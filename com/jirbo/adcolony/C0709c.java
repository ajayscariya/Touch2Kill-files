package com.jirbo.adcolony;

import android.os.Build.VERSION;
import com.google.android.gms.common.zze;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.C0756n.C0730a;
import com.jirbo.adcolony.C0756n.C0732c;
import com.jirbo.adcolony.C0756n.C0739j;
import com.jirbo.adcolony.C0756n.C0753x;
import com.jirbo.adcolony.C0756n.ac;
import com.jirbo.adcolony.C0756n.ad;
import com.jirbo.adcolony.C0756n.ag;
import com.silvermob.sdk.BuildConfig;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import mf.javax.xml.XMLConstants;
import mf.javax.xml.transform.OutputKeys;

/* renamed from: com.jirbo.adcolony.c */
class C0709c {
    static String f2468c;
    String f2469A;
    String f2470B;
    String f2471C;
    String f2472D;
    String f2473E;
    String f2474F;
    String f2475G;
    String f2476H;
    String f2477I;
    String f2478J;
    String f2479K;
    String f2480L;
    String f2481M;
    String f2482N;
    boolean f2483O;
    boolean f2484P;
    C0711d f2485a;
    String f2486b;
    int f2487d;
    int f2488e;
    boolean f2489f;
    boolean f2490g;
    String f2491h;
    C1423g f2492i;
    C1423g f2493j;
    String f2494k;
    String[] f2495l;
    ad f2496m;
    C0730a f2497n;
    double f2498o;
    String f2499p;
    String f2500q;
    String f2501r;
    String f2502s;
    boolean f2503t;
    String f2504u;
    String f2505v;
    C1419c f2506w;
    String f2507x;
    String f2508y;
    String f2509z;

    static {
        f2468c = "https://androidads23.adcolony.com/configure";
    }

    C0709c(C0711d c0711d) {
        this.f2486b = "2.3.0";
        this.f2487d = 300;
        this.f2488e = 0;
        this.f2489f = false;
        this.f2490g = false;
        this.f2492i = new C1423g();
        this.f2498o = 0.0d;
        this.f2499p = "android";
        this.f2500q = "android_native";
        this.f2501r = BuildConfig.VERSION_NAME;
        this.f2502s = "google";
        this.f2503t = false;
        this.f2508y = XMLConstants.NULL_NS_URI;
        this.f2485a = c0711d;
    }

    void m2541a(String str) {
        if (str == null) {
            str = XMLConstants.NULL_NS_URI;
        }
        for (String split : r8.split(",")) {
            String split2;
            String[] split3 = split2.split(":");
            if (split3.length == 2) {
                String str2 = split3[0];
                split2 = split3[1];
                if (str2.equals(OutputKeys.VERSION)) {
                    this.f2501r = split2;
                } else if (str2.equals("store")) {
                    if (split2.toLowerCase().equals("google") || split2.toLowerCase().equals("amazon")) {
                        this.f2502s = split2;
                    } else {
                        throw new AdColonyException("Origin store in client options must be set to either 'google' or 'amazon'");
                    }
                } else if (str2.equals("skippable")) {
                    this.f2503t = false;
                }
            } else if (split3[0].equals("skippable")) {
                this.f2503t = false;
            }
        }
    }

    void m2540a() {
        String a;
        while (!AdColony.f2201c && this.f2488e < 60) {
            try {
                this.f2488e++;
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
        this.f2488e = 0;
        this.f2485a.f2518g.m2530a();
        this.f2480L = m2539a(C0721g.f2573a, XMLConstants.NULL_NS_URI);
        this.f2483O = C0721g.f2574b;
        this.f2504u = m2539a(C0721g.m2602a(), XMLConstants.NULL_NS_URI);
        if (this.f2480L.equals(XMLConstants.NULL_NS_URI)) {
            a = m2539a(aa.m2482b(this.f2504u), XMLConstants.NULL_NS_URI);
        } else {
            a = XMLConstants.NULL_NS_URI;
        }
        this.f2505v = a;
        this.f2507x = m2539a(C0721g.m2603b(), XMLConstants.NULL_NS_URI);
        if (this.f2509z == null) {
            this.f2509z = m2539a(C0721g.m2606e(), XMLConstants.NULL_NS_URI);
        }
        this.f2469A = m2539a(C0721g.m2613l(), XMLConstants.NULL_NS_URI);
        this.f2470B = m2539a(C0721g.m2614m(), XMLConstants.NULL_NS_URI);
        this.f2474F = m2539a(C0721g.m2611j(), "en");
        this.f2475G = m2539a(C0721g.m2615n(), XMLConstants.NULL_NS_URI);
        this.f2476H = m2539a(C0721g.m2616o(), XMLConstants.NULL_NS_URI);
        this.f2479K = m2539a(XMLConstants.NULL_NS_URI + VERSION.SDK_INT, XMLConstants.NULL_NS_URI);
        this.f2472D = m2539a(C0721g.m2609h(), XMLConstants.NULL_NS_URI);
        this.f2473E = XMLConstants.NULL_NS_URI;
        this.f2477I = m2539a(XMLConstants.NULL_NS_URI + C0721g.m2604c(), XMLConstants.NULL_NS_URI);
        this.f2478J = m2539a(XMLConstants.NULL_NS_URI + C0721g.m2605d(), XMLConstants.NULL_NS_URI);
        boolean z = aa.m2485d() && aa.m2486e();
        this.f2484P = z;
        C0694a.af = this.f2476H;
        C0694a.ag = this.f2486b;
        if (C0694a.f2373m) {
            this.f2471C = "tablet";
        } else {
            this.f2471C = "phone";
        }
        this.f2506w = new C1419c();
        if (aa.m2480a(zze.GOOGLE_PLAY_STORE_PACKAGE) || aa.m2480a("com.android.market")) {
            this.f2506w.m5235a("google");
        }
        if (aa.m2480a("com.amazon.venezia")) {
            this.f2506w.m5235a("amazon");
        }
        if (C0726l.f2611b.f2615f) {
            C0726l.f2611b.m2653a("sdk_version:").m2657b(this.f2486b);
            C0726l.f2611b.m2653a("ad_manifest_url:").m2657b(f2468c);
            C0726l.f2611b.m2653a("app_id:").m2657b(this.f2494k);
            C0726l.f2611b.m2653a("zone_ids:").m2657b(this.f2495l);
            C0726l.f2611b.m2653a("os_name:").m2657b(this.f2499p);
            C0726l.f2611b.m2653a("sdk_type:").m2657b(this.f2500q);
            C0726l.f2611b.m2653a("app_version:").m2657b(this.f2501r);
            C0726l.f2611b.m2653a("origin_store:").m2657b(this.f2502s);
            C0726l.f2611b.m2653a("skippable:").m2658b(this.f2503t);
            C0726l.f2611b.m2653a("android_id:").m2657b(this.f2504u);
            C0726l.f2611b.m2653a("android_id_sha1:").m2657b(this.f2505v);
            C0726l.f2611b.m2653a("available_stores:").m2657b(this.f2506w);
            C0726l.f2611b.m2653a("carrier_name:").m2657b(this.f2507x);
            C0726l.f2611b.m2653a("custom_id:").m2657b(this.f2508y);
            C0726l.f2611b.m2653a("device_id:").m2657b(this.f2509z);
            C0726l.f2611b.m2653a("device_manufacturer:").m2657b(this.f2469A);
            C0726l.f2611b.m2653a("device_model:").m2657b(this.f2470B);
            C0726l.f2611b.m2653a("device_type:").m2657b(this.f2471C);
            C0726l.f2611b.m2653a("imei:").m2657b(this.f2472D);
            C0726l.f2611b.m2653a("imei_sha1:").m2657b(this.f2473E);
            C0726l.f2611b.m2653a("language:").m2657b(this.f2474F);
            C0726l.f2611b.m2653a("open_udid:").m2657b(this.f2475G);
            C0726l.f2611b.m2653a("os_version:").m2657b(this.f2476H);
        }
        C1423g c1423g = new C1423g();
        c1423g.m5277b("os_name", this.f2499p);
        c1423g.m5277b("os_version", this.f2476H);
        c1423g.m5277b("device_api", this.f2479K);
        c1423g.m5277b("app_version", this.f2501r);
        c1423g.m5277b("android_id_sha1", this.f2505v);
        c1423g.m5277b("device_id", this.f2509z);
        c1423g.m5277b("open_udid", this.f2475G);
        c1423g.m5277b("device_type", this.f2471C);
        c1423g.m5277b("ln", this.f2474F);
        c1423g.m5277b("device_brand", this.f2469A);
        c1423g.m5277b("device_model", this.f2470B);
        c1423g.m5276b("screen_width", C0721g.m2607f());
        c1423g.m5276b("screen_height", C0721g.m2608g());
        c1423g.m5277b("sdk_type", this.f2500q);
        c1423g.m5277b("sdk_version", this.f2486b);
        c1423g.m5277b("origin_store", this.f2502s);
        c1423g.m5271a("available_stores", this.f2506w);
        c1423g.m5277b("imei_sha1", this.f2473E);
        c1423g.m5277b("memory_class", this.f2477I);
        c1423g.m5277b("memory_used_mb", this.f2478J);
        c1423g.m5277b("advertiser_id", this.f2480L);
        c1423g.m5278b("limit_tracking", this.f2483O);
        c1423g.m5278b("immersion", this.f2484P);
        this.f2493j = c1423g;
        this.f2485a.f2517f.m2413a();
        this.f2485a.f2514c.m5339a();
        this.f2485a.f2515d.m5350a();
        this.f2485a.f2513b.m5315a();
        this.f2485a.f2516e.m2805a();
        this.f2490g = true;
        C0694a.f2372l.f2513b.f4599i.f2749n = new ag();
        this.f2485a.f2513b.m5329h();
        if (this.f2485a.f2513b.f4599i.f2744i == null || this.f2485a.f2513b.f4599i.f2744i.equals(XMLConstants.NULL_NS_URI)) {
            this.f2485a.f2513b.f4599i.f2744i = "all";
        }
        if (this.f2485a.f2513b.f4599i.f2745j == null || this.f2485a.f2513b.f4599i.f2745j.equals(XMLConstants.NULL_NS_URI)) {
            this.f2485a.f2513b.f4599i.f2745j = "all";
        }
    }

    String m2539a(String str, String str2) {
        return str != null ? str : str2;
    }

    void m2544b(String str) {
        m2542a(str, null);
    }

    void m2542a(String str, C0730a c0730a) {
        this.f2496m = this.f2485a.f2513b.f4599i.f2749n.m2716a(str);
        if (this.f2496m != null) {
            if (c0730a == null) {
                this.f2497n = this.f2496m.m2709k();
            } else {
                this.f2497n = c0730a;
            }
            if (this.f2497n != null) {
                C1438o c1438o = this.f2485a.f2514c;
                ac acVar = this.f2497n.f2653z;
                this.f2492i.m5278b("video_enabled", acVar.f2660a);
                this.f2492i.m5277b("video_filepath", acVar.m2690b());
                this.f2492i.m5276b("video_width", acVar.f2661b);
                this.f2492i.m5276b("video_height", acVar.f2662c);
                this.f2492i.m5275b("video_duration", acVar.f2670k);
                this.f2492i.m5276b("engagement_delay", acVar.f2672m.f2763e);
                this.f2492i.m5276b("skip_delay", acVar.f2671l.f2763e);
                this.f2492i.m5277b("browser_close_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2815k.f2764f));
                this.f2492i.m5277b("browser_close_image_down", c1438o.m5342b(this.f2497n.f2649v.f2815k.f2766h));
                this.f2492i.m5277b("browser_reload_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2817m.f2764f));
                this.f2492i.m5277b("browser_reload_image_down", c1438o.m5342b(this.f2497n.f2649v.f2817m.f2766h));
                this.f2492i.m5277b("browser_back_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2814j.f2764f));
                this.f2492i.m5277b("browser_back_image_down", c1438o.m5342b(this.f2497n.f2649v.f2814j.f2766h));
                this.f2492i.m5277b("browser_forward_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2816l.f2764f));
                this.f2492i.m5277b("browser_forward_image_down", c1438o.m5342b(this.f2497n.f2649v.f2816l.f2766h));
                this.f2492i.m5277b("browser_stop_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2813i.f2764f));
                this.f2492i.m5277b("browser_stop_image_down", c1438o.m5342b(this.f2497n.f2649v.f2813i.f2766h));
                this.f2492i.m5277b("browser_glow_button", c1438o.m5342b(this.f2497n.f2649v.f2805a));
                this.f2492i.m5277b("browser_icon", c1438o.m5342b(this.f2497n.f2649v.f2812h.f2802d));
                this.f2492i.m5277b("mute", c1438o.m5342b(this.f2497n.f2626A.f2838j.f2802d));
                this.f2492i.m5277b("unmute", c1438o.m5342b(this.f2497n.f2626A.f2839k.f2802d));
                this.f2492i.m5277b("poster_image", c1438o.m5342b(this.f2497n.f2626A.f2835g.f2845a));
                this.f2492i.m5277b("thumb_image", c1438o.m5342b(this.f2497n.f2626A.f2834f.f2849a));
                this.f2492i.m5277b("advertiser_name", this.f2497n.f2626A.f2831c);
                this.f2492i.m5277b("description", this.f2497n.f2626A.f2832d);
                this.f2492i.m5277b(DatabaseOpenHelper.HISTORY_ROW_TITLE, this.f2497n.f2626A.f2833e);
                this.f2492i.m5278b("click_to_install", this.f2497n.f2626A.f2835g.f2847c.equals("install"));
                this.f2492i.m5277b("store_url", this.f2497n.f2626A.f2835g.f2848d);
                this.f2492i.m5278b("native_engagement_enabled", this.f2497n.f2626A.f2836h.f2840a);
                this.f2492i.m5277b("native_engagement_type", this.f2497n.f2626A.f2836h.f2842c);
                this.f2492i.m5277b("native_engagement_command", this.f2497n.f2626A.f2836h.f2844e);
                this.f2492i.m5277b("native_engagement_label", this.f2497n.f2626A.f2836h.f2843d);
                this.f2492i.m5277b("skip_video_image_normal", c1438o.m5342b(acVar.f2671l.f2764f));
                this.f2492i.m5277b("skip_video_image_down", c1438o.m5342b(acVar.f2671l.f2766h));
                this.f2492i.m5277b("engagement_image_normal", c1438o.m5342b(acVar.f2672m.f2764f));
                this.f2492i.m5277b("engagement_image_down", c1438o.m5342b(acVar.f2672m.f2766h));
                this.f2492i.m5276b("engagement_height", acVar.f2672m.f2761c);
                this.f2492i.m5278b("image_overlay_enabled", acVar.f2673n.f2759a);
                this.f2492i.m5277b("image_overlay_filepath", c1438o.m5342b(acVar.f2673n.f2764f));
                this.f2492i.m5278b("haptics_enabled", acVar.f2674o.f2795a);
                this.f2492i.m5277b("haptics_filepath", c1438o.m5342b(acVar.f2674o.f2797c));
                this.f2492i.m5278b("v4iap_enabled", this.f2497n.f2627B.f2656c);
                this.f2492i.m5277b("product_id", this.f2497n.f2627B.f2654a);
                this.f2492i.m5277b("in_progress", this.f2497n.f2627B.f2655b);
                m2543b();
            }
        }
    }

    void m2545c(String str) {
        this.f2496m = this.f2485a.f2513b.f4599i.f2749n.m2716a(str);
        this.f2497n = this.f2496m.m2709k();
        C1438o c1438o = this.f2485a.f2514c;
        ac acVar = this.f2497n.f2653z;
        this.f2492i.m5278b("video_enabled", acVar.f2660a);
        this.f2492i.m5277b("video_filepath", acVar.m2690b());
        this.f2492i.m5276b("video_width", acVar.f2661b);
        this.f2492i.m5276b("video_height", acVar.f2662c);
        this.f2492i.m5275b("video_duration", acVar.f2670k);
        C0694a.f2377q = acVar.f2670k;
        this.f2492i.m5276b("engagement_delay", acVar.f2672m.f2763e);
        this.f2492i.m5276b("skip_delay", acVar.f2671l.f2763e);
        m2543b();
        C0732c c0732c = this.f2497n.f2650w;
        this.f2492i.m5277b("pre_popup_bg", c1438o.m5342b(c0732c.f2733b.f2885d.f2872e));
        this.f2492i.m5277b("v4vc_logo", c1438o.m5342b(c0732c.f2733b.f2885d.f2879l.f2802d));
        this.f2492i.m5277b("no_button_normal", c1438o.m5342b(c0732c.f2733b.f2885d.f2881n.f2764f));
        this.f2492i.m5277b("no_button_down", c1438o.m5342b(c0732c.f2733b.f2885d.f2881n.f2766h));
        this.f2492i.m5277b("yes_button_normal", c1438o.m5342b(c0732c.f2733b.f2885d.f2880m.f2764f));
        this.f2492i.m5277b("yes_button_down", c1438o.m5342b(c0732c.f2733b.f2885d.f2880m.f2766h));
        this.f2492i.m5277b("done_button_normal", c1438o.m5342b(c0732c.f2734c.f2867d.f2863m.f2764f));
        this.f2492i.m5277b("done_button_down", c1438o.m5342b(c0732c.f2734c.f2867d.f2863m.f2766h));
        this.f2492i.m5277b("browser_close_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2815k.f2764f));
        this.f2492i.m5277b("browser_close_image_down", c1438o.m5342b(this.f2497n.f2649v.f2815k.f2766h));
        this.f2492i.m5277b("browser_reload_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2817m.f2764f));
        this.f2492i.m5277b("browser_reload_image_down", c1438o.m5342b(this.f2497n.f2649v.f2817m.f2766h));
        this.f2492i.m5277b("browser_back_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2814j.f2764f));
        this.f2492i.m5277b("browser_back_image_down", c1438o.m5342b(this.f2497n.f2649v.f2814j.f2766h));
        this.f2492i.m5277b("browser_forward_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2816l.f2764f));
        this.f2492i.m5277b("browser_forward_image_down", c1438o.m5342b(this.f2497n.f2649v.f2816l.f2766h));
        this.f2492i.m5277b("browser_stop_image_normal", c1438o.m5342b(this.f2497n.f2649v.f2813i.f2764f));
        this.f2492i.m5277b("browser_stop_image_down", c1438o.m5342b(this.f2497n.f2649v.f2813i.f2766h));
        this.f2492i.m5277b("browser_glow_button", c1438o.m5342b(this.f2497n.f2649v.f2805a));
        this.f2492i.m5277b("browser_icon", c1438o.m5342b(this.f2497n.f2649v.f2812h.f2802d));
        this.f2492i.m5277b("skip_video_image_normal", c1438o.m5342b(acVar.f2671l.f2764f));
        this.f2492i.m5277b("skip_video_image_down", c1438o.m5342b(acVar.f2671l.f2766h));
        this.f2492i.m5277b("engagement_image_normal", c1438o.m5342b(acVar.f2672m.f2764f));
        this.f2492i.m5277b("engagement_image_down", c1438o.m5342b(acVar.f2672m.f2766h));
        this.f2492i.m5276b("engagement_height", acVar.f2672m.f2761c);
        this.f2492i.m5278b("image_overlay_enabled", acVar.f2673n.f2759a);
        this.f2492i.m5277b("image_overlay_filepath", c1438o.m5342b(acVar.f2673n.f2764f));
        this.f2492i.m5278b("haptics_enabled", acVar.f2674o.f2795a);
        this.f2492i.m5277b("haptics_filepath", c1438o.m5342b(acVar.f2674o.f2797c));
        this.f2492i.m5278b("v4iap_enabled", this.f2497n.f2627B.f2656c);
        this.f2492i.m5277b("product_id", this.f2497n.f2627B.f2654a);
        this.f2492i.m5277b("in_progress", this.f2497n.f2627B.f2655b);
    }

    void m2543b() {
        C0753x c0753x = this.f2497n.f2652y.f2782h;
        C0739j c0739j = this.f2497n.f2652y.f2783i;
        C1438o c1438o = this.f2485a.f2514c;
        if (this.f2497n.f2652y.f2778d) {
            if (c0739j.m2745a()) {
                C0694a.f2359Y = true;
                C0694a.ad = c0739j.f2791g;
                C0694a.ae = c1438o.m5342b(c0739j.f2790f.f2827b);
                this.f2492i.m5277b("close_image_normal", c1438o.m5342b(c0739j.f2794j.f2764f));
                this.f2492i.m5277b("close_image_down", c1438o.m5342b(c0739j.f2794j.f2766h));
                this.f2492i.m5277b("reload_image_normal", c1438o.m5342b(c0739j.f2793i.f2764f));
                this.f2492i.m5277b("reload_image_down", c1438o.m5342b(c0739j.f2793i.f2766h));
            } else {
                C0694a.f2359Y = false;
                this.f2492i.m5277b("end_card_filepath", c1438o.m5342b(c0753x.f2889d));
                this.f2492i.m5277b("info_image_normal", c1438o.m5342b(c0753x.f2891f.f2764f));
                this.f2492i.m5277b("info_image_down", c1438o.m5342b(c0753x.f2891f.f2766h));
                this.f2492i.m5277b("info_url", c0753x.f2891f.f2768j);
                this.f2492i.m5277b("replay_image_normal", c1438o.m5342b(c0753x.f2893h.f2764f));
                this.f2492i.m5277b("replay_image_down", c1438o.m5342b(c0753x.f2893h.f2766h));
                this.f2492i.m5277b("continue_image_normal", c1438o.m5342b(c0753x.f2894i.f2764f));
                this.f2492i.m5277b("continue_image_down", c1438o.m5342b(c0753x.f2894i.f2766h));
                this.f2492i.m5277b("download_image_normal", c1438o.m5342b(c0753x.f2892g.f2764f));
                this.f2492i.m5277b("download_image_down", c1438o.m5342b(c0753x.f2892g.f2766h));
                this.f2492i.m5277b("download_url", c0753x.f2892g.f2768j);
            }
            ac acVar = this.f2497n.f2653z;
            this.f2492i.m5278b("end_card_enabled", this.f2497n.f2652y.f2778d);
            this.f2492i.m5278b("load_timeout_enabled", this.f2497n.f2652y.f2783i.f2787c);
            this.f2492i.m5275b("load_timeout", this.f2497n.f2652y.f2783i.f2786b);
            this.f2492i.m5278b("hardware_acceleration_disabled", this.f2485a.f2513b.f4599i.f2740e);
            return;
        }
        this.f2492i.m5278b("end_card_enabled", this.f2497n.f2652y.f2778d);
    }
}
