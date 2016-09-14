package com.immersion.hapticmediasdk.models;

public class HttpUnsuccessfulException extends Exception {
    public static int f1376b042704270427 = 2;
    public static int f1377b04270427 = 0;
    public static int f1378b04270427 = 1;
    public static int f1379b0427 = 24;
    private static final long serialVersionUID = -251711421440827767L;
    private int f1380a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpUnsuccessfulException(int r3, java.lang.String r4) {
        /*
        r2 = this;
        r2.<init>(r4);
    L_0x0003:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0003;
            case 1: goto L_0x000c;
            default: goto L_0x0007;
        };
    L_0x0007:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x000c;
            case 1: goto L_0x0003;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0007;
    L_0x000c:
        r0 = f1379b0427;
        r1 = f1378b04270427;
        r0 = r0 + r1;
        r1 = f1379b0427;
        r0 = r0 * r1;
        r1 = f1376b042704270427;
        r0 = r0 % r1;
        r1 = f1377b04270427;
        if (r0 == r1) goto L_0x0023;
    L_0x001b:
        r0 = 74;
        f1379b0427 = r0;
        r0 = 98;
        f1377b04270427 = r0;
    L_0x0023:
        r2.f1380a = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.models.HttpUnsuccessfulException.<init>(int, java.lang.String):void");
    }

    public static int m1409b042704270427() {
        return 75;
    }

    public static int m1410b04270427() {
        return 1;
    }

    public int getHttpStatusCode() {
        if (((f1379b0427 + m1410b04270427()) * f1379b0427) % f1376b042704270427 != f1377b04270427) {
            f1379b0427 = m1409b042704270427();
            f1377b04270427 = m1409b042704270427();
        }
        try {
            return this.f1380a;
        } catch (Exception e) {
            throw e;
        }
    }
}
