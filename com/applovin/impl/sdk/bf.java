package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bf implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f3902a;
    final /* synthetic */ be f3903b;

    bf(be beVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f3903b = beVar;
        this.f3902a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f3903b.m4192a(this.f3902a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f3903b.m4198a(list, this.f3902a);
    }
}
