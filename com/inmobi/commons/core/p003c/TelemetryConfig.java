package com.inmobi.commons.core.p003c;

import com.inmobi.commons.core.configs.Config;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.c.c */
class TelemetryConfig extends Config {
    private TelemetryComponentConfig f4423a;
    private String f4424b;
    private int f4425c;
    private int f4426d;
    private int f4427e;
    private int f4428f;
    private int f4429g;
    private int f4430h;

    public TelemetryConfig() {
        this.f4424b = "http://tm.inmobi.com/telemetry-collector/v1/collect";
        this.f4425c = 300;
        this.f4426d = 60;
        this.f4427e = 50;
        this.f4428f = 3;
        this.f4429g = 1000;
        this.f4430h = 10;
        this.f4423a = new TelemetryComponentConfig();
    }

    public String m5104a() {
        return "telemetry";
    }

    public boolean m5107c() {
        if (this.f4423a == null || this.f4423a.m1616c() < 0 || this.f4424b.trim().length() == 0) {
            return false;
        }
        if ((this.f4424b.startsWith("http://") || this.f4424b.startsWith("https://")) && this.f4426d >= 0 && this.f4425c >= 0 && this.f4428f >= 0 && this.f4430h > 0 && this.f4427e > 0 && this.f4429g > 0) {
            return true;
        }
        return false;
    }

    public void m5105a(JSONObject jSONObject) throws JSONException {
        super.m1650a(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("base");
        this.f4423a.m1614b(jSONObject2.getBoolean("enabled"));
        this.f4423a.m1611a(jSONObject2.getInt("samplingFactor"));
        this.f4423a.m1612a(jSONObject2.getBoolean("metricEnabled"));
        m5098a(jSONObject.getString(DatabaseOpenHelper.HISTORY_ROW_URL));
        m5097a(jSONObject.getInt("processingInterval"));
        m5103f(jSONObject.getInt("retryInterval"));
        m5100c(jSONObject.getInt("maxBatchSize"));
        m5099b(jSONObject.getInt("maxRetryCount"));
        m5101d(jSONObject.getInt("maxEventsToPersist"));
        m5102e(jSONObject.getInt("memoryThreshold"));
    }

    public JSONObject m5106b() throws JSONException {
        JSONObject b = super.m1651b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", this.f4423a.m1615b());
        jSONObject.put("samplingFactor", this.f4423a.m1616c());
        jSONObject.put("metricEnabled", this.f4423a.m1617d());
        b.put("base", jSONObject);
        b.put(DatabaseOpenHelper.HISTORY_ROW_URL, m5110f());
        b.put("processingInterval", m5115k());
        b.put("retryInterval", m5111g());
        b.put("maxBatchSize", m5113i());
        b.put("maxRetryCount", m5114j());
        b.put("maxEventsToPersist", m5116l());
        b.put("memoryThreshold", m5112h());
        return b;
    }

    public boolean m5109e() {
        return this.f4423a.m1615b();
    }

    private void m5098a(String str) {
        this.f4424b = str;
    }

    public String m5110f() {
        return this.f4424b;
    }

    private void m5097a(int i) {
        this.f4425c = i;
    }

    private void m5099b(int i) {
        this.f4428f = i;
    }

    private void m5100c(int i) {
        this.f4427e = i;
    }

    private void m5101d(int i) {
        this.f4429g = i;
    }

    private void m5102e(int i) {
        this.f4430h = i;
    }

    private void m5103f(int i) {
        this.f4426d = i;
    }

    public int m5111g() {
        return this.f4426d;
    }

    public int m5112h() {
        return this.f4430h;
    }

    public int m5113i() {
        return this.f4427e;
    }

    public int m5114j() {
        return this.f4428f;
    }

    public int m5115k() {
        return this.f4425c;
    }

    public int m5116l() {
        return this.f4429g;
    }

    public Config m5108d() {
        return new TelemetryConfig();
    }

    public TelemetryComponentConfig m5117m() {
        return this.f4423a;
    }
}
