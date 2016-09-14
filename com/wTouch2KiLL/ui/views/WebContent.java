package com.wTouch2KiLL.ui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.media.TransportMediator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.SettingsActivity;
import com.wTouch2KiLL.configuration.UrlBarMenuButton;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.TabsPositions;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarStates;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarStyles;
import com.wTouch2KiLL.controllers.ITabContentController;
import com.wTouch2KiLL.controllers.ITabsController;
import com.wTouch2KiLL.model.WidgetEntity.LoadingCurtainType;
import com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget;
import com.wTouch2KiLL.ui.navigationwidget.INavigationWidget;
import com.wTouch2KiLL.ui.navigationwidget.NavigationWidget;
import com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget;
import com.wTouch2KiLL.ui.views.BrowserWebView.OnScrollChangedCallback;
import java.util.Collection;
import mf.javax.xml.XMLConstants;

public class WebContent extends TabContent {
    private BrowserWebView _browser;
    private String _defaultUrl;
    private INavigationWidget _navigationWidget;
    private ProgressBar _progressBar;
    private ITabContentController _tabContentController;
    private ITabsController _tabsController;
    private int height;
    private Integer heightNW;
    private boolean hideTabBar;
    private boolean hideUrlBar;
    private String pageRefreshJsCode;
    private SharedPreferences settings;
    private int skip;

    /* renamed from: com.wTouch2KiLL.ui.views.WebContent.2 */
    class C09802 implements OnTouchListener {
        C09802() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            try {
                if (event.getAction() == 1) {
                    if (WebContent.this._tabsController.getLayoutParams().height > 0 && WebContent.this._tabsController.getLayoutParams().height < WebContent.this.height) {
                        if (WebContent.this._tabsController.getLayoutParams().height >= WebContent.this.height / 2) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, WebContent.this.height));
                        } else if (WebContent.this.hideTabBar) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, 0));
                        }
                    }
                    if (WebContent.this._navigationWidget != null && WebContent.this._navigationWidget.getLayoutParams() != null && WebContent.this._navigationWidget.getLayoutParams().height > 0 && WebContent.this._navigationWidget.getLayoutParams().height < WebContent.this.heightNW.intValue()) {
                        if (WebContent.this._navigationWidget.getLayoutParams().height >= WebContent.this.heightNW.intValue() / 2) {
                            WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, WebContent.this.heightNW.intValue()));
                        } else if (WebContent.this.hideUrlBar) {
                            WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, 0));
                        }
                    }
                }
                if ((event.getAction() == 1 || event.getAction() == 0) && !v.hasFocus()) {
                    v.requestFocus();
                }
            } catch (Exception e) {
                Log.e("onTouch", XMLConstants.NULL_NS_URI + e);
            }
            return false;
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.views.WebContent.1 */
    class C14811 implements OnScrollChangedCallback {
        C14811() {
        }

        public void onScroll(int l, int t, int oldl, int oldt) {
            WebContent.this.hideTabBar = WebContent.this.settings.getBoolean(SettingsActivity.KEY_HIDE_TAB_BAR, true);
            WebContent.this.hideUrlBar = WebContent.this.settings.getBoolean(SettingsActivity.KEY_HIDE_URL_BAR, true);
            if (!(WebContent.this.hideUrlBar || WebContent.this._navigationWidget == null)) {
                WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, WebContent.this.heightNW.intValue()));
            }
            if (!WebContent.this.hideTabBar) {
                WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, WebContent.this.height));
            }
            if (WebContent.this.skip == 0) {
                int d;
                int dNW;
                LayoutParams layoutParams;
                if ((WebContent.this._tabsController.getLayoutParams().height > 0 && t > oldt) || (WebContent.this._navigationWidget != null && WebContent.this._navigationWidget.getLayoutParams().height > 0 && t > oldt)) {
                    d = WebContent.this._tabsController.getLayoutParams().height - (t - oldt);
                    dNW = 0;
                    if (WebContent.this._navigationWidget != null) {
                        dNW = WebContent.this._navigationWidget.getLayoutParams().height - (t - oldt);
                    }
                    if (d <= 0) {
                        d = 0;
                    }
                    if (dNW <= 0) {
                        dNW = 0;
                    }
                    if (WebContent.this.isElementsOnTop() || WebContent.this.isElementsOnBottom()) {
                        if (WebContent.this.hideUrlBar) {
                            WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, dNW));
                        }
                        if ((WebContent.this._navigationWidget.getLayoutParams().height <= 0 || !WebContent.this.hideUrlBar) && WebContent.this.hideTabBar) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, d));
                        }
                    } else {
                        if (WebContent.this.hideTabBar) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, d));
                        }
                        if (WebContent.this._navigationWidget != null && WebContent.this.hideUrlBar) {
                            layoutParams = (LayoutParams) WebContent.this._navigationWidget.getLayoutParams();
                            layoutParams.height = dNW;
                            WebContent.this._navigationWidget.setLayoutParams(layoutParams);
                        }
                    }
                    WebContent.this.skip = 2;
                } else if ((WebContent.this._tabsController.getLayoutParams().height < WebContent.this.height && t < oldt) || (WebContent.this._navigationWidget != null && WebContent.this._navigationWidget.getLayoutParams().height < WebContent.this.heightNW.intValue() && t < oldt)) {
                    d = WebContent.this._tabsController.getLayoutParams().height + (oldt - t);
                    dNW = 0;
                    if (WebContent.this._navigationWidget != null) {
                        dNW = WebContent.this._navigationWidget.getLayoutParams().height + (oldt - t);
                    }
                    if (d >= WebContent.this.height) {
                        d = WebContent.this.height;
                    }
                    if (dNW >= WebContent.this.heightNW.intValue()) {
                        dNW = WebContent.this.heightNW.intValue();
                    }
                    if (WebContent.this.isElementsOnTop() || WebContent.this.isElementsOnBottom()) {
                        if (WebContent.this.hideUrlBar) {
                            WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, dNW));
                        }
                        if (WebContent.this._navigationWidget.getLayoutParams().height == WebContent.this.heightNW.intValue() && WebContent.this.hideTabBar) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, d));
                        }
                    } else {
                        if (WebContent.this.hideTabBar) {
                            WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, d));
                        }
                        if (WebContent.this._navigationWidget != null && WebContent.this.hideUrlBar) {
                            layoutParams = (LayoutParams) WebContent.this._navigationWidget.getLayoutParams();
                            layoutParams.height = dNW;
                            WebContent.this._navigationWidget.setLayoutParams(layoutParams);
                        }
                    }
                    WebContent.this.skip = 2;
                }
            } else if ((WebContent.this._tabsController.getLayoutParams().height >= WebContent.this.height || t > 5) && (WebContent.this._navigationWidget == null || WebContent.this._navigationWidget.getLayoutParams().height >= WebContent.this.heightNW.intValue() || t > 5)) {
                WebContent.this.skip = WebContent.this.skip - 1;
            } else {
                if (WebContent.this.hideTabBar) {
                    WebContent.this._tabsController.setLayoutParams(new LayoutParams(WebContent.this._tabsController.getLayoutParams().width, WebContent.this.height));
                }
                if (WebContent.this._navigationWidget != null && WebContent.this.hideUrlBar) {
                    WebContent.this._navigationWidget.setLayoutParams(new LayoutParams(WebContent.this._navigationWidget.getLayoutParams().width, WebContent.this.heightNW.intValue()));
                }
            }
        }
    }

    public WebContent(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._tabContentController = null;
        this._browser = null;
        this._progressBar = null;
        this._navigationWidget = null;
        this.pageRefreshJsCode = XMLConstants.NULL_NS_URI;
        this._defaultUrl = XMLConstants.NULL_NS_URI;
        this.heightNW = null;
        this.height = 0;
        this.skip = 0;
        this._tabsController = Factory.getInstance().getTabsController();
    }

    public WebContent(Context context) {
        super(context);
        this._tabContentController = null;
        this._browser = null;
        this._progressBar = null;
        this._navigationWidget = null;
        this.pageRefreshJsCode = XMLConstants.NULL_NS_URI;
        this._defaultUrl = XMLConstants.NULL_NS_URI;
        this.heightNW = null;
        this.height = 0;
        this.skip = 0;
        this._tabsController = Factory.getInstance().getTabsController();
    }

    public void init(ITabContentController tabContentController) {
        this._tabContentController = tabContentController;
        this._browser = (BrowserWebView) findViewById(C0866R.id.webView);
        this.settings = PreferenceManager.getDefaultSharedPreferences(Factory.getInstance().getMainNavigationActivity().getBaseContext());
        this.height = this._tabsController.getLayoutParams().height;
        this._browser.setOnScrollChangedCallback(new C14811());
        this._browser.setOnTouchListener(new C09802());
        this._browser.requestFocus(TransportMediator.KEYCODE_MEDIA_RECORD);
        this._browser.getContentHeight();
        this._progressBar = (ProgressBar) findViewById(C0866R.id.progressbar);
        WebWidgetConfiguration config = this._tabContentController.getMainNavigationActivity().getConfig();
        UrlBarStates urlBarState = config.getUrlOverlayState();
        if (urlBarState != UrlBarStates.DISABLED) {
            boolean z;
            String link = this._tabContentController.getWidgetInfo().getLink();
            Collection<UrlBarMenuButton> urlBarButtons = config.getUrlBarMenuButtons();
            if (config.getUrlBarStyle() == UrlBarStyles.TOP) {
                this._navigationWidget = new TopNavigationWidget(this, link, this._browser, urlBarButtons);
                ((NavigationWidget) this._navigationWidget).initHistory();
            } else {
                this._navigationWidget = new BottomNavigationWidget(this, link, this._browser, urlBarButtons);
                this._navigationWidget.attachAutocomplete();
            }
            INavigationWidget iNavigationWidget = this._navigationWidget;
            if (urlBarState == UrlBarStates.ENABLED_ON_EXTERNAL_URLS) {
                z = true;
            } else {
                z = false;
            }
            iNavigationWidget.setHideOnInternalUrls(z);
            Factory.getInstance().setNavigationWidget(this._navigationWidget);
            this.heightNW = Integer.valueOf(this._navigationWidget.getLayoutParams().height);
            return;
        }
        this.heightNW = Integer.valueOf(0);
        try {
            ((LayoutParams) this._browser.getLayoutParams()).setMargins(0, 0, 0, 0);
        } catch (ClassCastException c) {
            Log.e("WebContent", XMLConstants.NULL_NS_URI + c);
        }
    }

    private boolean isElementsOnTop() {
        return this._tabsController.getVisibilityTabs() && this._navigationWidget != null && (this._navigationWidget instanceof TopNavigationWidget) && Factory.getInstance().getMainNavigationActivity().getConfig().getTabsPosition() == TabsPositions.TOP;
    }

    private boolean isElementsOnBottom() {
        return this._tabsController.getVisibilityTabs() && this._navigationWidget != null && (this._navigationWidget instanceof BottomNavigationWidget) && Factory.getInstance().getMainNavigationActivity().getConfig().getTabsPosition() == TabsPositions.BOTTOM;
    }

    public void navigate(String url) {
        this._browser.loadUrl(url);
        this._defaultUrl = url;
        if (this._navigationWidget != null) {
            this._navigationWidget.setUrl(url);
        }
        this._progressBar.setProgress(0);
    }

    public void showNavigationBars() {
        this._tabsController.setLayoutParams(new LayoutParams(this._tabsController.getLayoutParams().width, this.height));
        if (this._navigationWidget != null) {
            this._navigationWidget.setLayoutParams(new LayoutParams(this._navigationWidget.getLayoutParams().width, this.heightNW.intValue()));
        }
    }

    public INavigationWidget getNavigationWidget() {
        return this._navigationWidget;
    }

    public WebView getBrowser() {
        return this._browser;
    }

    public ProgressBar getProgressBar() {
        return this._progressBar;
    }

    public void hideProgressBarPanel() {
        findViewById(C0866R.id.progressbarPanel).setVisibility(8);
    }

    public void showProgressBarPanel() {
        findViewById(C0866R.id.progressbarPanel).setVisibility(0);
    }

    public void setLoadingCurtainType(LoadingCurtainType type) {
        if (type == LoadingCurtainType.NONE) {
            findViewById(C0866R.id.loadingCurtainDefault).setVisibility(8);
        } else if (type == LoadingCurtainType.DEFAULT) {
            findViewById(C0866R.id.loadingCurtainDefault).setVisibility(0);
        }
    }

    public String getPageRefreshJsCode() {
        return this.pageRefreshJsCode;
    }

    public void setPageRefreshJsCode(String pageRefreshJsCode) {
        this.pageRefreshJsCode = pageRefreshJsCode;
    }
}
