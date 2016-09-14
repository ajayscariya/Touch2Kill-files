package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class al implements Runnable {
    final /* synthetic */ AppLovinAd f159a;
    final /* synthetic */ Map f160b;
    final /* synthetic */ af f161c;

    al(af afVar, AppLovinAd appLovinAd, Map map) {
        this.f161c = afVar;
        this.f159a = appLovinAd;
        this.f160b = map;
    }

    public void run() {
        this.f161c.f3896f.userRewardVerified(this.f159a, this.f160b);
    }
}
