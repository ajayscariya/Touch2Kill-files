package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ag implements Runnable {
    final /* synthetic */ AppLovinAd f146a;
    final /* synthetic */ int f147b;
    final /* synthetic */ af f148c;

    ag(af afVar, AppLovinAd appLovinAd, int i) {
        this.f148c = afVar;
        this.f146a = appLovinAd;
        this.f147b = i;
    }

    public void run() {
        this.f148c.f3896f.validationRequestFailed(this.f146a, this.f147b);
    }
}
