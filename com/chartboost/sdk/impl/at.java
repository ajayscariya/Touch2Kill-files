package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import mf.org.apache.xml.serialize.Method;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

public class at extends ap {
    private WebView f4096a;
    private OnClickListener f4097b;

    /* renamed from: com.chartboost.sdk.impl.at.1 */
    class C03391 extends WebViewClient {
        final /* synthetic */ at f823a;

        C03391(at atVar) {
            this.f823a = atVar;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url == null) {
                return false;
            }
            if (url.contains("chartboost") && url.contains("click") && this.f823a.f4097b != null) {
                this.f823a.f4097b.onClick(this.f823a);
            }
            return true;
        }
    }

    public at(aw awVar, Context context) {
        super(context);
        this.f4097b = null;
        this.f4096a = new WebView(context);
        addView(this.f4096a, new LayoutParams(-1, -1));
        this.f4096a.setBackgroundColor(0);
        this.f4096a.setWebViewClient(new C03391(this));
    }

    public void setOnClickListener(OnClickListener clickListener) {
        super.setOnClickListener(clickListener);
        this.f4097b = clickListener;
    }

    public void m4518a(C0269a c0269a, int i) {
        String e = c0269a.m442e(Method.HTML);
        if (e != null) {
            try {
                this.f4096a.loadDataWithBaseURL("file:///android_res/", e, "text/html", Defaults.Encoding, null);
            } catch (Throwable e2) {
                CBLogging.m382b("AppCellWebView", "Exception raised loading data into webview", e2);
            }
        }
    }

    public int m4517a() {
        return CBUtility.m390a(100, getContext());
    }
}
