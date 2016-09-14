package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Libraries.CBUtility;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import mf.javax.xml.XMLConstants;

public class ar extends ap {
    private aw f4085a;
    private TextView f4086b;
    private TextView f4087c;
    private TextView f4088d;
    private LinearLayout f4089e;
    private au f4090f;
    private bl f4091g;
    private int f4092h;
    private Point f4093i;
    private C1201j f4094j;
    private OnClickListener f4095k;

    /* renamed from: com.chartboost.sdk.impl.ar.1 */
    class C12281 extends bl {
        final /* synthetic */ ar f4084a;

        C12281(ar arVar, Context context) {
            this.f4084a = arVar;
            super(context);
        }

        protected void m4508a(MotionEvent motionEvent) {
            this.f4084a.f4095k.onClick(this.f4084a.f4091g);
        }
    }

    public ar(aw awVar, Context context) {
        super(context);
        this.f4085a = awVar;
        this.f4089e = new LinearLayout(context);
        this.f4089e.setOrientation(1);
        setGravity(16);
        boolean a = C0320g.m768a(context);
        this.f4086b = new TextView(context);
        this.f4086b.setTypeface(null, 1);
        this.f4086b.setTextSize(2, a ? 21.0f : 16.0f);
        this.f4086b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4086b.setSingleLine();
        this.f4086b.setEllipsize(TruncateAt.END);
        this.f4087c = new TextView(context);
        this.f4087c.setTextSize(2, a ? 16.0f : 10.0f);
        this.f4087c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4087c.setSingleLine();
        this.f4087c.setEllipsize(TruncateAt.END);
        this.f4088d = new TextView(context);
        this.f4088d.setTextSize(2, a ? 18.0f : 11.0f);
        this.f4088d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4088d.setMaxLines(2);
        this.f4088d.setEllipsize(TruncateAt.END);
        this.f4091g = new C12281(this, context);
        this.f4091g.m1019a(ScaleType.FIT_CENTER);
        this.f4090f = new au(context);
        setFocusable(false);
        setGravity(16);
        addView(this.f4090f);
        addView(this.f4089e, new LayoutParams(0, -2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        addView(this.f4091g);
        setBackgroundColor(0);
        this.f4089e.addView(this.f4086b, new LayoutParams(-1, -2));
        this.f4089e.addView(this.f4087c, new LayoutParams(-1, -2));
        this.f4089e.addView(this.f4088d, new LayoutParams(-1, -1));
    }

    public void setOnClickListener(OnClickListener clickListener) {
        super.setOnClickListener(clickListener);
        this.f4095k = clickListener;
    }

    public void m4514a(C0269a c0269a, int i) {
        this.f4086b.setText(c0269a.m431a("name").m440d("Unknown App"));
        if (TextUtils.isEmpty(c0269a.m442e("publisher"))) {
            this.f4087c.setVisibility(8);
        } else {
            this.f4087c.setText(c0269a.m442e("publisher"));
        }
        if (TextUtils.isEmpty(c0269a.m442e("description"))) {
            this.f4088d.setVisibility(8);
        } else {
            this.f4088d.setText(c0269a.m442e("description"));
        }
        this.f4092h = c0269a.m436b("border-color") ? -4802890 : C0320g.m766a(c0269a.m442e("border-color"));
        if (c0269a.m439c("offset")) {
            this.f4093i = new Point(c0269a.m431a("offset").m444f("x"), c0269a.m431a("offset").m444f("y"));
        } else {
            this.f4093i = new Point(0, 0);
        }
        this.f4094j = null;
        if (c0269a.m439c("deep-link") && bb.m941a(c0269a.m442e("deep-link"))) {
            if (this.f4085a.f4120l.m4348e()) {
                this.f4094j = this.f4085a.f4120l;
            } else {
                this.f4091g.m1022a("Play");
            }
        } else if (this.f4085a.f4119k.m4348e()) {
            this.f4094j = this.f4085a.f4119k;
        } else {
            this.f4091g.m1022a("Install");
        }
        int a = CBUtility.m390a(C0320g.m768a(getContext()) ? 14 : 7, getContext());
        if (this.f4094j != null) {
            this.f4091g.m1020a(this.f4094j);
            a = (a * 2) + Math.round((((float) this.f4094j.m4345b()) * ((float) m4512c())) / ((float) this.f4094j.m4346c()));
        } else {
            this.f4091g.m1017a().setTextColor(-14571545);
            a = CBUtility.m390a(8, getContext());
            this.f4091g.m1017a().setPadding(a, a, a, a);
            a = CBUtility.m390a(100, getContext());
        }
        this.f4091g.setLayoutParams(new LayoutParams(a, m4512c()));
        removeView(this.f4090f);
        this.f4090f = new au(getContext());
        addView(this.f4090f, 0);
        m4510a(this.f4090f, i, c0269a.m431a("assets").m431a("icon"));
        this.f4090f.m4521a(this.f4092h);
        this.f4090f.m4520a(0.16666667f);
        m4515b();
    }

    private void m4510a(bk bkVar, int i, C0269a c0269a) {
        if (!c0269a.m435b()) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            String str = XMLConstants.NULL_NS_URI;
            if (!(c0269a.m442e("checksum") == null || c0269a.m442e("checksum").isEmpty())) {
                str = c0269a.m442e("checksum");
            }
            bc.m956a().m962a(c0269a.m442e(DatabaseOpenHelper.HISTORY_ROW_URL), str, null, bkVar, bundle);
        }
    }

    protected void m4515b() {
        int a = CBUtility.m390a(C0320g.m768a(getContext()) ? 14 : 7, getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(m4513a() - (a * 2), m4513a() - (a * 2));
        layoutParams.setMargins(a, a, a, a);
        this.f4089e.setPadding(0, a, 0, a);
        this.f4091g.setPadding((this.f4093i.x * 2) + a, this.f4093i.y * 2, a, 0);
        this.f4090f.setLayoutParams(layoutParams);
        this.f4090f.setScaleType(ScaleType.FIT_CENTER);
    }

    public int m4513a() {
        int i = 134;
        if (CBUtility.m397c().m470b()) {
            if (!C0320g.m768a(getContext())) {
                i = 75;
            }
        } else if (!C0320g.m768a(getContext())) {
            i = 77;
        }
        return CBUtility.m390a(i, getContext());
    }

    private int m4512c() {
        int i = 74;
        if (CBUtility.m397c().m470b()) {
            if (!C0320g.m768a(getContext())) {
                i = 41;
            }
        } else if (!C0320g.m768a(getContext())) {
            i = 41;
        }
        return CBUtility.m390a(i, getContext());
    }
}
