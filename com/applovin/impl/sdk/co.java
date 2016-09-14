package com.applovin.impl.sdk;

import org.json.JSONObject;

class co extends cy {
    final /* synthetic */ cn f4823a;

    co(cn cnVar, String str, bz bzVar, AppLovinSdkImpl appLovinSdkImpl) {
        this.f4823a = cnVar;
        super(str, bzVar, appLovinSdkImpl);
    }

    public void m5672a(int i) {
        this.f4823a.m4222b(i);
    }

    protected void m5673a(C0238o c0238o, C0239p c0239p) {
        c0238o.m260a(this.f4823a.m4239c(), ((Integer) this.f.m4161a(bx.f273p)).intValue(), c0239p);
    }

    public void m5674a(JSONObject jSONObject, int i) {
        if (i == 200) {
            this.f4823a.m4223b(jSONObject);
        } else {
            this.f4823a.m4222b(i);
        }
    }
}
