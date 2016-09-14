package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.PublisherProvidedUserInfo;
import com.inmobi.commons.p000a.SdkContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.w3c.dom.traversal.NodeFilter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.utilities.uid.c */
public class UidHelper {
    private static final String f1693a;
    private static final Object f1694b;
    private static UidHelper f1695c;
    private static AdvertisingIdInfo f1696d;
    private static String f1697e;

    /* renamed from: com.inmobi.commons.core.utilities.uid.c.1 */
    class UidHelper implements Runnable {
        final /* synthetic */ UidDao f1691a;
        final /* synthetic */ UidHelper f1692b;

        UidHelper(UidHelper uidHelper, UidDao uidDao) {
            this.f1692b = uidHelper;
            this.f1691a = uidDao;
        }

        public void run() {
            try {
                Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                Class cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                Object invoke = cls.getDeclaredMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{SdkContext.m1562b()});
                String str = (String) cls2.getDeclaredMethod("getId", (Class[]) null).invoke(invoke, (Object[]) null);
                UidHelper.f1696d.m1838a(str);
                this.f1691a.m1844a(str);
                Boolean bool = (Boolean) cls2.getDeclaredMethod("isLimitAdTrackingEnabled", (Class[]) null).invoke(invoke, (Object[]) null);
                UidHelper.f1696d.m1839a(bool.booleanValue());
                this.f1691a.m1845a(bool.booleanValue());
            } catch (Throwable e) {
                Logger.m1745a(InternalLogLevel.INTERNAL, UidHelper.f1693a, "Failed to fetch advertising id.", e);
            } catch (Throwable e2) {
                Logger.m1745a(InternalLogLevel.INTERNAL, UidHelper.f1693a, "Failed to fetch advertising id.", e2);
            } catch (Throwable e22) {
                Logger.m1745a(InternalLogLevel.INTERNAL, UidHelper.f1693a, "Failed to fetch advertising id.", e22);
            } catch (Throwable e222) {
                Logger.m1745a(InternalLogLevel.INTERNAL, UidHelper.f1693a, "Failed to fetch advertising id.", e222);
            }
        }
    }

    static {
        f1693a = UidHelper.class.getSimpleName();
        f1694b = new Object();
    }

    public static UidHelper m1854a() {
        UidHelper uidHelper = f1695c;
        if (uidHelper == null) {
            synchronized (f1694b) {
                uidHelper = f1695c;
                if (uidHelper == null) {
                    uidHelper = new UidHelper();
                    f1695c = uidHelper;
                }
            }
        }
        return uidHelper;
    }

    private UidHelper() {
    }

    public void m1864b() {
        m1867e();
        m1866d();
        m1858r();
        m1857q();
        m1876n();
    }

    private void m1857q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.inmobi.share.id");
        SdkContext.m1562b().registerReceiver(new ImIdShareBroadCastReceiver(), intentFilter);
    }

    public String m1865c() {
        return f1697e;
    }

    private void m1858r() {
        UidDao uidDao = new UidDao();
        String c = uidDao.m1848c();
        if (c == null) {
            c = UUID.randomUUID().toString();
            uidDao.m1846b(c);
        }
        f1697e = c;
    }

    public void m1866d() {
        m1873k();
    }

    public void m1867e() {
        if (m1874l()) {
            AdvertisingIdInfo j = m1872j();
            if (j != null) {
                String b = j.m1841b();
                if (b != null) {
                    Logger.m1744a(InternalLogLevel.DEBUG, f1693a, "Publisher device Id is " + b);
                    return;
                }
                return;
            }
            return;
        }
        Logger.m1744a(InternalLogLevel.DEBUG, f1693a, "Publisher device Id is " + m1860a(m1871i()));
    }

    String m1860a(String str) {
        String str2 = "SHA-1";
        return m1861a(str, "SHA-1");
    }

    String m1868f() {
        return SchemaSymbols.ATTVAL_TRUE_1;
    }

    String m1861a(String str, String str2) {
        if (str != null) {
            try {
                if (!XMLConstants.NULL_NS_URI.equals(str.trim())) {
                    MessageDigest instance = MessageDigest.getInstance(str2);
                    instance.update(str.getBytes());
                    byte[] digest = instance.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b : digest) {
                        stringBuffer.append(Integer.toString((b & MotionEventCompat.ACTION_MASK) + NodeFilter.SHOW_DOCUMENT, 16).substring(1));
                    }
                    return stringBuffer.toString();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        return "TEST_EMULATOR";
    }

    String m1863b(String str) {
        String str2 = "MD5";
        return m1861a(str, "MD5");
    }

    String m1869g() {
        return PublisherProvidedUserInfo.m1810b();
    }

    String m1870h() {
        return PublisherProvidedUserInfo.m1813c();
    }

    String m1871i() {
        String string = Secure.getString(SdkContext.m1562b().getContentResolver(), "android_id");
        if (string == null) {
            return System.getString(SdkContext.m1562b().getContentResolver(), "android_id");
        }
        return string;
    }

    AdvertisingIdInfo m1872j() {
        return f1696d;
    }

    void m1873k() {
        String str = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
        str = "getId";
        str = "isLimitAdTrackingEnabled";
        str = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
        str = "getAdvertisingIdInfo";
        UidDao uidDao = new UidDao();
        f1696d = new AdvertisingIdInfo();
        f1696d.m1838a(uidDao.m1842a());
        f1696d.m1839a(uidDao.m1847b());
        new Thread(new UidHelper(this, uidDao)).start();
    }

    boolean m1874l() {
        try {
            return GooglePlayServicesUtil.isGooglePlayServicesAvailable(SdkContext.m1562b()) == 0;
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean m1875m() {
        AdvertisingIdInfo j = UidHelper.m1854a().m1872j();
        if (j != null) {
            return j.m1840a();
        }
        return false;
    }

    protected void m1876n() {
        UidDao uidDao = new UidDao();
        String d = uidDao.m1850d();
        long e = uidDao.m1852e();
        if (d == null) {
            d = UUID.randomUUID().toString();
            uidDao.m1849c(d);
            uidDao.m1846b(m1865c());
            uidDao.m1851d(m1865c());
        }
        if (e == 0) {
            uidDao.m1843a(System.currentTimeMillis());
        }
        Intent intent = new Intent();
        intent.setAction("com.inmobi.share.id");
        intent.putExtra("imid", d);
        intent.putExtra("appendedid", uidDao.m1853f());
        intent.putExtra("imidts", uidDao.m1852e());
        intent.putExtra("appid", uidDao.m1848c());
        SdkContext.m1562b().sendBroadcast(intent);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1693a, "Generating and broadcasting IDs. ID:" + d + " AID:" + uidDao.m1853f());
    }

    String m1859a(Context context) {
        return new UidDao().m1850d();
    }

    String m1862b(Context context) {
        UidDao uidDao = new UidDao();
        try {
            JSONObject jSONObject = new JSONObject();
            CharSequence c = uidDao.m1848c();
            if (c != null) {
                jSONObject.put("p", c);
            }
            Object f = uidDao.m1853f();
            if (f != null && f.contains(c)) {
                f = f.replace(c, XMLConstants.NULL_NS_URI);
            }
            if (!(f == null || f.trim().length() == 0)) {
                if (f.charAt(0) == ',') {
                    f = f.substring(1);
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(f);
                jSONObject.put("s", jSONArray);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
