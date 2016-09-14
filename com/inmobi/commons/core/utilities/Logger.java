package com.inmobi.commons.core.utilities;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class Logger {
    private static InternalLogLevel f1626a;

    /* renamed from: com.inmobi.commons.core.utilities.Logger.1 */
    static /* synthetic */ class C06381 {
        static final /* synthetic */ int[] f1625a;

        static {
            f1625a = new int[InternalLogLevel.values().length];
            try {
                f1625a[InternalLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1625a[InternalLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1625a[InternalLogLevel.INTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum InternalLogLevel {
        NONE,
        ERROR,
        DEBUG,
        INTERNAL
    }

    public static void m1744a(InternalLogLevel internalLogLevel, String str, String str2) {
        if (internalLogLevel.ordinal() <= f1626a.ordinal()) {
            switch (C06381.f1625a[internalLogLevel.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    Log.e("[InMobi]", str2);
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    Log.d("[InMobi]", str2);
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    Log.d(str, str2);
                default:
            }
        }
    }

    public static void m1745a(InternalLogLevel internalLogLevel, String str, String str2, Throwable th) {
        if (internalLogLevel.ordinal() <= f1626a.ordinal()) {
            switch (C06381.f1625a[internalLogLevel.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    Log.e("[InMobi]", str2, th);
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    Log.d("[InMobi]", str2, th);
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    Log.d(str, str2, th);
                default:
            }
        }
    }

    public static void m1743a(InternalLogLevel internalLogLevel) {
        f1626a = internalLogLevel;
    }

    static {
        f1626a = "production".equalsIgnoreCase("staging") ? InternalLogLevel.INTERNAL : InternalLogLevel.NONE;
    }
}
