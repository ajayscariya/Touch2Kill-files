package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import mf.javax.xml.XMLConstants;

/* renamed from: com.applovin.impl.adview.s */
public class C0225s extends View {
    private final int f80A;
    protected Paint f81a;
    protected Paint f82b;
    private Paint f83c;
    private Paint f84d;
    private RectF f85e;
    private float f86f;
    private int f87g;
    private int f88h;
    private int f89i;
    private int f90j;
    private int f91k;
    private float f92l;
    private int f93m;
    private String f94n;
    private String f95o;
    private float f96p;
    private String f97q;
    private float f98r;
    private final float f99s;
    private final int f100t;
    private final int f101u;
    private final int f102v;
    private final int f103w;
    private final int f104x;
    private final float f105y;
    private final float f106z;

    public C0225s(Context context) {
        this(context, null);
    }

    public C0225s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0225s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f85e = new RectF();
        this.f89i = 0;
        this.f94n = XMLConstants.NULL_NS_URI;
        this.f95o = XMLConstants.NULL_NS_URI;
        this.f97q = XMLConstants.NULL_NS_URI;
        this.f100t = Color.rgb(66, 145, 241);
        this.f101u = Color.rgb(66, 145, 241);
        this.f102v = Color.rgb(66, 145, 241);
        this.f103w = 0;
        this.f104x = 100;
        this.f105y = C0226t.m49b(getResources(), 14.0f);
        this.f80A = (int) C0226t.m48a(getResources(), 100.0f);
        this.f99s = C0226t.m48a(getResources(), 4.0f);
        this.f106z = C0226t.m49b(getResources(), 18.0f);
        m31b();
        m28a();
    }

    private int m26e(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f80A;
        return mode == ExploreByTouchHelper.INVALID_ID ? Math.min(i2, size) : i2;
    }

    private float m27o() {
        return (((float) m36d()) / ((float) this.f90j)) * 360.0f;
    }

    protected void m28a() {
        this.f81a = new TextPaint();
        this.f81a.setColor(this.f87g);
        this.f81a.setTextSize(this.f86f);
        this.f81a.setAntiAlias(true);
        this.f82b = new TextPaint();
        this.f82b.setColor(this.f88h);
        this.f82b.setTextSize(this.f96p);
        this.f82b.setAntiAlias(true);
        this.f83c = new Paint();
        this.f83c.setColor(this.f91k);
        this.f83c.setStyle(Style.STROKE);
        this.f83c.setAntiAlias(true);
        this.f83c.setStrokeWidth(this.f92l);
        this.f84d = new Paint();
        this.f84d.setColor(this.f93m);
        this.f84d.setAntiAlias(true);
    }

    public void m29a(float f) {
        this.f92l = f;
        invalidate();
    }

    public void m30a(int i) {
        this.f89i = i;
        if (this.f89i > m38e()) {
            this.f89i %= m38e();
        }
        invalidate();
    }

    protected void m31b() {
        this.f91k = this.f100t;
        this.f87g = this.f101u;
        this.f86f = this.f105y;
        m33b(100);
        m30a(0);
        this.f92l = this.f99s;
        this.f93m = 0;
        this.f96p = this.f106z;
        this.f88h = this.f102v;
    }

    public void m32b(float f) {
        this.f86f = f;
        invalidate();
    }

    public void m33b(int i) {
        if (i > 0) {
            this.f90j = i;
            invalidate();
        }
    }

    public float m34c() {
        return this.f92l;
    }

    public void m35c(int i) {
        this.f87g = i;
        invalidate();
    }

    public int m36d() {
        return this.f89i;
    }

    public void m37d(int i) {
        this.f91k = i;
        invalidate();
    }

    public int m38e() {
        return this.f90j;
    }

    public float m39f() {
        return this.f86f;
    }

    public int m40g() {
        return this.f87g;
    }

    public int m41h() {
        return this.f91k;
    }

    public String m42i() {
        return this.f95o;
    }

    public void invalidate() {
        m28a();
        super.invalidate();
    }

    public String m43j() {
        return this.f94n;
    }

    public int m44k() {
        return this.f93m;
    }

    public String m45l() {
        return this.f97q;
    }

    public float m46m() {
        return this.f96p;
    }

    public int m47n() {
        return this.f88h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f92l;
        this.f85e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - this.f92l) + this.f92l) / 2.0f, this.f84d);
        canvas.drawArc(this.f85e, 270.0f, -m27o(), false, this.f83c);
        String str = this.f94n + this.f89i + this.f95o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f81a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f81a.descent() + this.f81a.ascent())) / 2.0f, this.f81a);
        }
        if (!TextUtils.isEmpty(m45l())) {
            this.f82b.setTextSize(this.f96p);
            canvas.drawText(m45l(), (((float) getWidth()) - this.f82b.measureText(m45l())) / 2.0f, (((float) getHeight()) - this.f98r) - ((this.f81a.descent() + this.f81a.ascent()) / 2.0f), this.f82b);
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m26e(i), m26e(i2));
        this.f98r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f87g = bundle.getInt("text_color");
            this.f86f = bundle.getFloat("text_size");
            this.f96p = bundle.getFloat("inner_bottom_text_size");
            this.f97q = bundle.getString("inner_bottom_text");
            this.f88h = bundle.getInt("inner_bottom_text_color");
            this.f91k = bundle.getInt("finished_stroke_color");
            this.f92l = bundle.getFloat("finished_stroke_width");
            this.f93m = bundle.getInt("inner_background_color");
            m28a();
            m33b(bundle.getInt("max"));
            m30a(bundle.getInt(NotificationCompatApi21.CATEGORY_PROGRESS));
            this.f94n = bundle.getString("prefix");
            this.f95o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", m40g());
        bundle.putFloat("text_size", m39f());
        bundle.putFloat("inner_bottom_text_size", m46m());
        bundle.putFloat("inner_bottom_text_color", (float) m47n());
        bundle.putString("inner_bottom_text", m45l());
        bundle.putInt("inner_bottom_text_color", m47n());
        bundle.putInt("finished_stroke_color", m41h());
        bundle.putInt("max", m38e());
        bundle.putInt(NotificationCompatApi21.CATEGORY_PROGRESS, m36d());
        bundle.putString("suffix", m42i());
        bundle.putString("prefix", m43j());
        bundle.putFloat("finished_stroke_width", m34c());
        bundle.putInt("inner_background_color", m44k());
        return bundle;
    }
}
