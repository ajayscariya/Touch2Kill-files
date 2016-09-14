package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import com.android.volley.DefaultRetryPolicy;
import com.applovin.sdk.AppLovinSdk;

public class ao extends C0227u {
    private float f3816c;
    private float f3817d;
    private float f3818e;
    private float f3819f;
    private float f3820g;

    public ao(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
        this.f3816c = 30.0f;
        this.f3817d = 2.0f;
        this.f3818e = 10.0f;
        this.f3819f = 3.0f;
        this.f3820g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }

    protected float m4111a() {
        return this.f3816c * this.f3820g;
    }

    public void m4112a(float f) {
        this.f3820g = f;
    }

    public void m4113a(int i) {
        m4112a(((float) i) / this.f3816c);
    }

    protected float m4114b() {
        return this.f3818e * this.f3820g;
    }

    protected float m4115c() {
        return this.f3819f * this.f3820g;
    }

    protected float m4116d() {
        return m4111a() / 2.0f;
    }

    protected float m4117e() {
        return this.f3817d * this.f3820g;
    }

    protected float m4118f() {
        return m4116d() - m4117e();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = m4116d();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(d, d, m4118f(), paint2);
        Paint paint3 = new Paint(paint);
        paint3.setStyle(Style.STROKE);
        paint3.setStrokeWidth(m4115c());
        float b = m4114b();
        float a = m4111a() - b;
        canvas.drawLine(b, b, a, a, paint3);
        canvas.drawLine(b, a, a, b, paint3);
    }
}
