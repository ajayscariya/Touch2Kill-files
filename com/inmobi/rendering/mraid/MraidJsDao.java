package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.p002b.KeyValueStore;

/* renamed from: com.inmobi.rendering.mraid.i */
public class MraidJsDao {
    private KeyValueStore f2026a;

    public static String m2118a() {
        return KeyValueStore.m1589a("mraid_js_store");
    }

    public MraidJsDao() {
        this.f2026a = KeyValueStore.m1590b("mraid_js_store");
    }

    public void m2119a(String str) {
        this.f2026a.m1592a("mraid_js_string", str);
        this.f2026a.m1591a("last_updated_ts", System.currentTimeMillis() / 1000);
    }

    public String m2120b() {
        return this.f2026a.m1595b("mraid_js_string", null);
    }

    public long m2121c() {
        return this.f2026a.m1594b("last_updated_ts", 0);
    }
}
