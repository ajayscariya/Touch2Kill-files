package com.applovin.impl.adview;

import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;

/* renamed from: com.applovin.impl.adview.q */
class C0223q implements OnLongClickListener {
    final /* synthetic */ C0221o f77a;

    C0223q(C0221o c0221o) {
        this.f77a = c0221o;
    }

    public boolean onLongClick(View view) {
        Log.d("AdWebView", "Received a LongClick event.");
        return true;
    }
}
