package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

class ak implements Runnable {
    final /* synthetic */ AppLovinAd f57a;
    final /* synthetic */ ah f58b;

    ak(ah ahVar, AppLovinAd appLovinAd) {
        this.f58b = ahVar;
        this.f57a = appLovinAd;
    }

    public void run() {
        if (this.f58b.f3801g != null) {
            this.f58b.f3801g.adReceived(this.f57a);
        }
    }
}
