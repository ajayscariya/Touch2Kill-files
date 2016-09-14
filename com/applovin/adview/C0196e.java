package com.applovin.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.volley.DefaultRetryPolicy;

/* renamed from: com.applovin.adview.e */
class C0196e implements Runnable {
    final /* synthetic */ AppLovinInterstitialActivity f18a;

    C0196e(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f18a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (this.f18a.f3748n) {
                this.f18a.f3758x.setVisibility(0);
                return;
            }
            this.f18a.f3748n = true;
            if (this.f18a.m4031j() && this.f18a.f3759y != null) {
                this.f18a.f3759y.setVisibility(0);
                this.f18a.f3759y.bringToFront();
            }
            this.f18a.f3758x.setVisibility(0);
            this.f18a.f3758x.bringToFront();
            Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            alphaAnimation.setDuration((long) this.f18a.f3739e.m193e());
            alphaAnimation.setRepeatCount(0);
            this.f18a.f3758x.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f18a.dismiss();
        }
    }
}
