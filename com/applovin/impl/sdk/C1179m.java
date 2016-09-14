package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.applovin.impl.sdk.m */
class C1179m implements AppLovinTargetingData {
    private final Context f3966a;

    C1179m(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f3966a = appLovinSdkImpl.getApplicationContext();
    }

    private static String m4303a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return XMLConstants.NULL_NS_URI;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            if (AppLovinSdkUtils.isValidString(str)) {
                stringBuilder.append(di.m4293c(str));
                stringBuilder.append(",");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private void m4304a(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str)) {
            Editor edit = this.f3966a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
            edit.putString(str, di.m4293c(str2));
            edit.commit();
        }
    }

    Map m4305a() {
        Map hashMap = new HashMap();
        Map all = this.f3966a.getSharedPreferences("applovin.sdk.targeting", 0).getAll();
        if (all != null && all.size() > 0) {
            for (Entry entry : all.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }

    public void clearData() {
        Editor edit = this.f3966a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
        edit.clear();
        edit.commit();
    }

    public void putExtra(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str) && AppLovinSdkUtils.isValidString(str2)) {
            m4304a("ex_" + str, str2);
        }
    }

    public void setBirthYear(int i) {
        if (i < 9999 && i > 1900) {
            m4304a("yob", Integer.toString(i));
        }
    }

    public void setCarrier(String str) {
        if (AppLovinSdkUtils.isValidString(str)) {
            m4304a("carrier", str);
        }
    }

    public void setCountry(String str) {
        if (AppLovinSdkUtils.isValidString(str) && str.length() == 2) {
            m4304a("country", str.toUpperCase(Locale.ENGLISH));
        }
    }

    public void setGender(char c) {
        String str = c == AppLovinTargetingData.GENDER_MALE ? "m" : c == AppLovinTargetingData.GENDER_FEMALE ? "f" : "u";
        m4304a("gender", str);
    }

    public void setInterests(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m4304a("interests", C1179m.m4303a(strArr));
        }
    }

    public void setKeywords(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m4304a("keywords", C1179m.m4303a(strArr));
        }
    }

    public void setLanguage(String str) {
        if (AppLovinSdkUtils.isValidString(str)) {
            m4304a(SchemaSymbols.ATTVAL_LANGUAGE, str.toLowerCase(Locale.ENGLISH));
        }
    }

    public void setLocation(Location location) {
        if (location != null) {
            m4304a("lat", Double.toString(location.getLatitude()));
            m4304a("lon", Double.toString(location.getLongitude()));
        }
    }
}
