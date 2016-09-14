package com.immersion.hapticmediasdk.controllers;

import com.immersion.content.HapticHeaderUtils;
import com.immersion.content.HeaderUtils;
import com.immersion.hapticmediasdk.models.HapticFileInformation;
import com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Profiler;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import rrrrrr.rcrcrr;

public class MemoryAlignedFileReader implements IHapticFileReader {
    private static final String f4313a = "MemoryAlignedFileReader";
    public static int f4314b04150415 = 10;
    public static int f4315b041504150415 = 1;
    public static int f4316b04150415 = 0;
    public static int f4317b04150415 = 2;
    private static int f4318h = 0;
    private static int f4319i = 0;
    private static final int f4320k = 1024;
    private static final int f4321l = 3072;
    private static final int f4322t = 16;
    private File f4323b;
    private FileChannel f4324c;
    private rcrcrr f4325d;
    private rcrcrr f4326e;
    private int f4327f;
    private int f4328g;
    private HapticFileInformation f4329j;
    private String f4330m;
    private FileManager f4331n;
    private HeaderUtils f4332o;
    private byte[] f4333p;
    private final Profiler f4334q;
    private int f4335r;
    private int f4336s;

    static {
        f4318h = 80;
        f4319i = 0;
    }

    public MemoryAlignedFileReader(String str, HeaderUtils headerUtils) {
        try {
            this.f4327f = 0;
            this.f4330m = null;
            this.f4331n = null;
            this.f4333p = null;
            try {
                this.f4334q = new Profiler();
                this.f4330m = str;
                int i = f4314b04150415;
                switch ((i * (f4315b041504150415 + i)) % f4317b04150415) {
                    case DurationDV.DURATION_TYPE /*0*/:
                        break;
                    default:
                        f4314b04150415 = m4924b041504150415();
                        f4316b04150415 = 92;
                        break;
                }
                this.f4332o = headerUtils;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public MemoryAlignedFileReader(String str, FileManager fileManager, int i) {
        try {
            if (((f4314b04150415 + m4923b041504150415()) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
                f4314b04150415 = m4924b041504150415();
                f4316b04150415 = m4924b041504150415();
            }
            this.f4327f = 0;
            this.f4330m = null;
            this.f4331n = null;
            this.f4333p = null;
            this.f4334q = new Profiler();
            try {
                this.f4330m = str;
                this.f4331n = fileManager;
                this.f4332o = new HapticHeaderUtils();
                this.f4327f = i;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private int m4917a(rcrcrr rrrrrr_rcrcrr, int i) {
        if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
            f4314b04150415 = 0;
            f4316b04150415 = m4924b041504150415();
        }
        try {
            try {
                return (i - rrrrrr_rcrcrr.mHapticDataOffset) % rrrrrr_rcrcrr.mMappedByteBuffer.capacity();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4918a() {
        /*
        r5 = this;
        r0 = 0;
        r1 = 0;
        r2 = r5.f4329j;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 == 0) goto L_0x0008;
    L_0x0006:
        r0 = 1;
    L_0x0007:
        return r0;
    L_0x0008:
        r2 = r5.f4323b;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 != 0) goto L_0x001a;
    L_0x000c:
        r2 = r5.f4331n;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 == 0) goto L_0x006d;
    L_0x0010:
        r2 = r5.f4331n;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r3 = r5.f4330m;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r2 = r2.getHapticStorageFile(r3);	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r5.f4323b = r2;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
    L_0x001a:
        r2 = r5.f4324c;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 != 0) goto L_0x002e;
    L_0x001e:
        r2 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r3 = r5.f4323b;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r4 = "r";
        r2.<init>(r3, r4);	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r1 = r2.getChannel();	 Catch:{ FileNotFoundException -> 0x007d, Exception -> 0x0063 }
        r5.f4324c = r1;	 Catch:{ FileNotFoundException -> 0x007d, Exception -> 0x0063 }
        r1 = r2;
    L_0x002e:
        r2 = r5.f4324c;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 != 0) goto L_0x0068;
    L_0x0032:
        r1 = f4314b04150415;
        r2 = f4315b041504150415;
        r1 = r1 + r2;
        r2 = f4314b04150415;
        r1 = r1 * r2;
        r2 = f4317b04150415;
        r1 = r1 % r2;
        r2 = f4316b04150415;
        if (r1 == r2) goto L_0x0007;
    L_0x0041:
        r1 = m4924b041504150415();
        f4314b04150415 = r1;
        r1 = 96;
        f4316b04150415 = r1;
        goto L_0x0007;
    L_0x004c:
        r2 = move-exception;
    L_0x004d:
        r2 = "MemoryAlignedFileReader";
        r3 = "FileNotFoundException";
        com.immersion.hapticmediasdk.utils.Log.m1418e(r2, r3);	 Catch:{ Exception -> 0x007b }
        r2 = r5.f4331n;	 Catch:{ Exception -> 0x007b }
        r2.closeCloseable(r1);	 Catch:{ Exception -> 0x007b }
        r1 = r5.f4331n;	 Catch:{ Exception -> 0x0061 }
        r2 = r5.f4324c;	 Catch:{ Exception -> 0x0061 }
        r1.closeCloseable(r2);	 Catch:{ Exception -> 0x0061 }
        goto L_0x0007;
    L_0x0061:
        r0 = move-exception;
        throw r0;
    L_0x0063:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0061 }
        goto L_0x0007;
    L_0x0068:
        r0 = r5.m4921b();	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        goto L_0x0007;
    L_0x006d:
        r2 = r5.f4330m;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        if (r2 == 0) goto L_0x0007;
    L_0x0071:
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r3 = r5.f4330m;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        r5.f4323b = r2;	 Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x0063 }
        goto L_0x001a;
    L_0x007b:
        r0 = move-exception;
        throw r0;
    L_0x007d:
        r1 = move-exception;
        r1 = r2;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.a():boolean");
    }

    private boolean m4919a(int i) {
        if (((f4314b04150415 + m4923b041504150415()) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
            f4314b04150415 = 31;
            f4316b04150415 = 17;
        }
        try {
            return this.f4328g >= i;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m4920b(int r3) {
        /*
        r2 = this;
        r0 = 0;
        r1 = r2.f4332o;
        if (r1 == 0) goto L_0x0026;
    L_0x0005:
        switch(r0) {
            case 0: goto L_0x000c;
            case 1: goto L_0x0005;
            default: goto L_0x0008;
        };
    L_0x0008:
        switch(r0) {
            case 0: goto L_0x000c;
            case 1: goto L_0x0005;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0008;
    L_0x000c:
        r0 = f4314b04150415;
        r1 = f4315b041504150415;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f4317b04150415;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x0020;
            default: goto L_0x0018;
        };
    L_0x0018:
        r0 = 53;
        f4314b04150415 = r0;
        r0 = 85;
        f4316b04150415 = r0;
    L_0x0020:
        r0 = r2.f4332o;
        r0 = r0.calculateByteOffsetIntoHapticData(r3);
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.b(int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4921b() {
        /*
        r8 = this;
        r6 = 4;
        r0 = 0;
        r1 = -1;
        r2 = 4;
        r2 = java.nio.ByteBuffer.allocate(r2);	 Catch:{ IOException -> 0x0080 }
        r3 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IOException -> 0x0080 }
        r2.order(r3);	 Catch:{ IOException -> 0x0080 }
        r3 = 0;
        r2.position(r3);	 Catch:{ IOException -> 0x0080 }
        r3 = r8.f4324c;	 Catch:{ IOException -> 0x0080 }
        r4 = 16;
        r3 = r3.read(r2, r4);	 Catch:{ IOException -> 0x0080 }
        if (r3 == r6) goto L_0x005c;
    L_0x001b:
        return r0;
    L_0x001c:
        r5 = 4;
        r4.position(r5);	 Catch:{ IOException -> 0x0080 }
        r5 = r4.getInt();	 Catch:{ IOException -> 0x0080 }
        r5 = r5 + 8;
        r5 = r5 - r3;
        r8.f4335r = r5;	 Catch:{ IOException -> 0x0080 }
        r8.f4336s = r3;	 Catch:{ IOException -> 0x0080 }
        r3 = 20;
        r4.position(r3);	 Catch:{ IOException -> 0x0080 }
        r3 = new byte[r2];	 Catch:{ IOException -> 0x0080 }
        r8.f4333p = r3;	 Catch:{ IOException -> 0x0080 }
        r3 = r4.duplicate();	 Catch:{ IOException -> 0x0080 }
        r5 = r8.f4333p;	 Catch:{ IOException -> 0x0080 }
        r6 = 0;
        r3.get(r5, r6, r2);	 Catch:{ IOException -> 0x0080 }
        r3 = r8.f4332o;	 Catch:{ IOException -> 0x0080 }
        r3.setEncryptedHSI(r4, r2);	 Catch:{ IOException -> 0x0080 }
        r2 = r8.f4332o;	 Catch:{ IOException -> 0x0080 }
        r2 = r2.calculateBlockSize();	 Catch:{ IOException -> 0x0080 }
        if (r2 <= 0) goto L_0x001b;
    L_0x004b:
        r2 = r2 * 2;
        f4319i = r2;	 Catch:{ IOException -> 0x0080 }
        r2 = r8.f4332o;	 Catch:{ IOException -> 0x0080 }
        r2 = r2.calculateBlockRate();	 Catch:{ IOException -> 0x0080 }
        if (r2 <= 0) goto L_0x001b;
    L_0x0057:
        f4318h = r2;	 Catch:{ IOException -> 0x0080 }
    L_0x0059:
        r0 = new int[r1];	 Catch:{ Exception -> 0x0085 }
        goto L_0x0059;
    L_0x005c:
        r2.flip();	 Catch:{ IOException -> 0x0080 }
        r2 = r2.getInt();	 Catch:{ IOException -> 0x0080 }
    L_0x0063:
        switch(r0) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0063;
            default: goto L_0x0066;
        };	 Catch:{ IOException -> 0x0080 }
    L_0x0066:
        switch(r0) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0063;
            default: goto L_0x0069;
        };	 Catch:{ IOException -> 0x0080 }
    L_0x0069:
        goto L_0x0066;
    L_0x006a:
        r3 = r2 + 28;
        r4 = java.nio.ByteBuffer.allocate(r3);	 Catch:{ IOException -> 0x0080 }
        r5 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IOException -> 0x0080 }
        r4.order(r5);	 Catch:{ IOException -> 0x0080 }
        r5 = r8.f4324c;	 Catch:{ IOException -> 0x0080 }
        r6 = 0;
        r5 = r5.read(r4, r6);	 Catch:{ IOException -> 0x0080 }
        if (r5 == r3) goto L_0x001c;
    L_0x007f:
        goto L_0x001b;
    L_0x0080:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001b;
    L_0x0085:
        r0 = move-exception;
        r0 = m4924b041504150415();
        f4314b04150415 = r0;
        r0 = 1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.b():boolean");
    }

    private static boolean m4922b(rcrcrr rrrrrr_rcrcrr, int i) {
        if (i >= rrrrrr_rcrcrr.mHapticDataOffset) {
            return false;
        }
        if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % m4925b041504150415() == f4316b04150415) {
            return true;
        }
        f4314b04150415 = 22;
        f4316b04150415 = m4924b041504150415();
        return true;
    }

    public static int m4923b041504150415() {
        return 1;
    }

    public static int m4924b041504150415() {
        return 23;
    }

    public static int m4925b041504150415() {
        return 2;
    }

    public static int m4926b041504150415() {
        return 0;
    }

    private int m4927c(int i) {
        return this.f4336s + m4920b(i);
    }

    private void m4928c() throws NotEnoughHapticBytesAvailableException, IOException {
        String str = null;
        try {
            if (this.f4326e == null) {
                while (true) {
                    try {
                        int[] iArr = new int[-1];
                    } catch (Exception e) {
                        f4314b04150415 = m4924b041504150415();
                        while (true) {
                            try {
                                str.length();
                            } catch (Exception e2) {
                                f4314b04150415 = 39;
                                while (true) {
                                    try {
                                        int[] iArr2 = new int[-1];
                                    } catch (Exception e3) {
                                        f4314b04150415 = 45;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int i = this.f4326e.mHapticDataOffset + f4320k;
            this.f4325d = this.f4326e;
            try {
                this.f4326e = m4931d(i - (f4319i / 2));
            } catch (Exception e4) {
                throw e4;
            }
        } catch (Exception e42) {
            throw e42;
        }
    }

    private static boolean m4929c(rcrcrr rrrrrr_rcrcrr, int i) {
        try {
            if (i < rrrrrr_rcrcrr.mHapticDataOffset + rrrrrr_rcrcrr.mMappedByteBuffer.capacity()) {
                return false;
            }
            if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % f4317b04150415 == m4926b041504150415()) {
                return true;
            }
            f4314b04150415 = m4924b041504150415();
            f4316b04150415 = m4924b041504150415();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    private int m4930d() {
        try {
            if (this.f4332o == null) {
                return 0;
            }
            try {
                int numChannels = this.f4332o.getNumChannels();
                if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % f4317b04150415 == f4316b04150415) {
                    return numChannels;
                }
                f4314b04150415 = m4924b041504150415();
                f4316b04150415 = m4924b041504150415();
                return numChannels;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private rcrcrr m4931d(int i) throws IOException, NotEnoughHapticBytesAvailableException {
        try {
            this.f4334q.startTiming();
            if (i < this.f4335r) {
                int i2 = this.f4336s + i;
                try {
                    int i3;
                    int f = m4935f();
                    if ((i + f4320k) + f <= this.f4335r) {
                        f += f4320k;
                        if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
                            f4314b04150415 = 31;
                            f4316b04150415 = 69;
                        }
                        i3 = f;
                    } else {
                        i3 = this.f4335r - i;
                    }
                    if (i + i3 > this.f4328g) {
                        throw new NotEnoughHapticBytesAvailableException("Not enough bytes available yet.");
                    }
                    MappedByteBuffer map = this.f4324c.map(MapMode.READ_ONLY, (long) i2, (long) i3);
                    if (map != null) {
                        map.order(ByteOrder.BIG_ENDIAN);
                        rcrcrr rrrrrr_rcrcrr = new rcrcrr();
                        rrrrrr_rcrcrr.mMappedByteBuffer = map;
                        rrrrrr_rcrcrr.mHapticDataOffset = i;
                        return rrrrrr_rcrcrr;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4932d(rrrrrr.rcrcrr r3, int r4) {
        /*
        r0 = 1;
        r1 = m4922b(r3, r4);
        if (r1 != 0) goto L_0x002c;
    L_0x0007:
        switch(r0) {
            case 0: goto L_0x0007;
            case 1: goto L_0x000e;
            default: goto L_0x000a;
        };
    L_0x000a:
        switch(r0) {
            case 0: goto L_0x0007;
            case 1: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x000a;
    L_0x000e:
        r1 = m4929c(r3, r4);
        if (r1 == 0) goto L_0x002d;
    L_0x0014:
        r1 = m4924b041504150415();
        r2 = f4315b041504150415;
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f4317b04150415;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x002c;
            default: goto L_0x0022;
        };
    L_0x0022:
        r1 = m4924b041504150415();
        f4314b04150415 = r1;
        r1 = 24;
        f4316b04150415 = r1;
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = 0;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.d(rrrrrr.rcrcrr, int):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4933e() {
        /*
        r4 = this;
        r3 = 1;
        r0 = "MemoryAlignedFileReader";
        r1 = "%%%%%%%%%%% logBufferState %%%%%%%%%%%";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = r4.f4325d;
        if (r0 == 0) goto L_0x0185;
    L_0x000c:
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mCurrentMMW capacity = ";
        r1 = r1.append(r2);
        r2 = r4.f4325d;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.capacity();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0033:
        switch(r3) {
            case 0: goto L_0x0033;
            case 1: goto L_0x003a;
            default: goto L_0x0036;
        };
    L_0x0036:
        switch(r3) {
            case 0: goto L_0x0033;
            case 1: goto L_0x003a;
            default: goto L_0x0039;
        };
    L_0x0039:
        goto L_0x0036;
    L_0x003a:
        r2 = "mCurrentMMW position = ";
        r1 = r1.append(r2);
        r2 = r4.f4325d;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.position();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mCurrentMMW remaining = ";
        r1 = r1.append(r2);
        r2 = r4.f4325d;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.remaining();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mCurrentMMW mHapticDataOffset = ";
        r1 = r1.append(r2);
        r2 = r4.f4325d;
        r2 = r2.mHapticDataOffset;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mCurrentMMW mHapticDataOffset + position = ";
        r1 = r1.append(r2);
        r2 = r4.f4325d;
        r2 = r2.mHapticDataOffset;
        r3 = r4.f4325d;
        r3 = r3.mMappedByteBuffer;
        r3 = r3.position();
        r2 = r2 + r3;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
    L_0x00b4:
        r0 = "MemoryAlignedFileReader";
        r1 = "--------------------------------------";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = r4.f4326e;
        if (r0 == 0) goto L_0x018e;
    L_0x00bf:
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mNextMMW capacity = ";
        r1 = r1.append(r2);
        r2 = r4.f4326e;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.capacity();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mNextMMW position = ";
        r1 = r1.append(r2);
        r2 = r4.f4326e;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.position();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mNextMMW remaining = ";
        r1 = r1.append(r2);
        r2 = r4.f4326e;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.remaining();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mNextMMW mHapticDataOffset = ";
        r1 = r1.append(r2);
        r2 = r4.f4326e;
        r2 = r2.mHapticDataOffset;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        r0 = "MemoryAlignedFileReader";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mNextMMW mHapticDataOffset + position = ";
        r1 = r1.append(r2);
        r2 = f4314b04150415;
        r3 = m4923b041504150415();
        r2 = r2 + r3;
        r3 = f4314b04150415;
        r2 = r2 * r3;
        r3 = f4317b04150415;
        r2 = r2 % r3;
        r3 = f4316b04150415;
        if (r2 == r3) goto L_0x0165;
    L_0x0159:
        r2 = m4924b041504150415();
        f4314b04150415 = r2;
        r2 = m4924b041504150415();
        f4316b04150415 = r2;
    L_0x0165:
        r2 = r4.f4326e;
        r2 = r2.mHapticDataOffset;
        r3 = r4.f4326e;
        r3 = r3.mMappedByteBuffer;
        r3 = r3.position();
        r2 = r2 + r3;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
    L_0x017d:
        r0 = "MemoryAlignedFileReader";
        r1 = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        return;
    L_0x0185:
        r0 = "MemoryAlignedFileReader";
        r1 = "mCurrentMMW is null";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        goto L_0x00b4;
    L_0x018e:
        r0 = "MemoryAlignedFileReader";
        r1 = "mNextMMW is null";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);
        goto L_0x017d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.e():void");
    }

    private static boolean m4934e(rcrcrr rrrrrr_rcrcrr, int i) {
        try {
            int i2 = f4319i;
            int i3 = f4314b04150415;
            switch ((i3 * (f4315b041504150415 + i3)) % f4317b04150415) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                default:
                    f4314b04150415 = 4;
                    f4316b04150415 = 62;
                    break;
            }
            return m4929c(rrrrrr_rcrcrr, i2 + i);
        } catch (Exception e) {
            throw e;
        }
    }

    private int m4935f() {
        int i = 0;
        while ((i + f4320k) % (f4319i / 2) != 0) {
            i += f4322t;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bufferAtPlaybackPosition(int r8) {
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        r2 = r7.m4918a();
        if (r2 != 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r2 = r7.m4920b(r8);
        r3 = r7.f4335r;
        if (r2 >= r3) goto L_0x0008;
    L_0x0011:
        r3 = r7.f4325d;
        if (r3 == 0) goto L_0x001d;
    L_0x0015:
        r3 = r7.f4325d;
        r3 = m4932d(r3, r2);
        if (r3 == 0) goto L_0x007f;
    L_0x001d:
        r3 = r7.f4326e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 == 0) goto L_0x0031;
    L_0x0021:
        r3 = r7.f4326e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r3 = m4932d(r3, r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 != 0) goto L_0x0031;
    L_0x0029:
        r3 = r7.f4326e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r3 = m4934e(r3, r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 == 0) goto L_0x007c;
    L_0x0031:
        r3 = r7.f4325d;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 == 0) goto L_0x003b;
    L_0x0035:
        r3 = r7.f4325d;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r3 = r3.mHapticDataOffset;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 == r2) goto L_0x0041;
    L_0x003b:
        r3 = r7.m4931d(r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r7.f4325d = r3;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
    L_0x0041:
        r3 = r7.f4326e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        if (r3 == 0) goto L_0x006d;
    L_0x0045:
        r3 = r7.f4326e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r3 = r3.mHapticDataOffset;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r4 = r2 + 1024;
        r5 = f4319i;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r5 = r5 / 2;
        r4 = r4 - r5;
        r5 = m4924b041504150415();
        r6 = f4315b041504150415;
        r5 = r5 + r6;
        r6 = m4924b041504150415();
        r5 = r5 * r6;
        r6 = f4317b04150415;
        r5 = r5 % r6;
        r6 = f4316b04150415;
        if (r5 == r6) goto L_0x006b;
    L_0x0063:
        r5 = 98;
        f4314b04150415 = r5;
        r5 = 73;
        f4316b04150415 = r5;
    L_0x006b:
        if (r3 == r4) goto L_0x007a;
    L_0x006d:
        r2 = r2 + 1024;
        r3 = f4319i;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r3 = r3 / 2;
        r2 = r2 - r3;
        r2 = r7.m4931d(r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
        r7.f4326e = r2;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
    L_0x007a:
        r0 = r1;
        goto L_0x0008;
    L_0x007c:
        r7.m4928c();	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x0096, IOException -> 0x0093 }
    L_0x007f:
        r0 = r7.f4325d;
        if (r0 == 0) goto L_0x0090;
    L_0x0083:
        r0 = r7.f4325d;
        r0 = r0.mMappedByteBuffer;
        r3 = r7.f4325d;
        r2 = r7.m4917a(r3, r2);
        r0.position(r2);
    L_0x0090:
        r0 = r1;
        goto L_0x0008;
    L_0x0093:
        r1 = move-exception;
        goto L_0x0008;
    L_0x0096:
        r1 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.bufferAtPlaybackPosition(int):boolean");
    }

    public void close() {
        this.f4331n.closeCloseable(this.f4324c);
        this.f4332o.dispose();
    }

    public long getBlockOffset(long j) {
        long j2 = j % ((long) f4318h);
        int i = f4314b04150415;
        switch ((i * (f4315b041504150415 + i)) % f4317b04150415) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4314b04150415 = m4924b041504150415();
                f4316b04150415 = 40;
                break;
        }
        return (j2 * 16) / ((long) f4318h);
    }

    public int getBlockSizeMS() {
        int i = f4318h;
        if (((f4314b04150415 + f4315b041504150415) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
            f4314b04150415 = 57;
            f4316b04150415 = 94;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getBufferForPlaybackPosition(int r8) throws com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException {
        /*
        r7 = this;
        r0 = 0;
        r3 = 0;
        r1 = r7.f4325d;
        if (r1 != 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r2 = r7.m4920b(r8);
        r1 = r7.f4335r;
        r4 = f4319i;
        r1 = r1 - r4;
        if (r2 >= r1) goto L_0x0006;
    L_0x0012:
        r1 = f4319i;	 Catch:{ Exception -> 0x00b0 }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x00b0 }
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.remaining();	 Catch:{ Exception -> 0x00b0 }
        r5 = f4319i;	 Catch:{ Exception -> 0x00b0 }
        if (r4 >= r5) goto L_0x0025;
    L_0x0022:
        r7.m4928c();	 Catch:{ Exception -> 0x00b0 }
    L_0x0025:
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.position();	 Catch:{ Exception -> 0x00b0 }
        r5 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r5 = r5.mHapticDataOffset;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4 + r5;
        if (r4 < r2) goto L_0x0036;
    L_0x0034:
        if (r4 <= r2) goto L_0x004a;
    L_0x0036:
        r2 = r2 - r4;
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.position();	 Catch:{ Exception -> 0x00b0 }
        r2 = r2 + r4;
        if (r2 >= 0) goto L_0x009b;
    L_0x0042:
        r2 = r3;
    L_0x0043:
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4.position(r2);	 Catch:{ Exception -> 0x00b0 }
    L_0x004a:
        r2 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.remaining();	 Catch:{ Exception -> 0x00b0 }
        r4 = f4314b04150415;
        r5 = f4315b041504150415;
        r5 = r5 + r4;
        r4 = r4 * r5;
        r5 = m4925b041504150415();
        r4 = r4 % r5;
        switch(r4) {
            case 0: goto L_0x006c;
            default: goto L_0x0060;
        };
    L_0x0060:
        r4 = m4924b041504150415();
        f4314b04150415 = r4;
        r4 = m4924b041504150415();
        f4316b04150415 = r4;
    L_0x006c:
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r5 = 0;
        r6 = f4319i;	 Catch:{ Exception -> 0x00b0 }
        if (r2 >= r6) goto L_0x0098;
    L_0x0075:
        r4.get(r1, r5, r2);	 Catch:{ Exception -> 0x00b0 }
        r2 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.position();	 Catch:{ Exception -> 0x00b0 }
    L_0x0084:
        switch(r3) {
            case 0: goto L_0x008c;
            case 1: goto L_0x0084;
            default: goto L_0x0087;
        };	 Catch:{ Exception -> 0x00b0 }
    L_0x0087:
        r5 = 1;
        switch(r5) {
            case 0: goto L_0x0084;
            case 1: goto L_0x008c;
            default: goto L_0x008b;
        };	 Catch:{ Exception -> 0x00b0 }
    L_0x008b:
        goto L_0x0087;
    L_0x008c:
        r3 = f4319i;	 Catch:{ Exception -> 0x00b0 }
        r3 = r3 / 2;
        r3 = r4 - r3;
        r2.position(r3);	 Catch:{ Exception -> 0x00b0 }
        r0 = r1;
        goto L_0x0006;
    L_0x0098:
        r2 = f4319i;	 Catch:{ Exception -> 0x00b0 }
        goto L_0x0075;
    L_0x009b:
        r4 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r4 = r4.limit();	 Catch:{ Exception -> 0x00b0 }
        if (r4 >= r2) goto L_0x0043;
    L_0x00a5:
        r2 = r7.f4325d;	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.limit();	 Catch:{ Exception -> 0x00b0 }
        r2 = r2 + -1;
        goto L_0x0043;
    L_0x00b0:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryAlignedFileReader.getBufferForPlaybackPosition(int):byte[]");
    }

    public byte[] getEncryptedHapticHeader() {
        return this.f4333p;
    }

    public int getHapticBlockIndex(long j) {
        try {
            int b = m4920b((int) j);
            int i = this.f4327f;
            if (((f4314b04150415 + m4923b041504150415()) * f4314b04150415) % f4317b04150415 != f4316b04150415) {
                f4314b04150415 = 2;
                f4316b04150415 = m4924b041504150415();
            }
            if (i == 2) {
                return b / f4322t;
            }
            if (this.f4327f < 3) {
                return 0;
            }
            try {
                return b / (m4930d() * f4322t);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public HapticFileInformation getHapticFileInformation() {
        return this.f4329j;
    }

    public void setBlockSizeMS(int i) {
        int i2 = f4314b04150415;
        switch ((i2 * (m4923b041504150415() + i2)) % f4317b04150415) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4314b04150415 = m4924b041504150415();
                f4316b04150415 = m4924b041504150415();
                break;
        }
        try {
            f4318h = i;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setBytesAvailable(int i) {
        this.f4328g = i;
        if (this.f4328g <= 0) {
            this.f4328g = i;
            m4918a();
        }
    }
}
