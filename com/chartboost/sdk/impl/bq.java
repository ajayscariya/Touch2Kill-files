package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0287b;

public final class bq extends RelativeLayout {
    private C0318a f1023a;
    private bj f1024b;
    private bj f1025c;
    private bp f1026d;
    private C0291a f1027e;

    public bq(Context context, C0291a c0291a) {
        super(context);
        this.f1027e = null;
        this.f1027e = c0291a;
        if (c0291a.f596a == C0287b.NATIVE) {
            this.f1024b = new bj(context);
            addView(this.f1024b, new LayoutParams(-1, -1));
            this.f1025c = new bj(context);
            addView(this.f1025c, new LayoutParams(-1, -1));
            this.f1025c.setVisibility(8);
        }
    }

    public void m1039a() {
        if (this.f1023a == null) {
            this.f1023a = this.f1027e.m582m();
            if (this.f1023a != null) {
                addView(this.f1023a, new LayoutParams(-1, -1));
                this.f1023a.m758a();
            }
        }
        m1041c();
    }

    public void m1040b() {
        boolean z = !this.f1027e.f606k;
        this.f1027e.f606k = true;
        if (this.f1026d == null) {
            this.f1026d = new bp(getContext());
            this.f1026d.setVisibility(8);
            addView(this.f1026d, new LayoutParams(-1, -1));
        } else {
            if (!(this.f1025c == null || this.f1024b == null)) {
                this.f1025c.bringToFront();
                this.f1025c.setVisibility(0);
                this.f1025c.m1009a();
                bi.m1004a(false, this.f1024b);
            }
            this.f1026d.bringToFront();
            this.f1026d.m1038a();
        }
        if (!m1045g()) {
            this.f1026d.setVisibility(0);
            if (z) {
                if (!(this.f1025c == null || this.f1024b == null)) {
                    m1043e().m1009a();
                }
                bi.m1004a(true, this.f1026d);
            }
        }
    }

    public void m1041c() {
        if (this.f1026d != null) {
            this.f1026d.clearAnimation();
            this.f1026d.setVisibility(8);
        }
    }

    public void m1042d() {
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    public bj m1043e() {
        return this.f1024b;
    }

    public View m1044f() {
        return this.f1023a;
    }

    public boolean m1045g() {
        return this.f1026d != null && this.f1026d.getVisibility() == 0;
    }

    public C0291a m1046h() {
        return this.f1027e;
    }
}
