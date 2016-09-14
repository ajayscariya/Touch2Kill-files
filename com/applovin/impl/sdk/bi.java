package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bi implements AppLovinNativeAdLoadListener {
    final /* synthetic */ List f3908a;
    final /* synthetic */ AppLovinNativeAdLoadListener f3909b;
    final /* synthetic */ List f3910c;
    final /* synthetic */ be f3911d;

    bi(be beVar, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list2) {
        this.f3911d = beVar;
        this.f3908a = list;
        this.f3909b = appLovinNativeAdLoadListener;
        this.f3910c = list2;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f3909b != null) {
            this.f3909b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        this.f3911d.m4197c(this.f3908a, new bj(this));
    }
}
