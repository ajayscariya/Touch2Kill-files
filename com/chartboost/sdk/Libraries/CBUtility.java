package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.C0299c;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

public final class CBUtility {
    private static Handler f457a;

    private CBUtility() {
    }

    public static SharedPreferences m391a() {
        if (C0299c.m682y() != null) {
            return C0299c.m682y().getSharedPreferences("cbPrefs", 0);
        }
        CBLogging.m381b("CBUtility", "The context must be set through the Chartboost method onCreate() before modifying or accessing preferences.");
        return null;
    }

    public static boolean m396b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String m392a(Map<String, Object> map) {
        if (map == null) {
            return XMLConstants.NULL_NS_URI;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!map.keySet().isEmpty()) {
            stringBuilder.append("?");
        }
        for (String str : map.keySet()) {
            String str2;
            if (stringBuilder.length() > 1) {
                stringBuilder.append("&");
            }
            String obj = map.get(str2).toString();
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, Defaults.Encoding);
                } catch (Throwable e) {
                    CBLogging.m382b("CBUtility", "This method requires UTF-8 encoding support", e);
                    return null;
                }
            }
            str2 = XMLConstants.NULL_NS_URI;
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append(obj != null ? URLEncoder.encode(obj, Defaults.Encoding) : XMLConstants.NULL_NS_URI);
        }
        return stringBuilder.toString();
    }

    public static float m389a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int m390a(int i, Context context) {
        return Math.round(((float) i) * m389a(context));
    }

    public static float m388a(float f, Context context) {
        return m389a(context) * f;
    }

    public static C0272f m397c() {
        int i;
        Context y = C0299c.m682y();
        Display defaultDisplay = ((WindowManager) y.getSystemService("window")).getDefaultDisplay();
        int i2 = y.getResources().getConfiguration().orientation;
        int rotation = defaultDisplay.getRotation();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            Object obj = 3;
        } else if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        if (obj == 1) {
            obj = 1;
        } else if (obj == 2) {
            obj = null;
        } else {
            if (obj == 3) {
                if (i2 == 1) {
                    i = 1;
                } else if (i2 == 2) {
                    obj = null;
                }
            }
            i = 1;
        }
        if (!(rotation == 0 || rotation == 2)) {
            if (obj == null) {
                i = 1;
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            switch (rotation) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    return C0272f.f486g;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    return C0272f.PORTRAIT_REVERSE;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    return C0272f.f487h;
                default:
                    return C0272f.PORTRAIT;
            }
        }
        switch (rotation) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                return C0272f.f484e;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                return C0272f.LANDSCAPE_REVERSE;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return C0272f.f485f;
            default:
                return C0272f.LANDSCAPE;
        }
    }

    public static void throwProguardError(Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            CBLogging.m381b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
        } else if (ex == null || ex.getMessage() == null) {
            CBLogging.m381b("CBUtility", "Unknown Proguard error");
        } else {
            CBLogging.m381b("CBUtility", ex.getMessage());
        }
    }

    public static String m399d() {
        String str = "%s %s %s";
        Object[] objArr = new Object[3];
        objArr[0] = "Chartboost-Android-SDK";
        objArr[1] = C0299c.m647b() == null ? XMLConstants.NULL_NS_URI : C0299c.m647b();
        objArr[2] = "6.0.2";
        return String.format(str, objArr);
    }

    public static Handler m400e() {
        if (f457a == null) {
            f457a = new Handler(Looper.getMainLooper());
        }
        return f457a;
    }

    public static void m394a(Handler handler) {
        f457a = handler;
    }

    public static boolean m401f() {
        return m403h() || m404i() || m405j();
    }

    public static String m402g() {
        SimpleDateFormat simpleDateFormat;
        if (VERSION.SDK_INT >= 18) {
            simpleDateFormat = new SimpleDateFormat("ZZZZ", Locale.US);
        } else {
            simpleDateFormat = new SimpleDateFormat("'GMT'ZZZZ", Locale.US);
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date());
    }

    private static boolean m403h() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean m404i() {
        return new File("/system/app/Superuser.apk").exists();
    }

    private static boolean m405j() {
        for (String file : new String[]{"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"}) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    public static void m393a(Activity activity) {
        if (activity != null) {
            C0272f c = m397c();
            if (c == C0272f.PORTRAIT) {
                activity.setRequestedOrientation(1);
            } else if (c == C0272f.PORTRAIT_REVERSE) {
                activity.setRequestedOrientation(9);
            } else if (c == C0272f.LANDSCAPE) {
                activity.setRequestedOrientation(0);
            } else {
                activity.setRequestedOrientation(8);
            }
        }
    }

    public static void m395b(Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(-1);
        }
    }

    public static void m398c(Activity activity) {
        if (activity != null && VERSION.SDK_INT >= 11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }
}
