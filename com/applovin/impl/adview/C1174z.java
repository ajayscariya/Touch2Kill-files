package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.z */
class C1174z implements AppLovinAdClickListener {
    final /* synthetic */ ah f3840a;
    final /* synthetic */ C1172x f3841b;

    C1174z(C1172x c1172x, ah ahVar) {
        this.f3841b = c1172x;
        this.f3840a = ahVar;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f3840a.m4101e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
