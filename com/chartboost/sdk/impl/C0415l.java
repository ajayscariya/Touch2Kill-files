package com.chartboost.sdk.impl;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.chartboost.sdk.impl.C0350b.C0349a;
import com.chartboost.sdk.impl.C0420n.C0418a;
import com.chartboost.sdk.impl.C0426t.C0425a;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.chartboost.sdk.impl.l */
public abstract class C0415l<T> implements Comparable<C0415l<T>> {
    private final C0425a f1112a;
    private final int f1113b;
    private final String f1114c;
    private final int f1115d;
    private final C0418a f1116e;
    private Integer f1117f;
    private C0417m f1118g;
    private boolean f1119h;
    private boolean f1120i;
    private boolean f1121j;
    private long f1122k;
    private C0422p f1123l;
    private C0349a f1124m;
    private Object f1125n;

    /* renamed from: com.chartboost.sdk.impl.l.1 */
    class C04131 implements Runnable {
        final /* synthetic */ C0415l f1104a;
        private final /* synthetic */ String f1105b;
        private final /* synthetic */ long f1106c;

        C04131(C0415l c0415l, String str, long j) {
            this.f1104a = c0415l;
            this.f1105b = str;
            this.f1106c = j;
        }

        public void run() {
            this.f1104a.f1112a.m1140a(this.f1105b, this.f1106c);
            this.f1104a.f1112a.m1139a(toString());
        }
    }

    /* renamed from: com.chartboost.sdk.impl.l.a */
    public enum C0414a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract C0420n<T> m1090a(C0412i c0412i);

    protected abstract void m1095b(T t);

    public /* synthetic */ int compareTo(Object obj) {
        return m1084a((C0415l) obj);
    }

    public C0415l(int i, String str, C0418a c0418a) {
        C0425a c0425a;
        if (C0425a.f1145a) {
            c0425a = new C0425a();
        } else {
            c0425a = null;
        }
        this.f1112a = c0425a;
        this.f1119h = true;
        this.f1120i = false;
        this.f1121j = false;
        this.f1122k = 0;
        this.f1124m = null;
        this.f1113b = i;
        this.f1114c = str;
        this.f1116e = c0418a;
        m1088a(new C1244d());
        this.f1115d = C0415l.m1082c(str);
    }

    public int m1083a() {
        return this.f1113b;
    }

    public C0415l<?> m1089a(Object obj) {
        this.f1125n = obj;
        return this;
    }

    public Object m1093b() {
        return this.f1125n;
    }

    public int m1097c() {
        return this.f1115d;
    }

    private static int m1082c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public C0415l<?> m1088a(C0422p c0422p) {
        this.f1123l = c0422p;
        return this;
    }

    public void m1092a(String str) {
        if (C0425a.f1145a) {
            this.f1112a.m1140a(str, Thread.currentThread().getId());
        } else if (this.f1122k == 0) {
            this.f1122k = SystemClock.elapsedRealtime();
        }
    }

    void m1096b(String str) {
        if (this.f1118g != null) {
            this.f1118g.m1125b(this);
        }
        if (C0425a.f1145a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C04131(this, str, id));
                return;
            }
            this.f1112a.m1140a(str, id);
            this.f1112a.m1139a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f1122k >= 3000) {
            C0426t.m1143b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f1122k), toString());
        }
    }

    public C0415l<?> m1087a(C0417m c0417m) {
        this.f1118g = c0417m;
        return this;
    }

    public final C0415l<?> m1085a(int i) {
        this.f1117f = Integer.valueOf(i);
        return this;
    }

    public String m1098d() {
        return this.f1114c;
    }

    public String m1099e() {
        return m1098d();
    }

    public C0415l<?> m1086a(C0349a c0349a) {
        this.f1124m = c0349a;
        return this;
    }

    public C0349a m1100f() {
        return this.f1124m;
    }

    public void m1101g() {
        this.f1120i = true;
    }

    public boolean m1102h() {
        return this.f1120i;
    }

    public Map<String, String> m1103i() throws C1214a {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> m1104j() throws C1214a {
        return m1108n();
    }

    @Deprecated
    protected String m1105k() {
        return m1109o();
    }

    @Deprecated
    public String m1106l() {
        return m1110p();
    }

    @Deprecated
    public byte[] m1107m() throws C1214a {
        Map j = m1104j();
        if (j == null || j.size() <= 0) {
            return null;
        }
        return m1080a(j, m1105k());
    }

    protected Map<String, String> m1108n() throws C1214a {
        return null;
    }

    protected String m1109o() {
        return Defaults.Encoding;
    }

    public String m1110p() {
        return "application/x-www-form-urlencoded; charset=" + m1109o();
    }

    public byte[] m1111q() throws C1214a {
        Map n = m1108n();
        if (n == null || n.size() <= 0) {
            return null;
        }
        return m1080a(n, m1109o());
    }

    private byte[] m1080a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public final boolean m1112r() {
        return this.f1119h;
    }

    public C0414a m1113s() {
        return C0414a.NORMAL;
    }

    public final int m1114t() {
        return this.f1123l.m1135a();
    }

    public C0422p m1115u() {
        return this.f1123l;
    }

    public void m1116v() {
        this.f1121j = true;
    }

    public boolean m1117w() {
        return this.f1121j;
    }

    protected C0423s m1091a(C0423s c0423s) {
        return c0423s;
    }

    public void m1094b(C0423s c0423s) {
        if (this.f1116e != null) {
            this.f1116e.m1127a(c0423s);
        }
    }

    public int m1084a(C0415l<T> c0415l) {
        C0414a s = m1113s();
        C0414a s2 = c0415l.m1113s();
        if (s == s2) {
            return this.f1117f.intValue() - c0415l.f1117f.intValue();
        }
        return s2.ordinal() - s.ordinal();
    }

    public String toString() {
        return new StringBuilder(String.valueOf(this.f1120i ? "[X] " : "[ ] ")).append(m1098d()).append(" ").append("0x" + Integer.toHexString(m1097c())).append(" ").append(m1113s()).append(" ").append(this.f1117f).toString();
    }
}
