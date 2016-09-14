package com.applovin.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.volley.DefaultRetryPolicy;

/* renamed from: com.applovin.adview.f */
class C0197f implements Runnable {
    final /* synthetic */ AppLovinInterstitialActivity f19a;

    C0197f(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f19a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (!this.f19a.f3749o && this.f19a.f3760z != null) {
                this.f19a.f3749o = true;
                this.f19a.f3760z.setVisibility(0);
                Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                alphaAnimation.setDuration((long) this.f19a.f3739e.m193e());
                alphaAnimation.setRepeatCount(0);
                this.f19a.f3760z.startAnimation(alphaAnimation);
                if (this.f19a.m4031j() && this.f19a.f3730A != null) {
                    this.f19a.f3730A.setVisibility(0);
                    this.f19a.f3730A.bringToFront();
                }
            }
        } catch (Throwable th) {
            this.f19a.f3738d.m310w("AppLovinInterstitialActivity", "Unable to show skip button: " + th);
        }
    }
}
