package com.inmobi.signals;

import com.inmobi.commons.core.p002b.KeyValueStore;

/* renamed from: com.inmobi.signals.a */
public class CarbDao {
    private KeyValueStore f2068a;

    public static String m2172a() {
        return KeyValueStore.m1589a("carb_store");
    }

    public CarbDao() {
        this.f2068a = KeyValueStore.m1590b("carb_store");
    }

    public long m2174b() {
        return this.f2068a.m1594b("carb_last_update_ts", 0);
    }

    public void m2173a(long j) {
        this.f2068a.m1591a("carb_last_update_ts", j);
    }
}
