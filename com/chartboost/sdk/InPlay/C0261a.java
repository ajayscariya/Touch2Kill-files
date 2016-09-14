package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.C0293a;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0304d;
import com.chartboost.sdk.C0304d.C0303b;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0292b;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.C0420n.C0418a;
import com.chartboost.sdk.impl.C0420n.C0419b;
import com.chartboost.sdk.impl.C0423s;
import com.chartboost.sdk.impl.ab;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0347c;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bb;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: com.chartboost.sdk.InPlay.a */
public final class C0261a {
    private static final String f448a;
    private static ArrayList<CBInPlay> f449b;
    private static int f450c;
    private static C0261a f451d;
    private static LinkedHashMap<String, Bitmap> f452e;
    private static volatile boolean f453f;

    /* renamed from: com.chartboost.sdk.InPlay.a.1 */
    class C11841 implements C0347c {
        final /* synthetic */ String f3970a;
        final /* synthetic */ boolean f3971b;
        final /* synthetic */ C0261a f3972c;

        C11841(C0261a c0261a, String str, boolean z) {
            this.f3972c = c0261a;
            this.f3970a = str;
            this.f3971b = z;
        }

        public void m4310a(C0269a c0269a, az azVar) {
            C0261a.f453f = false;
            if (c0269a.m438c()) {
                CBInPlay cBInPlay = new CBInPlay();
                cBInPlay.m361a(c0269a);
                cBInPlay.m363b(c0269a.m442e("name"));
                if (!TextUtils.isEmpty(this.f3970a)) {
                    cBInPlay.m362a(this.f3970a);
                }
                C0269a a = c0269a.m431a("icons");
                if (a.m438c() && !TextUtils.isEmpty(a.m442e("lg"))) {
                    String e = a.m442e("lg");
                    if (C0261a.f452e.get(e) == null) {
                        C0419b c1187b = new C1187b(null);
                        C0418a c1186a = new C1186a(null);
                        c1187b.f3979c = cBInPlay;
                        c1187b.f3978b = e;
                        c1187b.f3977a = this.f3971b;
                        ba.m914a(C0299c.m682y()).m927a().m1119a(new ab(e, c1187b, 0, 0, null, c1186a));
                        return;
                    }
                    this.f3972c.m365a(cBInPlay, e, true);
                }
            }
        }

        public void m4311a(C0269a c0269a, az azVar, CBError cBError) {
            CBLogging.m381b(C0261a.f448a, "InPlay cache call failed" + cBError);
            C0261a.f453f = false;
            if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToLoadInPlay(this.f3970a, cBError != null ? cBError.m556c() : null);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.2 */
    class C11852 implements C0303b {
        final /* synthetic */ CBInPlay f3973a;
        final /* synthetic */ C0269a f3974b;
        final /* synthetic */ C0261a f3975c;

        C11852(C0261a c0261a, CBInPlay cBInPlay, C0269a c0269a) {
            this.f3975c = c0261a;
            this.f3973a = cBInPlay;
            this.f3974b = c0269a;
        }

        public void m4312a() {
            az d = C0304d.m686a().m694d();
            d.m869a("location", this.f3973a.getLocation());
            d.m868a("to", this.f3974b);
            d.m868a("cgn", this.f3974b);
            d.m868a("creative", this.f3974b);
            d.m868a("ad_id", this.f3974b);
            d.m868a("type", this.f3974b);
            d.m868a("more_type", this.f3974b);
            d.m871a(true);
            d.m894s();
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.a */
    private class C1186a implements C0418a {
        final /* synthetic */ C0261a f3976a;

        private C1186a(C0261a c0261a) {
            this.f3976a = c0261a;
        }

        public void m4313a(C0423s c0423s) {
            CBLogging.m381b(C0261a.f448a, "Bitmap download failed " + c0423s.getMessage());
        }
    }

    /* renamed from: com.chartboost.sdk.InPlay.a.b */
    private class C1187b implements C0419b<Bitmap> {
        protected boolean f3977a;
        protected String f3978b;
        protected CBInPlay f3979c;
        final /* synthetic */ C0261a f3980d;

        private C1187b(C0261a c0261a) {
            this.f3980d = c0261a;
        }

        public void m4314a(Bitmap bitmap) {
            C0261a.f452e.put(this.f3978b, bitmap);
            this.f3980d.m365a(this.f3979c, this.f3978b, this.f3977a);
        }
    }

    static {
        f448a = C0261a.class.getSimpleName();
        f450c = 4;
        f453f = false;
    }

    private C0261a() {
        f449b = new ArrayList();
        f452e = new LinkedHashMap(f450c);
    }

    public static C0261a m364a() {
        if (f451d == null) {
            synchronized (C0261a.class) {
                if (f451d == null) {
                    f451d = new C0261a();
                }
            }
        }
        return f451d;
    }

    public synchronized void m374a(String str) {
        if (!(C0261a.m372e() || f453f)) {
            m367a(str, true);
        }
    }

    private static boolean m372e() {
        return f449b.size() == f450c;
    }

    public synchronized boolean m376b(String str) {
        boolean z;
        if (f449b.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized CBInPlay m377c(String str) {
        CBInPlay cBInPlay;
        cBInPlay = null;
        if (f449b.size() > 0) {
            cBInPlay = (CBInPlay) f449b.get(0);
            f449b.remove(0);
        }
        if (!(C0261a.m372e() || f453f)) {
            m367a(str, true);
        }
        if (cBInPlay == null) {
            CBLogging.m379a(f448a, "InPlay Object not available returning null :(");
        }
        return cBInPlay;
    }

    private void m367a(String str, boolean z) {
        f453f = true;
        az azVar = new az("/inplay/get");
        azVar.m869a("raw", Boolean.valueOf(true));
        azVar.m869a("cache", Boolean.valueOf(true));
        azVar.m866a(C0414a.HIGH);
        azVar.m875b(true);
        azVar.m869a("location", (Object) str);
        azVar.m863a(C0292b.f625e);
        azVar.m864a(new C11841(this, str, z));
    }

    private synchronized void m365a(CBInPlay cBInPlay, String str, boolean z) {
        cBInPlay.m360a((Bitmap) f452e.get(str));
        f449b.add(cBInPlay);
        C0293a g = C0299c.m663g();
        if (g != null && z) {
            g.didCacheInPlay(cBInPlay.getLocation());
        }
        if (!(C0261a.m372e() || f453f)) {
            m367a(cBInPlay.getLocation(), false);
        }
    }

    protected void m373a(CBInPlay cBInPlay) {
        Object a = cBInPlay.m359a();
        az azVar = new az("/inplay/show");
        azVar.m869a("inplay-dictionary", a);
        azVar.m869a("location", cBInPlay.getLocation());
        azVar.m871a(true);
        azVar.m894s();
        if (cBInPlay.m359a().m438c()) {
            a.m442e("ad_id");
        }
    }

    protected void m375b(CBInPlay cBInPlay) {
        String str;
        C0269a a = cBInPlay.m359a();
        if (a != null) {
            String e = a.m442e("link");
            String e2 = a.m442e("deep-link");
            if (!TextUtils.isEmpty(e2)) {
                try {
                    if (!bb.m941a(e2)) {
                        e2 = e;
                    }
                    str = e2;
                } catch (Exception e3) {
                    CBLogging.m381b(f448a, "Cannot open a url");
                }
            }
            str = e;
        } else {
            str = null;
        }
        C0303b c11852 = new C11852(this, cBInPlay, a);
        C0304d a2 = C0304d.m686a();
        if (TextUtils.isEmpty(str)) {
            a2.f707b.m937a(null, false, str, CBClickError.URI_INVALID, c11852);
        } else {
            a2.m691b(null, str, c11852);
        }
    }

    public static void m369b() {
        if (f452e != null) {
            f452e.clear();
        }
        if (f449b != null) {
            f449b.clear();
        }
    }
}
