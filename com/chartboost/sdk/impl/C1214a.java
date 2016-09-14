package com.chartboost.sdk.impl;

import android.content.Intent;

/* renamed from: com.chartboost.sdk.impl.a */
public class C1214a extends C0423s {
    private Intent f4026b;

    public C1214a(C0412i c0412i) {
        super(c0412i);
    }

    public String getMessage() {
        if (this.f4026b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
