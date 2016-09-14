package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.chartboost.sdk.impl.m */
public class C0417m {
    private AtomicInteger f1126a;
    private final Map<String, Queue<C0415l<?>>> f1127b;
    private final Set<C0415l<?>> f1128c;
    private final PriorityBlockingQueue<C0415l<?>> f1129d;
    private final PriorityBlockingQueue<C0415l<?>> f1130e;
    private final C0350b f1131f;
    private final C0410f f1132g;
    private final C0421o f1133h;
    private C0411g[] f1134i;
    private C0407c f1135j;
    private boolean f1136k;

    /* renamed from: com.chartboost.sdk.impl.m.a */
    public interface C0416a {
        boolean m1118a(C0415l<?> c0415l);
    }

    /* renamed from: com.chartboost.sdk.impl.m.1 */
    class C12481 implements C0416a {
        final /* synthetic */ C0417m f4224a;
        private final /* synthetic */ Object f4225b;

        C12481(C0417m c0417m, Object obj) {
            this.f4224a = c0417m;
            this.f4225b = obj;
        }

        public boolean m4705a(C0415l<?> c0415l) {
            return c0415l.m1093b() == this.f4225b;
        }
    }

    public C0417m(C0350b c0350b, C0410f c0410f, int i, C0421o c0421o) {
        this.f1126a = new AtomicInteger();
        this.f1127b = new HashMap();
        this.f1128c = new HashSet();
        this.f1129d = new PriorityBlockingQueue();
        this.f1130e = new PriorityBlockingQueue();
        this.f1136k = false;
        this.f1131f = c0350b;
        this.f1132g = c0410f;
        this.f1134i = new C0411g[i];
        this.f1133h = c0421o;
    }

    public C0417m(C0350b c0350b, C0410f c0410f, int i) {
        this(c0350b, c0410f, i, new C1245e(new Handler(Looper.getMainLooper())));
    }

    public C0417m(C0350b c0350b, C0410f c0410f) {
        this(c0350b, c0410f, 4);
    }

    public void m1120a() {
        m1124b();
        this.f1135j = new C0407c(this.f1129d, this.f1130e, this.f1131f, this.f1133h);
        this.f1135j.start();
        m1123a(true);
        for (int i = 0; i < this.f1134i.length; i++) {
            C0411g c0411g = new C0411g(this.f1130e, this.f1132g, this.f1131f, this.f1133h);
            this.f1134i[i] = c0411g;
            c0411g.start();
        }
    }

    public void m1124b() {
        int i = 0;
        m1123a(false);
        if (this.f1135j != null) {
            this.f1135j.m1075a();
        }
        while (i < this.f1134i.length) {
            if (this.f1134i[i] != null) {
                this.f1134i[i].m1079a();
            }
            i++;
        }
    }

    public int m1126c() {
        return this.f1126a.incrementAndGet();
    }

    public void m1121a(C0416a c0416a) {
        synchronized (this.f1128c) {
            for (C0415l c0415l : this.f1128c) {
                if (c0416a.m1118a(c0415l)) {
                    c0415l.m1101g();
                }
            }
        }
    }

    public void m1122a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        m1121a(new C12481(this, obj));
    }

    public <T> C0415l<T> m1119a(C0415l<T> c0415l) {
        c0415l.m1087a(this);
        synchronized (this.f1128c) {
            this.f1128c.add(c0415l);
        }
        c0415l.m1085a(m1126c());
        c0415l.m1092a("add-to-queue");
        if (c0415l.m1112r()) {
            synchronized (this.f1127b) {
                String e = c0415l.m1099e();
                if (this.f1127b.containsKey(e)) {
                    Queue queue = (Queue) this.f1127b.get(e);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(c0415l);
                    this.f1127b.put(e, queue);
                    if (C0426t.f1149b) {
                        C0426t.m1141a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f1127b.put(e, null);
                    this.f1129d.add(c0415l);
                }
            }
        } else {
            this.f1130e.add(c0415l);
        }
        return c0415l;
    }

    void m1125b(C0415l<?> c0415l) {
        synchronized (this.f1128c) {
            this.f1128c.remove(c0415l);
        }
        if (c0415l.m1112r()) {
            synchronized (this.f1127b) {
                Queue queue = (Queue) this.f1127b.remove(c0415l.m1099e());
                if (queue != null) {
                    if (C0426t.f1149b) {
                        C0426t.m1141a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f1129d.addAll(queue);
                }
            }
        }
    }

    public boolean m1123a(boolean z) {
        this.f1136k = z;
        return z;
    }
}
