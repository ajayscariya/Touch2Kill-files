package com.inmobi.commons.core.configs;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.a */
public abstract class Config {
    private Config f1572a;

    /* renamed from: com.inmobi.commons.core.configs.a.a */
    public static final class Config {
        private HashMap<String, Boolean> f1571a;

        public Config() {
            this.f1571a = new HashMap();
            this.f1571a.put("O1", Boolean.valueOf(true));
            this.f1571a.put("SID", Boolean.valueOf(true));
            this.f1571a.put("LID", Boolean.valueOf(true));
            this.f1571a.put("UM5", Boolean.valueOf(true));
            this.f1571a.put("GPID", Boolean.valueOf(true));
            this.f1571a.put("IMID", Boolean.valueOf(true));
            this.f1571a.put("AIDL", Boolean.valueOf(true));
        }

        public HashMap<String, Boolean> m1648a() {
            return this.f1571a;
        }
    }

    public abstract String m1649a();

    public abstract boolean m1652c();

    public abstract Config m1653d();

    public Config() {
        this.f1572a = new Config();
    }

    public void m1650a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("includeIds");
        for (int i = 0; i < jSONObject2.length(); i++) {
            this.f1572a.f1571a.put("O1", Boolean.valueOf(jSONObject2.getBoolean("O1")));
            this.f1572a.f1571a.put("SID", Boolean.valueOf(jSONObject2.getBoolean("SID")));
            this.f1572a.f1571a.put("LID", Boolean.valueOf(jSONObject2.getBoolean("LID")));
            this.f1572a.f1571a.put("UM5", Boolean.valueOf(jSONObject2.getBoolean("UM5")));
            this.f1572a.f1571a.put("GPID", Boolean.valueOf(jSONObject2.getBoolean("GPID")));
            this.f1572a.f1571a.put("IMID", Boolean.valueOf(jSONObject2.getBoolean("IMID")));
            this.f1572a.f1571a.put("AIDL", Boolean.valueOf(jSONObject2.getBoolean("AIDL")));
        }
    }

    public JSONObject m1651b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("O1", this.f1572a.f1571a.get("O1"));
        jSONObject2.put("SID", this.f1572a.f1571a.get("SID"));
        jSONObject2.put("LID", this.f1572a.f1571a.get("LID"));
        jSONObject2.put("UM5", this.f1572a.f1571a.get("UM5"));
        jSONObject2.put("GPID", this.f1572a.f1571a.get("GPID"));
        jSONObject2.put("IMID", this.f1572a.f1571a.get("IMID"));
        jSONObject2.put("AIDL", this.f1572a.f1571a.get("AIDL"));
        jSONObject.put("includeIds", jSONObject2);
        return jSONObject;
    }

    public Config m1654n() {
        return this.f1572a;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass() && m1649a().equals(((Config) obj).m1649a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return m1649a().hashCode();
    }
}
