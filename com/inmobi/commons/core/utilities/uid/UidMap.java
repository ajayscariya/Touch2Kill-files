package com.inmobi.commons.core.utilities.uid;

import android.util.Base64;
import com.inmobi.commons.core.utilities.p004a.UidEncryptionUtils;
import com.inmobi.commons.p000a.SdkContext;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.utilities.uid.d */
public class UidMap {
    private Map<String, Boolean> f1698a;

    public UidMap(Map<String, Boolean> map) {
        this.f1698a = map;
    }

    public HashMap<String, String> m1879a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("u-id-map", m1878c());
        return hashMap;
    }

    public Map<String, String> m1881b() {
        String num = Integer.toString(new Random().nextInt());
        String a = UidEncryptionUtils.m1763a(new JSONObject(m1880a(num, true)).toString());
        Map<String, String> hashMap = new HashMap();
        hashMap.put("u-id-map", a);
        hashMap.put("u-id-key", num);
        hashMap.put("u-key-ver", UidHelper.m1854a().m1868f());
        return hashMap;
    }

    private String m1878c() {
        return new JSONObject(m1880a(null, false)).toString();
    }

    public Map<String, String> m1880a(String str, boolean z) {
        Object a;
        Map<String, String> hashMap = new HashMap();
        if (((Boolean) this.f1698a.get("O1")).booleanValue() && !UidHelper.m1854a().m1874l()) {
            a = UidHelper.m1854a().m1860a(UidHelper.m1854a().m1871i());
            if (z) {
                a = m1877a((String) a, str);
            }
            hashMap.put("O1", a);
        }
        if (((Boolean) this.f1698a.get("UM5")).booleanValue() && !UidHelper.m1854a().m1874l()) {
            a = UidHelper.m1854a().m1863b(UidHelper.m1854a().m1871i());
            if (z) {
                a = m1877a((String) a, str);
            }
            hashMap.put("UM5", a);
        }
        if (((Boolean) this.f1698a.get("LID")).booleanValue()) {
            a = UidHelper.m1854a().m1869g();
            if (a != null && a.trim().length() > 0) {
                if (z) {
                    a = m1877a((String) a, str);
                }
                hashMap.put("LID", a);
            }
        }
        if (((Boolean) this.f1698a.get("SID")).booleanValue()) {
            a = UidHelper.m1854a().m1870h();
            if (a != null && a.trim().length() > 0) {
                if (z) {
                    a = m1877a((String) a, str);
                }
                hashMap.put("SID", a);
            }
        }
        if (((Boolean) this.f1698a.get("GPID")).booleanValue()) {
            AdvertisingIdInfo j = UidHelper.m1854a().m1872j();
            if (j != null) {
                a = j.m1841b();
                if (a != null) {
                    if (z) {
                        a = m1877a((String) a, str);
                    }
                    hashMap.put("GPID", a);
                }
            }
        }
        if (((Boolean) this.f1698a.get("IMID")).booleanValue()) {
            a = UidHelper.m1854a().m1859a(SdkContext.m1562b());
            if (a != null) {
                if (z) {
                    a = m1877a((String) a, str);
                }
                hashMap.put("IMID", a);
            }
        }
        if (((Boolean) this.f1698a.get("AIDL")).booleanValue()) {
            a = UidHelper.m1854a().m1862b(SdkContext.m1562b());
            if (a != null) {
                if (z) {
                    a = m1877a((String) a, str);
                }
                hashMap.put("AIDL", a);
            }
        }
        return hashMap;
    }

    private String m1877a(String str, String str2) {
        String str3 = XMLConstants.NULL_NS_URI;
        try {
            byte[] bytes = str.getBytes(Defaults.Encoding);
            byte[] bArr = new byte[bytes.length];
            byte[] bytes2 = str2.getBytes(Defaults.Encoding);
            for (int i = 0; i < bytes.length; i++) {
                bArr[i] = (byte) (bytes[i] ^ bytes2[i % bytes2.length]);
            }
            return new String(Base64.encode(bArr, 2), Defaults.Encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str3;
        }
    }
}
