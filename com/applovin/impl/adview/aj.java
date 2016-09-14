package com.applovin.impl.adview;

import android.app.Activity;

class aj implements Runnable {
    final /* synthetic */ boolean f53a;
    final /* synthetic */ boolean f54b;
    final /* synthetic */ Activity f55c;
    final /* synthetic */ ah f56d;

    aj(ah ahVar, boolean z, boolean z2, Activity activity) {
        this.f56d = ahVar;
        this.f53a = z;
        this.f54b = z2;
        this.f55c = activity;
    }

    public void run() {
        if (this.f53a && this.f54b) {
            this.f56d.m4091b(this.f55c);
        } else {
            this.f56d.m4085a(this.f55c);
        }
    }
}
