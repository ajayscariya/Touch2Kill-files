package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

abstract class ch extends bw {
    protected AppLovinNativeAdLoadListener f3921a;
    protected AppLovinNativeAdPrecacheListener f3922b;
    private List f3923c;
    private int f3924d;

    ch(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, appLovinSdkImpl);
        this.f3924d = 0;
        this.f3921a = appLovinNativeAdLoadListener;
        this.f3923c = list;
    }

    ch(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, appLovinSdkImpl);
        this.f3924d = 0;
        if (list == null) {
            throw new IllegalArgumentException("Slots cannot be null");
        }
        this.f3923c = list;
        this.f3922b = appLovinNativeAdPrecacheListener;
    }

    private void m4205a(int i) {
        if (this.f3921a != null) {
            this.f3921a.onNativeAdsFailedToLoad(i);
        }
    }

    private void m4206a(List list) {
        if (this.f3921a != null) {
            this.f3921a.onNativeAdsLoaded(list);
        }
    }

    protected String m4207a(String str, C0246z c0246z) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            this.f.getLogger().m306d(m154a(), "Asked to cache file with null/empty URL, nothing to do.");
            return null;
        } else if (di.m4289a(this.f, str)) {
            try {
                String a = c0246z.m288a(this.h, str, true);
                if (a != null) {
                    return a;
                }
                this.g.m310w(m154a(), "Unable to cache icon resource " + str);
                return null;
            } catch (Throwable e) {
                this.g.m311w(m154a(), "Unable to cache icon resource " + str, e);
                return null;
            }
        } else {
            this.f.getLogger().m306d(m154a(), "Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        }
    }

    protected abstract void m4208a(NativeAdImpl nativeAdImpl);

    protected abstract boolean m4209a(NativeAdImpl nativeAdImpl, C0246z c0246z);

    public void run() {
        for (NativeAdImpl nativeAdImpl : this.f3923c) {
            C0246z fileManager = this.f.getFileManager();
            this.f.getLogger().m306d(m154a(), "Beginning resource caching phase...");
            if (m4209a(nativeAdImpl, fileManager)) {
                this.f3924d++;
                m4208a(nativeAdImpl);
            } else {
                this.f.getLogger().m307e(m154a(), "Unable to cache resources");
            }
        }
        try {
            if (this.f3924d == this.f3923c.size()) {
                m4206a(this.f3923c);
            } else if (((Boolean) this.f.m4161a(bx.aA)).booleanValue()) {
                this.f.getLogger().m307e(m154a(), "Mismatch between successful populations and requested size");
                m4205a(-6);
            } else {
                m4206a(this.f3923c);
            }
        } catch (Throwable th) {
            this.f.getLogger().userError(m154a(), "Encountered exception while notifying publisher code", th);
        }
    }
}
