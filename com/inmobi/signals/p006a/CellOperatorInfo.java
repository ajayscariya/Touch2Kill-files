package com.inmobi.signals.p006a;

/* renamed from: com.inmobi.signals.a.a */
public class CellOperatorInfo {
    private int f2059a;
    private int f2060b;
    private int f2061c;
    private int f2062d;

    public CellOperatorInfo() {
        this.f2059a = -1;
        this.f2060b = -1;
        this.f2061c = -1;
        this.f2062d = -1;
    }

    public void m2150a(int i) {
        this.f2059a = i;
    }

    public void m2152b(int i) {
        this.f2060b = i;
    }

    public void m2153c(int i) {
        this.f2061c = i;
    }

    public void m2154d(int i) {
        this.f2062d = i;
    }

    public String m2149a() {
        if (this.f2059a == -1 && this.f2060b == -1) {
            return null;
        }
        return this.f2059a + "_" + this.f2060b;
    }

    public String m2151b() {
        if (this.f2061c == -1 && this.f2062d == -1) {
            return null;
        }
        return this.f2061c + "_" + this.f2062d;
    }
}
