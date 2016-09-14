package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

class cp extends cn {
    private int f4824a;
    private final AppLovinNativeAdLoadListener f4825b;

    public cp(AppLovinSdkImpl appLovinSdkImpl, int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(NativeAdImpl.SIZE_NATIVE, NativeAdImpl.TYPE_NATIVE, null, appLovinSdkImpl);
        this.f4825b = appLovinNativeAdLoadListener;
        this.f4824a = i;
    }

    protected bw m5675a(JSONObject jSONObject) {
        return new cx(jSONObject, this.f, this.f4825b);
    }

    protected void m5676a(int i) {
        if (this.f4825b != null) {
            this.f4825b.onNativeAdsFailedToLoad(i);
        }
    }

    protected void m5677b(Map map) {
        map.put("slot_count", Integer.toString(this.f4824a));
    }

    protected void m5678c(Map map) {
        de a = dc.m236a().m237a("tFNW");
        if (a != null) {
            map.put("etfw", Long.toString(a.m240b()));
            map.put("ntfw", a.m239a());
        }
    }

    protected String m5679d() {
        return C0240q.m276b("nad", this.f);
    }

    public String m5680e() {
        return "tFNW";
    }
}
