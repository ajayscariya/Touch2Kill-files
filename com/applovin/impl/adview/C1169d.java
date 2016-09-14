package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.d */
class C1169d implements AppLovinAdDisplayListener {
    final /* synthetic */ AdViewControllerImpl f3822a;

    C1169d(AdViewControllerImpl adViewControllerImpl) {
        this.f3822a = adViewControllerImpl;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
    }

    public void adHidden(AppLovinAd appLovinAd) {
        if (this.f3822a.f3785w != null) {
            this.f3822a.f3785w.adHidden(appLovinAd);
        }
    }
}
