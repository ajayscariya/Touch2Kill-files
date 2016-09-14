package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.core.utilities.uid.UidHelper;
import com.inmobi.commons.p000a.SdkInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.utilities.info.d */
public class IdentityInfo {
    private static final String f1660a;

    static {
        f1660a = IdentityInfo.class.getSimpleName();
    }

    private static String m1803b() {
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    private static String m1804c() {
        Calendar instance = Calendar.getInstance();
        return String.valueOf(instance.get(16) + instance.get(15));
    }

    public static Map<String, String> m1802a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("mk-version", SdkInfo.m1569a());
        hashMap.put("u-id-adt", String.valueOf(UidHelper.m1854a().m1875m() ? 1 : 0));
        hashMap.put("ts", IdentityInfo.m1803b());
        hashMap.put("tz", IdentityInfo.m1804c());
        hashMap.putAll(SessionInfo.m1829a().m1836c());
        return hashMap;
    }
}
