package com.inmobi.commons.core.p002b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.p000a.SdkContext;
import java.util.HashMap;

/* renamed from: com.inmobi.commons.core.b.c */
public final class KeyValueStore {
    private static HashMap<String, KeyValueStore> f1531a;
    private static final Object f1532b;
    private SharedPreferences f1533c;

    static {
        f1531a = new HashMap();
        f1532b = new Object();
    }

    private KeyValueStore(Context context, String str) {
        this.f1533c = context.getSharedPreferences(str, 0);
    }

    public static String m1589a(String str) {
        return "com.im.keyValueStore." + str;
    }

    public static KeyValueStore m1588a(Context context, String str) {
        String a = KeyValueStore.m1589a(str);
        if (f1531a.containsKey(a)) {
            return (KeyValueStore) f1531a.get(a);
        }
        synchronized (f1532b) {
            if (f1531a.containsKey(a)) {
                KeyValueStore keyValueStore = (KeyValueStore) f1531a.get(a);
                return keyValueStore;
            }
            keyValueStore = new KeyValueStore(context, a);
            f1531a.put(a, keyValueStore);
            return keyValueStore;
        }
    }

    public static KeyValueStore m1590b(String str) {
        return KeyValueStore.m1588a(SdkContext.m1562b(), str);
    }

    public void m1592a(String str, String str2) {
        Editor edit = this.f1533c.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String m1595b(String str, String str2) {
        return this.f1533c.getString(str, str2);
    }

    public void m1591a(String str, long j) {
        Editor edit = this.f1533c.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public long m1594b(String str, long j) {
        return this.f1533c.getLong(str, j);
    }

    public void m1593a(String str, boolean z) {
        Editor edit = this.f1533c.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean m1596b(String str, boolean z) {
        return this.f1533c.getBoolean(str, z);
    }
}
