package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ah implements Runnable {
    final /* synthetic */ AppLovinAd f149a;
    final /* synthetic */ af f150b;

    ah(af afVar, AppLovinAd appLovinAd) {
        this.f150b = afVar;
        this.f149a = appLovinAd;
    }

    public void run() {
        this.f150b.f3893c.adHidden(this.f149a);
    }
}
