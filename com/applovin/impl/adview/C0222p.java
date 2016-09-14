package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.applovin.impl.adview.p */
class C0222p implements OnTouchListener {
    final /* synthetic */ C0221o f76a;

    C0222p(C0221o c0221o) {
        this.f76a = c0221o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
