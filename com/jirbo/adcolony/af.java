package com.jirbo.adcolony;

import com.google.android.gcm.GCMConstants;
import com.jirbo.adcolony.ADCData.C1423g;
import java.io.Serializable;
import mf.javax.xml.XMLConstants;

class af implements Serializable {
    String f2458a;
    int f2459b;
    int f2460c;
    int f2461d;

    af() {
        this.f2458a = XMLConstants.NULL_NS_URI;
    }

    af(String str) {
        this.f2458a = XMLConstants.NULL_NS_URI;
        this.f2458a = str;
    }

    boolean m2527a(C1423g c1423g) {
        if (c1423g == null) {
            return false;
        }
        this.f2458a = c1423g.m5268a("uuid", GCMConstants.EXTRA_ERROR);
        this.f2459b = c1423g.m5283g("skipped_plays");
        this.f2460c = c1423g.m5283g("play_order_index");
        return true;
    }

    C1423g m2526a() {
        C1423g c1423g = new C1423g();
        c1423g.m5277b("uuid", this.f2458a);
        c1423g.m5276b("skipped_plays", this.f2459b);
        c1423g.m5276b("play_order_index", this.f2460c);
        return c1423g;
    }
}
