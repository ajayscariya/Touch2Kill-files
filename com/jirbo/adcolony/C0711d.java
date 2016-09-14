package com.jirbo.adcolony;

import android.content.Intent;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.C0756n.ad;
import com.jirbo.adcolony.aa.C0695a;
import java.util.ArrayList;

/* renamed from: com.jirbo.adcolony.d */
class C0711d {
    C0709c f2512a;
    C1429b f2513b;
    C1438o f2514c;
    C1439t f2515d;
    C0763u f2516e;
    ADCStorage f2517f;
    ag f2518g;
    ArrayList<C0724j> f2519h;
    ArrayList<C0724j> f2520i;
    volatile boolean f2521j;
    boolean f2522k;
    boolean f2523l;
    C0695a f2524m;

    /* renamed from: com.jirbo.adcolony.d.1 */
    class C07101 implements Runnable {
        final /* synthetic */ C0724j f2510a;
        final /* synthetic */ C0711d f2511b;

        C07101(C0711d c0711d, C0724j c0724j) {
            this.f2511b = c0711d;
            this.f2510a = c0724j;
        }

        public void run() {
            synchronized (this.f2511b.f2519h) {
                if (C0694a.m2459d()) {
                    this.f2511b.f2519h.add(this.f2510a);
                    if (!this.f2511b.f2521j) {
                        this.f2511b.m2577g();
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.d.2 */
    class C14302 extends C0724j {
        final /* synthetic */ C0711d f4600a;

        C14302(C0711d c0711d, C0711d c0711d2) {
            this.f4600a = c0711d;
            super(c0711d2);
        }

        void m5330a() {
            this.o.f2516e.m2808c();
        }
    }

    /* renamed from: com.jirbo.adcolony.d.3 */
    class C14313 extends C0724j {
        final /* synthetic */ C0711d f4601a;

        C14313(C0711d c0711d, C0711d c0711d2) {
            this.f4601a = c0711d;
            super(c0711d2);
        }

        void m5331a() {
            this.o.f2516e.m2809d();
        }
    }

    /* renamed from: com.jirbo.adcolony.d.4 */
    class C14324 extends C0724j {
        final /* synthetic */ C0711d f4602a;

        C14324(C0711d c0711d, C0711d c0711d2) {
            this.f4602a = c0711d;
            super(c0711d2);
        }

        void m5332a() {
            this.o.f2516e.m2810e();
        }
    }

    /* renamed from: com.jirbo.adcolony.d.5 */
    class C14335 extends C0724j {
        final /* synthetic */ AdColonyAd f4603a;
        final /* synthetic */ C0711d f4604b;

        C14335(C0711d c0711d, C0711d c0711d2, AdColonyAd adColonyAd) {
            this.f4604b = c0711d;
            this.f4603a = adColonyAd;
            super(c0711d2);
        }

        void m5333a() {
            if (AdColony.isZoneV4VC(this.f4603a.f2212h) || this.f4603a.f2214j.f2626A == null || !this.f4603a.f2214j.f2626A.f2829a || (this.f4603a.f2214j.f2626A.f2829a && this.f4603a.f2225u && this.f4603a.f2216l.equals("fullscreen"))) {
                this.f4604b.m2556a("start", "{\"ad_slot\":" + (C0694a.f2372l.f2516e.f2970j + 1) + ", \"replay\":" + this.f4603a.f2225u + "}", this.f4603a);
                this.f4603a.f2214j.f2644q = true;
                this.f4603a.f2214j.f2645r = true;
                C0694a.m2467h();
                this.f4603a.f2213i.f2684j.m5235a(this.f4603a.f2214j.f2628a);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.d.6 */
    class C14346 extends C0724j {
        final /* synthetic */ AdColonyAd f4605a;
        final /* synthetic */ double f4606b;
        final /* synthetic */ C0711d f4607c;

        C14346(C0711d c0711d, C0711d c0711d2, AdColonyAd adColonyAd, double d) {
            this.f4607c = c0711d;
            this.f4605a = adColonyAd;
            this.f4606b = d;
            super(c0711d2);
        }

        void m5334a() {
            if (!C0694a.f2375o && this.f4605a.f2214j.f2650w != null && this.f4605a.f2214j.f2650w.f2732a && this.f4606b > 0.9d) {
                C0726l.f2612c.m2657b((Object) "V4VC validated.");
                C0694a.f2375o = true;
            }
            this.o.f2515d.m5351a(this.f4606b, this.f4605a);
        }
    }

    /* renamed from: com.jirbo.adcolony.d.7 */
    class C14357 extends C0724j {
        final /* synthetic */ String f4608a;
        final /* synthetic */ int f4609b;
        final /* synthetic */ AdColonyAd f4610c;
        final /* synthetic */ C0711d f4611d;

        C14357(C0711d c0711d, C0711d c0711d2, String str, int i, AdColonyAd adColonyAd) {
            this.f4611d = c0711d;
            this.f4608a = str;
            this.f4609b = i;
            this.f4610c = adColonyAd;
            super(c0711d2);
        }

        void m5335a() {
            C1423g c1423g = new C1423g();
            c1423g.m5277b("v4vc_name", this.f4608a);
            c1423g.m5276b("v4vc_amount", this.f4609b);
            this.o.f2515d.m5353a("reward_v4vc", c1423g, this.f4610c);
        }
    }

    /* renamed from: com.jirbo.adcolony.d.8 */
    class C14368 extends C0724j {
        final /* synthetic */ String f4612a;
        final /* synthetic */ String f4613b;
        final /* synthetic */ C0711d f4614c;

        C14368(C0711d c0711d, C0711d c0711d2, String str, String str2) {
            this.f4614c = c0711d;
            this.f4612a = str;
            this.f4613b = str2;
            super(c0711d2);
        }

        void m5336a() {
            this.o.f2515d.m5352a(this.f4612a, C0725k.m2638b(this.f4613b));
        }
    }

    /* renamed from: com.jirbo.adcolony.d.9 */
    class C14379 extends C0724j {
        final /* synthetic */ String f4615a;
        final /* synthetic */ String f4616b;
        final /* synthetic */ AdColonyAd f4617c;
        final /* synthetic */ C0711d f4618d;

        C14379(C0711d c0711d, C0711d c0711d2, String str, String str2, AdColonyAd adColonyAd) {
            this.f4618d = c0711d;
            this.f4615a = str;
            this.f4616b = str2;
            this.f4617c = adColonyAd;
            super(c0711d2);
        }

        void m5337a() {
            this.o.f2515d.m5353a(this.f4615a, C0725k.m2638b(this.f4616b), this.f4617c);
        }
    }

    C0711d() {
        this.f2512a = new C0709c(this);
        this.f2513b = new C1429b(this);
        this.f2514c = new C1438o(this);
        this.f2515d = new C1439t(this);
        this.f2516e = new C0763u(this);
        this.f2517f = new ADCStorage(this);
        this.f2518g = new ag(this);
        this.f2519h = new ArrayList();
        this.f2520i = new ArrayList();
        this.f2524m = new C0695a();
    }

    void m2554a(C0724j c0724j) {
        new Thread(new C07101(this, c0724j)).start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m2547a() {
        /*
        r3 = this;
        r2 = 0;
        r0 = r3.f2522k;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = com.jirbo.adcolony.C0694a.m2459d();
        if (r0 == 0) goto L_0x0005;
    L_0x000c:
        r0 = r3.f2522k;	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 == 0) goto L_0x001c;
    L_0x0010:
        r0 = r3.f2521j;	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 != 0) goto L_0x0062;
    L_0x0014:
        r0 = r3.f2519h;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.size();	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 <= 0) goto L_0x0062;
    L_0x001c:
        r0 = 1;
        r3.f2522k = r0;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r3.f2520i;	 Catch:{ RuntimeException -> 0x0051 }
        r1 = r3.f2519h;	 Catch:{ RuntimeException -> 0x0051 }
        r0.addAll(r1);	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r3.f2519h;	 Catch:{ RuntimeException -> 0x0051 }
        r0.clear();	 Catch:{ RuntimeException -> 0x0051 }
        r1 = r2;
    L_0x002c:
        r0 = r3.f2520i;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.size();	 Catch:{ RuntimeException -> 0x0051 }
        if (r1 >= r0) goto L_0x004b;
    L_0x0034:
        r0 = r3.f2520i;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.get(r1);	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 == 0) goto L_0x0047;
    L_0x003c:
        r0 = r3.f2520i;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.get(r1);	 Catch:{ RuntimeException -> 0x0051 }
        r0 = (com.jirbo.adcolony.C0724j) r0;	 Catch:{ RuntimeException -> 0x0051 }
        r0.m2628a();	 Catch:{ RuntimeException -> 0x0051 }
    L_0x0047:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x002c;
    L_0x004b:
        r0 = r3.f2520i;	 Catch:{ RuntimeException -> 0x0051 }
        r0.clear();	 Catch:{ RuntimeException -> 0x0051 }
        goto L_0x000c;
    L_0x0051:
        r0 = move-exception;
        r3.f2522k = r2;
        r1 = r3.f2520i;
        r1.clear();
        r1 = r3.f2519h;
        r1.clear();
        com.jirbo.adcolony.C0694a.m2446a(r0);
        goto L_0x0005;
    L_0x0062:
        r0 = 0;
        r3.f2522k = r0;	 Catch:{ RuntimeException -> 0x0051 }
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jirbo.adcolony.d.a():void");
    }

    void m2562b() {
        this.f2521j = true;
        C14302 c14302 = new C14302(this, this);
    }

    void m2568c() {
        this.f2521j = false;
        C14313 c14313 = new C14313(this, this);
    }

    void m2571d() {
        C14324 c14324 = new C14324(this, this);
    }

    synchronized void m2550a(AdColonyAd adColonyAd) {
        this.f2512a.f2498o = 0.0d;
        C0726l.f2610a.m2657b((Object) "Tracking ad event - start");
        af afVar = adColonyAd.f2213i.f2692r;
        afVar.f2461d++;
        if (!adColonyAd.m2421b()) {
            adColonyAd.f2213i.m2711m();
        }
        C14335 c14335 = new C14335(this, this, adColonyAd);
    }

    void m2548a(double d, AdColonyAd adColonyAd) {
        C14346 c14346 = new C14346(this, this, adColonyAd, d);
    }

    synchronized void m2559a(boolean z, String str, int i) {
        C0694a.f2358X.m2439a(z, str, i);
    }

    synchronized void m2558a(boolean z, AdColonyAd adColonyAd) {
        Object obj = 1;
        synchronized (this) {
            if (adColonyAd != null) {
                m2548a(1.0d, adColonyAd);
                if (!z && adColonyAd.m2421b()) {
                    adColonyAd.f2213i.m2711m();
                    ad adVar = adColonyAd.f2213i;
                    adVar.f2693s++;
                    AdColonyV4VCAd adColonyV4VCAd = (AdColonyV4VCAd) C0694a.f2354T;
                    String rewardName = adColonyV4VCAd.getRewardName();
                    int rewardAmount = adColonyV4VCAd.getRewardAmount();
                    if (!adColonyAd.f2213i.m2698b()) {
                        obj = null;
                    }
                    if (obj != null) {
                        if (adColonyV4VCAd.i.f2688n.f2699e && C0694a.f2375o) {
                            m2559a(true, rewardName, rewardAmount);
                        }
                        C14357 c14357 = new C14357(this, this, rewardName, rewardAmount, adColonyAd);
                    }
                }
            }
        }
    }

    void m2555a(String str, String str2) {
        C14368 c14368 = new C14368(this, this, str, str2);
    }

    void m2556a(String str, String str2, AdColonyAd adColonyAd) {
        C14379 c14379 = new C14379(this, this, str, str2, adColonyAd);
    }

    synchronized double m2546a(String str) {
        double f;
        try {
            f = this.f2512a.f2492i.m5282f(str);
        } catch (RuntimeException e) {
            C0694a.m2446a(e);
            f = 0.0d;
        }
        return f;
    }

    synchronized int m2561b(String str) {
        int g;
        try {
            g = this.f2512a.f2492i.m5283g(str);
        } catch (RuntimeException e) {
            C0694a.m2446a(e);
            g = 0;
        }
        return g;
    }

    synchronized boolean m2569c(String str) {
        boolean h;
        try {
            h = this.f2512a.f2492i.m5285h(str);
        } catch (RuntimeException e) {
            C0694a.m2446a(e);
            h = false;
        }
        return h;
    }

    synchronized String m2570d(String str) {
        String e;
        try {
            e = this.f2512a.f2492i.m5281e(str);
        } catch (RuntimeException e2) {
            C0694a.m2446a(e2);
            e = null;
        }
        return e;
    }

    synchronized String m2572e() {
        return this.f2513b.m5323c();
    }

    synchronized String m2574f() {
        return this.f2513b.m5325d();
    }

    synchronized boolean m2573e(String str) {
        return m2560a(str, false, true);
    }

    synchronized boolean m2560a(String str, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (this) {
            try {
                if (C0694a.m2459d()) {
                    if (this.f2513b.m5322b(str, z)) {
                        z3 = this.f2513b.f4599i.f2749n.m2716a(str).m2699b(z2);
                    }
                }
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
        return z3;
    }

    synchronized boolean m2575f(String str) {
        return m2567b(str, false, true);
    }

    synchronized boolean m2567b(String str, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (this) {
            try {
                if (C0694a.m2459d()) {
                    if (this.f2513b.m5322b(str, z)) {
                        z3 = this.f2513b.f4599i.f2749n.m2716a(str).m2701c(z2);
                    }
                }
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
        return z3;
    }

    synchronized void m2553a(AdColonyVideoAd adColonyVideoAd) {
        this.f2512a.m2544b(adColonyVideoAd.h);
    }

    synchronized void m2551a(AdColonyInterstitialAd adColonyInterstitialAd) {
        this.f2512a.m2544b(adColonyInterstitialAd.h);
    }

    synchronized boolean m2566b(AdColonyVideoAd adColonyVideoAd) {
        boolean z = false;
        synchronized (this) {
            try {
                C0694a.f2354T = adColonyVideoAd;
                Object obj = adColonyVideoAd.h;
                if (m2573e(obj)) {
                    C0726l.f2610a.m2653a("Showing ad for zone ").m2657b(obj);
                    m2553a(adColonyVideoAd);
                    z = m2563b((AdColonyAd) adColonyVideoAd);
                }
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
        return z;
    }

    synchronized boolean m2564b(AdColonyInterstitialAd adColonyInterstitialAd) {
        boolean z = false;
        synchronized (this) {
            try {
                C0694a.f2354T = adColonyInterstitialAd;
                Object obj = adColonyInterstitialAd.h;
                if (m2573e(obj)) {
                    C0726l.f2610a.m2653a("Showing ad for zone ").m2657b(obj);
                    m2551a(adColonyInterstitialAd);
                    z = m2563b((AdColonyAd) adColonyInterstitialAd);
                }
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
        return z;
    }

    synchronized ad m2576g(String str) {
        return this.f2513b.f4599i.f2749n.m2716a(str);
    }

    synchronized void m2552a(AdColonyV4VCAd adColonyV4VCAd) {
        this.f2512a.m2545c(adColonyV4VCAd.h);
    }

    synchronized boolean m2565b(AdColonyV4VCAd adColonyV4VCAd) {
        boolean z = false;
        synchronized (this) {
            try {
                C0694a.f2354T = adColonyV4VCAd;
                Object obj = adColonyV4VCAd.h;
                if (m2575f(obj)) {
                    C0726l.f2610a.m2653a("Showing v4vc for zone ").m2657b(obj);
                    m2552a(adColonyV4VCAd);
                    z = m2563b((AdColonyAd) adColonyV4VCAd);
                }
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
        return z;
    }

    synchronized boolean m2563b(AdColonyAd adColonyAd) {
        boolean z;
        if (this.f2512a.f2496m.m2702d()) {
            C0694a.f2354T.f2210f = 3;
            z = false;
        } else {
            ADCVideo.m5299a();
            if (C0694a.f2373m) {
                C0726l.f2610a.m2657b((Object) "Launching AdColonyOverlay");
                C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyOverlay.class));
            } else {
                C0726l.f2610a.m2657b((Object) "Launching AdColonyFullscreen");
                C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyFullscreen.class));
            }
            z = true;
        }
        return z;
    }

    synchronized void m2557a(String str, String str2, String[] strArr) {
        try {
            m2549a(C0694a.f2374n);
            C0726l.f2612c.m2653a("==== Configuring AdColony ").m2653a(this.f2512a.f2486b).m2657b((Object) " with app/zone ids: ====");
            C0726l.f2612c.m2657b((Object) str2);
            for (Object b : strArr) {
                C0726l.f2612c.m2657b(b);
            }
            C0726l.f2610a.m2653a("package name: ").m2657b(aa.m2487f());
            this.f2512a.f2494k = str2;
            this.f2512a.f2495l = strArr;
            this.f2512a.m2541a(str);
            this.f2524m.m2471a();
        } catch (RuntimeException e) {
            C0694a.m2446a(e);
        }
    }

    synchronized void m2577g() {
        if (!C0694a.m2457c()) {
            try {
                m2547a();
                if (!C0694a.f2384x) {
                    if (C0721g.m2615n() != null || this.f2524m.m2472b() > 5.0d) {
                        this.f2512a.m2540a();
                        C0694a.f2384x = true;
                    }
                    C0694a.f2386z = true;
                    this.f2513b.m5327f();
                }
                this.f2514c.m5346e();
                this.f2516e.m2807b();
                this.f2515d.m5361d();
                this.f2518g.m2533d();
            } catch (RuntimeException e) {
                C0694a.m2446a(e);
            }
        }
    }

    void m2549a(int i) {
        C0694a.m2440a(i);
    }
}
