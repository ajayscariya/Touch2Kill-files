package com.chartboost.sdk.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0315f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0288c;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class bi {

    /* renamed from: com.chartboost.sdk.impl.bi.1 */
    static class C03791 implements OnGlobalLayoutListener {
        final /* synthetic */ View f974a;
        final /* synthetic */ C0383b f975b;
        final /* synthetic */ C0291a f976c;
        final /* synthetic */ C0382a f977d;
        final /* synthetic */ boolean f978e;

        C03791(View view, C0383b c0383b, C0291a c0291a, C0382a c0382a, boolean z) {
            this.f974a = view;
            this.f975b = c0383b;
            this.f976c = c0291a;
            this.f977d = c0382a;
            this.f978e = z;
        }

        public void onGlobalLayout() {
            this.f974a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            bi.m1008c(this.f975b, this.f976c, this.f977d, this.f978e);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bi.2 */
    static class C03802 implements Runnable {
        final /* synthetic */ C0382a f979a;
        final /* synthetic */ C0291a f980b;

        C03802(C0382a c0382a, C0291a c0291a) {
            this.f979a = c0382a;
            this.f980b = c0291a;
        }

        public void run() {
            this.f979a.m1000a(this.f980b);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bi.3 */
    static /* synthetic */ class C03813 {
        static final /* synthetic */ int[] f981a;

        static {
            f981a = new int[C0383b.values().length];
            try {
                f981a[C0383b.CBAnimationTypeFade.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f981a[C0383b.CBAnimationTypePerspectiveZoom.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f981a[C0383b.CBAnimationTypePerspectiveRotate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f981a[C0383b.CBAnimationTypeSlideFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f981a[C0383b.CBAnimationTypeSlideFromTop.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f981a[C0383b.CBAnimationTypeSlideFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f981a[C0383b.CBAnimationTypeSlideFromRight.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f981a[C0383b.CBAnimationTypeBounce.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bi.a */
    public interface C0382a {
        void m1000a(C0291a c0291a);
    }

    /* renamed from: com.chartboost.sdk.impl.bi.b */
    public enum C0383b {
        CBAnimationTypePerspectiveRotate,
        CBAnimationTypeBounce,
        CBAnimationTypePerspectiveZoom,
        CBAnimationTypeSlideFromTop,
        CBAnimationTypeSlideFromBottom,
        CBAnimationTypeFade,
        CBAnimationTypeNone,
        CBAnimationTypeSlideFromLeft,
        CBAnimationTypeSlideFromRight;

        public static C0383b m1001a(int i) {
            if (i != 0 && i > 0 && i <= C0383b.values().length) {
                return C0383b.values()[i - 1];
            }
            return null;
        }
    }

    public static void m1002a(C0383b c0383b, C0291a c0291a, C0382a c0382a) {
        m1007b(c0383b, c0291a, c0382a, true);
    }

    public static void m1006b(C0383b c0383b, C0291a c0291a, C0382a c0382a) {
        m1008c(c0383b, c0291a, c0382a, false);
    }

    private static void m1007b(C0383b c0383b, C0291a c0291a, C0382a c0382a, boolean z) {
        if (c0383b == C0383b.CBAnimationTypeNone) {
            if (c0382a != null) {
                c0382a.m1000a(c0291a);
            }
        } else if (c0291a == null || c0291a.f604i == null) {
            CBLogging.m379a("AnimationManager", "Transition of impression canceled due to lack of container");
        } else {
            View f = c0291a.f604i.m1044f();
            if (f == null) {
                C0315f.m744a().m753d(c0291a);
                CBLogging.m379a("AnimationManager", "Transition of impression canceled due to lack of view");
                return;
            }
            ViewTreeObserver viewTreeObserver = f.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new C03791(f, c0383b, c0291a, c0382a, z));
            }
        }
    }

    private static void m1008c(C0383b c0383b, C0291a c0291a, C0382a c0382a, boolean z) {
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        if (c0291a == null || c0291a.f604i == null) {
            CBLogging.m379a("AnimationManager", "Transition of impression canceled due to lack of container");
            return;
        }
        View f = c0291a.f604i.m1044f();
        if (f == null) {
            CBLogging.m379a("AnimationManager", "Transition of impression canceled due to lack of view");
            return;
        }
        View view;
        long j;
        Animation alphaAnimation;
        if (c0291a.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO || c0291a.f601f == C0288c.INTERSTITIAL_VIDEO) {
            view = c0291a.f604i;
        } else {
            view = f;
        }
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        float f2 = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - 0.4f) / 2.0f;
        if (c0291a.f596a == C0287b.WEB) {
            j = 1000;
        } else {
            j = 500;
        }
        float f3;
        float f4;
        Animation translateAnimation;
        switch (C03813.f981a[c0383b.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (z) {
                    alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                } else {
                    alphaAnimation = new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                Animation animationSet2 = new AnimationSet(true);
                animationSet2.addAnimation(alphaAnimation);
                alphaAnimation = animationSet2;
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (z) {
                    alphaAnimation = new bn(-1114636288, 0.0f, width / 2.0f, height / 2.0f, false);
                } else {
                    alphaAnimation = new bn(0.0f, 60.0f, width / 2.0f, height / 2.0f, false);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                if (z) {
                    alphaAnimation = new ScaleAnimation(0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                } else {
                    alphaAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                if (z) {
                    alphaAnimation = new TranslateAnimation(width * f2, 0.0f, (-height) * 0.4f, 0.0f);
                } else {
                    alphaAnimation = new TranslateAnimation(0.0f, width * f2, 0.0f, height);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation = animationSet;
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                if (z) {
                    alphaAnimation = new bn(-1114636288, 0.0f, width / 2.0f, height / 2.0f, true);
                } else {
                    alphaAnimation = new bn(0.0f, 60.0f, width / 2.0f, height / 2.0f, true);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                if (z) {
                    alphaAnimation = new ScaleAnimation(0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                } else {
                    alphaAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.4f);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                if (z) {
                    alphaAnimation = new TranslateAnimation((-width) * 0.4f, 0.0f, height * f2, 0.0f);
                } else {
                    alphaAnimation = new TranslateAnimation(0.0f, width, 0.0f, height * f2);
                }
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation = animationSet;
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                f3 = z ? height : 0.0f;
                if (z) {
                    f4 = 0.0f;
                } else {
                    f4 = height;
                }
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, f3, f4);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                alphaAnimation = animationSet;
                break;
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, z ? -height : 0.0f, z ? 0.0f : -height);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                alphaAnimation = animationSet;
                break;
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                f3 = z ? width : 0.0f;
                if (z) {
                    f4 = 0.0f;
                } else {
                    f4 = width;
                }
                translateAnimation = new TranslateAnimation(f3, f4, 0.0f, 0.0f);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                alphaAnimation = animationSet;
                break;
            case ConnectionResult.NETWORK_ERROR /*7*/:
                translateAnimation = new TranslateAnimation(z ? -width : 0.0f, z ? 0.0f : -width, 0.0f, 0.0f);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                alphaAnimation = animationSet;
                break;
            case ConnectionResult.INTERNAL_ERROR /*8*/:
                if (!z) {
                    alphaAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, 1, 0.5f, 1, 0.5f);
                    alphaAnimation.setDuration(j);
                    alphaAnimation.setStartOffset(0);
                    alphaAnimation.setFillAfter(true);
                    animationSet.addAnimation(alphaAnimation);
                    alphaAnimation = animationSet;
                    break;
                }
                alphaAnimation = new ScaleAnimation(0.6f, 1.1f, 0.6f, 1.1f, 1, 0.5f, 1, 0.5f);
                alphaAnimation.setDuration((long) Math.round(((float) j) * 0.6f));
                alphaAnimation.setStartOffset(0);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.81818175f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.81818175f, 1, 0.5f, 1, 0.5f);
                alphaAnimation.setDuration((long) Math.round(((float) j) * 0.19999999f));
                alphaAnimation.setStartOffset((long) Math.round(((float) j) * 0.6f));
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.1111112f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.1111112f, 1, 0.5f, 1, 0.5f);
                alphaAnimation.setDuration((long) Math.round(((float) j) * 0.099999964f));
                alphaAnimation.setStartOffset((long) Math.round(((float) j) * 0.8f));
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation = animationSet;
                break;
            default:
                alphaAnimation = animationSet;
                break;
        }
        if (c0383b != C0383b.CBAnimationTypeNone) {
            if (c0382a != null) {
                CBUtility.m400e().postDelayed(new C03802(c0382a, c0291a), j);
            }
            view.startAnimation(alphaAnimation);
        } else if (c0382a != null) {
            c0382a.m1000a(c0291a);
        }
    }

    public static void m1004a(boolean z, View view) {
        long j = 500;
        if (C0299c.m632F().booleanValue()) {
            j = 1000;
        }
        m1005a(z, view, j);
    }

    public static void m1005a(boolean z, View view, long j) {
        float f;
        float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        view.clearAnimation();
        if (z) {
            view.setVisibility(0);
        }
        if (z) {
            f = 0.0f;
        } else {
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        if (!z) {
            f2 = 0.0f;
        }
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillBefore(true);
        view.startAnimation(alphaAnimation);
    }
}
