package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.b */
class C0212b implements Runnable {
    final /* synthetic */ int f62a;
    final /* synthetic */ AdViewControllerImpl f63b;

    C0212b(AdViewControllerImpl adViewControllerImpl, int i) {
        this.f63b = adViewControllerImpl;
        this.f62a = i;
    }

    public void run() {
        try {
            if (this.f63b.f3784v != null) {
                this.f63b.f3784v.failedToReceiveAd(this.f62a);
            }
        } catch (Throwable th) {
            this.f63b.f3766d.userError("AppLovinAdView", "Exception while running app load  callback", th);
        }
    }
}
