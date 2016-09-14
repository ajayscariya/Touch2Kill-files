package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;

class bj implements AppLovinNativeAdLoadListener {
    final /* synthetic */ bi f3912a;

    bj(bi biVar) {
        this.f3912a = biVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f3912a.f3909b != null) {
            this.f3912a.f3909b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f3912a.f3909b != null) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.f3912a.f3908a);
            arrayList.addAll(this.f3912a.f3910c);
            this.f3912a.f3909b.onNativeAdsLoaded(arrayList);
        }
    }
}
