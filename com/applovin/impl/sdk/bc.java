package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bc extends br {
    public bc(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    bw m6079a(C0231c c0231c) {
        bw cpVar = new cp(this.a, 1, this);
        cpVar.m4236a(true);
        return cpVar;
    }

    C0231c m6080a(az azVar) {
        return NativeAdImpl.SPEC_NATIVE;
    }

    Map m6081a() {
        Map hashMap = new HashMap(1);
        hashMap.put(NativeAdImpl.SPEC_NATIVE, new bs(((Integer) this.a.m4161a(bx.aE)).intValue()));
        return hashMap;
    }

    public void m6082a(C0231c c0231c, int i) {
    }

    void m6083a(Object obj, az azVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) azVar}));
    }

    void m6084a(Object obj, C0231c c0231c, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    public void adReceived(AppLovinAd appLovinAd) {
    }

    public /* bridge */ /* synthetic */ az m6086b(C0231c c0231c) {
        return super.m5645b(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6087b(C0231c c0231c, Object obj) {
        super.m5648b(c0231c, obj);
    }

    public /* bridge */ /* synthetic */ boolean m6088c(C0231c c0231c) {
        return super.m5650c(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6089d(C0231c c0231c) {
        super.m5651d(c0231c);
    }

    public /* bridge */ /* synthetic */ boolean m6090e(C0231c c0231c) {
        return super.m5652e(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6091f(C0231c c0231c) {
        super.m5653f(c0231c);
    }

    public void failedToReceiveAd(int i) {
    }

    public void onNativeAdsFailedToLoad(int i) {
        m5647b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdsLoaded(List list) {
        AppLovinNativeAd appLovinNativeAd = (AppLovinNativeAd) list.get(0);
        if (((Boolean) this.a.m4161a(bx.bm)).booleanValue()) {
            this.a.getNativeAdService().precacheResources(appLovinNativeAd, new bd(this));
        } else {
            m5649c((az) appLovinNativeAd);
        }
    }
}
