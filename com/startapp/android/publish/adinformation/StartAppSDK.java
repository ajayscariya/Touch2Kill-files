package com.startapp.android.publish.adinformation;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.startapp.android.publish.adinformation.AdInformationPositions.Position;
import com.startapp.android.publish.model.AdPreferences.Placement;

/* renamed from: com.startapp.android.publish.adinformation.c */
public class StartAppSDK extends RelativeLayout {
    private ImageView f3042a;
    private ImageView f3043b;
    private RelativeLayout f3044c;
    private OnClickListener f3045d;
    private OnClickListener f3046e;
    private AdInformationConfig f3047f;
    private StartAppSDK f3048g;
    private StartAppSDK f3049h;
    private StartAppSDK f3050i;
    private Placement f3051j;
    private boolean f3052k;
    private Handler f3053l;
    private Runnable f3054m;
    private Position f3055n;

    /* renamed from: com.startapp.android.publish.adinformation.c.1 */
    class StartAppSDK implements OnClickListener {
        final /* synthetic */ StartAppSDK f3037a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3037a = startAppSDK;
        }

        public void onClick(View v) {
            com.startapp.android.publish.p022h.StartAppSDK.m3219a(this.f3037a.getContext()).m3224a(new Intent("com.startapp.android.adInfoWasClickedBroadcastListener"));
            this.f3037a.m2865b();
        }
    }

    /* renamed from: com.startapp.android.publish.adinformation.c.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3038a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3038a = startAppSDK;
        }

        public void run() {
            if (this.f3038a.f3052k) {
                this.f3038a.f3052k = false;
                this.f3038a.m2867c();
            }
        }
    }

    /* renamed from: com.startapp.android.publish.adinformation.c.3 */
    class StartAppSDK implements OnClickListener {
        final /* synthetic */ OnClickListener f3039a;
        final /* synthetic */ StartAppSDK f3040b;

        StartAppSDK(StartAppSDK startAppSDK, OnClickListener onClickListener) {
            this.f3040b = startAppSDK;
            this.f3039a = onClickListener;
        }

        public void onClick(View v) {
            this.f3040b.f3052k = false;
            this.f3040b.f3053l.removeCallbacks(this.f3040b.f3054m);
            this.f3040b.m2867c();
            this.f3039a.onClick(v);
        }
    }

    /* renamed from: com.startapp.android.publish.adinformation.c.4 */
    class StartAppSDK implements AnimationListener {
        final /* synthetic */ StartAppSDK f3041a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3041a = startAppSDK;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f3041a.m2862a();
        }
    }

    public StartAppSDK(Context context, StartAppSDK startAppSDK, Placement placement, StartAppSDK startAppSDK2) {
        super(context);
        this.f3045d = new StartAppSDK(this);
        this.f3046e = null;
        this.f3050i = StartAppSDK.LARGE;
        this.f3052k = false;
        this.f3053l = new Handler();
        this.f3054m = new StartAppSDK(this);
        this.f3051j = placement;
        m2872a(startAppSDK, startAppSDK2);
    }

    protected void m2872a(StartAppSDK startAppSDK, StartAppSDK startAppSDK2) {
        setSize(startAppSDK);
        this.f3047f = StartAppSDK.m2838a(getContext());
        if (this.f3047f == null) {
            this.f3047f = AdInformationConfig.m2821a();
        }
        this.f3048g = this.f3047f.m2824a(startAppSDK.m2835a());
        this.f3049h = this.f3047f.m2824a(startAppSDK.m2836b());
        if (startAppSDK2 == null || !startAppSDK2.m2860d()) {
            this.f3055n = this.f3047f.m2823a(this.f3051j);
        } else {
            this.f3055n = startAppSDK2.m2859c();
        }
        this.f3042a = new ImageView(getContext());
        this.f3042a.setContentDescription("info");
        this.f3042a.setId(com.startapp.android.publish.StartAppSDK.AD_INFORMATION_ID);
        this.f3043b = new ImageView(getContext());
        this.f3043b.setContentDescription("infoExtended");
        this.f3043b.setId(com.startapp.android.publish.StartAppSDK.AD_INFORMATION_EXTENDED_ID);
        this.f3042a.setImageBitmap(this.f3048g.m2874a(getContext()));
        this.f3043b.setImageBitmap(this.f3049h.m2874a(getContext()));
        this.f3044c = new RelativeLayout(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((float) this.f3048g.m2879b()) * this.f3047f.m2829c())), com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((float) this.f3048g.m2883c()) * this.f3047f.m2829c())));
        this.f3044c.setBackgroundColor(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), this.f3048g.m2879b()), com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), this.f3048g.m2883c()));
        layoutParams2.setMargins(0, 0, 0, 0);
        this.f3042a.setPadding(0, 0, 0, 0);
        this.f3055n.addRules(layoutParams2);
        this.f3044c.addView(this.f3042a, layoutParams2);
        m2862a();
        addView(this.f3044c, layoutParams);
    }

    private void m2862a() {
        this.f3044c.setOnClickListener(this.f3045d);
        this.f3044c.removeView(this.f3043b);
        com.startapp.android.publish.p022h.StartAppSDK.m3171a(this.f3043b, this.f3042a);
    }

    private void m2865b() {
        this.f3044c.setOnClickListener(this.f3046e);
        StartAppSDK a = this.f3047f.m2824a(this.f3050i.m2835a());
        StartAppSDK a2 = this.f3047f.m2824a(this.f3050i.m2836b());
        this.f3044c.getLayoutParams().width = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), a2.m2879b());
        this.f3044c.getLayoutParams().height = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((float) a2.m2883c()) * this.f3047f.m2829c()));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), a2.m2879b()), com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), a2.m2883c()));
        layoutParams.setMargins(0, 0, 0, 0);
        this.f3043b.setPadding(0, 0, 0, 0);
        this.f3055n.addRules(layoutParams);
        Animation translateAnimation = new TranslateAnimation(0, (float) com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), this.f3055n.getAnimationStartMultiplier() * (a2.m2879b() - a.m2879b())), 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(800);
        this.f3044c.addView(this.f3043b, layoutParams);
        this.f3042a.setVisibility(8);
        this.f3043b.startAnimation(translateAnimation);
        this.f3052k = true;
        this.f3053l.removeCallbacks(this.f3054m);
        this.f3053l.postDelayed(this.f3054m, 4000);
    }

    protected void setOnInfoClickListener(OnClickListener listener) {
        this.f3046e = new StartAppSDK(this, listener);
    }

    public void setSize(StartAppSDK size) {
        this.f3050i = size;
    }

    private void m2867c() {
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), this.f3055n.getAnimationStartMultiplier() * (this.f3049h.m2879b() - this.f3048g.m2879b())), 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(800);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new StartAppSDK(this));
        this.f3043b.startAnimation(translateAnimation);
    }
}
