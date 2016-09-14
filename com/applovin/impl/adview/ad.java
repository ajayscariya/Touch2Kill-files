package com.applovin.impl.adview;

import android.view.View;
import android.view.View.OnClickListener;

class ad implements OnClickListener {
    final /* synthetic */ C1172x f49a;

    ad(C1172x c1172x) {
        this.f49a = c1172x;
    }

    public void onClick(View view) {
        if (this.f49a.f3833g.isClickable()) {
            this.f49a.f3833g.performClick();
        }
    }
}
