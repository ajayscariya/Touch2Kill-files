package com.applovin.impl.adview;

import com.applovin.impl.sdk.AppLovinSdkImpl;

/* renamed from: com.applovin.impl.adview.k */
class C0218k implements Runnable {
    final /* synthetic */ AdViewControllerImpl f71a;

    private C0218k(AdViewControllerImpl adViewControllerImpl) {
        this.f71a = adViewControllerImpl;
    }

    public void run() {
        if (this.f71a.f3776n != null) {
            this.f71a.f3766d.m306d("AppLovinAdView", "Rendering advertisement ad for #" + this.f71a.f3776n.getAdIdNumber() + " over placement: \"" + this.f71a.f3768f + "\"...");
            AdViewControllerImpl.m4069b(this.f71a.f3771i, this.f71a.f3776n.getSize());
            this.f71a.f3771i.m21a(this.f71a.f3776n, this.f71a.f3768f, (AppLovinSdkImpl) this.f71a.f3764b);
        }
    }
}
