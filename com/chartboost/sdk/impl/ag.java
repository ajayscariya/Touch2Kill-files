package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;

public final class ag extends am {
    private LinearLayout f4041b;
    private LinearLayout f4042c;
    private bk f4043d;
    private bl f4044e;
    private TextView f4045f;
    private TextView f4046g;

    /* renamed from: com.chartboost.sdk.impl.ag.1 */
    class C12191 extends bl {
        final /* synthetic */ ag f4040a;

        C12191(ag agVar, Context context) {
            this.f4040a = agVar;
            super(context);
        }

        protected void m4468a(MotionEvent motionEvent) {
            this.f4040a.a.m5767r().m5728h();
        }
    }

    public ag(Context context, ai aiVar) {
        super(context, aiVar);
    }

    protected View m4469a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 6.0f);
        this.f4041b = new LinearLayout(context);
        this.f4041b.setOrientation(0);
        this.f4041b.setGravity(17);
        this.f4042c = new LinearLayout(context);
        this.f4042c.setOrientation(1);
        this.f4042c.setGravity(19);
        this.f4043d = new bk(context);
        this.f4043d.setPadding(round, round, round, round);
        if (this.a.f4851G.m4348e()) {
            this.f4043d.m1011a(this.a.f4851G);
        }
        this.f4044e = new C12191(this, context);
        this.f4044e.setPadding(round, round, round, round);
        if (this.a.f4852H.m4348e()) {
            this.f4044e.m1020a(this.a.f4852H);
        }
        this.f4045f = new TextView(getContext());
        this.f4045f.setTextColor(-15264491);
        this.f4045f.setTypeface(null, 1);
        this.f4045f.setGravity(3);
        this.f4045f.setPadding(round, round, round, round / 2);
        this.f4046g = new TextView(getContext());
        this.f4046g.setTextColor(-15264491);
        this.f4046g.setTypeface(null, 1);
        this.f4046g.setGravity(3);
        this.f4046g.setPadding(round, 0, round, round);
        this.f4045f.setTextSize(2, 14.0f);
        this.f4046g.setTextSize(2, 11.0f);
        this.f4042c.addView(this.f4045f);
        this.f4042c.addView(this.f4046g);
        this.f4041b.addView(this.f4043d);
        this.f4041b.addView(this.f4042c, new LayoutParams(0, -2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        this.f4041b.addView(this.f4044e);
        return this.f4041b;
    }

    public void m4470a(String str, String str2) {
        this.f4045f.setText(str);
        this.f4046g.setText(str2);
    }

    protected int m4471b() {
        return 72;
    }
}
