package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class am implements Runnable {
    final /* synthetic */ AppLovinAd f162a;
    final /* synthetic */ Map f163b;
    final /* synthetic */ af f164c;

    am(af afVar, AppLovinAd appLovinAd, Map map) {
        this.f164c = afVar;
        this.f162a = appLovinAd;
        this.f163b = map;
    }

    public void run() {
        this.f164c.f3896f.userOverQuota(this.f162a, this.f163b);
    }
}
