package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bl implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f3915a;
    final /* synthetic */ be f3916b;

    bl(be beVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f3916b = beVar;
        this.f3915a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f3916b.m4192a(this.f3915a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f3916b.m4193a(this.f3915a, list);
    }
}
