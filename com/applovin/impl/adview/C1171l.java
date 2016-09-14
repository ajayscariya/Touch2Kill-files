package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.l */
class C1171l implements AppLovinAdLoadListener, AppLovinAdUpdateListener {
    private final WeakReference f3824a;
    private final AppLovinAdService f3825b;
    private final AppLovinLogger f3826c;

    C1171l(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        if (adViewControllerImpl == null) {
            throw new IllegalArgumentException("No view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f3824a = new WeakReference(adViewControllerImpl);
            this.f3826c = appLovinSdk.getLogger();
            this.f3825b = appLovinSdk.getAdService();
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f3824a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m4080a(appLovinAd);
        } else {
            this.f3826c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was recieved");
        }
    }

    public void adUpdated(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f3824a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m4080a(appLovinAd);
            return;
        }
        this.f3825b.removeAdUpdateListener(this, appLovinAd.getSize());
        this.f3826c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
    }

    public void failedToReceiveAd(int i) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f3824a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m4079a(i);
        }
    }

    public String toString() {
        return "[AdViewController listener: " + hashCode() + "]";
    }
}
