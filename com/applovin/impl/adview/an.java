package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.android.volley.DefaultRetryPolicy;
import com.applovin.sdk.AppLovinSdk;

public class an extends C0227u {
    private float f3811c;
    private float f3812d;
    private float f3813e;
    private float f3814f;
    private float f3815g;

    public an(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
        this.f3811c = 30.0f;
        this.f3812d = 2.0f;
        this.f3813e = 8.0f;
        this.f3814f = 2.0f;
        this.f3815g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }

    protected float m4105a() {
        return this.f3811c * this.f3815g;
    }

    public void m4106a(float f) {
        this.f3815g = f;
    }

    public void m4107a(int i) {
        m4106a(((float) i) / this.f3811c);
    }

    protected float m4108b() {
        return this.f3813e * this.f3815g;
    }

    protected float m4109c() {
        return this.f3814f * this.f3815g;
    }

    protected float m4110d() {
        return m4105a() / 2.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = m4110d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Style.STROKE);
        paint2.setStrokeWidth(m4109c());
        float b = m4108b();
        float a = m4105a() - b;
        canvas.drawLine(b, b, a, a, paint2);
        canvas.drawLine(b, a, a, b, paint2);
    }
}
