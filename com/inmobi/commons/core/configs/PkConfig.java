package com.inmobi.commons.core.configs;

import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.f */
public class PkConfig extends Config {
    private String f4440a;
    private String f4441b;
    private String f4442c;
    private String f4443d;

    public PkConfig() {
        this.f4440a = "010001";
        this.f4441b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
        this.f4442c = "rsa";
        this.f4443d = SchemaSymbols.ATTVAL_TRUE_1;
    }

    public String m5131a() {
        return "pk";
    }

    public void m5132a(JSONObject jSONObject) throws JSONException {
        super.m1650a(jSONObject);
        this.f4440a = jSONObject.getString("e");
        this.f4441b = jSONObject.getString("m");
        this.f4442c = jSONObject.getString("alg");
        this.f4443d = jSONObject.getString("ver");
    }

    public JSONObject m5133b() throws JSONException {
        JSONObject b = super.m1651b();
        b.put("e", this.f4440a);
        b.put("m", this.f4441b);
        b.put("alg", this.f4442c);
        b.put("ver", this.f4443d);
        return b;
    }

    public boolean m5134c() {
        if (this.f4440a.trim().length() == 0 || this.f4441b.trim().length() == 0 || this.f4442c.trim().length() == 0 || this.f4443d.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public Config m5135d() {
        return new PkConfig();
    }

    public String m5136e() {
        return this.f4440a;
    }

    public String m5137f() {
        return this.f4441b;
    }

    public String m5138g() {
        return this.f4443d;
    }
}
