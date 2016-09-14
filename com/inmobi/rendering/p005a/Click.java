package com.inmobi.rendering.p005a;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mf.org.apache.xerces.dom3.as.ASContentModel;

/* renamed from: com.inmobi.rendering.a.a */
final class Click {
    int f1892a;
    String f1893b;
    long f1894c;
    int f1895d;
    AtomicBoolean f1896e;
    boolean f1897f;
    boolean f1898g;

    public Click(String str, boolean z, boolean z2, int i) {
        this(ASContentModel.AS_UNBOUNDED & new Random().nextInt(), str, z, z2, i, System.currentTimeMillis());
    }

    public Click(int i, String str, boolean z, boolean z2, int i2, long j) {
        this.f1892a = i;
        this.f1893b = str;
        this.f1894c = j;
        this.f1895d = i2;
        this.f1896e = new AtomicBoolean(false);
        this.f1898g = z;
        this.f1897f = z2;
    }
}
