package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.SessionInfo;
import java.util.UUID;

/* renamed from: com.inmobi.signals.o */
public class SessionManager {
    private static final String f2136a;
    private static SessionManager f2137b;
    private static Object f2138c;

    static {
        f2136a = SessionManager.class.getSimpleName();
        f2138c = new Object();
    }

    public static SessionManager m2299a() {
        SessionManager sessionManager = f2137b;
        if (sessionManager == null) {
            synchronized (f2138c) {
                sessionManager = f2137b;
                if (sessionManager == null) {
                    f2137b = new SessionManager();
                    sessionManager = f2137b;
                }
            }
        }
        return sessionManager;
    }

    private SessionManager() {
    }

    void m2300b() {
        if (SignalsComponent.m5202a().m5207e().m2373i()) {
            SessionInfo.m1829a().m1832a(UUID.randomUUID().toString());
            SessionInfo.m1829a().m1831a(System.currentTimeMillis());
            SessionInfo.m1829a().m1835b(0);
            Logger.m1744a(InternalLogLevel.INTERNAL, f2136a, "Session tracking started.");
        }
    }

    void m2301c() {
        if (SignalsComponent.m5202a().m5207e().m2373i()) {
            SessionInfo.m1829a().m1835b(System.currentTimeMillis());
            Logger.m1744a(InternalLogLevel.INTERNAL, f2136a, "Session tracking stopped.");
        }
    }

    SessionInfo m2302d() {
        return SessionInfo.m1829a();
    }
}
