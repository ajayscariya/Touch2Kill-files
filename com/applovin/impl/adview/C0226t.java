package com.applovin.impl.adview;

import android.content.res.Resources;

/* renamed from: com.applovin.impl.adview.t */
class C0226t {
    public static float m48a(Resources resources, float f) {
        return (resources.getDisplayMetrics().density * f) + 0.5f;
    }

    public static float m49b(Resources resources, float f) {
        return resources.getDisplayMetrics().scaledDensity * f;
    }
}
