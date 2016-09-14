package com.chartboost.sdk.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.chartboost.sdk.impl.e */
public class C1245e implements C0421o {
    private final Executor f4223a;

    /* renamed from: com.chartboost.sdk.impl.e.1 */
    class C04081 implements Executor {
        final /* synthetic */ C1245e f1089a;
        private final /* synthetic */ Handler f1090b;

        C04081(C1245e c1245e, Handler handler) {
            this.f1089a = c1245e;
            this.f1090b = handler;
        }

        public void execute(Runnable command) {
            this.f1090b.post(command);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.e.a */
    private class C0409a implements Runnable {
        final /* synthetic */ C1245e f1091a;
        private final C0415l f1092b;
        private final C0420n f1093c;
        private final Runnable f1094d;

        public C0409a(C1245e c1245e, C0415l c0415l, C0420n c0420n, Runnable runnable) {
            this.f1091a = c1245e;
            this.f1092b = c0415l;
            this.f1093c = c0420n;
            this.f1094d = runnable;
        }

        public void run() {
            if (this.f1092b.m1102h()) {
                this.f1092b.m1096b("canceled-at-delivery");
                return;
            }
            if (this.f1093c.m1131a()) {
                this.f1092b.m1095b(this.f1093c.f1137a);
            } else {
                this.f1092b.m1094b(this.f1093c.f1139c);
            }
            if (this.f1093c.f1140d) {
                this.f1092b.m1092a("intermediate-response");
            } else {
                this.f1092b.m1096b("done");
            }
            if (this.f1094d != null) {
                this.f1094d.run();
            }
        }
    }

    public C1245e(Handler handler) {
        this.f4223a = new C04081(this, handler);
    }

    public void m4702a(C0415l<?> c0415l, C0420n<?> c0420n) {
        m4703a(c0415l, c0420n, null);
    }

    public void m4703a(C0415l<?> c0415l, C0420n<?> c0420n, Runnable runnable) {
        c0415l.m1116v();
        c0415l.m1092a("post-response");
        this.f4223a.execute(new C0409a(this, c0415l, c0420n, runnable));
    }

    public void m4704a(C0415l<?> c0415l, C0423s c0423s) {
        c0415l.m1092a("post-error");
        this.f4223a.execute(new C0409a(this, c0415l, C0420n.m1129a(c0423s), null));
    }
}
