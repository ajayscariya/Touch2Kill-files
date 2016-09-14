package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0288c;
import com.chartboost.sdk.Model.C0291a.C0290e;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.bi;
import com.chartboost.sdk.impl.bi.C0382a;
import com.chartboost.sdk.impl.bi.C0383b;
import com.chartboost.sdk.impl.bq;
import com.wTouch2KiLL.MainNavigationActivity;

/* renamed from: com.chartboost.sdk.f */
public final class C0315f {
    private static C0315f f734c;
    private bq f735a;
    private C0291a f736b;
    private int f737d;

    /* renamed from: com.chartboost.sdk.f.2 */
    class C03132 implements Runnable {
        final /* synthetic */ C0291a f730a;
        final /* synthetic */ Activity f731b;
        final /* synthetic */ C0315f f732c;

        /* renamed from: com.chartboost.sdk.f.2.1 */
        class C12131 implements C0382a {
            final /* synthetic */ C03132 f4025a;

            /* renamed from: com.chartboost.sdk.f.2.1.1 */
            class C03121 implements Runnable {
                final /* synthetic */ C0291a f728a;
                final /* synthetic */ C12131 f729b;

                C03121(C12131 c12131, C0291a c0291a) {
                    this.f729b = c12131;
                    this.f728a = c0291a;
                }

                public void run() {
                    this.f729b.f4025a.f732c.m753d(this.f728a);
                }
            }

            C12131(C03132 c03132) {
                this.f4025a = c03132;
            }

            public void m4422a(C0291a c0291a) {
                CBUtility.m400e().post(new C03121(this, c0291a));
                c0291a.m584o();
                if (c0291a.f596a == C0287b.WEB) {
                    CBUtility.m395b(this.f4025a.f731b);
                }
                if (this.f4025a.f732c.f737d != -1) {
                    this.f4025a.f731b.getWindow().getDecorView().setSystemUiVisibility(this.f4025a.f732c.f737d);
                    this.f4025a.f732c.f737d = -1;
                }
            }
        }

        C03132(C0315f c0315f, C0291a c0291a, Activity activity) {
            this.f732c = c0315f;
            this.f730a = c0291a;
            this.f731b = activity;
        }

        public void run() {
            this.f730a.f598c = C0290e.DISMISSING;
            C0383b c0383b = C0383b.CBAnimationTypePerspectiveRotate;
            if (this.f730a.f596a == C0287b.WEB) {
                c0383b = C0383b.CBAnimationTypeFade;
            }
            if (this.f730a.f599d == C0286a.MORE_APPS) {
                c0383b = C0383b.CBAnimationTypePerspectiveZoom;
            }
            C0383b a = C0383b.m1001a(this.f730a.m563A().m444f("animation"));
            if (a != null) {
                c0383b = a;
            }
            if (C0299c.m666i()) {
                c0383b = C0383b.CBAnimationTypeNone;
            }
            bi.m1006b(c0383b, this.f730a, new C12131(this));
        }
    }

    /* renamed from: com.chartboost.sdk.f.3 */
    static /* synthetic */ class C03143 {
        static final /* synthetic */ int[] f733a;

        static {
            f733a = new int[C0290e.values().length];
            try {
                f733a[C0290e.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.f.1 */
    class C12121 implements C0382a {
        final /* synthetic */ C0315f f4024a;

        C12121(C0315f c0315f) {
            this.f4024a = c0315f;
        }

        public void m4421a(C0291a c0291a) {
            c0291a.m588s();
        }
    }

    private C0315f() {
        this.f735a = null;
        this.f737d = -1;
    }

    public static C0315f m744a() {
        if (f734c == null) {
            f734c = new C0315f();
        }
        return f734c;
    }

    public void m747a(C0291a c0291a) {
        switch (C03143.f733a[c0291a.f598c.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (c0291a.f605j && C0299c.m680w()) {
                    m746f(c0291a);
                }
            default:
                m745e(c0291a);
        }
    }

    private void m745e(C0291a c0291a) {
        if (this.f735a == null || this.f735a.m1046h() == c0291a) {
            Object obj = c0291a.f598c != C0290e.DISPLAYED ? 1 : null;
            c0291a.f598c = C0290e.DISPLAYED;
            Activity f = Chartboost.m345f();
            if (c0291a.f596a == C0287b.NATIVE) {
                CBImpressionError cBImpressionError = f == null ? CBImpressionError.NO_HOST_ACTIVITY : null;
                if (cBImpressionError == null) {
                    cBImpressionError = c0291a.m581l();
                }
                if (cBImpressionError != null) {
                    CBLogging.m381b("CBViewController", "Unable to create the view while trying th display the impression");
                    c0291a.m567a(cBImpressionError);
                    return;
                }
            }
            if (this.f735a == null) {
                this.f735a = new bq(f, c0291a);
                f.addContentView(this.f735a, new LayoutParams(-1, -1));
            }
            if (c0291a.f596a == C0287b.WEB) {
                CBUtility.m393a(f);
            }
            if (this.f737d == -1) {
                this.f737d = f.getWindow().getDecorView().getSystemUiVisibility();
                CBUtility.m398c(f);
            }
            this.f735a.m1039a();
            CBLogging.m381b("CBViewController", "Displaying the impression");
            c0291a.f604i = this.f735a;
            if (obj != null) {
                if (c0291a.f596a == C0287b.NATIVE) {
                    this.f735a.m1043e().m1009a();
                }
                C0383b c0383b = C0383b.CBAnimationTypePerspectiveRotate;
                if (c0291a.f596a == C0287b.WEB) {
                    c0383b = C0383b.CBAnimationTypeFade;
                }
                if (c0291a.f599d == C0286a.MORE_APPS) {
                    c0383b = C0383b.CBAnimationTypePerspectiveZoom;
                }
                C0383b a = C0383b.m1001a(c0291a.m563A().m444f("animation"));
                if (a != null) {
                    c0383b = a;
                }
                if (C0299c.m666i()) {
                    c0383b = C0383b.CBAnimationTypeNone;
                }
                c0291a.m587r();
                bi.m1002a(c0383b, c0291a, new C12121(this));
                if (C0299c.m663g() != null && (c0291a.f601f == C0288c.INTERSTITIAL_VIDEO || c0291a.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO)) {
                    C0299c.m663g().willDisplayVideo(c0291a.f600e);
                }
                if (c0291a.m590u().m714b() != null) {
                    c0291a.m590u().m714b().m700e(c0291a);
                    return;
                }
                return;
            }
            return;
        }
        CBLogging.m381b("CBViewController", "Impression already visible");
        c0291a.m567a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }

    public void m750b(C0291a c0291a) {
        CBLogging.m381b("CBViewController", "Dismissing impression");
        Runnable c03132 = new C03132(this, c0291a, Chartboost.m345f());
        if (c0291a.f607l) {
            c0291a.m568a(c03132);
        } else {
            c03132.run();
        }
    }

    private void m746f(C0291a c0291a) {
        Context f = Chartboost.m345f();
        if (f == null) {
            CBLogging.m385d(this, "No host activity to display loading view");
            return;
        }
        if (this.f735a == null) {
            this.f735a = new bq(f, c0291a);
            f.addContentView(this.f735a, new LayoutParams(-1, -1));
        }
        this.f735a.m1040b();
        this.f736b = c0291a;
    }

    public void m748a(C0291a c0291a, boolean z) {
        if (c0291a == null) {
            return;
        }
        if (c0291a == this.f736b || c0291a == C0304d.m686a().m693c()) {
            this.f736b = null;
            CBLogging.m381b("CBViewController", "Dismissing loading view");
            if (m752c()) {
                this.f735a.m1041c();
                if (z && this.f735a != null && this.f735a.m1046h() != null) {
                    m753d(this.f735a.m1046h());
                }
            }
        }
    }

    public void m751c(C0291a c0291a) {
        CBLogging.m381b("CBViewController", "Removing impression silently");
        if (m752c()) {
            m748a(c0291a, false);
        }
        c0291a.m580k();
        try {
            ((ViewGroup) this.f735a.getParent()).removeView(this.f735a);
        } catch (Throwable e) {
            CBLogging.m382b("CBViewController", "Exception removing impression silently", e);
        }
        this.f735a = null;
    }

    public void m753d(C0291a c0291a) {
        CBLogging.m381b("CBViewController", "Removing impression");
        c0291a.f598c = C0290e.NONE;
        if (this.f735a != null) {
            try {
                ((ViewGroup) this.f735a.getParent()).removeView(this.f735a);
            } catch (Throwable e) {
                CBLogging.m382b("CBViewController", "Exception removing impression ", e);
            }
            c0291a.m579j();
            this.f735a = null;
            if (C0299c.m665h()) {
                m749b();
            }
            c0291a.m590u().m714b().m698c(c0291a);
            if (c0291a.m565C()) {
                c0291a.m590u().m714b().m697b(c0291a);
            }
        } else if (C0299c.m665h()) {
            m749b();
        }
    }

    public void m749b() {
        CBLogging.m381b("CBViewController", " Closing impression activity");
        Activity f = Chartboost.m345f();
        if (f != null && (f instanceof CBImpressionActivity)) {
            CBLogging.m381b("CBViewController", " Closing impression activity #######");
            Chartboost.m348g();
            f.finish();
        }
    }

    public boolean m752c() {
        return this.f735a != null && this.f735a.m1045g();
    }

    public boolean m754d() {
        return this.f735a != null;
    }

    public bq m755e() {
        return this.f735a;
    }
}
