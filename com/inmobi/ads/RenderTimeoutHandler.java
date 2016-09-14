package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.inmobi.ads.o */
final class RenderTimeoutHandler extends Handler {
    private AdUnit f1496a;

    public RenderTimeoutHandler(AdUnit adUnit) {
        this.f1496a = adUnit;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case DurationDV.DURATION_TYPE /*0*/:
                this.f1496a.m4989m().stopLoading();
                this.f1496a.m4996t();
            default:
        }
    }
}
