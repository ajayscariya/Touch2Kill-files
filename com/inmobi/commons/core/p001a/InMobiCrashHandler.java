package com.inmobi.commons.core.p001a;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent.ConfigComponent;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.inmobi.commons.core.a.c */
public class InMobiCrashHandler implements UncaughtExceptionHandler {
    private static final String f1521b;
    private static boolean f1522c;
    private static InMobiCrashHandler f1523d;
    private UncaughtExceptionHandler f1524a;

    /* renamed from: com.inmobi.commons.core.a.c.a */
    static class InMobiCrashHandler implements ConfigComponent {
        InMobiCrashHandler() {
        }

        public void m5068a(Config config) {
            TelemetryComponent.m5070a().m5093a(config.m1649a(), ((CrashConfig) config).m5067e());
        }
    }

    static {
        f1521b = InMobiCrashHandler.class.getSimpleName();
        f1522c = false;
    }

    private InMobiCrashHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1524a = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (m1578a(th)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1521b, "Crash due to inmobi, will report it");
            TelemetryComponent.m5070a().m5090a(new CrashEvent(thread, th));
        }
        this.f1524a.uncaughtException(thread, th);
    }

    private boolean m1578a(Throwable th) {
        for (StackTraceElement className : th.getStackTrace()) {
            if (className.getClassName().contains("com.inmobi.")) {
                return true;
            }
        }
        return false;
    }

    public static synchronized void m1577a() {
        synchronized (InMobiCrashHandler.class) {
            if (!f1522c) {
                Config crashConfig = new CrashConfig();
                f1523d = new InMobiCrashHandler();
                com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(crashConfig, f1523d);
                TelemetryComponent.m5070a().m5093a(crashConfig.m5062a(), crashConfig.m5067e());
                Thread.setDefaultUncaughtExceptionHandler(new InMobiCrashHandler(Thread.getDefaultUncaughtExceptionHandler()));
                f1522c = true;
            }
        }
    }
}
