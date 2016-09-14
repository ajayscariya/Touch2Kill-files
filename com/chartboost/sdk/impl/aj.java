package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Libraries.CBUtility;

public final class aj extends am {
    private LinearLayout f4070b;
    private bk f4071c;
    private TextView f4072d;

    public aj(Context context, ai aiVar) {
        super(context, aiVar);
    }

    protected View m4493a() {
        Context context = getContext();
        int round = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0f);
        this.f4070b = new LinearLayout(context);
        this.f4070b.setOrientation(0);
        this.f4070b.setGravity(17);
        int a = CBUtility.m390a(36, context);
        this.f4071c = new bk(context);
        this.f4071c.setPadding(round, round, round, round);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
        this.f4071c.setScaleType(ScaleType.FIT_CENTER);
        this.f4072d = new TextView(context);
        this.f4072d.setPadding(round / 2, round, round, round);
        this.f4072d.setTextColor(-15264491);
        this.f4072d.setTextSize(2, 16.0f);
        this.f4072d.setTypeface(null, 1);
        this.f4072d.setGravity(17);
        this.f4070b.addView(this.f4071c, layoutParams);
        this.f4070b.addView(this.f4072d, new LinearLayout.LayoutParams(-2, -1));
        return this.f4070b;
    }

    public void m4494a(C1201j c1201j) {
        this.f4071c.m1011a(c1201j);
        this.f4071c.setScaleType(ScaleType.FIT_CENTER);
    }

    public void m4495a(String str) {
        this.f4072d.setText(str);
    }

    protected int m4496b() {
        return 48;
    }
}
