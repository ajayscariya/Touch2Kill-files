package com.jirbo.adcolony;

import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1423g;
import java.util.ArrayList;

class ag {
    C0711d f2462a;
    boolean f2463b;
    ArrayList<af> f2464c;

    ag(C0711d c0711d) {
        this.f2463b = false;
        this.f2464c = new ArrayList();
        this.f2462a = c0711d;
    }

    void m2530a() {
        int i = 0;
        C1419c c = C0725k.m2640c(new C0720f("zone_state.txt"));
        if (c != null) {
            this.f2464c.clear();
            for (int i2 = 0; i2 < c.m5250i(); i2++) {
                C1423g b = c.m5241b(i2);
                af afVar = new af();
                if (afVar.m2527a(b)) {
                    this.f2464c.add(afVar);
                }
            }
        }
        String[] strArr = this.f2462a.f2512a.f2495l;
        int length = strArr.length;
        while (i < length) {
            m2529a(strArr[i]);
            i++;
        }
    }

    void m2531b() {
        int i = 0;
        C0726l.f2610a.m2657b((Object) "Saving zone state...");
        this.f2463b = false;
        C1419c c1419c = new C1419c();
        String[] strArr = this.f2462a.f2512a.f2495l;
        int length = strArr.length;
        while (i < length) {
            c1419c.m5234a(m2529a(strArr[i]).m2526a());
            i++;
        }
        C0725k.m2633a(new C0720f("zone_state.txt"), c1419c);
        C0726l.f2610a.m2657b((Object) "Saved zone state");
    }

    int m2532c() {
        return this.f2464c.size();
    }

    af m2528a(int i) {
        return (af) this.f2464c.get(i);
    }

    af m2529a(String str) {
        af afVar;
        int size = this.f2464c.size();
        for (int i = 0; i < size; i++) {
            afVar = (af) this.f2464c.get(i);
            if (afVar.f2458a.equals(str)) {
                return afVar;
            }
        }
        this.f2463b = true;
        afVar = new af(str);
        this.f2464c.add(afVar);
        return afVar;
    }

    void m2533d() {
        if (this.f2463b) {
            m2531b();
        }
    }
}
