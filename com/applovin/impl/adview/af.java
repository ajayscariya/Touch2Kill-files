package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.volley.DefaultRetryPolicy;
import com.applovin.impl.sdk.cb;

class af implements Runnable {
    final /* synthetic */ C1172x f51a;

    af(C1172x c1172x) {
        this.f51a = c1172x;
    }

    public void run() {
        try {
            this.f51a.f3833g.setVisibility(0);
            this.f51a.f3833g.bringToFront();
            cb cbVar = new cb(this.f51a.f3828b);
            Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            alphaAnimation.setDuration((long) cbVar.m193e());
            alphaAnimation.setRepeatCount(0);
            this.f51a.f3833g.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f51a.dismiss();
        }
    }
}
