package com.applovin.adview;

import android.app.Activity;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.adview.u */
final class C0210u implements Runnable {
    final /* synthetic */ AppLovinSdk f38a;
    final /* synthetic */ Activity f39b;
    final /* synthetic */ String f40c;

    C0210u(AppLovinSdk appLovinSdk, Activity activity, String str) {
        this.f38a = appLovinSdk;
        this.f39b = activity;
        this.f40c = str;
    }

    public void run() {
        new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f38a, this.f39b).show(this.f40c);
    }
}
