package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class ad {
    public static C0417m m796a(Context context, C0433z c0433z) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName)).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (c0433z == null) {
            if (VERSION.SDK_INT >= 9) {
                c0433z = new aa();
            } else {
                c0433z = new C1253x(AndroidHttpClient.newInstance(str));
            }
        }
        C0417m c0417m = new C0417m(new C1252w(file), new C1251u(c0433z));
        c0417m.m1120a();
        return c0417m;
    }

    public static C0417m m795a(Context context) {
        return m796a(context, null);
    }
}
