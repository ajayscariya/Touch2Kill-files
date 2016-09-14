package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.widget.LinearLayout;
import com.chartboost.sdk.Libraries.C0271e.C0269a;

public abstract class ap extends LinearLayout {
    private Rect f818a;
    private Paint f819b;
    private Paint f820c;

    public abstract int m840a();

    public abstract void m841a(C0269a c0269a, int i);

    public ap(Context context) {
        super(context);
        this.f818a = new Rect();
        this.f819b = null;
        this.f820c = null;
    }

    protected void onDraw(Canvas canvas) {
        this.f818a.set(0, 0, canvas.getWidth(), canvas.getHeight());
        m838a(canvas, this.f818a);
        m839b(canvas, this.f818a);
    }

    private void m838a(Canvas canvas, Rect rect) {
        if (this.f820c == null) {
            this.f820c = new Paint();
            this.f820c.setStyle(Style.FILL);
            this.f820c.setColor(-1);
        }
        canvas.drawRect(rect, this.f820c);
    }

    private void m839b(Canvas canvas, Rect rect) {
        if (this.f819b == null) {
            this.f819b = new Paint();
            this.f819b.setStyle(Style.FILL);
            this.f819b.setAntiAlias(true);
        }
        this.f819b.setColor(-2631721);
        canvas.drawRect((float) rect.left, (float) (rect.bottom - 1), (float) rect.right, (float) rect.bottom, this.f819b);
    }
}
