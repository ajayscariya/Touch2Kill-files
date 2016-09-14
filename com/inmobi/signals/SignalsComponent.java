package com.inmobi.signals;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent.ConfigComponent;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.SessionInfo;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.signals.SignalsConfig.SignalsConfig;

/* renamed from: com.inmobi.signals.p */
public class SignalsComponent implements ConfigComponent {
    private static final String f4496a;
    private static final Object f4497b;
    private static volatile SignalsComponent f4498c;
    private IceCollector f4499d;
    private CarbWorker f4500e;
    private SignalsConfig f4501f;
    private boolean f4502g;

    static {
        f4496a = SignalsComponent.class.getSimpleName();
        f4497b = new Object();
    }

    public static SignalsComponent m5202a() {
        SignalsComponent signalsComponent = f4498c;
        if (signalsComponent == null) {
            synchronized (f4497b) {
                signalsComponent = f4498c;
                if (signalsComponent == null) {
                    signalsComponent = new SignalsComponent();
                    f4498c = signalsComponent;
                }
            }
        }
        return signalsComponent;
    }

    private SignalsComponent() {
        this.f4502g = false;
        this.f4501f = new SignalsConfig();
        com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(this.f4501f, (ConfigComponent) this);
        SessionInfo.m1829a().m1833a(m5207e().m2373i());
        LocationInfo.m2285a().m2295a(m5207e().m2372h());
        TelemetryComponent.m5070a().m5093a(this.f4501f.m5213a(), this.f4501f.m5218e());
    }

    public void m5203a(Config config) {
        this.f4501f = (SignalsConfig) config;
        LocationInfo.m2285a().m2295a(m5207e().m2372h());
        SessionInfo.m1829a().m1833a(m5207e().m2373i());
        TelemetryComponent.m5070a().m5093a(this.f4501f.m5213a(), this.f4501f.m5218e());
    }

    public synchronized void m5204b() {
        if (!this.f4502g) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "Starting signals component.");
            this.f4502g = true;
            m5209g();
        }
    }

    public synchronized void m5205c() {
        if (this.f4502g) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "Stopping signals component.");
            this.f4502g = false;
            m5210h();
        }
    }

    UidMap m5206d() {
        return new UidMap(this.f4501f.m1654n().m1648a());
    }

    public SignalsConfig m5207e() {
        return this.f4501f.m5219f();
    }

    public SignalsConfig m5208f() {
        return this.f4501f.m5220g();
    }

    synchronized void m5209g() {
        if (!this.f4502g) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "Ice can not be started as Signals component has not been started.");
        } else if (m5207e().m2365a()) {
            SessionManager.m2299a().m2300b();
            if (this.f4499d == null) {
                this.f4499d = new IceCollector();
                this.f4499d.m2265a();
            } else {
                this.f4499d.m2265a();
            }
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "User data collection is disabled.");
        }
    }

    void m5210h() {
        SessionManager.m2299a().m2301c();
        if (this.f4499d != null) {
            this.f4499d.m2267c();
        }
    }

    public void m5211i() {
        if (!this.f4502g) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "Carb can not be started as Signals component has not been started.");
        } else if (!m5208f().m2319a()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4496a, "Carb is disabled.");
        } else if (this.f4500e == null) {
            this.f4500e = new CarbWorker();
            this.f4500e.m2250a(m5208f());
        } else {
            this.f4500e.m2250a(m5208f());
        }
    }
}
