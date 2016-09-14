package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.i */
class C0235i {
    final AppLovinAdSize f326a;
    final Object f327b;
    AppLovinAd f328c;
    long f329d;
    boolean f330e;
    private final Collection f331f;
    private final Collection f332g;

    private C0235i(AppLovinAdSize appLovinAdSize) {
        this.f331f = new HashSet();
        this.f332g = new HashSet();
        this.f326a = appLovinAdSize;
        this.f327b = new Object();
        this.f328c = null;
        this.f329d = 0;
        this.f330e = false;
    }
}
