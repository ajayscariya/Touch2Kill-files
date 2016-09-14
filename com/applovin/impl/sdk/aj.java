package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class aj implements Runnable {
    final /* synthetic */ AppLovinAd f153a;
    final /* synthetic */ af f154b;

    aj(af afVar, AppLovinAd appLovinAd) {
        this.f154b = afVar;
        this.f153a = appLovinAd;
    }

    public void run() {
        this.f154b.f3895e.videoPlaybackBegan(this.f153a);
    }
}
