package com.inmobi.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.android.volley.DefaultRetryPolicy;
import com.inmobi.ads.InMobiBanner.AnimationType;

/* renamed from: com.inmobi.ads.i */
class AnimationController {

    /* renamed from: com.inmobi.ads.i.a */
    static class AnimationController extends Animation {
        private final float f1470a;
        private final float f1471b;
        private final float f1472c;
        private final float f1473d;
        private final float f1474e;
        private final boolean f1475f;
        private Camera f1476g;

        public AnimationController(float f, float f2, float f3, float f4, float f5, boolean z) {
            this.f1470a = f;
            this.f1471b = f2;
            this.f1472c = f3;
            this.f1473d = f4;
            this.f1474e = f5;
            this.f1475f = z;
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f1476g = new Camera();
        }

        protected void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f1470a;
            f2 += (this.f1471b - f2) * f;
            float f3 = this.f1472c;
            float f4 = this.f1473d;
            Camera camera = this.f1476g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f1475f) {
                camera.translate(0.0f, 0.0f, this.f1474e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f1474e * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f));
            }
            camera.rotateX(f2);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f3, -f4);
            matrix.postTranslate(f3, f4);
        }
    }

    /* renamed from: com.inmobi.ads.i.b */
    static class AnimationController extends Animation {
        private final float f1477a;
        private final float f1478b;
        private final float f1479c;
        private final float f1480d;
        private final float f1481e;
        private final boolean f1482f;
        private Camera f1483g;

        public AnimationController(float f, float f2, float f3, float f4, float f5, boolean z) {
            this.f1477a = f;
            this.f1478b = f2;
            this.f1479c = f3;
            this.f1480d = f4;
            this.f1481e = f5;
            this.f1482f = z;
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.f1483g = new Camera();
        }

        protected void applyTransformation(float f, Transformation transformation) {
            float f2 = this.f1477a;
            f2 += (this.f1478b - f2) * f;
            float f3 = this.f1479c;
            float f4 = this.f1480d;
            Camera camera = this.f1483g;
            Matrix matrix = transformation.getMatrix();
            camera.save();
            if (this.f1482f) {
                camera.translate(0.0f, 0.0f, this.f1481e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f1481e * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f));
            }
            camera.rotateY(f2);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f3, -f4);
            matrix.postTranslate(f3, f4);
        }
    }

    static Animation m1531a(AnimationType animationType, float f, float f2) {
        Animation alphaAnimation;
        if (animationType == AnimationType.ANIMATION_ALPHA) {
            alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
            alphaAnimation.setDuration(1000);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            return alphaAnimation;
        } else if (animationType == AnimationType.ROTATE_HORIZONTAL_AXIS) {
            alphaAnimation = new AnimationController(0.0f, 90.0f, f / 2.0f, f2 / 2.0f, 0.0f, true);
            alphaAnimation.setDuration(500);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            return alphaAnimation;
        } else if (animationType != AnimationType.ROTATE_VERTICAL_AXIS) {
            return null;
        } else {
            alphaAnimation = new AnimationController(0.0f, 90.0f, f / 2.0f, f2 / 2.0f, 0.0f, true);
            alphaAnimation.setDuration(500);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            return alphaAnimation;
        }
    }
}
