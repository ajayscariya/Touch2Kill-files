package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1201j;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public abstract class bl extends RelativeLayout {
    private static Rect f997b;
    private C1242a f998a;
    protected boolean f999c;
    protected Button f1000d;
    private boolean f1001e;

    /* renamed from: com.chartboost.sdk.impl.bl.1 */
    class C03841 implements OnTouchListener {
        final /* synthetic */ bl f995a;

        C03841(bl blVar) {
            this.f995a = blVar;
        }

        public boolean onTouch(View v, MotionEvent event) {
            boolean a = bl.m1015b(v, event);
            switch (event.getActionMasked()) {
                case DurationDV.DURATION_TYPE /*0*/:
                    this.f995a.f998a.m4663a(a);
                    return a;
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    if (this.f995a.getVisibility() == 0 && this.f995a.isEnabled() && a) {
                        this.f995a.m1018a(event);
                    }
                    this.f995a.f998a.m4663a(false);
                    break;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    this.f995a.f998a.m4663a(a);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    this.f995a.f998a.m4663a(false);
                    break;
            }
            return true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bl.2 */
    class C03852 implements OnClickListener {
        final /* synthetic */ bl f996a;

        C03852(bl blVar) {
            this.f996a = blVar;
        }

        public void onClick(View v) {
            this.f996a.m1018a(null);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bl.a */
    public class C1242a extends bk {
        final /* synthetic */ bl f4193b;

        public C1242a(bl blVar, Context context) {
            this.f4193b = blVar;
            super(context);
            blVar.f999c = false;
        }

        protected void m4663a(boolean z) {
            if (this.f4193b.f1001e && z) {
                if (!this.f4193b.f999c) {
                    if (getDrawable() != null) {
                        getDrawable().setColorFilter(1996488704, Mode.SRC_ATOP);
                    } else if (getBackground() != null) {
                        getBackground().setColorFilter(1996488704, Mode.SRC_ATOP);
                    }
                    invalidate();
                    this.f4193b.f999c = true;
                }
            } else if (this.f4193b.f999c) {
                if (getDrawable() != null) {
                    getDrawable().clearColorFilter();
                } else if (getBackground() != null) {
                    getBackground().clearColorFilter();
                }
                invalidate();
                this.f4193b.f999c = false;
            }
        }

        public void m4662a(C1201j c1201j, LayoutParams layoutParams) {
            m1011a(c1201j);
            layoutParams.width = c1201j.m4351h();
            layoutParams.height = c1201j.m4352i();
        }
    }

    protected abstract void m1018a(MotionEvent motionEvent);

    static {
        f997b = new Rect();
    }

    public bl(Context context) {
        super(context);
        this.f999c = false;
        this.f1000d = null;
        this.f1001e = true;
        m1014b();
    }

    private void m1014b() {
        this.f998a = new C1242a(this, getContext());
        this.f998a.setOnTouchListener(new C03841(this));
        addView(this.f998a, new RelativeLayout.LayoutParams(-1, -1));
    }

    private static boolean m1015b(View view, MotionEvent motionEvent) {
        view.getLocalVisibleRect(f997b);
        Rect rect = f997b;
        rect.left += view.getPaddingLeft();
        rect = f997b;
        rect.top += view.getPaddingTop();
        rect = f997b;
        rect.right -= view.getPaddingRight();
        rect = f997b;
        rect.bottom -= view.getPaddingBottom();
        return f997b.contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
    }

    public void m1022a(String str) {
        if (str != null) {
            m1017a().setText(str);
            addView(m1017a(), new RelativeLayout.LayoutParams(-1, -1));
            this.f998a.setVisibility(8);
            m1023a(false);
            this.f1000d.setOnClickListener(new C03852(this));
        } else if (this.f1000d != null) {
            removeView(m1017a());
            this.f1000d = null;
            this.f998a.setVisibility(0);
            m1023a(true);
        }
    }

    public TextView m1017a() {
        if (this.f1000d == null) {
            this.f1000d = new Button(getContext());
            this.f1000d.setGravity(17);
        }
        this.f1000d.postInvalidate();
        return this.f1000d;
    }

    public void m1020a(C1201j c1201j) {
        this.f998a.m1011a(c1201j);
        m1022a(null);
    }

    public void m1021a(C1201j c1201j, RelativeLayout.LayoutParams layoutParams) {
        this.f998a.m4662a(c1201j, layoutParams);
        m1022a(null);
    }

    public void m1019a(ScaleType scaleType) {
        this.f998a.setScaleType(scaleType);
    }

    public void m1023a(boolean z) {
        this.f1001e = z;
    }
}
