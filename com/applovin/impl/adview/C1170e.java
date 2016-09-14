package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

/* renamed from: com.applovin.impl.adview.e */
class C1170e implements AppLovinAdVideoPlaybackListener {
    final /* synthetic */ AdViewControllerImpl f3823a;

    C1170e(AdViewControllerImpl adViewControllerImpl) {
        this.f3823a = adViewControllerImpl;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f3823a.f3786x != null) {
            this.f3823a.f3786x.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f3823a.f3786x != null) {
            this.f3823a.f3786x.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
