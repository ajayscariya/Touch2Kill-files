package com.inmobi.ads;

import android.graphics.Color;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.b */
public final class AdConfig extends Config {
    private static final String f4373a;
    private static final String f4374b;
    private String f4375c;
    private int f4376d;
    private int f4377e;
    private int f4378f;
    private AdConfig f4379g;
    private Map<String, AdConfig> f4380h;
    private AdConfig f4381i;
    private AdConfig f4382j;
    private AdConfig f4383k;
    private AdConfig f4384l;
    private JSONObject f4385m;

    /* renamed from: com.inmobi.ads.b.a */
    static final class AdConfig {
        private int f1424a;
        private int f1425b;
        private int f1426c;
        private long f1427d;

        AdConfig() {
        }

        public boolean m1444a() {
            if (this.f1425b <= 0 || this.f1424a < 0 || this.f1426c < 0 || this.f1427d < 0) {
                return false;
            }
            return true;
        }

        public int m1445b() {
            return this.f1424a;
        }

        public int m1446c() {
            return this.f1425b;
        }

        public int m1447d() {
            return this.f1426c;
        }

        public long m1448e() {
            return this.f1427d;
        }
    }

    /* renamed from: com.inmobi.ads.b.b */
    public static final class AdConfig {
        private int f1428a;
        private int f1429b;
        private int f1430c;
        private int f1431d;
        private int f1432e;

        public AdConfig() {
            this.f1428a = 3;
            this.f1429b = 60;
            this.f1430c = 120;
            this.f1431d = 500;
            this.f1432e = 10;
        }

        public int m1454a() {
            return this.f1428a;
        }

        public int m1455b() {
            return this.f1429b;
        }

        public int m1456c() {
            return this.f1430c;
        }

        public int m1457d() {
            return this.f1431d;
        }

        public int m1458e() {
            return this.f1432e;
        }
    }

    /* renamed from: com.inmobi.ads.b.c */
    public static final class AdConfig {
        private long f1433a;
        private int f1434b;
        private int f1435c;
        private String f1436d;

        public AdConfig() {
            this.f1433a = 432000;
            this.f1434b = 3;
            this.f1435c = 60;
            this.f1436d = "https://inmobisdk-a.akamaihd.net/sdk/500/android/mraid.js";
        }

        public long m1463a() {
            return this.f1433a;
        }

        public int m1464b() {
            return this.f1434b;
        }

        public int m1465c() {
            return this.f1435c;
        }

        public String m1466d() {
            return this.f1436d;
        }
    }

    /* renamed from: com.inmobi.ads.b.d */
    public static final class AdConfig {
        private int f1437a;
        private int f1438b;
        private int f1439c;
        private int f1440d;
        private String f1441e;
        private int f1442f;
        private int f1443g;
        private int f1444h;
        private long f1445i;
        private ArrayList<String> f1446j;

        public AdConfig() {
            this.f1437a = 60;
            this.f1438b = 320;
            this.f1439c = 480;
            this.f1440d = 100;
            this.f1441e = "#00000000";
            this.f1442f = Color.parseColor("#00000000");
            this.f1443g = 5;
            this.f1444h = 20;
            this.f1445i = 5242880;
            this.f1446j = new ArrayList(Arrays.asList(new String[]{"video/mp4"}));
        }

        public int m1478a() {
            return this.f1438b;
        }

        public int m1479b() {
            return this.f1439c;
        }

        public int m1480c() {
            return this.f1440d;
        }

        public int m1481d() {
            return this.f1442f;
        }

        public int m1482e() {
            return this.f1443g;
        }

        public int m1483f() {
            return this.f1444h;
        }

        public long m1484g() {
            return this.f1445i;
        }

        public ArrayList<String> m1485h() {
            return this.f1446j;
        }

        public int m1486i() {
            return this.f1437a;
        }
    }

    /* renamed from: com.inmobi.ads.b.e */
    public static final class AdConfig {
        private int f1447a;
        private int f1448b;
        private int f1449c;
        private int f1450d;

        public AdConfig() {
            this.f1447a = 50;
            this.f1448b = 1000;
            this.f1449c = 100;
            this.f1450d = 250;
        }

        public int m1491a() {
            return this.f1447a;
        }

        public int m1492b() {
            return this.f1448b;
        }

        public int m1493c() {
            return this.f1449c;
        }

        public int m1494d() {
            return this.f1450d;
        }
    }

    static {
        f4373a = AdConfig.class.getSimpleName();
        f4374b = "production".equals("staging") ? "http://i.w.inmobi.com/showad.asm" : "http://i.w.inmobi.com/showad.asm";
    }

    private JSONObject m5021o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("maxCacheSize", 0);
        jSONObject2.put("fetchLimit", 1);
        jSONObject2.put("minThreshold", 0);
        jSONObject2.put("timeToLive", 0);
        jSONObject.put("base", jSONObject2);
        jSONObject2 = new JSONObject();
        jSONObject2.put("maxCacheSize", 100);
        jSONObject2.put("fetchLimit", 5);
        jSONObject2.put("minThreshold", 2);
        jSONObject2.put("timeToLive", 3300);
        jSONObject.put("native", jSONObject2);
        return jSONObject;
    }

    private JSONObject m5022p() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", false);
        jSONObject.put("samplingFactor", 0);
        jSONObject.put("metricEnabled", false);
        return jSONObject;
    }

    public AdConfig() {
        this.f4375c = f4374b;
        this.f4376d = 20;
        this.f4377e = 60;
        this.f4378f = 60;
        this.f4381i = new AdConfig();
        this.f4382j = new AdConfig();
        this.f4383k = new AdConfig();
        this.f4384l = new AdConfig();
        try {
            m5020b(m5021o());
            this.f4385m = m5022p();
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4373a, "Default config provided for ads is invalid.", e);
        }
    }

    public String m5025a() {
        return "ads";
    }

    public void m5026a(JSONObject jSONObject) throws JSONException {
        super.m1650a(jSONObject);
        if (jSONObject.has(DatabaseOpenHelper.HISTORY_ROW_URL)) {
            this.f4375c = jSONObject.getString(DatabaseOpenHelper.HISTORY_ROW_URL);
        }
        this.f4376d = jSONObject.getInt("minimumRefreshInterval");
        this.f4377e = jSONObject.getInt("defaultRefreshInterval");
        this.f4378f = jSONObject.getInt("fetchTimeout");
        m5020b(jSONObject.getJSONObject("cache"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("imai");
        this.f4381i.f1428a = jSONObject2.getInt("maxRetries");
        this.f4381i.f1429b = jSONObject2.getInt("pingInterval");
        this.f4381i.f1430c = jSONObject2.getInt("pingTimeout");
        this.f4381i.f1431d = jSONObject2.getInt("maxDbEvents");
        this.f4381i.f1432e = jSONObject2.getInt("maxEventBatch");
        jSONObject2 = jSONObject.getJSONObject("rendering");
        this.f4382j.f1437a = jSONObject2.getInt("renderTimeout");
        this.f4382j.f1439c = jSONObject2.getInt("picHeight");
        this.f4382j.f1438b = jSONObject2.getInt("picWidth");
        this.f4382j.f1440d = jSONObject2.getInt("picQuality");
        this.f4382j.f1441e = jSONObject2.getString("webviewBackground");
        this.f4382j.f1443g = jSONObject2.getInt("maxVibrationDuration");
        this.f4382j.f1444h = jSONObject2.getInt("maxVibrationPatternLength");
        this.f4382j.f1445i = (long) jSONObject2.getJSONObject("savecontent").getInt("maxSaveSize");
        JSONArray jSONArray = jSONObject2.getJSONObject("savecontent").getJSONArray("allowedContentType");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f4382j.f1446j.add(jSONArray.getString(i));
        }
        jSONObject2 = jSONObject.getJSONObject("mraid");
        this.f4383k.f1433a = jSONObject2.getLong("expiry");
        this.f4383k.f1434b = jSONObject2.getInt("maxRetries");
        this.f4383k.f1435c = jSONObject2.getInt("retryInterval");
        this.f4383k.f1436d = jSONObject2.getString(DatabaseOpenHelper.HISTORY_ROW_URL);
        if (jSONObject.has("telemetry")) {
            this.f4385m = jSONObject.getJSONObject("telemetry");
        }
        jSONObject2 = jSONObject.getJSONObject("viewability");
        this.f4384l.f1447a = jSONObject2.getInt("impressionMinPercentageViewed");
        this.f4384l.f1448b = jSONObject2.getInt("impressionMinTimeViewed");
        this.f4384l.f1449c = jSONObject2.optInt("visibilityThrottleMillis", 100);
        this.f4384l.f1450d = jSONObject2.optInt("impressionPollIntervalMillis", 250);
    }

    private void m5020b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("base");
        this.f4379g = new AdConfig();
        this.f4379g.f1424a = jSONObject2.getInt("maxCacheSize");
        this.f4379g.f1425b = jSONObject2.getInt("fetchLimit");
        this.f4379g.f1426c = jSONObject2.getInt("minThreshold");
        this.f4379g.f1427d = jSONObject2.getLong("timeToLive");
        jSONObject.remove("base");
        this.f4380h = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(str);
            AdConfig adConfig = new AdConfig();
            adConfig.f1424a = jSONObject3.has("maxCacheSize") ? jSONObject3.getInt("maxCacheSize") : this.f4379g.f1424a;
            adConfig.f1425b = jSONObject3.has("fetchLimit") ? jSONObject3.getInt("fetchLimit") : this.f4379g.f1425b;
            adConfig.f1426c = jSONObject3.has("minThreshold") ? jSONObject3.getInt("minThreshold") : this.f4379g.f1426c;
            adConfig.f1427d = jSONObject3.has("timeToLive") ? (long) jSONObject3.getInt("timeToLive") : this.f4379g.f1427d;
            this.f4380h.put(str, adConfig);
        }
    }

    public JSONObject m5027b() throws JSONException {
        JSONObject b = super.m1651b();
        b.put(DatabaseOpenHelper.HISTORY_ROW_URL, this.f4375c);
        b.put("minimumRefreshInterval", this.f4376d);
        b.put("defaultRefreshInterval", this.f4377e);
        b.put("fetchTimeout", this.f4378f);
        b.put("cache", m5023q());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("maxRetries", this.f4381i.m1454a());
        jSONObject.put("pingInterval", this.f4381i.m1455b());
        jSONObject.put("pingTimeout", this.f4381i.m1456c());
        jSONObject.put("maxDbEvents", this.f4381i.m1457d());
        jSONObject.put("maxEventBatch", this.f4381i.m1458e());
        b.put("imai", jSONObject);
        jSONObject = new JSONObject();
        jSONObject.put("renderTimeout", this.f4382j.m1486i());
        jSONObject.put("picWidth", this.f4382j.m1478a());
        jSONObject.put("picHeight", this.f4382j.m1479b());
        jSONObject.put("picQuality", this.f4382j.m1480c());
        jSONObject.put("webviewBackground", this.f4382j.f1441e);
        jSONObject.put("maxVibrationDuration", this.f4382j.m1482e());
        jSONObject.put("maxVibrationPatternLength", this.f4382j.m1483f());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("maxSaveSize", this.f4382j.m1484g());
        jSONObject2.put("allowedContentType", new JSONArray(this.f4382j.m1485h()));
        jSONObject.put("savecontent", jSONObject2);
        b.put("rendering", jSONObject);
        jSONObject = new JSONObject();
        jSONObject.put("expiry", this.f4383k.m1463a());
        jSONObject.put("maxRetries", this.f4383k.m1464b());
        jSONObject.put("retryInterval", this.f4383k.m1465c());
        jSONObject.put(DatabaseOpenHelper.HISTORY_ROW_URL, this.f4383k.m1466d());
        b.put("mraid", jSONObject);
        jSONObject = new JSONObject();
        jSONObject.put("impressionMinPercentageViewed", this.f4384l.m1491a());
        jSONObject.put("impressionMinTimeViewed", this.f4384l.m1492b());
        jSONObject.put("visibilityThrottleMillis", this.f4384l.m1493c());
        jSONObject.put("impressionPollIntervalMillis", this.f4384l.m1494d());
        b.put("viewability", jSONObject);
        if (this.f4385m != null) {
            b.put("telemetry", this.f4385m);
        }
        return b;
    }

    private JSONObject m5023q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("maxCacheSize", this.f4379g.m1445b());
        jSONObject2.put("fetchLimit", this.f4379g.m1446c());
        jSONObject2.put("minThreshold", this.f4379g.m1447d());
        jSONObject2.put("timeToLive", this.f4379g.m1448e());
        jSONObject.put("base", jSONObject2);
        for (Entry entry : this.f4380h.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            AdConfig adConfig = (AdConfig) entry.getValue();
            jSONObject3.put("maxCacheSize", adConfig.m1445b());
            jSONObject3.put("fetchLimit", adConfig.m1446c());
            jSONObject3.put("minThreshold", adConfig.m1447d());
            jSONObject3.put("timeToLive", adConfig.m1448e());
            jSONObject.put((String) entry.getKey(), jSONObject3);
        }
        return jSONObject;
    }

    public boolean m5028c() {
        if ((!this.f4375c.startsWith("http://") && !this.f4375c.startsWith("https://")) || this.f4376d < 0 || this.f4377e < 0 || this.f4378f <= 0) {
            return false;
        }
        if (this.f4379g == null || !this.f4379g.m1444a()) {
            return false;
        }
        for (Entry value : this.f4380h.entrySet()) {
            if (!((AdConfig) value.getValue()).m1444a()) {
                return false;
            }
        }
        if (this.f4381i.m1457d() < 0 || this.f4381i.m1458e() < 0 || this.f4381i.m1454a() < 0 || this.f4381i.m1455b() < 0 || this.f4381i.m1456c() <= 0) {
            return false;
        }
        if (this.f4383k.m1463a() < 0 || this.f4383k.m1465c() < 0 || this.f4383k.m1464b() < 0 || (!this.f4383k.m1466d().startsWith("http://") && !this.f4383k.m1466d().startsWith("https://"))) {
            return false;
        }
        if (this.f4382j.m1486i() < 0 || this.f4382j.m1479b() < 0 || this.f4382j.m1478a() < 0 || this.f4382j.m1480c() < 0 || this.f4382j.m1482e() < 0 || this.f4382j.m1483f() < 0 || this.f4382j.m1484g() < 0 || this.f4382j.f1441e == null || this.f4382j.f1441e.trim().length() == 0) {
            return false;
        }
        try {
            this.f4382j.f1442f = Color.parseColor(this.f4382j.f1441e);
            if (this.f4383k.m1464b() < 0 || this.f4383k.m1465c() < 0 || this.f4383k.m1466d() == null || this.f4383k.m1466d().trim().length() == 0) {
                return false;
            }
            if (this.f4384l.m1491a() <= 0 || this.f4384l.m1491a() > 100 || this.f4384l.m1492b() < 0 || this.f4384l.m1493c() < 50 || this.f4384l.m1493c() * 5 > this.f4384l.m1492b() || this.f4384l.m1494d() < 50 || this.f4384l.m1494d() * 4 > this.f4384l.m1492b()) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4373a, "Webview color specified in config is invalid.", e);
            return false;
        }
    }

    public Config m5029d() {
        return new AdConfig();
    }

    public String m5030e() {
        return this.f4375c;
    }

    public int m5031f() {
        return this.f4376d;
    }

    public int m5032g() {
        return this.f4377e;
    }

    public int m5033h() {
        return this.f4378f;
    }

    public AdConfig m5024a(String str) {
        AdConfig adConfig = (AdConfig) this.f4380h.get(str);
        if (adConfig == null) {
            return this.f4379g;
        }
        return adConfig;
    }

    public AdConfig m5034i() {
        return this.f4381i;
    }

    public AdConfig m5035j() {
        return this.f4382j;
    }

    public AdConfig m5036k() {
        return this.f4383k;
    }

    public AdConfig m5037l() {
        return this.f4384l;
    }

    public JSONObject m5038m() {
        return this.f4385m;
    }
}
