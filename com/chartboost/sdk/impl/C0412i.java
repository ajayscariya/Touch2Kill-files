package com.chartboost.sdk.impl;

import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.i */
public class C0412i {
    public final int f1100a;
    public final byte[] f1101b;
    public final Map<String, String> f1102c;
    public final boolean f1103d;

    public C0412i(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this.f1100a = i;
        this.f1101b = bArr;
        this.f1102c = map;
        this.f1103d = z;
    }

    public C0412i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false);
    }
}
