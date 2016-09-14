package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.C0350b.C0349a;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.chartboost.sdk.impl.y */
public class C0432y {
    public static C0349a m1155a(C0412i c0412i) {
        long a;
        long j;
        long a2;
        Object obj = null;
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = c0412i.f1102c;
        String str = (String) map.get("Date");
        if (str != null) {
            a = C0432y.m1154a(str);
        } else {
            a = 0;
        }
        str = (String) map.get("Cache-Control");
        if (str != null) {
            String[] split = str.split(",");
            long j3 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j3 = 0;
                }
            }
            j = j3;
            obj = 1;
        } else {
            j = 0;
        }
        str = (String) map.get("Expires");
        if (str != null) {
            a2 = C0432y.m1154a(str);
        } else {
            a2 = 0;
        }
        str = (String) map.get("ETag");
        if (obj != null) {
            j2 = (1000 * j) + currentTimeMillis;
        } else if (a > 0 && a2 >= a) {
            j2 = (a2 - a) + currentTimeMillis;
        }
        C0349a c0349a = new C0349a();
        c0349a.f891a = c0412i.f1101b;
        c0349a.f892b = str;
        c0349a.f895e = j2;
        c0349a.f894d = c0349a.f895e;
        c0349a.f893c = a;
        c0349a.f896f = map;
        return c0349a;
    }

    public static long m1154a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }
}
