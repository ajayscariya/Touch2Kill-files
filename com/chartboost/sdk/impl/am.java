package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public abstract class am extends RelativeLayout {
    private static final String f791b;
    protected ai f792a;
    private an f793c;
    private C0332a f794d;

    /* renamed from: com.chartboost.sdk.impl.am.1 */
    class C03301 implements Runnable {
        final /* synthetic */ boolean f783a;
        final /* synthetic */ am f784b;

        C03301(am amVar, boolean z) {
            this.f784b = amVar;
            this.f783a = z;
        }

        public void run() {
            if (!this.f783a) {
                this.f784b.setVisibility(8);
                this.f784b.clearAnimation();
            }
            this.f784b.f792a.h.remove(Integer.valueOf(hashCode()));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.am.2 */
    static /* synthetic */ class C03312 {
        static final /* synthetic */ int[] f785a;

        static {
            f785a = new int[C0332a.values().length];
            try {
                f785a[C0332a.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f785a[C0332a.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f785a[C0332a.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f785a[C0332a.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.am.a */
    public enum C0332a {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    protected abstract View m805a();

    protected abstract int m808b();

    static {
        f791b = am.class.getSimpleName();
    }

    public am(Context context, ai aiVar) {
        super(context);
        this.f792a = aiVar;
        this.f794d = C0332a.BOTTOM;
        m803a(context);
    }

    public void m806a(C0332a c0332a) {
        if (c0332a == null) {
            CBLogging.m381b(f791b, "Side object cannot be null");
            return;
        }
        this.f794d = c0332a;
        LayoutParams layoutParams = null;
        setClickable(false);
        int b = m808b();
        switch (C03312.f785a[this.f794d.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.m390a(b, getContext()));
                layoutParams.addRule(10);
                this.f793c.m810b(1);
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                layoutParams = new RelativeLayout.LayoutParams(-1, CBUtility.m390a(b, getContext()));
                layoutParams.addRule(12);
                this.f793c.m810b(4);
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                layoutParams = new RelativeLayout.LayoutParams(CBUtility.m390a(b, getContext()), -1);
                layoutParams.addRule(9);
                this.f793c.m810b(8);
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                layoutParams = new RelativeLayout.LayoutParams(CBUtility.m390a(b, getContext()), -1);
                layoutParams.addRule(11);
                this.f793c.m810b(2);
                break;
        }
        setLayoutParams(layoutParams);
    }

    private void m803a(Context context) {
        Context context2 = getContext();
        setGravity(17);
        this.f793c = new an(context2);
        this.f793c.m809a(-1);
        this.f793c.setBackgroundColor(-855638017);
        addView(this.f793c, new RelativeLayout.LayoutParams(-1, -1));
        addView(m805a(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void m807a(boolean z) {
        m804a(z, 500);
    }

    private void m804a(boolean z, long j) {
        this.f792a.f4872z = z;
        if (!z || getVisibility() != 0) {
            if (z || getVisibility() != 8) {
                Animation translateAnimation;
                Runnable c03301 = new C03301(this, z);
                if (z) {
                    setVisibility(0);
                }
                float a = CBUtility.m388a((float) m808b(), getContext());
                float f;
                switch (C03312.f785a[this.f794d.ordinal()]) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        if (z) {
                            f = -a;
                        } else {
                            f = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, z ? 0.0f : -a);
                        break;
                    case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                        if (z) {
                            f = a;
                        } else {
                            f = 0.0f;
                        }
                        if (z) {
                            a = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, a);
                        break;
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        if (z) {
                            f = -a;
                        } else {
                            f = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(f, z ? 0.0f : -a, 0.0f, 0.0f);
                        break;
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        f = z ? a : 0.0f;
                        if (z) {
                            a = 0.0f;
                        }
                        translateAnimation = new TranslateAnimation(f, a, 0.0f, 0.0f);
                        break;
                    default:
                        translateAnimation = null;
                        break;
                }
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(!z);
                startAnimation(translateAnimation);
                this.f792a.h.put(Integer.valueOf(hashCode()), c03301);
                C0320g.f749a.postDelayed(c03301, j);
            }
        }
    }
}
