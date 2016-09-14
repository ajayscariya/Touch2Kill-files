package com.jirbo.adcolony;

import com.immersion.hapticmediasdk.HapticContentSDK;
import com.jirbo.adcolony.ADCData.C0670i;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.ADCDownload.Listener;
import com.jirbo.adcolony.C0756n.C0735f;
import com.jirbo.adcolony.C0756n.C0754y;
import com.jirbo.adcolony.C0756n.ad;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;

/* renamed from: com.jirbo.adcolony.t */
class C1439t implements Listener {
    C0711d f4629a;
    ArrayList<C0762a> f4630b;
    ArrayList<C0762a> f4631c;
    int f4632d;
    boolean f4633e;
    int f4634f;
    HashMap<Integer, Boolean> f4635g;

    /* renamed from: com.jirbo.adcolony.t.a */
    static class C0762a {
        String f2949a;
        String f2950b;
        String f2951c;
        String f2952d;
        double f2953e;
        int f2954f;
        int f2955g;
        int f2956h;
        int f2957i;
        boolean f2958j;
        boolean f2959k;
        boolean f2960l;

        C0762a() {
            this.f2957i = -1;
        }
    }

    C1439t(C0711d c0711d) {
        this.f4630b = new ArrayList();
        this.f4631c = new ArrayList();
        this.f4632d = 0;
        this.f4633e = false;
        this.f4635g = new HashMap();
        this.f4629a = c0711d;
    }

    void m5354a(String str, AdColonyAd adColonyAd) {
        if (this.f4629a != null && this.f4629a.f2513b != null && this.f4629a.f2513b.f4599i != null && this.f4629a.f2513b.f4599i.f2749n != null && this.f4629a.f2513b.f4599i.f2749n.m2716a(str) != null) {
            C0726l.f2610a.m2653a("Ad request for zone ").m2657b((Object) str);
            ad a = this.f4629a.f2513b.f4599i.f2749n.m2716a(str);
            if (a != null && a.f2686l != null && a.f2686l.f2694a != null) {
                C1423g c1423g = new C1423g();
                if (adColonyAd.f2211g == 0) {
                    c1423g.m5278b("request_denied", false);
                } else {
                    c1423g.m5278b("request_denied", true);
                }
                c1423g.m5276b("request_denied_reason", adColonyAd.f2211g);
                m5356a("request", a.f2686l.f2694a, c1423g, adColonyAd);
                C0726l.f2610a.m2653a("Tracking ad request - URL : ").m2657b(a.f2686l.f2694a);
            }
        }
    }

    void m5352a(String str, C1423g c1423g) {
        C0735f c0735f = this.f4629a.f2513b.f4599i.f2746k;
        if (c0735f != null) {
            m5355a(str, c0735f.f2758h.m5281e(str), c1423g);
        }
        C0754y c0754y = this.f4629a.f2513b.f4599i.f2747l;
        if (c0754y != null) {
            m5357a(str, (ArrayList) c0754y.f2898d.get(str));
        }
    }

    void m5359b(String str, AdColonyAd adColonyAd) {
        m5353a(str, null, adColonyAd);
    }

    void m5353a(String str, C1423g c1423g, AdColonyAd adColonyAd) {
        if (str == null) {
            C0726l.f2613d.m2657b((Object) "No such event type:").m2657b((Object) str);
            return;
        }
        if (str.equals("start") || str.equals("native_start")) {
            C0763u c0763u = C0694a.f2372l.f2516e;
            c0763u.f2970j++;
        }
        if (c1423g == null) {
            c1423g = new C1423g();
            c1423g.m5278b("replay", adColonyAd.f2225u);
        }
        c1423g.m5276b("s_imp_count", C0694a.f2372l.f2516e.f2970j);
        m5356a(str, (String) adColonyAd.f2208A.get(str), c1423g, adColonyAd);
        m5357a(str, (ArrayList) adColonyAd.f2209B.get(str));
    }

    void m5355a(String str, String str2, C1423g c1423g) {
        m5356a(str, str2, c1423g, null);
    }

    void m5356a(String str, String str2, C1423g c1423g, AdColonyAd adColonyAd) {
        if (str2 != null && !str2.equals(XMLConstants.NULL_NS_URI)) {
            C0762a c0762a;
            if (c1423g == null) {
                c1423g = new C1423g();
            }
            String b = aa.m2481b();
            if (adColonyAd != null) {
                c1423g.m5277b("asi", adColonyAd.f2217m);
            }
            double c = aa.m2483c() - this.f4629a.f2516e.f2967g;
            if (c <= 0.0d || c < 604800.0d) {
                c1423g.m5275b("s_time", C0694a.f2372l.f2516e.f2969i);
                c1423g.m5277b("sid", this.f4629a.f2516e.f2971k);
                c1423g.m5277b("guid", b);
                c1423g.m5277b("guid_key", aa.m2482b(b + "DUBu6wJ27y6xs7VWmNDw67DD"));
                c0762a = new C0762a();
                c0762a.f2949a = str;
                c0762a.f2950b = str2;
                C0726l.f2610a.m2657b((Object) "EVENT ---------------------------");
                C0726l.f2610a.m2653a("EVENT - TYPE = ").m2657b((Object) str);
                C0726l.f2610a.m2653a("EVENT - URL  = ").m2657b((Object) str2);
                c0762a.f2951c = c1423g.m2399q();
            } else {
                c1423g.m5275b("s_time", C0694a.f2372l.f2516e.f2969i);
                c1423g.m5277b("sid", this.f4629a.f2516e.f2971k);
                c1423g.m5277b("guid", b);
                c1423g.m5277b("guid_key", aa.m2482b(b + "DUBu6wJ27y6xs7VWmNDw67DD"));
                c0762a = new C0762a();
                c0762a.f2949a = str;
                c0762a.f2950b = str2;
                C0726l.f2610a.m2657b((Object) "EVENT ---------------------------");
                C0726l.f2610a.m2653a("EVENT - TYPE = ").m2657b((Object) str);
                C0726l.f2610a.m2653a("EVENT - URL  = ").m2657b((Object) str2);
                c0762a.f2951c = c1423g.m2399q();
            }
            if (str.equals("reward_v4vc")) {
                c0762a.f2952d = c1423g.m5281e("v4vc_name");
                c0762a.f2956h = c1423g.m5283g("v4vc_amount");
            }
            this.f4630b.add(c0762a);
            this.f4633e = true;
            C0694a.f2386z = true;
        }
    }

    void m5357a(String str, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                String str2 = (String) arrayList.get(i);
                C0762a c0762a = new C0762a();
                c0762a.f2949a = str;
                c0762a.f2950b = str2;
                c0762a.f2960l = true;
                this.f4630b.add(c0762a);
            }
            this.f4633e = true;
            C0694a.f2386z = true;
        }
    }

    void m5351a(double d, AdColonyAd adColonyAd) {
        double d2 = adColonyAd.f2220p;
        if (d >= d2) {
            if (d2 < 0.25d && d >= 0.25d) {
                if (AdColony.isZoneV4VC(adColonyAd.f2212h) || !adColonyAd.f2216l.equals("native")) {
                    m5359b("first_quartile", adColonyAd);
                } else {
                    m5359b("native_first_quartile", adColonyAd);
                }
            }
            if (d2 < 0.5d && d >= 0.5d) {
                if (AdColony.isZoneV4VC(adColonyAd.f2212h) || !adColonyAd.f2216l.equals("native")) {
                    m5359b("midpoint", adColonyAd);
                } else {
                    m5359b("native_midpoint", adColonyAd);
                }
            }
            if (d2 < 0.75d && d >= 0.75d) {
                if (AdColony.isZoneV4VC(adColonyAd.f2212h) || !adColonyAd.f2216l.equals("native")) {
                    m5359b("third_quartile", adColonyAd);
                } else {
                    m5359b("native_third_quartile", adColonyAd);
                }
            }
            if (d2 < 1.0d && d >= 1.0d && !adColonyAd.f2216l.equals("native")) {
                C0726l.f2610a.m2653a("Tracking ad event - complete");
                C1423g c1423g = new C1423g();
                if (adColonyAd.f2224t) {
                    c1423g.m5276b("ad_slot", C0694a.f2372l.f2516e.f2970j);
                } else {
                    c1423g.m5276b("ad_slot", C0694a.f2372l.f2516e.f2970j);
                }
                c1423g.m5278b("replay", adColonyAd.f2225u);
                m5353a("complete", c1423g, adColonyAd);
                adColonyAd.f2214j.f2645r = false;
            }
            adColonyAd.f2220p = d;
        }
    }

    void m5350a() {
        m5358b();
        this.f4632d = 0;
    }

    void m5358b() {
        C0694a.f2386z = true;
        C1419c c = C0725k.m2640c(new C0720f("tracking_info.txt"));
        if (c != null) {
            this.f4630b.clear();
            for (int i = 0; i < c.m5250i(); i++) {
                C1423g b = c.m5241b(i);
                C0762a c0762a = new C0762a();
                c0762a.f2949a = b.m5281e("type");
                c0762a.f2950b = b.m5281e(DatabaseOpenHelper.HISTORY_ROW_URL);
                c0762a.f2951c = b.m5268a("payload", null);
                c0762a.f2954f = b.m5283g("attempts");
                c0762a.f2960l = b.m5285h("third_party");
                if (c0762a.f2949a.equals("v4vc_callback") || c0762a.f2949a.equals("reward_v4vc")) {
                    c0762a.f2952d = b.m5281e("v4vc_name");
                    c0762a.f2956h = b.m5283g("v4vc_amount");
                }
                this.f4630b.add(c0762a);
            }
        }
        C0726l.f2610a.m2653a("Loaded ").m2651a(this.f4630b.size()).m2657b((Object) " events");
    }

    void m5360c() {
        this.f4631c.clear();
        this.f4631c.addAll(this.f4630b);
        this.f4630b.clear();
        C1419c c1419c = new C1419c();
        for (int i = 0; i < this.f4631c.size(); i++) {
            C0762a c0762a = (C0762a) this.f4631c.get(i);
            if (!c0762a.f2958j) {
                this.f4630b.add(c0762a);
                C0670i c1423g = new C1423g();
                c1423g.m5277b("type", c0762a.f2949a);
                c1423g.m5277b(DatabaseOpenHelper.HISTORY_ROW_URL, c0762a.f2950b);
                if (c0762a.f2951c != null) {
                    c1423g.m5277b("payload", c0762a.f2951c);
                }
                c1423g.m5276b("attempts", c0762a.f2954f);
                if (c0762a.f2952d != null) {
                    c1423g.m5277b("v4vc_name", c0762a.f2952d);
                    c1423g.m5276b("v4vc_amount", c0762a.f2956h);
                }
                if (c0762a.f2960l) {
                    c1423g.m5278b("third_party", true);
                }
                c1419c.m5234a(c1423g);
            }
        }
        this.f4631c.clear();
        C0726l.f2610a.m2653a("Saving tracking_info (").m2651a(this.f4630b.size()).m2657b((Object) " events)");
        C0725k.m2633a(new C0720f("tracking_info.txt"), c1419c);
    }

    void m5361d() {
        if (this.f4633e) {
            this.f4633e = false;
            m5360c();
        }
        m5362e();
    }

    void m5362e() {
        if (this.f4630b.size() != 0) {
            while (this.f4630b.size() > 1000) {
                this.f4630b.remove(this.f4630b.size() - 1);
            }
            if (C0760q.m2793c()) {
                double c = aa.m2483c();
                for (int i = 0; i < this.f4630b.size(); i++) {
                    C0762a c0762a = (C0762a) this.f4630b.get(i);
                    if (c0762a.f2953e < c && !c0762a.f2959k) {
                        if (this.f4632d != 5) {
                            this.f4632d++;
                            c0762a.f2959k = true;
                            if (c0762a.f2949a.equals("v4vc_callback")) {
                                int i2 = this.f4634f;
                                this.f4634f = i2 + 1;
                                c0762a.f2957i = i2;
                                this.f4635g.put(Integer.valueOf(c0762a.f2957i), Boolean.valueOf(C0694a.f2375o));
                            }
                            ADCDownload a = new ADCDownload(this.f4629a, c0762a.f2950b, this).m5295a(c0762a);
                            if (c0762a.f2960l) {
                                a.f4520h = true;
                            }
                            if (c0762a.f2951c != null) {
                                a.m5296a("application/json", c0762a.f2951c);
                            }
                            C0726l.f2611b.m2653a("Submitting '").m2653a(c0762a.f2949a).m2657b((Object) "' event.");
                            a.m5298b();
                            C0694a.f2386z = true;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void on_download_finished(ADCDownload download) {
        boolean z;
        C0694a.f2386z = true;
        this.f4633e = true;
        this.f4632d--;
        C0762a c0762a = (C0762a) download.f4517e;
        C0726l.f2610a.m2653a("on_download_finished - event.type = ").m2657b(c0762a.f2949a);
        c0762a.f2959k = false;
        boolean z2 = download.f4521i;
        if (z2 && c0762a.f2951c != null) {
            C1423g b = C0725k.m2638b(download.f4526n);
            if (b != null) {
                z2 = b.m5281e(NotificationCompatApi21.CATEGORY_STATUS).equals("success");
                if (z2 && c0762a.f2949a.equals("reward_v4vc")) {
                    if (b.m5285h("v4vc_status")) {
                        String e = b.m5281e("v4vc_callback");
                        if (e.length() > 0) {
                            C0762a c0762a2 = new C0762a();
                            c0762a2.f2949a = "v4vc_callback";
                            c0762a2.f2950b = e;
                            c0762a2.f2952d = c0762a.f2952d;
                            c0762a2.f2956h = c0762a.f2956h;
                            this.f4630b.add(c0762a2);
                        } else {
                            if (C0694a.f2355U != null) {
                                C0694a.f2355U.f4566o = true;
                            }
                            C0726l.f2610a.m2657b((Object) "Client-side V4VC success");
                        }
                    } else {
                        C0726l.f2610a.m2657b((Object) "Client-side V4VC failure");
                    }
                }
            } else {
                z2 = false;
            }
        }
        if (z2 && c0762a.f2949a.equals("v4vc_callback")) {
            C0726l.f2610a.m2657b((Object) "v4vc_callback response:").m2657b(download.f4526n);
            if (download.f4526n.indexOf("vc_success") != -1 && ((Boolean) this.f4635g.get(Integer.valueOf(c0762a.f2957i))).booleanValue()) {
                if (C0694a.f2355U != null) {
                    C0694a.f2355U.f4566o = true;
                }
                C0726l.f2610a.m2657b((Object) "v4vc_callback success");
                this.f4629a.m2559a(true, c0762a.f2952d, c0762a.f2956h);
                z = z2;
            } else if (download.f4526n.indexOf("vc_decline") == -1 && download.f4526n.indexOf("vc_noreward") == -1) {
                C0726l.f2612c.m2653a("Server-side V4VC failure: ").m2657b(download.f4515c);
                z = false;
            } else {
                C0726l.f2612c.m2653a("Server-side V4VC failure: ").m2657b(download.f4515c);
                C0726l.f2610a.m2657b((Object) "v4vc_callback declined");
                this.f4629a.m2559a(false, XMLConstants.NULL_NS_URI, 0);
                z = z2;
            }
        } else {
            z = z2;
        }
        if (z) {
            C0726l.f2610a.m2653a("Event submission SUCCESS for type: ").m2657b(c0762a.f2949a);
            c0762a.f2958j = true;
        } else {
            C0726l.f2610a.m2653a("Event submission FAILED for type: ").m2653a(c0762a.f2949a).m2653a(" on try ").m2656b(c0762a.f2954f + 1);
            c0762a.f2954f++;
            if (c0762a.f2954f >= 24) {
                C0726l.f2613d.m2657b((Object) "Discarding event after 24 attempts to report.");
                c0762a.f2958j = true;
                if (c0762a.f2949a.equals("v4vc_callback")) {
                    this.f4629a.m2559a(false, XMLConstants.NULL_NS_URI, 0);
                }
            } else {
                int i = 20;
                if (c0762a.f2955g > 0) {
                    i = c0762a.f2955g * 3;
                }
                if (i > HapticContentSDK.f1228b04440444044404440444) {
                    i = HapticContentSDK.f1228b04440444044404440444;
                }
                C0726l.f2610a.m2653a("Retrying in ").m2651a(i).m2653a(" seconds (attempt ").m2651a(c0762a.f2954f).m2657b((Object) ")");
                c0762a.f2955g = i;
                c0762a.f2953e = aa.m2483c() + ((double) i);
            }
        }
        if (!this.f4629a.f2516e.f2962b) {
            m5360c();
        }
    }
}
