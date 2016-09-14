package com.inmobi.signals;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.q */
class SignalsConfig extends Config {
    private static final String f4503a;
    private SignalsConfig f4504b;
    private SignalsConfig f4505c;
    private JSONObject f4506d;

    /* renamed from: com.inmobi.signals.q.a */
    public static class SignalsConfig {
        private boolean f2139a;
        private String f2140b;
        private String f2141c;
        private int f2142d;
        private int f2143e;
        private int f2144f;
        private int f2145g;
        private long f2146h;

        public SignalsConfig() {
            this.f2139a = false;
            this.f2140b = "http://dock.inmobi.com/carb/v1/i";
            this.f2141c = "http://dock.inmobi.com/carb/v1/o";
            this.f2142d = 86400;
            this.f2143e = 3;
            this.f2144f = 60;
            this.f2145g = 60;
            this.f2146h = 307200;
        }

        public boolean m2319a() {
            return this.f2139a;
        }

        public String m2320b() {
            return this.f2140b;
        }

        public String m2321c() {
            return this.f2141c;
        }

        public int m2322d() {
            return this.f2142d;
        }

        public int m2323e() {
            return this.f2143e;
        }

        public int m2324f() {
            return this.f2144f;
        }

        public int m2325g() {
            return this.f2145g;
        }

        public long m2326h() {
            return this.f2146h;
        }
    }

    /* renamed from: com.inmobi.signals.q.b */
    public static class SignalsConfig {
        private boolean f2147a;
        private int f2148b;
        private int f2149c;
        private int f2150d;
        private String f2151e;
        private int f2152f;
        private int f2153g;
        private boolean f2154h;
        private boolean f2155i;
        private int f2156j;
        private boolean f2157k;
        private boolean f2158l;
        private int f2159m;
        private boolean f2160n;
        private boolean f2161o;
        private boolean f2162p;
        private boolean f2163q;
        private int f2164r;
        private int f2165s;

        public SignalsConfig() {
            this.f2147a = false;
            this.f2148b = 300;
            this.f2149c = 3;
            this.f2150d = 50;
            this.f2151e = "https://sdkm.w.inmobi.com/user/e.asm";
            this.f2152f = 3;
            this.f2153g = 60;
            this.f2154h = false;
            this.f2155i = false;
            this.f2156j = 0;
            this.f2157k = false;
            this.f2158l = false;
            this.f2159m = 0;
            this.f2160n = false;
            this.f2161o = false;
            this.f2162p = false;
            this.f2163q = false;
            this.f2164r = 180;
            this.f2165s = 50;
        }

        public boolean m2365a() {
            return this.f2147a;
        }

        public int m2366b() {
            return this.f2148b;
        }

        public int m2367c() {
            return this.f2149c;
        }

        public int m2368d() {
            return this.f2150d;
        }

        public String m2369e() {
            return this.f2151e;
        }

        public int m2370f() {
            return this.f2152f;
        }

        public int m2371g() {
            return this.f2153g;
        }

        public boolean m2372h() {
            return this.f2154h && this.f2147a;
        }

        public boolean m2373i() {
            return this.f2155i && this.f2147a;
        }

        public int m2374j() {
            return this.f2156j;
        }

        public boolean m2375k() {
            return this.f2157k && this.f2147a;
        }

        public boolean m2376l() {
            return this.f2158l && this.f2147a;
        }

        public int m2377m() {
            return this.f2159m;
        }

        public boolean m2378n() {
            return this.f2160n && this.f2147a;
        }

        public boolean m2379o() {
            return this.f2161o && this.f2147a;
        }

        public boolean m2380p() {
            return this.f2162p && this.f2147a;
        }

        public boolean m2381q() {
            return this.f2163q && this.f2147a;
        }

        public int m2382r() {
            return this.f2164r;
        }

        public int m2383s() {
            return this.f2165s;
        }
    }

    static {
        f4503a = Config.class.getSimpleName();
    }

    private JSONObject m5212h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", false);
        jSONObject.put("samplingFactor", 0);
        jSONObject.put("metricEnabled", false);
        return jSONObject;
    }

    public SignalsConfig() {
        this.f4504b = new SignalsConfig();
        this.f4505c = new SignalsConfig();
        try {
            this.f4506d = m5212h();
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4503a, "Default telemetry config provided for ads is invalid.", e);
        }
    }

    public String m5213a() {
        return "signals";
    }

    public void m5214a(JSONObject jSONObject) throws JSONException {
        super.m1650a(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("ice");
        this.f4504b.f2148b = jSONObject2.getInt("sampleInterval");
        this.f4504b.f2150d = jSONObject2.getInt("sampleHistorySize");
        this.f4504b.f2149c = jSONObject2.getInt("stopRequestTimeout");
        this.f4504b.f2147a = jSONObject2.getBoolean("enabled");
        this.f4504b.f2151e = jSONObject2.getString("endPoint");
        this.f4504b.f2152f = jSONObject2.getInt("maxRetries");
        this.f4504b.f2153g = jSONObject2.getInt("retryInterval");
        this.f4504b.f2154h = jSONObject2.getBoolean("locationEnabled");
        this.f4504b.f2155i = jSONObject2.getBoolean("sessionEnabled");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("w");
        this.f4504b.f2156j = jSONObject3.getInt("wf");
        this.f4504b.f2158l = jSONObject3.getBoolean("cwe");
        this.f4504b.f2157k = jSONObject3.getBoolean("vwe");
        jSONObject3 = jSONObject2.getJSONObject("c");
        this.f4504b.f2160n = jSONObject3.getBoolean("oe");
        this.f4504b.f2162p = jSONObject3.getBoolean("cce");
        this.f4504b.f2161o = jSONObject3.getBoolean("vce");
        this.f4504b.f2159m = jSONObject3.getInt("cof");
        jSONObject2 = jSONObject2.getJSONObject("ar");
        this.f4504b.f2163q = jSONObject2.getBoolean("e");
        this.f4504b.f2164r = jSONObject2.getInt("sampleInterval");
        this.f4504b.f2165s = jSONObject2.getInt("maxHistorySize");
        jSONObject2 = jSONObject.getJSONObject("carb");
        this.f4505c.f2139a = jSONObject2.getBoolean("enabled");
        this.f4505c.f2140b = jSONObject2.getString("getEndPoint");
        this.f4505c.f2141c = jSONObject2.getString("postEndPoint");
        this.f4505c.f2142d = jSONObject2.getInt("retrieveFrequency");
        this.f4505c.f2143e = jSONObject2.getInt("maxRetries");
        this.f4505c.f2144f = jSONObject2.getInt("retryInterval");
        this.f4505c.f2145g = jSONObject2.getInt("timeoutInterval");
        this.f4505c.f2146h = jSONObject2.getLong("maxGetResponseSize");
        this.f4506d = jSONObject.optJSONObject("telemetry");
    }

    public JSONObject m5215b() throws JSONException {
        JSONObject b = super.m1651b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sampleInterval", this.f4504b.f2148b);
        jSONObject.put("stopRequestTimeout", this.f4504b.f2149c);
        jSONObject.put("sampleHistorySize", this.f4504b.f2150d);
        jSONObject.put("enabled", this.f4504b.f2147a);
        jSONObject.put("endPoint", this.f4504b.f2151e);
        jSONObject.put("maxRetries", this.f4504b.f2152f);
        jSONObject.put("retryInterval", this.f4504b.f2153g);
        jSONObject.put("locationEnabled", this.f4504b.f2154h);
        jSONObject.put("sessionEnabled", this.f4504b.f2155i);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("wf", this.f4504b.f2156j);
        jSONObject2.put("vwe", this.f4504b.f2157k);
        jSONObject2.put("cwe", this.f4504b.f2158l);
        jSONObject.put("w", jSONObject2);
        jSONObject2 = new JSONObject();
        jSONObject2.put("cof", this.f4504b.f2159m);
        jSONObject2.put("vce", this.f4504b.f2161o);
        jSONObject2.put("cce", this.f4504b.f2162p);
        jSONObject2.put("oe", this.f4504b.f2160n);
        jSONObject.put("c", jSONObject2);
        jSONObject2 = new JSONObject();
        jSONObject2.put("e", this.f4504b.f2163q);
        jSONObject2.put("sampleInterval", this.f4504b.f2164r);
        jSONObject2.put("maxHistorySize", this.f4504b.f2165s);
        jSONObject.put("ar", jSONObject2);
        b.put("ice", jSONObject);
        jSONObject = new JSONObject();
        jSONObject.put("enabled", this.f4505c.f2139a);
        jSONObject.put("getEndPoint", this.f4505c.f2140b);
        jSONObject.put("postEndPoint", this.f4505c.f2141c);
        jSONObject.put("retrieveFrequency", this.f4505c.f2142d);
        jSONObject.put("maxRetries", this.f4505c.f2143e);
        jSONObject.put("retryInterval", this.f4505c.f2144f);
        jSONObject.put("timeoutInterval", this.f4505c.f2145g);
        jSONObject.put("maxGetResponseSize", this.f4505c.m2326h());
        b.put("carb", jSONObject);
        b.put("telemetry", this.f4506d);
        return b;
    }

    public boolean m5216c() {
        if (this.f4504b.f2148b < 0 || this.f4504b.f2150d < 0 || this.f4504b.f2149c < 0 || this.f4504b.f2151e.trim().length() == 0 || this.f4504b.f2152f < 0 || this.f4504b.f2153g < 0 || this.f4504b.m2374j() < 0 || this.f4504b.m2377m() < 0 || this.f4504b.f2165s < 0 || this.f4504b.f2164r < 0 || this.f4505c.f2140b.trim().length() == 0 || this.f4505c.f2141c.trim().length() == 0) {
            return false;
        }
        if (!this.f4505c.f2140b.startsWith("http://") && !this.f4505c.f2140b.startsWith("https://")) {
            return false;
        }
        if ((this.f4505c.f2141c.startsWith("http://") || this.f4505c.f2141c.startsWith("https://")) && this.f4505c.f2142d >= 0 && this.f4505c.f2143e >= 0 && this.f4505c.f2144f >= 0 && this.f4505c.f2145g >= 0 && this.f4505c.f2146h >= 0) {
            return true;
        }
        return false;
    }

    public Config m5217d() {
        return new SignalsConfig();
    }

    public JSONObject m5218e() {
        return this.f4506d;
    }

    public SignalsConfig m5219f() {
        return this.f4504b;
    }

    public SignalsConfig m5220g() {
        return this.f4505c;
    }
}
