package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

class ac implements AppLovinAdLoadListener {
    final /* synthetic */ aa f3889a;
    private final AppLovinAdLoadListener f3890b;

    ac(aa aaVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f3889a = aaVar;
        this.f3890b = appLovinAdLoadListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f3889a.f133c = (AppLovinAdImpl) appLovinAd;
        if (this.f3890b != null) {
            this.f3889a.f136f.post(new ad(this, appLovinAd));
        }
    }

    public void failedToReceiveAd(int i) {
        if (this.f3890b != null) {
            this.f3889a.f136f.post(new ae(this, i));
        }
    }
}
