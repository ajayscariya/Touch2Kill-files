package com.immersion.hapticmediasdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;
import com.wTouch2KiLL.MainNavigationActivity;

public abstract class HapticContentSDK {
    public static final int INACCESSIBLE_URL = -2;
    public static final int INVALID = -1;
    public static final int MALFORMED_URL = -4;
    public static final int PERMISSION_DENIED = -3;
    public static final int SDKMODE_MEDIAPLAYBACK = 0;
    public static final int SUCCESS = 0;
    public static final int UNSUPPORTED_PROTOCOL = -5;
    private static final String f1227a = "HapticContentSDK";
    public static final int f1228b04440444044404440444 = 10000;
    public static int f1229b044604460446 = 25;
    public static int f1230b04460446 = 1;
    public static final int f1231b0444044404440444 = 1500;
    public static int f1232b04460446 = 2;
    public static int f1233b0446;
    private HandlerThread f1234b;
    private Handler f1235c;
    private Context f1236d;
    private RuntimeInfo f1237e;
    public boolean mDisposed;
    public MediaTaskManager mMediaTaskManager;
    public SDKStatus mSDKStatus;

    public enum SDKStatus {
        NOT_INITIALIZED,
        INITIALIZED,
        PLAYING,
        STOPPED,
        STOPPED_DUE_TO_ERROR,
        PAUSED,
        PAUSED_DUE_TO_TIMEOUT;
        
        public static int f1223b04170417 = 0;
        public static int f1224b0417 = 2;
        public static int f1225b044A044A044A044A044A = 6;
        public static int f1226b044A044A044A044A044A = 1;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static {
            /*
            r7 = 4;
            r6 = 3;
            r5 = 2;
            r4 = 1;
            r3 = 0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "NOT_INITIALIZED";
            r0.<init>(r1, r3);
            NOT_INITIALIZED = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "INITIALIZED";
            r0.<init>(r1, r4);
            INITIALIZED = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "PLAYING";
            r0.<init>(r1, r5);
            PLAYING = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "STOPPED";
            r0.<init>(r1, r6);
            STOPPED = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "STOPPED_DUE_TO_ERROR";
            r0.<init>(r1, r7);
            STOPPED_DUE_TO_ERROR = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "PAUSED";
            r2 = 5;
            r0.<init>(r1, r2);
            PAUSED = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "PAUSED_DUE_TO_TIMEOUT";
            r2 = 6;
            r0.<init>(r1, r2);
            PAUSED_DUE_TO_TIMEOUT = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = "PAUSED_DUE_TO_BUFFERING";
            r2 = 7;
            r0.<init>(r1, r2);
        L_0x004e:
            switch(r4) {
                case 0: goto L_0x004e;
                case 1: goto L_0x0055;
                default: goto L_0x0051;
            };
        L_0x0051:
            switch(r3) {
                case 0: goto L_0x0055;
                case 1: goto L_0x004e;
                default: goto L_0x0054;
            };
        L_0x0054:
            goto L_0x0051;
        L_0x0055:
            PAUSED_DUE_TO_BUFFERING = r0;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK$SDKStatus;
            r1 = m1297b0417();
            r2 = f1226b044A044A044A044A044A;
            r1 = r1 + r2;
            r2 = m1297b0417();
            r1 = r1 * r2;
            r2 = f1224b0417;
            r1 = r1 % r2;
            r2 = f1223b04170417;
            if (r1 == r2) goto L_0x0078;
        L_0x006c:
            r1 = m1297b0417();
            f1225b044A044A044A044A044A = r1;
            r1 = m1297b0417();
            f1223b04170417 = r1;
        L_0x0078:
            r1 = "DISPOSED";
            r2 = 8;
            r0.<init>(r1, r2);
            DISPOSED = r0;
            r0 = 9;
            r0 = new com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus[r0];
            r1 = NOT_INITIALIZED;
            r0[r3] = r1;
            r1 = INITIALIZED;
            r0[r4] = r1;
            r1 = PLAYING;
            r0[r5] = r1;
            r1 = STOPPED;
            r0[r6] = r1;
            r1 = STOPPED_DUE_TO_ERROR;
            r0[r7] = r1;
            r1 = 5;
            r2 = PAUSED;
            r0[r1] = r2;
            r1 = 6;
            r2 = PAUSED_DUE_TO_TIMEOUT;
            r0[r1] = r2;
            r1 = 7;
            r2 = PAUSED_DUE_TO_BUFFERING;
            r0[r1] = r2;
            r1 = 8;
            r2 = DISPOSED;
            r0[r1] = r2;
            f1222a = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.<clinit>():void");
        }

        public static int m1296b04170417() {
            return 2;
        }

        public static int m1297b0417() {
            return 37;
        }

        public static int m1298b0417() {
            return 1;
        }

        public static SDKStatus valueOfCaseInsensitive(String str) {
            try {
                SDKStatus[] values = values();
                int length = values.length;
                for (int i = HapticContentSDK.SUCCESS; i < length; i++) {
                    if (((f1225b044A044A044A044A044A + f1226b044A044A044A044A044A) * f1225b044A044A044A044A044A) % m1296b04170417() != f1223b04170417) {
                        f1225b044A044A044A044A044A = 55;
                        f1223b04170417 = m1297b0417();
                    }
                    SDKStatus sDKStatus = values[i];
                    if (str.equalsIgnoreCase(sDKStatus.name())) {
                        return sDKStatus;
                    }
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public HapticContentSDK(int i, Context context) {
        this.mSDKStatus = SDKStatus.NOT_INITIALIZED;
        this.mDisposed = false;
        this.f1236d = context;
        if (((f1229b044604460446 + f1230b04460446) * f1229b044604460446) % f1232b04460446 != f1233b0446) {
            f1229b044604460446 = 24;
            f1233b0446 = m1299b044604460446();
        }
        this.f1237e = new RuntimeInfo();
    }

    public static int m1299b044604460446() {
        return 96;
    }

    public static int m1300b04460446() {
        return 2;
    }

    public int m1301b0411041104110411() {
        try {
            if (this.f1236d.getPackageManager().checkPermission("android.permission.VIBRATE", this.f1236d.getPackageName()) == 0) {
                this.f1234b = new HandlerThread("SDK Monitor");
                this.f1234b.start();
                try {
                    this.f1235c = new Handler(this.f1234b.getLooper());
                    Handler handler = this.f1235c;
                    int i = f1229b044604460446;
                    switch ((i * (f1230b04460446 + i)) % f1232b04460446) {
                        case SUCCESS /*0*/:
                            break;
                        default:
                            f1229b044604460446 = m1299b044604460446();
                            f1233b0446 = 93;
                            break;
                    }
                    this.mMediaTaskManager = new MediaTaskManager(handler, this.f1236d, this.f1237e);
                    return SUCCESS;
                } catch (Exception e) {
                    throw e;
                }
            }
            Log.m1418e(f1227a, "Failed to create a Haptic Content SDK instance.Vibrate permission denied.");
            return PERMISSION_DENIED;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void dispose() {
        if (getSDKStatus() != SDKStatus.DISPOSED) {
            this.mMediaTaskManager.transitToState(SDKStatus.NOT_INITIALIZED);
            this.f1234b.quit();
            this.f1234b = null;
            this.mMediaTaskManager = null;
            this.mDisposed = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finalize() throws java.lang.Throwable {
        /*
        r2 = this;
        r2.dispose();	 Catch:{ Throwable -> 0x000c }
        super.finalize();
        return;
    L_0x0007:
        r0 = move-exception;
        super.finalize();
        throw r0;
    L_0x000c:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0007 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.HapticContentSDK.finalize():void");
    }

    public final SDKStatus getSDKStatus() {
        return this.mDisposed ? SDKStatus.DISPOSED : this.mMediaTaskManager.getSDKStatus();
    }

    public final String getVersion() {
        while (true) {
            try {
                int[] iArr = new int[INVALID];
            } catch (Exception e) {
                f1229b044604460446 = 88;
                return HapticMediaSDKVersion.Version;
            }
        }
    }

    public final int mute() {
        int i = f1229b044604460446;
        switch ((i * (f1230b04460446 + i)) % f1232b04460446) {
            case SUCCESS /*0*/:
                break;
            default:
                f1229b044604460446 = 16;
                f1233b0446 = m1299b044604460446();
                break;
        }
        try {
            if (getSDKStatus() == SDKStatus.DISPOSED) {
                return INVALID;
            }
            try {
                this.f1237e.mute();
                return SUCCESS;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public abstract int openHaptics(String str);

    public final int pause() {
        String str = null;
        try {
            SDKStatus sDKStatus = getSDKStatus();
            if (sDKStatus != SDKStatus.DISPOSED) {
                if (sDKStatus == SDKStatus.STOPPED_DUE_TO_ERROR) {
                    while (true) {
                        try {
                            str.length();
                        } catch (Exception e) {
                            f1229b044604460446 = 21;
                        }
                    }
                } else {
                    try {
                        return this.mMediaTaskManager.transitToState(SDKStatus.PAUSED);
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            return INVALID;
        } catch (Exception e22) {
            throw e22;
        }
    }

    public final int play() {
        try {
            SDKStatus sDKStatus = getSDKStatus();
            if (sDKStatus != SDKStatus.INITIALIZED && sDKStatus != SDKStatus.STOPPED) {
                return INVALID;
            }
            this.mMediaTaskManager.setMediaTimestamp(0);
            MediaTaskManager mediaTaskManager = this.mMediaTaskManager;
            SDKStatus sDKStatus2 = SDKStatus.PLAYING;
            if (((m1299b044604460446() + f1230b04460446) * m1299b044604460446()) % m1300b04460446() != f1233b0446) {
                f1229b044604460446 = m1299b044604460446();
                f1233b0446 = m1299b044604460446();
            }
            try {
                return mediaTaskManager.transitToState(sDKStatus2);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int resume() {
        SDKStatus sDKStatus = getSDKStatus();
        if (!(sDKStatus == SDKStatus.PAUSED || sDKStatus == SDKStatus.PLAYING)) {
            if (sDKStatus != SDKStatus.STOPPED) {
                return INVALID;
            }
            while (true) {
                try {
                    int[] iArr = new int[INVALID];
                } catch (Exception e) {
                    f1229b044604460446 = 99;
                }
            }
        }
        this.mMediaTaskManager.setMediaReferenceTime();
        return this.mMediaTaskManager.transitToState(SDKStatus.PLAYING);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int seek(int r5) {
        /*
        r4 = this;
        r3 = 1;
        r0 = r4.getSDKStatus();
        r1 = f1229b044604460446;
        r2 = f1230b04460446;
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f1232b04460446;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x001b;
            default: goto L_0x0011;
        };
    L_0x0011:
        r1 = 56;
        f1229b044604460446 = r1;
        r1 = m1299b044604460446();
        f1233b0446 = r1;
    L_0x001b:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.DISPOSED;
    L_0x001d:
        switch(r3) {
            case 0: goto L_0x001d;
            case 1: goto L_0x0024;
            default: goto L_0x0020;
        };
    L_0x0020:
        switch(r3) {
            case 0: goto L_0x001d;
            case 1: goto L_0x0024;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0020;
    L_0x0024:
        if (r0 == r1) goto L_0x002e;
    L_0x0026:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.NOT_INITIALIZED;
        if (r0 == r1) goto L_0x002e;
    L_0x002a:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR;
        if (r0 != r1) goto L_0x0030;
    L_0x002e:
        r0 = -1;
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = r4.mMediaTaskManager;
        r0 = r0.SeekTo(r5);
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.HapticContentSDK.seek(int):int");
    }

    public final int stop() {
        SDKStatus sDKStatus = getSDKStatus();
        if (sDKStatus == SDKStatus.DISPOSED || sDKStatus == SDKStatus.NOT_INITIALIZED) {
            return INVALID;
        }
        int transitToState = this.mMediaTaskManager.transitToState(SDKStatus.STOPPED);
        while (true) {
            switch (1) {
                case SUCCESS /*0*/:
                    break;
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    return transitToState;
                default:
                    while (true) {
                        switch (1) {
                            case SUCCESS /*0*/:
                                break;
                            case MainNavigationActivity.REQUEST_CODE /*1*/:
                                return transitToState;
                            default:
                        }
                    }
            }
        }
    }

    public final int unmute() {
        try {
            if (getSDKStatus() == SDKStatus.DISPOSED) {
                return INVALID;
            }
            this.f1237e.unmute();
            return SUCCESS;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int update(long r6) {
        /*
        r5 = this;
        r3 = 1;
        r0 = r5.getSDKStatus();
        r1 = f1229b044604460446;
        r2 = f1230b04460446;
        r2 = r2 + r1;
        r1 = r1 * r2;
        r2 = f1232b04460446;
        r1 = r1 % r2;
        switch(r1) {
            case 0: goto L_0x001b;
            default: goto L_0x0011;
        };
    L_0x0011:
        r1 = m1299b044604460446();
        f1229b044604460446 = r1;
        r1 = 98;
        f1233b0446 = r1;
    L_0x001b:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.PLAYING;
        if (r0 == r1) goto L_0x0023;
    L_0x001f:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.PAUSED_DUE_TO_TIMEOUT;
        if (r0 != r1) goto L_0x003a;
    L_0x0023:
        r0 = r5.mMediaTaskManager;
        r0.setMediaTimestamp(r6);
        r0 = r5.mMediaTaskManager;
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.PLAYING;
        r0 = r0.transitToState(r1);
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = r5.mMediaTaskManager;
        r0.setMediaTimestamp(r6);
        r0 = 0;
        goto L_0x0030;
    L_0x0038:
        r0 = -1;
        goto L_0x0030;
    L_0x003a:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.PAUSED;
        if (r0 == r1) goto L_0x0042;
    L_0x003e:
        r1 = com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus.PAUSED_DUE_TO_BUFFERING;
        if (r0 != r1) goto L_0x0038;
    L_0x0042:
        switch(r3) {
            case 0: goto L_0x0042;
            case 1: goto L_0x0031;
            default: goto L_0x0045;
        };
    L_0x0045:
        switch(r3) {
            case 0: goto L_0x0042;
            case 1: goto L_0x0031;
            default: goto L_0x0048;
        };
    L_0x0048:
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.HapticContentSDK.update(long):int");
    }
}
