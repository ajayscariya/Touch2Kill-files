package com.inmobi.ads;

import android.os.SystemClock;
import android.support.annotation.NonNull;

/* renamed from: com.inmobi.ads.p */
class TimestampWrapper<T> {
    @NonNull
    final T f1497a;
    long f1498b;

    TimestampWrapper(@NonNull T t) {
        this.f1497a = t;
        this.f1498b = SystemClock.uptimeMillis();
    }
}
