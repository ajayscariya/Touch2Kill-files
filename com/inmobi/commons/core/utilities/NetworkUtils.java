package com.inmobi.commons.core.utilities;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.p000a.SdkContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.inmobi.commons.core.utilities.d */
public class NetworkUtils {
    public static boolean m1783a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) SdkContext.m1562b().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String m1781a(Map<String, ? extends Object> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : map.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append(String.format(Locale.US, "%s=%s", new Object[]{NetworkUtils.m1780a(str2), NetworkUtils.m1780a(map.get(str2).toString())}));
        }
        return stringBuilder.toString();
    }

    public static String m1780a(String str) {
        String str2 = XMLConstants.NULL_NS_URI;
        try {
            str2 = URLEncoder.encode(str, Defaults.Encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static void m1782a(Map<String, String> map) {
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            Map hashMap = new HashMap();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.getValue() == null || ((String) entry.getValue()).trim().length() == 0 || entry.getKey() == null || ((String) entry.getKey()).trim().length() == 0) {
                    it.remove();
                } else if (((String) entry.getKey()).equals(((String) entry.getKey()).trim())) {
                    hashMap.put(entry.getKey(), ((String) entry.getValue()).trim());
                } else {
                    it.remove();
                    hashMap.put(((String) entry.getKey()).trim(), ((String) entry.getValue()).trim());
                }
            }
            map.putAll(hashMap);
        }
    }
}
