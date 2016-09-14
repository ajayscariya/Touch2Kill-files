package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.media.TransportMediator;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import java.util.HashMap;
import java.util.Map;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.core.utilities.info.a */
public class AppInfo {
    private static final String f1649a;
    private static AppInfo f1650b;
    private static Object f1651c;
    private String f1652d;
    private String f1653e;
    private String f1654f;
    private String f1655g;
    private Map<String, String> f1656h;

    static {
        f1649a = AppInfo.class.getSimpleName();
        f1651c = new Object();
    }

    private AppInfo() {
        this.f1656h = new HashMap();
        m1792a(SdkContext.m1562b());
        m1793d();
    }

    private void m1792a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT);
            if (applicationInfo != null) {
                this.f1652d = applicationInfo.packageName;
                this.f1653e = applicationInfo.loadLabel(packageManager).toString();
                this.f1655g = packageManager.getInstallerPackageName(this.f1652d);
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT);
            String str = null;
            if (packageInfo != null) {
                str = packageInfo.versionName;
                if (str == null || str.equals(XMLConstants.NULL_NS_URI)) {
                    str = packageInfo.versionCode + XMLConstants.NULL_NS_URI;
                }
            }
            if (str != null && !str.equals(XMLConstants.NULL_NS_URI)) {
                this.f1654f = str;
            }
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1649a, "Failed to fetch app info completely", e);
        }
    }

    private void m1793d() {
        this.f1656h.put("u-appbid", this.f1652d);
        this.f1656h.put("u-appdnm", this.f1653e);
        this.f1656h.put("u-appver", this.f1654f);
    }

    public static AppInfo m1791a() {
        AppInfo appInfo = f1650b;
        if (appInfo == null) {
            synchronized (f1651c) {
                appInfo = f1650b;
                if (appInfo == null) {
                    f1650b = new AppInfo();
                    appInfo = f1650b;
                }
            }
        }
        return appInfo;
    }

    public String m1794b() {
        return this.f1655g;
    }

    public Map<String, String> m1795c() {
        return this.f1656h;
    }
}
