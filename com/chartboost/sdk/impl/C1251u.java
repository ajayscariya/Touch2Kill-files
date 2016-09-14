package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.C0350b.C0349a;
import com.google.android.gms.common.api.CommonStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mf.org.apache.xerces.impl.io.UTF16Reader;
import mf.org.w3c.dom.traversal.NodeFilter;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.chartboost.sdk.impl.u */
public class C1251u implements C0410f {
    protected static final boolean f4226a;
    private static int f4227d;
    private static int f4228e;
    protected final C0433z f4229b;
    protected final C0428v f4230c;

    static {
        f4226a = C0426t.f1149b;
        f4227d = CommonStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        f4228e = UTF16Reader.DEFAULT_BUFFER_SIZE;
    }

    public C1251u(C0433z c0433z) {
        this(c0433z, new C0428v(f4228e));
    }

    public C1251u(C0433z c0433z, C0428v c0428v) {
        this.f4229b = c0433z;
        this.f4230c = c0428v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.chartboost.sdk.impl.C0412i m4711a(com.chartboost.sdk.impl.C0415l<?> r13) throws com.chartboost.sdk.impl.C0423s {
        /*
        r12 = this;
        r10 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r2 = 0;
        r5 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r3 = r13.m1100f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r12.m4709a(r0, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r3 = r12.f4229b;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r8 = r3.m1156a(r13, r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ad }
        r6 = r8.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r9 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r0 = r8.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r7 = com.chartboost.sdk.impl.C1251u.m4706a(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00fc }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r9 != r0) goto L_0x0048;
    L_0x0031:
        r0 = new com.chartboost.sdk.impl.i;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r1 = r13.m1100f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        if (r1 != 0) goto L_0x0041;
    L_0x003b:
        r1 = 0;
    L_0x003c:
        r3 = 1;
        r0.<init>(r2, r1, r7, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x0040:
        return r0;
    L_0x0041:
        r1 = r13.m1100f();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r1 = r1.f891a;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x003c;
    L_0x0048:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        if (r0 == 0) goto L_0x007b;
    L_0x004e:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r5 = r12.m4710a(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x0056:
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r2 = r0 - r10;
        r1 = r12;
        r4 = r13;
        r1.m4707a(r2, r4, r5, r6);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r0) goto L_0x0069;
    L_0x0065:
        r0 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r9 <= r0) goto L_0x007f;
    L_0x0069:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
    L_0x006f:
        r0 = move-exception;
        r0 = "socket";
        r1 = new com.chartboost.sdk.impl.r;
        r1.<init>();
        com.chartboost.sdk.impl.C1251u.m4708a(r0, r13, r1);
        goto L_0x0004;
    L_0x007b:
        r0 = 0;
        r5 = new byte[r0];	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x0056;
    L_0x007f:
        r0 = new com.chartboost.sdk.impl.i;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        r1 = 0;
        r0.<init>(r9, r5, r7, r1);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00ff }
        goto L_0x0040;
    L_0x0086:
        r0 = move-exception;
        r0 = "connection";
        r1 = new com.chartboost.sdk.impl.r;
        r1.<init>();
        com.chartboost.sdk.impl.C1251u.m4708a(r0, r13, r1);
        goto L_0x0004;
    L_0x0093:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Bad URL ";
        r2.<init>(r3);
        r3 = r13.m1098d();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00ad:
        r0 = move-exception;
    L_0x00ae:
        if (r2 == 0) goto L_0x00ea;
    L_0x00b0:
        r0 = r2.getStatusLine();
        r0 = r0.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r6 = java.lang.Integer.valueOf(r0);
        r3[r4] = r6;
        r4 = 1;
        r6 = r13.m1098d();
        r3[r4] = r6;
        com.chartboost.sdk.impl.C0426t.m1144c(r2, r3);
        r2 = new com.chartboost.sdk.impl.i;
        r3 = 0;
        r2.<init>(r0, r5, r1, r3);
        if (r5 == 0) goto L_0x00f6;
    L_0x00d6:
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x00de;
    L_0x00da:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x00f0;
    L_0x00de:
        r0 = "auth";
        r1 = new com.chartboost.sdk.impl.a;
        r1.<init>(r2);
        com.chartboost.sdk.impl.C1251u.m4708a(r0, r13, r1);
        goto L_0x0004;
    L_0x00ea:
        r1 = new com.chartboost.sdk.impl.j;
        r1.<init>(r0);
        throw r1;
    L_0x00f0:
        r0 = new com.chartboost.sdk.impl.q;
        r0.<init>(r2);
        throw r0;
    L_0x00f6:
        r0 = new com.chartboost.sdk.impl.h;
        r0.<init>(r2);
        throw r0;
    L_0x00fc:
        r0 = move-exception;
        r2 = r8;
        goto L_0x00ae;
    L_0x00ff:
        r0 = move-exception;
        r1 = r7;
        r2 = r8;
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.u.a(com.chartboost.sdk.impl.l):com.chartboost.sdk.impl.i");
    }

    private void m4707a(long j, C0415l<?> c0415l, byte[] bArr, StatusLine statusLine) {
        if (f4226a || j > ((long) f4227d)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = c0415l;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(c0415l.m1115u().m1137b());
            C0426t.m1143b(str, objArr);
        }
    }

    private static void m4708a(String str, C0415l<?> c0415l, C0423s c0423s) throws C0423s {
        C0422p u = c0415l.m1115u();
        int t = c0415l.m1114t();
        try {
            u.m1136a(c0423s);
            c0415l.m1092a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
        } catch (C0423s e) {
            c0415l.m1092a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
            throw e;
        }
    }

    private void m4709a(Map<String, String> map, C0349a c0349a) {
        if (c0349a != null) {
            if (c0349a.f892b != null) {
                map.put("If-None-Match", c0349a.f892b);
            }
            if (c0349a.f893c > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c0349a.f893c)));
            }
        }
    }

    private byte[] m4710a(HttpEntity httpEntity) throws IOException, C1249q {
        ac acVar = new ac(this.f4230c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new C1249q();
            }
            bArr = this.f4230c.m1149a((int) NodeFilter.SHOW_DOCUMENT_FRAGMENT);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                acVar.write(bArr, 0, read);
            }
            byte[] toByteArray = acVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C0426t.m1141a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f4230c.m1148a(bArr);
            acVar.close();
        }
    }

    private static Map<String, String> m4706a(Header[] headerArr) {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
