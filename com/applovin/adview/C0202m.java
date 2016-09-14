package com.applovin.adview;

/* renamed from: com.applovin.adview.m */
class C0202m implements Runnable {
    final /* synthetic */ int f27a;
    final /* synthetic */ int f28b;
    final /* synthetic */ C0201l f29c;

    C0202m(C0201l c0201l, int i, int i2) {
        this.f29c = c0201l;
        this.f27a = i;
        this.f28b = i2;
    }

    public void run() {
        this.f29c.f26a.f3738d.m307e("AppLovinInterstitialActivity", "Video view error (" + this.f27a + "," + this.f28b + ") - showing close button.");
        this.f29c.f26a.m4021e();
    }
}
