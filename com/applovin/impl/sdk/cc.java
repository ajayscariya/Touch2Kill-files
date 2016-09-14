package com.applovin.impl.sdk;

import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class cc {
    private final AppLovinSdkImpl f295a;
    private final Map f296b;

    cc(AppLovinSdkImpl appLovinSdkImpl) {
        this.f296b = new HashMap();
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f295a = appLovinSdkImpl;
    }

    void m215a() {
        synchronized (this.f296b) {
            this.f296b.clear();
        }
        m223d();
    }

    void m216a(String str) {
        m217a(str, 1);
    }

    void m217a(String str, long j) {
        synchronized (this.f296b) {
            Long l = (Long) this.f296b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            this.f296b.put(str, Long.valueOf(l.longValue() + j));
        }
        m223d();
    }

    long m218b(String str) {
        long longValue;
        synchronized (this.f296b) {
            Long l = (Long) this.f296b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    JSONObject m219b() {
        JSONObject jSONObject;
        synchronized (this.f296b) {
            jSONObject = new JSONObject();
            for (Entry entry : this.f296b.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    void m220b(String str, long j) {
        synchronized (this.f296b) {
            this.f296b.put(str, Long.valueOf(j));
        }
        m223d();
    }

    void m221c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f295a.getSettingsManager().m168a().getString("stats", "{}"));
            synchronized (this.f296b) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str = (String) keys.next();
                        this.f296b.put(str, Long.valueOf(jSONObject.getLong(str)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f295a.getLogger().m308e("StatsManager", "Unable to load stats", th);
        }
    }

    void m222c(String str) {
        synchronized (this.f296b) {
            this.f296b.remove(str);
        }
        m223d();
    }

    void m223d() {
        try {
            Editor edit = this.f295a.getSettingsManager().m168a().edit();
            edit.putString("stats", m219b().toString());
            edit.commit();
        } catch (Throwable e) {
            this.f295a.getLogger().m308e("StatsManager", "Unable to save stats", e);
        }
    }
}
