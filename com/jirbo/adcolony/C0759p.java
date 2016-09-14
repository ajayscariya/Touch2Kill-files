package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;
import com.jirbo.adcolony.C0756n.ad;
import java.util.Iterator;

/* renamed from: com.jirbo.adcolony.p */
class C0759p implements Runnable {
    public static final int f2936a = 5;
    public static final int f2937b = 10;
    static String f2938c;
    static volatile C0759p f2939d;
    static volatile long f2940e;
    long f2941f;

    /* renamed from: com.jirbo.adcolony.p.a */
    static class C0758a extends Handler {
        C0758a() {
            C0694a.f2379s = true;
            sendMessageDelayed(obtainMessage(), 1000);
        }

        public void handleMessage(Message m) {
            if (C0694a.f2350P == null || C0694a.m2452b().isFinishing()) {
                C0694a.m2454b("Monitor pinger exiting.");
                C0694a.f2379s = false;
                return;
            }
            if (!C0694a.f2378r) {
                C0759p.m2784a();
            }
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    C0759p() {
    }

    static {
        f2938c = "MONITOR_MUTEX";
    }

    static void m2784a() {
        synchronized (f2938c) {
            f2940e = System.currentTimeMillis();
            if (f2939d == null) {
                C0694a.m2454b("Creating ADC Monitor singleton.");
                f2939d = new C0759p();
                new Thread(f2939d).start();
            }
        }
    }

    public void run() {
        C0694a.m2440a(C0694a.f2374n);
        C0726l.f2610a.m2657b((Object) "ADC Monitor Started.");
        C0694a.f2372l.m2562b();
        Object obj = null;
        while (C0694a.f2350P != null && !AdColony.activity().isFinishing()) {
            long j;
            Object obj2;
            long currentTimeMillis = System.currentTimeMillis();
            C0694a.f2386z = false;
            C0694a.f2372l.m2577g();
            if (C0694a.f2386z) {
                j = 50;
            } else {
                j = (long) (obj != null ? 2000 : 250);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = (int) ((currentTimeMillis2 - f2940e) / 1000);
            C0694a.f2372l.m2577g();
            if (obj == null) {
                if (i >= f2936a) {
                    C0694a.m2454b("AdColony is idle.");
                    obj = 1;
                    C0694a.f2372l.m2568c();
                }
                obj2 = obj;
            } else if (i >= f2937b) {
                break;
            } else {
                if (i < f2936a) {
                    C0694a.f2372l.m2562b();
                    C0694a.m2454b("AdColony is active.");
                    obj2 = null;
                }
                obj2 = obj;
            }
            if (C0760q.m2793c()) {
                if (!C0694a.f2346L) {
                    C0694a.m2467h();
                }
                C0694a.f2346L = true;
            } else {
                if (C0694a.f2346L) {
                    C0694a.m2467h();
                }
                C0694a.f2346L = false;
            }
            if (!(C0694a.f2372l.f2513b.f4599i == null || C0694a.f2372l.f2513b.f4599i.f2749n == null)) {
                C0694a.f2372l.f2513b.f4599i.f2749n.m2717a();
            }
            m2785a(j);
            j = System.currentTimeMillis();
            if (j - currentTimeMillis <= 3000 && j - currentTimeMillis > 0) {
                C0763u c0763u = C0694a.f2372l.f2516e;
                c0763u.f2969i = (((double) (j - currentTimeMillis)) / 1000.0d) + c0763u.f2969i;
                if (C0694a.f2350P != null && currentTimeMillis2 - this.f2941f > 1000) {
                    this.f2941f = System.currentTimeMillis();
                    Iterator it = C0694a.f2372l.f2513b.f4599i.f2749n.f2701a.iterator();
                    while (it.hasNext()) {
                        ad adVar = (ad) it.next();
                        if ((adVar.m2694a() && adVar.f2691q != 0 && System.currentTimeMillis() - adVar.f2691q > adVar.f2690p) || (adVar.f2691q != 0 && System.currentTimeMillis() - adVar.f2691q > adVar.f2689o)) {
                            if (!(C0694a.f2350P == null || C0694a.f2376p)) {
                                C0694a.f2372l.f2513b.m5316a(C0694a.f2350P);
                                C0694a.f2376p = true;
                            }
                        }
                    }
                }
            }
            obj = obj2;
        }
        synchronized (f2938c) {
            f2939d = null;
        }
        if (obj == null) {
            C0694a.f2372l.m2568c();
        }
        if (C0694a.f2350P != null && AdColony.activity().isFinishing()) {
            C0694a.f2335A = true;
            m2785a(5000);
            if (C0694a.f2335A) {
                C0726l.f2612c.m2657b((Object) "ADC.finishing, controller on_stop");
                C0694a.f2372l.m2571d();
                C0766z.m2815a();
            }
            m2785a(5000);
            if (C0694a.f2335A) {
                C0726l.f2612c.m2657b((Object) "Releasing Activity reference");
                C0694a.f2350P = null;
                C0694a.m2467h();
            }
        }
        System.out.println("Exiting monitor");
    }

    void m2785a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
    }
}
