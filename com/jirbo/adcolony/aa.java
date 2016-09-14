package com.jirbo.adcolony;

import android.content.pm.PackageManager.NameNotFoundException;
import com.silvermob.sdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;

class aa {
    static byte[] f2389a;
    static StringBuilder f2390b;

    /* renamed from: com.jirbo.adcolony.aa.a */
    static class C0695a {
        long f2387a;

        C0695a() {
            this.f2387a = System.currentTimeMillis();
        }

        void m2471a() {
            this.f2387a = System.currentTimeMillis();
        }

        double m2472b() {
            return ((double) (System.currentTimeMillis() - this.f2387a)) / 1000.0d;
        }

        public String toString() {
            return aa.m2477a(m2472b(), 2);
        }
    }

    /* renamed from: com.jirbo.adcolony.aa.b */
    static class C0696b {
        double f2388a;

        C0696b(double d) {
            this.f2388a = (double) System.currentTimeMillis();
            m2473a(d);
        }

        void m2473a(double d) {
            this.f2388a = (((double) System.currentTimeMillis()) / 1000.0d) + d;
        }

        boolean m2474a() {
            return m2475b() == 0.0d;
        }

        double m2475b() {
            double currentTimeMillis = this.f2388a - (((double) System.currentTimeMillis()) / 1000.0d);
            if (currentTimeMillis <= 0.0d) {
                return 0.0d;
            }
            return currentTimeMillis;
        }

        public String toString() {
            return aa.m2477a(m2475b(), 2);
        }
    }

    aa() {
    }

    static {
        f2389a = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
        f2390b = new StringBuilder();
    }

    static boolean m2480a(String str) {
        if (C0694a.f2350P == null) {
            return false;
        }
        try {
            AdColony.activity().getApplication().getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static String m2476a() {
        if (C0694a.f2350P == null) {
            return BuildConfig.VERSION_NAME;
        }
        try {
            return AdColony.activity().getPackageManager().getPackageInfo(AdColony.activity().getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            C0694a.m2461e("Failed to retrieve package info.");
            return BuildConfig.VERSION_NAME;
        }
    }

    static String m2482b(String str) {
        try {
            return ah.m2534a(str);
        } catch (Exception e) {
            return null;
        }
    }

    static String m2481b() {
        return UUID.randomUUID().toString();
    }

    static double m2483c() {
        return ((double) System.currentTimeMillis()) / 1000.0d;
    }

    static String m2477a(double d, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        m2479a(d, i, stringBuilder);
        return stringBuilder.toString();
    }

    static void m2479a(double d, int i, StringBuilder stringBuilder) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            stringBuilder.append(d);
            return;
        }
        if (d < 0.0d) {
            d = -d;
            stringBuilder.append('-');
        }
        if (i == 0) {
            stringBuilder.append(Math.round(d));
            return;
        }
        long pow = (long) Math.pow(10.0d, (double) i);
        long round = Math.round(((double) pow) * d);
        stringBuilder.append(round / pow);
        stringBuilder.append('.');
        long j = round % pow;
        if (j == 0) {
            for (int i2 = 0; i2 < i; i2++) {
                stringBuilder.append('0');
            }
            return;
        }
        for (round = j * 10; round < pow; round *= 10) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j);
    }

    static boolean m2485d() {
        if (new File(C0694a.f2372l.f2517f.m2415c() + "/../lib/libImmEndpointWarpJ.so").exists()) {
            return true;
        }
        return false;
    }

    static String m2484c(String str) {
        return m2478a(str, XMLConstants.NULL_NS_URI);
    }

    static String m2478a(String str, String str2) {
        if (str == null) {
            return XMLConstants.NULL_NS_URI;
        }
        try {
            String stringBuilder;
            C0726l.f2610a.m2653a("Loading ").m2657b((Object) str);
            FileInputStream fileInputStream = new FileInputStream(str);
            synchronized (f2389a) {
                f2390b.setLength(0);
                f2390b.append(str2);
                for (int read = fileInputStream.read(f2389a, 0, f2389a.length); read != -1; read = fileInputStream.read(f2389a, 0, f2389a.length)) {
                    for (int i = 0; i < read; i++) {
                        f2390b.append((char) f2389a[i]);
                    }
                }
                fileInputStream.close();
                stringBuilder = f2390b.toString();
            }
            return stringBuilder;
        } catch (IOException e) {
            C0726l.f2613d.m2653a("Unable to load ").m2657b((Object) str);
            return XMLConstants.NULL_NS_URI;
        }
    }

    static boolean m2486e() {
        if (C0694a.f2350P != null && C0694a.m2452b().checkCallingOrSelfPermission("android.permission.VIBRATE") == 0) {
            return true;
        }
        return false;
    }

    static String m2487f() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return C0694a.m2452b().getPackageName();
    }
}
