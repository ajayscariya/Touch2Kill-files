package com.applovin.impl.sdk;

import android.app.Activity;
import android.widget.Toast;

public class ap {
    private final AppLovinSdkImpl f171a;
    private final String f172b;
    private final Activity f173c;

    public ap(AppLovinSdkImpl appLovinSdkImpl, Activity activity, String str) {
        this.f171a = appLovinSdkImpl;
        this.f172b = str;
        this.f173c = activity;
    }

    void m81a() {
        this.f173c.runOnUiThread(new aq(this));
    }

    void m82a(String str, Throwable th) {
        this.f171a.getLogger().userError("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", th);
        Toast.makeText(this.f173c, str, 1).show();
    }

    String m83b() {
        return this.f172b.equals("accepted") ? (String) this.f171a.m4161a(bx.f247P) : this.f172b.equals("quota_exceeded") ? (String) this.f171a.m4161a(bx.f248Q) : this.f172b.equals("rejected") ? (String) this.f171a.m4161a(bx.f249R) : (String) this.f171a.m4161a(bx.f250S);
    }
}
