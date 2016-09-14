package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C0297b;
import com.chartboost.sdk.C0315f;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C1203a;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

public final class bu extends C0320g {
    public String f4209k;
    protected int f4210l;
    private String f4211m;
    private String f4212n;
    private float f4213o;
    private float f4214p;
    private boolean f4215q;
    private long f4216r;
    private long f4217s;
    private C0405b f4218t;

    /* renamed from: com.chartboost.sdk.impl.bu.1 */
    class C04021 implements Runnable {
        final /* synthetic */ bu f1060a;

        C04021(bu buVar) {
            this.f1060a = buVar;
        }

        public void run() {
            String str = "javascript:Chartboost.EventHandler.handleNativeEvent(\"videoPlay\", \"\")";
            CBLogging.m379a("CBWebViewProtocol", "Calling native to javascript: " + str);
            this.f1060a.m4696q().f4204b.loadUrl(str);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bu.2 */
    class C04032 implements Runnable {
        final /* synthetic */ bu f1061a;

        C04032(bu buVar) {
            this.f1061a = buVar;
        }

        public void run() {
            String str = "javascript:Chartboost.EventHandler.handleNativeEvent(\"videoPause\", \"\")";
            CBLogging.m379a("CBWebViewProtocol", "Calling native to javascript: " + str);
            this.f1061a.m4696q().f4204b.loadUrl(str);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bu.a */
    private class C0404a extends WebViewClient {
        final /* synthetic */ bu f1062a;

        private C0404a(bu buVar) {
            this.f1062a = buVar;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            this.f1062a.f4217s = System.currentTimeMillis();
            CBLogging.m379a("CBWebViewProtocol", "Total web view load response time " + ((this.f1062a.f4217s - this.f1062a.f4216r) / 1000));
            C0315f a = C0315f.m744a();
            if (a != null) {
                a.m747a(this.f1062a.f);
            } else {
                this.f1062a.m4677d("View Controller instance is null");
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            this.f1062a.m4677d(description);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bu.b */
    public enum C0405b {
        NONE,
        IDLE,
        PLAYING,
        PAUSED
    }

    /* renamed from: com.chartboost.sdk.impl.bu.c */
    public class C1243c extends C0318a {
        public bt f4204b;
        public bs f4205c;
        public RelativeLayout f4206d;
        public RelativeLayout f4207e;
        final /* synthetic */ bu f4208f;

        public C1243c(bu buVar, Context context, String str) {
            this.f4208f = buVar;
            super(buVar, context);
            setFocusable(false);
            this.f4206d = new RelativeLayout(context);
            this.f4207e = new RelativeLayout(context);
            this.f4204b = new bt(context);
            this.f4204b.setWebViewClient(new C0404a(null));
            this.f4205c = new bs(this.f4206d, this.f4207e, null, this.f4204b, buVar);
            this.f4204b.setWebChromeClient(this.f4205c);
            if (VERSION.SDK_INT >= 19) {
                bt btVar = this.f4204b;
                bt.setWebContentsDebuggingEnabled(true);
            }
            this.f4204b.loadDataWithBaseURL(buVar.f4212n, str, "text/html", "utf-8", null);
            this.f4206d.addView(this.f4204b);
            this.f4204b.getSettings().setSupportZoom(false);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f4206d.setLayoutParams(layoutParams);
            this.f4204b.setLayoutParams(layoutParams);
            this.f4204b.setBackgroundColor(0);
            this.f4207e.setVisibility(8);
            this.f4207e.setLayoutParams(layoutParams);
            addView(this.f4206d);
            addView(this.f4207e);
            buVar.f4216r = System.currentTimeMillis();
        }

        protected void m4669a(int i, int i2) {
        }
    }

    public /* synthetic */ C0318a m4687e() {
        return m4696q();
    }

    public bu(C0291a c0291a) {
        super(c0291a);
        this.f4209k = "UNKNOWN";
        this.f4211m = null;
        this.f4212n = null;
        this.f4210l = 1;
        this.f4213o = 0.0f;
        this.f4214p = 0.0f;
        this.f4215q = false;
        this.f4216r = 0;
        this.f4217s = 0;
        this.f4218t = C0405b.NONE;
    }

    protected C0318a m4682b(Context context) {
        return new C1243c(this, context, this.f4211m);
    }

    public boolean m4681a(C0269a c0269a) {
        File a = C0278h.m489a();
        if (a == null) {
            CBLogging.m381b("CBWebViewProtocol", "External Storage path is unavailable or media not mounted");
            m772a(CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f4212n = "file://" + a.getAbsolutePath() + "/";
        CharSequence e = c0269a.m442e("ad_unit_id");
        if (TextUtils.isEmpty(e)) {
            CBLogging.m381b("CBWebViewProtocol", "Invalid adId being passed in th response");
            m772a(CBImpressionError.ERROR_DISPLAYING_VIEW);
            return false;
        }
        ConcurrentHashMap d = C0297b.m614d();
        if (d == null || d.isEmpty() || !d.containsKey(e)) {
            CBLogging.m381b("CBWebViewProtocol", "No html data found in memory");
            m772a(CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return false;
        }
        this.f4211m = (String) d.get(e);
        m780b();
        return true;
    }

    public void m4688h() {
        super.m786h();
    }

    public void m4680a(JSONObject jSONObject, String str) {
        C1203a.m4363a(this.f.m590u().m724e(), this.f.f600e, this.f.m589t(), jSONObject, str);
    }

    public void m4684b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Unknown Webview error";
        }
        C1203a.m4361a(this.f.m590u().m724e(), this.f.f600e, this.f.m589t(), str);
        CBLogging.m381b("CBWebViewProtocol", "Webview error occurred closing the webview" + str);
        m772a(CBImpressionError.ERROR_LOADING_WEB_VIEW);
        m4688h();
    }

    public void m4685c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Unknown Webview warning message";
        }
        C1203a.m4371b(this.f.m590u().m724e(), this.f.f600e, this.f.m589t(), str);
        CBLogging.m385d("CBWebViewProtocol", "Webview warning occurred closing the webview" + str);
    }

    private void m4677d(String str) {
        C0315f a = C0315f.m744a();
        if (a != null) {
            a.m749b();
        }
        m772a(CBImpressionError.ERROR_LOADING_WEB_VIEW);
        if (TextUtils.isEmpty(str)) {
            str = XMLConstants.NULL_NS_URI;
        }
        C1203a.m4361a(this.f.m590u().m724e(), this.f.f600e, this.f.m589t(), "OReceivedError called, error loading Web View" + str);
        CBLogging.m381b("CBWebViewProtocol", " OReceivedError called, error loading Web View" + str);
    }

    public boolean m4691l() {
        if (this.f4218t != C0405b.PLAYING) {
            C1243c q = m4696q();
            if (q != null) {
                q.f4205c.onHideCustomView();
            }
            m4688h();
        }
        return true;
    }

    public void m4692m() {
        super.m791m();
        if (this.f4218t == C0405b.PAUSED && m4696q() != null) {
            CBUtility.m400e().post(new C04021(this));
            C1203a.m4376d(this.f4209k, this.f.m589t());
        }
    }

    public void m4693n() {
        super.m792n();
        if (this.f4218t == C0405b.PLAYING && m4696q() != null) {
            CBUtility.m400e().post(new C04032(this));
            C1203a.m4379e(this.f4209k, this.f.m589t());
        }
    }

    public void m4694o() {
        if (this.f4210l <= 1) {
            this.f.m576g();
            this.f4210l++;
            C1203a.m4369b(this.f4209k, this.f.m589t());
        }
    }

    public void m4686d() {
        super.m782d();
    }

    public void m4695p() {
        C1203a.m4372c(this.f4209k, this.f.m589t());
    }

    public void m4679a(C0405b c0405b) {
        this.f4218t = c0405b;
    }

    public C1243c m4696q() {
        return (C1243c) super.m783e();
    }

    public void m4678a(float f) {
        this.f4214p = f;
    }

    public void m4683b(float f) {
        this.f4213o = f;
    }

    public float m4689j() {
        return this.f4213o;
    }

    public float m4690k() {
        return this.f4214p;
    }

    public void m4697r() {
        if (!this.f4215q) {
            C1203a.m4376d(XMLConstants.NULL_NS_URI, this.f.m589t());
            this.f.m591v();
            this.f4215q = true;
        }
    }
}
