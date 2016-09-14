package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class an implements Runnable {
    final /* synthetic */ AppLovinAd f165a;
    final /* synthetic */ Map f166b;
    final /* synthetic */ af f167c;

    an(af afVar, AppLovinAd appLovinAd, Map map) {
        this.f167c = afVar;
        this.f165a = appLovinAd;
        this.f166b = map;
    }

    public void run() {
        this.f167c.f3896f.userRewardRejected(this.f165a, this.f166b);
    }
}
