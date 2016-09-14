package com.wTouch2KiLL.ui.navigationwidget;

import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.util.HashMap;

public interface INavigationWidget {
    void attachAutocomplete();

    HashMap<String, NavigationWidgetCustomIcon> getCustomIcons();

    LayoutParams getLayoutParams();

    ViewGroup getNawigationWidgetView();

    Toolbar getUrlBar();

    boolean isVisible();

    void onPageFinished(WebView webView, String str);

    void onPageStart(WebView webView, String str);

    void setAdsKeyboard(boolean z);

    void setHideOnInternalUrls(boolean z);

    void setLayoutParams(RelativeLayout.LayoutParams layoutParams);

    void setUrl(String str);
}
