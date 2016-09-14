package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.h */
class C0215h implements Runnable {
    final /* synthetic */ AdViewControllerImpl f67a;
    private final AppLovinAd f68b;

    public C0215h(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f67a = adViewControllerImpl;
        this.f68b = appLovinAd;
    }

    public void run() {
        AppLovinAdDisplayListener h = this.f67a.f3785w;
        if (h != null && this.f68b != null) {
            try {
                h.adHidden(this.f68b);
            } catch (Throwable th) {
                this.f67a.f3766d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }
}
