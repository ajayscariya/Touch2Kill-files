package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Libraries.C0276g.C0274a;
import com.chartboost.sdk.Libraries.C0276g.C1190e;

/* renamed from: com.chartboost.sdk.Libraries.a */
public interface C0262a {
    public static final C0274a f458a;

    /* renamed from: com.chartboost.sdk.Libraries.a.1 */
    static class C15131 extends C1190e {
        C15131() {
        }

        public boolean m5690a(Object obj) {
            int intValue = ((Number) obj).intValue();
            return intValue >= 200 && intValue < 300;
        }

        public String m5689a() {
            return "Must be a valid status code (>=200 && <300)";
        }
    }

    static {
        f458a = C0276g.m485b(C0276g.m483b(), new C15131());
    }
}
