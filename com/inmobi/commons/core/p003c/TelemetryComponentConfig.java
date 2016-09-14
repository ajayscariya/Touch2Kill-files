package com.inmobi.commons.core.p003c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.c.b */
public class TelemetryComponentConfig {
    private int f1549a;
    private String f1550b;
    private boolean f1551c;
    private boolean f1552d;
    private Map<String, TelemetryComponentConfig> f1553e;

    /* renamed from: com.inmobi.commons.core.c.b.a */
    static final class TelemetryComponentConfig {
        private String f1546a;
        private int f1547b;
        private boolean f1548c;

        public TelemetryComponentConfig(String str, int i, boolean z) {
            m1604a(str);
            m1603a(i);
            m1605a(z);
        }

        public String m1602a() {
            return this.f1546a;
        }

        public int m1606b() {
            return this.f1547b;
        }

        public void m1604a(String str) {
            this.f1546a = str;
        }

        public void m1603a(int i) {
            this.f1547b = i;
        }

        public void m1605a(boolean z) {
            this.f1548c = z;
        }

        public boolean m1607c() {
            return this.f1548c;
        }
    }

    public TelemetryComponentConfig() {
        this.f1549a = 0;
        this.f1550b = "telemetry";
        this.f1551c = false;
        this.f1552d = false;
        this.f1553e = new HashMap();
    }

    public TelemetryComponentConfig(String str, JSONObject jSONObject, TelemetryComponentConfig telemetryComponentConfig) {
        this.f1549a = 0;
        this.f1550b = "telemetry";
        this.f1551c = false;
        this.f1552d = false;
        this.f1553e = new HashMap();
        if (jSONObject == null) {
            m1608a(str, telemetryComponentConfig);
            return;
        }
        String str2;
        JSONArray jSONArray;
        int i;
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    str2 = str;
                    this.f1550b = str2;
                    this.f1551c = jSONObject.has("enabled") ? jSONObject.getBoolean("enabled") : true;
                    m1611a(jSONObject.has("samplingFactor") ? jSONObject.getInt("samplingFactor") : telemetryComponentConfig.m1616c());
                    m1612a(jSONObject.has("metricEnabled") ? jSONObject.getBoolean("metricEnabled") : telemetryComponentConfig.m1617d());
                    this.f1553e = new HashMap();
                    if (jSONObject.has("events")) {
                        jSONArray = jSONObject.getJSONArray("events");
                        for (i = 0; i < jSONArray.length(); i++) {
                            TelemetryComponentConfig telemetryComponentConfig2 = new TelemetryComponentConfig();
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            telemetryComponentConfig2.m1604a(jSONObject2.getString("type"));
                            telemetryComponentConfig2.m1603a(jSONObject2.has("samplingFactor") ? jSONObject2.getInt("samplingFactor") : m1616c());
                            telemetryComponentConfig2.m1605a(jSONObject2.has("metricEnabled") ? jSONObject2.getBoolean("metricEnabled") : m1617d());
                            this.f1553e.put(telemetryComponentConfig2.m1602a(), telemetryComponentConfig2);
                        }
                    }
                }
            } catch (JSONException e) {
                m1608a(str, telemetryComponentConfig);
                return;
            }
        }
        str2 = telemetryComponentConfig.m1610a();
        this.f1550b = str2;
        if (jSONObject.has("enabled")) {
        }
        this.f1551c = jSONObject.has("enabled") ? jSONObject.getBoolean("enabled") : true;
        if (jSONObject.has("samplingFactor")) {
        }
        m1611a(jSONObject.has("samplingFactor") ? jSONObject.getInt("samplingFactor") : telemetryComponentConfig.m1616c());
        if (jSONObject.has("metricEnabled")) {
        }
        m1612a(jSONObject.has("metricEnabled") ? jSONObject.getBoolean("metricEnabled") : telemetryComponentConfig.m1617d());
        this.f1553e = new HashMap();
        if (jSONObject.has("events")) {
            jSONArray = jSONObject.getJSONArray("events");
            for (i = 0; i < jSONArray.length(); i++) {
                TelemetryComponentConfig telemetryComponentConfig22 = new TelemetryComponentConfig();
                JSONObject jSONObject22 = jSONArray.getJSONObject(i);
                telemetryComponentConfig22.m1604a(jSONObject22.getString("type"));
                if (jSONObject22.has("samplingFactor")) {
                }
                telemetryComponentConfig22.m1603a(jSONObject22.has("samplingFactor") ? jSONObject22.getInt("samplingFactor") : m1616c());
                if (jSONObject22.has("metricEnabled")) {
                }
                telemetryComponentConfig22.m1605a(jSONObject22.has("metricEnabled") ? jSONObject22.getBoolean("metricEnabled") : m1617d());
                this.f1553e.put(telemetryComponentConfig22.m1602a(), telemetryComponentConfig22);
            }
        }
    }

    public String m1610a() {
        return this.f1550b;
    }

    public boolean m1615b() {
        return this.f1551c;
    }

    public TelemetryComponentConfig m1609a(String str) {
        TelemetryComponentConfig telemetryComponentConfig = (TelemetryComponentConfig) this.f1553e.get(str);
        return telemetryComponentConfig != null ? telemetryComponentConfig : new TelemetryComponentConfig(str, m1616c(), m1617d());
    }

    private void m1608a(String str, TelemetryComponentConfig telemetryComponentConfig) {
        m1614b(true);
        m1613b(str);
    }

    public int m1616c() {
        return this.f1549a;
    }

    public boolean m1617d() {
        return this.f1552d;
    }

    public void m1612a(boolean z) {
        this.f1552d = z;
    }

    public void m1614b(boolean z) {
        this.f1551c = z;
    }

    public void m1611a(int i) {
        this.f1549a = i;
    }

    public void m1613b(String str) {
        this.f1550b = str;
    }
}
