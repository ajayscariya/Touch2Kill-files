package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;

class cq implements Runnable {
    private final AppLovinSdkImpl f298a;
    private final AppLovinLogger f299b;
    private final Context f300c;

    cq(AppLovinSdkImpl appLovinSdkImpl) {
        this.f298a = appLovinSdkImpl;
        this.f300c = appLovinSdkImpl.getApplicationContext();
        this.f299b = appLovinSdkImpl.getLogger();
    }

    private void m226c() {
        String str = (String) this.f298a.m4161a(bx.f235D);
        if (str.length() > 0) {
            for (String fromString : str.split(",")) {
                AppLovinAdSize fromString2 = AppLovinAdSize.fromString(fromString);
                if (fromString2 != null) {
                    this.f298a.m4164c().m6076d(new C0231c(fromString2, AppLovinAdType.REGULAR));
                }
            }
        }
        if (((Boolean) this.f298a.m4161a(bx.f236E)).booleanValue()) {
            this.f298a.m4164c().m6076d(new C0231c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED));
        }
        if (((Boolean) this.f298a.m4161a(bx.az)).booleanValue()) {
            this.f298a.m4165d().m6089d(NativeAdImpl.SPEC_NATIVE);
        }
    }

    boolean m227a() {
        if (C0241r.m278a("android.permission.INTERNET", this.f300c)) {
            return true;
        }
        this.f299b.userError("TaskInitializeSdk", "Unable to enable AppLovin SDK: no android.permission.INTERNET");
        return false;
    }

    void m228b() {
        this.f298a.m4160a().m234a(new ce(this.f298a), cs.MAIN, 500);
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f299b.m306d("TaskInitializeSdk", "Initializing AppLovin SDK 6.2.4...");
        try {
            if (m227a()) {
                cc b = this.f298a.m4163b();
                b.m221c();
                b.m222c("ad_imp_session");
                C0230a.m55b(this.f298a);
                this.f298a.getFileManager().m302e(this.f300c);
                this.f298a.getFileManager().m301d(this.f300c);
                m226c();
                m228b();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f300c);
                if (!AppLovinSdkUtils.isValidString(defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", null))) {
                    defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(true)).commit();
                }
                this.f298a.getPersistentPostbackManager().m138a();
                this.f298a.getEventService().trackEvent("landing");
                this.f298a.m4162a(true);
            } else {
                this.f298a.m4162a(false);
            }
            this.f299b.m306d("TaskInitializeSdk", "AppLovin SDK 6.2.4 initialization " + (this.f298a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f299b.m306d("TaskInitializeSdk", "AppLovin SDK 6.2.4 initialization " + (this.f298a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
