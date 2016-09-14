package com.startapp.android.publish.inappbrowser;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

/* renamed from: com.startapp.android.publish.inappbrowser.a */
public class StartAppSDK extends ProgressBar {
    private static final Interpolator f3391a;
    private ValueAnimator f3392b;
    private boolean f3393c;

    /* renamed from: com.startapp.android.publish.inappbrowser.a.1 */
    class StartAppSDK implements AnimatorUpdateListener {
        Integer f3389a;
        final /* synthetic */ StartAppSDK f3390b;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3390b = startAppSDK;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            this.f3389a = (Integer) animation.getAnimatedValue();
            super.setProgress(this.f3389a.intValue());
        }
    }

    static {
        f3391a = new AccelerateDecelerateInterpolator();
    }

    public StartAppSDK(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet, i);
        this.f3393c = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        this.f3393c = z;
    }

    public void setProgress(int progress) {
        if (this.f3393c) {
            if (this.f3392b != null) {
                this.f3392b.cancel();
                if (getProgress() >= progress) {
                    return;
                }
            }
            this.f3392b = ValueAnimator.ofInt(new int[]{getProgress(), progress});
            this.f3392b.setInterpolator(f3391a);
            this.f3392b.addUpdateListener(new StartAppSDK(this));
            this.f3392b.setIntValues(new int[]{getProgress(), progress});
            this.f3392b.start();
            return;
        }
        super.setProgress(progress);
    }

    protected ValueAnimator getAnimator() {
        return this.f3392b;
    }

    public void m3373a() {
        super.setProgress(0);
        if (this.f3392b != null) {
            this.f3392b.cancel();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3392b != null) {
            this.f3392b.cancel();
        }
    }
}
