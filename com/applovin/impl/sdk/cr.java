package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class cr {
    private final AppLovinSdkImpl f301a;
    private final AppLovinLogger f302b;
    private final ScheduledExecutorService f303c;
    private final ScheduledExecutorService f304d;
    private final ScheduledExecutorService f305e;

    cr(AppLovinSdkImpl appLovinSdkImpl) {
        this.f301a = appLovinSdkImpl;
        this.f303c = m232a("main");
        this.f304d = m232a("back");
        this.f305e = m232a("postbacks");
        this.f302b = appLovinSdkImpl.getLogger();
    }

    private static void m230a(Runnable runnable, long j, ScheduledExecutorService scheduledExecutorService) {
        if (j > 0) {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.submit(runnable);
        }
    }

    ScheduledExecutorService m232a(String str) {
        return Executors.newScheduledThreadPool(1, new ct(this, str));
    }

    void m233a(bw bwVar, cs csVar) {
        m234a(bwVar, csVar, 0);
    }

    void m234a(bw bwVar, cs csVar, long j) {
        if (bwVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            throw new IllegalArgumentException("Invalid delay specified: " + j);
        } else {
            this.f302b.m306d(bwVar.f228e, "Scheduling " + bwVar.f228e + " on " + csVar + " queue in " + j + "ms.");
            Runnable cvVar = new cv(this, bwVar, csVar);
            if (csVar == cs.MAIN) {
                m230a(cvVar, j, this.f303c);
            } else if (csVar == cs.BACKGROUND) {
                m230a(cvVar, j, this.f304d);
            } else if (csVar == cs.POSTBACKS) {
                m230a(cvVar, j, this.f305e);
            }
        }
    }

    void m235a(cq cqVar, long j) {
        if (cqVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        m230a((Runnable) cqVar, j, this.f303c);
    }
}
