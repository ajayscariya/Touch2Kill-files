package com.immersion.content;

import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class Log {
    private static final boolean f1217a = false;
    public static int f1218b04460446 = 0;
    public static int f1219b04460446 = 2;
    public static int f1220b0446 = 45;
    public static int f1221b0446 = 1;

    public static int m1290b04460446() {
        return 40;
    }

    public static void m1291d(String str, String str2) {
        while (true) {
            switch (1) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    return;
                default:
                    while (true) {
                        switch (1) {
                            case DurationDV.DURATION_TYPE /*0*/:
                                break;
                            case MainNavigationActivity.REQUEST_CODE /*1*/:
                                return;
                            default:
                        }
                    }
            }
        }
    }

    public static void m1292e(String str, String str2) {
        try {
            android.util.Log.e(str, str2);
            if (((f1220b0446 + f1221b0446) * f1220b0446) % f1219b04460446 != f1218b04460446) {
                f1220b0446 = 56;
                f1218b04460446 = 70;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void m1293i(String str, String str2) {
        android.util.Log.i(str, str2);
    }

    public static void m1294v(String str, String str2) {
        while (true) {
            switch (null) {
                case DurationDV.DURATION_TYPE /*0*/:
                    return;
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    break;
                default:
                    while (true) {
                        switch (null) {
                            case DurationDV.DURATION_TYPE /*0*/:
                                return;
                            case MainNavigationActivity.REQUEST_CODE /*1*/:
                                break;
                            default:
                        }
                    }
            }
        }
    }

    public static void m1295w(String str, String str2) {
        android.util.Log.w(str, str2);
    }
}
