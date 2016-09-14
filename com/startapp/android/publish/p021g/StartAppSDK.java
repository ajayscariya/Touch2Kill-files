package com.startapp.android.publish.p021g;

import android.content.Context;
import com.startapp.android.publish.gson.Gson;
import com.startapp.android.publish.model.BaseRequest;
import com.startapp.android.publish.model.BaseResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mf.org.apache.xerces.xinclude.XIncludeHandler;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.startapp.android.publish.g.c */
public class StartAppSDK {
    public static <T extends BaseResponse> T m3140a(Context context, String str, BaseRequest baseRequest, Map<String, String> map, Class<T> cls) {
        return StartAppSDK.m3141a(context, str, baseRequest, (Map) map, (Class) cls, new Gson());
    }

    public static <T extends BaseResponse> T m3141a(Context context, String str, BaseRequest baseRequest, Map<String, String> map, Class<T> cls, Gson gson) {
        StringBuilder stringBuilder = new StringBuilder();
        StartAppSDK.m3144a(context, str, baseRequest, map, stringBuilder, 3, 0);
        try {
            return (BaseResponse) gson.fromJson(stringBuilder.toString(), (Class) cls);
        } catch (Throwable e) {
            throw new com.startapp.android.publish.p022h.StartAppSDK("Failed parsing the JSON response to " + cls.getName(), e);
        }
    }

    public static String m3142a(Context context, String str, BaseRequest baseRequest, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        StartAppSDK.m3144a(context, str, baseRequest, map, stringBuilder, 3, 0);
        return stringBuilder.toString();
    }

    public static boolean m3146a(Context context, String str, Map<String, String> map) {
        StartAppSDK.m3144a(context, str, null, map, null, 3, 0);
        return true;
    }

    public static boolean m3145a(Context context, String str, BaseRequest baseRequest, Map<String, String> map, int i, long j) {
        StartAppSDK.m3144a(context, str, baseRequest, map, null, i, j);
        return true;
    }

    private static void m3144a(Context context, String str, BaseRequest baseRequest, Map<String, String> map, StringBuilder stringBuilder, int i, long j) {
        if (baseRequest != null) {
            str = str + baseRequest.getRequestString();
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Transport", 3, "Sending get to URL: " + str);
        Map a = StartAppSDK.m3143a(context, map);
        Object obj = null;
        int i2 = 1;
        while (obj == null) {
            try {
                com.startapp.android.publish.p022h.StartAppSDK.m3244a(context, str, a, stringBuilder);
                obj = 1;
            } catch (com.startapp.android.publish.p022h.StartAppSDK e) {
                if (!e.m3252a() || i2 >= i) {
                    throw e;
                }
                i2++;
                if (j > 0) {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e2) {
                    }
                }
            }
        }
    }

    private static Map<String, String> m3143a(Context context, Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        Object a = com.startapp.android.publish.p022h.StartAppSDK.m3156a(context).m3150a();
        try {
            a = URLEncoder.encode(a, Defaults.Encoding);
        } catch (UnsupportedEncodingException e) {
        }
        map.put("device-id", a);
        map.put(XIncludeHandler.HTTP_ACCEPT_LANGUAGE, Locale.getDefault().toString());
        return map;
    }
}
