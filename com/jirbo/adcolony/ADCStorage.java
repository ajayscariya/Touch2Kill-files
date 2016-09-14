package com.jirbo.adcolony;

import android.os.StatFs;
import java.io.File;
import mf.javax.xml.XMLConstants;

public class ADCStorage {
    C0711d f2183a;
    String f2184b;
    String f2185c;
    String f2186d;
    File f2187e;
    File f2188f;

    ADCStorage(C0711d controller) {
        this.f2183a = controller;
    }

    void m2413a() {
        C0726l.f2610a.m2657b((Object) "Configuring storage");
        C0726l.f2611b.m2657b((Object) "Using internal storage:");
        this.f2184b = m2415c() + "/adc/";
        this.f2185c = this.f2184b + "media/";
        C0726l.f2610a.m2657b(this.f2185c);
        this.f2187e = new File(this.f2185c);
        if (!this.f2187e.isDirectory()) {
            this.f2187e.delete();
            this.f2187e.mkdirs();
        }
        if (!this.f2187e.isDirectory()) {
            C0694a.m2447a("Cannot create media folder.");
        } else if (m2412a(this.f2185c) < 2.097152E7d) {
            C0694a.m2447a("Not enough space to store temporary files (" + m2412a(this.f2185c) + " bytes available).");
        } else {
            this.f2186d = m2415c() + "/adc/data/";
            if (C0694a.f2374n == 0) {
                this.f2186d = this.f2184b + "data/";
            }
            C0726l.f2610a.m2653a("Internal data path: ").m2657b(this.f2186d);
            this.f2188f = new File(this.f2186d);
            if (!this.f2188f.isDirectory()) {
                this.f2188f.delete();
            }
            this.f2188f.mkdirs();
            C0720f c0720f = new C0720f("iap_cache.txt");
            c0720f.m2601c();
            C0725k.m2633a(c0720f, C0694a.aj);
        }
    }

    void m2414b() {
        if (this.f2187e != null && this.f2188f != null) {
            if (!this.f2187e.isDirectory()) {
                this.f2187e.delete();
            }
            if (!this.f2188f.isDirectory()) {
                this.f2188f.delete();
            }
            this.f2187e.mkdirs();
            this.f2188f.mkdirs();
        }
    }

    String m2415c() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return AdColony.activity().getFilesDir().getAbsolutePath();
    }

    String m2416d() {
        if (C0694a.f2350P == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return AdColony.activity().getExternalFilesDir(null).getAbsolutePath();
    }

    double m2412a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        } catch (RuntimeException e) {
            return 0.0d;
        }
    }
}
