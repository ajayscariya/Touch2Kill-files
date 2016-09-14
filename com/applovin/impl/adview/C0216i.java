package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAdDialog;

/* renamed from: com.applovin.impl.adview.i */
class C0216i implements Runnable {
    final /* synthetic */ AdViewControllerImpl f69a;

    private C0216i(AdViewControllerImpl adViewControllerImpl) {
        this.f69a = adViewControllerImpl;
    }

    public void run() {
        if (this.f69a.f3776n != null) {
            try {
                this.f69a.f3766d.m306d("AppLovinAdView", "Rendering interstitial ad for #" + this.f69a.f3776n.getAdIdNumber() + " over placement: \"" + this.f69a.f3768f + "\"...");
                AppLovinInterstitialAdDialog createInterstitialAdDialog = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f69a.f3764b, this.f69a.f3763a);
                createInterstitialAdDialog.setAdDisplayListener(new C1169d(this.f69a));
                createInterstitialAdDialog.setAdVideoPlaybackListener(new C1170e(this.f69a));
                createInterstitialAdDialog.setAdClickListener(new C1168c(this.f69a));
                createInterstitialAdDialog.showAndRender(this.f69a.f3776n, this.f69a.f3768f);
            } catch (Throwable th) {
            }
        }
    }
}
