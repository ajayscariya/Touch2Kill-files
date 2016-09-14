package com.inmobi.signals.p007b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import java.util.List;

/* renamed from: com.inmobi.signals.b.c */
public class WifiScanner {
    private static final String f2086a;
    private static Context f2087b;
    private static WifiScanner f2088c;
    private static Handler f2089d;
    private static boolean f2090e;
    private static final IntentFilter f2091f;
    private static List<WifiInfo> f2092g;
    private static Runnable f2093h;
    private static final BroadcastReceiver f2094i;

    /* renamed from: com.inmobi.signals.b.c.1 */
    static class WifiScanner implements Runnable {
        WifiScanner() {
        }

        public void run() {
            WifiScanner b = WifiScanner.f2088c;
            WifiScanner.m2226f();
            if (b != null) {
                b.m2216a();
            }
        }
    }

    /* renamed from: com.inmobi.signals.b.c.2 */
    static class WifiScanner extends BroadcastReceiver {
        WifiScanner() {
        }

        public void onReceive(Context context, Intent intent) {
            WifiScanner b = WifiScanner.f2088c;
            WifiManager wifiManager = (WifiManager) WifiScanner.f2087b.getSystemService("wifi");
            WifiScanner.m2226f();
            if (b != null) {
                WifiScanner.f2092g = WifiInfoUtil.m2207a(wifiManager.getScanResults());
                b.m2217a(WifiScanner.f2092g);
            }
        }
    }

    /* renamed from: com.inmobi.signals.b.c.a */
    public interface WifiScanner {
        void m2216a();

        void m2217a(List<WifiInfo> list);
    }

    static {
        f2086a = WifiScanner.class.getSimpleName();
        f2087b = null;
        f2088c = null;
        f2089d = null;
        f2090e = false;
        f2091f = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        f2093h = new WifiScanner();
        f2094i = new WifiScanner();
    }

    public static boolean m2221a(WifiScanner wifiScanner) {
        f2087b = SdkContext.m1562b();
        return WifiScanner.m2220a(Looper.myLooper(), wifiScanner, 10000, false);
    }

    public static List<WifiInfo> m2218a() {
        return f2092g;
    }

    private static synchronized boolean m2220a(Looper looper, WifiScanner wifiScanner, long j, boolean z) {
        boolean z2;
        synchronized (WifiScanner.class) {
            if (f2089d != null) {
                z2 = false;
            } else {
                WifiManager wifiManager = (WifiManager) SdkContext.m1562b().getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    f2088c = wifiScanner;
                    f2089d = new Handler(looper);
                    f2089d.postDelayed(f2093h, j);
                    WifiScanner.m2228h();
                    z2 = wifiManager.startScan();
                } else {
                    z2 = false;
                }
            }
        }
        return z2;
    }

    private static synchronized void m2226f() {
        synchronized (WifiScanner.class) {
            if (f2089d != null) {
                f2089d.removeCallbacks(f2093h);
                WifiScanner.m2227g();
                f2089d = null;
                f2088c = null;
                f2087b = null;
            }
        }
    }

    private static void m2227g() {
        if (f2090e) {
            f2090e = false;
            try {
                f2087b.unregisterReceiver(f2094i);
            } catch (IllegalArgumentException e) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2086a, "Failed to register for Wifi scanning.");
            }
        }
    }

    private static void m2228h() {
        if (!f2090e) {
            f2090e = true;
            f2087b.registerReceiver(f2094i, f2091f, null, f2089d);
        }
    }
}
