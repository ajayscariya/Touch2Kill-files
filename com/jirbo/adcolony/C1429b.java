package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Looper;
import com.google.android.gcm.GCMConstants;
import com.jirbo.adcolony.ADCData.C0670i;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.ADCDownload.Listener;
import com.jirbo.adcolony.C0756n.C0730a;
import com.jirbo.adcolony.C0756n.C0734e;
import com.jirbo.adcolony.C0756n.ad;
import java.util.Iterator;
import mf.javax.xml.XMLConstants;

/* renamed from: com.jirbo.adcolony.b */
class C1429b implements Listener {
    C0711d f4591a;
    boolean f4592b;
    boolean f4593c;
    boolean f4594d;
    boolean f4595e;
    boolean f4596f;
    boolean f4597g;
    double f4598h;
    C0734e f4599i;

    /* renamed from: com.jirbo.adcolony.b.1 */
    class C07081 implements Runnable {
        final /* synthetic */ C1429b f2467a;

        C07081(C1429b c1429b) {
            this.f2467a = c1429b;
        }

        public void run() {
            for (int i = 0; i < 500 && C0694a.m2451a(); i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    C1429b(C0711d c0711d) {
        this.f4595e = true;
        this.f4596f = false;
        this.f4597g = true;
        this.f4599i = new C0734e();
        this.f4591a = c0711d;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
    }

    void m5315a() {
    }

    void m5320b() {
        C0726l.f2611b.m2657b((Object) "Attempting to load backup manifest from file.");
        C0720f c0720f = new C0720f("manifest.txt");
        C1423g b = C0725k.m2637b(c0720f);
        if (b != null) {
            boolean z;
            C1419c c = b.m5274b(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).m5279c("zones");
            if (c != null) {
                for (int i = 0; i < c.m5250i(); i++) {
                    C1423g b2 = c.m5241b(i);
                    boolean z2 = false;
                    for (Object equals : C0694a.f2372l.f2512a.f2495l) {
                        if (b2.m5281e("uuid").equals(equals)) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            C0694a.f2337C = true;
            if (z && m5317a(b)) {
                this.f4592b = true;
                this.f4599i.m2733a();
                C0694a.f2337C = false;
                return;
            }
            C0726l.f2611b.m2657b((Object) "Invalid manifest loaded.");
            c0720f.m2601c();
            C0694a.f2337C = false;
            this.f4592b = false;
        }
    }

    String m5323c() {
        if (!this.f4592b) {
            return null;
        }
        String str = null;
        for (int i = 0; i < this.f4599i.f2749n.m2719b(); i++) {
            ad a = this.f4599i.f2749n.m2715a(i);
            if (a.m2705g()) {
                str = a.f2675a;
                if (a.m2700c()) {
                    return a.f2675a;
                }
            }
        }
        return str;
    }

    String m5325d() {
        if (!this.f4592b) {
            return null;
        }
        String str = null;
        for (int i = 0; i < this.f4599i.f2749n.m2719b(); i++) {
            ad a = this.f4599i.f2749n.m2715a(i);
            if (a.m2707i()) {
                str = a.f2675a;
                if (a.m2700c()) {
                    return a.f2675a;
                }
            }
        }
        return str;
    }

    boolean m5318a(String str) {
        return m5319a(str, true);
    }

    boolean m5319a(String str, boolean z) {
        for (int i = 0; i < this.f4599i.f2749n.m2719b(); i++) {
            ad a = this.f4599i.f2749n.m2715a(i);
            if (a.m2701c(z) && a.f2675a.equals(str)) {
                return true;
            }
        }
        return false;
    }

    boolean m5321b(String str) {
        return m5322b(str, false);
    }

    boolean m5322b(String str, boolean z) {
        if (z) {
            return m5324c(str, z);
        }
        if (!this.f4592b) {
            return C0726l.f2612c.m2659b("Ads are not ready to be played, as they are still downloading.");
        }
        if (z) {
            return this.f4599i.m2736a(str, true, false);
        }
        return this.f4599i.m2736a(str, false, true);
    }

    boolean m5324c(String str, boolean z) {
        if (!this.f4592b) {
            return false;
        }
        if (z) {
            return this.f4599i.m2736a(str, true, false);
        }
        return this.f4599i.m2736a(str, false, true);
    }

    void m5326e() {
    }

    void m5327f() {
        this.f4593c = true;
        if (this.f4593c) {
            this.f4593c = false;
            if (C0721g.m2604c() >= 32) {
                this.f4598h = aa.m2483c() + 600.0d;
                m5329h();
            }
        }
        if (C0760q.m2793c()) {
            if (!C0694a.f2346L) {
                C0694a.m2467h();
            }
            C0694a.f2346L = true;
            return;
        }
        if (C0694a.f2346L) {
            C0694a.m2467h();
        }
        C0694a.f2346L = false;
    }

    void m5328g() {
        new Thread(new C07081(this)).start();
        m5329h();
    }

    void m5329h() {
        m5316a(null);
    }

    void m5316a(Activity activity) {
        C0694a.f2386z = true;
        if (!this.f4594d) {
            this.f4594d = true;
            if (!this.f4592b) {
                m5320b();
            }
        }
        if (activity != null) {
            C0694a.f2355U = null;
        }
        C1423g c1423g = this.f4591a.f2512a.f2493j;
        c1423g.m5277b("app_id", this.f4591a.f2512a.f2494k);
        C0670i c1419c = new C1419c();
        if (this.f4591a.f2512a.f2495l != null) {
            for (String str : this.f4591a.f2512a.f2495l) {
                ad g = C0694a.f2372l.m2576g(str);
                if (g == null || (g != null && (g.m2694a() || System.currentTimeMillis() - g.f2691q > g.f2689o))) {
                    c1419c.m5235a(str);
                }
            }
        }
        if (c1419c.m5250i() != 0) {
            c1423g.m5271a("zones", c1419c);
            C0670i c1423g2 = new C1423g();
            C0670i c1423g3 = new C1423g();
            C0670i c1423g4 = new C1423g();
            if (this.f4591a.f2512a.f2495l != null) {
                for (String str2 : this.f4591a.f2512a.f2495l) {
                    ad g2 = C0694a.f2372l.m2576g(str2);
                    C0670i c1419c2 = new C1419c();
                    C0670i c1419c3 = new C1419c();
                    if (!(g2 == null || g2.f2687m == null || g2.f2687m.f2735a == null)) {
                        Iterator it = g2.f2687m.f2735a.iterator();
                        while (it.hasNext()) {
                            C0730a c0730a = (C0730a) it.next();
                            if (!c0730a.m2682b()) {
                                c1419c2.m5235a(c0730a.f2628a);
                            }
                            if (c0730a.m2683c()) {
                                c1419c3.m5235a(c0730a.f2628a);
                            }
                        }
                    }
                    if (c1419c2.m5250i() > 0) {
                        c1423g2.m5271a(str2, c1419c2);
                    }
                    if (c1419c3.m5250i() > 0) {
                        c1423g3.m5271a(str2, c1419c3);
                    }
                    if (g2 != null && g2.f2684j.m5250i() > 0) {
                        c1423g4.m5271a(str2, g2.f2684j);
                    }
                }
            }
            c1423g.m5271a("ad_queue", c1423g2);
            c1423g.m5271a("ad_playing", c1423g3);
            c1423g.m5271a("ad_history", c1423g4);
            String str3 = C0694a.f2372l.f2516e.f2971k == null ? XMLConstants.NULL_NS_URI : C0694a.f2372l.f2516e.f2971k;
            int i = C0694a.f2372l.f2516e.f2970j;
            c1423g.m5277b("carrier", this.f4591a.f2512a.f2507x);
            if (C0760q.m2788a()) {
                c1423g.m5277b("network_type", "wifi");
            } else if (C0760q.m2791b()) {
                c1423g.m5277b("network_type", "cell");
            } else {
                c1423g.m5277b("network_type", "none");
            }
            c1423g.m5277b("custom_id", this.f4591a.f2512a.f2508y);
            c1423g.m5277b("sid", str3);
            c1423g.m5276b("s_imp_count", i);
            if (!C0694a.f2376p) {
                C0726l a = C0726l.f2611b.m2653a("Downloading ad manifest from ");
                C0709c c0709c = this.f4591a.f2512a;
                a.m2653a(C0709c.f2468c).m2657b((Object) " with the following post content: ");
                C0726l.f2611b.m2657b(c1423g.toString());
                C0694a.f2376p = true;
                C0711d c0711d = this.f4591a;
                C0709c c0709c2 = this.f4591a.f2512a;
                new ADCDownload(c0711d, C0709c.f2468c, this).m5296a("application/json", c1423g.m2399q()).m5298b();
            }
        }
    }

    public void on_download_finished(ADCDownload download) {
        C0694a.f2386z = true;
        if (download.f4521i) {
            C0726l.f2612c.m2657b((Object) "Received ad server response from:");
            C0726l.f2612c.m2657b(download.f4515c);
            C1423g b = C0725k.m2638b(download.f4526n);
            if (b == null) {
                C0726l.f2610a.m2657b((Object) "Invalid JSON in manifest.  Raw data:");
                C0726l.f2610a.m2657b(download.f4526n);
                return;
            } else if (m5317a(b)) {
                int i;
                C0726l.f2611b.m2657b((Object) "Ad manifest updated.");
                C1419c c = C0725k.m2641c(b.m5274b(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).m5279c("zones").toString());
                for (i = 0; i < this.f4599i.f2749n.m2719b(); i++) {
                    boolean z;
                    for (int i2 = 0; i2 < c.m5250i(); i2++) {
                        if (((ad) this.f4599i.f2749n.f2701a.get(i)).f2675a.equals(c.m5241b(i2).m5281e("uuid"))) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        c.m5234a(this.f4599i.f2749n.m2715a(i).f2676b);
                    }
                }
                b.m5274b(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).m5279c("zones").m5251j();
                for (int i3 = 0; i3 < c.m5250i(); i3++) {
                    boolean z2 = false;
                    for (String equals : C0694a.f2372l.f2512a.f2495l) {
                        if (equals.equals(c.m5241b(i3).m5281e("uuid"))) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c.m5241b(i3).m5277b("last_config_ms", new Long(System.currentTimeMillis()).toString());
                        b.m5274b(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).m5279c("zones").m5234a(c.m5241b(i3));
                    }
                }
                new C0720f("manifest.txt").m2599a(b.toString());
                this.f4592b = true;
                this.f4599i.m2733a();
                if (this.f4599i.f2744i == null || this.f4599i.f2744i.equals(XMLConstants.NULL_NS_URI)) {
                    this.f4599i.f2744i = "all";
                }
                if (this.f4599i.f2745j == null || this.f4599i.f2745j.equals(XMLConstants.NULL_NS_URI)) {
                    this.f4599i.f2745j = "all";
                }
                C0694a.m2467h();
                return;
            } else {
                C0726l.f2611b.m2657b((Object) "Invalid manifest.");
                return;
            }
        }
        C0726l.f2612c.m2657b((Object) "Error retrieving ad server response from:");
        C0726l.f2612c.m2657b(download.f4515c);
    }

    boolean m5317a(C1423g c1423g) {
        if (c1423g == null || !c1423g.m5281e(NotificationCompatApi21.CATEGORY_STATUS).equals("success") || !this.f4599i.m2734a(c1423g.m5274b(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT))) {
            return false;
        }
        C0726l.f2610a.m2657b((Object) "Finished parsing manifest");
        C0694a.m2467h();
        if (this.f4599i.f2743h.equalsIgnoreCase("none")) {
            C0694a.m2440a(2);
        } else {
            C0726l.f2612c.m2657b((Object) "Enabling debug logging.");
            C0694a.m2440a(1);
        }
        return true;
    }
}
