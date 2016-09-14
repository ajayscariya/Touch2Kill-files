package com.chartboost.sdk.impl;

import com.android.volley.toolbox.HttpClientStack.HttpPatch;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import mf.org.apache.xerces.impl.dtd.DTDGrammar;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class aa implements C0433z {
    private final C0321a f4027a;
    private final SSLSocketFactory f4028b;

    /* renamed from: com.chartboost.sdk.impl.aa.a */
    public interface C0321a {
        String m793a(String str);
    }

    public aa() {
        this(null);
    }

    public aa(C0321a c0321a) {
        this(c0321a, null);
    }

    public aa(C0321a c0321a, SSLSocketFactory sSLSocketFactory) {
        this.f4027a = c0321a;
        this.f4028b = sSLSocketFactory;
    }

    public HttpResponse m4428a(C0415l<?> c0415l, Map<String, String> map) throws IOException, C1214a {
        String a;
        String d = c0415l.m1098d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(c0415l.m1103i());
        hashMap.putAll(map);
        if (this.f4027a != null) {
            a = this.f4027a.m793a(d);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + d);
            }
        }
        a = d;
        HttpURLConnection a2 = m4423a(new URL(a), (C0415l) c0415l);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        m4425a(a2, (C0415l) c0415l);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(m4424a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity m4424a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    protected HttpURLConnection m4427a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection m4423a(URL url, C0415l<?> c0415l) throws IOException {
        HttpURLConnection a = m4427a(url);
        int t = c0415l.m1114t();
        a.setConnectTimeout(t);
        a.setReadTimeout(t);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f4028b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f4028b);
        }
        return a;
    }

    static void m4425a(HttpURLConnection httpURLConnection, C0415l<?> c0415l) throws IOException, C1214a {
        switch (c0415l.m1083a()) {
            case DTDGrammar.TOP_LEVEL_SCOPE /*-1*/:
                byte[] m = c0415l.m1107m();
                if (m != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", c0415l.m1106l());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(m);
                    dataOutputStream.close();
                }
            case DurationDV.DURATION_TYPE /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                httpURLConnection.setRequestMethod("POST");
                m4426b(httpURLConnection, c0415l);
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                m4426b(httpURLConnection, c0415l);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                httpURLConnection.setRequestMethod("HEAD");
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                httpURLConnection.setRequestMethod("OPTIONS");
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                httpURLConnection.setRequestMethod("TRACE");
            case ConnectionResult.NETWORK_ERROR /*7*/:
                httpURLConnection.setRequestMethod(HttpPatch.METHOD_NAME);
                m4426b(httpURLConnection, c0415l);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m4426b(HttpURLConnection httpURLConnection, C0415l<?> c0415l) throws IOException, C1214a {
        byte[] q = c0415l.m1111q();
        if (q != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", c0415l.m1110p());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(q);
            dataOutputStream.close();
        }
    }
}
