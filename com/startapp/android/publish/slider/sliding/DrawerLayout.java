package com.startapp.android.publish.slider.sliding;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* compiled from: StartAppSDK */
public class DrawerLayout extends ViewGroup {
    private static final int[] f3526a;
    private int f3527b;
    private int f3528c;
    private float f3529d;
    private Paint f3530e;
    private final StartAppSDK f3531f;
    private final StartAppSDK f3532g;
    private final StartAppSDK f3533h;
    private final StartAppSDK f3534i;
    private int f3535j;
    private boolean f3536k;
    private boolean f3537l;
    private int f3538m;
    private int f3539n;
    private boolean f3540o;
    private boolean f3541p;
    private StartAppSDK f3542q;
    private float f3543r;
    private float f3544s;
    private Drawable f3545t;
    private Drawable f3546u;

    /* compiled from: StartAppSDK */
    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3518a;
        int f3519b;
        int f3520c;

        /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.SavedState.1 */
        static class StartAppSDK implements Creator<SavedState> {
            StartAppSDK() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m3511a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m3512a(x0);
            }

            public SavedState m3511a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m3512a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel in) {
            super(in);
            this.f3518a = 0;
            this.f3519b = 0;
            this.f3520c = 0;
            this.f3518a = in.readInt();
        }

        public SavedState(Parcelable superState) {
            super(superState);
            this.f3518a = 0;
            this.f3519b = 0;
            this.f3520c = 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f3518a);
        }

        static {
            CREATOR = new StartAppSDK();
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.b */
    public interface StartAppSDK {
        void m3513a(int i);

        void m3514a(View view);

        void m3515a(View view, float f);

        void m3516b(View view);
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.c */
    public static class StartAppSDK extends MarginLayoutParams {
        public int f3521a;
        float f3522b;
        boolean f3523c;
        boolean f3524d;

        public StartAppSDK(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3521a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3526a);
            this.f3521a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public StartAppSDK(int i, int i2) {
            super(i, i2);
            this.f3521a = 0;
        }

        public StartAppSDK(StartAppSDK startAppSDK) {
            super(startAppSDK);
            this.f3521a = 0;
            this.f3521a = startAppSDK.f3521a;
        }

        public StartAppSDK(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3521a = 0;
        }

        public StartAppSDK(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3521a = 0;
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.a */
    class StartAppSDK extends com.startapp.android.publish.slider.sliding.p024b.StartAppSDK {
        final /* synthetic */ DrawerLayout f4767a;
        private final Rect f4768c;

        StartAppSDK(DrawerLayout drawerLayout) {
            this.f4767a = drawerLayout;
            this.f4768c = new Rect();
        }

        public void m5491a(View view, com.startapp.android.publish.slider.sliding.p023a.StartAppSDK startAppSDK) {
            com.startapp.android.publish.slider.sliding.p023a.StartAppSDK a = com.startapp.android.publish.slider.sliding.p023a.StartAppSDK.m3590a(startAppSDK);
            super.m3701a(view, a);
            startAppSDK.m3596a(view);
            ViewParent c = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3772c(view);
            if (c instanceof View) {
                startAppSDK.m3605c((View) c);
            }
            m5490a(startAppSDK, a);
            a.m3630s();
            int childCount = this.f4767a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f4767a.getChildAt(i);
                if (!m5492a(childAt)) {
                    startAppSDK.m3601b(childAt);
                }
            }
        }

        public boolean m5493a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (m5492a(view)) {
                return false;
            }
            return super.m3703a(viewGroup, view, accessibilityEvent);
        }

        public boolean m5492a(View view) {
            View a = this.f4767a.m3524a();
            return (a == null || a == view) ? false : true;
        }

        private void m5490a(com.startapp.android.publish.slider.sliding.p023a.StartAppSDK startAppSDK, com.startapp.android.publish.slider.sliding.p023a.StartAppSDK startAppSDK2) {
            Rect rect = this.f4768c;
            startAppSDK2.m3595a(rect);
            startAppSDK.m3600b(rect);
            startAppSDK2.m3604c(rect);
            startAppSDK.m3609d(rect);
            startAppSDK.m3607c(startAppSDK2.m3617g());
            startAppSDK.m3597a(startAppSDK2.m3626o());
            startAppSDK.m3602b(startAppSDK2.m3627p());
            startAppSDK.m3606c(startAppSDK2.m3629r());
            startAppSDK.m3618h(startAppSDK2.m3623l());
            startAppSDK.m3614f(startAppSDK2.m3621j());
            startAppSDK.m3598a(startAppSDK2.m3613e());
            startAppSDK.m3603b(startAppSDK2.m3615f());
            startAppSDK.m3610d(startAppSDK2.m3619h());
            startAppSDK.m3612e(startAppSDK2.m3620i());
            startAppSDK.m3616g(startAppSDK2.m3622k());
            startAppSDK.m3594a(startAppSDK2.m3599b());
        }
    }

    /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.d */
    private class StartAppSDK extends com.startapp.android.publish.slider.sliding.StartAppSDK.StartAppSDK {
        final /* synthetic */ DrawerLayout f4769a;
        private final int f4770b;
        private StartAppSDK f4771c;
        private final Runnable f4772d;

        /* renamed from: com.startapp.android.publish.slider.sliding.DrawerLayout.d.1 */
        class StartAppSDK implements Runnable {
            final /* synthetic */ StartAppSDK f3525a;

            StartAppSDK(StartAppSDK startAppSDK) {
                this.f3525a = startAppSDK;
            }

            public void run() {
                this.f3525a.m5496c();
            }
        }

        public StartAppSDK(DrawerLayout drawerLayout, int i) {
            this.f4769a = drawerLayout;
            this.f4772d = new StartAppSDK(this);
            this.f4770b = i;
        }

        public void m5504a(StartAppSDK startAppSDK) {
            this.f4771c = startAppSDK;
        }

        public void m5499a() {
            this.f4769a.removeCallbacks(this.f4772d);
        }

        public boolean m5505a(View view, int i) {
            return this.f4769a.m3539g(view) && this.f4769a.m3530a(view, this.f4770b) && this.f4769a.m3523a(view) == 0;
        }

        public void m5500a(int i) {
            this.f4769a.m3527a(this.f4770b, i, this.f4771c.m3837c());
        }

        public void m5503a(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.f4769a.m3530a(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.f4769a.getWidth() - i)) / ((float) width);
            }
            this.f4769a.m3533b(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.f4769a.invalidate();
        }

        public void m5508b(View view, int i) {
            ((StartAppSDK) view.getLayoutParams()).f3523c = false;
            m5495b();
        }

        private void m5495b() {
            int i = 3;
            if (this.f4770b == 3) {
                i = 5;
            }
            View a = this.f4769a.m3525a(i);
            if (a != null) {
                this.f4769a.m3541i(a);
            }
        }

        public void m5502a(View view, float f, float f2) {
            int i;
            float d = this.f4769a.m3536d(view);
            int width = view.getWidth();
            if (this.f4769a.m3530a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                i = this.f4769a.getWidth();
                if (f < 0.0f || (f == 0.0f && d < 0.5f)) {
                    i -= width;
                }
            }
            this.f4771c.m3827a(i, view.getTop());
            this.f4769a.invalidate();
        }

        public void m5501a(int i, int i2) {
            this.f4769a.postDelayed(this.f4772d, 160);
        }

        private void m5496c() {
            View view;
            int i;
            int i2 = 0;
            int b = this.f4771c.m3831b();
            boolean z = this.f4770b == 3;
            if (z) {
                View a = this.f4769a.m3525a(3);
                if (a != null) {
                    i2 = -a.getWidth();
                }
                i2 += b;
                view = a;
                i = i2;
            } else {
                i2 = this.f4769a.getWidth() - b;
                view = this.f4769a.m3525a(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f4769a.m3523a(view) == 0) {
                StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
                this.f4771c.m3829a(view, i, view.getTop());
                startAppSDK.f3523c = true;
                this.f4769a.invalidate();
                m5495b();
                this.f4769a.m3534c();
            }
        }

        public boolean m5509b(int i) {
            return false;
        }

        public void m5507b(int i, int i2) {
            View a;
            if ((i & 1) == 1) {
                a = this.f4769a.m3525a(3);
            } else {
                a = this.f4769a.m3525a(5);
            }
            if (a != null && this.f4769a.m3523a(a) == 0) {
                this.f4771c.m3826a(a, i2);
            }
        }

        public int m5497a(View view) {
            return view.getWidth();
        }

        public int m5498a(View view, int i, int i2) {
            if (this.f4769a.m3530a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f4769a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int m5506b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        f3526a = new int[]{16842931};
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3528c = -1728053248;
        this.f3530e = new Paint();
        this.f3537l = true;
        float f = getResources().getDisplayMetrics().density;
        this.f3527b = (int) ((64.0f * f) + 0.5f);
        f *= 400.0f;
        this.f3533h = new StartAppSDK(this, 3);
        this.f3534i = new StartAppSDK(this, 5);
        this.f3531f = StartAppSDK.m3806a((ViewGroup) this, 0.5f, this.f3533h);
        this.f3531f.m3825a(1);
        this.f3531f.m3824a(f);
        this.f3533h.m5504a(this.f3531f);
        this.f3532g = StartAppSDK.m3806a((ViewGroup) this, 0.5f, this.f3534i);
        this.f3532g.m3825a(2);
        this.f3532g.m3824a(f);
        this.f3534i.m5504a(this.f3532g);
        setFocusableInTouchMode(true);
        com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3770a(this, new StartAppSDK(this));
        com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3779a(this, false);
    }

    public void setScrimColor(int color) {
        this.f3528c = color;
        invalidate();
    }

    public void setDrawerListener(StartAppSDK listener) {
        this.f3542q = listener;
    }

    public void setDrawerLockMode(int lockMode) {
        m3526a(lockMode, 3);
        m3526a(lockMode, 5);
    }

    public void m3526a(int i, int i2) {
        int a = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3737a(i2, com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3771b(this));
        if (a == 3) {
            this.f3538m = i;
        } else if (a == 5) {
            this.f3539n = i;
        }
        if (i != 0) {
            (a == 3 ? this.f3531f : this.f3532g).m3844e();
        }
        View a2;
        switch (i) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                a2 = m3525a(a);
                if (a2 != null) {
                    m3541i(a2);
                }
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                a2 = m3525a(a);
                if (a2 != null) {
                    m3540h(a2);
                }
            default:
        }
    }

    public int m3523a(View view) {
        int e = m3537e(view);
        if (e == 3) {
            return this.f3538m;
        }
        if (e == 5) {
            return this.f3539n;
        }
        return 0;
    }

    void m3527a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f3531f.m3823a();
        int a2 = this.f3532g.m3823a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
            if (startAppSDK.f3522b == 0.0f) {
                m3532b(view);
            } else if (startAppSDK.f3522b == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                m3535c(view);
            }
        }
        if (i3 != this.f3535j) {
            this.f3535j = i3;
            if (this.f3542q != null) {
                this.f3542q.m3513a(i3);
            }
        }
    }

    void m3532b(View view) {
        StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
        if (startAppSDK.f3524d) {
            startAppSDK.f3524d = false;
            if (this.f3542q != null) {
                this.f3542q.m3516b(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    void m3535c(View view) {
        StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
        if (!startAppSDK.f3524d) {
            startAppSDK.f3524d = true;
            if (this.f3542q != null) {
                this.f3542q.m3514a(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    void m3528a(View view, float f) {
        if (this.f3542q != null) {
            this.f3542q.m3515a(view, f);
        }
    }

    void m3533b(View view, float f) {
        StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
        if (f != startAppSDK.f3522b) {
            startAppSDK.f3522b = f;
            m3528a(view, f);
        }
    }

    float m3536d(View view) {
        return ((StartAppSDK) view.getLayoutParams()).f3522b;
    }

    int m3537e(View view) {
        return com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3737a(((StartAppSDK) view.getLayoutParams()).f3521a, com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3771b(view));
    }

    boolean m3530a(View view, int i) {
        return (m3537e(view) & i) == i;
    }

    View m3524a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((StartAppSDK) childAt.getLayoutParams()).f3524d) {
                return childAt;
            }
        }
        return null;
    }

    View m3525a(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m3537e(childAt) & 7) == (i & 7)) {
                return childAt;
            }
        }
        return null;
    }

    static String m3517b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3537l = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3537l = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r12, int r13) {
        /*
        r11 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r4 = 0;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r12);
        r5 = android.view.View.MeasureSpec.getMode(r13);
        r2 = android.view.View.MeasureSpec.getSize(r12);
        r0 = android.view.View.MeasureSpec.getSize(r13);
        if (r3 != r10) goto L_0x001b;
    L_0x0019:
        if (r5 == r10) goto L_0x0046;
    L_0x001b:
        r6 = r11.isInEditMode();
        if (r6 == 0) goto L_0x0048;
    L_0x0021:
        if (r3 != r7) goto L_0x0040;
    L_0x0023:
        if (r5 != r7) goto L_0x0044;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r11.setMeasuredDimension(r2, r1);
        r5 = r11.getChildCount();
        r3 = r4;
    L_0x002e:
        if (r3 >= r5) goto L_0x0109;
    L_0x0030:
        r6 = r11.getChildAt(r3);
        r0 = r6.getVisibility();
        r7 = 8;
        if (r0 != r7) goto L_0x0050;
    L_0x003c:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x002e;
    L_0x0040:
        if (r3 != 0) goto L_0x0023;
    L_0x0042:
        r2 = r1;
        goto L_0x0023;
    L_0x0044:
        if (r5 == 0) goto L_0x0026;
    L_0x0046:
        r1 = r0;
        goto L_0x0026;
    L_0x0048:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r6.getLayoutParams();
        r0 = (com.startapp.android.publish.slider.sliding.DrawerLayout.StartAppSDK) r0;
        r7 = r11.m3538f(r6);
        if (r7 == 0) goto L_0x0077;
    L_0x005c:
        r7 = r0.leftMargin;
        r7 = r2 - r7;
        r8 = r0.rightMargin;
        r7 = r7 - r8;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10);
        r8 = r0.topMargin;
        r8 = r1 - r8;
        r0 = r0.bottomMargin;
        r0 = r8 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x0077:
        r7 = r11.m3539g(r6);
        if (r7 == 0) goto L_0x00da;
    L_0x007d:
        r7 = r11.m3537e(r6);
        r7 = r7 & 7;
        r8 = r4 & r7;
        if (r8 == 0) goto L_0x00bc;
    L_0x0087:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m3517b(r7);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00bc:
        r7 = r11.f3527b;
        r8 = r0.leftMargin;
        r7 = r7 + r8;
        r8 = r0.rightMargin;
        r7 = r7 + r8;
        r8 = r0.width;
        r7 = getChildMeasureSpec(r12, r7, r8);
        r8 = r0.topMargin;
        r9 = r0.bottomMargin;
        r8 = r8 + r9;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r13, r8, r0);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x00da:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0109:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.android.publish.slider.sliding.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.f3536k = true;
        int i = r - l;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                StartAppSDK startAppSDK = (StartAppSDK) childAt.getLayoutParams();
                if (m3538f(childAt)) {
                    childAt.layout(startAppSDK.leftMargin, startAppSDK.topMargin, startAppSDK.leftMargin + childAt.getMeasuredWidth(), startAppSDK.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i3;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m3530a(childAt, 3)) {
                        i3 = ((int) (((float) measuredWidth) * startAppSDK.f3522b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i3)) / ((float) measuredWidth);
                    } else {
                        i3 = i - ((int) (((float) measuredWidth) * startAppSDK.f3522b));
                        f = ((float) (i - i3)) / ((float) measuredWidth);
                    }
                    Object obj = f != startAppSDK.f3522b ? 1 : null;
                    int i4;
                    switch (startAppSDK.f3521a & 112) {
                        case ConnectionResult.API_UNAVAILABLE /*16*/:
                            int i5 = b - t;
                            i4 = (i5 - measuredHeight) / 2;
                            if (i4 < startAppSDK.topMargin) {
                                i4 = startAppSDK.topMargin;
                            } else if (i4 + measuredHeight > i5 - startAppSDK.bottomMargin) {
                                i4 = (i5 - startAppSDK.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
                            break;
                        case MetaData.DEFAULT_PROBABILITY_3D /*80*/:
                            i4 = b - t;
                            childAt.layout(i3, (i4 - startAppSDK.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i3, i4 - startAppSDK.bottomMargin);
                            break;
                        default:
                            childAt.layout(i3, startAppSDK.topMargin, measuredWidth + i3, measuredHeight);
                            break;
                    }
                    if (obj != null) {
                        m3533b(childAt, f);
                    }
                    int i6 = startAppSDK.f3522b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i6) {
                        childAt.setVisibility(i6);
                    }
                }
            }
        }
        this.f3536k = false;
        this.f3537l = false;
    }

    public void requestLayout() {
        if (!this.f3536k) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((StartAppSDK) getChildAt(i).getLayoutParams()).f3522b);
        }
        this.f3529d = f;
        if ((this.f3531f.m3830a(true) | this.f3532g.m3830a(true)) != 0) {
            com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3769a(this);
        }
    }

    private static boolean m3522k(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        int i;
        int height = getHeight();
        boolean f = m3538f(child);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != child && childAt.getVisibility() == 0 && m3522k(childAt) && m3539g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m3530a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(save);
        if (this.f3529d > 0.0f && f) {
            this.f3530e.setColor((((int) (((float) ((this.f3528c & ViewCompat.MEASURED_STATE_MASK) >>> 24)) * this.f3529d)) << 24) | (this.f3528c & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f3530e);
        } else if (this.f3545t != null && m3530a(child, 3)) {
            i = this.f3545t.getIntrinsicWidth();
            i2 = child.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f3531f.m3831b()), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            this.f3545t.setBounds(i2, child.getTop(), i + i2, child.getBottom());
            this.f3545t.setAlpha((int) (255.0f * r2));
            this.f3545t.draw(canvas);
        } else if (this.f3546u != null && m3530a(child, 5)) {
            i = this.f3546u.getIntrinsicWidth();
            i2 = child.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f3532g.m3831b()), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            this.f3546u.setBounds(i2 - i, child.getTop(), i2, child.getBottom());
            this.f3546u.setAlpha((int) (255.0f * r2));
            this.f3546u.draw(canvas);
        }
        return drawChild;
    }

    boolean m3538f(View view) {
        return ((StartAppSDK) view.getLayoutParams()).f3521a == 0;
    }

    boolean m3539g(View view) {
        return (com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3737a(((StartAppSDK) view.getLayoutParams()).f3521a, com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3771b(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3747a(r8);
        r3 = r7.f3531f;
        r3 = r3.m3828a(r8);
        r4 = r7.f3532g;
        r4 = r4.m3828a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0063;
            case 2: goto L_0x004e;
            case 3: goto L_0x0063;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m3519e();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f3541p;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f3543r = r0;
        r7.f3544s = r4;
        r5 = r7.f3529d;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006b;
    L_0x003a:
        r5 = r7.f3531f;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m3843e(r0, r4);
        r0 = r7.m3538f(r0);
        if (r0 == 0) goto L_0x006b;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        r7.f3540o = r2;
        r7.f3541p = r2;
        goto L_0x0017;
    L_0x004e:
        r0 = r7.f3531f;
        r4 = 3;
        r0 = r0.m3841d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0057:
        r0 = r7.f3533h;
        r0.m5499a();
        r0 = r7.f3534i;
        r0.m5499a();
        r0 = r2;
        goto L_0x0017;
    L_0x0063:
        r7.m3529a(r1);
        r7.f3540o = r2;
        r7.f3541p = r2;
        goto L_0x0016;
    L_0x006b:
        r0 = r2;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.android.publish.slider.sliding.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent ev) {
        this.f3531f.m3832b(ev);
        this.f3532g.m3832b(ev);
        float x;
        float y;
        switch (ev.getAction() & MotionEventCompat.ACTION_MASK) {
            case DurationDV.DURATION_TYPE /*0*/:
                x = ev.getX();
                y = ev.getY();
                this.f3543r = x;
                this.f3544s = y;
                this.f3540o = false;
                this.f3541p = false;
                break;
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                boolean z;
                x = ev.getX();
                y = ev.getY();
                View e = this.f3531f.m3843e((int) x, (int) y);
                if (e != null && m3538f(e)) {
                    x -= this.f3543r;
                    y -= this.f3544s;
                    int d = this.f3531f.m3840d();
                    if ((x * x) + (y * y) < ((float) (d * d))) {
                        View a = m3524a();
                        if (a != null) {
                            z = m3523a(a) == 2;
                            m3529a(z);
                            this.f3540o = false;
                            break;
                        }
                    }
                }
                z = true;
                m3529a(z);
                this.f3540o = false;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                m3529a(true);
                this.f3540o = false;
                this.f3541p = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (!(this.f3531f.m3845e(1) || this.f3532g.m3845e(2))) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
        this.f3540o = disallowIntercept;
        if (disallowIntercept) {
            m3529a(true);
        }
    }

    public void m3531b() {
        m3529a(false);
    }

    void m3529a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            StartAppSDK startAppSDK = (StartAppSDK) childAt.getLayoutParams();
            if (m3539g(childAt) && (!z || startAppSDK.f3523c)) {
                int width = childAt.getWidth();
                if (m3530a(childAt, 3)) {
                    i |= this.f3531f.m3829a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f3532g.m3829a(childAt, getWidth(), childAt.getTop());
                }
                startAppSDK.f3523c = false;
            }
        }
        this.f3533h.m5499a();
        this.f3534i.m5499a();
        if (i != 0) {
            invalidate();
        }
    }

    public void m3540h(View view) {
        if (m3539g(view)) {
            if (this.f3537l) {
                StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
                startAppSDK.f3522b = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                startAppSDK.f3524d = true;
            } else if (m3530a(view, 3)) {
                this.f3531f.m3829a(view, 0, view.getTop());
            } else {
                this.f3532g.m3829a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m3541i(View view) {
        if (m3539g(view)) {
            if (this.f3537l) {
                StartAppSDK startAppSDK = (StartAppSDK) view.getLayoutParams();
                startAppSDK.f3522b = 0.0f;
                startAppSDK.f3524d = false;
            } else if (m3530a(view, 3)) {
                this.f3531f.m3829a(view, -view.getWidth(), view.getTop());
            } else {
                this.f3532g.m3829a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m3542j(View view) {
        if (m3539g(view)) {
            return ((StartAppSDK) view.getLayoutParams()).f3522b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    private boolean m3519e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((StartAppSDK) getChildAt(i).getLayoutParams()).f3523c) {
                return true;
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new StartAppSDK(-1, -1);
    }

    protected LayoutParams generateLayoutParams(LayoutParams p) {
        if (p instanceof StartAppSDK) {
            return new StartAppSDK((StartAppSDK) p);
        }
        return p instanceof MarginLayoutParams ? new StartAppSDK((MarginLayoutParams) p) : new StartAppSDK(p);
    }

    protected boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof StartAppSDK) && super.checkLayoutParams(p);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new StartAppSDK(getContext(), attrs);
    }

    private boolean m3520f() {
        return m3521g() != null;
    }

    private View m3521g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3539g(childAt) && m3542j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void m3534c() {
        int i = 0;
        if (!this.f3541p) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f3541p = true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !m3520f()) {
            return super.onKeyDown(keyCode, event);
        }
        com.startapp.android.publish.slider.sliding.p024b.StartAppSDK.m3740a(event);
        return true;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyUp(keyCode, event);
        }
        View g = m3521g();
        if (g != null && m3523a(g) == 0) {
            m3531b();
        }
        return g != null;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f3518a != 0) {
            View a = m3525a(savedState.f3518a);
            if (a != null) {
                m3540h(a);
            }
        }
        m3526a(savedState.f3519b, 3);
        m3526a(savedState.f3520c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m3539g(childAt)) {
                StartAppSDK startAppSDK = (StartAppSDK) childAt.getLayoutParams();
                if (startAppSDK.f3524d) {
                    savedState.f3518a = startAppSDK.f3521a;
                    break;
                }
            }
        }
        savedState.f3519b = this.f3538m;
        savedState.f3520c = this.f3539n;
        return savedState;
    }
}
