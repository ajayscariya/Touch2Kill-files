package com.startapp.android.publish.p012f.p013a.p014a;

/* renamed from: com.startapp.android.publish.f.a.a.b */
public class StartAppSDK {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m3059a(java.nio.ByteBuffer r17, int r18, int r19, long r20) {
        /*
        r8 = -4132994306676758123; // 0xc6a4a7935bd1e995 float:1.18170193E17 double:-2.0946245025644615E32;
        r10 = 47;
        r2 = 4294967295; // 0xffffffff float:NaN double:2.1219957905E-314;
        r2 = r2 & r20;
        r0 = r19;
        r4 = (long) r0;
        r4 = r4 * r8;
        r4 = r4 ^ r2;
        r11 = r19 >> 3;
        r2 = 0;
        r16 = r2;
        r2 = r4;
        r4 = r16;
    L_0x001b:
        if (r4 >= r11) goto L_0x00b9;
    L_0x001d:
        r5 = r4 << 3;
        r6 = r18 + r5;
        r6 = r6 + 0;
        r0 = r17;
        r6 = r0.get(r6);
        r6 = (long) r6;
        r12 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = r6 & r12;
        r12 = r18 + r5;
        r12 = r12 + 1;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 8;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r12 = r18 + r5;
        r12 = r12 + 2;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 16;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r12 = r18 + r5;
        r12 = r12 + 3;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 24;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r12 = r18 + r5;
        r12 = r12 + 4;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 32;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r12 = r18 + r5;
        r12 = r12 + 5;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 40;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r12 = r18 + r5;
        r12 = r12 + 6;
        r0 = r17;
        r12 = r0.get(r12);
        r12 = (long) r12;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r14 = 48;
        r12 = r12 << r14;
        r6 = r6 + r12;
        r5 = r5 + r18;
        r5 = r5 + 7;
        r0 = r17;
        r5 = r0.get(r5);
        r12 = (long) r5;
        r14 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r12 = r12 & r14;
        r5 = 56;
        r12 = r12 << r5;
        r6 = r6 + r12;
        r6 = r6 * r8;
        r12 = r6 >>> r10;
        r6 = r6 ^ r12;
        r6 = r6 * r8;
        r2 = r2 ^ r6;
        r6 = r2 * r8;
        r2 = r4 + 1;
        r4 = r2;
        r2 = r6;
        goto L_0x001b;
    L_0x00b9:
        r4 = r19 & 7;
        switch(r4) {
            case 0: goto L_0x00be;
            case 1: goto L_0x0126;
            case 2: goto L_0x0116;
            case 3: goto L_0x0106;
            case 4: goto L_0x00f6;
            case 5: goto L_0x00e6;
            case 6: goto L_0x00d6;
            case 7: goto L_0x00c6;
            default: goto L_0x00be;
        };
    L_0x00be:
        r4 = r2 >>> r10;
        r2 = r2 ^ r4;
        r2 = r2 * r8;
        r4 = r2 >>> r10;
        r2 = r2 ^ r4;
        return r2;
    L_0x00c6:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 6;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 48;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x00d6:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 5;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 40;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x00e6:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 4;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 32;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x00f6:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 3;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 24;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x0106:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 2;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 16;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x0116:
        r5 = r18 + r19;
        r5 = r5 - r4;
        r5 = r5 + 1;
        r0 = r17;
        r5 = r0.get(r5);
        r6 = (long) r5;
        r5 = 8;
        r6 = r6 << r5;
        r2 = r2 ^ r6;
    L_0x0126:
        r5 = r18 + r19;
        r4 = r5 - r4;
        r0 = r17;
        r4 = r0.get(r4);
        r4 = (long) r4;
        r2 = r2 ^ r4;
        r2 = r2 * r8;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.android.publish.f.a.a.b.a(java.nio.ByteBuffer, int, int, long):long");
    }
}
