package com.applovin.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.adview.j */
class C1167j implements AppLovinAdClickListener {
    final /* synthetic */ AppLovinInterstitialActivity f3762a;

    C1167j(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f3762a = appLovinInterstitialActivity;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f3762a.f3736b.m4101e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
