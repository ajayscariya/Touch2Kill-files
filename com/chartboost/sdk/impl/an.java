package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;
import com.android.volley.DefaultRetryPolicy;

public class an extends LinearLayout {
    private Paint f795a;
    private float f796b;
    private int f797c;

    public an(Context context) {
        super(context);
        this.f796b = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f797c = 0;
        int round = Math.round(context.getResources().getDisplayMetrics().density * 5.0f);
        setPadding(round, round, round, round);
        setBaselineAligned(false);
        this.f795a = new Paint();
        this.f795a.setStyle(Style.FILL);
    }

    public void m809a(int i) {
        this.f795a.setColor(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = getContext().getResources().getDisplayMetrics().density;
        if ((this.f797c & 1) > 0) {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), this.f796b * f, this.f795a);
        }
        if ((this.f797c & 2) > 0) {
            canvas.drawRect(((float) canvas.getWidth()) - (this.f796b * f), 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f795a);
        }
        if ((this.f797c & 4) > 0) {
            canvas.drawRect(0.0f, ((float) canvas.getHeight()) - (this.f796b * f), (float) canvas.getWidth(), (float) canvas.getHeight(), this.f795a);
        }
        if ((this.f797c & 8) > 0) {
            canvas.drawRect(0.0f, 0.0f, this.f796b * f, (float) canvas.getHeight(), this.f795a);
        }
    }

    public void m810b(int i) {
        this.f797c = i;
    }
}
