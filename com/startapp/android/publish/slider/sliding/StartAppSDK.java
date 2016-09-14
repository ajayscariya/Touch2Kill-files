package com.startapp.android.publish.slider.sliding;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.Arrays;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.startapp.android.publish.slider.sliding.c */
public class StartAppSDK {
    private static final Interpolator f3566v;
    private int f3567a;
    private int f3568b;
    private int f3569c;
    private float[] f3570d;
    private float[] f3571e;
    private float[] f3572f;
    private float[] f3573g;
    private int[] f3574h;
    private int[] f3575i;
    private int[] f3576j;
    private int f3577k;
    private VelocityTracker f3578l;
    private float f3579m;
    private float f3580n;
    private int f3581o;
    private int f3582p;
    private StartAppSDK f3583q;
    private final StartAppSDK f3584r;
    private View f3585s;
    private boolean f3586t;
    private final ViewGroup f3587u;
    private final Runnable f3588w;

    /* renamed from: com.startapp.android.publish.slider.sliding.c.1 */
    static class StartAppSDK implements Interpolator {
        StartAppSDK() {
        }

        public float getInterpolation(float t) {
            t -= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            return ((((t * t) * t) * t) * t) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.c.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3565a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3565a = startAppSDK;
        }

        public void run() {
            this.f3565a.m3838c(0);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.c.a */
    public static abstract class StartAppSDK {
        public abstract boolean m3796a(View view, int i);

        public void m3792a(int i) {
        }

        public void m3795a(View view, int i, int i2, int i3, int i4) {
        }

        public void m3800b(View view, int i) {
        }

        public void m3794a(View view, float f, float f2) {
        }

        public void m3793a(int i, int i2) {
        }

        public boolean m3801b(int i) {
            return false;
        }

        public void m3799b(int i, int i2) {
        }

        public int m3802c(int i) {
            return i;
        }

        public int m3790a(View view) {
            return 0;
        }

        public int m3797b(View view) {
            return 0;
        }

        public int m3791a(View view, int i, int i2) {
            return 0;
        }

        public int m3798b(View view, int i, int i2) {
            return 0;
        }
    }

    static {
        f3566v = new StartAppSDK();
    }

    public static StartAppSDK m3807a(ViewGroup viewGroup, StartAppSDK startAppSDK) {
        return new StartAppSDK(viewGroup.getContext(), viewGroup, startAppSDK);
    }

    public static StartAppSDK m3806a(ViewGroup viewGroup, float f, StartAppSDK startAppSDK) {
        StartAppSDK a = StartAppSDK.m3807a(viewGroup, startAppSDK);
        a.f3568b = (int) (((float) a.f3568b) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / f));
        return a;
    }

    private StartAppSDK(Context context, ViewGroup viewGroup, StartAppSDK startAppSDK) {
        this.f3569c = -1;
        this.f3588w = new StartAppSDK(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (startAppSDK == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f3587u = viewGroup;
            this.f3584r = startAppSDK;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f3581o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f3568b = viewConfiguration.getScaledTouchSlop();
            this.f3579m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f3580n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f3583q = StartAppSDK.m3678a(context, f3566v);
        }
    }

    public void m3824a(float f) {
        this.f3580n = f;
    }

    public int m3823a() {
        return this.f3567a;
    }

    public void m3825a(int i) {
        this.f3582p = i;
    }

    public int m3831b() {
        return this.f3581o;
    }

    public void m3826a(View view, int i) {
        if (view.getParent() != this.f3587u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f3587u + ")");
        }
        this.f3585s = view;
        this.f3569c = i;
        this.f3584r.m3800b(view, i);
        m3838c(1);
    }

    public View m3837c() {
        return this.f3585s;
    }

    public int m3840d() {
        return this.f3568b;
    }

    public void m3844e() {
        this.f3569c = -1;
        m3819f();
        if (this.f3578l != null) {
            this.f3578l.recycle();
            this.f3578l = null;
        }
    }

    public boolean m3829a(View view, int i, int i2) {
        this.f3585s = view;
        this.f3569c = -1;
        return m3811a(i, i2, 0, 0);
    }

    public boolean m3827a(int i, int i2) {
        if (this.f3586t) {
            return m3811a(i, i2, (int) com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3761a(this.f3578l, this.f3569c), (int) com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3762b(this.f3578l, this.f3569c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m3811a(int i, int i2, int i3, int i4) {
        int left = this.f3585s.getLeft();
        int top = this.f3585s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f3583q.m3686g();
            m3838c(0);
            return false;
        }
        this.f3583q.m3679a(left, top, i5, i6, m3805a(this.f3585s, i5, i6, i3, i4));
        m3838c(2);
        return true;
    }

    private int m3805a(View view, int i, int i2, int i3, int i4) {
        int b = m3814b(i3, (int) this.f3580n, (int) this.f3579m);
        int b2 = m3814b(i4, (int) this.f3580n, (int) this.f3579m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m3804a(i2, b2, this.f3584r.m3797b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m3804a(i, b, this.f3584r.m3790a(view)))));
    }

    private int m3804a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f3587u.getWidth();
        int i4 = width / 2;
        float b = (m3813b(Math.min(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m3814b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m3803a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m3813b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m3830a(boolean z) {
        if (this.f3567a == 2) {
            boolean a;
            boolean f = this.f3583q.m3685f();
            int b = this.f3583q.m3681b();
            int c = this.f3583q.m3682c();
            int left = b - this.f3585s.getLeft();
            int top = c - this.f3585s.getTop();
            if (left != 0) {
                this.f3585s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f3585s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f3584r.m3795a(this.f3585s, b, c, left, top);
            }
            if (f && b == this.f3583q.m3683d() && c == this.f3583q.m3684e()) {
                this.f3583q.m3686g();
                a = this.f3583q.m3680a();
            } else {
                a = f;
            }
            if (!a) {
                if (z) {
                    this.f3587u.post(this.f3588w);
                } else {
                    m3838c(0);
                }
            }
        }
        return this.f3567a == 2;
    }

    private void m3808a(float f, float f2) {
        this.f3586t = true;
        this.f3584r.m3794a(this.f3585s, f, f2);
        this.f3586t = false;
        if (this.f3567a == 1) {
            m3838c(0);
        }
    }

    private void m3819f() {
        if (this.f3570d != null) {
            Arrays.fill(this.f3570d, 0.0f);
            Arrays.fill(this.f3571e, 0.0f);
            Arrays.fill(this.f3572f, 0.0f);
            Arrays.fill(this.f3573g, 0.0f);
            Arrays.fill(this.f3574h, 0);
            Arrays.fill(this.f3575i, 0);
            Arrays.fill(this.f3576j, 0);
            this.f3577k = 0;
        }
    }

    private void m3820f(int i) {
        if (this.f3570d != null) {
            this.f3570d[i] = 0.0f;
            this.f3571e[i] = 0.0f;
            this.f3572f[i] = 0.0f;
            this.f3573g[i] = 0.0f;
            this.f3574h[i] = 0;
            this.f3575i[i] = 0;
            this.f3576j[i] = 0;
            this.f3577k &= (1 << i) ^ -1;
        }
    }

    private void m3822g(int i) {
        if (this.f3570d == null || this.f3570d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f3570d != null) {
                System.arraycopy(this.f3570d, 0, obj, 0, this.f3570d.length);
                System.arraycopy(this.f3571e, 0, obj2, 0, this.f3571e.length);
                System.arraycopy(this.f3572f, 0, obj3, 0, this.f3572f.length);
                System.arraycopy(this.f3573g, 0, obj4, 0, this.f3573g.length);
                System.arraycopy(this.f3574h, 0, obj5, 0, this.f3574h.length);
                System.arraycopy(this.f3575i, 0, obj6, 0, this.f3575i.length);
                System.arraycopy(this.f3576j, 0, obj7, 0, this.f3576j.length);
            }
            this.f3570d = obj;
            this.f3571e = obj2;
            this.f3572f = obj3;
            this.f3573g = obj4;
            this.f3574h = obj5;
            this.f3575i = obj6;
            this.f3576j = obj7;
        }
    }

    private void m3809a(float f, float f2, int i) {
        m3822g(i);
        float[] fArr = this.f3570d;
        this.f3572f[i] = f;
        fArr[i] = f;
        fArr = this.f3571e;
        this.f3573g[i] = f2;
        fArr[i] = f2;
        this.f3574h[i] = m3818f((int) f, (int) f2);
        this.f3577k |= 1 << i;
    }

    private void m3817c(MotionEvent motionEvent) {
        int c = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3752c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, i);
            float c2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, i);
            float d = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, i);
            this.f3572f[b] = c2;
            this.f3573g[b] = d;
        }
    }

    public boolean m3833b(int i) {
        return (this.f3577k & (1 << i)) != 0;
    }

    void m3838c(int i) {
        if (this.f3567a != i) {
            this.f3567a = i;
            this.f3584r.m3792a(i);
            if (i == 0) {
                this.f3585s = null;
            }
        }
    }

    boolean m3835b(View view, int i) {
        if (view == this.f3585s && this.f3569c == i) {
            return true;
        }
        if (view == null || !this.f3584r.m3796a(view, i)) {
            return false;
        }
        this.f3569c = i;
        m3826a(view, i);
        return true;
    }

    public boolean m3828a(MotionEvent motionEvent) {
        int a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3747a(motionEvent);
        int b = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3749b(motionEvent);
        if (a == 0) {
            m3844e();
        }
        if (this.f3578l == null) {
            this.f3578l = VelocityTracker.obtain();
        }
        this.f3578l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case DurationDV.DURATION_TYPE /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, 0);
                m3809a(x, y, b2);
                View e = m3843e((int) x, (int) y);
                if (e == this.f3585s && this.f3567a == 2) {
                    m3835b(e, b2);
                }
                a = this.f3574h[b2];
                if ((this.f3582p & a) != 0) {
                    this.f3584r.m3793a(a & this.f3582p, b2);
                    break;
                }
                break;
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                m3844e();
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                b = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3752c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, a);
                    float c = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, a);
                    float d = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, a);
                    float f = c - this.f3570d[b2];
                    float f2 = d - this.f3571e[b2];
                    m3815b(f, f2, b2);
                    if (this.f3567a != 1) {
                        View e2 = m3843e((int) c, (int) d);
                        if (e2 == null || !m3812a(e2, f, f2) || !m3835b(e2, b2)) {
                            a++;
                        }
                    }
                    m3817c(motionEvent);
                    break;
                }
                m3817c(motionEvent);
                break;
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, b);
                float c2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, b);
                y = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, b);
                m3809a(c2, y, a);
                if (this.f3567a != 0) {
                    if (this.f3567a == 2) {
                        View e3 = m3843e((int) c2, (int) y);
                        if (e3 == this.f3585s) {
                            m3835b(e3, a);
                            break;
                        }
                    }
                }
                b = this.f3574h[a];
                if ((this.f3582p & b) != 0) {
                    this.f3584r.m3793a(b & this.f3582p, a);
                    break;
                }
                break;
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                m3820f(com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, b));
                break;
        }
        if (this.f3567a == 1) {
            return true;
        }
        return false;
    }

    public void m3832b(MotionEvent motionEvent) {
        int i = 0;
        int a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3747a(motionEvent);
        int b = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3749b(motionEvent);
        if (a == 0) {
            m3844e();
        }
        if (this.f3578l == null) {
            this.f3578l = VelocityTracker.obtain();
        }
        this.f3578l.addMovement(motionEvent);
        float x;
        float y;
        View e;
        int i2;
        switch (a) {
            case DurationDV.DURATION_TYPE /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, 0);
                e = m3843e((int) x, (int) y);
                m3809a(x, y, i);
                m3835b(e, i);
                i2 = this.f3574h[i];
                if ((this.f3582p & i2) != 0) {
                    this.f3584r.m3793a(i2 & this.f3582p, i);
                }
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (this.f3567a == 1) {
                    m3821g();
                }
                m3844e();
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (this.f3567a == 1) {
                    i = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3748a(motionEvent, this.f3569c);
                    x = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, i);
                    i2 = (int) (x - this.f3572f[this.f3569c]);
                    i = (int) (com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, i) - this.f3573g[this.f3569c]);
                    m3816b(this.f3585s.getLeft() + i2, this.f3585s.getTop() + i, i2, i);
                    m3817c(motionEvent);
                    return;
                }
                i2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3752c(motionEvent);
                while (i < i2) {
                    a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, i);
                    float c = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, i);
                    float d = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, i);
                    float f = c - this.f3570d[a];
                    float f2 = d - this.f3571e[a];
                    m3815b(f, f2, a);
                    if (this.f3567a != 1) {
                        e = m3843e((int) c, (int) d);
                        if (!m3812a(e, f, f2) || !m3835b(e, a)) {
                            i++;
                        }
                    }
                    m3817c(motionEvent);
                }
                m3817c(motionEvent);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                if (this.f3567a == 1) {
                    m3808a(0.0f, 0.0f);
                }
                m3844e();
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                i = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, b);
                x = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, b);
                y = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, b);
                m3809a(x, y, i);
                if (this.f3567a == 0) {
                    m3835b(m3843e((int) x, (int) y), i);
                    i2 = this.f3574h[i];
                    if ((this.f3582p & i2) != 0) {
                        this.f3584r.m3793a(i2 & this.f3582p, i);
                    }
                } else if (m3842d((int) x, (int) y)) {
                    m3835b(this.f3585s, i);
                }
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, b);
                if (this.f3567a == 1 && a == this.f3569c) {
                    b = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3752c(motionEvent);
                    while (i < b) {
                        int b2 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3750b(motionEvent, i);
                        if (b2 != this.f3569c) {
                            if (m3843e((int) com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3751c(motionEvent, i), (int) com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3753d(motionEvent, i)) == this.f3585s && m3835b(this.f3585s, b2)) {
                                i = this.f3569c;
                                if (i == -1) {
                                    m3821g();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m3821g();
                    }
                }
                m3820f(a);
            default:
        }
    }

    private void m3815b(float f, float f2, int i) {
        int i2 = 1;
        if (!m3810a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m3810a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m3810a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m3810a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f3575i;
            iArr[i] = iArr[i] | i2;
            this.f3584r.m3799b(i2, i);
        }
    }

    private boolean m3810a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f3574h[i] & i2) != i2 || (this.f3582p & i2) == 0 || (this.f3576j[i] & i2) == i2 || (this.f3575i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f3568b) && abs2 <= ((float) this.f3568b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f3584r.m3801b(i2)) {
            int[] iArr = this.f3576j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f3575i[i] & i2) != 0 || abs <= ((float) this.f3568b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m3812a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f3584r.m3790a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f3584r.m3797b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f3568b * this.f3568b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f3568b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f3568b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m3841d(int i) {
        int length = this.f3570d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m3834b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m3834b(int i, int i2) {
        if (!m3833b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f3572f[i2] - this.f3570d[i2];
        float f2 = this.f3573g[i2] - this.f3571e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f3568b * this.f3568b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f3568b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f3568b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m3845e(int i) {
        int length = this.f3574h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m3839c(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m3839c(int i, int i2) {
        return m3833b(i2) && (this.f3574h[i2] & i) != 0;
    }

    private void m3821g() {
        this.f3578l.computeCurrentVelocity(1000, this.f3579m);
        m3808a(m3803a(com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3761a(this.f3578l, this.f3569c), this.f3580n, this.f3579m), m3803a(com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3762b(this.f3578l, this.f3569c), this.f3580n, this.f3579m));
    }

    private void m3816b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f3585s.getLeft();
        int top = this.f3585s.getTop();
        if (i3 != 0) {
            a = this.f3584r.m3791a(this.f3585s, i, i3);
            this.f3585s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f3584r.m3798b(this.f3585s, i2, i4);
            this.f3585s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f3584r.m3795a(this.f3585s, a, b, a - left, b - top);
        }
    }

    public boolean m3842d(int i, int i2) {
        return m3836b(this.f3585s, i, i2);
    }

    public boolean m3836b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m3843e(int i, int i2) {
        for (int childCount = this.f3587u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3587u.getChildAt(this.f3584r.m3802c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m3818f(int i, int i2) {
        int i3 = 0;
        if (i < this.f3587u.getLeft() + this.f3581o) {
            i3 = 1;
        }
        if (i2 < this.f3587u.getTop() + this.f3581o) {
            i3 |= 4;
        }
        if (i > this.f3587u.getRight() - this.f3581o) {
            i3 |= 2;
        }
        if (i2 > this.f3587u.getBottom() - this.f3581o) {
            return i3 | 8;
        }
        return i3;
    }
}
