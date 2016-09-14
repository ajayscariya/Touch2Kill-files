package com.applovin.adview;

/* renamed from: com.applovin.adview.d */
class C0195d implements Runnable {
    final /* synthetic */ int f15a;
    final /* synthetic */ int f16b;
    final /* synthetic */ C0194c f17c;

    C0195d(C0194c c0194c, int i, int i2) {
        this.f17c = c0194c;
        this.f15a = i;
        this.f16b = i2;
    }

    public void run() {
        this.f17c.f14a.f13a.f3738d.m307e("AppLovinInterstitialActivity", "Media player error (" + this.f15a + "," + this.f16b + ") - showing close button.");
        this.f17c.f14a.f13a.m4021e();
    }
}
