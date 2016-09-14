package com.immersion.hapticmediasdk.controllers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Profiler;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import rrrrrr.ccrcrr;
import rrrrrr.crcrrr;
import rrrrrr.rccrrr;
import rrrrrr.rrcrrr;

public class HapticPlaybackThread extends Thread {
    private static final long f1280D = 100;
    private static final int f1281E = 5;
    public static final int HAPTIC_BYTES_AVAILABLE_TO_DOWNLOAD = 3;
    public static final int HAPTIC_DOWNLOAD_ERROR = 8;
    public static final String HAPTIC_DOWNLOAD_EXCEPTION_KEY = "haptic_download_exception";
    public static final int HAPTIC_PAUSE_PLAYBACK = 5;
    public static final int HAPTIC_PLAYBACK_FOR_TIME_CODE = 2;
    public static final int HAPTIC_PLAYBACK_IS_READY = 6;
    public static final int HAPTIC_QUIT_PLAYBACK = 9;
    public static final int HAPTIC_SET_BUFFERING_POSITION = 1;
    public static final int HAPTIC_STOP_PLAYBACK = 4;
    public static final int PAUSE_AV_FOR_HAPTIC_BUFFERING = 7;
    private static final String f1282a = "HapticPlaybackThread";
    private static final int f1283b = Integer.MIN_VALUE;
    public static int f1284b0427042704270427 = 1;
    public static int f1285b042704270427 = 0;
    public static int f1286b042704270427 = 86;
    public static int f1287b0427 = 2;
    private static final String f1288c = "playback_timecode";
    private static final String f1289d = "playback_uptime";
    private RuntimeInfo f1290A;
    private boolean f1291B;
    private FileManager f1292C;
    private final Runnable f1293F;
    private final Runnable f1294G;
    public volatile boolean f1295b0444044404440444;
    public Context f1296b044404440444;
    public volatile boolean f1297b04440444;
    private int f1298e;
    private final String f1299f;
    private Handler f1300g;
    private final Handler f1301h;
    private HapticDownloadThread f1302i;
    private Looper f1303j;
    private IHapticFileReader f1304k;
    private EndpointWarp f1305l;
    private final Profiler f1306m;
    private Object f1307n;
    private Object f1308o;
    private int f1309p;
    private int f1310q;
    private int f1311r;
    private long f1312s;
    private int f1313t;
    private int f1314u;
    private int f1315v;
    private long f1316w;
    private boolean f1317x;
    private boolean f1318y;
    private ArrayList f1319z;

    public HapticPlaybackThread(Context context, String str, Handler handler, boolean z, RuntimeInfo runtimeInfo) {
        super(f1282a);
        this.f1298e = 0;
        this.f1306m = new Profiler();
        this.f1307n = new Object();
        this.f1308o = new Object();
        int i = f1286b042704270427;
        switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1286b042704270427 = m1346b04270427();
                f1284b0427042704270427 = m1346b04270427();
                break;
        }
        this.f1317x = false;
        this.f1318y = false;
        this.f1295b0444044404440444 = false;
        this.f1297b04440444 = false;
        this.f1291B = false;
        this.f1293F = new rrcrrr(this);
        this.f1294G = new crcrrr(this);
        this.f1299f = str;
        this.f1301h = handler;
        this.f1296b044404440444 = context;
        this.f1291B = z;
        this.f1292C = new FileManager(context);
        this.f1290A = runtimeInfo;
        this.f1319z = new ArrayList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1326a() {
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.f1302i;
        r0 = r0.isAlive();
        if (r0 == 0) goto L_0x003d;
    L_0x0008:
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = f1286b042704270427;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = m1362b04270427();
        if (r0 == r1) goto L_0x0023;
    L_0x0019:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 65;
        f1284b0427042704270427 = r0;
    L_0x0023:
        r0 = r2.f1302i;
        r0.terminate();
        r0 = r2.f1302i;
        r0.interrupt();
        java.lang.Thread.currentThread();
    L_0x0030:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0039;
            case 1: goto L_0x0030;
            default: goto L_0x0034;
        };
    L_0x0034:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0030;
            case 1: goto L_0x0039;
            default: goto L_0x0038;
        };
    L_0x0038:
        goto L_0x0034;
    L_0x0039:
        java.lang.Thread.yield();
        goto L_0x0000;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.a():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1327a(int r9, long r10) {
        /*
        r8 = this;
        r4 = 0;
        r6 = 1;
        r0 = r8.f1318y;
        if (r0 != 0) goto L_0x0045;
    L_0x0006:
        r0 = r8.f1304k;	 Catch:{ Error -> 0x001f }
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r8.f1305l;	 Catch:{ Error -> 0x001f }
        if (r0 != 0) goto L_0x0040;
    L_0x000f:
        r0 = r8.f1304k;	 Catch:{ Error -> 0x001f }
        r0 = r0.getEncryptedHapticHeader();	 Catch:{ Error -> 0x001f }
        if (r0 != 0) goto L_0x002a;
    L_0x0017:
        r0 = "HapticPlaybackThread";
        r1 = "corrupted hapt file or unsupported format";
        com.immersion.hapticmediasdk.utils.Log.m1418e(r0, r1);	 Catch:{ Error -> 0x001f }
        goto L_0x000a;
    L_0x001f:
        r0 = move-exception;
        r1 = "HapticPlaybackThread";
        r0 = r0.getMessage();
        com.immersion.hapticmediasdk.utils.Log.m1418e(r1, r0);
        goto L_0x000a;
    L_0x002a:
        r1 = new com.immersion.content.EndpointWarp;	 Catch:{ Error -> 0x001f }
        r2 = r8.f1296b044404440444;	 Catch:{ Error -> 0x001f }
        r3 = r0.length;	 Catch:{ Error -> 0x001f }
        r1.<init>(r2, r0, r3);	 Catch:{ Error -> 0x001f }
        r8.f1305l = r1;	 Catch:{ Error -> 0x001f }
        r0 = r8.f1305l;	 Catch:{ Error -> 0x001f }
        if (r0 != 0) goto L_0x0040;
    L_0x0038:
        r0 = "HapticPlaybackThread";
        r1 = "Error creating endpointwarp";
        com.immersion.hapticmediasdk.utils.Log.m1417d(r0, r1);	 Catch:{ Error -> 0x001f }
        goto L_0x000a;
    L_0x0040:
        r0 = r8.f1305l;	 Catch:{ Error -> 0x001f }
        r0.start();	 Catch:{ Error -> 0x001f }
    L_0x0045:
        r8.f1297b04440444 = r4;
        r8.f1318y = r6;
        r8.f1315v = r4;
        r1 = r8.f1307n;
        monitor-enter(r1);
        r8.f1314u = r9;	 Catch:{ all -> 0x0069 }
        r0 = r8.f1314u;	 Catch:{ all -> 0x0069 }
        r8.f1313t = r0;	 Catch:{ all -> 0x0069 }
        r2 = r8.f1316w;	 Catch:{ all -> 0x0069 }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x0062;
    L_0x005c:
        r2 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x0069 }
        r8.f1316w = r2;	 Catch:{ all -> 0x0069 }
    L_0x0062:
        monitor-exit(r1);	 Catch:{ all -> 0x0069 }
        r8.f1312s = r10;
        r8.m1368h();
        goto L_0x000a;
    L_0x0069:
        r0 = move-exception;
    L_0x006a:
        switch(r6) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0071;
            default: goto L_0x006d;
        };
    L_0x006d:
        switch(r6) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0071;
            default: goto L_0x0070;
        };
    L_0x0070:
        goto L_0x006d;
    L_0x0071:
        monitor-exit(r1);	 Catch:{ all -> 0x0069 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.a(int, long):void");
    }

    private void m1328a(Message message) {
        this.f1317x = true;
        Message obtainMessage = this.f1301h.obtainMessage(HAPTIC_DOWNLOAD_ERROR);
        obtainMessage.setData(message.getData());
        this.f1301h.sendMessage(obtainMessage);
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = 41;
            f1285b042704270427 = m1346b04270427();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1329b() {
        /*
        r4 = this;
        r3 = 0;
        r0 = r4.f1302i;
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r4.m1326a();
        r4.f1302i = r3;
    L_0x000a:
        r1 = r4.f1308o;
        monitor-enter(r1);
        r0 = r4.f1300g;	 Catch:{ all -> 0x0049 }
        r2 = 0;
        r0.removeCallbacksAndMessages(r2);	 Catch:{ all -> 0x0049 }
        monitor-exit(r1);	 Catch:{ all -> 0x0049 }
        r0 = r4.f1303j;
        if (r0 == 0) goto L_0x001f;
    L_0x0018:
        r0 = r4.f1303j;
        r0.quit();
        r4.f1303j = r3;
    L_0x001f:
        r0 = r4.f1304k;
        if (r0 == 0) goto L_0x002a;
    L_0x0023:
        r0 = r4.f1304k;
        r0.close();
        r4.f1304k = r3;
    L_0x002a:
        r0 = r4.f1305l;
        if (r0 == 0) goto L_0x0043;
    L_0x002e:
        r0 = r4.f1305l;
        r0.stop();
        r0 = r4.f1305l;
        r0.dispose();
    L_0x0038:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0041;
            case 1: goto L_0x0038;
            default: goto L_0x003c;
        };
    L_0x003c:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0038;
            case 1: goto L_0x0041;
            default: goto L_0x0040;
        };
    L_0x0040:
        goto L_0x003c;
    L_0x0041:
        r4.f1305l = r3;
    L_0x0043:
        r0 = r4.f1292C;
        r0.deleteHapticStorage();
        return;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0049 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m1330b04110411041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2, int r3, long r4) {
        /*
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = f1286b042704270427;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = f1285b042704270427;
        if (r0 == r1) goto L_0x0019;
    L_0x000f:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 45;
        f1285b042704270427 = r0;
    L_0x0019:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0019;
            case 1: goto L_0x0022;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0022;
            case 1: goto L_0x0019;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x001d;
    L_0x0022:
        r2.m1327a(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b04110411041104110411Б(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, int, long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.immersion.content.EndpointWarp m1331b04110411041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r4) {
        /*
        r3 = 0;
        r1 = -1;
        r0 = 4;
        r2 = 0;
    L_0x0004:
        r0 = r0 / r2;
        goto L_0x0004;
    L_0x0006:
        r0 = move-exception;
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = r4.f1305l;
    L_0x000f:
        switch(r3) {
            case 0: goto L_0x0016;
            case 1: goto L_0x000f;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r3) {
            case 0: goto L_0x0016;
            case 1: goto L_0x000f;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x0012;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = move-exception;
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
    L_0x001e:
        r0 = new int[r1];	 Catch:{ Exception -> 0x0006 }
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b0411041104110411Б0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):com.immersion.content.EndpointWarp");
    }

    public static /* synthetic */ void m1332b0411041104110411(HapticPlaybackThread hapticPlaybackThread) {
        int i = f1286b042704270427;
        switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1286b042704270427 = 25;
                f1285b042704270427 = 36;
                break;
        }
        try {
            hapticPlaybackThread.m1367g();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int m1333b0411041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2, int r3) {
        /*
    L_0x0000:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0000;
            case 1: goto L_0x0009;
            default: goto L_0x0004;
        };
    L_0x0004:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0000;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0004;
    L_0x0009:
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x001f;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = 74;
        f1286b042704270427 = r0;
        r0 = m1346b04270427();
        f1285b042704270427 = r0;
    L_0x001f:
        r2.f1309p = r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b04110411Б04110411Б(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, int):int");
    }

    public static /* synthetic */ boolean m1334b0411041104110411(HapticPlaybackThread hapticPlaybackThread) {
        try {
            boolean z = hapticPlaybackThread.f1318y;
            if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
                f1286b042704270427 = m1346b04270427();
                f1285b042704270427 = m1346b04270427();
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int m1335b0411041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2) {
        /*
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
        r0 = m1346b04270427();
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = m1346b04270427();
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = f1285b042704270427;
        if (r0 == r1) goto L_0x0028;
    L_0x001c:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = m1346b04270427();
        f1285b042704270427 = r0;
    L_0x0028:
        r0 = r2.f1314u;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b04110411ББ04110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):int");
    }

    public static /* synthetic */ FileManager m1336b041104110411(HapticPlaybackThread hapticPlaybackThread) {
        while (true) {
            try {
                int[] iArr = new int[-1];
            } catch (Exception e) {
                f1286b042704270427 = 90;
                return hapticPlaybackThread.f1292C;
            }
        }
    }

    public static /* synthetic */ int m1337b0411041104110411(HapticPlaybackThread hapticPlaybackThread, int i) {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = m1346b04270427();
            f1285b042704270427 = 87;
        }
        hapticPlaybackThread.f1311r = i;
        return i;
    }

    public static /* synthetic */ ArrayList m1338b0411041104110411(HapticPlaybackThread hapticPlaybackThread) {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = m1346b04270427();
            f1285b042704270427 = 92;
        }
        try {
            return hapticPlaybackThread.f1319z;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Runnable m1339b0411041104110411(HapticPlaybackThread hapticPlaybackThread) {
        if (((m1346b04270427() + f1284b0427042704270427) * m1346b04270427()) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = m1346b04270427();
            f1285b042704270427 = m1346b04270427();
        }
        try {
            return hapticPlaybackThread.f1294G;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int m1340b041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r3, int r4) {
        /*
        r2 = 0;
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = f1286b042704270427;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = f1285b042704270427;
        if (r0 == r1) goto L_0x001a;
    L_0x0010:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 23;
        f1285b042704270427 = r0;
    L_0x001a:
        switch(r2) {
            case 0: goto L_0x0021;
            case 1: goto L_0x001a;
            default: goto L_0x001d;
        };
    L_0x001d:
        switch(r2) {
            case 0: goto L_0x0021;
            case 1: goto L_0x001a;
            default: goto L_0x0020;
        };
    L_0x0020:
        goto L_0x001d;
    L_0x0021:
        r3.f1298e = r4;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b0411Б0411ББ0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Runnable m1341b041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r3) {
        /*
        r0 = 1;
    L_0x0001:
        switch(r0) {
            case 0: goto L_0x0001;
            case 1: goto L_0x0008;
            default: goto L_0x0004;
        };
    L_0x0004:
        switch(r0) {
            case 0: goto L_0x0001;
            case 1: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0004;
    L_0x0008:
        r0 = r3.f1293F;
        r1 = f1286b042704270427;
        r2 = f1284b0427042704270427;
        r1 = r1 + r2;
        r2 = f1286b042704270427;
        r1 = r1 * r2;
        r2 = f1287b0427;
        r1 = r1 % r2;
        r2 = m1362b04270427();
        if (r1 == r2) goto L_0x0025;
    L_0x001b:
        r1 = m1346b04270427();
        f1286b042704270427 = r1;
        r1 = 18;
        f1285b042704270427 = r1;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b0411ББ04110411Б(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):java.lang.Runnable");
    }

    public static /* synthetic */ void m1342b041104110411(HapticPlaybackThread hapticPlaybackThread) {
        String str = null;
        hapticPlaybackThread.m1365e();
        while (true) {
            try {
                str.length();
            } catch (Exception e) {
                f1286b042704270427 = m1346b04270427();
                return;
            }
        }
    }

    public static /* synthetic */ int m1343b041104110411(HapticPlaybackThread hapticPlaybackThread, int i) {
        int i2 = hapticPlaybackThread.f1314u + i;
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = 55;
            f1285b042704270427 = HAPTIC_SET_BUFFERING_POSITION;
        }
        hapticPlaybackThread.f1314u = i2;
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.immersion.hapticmediasdk.controllers.IHapticFileReader m1344b04110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2, com.immersion.hapticmediasdk.controllers.IHapticFileReader r3) {
        /*
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
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = f1286b042704270427;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = f1285b042704270427;
        if (r0 == r1) goto L_0x0023;
    L_0x0017:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = m1346b04270427();
        f1285b042704270427 = r0;
    L_0x0023:
        r2.f1304k = r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.b0411ББББ0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, com.immersion.hapticmediasdk.controllers.IHapticFileReader):com.immersion.hapticmediasdk.controllers.IHapticFileReader");
    }

    public static int m1345b0427042704270427() {
        return HAPTIC_PLAYBACK_FOR_TIME_CODE;
    }

    public static int m1346b04270427() {
        return 41;
    }

    public static /* synthetic */ void m1347b0411041104110411(HapticPlaybackThread hapticPlaybackThread) {
        hapticPlaybackThread.m1364d();
        int i = f1286b042704270427;
        switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
            default:
                f1286b042704270427 = m1346b04270427();
                f1285b042704270427 = m1346b04270427();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.immersion.hapticmediasdk.utils.RuntimeInfo m1348b0411041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2) {
        /*
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x0016;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 64;
        f1285b042704270427 = r0;
    L_0x0016:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0016;
            case 1: goto L_0x001f;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0016;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x001a;
    L_0x001f:
        r0 = r2.f1290A;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.bБ041104110411Б0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):com.immersion.hapticmediasdk.utils.RuntimeInfo");
    }

    public static /* synthetic */ void m1349b041104110411(HapticPlaybackThread hapticPlaybackThread) {
        int b0427ЧЧЧ0427Ч = m1346b04270427();
        switch ((b0427ЧЧЧ0427Ч * (f1284b0427042704270427 + b0427ЧЧЧ0427Ч)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1286b042704270427 = m1346b04270427();
                f1285b042704270427 = m1346b04270427();
                break;
        }
        hapticPlaybackThread.m1366f();
    }

    public static /* synthetic */ Handler m1350b041104110411(HapticPlaybackThread hapticPlaybackThread) {
        try {
            Handler handler = hapticPlaybackThread.f1300g;
            int i = f1286b042704270427;
            switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                default:
                    f1286b042704270427 = HAPTIC_QUIT_PLAYBACK;
                    f1285b042704270427 = 62;
                    break;
            }
            return handler;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void m1351b041104110411(HapticPlaybackThread hapticPlaybackThread) {
        hapticPlaybackThread.m1368h();
        while (true) {
            try {
                int[] iArr = new int[-1];
            } catch (Exception e) {
                f1286b042704270427 = m1346b04270427();
                return;
            }
        }
    }

    public static /* synthetic */ int m1352b041104110411(HapticPlaybackThread hapticPlaybackThread, int i) {
        int[] iArr;
        while (true) {
            try {
                iArr = new int[-1];
            } catch (Exception e) {
                f1286b042704270427 = m1346b04270427();
                while (true) {
                    try {
                        iArr = new int[-1];
                    } catch (Exception e2) {
                        f1286b042704270427 = m1346b04270427();
                        try {
                            hapticPlaybackThread.f1313t = i;
                            return i;
                        } catch (Exception e3) {
                            throw e3;
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ int m1354b041104110411(HapticPlaybackThread hapticPlaybackThread, int i) {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % m1345b0427042704270427() != f1285b042704270427) {
            f1286b042704270427 = HAPTIC_DOWNLOAD_ERROR;
            f1285b042704270427 = m1346b04270427();
        }
        try {
            hapticPlaybackThread.f1310q = i;
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ long m1356b041104110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r3, long r4) {
        /*
        r0 = 1;
    L_0x0001:
        switch(r0) {
            case 0: goto L_0x0001;
            case 1: goto L_0x0008;
            default: goto L_0x0004;
        };
    L_0x0004:
        switch(r0) {
            case 0: goto L_0x0001;
            case 1: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0004;
    L_0x0008:
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r0 = r0 + r1;
        r1 = f1286b042704270427;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        r1 = f1285b042704270427;
        if (r0 == r1) goto L_0x0021;
    L_0x0017:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 90;
        f1285b042704270427 = r0;
    L_0x0021:
        r3.f1316w = r4;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.bББ0411Б04110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, long):long");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m1358b04110411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2, android.os.Message r3) {
        /*
    L_0x0000:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x0000;
            case 1: goto L_0x0009;
            default: goto L_0x0004;
        };
    L_0x0004:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0000;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0004;
    L_0x0009:
        r0 = f1286b042704270427;
        r1 = m1361b042704270427();
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x001f;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = 56;
        f1286b042704270427 = r0;
        r0 = 92;
        f1285b042704270427 = r0;
    L_0x001f:
        r2.m1328a(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.bБББ0411Б0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread, android.os.Message):void");
    }

    public static /* synthetic */ Object m1359b04110411(HapticPlaybackThread hapticPlaybackThread) {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = 18;
            f1285b042704270427 = m1346b04270427();
        }
        try {
            return hapticPlaybackThread.f1307n;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.immersion.hapticmediasdk.controllers.IHapticFileReader m1360b0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread r2) {
        /*
        r0 = f1286b042704270427;
        r1 = f1284b0427042704270427;
        r1 = r1 + r0;
        r0 = r0 * r1;
        r1 = f1287b0427;
        r0 = r0 % r1;
        switch(r0) {
            case 0: goto L_0x0016;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
        r0 = 19;
        f1285b042704270427 = r0;
    L_0x0016:
        r0 = r2.f1304k;
    L_0x0018:
        r1 = 0;
        switch(r1) {
            case 0: goto L_0x0021;
            case 1: goto L_0x0018;
            default: goto L_0x001c;
        };
    L_0x001c:
        r1 = 1;
        switch(r1) {
            case 0: goto L_0x0018;
            case 1: goto L_0x0021;
            default: goto L_0x0020;
        };
    L_0x0020:
        goto L_0x001c;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.bБББББ0411(com.immersion.hapticmediasdk.controllers.HapticPlaybackThread):com.immersion.hapticmediasdk.controllers.IHapticFileReader");
    }

    public static int m1361b042704270427() {
        return HAPTIC_SET_BUFFERING_POSITION;
    }

    public static int m1362b04270427() {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1363c() {
        /*
        r1 = this;
        r0 = 0;
        monitor-enter(r1);
    L_0x0002:
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0002;
            default: goto L_0x0005;
        };
    L_0x0005:
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x0002;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0005;
    L_0x0009:
        r1.notifyAll();	 Catch:{ all -> 0x000e }
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        return;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.c():void");
    }

    private void m1364d() {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
            f1286b042704270427 = 74;
            f1285b042704270427 = 21;
        }
        if (!this.f1317x) {
            int i = this.f1311r;
            this.f1311r = i + HAPTIC_SET_BUFFERING_POSITION;
            if (i == HAPTIC_PAUSE_PLAYBACK) {
                this.f1301h.sendMessage(this.f1301h.obtainMessage(PAUSE_AV_FOR_HAPTIC_BUFFERING, this.f1309p, 0));
                this.f1300g.postDelayed(this.f1293F, f1280D);
            } else if (this.f1304k == null || !this.f1304k.bufferAtPlaybackPosition(this.f1309p)) {
                this.f1300g.postDelayed(this.f1293F, f1280D);
            } else if (this.f1310q != f1283b) {
                this.f1301h.sendMessage(this.f1301h.obtainMessage(HAPTIC_PLAYBACK_IS_READY, this.f1309p, this.f1310q));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1365e() {
        /*
        r5 = this;
        r4 = 0;
        r0 = 0;
        r5.m1329b();	 Catch:{ Exception -> 0x0030 }
    L_0x0005:
        r0.length();	 Catch:{ Exception -> 0x0009 }
        goto L_0x0005;
    L_0x0009:
        r1 = move-exception;
        r1 = m1346b04270427();
        f1286b042704270427 = r1;
    L_0x0010:
        r0.length();	 Catch:{ Exception -> 0x0014 }
        goto L_0x0010;
    L_0x0014:
        r1 = move-exception;
        r1 = m1346b04270427();
        f1286b042704270427 = r1;
    L_0x001b:
        r0.length();	 Catch:{ Exception -> 0x001f }
        goto L_0x001b;
    L_0x001f:
        r0 = move-exception;
        r0 = 38;
        f1286b042704270427 = r0;
        r5.f1295b0444044404440444 = r4;
        r5.m1363c();
    L_0x0029:
        return;
    L_0x002a:
        r5.f1295b0444044404440444 = r4;
        r5.m1363c();
        goto L_0x0029;
    L_0x0030:
        r0 = move-exception;
        r1 = "HapticPlaybackThread";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0055 }
        r2.<init>();	 Catch:{ all -> 0x0055 }
        r3 = "quit() : ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0055 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0055 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0055 }
        r0 = r0.toString();	 Catch:{ all -> 0x0055 }
        com.immersion.hapticmediasdk.utils.Log.m1418e(r1, r0);	 Catch:{ all -> 0x0055 }
    L_0x004d:
        switch(r4) {
            case 0: goto L_0x002a;
            case 1: goto L_0x004d;
            default: goto L_0x0050;
        };
    L_0x0050:
        r0 = 1;
        switch(r0) {
            case 0: goto L_0x004d;
            case 1: goto L_0x002a;
            default: goto L_0x0054;
        };
    L_0x0054:
        goto L_0x0050;
    L_0x0055:
        r0 = move-exception;
        r5.f1295b0444044404440444 = r4;
        r5.m1363c();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.e():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1366f() {
        /*
        r8 = this;
        r6 = 0;
        r5 = 1;
        r4 = 0;
        r8.f1318y = r4;
        r0 = r8.f1305l;
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r8.f1305l;
        r0.stop();
    L_0x000f:
        switch(r4) {
            case 0: goto L_0x0016;
            case 1: goto L_0x000f;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r5) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0016;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x0012;
    L_0x0016:
        r0 = r8.f1300g;
        r1 = r8.f1293F;
        r0.removeCallbacks(r1);
        r8.removePlaybackCallbacks();
        r1 = r8.f1307n;
        monitor-enter(r1);
        r0 = 0;
        r8.f1314u = r0;	 Catch:{ all -> 0x0035 }
        r0 = 0;
        r8.f1313t = r0;	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r8.f1316w = r2;	 Catch:{ all -> 0x0035 }
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        r8.f1315v = r4;
        r8.f1312s = r6;
        r8.f1297b04440444 = r5;
        return;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.f():void");
    }

    private void m1367g() {
        this.f1318y = false;
        removePlaybackCallbacks();
        int i = f1286b042704270427;
        switch ((i * (m1361b042704270427() + i)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
            default:
                f1286b042704270427 = m1346b04270427();
                f1285b042704270427 = m1346b04270427();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1368h() {
        /*
        r13 = this;
        r12 = 0;
        r0 = r13.f1318y;
        if (r0 == 0) goto L_0x0057;
    L_0x0005:
        r1 = r13.f1307n;
        monitor-enter(r1);
        r2 = r13.f1314u;	 Catch:{ all -> 0x0058 }
        r4 = r13.f1313t;	 Catch:{ all -> 0x0058 }
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        r0 = r13.f1304k;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r6 = r0.getBufferForPlaybackPosition(r2);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r0 = r13.f1304k;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r8 = (long) r2;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r7 = r0.getHapticBlockIndex(r8);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r0 = r13.f1304k;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r8 = (long) r2;	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        r8 = r0.getBlockOffset(r8);	 Catch:{ NotEnoughHapticBytesAvailableException -> 0x005b }
        if (r6 == 0) goto L_0x006e;
    L_0x0023:
        r0 = r13.f1312s;
        r3 = r13.f1315v;
        r10 = (long) r3;
        r10 = r10 + r0;
        r0 = new rrrrrr.ccrcrr;
        r2 = (long) r2;
        r4 = (long) r4;
        r1 = r13;
        r0.<init>(r1, r2, r4, r6, r7, r8);
        r1 = r13.f1308o;
    L_0x0033:
        r2 = 1;
        switch(r2) {
            case 0: goto L_0x0033;
            case 1: goto L_0x003b;
            default: goto L_0x0037;
        };
    L_0x0037:
        switch(r12) {
            case 0: goto L_0x003b;
            case 1: goto L_0x0033;
            default: goto L_0x003a;
        };
    L_0x003a:
        goto L_0x0037;
    L_0x003b:
        monitor-enter(r1);
        r2 = r13.f1319z;	 Catch:{ all -> 0x006b }
        r2.add(r0);	 Catch:{ all -> 0x006b }
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        r1 = r13.f1300g;
        r2 = r13.f1298e;
        r2 = (long) r2;
        r2 = r2 + r10;
        r1.postAtTime(r0, r2);
        r0 = r13.f1315v;
        r1 = r13.f1298e;
        r0 = r0 + r1;
        r13.f1315v = r0;
        r0 = r13.f1306m;
        r0.startTimingII();
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0058 }
        throw r0;
    L_0x005b:
        r0 = move-exception;
        r13.f1318y = r12;
        r0 = r13.f1301h;
        r1 = r13.f1301h;
        r3 = 7;
        r1 = r1.obtainMessage(r3, r2, r12);
        r0.sendMessage(r1);
        goto L_0x0057;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r1 = r13.f1307n;
        monitor-enter(r1);
        r0 = 0;
        r13.f1314u = r0;	 Catch:{ all -> 0x0081 }
        r0 = 0;
        r13.f1313t = r0;	 Catch:{ all -> 0x0081 }
        monitor-exit(r1);	 Catch:{ all -> 0x0081 }
        r13.f1315v = r12;
        r0 = 0;
        r13.f1312s = r0;
        r13.f1318y = r12;
        goto L_0x0057;
    L_0x0081:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0081 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.h():void");
    }

    public Handler getHandler() {
        try {
            Handler handler = this.f1300g;
            if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
                f1286b042704270427 = m1346b04270427();
                f1285b042704270427 = 58;
            }
            return handler;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isStarted() {
        boolean z = this.f1295b0444044404440444;
        int i = f1286b042704270427;
        switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
            case DurationDV.DURATION_TYPE /*0*/:
                break;
            default:
                f1286b042704270427 = 69;
                f1285b042704270427 = m1346b04270427();
                break;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStopped() {
        /*
        r3 = this;
        r1 = 0;
        r0 = r3.f1297b04440444;
    L_0x0003:
        switch(r1) {
            case 0: goto L_0x000a;
            case 1: goto L_0x0003;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r1) {
            case 0: goto L_0x000a;
            case 1: goto L_0x0003;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0006;
    L_0x000a:
        r1 = f1286b042704270427;
        r2 = m1361b042704270427();
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f1287b0427;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x0022;
            default: goto L_0x0018;
        };
    L_0x0018:
        r1 = 11;
        f1286b042704270427 = r1;
        r1 = m1346b04270427();
        f1285b042704270427 = r1;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.isStopped():boolean");
    }

    public void pauseHapticPlayback() {
        if (((f1286b042704270427 + f1284b0427042704270427) * f1286b042704270427) % m1345b0427042704270427() != m1362b04270427()) {
            f1286b042704270427 = 98;
            f1285b042704270427 = 68;
        }
        this.f1300g.sendEmptyMessage(HAPTIC_PAUSE_PLAYBACK);
        while (true) {
            switch (HAPTIC_SET_BUFFERING_POSITION) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                case HAPTIC_SET_BUFFERING_POSITION /*1*/:
                    return;
                default:
                    while (true) {
                        switch (HAPTIC_SET_BUFFERING_POSITION) {
                            case DurationDV.DURATION_TYPE /*0*/:
                                break;
                            case HAPTIC_SET_BUFFERING_POSITION /*1*/:
                                return;
                            default:
                        }
                    }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void playHapticForPlaybackPosition(int r7, long r8) {
        /*
        r6 = this;
        r5 = 2;
        r0 = 0;
        r1 = 0;
        r2 = 0;
        r6.removePlaybackCallbacks();
        r3 = r6.f1300g;
        r3.removeMessages(r5);
        r3 = new android.os.Bundle;
    L_0x000e:
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x000e;
            default: goto L_0x0011;
        };
    L_0x0011:
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x000e;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0011;
    L_0x0015:
        r3.<init>();
        r4 = "playback_timecode";
        r3.putInt(r4, r7);
        r4 = "playback_uptime";
        r3.putLong(r4, r8);
        r4 = r6.f1300g;
        r4 = r4.obtainMessage(r5);
    L_0x0028:
        r2.length();	 Catch:{ Exception -> 0x002c }
        goto L_0x0028;
    L_0x002c:
        r5 = move-exception;
        r5 = 75;
        f1286b042704270427 = r5;
    L_0x0031:
        r0 = r0 / r1;
        goto L_0x0031;
    L_0x0033:
        r0 = move-exception;
        r0 = 38;
        f1286b042704270427 = r0;
        r4.setData(r3);
        r0 = r6.f1300g;
        r0.sendMessage(r4);
        return;
    L_0x0041:
        r0 = move-exception;
        r0 = m1346b04270427();
        f1286b042704270427 = r0;
    L_0x0048:
        r2.length();	 Catch:{ Exception -> 0x0033 }
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.playHapticForPlaybackPosition(int, long):void");
    }

    public void prepareHapticPlayback(int i, int i2) {
        this.f1300g.removeMessages(HAPTIC_SET_BUFFERING_POSITION);
        this.f1300g.sendMessage(this.f1300g.obtainMessage(HAPTIC_SET_BUFFERING_POSITION, i, i2));
    }

    public void quitHapticPlayback() {
        try {
            if (!this.f1300g.sendEmptyMessage(HAPTIC_QUIT_PLAYBACK)) {
                if (((f1286b042704270427 + m1361b042704270427()) * f1286b042704270427) % f1287b0427 != f1285b042704270427) {
                    f1286b042704270427 = m1346b04270427();
                    f1285b042704270427 = 16;
                }
                this.f1295b0444044404440444 = false;
                try {
                    m1363c();
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void removePlaybackCallbacks() {
        synchronized (this.f1308o) {
            Iterator it = this.f1319z.iterator();
            while (it.hasNext()) {
                this.f1300g.removeCallbacks((ccrcrr) it.next());
            }
            this.f1319z.clear();
        }
    }

    public void run() {
        String str = null;
        Process.setThreadPriority(-19);
        Looper.prepare();
        this.f1303j = Looper.myLooper();
        this.f1300g = new rccrrr();
        while (true) {
            try {
                str.length();
            } catch (Exception e) {
                f1286b042704270427 = m1346b04270427();
                this.f1302i = new HapticDownloadThread(this.f1299f, this.f1300g, this.f1291B, this.f1292C);
                this.f1302i.start();
                this.f1295b0444044404440444 = true;
                m1363c();
                Looper.loop();
                return;
            }
        }
    }

    public void stopHapticPlayback() {
        try {
            this.f1300g.sendEmptyMessage(HAPTIC_STOP_PLAYBACK);
            int i = f1286b042704270427;
            switch ((i * (f1284b0427042704270427 + i)) % f1287b0427) {
                case DurationDV.DURATION_TYPE /*0*/:
                default:
                    f1286b042704270427 = 35;
                    f1285b042704270427 = 24;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncUpdate(int r11, long r12) {
        /*
        r10 = this;
        r8 = 1;
        r1 = r10.f1307n;
        monitor-enter(r1);
        r2 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x003f }
        r4 = (long) r11;	 Catch:{ all -> 0x003f }
        r6 = r2 - r12;
        r4 = r4 + r6;
        r0 = (int) r4;	 Catch:{ all -> 0x003f }
        r4 = r10.f1314u;	 Catch:{ all -> 0x003f }
        r6 = r10.f1316w;	 Catch:{ all -> 0x003f }
        r2 = r2 - r6;
        r2 = (int) r2;	 Catch:{ all -> 0x003f }
        r2 = r2 + r4;
        r2 = r0 - r2;
        r3 = 50;
        r4 = java.lang.Math.abs(r2);	 Catch:{ all -> 0x003f }
        if (r3 >= r4) goto L_0x003d;
    L_0x001e:
        r3 = r10.f1314u;	 Catch:{ all -> 0x003f }
        r2 = r2 + r3;
        r10.f1314u = r2;	 Catch:{ all -> 0x003f }
    L_0x0023:
        r2 = 0;
        switch(r2) {
            case 0: goto L_0x002b;
            case 1: goto L_0x0023;
            default: goto L_0x0027;
        };	 Catch:{ all -> 0x003f }
    L_0x0027:
        switch(r8) {
            case 0: goto L_0x0023;
            case 1: goto L_0x002b;
            default: goto L_0x002a;
        };	 Catch:{ all -> 0x003f }
    L_0x002a:
        goto L_0x0027;
    L_0x002b:
        r2 = r10.f1314u;	 Catch:{ all -> 0x003f }
        r10.f1313t = r2;	 Catch:{ all -> 0x003f }
        r2 = r10.f1300g;	 Catch:{ all -> 0x003f }
        r3 = r10.f1300g;	 Catch:{ all -> 0x003f }
        r4 = 1;
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r0 = r3.obtainMessage(r4, r0, r5);	 Catch:{ all -> 0x003f }
        r2.sendMessage(r0);	 Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        return;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticPlaybackThread.syncUpdate(int, long):void");
    }
}
