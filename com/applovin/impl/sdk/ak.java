package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ak implements Runnable {
    final /* synthetic */ AppLovinAd f155a;
    final /* synthetic */ double f156b;
    final /* synthetic */ boolean f157c;
    final /* synthetic */ af f158d;

    ak(af afVar, AppLovinAd appLovinAd, double d, boolean z) {
        this.f158d = afVar;
        this.f155a = appLovinAd;
        this.f156b = d;
        this.f157c = z;
    }

    public void run() {
        this.f158d.f3895e.videoPlaybackEnded(this.f155a, this.f156b, this.f157c);
    }
}
