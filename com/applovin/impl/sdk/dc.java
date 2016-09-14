package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

public class dc {
    private static final dc f317a;
    private final Object f318b;
    private final Map f319c;

    static {
        f317a = new dc();
    }

    private dc() {
        this.f319c = new HashMap(2);
        this.f318b = new Object();
    }

    static dc m236a() {
        return f317a;
    }

    de m237a(String str) {
        de deVar;
        synchronized (this.f318b) {
            deVar = (de) this.f319c.remove(str);
        }
        return deVar;
    }

    void m238a(String str, long j, String str2, boolean z) {
        de deVar = new de(str2, j, z, null);
        synchronized (this.f318b) {
            this.f319c.put(str, deVar);
        }
    }
}
