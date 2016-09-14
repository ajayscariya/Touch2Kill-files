package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;

class bd implements AppLovinNativeAdPrecacheListener {
    final /* synthetic */ bc f3899a;

    bd(bc bcVar) {
        this.f3899a = bcVar;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f3899a.m5647b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        if (!AppLovinSdkUtils.isValidString(appLovinNativeAd.getVideoUrl())) {
            this.f3899a.m5649c((az) appLovinNativeAd);
        }
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f3899a.b.m310w("NativeAdPreloadManager", "Video failed to cache during native ad preload. " + i);
        this.f3899a.m5649c((az) appLovinNativeAd);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f3899a.m5649c((az) appLovinNativeAd);
    }
}
