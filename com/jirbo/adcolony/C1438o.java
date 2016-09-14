package com.jirbo.adcolony;

import com.jirbo.adcolony.ADCData.C0670i;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.ADCDownload.Listener;
import com.jirbo.adcolony.aa.C0696b;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;

/* renamed from: com.jirbo.adcolony.o */
class C1438o implements Listener {
    C0711d f4619a;
    ArrayList<C0757a> f4620b;
    HashMap<String, C0757a> f4621c;
    int f4622d;
    C0696b f4623e;
    int f4624f;
    ArrayList<String> f4625g;
    boolean f4626h;
    boolean f4627i;
    double f4628j;

    /* renamed from: com.jirbo.adcolony.o.a */
    static class C0757a {
        String f2928a;
        String f2929b;
        String f2930c;
        boolean f2931d;
        boolean f2932e;
        int f2933f;
        int f2934g;
        double f2935h;

        C0757a() {
        }
    }

    C1438o(C0711d c0711d) {
        this.f4620b = new ArrayList();
        this.f4621c = new HashMap();
        this.f4622d = 1;
        this.f4623e = new C0696b(2.0d);
        this.f4625g = new ArrayList();
        this.f4619a = c0711d;
    }

    void m5339a() {
        m5343b();
        this.f4626h = true;
    }

    void m5343b() {
        C0726l.f2610a.m2657b((Object) "Loading media info");
        C1423g b = C0725k.m2637b(new C0720f("media_info.txt"));
        if (b == null) {
            b = new C1423g();
            C0726l.f2610a.m2657b((Object) "No saved media info exists.");
        } else {
            C0726l.f2610a.m2657b((Object) "Loaded media info");
        }
        this.f4622d = b.m5283g("next_file_number");
        if (this.f4622d <= 0) {
            this.f4622d = 1;
        }
        C1419c c = b.m5279c("assets");
        if (c != null) {
            this.f4620b.clear();
            for (int i = 0; i < c.m5250i(); i++) {
                C1423g b2 = c.m5241b(i);
                C0757a c0757a = new C0757a();
                c0757a.f2928a = b2.m5281e(DatabaseOpenHelper.HISTORY_ROW_URL);
                c0757a.f2929b = b2.m5281e("filepath");
                c0757a.f2930c = b2.m5281e("last_modified");
                c0757a.f2933f = b2.m5283g("file_number");
                c0757a.f2934g = b2.m5283g("size");
                c0757a.f2932e = b2.m5285h("ready");
                c0757a.f2935h = b2.m5282f("last_accessed");
                if (c0757a.f2933f > this.f4622d) {
                    this.f4622d = c0757a.f2933f + 1;
                }
                this.f4620b.add(c0757a);
            }
        }
        m5344c();
    }

    void m5344c() {
        int i;
        HashMap hashMap = new HashMap();
        String str = this.f4619a.f2517f.f2185c;
        String[] list = new File(str).list();
        String[] strArr;
        if (list == null) {
            strArr = new String[0];
        } else {
            strArr = list;
        }
        for (String str2 : r1) {
            String str22 = str + str22;
            hashMap.put(str22, str22);
        }
        HashMap hashMap2 = new HashMap();
        this.f4628j = 0.0d;
        ArrayList arrayList = new ArrayList();
        for (i = 0; i < this.f4620b.size(); i++) {
            C0757a c0757a = (C0757a) this.f4620b.get(i);
            if (!c0757a.f2931d && c0757a.f2932e) {
                String str3 = c0757a.f2929b;
                if (hashMap.containsKey(str3) && new File(str3).length() == ((long) c0757a.f2934g)) {
                    this.f4628j += (double) c0757a.f2934g;
                    arrayList.add(c0757a);
                    hashMap2.put(str3, str3);
                }
            }
        }
        this.f4620b = arrayList;
        for (String str4 : r1) {
            Object obj = str + str4;
            if (!hashMap2.containsKey(obj)) {
                C0726l.f2611b.m2653a("Deleting unused media ").m2657b(obj);
                new File(obj).delete();
            }
        }
        this.f4621c.clear();
        for (int i2 = 0; i2 < this.f4620b.size(); i2++) {
            c0757a = (C0757a) this.f4620b.get(i2);
            this.f4621c.put(c0757a.f2928a, c0757a);
        }
        double d = this.f4619a.f2513b.f4599i.f2742g;
        if (d > 0.0d) {
            C0726l.f2611b.m2653a("Media pool at ").m2650a(this.f4628j / 1048576.0d).m2653a("/").m2650a(d / 1048576.0d).m2657b((Object) " MB");
        }
    }

    void m5345d() {
        C0726l.f2610a.m2657b((Object) "Saving media info");
        C0670i c1419c = new C1419c();
        for (int i = 0; i < this.f4620b.size(); i++) {
            C0757a c0757a = (C0757a) this.f4620b.get(i);
            if (c0757a.f2932e && !c0757a.f2931d) {
                C0670i c1423g = new C1423g();
                c1423g.m5277b(DatabaseOpenHelper.HISTORY_ROW_URL, c0757a.f2928a);
                c1423g.m5277b("filepath", c0757a.f2929b);
                c1423g.m5277b("last_modified", c0757a.f2930c);
                c1423g.m5276b("file_number", c0757a.f2933f);
                c1423g.m5276b("size", c0757a.f2934g);
                c1423g.m5278b("ready", c0757a.f2932e);
                c1423g.m5275b("last_accessed", c0757a.f2935h);
                c1419c.m5234a(c1423g);
            }
        }
        C1423g c1423g2 = new C1423g();
        c1423g2.m5276b("next_file_number", this.f4622d);
        c1423g2.m5271a("assets", c1419c);
        C0725k.m2634a(new C0720f("media_info.txt"), c1423g2);
        this.f4627i = false;
    }

    boolean m5341a(String str) {
        if (str == null || str.equals(XMLConstants.NULL_NS_URI)) {
            return false;
        }
        C0757a c0757a = (C0757a) this.f4621c.get(str);
        if (c0757a == null) {
            this.f4619a.f2513b.f4599i.m2733a();
            return false;
        } else if (!c0757a.f2932e) {
            if (!c0757a.f2931d) {
                this.f4619a.f2513b.f4599i.m2733a();
            }
            return false;
        } else if (c0757a.f2931d) {
            return false;
        } else {
            c0757a.f2935h = aa.m2483c();
            return true;
        }
    }

    String m5342b(String str) {
        C0757a c0757a = (C0757a) this.f4621c.get(str);
        if (c0757a == null || c0757a.f2929b == null) {
            return "(file not found)";
        }
        c0757a.f2935h = aa.m2483c();
        this.f4627i = true;
        this.f4623e.m2473a(2.0d);
        return c0757a.f2929b;
    }

    void m5340a(String str, String str2) {
        if (str != null && !str.equals(XMLConstants.NULL_NS_URI)) {
            if (str2 == null) {
                str2 = XMLConstants.NULL_NS_URI;
            }
            C0757a c0757a = (C0757a) this.f4621c.get(str);
            if (c0757a != null) {
                c0757a.f2935h = aa.m2483c();
                if (c0757a.f2930c.equals(str2) && (c0757a.f2932e || c0757a.f2931d)) {
                    return;
                }
            }
            c0757a = new C0757a();
            c0757a.f2928a = str;
            this.f4620b.add(c0757a);
            c0757a.f2935h = aa.m2483c();
            this.f4621c.put(str, c0757a);
            if (c0757a.f2933f == 0) {
                int h = m5349h();
                String str3 = this.f4619a.f2517f.f2185c + m5338a(str, h);
                c0757a.f2933f = h;
                c0757a.f2929b = str3;
            }
            c0757a.f2930c = str2;
            c0757a.f2931d = true;
            c0757a.f2932e = false;
            C0726l.f2610a.m2653a("Adding ").m2653a(str).m2657b((Object) " to pending downloads.");
            this.f4625g.add(str);
            this.f4627i = true;
            this.f4623e.m2473a(2.0d);
            C0694a.f2386z = true;
        }
    }

    void m5346e() {
        m5347f();
        if (this.f4627i && this.f4623e.m2474a()) {
            m5348g();
            m5345d();
        }
    }

    void m5347f() {
        if (this.f4619a.f2513b.f4599i.f2745j.equals("wifi") && !C0760q.m2788a()) {
            C0726l.f2610a.m2657b((Object) "Skipping asset download due to CACHE_FILTER_WIFI");
        } else if (!this.f4619a.f2513b.f4599i.f2745j.equals("cell") || C0760q.m2791b()) {
            while (this.f4624f < 3 && this.f4625g.size() > 0) {
                String str = (String) this.f4625g.remove(0);
                C0757a c0757a = (C0757a) this.f4621c.get(str);
                if (c0757a != null && (str == null || str.equals(XMLConstants.NULL_NS_URI))) {
                    C0726l.f2613d.m2657b((Object) "[ADC ERROR] - NULL URL");
                    new RuntimeException().printStackTrace();
                }
                if (!(c0757a == null || str == null || str.equals(XMLConstants.NULL_NS_URI))) {
                    C0694a.f2386z = true;
                    this.f4624f++;
                    new ADCDownload(this.f4619a, str, this, c0757a.f2929b).m5295a(c0757a).m5298b();
                }
            }
        } else {
            C0726l.f2610a.m2657b((Object) "Skipping asset download due to CACHE_FILTER_CELL.");
        }
    }

    public void on_download_finished(ADCDownload download) {
        C0757a c0757a = (C0757a) download.f4517e;
        this.f4624f--;
        this.f4627i = true;
        this.f4623e.m2473a(2.0d);
        c0757a.f2932e = download.f4521i;
        c0757a.f2931d = false;
        if (download.f4521i) {
            c0757a.f2934g = download.f4525m;
            this.f4628j += (double) c0757a.f2934g;
            C0726l.f2610a.m2653a("Downloaded ").m2657b(c0757a.f2928a);
        }
        C0694a.m2467h();
        m5347f();
    }

    void m5348g() {
        double d = this.f4619a.f2513b.f4599i.f2742g;
        if (d != 0.0d) {
            while (this.f4628j > this.f4619a.f2513b.f4599i.f2742g) {
                int i = 0;
                C0757a c0757a = null;
                while (i < this.f4620b.size()) {
                    C0757a c0757a2 = (C0757a) this.f4620b.get(i);
                    if (!c0757a2.f2932e || (c0757a != null && c0757a2.f2935h >= c0757a.f2935h)) {
                        c0757a2 = c0757a;
                    }
                    i++;
                    c0757a = c0757a2;
                }
                if (c0757a == null) {
                    return;
                }
                if (c0757a.f2929b != null) {
                    C0726l.f2611b.m2653a("Deleting ").m2657b(c0757a.f2929b);
                    c0757a.f2932e = false;
                    new File(c0757a.f2929b).delete();
                    c0757a.f2929b = null;
                    this.f4628j -= (double) c0757a.f2934g;
                    C0726l.f2611b.m2653a("Media pool now at ").m2650a(this.f4628j / 1048576.0d).m2653a("/").m2650a(d / 1048576.0d).m2657b((Object) " MB");
                    this.f4627i = true;
                    this.f4623e.m2473a(2.0d);
                } else {
                    return;
                }
            }
        }
    }

    int m5349h() {
        this.f4627i = true;
        this.f4623e.m2473a(2.0d);
        int i = this.f4622d;
        this.f4622d = i + 1;
        return i;
    }

    String m5338a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return i + XMLConstants.NULL_NS_URI;
        }
        String substring = str.substring(lastIndexOf);
        if (substring.contains("/")) {
            substring = ".0";
        }
        return i + substring;
    }
}
