package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBUtility;

public final class br extends bo {
    private static Handler f4194a;
    private float f4195b;
    private long f4196c;
    private Paint f4197d;
    private Paint f4198e;
    private Path f4199f;
    private Path f4200g;
    private RectF f4201h;
    private RectF f4202i;
    private Runnable f4203j;

    /* renamed from: com.chartboost.sdk.impl.br.1 */
    class C03911 implements Runnable {
        final /* synthetic */ br f1028a;

        C03911(br brVar) {
            this.f1028a = brVar;
        }

        public void run() {
            float f = this.f1028a.getContext().getResources().getDisplayMetrics().density;
            br.m4665a(this.f1028a, (60.0f * f) * 0.016666668f);
            f = ((float) this.f1028a.getHeight()) - (f * 9.0f);
            if (this.f1028a.f4195b > f) {
                br.m4667b(this.f1028a, f * 2.0f);
            }
            if (this.f1028a.getWindowVisibility() == 0) {
                this.f1028a.invalidate();
            }
        }
    }

    static /* synthetic */ float m4665a(br brVar, float f) {
        float f2 = brVar.f4195b + f;
        brVar.f4195b = f2;
        return f2;
    }

    static /* synthetic */ float m4667b(br brVar, float f) {
        float f2 = brVar.f4195b - f;
        brVar.f4195b = f2;
        return f2;
    }

    static {
        f4194a = CBUtility.m400e();
    }

    public br(Context context) {
        super(context);
        this.f4203j = new C03911(this);
        m4666a(context);
    }

    private void m4666a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f4195b = 0.0f;
        this.f4196c = (long) (((double) System.nanoTime()) / 1000000.0d);
        this.f4197d = new Paint();
        this.f4197d.setColor(-1);
        this.f4197d.setStyle(Style.STROKE);
        this.f4197d.setStrokeWidth(f * 3.0f);
        this.f4197d.setAntiAlias(true);
        this.f4198e = new Paint();
        this.f4198e.setColor(-1);
        this.f4198e.setStyle(Style.FILL);
        this.f4198e.setAntiAlias(true);
        this.f4199f = new Path();
        this.f4200g = new Path();
        this.f4202i = new RectF();
        this.f4201h = new RectF();
    }

    protected void m4668a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4201h.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f4201h.inset(1.5f * f, 1.5f * f);
        float height = ((float) getHeight()) / 2.0f;
        canvas.drawRoundRect(this.f4201h, height, height, this.f4197d);
        this.f4202i.set(this.f4201h);
        this.f4202i.inset(3.0f * f, f * 3.0f);
        f = this.f4202i.height() / 2.0f;
        this.f4199f.reset();
        this.f4199f.addRoundRect(this.f4202i, f, f, Direction.CW);
        height = this.f4202i.height();
        this.f4200g.reset();
        this.f4200g.moveTo(0.0f, height);
        this.f4200g.lineTo(height, height);
        this.f4200g.lineTo(height * 2.0f, 0.0f);
        this.f4200g.lineTo(height, 0.0f);
        this.f4200g.close();
        canvas.save();
        Object obj = 1;
        try {
            canvas.clipPath(this.f4199f);
        } catch (UnsupportedOperationException e) {
            obj = null;
        }
        if (obj != null) {
            for (f = (-height) + this.f4195b; f < this.f4202i.width() + height; f += 2.0f * height) {
                float f2 = this.f4202i.left + f;
                canvas.save();
                canvas.translate(f2, this.f4202i.top);
                canvas.drawPath(this.f4200g, this.f4198e);
                canvas.restore();
            }
        }
        canvas.restore();
        long max = Math.max(0, 16 - (((long) (((double) System.nanoTime()) / 1000000.0d)) - this.f4196c));
        f4194a.removeCallbacks(this.f4203j);
        f4194a.postDelayed(this.f4203j, max);
    }

    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        f4194a.removeCallbacks(this.f4203j);
        if (visibility == 0) {
            f4194a.post(this.f4203j);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f4194a.removeCallbacks(this.f4203j);
        f4194a.post(this.f4203j);
    }

    protected void onDetachedFromWindow() {
        f4194a.removeCallbacks(this.f4203j);
        super.onDetachedFromWindow();
    }
}
