package com.chartboost.sdk.impl;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.chartboost.sdk.impl.g */
public class C0411g extends Thread {
    private final BlockingQueue<C0415l<?>> f1095a;
    private final C0410f f1096b;
    private final C0350b f1097c;
    private final C0421o f1098d;
    private volatile boolean f1099e;

    public C0411g(BlockingQueue<C0415l<?>> blockingQueue, C0410f c0410f, C0350b c0350b, C0421o c0421o) {
        this.f1099e = false;
        this.f1095a = blockingQueue;
        this.f1096b = c0410f;
        this.f1097c = c0350b;
        this.f1098d = c0421o;
    }

    public void m1079a() {
        this.f1099e = true;
        interrupt();
    }

    @TargetApi(14)
    private void m1077a(C0415l<?> c0415l) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(c0415l.m1097c());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                C0415l c0415l = (C0415l) this.f1095a.take();
                try {
                    c0415l.m1092a("network-queue-take");
                    if (c0415l.m1102h()) {
                        c0415l.m1096b("network-discard-cancelled");
                    } else {
                        m1077a(c0415l);
                        C0412i a = this.f1096b.m1076a(c0415l);
                        c0415l.m1092a("network-http-complete");
                        if (a.f1103d && c0415l.m1117w()) {
                            c0415l.m1096b("not-modified");
                        } else {
                            C0420n a2 = c0415l.m1090a(a);
                            c0415l.m1092a("network-parse-complete");
                            if (c0415l.m1112r() && a2.f1138b != null) {
                                this.f1097c.m900a(c0415l.m1099e(), a2.f1138b);
                                c0415l.m1092a("network-cache-written");
                            }
                            c0415l.m1116v();
                            this.f1098d.m1132a(c0415l, a2);
                        }
                    }
                } catch (C0423s e) {
                    m1078a(c0415l, e);
                } catch (Throwable e2) {
                    C0426t.m1142a(e2, "Unhandled exception %s", e2.toString());
                    this.f1098d.m1134a(c0415l, new C0423s(e2));
                }
            } catch (InterruptedException e3) {
                if (this.f1099e) {
                    return;
                }
            }
        }
    }

    private void m1078a(C0415l<?> c0415l, C0423s c0423s) {
        this.f1098d.m1134a((C0415l) c0415l, c0415l.m1091a(c0423s));
    }
}
