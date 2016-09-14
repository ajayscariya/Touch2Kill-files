package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.e */
class C1175e implements AppLovinPostbackListener {
    final /* synthetic */ AdViewControllerImpl f3955a;
    final /* synthetic */ Uri f3956b;
    final /* synthetic */ AppLovinAdImpl f3957c;
    final /* synthetic */ AppLovinAdView f3958d;
    final /* synthetic */ AppLovinAdServiceImpl f3959e;

    C1175e(AppLovinAdServiceImpl appLovinAdServiceImpl, AdViewControllerImpl adViewControllerImpl, Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView) {
        this.f3959e = appLovinAdServiceImpl;
        this.f3955a = adViewControllerImpl;
        this.f3956b = uri;
        this.f3957c = appLovinAdImpl;
        this.f3958d = appLovinAdView;
    }

    public void onPostbackFailure(String str, int i) {
        this.f3959e.f3859c.post(new C0234g(this));
    }

    public void onPostbackSuccess(String str) {
        this.f3959e.f3859c.post(new C0233f(this));
    }
}
