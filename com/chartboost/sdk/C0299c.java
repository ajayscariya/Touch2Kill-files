package com.chartboost.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.chartboost.sdk.C0304d.C0302a;
import com.chartboost.sdk.Chartboost.CBFramework;
import com.chartboost.sdk.Chartboost.CBMediation;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0347c;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.c */
public final class C0299c {
    private static boolean f670A;
    private static boolean f671B;
    private static boolean f672C;
    private static boolean f673D;
    private static boolean f674E;
    public static C0302a f675a;
    private static final String f676b;
    private static String f677c;
    private static String f678d;
    private static C0293a f679e;
    private static boolean f680f;
    private static boolean f681g;
    private static boolean f682h;
    private static CBFramework f683i;
    private static String f684j;
    private static String f685k;
    private static String f686l;
    private static CBMediation f687m;
    private static String f688n;
    private static String f689o;
    private static SharedPreferences f690p;
    private static boolean f691q;
    private static volatile boolean f692r;
    private static Context f693s;
    private static Application f694t;
    private static boolean f695u;
    private static boolean f696v;
    private static boolean f697w;
    private static boolean f698x;
    private static float f699y;
    private static boolean f700z;

    /* renamed from: com.chartboost.sdk.c.a */
    public interface C0298a {
        void m626a();
    }

    /* renamed from: com.chartboost.sdk.c.1 */
    static class C12071 implements C0347c {
        final /* synthetic */ C0298a f4015a;

        C12071(C0298a c0298a) {
            this.f4015a = c0298a;
        }

        public void m4409a(C0269a c0269a, az azVar) {
            if (c0269a.m438c()) {
                C0269a a = c0269a.m431a("response");
                if (a.m438c()) {
                    C0299c.m640a(a);
                }
            }
            if (this.f4015a != null) {
                this.f4015a.m626a();
            }
        }

        public void m4410a(C0269a c0269a, az azVar, CBError cBError) {
            if (this.f4015a != null) {
                this.f4015a.m626a();
            }
        }
    }

    static {
        f676b = C0299c.class.getSimpleName();
        f680f = false;
        f681g = false;
        f682h = false;
        f683i = null;
        f684j = null;
        f685k = null;
        f686l = null;
        f687m = null;
        f688n = null;
        f689o = null;
        f690p = null;
        f691q = true;
        f692r = false;
        f693s = null;
        f694t = null;
        f695u = false;
        f696v = true;
        f697w = false;
        f698x = true;
        f699y = 250.0f;
        f700z = false;
        f670A = true;
        f671B = true;
        f672C = true;
        f673D = true;
        f674E = true;
    }

    private C0299c() {
    }

    private static SharedPreferences m633G() {
        if (f690p == null) {
            f690p = CBUtility.m391a();
        }
        return f690p;
    }

    public static boolean m645a() {
        return f670A;
    }

    public static void m636a(CBFramework cBFramework) {
        if (!C0299c.m677t()) {
            return;
        }
        if (cBFramework == null) {
            CBLogging.m381b(f676b, "Pass a valid CBFramework enum value");
        } else {
            f683i = cBFramework;
        }
    }

    public static void m637a(CBFramework cBFramework, String str) {
        C0299c.m636a(cBFramework);
        f684j = str;
    }

    public static CBFramework m647b() {
        C0299c.m677t();
        return f683i == null ? null : f683i;
    }

    public static String m652c() {
        return String.format("%s %s", new Object[]{f683i, f684j});
    }

    public static void m643a(String str) {
        if (!C0299c.m677t()) {
            return;
        }
        if (f683i == null) {
            CBLogging.m381b(f676b, "Set a valid CBFramework first");
        } else if (TextUtils.isEmpty(str)) {
            CBLogging.m381b(f676b, "Invalid Version String");
        } else {
            f685k = str;
        }
    }

    public static String m655d() {
        C0299c.m677t();
        return f685k;
    }

    public static void m638a(CBMediation cBMediation, String str) {
        if (C0299c.m677t()) {
            f687m = cBMediation;
            f688n = str;
            f686l = f687m + " " + f688n;
        }
    }

    public static String m659e() {
        if (!C0299c.m677t()) {
            return XMLConstants.NULL_NS_URI;
        }
        f677c = C0299c.m633G().getString("appId", f677c);
        return f677c;
    }

    public static void m648b(String str) {
        f677c = str;
        C0299c.m633G().edit().putString("appId", str).commit();
    }

    public static String m661f() {
        if (!C0299c.m677t()) {
            return XMLConstants.NULL_NS_URI;
        }
        f678d = C0299c.m633G().getString("appSignature", f678d);
        return f678d;
    }

    public static void m653c(String str) {
        f678d = str;
        C0299c.m633G().edit().putString("appSignature", str).commit();
    }

    public static C0293a m663g() {
        if (C0299c.m677t()) {
            return f679e;
        }
        return null;
    }

    public static void m641a(C0293a c0293a) {
        if (C0299c.m677t()) {
            f679e = c0293a;
        }
    }

    public static boolean m665h() {
        return true;
    }

    public static boolean m666i() {
        if (C0299c.m677t()) {
            return f682h;
        }
        return false;
    }

    public static boolean m667j() {
        return f691q;
    }

    public static void m644a(boolean z) {
        f691q = z;
    }

    public static JSONObject m668k() {
        if (!C0299c.m677t()) {
            return null;
        }
        Object string = C0299c.m633G().getString("trackingLevels", XMLConstants.NULL_NS_URI);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        C0269a k = C0269a.m427k(string);
        if (k.m438c()) {
            return k.m443e();
        }
        return null;
    }

    public static boolean m669l() {
        C0299c.m677t();
        return C0299c.m633G().getBoolean("retriesEnabled", true);
    }

    public static boolean m670m() {
        if (!C0299c.m677t()) {
            return false;
        }
        JSONObject k = C0299c.m668k();
        if (k == null) {
            return false;
        }
        if (k.optBoolean("debug") || k.optBoolean("session") || k.optBoolean("system") || k.optBoolean("user")) {
            return true;
        }
        return false;
    }

    public static void m639a(Level level) {
        C0299c.m677t();
        CBLogging.f455a = level;
    }

    public static Level m671n() {
        C0299c.m677t();
        return CBLogging.f455a;
    }

    public static String m672o() {
        if (C0299c.m677t()) {
            return f689o;
        }
        return XMLConstants.NULL_NS_URI;
    }

    public static void m656d(String str) {
        if (C0299c.m677t()) {
            f689o = str;
        }
    }

    public static void m640a(C0269a c0269a) {
        try {
            if (c0269a.m438c()) {
                Map f = c0269a.m445f();
                if (f != null) {
                    Editor edit = C0299c.m633G().edit();
                    for (String str : f.keySet()) {
                        Object obj = f.get(str);
                        if (obj instanceof String) {
                            edit.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            edit.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Float) {
                            edit.putFloat(str, ((Float) obj).floatValue());
                        } else if (obj instanceof Long) {
                            edit.putLong(str, ((Long) obj).longValue());
                        } else if (obj instanceof Boolean) {
                            edit.putBoolean(str, ((Boolean) obj).booleanValue());
                        } else if (obj != null) {
                            edit.putString(str, obj.toString());
                        }
                    }
                    edit.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m642a(C0298a c0298a) {
        az azVar = new az("/api/config");
        azVar.m871a(false);
        azVar.m875b(false);
        azVar.m866a(C0414a.HIGH);
        azVar.m863a(C0276g.m480a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a)));
        azVar.m864a(new C12071(c0298a));
    }

    public static boolean m673p() {
        return f692r;
    }

    protected static void m649b(boolean z) {
        f692r = z;
    }

    public static boolean m674q() {
        if (C0299c.m677t() && C0299c.m676s() && C0299c.m675r()) {
            return true;
        }
        return false;
    }

    public static boolean m675r() {
        if (C0299c.m673p()) {
            return true;
        }
        try {
            throw new Exception("Session not started: Check if Chartboost.onStart() is called, if not the session won't be invoked");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m676s() {
        if (Chartboost.f425b != null) {
            return true;
        }
        try {
            throw new Exception("Chartboost Weak Activity reference is null");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m646a(Activity activity) {
        if (activity != null) {
            return true;
        }
        try {
            throw new Exception("Invalid activity context: Host Activity object is null, Please send a valid activity object");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m677t() {
        try {
            if (C0299c.m683z() == null) {
                throw new Exception("SDK Initialization error. Activity context seems to be not initialized properly, host activity or application context is being sent as null");
            } else if (TextUtils.isEmpty(f677c)) {
                throw new Exception("SDK Initialization error. AppId is missing");
            } else if (!TextUtils.isEmpty(f678d)) {
                return true;
            } else {
                throw new Exception("SDK Initialization error. AppSignature is missing");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void m654c(boolean z) {
        if (f675a != null) {
            f675a.m684a(z);
        }
    }

    protected static void m657d(boolean z) {
        f695u = z;
    }

    public static boolean m678u() {
        return f695u;
    }

    public static void m660e(boolean z) {
        f696v = z;
    }

    public static boolean m679v() {
        return f696v;
    }

    public static void m662f(boolean z) {
        f697w = z;
    }

    public static boolean m680w() {
        return f697w;
    }

    public static void m664g(boolean z) {
        f698x = z;
    }

    public static boolean m681x() {
        return f698x;
    }

    public static void m635a(Context context) {
        f693s = context;
    }

    public static Context m682y() {
        return f693s;
    }

    public static Application m683z() {
        return f694t;
    }

    public static void m634a(Application application) {
        f694t = application;
    }

    public static boolean m650b(Activity activity) {
        if (activity == null) {
            try {
                throw new RuntimeException("Invalid activity context passed during intitalization");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        int checkSelfPermission;
        int checkSelfPermission2;
        int checkSelfPermission3;
        int checkSelfPermission4;
        int checkSelfPermission5;
        if (VERSION.SDK_INT >= 23) {
            checkSelfPermission = activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            checkSelfPermission2 = activity.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE");
            checkSelfPermission3 = activity.checkSelfPermission("android.permission.INTERNET");
            checkSelfPermission4 = activity.checkSelfPermission("android.permission.READ_PHONE_STATE");
            checkSelfPermission5 = activity.checkSelfPermission("android.permission.ACCESS_WIFI_STATE");
        } else {
            checkSelfPermission = activity.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            checkSelfPermission2 = activity.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
            checkSelfPermission3 = activity.checkCallingOrSelfPermission("android.permission.INTERNET");
            checkSelfPermission4 = activity.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
            checkSelfPermission5 = activity.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE");
        }
        if (checkSelfPermission != 0) {
            f670A = true;
        } else {
            f670A = false;
        }
        if (checkSelfPermission3 != 0) {
            f671B = true;
            throw new RuntimeException("Please add the permission : android.permission.INTERNET in your android manifest.xml");
        }
        f671B = false;
        if (checkSelfPermission2 != 0) {
            f672C = true;
            throw new RuntimeException("Please add the permission :  android.permission.ACCESS_NETWORK_STATE in your android manifest.xml");
        }
        f672C = false;
        if (checkSelfPermission4 == 0) {
            f673D = false;
        } else {
            f673D = true;
        }
        if (checkSelfPermission5 == 0) {
            f674E = false;
            return true;
        }
        f674E = true;
        return true;
    }

    public static boolean m651b(Context context) {
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(1)) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (activityInfo.name.contains("com.chartboost.sdk.CBImpressionActivity")) {
                            f700z = true;
                        }
                    }
                }
            }
            if (f700z) {
                return true;
            }
            throw new RuntimeException("Please add             <activity android:name=\"com.chartboost.sdk.CBImpressionActivity\"\n                  android:excludeFromRecents=\"true\"\n                  android:theme=\"@android:style/Theme.Translucent.NoTitleBar.Fullscreen\"\n                  android:configChanges=\"keyboardHidden|orientation|screenSize\"/> in your android manifest.xml");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String m627A() {
        if (C0299c.m632F().booleanValue()) {
            return "/webview/v1/interstitial/get";
        }
        return "/interstitial/get";
    }

    public static String m628B() {
        if (C0299c.m632F().booleanValue()) {
            return "/webview/v1/reward/get";
        }
        return "/reward/get";
    }

    public static String m629C() {
        if (C0299c.m632F().booleanValue()) {
            return "/webview/v1/prefetch";
        }
        return "/api/video-prefetch";
    }

    public static int m630D() {
        Float e = C0299c.m658e("cacheTTLs");
        if (e == null || e.floatValue() < 604800.0f) {
            return 7;
        }
        return (int) TimeUnit.SECONDS.toDays(e.longValue());
    }

    public static int m631E() {
        Float e = C0299c.m658e("cacheMaxUnits");
        if (e == null || e.floatValue() <= 0.0f) {
            return 10;
        }
        return e.intValue();
    }

    private static Float m658e(String str) {
        Object string = C0299c.m633G().getString("webview", XMLConstants.NULL_NS_URI);
        if (!TextUtils.isEmpty(string)) {
            C0269a k = C0269a.m427k(string);
            if (k.m438c() && !k.m431a(str).m435b()) {
                return Float.valueOf(k.m446g(str));
            }
        }
        return null;
    }

    public static Boolean m632F() {
        Object string = C0299c.m633G().getString("webview", XMLConstants.NULL_NS_URI);
        if (!TextUtils.isEmpty(string)) {
            C0269a k = C0269a.m427k(string);
            if (k.m438c() && k.m431a("enabled").m438c()) {
                if (VERSION.SDK_INT >= 11) {
                    return Boolean.valueOf(k.m453j("enabled"));
                }
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(false);
    }
}
