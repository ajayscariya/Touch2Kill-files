package com.jirbo.adcolony;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;
import mf.javax.xml.XMLConstants;

/* renamed from: com.jirbo.adcolony.g */
class C0721g {
    static String f2573a;
    static boolean f2574b;

    C0721g() {
    }

    static String m2602a() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return Secure.getString(AdColony.activity().getContentResolver(), "android_id");
    }

    static String m2603b() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        String networkOperatorName = ((TelephonyManager) AdColony.activity().getSystemService("phone")).getNetworkOperatorName();
        if (networkOperatorName.length() == 0) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return networkOperatorName;
    }

    static int m2604c() {
        if (C0694a.f2350P == null) {
            return 0;
        }
        Context applicationContext = C0694a.m2452b().getApplicationContext();
        C0694a.m2452b();
        return ((ActivityManager) applicationContext.getSystemService("activity")).getMemoryClass();
    }

    static long m2605d() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) AccessibilityNodeInfoCompat.ACTION_DISMISS);
    }

    static String m2606e() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return ai.m2536a(C0694a.m2452b());
    }

    static int m2607f() {
        if (C0694a.f2350P == null) {
            return 0;
        }
        return C0694a.m2452b().getWindowManager().getDefaultDisplay().getWidth();
    }

    static int m2608g() {
        if (C0694a.f2350P == null) {
            return 0;
        }
        return C0694a.m2452b().getWindowManager().getDefaultDisplay().getHeight();
    }

    static String m2609h() {
        return XMLConstants.NULL_NS_URI;
    }

    static boolean m2610i() {
        if (C0694a.f2350P == null) {
            return false;
        }
        if (C0694a.ah == null) {
            DisplayMetrics displayMetrics = AdColony.activity().getResources().getDisplayMetrics();
            float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            if (Math.sqrt((double) ((f2 * f2) + (f * f))) < 6.0d) {
                return false;
            }
            return true;
        } else if (C0694a.ah.equals("tablet")) {
            return true;
        } else {
            return false;
        }
    }

    static String m2611j() {
        return Locale.getDefault().getLanguage();
    }

    static String m2612k() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        try {
            return ((WifiManager) AdColony.activity().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (RuntimeException e) {
            return null;
        }
    }

    static String m2613l() {
        return Build.MANUFACTURER;
    }

    static String m2614m() {
        return Build.MODEL;
    }

    static String m2615n() {
        return XMLConstants.NULL_NS_URI;
    }

    static String m2616o() {
        return VERSION.RELEASE;
    }
}
