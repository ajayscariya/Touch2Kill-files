package com.immersion.hapticmediasdk.controllers;

import com.immersion.hapticmediasdk.models.HapticFileInformation;
import com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.Profiler;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import rrrrrr.ccrrrr;

public class MemoryMappedFileReader implements IHapticFileReader {
    private static final String f4337a = "MemoryMappedFileReader";
    public static int f4338b044A044A = 1;
    public static int f4339b044A044A = 93;
    public static int f4340b044A = 0;
    public static int f4341b044A = 2;
    private static int f4342g = 0;
    private static int f4343h = 0;
    private static final int f4344j = 4096;
    private static final int f4345k = 12288;
    private File f4346b;
    private FileChannel f4347c;
    private ccrrrr f4348d;
    private ccrrrr f4349e;
    private int f4350f;
    private HapticFileInformation f4351i;
    private String f4352l;
    private final Profiler f4353m;
    private FileManager f4354n;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r2 = 0;
    L_0x0001:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0001;
            case 1: goto L_0x0009;
            default: goto L_0x0005;
        };
    L_0x0005:
        switch(r2) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0001;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0005;
    L_0x0009:
        r0 = 40;
        f4342g = r0;
        r0 = f4339b044A044A;
        r1 = f4338b044A044A;
        r0 = r0 + r1;
        r1 = f4339b044A044A;
        r0 = r0 * r1;
        r1 = f4341b044A;
        r0 = r0 % r1;
        r1 = f4340b044A;
        if (r0 == r1) goto L_0x0024;
    L_0x001c:
        r0 = 55;
        f4339b044A044A = r0;
        r0 = 34;
        f4340b044A = r0;
    L_0x0024:
        f4343h = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.<clinit>():void");
    }

    public MemoryMappedFileReader(String str, FileManager fileManager) {
        try {
            if (((m4944b044A() + f4338b044A044A) * m4944b044A()) % f4341b044A != f4340b044A) {
                f4340b044A = m4944b044A();
            }
            this.f4353m = new Profiler();
            try {
                this.f4352l = str;
                this.f4354n = fileManager;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m4936a(rrrrrr.ccrrrr r4, int r5) {
        /*
        r3 = this;
        r1 = 1;
        r0 = r4.mHapticDataOffset;
    L_0x0003:
        switch(r1) {
            case 0: goto L_0x0003;
            case 1: goto L_0x000a;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r1) {
            case 0: goto L_0x0003;
            case 1: goto L_0x000a;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0006;
    L_0x000a:
        r0 = r5 - r0;
        r1 = f4339b044A044A;
        r2 = m4943b044A044A();
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f4341b044A;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x0026;
            default: goto L_0x001a;
        };
    L_0x001a:
        r1 = m4944b044A();
        f4339b044A044A = r1;
        r1 = m4944b044A();
        f4340b044A = r1;
    L_0x0026:
        r1 = r4.mMappedByteBuffer;
        r1 = r1.capacity();
        r0 = r0 % r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.a(rrrrrr.ccrrrr, int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4937a() {
        /*
        r5 = this;
        r0 = 0;
        r2 = 0;
        r1 = r5.f4351i;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        if (r1 == 0) goto L_0x0033;
    L_0x0006:
        r0 = 1;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = r5.f4346b;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        if (r1 != 0) goto L_0x0016;
    L_0x000c:
        r1 = r5.f4354n;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r3 = r5.f4352l;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r1 = r1.getHapticStorageFile(r3);	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r5.f4346b = r1;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
    L_0x0016:
        r1 = r5.f4347c;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        if (r1 != 0) goto L_0x002a;
    L_0x001a:
        r3 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r1 = r5.f4346b;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r4 = "r";
        r3.<init>(r1, r4);	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        r1 = r3.getChannel();	 Catch:{ FileNotFoundException -> 0x0058, Exception -> 0x0053 }
        r5.f4347c = r1;	 Catch:{ FileNotFoundException -> 0x0058, Exception -> 0x0053 }
        r2 = r3;
    L_0x002a:
        r1 = r5.f4347c;	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        if (r1 == 0) goto L_0x0007;
    L_0x002e:
        r0 = r5.m4940b();	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        goto L_0x0007;
    L_0x0033:
        r1 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
        r1 = r5.m4938a(r1);	 Catch:{ FileNotFoundException -> 0x003c, Exception -> 0x0053 }
        if (r1 == 0) goto L_0x0008;
    L_0x003b:
        goto L_0x0007;
    L_0x003c:
        r1 = move-exception;
    L_0x003d:
        r3 = "MemoryMappedFileReader";
        r1 = r1.getMessage();
        com.immersion.hapticmediasdk.utils.Log.m1418e(r3, r1);
        r1 = r5.f4354n;
        r1.closeCloseable(r2);
        r1 = r5.f4354n;
        r2 = r5.f4347c;
        r1.closeCloseable(r2);
        goto L_0x0007;
    L_0x0053:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0007;
    L_0x0058:
        r1 = move-exception;
        r2 = r3;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.a():boolean");
    }

    private boolean m4938a(int i) {
        if (this.f4350f < i) {
            return false;
        }
        if (((m4944b044A() + f4338b044A044A) * m4944b044A()) % f4341b044A == f4340b044A) {
            return true;
        }
        f4339b044A044A = 58;
        f4340b044A = 75;
        return true;
    }

    private int m4939b(int i) {
        int sampleHertz = i / (1000 / this.f4351i.getSampleHertz());
        if (((f4339b044A044A + f4338b044A044A) * f4339b044A044A) % f4341b044A != f4340b044A) {
            f4339b044A044A = 77;
            f4340b044A = 64;
        }
        int bitsPerSample = this.f4351i.getBitsPerSample();
        int numberOfChannels = this.f4351i.getNumberOfChannels();
        float f = (float) ((bitsPerSample * numberOfChannels) / 8);
        bitsPerSample = (int) f;
        if (((float) (bitsPerSample * numberOfChannels)) / 8.0f > f) {
            bitsPerSample++;
        }
        return bitsPerSample * sampleHertz;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4940b() {
        /*
        r8 = this;
        r2 = 1;
        r6 = 4;
        r1 = 0;
        r0 = 4;
        r0 = java.nio.ByteBuffer.allocate(r0);	 Catch:{ IOException -> 0x0105 }
        r3 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IOException -> 0x0105 }
        r0.order(r3);	 Catch:{ IOException -> 0x0105 }
        r3 = 0;
        r0.position(r3);	 Catch:{ IOException -> 0x0105 }
        r3 = r8.f4347c;	 Catch:{ IOException -> 0x0105 }
        r4 = 16;
        r3 = r3.read(r0, r4);	 Catch:{ IOException -> 0x0105 }
        if (r3 == r6) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r0.flip();	 Catch:{ IOException -> 0x0105 }
        r0 = r0.getInt();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 + 28;
        r3 = java.nio.ByteBuffer.allocate(r0);	 Catch:{ IOException -> 0x0105 }
        r4 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IOException -> 0x0105 }
        r3.order(r4);	 Catch:{ IOException -> 0x0105 }
        r4 = r8.f4347c;	 Catch:{ IOException -> 0x0105 }
        r6 = 0;
        r4 = r4.read(r3, r6);	 Catch:{ IOException -> 0x0105 }
    L_0x0036:
        switch(r1) {
            case 0: goto L_0x003d;
            case 1: goto L_0x0036;
            default: goto L_0x0039;
        };	 Catch:{ IOException -> 0x0105 }
    L_0x0039:
        switch(r2) {
            case 0: goto L_0x0036;
            case 1: goto L_0x003d;
            default: goto L_0x003c;
        };	 Catch:{ IOException -> 0x0105 }
    L_0x003c:
        goto L_0x0039;
    L_0x003d:
        if (r4 != r0) goto L_0x001b;
    L_0x003f:
        r3.flip();	 Catch:{ IOException -> 0x0105 }
        r4 = new com.immersion.hapticmediasdk.models.HapticFileInformation$Builder;	 Catch:{ IOException -> 0x0105 }
        r4.<init>();	 Catch:{ IOException -> 0x0105 }
        r0 = r8.f4346b;	 Catch:{ IOException -> 0x0105 }
        r0 = r0.getAbsolutePath();	 Catch:{ IOException -> 0x0105 }
        r4.setFilePath(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = 4;
        r3.position(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.getInt();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 + 8;
        r4.setTotalFileLength(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = 20;
        r3.position(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r4.setMajorVersion(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r4.setMinorVersion(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r4.setEncoding(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = 24;
        r3.position(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.getInt();	 Catch:{ IOException -> 0x0105 }
        r4.setSampleHertz(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r5 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r5 = r5 << 8;
        r0 = r0 | r5;
        r4.setBitsPerSample(r0);	 Catch:{ IOException -> 0x0105 }
        r5 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r4.setNumberOfChannels(r5);	 Catch:{ IOException -> 0x0105 }
        r6 = new int[r5];	 Catch:{ IOException -> 0x0105 }
        r0 = r1;
    L_0x009b:
        if (r0 >= r5) goto L_0x00a6;
    L_0x009d:
        r7 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r6[r0] = r7;	 Catch:{ IOException -> 0x0105 }
        r0 = r0 + 1;
        goto L_0x009b;
    L_0x00a6:
        r4.setActuatorArray(r6);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.get();	 Catch:{ IOException -> 0x0105 }
        r4.setCompressionScheme(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.position();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 + 4;
        r3.position(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.getInt();	 Catch:{ IOException -> 0x0105 }
        r4.setHapticDataLength(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r3.position();	 Catch:{ IOException -> 0x0105 }
        r4.setHapticDataStartByteOffset(r0);	 Catch:{ IOException -> 0x0105 }
        r0 = r4.build();	 Catch:{ IOException -> 0x0105 }
        r8.f4351i = r0;	 Catch:{ IOException -> 0x0105 }
        r0 = f4342g;	 Catch:{ IOException -> 0x0105 }
        r3 = r8.f4351i;	 Catch:{ IOException -> 0x0105 }
        r3 = r3.getSampleHertz();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 * r3;
        r0 = r0 / 1000;
        r3 = f4339b044A044A;
        r4 = m4943b044A044A();
        r4 = r4 + r3;
        r3 = r3 * r4;
        r4 = f4341b044A;
        r3 = r3 % r4;
        switch(r3) {
            case 0: goto L_0x00f0;
            default: goto L_0x00e6;
        };
    L_0x00e6:
        r3 = m4944b044A();
        f4339b044A044A = r3;
        r3 = 51;
        f4340b044A = r3;
    L_0x00f0:
        r3 = r8.f4351i;	 Catch:{ IOException -> 0x0105 }
        r3 = r3.getBitsPerSample();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 * r3;
        r3 = r8.f4351i;	 Catch:{ IOException -> 0x0105 }
        r3 = r3.getNumberOfChannels();	 Catch:{ IOException -> 0x0105 }
        r0 = r0 * r3;
        r0 = r0 / 8;
        f4343h = r0;	 Catch:{ IOException -> 0x0105 }
        r1 = r2;
        goto L_0x001b;
    L_0x0105:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.b():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4941b(rrrrrr.ccrrrr r3, int r4) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = r3.mHapticDataOffset;
        if (r4 >= r2) goto L_0x001f;
    L_0x0006:
        r1 = f4339b044A044A;
        r2 = f4338b044A044A;
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f4341b044A;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x001e;
            default: goto L_0x0012;
        };
    L_0x0012:
        r1 = m4944b044A();
        f4339b044A044A = r1;
        r1 = m4944b044A();
        f4340b044A = r1;
    L_0x001e:
        return r0;
    L_0x001f:
        switch(r1) {
            case 0: goto L_0x0026;
            case 1: goto L_0x001f;
            default: goto L_0x0022;
        };
    L_0x0022:
        switch(r0) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0026;
            default: goto L_0x0025;
        };
    L_0x0025:
        goto L_0x0022;
    L_0x0026:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.b(rrrrrr.ccrrrr, int):boolean");
    }

    public static int m4942b044A044A044A() {
        return 0;
    }

    public static int m4943b044A044A() {
        return 1;
    }

    public static int m4944b044A() {
        return 73;
    }

    public static int m4945b044A044A044A() {
        return 2;
    }

    private int m4946c(int i) {
        try {
            HapticFileInformation hapticFileInformation = this.f4351i;
            if (((f4339b044A044A + f4338b044A044A) * f4339b044A044A) % f4341b044A != f4340b044A) {
                f4339b044A044A = 98;
                f4340b044A = 21;
            }
            try {
                return hapticFileInformation.getHapticDataStartByteOffset() + m4939b(i);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void m4947c() throws NotEnoughHapticBytesAvailableException, IOException {
        try {
            if (this.f4349e != null) {
                int i = this.f4349e.mHapticDataOffset + f4344j;
                try {
                    this.f4348d = this.f4349e;
                    if (((m4944b044A() + f4338b044A044A) * m4944b044A()) % m4945b044A044A044A() != m4942b044A044A044A()) {
                        f4339b044A044A = 80;
                        f4340b044A = 68;
                    }
                    this.f4349e = m4949d(i);
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean m4948c(ccrrrr rrrrrr_ccrrrr, int i) {
        if (i < rrrrrr_ccrrrr.mHapticDataOffset + rrrrrr_ccrrrr.mMappedByteBuffer.capacity()) {
            return false;
        }
        if (((f4339b044A044A + f4338b044A044A) * f4339b044A044A) % f4341b044A == f4340b044A) {
            return true;
        }
        f4339b044A044A = m4944b044A();
        f4340b044A = m4944b044A();
        return true;
    }

    private ccrrrr m4949d(int i) throws IOException, NotEnoughHapticBytesAvailableException {
        this.f4353m.startTiming();
        if (i < this.f4351i.getHapticDataLength()) {
            int hapticDataStartByteOffset = this.f4351i.getHapticDataStartByteOffset() + i;
            int hapticDataLength = i + f4344j <= this.f4351i.getHapticDataLength() ? f4344j : this.f4351i.getHapticDataLength() - i;
            if (i + hapticDataLength > this.f4350f) {
                throw new NotEnoughHapticBytesAvailableException("Not enough bytes available yet.");
            }
            MappedByteBuffer map = this.f4347c.map(MapMode.READ_ONLY, (long) hapticDataStartByteOffset, (long) hapticDataLength);
            if (map != null) {
                map.order(ByteOrder.LITTLE_ENDIAN);
                ccrrrr rrrrrr_ccrrrr = new ccrrrr();
                rrrrrr_ccrrrr.mMappedByteBuffer = map;
                rrrrrr_ccrrrr.mHapticDataOffset = i;
                return rrrrrr_ccrrrr;
            }
        }
        return null;
    }

    private void m4950d() {
        Log.m1417d(f4337a, "%%%%%%%%%%% logBufferState %%%%%%%%%%%");
        if (this.f4348d != null) {
            Log.m1417d(f4337a, "mCurrentMMW capacity = " + this.f4348d.mMappedByteBuffer.capacity());
            Log.m1417d(f4337a, "mCurrentMMW position = " + this.f4348d.mMappedByteBuffer.position());
            Log.m1417d(f4337a, "mCurrentMMW remaining = " + this.f4348d.mMappedByteBuffer.remaining());
            Log.m1417d(f4337a, "mCurrentMMW mHapticDataOffset = " + this.f4348d.mHapticDataOffset);
            String str = f4337a;
            StringBuilder append = new StringBuilder().append("mCurrentMMW mHapticDataOffset + position = ");
            ccrrrr rrrrrr_ccrrrr = this.f4348d;
            if (((m4944b044A() + f4338b044A044A) * m4944b044A()) % m4945b044A044A044A() != m4942b044A044A044A()) {
                f4339b044A044A = m4944b044A();
                f4340b044A = m4944b044A();
            }
            Log.m1417d(str, append.append(rrrrrr_ccrrrr.mHapticDataOffset + this.f4348d.mMappedByteBuffer.position()).toString());
        } else {
            Log.m1417d(f4337a, "mCurrentMMW is null");
        }
        Log.m1417d(f4337a, "--------------------------------------");
        if (this.f4349e != null) {
            Log.m1417d(f4337a, "mNextMMW capacity = " + this.f4349e.mMappedByteBuffer.capacity());
            Log.m1417d(f4337a, "mNextMMW position = " + this.f4349e.mMappedByteBuffer.position());
            Log.m1417d(f4337a, "mNextMMW remaining = " + this.f4349e.mMappedByteBuffer.remaining());
            Log.m1417d(f4337a, "mNextMMW mHapticDataOffset = " + this.f4349e.mHapticDataOffset);
            Log.m1417d(f4337a, "mNextMMW mHapticDataOffset + position = " + (this.f4349e.mHapticDataOffset + this.f4349e.mMappedByteBuffer.position()));
        } else {
            Log.m1417d(f4337a, "mNextMMW is null");
        }
        Log.m1417d(f4337a, "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    private static boolean m4951d(ccrrrr rrrrrr_ccrrrr, int i) {
        try {
            if (!m4941b(rrrrrr_ccrrrr, i)) {
                boolean c = m4948c(rrrrrr_ccrrrr, i);
                if (((f4339b044A044A + f4338b044A044A) * f4339b044A044A) % f4341b044A != f4340b044A) {
                    f4339b044A044A = 52;
                    f4340b044A = 7;
                }
                if (!c) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean m4952e(ccrrrr rrrrrr_ccrrrr, int i) {
        int i2 = f4339b044A044A;
        switch ((i2 * (m4943b044A044A() + i2)) % f4341b044A) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4339b044A044A = 57;
                f4340b044A = 27;
                break;
        }
        try {
            try {
                return m4948c(rrrrrr_ccrrrr, f4343h + i);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bufferAtPlaybackPosition(int r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = -1;
        r3 = r5.m4937a();	 Catch:{ Exception -> 0x0065 }
        if (r3 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = r5.m4939b(r6);	 Catch:{ Exception -> 0x0065 }
        r4 = r5.f4348d;	 Catch:{ Exception -> 0x0065 }
        if (r4 == 0) goto L_0x001a;
    L_0x0012:
        r4 = r5.f4348d;	 Catch:{ Exception -> 0x0065 }
        r4 = m4951d(r4, r3);	 Catch:{ Exception -> 0x0065 }
        if (r4 == 0) goto L_0x006b;
    L_0x001a:
        r4 = r5.f4349e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r4 == 0) goto L_0x002e;
    L_0x001e:
        r4 = r5.f4349e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r4 = m4951d(r4, r3);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r4 != 0) goto L_0x002e;
    L_0x0026:
        r4 = r5.f4349e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r4 = m4952e(r4, r3);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r4 == 0) goto L_0x0054;
    L_0x002e:
        r2 = r5.f4348d;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r2 == 0) goto L_0x0038;
    L_0x0032:
        r2 = r5.f4348d;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r2 = r2.mHapticDataOffset;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r2 == r3) goto L_0x003e;
    L_0x0038:
        r2 = r5.m4949d(r3);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r5.f4348d = r2;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
    L_0x003e:
        r2 = r5.f4349e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        if (r2 == 0) goto L_0x004a;
    L_0x0042:
        r2 = r5.f4349e;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r2 = r2.mHapticDataOffset;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r4 = r3 + 4096;
        if (r2 == r4) goto L_0x0052;
    L_0x004a:
        r2 = r3 + 4096;
        r2 = r5.m4949d(r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
        r5.f4349e = r2;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
    L_0x0052:
        r0 = r1;
        goto L_0x0009;
    L_0x0054:
        r5.m4947c();	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005a, IOException -> 0x007e }
    L_0x0057:
        r0 = new int[r2];	 Catch:{ Exception -> 0x0067 }
        goto L_0x0057;
    L_0x005a:
        r1 = move-exception;
        r2 = "MemoryMappedFileReader";
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x0065 }
        com.immersion.hapticmediasdk.utils.Log.m1421w(r2, r1);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0009;
    L_0x0065:
        r0 = move-exception;
        throw r0;
    L_0x0067:
        r0 = move-exception;
        r0 = 5;
        f4339b044A044A = r0;
    L_0x006b:
        r0 = r5.f4348d;	 Catch:{ Exception -> 0x0083 }
        if (r0 == 0) goto L_0x007c;
    L_0x006f:
        r0 = r5.f4348d;	 Catch:{ Exception -> 0x0065 }
        r0 = r0.mMappedByteBuffer;	 Catch:{ Exception -> 0x0065 }
        r2 = r5.f4348d;	 Catch:{ Exception -> 0x0083 }
        r2 = r5.m4936a(r2, r3);	 Catch:{ Exception -> 0x0083 }
        r0.position(r2);	 Catch:{ Exception -> 0x0083 }
    L_0x007c:
        r0 = r1;
        goto L_0x0009;
    L_0x007e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0083 }
        goto L_0x0009;
    L_0x0083:
        r0 = move-exception;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.bufferAtPlaybackPosition(int):boolean");
    }

    public void close() {
        int i = f4339b044A044A;
        switch ((i * (m4943b044A044A() + i)) % f4341b044A) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f4339b044A044A = m4944b044A();
                f4340b044A = 35;
                break;
        }
        try {
            this.f4354n.closeCloseable(this.f4347c);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getBlockOffset(long r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0000;
            default: goto L_0x0004;
        };
    L_0x0004:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0000;
            case 1: goto L_0x0009;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0004;
    L_0x0009:
        r0 = f4339b044A044A;
        r1 = f4338b044A044A;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f4341b044A;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x001d;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = 89;
        f4339b044A044A = r0;
        r0 = 47;
        f4340b044A = r0;
    L_0x001d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.getBlockOffset(long):long");
    }

    public int getBlockSizeMS() {
        try {
            int i = f4342g;
            if (((f4339b044A044A + f4338b044A044A) * f4339b044A044A) % f4341b044A != f4340b044A) {
                f4339b044A044A = m4944b044A();
                f4340b044A = m4944b044A();
            }
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getBufferForPlaybackPosition(int r7) throws com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException {
        /*
        r6 = this;
        r0 = 0;
        r4 = 0;
        r1 = r6.f4348d;
        if (r1 != 0) goto L_0x0057;
    L_0x0006:
        return r0;
    L_0x0007:
        r2 = r6.f4348d;
        r2 = r2.mMappedByteBuffer;
        r2 = r2.position();
        r1 = r1 + r2;
        r2 = r6.f4351i;
        r2 = r2.getHapticDataLength();
        if (r1 >= r2) goto L_0x0006;
    L_0x0018:
        r1 = f4343h;	 Catch:{ Exception -> 0x007c }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x007c }
        r2 = f4343h;	 Catch:{ Exception -> 0x007c }
        r3 = r6.f4348d;	 Catch:{ Exception -> 0x007c }
        r3 = r3.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r3 = r3.remaining();	 Catch:{ Exception -> 0x007c }
        if (r2 < r3) goto L_0x008a;
    L_0x0028:
        r2 = r6.f4348d;	 Catch:{ Exception -> 0x007c }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r3 = r2.remaining();	 Catch:{ Exception -> 0x007c }
        r2 = f4343h;	 Catch:{ Exception -> 0x007c }
        r2 = r2 - r3;
        r4 = r6.f4348d;	 Catch:{ Exception -> 0x007c }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r5 = 0;
        r4.get(r1, r5, r3);	 Catch:{ Exception -> 0x007c }
        if (r2 <= 0) goto L_0x0052;
    L_0x003d:
        r4 = r6.f4349e;	 Catch:{ Exception -> 0x007c }
        if (r4 == 0) goto L_0x0052;
    L_0x0041:
        r4 = r6.f4349e;	 Catch:{ Exception -> 0x007c }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r4 = r4.remaining();	 Catch:{ Exception -> 0x007c }
        if (r4 < r2) goto L_0x0081;
    L_0x004b:
        r4 = r6.f4349e;	 Catch:{ Exception -> 0x007c }
        r4 = r4.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r4.get(r1, r3, r2);	 Catch:{ Exception -> 0x007c }
    L_0x0052:
        r6.m4947c();	 Catch:{ Exception -> 0x007c }
    L_0x0055:
        r0 = r1;
        goto L_0x0006;
    L_0x0057:
        r1 = r6.f4348d;
        r2 = f4339b044A044A;
        r3 = f4338b044A044A;
        r2 = r2 + r3;
        r3 = f4339b044A044A;
        r2 = r2 * r3;
        r3 = f4341b044A;
        r2 = r2 % r3;
        r3 = f4340b044A;
        if (r2 == r3) goto L_0x0072;
    L_0x0068:
        r2 = m4944b044A();
        f4339b044A044A = r2;
        r2 = 47;
        f4340b044A = r2;
    L_0x0072:
        r1 = r1.mHapticDataOffset;
    L_0x0074:
        r2 = 1;
        switch(r2) {
            case 0: goto L_0x0074;
            case 1: goto L_0x0007;
            default: goto L_0x0078;
        };
    L_0x0078:
        switch(r4) {
            case 0: goto L_0x0007;
            case 1: goto L_0x0074;
            default: goto L_0x007b;
        };
    L_0x007b:
        goto L_0x0078;
    L_0x007c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0006;
    L_0x0081:
        r2 = r6.f4349e;	 Catch:{ Exception -> 0x007c }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r2 = r2.remaining();	 Catch:{ Exception -> 0x007c }
        goto L_0x004b;
    L_0x008a:
        r2 = r6.f4348d;	 Catch:{ Exception -> 0x007c }
        r2 = r2.mMappedByteBuffer;	 Catch:{ Exception -> 0x007c }
        r3 = 0;
        r4 = f4343h;	 Catch:{ Exception -> 0x007c }
        r2.get(r1, r3, r4);	 Catch:{ Exception -> 0x007c }
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.getBufferForPlaybackPosition(int):byte[]");
    }

    public byte[] getEncryptedHapticHeader() {
        return new byte[0];
    }

    public int getHapticBlockIndex(long j) {
        return 0;
    }

    public HapticFileInformation getHapticFileInformation() {
        return this.f4351i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setBlockSizeMS(int r3) {
        /*
        r2 = this;
        r0 = 1;
        f4342g = r3;
    L_0x0003:
        switch(r0) {
            case 0: goto L_0x0003;
            case 1: goto L_0x000a;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r0) {
            case 0: goto L_0x0003;
            case 1: goto L_0x000a;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0006;
    L_0x000a:
        r0 = m4944b044A();
        r1 = m4943b044A044A();
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f4341b044A;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x001e;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = 15;
        f4340b044A = r0;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.MemoryMappedFileReader.setBlockSizeMS(int):void");
    }

    public void setBytesAvailable(int i) {
        this.f4350f = i;
        if (((f4339b044A044A + m4943b044A044A()) * f4339b044A044A) % f4341b044A != m4942b044A044A044A()) {
            f4339b044A044A = 62;
            f4340b044A = 4;
        }
        m4937a();
    }
}
