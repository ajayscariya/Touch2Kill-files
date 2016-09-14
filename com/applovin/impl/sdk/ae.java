package com.applovin.impl.sdk;

class ae implements Runnable {
    final /* synthetic */ int f144a;
    final /* synthetic */ ac f145b;

    ae(ac acVar, int i) {
        this.f145b = acVar;
        this.f144a = i;
    }

    public void run() {
        this.f145b.f3890b.failedToReceiveAd(this.f144a);
    }
}
