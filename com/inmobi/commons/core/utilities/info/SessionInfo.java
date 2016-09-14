package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.utilities.info.f */
public class SessionInfo {
    private static final String f1680a;
    private static SessionInfo f1681b;
    private static Object f1682c;
    private String f1683d;
    private long f1684e;
    private long f1685f;
    private boolean f1686g;

    static {
        f1680a = SessionInfo.class.getSimpleName();
        f1682c = new Object();
    }

    public static SessionInfo m1829a() {
        SessionInfo sessionInfo = f1681b;
        if (sessionInfo == null) {
            synchronized (f1682c) {
                sessionInfo = f1681b;
                if (sessionInfo == null) {
                    f1681b = new SessionInfo();
                    sessionInfo = f1681b;
                }
            }
        }
        return sessionInfo;
    }

    private SessionInfo() {
    }

    public void m1832a(String str) {
        this.f1683d = str;
    }

    public void m1831a(long j) {
        this.f1684e = j;
    }

    public void m1835b(long j) {
        this.f1685f = j;
    }

    public JSONObject m1834b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", this.f1683d);
            jSONObject.put("s-ts", this.f1684e);
            jSONObject.put("e-ts", this.f1685f);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1680a, "Problem converting session object to Json.", e);
        }
        return jSONObject;
    }

    public void m1833a(boolean z) {
        this.f1686g = z;
        if (!this.f1686g) {
            m1830d();
        }
    }

    private void m1830d() {
        this.f1683d = null;
        this.f1684e = 0;
        this.f1685f = 0;
    }

    public HashMap<String, String> m1836c() {
        HashMap<String, String> hashMap = new HashMap();
        if (this.f1686g && this.f1683d != null) {
            hashMap.put("u-s-id", this.f1683d);
        }
        return hashMap;
    }
}
