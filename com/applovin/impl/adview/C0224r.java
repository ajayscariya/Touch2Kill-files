package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* renamed from: com.applovin.impl.adview.r */
class C0224r extends WebViewClient {
    private final AppLovinLogger f78a;
    private final AdViewControllerImpl f79b;

    public C0224r(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        this.f78a = appLovinSdk.getLogger();
        this.f79b = adViewControllerImpl;
    }

    private void m22a(C0221o c0221o, Uri uri) {
        AppLovinAd a = c0221o.m20a();
        ViewParent parent = c0221o.getParent();
        if (!(parent instanceof AppLovinAdView) || a == null) {
            this.f78a.m307e("AdWebViewClient", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        } else {
            this.f79b.m4081a(a, (AppLovinAdView) parent, this.f79b, uri);
        }
    }

    void m23a(WebView webView, String str) {
        this.f78a.m306d("AdWebViewClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0221o)) {
            Uri parse = Uri.parse(str);
            C0221o c0221o = (C0221o) webView;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            if (!AppLovinSdk.URI_SCHEME.equals(scheme) || !AppLovinSdk.URI_HOST.equals(host)) {
                m22a(c0221o, parse);
            } else if (AppLovinAdService.URI_NEXT_AD.equals(path)) {
                m24a(c0221o);
            } else if (AppLovinAdService.URI_CLOSE_AD.equals(path)) {
                m25b(c0221o);
            } else if (!AppLovinAdServiceImpl.URI_NO_OP.equals(path)) {
                if (AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(path)) {
                    m22a(c0221o, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                } else if (path == null || !path.startsWith("/launch/")) {
                    this.f78a.m310w("AdWebViewClient", "Unknown URL: " + str);
                    this.f78a.m310w("AdWebViewClient", "Path: " + path);
                } else {
                    List pathSegments = parse.getPathSegments();
                    if (pathSegments != null && pathSegments.size() > 1) {
                        String str2 = (String) pathSegments.get(pathSegments.size() - 1);
                        try {
                            Context context = webView.getContext();
                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str2));
                            m22a(c0221o, null);
                        } catch (Throwable e) {
                            this.f78a.m308e("AdWebViewClient", "Threw Exception Trying to Launch App for Package: " + str2, e);
                        }
                    }
                }
            }
        }
    }

    void m24a(C0221o c0221o) {
        ViewParent parent = c0221o.getParent();
        if (parent instanceof AppLovinAdView) {
            ((AppLovinAdView) parent).loadNextAd();
        }
    }

    void m25b(C0221o c0221o) {
        this.f79b.m4078a();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f79b.onAdHtmlLoaded(webView);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m23a(webView, str);
        return true;
    }
}
