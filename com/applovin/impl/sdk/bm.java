package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.HashMap;
import java.util.Map;

public class bm {
    private static bm f207d;
    private final Map f208a;
    private final Map f209b;
    private final Object f210c;

    private bm() {
        this.f208a = new HashMap(1);
        this.f209b = new HashMap(1);
        this.f210c = new Object();
    }

    public static synchronized bm m121a() {
        bm bmVar;
        synchronized (bm.class) {
            if (f207d == null) {
                f207d = new bm();
            }
            bmVar = f207d;
        }
        return bmVar;
    }

    public Map m122a(AppLovinAd appLovinAd) {
        Map map;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f210c) {
            map = (Map) this.f209b.remove(appLovinAdImpl);
        }
        return map;
    }

    public void m123a(AppLovinAd appLovinAd, String str) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f210c) {
            this.f208a.put(appLovinAdImpl, str);
        }
    }

    public void m124a(AppLovinAd appLovinAd, Map map) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f210c) {
            this.f209b.put(appLovinAdImpl, map);
        }
    }

    public String m125b(AppLovinAd appLovinAd) {
        String str;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f210c) {
            str = (String) this.f208a.remove(appLovinAdImpl);
        }
        return str;
    }
}
