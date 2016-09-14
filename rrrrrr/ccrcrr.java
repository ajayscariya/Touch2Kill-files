package rrrrrr;

import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class ccrcrr implements Runnable {
    public static int f3670b044A044A044A044A = 2;
    public static int f3671b044A044A044A = 45;
    public static int f3672b044A044A044A = 1;
    private final byte[] f3673a;
    private final long f3674b;
    public final /* synthetic */ HapticPlaybackThread f3675b04250425;
    private final long f3676c;
    private final int f3677d;
    private final long f3678e;

    public ccrcrr(HapticPlaybackThread hapticPlaybackThread, long j, long j2, byte[] bArr, int i, long j3) {
        try {
            this.f3675b04250425 = hapticPlaybackThread;
            this.f3673a = bArr;
            this.f3674b = j;
            int i2 = f3671b044A044A044A;
            switch ((i2 * (f3672b044A044A044A + i2)) % f3670b044A044A044A044A) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                default:
                    f3671b044A044A044A = 15;
                    f3672b044A044A044A = m3968b044A044A044A();
                    break;
            }
            try {
                this.f3676c = j2;
                this.f3677d = i;
                this.f3678e = j3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int m3968b044A044A044A() {
        return 32;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r0 = r8.f3675b04250425;
        r0 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1334b0411041104110411(r0);
        if (r0 == 0) goto L_0x007f;
    L_0x0008:
        r0 = r8.f3675b04250425;
        r1 = r0.f1308o;
        monitor-enter(r1);
        r0 = r8.f3675b04250425;	 Catch:{ all -> 0x0083 }
        r0 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1338b0411041104110411(r0);	 Catch:{ all -> 0x0083 }
        r0.remove(r8);	 Catch:{ all -> 0x0083 }
        monitor-exit(r1);	 Catch:{ all -> 0x0083 }
        r0 = r8.f3674b;
        r2 = r8.f3676c;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0070;
    L_0x0021:
        r0 = r8.f3675b04250425;
        r0 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1348b0411041104110411(r0);
        r0 = r0.areHapticsEnabled();
        if (r0 == 0) goto L_0x0049;
    L_0x002d:
        r0 = r8.f3675b04250425;
        r1 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1331b04110411041104110411(r0);
    L_0x0033:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0033;
            case 1: goto L_0x003c;
            default: goto L_0x0037;
        };
    L_0x0037:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x003c;
            case 1: goto L_0x0033;
            default: goto L_0x003b;
        };
    L_0x003b:
        goto L_0x0037;
    L_0x003c:
        r2 = r8.f3673a;
        r0 = r8.f3673a;
        r3 = r0.length;
        r4 = r8.f3678e;
        r0 = r8.f3677d;
        r6 = (long) r0;
        r1.update(r2, r3, r4, r6);
    L_0x0049:
        r0 = r8.f3675b04250425;
        r1 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1359b04110411(r0);
        monitor-enter(r1);
        r0 = r8.f3675b04250425;	 Catch:{ all -> 0x0080 }
        r2 = r8.f3675b04250425;	 Catch:{ all -> 0x0080 }
        r2 = r2.f1298e;	 Catch:{ all -> 0x0080 }
        com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1343b041104110411(r0, r2);	 Catch:{ all -> 0x0080 }
        r0 = r8.f3675b04250425;	 Catch:{ all -> 0x0080 }
        r2 = r8.f3675b04250425;	 Catch:{ all -> 0x0080 }
        r2 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1335b0411041104110411(r2);	 Catch:{ all -> 0x0080 }
        com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1352b041104110411(r0, r2);	 Catch:{ all -> 0x0080 }
        r0 = r8.f3675b04250425;	 Catch:{ all -> 0x0080 }
        r2 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x0080 }
        com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1356b041104110411(r0, r2);	 Catch:{ all -> 0x0080 }
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
    L_0x0070:
        r0 = r8.f3675b04250425;
        r0 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1350b041104110411(r0);
        r1 = r8.f3675b04250425;
        r1 = com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.m1339b0411041104110411(r1);
        r0.post(r1);
    L_0x007f:
        return;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        throw r0;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0083 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rrrrrr.ccrcrr.run():void");
    }
}
