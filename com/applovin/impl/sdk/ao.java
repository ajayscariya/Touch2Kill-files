package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ao implements Runnable {
    final /* synthetic */ AppLovinAd f168a;
    final /* synthetic */ int f169b;
    final /* synthetic */ af f170c;

    ao(af afVar, AppLovinAd appLovinAd, int i) {
        this.f170c = afVar;
        this.f168a = appLovinAd;
        this.f169b = i;
    }

    public void run() {
        this.f170c.f3896f.validationRequestFailed(this.f168a, this.f169b);
    }
}
