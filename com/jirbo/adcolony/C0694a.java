package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.C0759p.C0758a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.jirbo.adcolony.a */
class C0694a {
    static boolean f2335A = false;
    static boolean f2336B = false;
    static boolean f2337C = false;
    static boolean f2338D = false;
    static boolean f2339E = false;
    static int f2340F = 0;
    static double f2341G = 0.0d;
    static boolean f2342H = false;
    static boolean f2343I = false;
    static boolean f2344J = false;
    static boolean f2345K = false;
    static boolean f2346L = false;
    static boolean f2347M = false;
    static boolean f2348N = false;
    static boolean f2349O = false;
    static Activity f2350P = null;
    static boolean f2351Q = false;
    static boolean f2352R = false;
    static C0722h f2353S = null;
    static AdColonyAd f2354T = null;
    static ADCVideo f2355U = null;
    static ADCVideo f2356V = null;
    static C0692a f2357W = null;
    static C0693b f2358X = null;
    static boolean f2359Y = false;
    static boolean f2360Z = false;
    public static final boolean f2361a = false;
    static boolean aa = false;
    static boolean ab = false;
    static int ac = 0;
    static String ad = null;
    static String ae = null;
    static String af = null;
    static String ag = null;
    static String ah = null;
    static ArrayList<String> ai = null;
    static C1419c aj = null;
    static boolean ak = false;
    static long al = 0;
    static int am = 0;
    static ArrayList<Bitmap> an = null;
    static ArrayList<AdColonyV4VCListener> ao = null;
    static ArrayList<AdColonyAdAvailabilityListener> ap = null;
    static ArrayList<AdColonyNativeAdView> aq = null;
    static HashMap ar = null;
    public static final boolean f2362b = false;
    public static final boolean f2363c = false;
    public static final boolean f2364d = false;
    public static String f2365e = null;
    public static final String f2366f;
    public static final int f2367g = 0;
    public static final int f2368h = 1;
    public static final int f2369i = 2;
    public static final int f2370j = 3;
    static final String f2371k = "AdColony";
    static C0711d f2372l;
    static boolean f2373m;
    static int f2374n;
    static boolean f2375o;
    static boolean f2376p;
    static double f2377q;
    static boolean f2378r;
    static boolean f2379s;
    static long f2380t;
    static long f2381u;
    static AdColonyAd f2382v;
    static boolean f2383w;
    static boolean f2384x;
    static boolean f2385y;
    static boolean f2386z;

    /* renamed from: com.jirbo.adcolony.a.a */
    static class C0692a extends Handler {
        AdColonyAd f2334a;

        C0692a() {
        }

        public void m2437a(AdColonyAd adColonyAd) {
            if (adColonyAd == null) {
                this.f2334a = C0694a.f2354T;
            } else {
                this.f2334a = adColonyAd;
            }
            sendMessage(obtainMessage(C0694a.f2368h));
        }

        public void m2438b(AdColonyAd adColonyAd) {
            if (adColonyAd == null) {
                this.f2334a = C0694a.f2354T;
            } else {
                this.f2334a = adColonyAd;
            }
            sendMessage(obtainMessage(C0694a.f2367g));
        }

        public void handleMessage(Message m) {
            switch (m.what) {
                case C0694a.f2367g /*0*/:
                    C0694a.m2448a(SchemaSymbols.ATTVAL_SKIP, this.f2334a);
                    if (C0694a.f2354T != null) {
                        C0694a.f2354T.f2210f = C0694a.f2368h;
                        C0694a.f2354T.m2419a();
                    }
                case C0694a.f2368h /*1*/:
                    C1423g c1423g = new C1423g();
                    if (C0694a.f2356V.f4543H.f2423Q) {
                        c1423g.m5278b("html5_endcard_loading_started", C0694a.f2356V.f4562k);
                    }
                    if (C0694a.f2356V.f4543H.f2423Q) {
                        c1423g.m5278b("html5_endcard_loading_finished", C0694a.f2356V.f4563l);
                    }
                    if (C0694a.f2356V.f4543H.f2423Q) {
                        c1423g.m5275b("html5_endcard_loading_time", C0694a.f2356V.f4567p);
                    }
                    if (C0694a.f2356V.f4543H.f2423Q) {
                        c1423g.m5278b("html5_endcard_loading_timeout", C0694a.f2356V.f4564m);
                    }
                    if (C0694a.f2356V.f4568q < 60000.0d) {
                        c1423g.m5275b("endcard_time_spent", C0694a.f2356V.f4568q);
                    }
                    c1423g.m5278b("endcard_dissolved", C0694a.f2356V.f4565n);
                    ADCVideo aDCVideo = C0694a.f2356V;
                    c1423g.m5278b("replay", ADCVideo.f4531e);
                    c1423g.m5278b("reward", C0694a.f2356V.f4566o);
                    C0694a.f2372l.f2515d.m5353a("continue", c1423g, this.f2334a);
                    if (C0694a.f2354T != null) {
                        C0694a.f2354T.f2210f = 4;
                        C0694a.f2354T.m2419a();
                    }
                default:
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.a.b */
    static class C0693b extends Handler {
        C0693b() {
        }

        public void handleMessage(Message m) {
            int i = C0694a.f2367g;
            String str = (String) m.obj;
            int i2 = m.what;
            boolean z = str != null ? true : C0694a.f2364d;
            if (!z) {
                str = XMLConstants.NULL_NS_URI;
            }
            AdColonyV4VCReward adColonyV4VCReward = new AdColonyV4VCReward(z, str, i2);
            while (i < C0694a.ao.size()) {
                ((AdColonyV4VCListener) C0694a.ao.get(i)).onAdColonyV4VCReward(adColonyV4VCReward);
                i += C0694a.f2368h;
            }
        }

        public void m2439a(boolean z, String str, int i) {
            if (!z) {
                str = null;
            }
            sendMessage(obtainMessage(i, str));
        }
    }

    C0694a() {
    }

    static {
        f2365e = null;
        f2366f = null;
        f2372l = new C0711d();
        f2374n = f2369i;
        f2338D = f2364d;
        f2339E = true;
        f2340F = f2367g;
        f2341G = 1.0d;
        f2342H = f2364d;
        f2343I = f2364d;
        f2344J = f2364d;
        f2345K = f2364d;
        f2346L = true;
        f2349O = f2364d;
        ai = new ArrayList();
        aj = new C1419c();
        am = f2367g;
        an = new ArrayList();
        ao = new ArrayList();
        ap = new ArrayList();
        aq = new ArrayList();
    }

    static void m2442a(Activity activity) {
        if (activity != f2350P && activity != null) {
            f2350P = activity;
            f2357W = new C0692a();
            f2358X = new C0693b();
            if (!f2379s) {
                C0758a c0758a = new C0758a();
            }
        }
    }

    static void m2453b(Activity activity) {
        f2384x = f2364d;
        C0694a.m2442a(activity);
        f2353S = null;
        f2373m = C0721g.m2610i();
        if (f2351Q) {
            f2351Q = f2364d;
            f2383w = f2364d;
            f2372l = new C0711d();
        }
    }

    static boolean m2451a() {
        if (f2350P == null) {
            return true;
        }
        return f2364d;
    }

    static Activity m2452b() {
        if (f2350P != null) {
            return f2350P;
        }
        throw new AdColonyException("AdColony.configure() must be called before any other AdColony methods. If you have called AdColony.configure(), the Activity reference you passed in via AdColony.configure()/AdColony.resume() is null OR you have not called AdColony.resume() as appropriate.");
    }

    static boolean m2457c() {
        return (f2351Q || f2385y || !f2383w) ? true : f2364d;
    }

    static boolean m2459d() {
        return (!f2383w || f2351Q || f2385y) ? f2364d : true;
    }

    static void m2447a(String str) {
        f2351Q = true;
        C0694a.m2461e(str);
    }

    static void m2446a(RuntimeException runtimeException) {
        f2351Q = true;
        C0694a.m2461e(runtimeException.toString());
        runtimeException.printStackTrace();
    }

    static void m2460e() {
        C0694a.m2452b();
    }

    static void m2440a(int i) {
        boolean z;
        boolean z2 = f2364d;
        f2374n = i;
        C0726l.f2610a.f2615f = i <= 0 ? true : f2364d;
        C0726l c0726l = C0726l.f2611b;
        if (i <= f2368h) {
            z = true;
        } else {
            z = f2364d;
        }
        c0726l.f2615f = z;
        c0726l = C0726l.f2612c;
        if (i <= f2369i) {
            z = true;
        } else {
            z = f2364d;
        }
        c0726l.f2615f = z;
        C0726l c0726l2 = C0726l.f2613d;
        if (i <= f2370j) {
            z2 = true;
        }
        c0726l2.f2615f = z2;
        if (i <= 0) {
            C0694a.m2454b("DEVELOPER LOGGING ENABLED");
        }
        if (i <= f2368h) {
            C0694a.m2456c("DEBUG LOGGING ENABLED");
        }
    }

    static boolean m2455b(int i) {
        return f2374n <= i ? true : f2364d;
    }

    static boolean m2463f() {
        return f2374n <= 0 ? true : f2364d;
    }

    static boolean m2465g() {
        return f2374n <= f2368h ? true : f2364d;
    }

    static void m2441a(int i, String str) {
        if (f2374n <= i) {
            switch (i) {
                case f2367g /*0*/:
                case f2368h /*1*/:
                    Log.d(f2371k, str);
                case f2369i /*2*/:
                    Log.i(f2371k, str);
                case f2370j /*3*/:
                    Log.e(f2371k, str);
                default:
            }
        }
    }

    static void m2454b(String str) {
        C0694a.m2441a((int) f2367g, str);
    }

    static void m2456c(String str) {
        C0694a.m2441a((int) f2368h, str);
    }

    static void m2458d(String str) {
        C0694a.m2441a((int) f2369i, str);
    }

    static void m2461e(String str) {
        C0694a.m2441a((int) f2370j, str);
    }

    static void m2462f(String str) {
        Toast.makeText(C0694a.m2452b(), str, f2367g).show();
    }

    static double m2464g(String str) {
        return f2372l.m2546a(str);
    }

    static int m2466h(String str) {
        return f2372l.m2561b(str);
    }

    static boolean m2468i(String str) {
        return f2372l.m2569c(str);
    }

    static String m2469j(String str) {
        return f2372l.m2570d(str);
    }

    static void m2470k(String str) {
        f2372l.m2555a(str, null);
    }

    static void m2449a(String str, String str2) {
        f2372l.m2555a(str, str2);
    }

    static void m2448a(String str, AdColonyAd adColonyAd) {
        f2372l.m2556a(str, null, adColonyAd);
    }

    static void m2450a(String str, String str2, AdColonyAd adColonyAd) {
        f2372l.m2556a(str, str2, adColonyAd);
    }

    static void m2467h() {
        if (f2372l != null && ap.size() != 0 && ar != null) {
            for (Entry entry : ar.entrySet()) {
                boolean b;
                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                if (AdColony.isZoneV4VC((String) entry.getKey())) {
                    b = f2372l.m2567b((String) entry.getKey(), true, f2364d);
                } else {
                    b = f2372l.m2560a((String) entry.getKey(), true, (boolean) f2364d);
                }
                boolean b2 = (!AdColony.isZoneNative((String) entry.getKey()) || f2350P == null) ? f2350P == null ? f2364d : b : new AdColonyNativeAdView(C0694a.m2452b(), (String) entry.getKey(), 300, true).m2434b(true);
                if (booleanValue != b2) {
                    ar.put(entry.getKey(), Boolean.valueOf(b2));
                    for (int i = f2367g; i < ap.size(); i += f2368h) {
                        ((AdColonyAdAvailabilityListener) ap.get(i)).onAdColonyAdAvailabilityChange(b2, (String) entry.getKey());
                    }
                }
            }
        }
    }

    static void m2443a(AdColonyAd adColonyAd) {
        f2382v = adColonyAd;
    }

    static void m2444a(AdColonyNativeAdView adColonyNativeAdView) {
        aq.add(adColonyNativeAdView);
    }

    static void m2445a(C0724j c0724j) {
        f2372l.m2554a(c0724j);
    }
}
