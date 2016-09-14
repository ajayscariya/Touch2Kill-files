package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0311e;
import com.chartboost.sdk.C0311e.C0310a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0292b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0415l.C0414a;

public class av extends C0311e {
    private static final String f4104d;
    private static av f4105e;
    protected int f4106c;
    private C0291a f4107f;
    private boolean f4108g;
    private boolean f4109h;

    /* renamed from: com.chartboost.sdk.impl.av.1 */
    class C12291 implements C0310a {
        final /* synthetic */ av f4103a;

        C12291(av avVar) {
            this.f4103a = avVar;
        }

        public void m4522a(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didClickMoreApps(c0291a.f600e);
            }
        }

        public void m4524b(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCloseMoreApps(c0291a.f600e);
            }
        }

        public void m4525c(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDismissMoreApps(c0291a.f600e);
            }
        }

        public void m4526d(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCacheMoreApps(c0291a.f600e);
            }
        }

        public void m4523a(C0291a c0291a, CBImpressionError cBImpressionError) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToLoadMoreApps(c0291a.f600e, cBImpressionError);
            }
        }

        public void m4527e(C0291a c0291a) {
            this.f4103a.f4106c = 0;
            this.f4103a.m4541i();
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDisplayMoreApps(c0291a.f600e);
            }
        }

        public boolean m4528f(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m663g().shouldDisplayMoreApps(c0291a.f600e);
            }
            return true;
        }

        public boolean m4529g(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m663g().shouldRequestMoreApps(c0291a.f600e);
            }
            return true;
        }

        public boolean m4530h(C0291a c0291a) {
            return true;
        }
    }

    static {
        f4104d = av.class.getSimpleName();
    }

    private av() {
        this.f4107f = null;
    }

    public static av m4531h() {
        if (f4105e == null) {
            synchronized (av.class) {
                if (f4105e == null) {
                    f4105e = new av();
                }
            }
        }
        return f4105e;
    }

    public void m4535a(String str) {
        this.f4106c = 0;
        m4541i();
        super.m713a(str);
    }

    protected void m4534a(C0291a c0291a, C0269a c0269a) {
        if (!this.f4108g && this.f4109h) {
            this.f4109h = false;
            this.f4106c = c0269a.m431a("cells").m458o();
        }
        super.m709a(c0291a, c0269a);
    }

    protected C0291a m4532a(String str, boolean z) {
        return new C0291a(C0286a.MORE_APPS, z, str, false, m727f());
    }

    protected az m4540f(C0291a c0291a) {
        az azVar = new az("/more/get");
        azVar.m866a(C0414a.HIGH);
        azVar.m863a(C0292b.f624d);
        return azVar;
    }

    protected az m4542m(C0291a c0291a) {
        az azVar = new az("/more/show");
        if (c0291a.f600e != null) {
            azVar.m869a("location", c0291a.f600e);
        }
        if (c0291a.m563A().m439c("cells")) {
            azVar.m869a("cells", c0291a.m563A().m431a("cells"));
        }
        return azVar;
    }

    public void m4533a() {
        this.f4107f = null;
    }

    protected C0291a m4537d(String str) {
        return this.f4107f;
    }

    protected void m4539e(String str) {
        this.f4107f = null;
    }

    protected void m4543r(C0291a c0291a) {
        this.f4107f = c0291a;
    }

    protected C0310a m4536c() {
        return new C12291(this);
    }

    protected void m4541i() {
    }

    public String m4538e() {
        return "more-apps";
    }
}
