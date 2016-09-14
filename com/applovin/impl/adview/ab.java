package com.applovin.impl.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.di;
import com.applovin.sdk.AppLovinAd;

class ab implements Runnable {
    final /* synthetic */ AppLovinAd f45a;
    final /* synthetic */ String f46b;
    final /* synthetic */ C1172x f47c;

    ab(C1172x c1172x, AppLovinAd appLovinAd, String str) {
        this.f47c = c1172x;
        this.f45a = appLovinAd;
        this.f46b = str;
    }

    public void run() {
        this.f47c.f3831e.renderAd(this.f45a, this.f46b);
        this.f47c.m4123a(((AppLovinAdImpl) this.f45a).getCloseStyle());
        float closeDelay = ((AppLovinAdImpl) this.f45a).getCloseDelay();
        if (closeDelay > 0.0f) {
            this.f47c.m4122a(di.m4292c(closeDelay));
            return;
        }
        this.f47c.f3833g.setVisibility(0);
        this.f47c.f3833g.setClickable(true);
    }
}
