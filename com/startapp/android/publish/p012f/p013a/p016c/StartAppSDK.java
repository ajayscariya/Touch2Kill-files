package com.startapp.android.publish.p012f.p013a.p016c;

import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.dom3.as.ASContentModel;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.w3c.dom.traversal.NodeFilter;

/* renamed from: com.startapp.android.publish.f.a.c.a */
public class StartAppSDK extends StartAppSDK {
    static final byte[] f4707a;
    private static final byte[] f4708d;
    private static final byte[] f4709e;
    private static final byte[] f4710f;
    private final byte[] f4711g;
    private final byte[] f4712h;
    private final byte[] f4713i;
    private final int f4714j;
    private final int f4715k;

    static {
        f4707a = new byte[]{(byte) 13, (byte) 10};
        f4708d = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f4709e = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        f4710f = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    }

    public StartAppSDK() {
        this(0);
    }

    public StartAppSDK(boolean z) {
        this(76, f4707a, z);
    }

    public StartAppSDK(int i) {
        this(i, f4707a);
    }

    public StartAppSDK(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public StartAppSDK(int i, byte[] bArr, boolean z) {
        int i2;
        if (bArr == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        super(3, 4, i, i2);
        this.f4712h = f4710f;
        if (bArr == null) {
            this.f4715k = 4;
            this.f4713i = null;
        } else if (m3079c(bArr)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StartAppSDK.m3083a(bArr) + "]");
        } else if (i > 0) {
            this.f4715k = bArr.length + 4;
            this.f4713i = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f4713i, 0, bArr.length);
        } else {
            this.f4715k = 4;
            this.f4713i = null;
        }
        this.f4714j = this.f4715k - 1;
        this.f4711g = z ? f4709e : f4708d;
    }

    void m5455a(byte[] bArr, int i, int i2, StartAppSDK startAppSDK) {
        if (!startAppSDK.f3250f) {
            int i3;
            int i4;
            if (i2 < 0) {
                startAppSDK.f3250f = true;
                if (startAppSDK.f3252h != 0 || this.c != 0) {
                    Object a = m3076a(this.f4715k, startAppSDK);
                    i3 = startAppSDK.f3248d;
                    switch (startAppSDK.f3252h) {
                        case DurationDV.DURATION_TYPE /*0*/:
                            break;
                        case MainNavigationActivity.REQUEST_CODE /*1*/:
                            i4 = startAppSDK.f3248d;
                            startAppSDK.f3248d = i4 + 1;
                            a[i4] = this.f4711g[(startAppSDK.f3245a >> 2) & 63];
                            i4 = startAppSDK.f3248d;
                            startAppSDK.f3248d = i4 + 1;
                            a[i4] = this.f4711g[(startAppSDK.f3245a << 4) & 63];
                            if (this.f4711g == f4708d) {
                                i4 = startAppSDK.f3248d;
                                startAppSDK.f3248d = i4 + 1;
                                a[i4] = 61;
                                i4 = startAppSDK.f3248d;
                                startAppSDK.f3248d = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                            i4 = startAppSDK.f3248d;
                            startAppSDK.f3248d = i4 + 1;
                            a[i4] = this.f4711g[(startAppSDK.f3245a >> 10) & 63];
                            i4 = startAppSDK.f3248d;
                            startAppSDK.f3248d = i4 + 1;
                            a[i4] = this.f4711g[(startAppSDK.f3245a >> 4) & 63];
                            i4 = startAppSDK.f3248d;
                            startAppSDK.f3248d = i4 + 1;
                            a[i4] = this.f4711g[(startAppSDK.f3245a << 2) & 63];
                            if (this.f4711g == f4708d) {
                                i4 = startAppSDK.f3248d;
                                startAppSDK.f3248d = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + startAppSDK.f3252h);
                    }
                    startAppSDK.f3251g = (startAppSDK.f3248d - i3) + startAppSDK.f3251g;
                    if (this.c > 0 && startAppSDK.f3251g > 0) {
                        System.arraycopy(this.f4713i, 0, a, startAppSDK.f3248d, this.f4713i.length);
                        startAppSDK.f3248d += this.f4713i.length;
                        return;
                    }
                    return;
                }
                return;
            }
            i3 = 0;
            while (i3 < i2) {
                Object a2 = m3076a(this.f4715k, startAppSDK);
                startAppSDK.f3252h = (startAppSDK.f3252h + 1) % 3;
                i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += NodeFilter.SHOW_DOCUMENT;
                }
                startAppSDK.f3245a = i5 + (startAppSDK.f3245a << 8);
                if (startAppSDK.f3252h == 0) {
                    i5 = startAppSDK.f3248d;
                    startAppSDK.f3248d = i5 + 1;
                    a2[i5] = this.f4711g[(startAppSDK.f3245a >> 18) & 63];
                    i5 = startAppSDK.f3248d;
                    startAppSDK.f3248d = i5 + 1;
                    a2[i5] = this.f4711g[(startAppSDK.f3245a >> 12) & 63];
                    i5 = startAppSDK.f3248d;
                    startAppSDK.f3248d = i5 + 1;
                    a2[i5] = this.f4711g[(startAppSDK.f3245a >> 6) & 63];
                    i5 = startAppSDK.f3248d;
                    startAppSDK.f3248d = i5 + 1;
                    a2[i5] = this.f4711g[startAppSDK.f3245a & 63];
                    startAppSDK.f3251g += 4;
                    if (this.c > 0 && this.c <= startAppSDK.f3251g) {
                        System.arraycopy(this.f4713i, 0, a2, startAppSDK.f3248d, this.f4713i.length);
                        startAppSDK.f3248d += this.f4713i.length;
                        startAppSDK.f3251g = 0;
                    }
                }
                i3++;
                i = i4;
            }
        }
    }

    public static String m5451a(byte[] bArr) {
        return StartAppSDK.m3083a(StartAppSDK.m5452a(bArr, false));
    }

    public static byte[] m5452a(byte[] bArr, boolean z) {
        return StartAppSDK.m5453a(bArr, z, false);
    }

    public static byte[] m5453a(byte[] bArr, boolean z, boolean z2) {
        return StartAppSDK.m5454a(bArr, z, z2, (int) ASContentModel.AS_UNBOUNDED);
    }

    public static byte[] m5454a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        StartAppSDK startAppSDK = z ? new StartAppSDK(z2) : new StartAppSDK(0, f4707a, z2);
        long d = startAppSDK.m3080d(bArr);
        if (d <= ((long) i)) {
            return startAppSDK.m3078b(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + d + ") than the specified maximum size of " + i);
    }

    protected boolean m5456a(byte b) {
        return b >= null && b < this.f4712h.length && this.f4712h[b] != -1;
    }
}
