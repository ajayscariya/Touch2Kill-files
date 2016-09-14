package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class bn extends Animation {
    private final float f1013a;
    private final float f1014b;
    private final float f1015c;
    private final float f1016d;
    private boolean f1017e;
    private Camera f1018f;

    public bn(float f, float f2, float f3, float f4, boolean z) {
        this.f1017e = true;
        this.f1013a = f;
        this.f1014b = f2;
        this.f1015c = f3;
        this.f1016d = f4;
        this.f1017e = z;
    }

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.f1018f = new Camera();
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float f = this.f1013a + ((this.f1014b - this.f1013a) * interpolatedTime);
        Camera camera = this.f1018f;
        Matrix matrix = t.getMatrix();
        camera.save();
        if (this.f1017e) {
            camera.rotateY(f);
        } else {
            camera.rotateX(f);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.f1015c, -this.f1016d);
        matrix.postTranslate(this.f1015c, this.f1016d);
    }
}
