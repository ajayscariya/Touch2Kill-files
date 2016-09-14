package com.chartboost.sdk.Model;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0311e;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.aw;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.bq;
import com.chartboost.sdk.impl.bu;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.Date;
import mf.javax.xml.transform.OutputKeys;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.chartboost.sdk.Model.a */
public final class C0291a {
    public C0287b f596a;
    public Date f597b;
    public C0290e f598c;
    public C0286a f599d;
    public String f600e;
    public C0288c f601f;
    public boolean f602g;
    public boolean f603h;
    public bq f604i;
    public boolean f605j;
    public boolean f606k;
    public boolean f607l;
    public boolean f608m;
    public boolean f609n;
    public az f610o;
    public boolean f611p;
    public boolean f612q;
    public boolean f613r;
    public boolean f614s;
    private C0269a f615t;
    private boolean f616u;
    private Boolean f617v;
    private C0320g f618w;
    private C0289d f619x;
    private Runnable f620y;

    /* renamed from: com.chartboost.sdk.Model.a.1 */
    static /* synthetic */ class C02851 {
        static final /* synthetic */ int[] f575a;

        static {
            f575a = new int[C0286a.values().length];
            try {
                f575a[C0286a.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f575a[C0286a.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f575a[C0286a.MORE_APPS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f575a[C0286a.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Model.a.a */
    public enum C0286a {
        INTERSTITIAL,
        MORE_APPS,
        REWARDED_VIDEO,
        NONE
    }

    /* renamed from: com.chartboost.sdk.Model.a.b */
    public enum C0287b {
        NATIVE,
        WEB
    }

    /* renamed from: com.chartboost.sdk.Model.a.c */
    public enum C0288c {
        INTERSTITIAL,
        INTERSTITIAL_VIDEO,
        INTERSTITIAL_REWARD_VIDEO,
        NONE
    }

    /* renamed from: com.chartboost.sdk.Model.a.d */
    public interface C0289d {
        void m557a(C0291a c0291a);

        void m558a(C0291a c0291a, CBImpressionError cBImpressionError);

        void m559a(C0291a c0291a, String str, C0269a c0269a);

        void m560b(C0291a c0291a);

        void m561c(C0291a c0291a);

        void m562d(C0291a c0291a);
    }

    /* renamed from: com.chartboost.sdk.Model.a.e */
    public enum C0290e {
        LOADING,
        LOADED,
        DISPLAYED,
        CACHED,
        DISMISSING,
        NONE
    }

    public C0291a(C0286a c0286a, boolean z, String str, boolean z2, C0287b c0287b) {
        this.f596a = C0287b.NATIVE;
        this.f617v = null;
        this.f606k = false;
        this.f607l = false;
        this.f608m = false;
        this.f609n = false;
        this.f612q = false;
        this.f613r = false;
        this.f614s = false;
        this.f598c = C0290e.LOADING;
        this.f602g = z;
        this.f603h = false;
        this.f611p = false;
        this.f613r = true;
        this.f599d = c0286a;
        this.f605j = z2;
        this.f615t = C0269a.f470a;
        this.f601f = C0288c.NONE;
        this.f600e = str;
        this.f616u = true;
        this.f596a = c0287b;
        if (this.f600e == null) {
            this.f600e = CBLocation.LOCATION_DEFAULT;
        }
    }

    public void m566a(C0269a c0269a, C0289d c0289d) {
        boolean z;
        if (c0269a == null) {
            c0269a = C0269a.m425a();
        }
        this.f615t = c0269a;
        this.f597b = new Date();
        this.f598c = C0290e.LOADING;
        this.f619x = c0289d;
        Object e = this.f615t.m442e("type");
        if (TextUtils.isEmpty(e) || !e.equals("native")) {
            this.f596a = C0287b.WEB;
        } else {
            this.f596a = C0287b.NATIVE;
        }
        if (this.f596a == C0287b.NATIVE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (C02851.f575a[this.f599d.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    if (!c0269a.m431a(OutputKeys.MEDIA_TYPE).equals("video")) {
                        this.f601f = C0288c.INTERSTITIAL;
                        this.f618w = new ah(this);
                        break;
                    }
                    this.f601f = C0288c.INTERSTITIAL_VIDEO;
                    this.f618w = new ai(this);
                    this.f616u = false;
                    break;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    this.f601f = C0288c.INTERSTITIAL_REWARD_VIDEO;
                    this.f618w = new ai(this);
                    this.f616u = false;
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    this.f618w = new aw(this);
                    this.f616u = false;
                    break;
            }
        }
        switch (C02851.f575a[this.f599d.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                this.f601f = C0288c.INTERSTITIAL_VIDEO;
                this.f616u = false;
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                this.f601f = C0288c.INTERSTITIAL_REWARD_VIDEO;
                this.f616u = false;
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                this.f616u = false;
                break;
        }
        this.f618w = new bu(this);
        this.f618w.m776a(c0269a);
    }

    public boolean m569a() {
        return this.f616u;
    }

    public boolean m571b() {
        if (C0299c.m647b() == null || this.f616u) {
            return false;
        }
        return true;
    }

    public void m572c() {
        if (this.f619x != null) {
            this.f613r = true;
            this.f619x.m560b(this);
        }
    }

    public void m573d() {
        if (this.f619x != null) {
            this.f619x.m557a(this);
        }
    }

    public boolean m570a(String str, C0269a c0269a) {
        if (this.f598c != C0290e.DISPLAYED || this.f607l) {
            return false;
        }
        if (str == null) {
            str = this.f615t.m442e("link");
        }
        String e = this.f615t.m442e("deep-link");
        if (!TextUtils.isEmpty(e)) {
            try {
                if (bb.m941a(e)) {
                    try {
                        this.f617v = new Boolean(true);
                        str = e;
                    } catch (Exception e2) {
                        str = e;
                    }
                } else {
                    this.f617v = new Boolean(false);
                }
            } catch (Exception e3) {
            }
        }
        if (this.f611p) {
            return false;
        }
        this.f611p = true;
        this.f613r = false;
        this.f619x.m559a(this, str, c0269a);
        return true;
    }

    public boolean m574e() {
        return this.f617v != null;
    }

    public boolean m575f() {
        return this.f617v.booleanValue();
    }

    public void m567a(CBImpressionError cBImpressionError) {
        if (this.f619x != null) {
            this.f619x.m558a(this, cBImpressionError);
        }
    }

    public void m576g() {
        if (this.f619x != null) {
            this.f619x.m561c(this);
        }
    }

    public void m577h() {
        if (this.f619x != null) {
            this.f619x.m562d(this);
        }
    }

    public boolean m578i() {
        if (this.f618w != null) {
            this.f618w.m780b();
            if (this.f618w.m783e() != null) {
                return true;
            }
        }
        CBLogging.m381b("CBImpression", "reinitializing -- no view protocol exists!!");
        CBLogging.m387e("CBImpression", "reinitializing -- view not yet created");
        return false;
    }

    public void m579j() {
        m580k();
        if (this.f603h) {
            if (this.f618w != null) {
                this.f618w.m782d();
            }
            this.f618w = null;
            CBLogging.m381b("CBImpression", "Destroying the view and view data");
        }
    }

    public void m580k() {
        if (this.f604i != null) {
            this.f604i.m1042d();
            try {
                if (!(this.f618w == null || this.f618w.m783e() == null || this.f618w.m783e().getParent() == null)) {
                    this.f604i.removeView(this.f618w.m783e());
                }
            } catch (Throwable e) {
                CBLogging.m382b("CBImpression", "Exception raised while cleaning up views", e);
            }
            this.f604i = null;
        }
        if (this.f618w != null) {
            this.f618w.m784f();
        }
        CBLogging.m381b("CBImpression", "Destroying the view");
    }

    public CBImpressionError m581l() {
        if (this.f618w != null) {
            return this.f618w.m781c();
        }
        return CBImpressionError.ERROR_CREATING_VIEW;
    }

    public C0318a m582m() {
        if (this.f618w != null) {
            return this.f618w.m783e();
        }
        return null;
    }

    public void m583n() {
        if (this.f618w != null && this.f618w.m783e() != null) {
            this.f618w.m783e().setVisibility(0);
        }
    }

    public void m584o() {
        if (this.f618w != null && this.f618w.m783e() != null) {
            this.f618w.m783e().setVisibility(8);
        }
    }

    public void m585p() {
        if (this.f618w != null && this.f618w.m783e() != null) {
            ViewParent parent = this.f618w.m783e().getParent();
            if (parent == null || !(parent instanceof View)) {
                m584o();
            } else {
                ((View) parent).setVisibility(0);
            }
        }
    }

    public void m586q() {
        if (this.f618w != null && this.f618w.m783e() != null) {
            ViewParent parent = this.f618w.m783e().getParent();
            if (parent == null || !(parent instanceof View)) {
                m583n();
            } else {
                ((View) parent).setVisibility(8);
            }
        }
    }

    public void m568a(Runnable runnable) {
        this.f620y = runnable;
    }

    public void m587r() {
        this.f607l = true;
    }

    public void m588s() {
        if (this.f620y != null) {
            this.f620y.run();
            this.f620y = null;
        }
        this.f607l = false;
        this.f606k = false;
    }

    public String m589t() {
        return this.f615t.m442e("ad_id");
    }

    public C0311e m590u() {
        switch (C02851.f575a[this.f599d.ordinal()]) {
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                return af.m5701j();
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return av.m4531h();
            default:
                return ae.m4445h();
        }
    }

    public void m591v() {
        m590u().m734k(this);
    }

    public boolean m592w() {
        if (this.f618w != null) {
            return this.f618w.m790l();
        }
        return false;
    }

    public void m593x() {
        this.f611p = false;
        if (this.f618w != null && this.f612q) {
            this.f612q = false;
            this.f618w.m791m();
        }
    }

    public void m594y() {
        this.f611p = false;
    }

    public void m595z() {
        if (this.f618w != null && !this.f612q) {
            this.f612q = true;
            this.f618w.m792n();
        }
    }

    public C0269a m563A() {
        return this.f615t == null ? C0269a.f470a : this.f615t;
    }

    public C0320g m564B() {
        return this.f618w;
    }

    public boolean m565C() {
        return this.f613r;
    }
}
