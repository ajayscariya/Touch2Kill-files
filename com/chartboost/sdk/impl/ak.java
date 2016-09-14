package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.android.volley.DefaultRetryPolicy;

public class ak extends bo {
    private Paint f4073a;
    private Paint f4074b;
    private Path f4075c;
    private RectF f4076d;
    private RectF f4077e;
    private int f4078f;
    private float f4079g;
    private float f4080h;

    public ak(Context context) {
        super(context);
        this.f4078f = 0;
        m4497a(context);
    }

    private void m4497a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f4079g = 4.5f * f;
        this.f4073a = new Paint();
        this.f4073a.setColor(-1);
        this.f4073a.setStyle(Style.STROKE);
        this.f4073a.setStrokeWidth(f * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f4073a.setAntiAlias(true);
        this.f4074b = new Paint();
        this.f4074b.setColor(-855638017);
        this.f4074b.setStyle(Style.FILL);
        this.f4074b.setAntiAlias(true);
        this.f4075c = new Path();
        this.f4077e = new RectF();
        this.f4076d = new RectF();
    }

    protected void m4500a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4076d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        int min = Math.min(1, Math.round(f * 0.5f));
        this.f4076d.inset((float) min, (float) min);
        this.f4075c.reset();
        this.f4075c.addRoundRect(this.f4076d, this.f4079g, this.f4079g, Direction.CW);
        canvas.save();
        canvas.clipPath(this.f4075c);
        canvas.drawColor(this.f4078f);
        this.f4077e.set(this.f4076d);
        this.f4077e.right = ((this.f4077e.right - this.f4077e.left) * this.f4080h) + this.f4077e.left;
        canvas.drawRect(this.f4077e, this.f4074b);
        canvas.restore();
        canvas.drawRoundRect(this.f4076d, this.f4079g, this.f4079g, this.f4073a);
    }

    public void m4499a(int i) {
        this.f4078f = i;
        invalidate();
    }

    public void m4502b(int i) {
        this.f4073a.setColor(i);
        invalidate();
    }

    public void m4503c(int i) {
        this.f4074b.setColor(i);
        invalidate();
    }

    public void m4498a(float f) {
        this.f4080h = f;
        if (getVisibility() != 8) {
            invalidate();
        }
    }

    public void m4501b(float f) {
        this.f4079g = f;
    }
}
