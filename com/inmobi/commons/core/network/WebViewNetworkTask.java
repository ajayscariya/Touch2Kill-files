package com.inmobi.commons.core.network;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.p000a.SdkContext;

/* renamed from: com.inmobi.commons.core.network.e */
public class WebViewNetworkTask {
    private NetworkRequest f1622a;
    private WebViewClient f1623b;
    private WebView f1624c;

    public WebViewNetworkTask(NetworkRequest networkRequest, WebViewClient webViewClient) {
        this.f1623b = webViewClient;
        this.f1622a = networkRequest;
    }

    public void m1742a() {
        m1741b();
        String h = this.f1622a.m1713h();
        if (!(this.f1622a.m1715j() == null || this.f1622a.m1715j().trim().length() == 0)) {
            h = h + "?" + this.f1622a.m1715j();
        }
        this.f1624c.loadUrl(h);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m1741b() {
        this.f1624c = new WebView(SdkContext.m1562b());
        this.f1624c.setWebViewClient(this.f1623b);
        this.f1624c.getSettings().setJavaScriptEnabled(true);
        this.f1624c.getSettings().setCacheMode(2);
    }
}
