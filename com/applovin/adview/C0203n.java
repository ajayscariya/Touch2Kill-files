package com.applovin.adview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.volley.DefaultRetryPolicy;

/* renamed from: com.applovin.adview.n */
class C0203n implements OnClickListener {
    final /* synthetic */ AppLovinInterstitialActivity f30a;

    C0203n(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f30a = appLovinInterstitialActivity;
    }

    public void onClick(View view) {
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f30a.f3740f.getLogger().m306d("AppLovinInterstitialActivity", "Video view tapped!");
        if (this.f30a.f3739e.m214z() && this.f30a.f3731B != null && this.f30a.f3731B.getVisibility() != 8) {
            boolean z = this.f30a.f3731B.getVisibility() == 4;
            float f2 = z ? 0.0f : DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            if (!z) {
                f = 0.0f;
            }
            Animation alphaAnimation = new AlphaAnimation(f2, f);
            alphaAnimation.setDuration(750);
            alphaAnimation.setAnimationListener(new C0204o(this, z));
            this.f30a.f3731B.startAnimation(alphaAnimation);
        }
    }
}
