package com.jirbo.adcolony;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

public class AdColonyOverlay extends ADCVideo {
    Rect f4917Z;
    int aa;

    /* renamed from: com.jirbo.adcolony.AdColonyOverlay.1 */
    class C06901 implements Runnable {
        final /* synthetic */ View f2329a;
        final /* synthetic */ AdColonyOverlay f2330b;

        C06901(AdColonyOverlay adColonyOverlay, View view) {
            this.f2330b = adColonyOverlay;
            this.f2329a = view;
        }

        public void run() {
            this.f2330b.P.removeView(this.f2329a);
        }
    }

    public AdColonyOverlay() {
        this.f4917Z = new Rect();
        this.aa = 0;
    }

    public void onConfigurationChanged(Configuration new_config) {
        super.onConfigurationChanged(new_config);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        this.t = defaultDisplay.getWidth();
        this.u = defaultDisplay.getHeight();
        C0694a.f2345K = true;
        View view = new View(this);
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (d && this.H.f2423Q) {
            this.Q.setLayoutParams(new LayoutParams(this.t, this.u - this.H.f2442m, 17));
            this.P.addView(view, new LayoutParams(this.t, this.u, 17));
            new Handler().postDelayed(new C06901(this, view), 1500);
        }
        this.H.m2490a();
    }
}
