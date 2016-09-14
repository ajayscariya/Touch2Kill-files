package com.immersion.hapticmediasdk.controllers;

import com.immersion.hapticmediasdk.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ImmersionHttpClient {
    private static final String f1320a = "ImmersionHttpClient";
    public static int f1321b04460446044604460446 = 0;
    public static int f1322b0446044604460446 = 1;
    public static int f1323b0446044604460446 = 2;
    public static int f1324b044604460446 = 3;
    private DefaultHttpClient f1325b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ImmersionHttpClient() {
        /*
        r2 = this;
        r2.<init>();
        r0 = m1372b044604460446();
        r1 = f1322b0446044604460446;
        r0 = r0 + r1;
        r1 = m1372b044604460446();
        r0 = r0 * r1;
        r1 = f1323b0446044604460446;
        r0 = r0 % r1;
        r1 = f1321b04460446044604460446;
        if (r0 == r1) goto L_0x001c;
    L_0x0016:
        r0 = m1372b044604460446();
        f1321b04460446044604460446 = r0;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        r1 = 1;
        switch(r1) {
            case 0: goto L_0x001d;
            case 1: goto L_0x0026;
            default: goto L_0x0021;
        };
    L_0x0021:
        r1 = 0;
        switch(r1) {
            case 0: goto L_0x0026;
            case 1: goto L_0x001d;
            default: goto L_0x0025;
        };
    L_0x0025:
        goto L_0x0021;
    L_0x0026:
        r2.f1325b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.ImmersionHttpClient.<init>():void");
    }

    private HttpResponse m1369a(HttpUriRequest httpUriRequest, Map map, int i) throws Exception {
        URI uri = httpUriRequest.getURI();
        String trim = uri.getHost() != null ? uri.getHost().trim() : XMLConstants.NULL_NS_URI;
        if (trim.length() > 0) {
            httpUriRequest.setHeader("Host", trim);
            if (((f1324b044604460446 + f1322b0446044604460446) * f1324b044604460446) % f1323b0446044604460446 != f1321b04460446044604460446) {
                f1324b044604460446 = 43;
                f1321b04460446044604460446 = 98;
            }
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                httpUriRequest.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Header[] allHeaders = httpUriRequest.getAllHeaders();
        Log.m1417d(f1320a, "request URI [" + httpUriRequest.getURI() + "]");
        for (Object obj : allHeaders) {
            Log.m1417d(f1320a, "request header [" + obj.toString() + "]");
        }
        HttpConnectionParams.setSoTimeout(this.f1325b.getParams(), i);
        HttpResponse execute = this.f1325b.execute(httpUriRequest);
        if (execute != null) {
            return execute;
        }
        throw new RuntimeException("Null response returned.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1370a() {
        /*
        r6 = this;
        r2 = 0;
        r0 = r6.f1325b;
        if (r0 != 0) goto L_0x005f;
    L_0x0005:
        r0 = f1324b044604460446;
        r1 = f1322b0446044604460446;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f1323b0446044604460446;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = 66;
        f1324b044604460446 = r0;
        r0 = 39;
        f1321b04460446044604460446 = r0;
    L_0x0019:
        r0 = new org.apache.http.params.BasicHttpParams;
        r0.<init>();
    L_0x001e:
        switch(r2) {
            case 0: goto L_0x0025;
            case 1: goto L_0x001e;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r2) {
            case 0: goto L_0x0025;
            case 1: goto L_0x001e;
            default: goto L_0x0024;
        };
    L_0x0024:
        goto L_0x0021;
    L_0x0025:
        r1 = 5;
        org.apache.http.conn.params.ConnManagerParams.setMaxTotalConnections(r0, r1);
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r1);
        r1 = new org.apache.http.conn.scheme.SchemeRegistry;
        r1.<init>();
        r2 = new org.apache.http.conn.scheme.Scheme;
        r3 = "http";
        r4 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();
        r5 = 80;
        r2.<init>(r3, r4, r5);
        r1.register(r2);
        r2 = new org.apache.http.conn.scheme.Scheme;
        r3 = "https";
        r4 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
        r5 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r2.<init>(r3, r4, r5);
        r1.register(r2);
        r2 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
        r2.<init>(r0, r1);
        r1 = new org.apache.http.impl.client.DefaultHttpClient;
        r1.<init>(r2, r0);
        r6.f1325b = r1;
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.ImmersionHttpClient.a():void");
    }

    public static int m1371b0446044604460446() {
        return 1;
    }

    public static int m1372b044604460446() {
        return 26;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.immersion.hapticmediasdk.controllers.ImmersionHttpClient getHttpClient() {
        /*
        r0 = new com.immersion.hapticmediasdk.controllers.ImmersionHttpClient;
        r0.<init>();
        r0.m1370a();
    L_0x0008:
        r1 = 0;
        switch(r1) {
            case 0: goto L_0x0011;
            case 1: goto L_0x0008;
            default: goto L_0x000c;
        };
    L_0x000c:
        r1 = 1;
        switch(r1) {
            case 0: goto L_0x0008;
            case 1: goto L_0x0011;
            default: goto L_0x0010;
        };
    L_0x0010:
        goto L_0x000c;
    L_0x0011:
        r1 = m1372b044604460446();
        r2 = f1322b0446044604460446;
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f1323b0446044604460446;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x0023;
            default: goto L_0x001f;
        };
    L_0x001f:
        r1 = 31;
        f1322b0446044604460446 = r1;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.ImmersionHttpClient.getHttpClient():com.immersion.hapticmediasdk.controllers.ImmersionHttpClient");
    }

    public HttpResponse executeDelete(String str, Map map, int i) throws Exception {
        HttpUriRequest httpDelete = new HttpDelete(str);
        if (((f1324b044604460446 + f1322b0446044604460446) * f1324b044604460446) % f1323b0446044604460446 != f1321b04460446044604460446) {
            f1324b044604460446 = 82;
            f1321b04460446044604460446 = m1372b044604460446();
        }
        return m1369a(httpDelete, map, i);
    }

    public HttpResponse executeGet(String str, Map map, int i) throws Exception {
        int i2 = f1324b044604460446;
        switch ((i2 * (m1371b0446044604460446() + i2)) % f1323b0446044604460446) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1324b044604460446 = m1372b044604460446();
                f1321b04460446044604460446 = m1372b044604460446();
                break;
        }
        try {
            try {
                return m1369a(new HttpGet(str), map, i);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public HttpResponse executePost(String str, Map map, int i) throws Exception {
        return m1369a(new HttpPost(str), map, i);
    }

    public HttpResponse executePostWithBody(String str, String str2, Map map, int i) throws Exception {
        try {
            HttpUriRequest httpPost = new HttpPost(str);
            try {
                HttpEntity stringEntity = new StringEntity(str2, Defaults.Encoding);
                int i2 = f1324b044604460446;
                switch ((i2 * (f1322b0446044604460446 + i2)) % f1323b0446044604460446) {
                    case DurationDV.DURATION_TYPE /*0*/:
                        break;
                    default:
                        f1324b044604460446 = m1372b044604460446();
                        f1321b04460446044604460446 = 81;
                        break;
                }
                httpPost.setEntity(stringEntity);
                return m1369a(httpPost, map, i);
            } catch (UnsupportedEncodingException e) {
                throw e;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e22) {
            throw e22;
        }
    }

    public HttpParams getParams() {
        int i = f1324b044604460446;
        switch ((i * (f1322b0446044604460446 + i)) % f1323b0446044604460446) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1324b044604460446 = 18;
                f1321b04460446044604460446 = m1372b044604460446();
                break;
        }
        try {
            try {
                return this.f1325b.getParams();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
