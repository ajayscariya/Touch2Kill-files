package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

class bs {
    private final int f221a;
    private final Queue f222b;
    private final Object f223c;

    bs(int i) {
        if (i > 10) {
            i = 10;
        }
        this.f221a = i;
        this.f222b = new LinkedList();
        this.f223c = new Object();
    }

    int m145a() {
        int size;
        synchronized (this.f223c) {
            size = this.f222b.size();
        }
        return size;
    }

    void m146a(az azVar) {
        synchronized (this.f223c) {
            if (!m148c()) {
                this.f222b.offer(azVar);
            }
        }
    }

    int m147b() {
        return this.f221a;
    }

    boolean m148c() {
        boolean z;
        synchronized (this.f223c) {
            z = m145a() >= this.f221a;
        }
        return z;
    }

    boolean m149d() {
        boolean z;
        synchronized (this.f223c) {
            z = m145a() == 0;
        }
        return z;
    }

    az m150e() {
        try {
            az azVar;
            synchronized (this.f223c) {
                azVar = !m149d() ? (az) this.f222b.poll() : null;
            }
            return azVar;
        } catch (Exception e) {
            return null;
        }
    }
}
