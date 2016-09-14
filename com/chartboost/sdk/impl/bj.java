package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;

public final class bj extends View {
    private boolean f992a;

    public bj(Context context) {
        super(context);
        this.f992a = false;
        setFocusable(false);
        setBackgroundColor(-1442840576);
    }

    public void m1009a() {
        if (!this.f992a) {
            bi.m1004a(true, this);
            this.f992a = true;
        }
    }
}
