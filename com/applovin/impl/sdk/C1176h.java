package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.h */
class C1176h implements AppLovinAdLoadListener {
    final /* synthetic */ AppLovinAdServiceImpl f3960a;
    private final C0235i f3961b;

    private C1176h(AppLovinAdServiceImpl appLovinAdServiceImpl, C0235i c0235i) {
        this.f3960a = appLovinAdServiceImpl;
        this.f3961b = c0235i;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        synchronized (this.f3961b.f327b) {
            if (this.f3960a.m4147a(this.f3961b.f326a)) {
                long b = this.f3960a.m4150b(this.f3961b.f326a);
                if (b > 0) {
                    this.f3961b.f329d = (b * 1000) + System.currentTimeMillis();
                } else if (b == 0) {
                    this.f3961b.f329d = Long.MAX_VALUE;
                }
                this.f3961b.f328c = appLovinAd;
            } else {
                this.f3961b.f328c = null;
                this.f3961b.f329d = 0;
            }
            Collection<AppLovinAdLoadListener> hashSet = new HashSet(this.f3961b.f332g);
            this.f3961b.f332g.clear();
            Collection<AppLovinAdUpdateListener> hashSet2 = new HashSet(this.f3961b.f331f);
            this.f3961b.f330e = false;
        }
        this.f3960a.m4155c(this.f3961b.f326a);
        for (AppLovinAdLoadListener adReceived : hashSet) {
            try {
                adReceived.adReceived(appLovinAd);
            } catch (Throwable th) {
                this.f3960a.f3858b.m308e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            }
        }
        for (AppLovinAdUpdateListener adUpdated : hashSet2) {
            try {
                adUpdated.adUpdated(appLovinAd);
            } catch (Throwable th2) {
                this.f3960a.f3858b.m308e("AppLovinAdService", "Unable to notify listener about an updated loaded ad", th2);
            }
        }
    }

    public void failedToReceiveAd(int i) {
        synchronized (this.f3961b.f327b) {
            Collection<AppLovinAdLoadListener> hashSet = new HashSet(this.f3961b.f332g);
            this.f3961b.f332g.clear();
            this.f3961b.f330e = false;
        }
        for (AppLovinAdLoadListener failedToReceiveAd : hashSet) {
            try {
                failedToReceiveAd.failedToReceiveAd(i);
            } catch (Throwable th) {
                this.f3960a.f3858b.m308e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            }
        }
    }
}
