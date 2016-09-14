package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

class aa implements AppLovinAdVideoPlaybackListener {
    final /* synthetic */ ah f3792a;
    final /* synthetic */ C1172x f3793b;

    aa(C1172x c1172x, ah ahVar) {
        this.f3793b = c1172x;
        this.f3792a = ahVar;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        AppLovinAdVideoPlaybackListener c = this.f3792a.m4099c();
        if (c != null) {
            c.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        AppLovinAdVideoPlaybackListener c = this.f3792a.m4099c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
