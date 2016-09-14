package com.chartboost.sdk.impl;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.chartboost.sdk.impl.t */
public class C0426t {
    public static String f1148a;
    public static boolean f1149b;

    /* renamed from: com.chartboost.sdk.impl.t.a */
    static class C0425a {
        public static final boolean f1145a;
        private final List<C0424a> f1146b;
        private boolean f1147c;

        /* renamed from: com.chartboost.sdk.impl.t.a.a */
        private static class C0424a {
            public final String f1142a;
            public final long f1143b;
            public final long f1144c;

            public C0424a(String str, long j, long j2) {
                this.f1142a = str;
                this.f1143b = j;
                this.f1144c = j2;
            }
        }

        C0425a() {
            this.f1146b = new ArrayList();
            this.f1147c = false;
        }

        static {
            f1145a = C0426t.f1149b;
        }

        public synchronized void m1140a(String str, long j) {
            if (this.f1147c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f1146b.add(new C0424a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void m1139a(String str) {
            this.f1147c = true;
            if (m1138a() > 0) {
                long j = ((C0424a) this.f1146b.get(0)).f1144c;
                C0426t.m1143b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C0424a c0424a : this.f1146b) {
                    C0426t.m1143b("(+%-4d) [%2d] %s", Long.valueOf(c0424a.f1144c - j2), Long.valueOf(c0424a.f1143b), c0424a.f1142a);
                    j2 = c0424a.f1144c;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.f1147c) {
                m1139a("Request on the loose");
                C0426t.m1144c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long m1138a() {
            if (this.f1146b.size() == 0) {
                return 0;
            }
            return ((C0424a) this.f1146b.get(this.f1146b.size() - 1)).f1144c - ((C0424a) this.f1146b.get(0)).f1144c;
        }
    }

    static {
        f1148a = "Volley";
        f1149b = Log.isLoggable(f1148a, 2);
    }

    public static void m1141a(String str, Object... objArr) {
        if (f1149b) {
            Log.v(f1148a, C0426t.m1145d(str, objArr));
        }
    }

    public static void m1143b(String str, Object... objArr) {
        Log.d(f1148a, C0426t.m1145d(str, objArr));
    }

    public static void m1144c(String str, Object... objArr) {
        Log.e(f1148a, C0426t.m1145d(str, objArr));
    }

    public static void m1142a(Throwable th, String str, Object... objArr) {
        Log.e(f1148a, C0426t.m1145d(str, objArr), th);
    }

    private static String m1145d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(C0426t.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
