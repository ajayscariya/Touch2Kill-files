package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.c */
class C1168c implements AppLovinAdClickListener {
    final /* synthetic */ AdViewControllerImpl f3821a;

    C1168c(AdViewControllerImpl adViewControllerImpl) {
        this.f3821a = adViewControllerImpl;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f3821a.f3787y != null) {
            this.f3821a.f3787y.adClicked(appLovinAd);
        }
    }
}
