package com.jirbo.adcolony;

import com.applovin.sdk.AppLovinTargetingData;
import com.jirbo.adcolony.ADCData.C0670i;
import com.jirbo.adcolony.ADCData.C1418b;
import com.jirbo.adcolony.ADCData.C1419c;
import com.jirbo.adcolony.ADCData.C1421e;
import com.jirbo.adcolony.ADCData.C1422f;
import com.jirbo.adcolony.ADCData.C1423g;
import com.wTouch2KiLL.C0866R;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.jirbo.adcolony.k */
class C0725k {
    static C1442y f2609a;

    C0725k() {
    }

    static {
        f2609a = new C1442y();
    }

    static void m2635a(C0720f c0720f, C0670i c0670i) {
        ae a = c0720f.m2598a();
        if (c0670i == null) {
            a.m2520b("null");
        } else {
            c0670i.m2384a(a);
            a.m2525d();
        }
        a.m5368b();
    }

    static void m2634a(C0720f c0720f, C1423g c1423g) {
        ae a = c0720f.m2598a();
        if (c1423g != null) {
            c1423g.m5270a(a);
            a.m2525d();
        } else {
            C0726l.f2611b.m2657b((Object) "Saving empty property table.");
            a.m2520b("{}");
        }
        a.m5368b();
    }

    static void m2633a(C0720f c0720f, C1419c c1419c) {
        ae a = c0720f.m2598a();
        if (c1419c != null) {
            c1419c.m5239a(a);
            a.m2525d();
        } else {
            C0726l.f2611b.m2657b((Object) "Saving empty property list.");
            a.m2520b("[]");
        }
        a.m5368b();
    }

    static C0670i m2630a(C0720f c0720f) {
        C0761s b = c0720f.m2600b();
        if (b == null) {
            return null;
        }
        return C0725k.m2631a(b);
    }

    static C1423g m2637b(C0720f c0720f) {
        C0670i a = C0725k.m2630a(c0720f);
        if (a == null || !a.m2396m()) {
            return null;
        }
        return a.m2397n();
    }

    static C1419c m2640c(C0720f c0720f) {
        C0670i a = C0725k.m2630a(c0720f);
        if (a == null || !a.m2391f()) {
            return null;
        }
        return a.m2393h();
    }

    static C0670i m2632a(String str) {
        if (str == null) {
            return null;
        }
        return C0725k.m2631a(new C0761s(str));
    }

    static C1423g m2638b(String str) {
        C0670i a = C0725k.m2632a(str);
        if (a == null || !a.m2396m()) {
            return null;
        }
        return a.m2397n();
    }

    static C1419c m2641c(String str) {
        C0670i a = C0725k.m2632a(str);
        if (a == null || !a.m2391f()) {
            return null;
        }
        return a.m2393h();
    }

    static C0670i m2631a(C0761s c0761s) {
        try {
            C0725k.m2639b(c0761s);
            char b = c0761s.m2800b();
            if (b == '{') {
                return C0725k.m2642c(c0761s);
            }
            if (b == '[') {
                return C0725k.m2643d(c0761s);
            }
            if (b == '-') {
                return C0725k.m2647h(c0761s);
            }
            if (b >= '0' && b <= '9') {
                return C0725k.m2647h(c0761s);
            }
            String e;
            if (b == '\"' || b == '\'') {
                e = C0725k.m2644e(c0761s);
                if (e.length() == 0) {
                    return new C1422f(XMLConstants.NULL_NS_URI);
                }
                b = e.charAt(0);
                if (b == 't' && e.equals(SchemaSymbols.ATTVAL_TRUE)) {
                    return ADCData.f2166a;
                }
                if (b == AppLovinTargetingData.GENDER_FEMALE && e.equals(SchemaSymbols.ATTVAL_FALSE)) {
                    return ADCData.f2167b;
                }
                if (b == 'n' && e.equals("null")) {
                    return ADCData.f2168c;
                }
                return new C1422f(e);
            } else if ((b < 'a' || b > 'z') && ((b < 'A' || b > 'Z') && b != '_' && b != '$')) {
                return null;
            } else {
                e = C0725k.m2646g(c0761s);
                if (e.length() == 0) {
                    return new C1422f(XMLConstants.NULL_NS_URI);
                }
                b = e.charAt(0);
                if (b == 't' && e.equals(SchemaSymbols.ATTVAL_TRUE)) {
                    return ADCData.f2166a;
                }
                if (b == AppLovinTargetingData.GENDER_FEMALE && e.equals(SchemaSymbols.ATTVAL_FALSE)) {
                    return ADCData.f2167b;
                }
                if (b == 'n' && e.equals("null")) {
                    return ADCData.f2168c;
                }
                return new C1422f(e);
            }
        } catch (RuntimeException e2) {
            return null;
        }
    }

    static void m2639b(C0761s c0761s) {
        char b = c0761s.m2800b();
        while (c0761s.m2797a()) {
            if (b <= ' ' || b > '~') {
                c0761s.m2803c();
                b = c0761s.m2800b();
            } else {
                return;
            }
        }
    }

    static C1423g m2642c(C0761s c0761s) {
        C0725k.m2639b(c0761s);
        if (!c0761s.m2798a('{')) {
            return null;
        }
        C0725k.m2639b(c0761s);
        C1423g c1423g = new C1423g();
        if (c0761s.m2798a('}')) {
            return c1423g;
        }
        boolean z = true;
        while (true) {
            if (!z && !c0761s.m2798a(',')) {
                break;
            }
            z = false;
            String g = C0725k.m2646g(c0761s);
            C0725k.m2639b(c0761s);
            if (c0761s.m2798a(':')) {
                C0725k.m2639b(c0761s);
                c1423g.m5271a(g, C0725k.m2631a(c0761s));
            } else {
                c1423g.m5278b(g, true);
            }
            C0725k.m2639b(c0761s);
        }
        if (c0761s.m2798a('}')) {
            return c1423g;
        }
        return null;
    }

    static C1419c m2643d(C0761s c0761s) {
        C0725k.m2639b(c0761s);
        if (!c0761s.m2798a('[')) {
            return null;
        }
        C0725k.m2639b(c0761s);
        C1419c c1419c = new C1419c();
        if (c0761s.m2798a(']')) {
            return c1419c;
        }
        Object obj = 1;
        while (true) {
            if (obj == null && !c0761s.m2798a(',')) {
                break;
            }
            obj = null;
            c1419c.m5234a(C0725k.m2631a(c0761s));
            C0725k.m2639b(c0761s);
        }
        if (c0761s.m2798a(']')) {
            return c1419c;
        }
        return null;
    }

    static String m2644e(C0761s c0761s) {
        char c = '\"';
        C0725k.m2639b(c0761s);
        if (!c0761s.m2798a('\"') && c0761s.m2798a('\'')) {
            c = '\'';
        }
        if (!c0761s.m2797a()) {
            return XMLConstants.NULL_NS_URI;
        }
        f2609a.m5370a();
        char c2 = c0761s.m2803c();
        while (c0761s.m2797a() && c2 != r0) {
            if (c2 == '\\') {
                c2 = c0761s.m2803c();
                if (c2 == 'b') {
                    f2609a.m2516b('\b');
                } else if (c2 == AppLovinTargetingData.GENDER_FEMALE) {
                    f2609a.m2516b('\f');
                } else if (c2 == 'n') {
                    f2609a.m2516b('\n');
                } else if (c2 == 'r') {
                    f2609a.m2516b('\r');
                } else if (c2 == 't') {
                    f2609a.m2516b('\t');
                } else if (c2 == 'u') {
                    f2609a.m2516b(C0725k.m2645f(c0761s));
                } else {
                    f2609a.m2516b(c2);
                }
            } else {
                f2609a.m2516b(c2);
            }
            c2 = c0761s.m2803c();
        }
        return f2609a.toString();
    }

    static int m2629a(int i) {
        if (i >= 48 && i <= 57) {
            return i - 48;
        }
        if (i >= 97 && i <= C0866R.styleable.Theme_checkboxStyle) {
            return (i - 97) + 10;
        }
        if (i < 65 || i > 70) {
            return 0;
        }
        return (i - 65) + 10;
    }

    static char m2645f(C0761s c0761s) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            if (c0761s.m2797a()) {
                i = (i << 4) | C0725k.m2629a(c0761s.m2803c());
            }
        }
        return (char) i;
    }

    static String m2646g(C0761s c0761s) {
        C0725k.m2639b(c0761s);
        int b = c0761s.m2800b();
        if (b == 34 || b == 39) {
            return C0725k.m2644e(c0761s);
        }
        f2609a.m5370a();
        Object obj = null;
        while (obj == null && c0761s.m2797a()) {
            if ((b < 97 || b > 122) && !((b >= 65 && b <= 90) || b == 95 || b == 36)) {
                obj = 1;
            } else {
                c0761s.m2803c();
                f2609a.m2516b((char) b);
                b = c0761s.m2800b();
            }
        }
        return f2609a.toString();
    }

    static C0670i m2647h(C0761s c0761s) {
        double d;
        int b;
        C0725k.m2639b(c0761s);
        double d2 = 1.0d;
        if (c0761s.m2798a('-')) {
            d2 = -1.0d;
            C0725k.m2639b(c0761s);
        }
        double d3 = 0.0d;
        int b2 = c0761s.m2800b();
        while (c0761s.m2797a() && b2 >= 48 && b2 <= 57) {
            c0761s.m2803c();
            d3 = (d3 * 10.0d) + ((double) (b2 - 48));
            b2 = c0761s.m2800b();
        }
        Object obj = null;
        if (c0761s.m2798a('.')) {
            d = 0.0d;
            double d4 = 0.0d;
            b = c0761s.m2800b();
            while (c0761s.m2797a() && b >= 48 && b <= 57) {
                c0761s.m2803c();
                d = (d * 10.0d) + ((double) (b - 48));
                d4 += 1.0d;
                b = c0761s.m2800b();
            }
            d3 += d / Math.pow(10.0d, d4);
            obj = 1;
        }
        if (c0761s.m2798a('e') || c0761s.m2798a('E')) {
            Object obj2 = null;
            if (!c0761s.m2798a('+') && c0761s.m2798a('-')) {
                obj2 = 1;
            }
            d = 0.0d;
            b = c0761s.m2800b();
            while (c0761s.m2797a() && b >= 48 && b <= 57) {
                c0761s.m2803c();
                d = (d * 10.0d) + ((double) (b - 48));
                b = c0761s.m2800b();
            }
            if (obj2 != null) {
                d3 /= Math.pow(10.0d, d);
            } else {
                d3 *= Math.pow(10.0d, d);
            }
        }
        d3 *= d2;
        if (obj == null && d3 == ((double) ((int) d3))) {
            return new C1418b((int) d3);
        }
        return new C1421e(d3);
    }

    public static void m2636a(String[] strArr) {
        System.out.println("==== ADCJSON Test ====");
        C0725k.m2637b(new C0720f("test.txt"));
        C0725k.m2635a(new C0720f("test2.txt"), C0725k.m2630a(new C0720f("test.txt")));
        C0725k.m2635a(new C0720f("test3.txt"), C0725k.m2630a(new C0720f("test2.txt")));
    }
}
