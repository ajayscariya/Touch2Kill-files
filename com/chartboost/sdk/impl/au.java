package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.Libraries.CBUtility;

public final class au extends bk {
    private RectF f4098b;
    private Paint f4099c;
    private Paint f4100d;
    private BitmapShader f4101e;
    private float f4102f;

    public au(Context context) {
        super(context);
        this.f4102f = 0.0f;
        m4519a(context);
    }

    private void m4519a(Context context) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4098b = new RectF();
        this.f4099c = new Paint();
        this.f4099c.setStyle(Style.STROKE);
        this.f4099c.setStrokeWidth(Math.max(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, f * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.f4099c.setAntiAlias(true);
    }

    public void m4521a(int i) {
        this.f4099c.setColor(i);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        float a = CBUtility.m388a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, getContext());
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.f4101e == null) {
                if (bitmap != null) {
                    this.f4101e = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
                    this.f4100d = new Paint();
                    this.f4100d.setAntiAlias(true);
                    this.f4100d.setShader(this.f4101e);
                } else {
                    postInvalidate();
                    return;
                }
            }
            float max = Math.max(((float) getWidth()) / ((float) bitmap.getWidth()), ((float) getHeight()) / ((float) bitmap.getHeight()));
            canvas.save();
            canvas.scale(max, max);
            this.f4098b.set(0.0f, 0.0f, ((float) getWidth()) / max, ((float) getHeight()) / max);
            this.f4098b.inset(a / (max * 2.0f), a / (max * 2.0f));
            canvas.drawRoundRect(this.f4098b, this.f4098b.width() * this.f4102f, this.f4098b.height() * this.f4102f, this.f4100d);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        this.f4098b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f4098b.inset(a / 2.0f, a / 2.0f);
        canvas.drawRoundRect(this.f4098b, this.f4098b.width() * this.f4102f, this.f4098b.height() * this.f4102f, this.f4099c);
    }

    public void m4520a(float f) {
        this.f4102f = f;
        invalidate();
    }
}
