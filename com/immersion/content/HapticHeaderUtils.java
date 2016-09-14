package com.immersion.content;

import java.nio.ByteBuffer;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class HapticHeaderUtils extends HeaderUtils {
    private static final String f4299b = "HapticHeaderUtils";
    public static int f4300b04210421042104210421 = 33;
    public static int f4301b04210421042104210421 = 0;
    public static int f4302b0421042104210421 = 2;
    public static int f4303b042104210421 = 1;
    long f4304a;
    private byte[] f4305c;
    private int f4306d;

    public HapticHeaderUtils() {
        int i = f4300b04210421042104210421;
        switch ((i * (f4303b042104210421 + i)) % f4302b0421042104210421) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4300b04210421042104210421 = 43;
                f4303b042104210421 = m4909b0421042104210421();
                break;
        }
        try {
        } catch (Exception e) {
            throw e;
        }
    }

    public static int m4908b04210421042104210421() {
        return 1;
    }

    public static int m4909b0421042104210421() {
        return 80;
    }

    public static int m4910b0421042104210421() {
        return 0;
    }

    private native int calculateBlockRateNative(long j);

    private native int calculateBlockSizeNative(long j);

    private native int calculateByteOffsetIntoHapticDataNative(long j, int i);

    private native void disposeNative(long j);

    private native String getContentIdNative(long j);

    private native int getEncryptionNative(long j);

    private native int getMajorVersionNumberNative(long j);

    private native int getMinorVersionNumberNative(long j);

    private native int getNumChannelsNative(long j);

    private native long init(byte[] bArr, int i);

    public int calculateBlockRate() {
        if (((f4300b04210421042104210421 + m4908b04210421042104210421()) * f4300b04210421042104210421) % f4302b0421042104210421 != m4910b0421042104210421()) {
            f4300b04210421042104210421 = m4909b0421042104210421();
            f4301b04210421042104210421 = 12;
        }
        return calculateBlockRateNative(this.f4304a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int calculateBlockSize() {
        /*
        r2 = this;
        r0 = f4300b04210421042104210421;
        r1 = f4303b042104210421;
        r0 = r0 + r1;
        r1 = f4300b04210421042104210421;
        r0 = r0 * r1;
        r1 = f4302b0421042104210421;
        r0 = r0 % r1;
        r1 = f4301b04210421042104210421;
        if (r0 == r1) goto L_0x0019;
    L_0x000f:
        r0 = m4909b0421042104210421();
        f4300b04210421042104210421 = r0;
        r0 = 84;
        f4301b04210421042104210421 = r0;
    L_0x0019:
        r0 = r2.f4304a;
        r0 = r2.calculateBlockSizeNative(r0);
    L_0x001f:
        r1 = 1;
        switch(r1) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0028;
            default: goto L_0x0023;
        };
    L_0x0023:
        r1 = 0;
        switch(r1) {
            case 0: goto L_0x0028;
            case 1: goto L_0x001f;
            default: goto L_0x0027;
        };
    L_0x0027:
        goto L_0x0023;
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.content.HapticHeaderUtils.calculateBlockSize():int");
    }

    public int calculateByteOffsetIntoHapticData(int i) {
        long j = this.f4304a;
        int bС0421С042104210421 = m4909b0421042104210421();
        switch ((bС0421С042104210421 * (f4303b042104210421 + bС0421С042104210421)) % f4302b0421042104210421) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4300b04210421042104210421 = 89;
                f4301b04210421042104210421 = m4909b0421042104210421();
                break;
        }
        return calculateByteOffsetIntoHapticDataNative(j, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
        r2 = this;
        r0 = 0;
    L_0x0001:
        switch(r0) {
            case 0: goto L_0x0008;
            case 1: goto L_0x0001;
            default: goto L_0x0004;
        };
    L_0x0004:
        switch(r0) {
            case 0: goto L_0x0008;
            case 1: goto L_0x0001;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0004;
    L_0x0008:
        r0 = f4300b04210421042104210421;
        r1 = m4908b04210421042104210421();
        r0 = r0 + r1;
        r1 = f4300b04210421042104210421;
        r0 = r0 * r1;
        r1 = f4302b0421042104210421;
        r0 = r0 % r1;
        r1 = f4301b04210421042104210421;
        if (r0 == r1) goto L_0x0023;
    L_0x0019:
        r0 = m4909b0421042104210421();
        f4300b04210421042104210421 = r0;
        r0 = 92;
        f4301b04210421042104210421 = r0;
    L_0x0023:
        r0 = r2.f4304a;
        r2.disposeNative(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.content.HapticHeaderUtils.dispose():void");
    }

    public String getContentUUID() {
        try {
            long j = this.f4304a;
            if (((f4300b04210421042104210421 + m4908b04210421042104210421()) * f4300b04210421042104210421) % f4302b0421042104210421 != m4910b0421042104210421()) {
                f4300b04210421042104210421 = 46;
                f4301b04210421042104210421 = 43;
            }
            return getContentIdNative(j);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getEncryption() {
        long j = this.f4304a;
        if (((f4300b04210421042104210421 + f4303b042104210421) * f4300b04210421042104210421) % f4302b0421042104210421 != f4301b04210421042104210421) {
            f4300b04210421042104210421 = m4909b0421042104210421();
            f4301b04210421042104210421 = m4909b0421042104210421();
        }
        return getEncryptionNative(j);
    }

    public int getMajorVersionNumber() {
        return getMajorVersionNumberNative(this.f4304a);
    }

    public int getMinorVersionNumber() {
        if (((f4300b04210421042104210421 + m4908b04210421042104210421()) * f4300b04210421042104210421) % f4302b0421042104210421 != f4301b04210421042104210421) {
            f4300b04210421042104210421 = m4909b0421042104210421();
            f4301b04210421042104210421 = m4909b0421042104210421();
        }
        try {
            try {
                return getMinorVersionNumberNative(this.f4304a);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int getNumChannels() {
        if (((f4300b04210421042104210421 + m4908b04210421042104210421()) * f4300b04210421042104210421) % f4302b0421042104210421 != f4301b04210421042104210421) {
            f4300b04210421042104210421 = 92;
            f4301b04210421042104210421 = m4909b0421042104210421();
        }
        try {
            return getNumChannelsNative(this.f4304a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setEncryptedHSI(ByteBuffer byteBuffer, int i) {
        this.f4306d = i;
        this.f4305c = new byte[this.f4306d];
        byteBuffer.get(this.f4305c, 0, this.f4306d);
        this.f4304a = init(this.f4305c, this.f4306d);
    }
}
