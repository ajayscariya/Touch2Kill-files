package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.C0350b.C0349a;

/* renamed from: com.chartboost.sdk.impl.n */
public class C0420n<T> {
    public final T f1137a;
    public final C0349a f1138b;
    public final C0423s f1139c;
    public boolean f1140d;

    /* renamed from: com.chartboost.sdk.impl.n.a */
    public interface C0418a {
        void m1127a(C0423s c0423s);
    }

    /* renamed from: com.chartboost.sdk.impl.n.b */
    public interface C0419b<T> {
        void m1128a(T t);
    }

    public static <T> C0420n<T> m1130a(T t, C0349a c0349a) {
        return new C0420n(t, c0349a);
    }

    public static <T> C0420n<T> m1129a(C0423s c0423s) {
        return new C0420n(c0423s);
    }

    public boolean m1131a() {
        return this.f1139c == null;
    }

    private C0420n(T t, C0349a c0349a) {
        this.f1140d = false;
        this.f1137a = t;
        this.f1138b = c0349a;
        this.f1139c = null;
    }

    private C0420n(C0423s c0423s) {
        this.f1140d = false;
        this.f1137a = null;
        this.f1138b = null;
        this.f1139c = c0423s;
    }
}
