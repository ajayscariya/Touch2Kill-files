package com.inmobi.commons.core.configs;

import com.inmobi.commons.p000a.SdkInfo;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.List;
import mf.javax.xml.XMLConstants;
import mf.javax.xml.transform.OutputKeys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.g */
class RootConfig extends Config {
    private int f4444a;
    private int f4445b;
    private int f4446c;
    private List<RootConfig> f4447d;
    private RootConfig f4448e;
    private JSONObject f4449f;

    /* renamed from: com.inmobi.commons.core.configs.g.a */
    static final class RootConfig {
        private String f1587a;
        private long f1588b;
        private String f1589c;
        private String f1590d;

        RootConfig() {
        }

        public String m1689a() {
            return this.f1587a;
        }

        public Long m1690b() {
            return Long.valueOf(this.f1588b);
        }

        public String m1691c() {
            return this.f1589c;
        }

        public String m1692d() {
            return this.f1590d;
        }
    }

    /* renamed from: com.inmobi.commons.core.configs.g.b */
    public static final class RootConfig {
        private String f1591a;
        private String f1592b;

        public RootConfig() {
            this.f1591a = SdkInfo.m1572b();
            this.f1592b = SdkInfo.m1576f();
        }

        public String m1697a() {
            return this.f1591a;
        }

        public String m1698b() {
            return this.f1592b;
        }
    }

    public RootConfig() {
        this.f4444a = 3;
        this.f4445b = 60;
        this.f4446c = 3;
        this.f4447d = new ArrayList();
        this.f4448e = new RootConfig();
        this.f4449f = new JSONObject();
    }

    public String m5140a() {
        return "root";
    }

    public JSONObject m5143b() throws JSONException {
        JSONObject b = super.m1651b();
        JSONArray jSONArray = new JSONArray();
        b.put("maxRetries", this.f4444a);
        b.put("retryInterval", this.f4445b);
        b.put("waitTime", this.f4446c);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(OutputKeys.VERSION, this.f4448e.f1591a);
        jSONObject.put(DatabaseOpenHelper.HISTORY_ROW_URL, this.f4448e.f1592b);
        b.put("latestSdkInfo", jSONObject);
        for (int i = 0; i < this.f4447d.size(); i++) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", ((RootConfig) this.f4447d.get(i)).f1587a);
            jSONObject2.put("expiry", ((RootConfig) this.f4447d.get(i)).f1588b);
            jSONObject2.put("protocol", ((RootConfig) this.f4447d.get(i)).f1589c);
            jSONObject2.put(DatabaseOpenHelper.HISTORY_ROW_URL, ((RootConfig) this.f4447d.get(i)).f1590d);
            jSONArray.put(jSONObject2);
        }
        b.put("components", jSONArray);
        return b;
    }

    public void m5141a(JSONObject jSONObject) throws JSONException {
        super.m1650a(jSONObject);
        this.f4444a = jSONObject.getInt("maxRetries");
        this.f4445b = jSONObject.getInt("retryInterval");
        this.f4446c = jSONObject.getInt("waitTime");
        JSONObject jSONObject2 = jSONObject.getJSONObject("latestSdkInfo");
        this.f4448e.f1591a = jSONObject2.getString(OutputKeys.VERSION);
        this.f4448e.f1592b = jSONObject2.getString(DatabaseOpenHelper.HISTORY_ROW_URL);
        JSONArray jSONArray = jSONObject.getJSONArray("components");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            RootConfig rootConfig = new RootConfig();
            rootConfig.f1587a = jSONObject3.getString("type");
            rootConfig.f1588b = jSONObject3.getLong("expiry");
            rootConfig.f1589c = jSONObject3.getString("protocol");
            rootConfig.f1590d = jSONObject3.getString(DatabaseOpenHelper.HISTORY_ROW_URL);
            this.f4447d.add(rootConfig);
        }
    }

    public boolean m5144c() {
        if (this.f4447d == null || this.f4444a < 0 || this.f4445b < 0 || this.f4446c < 0 || this.f4448e.m1697a().trim().length() == 0) {
            return false;
        }
        if (!this.f4448e.m1698b().startsWith("http://") && !this.f4448e.m1698b().startsWith("https://")) {
            return false;
        }
        for (int i = 0; i < this.f4447d.size(); i++) {
            RootConfig rootConfig = (RootConfig) this.f4447d.get(i);
            if (rootConfig.m1689a().trim().length() == 0 || rootConfig.m1690b().longValue() < 0 || rootConfig.m1690b().longValue() > 864000 || rootConfig.m1691c().trim().length() == 0 || rootConfig.m1692d() == null || rootConfig.m1692d().trim().length() == 0) {
                return false;
            }
            if (!rootConfig.m1692d().startsWith("http://") && !rootConfig.m1692d().startsWith("https://")) {
                return false;
            }
        }
        return true;
    }

    public Config m5145d() {
        return new RootConfig();
    }

    public long m5139a(String str) {
        for (int i = 0; i < this.f4447d.size(); i++) {
            RootConfig rootConfig = (RootConfig) this.f4447d.get(i);
            if (str.equals(rootConfig.f1587a)) {
                return rootConfig.f1588b;
            }
        }
        return 86400;
    }

    public int m5146e() {
        return this.f4444a;
    }

    public int m5147f() {
        return this.f4445b;
    }

    public int m5148g() {
        return this.f4446c;
    }

    public String m5142b(String str) {
        for (int i = 0; i < this.f4447d.size(); i++) {
            RootConfig rootConfig = (RootConfig) this.f4447d.get(i);
            if (str.equals(rootConfig.f1587a)) {
                return rootConfig.f1590d;
            }
        }
        return XMLConstants.NULL_NS_URI;
    }

    public RootConfig m5149h() {
        return this.f4448e;
    }

    public JSONObject m5150i() {
        return this.f4449f;
    }
}
