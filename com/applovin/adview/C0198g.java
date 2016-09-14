package com.applovin.adview;

import com.applovin.impl.adview.C0227u;

/* renamed from: com.applovin.adview.g */
class C0198g implements Runnable {
    final /* synthetic */ C0227u f20a;
    final /* synthetic */ AppLovinInterstitialActivity f21b;

    C0198g(AppLovinInterstitialActivity appLovinInterstitialActivity, C0227u c0227u) {
        this.f21b = appLovinInterstitialActivity;
        this.f20a = c0227u;
    }

    public void run() {
        if (this.f20a.equals(this.f21b.f3758x)) {
            this.f21b.m4028i();
        } else if (this.f20a.equals(this.f21b.f3760z)) {
            this.f21b.m4033k();
        }
    }
}
