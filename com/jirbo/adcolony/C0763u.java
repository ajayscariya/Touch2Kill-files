package com.jirbo.adcolony;

import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;

/* renamed from: com.jirbo.adcolony.u */
class C0763u {
    C0711d f2961a;
    boolean f2962b;
    boolean f2963c;
    boolean f2964d;
    boolean f2965e;
    boolean f2966f;
    double f2967g;
    double f2968h;
    double f2969i;
    int f2970j;
    String f2971k;

    C0763u(C0711d c0711d) {
        this.f2964d = false;
        this.f2965e = false;
        this.f2966f = true;
        this.f2971k = "uuid";
        this.f2961a = c0711d;
        this.f2971k = aa.m2481b();
    }

    void m2805a() {
    }

    void m2807b() {
        if (this.f2961a.f2513b.f4592b) {
            if (this.f2964d) {
                this.f2964d = false;
                this.f2961a.f2515d.m5352a("install", null);
            }
            if (this.f2965e) {
                this.f2965e = false;
                this.f2961a.f2515d.m5352a("session_start", null);
            }
        }
    }

    void m2808c() {
        C0726l.f2611b.m2657b((Object) "AdColony resuming");
        C0694a.f2386z = true;
        if (this.f2962b) {
            C0726l.f2613d.m2657b((Object) "AdColony.onResume() called multiple times in succession.");
        }
        this.f2962b = true;
        m2812g();
        double c = aa.m2483c();
        if (this.f2963c) {
            if (c - this.f2968h > ((double) this.f2961a.f2512a.f2487d)) {
                m2806a(this.f2969i);
                this.f2967g = c;
                m2813h();
            }
            this.f2963c = false;
            m2811f();
        } else {
            this.f2967g = c;
            m2813h();
        }
        C0694a.m2467h();
    }

    void m2809d() {
        C0726l.f2611b.m2657b((Object) "AdColony suspending");
        C0694a.f2386z = true;
        if (!this.f2962b) {
            C0726l.f2613d.m2657b((Object) "AdColony.onPause() called without initial call to onResume().");
        }
        this.f2962b = false;
        this.f2963c = true;
        this.f2968h = aa.m2483c();
        m2811f();
    }

    void m2810e() {
        C0726l.f2611b.m2657b((Object) "AdColony terminating");
        C0694a.f2386z = true;
        m2806a(this.f2969i);
        this.f2963c = false;
        m2811f();
    }

    void m2811f() {
        C1423g c1423g = new C1423g();
        c1423g.m5278b("allow_resume", this.f2963c);
        c1423g.m5275b("start_time", this.f2967g);
        c1423g.m5275b("finish_time", this.f2968h);
        c1423g.m5275b("session_time", this.f2969i);
        C0725k.m2634a(new C0720f("session_info.txt"), c1423g);
    }

    void m2812g() {
        C1423g b = C0725k.m2637b(new C0720f("session_info.txt"));
        if (b != null) {
            this.f2963c = b.m5285h("allow_resume");
            this.f2967g = b.m5282f("start_time");
            this.f2968h = b.m5282f("finish_time");
            this.f2969i = b.m5282f("session_time");
            return;
        }
        this.f2964d = true;
    }

    void m2813h() {
        this.f2965e = true;
        if (!this.f2966f) {
            this.f2971k = aa.m2481b();
        }
        this.f2966f = false;
        this.f2969i = 0.0d;
        this.f2970j = 0;
        if (C0694a.f2372l != null && C0694a.f2372l.f2513b != null && C0694a.f2372l.f2513b.f4599i != null && C0694a.f2372l.f2513b.f4599i.f2749n != null) {
            for (int i = 0; i < C0694a.f2372l.f2513b.f4599i.f2749n.m2719b(); i++) {
                if (C0694a.f2372l.f2513b.f4599i.f2749n.m2715a(i).f2692r != null) {
                    C0694a.f2372l.f2513b.f4599i.f2749n.m2715a(i).f2692r.f2461d = 0;
                }
                if (C0694a.f2372l.f2513b.f4599i.f2749n.m2715a(i) != null) {
                    C0694a.f2372l.f2513b.f4599i.f2749n.m2715a(i).f2684j = new C1419c();
                }
            }
        }
    }

    void m2806a(double d) {
        C0726l.f2610a.m2653a("Submitting session duration ").m2655b(d);
        C1423g c1423g = new C1423g();
        c1423g.m5276b("session_length", (int) d);
        this.f2961a.f2515d.m5352a("session_end", c1423g);
    }
}
