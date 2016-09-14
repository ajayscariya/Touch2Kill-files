package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0318a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0272f;
import com.chartboost.sdk.Libraries.C1201j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aw extends C0320g {
    protected C1201j f4119k;
    protected C1201j f4120l;
    private List<C0269a> f4121m;
    private C1201j f4122n;
    private C1201j f4123o;
    private C1201j f4124p;
    private C1201j f4125q;
    private C1201j f4126r;
    private C1201j f4127s;
    private C1201j f4128t;
    private Set<C1201j> f4129u;
    private int f4130v;
    private C0269a f4131w;
    private int f4132x;
    private int f4133y;
    private String f4134z;

    /* renamed from: com.chartboost.sdk.impl.aw.b */
    private enum C0343b {
        FEATURED("featured", aq.class),
        REGULAR("regular", ar.class),
        WEBVIEW("webview", at.class),
        VIDEO("video", as.class);
        
        private String f833e;
        private Class<? extends ap> f834f;

        private C0343b(String str, Class<? extends ap> cls) {
            this.f833e = str;
            this.f834f = cls;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.aw.a */
    public class C1231a extends C0318a {
        final /* synthetic */ aw f4112b;
        private bl f4113c;
        private bk f4114d;
        private TextView f4115e;
        private RelativeLayout f4116f;
        private ListView f4117g;
        private C0342a f4118h;

        /* renamed from: com.chartboost.sdk.impl.aw.a.a */
        public class C0342a extends ArrayAdapter<C0269a> {
            final /* synthetic */ C1231a f826a;
            private Context f827b;

            /* renamed from: com.chartboost.sdk.impl.aw.a.a.1 */
            class C03411 implements OnClickListener {
                final /* synthetic */ C0269a f824a;
                final /* synthetic */ C0342a f825b;

                C03411(C0342a c0342a, C0269a c0269a) {
                    this.f825b = c0342a;
                    this.f824a = c0269a;
                }

                public void onClick(View v) {
                    String e = this.f824a.m442e("deep-link");
                    if (TextUtils.isEmpty(e) || !bb.m941a(e)) {
                        e = this.f824a.m442e("link");
                    }
                    if (!this.f825b.f826a.f4112b.m777a(e, this.f824a)) {
                    }
                }
            }

            public /* synthetic */ Object getItem(int x0) {
                return m842a(x0);
            }

            public C0342a(C1231a c1231a, Context context) {
                this.f826a = c1231a;
                super(context, 0, c1231a.f4112b.f4121m);
                this.f827b = context;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                int i = 0;
                C0269a a = m842a(position);
                C0269a a2 = a.m431a("type");
                if (convertView == null) {
                    View view;
                    C0343b[] values = C0343b.values();
                    while (i < values.length) {
                        if (a2.equals(values[i].f833e)) {
                            try {
                                view = (ap) values[i].f834f.getConstructor(new Class[]{aw.class, Context.class}).newInstance(new Object[]{this.f826a.f4112b, this.f827b});
                                break;
                            } catch (Throwable e) {
                                CBLogging.m382b(this, "error in more apps list", e);
                                view = null;
                            }
                        } else {
                            i++;
                        }
                    }
                    view = null;
                    convertView = view;
                } else if (!(convertView instanceof ap)) {
                    return convertView;
                } else {
                    ap convertView2 = (ap) convertView;
                }
                if (convertView == null) {
                    return new View(getContext());
                }
                convertView.m841a(a, position);
                LayoutParams layoutParams = convertView.getLayoutParams();
                if (layoutParams == null || !(layoutParams instanceof AbsListView.LayoutParams)) {
                    layoutParams = new AbsListView.LayoutParams(-1, convertView.m840a());
                } else {
                    layoutParams = (AbsListView.LayoutParams) layoutParams;
                    layoutParams.width = -1;
                    layoutParams.height = convertView.m840a();
                }
                convertView.setLayoutParams(layoutParams);
                convertView.setOnClickListener(new C03411(this, a));
                return convertView;
            }

            public int getCount() {
                return this.f826a.f4112b.f4121m.size();
            }

            public C0269a m842a(int i) {
                return (C0269a) this.f826a.f4112b.f4121m.get(i);
            }

            public int getItemViewType(int position) {
                C0269a a = m842a(position).m431a("type");
                C0343b[] values = C0343b.values();
                for (int i = 0; i < values.length; i++) {
                    if (a.equals(values[i].f833e)) {
                        return i;
                    }
                }
                return 0;
            }

            public int getViewTypeCount() {
                return C0343b.values().length;
            }
        }

        /* renamed from: com.chartboost.sdk.impl.aw.a.1 */
        class C12301 extends bl {
            final /* synthetic */ aw f4110a;
            final /* synthetic */ C1231a f4111b;

            C12301(C1231a c1231a, Context context, aw awVar) {
                this.f4111b = c1231a;
                this.f4110a = awVar;
                super(context);
            }

            protected void m4544a(MotionEvent motionEvent) {
                this.f4111b.f4112b.m786h();
            }
        }

        private C1231a(aw awVar, Context context) {
            this.f4112b = awVar;
            super(awVar, context);
            setBackgroundColor(-1);
            this.f4114d = new bk(context);
            this.f4113c = new C12301(this, context, awVar);
            this.f4115e = new TextView(context);
            this.f4115e.setBackgroundColor(awVar.f4132x);
            this.f4115e.setText(awVar.f4134z);
            this.f4115e.setTextColor(awVar.f4133y);
            this.f4115e.setTextSize(2, m764c() ? 30.0f : 18.0f);
            this.f4115e.setGravity(17);
            this.f4117g = new ListView(context);
            this.f4117g.setBackgroundColor(-1);
            this.f4117g.setDividerHeight(0);
            m760a(this.f4117g);
            addView(this.f4117g);
            this.f4114d.setFocusable(false);
            this.f4113c.setFocusable(false);
            this.f4113c.setClickable(true);
            this.f4114d.setScaleType(ScaleType.CENTER_CROP);
            this.f4113c.m1019a(ScaleType.FIT_CENTER);
            this.f4116f = new RelativeLayout(context);
            this.f4116f.addView(this.f4114d, new RelativeLayout.LayoutParams(-1, -1));
            this.f4116f.addView(this.f4115e, new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f4116f, new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f4113c, new RelativeLayout.LayoutParams(-1, -1));
            m760a(this.f4116f);
            this.f4118h = new C0342a(this, context);
        }

        protected void m4545a(int i, int i2) {
            C1201j e;
            int i3;
            Context context = getContext();
            C0272f c = CBUtility.m397c();
            if (c.m469a() && this.f4112b.f4125q.m4348e()) {
                e = this.f4112b.f4125q;
            } else if (c.m470b() && this.f4112b.f4126r.m4348e()) {
                e = this.f4112b.f4126r;
            } else if (this.f4112b.f4128t.m4348e()) {
                e = this.f4112b.f4128t;
            } else {
                e = null;
            }
            if (e != null) {
                this.f4112b.f4130v = e.m4352i();
                if (e.m4351h() < i) {
                    this.f4112b.f4130v = Math.round(((float) this.f4112b.f4130v) * (((float) i) / ((float) e.m4351h())));
                }
                this.f4115e.setVisibility(8);
                this.f4114d.m1011a(e);
            } else {
                this.f4112b.f4130v = CBUtility.m390a(m764c() ? 80 : 40, context);
                this.f4115e.setVisibility(0);
            }
            if (this.f4112b.f4131w.m438c()) {
                this.f4112b.f4130v = CBUtility.m390a(this.f4112b.f4131w.m454k(), context);
            }
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f4112b.f4130v);
            if (this.f4112b.f4123o.m4348e() && c.m469a()) {
                e = this.f4112b.f4123o;
            } else if (this.f4112b.f4124p.m4348e() && c.m470b()) {
                e = this.f4112b.f4124p;
            } else if (this.f4112b.f4122n.m4348e()) {
                e = this.f4112b.f4122n;
            } else {
                e = null;
            }
            if (e != null) {
                this.f4113c.m1021a(e, layoutParams2);
                if (m764c()) {
                    i3 = 14;
                } else {
                    i3 = 7;
                }
                i3 = CBUtility.m390a(i3, context);
            } else {
                this.f4113c.m1022a("X");
                this.f4113c.m1017a().setTextSize(2, m764c() ? 26.0f : 16.0f);
                this.f4113c.m1017a().setTextColor(this.f4112b.f4133y);
                this.f4113c.m1017a().setTypeface(Typeface.SANS_SERIF, 1);
                layoutParams2.width = this.f4112b.f4130v / 2;
                layoutParams2.height = this.f4112b.f4130v / 3;
                if (m764c()) {
                    i3 = 30;
                } else {
                    i3 = 20;
                }
                i3 = CBUtility.m390a(i3, context);
            }
            int round = Math.round(((float) (this.f4112b.f4130v - layoutParams2.height)) / 2.0f);
            layoutParams2.rightMargin = i3;
            layoutParams2.topMargin = round;
            layoutParams2.addRule(11);
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.addRule(3, this.f4116f.getId());
            this.f4117g.setAdapter(this.f4118h);
            this.f4117g.setLayoutParams(layoutParams);
            this.f4113c.setLayoutParams(layoutParams2);
            this.f4116f.setLayoutParams(layoutParams3);
        }

        public void m4546b() {
            super.m763b();
            this.f4113c = null;
            this.f4114d = null;
            this.f4117g = null;
        }
    }

    public aw(C0291a c0291a) {
        super(c0291a);
        this.f4121m = new ArrayList();
        this.f4128t = new C1201j(this);
        this.f4126r = new C1201j(this);
        this.f4125q = new C1201j(this);
        this.f4127s = new C1201j(this);
        this.f4122n = new C1201j(this);
        this.f4124p = new C1201j(this);
        this.f4123o = new C1201j(this);
        this.f4120l = new C1201j(this);
        this.f4119k = new C1201j(this);
    }

    protected C0318a m4563b(Context context) {
        return new C1231a(context, null);
    }

    public boolean m4562a(C0269a c0269a) {
        int i = 0;
        if (!super.m776a(c0269a)) {
            return false;
        }
        C0269a a = c0269a.m431a("cells");
        if (a.m435b()) {
            m772a(CBImpressionError.INVALID_RESPONSE);
            return false;
        }
        this.f4129u = new HashSet();
        while (i < a.m458o()) {
            C0269a c = a.m437c(i);
            this.f4121m.add(c);
            C0269a a2 = c.m431a("type");
            if (a2.equals("regular")) {
                c = c.m431a("assets");
                if (c.m438c()) {
                    m4548a(c, "icon");
                }
            } else if (a2.equals("featured")) {
                c = c.m431a("assets");
                if (c.m438c()) {
                    m4548a(c, "portrait");
                    m4548a(c, "landscape");
                }
            } else if (a2.equals("webview")) {
            }
            i++;
        }
        this.f4122n.m4343a("close");
        this.f4124p.m4343a("close-landscape");
        this.f4123o.m4343a("close-portrait");
        this.f4128t.m4343a("header-center");
        this.f4125q.m4343a("header-portrait");
        this.f4126r.m4343a("header-landscape");
        this.f4127s.m4343a("header-tile");
        this.f4120l.m4343a("play-button");
        this.f4119k.m4343a("install-button");
        this.f4131w = this.e.m431a("header-height");
        if (this.f4131w.m438c()) {
            this.f4130v = this.f4131w.m454k();
        } else {
            this.f4130v = C0320g.m768a(C0299c.m682y()) ? 80 : 40;
        }
        this.f4132x = this.e.m439c("background-color") ? C0320g.m766a(this.e.m442e("background-color")) : -14571545;
        this.f4134z = this.e.m439c("header-text") ? this.e.m442e("header-text") : "More Free Games";
        this.f4133y = this.e.m439c("text-color") ? C0320g.m766a(this.e.m442e("text-color")) : -1;
        return true;
    }

    private void m4548a(C0269a c0269a, String str) {
        if (!c0269a.m436b(str)) {
            C1201j c1201j = new C1201j(this);
            this.f4129u.add(c1201j);
            c1201j.m4342a(c0269a, str, new Bundle());
        }
    }

    public void m4564d() {
        super.m782d();
        this.f4121m = null;
        for (C1201j d : this.f4129u) {
            d.m4347d();
        }
        this.f4129u.clear();
        this.f4122n.m4347d();
        this.f4124p.m4347d();
        this.f4123o.m4347d();
        this.f4128t.m4347d();
        this.f4127s.m4347d();
        this.f4125q.m4347d();
        this.f4126r.m4347d();
        this.f4120l.m4347d();
        this.f4119k.m4347d();
    }
}
