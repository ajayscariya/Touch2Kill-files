package com.chartboost.sdk.impl;

import com.android.volley.DefaultRetryPolicy;

/* renamed from: com.chartboost.sdk.impl.d */
public class C1244d implements C0422p {
    private int f4219a;
    private int f4220b;
    private final int f4221c;
    private final float f4222d;

    public C1244d() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public C1244d(int i, int i2, float f) {
        this.f4219a = i;
        this.f4221c = i2;
        this.f4222d = f;
    }

    public int m4698a() {
        return this.f4219a;
    }

    public int m4700b() {
        return this.f4220b;
    }

    public void m4699a(C0423s c0423s) throws C0423s {
        this.f4220b++;
        this.f4219a = (int) (((float) this.f4219a) + (((float) this.f4219a) * this.f4222d));
        if (!m4701c()) {
            throw c0423s;
        }
    }

    protected boolean m4701c() {
        return this.f4220b <= this.f4221c;
    }
}
