package com.wTouch2KiLL.ui.navigationwidget;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.configuration.UrlBarMenuButton;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.ApplicationThemes;
import com.wTouch2KiLL.suggestions.RemoteSuggestionItem;
import com.wTouch2KiLL.suggestions.SuggestionsClient;
import java.util.ArrayList;
import java.util.Collection;
import mf.javax.xml.XMLConstants;

public class BottomNavigationWidget extends NavigationWidget {

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget.1 */
    class C09541 implements OnClickListener {
        C09541() {
        }

        public void onClick(View v) {
            BottomNavigationWidget.this.urlTextBox.setText(XMLConstants.NULL_NS_URI);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget.2 */
    class C09552 implements OnClickListener {
        C09552() {
        }

        public void onClick(View v) {
            BottomNavigationWidget.this.focusChangeListener.onFocusChange(v, true);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget.3 */
    class C09563 implements Runnable {
        final /* synthetic */ MainNavigationActivity val$mainActivity;

        C09563(MainNavigationActivity mainNavigationActivity) {
            this.val$mainActivity = mainNavigationActivity;
        }

        public void run() {
            this.val$mainActivity.setSupportActionBar(BottomNavigationWidget.this.urlBar);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget.4 */
    class C09574 implements AnimationListener {
        final /* synthetic */ boolean val$toShowUrlBar;

        C09574(boolean z) {
            this.val$toShowUrlBar = z;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.val$toShowUrlBar) {
                BottomNavigationWidget.this.show();
            } else {
                BottomNavigationWidget.this.hide();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.BottomNavigationWidget.5 */
    class C09585 extends Animation {
        final /* synthetic */ boolean val$toShowUrlBar;

        C09585(boolean z) {
            this.val$toShowUrlBar = z;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            int newMargin;
            if (this.val$toShowUrlBar) {
                newMargin = (int) (((float) BottomNavigationWidget.this._defaultTopBrowserMargin) * interpolatedTime);
            } else {
                newMargin = (int) (((float) BottomNavigationWidget.this._defaultTopBrowserMargin) - (((float) BottomNavigationWidget.this._defaultTopBrowserMargin) * interpolatedTime));
            }
            LayoutParams params = (LayoutParams) BottomNavigationWidget.this._browser.getLayoutParams();
            params.setMargins(0, newMargin, 0, 0);
            BottomNavigationWidget.this._browser.setLayoutParams(params);
        }
    }

    public BottomNavigationWidget(ViewGroup parent, String defaultUrl, View browser, Collection<UrlBarMenuButton> urlBarMenuButtons) {
        super(parent, defaultUrl, browser, urlBarMenuButtons);
        this._parent = parent;
        this._progressBarContainer = (RelativeLayout) parent.findViewById(C0866R.id.progressbarPanel);
        this._defaultUrl = defaultUrl;
        this._browser = browser;
        createWidgetLayout();
        this.suggestionsClient = new SuggestionsClient(Factory.getInstance().getMainNavigationActivity());
        this.suggestionsClient.setListener(this);
        this.refreshImage = C0866R.drawable.ic_refresh_white_24dp;
        this.stopImage = C0866R.drawable.ic_close_white_24dp;
        this.urlBarButton = C0866R.layout.url_bar_top_menu_button;
        this.urlBarCheckBox = C0866R.layout.url_bar_top_menu_checkbox;
        this.urlBarIcon = C0866R.layout.url_bar_top_icon;
        this.frameNWBottom = (FrameLayout) this._parent.findViewById(C0866R.id.frameNWbottom);
        this.suggestionsView = (ViewGroup) this._parent.findViewById(C0866R.id.suggestions);
        this.suggestionsViewScroll = (ViewGroup) this._parent.findViewById(C0866R.id.suggestionsScroll);
        this.overlay = (ViewGroup) this._parent.findViewById(C0866R.id.menuOverlay);
        this.overlayScroll = (ViewGroup) this._parent.findViewById(C0866R.id.menuOverlayScroll);
        this.urlTextBox = (AutoCompleteTextView) this._parent.findViewById(C0866R.id.urlTextbox);
        this.searchBackground = (LinearLayout) this._parent.findViewById(C0866R.id.search_background);
        this.stopRefreshButton = (ImageButton) this._parent.findViewById(C0866R.id.stopRefreshButton);
        this.searchBtn = (ImageView) this.searchBackground.findViewById(C0866R.id.search_icon);
        this.clearTextButton = (ImageButton) this._parent.findViewById(C0866R.id.clearText);
        this.clearTextButton.setOnClickListener(new C09541());
        this.urlTextBox.addTextChangedListener(this.urlBarTextChangeListener);
        this.urlTextBox.setOnFocusChangeListener(this.focusChangeListener);
        this.urlTextBox.setOnClickListener(new C09552());
        initEventHandlers();
    }

    public void createWidgetLayout() {
        Context context = this._parent.getContext();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0866R.layout.navigation_bar, this._parent, true);
        this.urlBar = (Toolbar) this._parent.findViewById(C0866R.id.bottomNavigationRow);
        this.urlBar.bringToFront();
        if (!Factory.getInstance().getMainNavigationActivity().getConfig().getApplicationTheme().equals(ApplicationThemes.ACTION_BAR)) {
            this.urlBar.inflateMenu(C0866R.menu.webapp_menu);
            MainNavigationActivity mainActivity = Factory.getInstance().getMainNavigationActivity();
            mainActivity.runOnUiThread(new C09563(mainActivity));
        }
        this._defaultTopBrowserMargin = 0;
        this._defaultBottomBrowserMargin = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        show();
    }

    public void hide() {
        if (this._parent.findViewById(C0866R.id.bottomNavigationRow) != null) {
            this._parent.findViewById(C0866R.id.bottomNavigationRow).setVisibility(8);
            ((LayoutParams) this._browser.getLayoutParams()).setMargins(0, 0, 0, 0);
            ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(0, 0, 0, 0);
            this._visible = false;
        }
    }

    public void show() {
        if (this._parent.findViewById(C0866R.id.bottomNavigationRow) != null) {
            this._parent.findViewById(C0866R.id.bottomNavigationRow).setVisibility(0);
            ((LayoutParams) this._browser.getLayoutParams()).setMargins(this._defaultLeftBrowserMargin, this._defaultTopBrowserMargin, this._defaultRightBrowserMargin, this._defaultBottomBrowserMargin);
            ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(this._defaultLeftBrowserMargin, this._defaultTopBrowserMargin, this._defaultRightBrowserMargin, this._defaultBottomBrowserMargin);
            this._visible = true;
        }
    }

    public void changeVisibilityAnimated(boolean toShowUrlBar) {
        if (this._parent.findViewById(C0866R.id.bottomNavigationRow) == null) {
            return;
        }
        if (!this._visible || !toShowUrlBar) {
            if (this._visible || toShowUrlBar) {
                Animation animation = AnimationUtils.loadAnimation(this._parent.getContext(), toShowUrlBar ? C0866R.anim.slide_bottom_down : C0866R.anim.slide_bottom_up);
                animation.setAnimationListener(new C09574(toShowUrlBar));
                animation.setDuration(300);
                this._parent.findViewById(C0866R.id.bottomNavigationRow).startAnimation(animation);
                Animation a = new C09585(toShowUrlBar);
                a.setDuration(300);
                this._parent.startAnimation(a);
            }
        }
    }

    public void hideAnimated() {
        changeVisibilityAnimated(false);
    }

    public void showAnimated() {
        changeVisibilityAnimated(true);
    }

    public void requestSuggestions() {
    }

    public void hideSuggestionsView() {
    }

    public void onReceiveSuggestions(ArrayList<RemoteSuggestionItem> arrayList, String initialSearch) {
    }

    public void setLayoutParams(LayoutParams params1) {
        params1.addRule(12);
        this.frameNWBottom.setLayoutParams(params1);
        ((LayoutParams) this._browser.getLayoutParams()).setMargins(0, 0, 0, params1.height);
        ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(0, 0, 0, params1.height);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.frameNWBottom.getLayoutParams();
    }

    public Toolbar getUrlBar() {
        return this.urlBar;
    }
}
