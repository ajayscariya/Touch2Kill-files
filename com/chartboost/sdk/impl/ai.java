package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0288c;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.ah.C1222a;
import com.chartboost.sdk.impl.am.C0332a;
import com.chartboost.sdk.impl.bm.C0389a;
import com.chartboost.sdk.impl.bm.C0390b;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xml.serialize.Method;

public class ai extends ah {
    protected int f4845A;
    protected C1201j f4846B;
    protected C1201j f4847C;
    protected C1201j f4848D;
    protected C1201j f4849E;
    protected C1201j f4850F;
    protected C1201j f4851G;
    protected C1201j f4852H;
    protected C1201j f4853I;
    protected boolean f4854J;
    protected boolean f4855K;
    protected boolean f4856L;
    private boolean f4857M;
    private boolean f4858N;
    private boolean f4859O;
    private boolean f4860P;
    private boolean f4861Q;
    protected C0329b f4862p;
    protected int f4863q;
    protected String f4864r;
    protected String f4865s;
    protected int f4866t;
    protected int f4867u;
    protected boolean f4868v;
    protected boolean f4869w;
    protected boolean f4870x;
    protected boolean f4871y;
    protected boolean f4872z;

    /* renamed from: com.chartboost.sdk.impl.ai.2 */
    static /* synthetic */ class C03252 {
        static final /* synthetic */ int[] f769a;

        static {
            f769a = new int[C0329b.values().length];
            try {
                f769a[C0329b.REWARD_OFFER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f769a[C0329b.VIDEO_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f769a[C0329b.POST_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ai.b */
    protected enum C0329b {
        REWARD_OFFER,
        VIDEO_PLAYING,
        POST_VIDEO
    }

    /* renamed from: com.chartboost.sdk.impl.ai.1 */
    class C12231 extends C0390b {
        final /* synthetic */ ai f4065a;

        C12231(ai aiVar) {
            this.f4065a = aiVar;
        }

        public void m4489a(bm bmVar) {
            C1518a r = this.f4065a.m5767r();
            if (r != null) {
                r.f4839i.m833e();
            }
        }

        public void m4490a(bm bmVar, int i) {
            C1518a r = this.f4065a.m5767r();
            if (i != 1) {
                if (r != null) {
                    r.m5718d(false);
                    r.f4839i.m836h();
                }
                this.f4065a.m786h();
            } else if (r != null) {
                r.f4839i.m833e();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ai.a */
    public class C1518a extends C1222a {
        final /* synthetic */ ai f4837g;
        private bl f4838h;
        private ao f4839i;
        private al f4840j;
        private View f4841k;
        private ag f4842l;
        private aj f4843m;
        private bl f4844n;

        /* renamed from: com.chartboost.sdk.impl.ai.a.3 */
        class C03263 implements Runnable {
            final /* synthetic */ C1518a f770a;

            C03263(C1518a c1518a) {
                this.f770a = c1518a;
            }

            public void run() {
                boolean z;
                String str = "InterstitialVideoViewProtocol";
                String str2 = "controls %s automatically from timer";
                Object[] objArr = new Object[1];
                objArr[0] = this.f770a.f4837g.f4868v ? "hidden" : "shown";
                CBLogging.m383c(str, String.format(str2, objArr));
                ao b = this.f770a.f4839i;
                if (this.f770a.f4837g.f4868v) {
                    z = false;
                } else {
                    z = true;
                }
                b.m827a(z, true);
                this.f770a.f4837g.h.remove(Integer.valueOf(this.f770a.f4839i.hashCode()));
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.4 */
        class C03274 implements Runnable {
            final /* synthetic */ C1518a f771a;

            C03274(C1518a c1518a) {
                this.f771a = c1518a;
            }

            public void run() {
                this.f771a.f4843m.m807a(false);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.5 */
        class C03285 implements Runnable {
            final /* synthetic */ C1518a f772a;

            C03285(C1518a c1518a) {
                this.f772a = c1518a;
            }

            public void run() {
                this.f772a.f4837g.m786h();
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.1 */
        class C12241 extends bl {
            final /* synthetic */ ai f4066a;
            final /* synthetic */ C1518a f4067b;

            C12241(C1518a c1518a, Context context, ai aiVar) {
                this.f4067b = c1518a;
                this.f4066a = aiVar;
                super(context);
            }

            protected void m4491a(MotionEvent motionEvent) {
                if (this.f4067b.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                    this.f4067b.f4843m.m807a(false);
                }
                if (this.f4067b.f4837g.f4862p == C0329b.VIDEO_PLAYING) {
                    this.f4067b.m5718d(false);
                }
                this.f4067b.m5717c(true);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ai.a.2 */
        class C12252 extends bl {
            final /* synthetic */ ai f4068a;
            final /* synthetic */ C1518a f4069b;

            C12252(C1518a c1518a, Context context, ai aiVar) {
                this.f4069b = c1518a;
                this.f4068a = aiVar;
                super(context);
            }

            protected void m4492a(MotionEvent motionEvent) {
                this.f4069b.m5725e();
            }
        }

        private C1518a(ai aiVar, Context context) {
            this.f4837g = aiVar;
            super(aiVar, context);
            if (aiVar.f4855K) {
                this.f4841k = new View(context);
                this.f4841k.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.f4841k.setVisibility(8);
                addView(this.f4841k);
            }
            if (aiVar.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                this.f4840j = new al(context, aiVar);
                this.f4840j.setVisibility(8);
                addView(this.f4840j);
            }
            this.f4839i = new ao(context, aiVar);
            this.f4839i.setVisibility(8);
            addView(this.f4839i);
            this.f4842l = new ag(context, aiVar);
            this.f4842l.setVisibility(8);
            addView(this.f4842l);
            if (aiVar.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                this.f4843m = new aj(context, aiVar);
                this.f4843m.setVisibility(8);
                addView(this.f4843m);
            }
            this.f4838h = new C12241(this, getContext(), aiVar);
            this.f4838h.setVisibility(8);
            addView(this.f4838h);
            this.f4844n = new C12252(this, getContext(), aiVar);
            this.f4844n.setVisibility(8);
            addView(this.f4844n);
            if (aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m439c("background-color") && aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m439c("border-color") && aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m439c("progress-color") && aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m439c("radius")) {
                aiVar.f4854J = true;
                ak c = this.f4839i.m830c();
                c.m4499a(C0320g.m766a(aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m442e("background-color")));
                c.m4502b(C0320g.m766a(aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m442e("border-color")));
                c.m4503c(C0320g.m766a(aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m442e("progress-color")));
                c.m4501b(aiVar.m.m431a(NotificationCompatApi21.CATEGORY_PROGRESS).m431a("radius").m452j());
            }
            if (aiVar.m.m431a("video-controls-background").m439c("color")) {
                this.f4839i.m824a(C0320g.m766a(aiVar.m.m431a("video-controls-background").m442e("color")));
            }
            if (aiVar.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && aiVar.f4870x) {
                this.f4842l.m4470a(aiVar.m.m431a("post-video-toaster").m442e(DatabaseOpenHelper.HISTORY_ROW_TITLE), aiVar.m.m431a("post-video-toaster").m442e("tagline"));
            }
            if (aiVar.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && aiVar.f4869w) {
                this.f4840j.m801a(aiVar.m.m431a("confirmation").m442e(Method.TEXT), C0320g.m766a(aiVar.m.m431a("confirmation").m442e("color")));
            }
            if (aiVar.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && aiVar.f4871y) {
                this.f4843m.m806a(aiVar.m.m431a("post-video-reward-toaster").m431a("position").equals("inside-top") ? C0332a.TOP : C0332a.BOTTOM);
                this.f4843m.m4495a(aiVar.m.m431a("post-video-reward-toaster").m442e(Method.TEXT));
                if (aiVar.f4851G.m4348e()) {
                    this.f4843m.m4494a(aiVar.f4853I);
                }
            }
            if (aiVar.e.m431a("video-click-button").m435b()) {
                this.f4839i.m832d();
            }
            this.f4839i.m831c(aiVar.m.m453j("video-progress-timer-enabled"));
            if (aiVar.f4856L || aiVar.f4855K) {
                this.e.setVisibility(4);
            }
            aiVar.f4865s = aiVar.e.m431a(aiVar.m770a().m469a() ? "video-portrait" : "video-landscape").m442e("id");
            if (TextUtils.isEmpty(aiVar.f4865s)) {
                aiVar.m772a(CBImpressionError.VIDEO_ID_MISSING);
                return;
            }
            if (aiVar.f4864r == null) {
                aiVar.f4864r = C0278h.m492a(aiVar.f4865s);
            }
            if (aiVar.f4864r == null) {
                aiVar.m772a(CBImpressionError.VIDEO_UNAVAILABLE);
            } else {
                this.f4839i.m825a(aiVar.f4864r);
            }
        }

        protected void m5724d() {
            super.m4477d();
            if (this.f4837g.f4862p != C0329b.REWARD_OFFER || (this.f4837g.f4869w && !this.f4837g.m5764o())) {
                m5714a(this.f4837g.f4862p, false);
            } else {
                m5717c(false);
            }
        }

        public void m5726f() {
            m5718d(true);
            this.f4839i.m836h();
            ai aiVar = this.f4837g;
            aiVar.f4863q++;
            if (this.f4837g.f4863q <= 1 && !this.f4837g.f4861Q && this.f4837g.f4866t >= 1) {
                this.f4837g.f.m576g();
            }
        }

        protected void m5721a(int i, int i2) {
            super.m4475a(i, i2);
            m5714a(this.f4837g.f4862p, false);
            boolean a = this.f4837g.m770a().m469a();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            this.f4837g.m4484a(layoutParams2, a ? this.f4837g.f4847C : this.f4837g.f4846B, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            Point b = this.f4837g.m4486b(a ? "replay-portrait" : "replay-landscape");
            int round = Math.round(((((float) layoutParams6.leftMargin) + (((float) layoutParams6.width) / 2.0f)) + ((float) b.x)) - (((float) layoutParams2.width) / 2.0f));
            int round2 = Math.round((((((float) layoutParams6.height) / 2.0f) + ((float) layoutParams6.topMargin)) + ((float) b.y)) - (((float) layoutParams2.height) / 2.0f));
            layoutParams2.leftMargin = Math.min(Math.max(0, round), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams2.height);
            this.f4838h.bringToFront();
            if (a) {
                this.f4838h.m1020a(this.f4837g.f4847C);
            } else {
                this.f4838h.m1020a(this.f4837g.f4846B);
            }
            layoutParams6 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            if (this.f4837g.m5769t()) {
                LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
                C1201j c1201j = a ? this.f4837g.k : this.f4837g.l;
                this.f4837g.m4484a(layoutParams7, c1201j, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                layoutParams7.leftMargin = 0;
                layoutParams7.topMargin = 0;
                layoutParams7.addRule(11);
                this.f4844n.setLayoutParams(layoutParams7);
                this.f4844n.m1020a(c1201j);
            } else {
                layoutParams3.width = layoutParams6.width;
                layoutParams3.height = layoutParams6.height;
                layoutParams3.leftMargin = layoutParams6.leftMargin;
                layoutParams3.topMargin = layoutParams6.topMargin;
                layoutParams4.width = layoutParams6.width;
                layoutParams4.height = layoutParams6.height;
                layoutParams4.leftMargin = layoutParams6.leftMargin;
                layoutParams4.topMargin = layoutParams6.topMargin;
            }
            layoutParams5.width = layoutParams6.width;
            layoutParams5.height = 72;
            layoutParams5.leftMargin = layoutParams6.leftMargin;
            layoutParams5.topMargin = (layoutParams6.height + layoutParams6.topMargin) - 72;
            if (this.f4837g.f4855K) {
                this.f4841k.setLayoutParams(layoutParams);
            }
            if (this.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                this.f4840j.setLayoutParams(layoutParams3);
            }
            this.f4839i.setLayoutParams(layoutParams4);
            this.f4842l.setLayoutParams(layoutParams5);
            this.f4838h.setLayoutParams(layoutParams2);
            if (this.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                this.f4840j.m800a();
            }
            this.f4839i.m823a();
        }

        private void m5717c(boolean z) {
            if (this.f4837g.f4862p != C0329b.VIDEO_PLAYING) {
                if (this.f4837g.f4869w) {
                    m5714a(C0329b.REWARD_OFFER, z);
                    return;
                }
                m5714a(C0329b.VIDEO_PLAYING, z);
                if (this.f4837g.f4863q >= 1 || !this.f4837g.m.m431a("timer").m439c("delay")) {
                    this.f4839i.m826a(!this.f4837g.f4868v);
                } else {
                    String str = "InterstitialVideoViewProtocol";
                    String str2 = "controls starting %s, setting timer";
                    Object[] objArr = new Object[1];
                    objArr[0] = this.f4837g.f4868v ? "visible" : "hidden";
                    CBLogging.m383c(str, String.format(str2, objArr));
                    this.f4839i.m826a(this.f4837g.f4868v);
                    this.f4837g.m771a(this.f4839i, new C03263(this), Math.round(1000.0d * this.f4837g.m.m431a("timer").m448h("delay")));
                }
                this.f4839i.m833e();
                if (this.f4837g.f4863q <= 1) {
                    this.f4837g.f.m577h();
                }
            }
        }

        private void m5718d(boolean z) {
            this.f4839i.m834f();
            if (this.f4837g.f4862p == C0329b.VIDEO_PLAYING && z) {
                if (this.f4837g.f4863q < 1 && this.f4837g.m.m439c("post-video-reward-toaster") && this.f4837g.f4871y && this.f4837g.f4851G.m4348e() && this.f4837g.f4852H.m4348e()) {
                    m5719e(true);
                }
                m5714a(C0329b.POST_VIDEO, true);
                if (CBUtility.m397c().m469a()) {
                    requestLayout();
                }
            }
        }

        private void m5719e(boolean z) {
            if (z) {
                this.f4843m.m807a(true);
            } else {
                this.f4843m.setVisibility(0);
            }
            C0320g.f749a.postDelayed(new C03274(this), 2500);
        }

        private void m5714a(C0329b c0329b, boolean z) {
            boolean z2;
            boolean z3 = true;
            this.f4837g.f4862p = c0329b;
            switch (C03252.f769a[c0329b.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    this.f4837g.m775a(!this.f4837g.m5769t(), this.d, z);
                    if (this.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                        this.f4837g.m775a(true, this.f4840j, z);
                    }
                    if (this.f4837g.f4855K) {
                        this.f4837g.m775a(false, this.f4841k, z);
                    }
                    this.f4837g.m775a(false, this.f4839i, z);
                    this.f4837g.m775a(false, this.f4838h, z);
                    this.f4837g.m775a(false, this.f4842l, z);
                    this.d.setEnabled(false);
                    this.f4838h.setEnabled(false);
                    this.f4839i.setEnabled(false);
                    break;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    this.f4837g.m775a(false, this.d, z);
                    if (this.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                        this.f4837g.m775a(false, this.f4840j, z);
                    }
                    if (this.f4837g.f4855K) {
                        this.f4837g.m775a(true, this.f4841k, z);
                    }
                    this.f4837g.m775a(true, this.f4839i, z);
                    this.f4837g.m775a(false, this.f4838h, z);
                    this.f4837g.m775a(false, this.f4842l, z);
                    this.d.setEnabled(true);
                    this.f4838h.setEnabled(false);
                    this.f4839i.setEnabled(true);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    this.f4837g.m775a(true, this.d, z);
                    if (this.f4837g.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO) {
                        this.f4837g.m775a(false, this.f4840j, z);
                    }
                    if (this.f4837g.f4855K) {
                        this.f4837g.m775a(false, this.f4841k, z);
                    }
                    this.f4837g.m775a(false, this.f4839i, z);
                    this.f4837g.m775a(true, this.f4838h, z);
                    z2 = this.f4837g.f4852H.m4348e() && this.f4837g.f4851G.m4348e() && this.f4837g.f4870x;
                    this.f4837g.m775a(z2, this.f4842l, z);
                    this.f4838h.setEnabled(true);
                    this.d.setEnabled(true);
                    this.f4839i.setEnabled(false);
                    if (this.f4837g.f4872z) {
                        m5719e(false);
                        break;
                    }
                    break;
            }
            z2 = m5727g();
            View b = m5722b(true);
            b.setEnabled(z2);
            this.f4837g.m775a(z2, b, z);
            View b2 = m5722b(false);
            b2.setEnabled(false);
            this.f4837g.m775a(false, b2, z);
            if (this.f4837g.f4856L || this.f4837g.f4855K) {
                this.f4837g.m775a(!this.f4837g.m5769t(), this.e, z);
            }
            ai aiVar = this.f4837g;
            if (this.f4837g.m5769t()) {
                z2 = false;
            } else {
                z2 = true;
            }
            aiVar.m775a(z2, this.b, z);
            if (c0329b == C0329b.REWARD_OFFER) {
                z3 = false;
            }
            m761a(z3);
        }

        protected boolean m5727g() {
            if (this.f4837g.f4862p == C0329b.VIDEO_PLAYING && this.f4837g.f4863q < 1) {
                float a = this.f4837g.e.m431a("close-" + (this.f4837g.m770a().m469a() ? "portrait" : "landscape")).m431a("delay").m429a(-1.0f);
                int round = a >= 0.0f ? Math.round(a * 1000.0f) : -1;
                this.f4837g.f4845A = round;
                if (round < 0) {
                    return false;
                }
                if (round > this.f4839i.m828b().m994d()) {
                    return false;
                }
            }
            return true;
        }

        public void m5723b() {
            this.f4837g.m5763n();
            super.m4476b();
        }

        protected void m5725e() {
            if (this.f4837g.f4862p == C0329b.VIDEO_PLAYING && this.f4837g.m.m431a("cancel-popup").m439c(DatabaseOpenHelper.HISTORY_ROW_TITLE) && this.f4837g.m.m431a("cancel-popup").m439c(Method.TEXT) && this.f4837g.m.m431a("cancel-popup").m439c("cancel") && this.f4837g.m.m431a("cancel-popup").m439c("confirm")) {
                this.f4839i.m835g();
                if (this.f4837g.f4863q < 1) {
                    this.f4837g.m5765p();
                    return;
                }
            }
            if (this.f4837g.f4862p == C0329b.VIDEO_PLAYING) {
                m5718d(false);
                this.f4839i.m836h();
                if (this.f4837g.f4863q < 1) {
                    ai aiVar = this.f4837g;
                    aiVar.f4863q++;
                    this.f4837g.f.m576g();
                }
            }
            C0320g.f749a.post(new C03285(this));
        }

        protected void m5720a(float f, float f2) {
            if ((!this.f4837g.f4868v || this.f4837g.f4862p != C0329b.VIDEO_PLAYING) && this.f4837g.f4862p != C0329b.REWARD_OFFER) {
                m5728h();
            }
        }

        protected void m5728h() {
            if (this.f4837g.f4862p == C0329b.VIDEO_PLAYING) {
                m5718d(false);
            }
            this.f4837g.m777a(null, null);
        }

        protected void m5729i() {
            this.f4837g.f4869w = false;
            m5717c(true);
        }

        public bl m5722b(boolean z) {
            return (!(this.f4837g.m5769t() && z) && (this.f4837g.m5769t() || z)) ? this.c : this.f4844n;
        }
    }

    public /* synthetic */ C0318a m5757e() {
        return m5767r();
    }

    public ai(C0291a c0291a) {
        super(c0291a);
        this.f4862p = C0329b.REWARD_OFFER;
        this.f4857M = true;
        this.f4858N = false;
        this.f4859O = false;
        this.f4866t = 0;
        this.f4867u = 0;
        this.f4860P = false;
        this.f4861Q = false;
        this.f4872z = false;
        this.f4845A = 0;
        this.f4854J = false;
        this.f4855K = false;
        this.f4856L = false;
        this.f4862p = C0329b.REWARD_OFFER;
        this.f4846B = new C1201j(this);
        this.f4847C = new C1201j(this);
        this.f4848D = new C1201j(this);
        this.f4849E = new C1201j(this);
        this.f4850F = new C1201j(this);
        this.f4851G = new C1201j(this);
        this.f4852H = new C1201j(this);
        this.f4853I = new C1201j(this);
        this.f4863q = 0;
    }

    public boolean m5764o() {
        return this.f.f601f == C0288c.INTERSTITIAL_VIDEO;
    }

    public void m5765p() {
        C0389a c0389a = new C0389a();
        c0389a.m1024a(this.m.m431a("cancel-popup").m442e(DatabaseOpenHelper.HISTORY_ROW_TITLE)).m1026b(this.m.m431a("cancel-popup").m442e(Method.TEXT)).m1028d(this.m.m431a("cancel-popup").m442e("confirm")).m1027c(this.m.m431a("cancel-popup").m442e("cancel"));
        c0389a.m1025a(m5767r().getContext(), new C12231(this));
    }

    protected C0318a m5755b(Context context) {
        return new C1518a(context, null);
    }

    public boolean m5761l() {
        if (!(m5767r().m5722b(true).getVisibility() == 4 || m5767r().m5722b(true).getVisibility() == 8)) {
            m5767r().m5725e();
        }
        return true;
    }

    public void m5762m() {
        super.m791m();
        if (this.f4862p == C0329b.VIDEO_PLAYING && this.f4858N) {
            m5767r().f4839i.m828b().m986a(this.f4866t);
            if (!this.f4859O) {
                m5767r().f4839i.m833e();
            }
        }
        this.f4859O = false;
        this.f4858N = false;
    }

    public void m5763n() {
        super.m792n();
        if (this.f4862p == C0329b.VIDEO_PLAYING && !this.f4858N) {
            if (!m5767r().f4839i.m837i()) {
                this.f4859O = true;
            }
            this.f4858N = true;
            m5767r().f4839i.m835g();
        }
    }

    public boolean m5754a(C0269a c0269a) {
        boolean z = false;
        if (!super.m4485a(c0269a)) {
            return false;
        }
        if (this.e.m436b("video-landscape") || this.e.m436b("replay-landscape")) {
            this.j = false;
        }
        this.f4846B.m4343a("replay-landscape");
        this.f4847C.m4343a("replay-portrait");
        this.f4850F.m4343a("video-click-button");
        this.f4851G.m4343a("post-video-reward-icon");
        this.f4852H.m4343a("post-video-button");
        this.f4848D.m4343a("video-confirmation-button");
        this.f4849E.m4343a("video-confirmation-icon");
        this.f4853I.m4343a("post-video-reward-icon");
        this.f4868v = c0269a.m431a("ux").m453j("video-controls-togglable");
        this.f4855K = c0269a.m431a("fullscreen").m435b() ? false : c0269a.m431a("fullscreen").m456m();
        if (!c0269a.m431a("preroll_popup_fullscreen").m435b()) {
            z = c0269a.m431a("preroll_popup_fullscreen").m456m();
        }
        this.f4856L = z;
        if (this.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && this.m.m431a("post-video-toaster").m439c(DatabaseOpenHelper.HISTORY_ROW_TITLE) && this.m.m431a("post-video-toaster").m439c("tagline")) {
            this.f4870x = true;
        }
        if (this.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && this.m.m431a("confirmation").m439c(Method.TEXT) && this.m.m431a("confirmation").m439c("color")) {
            this.f4869w = true;
        }
        if (this.f.f601f == C0288c.INTERSTITIAL_REWARD_VIDEO && this.m.m439c("post-video-reward-toaster")) {
            this.f4871y = true;
        }
        return true;
    }

    protected void m5758i() {
        if (this.f4869w && !(this.f4848D.m4348e() && this.f4849E.m4348e())) {
            this.f4869w = false;
        }
        if (this.f4857M) {
            super.m787i();
        } else {
            m772a(CBImpressionError.ERROR_DISPLAYING_VIEW);
        }
    }

    public void m5756d() {
        super.m4488d();
        this.f4846B.m4347d();
        this.f4847C.m4347d();
        this.f4850F.m4347d();
        this.f4851G.m4347d();
        this.f4852H.m4347d();
        this.f4848D.m4347d();
        this.f4849E.m4347d();
        this.f4853I.m4347d();
        this.f4846B = null;
        this.f4847C = null;
        this.f4850F = null;
        this.f4851G = null;
        this.f4852H = null;
        this.f4848D = null;
        this.f4849E = null;
        this.f4853I = null;
    }

    public boolean m5766q() {
        return this.f4862p == C0329b.VIDEO_PLAYING;
    }

    public C1518a m5767r() {
        return (C1518a) super.m783e();
    }

    protected void m5768s() {
        this.f.m591v();
    }

    protected boolean m5769t() {
        boolean z = true;
        if (this.f4862p == C0329b.POST_VIDEO) {
            return false;
        }
        boolean a = CBUtility.m397c().m469a();
        if (this.f4862p == C0329b.REWARD_OFFER) {
            if (this.f4856L || a) {
                return true;
            }
            return false;
        } else if (this.f4862p != C0329b.VIDEO_PLAYING) {
            if (!a || this.f4862p == C0329b.POST_VIDEO) {
                z = false;
            }
            return z;
        } else if (this.f4855K || a) {
            return true;
        } else {
            return false;
        }
    }

    public boolean m5770u() {
        return this.f4860P;
    }

    public void m5753a(boolean z) {
        this.f4860P = z;
    }

    public void m5771v() {
        this.f4861Q = true;
        be.m973b(this.f4865s);
        m772a(CBImpressionError.ERROR_PLAYING_VIDEO);
    }

    public float m5759j() {
        return (float) this.f4867u;
    }

    public float m5760k() {
        return (float) this.f4866t;
    }
}
