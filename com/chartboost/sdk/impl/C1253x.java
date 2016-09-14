package com.chartboost.sdk.impl;

import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import mf.org.apache.xerces.impl.dtd.DTDGrammar;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.chartboost.sdk.impl.x */
public class C1253x implements C0433z {
    protected final HttpClient f4235a;

    /* renamed from: com.chartboost.sdk.impl.x.a */
    public static final class C0431a extends HttpEntityEnclosingRequestBase {
        public C0431a(String str) {
            setURI(URI.create(str));
        }
    }

    public C1253x(HttpClient httpClient) {
        this.f4235a = httpClient;
    }

    private static void m4732a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public HttpResponse m4734a(C0415l<?> c0415l, Map<String, String> map) throws IOException, C1214a {
        HttpUriRequest b = C1253x.m4733b(c0415l, map);
        C1253x.m4732a(b, (Map) map);
        C1253x.m4732a(b, c0415l.m1103i());
        m4735a(b);
        HttpParams params = b.getParams();
        int t = c0415l.m1114t();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, t);
        return this.f4235a.execute(b);
    }

    static HttpUriRequest m4733b(C0415l<?> c0415l, Map<String, String> map) throws C1214a {
        HttpEntityEnclosingRequestBase httpPost;
        switch (c0415l.m1083a()) {
            case DTDGrammar.TOP_LEVEL_SCOPE /*-1*/:
                byte[] m = c0415l.m1107m();
                if (m == null) {
                    return new HttpGet(c0415l.m1098d());
                }
                HttpUriRequest httpPost2 = new HttpPost(c0415l.m1098d());
                httpPost2.addHeader("Content-Type", c0415l.m1106l());
                httpPost2.setEntity(new ByteArrayEntity(m));
                return httpPost2;
            case DurationDV.DURATION_TYPE /*0*/:
                return new HttpGet(c0415l.m1098d());
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                httpPost = new HttpPost(c0415l.m1098d());
                httpPost.addHeader("Content-Type", c0415l.m1110p());
                C1253x.m4731a(httpPost, (C0415l) c0415l);
                return httpPost;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                httpPost = new HttpPut(c0415l.m1098d());
                httpPost.addHeader("Content-Type", c0415l.m1110p());
                C1253x.m4731a(httpPost, (C0415l) c0415l);
                return httpPost;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return new HttpDelete(c0415l.m1098d());
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return new HttpHead(c0415l.m1098d());
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                return new HttpOptions(c0415l.m1098d());
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                return new HttpTrace(c0415l.m1098d());
            case ConnectionResult.NETWORK_ERROR /*7*/:
                httpPost = new C0431a(c0415l.m1098d());
                httpPost.addHeader("Content-Type", c0415l.m1110p());
                C1253x.m4731a(httpPost, (C0415l) c0415l);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void m4731a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, C0415l<?> c0415l) throws C1214a {
        byte[] q = c0415l.m1111q();
        if (q != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(q));
        }
    }

    protected void m4735a(HttpUriRequest httpUriRequest) throws IOException {
    }
}
