package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

class ai implements AppLovinAdLoadListener {
    final /* synthetic */ String f3809a;
    final /* synthetic */ ah f3810b;

    ai(ah ahVar, String str) {
        this.f3810b = ahVar;
        this.f3809a = str;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f3810b.m4093b(appLovinAd);
        this.f3810b.showAndRender(appLovinAd, this.f3809a);
    }

    public void failedToReceiveAd(int i) {
        this.f3810b.m4084a(i);
    }
}
