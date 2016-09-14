package com.chartboost.sdk.Libraries;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ba;
import java.util.UUID;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.c */
public final class C0266c {
    private static String f466a;
    private static String f467b;
    private static C0265a f468c;
    private static String f469d;

    /* renamed from: com.chartboost.sdk.Libraries.c.1 */
    static class C02641 implements Runnable {
        C02641() {
        }

        public void run() {
            try {
                C0266c.m414b(C0267d.m424a());
                ba.m920b();
            } catch (VerifyError e) {
                C0266c.m420h();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.c.a */
    public enum C0265a {
        PRELOAD(-1),
        LOADING(-1),
        UNKNOWN(-1),
        TRACKING_ENABLED(0),
        TRACKING_DISABLED(1);
        
        private int f465f;

        private C0265a(int i) {
            this.f465f = i;
        }

        public int m408a() {
            return this.f465f;
        }

        public boolean m409b() {
            return this.f465f != -1;
        }
    }

    static {
        f466a = null;
        f467b = null;
        f468c = C0265a.PRELOAD;
        f469d = null;
    }

    private C0266c() {
    }

    public static void m410a() {
        synchronized (C0267d.class) {
            if (C0266c.m415c() != C0265a.PRELOAD) {
                return;
            }
            C0266c.m411a(C0265a.LOADING);
            Class cls = null;
            try {
                cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            } catch (ClassNotFoundException e) {
            }
            if (cls == null) {
                C0266c.m420h();
            } else {
                ax.m845a().execute(new C02641());
            }
        }
    }

    private static void m420h() {
        CBLogging.m381b("CBIdentity", "WARNING: It looks like you've forgotten to include the Google Play Services library in your project. Please review the SDK documentation for more details.");
        C0266c.m411a(C0265a.UNKNOWN);
        ba.m920b();
    }

    public static String m413b() {
        if (f466a == null) {
            f466a = C0266c.m421i();
        }
        return f466a;
    }

    public static synchronized C0265a m415c() {
        C0265a c0265a;
        synchronized (C0266c.class) {
            c0265a = f468c;
        }
        return c0265a;
    }

    protected static synchronized void m411a(C0265a c0265a) {
        synchronized (C0266c.class) {
            f468c = c0265a;
        }
    }

    public static synchronized String m416d() {
        String str;
        synchronized (C0266c.class) {
            str = f467b;
        }
        return str;
    }

    private static synchronized void m414b(String str) {
        synchronized (C0266c.class) {
            f467b = str;
        }
    }

    private static String m421i() {
        Object e = C0266c.m417e();
        if (e == null || "9774d56d682e549c".equals(e)) {
            e = C0266c.m422j();
        }
        String f = C0266c.m418f();
        String d = C0266c.m416d();
        C0269a a = C0269a.m425a();
        a.m432a("uuid", e);
        a.m432a("macid", f);
        a.m432a("gaid", d);
        JSONObject e2 = a.m443e();
        if (e2 == null) {
            e2 = new JSONObject();
        }
        return Base64.encodeToString(e2.toString().getBytes(), 0);
    }

    public static String m417e() {
        return Secure.getString(C0299c.m682y().getContentResolver(), "android_id");
    }

    private static String m422j() {
        if (f469d == null) {
            SharedPreferences a = CBUtility.m391a();
            f469d = a.getString("cbUUID", null);
            if (f469d == null) {
                f469d = UUID.randomUUID().toString();
                Editor edit = a.edit();
                edit.putString("cbUUID", f469d);
                edit.commit();
            }
        }
        return f469d;
    }

    public static String m418f() {
        return C0263b.m407b(C0263b.m406a(C0266c.m423k()));
    }

    private static byte[] m423k() {
        try {
            String macAddress = ((WifiManager) C0299c.m682y().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress == null || macAddress.equals(XMLConstants.NULL_NS_URI)) {
                return null;
            }
            String[] split = macAddress.split(":");
            byte[] bArr = new byte[6];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Integer.valueOf(Integer.parseInt(split[i], 16)).byteValue();
            }
            return bArr;
        } catch (Exception e) {
            return null;
        }
    }
}
