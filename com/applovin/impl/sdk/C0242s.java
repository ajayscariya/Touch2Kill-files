package com.applovin.impl.sdk;

import java.util.Comparator;

/* renamed from: com.applovin.impl.sdk.s */
class C0242s implements Comparator {
    final /* synthetic */ C0241r f344a;

    C0242s(C0241r c0241r) {
        this.f344a = c0241r;
    }

    public int m284a(C0244u c0244u, C0244u c0244u2) {
        return c0244u.f350d > c0244u2.f350d ? -1 : c0244u.f350d < c0244u2.f350d ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m284a((C0244u) obj, (C0244u) obj2);
    }
}
