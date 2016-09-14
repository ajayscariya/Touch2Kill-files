package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.applovin.impl.sdk.r */
class C0241r {
    private static List f339e;
    private final AppLovinSdkImpl f340a;
    private final Context f341b;
    private final AppLovinLogger f342c;
    private final Map f343d;

    static {
        f339e = new ArrayList();
    }

    C0241r(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f340a = appLovinSdkImpl;
        this.f342c = appLovinSdkImpl.getLogger();
        this.f341b = appLovinSdkImpl.getApplicationContext();
        this.f343d = Collections.synchronizedMap(new HashMap());
    }

    static boolean m278a(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException("No permission name specified");
        } else if (context != null) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    C0245v m279a() {
        Object obj = this.f343d.get(C0245v.class);
        if (obj != null) {
            return (C0245v) obj;
        }
        C0245v c0245v = new C0245v();
        c0245v.f358h = Locale.getDefault();
        c0245v.f351a = Build.MODEL;
        c0245v.f352b = VERSION.RELEASE;
        c0245v.f353c = Build.MANUFACTURER;
        c0245v.f355e = VERSION.SDK_INT;
        c0245v.f354d = Build.DEVICE;
        if (m280a("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f341b.getSystemService("phone");
            if (telephonyManager != null) {
                c0245v.f356f = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                try {
                    c0245v.f357g = URLEncoder.encode(networkOperatorName, Defaults.Encoding);
                } catch (UnsupportedEncodingException e) {
                    c0245v.f357g = networkOperatorName;
                }
            }
        }
        try {
            c0245v.f359i = this.f341b.getPackageManager().getPackageInfo((String) this.f340a.getSettingsManager().m169a(bx.bo), 0).versionCode;
        } catch (Throwable th) {
        }
        this.f343d.put(C0245v.class, c0245v);
        return c0245v;
    }

    boolean m280a(String str) {
        return C0241r.m278a(str, this.f341b);
    }

    C0244u m281b() {
        Object obj = this.f343d.get(C0244u.class);
        if (obj != null) {
            return (C0244u) obj;
        }
        ApplicationInfo applicationInfo = this.f341b.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f341b.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f341b.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
        C0244u c0244u = new C0244u();
        c0244u.f349c = applicationInfo.packageName;
        c0244u.f350d = lastModified;
        c0244u.f347a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        c0244u.f348b = packageInfo != null ? packageInfo.versionName : XMLConstants.NULL_NS_URI;
        this.f343d.put(C0244u.class, c0244u);
        return c0244u;
    }

    C0243t m282c() {
        try {
            Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (cls != null) {
                Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f341b});
                if (invoke != null) {
                    Class cls2 = invoke.getClass();
                    Object invoke2 = cls2.getMethod("isLimitAdTrackingEnabled", null).invoke(invoke, null);
                    invoke = cls2.getMethod("getId", null).invoke(invoke, null);
                    C0243t c0243t = new C0243t();
                    String str = (String) invoke;
                    String str2 = str == null ? XMLConstants.NULL_NS_URI : str;
                    c0243t.f345a = ((Boolean) invoke2).booleanValue();
                    c0243t.f346b = str2;
                    return c0243t;
                }
            }
        } catch (Throwable e) {
            this.f342c.userError("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e);
        } catch (Throwable e2) {
            this.f342c.m308e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e2);
        }
        C0243t c0243t2 = new C0243t();
        c0243t2.f346b = XMLConstants.NULL_NS_URI;
        c0243t2.f345a = false;
        return c0243t2;
    }

    List m283d() {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = this.f341b.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return Collections.emptyList();
        }
        if (f339e.size() == queryIntentActivities.size() && f339e.size() > 0 && ((C0244u) f339e.get(0)).f347a.equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name)) {
            return new ArrayList(f339e);
        }
        List arrayList = new ArrayList(queryIntentActivities.size());
        Set hashSet = new HashSet();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            try {
                long lastModified = new File(resolveInfo.activityInfo.applicationInfo.sourceDir).lastModified();
                C0244u c0244u = new C0244u();
                c0244u.f349c = di.m4283a(resolveInfo.activityInfo.packageName, this.f340a);
                c0244u.f350d = lastModified;
                c0244u.f347a = resolveInfo.activityInfo.name;
                if (!hashSet.contains(c0244u.f349c)) {
                    arrayList.add(c0244u);
                    hashSet.add(c0244u.f349c);
                }
            } catch (Throwable th) {
                this.f342c.m311w("DataCollector", "Unable to read information for app \"" + resolveInfo + "\"", th);
            }
        }
        try {
            Collections.sort(arrayList, new C0242s(this));
        } catch (Throwable th2) {
            this.f342c.m311w("DataCollector", "Unable to sort applications", th2);
        }
        f339e = arrayList;
        return arrayList;
    }
}
