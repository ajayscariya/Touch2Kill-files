package com.applovin.adview;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.applovin.adview.p */
class C0205p implements OnClickListener {
    final /* synthetic */ AppLovinInterstitialActivity f33a;

    C0205p(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f33a = appLovinInterstitialActivity;
    }

    public void onClick(View view) {
        this.f33a.dismiss();
    }
}
