package com.applovin.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class AppLovinTouchToClickListener implements OnTouchListener {
    private long f7a;
    private float f8b;
    private float f9c;
    private Context f10d;
    private OnClickListener f11e;

    public AppLovinTouchToClickListener(Context context, OnClickListener onClickListener) {
        this.f10d = context;
        this.f11e = onClickListener;
    }

    private float m15a(float f) {
        return f / this.f10d.getResources().getDisplayMetrics().density;
    }

    private float m16a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m15a((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case DurationDV.DURATION_TYPE /*0*/:
                this.f7a = System.currentTimeMillis();
                this.f8b = motionEvent.getX();
                this.f9c = motionEvent.getY();
                break;
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (System.currentTimeMillis() - this.f7a < 1000 && m16a(this.f8b, this.f9c, motionEvent.getX(), motionEvent.getY()) < 10.0f) {
                    this.f11e.onClick(view);
                    break;
                }
        }
        return true;
    }
}
