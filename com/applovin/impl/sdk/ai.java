package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ai implements Runnable {
    final /* synthetic */ AppLovinAd f151a;
    final /* synthetic */ af f152b;

    ai(af afVar, AppLovinAd appLovinAd) {
        this.f152b = afVar;
        this.f151a = appLovinAd;
    }

    public void run() {
        this.f152b.f3894d.adClicked(this.f151a);
    }
}
