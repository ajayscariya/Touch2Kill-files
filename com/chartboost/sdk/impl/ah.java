package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Model.C0291a;

public class ah extends C0320g {
    protected C1201j f4056k;
    protected C1201j f4057l;
    protected C0269a f4058m;
    protected String f4059n;
    protected float f4060o;
    private C1201j f4061p;
    private C1201j f4062q;
    private C1201j f4063r;
    private C1201j f4064s;

    /* renamed from: com.chartboost.sdk.impl.ah.a */
    public class C1222a extends C0318a {
        protected bk f4050b;
        protected bl f4051c;
        protected bl f4052d;
        protected ImageView f4053e;
        final /* synthetic */ ah f4054f;
        private boolean f4055g;

        /* renamed from: com.chartboost.sdk.impl.ah.a.1 */
        class C12201 extends bl {
            final /* synthetic */ ah f4047a;
            final /* synthetic */ C1222a f4048b;

            C12201(C1222a c1222a, Context context, ah ahVar) {
                this.f4048b = c1222a;
                this.f4047a = ahVar;
                super(context);
            }

            protected void m4472a(MotionEvent motionEvent) {
                this.f4048b.m4474a(motionEvent.getX(), motionEvent.getY());
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ah.a.2 */
        class C12212 extends bl {
            final /* synthetic */ C1222a f4049a;

            C12212(C1222a c1222a, Context context) {
                this.f4049a = c1222a;
                super(context);
            }

            protected void m4473a(MotionEvent motionEvent) {
                this.f4049a.m4478e();
            }
        }

        protected C1222a(ah ahVar, Context context) {
            this.f4054f = ahVar;
            super(ahVar, context);
            this.f4055g = false;
            setBackgroundColor(0);
            setLayoutParams(new LayoutParams(-1, -1));
            this.f4050b = new bk(context);
            addView(this.f4050b, new LayoutParams(-1, -1));
            this.f4052d = new C12201(this, context, ahVar);
            m760a(this.f4052d);
            this.f4053e = new ImageView(context);
            this.f4053e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            addView(this.f4053e);
            addView(this.f4052d);
        }

        protected void m4477d() {
            this.f4051c = new C12212(this, getContext());
            addView(this.f4051c);
        }

        protected void m4474a(float f, float f2) {
            this.f4054f.m777a(null, null);
        }

        protected void m4475a(int i, int i2) {
            C1201j c1201j;
            int round;
            int round2;
            if (!this.f4055g) {
                m4477d();
                this.f4055g = true;
            }
            boolean a = this.f4054f.m770a().m469a();
            C1201j a2 = a ? this.f4054f.f4061p : this.f4054f.f4062q;
            if (a) {
                c1201j = this.f4054f.f4056k;
            } else {
                c1201j = this.f4054f.f4057l;
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            this.f4054f.m4484a(layoutParams, a2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            this.f4054f.f4060o = Math.min(Math.min(((float) i) / ((float) layoutParams.width), ((float) i2) / ((float) layoutParams.height)), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            layoutParams.width = (int) (((float) layoutParams.width) * this.f4054f.f4060o);
            layoutParams.height = (int) (((float) layoutParams.height) * this.f4054f.f4060o);
            Point b = this.f4054f.m4486b(a ? "frame-portrait" : "frame-landscape");
            layoutParams.leftMargin = Math.round((((float) (i - layoutParams.width)) / 2.0f) + ((((float) b.x) / a2.m4350g()) * this.f4054f.f4060o));
            layoutParams.topMargin = Math.round(((((float) b.y) / a2.m4350g()) * this.f4054f.f4060o) + (((float) (i2 - layoutParams.height)) / 2.0f));
            this.f4054f.m4484a(layoutParams2, c1201j, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            b = this.f4054f.m4486b(a ? "close-portrait" : "close-landscape");
            if (b.x == 0 && b.y == 0) {
                round = Math.round(((float) (-layoutParams2.width)) / 2.0f) + (layoutParams.leftMargin + layoutParams.width);
                round2 = layoutParams.topMargin + Math.round(((float) (-layoutParams2.height)) / 2.0f);
            } else {
                round = Math.round(((((float) layoutParams.leftMargin) + (((float) layoutParams.width) / 2.0f)) + ((float) b.x)) - (((float) layoutParams2.width) / 2.0f));
                round2 = Math.round((((float) b.y) + (((float) layoutParams.topMargin) + (((float) layoutParams.height) / 2.0f))) - (((float) layoutParams2.height) / 2.0f));
            }
            layoutParams2.leftMargin = Math.min(Math.max(0, round), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams2.height);
            this.f4050b.setLayoutParams(layoutParams);
            this.f4051c.setLayoutParams(layoutParams2);
            this.f4050b.setScaleType(ScaleType.FIT_CENTER);
            this.f4050b.m1011a(a2);
            this.f4051c.m1020a(c1201j);
            c1201j = a ? this.f4054f.f4063r : this.f4054f.f4064s;
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            this.f4054f.m4484a(layoutParams3, c1201j, this.f4054f.f4060o);
            b = this.f4054f.m4486b(a ? "ad-portrait" : "ad-landscape");
            layoutParams3.leftMargin = Math.round((((float) (i - layoutParams3.width)) / 2.0f) + ((((float) b.x) / c1201j.m4350g()) * this.f4054f.f4060o));
            layoutParams3.topMargin = Math.round(((((float) b.y) / c1201j.m4350g()) * this.f4054f.f4060o) + (((float) (i2 - layoutParams3.height)) / 2.0f));
            this.f4053e.setLayoutParams(layoutParams3);
            this.f4052d.setLayoutParams(layoutParams3);
            this.f4052d.m1019a(ScaleType.FIT_CENTER);
            this.f4052d.m1020a(c1201j);
        }

        protected void m4478e() {
            this.f4054f.m786h();
        }

        public void m4476b() {
            super.m763b();
            this.f4050b = null;
            this.f4051c = null;
            this.f4052d = null;
            this.f4053e = null;
        }
    }

    public ah(C0291a c0291a) {
        super(c0291a);
        this.f4060o = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f4061p = new C1201j(this);
        this.f4062q = new C1201j(this);
        this.f4056k = new C1201j(this);
        this.f4057l = new C1201j(this);
        this.f4063r = new C1201j(this);
        this.f4064s = new C1201j(this);
    }

    protected C0318a m4487b(Context context) {
        return new C1222a(this, context);
    }

    public boolean m4485a(C0269a c0269a) {
        if (!super.m776a(c0269a)) {
            return false;
        }
        this.f4059n = c0269a.m442e("ad_id");
        this.f4058m = c0269a.m431a("ux");
        if (this.e.m436b("frame-portrait") || this.e.m436b("close-portrait")) {
            this.i = false;
        }
        if (this.e.m436b("frame-landscape") || this.e.m436b("close-landscape")) {
            this.j = false;
        }
        this.f4062q.m4343a("frame-landscape");
        this.f4061p.m4343a("frame-portrait");
        this.f4057l.m4343a("close-landscape");
        this.f4056k.m4343a("close-portrait");
        if (this.e.m436b("ad-portrait")) {
            this.i = false;
        }
        if (this.e.m436b("ad-landscape")) {
            this.j = false;
        }
        this.f4064s.m4343a("ad-landscape");
        this.f4063r.m4343a("ad-portrait");
        return true;
    }

    protected Point m4486b(String str) {
        C0269a a = this.e.m431a(str).m431a("offset");
        if (a.m438c()) {
            return new Point(a.m444f("x"), a.m444f("y"));
        }
        return new Point(0, 0);
    }

    public void m4484a(ViewGroup.LayoutParams layoutParams, C1201j c1201j, float f) {
        layoutParams.width = (int) ((((float) c1201j.m4345b()) / c1201j.m4350g()) * f);
        layoutParams.height = (int) ((((float) c1201j.m4346c()) / c1201j.m4350g()) * f);
    }

    public void m4488d() {
        super.m782d();
        this.f4062q.m4347d();
        this.f4061p.m4347d();
        this.f4057l.m4347d();
        this.f4056k.m4347d();
        this.f4064s.m4347d();
        this.f4063r.m4347d();
        this.f4062q = null;
        this.f4061p = null;
        this.f4057l = null;
        this.f4056k = null;
        this.f4064s = null;
        this.f4063r = null;
    }
}
