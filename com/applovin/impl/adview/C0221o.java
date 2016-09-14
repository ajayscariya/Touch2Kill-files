package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.cb;
import com.applovin.impl.sdk.di;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import mf.javax.xml.XMLConstants;

/* renamed from: com.applovin.impl.adview.o */
class C0221o extends WebView {
    private final AppLovinLogger f73a;
    private AppLovinAd f74b;
    private boolean f75c;

    C0221o(C0224r c0224r, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f74b = null;
        this.f75c = false;
        this.f73a = appLovinSdk.getLogger();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(c0224r);
        setWebChromeClient(new C0220n(appLovinSdk));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        setOnTouchListener(new C0222p(this));
        setOnLongClickListener(new C0223q(this));
    }

    AppLovinAd m20a() {
        return this.f74b;
    }

    public void m21a(AppLovinAd appLovinAd, String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (this.f75c) {
            this.f73a.userError("AdWebView", "Ad can not be loaded in a destroyed web view");
            return;
        }
        this.f74b = appLovinAd;
        if (appLovinSdkImpl != null) {
            try {
                if (new cb(appLovinSdkImpl).m188M()) {
                    loadUrl("about:blank");
                }
            } catch (Exception e) {
                this.f73a.m307e("AdWebView", "Unable to render AppLovinAd with placement = \"" + str + "\"");
                return;
            }
        }
        loadDataWithBaseURL("/", di.m4285a(str, ((AppLovinAdImpl) appLovinAd).getHtmlSource()), "text/html", null, XMLConstants.NULL_NS_URI);
        this.f73a.m306d("AdWebView", "AppLovinAd rendered");
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f75c = true;
        try {
            super.destroy();
            this.f73a.m306d("AdWebView", "Web view destroyed");
        } catch (Throwable th) {
            if (this.f73a != null) {
                this.f73a.m308e("AdWebView", "destroy() threw exception", th);
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Throwable e) {
            this.f73a.m308e("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Throwable e) {
            this.f73a.m308e("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Throwable e) {
            this.f73a.m308e("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Throwable e) {
            this.f73a.m308e("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }

    public void scrollTo(int i, int i2) {
    }
}
