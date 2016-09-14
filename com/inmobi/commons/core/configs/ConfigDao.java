package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.p002b.KeyValueStore;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.c */
public class ConfigDao {
    private KeyValueStore f1582a;

    public static String m1672a() {
        return KeyValueStore.m1589a("config_store");
    }

    public ConfigDao() {
        this.f1582a = KeyValueStore.m1590b("config_store");
    }

    public void m1673a(Config config) {
        try {
            this.f1582a.m1592a(config.m1649a() + "_config", config.m1651b().toString());
            m1674a(config.m1649a(), System.currentTimeMillis());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void m1677b(Config config) {
        String b = this.f1582a.m1595b(config.m1649a() + "_config", null);
        if (b != null) {
            try {
                config.m1650a(new JSONObject(b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean m1675a(String str) {
        return this.f1582a.m1595b(new StringBuilder().append(str).append("_config").toString(), null) != null;
    }

    public long m1676b(String str) {
        return this.f1582a.m1594b(str + "_config_update_ts", 0);
    }

    public void m1674a(String str, long j) {
        this.f1582a.m1591a(str + "_config_update_ts", j);
    }
}
