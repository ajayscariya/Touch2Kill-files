package com.chartboost.sdk.impl;

import android.os.Process;
import com.chartboost.sdk.impl.C0350b.C0349a;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.chartboost.sdk.impl.c */
public class C0407c extends Thread {
    private static final boolean f1083a;
    private final BlockingQueue<C0415l<?>> f1084b;
    private final BlockingQueue<C0415l<?>> f1085c;
    private final C0350b f1086d;
    private final C0421o f1087e;
    private volatile boolean f1088f;

    /* renamed from: com.chartboost.sdk.impl.c.1 */
    class C04061 implements Runnable {
        final /* synthetic */ C0407c f1081a;
        private final /* synthetic */ C0415l f1082b;

        C04061(C0407c c0407c, C0415l c0415l) {
            this.f1081a = c0407c;
            this.f1082b = c0415l;
        }

        public void run() {
            try {
                this.f1081a.f1085c.put(this.f1082b);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        f1083a = C0426t.f1149b;
    }

    public C0407c(BlockingQueue<C0415l<?>> blockingQueue, BlockingQueue<C0415l<?>> blockingQueue2, C0350b c0350b, C0421o c0421o) {
        this.f1088f = false;
        this.f1084b = blockingQueue;
        this.f1085c = blockingQueue2;
        this.f1086d = c0350b;
        this.f1087e = c0421o;
    }

    public void m1075a() {
        this.f1088f = true;
        interrupt();
    }

    public void run() {
        if (f1083a) {
            C0426t.m1141a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f1086d.m899a();
        while (true) {
            try {
                C0415l c0415l = (C0415l) this.f1084b.take();
                c0415l.m1092a("cache-queue-take");
                if (c0415l.m1102h()) {
                    c0415l.m1096b("cache-discard-canceled");
                } else {
                    C0349a a = this.f1086d.m898a(c0415l.m1099e());
                    if (a == null) {
                        c0415l.m1092a("cache-miss");
                        this.f1085c.put(c0415l);
                    } else if (a.m896a()) {
                        c0415l.m1092a("cache-hit-expired");
                        c0415l.m1086a(a);
                        this.f1085c.put(c0415l);
                    } else {
                        c0415l.m1092a("cache-hit");
                        C0420n a2 = c0415l.m1090a(new C0412i(a.f891a, a.f896f));
                        c0415l.m1092a("cache-hit-parsed");
                        if (a.m897b()) {
                            c0415l.m1092a("cache-hit-refresh-needed");
                            c0415l.m1086a(a);
                            a2.f1140d = true;
                            this.f1087e.m1133a(c0415l, a2, new C04061(this, c0415l));
                        } else {
                            this.f1087e.m1132a(c0415l, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f1088f) {
                    return;
                }
            }
        }
    }
}
