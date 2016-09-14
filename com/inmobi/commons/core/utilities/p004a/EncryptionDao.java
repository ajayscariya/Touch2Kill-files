package com.inmobi.commons.core.utilities.p004a;

import com.inmobi.commons.core.p002b.KeyValueStore;

/* renamed from: com.inmobi.commons.core.utilities.a.a */
public class EncryptionDao {
    private KeyValueStore f1630a;

    public static String m1749a() {
        return KeyValueStore.m1589a("aes_key_store");
    }

    public EncryptionDao() {
        this.f1630a = KeyValueStore.m1590b("aes_key_store");
    }

    public void m1750a(String str) {
        this.f1630a.m1592a("aes_public_key", str);
        this.f1630a.m1591a("last_generated_ts", System.currentTimeMillis() / 1000);
    }

    public String m1751b() {
        return this.f1630a.m1595b("aes_public_key", null);
    }

    public long m1752c() {
        return this.f1630a.m1594b("last_generated_ts", 0);
    }
}
