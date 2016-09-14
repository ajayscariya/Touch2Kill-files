package com.chartboost.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ax {
    private static ExecutorService f836a;
    private static ThreadFactory f837b;

    /* renamed from: com.chartboost.sdk.impl.ax.1 */
    static class C03441 implements ThreadFactory {
        private final AtomicInteger f835a;

        C03441() {
            this.f835a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable r) {
            return new Thread(r, "Chartboost Thread #" + this.f835a.getAndIncrement());
        }
    }

    static {
        f836a = null;
        f837b = null;
    }

    public static ExecutorService m845a() {
        if (f837b == null) {
            f837b = new C03441();
        }
        if (f836a == null) {
            f836a = Executors.newFixedThreadPool(5, f837b);
        }
        return f836a;
    }
}
