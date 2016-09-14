package com.applovin.impl.sdk;

import java.util.Map;

public class bt {
    private final String f224a;
    private final Map f225b;
    private final long f226c;
    private final String f227d;

    public bt(String str, Map map, long j, String str2) {
        this.f224a = str;
        this.f225b = map;
        this.f226c = j;
        this.f227d = str2;
    }

    public String m151a() {
        return this.f224a;
    }

    public Map m152b() {
        return this.f225b;
    }

    public long m153c() {
        return this.f226c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r6 != r7) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r7 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r7 = (com.applovin.impl.sdk.bt) r7;
        r2 = r6.f226c;
        r4 = r7.f226c;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0005;
    L_0x001c:
        r2 = r6.f224a;
        if (r2 == 0) goto L_0x0049;
    L_0x0020:
        r2 = r6.f224a;
        r3 = r7.f224a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x002a:
        r2 = r6.f225b;
        if (r2 == 0) goto L_0x004e;
    L_0x002e:
        r2 = r6.f225b;
        r3 = r7.f225b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0038:
        r2 = r6.f227d;
        if (r2 == 0) goto L_0x0053;
    L_0x003c:
        r2 = r6.f227d;
        r3 = r7.f227d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x0046:
        r0 = r1;
    L_0x0047:
        r1 = r0;
        goto L_0x0005;
    L_0x0049:
        r2 = r7.f224a;
        if (r2 == 0) goto L_0x002a;
    L_0x004d:
        goto L_0x0005;
    L_0x004e:
        r2 = r7.f225b;
        if (r2 == 0) goto L_0x0038;
    L_0x0052:
        goto L_0x0005;
    L_0x0053:
        r2 = r7.f227d;
        if (r2 != 0) goto L_0x0046;
    L_0x0057:
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.bt.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f225b != null ? this.f225b.hashCode() : 0) + ((this.f224a != null ? this.f224a.hashCode() : 0) * 31)) * 31) + ((int) (this.f226c ^ (this.f226c >>> 32)))) * 31;
        if (this.f227d != null) {
            i = this.f227d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SdkEvent{eventType='" + this.f224a + '\'' + ", parameters=" + this.f225b + ", creationTsMillis=" + this.f226c + ", uniqueIdentifier='" + this.f227d + '\'' + '}';
    }
}
