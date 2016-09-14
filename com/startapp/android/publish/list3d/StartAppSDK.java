package com.startapp.android.publish.list3d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.android.volley.DefaultRetryPolicy;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.LinkedList;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.startapp.android.publish.list3d.c */
public class StartAppSDK extends AdapterView<Adapter> {
    private boolean f3439A;
    private boolean f3440B;
    private String f3441C;
    private String f3442D;
    public BroadcastReceiver f3443a;
    private String f3444b;
    private Adapter f3445c;
    private int f3446d;
    private int f3447e;
    private int f3448f;
    private int f3449g;
    private int f3450h;
    private int f3451i;
    private int f3452j;
    private int f3453k;
    private int f3454l;
    private VelocityTracker f3455m;
    private Dynamics f3456n;
    private Runnable f3457o;
    private final LinkedList<View> f3458p;
    private Runnable f3459q;
    private Rect f3460r;
    private Camera f3461s;
    private Matrix f3462t;
    private Paint f3463u;
    private int f3464v;
    private float f3465w;
    private boolean f3466x;
    private boolean f3467y;
    private boolean f3468z;

    /* renamed from: com.startapp.android.publish.list3d.c.1 */
    class StartAppSDK extends BroadcastReceiver {
        final /* synthetic */ StartAppSDK f3435a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3435a = startAppSDK;
        }

        public void onReceive(Context context, Intent intent) {
            double height = ((double) this.f3435a.getHeight()) / ((double) intent.getIntExtra("getHeight", this.f3435a.getHeight()));
            com.startapp.android.publish.p022h.StartAppSDK.m3230a(3, this.f3435a.f3444b + "Updating Position with Ratio: [" + height + "]");
            this.f3435a.f3446d = intent.getIntExtra("mTouchState", this.f3435a.f3446d);
            this.f3435a.f3447e = intent.getIntExtra("mTouchStartX", this.f3435a.f3447e);
            this.f3435a.f3448f = intent.getIntExtra("mTouchStartY", this.f3435a.f3448f);
            this.f3435a.f3452j = intent.getIntExtra("mListRotation", this.f3435a.f3452j);
            this.f3435a.f3453k = (int) (((double) intent.getIntExtra("mFirstItemPosition", this.f3435a.f3453k)) * height);
            this.f3435a.f3453k = this.f3435a.f3453k - 1;
            this.f3435a.f3454l = (int) (((double) intent.getIntExtra("mLastItemPosition", this.f3435a.f3454l)) * height);
            this.f3435a.f3454l = this.f3435a.f3454l - 1;
            this.f3435a.f3450h = (int) (((double) intent.getIntExtra("mListTop", this.f3435a.f3450h)) * height);
            this.f3435a.f3449g = (int) (((double) intent.getIntExtra("mListTopStart", this.f3435a.f3449g)) * height);
            this.f3435a.f3451i = (int) (((double) intent.getIntExtra("mListTopOffset", this.f3435a.f3451i)) * height);
            this.f3435a.f3456n = (Dynamics) intent.getParcelableExtra("mDynamics");
            this.f3435a.f3465w = intent.getFloatExtra("mLastVelocity", this.f3435a.f3465w);
            this.f3435a.f3456n.m3375a(height);
            this.f3435a.setAdapter(new StartAppSDK(this.f3435a.getContext(), intent.getParcelableArrayListExtra(SchemaSymbols.ATTVAL_LIST), "home", this.f3435a.f3441C, this.f3435a.f3442D));
            this.f3435a.f3466x = true;
            this.f3435a.f3467y = true;
            this.f3435a.m3421a(this.f3435a.f3465w, true);
            com.startapp.android.publish.p022h.StartAppSDK.m3219a(context).m3222a((BroadcastReceiver) this);
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.c.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3436a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3436a = startAppSDK;
        }

        public void run() {
            this.f3436a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 2, 0.0f, -20.0f, 0));
            this.f3436a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 1, 0.0f, -20.0f, 0));
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.c.3 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3437a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3437a = startAppSDK;
        }

        public void run() {
            if (this.f3437a.f3456n != null) {
                View childAt = this.f3437a.getChildAt(0);
                if (childAt != null) {
                    this.f3437a.f3449g = this.f3437a.m3428b(childAt) - this.f3437a.f3451i;
                    this.f3437a.f3456n.m3379a(AnimationUtils.currentAnimationTimeMillis());
                    this.f3437a.m3422a(((int) this.f3437a.f3456n.m3374a()) - this.f3437a.f3449g);
                }
                if (!this.f3437a.f3456n.m3380a(0.5f, 0.4f)) {
                    this.f3437a.postDelayed(this, 16);
                }
            }
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.c.4 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3438a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3438a = startAppSDK;
        }

        public void run() {
            if (this.f3438a.f3446d == 1) {
                int a = this.f3438a.m3413a(this.f3438a.f3447e, this.f3438a.f3448f);
                if (a != -1) {
                    this.f3438a.m3432b(a);
                }
            }
        }
    }

    public StartAppSDK(Context context, AttributeSet attributeSet, String str, String str2) {
        super(context, attributeSet);
        this.f3444b = "List3DView";
        this.f3446d = 0;
        this.f3458p = new LinkedList();
        this.f3464v = ExploreByTouchHelper.INVALID_ID;
        this.f3465w = 0.0f;
        this.f3466x = false;
        this.f3467y = false;
        this.f3468z = false;
        this.f3439A = false;
        this.f3440B = false;
        this.f3443a = new StartAppSDK(this);
        this.f3441C = str;
        this.f3442D = str2;
    }

    public void setTag(String TAG) {
        this.f3444b = TAG;
    }

    public void m3470a() {
        this.f3466x = true;
    }

    public void setHint(boolean hint) {
        this.f3439A = hint;
    }

    public boolean m3471b() {
        return this.f3439A;
    }

    public boolean m3472c() {
        return this.f3468z;
    }

    public void setFade(boolean fade) {
        this.f3468z = fade;
    }

    public void setAdapter(Adapter adapter) {
        if (m3446d() && m3472c()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3169a((View) this, 0.0f);
        }
        this.f3445c = adapter;
        removeAllViewsInLayout();
        requestLayout();
    }

    public Adapter getAdapter() {
        return this.f3445c;
    }

    public void setSelection(int position) {
        throw new UnsupportedOperationException("Not supported");
    }

    public View getSelectedView() {
        return null;
    }

    private boolean m3446d() {
        return com.startapp.android.publish.p022h.StartAppSDK.m3179a();
    }

    public void setDynamics(Dynamics dynamics) {
        if (this.f3456n != null) {
            dynamics.m3377a(this.f3456n.m3374a(), this.f3456n.m3381b(), AnimationUtils.currentAnimationTimeMillis());
        }
        this.f3456n = dynamics;
    }

    private void m3449e() {
        if (!this.f3440B) {
            this.f3440B = true;
            dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, 0.0f, 0.0f, 0));
            postDelayed(new StartAppSDK(this), 5);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        float f = 0.0f;
        if (getChildCount() == 0) {
            return false;
        }
        switch (event.getAction()) {
            case DurationDV.DURATION_TYPE /*0*/:
                if (m3446d()) {
                    com.startapp.android.publish.p022h.StartAppSDK.m3170a((View) this, 1500);
                }
                m3424a(event);
                break;
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (this.f3446d == 1) {
                    m3433b((int) event.getX(), (int) event.getY());
                } else if (this.f3446d == 2) {
                    this.f3455m.addMovement(event);
                    this.f3455m.computeCurrentVelocity(1000);
                    f = this.f3455m.getYVelocity();
                    this.f3465w = f;
                }
                m3431b(f);
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (this.f3446d == 1) {
                    m3434b(event);
                }
                if (this.f3446d == 2) {
                    this.f3455m.addMovement(event);
                    m3422a(((int) event.getY()) - this.f3448f);
                    break;
                }
                break;
            default:
                m3431b(0.0f);
                break;
        }
        return true;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.f3466x && this.f3445c != null) {
            if (getChildCount() == 0) {
                if (m3471b()) {
                    this.f3450h = getHeight() / 3;
                }
                if (this.f3467y) {
                    this.f3454l = this.f3453k;
                    this.f3453k++;
                } else {
                    this.f3454l = -1;
                }
                m3440c(this.f3450h, 0);
            } else {
                int b = (this.f3450h + this.f3451i) - m3428b(getChildAt(0));
                m3439c(b);
                m3444d(b);
            }
            m3458h();
            if (m3471b()) {
                m3449e();
            }
            invalidate();
        }
    }

    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Bitmap drawingCache = child.getDrawingCache();
        if (drawingCache == null) {
            return super.drawChild(canvas, child, drawingTime);
        }
        float f;
        int top = child.getTop();
        int left = child.getLeft();
        int width = child.getWidth() / 2;
        int height = child.getHeight() / 2;
        float height2 = (float) (getHeight() / 2);
        height2 = (((float) (top + height)) - height2) / height2;
        float cos = (float) (1.0d - (0.15000000596046448d * (1.0d - Math.cos((double) height2))));
        height2 = (((float) this.f3452j) - (height2 * 20.0f)) % 90.0f;
        if (height2 < 0.0f) {
            f = height2 + 90.0f;
        } else {
            f = height2;
        }
        if (f < 45.0f) {
            m3423a(canvas, drawingCache, top, left, width, height, cos, f - 90.0f);
            m3423a(canvas, drawingCache, top, left, width, height, cos, f);
        } else {
            m3423a(canvas, drawingCache, top, left, width, height, cos, f);
            m3423a(canvas, drawingCache, top, left, width, height, cos, f - 90.0f);
        }
        return false;
    }

    private void m3423a(Canvas canvas, Bitmap bitmap, int i, int i2, int i3, int i4, float f, float f2) {
        if (this.f3461s == null) {
            this.f3461s = new Camera();
        }
        this.f3461s.save();
        this.f3461s.translate(0.0f, 0.0f, (float) i4);
        this.f3461s.rotateX(f2);
        this.f3461s.translate(0.0f, 0.0f, (float) (-i4));
        if (this.f3462t == null) {
            this.f3462t = new Matrix();
        }
        this.f3461s.getMatrix(this.f3462t);
        this.f3461s.restore();
        this.f3462t.preTranslate((float) (-i3), (float) (-i4));
        this.f3462t.postScale(f, f);
        this.f3462t.postTranslate((float) (i2 + i3), (float) (i + i4));
        if (this.f3463u == null) {
            this.f3463u = new Paint();
            this.f3463u.setAntiAlias(true);
            this.f3463u.setFilterBitmap(true);
        }
        this.f3463u.setColorFilter(m3418a(f2));
        canvas.drawBitmap(bitmap, this.f3462t, this.f3463u);
    }

    private LightingColorFilter m3418a(float f) {
        int i = MotionEventCompat.ACTION_MASK;
        double cos = Math.cos((3.141592653589793d * ((double) f)) / 180.0d);
        int i2 = ((int) (200.0d * cos)) + 55;
        int pow = (int) (Math.pow(cos, 200.0d) * 70.0d);
        if (i2 > MotionEventCompat.ACTION_MASK) {
            i2 = MotionEventCompat.ACTION_MASK;
        }
        if (pow <= MotionEventCompat.ACTION_MASK) {
            i = pow;
        }
        return new LightingColorFilter(Color.rgb(i2, i2, i2), Color.rgb(i, i, i));
    }

    private void m3424a(MotionEvent motionEvent) {
        removeCallbacks(this.f3457o);
        this.f3447e = (int) motionEvent.getX();
        this.f3448f = (int) motionEvent.getY();
        this.f3449g = m3428b(getChildAt(0)) - this.f3451i;
        m3455g();
        this.f3455m = VelocityTracker.obtain();
        this.f3455m.addMovement(motionEvent);
        this.f3446d = 1;
    }

    private void m3431b(float f) {
        m3421a(f, false);
    }

    private void m3421a(float f, boolean z) {
        if (this.f3455m != null || z) {
            if (this.f3455m != null) {
                this.f3455m.recycle();
            }
            this.f3455m = null;
            removeCallbacks(this.f3459q);
            if (this.f3457o == null) {
                this.f3457o = new StartAppSDK(this);
            }
            if (this.f3456n != null) {
                if (!z) {
                    this.f3456n.m3377a((float) this.f3450h, f, AnimationUtils.currentAnimationTimeMillis());
                }
                post(this.f3457o);
            }
            this.f3446d = 0;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3457o);
    }

    private void m3422a(int i) {
        this.f3450h = this.f3449g + i;
        this.f3452j = (-(this.f3450h * 270)) / getHeight();
        m3452f();
        requestLayout();
    }

    private void m3452f() {
        int i = this.f3452j % 90;
        if (i < 45) {
            i = ((-(this.f3452j - i)) * getHeight()) / 270;
        } else {
            i = ((-((this.f3452j + 90) - i)) * getHeight()) / 270;
        }
        if (this.f3464v == ExploreByTouchHelper.INVALID_ID && this.f3454l == this.f3445c.getCount() - 1 && m3436c(getChildAt(getChildCount() - 1)) < getHeight()) {
            this.f3464v = i;
        }
        if (i > 0) {
            i = 0;
        } else if (i < this.f3464v) {
            i = this.f3464v;
        }
        this.f3456n.m3376a((float) i);
        this.f3456n.m3382b((float) i);
    }

    private void m3455g() {
        if (this.f3459q == null) {
            this.f3459q = new StartAppSDK(this);
        }
        postDelayed(this.f3459q, (long) ViewConfiguration.getLongPressTimeout());
    }

    private boolean m3434b(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x >= this.f3447e - 10 && x <= this.f3447e + 10 && y >= this.f3448f - 10 && y <= this.f3448f + 10) {
            return false;
        }
        removeCallbacks(this.f3459q);
        this.f3446d = 2;
        return true;
    }

    private int m3413a(int i, int i2) {
        if (this.f3460r == null) {
            this.f3460r = new Rect();
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).getHitRect(this.f3460r);
            if (this.f3460r.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private void m3433b(int i, int i2) {
        int a = m3413a(i, i2);
        if (a != -1) {
            View childAt = getChildAt(a);
            a += this.f3453k;
            performItemClick(childAt, a, this.f3445c.getItemId(a));
        }
    }

    private void m3432b(int i) {
        View childAt = getChildAt(i);
        int i2 = this.f3453k + i;
        long itemId = this.f3445c.getItemId(i2);
        OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick(this, childAt, i2, itemId);
        }
    }

    private void m3439c(int i) {
        int childCount = getChildCount();
        if (this.f3454l != this.f3445c.getCount() - 1 && childCount > 1) {
            View childAt = getChildAt(0);
            while (childAt != null && m3436c(childAt) + i < 0) {
                removeViewInLayout(childAt);
                int i2 = childCount - 1;
                this.f3458p.addLast(childAt);
                this.f3453k++;
                this.f3451i += m3441d(childAt);
                if (i2 > 1) {
                    childAt = getChildAt(0);
                    childCount = i2;
                } else {
                    childAt = null;
                    childCount = i2;
                }
            }
        }
        if (this.f3453k != 0 && childCount > 1) {
            int i3 = childCount;
            View childAt2 = getChildAt(childCount - 1);
            while (childAt2 != null && m3428b(childAt2) + i > getHeight()) {
                removeViewInLayout(childAt2);
                i3--;
                this.f3458p.addLast(childAt2);
                this.f3454l--;
                childAt2 = i3 > 1 ? getChildAt(i3 - 1) : null;
            }
        }
    }

    private void m3444d(int i) {
        m3440c(m3436c(getChildAt(getChildCount() - 1)), i);
        m3445d(m3428b(getChildAt(0)), i);
    }

    private void m3440c(int i, int i2) {
        while (i + i2 < getHeight() && this.f3454l < this.f3445c.getCount() - 1) {
            this.f3454l++;
            View view = this.f3445c.getView(this.f3454l, getCachedView(), this);
            m3425a(view, 0);
            i += m3441d(view);
        }
    }

    private void m3445d(int i, int i2) {
        while (i + i2 > 0 && this.f3453k > 0) {
            this.f3453k--;
            View view = this.f3445c.getView(this.f3453k, getCachedView(), this);
            m3425a(view, 1);
            int d = m3441d(view);
            i -= d;
            this.f3451i -= d;
        }
    }

    private void m3425a(View view, int i) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new LayoutParams(-2, -2);
        } else {
            layoutParams = layoutParams2;
        }
        int i2 = i == 1 ? 0 : -1;
        view.setDrawingCacheEnabled(true);
        addViewInLayout(view, i2, layoutParams, true);
        view.measure(((int) (((float) getWidth()) * 0.85f)) | 1073741824, 0);
    }

    private void m3458h() {
        int i = this.f3451i + this.f3450h;
        float width = 0.0f * ((float) getWidth());
        float height = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (((float) getHeight()) * 0.9f);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            int sin = (int) (((double) width) * Math.sin((6.283185307179586d * ((double) height)) * ((double) i)));
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            sin += (getWidth() - measuredWidth) / 2;
            int a = m3414a(childAt);
            int i3 = i + a;
            childAt.layout(sin, i3, measuredWidth + sin, i3 + measuredHeight);
            i += (a * 2) + measuredHeight;
        }
    }

    private View getCachedView() {
        if (this.f3458p.size() != 0) {
            return (View) this.f3458p.removeFirst();
        }
        return null;
    }

    private int m3414a(View view) {
        return (int) ((((float) view.getMeasuredHeight()) * 0.35000002f) / 2.0f);
    }

    private int m3428b(View view) {
        return view.getTop() - m3414a(view);
    }

    private int m3436c(View view) {
        return view.getBottom() + m3414a(view);
    }

    private int m3441d(View view) {
        return view.getMeasuredHeight() + (m3414a(view) * 2);
    }

    public int getFirstItemPosition() {
        return this.f3453k;
    }

    public int getLastItemPosition() {
        return this.f3454l;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }
}
