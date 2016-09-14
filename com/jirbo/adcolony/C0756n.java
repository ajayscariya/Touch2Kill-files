package com.jirbo.adcolony;

import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.jirbo.adcolony.n */
class C0756n {

    /* renamed from: com.jirbo.adcolony.n.a */
    static class C0730a {
        C0745p f2626A;
        aa f2627B;
        String f2628a;
        String f2629b;
        int f2630c;
        int f2631d;
        int f2632e;
        int f2633f;
        int f2634g;
        int f2635h;
        long f2636i;
        boolean f2637j;
        boolean f2638k;
        boolean f2639l;
        boolean f2640m;
        boolean f2641n;
        boolean f2642o;
        boolean f2643p;
        boolean f2644q;
        boolean f2645r;
        boolean f2646s;
        C0743n f2647t;
        C0755z f2648u;
        C0742m f2649v;
        C0732c f2650w;
        C0731b f2651x;
        C0737h f2652y;
        ac f2653z;

        C0730a() {
        }

        boolean m2680a() {
            if (!this.f2649v.m2754a()) {
                return false;
            }
            if (this.f2650w.f2732a && !this.f2650w.m2722a()) {
                return false;
            }
            if (this.f2626A.f2829a && !this.f2626A.m2761a()) {
                return false;
            }
            if ((!this.f2652y.f2778d || this.f2652y.m2741a()) && this.f2653z.m2688a() && this.f2627B.m2685a() && !m2682b()) {
                return true;
            }
            return false;
        }

        boolean m2682b() {
            if (this.f2644q || System.currentTimeMillis() - this.f2636i > ((long) (this.f2635h * 1000))) {
                return true;
            }
            return false;
        }

        boolean m2683c() {
            if (this.f2645r) {
                return true;
            }
            return false;
        }

        boolean m2681a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2628a = c1423g.m5281e("uuid");
            this.f2629b = c1423g.m5281e(DatabaseOpenHelper.HISTORY_ROW_TITLE);
            this.f2630c = c1423g.m5283g("ad_campaign_id");
            this.f2631d = c1423g.m5283g("ad_id");
            this.f2632e = c1423g.m5283g("ad_group_id");
            this.f2633f = c1423g.m5283g("cpcv_bid");
            this.f2634g = c1423g.m5283g("net_earnings");
            this.f2635h = c1423g.m5264a("expires", 660);
            this.f2637j = c1423g.m5285h("enable_in_app_store");
            this.f2638k = c1423g.m5285h("video_events_on_replays");
            this.f2639l = c1423g.m5285h("test_ad");
            this.f2640m = c1423g.m5285h("fullscreen");
            this.f2641n = c1423g.m5285h("house_ad");
            this.f2642o = c1423g.m5285h("contracted");
            this.f2646s = false;
            this.f2636i = System.currentTimeMillis();
            this.f2647t = new C0743n();
            if (!this.f2647t.m2757a(c1423g.m5274b("limits"))) {
                return false;
            }
            this.f2648u = new C0755z();
            if (!this.f2648u.m2783a(c1423g.m5274b("third_party_tracking"))) {
                return false;
            }
            this.f2649v = new C0742m();
            if (!this.f2649v.m2755a(c1423g.m5274b("in_app_browser"))) {
                return false;
            }
            this.f2626A = new C0745p();
            if (!this.f2626A.m2762a(c1423g.m5274b("native"))) {
                return false;
            }
            this.f2650w = new C0732c();
            if (!this.f2650w.m2723a(c1423g.m5274b("v4vc"))) {
                return false;
            }
            this.f2651x = new C0731b();
            if (!this.f2651x.m2721a(c1423g.m5274b("ad_tracking"))) {
                return false;
            }
            this.f2652y = new C0737h();
            if (!this.f2652y.m2742a(c1423g.m5274b("companion_ad"))) {
                return false;
            }
            this.f2653z = new ac();
            if (!this.f2653z.m2689a(c1423g.m5274b("video"))) {
                return false;
            }
            this.f2627B = new aa();
            if (!this.f2627B.m2686a(c1423g.m5274b("v4iap"))) {
                return false;
            }
            C0726l.f2611b.m2657b((Object) "Finished parsing ad");
            return true;
        }

        void m2684d() {
            this.f2650w.m2724b();
            this.f2649v.m2756b();
            this.f2626A.m2763b();
            this.f2652y.m2743b();
            this.f2653z.m2691c();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.aa */
    static class aa {
        String f2654a;
        String f2655b;
        boolean f2656c;

        aa() {
        }

        boolean m2685a() {
            return true;
        }

        boolean m2686a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2656c = c1423g.m5285h("enabled");
            if (!this.f2656c) {
                return true;
            }
            this.f2654a = (String) c1423g.m5280d("product_ids").get(0);
            this.f2655b = c1423g.m5281e("in_progress");
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.ab */
    static class ab {
        int f2657a;
        int f2658b;
        int f2659c;

        ab() {
        }

        boolean m2687a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2657a = -1;
            this.f2658b = -1;
            this.f2659c = -1;
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.ac */
    static class ac {
        boolean f2660a;
        int f2661b;
        int f2662c;
        String f2663d;
        String f2664e;
        String f2665f;
        String f2666g;
        String f2667h;
        String f2668i;
        String f2669j;
        double f2670k;
        C0736g f2671l;
        C0736g f2672m;
        C0736g f2673n;
        C0740k f2674o;

        ac() {
        }

        boolean m2688a() {
            if (!this.f2660a) {
                return true;
            }
            if (!C0694a.f2372l.f2514c.m5341a(this.f2663d)) {
                return false;
            }
            if (!this.f2671l.m2738a()) {
                return false;
            }
            if (!this.f2672m.m2738a()) {
                return false;
            }
            if (!this.f2674o.m2748a()) {
                return false;
            }
            if (!this.f2673n.m2738a()) {
                return false;
            }
            if (C0694a.f2372l.f2513b.f4599i.f2744i.equals("online") && !C0760q.m2793c()) {
                C0694a.am = 9;
                return C0726l.f2612c.m2659b("Video not ready due to VIEW_FILTER_ONLINE");
            } else if (C0694a.f2372l.f2513b.f4599i.f2744i.equals("wifi") && !C0760q.m2788a()) {
                C0694a.am = 9;
                return C0726l.f2612c.m2659b("Video not ready due to VIEW_FILTER_WIFI");
            } else if (C0694a.f2372l.f2513b.f4599i.f2744i.equals("cell") && !C0760q.m2791b()) {
                C0694a.am = 9;
                return C0726l.f2612c.m2659b("Video not ready due to VIEW_FILTER_CELL");
            } else if (!C0694a.f2372l.f2513b.f4599i.f2744i.equals("offline") || !C0760q.m2793c()) {
                return true;
            } else {
                C0694a.am = 9;
                return C0726l.f2612c.m2659b("Video not ready due to VIEW_FILTER_OFFLINE");
            }
        }

        String m2690b() {
            return C0694a.f2372l.f2514c.m5342b(this.f2663d);
        }

        boolean m2689a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2660a = c1423g.m5285h("enabled");
            if (!this.f2660a) {
                return true;
            }
            this.f2661b = c1423g.m5283g("width");
            this.f2662c = c1423g.m5283g("height");
            this.f2663d = c1423g.m5281e(DatabaseOpenHelper.HISTORY_ROW_URL);
            this.f2664e = c1423g.m5281e("last_modified");
            this.f2665f = c1423g.m5281e("video_frame_rate");
            this.f2666g = c1423g.m5281e("audio_channels");
            this.f2667h = c1423g.m5281e("audio_codec");
            this.f2668i = c1423g.m5281e("audio_sample_rate");
            this.f2669j = c1423g.m5281e("video_codec");
            this.f2670k = c1423g.m5282f(SchemaSymbols.ATTVAL_DURATION);
            this.f2671l = new C0736g();
            if (!this.f2671l.m2739a(c1423g.m5274b("skip_video"))) {
                return false;
            }
            this.f2672m = new C0736g();
            if (!this.f2672m.m2739a(c1423g.m5274b("in_video_engagement"))) {
                return false;
            }
            this.f2674o = new C0740k();
            if (!this.f2674o.m2749a(c1423g.m5274b("haptic"))) {
                return false;
            }
            this.f2673n = new C0736g();
            if (this.f2673n.m2739a(c1423g.m5274b("in_video_engagement").m5274b("image_overlay"))) {
                return true;
            }
            return false;
        }

        void m2691c() {
            C0694a.f2372l.f2514c.m5340a(this.f2663d, this.f2664e);
            this.f2672m.m2740b();
            this.f2671l.m2740b();
            this.f2674o.m2750b();
            this.f2673n.m2740b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.ad */
    static class ad {
        String f2675a;
        C1423g f2676b;
        int f2677c;
        int f2678d;
        int f2679e;
        int f2680f;
        boolean f2681g;
        boolean f2682h;
        boolean f2683i;
        C1419c f2684j;
        ArrayList<String> f2685k;
        ae f2686l;
        C0733d f2687m;
        af f2688n;
        long f2689o;
        long f2690p;
        long f2691q;
        af f2692r;
        int f2693s;

        ad() {
            this.f2684j = new C1419c();
            this.f2689o = 600000;
            this.f2690p = 60000;
            this.f2693s = 0;
        }

        boolean m2694a() {
            if (this.f2687m == null) {
                return true;
            }
            Iterator it = this.f2687m.f2735a.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                if (((C0730a) it.next()).m2682b()) {
                    i2 = i;
                } else {
                    i2 = i + 1;
                }
                i = i2;
            }
            if (i < this.f2680f) {
                return true;
            }
            return false;
        }

        boolean m2698b() {
            if (this.f2693s % this.f2688n.f2700f != 0) {
                return false;
            }
            this.f2693s = 0;
            return true;
        }

        boolean m2700c() {
            return m2697a(false, true);
        }

        boolean m2697a(boolean z, boolean z2) {
            if (!z2) {
                return m2696a(z);
            }
            if (!this.f2681g || !this.f2682h) {
                C0694a.am = 1;
                return C0726l.f2612c.m2659b("Ad is not ready to be played, as zone " + this.f2675a + " is disabled or inactive.");
            } else if (this.f2687m.m2730b() == 0 || this.f2685k.size() == 0) {
                C0694a.am = 5;
                return C0726l.f2612c.m2659b("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.f2675a + ".");
            } else {
                C0730a k;
                int size = this.f2685k.size();
                for (int i = 0; i < size; i++) {
                    k = m2709k();
                    if (k == null) {
                        return C0726l.f2612c.m2659b("Ad is not ready to be played due to an unknown error.");
                    }
                    if (k.m2680a()) {
                        break;
                    }
                    m2711m();
                }
                k = null;
                if (k == null) {
                    C0694a.am = 6;
                    return C0726l.f2612c.m2659b("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone " + this.f2675a + ".");
                } else if (m2693a(k) == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        boolean m2696a(boolean z) {
            if (!z) {
                C0694a.m2467h();
            }
            if (!this.f2681g || !this.f2682h || this.f2687m.m2730b() == 0 || this.f2685k.size() == 0) {
                return false;
            }
            C0730a k;
            int size = this.f2685k.size();
            for (int i = 0; i < size; i++) {
                k = m2709k();
                if (k == null) {
                    return false;
                }
                if (k.m2680a()) {
                    break;
                }
                m2711m();
            }
            k = null;
            if (k == null || m2693a(k) == 0) {
                return false;
            }
            return true;
        }

        boolean m2702d() {
            if (this.f2677c <= 1) {
                return false;
            }
            C0694a.f2372l.f2518g.f2463b = true;
            af afVar = this.f2692r;
            int i = afVar.f2459b;
            afVar.f2459b = i + 1;
            if (i == 0) {
                return false;
            }
            if (this.f2692r.f2459b >= this.f2677c) {
                this.f2692r.f2459b = 0;
            }
            return true;
        }

        int m2692a(int i, int i2) {
            if (i2 <= 0) {
                return 0;
            }
            if (i == -1) {
                return i2;
            }
            if (i >= i2) {
                i = i2;
            }
            return i;
        }

        void m2703e() {
            C0694a.f2372l.f2513b.m5326e();
        }

        synchronized int m2704f() {
            return m2693a(m2709k());
        }

        synchronized int m2693a(C0730a c0730a) {
            int i;
            if (c0730a.f2644q) {
                i = 0;
            } else {
                i = 1;
            }
            return i;
        }

        boolean m2705g() {
            return m2699b(true);
        }

        boolean m2699b(boolean z) {
            if (!z) {
                return m2706h();
            }
            if (!this.f2681g || !this.f2682h) {
                C0694a.am = 1;
                return C0726l.f2612c.m2659b("Ad is not ready, as zone " + this.f2675a + " is disabled or inactive.");
            } else if (this.f2687m.m2730b() == 0) {
                C0694a.am = 5;
                return C0726l.f2612c.m2659b("Ad is not ready, as there are currently no ads to play in zone " + this.f2675a + ".");
            } else if (!this.f2687m.m2732c().f2650w.f2732a) {
                return true;
            } else {
                C0694a.am = 14;
                return C0726l.f2612c.m2659b("Ad is not ready, as zone " + this.f2675a + " is V4VC enabled and must be played using an AdColonyV4VCAd object.");
            }
        }

        boolean m2706h() {
            if (!this.f2681g || !this.f2682h || this.f2687m.m2730b() == 0 || this.f2687m.m2732c().f2650w.f2732a) {
                return false;
            }
            return true;
        }

        boolean m2707i() {
            return m2701c(true);
        }

        boolean m2701c(boolean z) {
            if (!z) {
                return m2708j();
            }
            if (!this.f2681g || !this.f2682h) {
                C0694a.am = 1;
                return C0726l.f2612c.m2659b("Ad is not ready, as zone " + this.f2675a + " is disabled or inactive.");
            } else if (this.f2687m.m2730b() == 0) {
                C0694a.am = 5;
                return C0726l.f2612c.m2659b("Ad is not ready, as there are currently no ads to play in zone " + this.f2675a + ".");
            } else if (this.f2687m.m2732c().f2650w.f2732a) {
                return true;
            } else {
                C0694a.am = 15;
                return C0726l.f2612c.m2659b("Ad is not ready, as zone " + this.f2675a + " is not V4VC enabled and must be played using an AdColonyVideoAd object.");
            }
        }

        boolean m2708j() {
            if (this.f2681g && this.f2682h && this.f2687m.m2730b() != 0 && this.f2687m.m2732c().f2650w.f2732a) {
                return true;
            }
            return false;
        }

        C0730a m2709k() {
            if (this.f2685k.size() > 0) {
                return this.f2687m.m2726a((String) this.f2685k.get(this.f2692r.f2460c % this.f2685k.size()));
            }
            return null;
        }

        C0730a m2710l() {
            if (this.f2685k.size() > 0) {
                return this.f2687m.m2731b(this.f2692r.f2460c % this.f2685k.size());
            }
            return null;
        }

        void m2711m() {
            if (this.f2685k.size() > 0) {
                this.f2692r.f2460c = (this.f2692r.f2460c + 1) % this.f2685k.size();
            }
        }

        boolean m2695a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2676b = c1423g;
            this.f2675a = c1423g.m5281e("uuid");
            this.f2681g = c1423g.m5285h("enabled");
            this.f2682h = c1423g.m5285h("active");
            this.f2691q = Long.parseLong(c1423g.m5268a("last_config_ms", SchemaSymbols.ATTVAL_FALSE_0)) == 0 ? System.currentTimeMillis() : Long.parseLong(c1423g.m5281e("last_config_ms"));
            this.f2683i = c1423g.m5285h("clear_ad_queue");
            if (!this.f2681g || !this.f2682h) {
                return true;
            }
            this.f2677c = c1423g.m5283g("play_interval");
            this.f2678d = c1423g.m5283g("daily_play_cap");
            this.f2679e = c1423g.m5283g("session_play_cap");
            this.f2680f = c1423g.m5264a("min_ad_thresh", 1);
            this.f2690p = ((long) c1423g.m5264a("min_config_win", 60)) * 1000;
            this.f2689o = ((long) c1423g.m5264a("max_config_win", 600)) * 1000;
            this.f2685k = new ArrayList();
            ArrayList d = c1423g.m5280d("play_order");
            this.f2685k = d;
            if (d == null) {
                return false;
            }
            this.f2686l = new ae();
            if (!this.f2686l.m2713a(c1423g.m5274b("tracking"))) {
                return false;
            }
            if (this.f2687m == null || this.f2683i) {
                this.f2687m = new C0733d();
            }
            if (!this.f2687m.m2729a(c1423g.m5279c("ads"))) {
                return false;
            }
            if (!C0694a.f2337C) {
                C0726l.f2612c.m2653a("Finished parsing response for zone \"").m2653a(this.f2675a).m2653a("\": ").m2651a(this.f2687m.m2730b()).m2657b((Object) " ad(s). Attempting to cache media assets.");
            }
            this.f2688n = new af();
            if (!this.f2688n.m2714a(c1423g.m5274b("v4vc"))) {
                return false;
            }
            this.f2692r = C0694a.f2372l.f2518g.m2529a(this.f2675a);
            C0726l.f2610a.m2657b((Object) "Finished parsing zone");
            return true;
        }

        void m2712n() {
            if (this.f2681g && this.f2682h) {
                for (int i = 0; i < this.f2687m.m2730b(); i++) {
                    this.f2687m.m2725a(i).m2684d();
                }
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.ae */
    static class ae {
        String f2694a;

        ae() {
        }

        boolean m2713a(C1423g c1423g) {
            if (c1423g != null) {
                this.f2694a = c1423g.m5268a("request", null);
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.af */
    static class af {
        boolean f2695a;
        ab f2696b;
        int f2697c;
        String f2698d;
        boolean f2699e;
        int f2700f;

        af() {
        }

        boolean m2714a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2695a = c1423g.m5285h("enabled");
            if (!this.f2695a) {
                return true;
            }
            this.f2696b = new ab();
            if (!this.f2696b.m2687a(c1423g.m5274b("limits"))) {
                return false;
            }
            this.f2697c = c1423g.m5283g("reward_amount");
            this.f2698d = c1423g.m5281e("reward_name");
            this.f2699e = c1423g.m5285h("client_side");
            this.f2700f = c1423g.m5283g("videos_per_reward");
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.ag */
    static class ag {
        ArrayList<ad> f2701a;

        ag() {
            this.f2701a = new ArrayList();
        }

        boolean m2718a(C1419c c1419c) {
            if (c1419c == null) {
                C0694a.f2376p = false;
                return false;
            }
            int i = 0;
            while (i < c1419c.m5250i()) {
                C1423g b = c1419c.m5241b(i);
                ad a = m2716a(b.m5281e("uuid"));
                if (a == null) {
                    a = new ad();
                }
                if (a.m2695a(b)) {
                    this.f2701a.add(a);
                    i++;
                } else {
                    C0694a.f2376p = false;
                    return false;
                }
            }
            C0694a.f2376p = false;
            return true;
        }

        void m2717a() {
            for (int i = 0; i < this.f2701a.size(); i++) {
                if (((ad) this.f2701a.get(i)).f2687m != null) {
                    ((ad) this.f2701a.get(i)).f2687m.m2727a();
                }
            }
        }

        int m2719b() {
            return this.f2701a.size();
        }

        ad m2715a(int i) {
            return (ad) this.f2701a.get(i);
        }

        ad m2720c() {
            return (ad) this.f2701a.get(0);
        }

        ad m2716a(String str) {
            for (int i = 0; i < this.f2701a.size(); i++) {
                ad adVar = (ad) this.f2701a.get(i);
                if (adVar.f2675a.equals(str)) {
                    return adVar;
                }
            }
            return null;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.b */
    static class C0731b {
        String f2702A;
        String f2703B;
        String f2704C;
        C1423g f2705D;
        String f2706a;
        String f2707b;
        String f2708c;
        String f2709d;
        String f2710e;
        String f2711f;
        String f2712g;
        String f2713h;
        String f2714i;
        String f2715j;
        String f2716k;
        String f2717l;
        String f2718m;
        String f2719n;
        String f2720o;
        String f2721p;
        String f2722q;
        String f2723r;
        String f2724s;
        String f2725t;
        String f2726u;
        String f2727v;
        String f2728w;
        String f2729x;
        String f2730y;
        String f2731z;

        C0731b() {
            this.f2705D = new C1423g();
        }

        boolean m2721a(C1423g c1423g) {
            if (c1423g != null) {
                this.f2706a = c1423g.m5268a("replay", null);
                this.f2707b = c1423g.m5268a("card_shown", null);
                this.f2708c = c1423g.m5268a("html5_interaction", null);
                this.f2709d = c1423g.m5268a("cancel", null);
                this.f2710e = c1423g.m5268a("download", null);
                this.f2711f = c1423g.m5268a(SchemaSymbols.ATTVAL_SKIP, null);
                this.f2712g = c1423g.m5268a("info", null);
                this.f2713h = c1423g.m5268a("custom_event", null);
                this.f2714i = c1423g.m5268a("midpoint", null);
                this.f2715j = c1423g.m5268a("card_dissolved", null);
                this.f2716k = c1423g.m5268a("start", null);
                this.f2717l = c1423g.m5268a("third_quartile", null);
                this.f2718m = c1423g.m5268a("complete", null);
                this.f2719n = c1423g.m5268a("continue", null);
                this.f2720o = c1423g.m5268a("in_video_engagement", null);
                this.f2721p = c1423g.m5268a("reward_v4vc", null);
                this.f2723r = c1423g.m5268a("first_quartile", null);
                this.f2722q = c1423g.m5268a("v4iap", null);
                this.f2724s = c1423g.m5268a("video_expanded", null);
                this.f2725t = c1423g.m5268a("sound_mute", null);
                this.f2726u = c1423g.m5268a("sound_unmute", null);
                this.f2727v = c1423g.m5268a("video_paused", null);
                this.f2728w = c1423g.m5268a("video_resumed", null);
                this.f2729x = c1423g.m5268a("native_start", null);
                this.f2730y = c1423g.m5268a("native_first_quartile", null);
                this.f2731z = c1423g.m5268a("native_midpoint", null);
                this.f2702A = c1423g.m5268a("native_third_quartile", null);
                this.f2703B = c1423g.m5268a("native_complete", null);
                this.f2704C = c1423g.m5268a("native_overlay_click", null);
                this.f2705D.m5277b("replay", this.f2706a);
                this.f2705D.m5277b("card_shown", this.f2707b);
                this.f2705D.m5277b("html5_interaction", this.f2708c);
                this.f2705D.m5277b("cancel", this.f2709d);
                this.f2705D.m5277b("download", this.f2710e);
                this.f2705D.m5277b(SchemaSymbols.ATTVAL_SKIP, this.f2711f);
                this.f2705D.m5277b("info", this.f2712g);
                this.f2705D.m5277b("custom_event", this.f2713h);
                this.f2705D.m5277b("midpoint", this.f2714i);
                this.f2705D.m5277b("card_dissolved", this.f2715j);
                this.f2705D.m5277b("start", this.f2716k);
                this.f2705D.m5277b("third_quartile", this.f2717l);
                this.f2705D.m5277b("complete", this.f2718m);
                this.f2705D.m5277b("continue", this.f2719n);
                this.f2705D.m5277b("in_video_engagement", this.f2720o);
                this.f2705D.m5277b("reward_v4vc", this.f2721p);
                this.f2705D.m5277b("first_quartile", this.f2723r);
                this.f2705D.m5277b("v4iap", this.f2722q);
                this.f2705D.m5277b("video_expanded", this.f2724s);
                this.f2705D.m5277b("sound_mute", this.f2725t);
                this.f2705D.m5277b("sound_unmute", this.f2726u);
                this.f2705D.m5277b("video_paused", this.f2727v);
                this.f2705D.m5277b("video_resumed", this.f2728w);
                this.f2705D.m5277b("native_start", this.f2729x);
                this.f2705D.m5277b("native_first_quartile", this.f2730y);
                this.f2705D.m5277b("native_midpoint", this.f2731z);
                this.f2705D.m5277b("native_third_quartile", this.f2702A);
                this.f2705D.m5277b("native_complete", this.f2703B);
                this.f2705D.m5277b("native_overlay_click", this.f2704C);
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.c */
    static class C0732c {
        boolean f2732a;
        C0752w f2733b;
        C0750u f2734c;

        C0732c() {
        }

        boolean m2722a() {
            if (this.f2733b.m2776a() && this.f2734c.m2770a()) {
                return true;
            }
            return false;
        }

        boolean m2723a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2732a = c1423g.m5285h("enabled");
            if (!this.f2732a) {
                return true;
            }
            this.f2733b = new C0752w();
            if (!this.f2733b.m2777a(c1423g.m5274b("pre_popup"))) {
                return false;
            }
            this.f2734c = new C0750u();
            if (this.f2734c.m2771a(c1423g.m5274b("post_popup"))) {
                return true;
            }
            return false;
        }

        void m2724b() {
            if (this.f2732a) {
                this.f2733b.m2778b();
                this.f2734c.m2772b();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.d */
    static class C0733d {
        ArrayList<C0730a> f2735a;

        C0733d() {
            this.f2735a = new ArrayList();
        }

        void m2727a() {
            for (int i = 0; i < this.f2735a.size(); i++) {
                C0730a c0730a = (C0730a) this.f2735a.get(i);
                if (c0730a.m2682b() && !c0730a.f2646s) {
                    C0694a.m2467h();
                    c0730a.f2646s = true;
                }
            }
        }

        boolean m2729a(C1419c c1419c) {
            if (c1419c == null) {
                return false;
            }
            for (int i = 0; i < this.f2735a.size(); i++) {
                if (((C0730a) this.f2735a.get(i)).m2682b()) {
                    this.f2735a.remove(i);
                }
            }
            for (int i2 = 0; i2 < c1419c.m5250i(); i2++) {
                C0730a c0730a = new C0730a();
                if (!c0730a.m2681a(c1419c.m5241b(i2))) {
                    return false;
                }
                this.f2735a.add(c0730a);
            }
            return true;
        }

        void m2728a(C0730a c0730a) {
            this.f2735a.add(c0730a);
        }

        int m2730b() {
            return this.f2735a.size();
        }

        C0730a m2725a(int i) {
            return (C0730a) this.f2735a.get(i);
        }

        C0730a m2732c() {
            return (C0730a) this.f2735a.get(0);
        }

        C0730a m2726a(String str) {
            for (int i = 0; i < this.f2735a.size(); i++) {
                C0730a c0730a = (C0730a) this.f2735a.get(i);
                if (c0730a.f2628a.equals(str)) {
                    return c0730a;
                }
            }
            return null;
        }

        C0730a m2731b(int i) {
            while (i < this.f2735a.size()) {
                C0730a c0730a = (C0730a) this.f2735a.get(i);
                if (c0730a.f2626A.f2829a) {
                    return c0730a;
                }
                i++;
            }
            for (int i2 = 0; i2 < this.f2735a.size(); i2++) {
                c0730a = (C0730a) this.f2735a.get(i2);
                if (c0730a.f2626A.f2829a) {
                    return c0730a;
                }
            }
            return null;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.e */
    static class C0734e {
        boolean f2736a;
        boolean f2737b;
        String f2738c;
        String f2739d;
        boolean f2740e;
        boolean f2741f;
        double f2742g;
        String f2743h;
        String f2744i;
        String f2745j;
        C0735f f2746k;
        C0754y f2747l;
        ArrayList<String> f2748m;
        ag f2749n;
        C0738i f2750o;

        C0734e() {
            this.f2740e = false;
            this.f2749n = new ag();
        }

        boolean m2735a(String str) {
            return m2736a(str, false, true);
        }

        boolean m2736a(String str, boolean z, boolean z2) {
            if (!this.f2736a) {
                return false;
            }
            ad a = this.f2749n.m2716a(str);
            if (a != null) {
                return a.m2697a(z, z2);
            }
            return false;
        }

        boolean m2734a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2736a = c1423g.m5285h("enabled");
            this.f2737b = c1423g.m5285h("log_screen_overlay");
            this.f2738c = c1423g.m5281e("last_country");
            this.f2739d = c1423g.m5281e("last_ip");
            this.f2741f = c1423g.m5285h("collect_iap_enabled");
            this.f2742g = c1423g.m5282f("media_pool_size");
            this.f2743h = c1423g.m5281e("log_level");
            this.f2744i = c1423g.m5281e("view_network_pass_filter");
            this.f2745j = c1423g.m5281e("cache_network_pass_filter");
            this.f2740e = c1423g.m5285h("hardware_acceleration_disabled");
            if (this.f2744i == null || this.f2744i.equals(XMLConstants.NULL_NS_URI)) {
                this.f2744i = "all";
            }
            if (this.f2745j == null || this.f2745j.equals(XMLConstants.NULL_NS_URI)) {
                this.f2745j = "all";
            }
            this.f2746k = new C0735f();
            if (!this.f2746k.m2737a(c1423g.m5274b("tracking"))) {
                return false;
            }
            this.f2747l = new C0754y();
            if (!this.f2747l.m2782a(c1423g.m5274b("third_party_tracking"))) {
                return false;
            }
            this.f2748m = c1423g.m5280d("console_messages");
            C0726l.f2610a.m2657b((Object) "Parsing zones");
            if (!this.f2749n.m2718a(c1423g.m5279c("zones"))) {
                return false;
            }
            this.f2750o = new C0738i();
            if (!this.f2750o.m2744a(c1423g.m5274b("device"))) {
                return false;
            }
            C0726l.f2610a.m2657b((Object) "Finished parsing app info");
            return true;
        }

        void m2733a() {
            C0726l.f2610a.m2657b((Object) "Caching media");
            if (this.f2736a) {
                for (int i = 0; i < this.f2749n.m2719b(); i++) {
                    this.f2749n.m2715a(i).m2712n();
                }
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.f */
    static class C0735f {
        String f2751a;
        String f2752b;
        String f2753c;
        String f2754d;
        String f2755e;
        String f2756f;
        String f2757g;
        C1423g f2758h;

        C0735f() {
        }

        boolean m2737a(C1423g c1423g) {
            if (c1423g != null) {
                this.f2751a = c1423g.m5268a("update", null);
                this.f2752b = c1423g.m5268a("install", null);
                this.f2753c = c1423g.m5268a("dynamic_interests", null);
                this.f2754d = c1423g.m5268a("user_meta_data", null);
                this.f2755e = c1423g.m5268a("in_app_purchase", null);
                this.f2757g = c1423g.m5268a("session_end", null);
                this.f2756f = c1423g.m5268a("session_start", null);
                this.f2758h = new C1423g();
                this.f2758h.m5277b("update", this.f2751a);
                this.f2758h.m5277b("install", this.f2752b);
                this.f2758h.m5277b("dynamic_interests", this.f2753c);
                this.f2758h.m5277b("user_meta_data", this.f2754d);
                this.f2758h.m5277b("in_app_purchase", this.f2755e);
                this.f2758h.m5277b("session_end", this.f2757g);
                this.f2758h.m5277b("session_start", this.f2756f);
                C0720f c0720f = new C0720f("iap_cache.txt");
                C1419c c = C0725k.m2640c(c0720f);
                if (c != null) {
                    for (int i = 0; i < c.m5250i(); i++) {
                        C0694a.f2372l.f2515d.m5352a("in_app_purchase", c.m5237a(i, new C1423g()));
                    }
                    c0720f.m2601c();
                    C0694a.aj.m5251j();
                }
                C0694a.f2349O = true;
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.g */
    static class C0736g {
        boolean f2759a;
        int f2760b;
        int f2761c;
        int f2762d;
        int f2763e;
        String f2764f;
        String f2765g;
        String f2766h;
        String f2767i;
        String f2768j;
        String f2769k;
        String f2770l;
        String f2771m;
        String f2772n;
        String f2773o;
        String f2774p;

        C0736g() {
        }

        boolean m2738a() {
            if (!this.f2759a) {
                return true;
            }
            if (!C0694a.f2372l.f2514c.m5341a(this.f2764f)) {
                return false;
            }
            if (C0694a.f2372l.f2514c.m5341a(this.f2766h)) {
                return true;
            }
            return false;
        }

        boolean m2739a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2759a = c1423g.m5273a("enabled", true);
            this.f2763e = c1423g.m5283g("delay");
            this.f2760b = c1423g.m5283g("width");
            this.f2761c = c1423g.m5283g("height");
            this.f2762d = c1423g.m5283g("scale");
            this.f2764f = c1423g.m5281e("image_normal");
            this.f2765g = c1423g.m5281e("image_normal_last_modified");
            this.f2766h = c1423g.m5281e("image_down");
            this.f2767i = c1423g.m5281e("image_down_last_modified");
            this.f2768j = c1423g.m5281e("click_action");
            this.f2769k = c1423g.m5281e("click_action_type");
            this.f2770l = c1423g.m5281e("label");
            this.f2771m = c1423g.m5281e("label_rgba");
            this.f2772n = c1423g.m5281e("label_shadow_rgba");
            this.f2773o = c1423g.m5281e("label_html");
            this.f2774p = c1423g.m5281e(NotificationCompatApi21.CATEGORY_EVENT);
            return true;
        }

        void m2740b() {
            C0694a.f2372l.f2514c.m5340a(this.f2764f, this.f2765g);
            C0694a.f2372l.f2514c.m5340a(this.f2766h, this.f2767i);
        }
    }

    /* renamed from: com.jirbo.adcolony.n.h */
    static class C0737h {
        String f2775a;
        int f2776b;
        int f2777c;
        boolean f2778d;
        boolean f2779e;
        boolean f2780f;
        double f2781g;
        C0753x f2782h;
        C0739j f2783i;

        C0737h() {
        }

        boolean m2741a() {
            if (this.f2783i.f2785a && !this.f2783i.m2745a()) {
                return false;
            }
            if (!this.f2778d) {
                return true;
            }
            if (this.f2782h.m2779a() || this.f2783i.m2745a()) {
                return true;
            }
            return false;
        }

        boolean m2742a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2778d = c1423g.m5285h("enabled");
            if (!this.f2778d) {
                return true;
            }
            this.f2775a = c1423g.m5281e("uuid");
            this.f2776b = c1423g.m5283g("ad_id");
            this.f2777c = c1423g.m5283g("ad_campaign_id");
            this.f2779e = c1423g.m5285h("dissolve");
            this.f2780f = c1423g.m5285h("enable_in_app_store");
            this.f2781g = c1423g.m5282f("dissolve_delay");
            this.f2782h = new C0753x();
            if (!this.f2782h.m2780a(c1423g.m5274b("static"))) {
                return false;
            }
            this.f2783i = new C0739j();
            if (this.f2783i.m2746a(c1423g.m5274b("html5"))) {
                return true;
            }
            return false;
        }

        void m2743b() {
            if (this.f2778d) {
                this.f2782h.m2781b();
                this.f2783i.m2747b();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.i */
    static class C0738i {
        String f2784a;

        C0738i() {
        }

        boolean m2744a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2784a = c1423g.m5268a("type", null);
            C0694a.ah = this.f2784a;
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.j */
    static class C0739j {
        boolean f2785a;
        double f2786b;
        boolean f2787c;
        boolean f2788d;
        String f2789e;
        C0744o f2790f;
        String f2791g;
        C0741l f2792h;
        C0736g f2793i;
        C0736g f2794j;

        C0739j() {
        }

        boolean m2745a() {
            if (!C0760q.m2793c()) {
                C0694a.am = 8;
                return C0726l.f2612c.m2659b("Ad not ready due to no network connection.");
            } else if (this.f2785a && this.f2790f.m2758a() && this.f2792h.m2751a() && this.f2793i.m2738a() && this.f2794j.m2738a()) {
                return true;
            } else {
                return false;
            }
        }

        boolean m2746a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2785a = c1423g.m5285h("enabled");
            this.f2786b = c1423g.m5282f("load_timeout");
            this.f2787c = c1423g.m5285h("load_timeout_enabled");
            this.f2788d = c1423g.m5285h("load_spinner_enabled");
            this.f2789e = c1423g.m5281e("background_color");
            this.f2791g = c1423g.m5281e("html5_tag");
            this.f2790f = new C0744o();
            if (!this.f2790f.m2759a(c1423g.m5274b("mraid_js"))) {
                return false;
            }
            this.f2792h = new C0741l();
            if (!this.f2792h.m2752a(c1423g.m5274b("background_logo"))) {
                return false;
            }
            this.f2793i = new C0736g();
            if (!this.f2793i.m2739a(c1423g.m5274b("replay"))) {
                return false;
            }
            this.f2794j = new C0736g();
            if (this.f2794j.m2739a(c1423g.m5274b("close"))) {
                return true;
            }
            return false;
        }

        void m2747b() {
            if (this.f2785a) {
                if (this.f2790f != null) {
                    this.f2790f.m2760b();
                }
                if (this.f2792h != null) {
                    this.f2792h.m2753b();
                }
                if (this.f2793i != null) {
                    this.f2793i.m2740b();
                }
                if (this.f2794j != null) {
                    this.f2794j.m2740b();
                }
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.k */
    static class C0740k {
        boolean f2795a;
        String f2796b;
        String f2797c;
        String f2798d;

        C0740k() {
        }

        boolean m2748a() {
            if (this.f2795a && !C0694a.f2372l.f2514c.m5341a(this.f2797c)) {
                return false;
            }
            return true;
        }

        boolean m2749a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2795a = c1423g.m5273a("enabled", false);
            this.f2797c = c1423g.m5281e("file_url");
            this.f2798d = c1423g.m5281e("last_modified");
            return true;
        }

        void m2750b() {
            C0694a.f2372l.f2514c.m5340a(this.f2797c, this.f2798d);
        }
    }

    /* renamed from: com.jirbo.adcolony.n.l */
    static class C0741l {
        int f2799a;
        int f2800b;
        int f2801c;
        String f2802d;
        String f2803e;
        boolean f2804f;

        C0741l() {
        }

        boolean m2751a() {
            if (this.f2804f) {
                return C0694a.f2372l.f2514c.m5341a(this.f2802d);
            }
            return true;
        }

        boolean m2752a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2804f = c1423g.m5273a("enabled", true);
            this.f2799a = c1423g.m5283g("width");
            this.f2800b = c1423g.m5283g("height");
            this.f2801c = c1423g.m5283g("scale");
            this.f2802d = c1423g.m5281e("image");
            this.f2803e = c1423g.m5281e("image_last_modified");
            if (!this.f2803e.equals(XMLConstants.NULL_NS_URI)) {
                return true;
            }
            this.f2803e = c1423g.m5281e("last_modified");
            return true;
        }

        void m2753b() {
            C0694a.f2372l.f2514c.m5340a(this.f2802d, this.f2803e);
        }
    }

    /* renamed from: com.jirbo.adcolony.n.m */
    static class C0742m {
        String f2805a;
        String f2806b;
        String f2807c;
        String f2808d;
        String f2809e;
        String f2810f;
        String f2811g;
        C0741l f2812h;
        C0736g f2813i;
        C0736g f2814j;
        C0736g f2815k;
        C0736g f2816l;
        C0736g f2817m;

        C0742m() {
        }

        boolean m2754a() {
            if (C0694a.f2372l.f2514c.m5341a(this.f2805a) && C0694a.f2372l.f2514c.m5341a(this.f2807c) && C0694a.f2372l.f2514c.m5341a(this.f2809e) && this.f2812h.m2751a() && this.f2813i.m2738a() && this.f2814j.m2738a() && this.f2815k.m2738a() && this.f2816l.m2738a() && this.f2817m.m2738a()) {
                return true;
            }
            return false;
        }

        boolean m2755a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2805a = c1423g.m5281e("tiny_glow_image");
            this.f2806b = c1423g.m5281e("tiny_glow_image_last_modified;");
            this.f2807c = c1423g.m5281e("background_bar_image");
            this.f2808d = c1423g.m5281e("background_bar_image_last_modified");
            this.f2809e = c1423g.m5281e("background_tile_image");
            this.f2810f = c1423g.m5281e("background_tile_image_last_modified");
            this.f2811g = c1423g.m5281e("background_color");
            this.f2812h = new C0741l();
            if (!this.f2812h.m2752a(c1423g.m5274b("logo"))) {
                return false;
            }
            this.f2812h = new C0741l();
            if (!this.f2812h.m2752a(c1423g.m5274b("logo"))) {
                return false;
            }
            this.f2813i = new C0736g();
            if (!this.f2813i.m2739a(c1423g.m5274b("stop"))) {
                return false;
            }
            this.f2814j = new C0736g();
            if (!this.f2814j.m2739a(c1423g.m5274b("back"))) {
                return false;
            }
            this.f2815k = new C0736g();
            if (!this.f2815k.m2739a(c1423g.m5274b("close"))) {
                return false;
            }
            this.f2816l = new C0736g();
            if (!this.f2816l.m2739a(c1423g.m5274b("forward"))) {
                return false;
            }
            this.f2817m = new C0736g();
            if (this.f2817m.m2739a(c1423g.m5274b("reload"))) {
                return true;
            }
            return false;
        }

        void m2756b() {
            C0694a.f2372l.f2514c.m5340a(this.f2805a, this.f2806b);
            C0694a.f2372l.f2514c.m5340a(this.f2807c, this.f2808d);
            C0694a.f2372l.f2514c.m5340a(this.f2809e, this.f2810f);
            this.f2812h.m2753b();
            this.f2813i.m2740b();
            this.f2814j.m2740b();
            this.f2815k.m2740b();
            this.f2816l.m2740b();
            this.f2817m.m2740b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.n */
    static class C0743n {
        int f2818a;
        int f2819b;
        int f2820c;
        int f2821d;
        int f2822e;
        int f2823f;
        int f2824g;
        int f2825h;

        C0743n() {
        }

        boolean m2757a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2818a = -1;
            this.f2819b = -1;
            this.f2820c = -1;
            this.f2821d = -1;
            this.f2822e = -1;
            this.f2823f = -1;
            this.f2824g = -1;
            this.f2825h = -1;
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.o */
    static class C0744o {
        boolean f2826a;
        String f2827b;
        String f2828c;

        C0744o() {
        }

        boolean m2758a() {
            if (this.f2826a && !C0694a.f2372l.f2514c.m5341a(this.f2827b)) {
                return false;
            }
            return true;
        }

        boolean m2759a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2826a = c1423g.m5285h("enabled");
            if (!this.f2826a) {
                return true;
            }
            this.f2827b = c1423g.m5281e(DatabaseOpenHelper.HISTORY_ROW_URL);
            this.f2828c = c1423g.m5281e("last_modified");
            return true;
        }

        void m2760b() {
            C0694a.f2372l.f2514c.m5340a(this.f2827b, this.f2828c);
        }
    }

    /* renamed from: com.jirbo.adcolony.n.p */
    static class C0745p {
        boolean f2829a;
        boolean f2830b;
        String f2831c;
        String f2832d;
        String f2833e;
        C0748s f2834f;
        C0747r f2835g;
        C0746q f2836h;
        boolean f2837i;
        C0741l f2838j;
        C0741l f2839k;

        C0745p() {
        }

        boolean m2762a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2829a = c1423g.m5285h("enabled");
            this.f2831c = c1423g.m5281e("advertiser_name");
            this.f2832d = c1423g.m5281e("description");
            this.f2833e = c1423g.m5281e(DatabaseOpenHelper.HISTORY_ROW_TITLE);
            this.f2837i = false;
            this.f2834f = new C0748s();
            if (!this.f2834f.m2766a(c1423g.m5274b("thumb"))) {
                return false;
            }
            this.f2835g = new C0747r();
            if (!this.f2835g.m2765a(c1423g.m5274b("poster"))) {
                return false;
            }
            this.f2838j = new C0741l();
            if (!this.f2838j.m2752a(c1423g.m5274b("mute"))) {
                return false;
            }
            this.f2830b = this.f2838j.f2804f;
            this.f2839k = new C0741l();
            if (!this.f2839k.m2752a(c1423g.m5274b("unmute"))) {
                return false;
            }
            this.f2836h = new C0746q();
            if (this.f2836h.m2764a(c1423g.m5274b("overlay"))) {
                return true;
            }
            return false;
        }

        boolean m2761a() {
            if (this.f2829a && C0694a.f2372l.f2514c.m5341a(this.f2835g.f2845a) && C0694a.f2372l.f2514c.m5341a(this.f2834f.f2849a) && this.f2838j.m2751a() && this.f2839k.m2751a() && !this.f2837i) {
                return true;
            }
            return false;
        }

        void m2763b() {
            C0694a.f2372l.f2514c.m5340a(this.f2835g.f2845a, this.f2835g.f2846b);
            C0694a.f2372l.f2514c.m5340a(this.f2834f.f2849a, this.f2834f.f2850b);
            this.f2838j.m2753b();
            this.f2839k.m2753b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.q */
    static class C0746q {
        boolean f2840a;
        boolean f2841b;
        String f2842c;
        String f2843d;
        String f2844e;

        C0746q() {
        }

        boolean m2764a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2840a = c1423g.m5285h("enabled");
            if (!this.f2840a) {
                return true;
            }
            this.f2841b = c1423g.m5285h("in_app");
            this.f2842c = c1423g.m5281e("click_action_type");
            this.f2844e = c1423g.m5281e("click_action");
            this.f2843d = c1423g.m5281e("label");
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.r */
    static class C0747r {
        String f2845a;
        String f2846b;
        String f2847c;
        String f2848d;

        C0747r() {
        }

        boolean m2765a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2845a = c1423g.m5281e("image");
            this.f2846b = c1423g.m5281e("last_modified");
            this.f2847c = c1423g.m5281e("click_action_type");
            this.f2848d = c1423g.m5281e("click_action");
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.s */
    static class C0748s {
        String f2849a;
        String f2850b;

        C0748s() {
        }

        boolean m2766a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2849a = c1423g.m5281e("image");
            this.f2850b = c1423g.m5281e("last_modified");
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.t */
    static class C0749t {
        int f2851a;
        String f2852b;
        int f2853c;
        int f2854d;
        String f2855e;
        String f2856f;
        String f2857g;
        String f2858h;
        String f2859i;
        String f2860j;
        String f2861k;
        C0741l f2862l;
        C0736g f2863m;

        C0749t() {
        }

        boolean m2767a() {
            if (C0694a.f2372l.f2514c.m5341a(this.f2855e) && this.f2862l.m2751a() && this.f2863m.m2738a()) {
                return true;
            }
            return false;
        }

        boolean m2768a(C1423g c1423g) {
            this.f2851a = c1423g.m5283g("scale");
            this.f2852b = c1423g.m5281e("label_reward");
            this.f2853c = c1423g.m5283g("width");
            this.f2854d = c1423g.m5283g("height");
            this.f2855e = c1423g.m5281e("image");
            this.f2856f = c1423g.m5281e("image_last_modified");
            this.f2857g = c1423g.m5281e("label");
            this.f2858h = c1423g.m5281e("label_rgba");
            this.f2859i = c1423g.m5281e("label_shadow_rgba");
            this.f2860j = c1423g.m5281e("label_fraction");
            this.f2861k = c1423g.m5281e("label_html");
            this.f2862l = new C0741l();
            if (!this.f2862l.m2752a(c1423g.m5274b("logo"))) {
                return false;
            }
            this.f2863m = new C0736g();
            if (this.f2863m.m2739a(c1423g.m5274b("option_done"))) {
                return true;
            }
            return false;
        }

        void m2769b() {
            C0694a.f2372l.f2514c.m5340a(this.f2855e, this.f2856f);
            this.f2862l.m2753b();
            this.f2863m.m2740b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.u */
    static class C0750u {
        String f2864a;
        String f2865b;
        C0741l f2866c;
        C0749t f2867d;

        C0750u() {
        }

        boolean m2770a() {
            if (C0694a.f2372l.f2514c.m5341a(this.f2864a) && this.f2866c.m2751a() && this.f2867d.m2767a()) {
                return true;
            }
            return false;
        }

        boolean m2771a(C1423g c1423g) {
            this.f2864a = c1423g.m5281e("background_image");
            this.f2865b = c1423g.m5281e("background_image_last_modified");
            this.f2866c = new C0741l();
            if (!this.f2866c.m2752a(c1423g.m5274b("background_logo"))) {
                return false;
            }
            this.f2867d = new C0749t();
            if (this.f2867d.m2768a(c1423g.m5274b("dialog"))) {
                return true;
            }
            return false;
        }

        void m2772b() {
            C0694a.f2372l.f2514c.m5340a(this.f2864a, this.f2865b);
            this.f2867d.m2769b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.v */
    static class C0751v {
        int f2868a;
        String f2869b;
        int f2870c;
        int f2871d;
        String f2872e;
        String f2873f;
        String f2874g;
        String f2875h;
        String f2876i;
        String f2877j;
        String f2878k;
        C0741l f2879l;
        C0736g f2880m;
        C0736g f2881n;

        C0751v() {
        }

        boolean m2773a() {
            if (C0694a.f2372l.f2514c.m5341a(this.f2872e) && this.f2879l.m2751a() && this.f2880m.m2738a()) {
                return true;
            }
            return false;
        }

        boolean m2774a(C1423g c1423g) {
            this.f2868a = c1423g.m5283g("scale");
            this.f2869b = c1423g.m5281e("label_reward");
            this.f2870c = c1423g.m5283g("width");
            this.f2871d = c1423g.m5283g("height");
            this.f2872e = c1423g.m5281e("image");
            this.f2873f = c1423g.m5281e("image_last_modified");
            this.f2874g = c1423g.m5281e("label");
            this.f2875h = c1423g.m5281e("label_rgba");
            this.f2876i = c1423g.m5281e("label_shadow_rgba");
            this.f2877j = c1423g.m5281e("label_fraction");
            this.f2878k = c1423g.m5281e("label_html");
            this.f2879l = new C0741l();
            if (!this.f2879l.m2752a(c1423g.m5274b("logo"))) {
                return false;
            }
            this.f2880m = new C0736g();
            if (!this.f2880m.m2739a(c1423g.m5274b("option_yes"))) {
                return false;
            }
            this.f2881n = new C0736g();
            if (this.f2881n.m2739a(c1423g.m5274b("option_no"))) {
                return true;
            }
            return false;
        }

        void m2775b() {
            C0694a.f2372l.f2514c.m5340a(this.f2872e, this.f2873f);
            this.f2879l.m2753b();
            this.f2880m.m2740b();
            this.f2881n.m2740b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.w */
    static class C0752w {
        String f2882a;
        String f2883b;
        C0741l f2884c;
        C0751v f2885d;

        C0752w() {
        }

        boolean m2776a() {
            if (C0694a.f2372l.f2514c.m5341a(this.f2882a) && this.f2884c.m2751a() && this.f2885d.m2773a()) {
                return true;
            }
            return false;
        }

        boolean m2777a(C1423g c1423g) {
            this.f2882a = c1423g.m5281e("background_image");
            this.f2883b = c1423g.m5281e("background_image_last_modified");
            this.f2884c = new C0741l();
            if (!this.f2884c.m2752a(c1423g.m5274b("background_logo"))) {
                return false;
            }
            this.f2885d = new C0751v();
            if (this.f2885d.m2774a(c1423g.m5274b("dialog"))) {
                return true;
            }
            return false;
        }

        void m2778b() {
            C0694a.f2372l.f2514c.m5340a(this.f2882a, this.f2883b);
            this.f2884c.m2753b();
            this.f2885d.m2775b();
        }
    }

    /* renamed from: com.jirbo.adcolony.n.x */
    static class C0753x {
        boolean f2886a;
        int f2887b;
        int f2888c;
        String f2889d;
        String f2890e;
        C0736g f2891f;
        C0736g f2892g;
        C0736g f2893h;
        C0736g f2894i;

        C0753x() {
        }

        boolean m2779a() {
            if (!this.f2886a) {
                return true;
            }
            if (!C0694a.f2372l.f2514c.m5341a(this.f2889d)) {
                return false;
            }
            if (!this.f2893h.m2738a()) {
                return false;
            }
            if (!this.f2894i.m2738a()) {
                return false;
            }
            if (!this.f2892g.m2738a()) {
                return false;
            }
            if (this.f2891f.m2738a()) {
                return true;
            }
            return false;
        }

        boolean m2780a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2886a = c1423g.m5285h("enabled");
            if (!this.f2886a) {
                return true;
            }
            this.f2887b = c1423g.m5283g("width");
            this.f2888c = c1423g.m5283g("height");
            this.f2889d = c1423g.m5281e("background_image");
            this.f2890e = c1423g.m5281e("background_image_last_modified");
            if (C0694a.f2366f != null) {
                this.f2889d = C0694a.f2366f;
            }
            this.f2893h = new C0736g();
            if (!this.f2893h.m2739a(c1423g.m5274b("replay"))) {
                return false;
            }
            this.f2894i = new C0736g();
            if (!this.f2894i.m2739a(c1423g.m5274b("continue"))) {
                return false;
            }
            this.f2892g = new C0736g();
            if (!this.f2892g.m2739a(c1423g.m5274b("download"))) {
                return false;
            }
            this.f2891f = new C0736g();
            if (this.f2891f.m2739a(c1423g.m5274b("info"))) {
                return true;
            }
            return false;
        }

        void m2781b() {
            if (this.f2886a) {
                C0694a.f2372l.f2514c.m5340a(this.f2889d, this.f2890e);
                this.f2893h.m2740b();
                this.f2894i.m2740b();
                this.f2892g.m2740b();
                this.f2891f.m2740b();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.n.y */
    static class C0754y {
        ArrayList<String> f2895a;
        ArrayList<String> f2896b;
        ArrayList<String> f2897c;
        HashMap<String, ArrayList<String>> f2898d;

        C0754y() {
            this.f2895a = new ArrayList();
            this.f2896b = new ArrayList();
            this.f2897c = new ArrayList();
            this.f2898d = new HashMap();
        }

        boolean m2782a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            ArrayList d = c1423g.m5280d("update");
            this.f2895a = d;
            if (d == null) {
                return false;
            }
            d = c1423g.m5280d("install");
            this.f2896b = d;
            if (d == null) {
                return false;
            }
            d = c1423g.m5280d("session_start");
            this.f2897c = d;
            if (d == null) {
                return false;
            }
            this.f2898d.put("update", this.f2895a);
            this.f2898d.put("install", this.f2896b);
            this.f2898d.put("session_start", this.f2897c);
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.n.z */
    static class C0755z {
        ArrayList<String> f2899A;
        ArrayList<String> f2900B;
        HashMap<String, ArrayList<String>> f2901C;
        ArrayList<String> f2902a;
        ArrayList<String> f2903b;
        ArrayList<String> f2904c;
        ArrayList<String> f2905d;
        ArrayList<String> f2906e;
        ArrayList<String> f2907f;
        ArrayList<String> f2908g;
        ArrayList<String> f2909h;
        ArrayList<String> f2910i;
        ArrayList<String> f2911j;
        ArrayList<String> f2912k;
        ArrayList<String> f2913l;
        ArrayList<String> f2914m;
        ArrayList<String> f2915n;
        ArrayList<String> f2916o;
        ArrayList<String> f2917p;
        ArrayList<String> f2918q;
        ArrayList<String> f2919r;
        ArrayList<String> f2920s;
        ArrayList<String> f2921t;
        ArrayList<String> f2922u;
        ArrayList<String> f2923v;
        ArrayList<String> f2924w;
        ArrayList<String> f2925x;
        ArrayList<String> f2926y;
        ArrayList<String> f2927z;

        C0755z() {
            this.f2902a = new ArrayList();
            this.f2903b = new ArrayList();
            this.f2904c = new ArrayList();
            this.f2905d = new ArrayList();
            this.f2906e = new ArrayList();
            this.f2907f = new ArrayList();
            this.f2908g = new ArrayList();
            this.f2909h = new ArrayList();
            this.f2910i = new ArrayList();
            this.f2911j = new ArrayList();
            this.f2912k = new ArrayList();
            this.f2913l = new ArrayList();
            this.f2914m = new ArrayList();
            this.f2915n = new ArrayList();
            this.f2916o = new ArrayList();
            this.f2917p = new ArrayList();
            this.f2918q = new ArrayList();
            this.f2919r = new ArrayList();
            this.f2920s = new ArrayList();
            this.f2921t = new ArrayList();
            this.f2922u = new ArrayList();
            this.f2923v = new ArrayList();
            this.f2924w = new ArrayList();
            this.f2925x = new ArrayList();
            this.f2926y = new ArrayList();
            this.f2927z = new ArrayList();
            this.f2899A = new ArrayList();
            this.f2900B = new ArrayList();
            this.f2901C = new HashMap();
        }

        boolean m2783a(C1423g c1423g) {
            if (c1423g == null) {
                return false;
            }
            this.f2902a = c1423g.m5280d("replay");
            this.f2903b = c1423g.m5280d("card_shown");
            this.f2904c = c1423g.m5280d("html5_interaction");
            this.f2905d = c1423g.m5280d("cancel");
            this.f2906e = c1423g.m5280d("download");
            this.f2907f = c1423g.m5280d(SchemaSymbols.ATTVAL_SKIP);
            this.f2908g = c1423g.m5280d("info");
            this.f2909h = c1423g.m5280d("midpoint");
            this.f2910i = c1423g.m5280d("card_dissolved");
            this.f2911j = c1423g.m5280d("start");
            this.f2912k = c1423g.m5280d("third_quartile");
            this.f2913l = c1423g.m5280d("complete");
            this.f2914m = c1423g.m5280d("continue");
            this.f2915n = c1423g.m5280d("in_video_engagement");
            this.f2916o = c1423g.m5280d("reward_v4vc");
            this.f2917p = c1423g.m5280d("first_quartile");
            this.f2918q = c1423g.m5280d("v4iap");
            this.f2919r = c1423g.m5280d("video_expanded");
            this.f2920s = c1423g.m5280d("sound_mute");
            this.f2921t = c1423g.m5280d("sound_unmute");
            this.f2922u = c1423g.m5280d("video_paused");
            this.f2923v = c1423g.m5280d("video_resumed");
            this.f2924w = c1423g.m5280d("native_start");
            this.f2925x = c1423g.m5280d("native_first_quartile");
            this.f2926y = c1423g.m5280d("native_midpoint");
            this.f2927z = c1423g.m5280d("native_third_quartile");
            this.f2899A = c1423g.m5280d("native_complete");
            this.f2900B = c1423g.m5280d("native_overlay_click");
            this.f2901C.put("replay", this.f2902a);
            this.f2901C.put("card_shown", this.f2903b);
            this.f2901C.put("html5_interaction", this.f2904c);
            this.f2901C.put("cancel", this.f2905d);
            this.f2901C.put("download", this.f2906e);
            this.f2901C.put(SchemaSymbols.ATTVAL_SKIP, this.f2907f);
            this.f2901C.put("info", this.f2908g);
            this.f2901C.put("midpoint", this.f2909h);
            this.f2901C.put("card_dissolved", this.f2910i);
            this.f2901C.put("start", this.f2911j);
            this.f2901C.put("third_quartile", this.f2912k);
            this.f2901C.put("complete", this.f2913l);
            this.f2901C.put("continue", this.f2914m);
            this.f2901C.put("in_video_engagement", this.f2915n);
            this.f2901C.put("reward_v4vc", this.f2916o);
            this.f2901C.put("first_quartile", this.f2917p);
            this.f2901C.put("v4iap", this.f2918q);
            this.f2901C.put("video_expanded", this.f2919r);
            this.f2901C.put("sound_mute", this.f2920s);
            this.f2901C.put("sound_unmute", this.f2921t);
            this.f2901C.put("video_paused", this.f2922u);
            this.f2901C.put("video_resumed", this.f2923v);
            this.f2901C.put("native_start", this.f2924w);
            this.f2901C.put("native_first_quartile", this.f2925x);
            this.f2901C.put("native_midpoint", this.f2926y);
            this.f2901C.put("native_third_quartile", this.f2927z);
            this.f2901C.put("native_complete", this.f2899A);
            this.f2901C.put("native_overlay_click", this.f2900B);
            return true;
        }
    }

    C0756n() {
    }
}
