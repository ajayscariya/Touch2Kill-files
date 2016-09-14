package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import com.chartboost.sdk.C0299c;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.Libraries.k */
public final class C0282k extends WeakReference<Activity> {
    private static C0282k f559b;
    private int f560a;

    private C0282k(Activity activity) {
        super(activity);
        this.f560a = activity.hashCode();
    }

    public static C0282k m549a(Activity activity) {
        if (f559b == null || f559b.f560a != activity.hashCode()) {
            f559b = new C0282k(activity);
        }
        return f559b;
    }

    public boolean m553b(Activity activity) {
        if (activity != null && activity.hashCode() == this.f560a) {
            return true;
        }
        return false;
    }

    public boolean m551a(C0282k c0282k) {
        if (c0282k != null && c0282k.m550a() == this.f560a) {
            return true;
        }
        return false;
    }

    public int m550a() {
        return this.f560a;
    }

    public int hashCode() {
        return m550a();
    }

    public Context m552b() {
        Context context = (Context) get();
        if (context == null) {
            return C0299c.m682y();
        }
        return context;
    }
}
