package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ad implements Runnable {
    final /* synthetic */ AppLovinAd f142a;
    final /* synthetic */ ac f143b;

    ad(ac acVar, AppLovinAd appLovinAd) {
        this.f143b = acVar;
        this.f142a = appLovinAd;
    }

    public void run() {
        this.f143b.f3890b.adReceived(this.f142a);
    }
}
