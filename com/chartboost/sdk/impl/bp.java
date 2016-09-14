package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class bp extends LinearLayout {
    private TextView f1021a;
    private br f1022b;

    public bp(Context context) {
        super(context);
        m1037a(context);
    }

    private void m1037a(Context context) {
        setGravity(17);
        this.f1021a = new TextView(getContext());
        this.f1021a.setTextColor(-1);
        this.f1021a.setTextSize(2, 16.0f);
        this.f1021a.setTypeface(null, 1);
        this.f1021a.setText("Loading...");
        this.f1021a.setGravity(17);
        this.f1022b = new br(getContext());
        addView(this.f1021a);
        addView(this.f1022b);
        m1038a();
    }

    public void m1038a() {
        removeView(this.f1021a);
        removeView(this.f1022b);
        float f = getContext().getResources().getDisplayMetrics().density;
        int round = Math.round(20.0f * f);
        setOrientation(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(round, round, round, 0);
        addView(this.f1021a, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, Math.round(f * 32.0f));
        layoutParams.setMargins(round, round, round, round);
        addView(this.f1022b, layoutParams);
    }
}
