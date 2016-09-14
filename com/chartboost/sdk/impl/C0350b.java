package com.chartboost.sdk.impl;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.chartboost.sdk.impl.b */
public interface C0350b {

    /* renamed from: com.chartboost.sdk.impl.b.a */
    public static class C0349a {
        public byte[] f891a;
        public String f892b;
        public long f893c;
        public long f894d;
        public long f895e;
        public Map<String, String> f896f;

        public C0349a() {
            this.f896f = Collections.emptyMap();
        }

        public boolean m896a() {
            return this.f894d < System.currentTimeMillis();
        }

        public boolean m897b() {
            return this.f895e < System.currentTimeMillis();
        }
    }

    C0349a m898a(String str);

    void m899a();

    void m900a(String str, C0349a c0349a);
}
