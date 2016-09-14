package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0272f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.bi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.chartboost.sdk.g */
public abstract class C0320g {
    public static Handler f749a;
    public boolean f750b;
    protected List<C0319b> f751c;
    protected List<C0319b> f752d;
    protected C0269a f753e;
    protected C0291a f754f;
    protected C0272f f755g;
    public Map<Integer, Runnable> f756h;
    protected boolean f757i;
    protected boolean f758j;
    private boolean f759k;
    private C0318a f760l;

    /* renamed from: com.chartboost.sdk.g.1 */
    class C03161 implements Runnable {
        final /* synthetic */ boolean f738a;
        final /* synthetic */ View f739b;
        final /* synthetic */ C0320g f740c;

        C03161(C0320g c0320g, boolean z, View view) {
            this.f740c = c0320g;
            this.f738a = z;
            this.f739b = view;
        }

        public void run() {
            if (!this.f738a) {
                this.f739b.setVisibility(8);
                this.f739b.setClickable(false);
            }
            this.f740c.f756h.remove(Integer.valueOf(this.f739b.hashCode()));
        }
    }

    /* renamed from: com.chartboost.sdk.g.a */
    public abstract class C0318a extends RelativeLayout {
        final /* synthetic */ C0320g f742a;
        private boolean f743b;
        private int f744c;
        private int f745d;
        private int f746e;
        private int f747f;
        private C0272f f748g;

        /* renamed from: com.chartboost.sdk.g.a.1 */
        class C03171 implements Runnable {
            final /* synthetic */ C0318a f741a;

            C03171(C0318a c0318a) {
                this.f741a = c0318a;
            }

            public void run() {
                this.f741a.requestLayout();
            }
        }

        protected abstract void m759a(int i, int i2);

        public C0318a(C0320g c0320g, Context context) {
            this.f742a = c0320g;
            super(context);
            this.f743b = false;
            this.f744c = -1;
            this.f745d = -1;
            this.f746e = -1;
            this.f747f = -1;
            this.f748g = null;
            c0320g.f760l = this;
            c0320g.f759k = false;
            setFocusableInTouchMode(true);
            requestFocus();
        }

        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            this.f746e = w;
            this.f747f = h;
            if (this.f744c != -1 && this.f745d != -1 && this.f742a.f754f != null && this.f742a.f754f.f596a == C0287b.NATIVE) {
                m758a();
            }
        }

        private boolean m757b(int i, int i2) {
            boolean z = true;
            if (this.f742a.f754f != null && this.f742a.f754f.f596a == C0287b.WEB) {
                return true;
            }
            if (this.f743b) {
                return false;
            }
            C0272f c = CBUtility.m397c();
            if (this.f744c == i && this.f745d == i2 && this.f748g == c) {
                return true;
            }
            this.f743b = true;
            try {
                if (this.f742a.f757i && c.m469a()) {
                    this.f742a.f755g = c;
                } else if (this.f742a.f758j && c.m470b()) {
                    this.f742a.f755g = c;
                }
                m759a(i, i2);
                post(new C03171(this));
                this.f744c = i;
                this.f745d = i2;
                this.f748g = c;
            } catch (Throwable e) {
                CBLogging.m382b("CBViewProtocol", "Exception raised while layouting Subviews", e);
                z = false;
            }
            this.f743b = false;
            return z;
        }

        public final void m758a() {
            m761a(false);
        }

        public final void m761a(boolean z) {
            if (z) {
                this.f748g = null;
            }
            m762a((Activity) getContext());
        }

        public void m763b() {
        }

        public boolean m762a(Activity activity) {
            if (this.f746e == -1 || this.f747f == -1) {
                int width;
                int height;
                try {
                    width = getWidth();
                    height = getHeight();
                    if (width == 0 || height == 0) {
                        View findViewById = activity.getWindow().findViewById(16908290);
                        if (findViewById == null) {
                            findViewById = activity.getWindow().getDecorView();
                        }
                        width = findViewById.getWidth();
                        height = findViewById.getHeight();
                    }
                } catch (Exception e) {
                    height = 0;
                    width = 0;
                }
                if (width == 0 || r0 == 0) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    width = displayMetrics.widthPixels;
                    height = displayMetrics.heightPixels;
                }
                this.f746e = width;
                this.f747f = height;
            }
            return m757b(this.f746e, this.f747f);
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            for (int i = 0; i < this.f742a.f756h.size(); i++) {
                C0320g.f749a.removeCallbacks((Runnable) this.f742a.f756h.get(Integer.valueOf(i)));
            }
            this.f742a.f756h.clear();
        }

        public final void m760a(View view) {
            int i = 200;
            if (200 == getId()) {
                i = 201;
            }
            int i2 = i;
            View findViewById = findViewById(i);
            while (findViewById != null) {
                i2++;
                findViewById = findViewById(i2);
            }
            view.setId(i2);
            view.setSaveEnabled(false);
        }

        protected boolean m764c() {
            return C0320g.m768a(getContext());
        }
    }

    /* renamed from: com.chartboost.sdk.g.b */
    public interface C0319b {
        boolean m765a();
    }

    protected abstract C0318a m778b(Context context);

    static {
        f749a = CBUtility.m400e();
    }

    public static boolean m768a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public C0320g(C0291a c0291a) {
        this.f750b = false;
        this.f751c = new ArrayList();
        this.f752d = new ArrayList();
        this.f756h = Collections.synchronizedMap(new HashMap());
        this.f757i = true;
        this.f758j = true;
        this.f754f = c0291a;
        this.f760l = null;
        this.f755g = CBUtility.m397c();
        this.f759k = false;
    }

    public C0272f m770a() {
        return this.f755g;
    }

    public boolean m776a(C0269a c0269a) {
        this.f753e = c0269a.m431a("assets");
        if (!this.f753e.m435b()) {
            return true;
        }
        CBLogging.m381b("CBViewProtocol", "Media got from the response is null or empty");
        m772a(CBImpressionError.INVALID_RESPONSE);
        return false;
    }

    public void m773a(C0319b c0319b) {
        if (c0319b.m765a()) {
            this.f752d.remove(c0319b);
        }
        this.f751c.remove(c0319b);
        if (this.f751c.isEmpty() && !m780b()) {
            CBLogging.m381b("CBViewProtocol", "Error while downloading the assets");
            m772a(CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        }
    }

    public boolean m780b() {
        if (this.f752d.isEmpty()) {
            m787i();
            return true;
        }
        CBLogging.m385d("CBViewProtocol", "not completed loading assets for impression");
        return false;
    }

    public CBImpressionError m781c() {
        Activity f = Chartboost.m345f();
        if (f == null) {
            this.f760l = null;
            return CBImpressionError.NO_HOST_ACTIVITY;
        } else if (!this.f758j && !this.f757i) {
            return CBImpressionError.WRONG_ORIENTATION;
        } else {
            this.f755g = CBUtility.m397c();
            if ((this.f755g.m470b() && !this.f758j) || (this.f755g.m469a() && !this.f757i)) {
                return CBImpressionError.ERROR_CREATING_VIEW;
            }
            if (this.f760l == null) {
                this.f760l = m778b((Context) f);
            }
            if (this.f754f.f596a != C0287b.NATIVE || this.f760l.m762a(f)) {
                return null;
            }
            this.f760l = null;
            return CBImpressionError.ERROR_CREATING_VIEW;
        }
    }

    public void m782d() {
        m784f();
        for (int i = 0; i < this.f756h.size(); i++) {
            f749a.removeCallbacks((Runnable) this.f756h.get(Integer.valueOf(i)));
        }
        this.f756h.clear();
    }

    public C0318a m783e() {
        return this.f760l;
    }

    public void m784f() {
        if (this.f760l != null) {
            this.f760l.m763b();
        }
        this.f760l = null;
    }

    public C0269a m785g() {
        return this.f753e;
    }

    public void m779b(C0319b c0319b) {
        this.f751c.add(c0319b);
        this.f752d.add(c0319b);
    }

    protected void m772a(CBImpressionError cBImpressionError) {
        this.f754f.m567a(cBImpressionError);
    }

    protected void m786h() {
        if (!this.f759k) {
            this.f759k = true;
            this.f754f.m572c();
        }
    }

    protected void m787i() {
        this.f754f.m573d();
    }

    public boolean m777a(String str, C0269a c0269a) {
        return this.f754f.m570a(str, c0269a);
    }

    public void m774a(boolean z, View view) {
        m775a(z, view, true);
    }

    public void m775a(boolean z, View view, boolean z2) {
        int i = 8;
        if (((z && view.getVisibility() == 0) || (!z && view.getVisibility() == 8)) && this.f756h.get(Integer.valueOf(view.hashCode())) == null) {
            return;
        }
        if (z2) {
            Runnable c03161 = new C03161(this, z, view);
            long j = 500;
            if (this.f754f.f596a == C0287b.WEB) {
                j = 1000;
            }
            bi.m1005a(z, view, j);
            m771a(view, c03161, j);
            return;
        }
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
        view.setClickable(z);
    }

    protected void m771a(View view, Runnable runnable, long j) {
        Runnable runnable2 = (Runnable) this.f756h.get(Integer.valueOf(view.hashCode()));
        if (runnable2 != null) {
            f749a.removeCallbacks(runnable2);
        }
        this.f756h.put(Integer.valueOf(view.hashCode()), runnable);
        f749a.postDelayed(runnable, j);
    }

    public static int m766a(String str) {
        int i = 0;
        if (str != null) {
            if (!str.startsWith("#")) {
                try {
                    i = Color.parseColor(str);
                } catch (IllegalArgumentException e) {
                    str = "#" + str;
                }
            }
            if (str.length() == 4 || str.length() == 5) {
                StringBuilder stringBuilder = new StringBuilder((str.length() * 2) + 1);
                stringBuilder.append("#");
                for (int i2 = i; i2 < str.length() - 1; i2++) {
                    stringBuilder.append(str.charAt(i2 + 1));
                    stringBuilder.append(str.charAt(i2 + 1));
                }
                str = stringBuilder.toString();
            }
            try {
                i = Color.parseColor(str);
            } catch (Throwable e2) {
                CBLogging.m386d("CBViewProtocol", "error parsing color " + str, e2);
            }
        }
        return i;
    }

    public float m788j() {
        return 0.0f;
    }

    public float m789k() {
        return 0.0f;
    }

    public boolean m790l() {
        return false;
    }

    public void m791m() {
        if (this.f750b) {
            this.f750b = false;
        }
        if (m783e() != null && CBUtility.m397c() != m783e().f748g) {
            m783e().m761a(false);
        }
    }

    public void m792n() {
        this.f750b = true;
    }
}
