package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.y */
class C1173y implements AppLovinAdDisplayListener {
    final /* synthetic */ ah f3838a;
    final /* synthetic */ C1172x f3839b;

    C1173y(C1172x c1172x, ah ahVar) {
        this.f3839b = c1172x;
        this.f3838a = ahVar;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        super.show();
        if (!this.f3839b.f3836j) {
            AppLovinAdDisplayListener d = this.f3838a.m4100d();
            if (d != null) {
                d.adDisplayed(appLovinAd);
            }
            this.f3839b.f3836j = true;
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f3839b.f3827a.runOnUiThread(this.f3839b.f3832f);
        AppLovinAdDisplayListener d = this.f3838a.m4100d();
        if (!(this.f3839b.f3837k || d == null)) {
            d.adHidden(appLovinAd);
            this.f3839b.f3837k = true;
        }
        this.f3838a.m4097a(false);
    }
}
