package com.jirbo.adcolony;

/* renamed from: com.jirbo.adcolony.l */
class C0726l {
    static C0726l f2610a;
    static C0726l f2611b;
    static C0726l f2612c;
    static C0726l f2613d;
    int f2614e;
    boolean f2615f;
    StringBuilder f2616g;

    static {
        f2610a = new C0726l(0, false);
        f2611b = new C0726l(1, false);
        f2612c = new C0726l(2, true);
        f2613d = new C0726l(3, true);
    }

    C0726l(int i, boolean z) {
        this.f2616g = new StringBuilder();
        this.f2614e = i;
        this.f2615f = z;
    }

    synchronized C0726l m2649a(char c) {
        C0726l c0726l;
        if (this.f2615f) {
            this.f2616g.append(c);
            if (c == '\n') {
                C0694a.m2441a(this.f2614e, this.f2616g.toString());
                this.f2616g.setLength(0);
            }
            c0726l = this;
        } else {
            c0726l = this;
        }
        return c0726l;
    }

    synchronized C0726l m2653a(String str) {
        C0726l c0726l;
        if (this.f2615f) {
            if (str == null) {
                this.f2616g.append("null");
            } else {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    m2649a(str.charAt(i));
                }
            }
            c0726l = this;
        } else {
            c0726l = this;
        }
        return c0726l;
    }

    synchronized C0726l m2652a(Object obj) {
        if (this.f2615f) {
            if (obj == null) {
                m2653a("null");
            } else {
                m2653a(obj.toString());
            }
        }
        return this;
    }

    synchronized C0726l m2650a(double d) {
        C0726l c0726l;
        if (this.f2615f) {
            aa.m2479a(d, 2, this.f2616g);
            c0726l = this;
        } else {
            c0726l = this;
        }
        return c0726l;
    }

    synchronized C0726l m2651a(int i) {
        C0726l c0726l;
        if (this.f2615f) {
            this.f2616g.append(i);
            c0726l = this;
        } else {
            c0726l = this;
        }
        return c0726l;
    }

    synchronized C0726l m2654a(boolean z) {
        C0726l c0726l;
        if (this.f2615f) {
            this.f2616g.append(z);
            c0726l = this;
        } else {
            c0726l = this;
        }
        return c0726l;
    }

    synchronized C0726l m2657b(Object obj) {
        m2652a(obj);
        return m2649a('\n');
    }

    synchronized C0726l m2655b(double d) {
        m2650a(d);
        return m2649a('\n');
    }

    synchronized C0726l m2656b(int i) {
        m2651a(i);
        return m2649a('\n');
    }

    synchronized C0726l m2658b(boolean z) {
        m2654a(z);
        return m2649a('\n');
    }

    synchronized C0726l m2648a() {
        return m2649a('\n');
    }

    boolean m2659b(String str) {
        m2653a(str + '\n');
        return false;
    }

    int m2660c(String str) {
        m2653a(str + '\n');
        return 0;
    }
}
