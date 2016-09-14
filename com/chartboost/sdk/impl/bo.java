package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public abstract class bo extends View {
    private Bitmap f1019a;
    private Canvas f1020b;

    protected abstract void m1036a(Canvas canvas);

    public bo(Context context) {
        super(context);
        this.f1019a = null;
        this.f1020b = null;
        m1034a(context);
    }

    private void m1034a(Context context) {
        try {
            getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
        } catch (Exception e) {
        }
    }

    private boolean m1035b(Canvas canvas) {
        try {
            return ((Boolean) Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(canvas, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    protected final void onDraw(Canvas canvas) {
        Canvas canvas2;
        boolean b = m1035b(canvas);
        if (b) {
            if (!(this.f1019a != null && this.f1019a.getWidth() == canvas.getWidth() && this.f1019a.getHeight() == canvas.getHeight())) {
                if (!(this.f1019a == null || this.f1019a.isRecycled())) {
                    this.f1019a.recycle();
                }
                try {
                    this.f1019a = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
                    this.f1020b = new Canvas(this.f1019a);
                } catch (Throwable th) {
                    return;
                }
            }
            this.f1019a.eraseColor(0);
            Canvas canvas3 = canvas;
            canvas = this.f1020b;
            canvas2 = canvas3;
        } else {
            canvas2 = null;
        }
        m1036a(canvas);
        if (b && canvas2 != null) {
            canvas2.drawBitmap(this.f1019a, 0.0f, 0.0f, null);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!(this.f1019a == null || this.f1019a.isRecycled())) {
            this.f1019a.recycle();
        }
        this.f1019a = null;
    }
}
