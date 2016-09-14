package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bk implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f3913a;
    final /* synthetic */ be f3914b;

    bk(be beVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f3914b = beVar;
        this.f3913a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f3913a != null) {
            this.f3913a.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f3913a != null) {
            this.f3913a.onNativeAdsLoaded(list);
        }
    }
}
