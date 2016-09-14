package com.applovin.impl.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.os.EnvironmentCompat;
import java.io.InputStream;
import java.util.Scanner;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.q */
class C0240q {
    private static final int[] f335a;
    private static final int[] f336b;
    private static final int[] f337c;
    private static final String f338d;

    static {
        f335a = new int[]{7, 4, 2, 1, 11};
        f336b = new int[]{5, 6, 10, 3, 9, 8, 14};
        f337c = new int[]{15, 12, 13};
        f338d = C0240q.class.getSimpleName();
    }

    C0240q() {
    }

    private static NetworkInfo m267a(Context context) {
        if (C0241r.m278a("android.permission.ACCESS_NETWORK_STATE", context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        }
        return null;
    }

    static String m268a(AppLovinSdkImpl appLovinSdkImpl) {
        NetworkInfo a = C0240q.m267a(appLovinSdkImpl.getApplicationContext());
        if (a == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        int type = a.getType();
        int subtype = a.getSubtype();
        String str = type == 1 ? "wifi" : type == 0 ? C0240q.m275a(subtype, f335a) ? "2g" : C0240q.m275a(subtype, f336b) ? "3g" : C0240q.m275a(subtype, f337c) ? "4g" : "mobile" : EnvironmentCompat.MEDIA_UNKNOWN;
        appLovinSdkImpl.getLogger().m306d(f338d, "Network " + type + "/" + subtype + " resolved to " + str);
        return str;
    }

    static String m269a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Scanner scanner = new Scanner(inputStream, Defaults.Encoding);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    static String m270a(String str) {
        return str.startsWith("https://") ? str : str.replace("http://", "https://");
    }

    static String m271a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            String str2 = (String) appLovinSdkImpl.m4161a(bx.f262e);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) appLovinSdkImpl.m4161a(bx.f267j));
            stringBuilder.append(str);
            if (str2 == null || str2.length() <= 0) {
                stringBuilder.append("?api_key=");
                stringBuilder.append(appLovinSdkImpl.getSdkKey());
            } else {
                stringBuilder.append("?device_token=");
                stringBuilder.append(str2);
            }
            return stringBuilder.toString();
        }
    }

    static JSONObject m272a(JSONObject jSONObject) {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    static void m273a(int i, AppLovinSdkImpl appLovinSdkImpl) {
        ca settingsManager = appLovinSdkImpl.getSettingsManager();
        if (i == 401) {
            settingsManager.m170a(bx.f260c, XMLConstants.NULL_NS_URI);
            settingsManager.m170a(bx.f262e, XMLConstants.NULL_NS_URI);
            settingsManager.m173b();
        } else if (i == 418) {
            settingsManager.m170a(bx.f258a, Boolean.valueOf(true));
            settingsManager.m173b();
        } else if (i >= 400 && i < 500) {
            appLovinSdkImpl.m4169h();
        } else if (i == -1) {
            appLovinSdkImpl.m4169h();
        }
    }

    static void m274a(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                if (jSONObject.has("settings")) {
                    ca settingsManager = appLovinSdkImpl.getSettingsManager();
                    if (!jSONObject.isNull("settings")) {
                        settingsManager.m172a(jSONObject.getJSONObject("settings"));
                        settingsManager.m173b();
                        appLovinSdkImpl.getLogger().m306d(f338d, "New settings processed");
                    }
                }
            } catch (Throwable e) {
                appLovinSdkImpl.getLogger().m308e(f338d, "Unable to parse settings out of API response", e);
            }
        }
    }

    private static boolean m275a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static String m276b(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl != null) {
            return ((String) appLovinSdkImpl.m4161a(bx.f268k)) + str;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    static void m277b(int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (i == 418) {
            ca settingsManager = appLovinSdkImpl.getSettingsManager();
            settingsManager.m170a(bx.f258a, Boolean.valueOf(true));
            settingsManager.m173b();
        }
    }
}
