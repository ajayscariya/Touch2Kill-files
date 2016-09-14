package com.applovin.impl.adview;

class al implements Runnable {
    final /* synthetic */ int f59a;
    final /* synthetic */ ah f60b;

    al(ah ahVar, int i) {
        this.f60b = ahVar;
        this.f59a = i;
    }

    public void run() {
        if (this.f60b.f3801g != null) {
            this.f60b.f3801g.failedToReceiveAd(this.f59a);
        }
    }
}
