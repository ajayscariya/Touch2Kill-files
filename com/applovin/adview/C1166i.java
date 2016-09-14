package com.applovin.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.adview.i */
class C1166i implements AppLovinAdDisplayListener {
    final /* synthetic */ AppLovinInterstitialActivity f3761a;

    C1166i(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f3761a = appLovinInterstitialActivity;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        this.f3761a.f3741g = (AppLovinAdImpl) appLovinAd;
        if (!this.f3761a.f3743i) {
            this.f3761a.m3999a(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f3761a.m4010b(appLovinAd);
    }
}
