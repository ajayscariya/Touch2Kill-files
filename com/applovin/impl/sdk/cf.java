package com.applovin.impl.sdk;

import org.json.JSONObject;

class cf extends cy {
    final /* synthetic */ JSONObject f4820a;
    final /* synthetic */ ce f4821b;

    cf(ce ceVar, String str, bz bzVar, AppLovinSdkImpl appLovinSdkImpl, JSONObject jSONObject) {
        this.f4821b = ceVar;
        this.f4820a = jSONObject;
        super(str, bzVar, appLovinSdkImpl);
    }

    public void m5658a(int i) {
        C0240q.m273a(i, this.f);
    }

    protected void m5659a(C0238o c0238o, C0239p c0239p) {
        c0238o.m264a(C0240q.m271a("device", this.f), this.f4820a, c0239p);
    }

    public void m5660a(JSONObject jSONObject, int i) {
        this.f4821b.m4201a(jSONObject);
    }
}
