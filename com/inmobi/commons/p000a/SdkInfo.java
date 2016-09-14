package com.inmobi.commons.p000a;

import android.content.Context;
import com.inmobi.commons.core.p002b.KeyValueStore;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.a.b */
public class SdkInfo {
    public static String m1569a() {
        String str = "pr-SAND";
        String str2 = XMLConstants.NULL_NS_URI;
        char[] toCharArray = SdkInfo.m1572b().toCharArray();
        str = str2;
        for (int i = 0; i < toCharArray.length; i++) {
            if (toCharArray[i] == '.') {
                str = str + "T";
            } else {
                str = str + ((char) ((toCharArray[i] - 48) + 65));
            }
        }
        return "pr-SAND-" + str + "-" + SdkInfo.m1575e();
    }

    public static String m1572b() {
        return "5.0.1";
    }

    public static String m1573c() {
        return "2.0";
    }

    public static String m1574d() {
        return "android";
    }

    public static String m1575e() {
        return "20151019";
    }

    public static String m1576f() {
        return "http://www.inmobi.com/products/sdk/#downloads";
    }

    public static String m1570a(Context context) {
        return KeyValueStore.m1588a(context, "sdk_version_store").m1595b("sdk_version", null);
    }

    public static void m1571a(Context context, String str) {
        KeyValueStore.m1588a(context, "sdk_version_store").m1592a("sdk_version", str);
    }
}
