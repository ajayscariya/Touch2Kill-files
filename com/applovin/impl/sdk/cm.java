package com.applovin.impl.sdk;

import org.json.JSONObject;

class cm extends cy {
    final /* synthetic */ cl f4822a;

    cm(cl clVar, String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        this.f4822a = clVar;
        super(str, i, appLovinSdkImpl);
    }

    public void m5669a(int i) {
        this.f4822a.f3928c.onPostbackFailure(this.f4822a.f3926a, i);
    }

    protected void m5670a(C0238o c0238o, C0239p c0239p) {
        int intValue = this.f4822a.f3931j < 0 ? ((Integer) this.f.m4161a(bx.as)).intValue() : this.f4822a.f3931j;
        if (this.f4822a.f3927b == null) {
            c0238o.m262a(this.f4822a.f3926a, intValue, false, c0239p);
        } else {
            c0238o.m261a(this.f4822a.f3926a, intValue, new JSONObject(this.f4822a.f3927b), false, c0239p);
        }
    }

    public void m5671a(JSONObject jSONObject, int i) {
        this.f4822a.f3928c.onPostbackSuccess(this.f4822a.f3926a);
    }
}
