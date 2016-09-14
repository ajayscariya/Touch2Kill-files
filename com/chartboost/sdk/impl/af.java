package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0297b;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0311e.C0310a;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0292b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.bd.C0364a;
import com.chartboost.sdk.impl.bm.C0389a;
import com.chartboost.sdk.impl.bm.C0390b;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.apache.xml.serialize.Method;

public class af extends ae {
    private static af f4835c;
    private static String f4836d;

    /* renamed from: com.chartboost.sdk.impl.af.1 */
    class C03231 implements Runnable {
        final /* synthetic */ C0269a f764a;
        final /* synthetic */ C0291a f765b;
        final /* synthetic */ af f766c;

        /* renamed from: com.chartboost.sdk.impl.af.1.1 */
        class C12161 extends C0390b {
            final /* synthetic */ C03231 f4037a;

            C12161(C03231 c03231) {
                this.f4037a = c03231;
            }

            public void m4456a(bm bmVar) {
                this.f4037a.f766c.m710a(this.f4037a.f765b, CBImpressionError.USER_CANCELLATION);
            }

            public void m4457a(bm bmVar, int i) {
                if (i == 1) {
                    super.m732i(this.f4037a.f765b);
                } else {
                    this.f4037a.f766c.m710a(this.f4037a.f765b, CBImpressionError.USER_CANCELLATION);
                }
            }
        }

        C03231(af afVar, C0269a c0269a, C0291a c0291a) {
            this.f766c = afVar;
            this.f764a = c0269a;
            this.f765b = c0291a;
        }

        public void run() {
            C0389a c0389a = new C0389a();
            c0389a.m1024a(this.f764a.m442e(DatabaseOpenHelper.HISTORY_ROW_TITLE)).m1026b(this.f764a.m442e(Method.TEXT)).m1028d(this.f764a.m442e("confirm")).m1027c(this.f764a.m442e("cancel"));
            c0389a.m1025a(this.f766c.m721d(), new C12161(this));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.af.2 */
    class C03242 implements Runnable {
        final /* synthetic */ C0269a f767a;
        final /* synthetic */ af f768b;

        /* renamed from: com.chartboost.sdk.impl.af.2.1 */
        class C12171 extends C0390b {
            final /* synthetic */ C03242 f4038a;

            C12171(C03242 c03242) {
                this.f4038a = c03242;
            }

            public void m4458a(bm bmVar, int i) {
                CBLogging.m383c(af.f4836d, "post-popup dismissed");
            }
        }

        C03242(af afVar, C0269a c0269a) {
            this.f768b = afVar;
            this.f767a = c0269a;
        }

        public void run() {
            C0389a c0389a = new C0389a();
            c0389a.m1024a(this.f767a.m442e(DatabaseOpenHelper.HISTORY_ROW_TITLE)).m1026b(this.f767a.m442e(Method.TEXT)).m1027c(this.f767a.m442e("confirm"));
            c0389a.m1025a(this.f768b.m721d(), new C12171(this));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.af.3 */
    class C12183 implements C0310a {
        final /* synthetic */ af f4039a;

        C12183(af afVar) {
            this.f4039a = afVar;
        }

        public void m4459a(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didClickRewardedVideo(c0291a.f600e);
            }
        }

        public void m4461b(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCloseRewardedVideo(c0291a.f600e);
            }
        }

        public void m4462c(C0291a c0291a) {
            this.f4039a.m5711s(c0291a);
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDismissRewardedVideo(c0291a.f600e);
            }
        }

        public void m4463d(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCacheRewardedVideo(c0291a.f600e);
            }
        }

        public void m4460a(C0291a c0291a, CBImpressionError cBImpressionError) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToLoadRewardedVideo(c0291a.f600e, cBImpressionError);
            }
        }

        public void m4464e(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDisplayRewardedVideo(c0291a.f600e);
            }
        }

        public boolean m4465f(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m663g().shouldDisplayRewardedVideo(c0291a.f600e);
            }
            return true;
        }

        public boolean m4466g(C0291a c0291a) {
            return true;
        }

        public boolean m4467h(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m679v();
            }
            return true;
        }
    }

    static {
        f4836d = "CBRewardedVideo";
    }

    private af() {
    }

    public static af m5701j() {
        if (f4835c == null) {
            f4835c = new af();
        }
        return f4835c;
    }

    protected boolean m5704b(C0291a c0291a, C0269a c0269a) {
        return true;
    }

    protected C0291a m5703a(String str, boolean z) {
        return new C0291a(C0286a.REWARDED_VIDEO, z, str, false, m727f());
    }

    protected az m5707f(C0291a c0291a) {
        az azVar = null;
        if (C0299c.m628B() == "/reward/get") {
            c0291a.f596a = C0287b.NATIVE;
        } else {
            c0291a.f596a = C0287b.WEB;
        }
        if (c0291a.f596a == C0287b.NATIVE) {
            Object i = m4453i();
            if (i == null || i.length() == 0) {
                CBLogging.m381b(f4836d, "Local video list is empty so cannot make any video request as adserver will not return anything");
                m710a(c0291a, CBImpressionError.EMPTY_LOCAL_VIDEO_LIST);
                be.m972b();
            } else {
                azVar = new az(C0299c.m628B());
                azVar.m869a("local-videos", i);
                azVar.m866a(C0414a.HIGH);
                azVar.m869a("location", c0291a.f600e);
                if (c0291a.f602g) {
                    azVar.m869a("cache", SchemaSymbols.ATTVAL_TRUE_1);
                    azVar.m875b(true);
                }
                azVar.m863a(C0292b.f622b);
            }
        } else {
            C0269a a = C0297b.m600a(true);
            if (a.m458o() == 0 && (C0297b.m616f() || Chartboost.isFirstHardBootup)) {
                CBLogging.m381b(f4836d, "Asset Download is in progress, so wait and retry request until its complete");
                C0297b.f648a.add(c0291a);
            } else {
                azVar = new bd(C0299c.m628B());
                azVar.m4581a("ad_units", a, C0364a.AD);
                azVar.m866a(C0414a.HIGH);
                azVar.m863a(C0292b.f626f);
                azVar.m4581a("location", c0291a.f600e, C0364a.AD);
                if (c0291a.f602g) {
                    azVar.m4581a("cache", Boolean.valueOf(true), C0364a.AD);
                    azVar.m875b(true);
                } else {
                    azVar.m4581a("cache", Boolean.valueOf(false), C0364a.AD);
                }
            }
        }
        return azVar;
    }

    public az m5710m(C0291a c0291a) {
        az m = super.m4455m(c0291a);
        m.m867a("/reward/show");
        return m;
    }

    protected void m5709j(C0291a c0291a) {
    }

    protected void m5708i(C0291a c0291a) {
        C0269a a = c0291a.m563A().m431a("ux").m431a("pre-popup");
        if (a.m438c() && a.m431a(DatabaseOpenHelper.HISTORY_ROW_TITLE).m441d() && a.m431a(Method.TEXT).m441d() && a.m431a("confirm").m441d() && a.m431a("cancel").m441d() && m721d() != null) {
            a.post(new C03231(this, a, c0291a));
        } else {
            super.m732i(c0291a);
        }
    }

    protected void m5711s(C0291a c0291a) {
        C0269a a = c0291a.m563A().m431a("ux").m431a("post-popup");
        if (a.m438c() && a.m431a(DatabaseOpenHelper.HISTORY_ROW_TITLE).m441d() && a.m431a(Method.TEXT).m441d() && a.m431a("confirm").m441d() && m721d() != null && c0291a.f608m) {
            a.post(new C03242(this, a));
        }
    }

    public C0310a m5705c() {
        return new C12183(this);
    }

    public String m5706e() {
        return String.format("%s-%s", new Object[]{"rewarded-video", m729g()});
    }
}
