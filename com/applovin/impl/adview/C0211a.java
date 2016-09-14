package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.adview.a */
class C0211a implements Runnable {
    final /* synthetic */ AppLovinAd f43a;
    final /* synthetic */ AdViewControllerImpl f44b;

    C0211a(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f44b = adViewControllerImpl;
        this.f43a = appLovinAd;
    }

    public void run() {
        try {
            if (this.f44b.f3784v != null) {
                this.f44b.f3784v.adReceived(this.f43a);
            }
        } catch (Throwable th) {
            this.f44b.f3766d.userError(AppLovinLogger.SDK_TAG, "Exception while running app load callback: " + th.getMessage());
        }
    }
}
