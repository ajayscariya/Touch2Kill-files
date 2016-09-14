package com.chartboost.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.CBLogging;
import java.util.Observable;

public class ay extends Observable {
    private static ay f845c;
    private static C0346b f846d;
    private boolean f847a;
    private boolean f848b;
    private C0345a f849e;

    /* renamed from: com.chartboost.sdk.impl.ay.a */
    private class C0345a extends BroadcastReceiver {
        final /* synthetic */ ay f838a;

        public C0345a(ay ayVar) {
            this.f838a = ayVar;
        }

        public void onReceive(Context context, Intent intent) {
            ay a = ay.m847a();
            a.m849a(context);
            a.notifyObservers();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ay.b */
    public enum C0346b {
        CONNECTION_UNKNOWN(-1),
        CONNECTION_ERROR(0),
        CONNECTION_WIFI(1),
        CONNECTION_MOBILE(2);
        
        private int f844e;

        private C0346b(int i) {
            this.f844e = i;
        }

        public int m846a() {
            return this.f844e;
        }
    }

    static {
        f845c = null;
        f846d = C0346b.CONNECTION_UNKNOWN;
    }

    private ay() {
        this.f847a = true;
        this.f848b = false;
        this.f849e = null;
        this.f849e = new C0345a(this);
    }

    public static ay m847a() {
        if (f845c == null) {
            f845c = new ay();
        }
        return f845c;
    }

    public int m851b() {
        return f846d.m846a();
    }

    public void m849a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                m850a(false);
                f846d = C0346b.CONNECTION_ERROR;
                CBLogging.m379a("CBReachability", "NETWORK TYPE: NO Network");
                return;
            }
            m850a(true);
            if (activeNetworkInfo.getType() == 1) {
                f846d = C0346b.CONNECTION_WIFI;
                CBLogging.m379a("CBReachability", "NETWORK TYPE: TYPE_WIFI");
            } else if (activeNetworkInfo.getType() == 0) {
                f846d = C0346b.CONNECTION_MOBILE;
                CBLogging.m379a("CBReachability", "NETWORK TYPE: TYPE_MOBILE");
            }
        } catch (SecurityException e) {
            f846d = C0346b.CONNECTION_UNKNOWN;
            CBLogging.m381b("CBReachability", "Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
        }
    }

    public void notifyObservers() {
        if (this.f847a) {
            setChanged();
            super.notifyObservers(this);
        }
    }

    public void m850a(boolean z) {
        this.f847a = z;
    }

    public boolean m855c() {
        return this.f847a;
    }

    public Intent m852b(Context context) {
        if (context == null || this.f848b) {
            return null;
        }
        m853b(true);
        CBLogging.m379a("CBReachability", "Network broadcast successfully registered");
        return context.registerReceiver(this.f849e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void m854c(Context context) {
        if (context != null && this.f848b) {
            context.unregisterReceiver(this.f849e);
            m853b(false);
            CBLogging.m379a("CBReachability", "Network broadcast successfully unregistered");
        }
    }

    public void m853b(boolean z) {
        this.f848b = z;
    }

    public static Integer m848d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C0299c.m682y().getSystemService("connectivity")).getActiveNetworkInfo();
            Object obj = (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? null : 1;
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) C0299c.m682y().getSystemService("phone");
                if (telephonyManager != null) {
                    return Integer.valueOf(telephonyManager.getNetworkType());
                }
            }
        } catch (SecurityException e) {
            CBLogging.m381b("CBReachability", "Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
        }
        return null;
    }
}
