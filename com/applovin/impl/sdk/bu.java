package com.applovin.impl.sdk;

import org.json.JSONObject;

abstract class bu extends bw {
    protected bu(String str, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
    }

    protected void m4199a(String str, JSONObject jSONObject, C0239p c0239p) {
        cy bvVar = new bv(this, "Repeat" + this.e, bx.f264g, this.f, str, jSONObject, c0239p);
        bvVar.m4269a(bx.f267j);
        bvVar.run();
    }
}
