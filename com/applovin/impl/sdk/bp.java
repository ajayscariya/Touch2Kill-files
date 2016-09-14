package com.applovin.impl.sdk;

import java.util.Map;

class bp {
    final /* synthetic */ bn f217a;
    private int f218b;
    private String f219c;
    private Map f220d;

    bp(bn bnVar, String str, Map map) {
        this(bnVar, str, map, 0);
    }

    bp(bn bnVar, String str, Map map, int i) {
        this.f217a = bnVar;
        this.f218b = i;
        this.f219c = str + "&postback_ts=" + System.currentTimeMillis();
        this.f220d = map;
    }

    public int m141a() {
        return this.f218b;
    }

    public void m142a(int i) {
        this.f218b = i;
    }

    public String m143b() {
        return this.f219c;
    }

    public Map m144c() {
        return this.f220d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r5 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r5 = (com.applovin.impl.sdk.bp) r5;
        r2 = r4.f218b;
        r3 = r5.f218b;
        if (r2 != r3) goto L_0x0005;
    L_0x001a:
        r2 = r4.f219c;
        if (r2 == 0) goto L_0x0039;
    L_0x001e:
        r2 = r4.f219c;
        r3 = r5.f219c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0028:
        r2 = r4.f220d;
        if (r2 == 0) goto L_0x003e;
    L_0x002c:
        r2 = r4.f220d;
        r3 = r5.f220d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0037;
    L_0x0036:
        r0 = r1;
    L_0x0037:
        r1 = r0;
        goto L_0x0005;
    L_0x0039:
        r2 = r5.f219c;
        if (r2 == 0) goto L_0x0028;
    L_0x003d:
        goto L_0x0005;
    L_0x003e:
        r2 = r5.f220d;
        if (r2 != 0) goto L_0x0036;
    L_0x0042:
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.bp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f219c != null ? this.f219c.hashCode() : 0) + (this.f218b * 31)) * 31;
        if (this.f220d != null) {
            i = this.f220d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostbackRequest{attemptNumber=" + this.f218b + ", targetUrl='" + this.f219c + '\'' + ", requestBody=" + this.f220d + '}';
    }
}
