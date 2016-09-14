package com.chartboost.sdk.Libraries;

import android.util.Log;

public final class CBLogging {
    public static Level f455a;
    private static String f456b;

    public enum Level {
        NONE,
        INTEGRATION,
        ALL
    }

    static {
        f455a = Level.INTEGRATION;
        f456b = "Chartboost SDK";
    }

    private static String m378a(Object obj) {
        String name = (obj == null || (obj instanceof String)) ? obj : obj.getClass().getName();
        return name;
    }

    public static void m379a(Object obj, String str) {
        if (f455a == Level.ALL) {
            Log.d(m378a(obj), str);
        }
    }

    public static void m380a(Object obj, String str, Throwable th) {
        if (f455a == Level.ALL) {
            Log.d(m378a(obj), str, th);
        }
    }

    public static void m381b(Object obj, String str) {
        if (f455a == Level.ALL) {
            Log.e(m378a(obj), str);
        }
    }

    public static void m382b(Object obj, String str, Throwable th) {
        if (f455a == Level.ALL) {
            Log.e(m378a(obj), str, th);
        }
    }

    public static void m383c(Object obj, String str) {
        if (f455a == Level.ALL) {
            Log.v(m378a(obj), str);
        }
    }

    public static void m384c(Object obj, String str, Throwable th) {
        if (f455a == Level.ALL) {
            Log.v(m378a(obj), str, th);
        }
    }

    public static void m385d(Object obj, String str) {
        if (f455a == Level.ALL) {
            Log.w(m378a(obj), str);
        }
    }

    public static void m386d(Object obj, String str, Throwable th) {
        if (f455a == Level.ALL) {
            Log.w(m378a(obj), str, th);
        }
    }

    public static void m387e(Object obj, String str) {
        if (f455a == Level.ALL) {
            Log.i(m378a(obj), str);
        }
    }
}
