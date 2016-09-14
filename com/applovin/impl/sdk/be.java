package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class be implements AppLovinNativeAdService {
    private final AppLovinSdkImpl f3900a;
    private final Object f3901b;

    be(AppLovinSdkImpl appLovinSdkImpl) {
        this.f3901b = new Object();
        this.f3900a = appLovinSdkImpl;
    }

    private List m4184a(AppLovinNativeAd appLovinNativeAd) {
        List arrayList = new ArrayList(1);
        arrayList.add((NativeAdImpl) appLovinNativeAd);
        return arrayList;
    }

    private void m4191a(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f3900a.m4160a().m233a(new ci(this.f3900a, m4184a(appLovinNativeAd), new bh(this, appLovinNativeAdPrecacheListener)), cs.MAIN);
    }

    private void m4192a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Throwable e) {
                this.f3900a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    private void m4193a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Throwable e) {
                this.f3900a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    private void m4194a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
                return;
            } catch (Throwable e) {
                this.f3900a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
                return;
            }
        }
        appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
    }

    private void m4195a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
                return;
            } catch (Throwable e) {
                this.f3900a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
                return;
            }
        }
        appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
    }

    private void m4196b(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f3900a.m4160a().m233a(new cg(this.f3900a, list, new bk(this, appLovinNativeAdLoadListener)), cs.MAIN);
    }

    private void m4197c(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f3900a.m4160a().m233a(new ci(this.f3900a, list, new bl(this, appLovinNativeAdLoadListener)), cs.MAIN);
    }

    public void m4198a(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f3900a.m4161a(bx.aL)).intValue();
        if (intValue > 0) {
            list = list;
            int size = list.size();
            if (size != 0) {
                intValue = Math.min(intValue, size);
                List subList = list.subList(0, intValue);
                m4196b(subList, new bi(this, subList, appLovinNativeAdLoadListener, list.subList(intValue, size)));
            } else if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            }
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        AppLovinNativeAd appLovinNativeAd = null;
        synchronized (this.f3901b) {
            if (i == 1) {
                if (this.f3900a.m4165d().m6090e(NativeAdImpl.SPEC_NATIVE)) {
                    appLovinNativeAd = (AppLovinNativeAd) this.f3900a.m4165d().m6086b(NativeAdImpl.SPEC_NATIVE);
                }
            }
        }
        if (appLovinNativeAd != null) {
            m4193a(appLovinNativeAdLoadListener, Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
            return;
        }
        this.f3900a.m4160a().m233a(new cp(this.f3900a, i, new bf(this, appLovinNativeAdLoadListener)), cs.MAIN);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m4191a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f3900a.m4160a().m233a(new cg(this.f3900a, m4184a(appLovinNativeAd), new bg(this, appLovinNativeAdPrecacheListener)), cs.MAIN);
    }
}
