package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;
import mf.javax.xml.XMLConstants;

/* renamed from: com.applovin.impl.sdk.a */
class C0230a {
    private static final Object f128a;
    private static final Map f129b;

    static {
        f128a = new Object();
        f129b = new HashMap();
    }

    static Map m52a(AppLovinSdkImpl appLovinSdkImpl) {
        Map c;
        synchronized (f128a) {
            appLovinSdkImpl.getLogger().m306d("AdDataCache", "Reading cached device data...");
            c = C0230a.m57c(appLovinSdkImpl);
        }
        return c;
    }

    private static void m53a(String str, Map map) {
        String[] split = str.split("=");
        if (split.length == 2) {
            map.put(split[0], split[1]);
        }
    }

    static void m54a(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        C0230a.m56b(map, appLovinSdkImpl);
    }

    static void m55b(AppLovinSdkImpl appLovinSdkImpl) {
        synchronized (f128a) {
            appLovinSdkImpl.getLogger().m306d("AdDataCache", "Clearing old device data cache...");
            C0230a.m54a(new HashMap(0), appLovinSdkImpl);
        }
    }

    private static void m56b(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        if (map == null) {
            throw new IllegalArgumentException("No ad aata specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                synchronized (f129b) {
                    Map map2 = (Map) f129b.get("ad_data_cache");
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    map2.clear();
                    map2.putAll(map);
                    f129b.put("ad_data_cache", map2);
                }
                Editor edit = appLovinSdkImpl.getSettingsManager().m168a().edit();
                edit.putString("ad_data_cache", di.m4287a(map));
                edit.commit();
                appLovinSdkImpl.getLogger().m306d("AdDataCache", map.size() + " " + "ad_data_cache" + " entries saved in cache");
            } catch (Throwable e) {
                appLovinSdkImpl.getLogger().m308e("AdDataCache", "Unable to save ad data entries", e);
            }
        }
    }

    private static Map m57c(AppLovinSdkImpl appLovinSdkImpl) {
        Map map;
        Map hashMap;
        Throwable e;
        synchronized (f129b) {
            map = (Map) f129b.get("ad_data_cache");
        }
        if (map == null) {
            SharedPreferences a = appLovinSdkImpl.getSettingsManager().m168a();
            String string = a.getString("ad_data_cache", XMLConstants.NULL_NS_URI);
            if (string != null && string.length() > 0) {
                try {
                    hashMap = new HashMap();
                    try {
                        for (String a2 : string.split("&")) {
                            C0230a.m53a(a2, hashMap);
                        }
                        synchronized (f129b) {
                            f129b.put("ad_data_cache", hashMap);
                        }
                        appLovinSdkImpl.getLogger().m306d("AdDataCache", hashMap.size() + " " + "ad_data_cache" + " entries loaded from cache");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    hashMap = map;
                    e = th;
                    appLovinSdkImpl.getLogger().m308e("AdDataCache", "Unable to load ad data", e);
                    Editor edit = a.edit();
                    edit.putString("ad_data_cache", XMLConstants.NULL_NS_URI);
                    edit.commit();
                    return hashMap != null ? new HashMap(hashMap) : new HashMap();
                }
                if (hashMap != null) {
                }
            }
        }
        hashMap = map;
        if (hashMap != null) {
        }
    }
}
