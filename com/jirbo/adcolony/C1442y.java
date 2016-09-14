package com.jirbo.adcolony;

/* renamed from: com.jirbo.adcolony.y */
class C1442y extends ae {
    StringBuilder f4648a;

    C1442y() {
        this.f4648a = new StringBuilder();
    }

    void m5370a() {
        this.f4648a.setLength(0);
        this.i = 0;
    }

    void m5371a(char c) {
        this.f4648a.append(c);
    }

    public String toString() {
        return this.f4648a.toString();
    }

    public static void m5369a(String[] strArr) {
        C1442y c1442y = new C1442y();
        c1442y.m2520b("A king who was mad at the time");
        c1442y.m2520b("Declared limerick writing a crime");
        c1442y.i += 2;
        c1442y.m2520b("So late in the night");
        c1442y.m2520b("All the poets would write");
        c1442y.i -= 2;
        c1442y.m2520b("Verses without any rhyme or meter");
        c1442y.m2525d();
        c1442y.i += 4;
        c1442y.m2520b("David\nGerrold");
        c1442y.i += 2;
        c1442y.m2517b(4.0d);
        c1442y.i += 2;
        c1442y.m2517b(0.0d);
        c1442y.i += 2;
        c1442y.m2517b(-100023.0d);
        c1442y.i += 2;
        c1442y.m2524c(-6);
        c1442y.i += 2;
        c1442y.m2524c(0);
        c1442y.i += 2;
        c1442y.m2524c(234);
        c1442y.i += 2;
        c1442y.m2524c(Long.MIN_VALUE);
        c1442y.i += 2;
        c1442y.m2521b(true);
        c1442y.i += 2;
        c1442y.m2521b(false);
        c1442y.i += 2;
        System.out.println(c1442y);
    }
}
