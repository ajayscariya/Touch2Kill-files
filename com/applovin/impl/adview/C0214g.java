package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.g */
class C0214g implements Runnable {
    final /* synthetic */ AdViewControllerImpl f65a;
    private final AppLovinAd f66b;

    public C0214g(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f65a = adViewControllerImpl;
        this.f66b = appLovinAd;
    }

    public void run() {
        AppLovinAdClickListener i = this.f65a.f3787y;
        if (i != null && this.f66b != null) {
            try {
                i.adClicked(this.f66b);
            } catch (Throwable th) {
                this.f65a.f3766d.userError("AppLovinAdView", "Exception while notifying ad click listener", th);
            }
        }
    }
}
