package com.applovin.impl.sdk;

import org.json.JSONObject;

class bv extends cy {
    final /* synthetic */ String f4816a;
    final /* synthetic */ JSONObject f4817b;
    final /* synthetic */ C0239p f4818c;
    final /* synthetic */ bu f4819d;

    bv(bu buVar, String str, bz bzVar, AppLovinSdkImpl appLovinSdkImpl, String str2, JSONObject jSONObject, C0239p c0239p) {
        this.f4819d = buVar;
        this.f4816a = str2;
        this.f4817b = jSONObject;
        this.f4818c = c0239p;
        super(str, bzVar, appLovinSdkImpl);
    }

    public void m5655a(int i) {
        this.f4818c.m265a(i);
    }

    protected void m5656a(C0238o c0238o, C0239p c0239p) {
        c0238o.m264a(C0240q.m270a(C0240q.m271a(this.f4816a, this.f)), this.f4817b, c0239p);
    }

    public void m5657a(JSONObject jSONObject, int i) {
        this.f4818c.m266a(jSONObject, i);
    }
}
