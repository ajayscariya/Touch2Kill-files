package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

public class cg extends ch {
    public cg(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public cg(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    private boolean m5661b(NativeAdImpl nativeAdImpl) {
        m5663a(nativeAdImpl, (int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    protected void m5662a(NativeAdImpl nativeAdImpl) {
        if (this.b != null) {
            this.b.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    protected void m5663a(NativeAdImpl nativeAdImpl, int i) {
        if (this.b != null) {
            this.b.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    protected boolean m5664a(NativeAdImpl nativeAdImpl, C0246z c0246z) {
        this.f.getLogger().m306d("TaskCacheNativeAdImages", "Beginning slot image caching for ad " + nativeAdImpl.getAdId());
        if (((Boolean) this.f.m4161a(bx.f233B)).booleanValue()) {
            String a = m4207a(nativeAdImpl.getSourceIconUrl(), c0246z);
            if (a == null) {
                return m5661b(nativeAdImpl);
            }
            nativeAdImpl.setIconUrl(a);
            a = m4207a(nativeAdImpl.getSourceImageUrl(), c0246z);
            if (a == null) {
                return m5661b(nativeAdImpl);
            }
            nativeAdImpl.setImageUrl(a);
        } else {
            this.f.getLogger().m306d("TaskCacheNativeAdImages", "Resource caching is disabled, skipping...");
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
