package com.inmobi.signals.p007b;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.b.a */
public class WifiInfo {
    private static final String f2081a;
    private long f2082b;
    private String f2083c;
    private int f2084d;
    private int f2085e;

    static {
        f2081a = WifiInfo.class.getSimpleName();
    }

    public void m2197a(long j) {
        this.f2082b = j;
    }

    public void m2198a(String str) {
        this.f2083c = str;
    }

    public void m2196a(int i) {
        this.f2084d = i;
    }

    public void m2200b(int i) {
        this.f2085e = i;
    }

    public long m2195a() {
        return this.f2082b;
    }

    public JSONObject m2199b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", this.f2082b);
            jSONObject.put("essid", this.f2083c);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2081a, "Error while converting WifiInfo to string.", e);
        }
        return jSONObject;
    }
}
