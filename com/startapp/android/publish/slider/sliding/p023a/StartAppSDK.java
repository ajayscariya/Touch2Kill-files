package com.startapp.android.publish.slider.sliding.p023a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.startapp.android.publish.slider.sliding.a.d */
public class StartAppSDK {
    private static final StartAppSDK f3549a;
    private final Object f3550b;

    /* renamed from: com.startapp.android.publish.slider.sliding.a.d.a */
    interface StartAppSDK {
        Object m3669a(StartAppSDK startAppSDK);
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.a.d.c */
    static class StartAppSDK implements StartAppSDK {
        StartAppSDK() {
        }

        public Object m5569a(StartAppSDK startAppSDK) {
            return null;
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.a.d.b */
    static class StartAppSDK extends StartAppSDK {

        /* renamed from: com.startapp.android.publish.slider.sliding.a.d.b.1 */
        class StartAppSDK implements StartAppSDK {
            final /* synthetic */ StartAppSDK f4773a;
            final /* synthetic */ StartAppSDK f4774b;

            StartAppSDK(StartAppSDK startAppSDK, StartAppSDK startAppSDK2) {
                this.f4774b = startAppSDK;
                this.f4773a = startAppSDK2;
            }

            public boolean m5568a(int i, int i2, Bundle bundle) {
                return this.f4773a.m3673a(i, i2, bundle);
            }

            public List<Object> m5567a(String str, int i) {
                List a = this.f4773a.m3672a(str, i);
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((StartAppSDK) a.get(i2)).m3593a());
                }
                return arrayList;
            }

            public Object m5566a(int i) {
                StartAppSDK a = this.f4773a.m3670a(i);
                if (a == null) {
                    return null;
                }
                return a.m3593a();
            }
        }

        StartAppSDK() {
        }

        public Object m6034a(StartAppSDK startAppSDK) {
            return StartAppSDK.m3677a(new StartAppSDK(this, startAppSDK));
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f3549a = new StartAppSDK();
        } else {
            f3549a = new StartAppSDK();
        }
    }

    public StartAppSDK() {
        this.f3550b = f3549a.m3669a(this);
    }

    public StartAppSDK(Object obj) {
        this.f3550b = obj;
    }

    public Object m3671a() {
        return this.f3550b;
    }

    public StartAppSDK m3670a(int i) {
        return null;
    }

    public boolean m3673a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<StartAppSDK> m3672a(String str, int i) {
        return null;
    }
}
