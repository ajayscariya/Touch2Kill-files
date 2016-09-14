package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C1548b extends br {
    public C1548b(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    private bz m6065a(AppLovinAdType appLovinAdType, AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize.equals(AppLovinAdSize.BANNER) ? bx.f254W : appLovinAdSize.equals(AppLovinAdSize.MREC) ? bx.f255X : appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL) ? bx.f256Y : appLovinAdSize.equals(AppLovinAdSize.LEADER) ? bx.f257Z : bx.f254W;
    }

    bw m6066a(C0231c c0231c) {
        bw cnVar = new cn(c0231c.m163a(), c0231c.m164b(), this, this.a);
        cnVar.m4236a(true);
        return cnVar;
    }

    C0231c m6067a(az azVar) {
        return new C0231c((AppLovinAd) azVar);
    }

    Map m6068a() {
        Map hashMap = new HashMap(5);
        for (AppLovinAdSize appLovinAdSize : AppLovinAdSize.allSizes()) {
            hashMap.put(new C0231c(appLovinAdSize, AppLovinAdType.REGULAR), new bs(((Integer) this.a.m4161a(m6065a(AppLovinAdType.REGULAR, appLovinAdSize))).intValue()));
        }
        hashMap.put(new C0231c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED), new bs(((Integer) this.a.m4161a(bx.aa)).intValue()));
        return hashMap;
    }

    public void m6069a(C0231c c0231c, int i) {
        m5647b(c0231c, i);
    }

    void m6070a(Object obj, az azVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) azVar);
    }

    void m6071a(Object obj, C0231c c0231c, int i) {
        if (obj instanceof C1181x) {
            ((C1181x) obj).m4307a(c0231c, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        m5649c((az) appLovinAd);
    }

    public /* bridge */ /* synthetic */ az m6073b(C0231c c0231c) {
        return super.m5645b(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6074b(C0231c c0231c, Object obj) {
        super.m5648b(c0231c, obj);
    }

    public /* bridge */ /* synthetic */ boolean m6075c(C0231c c0231c) {
        return super.m5650c(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6076d(C0231c c0231c) {
        super.m5651d(c0231c);
    }

    public /* bridge */ /* synthetic */ boolean m6077e(C0231c c0231c) {
        return super.m5652e(c0231c);
    }

    public /* bridge */ /* synthetic */ void m6078f(C0231c c0231c) {
        super.m5653f(c0231c);
    }

    public void failedToReceiveAd(int i) {
    }

    public void onNativeAdsFailedToLoad(int i) {
    }

    public void onNativeAdsLoaded(List list) {
    }
}
