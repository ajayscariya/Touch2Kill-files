package com.inmobi.commons.core.utilities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.inmobi.commons.core.utilities.c */
public class NetworkConnectivityChangeObserver {
    private static final String f1643a;
    private static List<NetworkConnectivityChangeObserver> f1644b;
    private static final Object f1645c;
    private static volatile NetworkConnectivityChangeObserver f1646d;
    private static NetworkConnectivityChangeObserver f1647e;

    /* renamed from: com.inmobi.commons.core.utilities.c.a */
    public interface NetworkConnectivityChangeObserver {
        void m1774a(boolean z);
    }

    /* renamed from: com.inmobi.commons.core.utilities.c.b */
    static final class NetworkConnectivityChangeObserver extends BroadcastReceiver {
        private static final String f1642a;

        NetworkConnectivityChangeObserver() {
        }

        static {
            f1642a = NetworkConnectivityChangeObserver.class.getSimpleName();
        }

        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        z = true;
                        NetworkConnectivityChangeObserver.m1778b(z);
                        Logger.m1744a(InternalLogLevel.INTERNAL, f1642a, "Network connectivity changed. Is network available:" + z);
                    }
                }
            }
            z = false;
            NetworkConnectivityChangeObserver.m1778b(z);
            Logger.m1744a(InternalLogLevel.INTERNAL, f1642a, "Network connectivity changed. Is network available:" + z);
        }
    }

    static {
        f1643a = NetworkConnectivityChangeObserver.class.getSimpleName();
        f1644b = new ArrayList();
        f1645c = new Object();
    }

    public static NetworkConnectivityChangeObserver m1775a() {
        NetworkConnectivityChangeObserver networkConnectivityChangeObserver = f1646d;
        if (networkConnectivityChangeObserver == null) {
            synchronized (f1645c) {
                networkConnectivityChangeObserver = f1646d;
                if (networkConnectivityChangeObserver == null) {
                    networkConnectivityChangeObserver = new NetworkConnectivityChangeObserver();
                    f1646d = networkConnectivityChangeObserver;
                }
            }
        }
        return networkConnectivityChangeObserver;
    }

    public void m1779a(NetworkConnectivityChangeObserver networkConnectivityChangeObserver) {
        f1644b.add(networkConnectivityChangeObserver);
        if (f1644b.size() == 1) {
            m1777b();
        }
    }

    private static void m1778b(boolean z) {
        for (NetworkConnectivityChangeObserver a : f1644b) {
            a.m1774a(z);
        }
    }

    private void m1777b() {
        f1647e = new NetworkConnectivityChangeObserver();
        SdkContext.m1562b().registerReceiver(f1647e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
