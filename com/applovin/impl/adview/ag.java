package com.applovin.impl.adview;

class ag implements Runnable {
    final /* synthetic */ C1172x f52a;

    private ag(C1172x c1172x) {
        this.f52a = c1172x;
    }

    public void run() {
        try {
            this.f52a.dismiss();
        } catch (Throwable th) {
            if (this.f52a.f3829c != null) {
                this.f52a.f3829c.m308e("InterstitialAdDialog", "dismiss() threw exception", th);
            }
        }
    }
}
