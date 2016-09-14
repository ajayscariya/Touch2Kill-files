package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

class bg implements AppLovinNativeAdPrecacheListener {
    final /* synthetic */ AppLovinNativeAdPrecacheListener f3904a;
    final /* synthetic */ be f3905b;

    bg(be beVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f3905b = beVar;
        this.f3904a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f3905b.m4194a(this.f3904a, appLovinNativeAd, i, false);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        this.f3905b.m4195a(this.f3904a, appLovinNativeAd, false);
        this.f3905b.m4191a(appLovinNativeAd, this.f3904a);
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
    }
}
