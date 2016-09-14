package com.applovin.adview;

import java.util.UUID;

/* renamed from: com.applovin.adview.h */
class C0199h implements Runnable {
    final /* synthetic */ int f22a;
    final /* synthetic */ UUID f23b;
    final /* synthetic */ AppLovinInterstitialActivity f24c;

    C0199h(AppLovinInterstitialActivity appLovinInterstitialActivity, int i, UUID uuid) {
        this.f24c = appLovinInterstitialActivity;
        this.f22a = i;
        this.f23b = uuid;
    }

    public void run() {
        this.f24c.m3995a(this.f22a, this.f23b);
    }
}
