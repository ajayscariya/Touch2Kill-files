package com.jirbo.adcolony;

import mf.org.apache.xerces.impl.xs.SchemaSymbols;

abstract class ae {
    boolean f2456h;
    int f2457i;

    abstract void m2510a(char c);

    ae() {
        this.f2456h = true;
        this.f2457i = 0;
    }

    void m2522c() {
        if (this.f2456h) {
            this.f2456h = false;
            int i = this.f2457i;
            while (true) {
                i--;
                if (i >= 0) {
                    m2510a(' ');
                } else {
                    return;
                }
            }
        }
    }

    void m2516b(char c) {
        if (this.f2456h) {
            m2522c();
        }
        m2510a(c);
        if (c == '\n') {
            this.f2456h = true;
        }
    }

    void m2513a(Object obj) {
        if (this.f2456h) {
            m2522c();
        }
        if (obj == null) {
            m2514a("null");
        } else {
            m2514a(obj.toString());
        }
    }

    void m2514a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            m2516b(str.charAt(i));
        }
    }

    void m2511a(double d) {
        if (this.f2456h) {
            m2522c();
        }
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            m2514a("0.0");
            return;
        }
        if (d < 0.0d) {
            d = -d;
            m2510a('-');
        }
        long pow = (long) Math.pow(10.0d, (double) 4);
        long round = Math.round(((double) pow) * d);
        m2512a(round / pow);
        m2510a('.');
        round %= pow;
        if (round == 0) {
            for (int i = 0; i < 4; i++) {
                m2510a('0');
            }
            return;
        }
        for (long j = round * 10; j < pow; j *= 10) {
            m2510a('0');
        }
        m2512a(round);
    }

    void m2512a(long j) {
        if (this.f2456h) {
            m2522c();
        }
        if (j == 0) {
            m2510a('0');
        } else if (j == (-j)) {
            m2514a("-9223372036854775808");
        } else if (j < 0) {
            m2510a('-');
            m2512a(-j);
        } else {
            m2518b(j);
        }
    }

    void m2518b(long j) {
        if (j != 0) {
            m2518b(j / 10);
            m2510a((char) ((int) (48 + (j % 10))));
        }
    }

    void m2515a(boolean z) {
        if (z) {
            m2514a(SchemaSymbols.ATTVAL_TRUE);
        } else {
            m2514a(SchemaSymbols.ATTVAL_FALSE);
        }
    }

    void m2523c(char c) {
        m2516b(c);
        m2516b('\n');
    }

    void m2519b(Object obj) {
        m2513a(obj);
        m2516b('\n');
    }

    void m2520b(String str) {
        m2514a(str);
        m2516b('\n');
    }

    void m2517b(double d) {
        m2511a(d);
        m2516b('\n');
    }

    void m2524c(long j) {
        m2512a(j);
        m2516b('\n');
    }

    void m2521b(boolean z) {
        m2515a(z);
        m2516b('\n');
    }

    void m2525d() {
        m2516b('\n');
    }

    public static void m2509b(String[] strArr) {
        System.out.println("Test...");
    }
}
