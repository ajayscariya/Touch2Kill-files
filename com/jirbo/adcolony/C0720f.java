package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;
import mf.org.w3c.dom.traversal.NodeFilter;

/* renamed from: com.jirbo.adcolony.f */
class C0720f {
    static byte[] f2571a;
    String f2572b;

    static {
        f2571a = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
    }

    C0720f(String str) {
        this.f2572b = C0694a.f2372l.f2517f.f2186d + str;
    }

    C1441x m2598a() {
        return new C1441x(this.f2572b);
    }

    C0761s m2600b() {
        try {
            return new C0761s(new C0764w(this.f2572b));
        } catch (IOException e) {
            return null;
        }
    }

    void m2599a(String str) {
        C1441x a = m2598a();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            a.m5366a(str.charAt(i));
        }
        a.m5368b();
    }

    void m2601c() {
        new File(this.f2572b).delete();
    }
}
