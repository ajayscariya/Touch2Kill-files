package com.chartboost.sdk;

import android.app.Activity;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0289d;
import com.chartboost.sdk.Model.C0291a.C0290e;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C1203a;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.bb.C0358a;
import com.chartboost.sdk.impl.bq;
import com.chartboost.sdk.impl.bu;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.chartboost.sdk.d */
public final class C0304d {
    private static final String f704c;
    private static C0304d f705d;
    public C0289d f706a;
    public C0358a f707b;
    private bb f708e;

    /* renamed from: com.chartboost.sdk.d.4 */
    static /* synthetic */ class C03014 {
        static final /* synthetic */ int[] f703a;

        static {
            f703a = new int[C0290e.values().length];
            try {
                f703a[C0290e.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f703a[C0290e.CACHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f703a[C0290e.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f703a[C0290e.DISPLAYED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.d.a */
    public interface C0302a {
        void m684a(boolean z);
    }

    /* renamed from: com.chartboost.sdk.d.b */
    public interface C0303b {
        void m685a();
    }

    /* renamed from: com.chartboost.sdk.d.1 */
    class C12081 implements C0302a {
        final /* synthetic */ C0291a f4016a;
        final /* synthetic */ String f4017b;
        final /* synthetic */ C0303b f4018c;
        final /* synthetic */ C0304d f4019d;

        /* renamed from: com.chartboost.sdk.d.1.1 */
        class C03001 implements Runnable {
            final /* synthetic */ boolean f701a;
            final /* synthetic */ C12081 f702b;

            C03001(C12081 c12081, boolean z) {
                this.f702b = c12081;
                this.f701a = z;
            }

            public void run() {
                if (this.f702b.f4016a != null) {
                    if (this.f702b.f4016a.m571b()) {
                        this.f702b.f4016a.m585p();
                    }
                    if (!this.f701a) {
                        this.f702b.f4016a.m593x();
                    }
                    if (this.f702b.f4016a.m569a() && this.f702b.f4016a.f598c == C0290e.DISPLAYED) {
                        C0315f h = Chartboost.m350h();
                        if (h != null) {
                            h.m750b(this.f702b.f4016a);
                        }
                    }
                }
                if (this.f701a) {
                    this.f702b.f4019d.m689a(this.f702b.f4016a, this.f702b.f4017b, this.f702b.f4018c);
                } else {
                    this.f702b.f4019d.f707b.m937a(this.f702b.f4016a, false, this.f702b.f4017b, CBClickError.AGE_GATE_FAILURE, this.f702b.f4018c);
                }
            }
        }

        C12081(C0304d c0304d, C0291a c0291a, String str, C0303b c0303b) {
            this.f4019d = c0304d;
            this.f4016a = c0291a;
            this.f4017b = str;
            this.f4018c = c0303b;
        }

        public void m4411a(boolean z) {
            Chartboost.m327a(new C03001(this, z));
        }
    }

    /* renamed from: com.chartboost.sdk.d.2 */
    class C12092 implements C0289d {
        final /* synthetic */ C0304d f4020a;

        C12092(C0304d c0304d) {
            this.f4020a = c0304d;
        }

        public void m4412a(C0291a c0291a) {
            synchronized (this.f4020a) {
                boolean z = c0291a.f602g;
            }
            if (c0291a.f598c == C0290e.LOADING) {
                c0291a.f598c = C0290e.LOADED;
                if (z) {
                    c0291a.m590u().m708a(c0291a);
                } else {
                    c0291a.m590u().m741r(c0291a);
                }
            }
            if (!z || c0291a.f598c == C0290e.DISPLAYED) {
                c0291a.m590u().m731h(c0291a);
            }
            c0291a.m590u().m739p(c0291a);
        }

        public void m4415b(C0291a c0291a) {
            if (c0291a.f598c == C0290e.DISPLAYED) {
                C0315f h = Chartboost.m350h();
                if (h != null) {
                    h.m750b(c0291a);
                }
            }
            C1203a.m4373c(c0291a.m590u().m724e(), c0291a.f600e, c0291a.m589t());
        }

        public void m4414a(C0291a c0291a, String str, C0269a c0269a) {
            c0291a.m590u().m714b().m695a(c0291a);
            if (!C0299c.m678u() && c0291a.m569a() && c0291a.f598c == C0290e.DISPLAYED) {
                C0315f h = Chartboost.m350h();
                if (h != null) {
                    h.m750b(c0291a);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                C0269a A = c0291a.m563A();
                az d = this.f4020a.m694d();
                d.m868a("ad_id", A);
                d.m868a("to", A);
                d.m868a("cgn", A);
                d.m868a("creative", A);
                d.m868a("cgn", c0269a);
                d.m868a("creative", c0269a);
                d.m868a("type", c0269a);
                d.m868a("more_type", c0269a);
                d.m869a("location", c0291a.f600e);
                if (c0291a.m574e()) {
                    d.m869a("retarget_reinstall", Boolean.valueOf(c0291a.m575f()));
                }
                c0291a.f610o = d;
                this.f4020a.m691b(c0291a, str, null);
            } else {
                this.f4020a.f707b.m937a(c0291a, false, str, CBClickError.URI_INVALID, null);
            }
            C1203a.m4370b(c0291a.m590u().m724e(), c0291a.f600e, c0291a.m589t());
        }

        public void m4413a(C0291a c0291a, CBImpressionError cBImpressionError) {
            C0311e u = c0291a.m590u();
            C1203a.m4360a(u.m724e(), c0291a.f600e, c0291a.m589t(), cBImpressionError);
            u.m710a(c0291a, cBImpressionError);
        }

        public void m4416c(C0291a c0291a) {
            c0291a.f608m = true;
            if (c0291a.f599d == C0286a.REWARDED_VIDEO && C0299c.m663g() != null) {
                C0299c.m663g().didCompleteRewardedVideo(c0291a.f600e, c0291a.m563A().m444f("reward"));
            }
            C0304d.m688b(c0291a);
        }

        public void m4417d(C0291a c0291a) {
            c0291a.f609n = true;
        }
    }

    /* renamed from: com.chartboost.sdk.d.3 */
    class C12103 implements C0358a {
        final /* synthetic */ C0304d f4021a;

        C12103(C0304d c0304d) {
            this.f4021a = c0304d;
        }

        public void m4418a(C0291a c0291a, boolean z, String str, CBClickError cBClickError, C0303b c0303b) {
            if (c0291a != null) {
                c0291a.f611p = false;
                if (c0291a.m569a()) {
                    c0291a.f598c = C0290e.DISMISSING;
                }
            }
            if (z) {
                if (c0291a != null && c0291a.f610o != null) {
                    c0291a.f610o.m871a(true);
                    c0291a.f610o.m894s();
                } else if (c0303b != null) {
                    c0303b.m685a();
                }
            } else if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToRecordClick(str, cBClickError);
            }
        }
    }

    static {
        f704c = C0304d.class.getSimpleName();
    }

    private C0304d() {
        this.f706a = new C12092(this);
        this.f707b = new C12103(this);
        this.f708e = bb.m938a(this.f707b);
    }

    public static C0304d m686a() {
        if (f705d == null) {
            f705d = new C0304d();
        }
        return f705d;
    }

    public final void m689a(C0291a c0291a, String str, C0303b c0303b) {
        this.f708e.m942a(c0291a, str, Chartboost.getHostActivity(), c0303b);
    }

    public final void m691b(C0291a c0291a, String str, C0303b c0303b) {
        C0299c.f675a = new C12081(this, c0291a, str, c0303b);
        if (!C0299c.m678u()) {
            m689a(c0291a, str, c0303b);
        } else if (C0299c.m663g() != null) {
            if (c0291a != null) {
                if (c0291a.m571b()) {
                    c0291a.m586q();
                }
                c0291a.m595z();
                c0291a.f611p = false;
            }
            if (c0291a == null) {
                C0299c.m663g().didPauseClickForConfirmation(Chartboost.getHostActivity());
            } else {
                C0299c.m663g().didPauseClickForConfirmation(Chartboost.m345f());
            }
        }
    }

    protected final boolean m692b() {
        C0291a c = m693c();
        if (c == null) {
            return false;
        }
        c.f613r = true;
        this.f706a.m560b(c);
        return true;
    }

    private static synchronized void m688b(C0291a c0291a) {
        synchronized (C0304d.class) {
            az azVar = new az("/api/video-complete");
            azVar.m869a("location", c0291a.f600e);
            azVar.m869a("reward", c0291a.m563A().m442e("reward"));
            azVar.m869a("currency-name", c0291a.m563A().m442e("currency-name"));
            azVar.m869a("ad_id", c0291a.m589t());
            azVar.m869a("force_close", Boolean.valueOf(false));
            C0320g c0320g = null;
            if (c0291a.f596a == C0287b.NATIVE && c0291a.m582m() != null) {
                c0320g = (ai) c0291a.m564B();
            } else if (c0291a.f596a == C0287b.WEB && c0291a.m582m() != null) {
                bu buVar = (bu) c0291a.m564B();
            }
            if (c0320g != null) {
                float k = c0320g.m789k();
                float j = c0320g.m788j();
                CBLogging.m379a(c0291a.m590u().getClass().getSimpleName(), String.format("TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(j), Float.valueOf(k)}));
                azVar.m869a("total_time", Float.valueOf(j / 1000.0f));
                if (k <= 0.0f) {
                    azVar.m869a("playback_time", Float.valueOf(j / 1000.0f));
                } else {
                    azVar.m869a("playback_time", Float.valueOf(k / 1000.0f));
                }
            }
            azVar.m871a(true);
            azVar.m894s();
        }
    }

    protected final C0291a m693c() {
        C0315f h = Chartboost.m350h();
        bq e = h == null ? null : h.m755e();
        if (e == null) {
            return null;
        }
        return e.m1046h();
    }

    public az m694d() {
        az azVar = new az("/api/click");
        if (Chartboost.m345f() == null) {
            Chartboost.getValidContext();
        }
        return azVar;
    }

    public final boolean m690a(Activity activity, C0291a c0291a) {
        if (c0291a != null) {
            switch (C03014.f703a[c0291a.f598c.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    if (c0291a.f605j) {
                        Chartboost.m326a(c0291a);
                        break;
                    }
                    break;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    Chartboost.m326a(c0291a);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    if (!c0291a.m578i()) {
                        if (C0299c.m647b() == null || !C0299c.m647b().doesWrapperUseCustomBackgroundingBehavior() || (activity instanceof CBImpressionActivity)) {
                            C0315f h = Chartboost.m350h();
                            if (h != null) {
                                CBLogging.m381b(f704c, "Error onActivityStart " + c0291a.f598c.name());
                                h.m753d(c0291a);
                                break;
                            }
                        }
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
