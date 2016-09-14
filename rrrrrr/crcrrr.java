package rrrrrr;

import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;

public class crcrrr implements Runnable {
    public static int f3687b042704270427 = 2;
    public static int f3688b04270427 = 0;
    public static int f3689b0427 = 48;
    public static int f3690b0427 = 1;
    public final /* synthetic */ HapticPlaybackThread f3691b044404440444;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public crcrrr(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r3) {
        /*
        r2 = this;
        r2.f3691b044404440444 = r3;
        r0 = f3689b0427;
        r1 = f3690b0427;
        r0 = r0 + r1;
        r1 = f3689b0427;
        r0 = r0 * r1;
        r1 = m3971b04270427();
        r0 = r0 % r1;
        r1 = f3688b04270427;
        if (r0 == r1) goto L_0x001f;
    L_0x0013:
        r0 = m3972b04270427();
        f3689b0427 = r0;
        r0 = m3972b04270427();
        f3688b04270427 = r0;
    L_0x001f:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0028;
            case 1: goto L_0x001f;
            default: goto L_0x0023;
        };
    L_0x0023:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0028;
            default: goto L_0x0027;
        };
    L_0x0027:
        goto L_0x0023;
    L_0x0028:
        r2.<init>();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rrrrrr.crcrrr.<init>(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):void");
    }

    public static int m3971b04270427() {
        return 2;
    }

    public static int m3972b04270427() {
        return 15;
    }

    public void run() {
        try {
            HapticPlaybackThread hapticPlaybackThread = this.f3691b044404440444;
            if (((f3689b0427 + f3690b0427) * f3689b0427) % f3687b042704270427 != f3688b04270427) {
                f3689b0427 = m3972b04270427();
                f3688b04270427 = 40;
            }
            try {
                HapticPlaybackThread.m1351b041104110411(hapticPlaybackThread);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
