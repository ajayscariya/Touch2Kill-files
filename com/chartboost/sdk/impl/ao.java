package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.Libraries.C0271e;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.ai.C1518a;
import com.chartboost.sdk.impl.bh.C0378a;

public final class ao extends RelativeLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final CharSequence f803a;
    private static Handler f804l;
    private RelativeLayout f805b;
    private an f806c;
    private an f807d;
    private bl f808e;
    private TextView f809f;
    private ak f810g;
    private bh f811h;
    private ai f812i;
    private boolean f813j;
    private boolean f814k;
    private Runnable f815m;
    private Runnable f816n;
    private Runnable f817o;

    /* renamed from: com.chartboost.sdk.impl.ao.2 */
    class C03332 implements Runnable {
        final /* synthetic */ ao f798a;

        C03332(ao aoVar) {
            this.f798a = aoVar;
        }

        public void run() {
            this.f798a.m817d(false);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.3 */
    class C03343 implements Runnable {
        final /* synthetic */ ao f799a;

        C03343(ao aoVar) {
            this.f799a = aoVar;
        }

        public void run() {
            if (this.f799a.f806c != null) {
                this.f799a.f806c.setVisibility(8);
            }
            if (this.f799a.f812i.f4854J) {
                this.f799a.f810g.setVisibility(8);
            }
            this.f799a.f807d.setVisibility(8);
            if (this.f799a.f808e != null) {
                this.f799a.f808e.setEnabled(false);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.4 */
    class C03354 implements Runnable {
        final /* synthetic */ ao f800a;
        private int f801b;

        C03354(ao aoVar) {
            this.f800a = aoVar;
            this.f801b = 0;
        }

        public void run() {
            if (this.f800a.f811h.m999a().m995e()) {
                float f;
                int d = this.f800a.f811h.m999a().m994d();
                if (d > 0) {
                    this.f800a.f812i.f4866t = d;
                    f = (float) this.f800a.f812i.f4866t;
                    if (this.f800a.f811h.m999a().m995e() && f / 1000.0f > 0.0f && !this.f800a.f812i.m5770u()) {
                        this.f800a.f812i.m5768s();
                        this.f800a.f812i.m5753a(true);
                    }
                }
                f = ((float) d) / ((float) this.f800a.f811h.m999a().m993c());
                if (this.f800a.f812i.f4854J) {
                    this.f800a.f810g.m4498a(f);
                }
                d /= 1000;
                if (this.f801b != d) {
                    this.f801b = d;
                    int i = d / 60;
                    d %= 60;
                    this.f800a.f809f.setText(String.format("%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(d)}));
                }
            }
            C1518a r = this.f800a.f812i.m5767r();
            if (r.m5727g()) {
                View b = r.m5722b(true);
                if (b.getVisibility() == 8) {
                    this.f800a.f812i.m774a(true, b);
                    b.setEnabled(true);
                }
            }
            ao.f804l.removeCallbacks(this.f800a.f817o);
            ao.f804l.postDelayed(this.f800a.f817o, 16);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.5 */
    class C03365 implements Runnable {
        final /* synthetic */ ao f802a;

        C03365(ao aoVar) {
            this.f802a = aoVar;
        }

        public void run() {
            this.f802a.f811h.setVisibility(0);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ao.1 */
    class C12271 extends bl {
        final /* synthetic */ ao f4082a;

        C12271(ao aoVar, Context context) {
            this.f4082a = aoVar;
            super(context);
        }

        protected void m4505a(MotionEvent motionEvent) {
            this.f4082a.f812i.m777a(null, C0271e.m461a(C0271e.m462a("paused", Integer.valueOf(1))));
        }
    }

    static {
        f803a = "00:00";
        f804l = CBUtility.m400e();
    }

    public ao(Context context, ai aiVar) {
        super(context);
        this.f813j = false;
        this.f814k = false;
        this.f815m = new C03332(this);
        this.f816n = new C03343(this);
        this.f817o = new C03354(this);
        this.f812i = aiVar;
        m812a(context);
    }

    private void m812a(Context context) {
        LayoutParams layoutParams;
        Context context2 = getContext();
        C0269a g = this.f812i.m785g();
        float f = getContext().getResources().getDisplayMetrics().density;
        int round = Math.round(f * 10.0f);
        this.f811h = new bh(context2);
        this.f812i.m5767r().m760a(this.f811h);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(13);
        addView(this.f811h, layoutParams2);
        this.f805b = new RelativeLayout(context2);
        if (g.m438c() && g.m431a("video-click-button").m438c()) {
            this.f806c = new an(context2);
            this.f806c.setVisibility(8);
            this.f808e = new C12271(this, context2);
            this.f808e.m1019a(ScaleType.FIT_CENTER);
            C1201j c1201j = this.f812i.f4850F;
            Point b = this.f812i.m4486b("video-click-button");
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.leftMargin = Math.round(((float) b.x) / c1201j.m4350g());
            layoutParams3.topMargin = Math.round(((float) b.y) / c1201j.m4350g());
            this.f812i.m4484a(layoutParams3, c1201j, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            this.f808e.m1020a(c1201j);
            this.f806c.addView(this.f808e, layoutParams3);
            layoutParams = new RelativeLayout.LayoutParams(-1, Math.round(((float) layoutParams3.height) + (10.0f * f)));
            layoutParams.addRule(10);
            this.f805b.addView(this.f806c, layoutParams);
        }
        this.f807d = new an(context2);
        this.f807d.setVisibility(8);
        layoutParams = new RelativeLayout.LayoutParams(-1, Math.round(32.5f * f));
        layoutParams.addRule(12);
        this.f805b.addView(this.f807d, layoutParams);
        this.f807d.setGravity(16);
        this.f807d.setPadding(round, round, round, round);
        this.f809f = new TextView(context2);
        this.f809f.setTextColor(-1);
        this.f809f.setTextSize(2, 11.0f);
        this.f809f.setText(f803a);
        this.f809f.setPadding(0, 0, round, 0);
        this.f809f.setSingleLine();
        this.f809f.measure(0, 0);
        int measuredWidth = this.f809f.getMeasuredWidth();
        this.f809f.setGravity(17);
        this.f807d.addView(this.f809f, new LinearLayout.LayoutParams(measuredWidth, -1));
        this.f810g = new ak(context2);
        this.f810g.setVisibility(8);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, Math.round(10.0f * f));
        layoutParams4.setMargins(0, CBUtility.m390a(1, getContext()), 0, 0);
        this.f807d.addView(this.f810g, layoutParams4);
        layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(6, this.f811h.getId());
        layoutParams4.addRule(8, this.f811h.getId());
        layoutParams4.addRule(5, this.f811h.getId());
        layoutParams4.addRule(7, this.f811h.getId());
        addView(this.f805b, layoutParams4);
        m823a();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.f808e != null) {
            this.f808e.setEnabled(enabled);
        }
        if (enabled) {
            m826a(false);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f804l.removeCallbacks(this.f817o);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent e) {
        if (!this.f811h.m999a().m995e() || e.getActionMasked() != 0) {
            return false;
        }
        if (this.f812i == null) {
            return true;
        }
        m817d(true);
        return true;
    }

    public void onCompletion(MediaPlayer arg0) {
        this.f812i.f4866t = this.f811h.m999a().m993c();
        if (this.f812i.m5767r() != null) {
            this.f812i.m5767r().m5726f();
        }
    }

    public void onPrepared(MediaPlayer mp) {
        this.f812i.f4867u = this.f811h.m999a().m993c();
        this.f812i.m5767r().m761a(true);
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        this.f812i.m5771v();
        return false;
    }

    private void m817d(boolean z) {
        m827a(!this.f813j, z);
    }

    protected void m827a(boolean z, boolean z2) {
        f804l.removeCallbacks(this.f815m);
        f804l.removeCallbacks(this.f816n);
        if (this.f812i.f4868v && this.f812i.m5766q() && z != this.f813j) {
            this.f813j = z;
            Animation alphaAnimation = this.f813j ? new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) : new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
            alphaAnimation.setDuration(z2 ? 100 : 200);
            alphaAnimation.setFillAfter(true);
            if (!(this.f814k || this.f806c == null)) {
                this.f806c.setVisibility(0);
                this.f806c.startAnimation(alphaAnimation);
                if (this.f808e != null) {
                    this.f808e.setEnabled(true);
                }
            }
            if (this.f812i.f4854J) {
                this.f810g.setVisibility(0);
            }
            this.f807d.setVisibility(0);
            this.f807d.startAnimation(alphaAnimation);
            if (this.f813j) {
                f804l.postDelayed(this.f815m, 3000);
            } else {
                f804l.postDelayed(this.f816n, alphaAnimation.getDuration());
            }
        }
    }

    public void m826a(boolean z) {
        f804l.removeCallbacks(this.f815m);
        f804l.removeCallbacks(this.f816n);
        if (z) {
            if (!(this.f814k || this.f806c == null)) {
                this.f806c.setVisibility(0);
            }
            if (this.f812i.f4854J) {
                this.f810g.setVisibility(0);
            }
            this.f807d.setVisibility(0);
            if (this.f808e != null) {
                this.f808e.setEnabled(true);
            }
        } else {
            if (this.f806c != null) {
                this.f806c.clearAnimation();
                this.f806c.setVisibility(8);
            }
            this.f807d.clearAnimation();
            if (this.f812i.f4854J) {
                this.f810g.setVisibility(8);
            }
            this.f807d.setVisibility(8);
            if (this.f808e != null) {
                this.f808e.setEnabled(false);
            }
        }
        this.f813j = z;
    }

    public void m829b(boolean z) {
        setBackgroundColor(z ? ViewCompat.MEASURED_STATE_MASK : 0);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!z) {
            layoutParams.addRule(6, this.f811h.getId());
            layoutParams.addRule(8, this.f811h.getId());
            layoutParams.addRule(5, this.f811h.getId());
            layoutParams.addRule(7, this.f811h.getId());
        }
        this.f805b.setLayoutParams(layoutParams);
        if (this.f806c != null) {
            this.f806c.setGravity(19);
            this.f806c.requestLayout();
        }
    }

    public void m823a() {
        m829b(CBUtility.m397c().m469a());
    }

    public C0378a m828b() {
        return this.f811h.m999a();
    }

    public ak m830c() {
        return this.f810g;
    }

    public void m824a(int i) {
        if (this.f806c != null) {
            this.f806c.setBackgroundColor(i);
        }
        this.f807d.setBackgroundColor(i);
    }

    public void m832d() {
        if (this.f806c != null) {
            this.f806c.setVisibility(8);
        }
        this.f814k = true;
        if (this.f808e != null) {
            this.f808e.setEnabled(false);
        }
    }

    public void m831c(boolean z) {
        this.f809f.setVisibility(z ? 0 : 8);
    }

    public void m825a(String str) {
        this.f811h.m999a().m988a((OnCompletionListener) this);
        this.f811h.m999a().m989a((OnErrorListener) this);
        this.f811h.m999a().m990a((OnPreparedListener) this);
        this.f811h.m999a().m991a(Uri.parse(str));
    }

    public void m833e() {
        f804l.postDelayed(new C03365(this), 500);
        this.f811h.m999a().m985a();
        f804l.removeCallbacks(this.f817o);
        f804l.postDelayed(this.f817o, 16);
    }

    public void m834f() {
        if (this.f811h.m999a().m995e()) {
            this.f812i.f4866t = this.f811h.m999a().m994d();
            this.f811h.m999a().m992b();
        }
        if (this.f812i.m5767r().d.getVisibility() == 0) {
            this.f812i.m5767r().d.postInvalidate();
        }
        f804l.removeCallbacks(this.f817o);
    }

    public void m835g() {
        if (this.f811h.m999a().m995e()) {
            this.f812i.f4866t = this.f811h.m999a().m994d();
        }
        this.f811h.m999a().m992b();
        f804l.removeCallbacks(this.f817o);
    }

    public void m836h() {
        this.f811h.setVisibility(8);
        invalidate();
    }

    public boolean m837i() {
        return this.f811h.m999a().m995e();
    }
}
