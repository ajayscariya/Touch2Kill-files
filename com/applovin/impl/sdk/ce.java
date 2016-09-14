package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import mf.org.apache.xerces.impl.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

class ce extends bw {
    ce(AppLovinSdkImpl appLovinSdkImpl) {
        super("SubmitData", appLovinSdkImpl);
    }

    private static JSONArray m4200a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (C0244u c0244u : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", c0244u.f349c);
            jSONObject.put("created_at_sec", c0244u.f350d / 1000);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    void m4201a(JSONObject jSONObject) {
        try {
            JSONObject a = C0240q.m272a(jSONObject);
            ca settingsManager = this.f.getSettingsManager();
            settingsManager.m170a(bx.f260c, a.getString("device_id"));
            settingsManager.m170a(bx.f262e, a.getString("device_token"));
            settingsManager.m170a(bx.f261d, a.getString("publisher_id"));
            settingsManager.m173b();
            C0240q.m274a(a, this.f);
            if (a.has("adserver_parameters")) {
                settingsManager.m170a(bx.f276s, a.getJSONObject("adserver_parameters").toString());
            }
        } catch (Throwable e) {
            this.g.m308e(this.e, "Unable to parse API response", e);
        }
    }

    void m4202b(JSONObject jSONObject) {
        C0241r dataCollector = this.f.getDataCollector();
        C0244u b = dataCollector.m281b();
        C0245v a = dataCollector.m279a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", a.f351a);
        jSONObject2.put("os", a.f352b);
        jSONObject2.put("brand", a.f353c);
        jSONObject2.put("sdk_version", a.f355e);
        jSONObject2.put("revision", a.f354d);
        jSONObject2.put("country_code", a.f356f);
        jSONObject2.put("carrier", a.f357g);
        jSONObject2.put("wvvc", a.f359i);
        jSONObject2.put("type", "android");
        C0243t c = dataCollector.m282c();
        String str = c.f346b;
        boolean z = c.f345a;
        if ((!z || ((Boolean) this.f.getSettingsManager().m169a(bx.aT)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            jSONObject2.put("idfa", str);
        }
        jSONObject2.put("dnt", z);
        Locale locale = a.f358h;
        if (locale != null) {
            jSONObject2.put(Constants.LOCALE_PROPERTY, locale.toString());
        }
        jSONObject.put("device_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", b.f349c);
        jSONObject3.put("app_name", b.f347a);
        jSONObject3.put("app_version", b.f348b);
        jSONObject3.put("installed_at", b.f350d);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("ic", this.f.isInitializedInMainActivity());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.h);
        String string = defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", null);
        if (AppLovinSdkUtils.isValidString(string)) {
            jSONObject3.put("first_install", string);
            if (string.equalsIgnoreCase(Boolean.toString(true))) {
                defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(false)).apply();
            }
        }
        String str2 = (String) this.f.m4161a(bx.f283z);
        if (str2 != null && str2.length() > 0) {
            jSONObject3.put("plugin_version", str2);
        }
        jSONObject.put("app_info", jSONObject3);
        if (((Boolean) this.f.m4161a(bx.f237F)).booleanValue()) {
            Map a2 = ((C1179m) this.f.getTargetingData()).m4305a();
            if (!(a2 == null || a2.isEmpty())) {
                jSONObject.put("targeting", ay.m100a(a2));
            }
            jSONObject.put("stats", this.f.m4163b().m219b());
        }
    }

    Collection m4203c() {
        return ((Boolean) this.f.m4161a(bx.aS)).booleanValue() ? this.f.getDataCollector().m283d() : null;
    }

    void m4204c(JSONObject jSONObject) {
        cy cfVar = new cf(this, "Repeat" + this.e, bx.f263f, this.f, jSONObject);
        cfVar.m4269a(bx.f267j);
        cfVar.run();
    }

    public void run() {
        try {
            this.g.m309i(this.e, "Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m4202b(jSONObject);
            if (((Boolean) this.f.m4161a(bx.aS)).booleanValue()) {
                Collection c = m4203c();
                if (c != null) {
                    jSONObject.put("vx", m4200a(c));
                }
            }
            m4204c(jSONObject);
        } catch (Throwable e) {
            this.g.m308e(this.e, "Unable to build JSON message with collected data", e);
        }
    }
}
