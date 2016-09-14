package com.chartboost.sdk.impl;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0320g;

public final class al extends LinearLayout {
    private ai f777a;
    private LinearLayout f778b;
    private bk f779c;
    private TextView f780d;
    private bl f781e;
    private int f782f;

    /* renamed from: com.chartboost.sdk.impl.al.1 */
    class C12261 extends bl {
        final /* synthetic */ al f4081a;

        C12261(al alVar, Context context) {
            this.f4081a = alVar;
            super(context);
        }

        protected void m4504a(MotionEvent motionEvent) {
            this.f4081a.f781e.setEnabled(false);
            this.f4081a.f777a.m5767r().m5729i();
        }
    }

    public al(Context context, ai aiVar) {
        super(context);
        this.f782f = ExploreByTouchHelper.INVALID_ID;
        this.f777a = aiVar;
        m798a(context);
    }

    private void m798a(Context context) {
        Context context2 = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        setOrientation(1);
        setGravity(17);
        this.f778b = new LinearLayout(context2);
        this.f778b.setGravity(17);
        this.f778b.setOrientation(0);
        this.f778b.setPadding(round, round, round, round);
        this.f779c = new bk(context2);
        this.f779c.setScaleType(ScaleType.FIT_CENTER);
        this.f779c.setPadding(0, 0, round, 0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f777a.m4484a(layoutParams, this.f777a.f4849E, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f780d = new TextView(getContext());
        this.f780d.setTextColor(-1);
        this.f780d.setTypeface(null, 1);
        this.f780d.setGravity(17);
        this.f780d.setTextSize(2, C0320g.m768a(context) ? 26.0f : 16.0f);
        this.f778b.addView(this.f779c, layoutParams);
        this.f778b.addView(this.f780d, new LinearLayout.LayoutParams(-2, -2));
        this.f781e = new C12261(this, getContext());
        this.f781e.setPadding(0, 0, 0, round);
        this.f781e.m1019a(ScaleType.FIT_CENTER);
        this.f781e.setPadding(round, round, round, round);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.f777a.m4484a(layoutParams2, this.f777a.f4848D, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        if (this.f777a.f4849E.m4348e()) {
            this.f779c.m1011a(this.f777a.f4849E);
        }
        if (this.f777a.f4848D.m4348e()) {
            this.f781e.m1020a(this.f777a.f4848D);
        }
        addView(this.f778b, new LinearLayout.LayoutParams(-2, -2));
        addView(this.f781e, layoutParams2);
        m800a();
    }

    public void m802a(boolean z) {
        setBackgroundColor(z ? ViewCompat.MEASURED_STATE_MASK : this.f782f);
    }

    public void m801a(String str, int i) {
        this.f780d.setText(str);
        this.f782f = i;
        m802a(this.f777a.m5769t());
    }

    public void m800a() {
        m802a(this.f777a.m5769t());
    }
}
