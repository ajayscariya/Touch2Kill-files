package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.jirbo.adcolony.z */
class C0766z {
    static String f2981a;
    static ArrayList<C0765a> f2982b;
    static ArrayList<C0765a> f2983c;
    static ArrayList<Runnable> f2984d;
    static ArrayList<Runnable> f2985e;
    static volatile boolean f2986f;

    /* renamed from: com.jirbo.adcolony.z.a */
    static class C0765a extends Thread {
        Runnable f2980a;

        C0765a() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
        L_0x0000:
            r0 = r3.f2980a;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r3.f2980a;	 Catch:{ RuntimeException -> 0x0011 }
            r0.run();	 Catch:{ RuntimeException -> 0x0011 }
        L_0x0009:
            r0 = 0;
            r3.f2980a = r0;
        L_0x000c:
            r0 = com.jirbo.adcolony.C0766z.f2986f;
            if (r0 == 0) goto L_0x0031;
        L_0x0010:
            return;
        L_0x0011:
            r0 = move-exception;
            r1 = "Exception caught in reusable thread.";
            com.jirbo.adcolony.C0694a.m2461e(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r1 = r1.append(r0);
            r2 = "";
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.jirbo.adcolony.C0694a.m2461e(r1);
            r0.printStackTrace();
            goto L_0x0009;
        L_0x0031:
            monitor-enter(r3);
            r1 = com.jirbo.adcolony.C0766z.f2981a;	 Catch:{ all -> 0x0040 }
            monitor-enter(r1);	 Catch:{ all -> 0x0040 }
            r0 = com.jirbo.adcolony.C0766z.f2982b;	 Catch:{ all -> 0x0043 }
            r0.add(r3);	 Catch:{ all -> 0x0043 }
            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
            r3.wait();	 Catch:{ InterruptedException -> 0x0046 }
        L_0x003e:
            monitor-exit(r3);	 Catch:{ all -> 0x0040 }
            goto L_0x0000;
        L_0x0040:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0040 }
            throw r0;
        L_0x0043:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0043 }
            throw r0;	 Catch:{ all -> 0x0040 }
        L_0x0046:
            r0 = move-exception;
            goto L_0x003e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jirbo.adcolony.z.a.run():void");
        }
    }

    C0766z() {
    }

    static {
        f2981a = new String("mutex");
        f2982b = new ArrayList();
        f2983c = new ArrayList();
        f2984d = new ArrayList();
        f2985e = new ArrayList();
    }

    static void m2815a() {
        C0766z.m2818c();
        synchronized (f2981a) {
            f2984d.clear();
        }
        C0766z.m2817b();
    }

    static void m2816a(Runnable runnable) {
        synchronized (f2981a) {
            if (f2986f) {
                f2984d.add(runnable);
                return;
            }
            if (null == null) {
                new Thread(runnable).start();
            }
        }
    }

    static void m2817b() {
        synchronized (f2981a) {
            f2986f = false;
            f2985e.clear();
            f2985e.addAll(f2984d);
            f2984d.clear();
            f2983c.clear();
        }
        Iterator it = f2985e.iterator();
        while (it.hasNext()) {
            C0766z.m2816a((Runnable) it.next());
        }
    }

    static void m2818c() {
        synchronized (f2981a) {
            f2986f = true;
            Iterator it = f2982b.iterator();
            while (it.hasNext()) {
                C0765a c0765a = (C0765a) it.next();
                synchronized (c0765a) {
                    c0765a.notify();
                }
            }
            synchronized (f2981a) {
                f2982b.clear();
            }
        }
    }
}
