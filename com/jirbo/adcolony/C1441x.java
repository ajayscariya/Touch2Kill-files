package com.jirbo.adcolony;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.jirbo.adcolony.x */
class C1441x extends ae {
    static final int f4641a = 1024;
    String f4642b;
    OutputStream f4643c;
    byte[] f4644d;
    int f4645e;
    int f4646f;
    int f4647g;

    C1441x(String str) {
        this.f4644d = new byte[f4641a];
        this.f4645e = 0;
        this.f4642b = str;
        if (C0694a.f2374n != 0) {
            this.f4647g = 23;
            this.f4646f = this.f4647g;
        }
        try {
            if (!(C0694a.f2372l == null || C0694a.f2372l.f2517f == null)) {
                C0694a.f2372l.f2517f.m2414b();
            }
            this.f4643c = new FileOutputStream(str);
        } catch (IOException e) {
            m5367a(e);
        }
    }

    C1441x(String str, OutputStream outputStream) {
        this.f4644d = new byte[f4641a];
        this.f4645e = 0;
        this.f4642b = str;
        this.f4643c = outputStream;
    }

    void m5366a(char c) {
        this.f4644d[this.f4645e] = (byte) (this.f4646f ^ c);
        this.f4646f += this.f4647g;
        int i = this.f4645e + 1;
        this.f4645e = i;
        if (i == f4641a) {
            m5365a();
        }
    }

    void m5365a() {
        if (this.f4645e > 0 && this.f4643c != null) {
            try {
                this.f4643c.write(this.f4644d, 0, this.f4645e);
                this.f4645e = 0;
                this.f4643c.flush();
            } catch (IOException e) {
                this.f4645e = 0;
                m5367a(e);
            }
        }
    }

    void m5368b() {
        m5365a();
        try {
            if (this.f4643c != null) {
                this.f4643c.close();
                this.f4643c = null;
            }
        } catch (IOException e) {
            this.f4643c = null;
            m5367a(e);
        }
    }

    void m5367a(IOException iOException) {
        C0726l.f2613d.m2653a("Error writing \"").m2653a(this.f4642b).m2657b((Object) "\":");
        C0726l.f2613d.m2657b(iOException.toString());
        m5368b();
    }

    public static void m5364a(String[] strArr) {
        C1441x c1441x = new C1441x("test.txt");
        c1441x.m2520b("A king who was mad at the time");
        c1441x.m2520b("Declared limerick writing a crime");
        c1441x.i += 2;
        c1441x.m2520b("So late in the night");
        c1441x.m2520b("All the poets would write");
        c1441x.i -= 2;
        c1441x.m2520b("Verses without any rhyme or meter");
        c1441x.m2525d();
        c1441x.i += 4;
        c1441x.m2520b("David\nGerrold");
        c1441x.i += 2;
        c1441x.m2517b(4.0d);
        c1441x.i += 2;
        c1441x.m2517b(0.0d);
        c1441x.i += 2;
        c1441x.m2517b(-100023.0d);
        c1441x.i += 2;
        c1441x.m2524c(-6);
        c1441x.i += 2;
        c1441x.m2524c(0);
        c1441x.i += 2;
        c1441x.m2524c(234);
        c1441x.i += 2;
        c1441x.m2524c(Long.MIN_VALUE);
        c1441x.i += 2;
        c1441x.m2521b(true);
        c1441x.i += 2;
        c1441x.m2521b(false);
        c1441x.i += 2;
        c1441x.m5368b();
    }
}
