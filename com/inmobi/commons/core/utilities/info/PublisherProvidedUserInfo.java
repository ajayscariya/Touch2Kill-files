package com.inmobi.commons.core.utilities.info;

import android.location.Location;
import android.support.v4.widget.ExploreByTouchHelper;
import java.util.HashMap;
import java.util.Locale;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.core.utilities.info.e */
public final class PublisherProvidedUserInfo {
    private static int f1661a;
    private static String f1662b;
    private static String f1663c;
    private static String f1664d;
    private static String f1665e;
    private static String f1666f;
    private static String f1667g;
    private static int f1668h;
    private static String f1669i;
    private static String f1670j;
    private static String f1671k;
    private static String f1672l;
    private static int f1673m;
    private static String f1674n;
    private static String f1675o;
    private static String f1676p;
    private static String f1677q;
    private static String f1678r;
    private static Location f1679s;

    static {
        f1661a = ExploreByTouchHelper.INVALID_ID;
        f1668h = ExploreByTouchHelper.INVALID_ID;
        f1673m = ExploreByTouchHelper.INVALID_ID;
    }

    public static void m1807a(int i) {
        f1661a = i;
    }

    public static void m1809a(String str) {
        f1662b = str;
    }

    public static void m1812b(String str) {
        f1663c = str;
    }

    public static void m1815c(String str) {
        f1664d = str;
    }

    public static void m1817d(String str) {
        f1665e = str;
    }

    public static void m1818e(String str) {
        f1666f = str;
    }

    public static void m1819f(String str) {
        f1667g = str;
    }

    public static void m1811b(int i) {
        f1668h = i;
    }

    public static void m1820g(String str) {
        f1669i = str;
    }

    public static void m1821h(String str) {
        f1670j = str;
    }

    public static void m1822i(String str) {
        f1671k = str;
    }

    public static void m1823j(String str) {
        f1672l = str;
    }

    public static void m1814c(int i) {
        f1673m = i;
    }

    public static void m1824k(String str) {
        f1674n = str;
    }

    public static void m1825l(String str) {
        f1675o = str;
    }

    public static void m1826m(String str) {
        f1676p = str;
    }

    public static HashMap<String, String> m1806a() {
        HashMap<String, String> hashMap = new HashMap();
        if (f1661a != ExploreByTouchHelper.INVALID_ID && f1661a > 0) {
            hashMap.put("u-age", String.valueOf(f1661a));
        }
        if (f1668h != ExploreByTouchHelper.INVALID_ID && f1668h > 0) {
            hashMap.put("u-yearofbirth", String.valueOf(f1668h));
        }
        if (f1673m != ExploreByTouchHelper.INVALID_ID && f1673m > 0) {
            hashMap.put("u-income", String.valueOf(f1673m));
        }
        String a = PublisherProvidedUserInfo.m1805a(f1665e, f1666f, f1667g);
        if (!(a == null || a.trim().length() == 0)) {
            hashMap.put("u-location", a);
        }
        if (f1662b != null) {
            hashMap.put("u-agegroup", f1662b.toString().toLowerCase(Locale.ENGLISH));
        }
        if (f1663c != null) {
            hashMap.put("u-areacode", f1663c);
        }
        if (f1664d != null) {
            hashMap.put("u-postalcode", f1664d);
        }
        if (f1669i != null) {
            hashMap.put("u-gender", f1669i);
        }
        if (f1670j != null) {
            hashMap.put("u-ethnicity", f1670j);
        }
        if (f1671k != null) {
            hashMap.put("u-education", f1671k);
        }
        if (f1672l != null) {
            hashMap.put("u-language", f1672l);
        }
        if (f1674n != null) {
            hashMap.put("u-householdincome", f1674n);
        }
        if (f1675o != null) {
            hashMap.put("u-interests", f1675o);
        }
        if (f1676p != null) {
            hashMap.put("u-nationality", f1676p);
        }
        return hashMap;
    }

    private static String m1805a(String str, String str2, String str3) {
        String str4 = XMLConstants.NULL_NS_URI;
        if (!(str == null || str.trim().length() == 0)) {
            str4 = str.trim();
        }
        if (!(str2 == null || str2.trim().length() == 0)) {
            str4 = str4 + "-" + str2.trim();
        }
        if (str3 == null || str3.trim().length() == 0) {
            return str4;
        }
        return str4 + "-" + str3.trim();
    }

    public static String m1810b() {
        return f1677q;
    }

    public static void m1827n(String str) {
        f1677q = str;
    }

    public static String m1813c() {
        return f1678r;
    }

    public static void m1828o(String str) {
        f1678r = str;
    }

    public static Location m1816d() {
        return f1679s;
    }

    public static void m1808a(Location location) {
        f1679s = location;
    }
}
