package com.applovin.sdk;

import com.applovin.impl.sdk.NativeAdImpl;

public class AppLovinSdkSettings {
    private boolean f370a;
    private long f371b;
    private String f372c;
    private String f373d;

    public AppLovinSdkSettings() {
        this.f370a = false;
        this.f371b = -1;
        this.f372c = AppLovinAdSize.BANNER.getLabel() + "," + AppLovinAdSize.INTERSTITIAL.getLabel();
        this.f373d = AppLovinAdType.INCENTIVIZED.getLabel() + "," + AppLovinAdType.REGULAR.getLabel() + "," + NativeAdImpl.TYPE_NATIVE.getLabel();
    }

    public String getAutoPreloadSizes() {
        return this.f372c;
    }

    public String getAutoPreloadTypes() {
        return this.f373d;
    }

    public long getBannerAdRefreshSeconds() {
        return this.f371b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f370a;
    }

    public void setAutoPreloadSizes(String str) {
        this.f372c = str;
    }

    public void setAutoPreloadTypes(String str) {
        this.f373d = str;
    }

    public void setBannerAdRefreshSeconds(long j) {
        this.f371b = j;
    }

    public void setVerboseLogging(boolean z) {
        this.f370a = z;
    }
}
