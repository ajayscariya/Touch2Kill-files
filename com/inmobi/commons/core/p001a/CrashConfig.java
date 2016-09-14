package com.inmobi.commons.core.p001a;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.a.a */
public class CrashConfig extends Config {
    private static final String f4404a;
    private JSONObject f4405b;

    static {
        f4404a = CrashConfig.class.getSimpleName();
    }

    private JSONObject m5061f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", false);
        jSONObject.put("samplingFactor", 0);
        jSONObject.put("metricEnabled", false);
        return jSONObject;
    }

    public CrashConfig() {
        try {
            this.f4405b = m5061f();
        } catch (Exception e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4404a, "Error in default telemetry config");
        }
    }

    public void m5063a(JSONObject jSONObject) {
        try {
            super.m1650a(jSONObject);
            this.f4405b = jSONObject.getJSONObject("telemetry");
        } catch (JSONException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4404a, "Error parsing Crash Config " + e.toString());
        }
    }

    public JSONObject m5064b() {
        try {
            JSONObject b = super.m1651b();
            b.put("telemetry", this.f4405b);
            return b;
        } catch (JSONException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4404a, "Error parsing Crash Config " + e.toString());
            return null;
        }
    }

    public JSONObject m5067e() {
        return this.f4405b;
    }

    public String m5062a() {
        return "crashReporting";
    }

    public boolean m5065c() {
        return true;
    }

    public Config m5066d() {
        return new CrashConfig();
    }
}
