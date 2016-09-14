package com.applovin.adview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.applovin.adview.o */
class C0204o implements AnimationListener {
    final /* synthetic */ boolean f31a;
    final /* synthetic */ C0203n f32b;

    C0204o(C0203n c0203n, boolean z) {
        this.f32b = c0203n;
        this.f31a = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f31a) {
            this.f32b.f30a.f3731B.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f32b.f30a.f3731B.setVisibility(0);
    }
}
