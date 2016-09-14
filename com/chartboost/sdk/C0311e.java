package com.chartboost.sdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0290e;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C1203a;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0347c;
import com.chartboost.sdk.impl.az.C1234d;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.chartboost.sdk.e */
public abstract class C0311e {
    protected static Handler f722a;
    public C0287b f723b;
    private Map<String, C0291a> f724c;
    private Map<String, C0291a> f725d;
    private Map<String, C0291a> f726e;
    private C0310a f727f;

    /* renamed from: com.chartboost.sdk.e.1 */
    class C03051 implements Runnable {
        final /* synthetic */ String f709a;
        final /* synthetic */ C0291a f710b;
        final /* synthetic */ C0311e f711c;

        C03051(C0311e c0311e, String str, C0291a c0291a) {
            this.f711c = c0311e;
            this.f709a = str;
            this.f710b = c0291a;
        }

        public void run() {
            if (this.f711c.m720c(this.f709a)) {
                C0291a d = this.f711c.m722d(this.f709a);
                if (d.f598c == C0290e.NONE) {
                    d.f598c = C0290e.CACHED;
                }
                this.f711c.m731h(d);
                return;
            }
            this.f711c.m719c(this.f710b);
        }
    }

    /* renamed from: com.chartboost.sdk.e.2 */
    class C03062 implements Runnable {
        final /* synthetic */ C0291a f712a;
        final /* synthetic */ C0311e f713b;

        C03062(C0311e c0311e, C0291a c0291a) {
            this.f713b = c0311e;
            this.f712a = c0291a;
        }

        public void run() {
            az f = this.f713b.m728f(this.f712a);
            if (f != null) {
                this.f713b.m712a(f, this.f712a);
                C1203a.m4364a(this.f713b.m724e(), this.f712a.f600e, this.f712a.m589t(), this.f712a.f602g);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.e.3 */
    class C03073 implements Runnable {
        final /* synthetic */ C0291a f714a;
        final /* synthetic */ CBImpressionError f715b;
        final /* synthetic */ C0311e f716c;

        C03073(C0311e c0311e, C0291a c0291a, CBImpressionError cBImpressionError) {
            this.f716c = c0311e;
            this.f714a = c0291a;
            this.f715b = cBImpressionError;
        }

        public void run() {
            this.f716c.m739p(this.f714a);
            C0315f h = Chartboost.m350h();
            if (h != null && h.m752c()) {
                h.m748a(this.f714a, true);
            } else if (h != null && h.m754d()) {
                h.m750b(this.f714a);
            }
            this.f716c.m714b().m696a(this.f714a, this.f715b);
        }
    }

    /* renamed from: com.chartboost.sdk.e.a */
    protected interface C0310a {
        void m695a(C0291a c0291a);

        void m696a(C0291a c0291a, CBImpressionError cBImpressionError);

        void m697b(C0291a c0291a);

        void m698c(C0291a c0291a);

        void m699d(C0291a c0291a);

        void m700e(C0291a c0291a);

        boolean m701f(C0291a c0291a);

        boolean m702g(C0291a c0291a);

        boolean m703h(C0291a c0291a);
    }

    /* renamed from: com.chartboost.sdk.e.5 */
    class C12115 implements C0347c {
        final /* synthetic */ C0291a f4022a;
        final /* synthetic */ C0311e f4023b;

        /* renamed from: com.chartboost.sdk.e.5.1 */
        class C03081 implements Runnable {
            final /* synthetic */ C0269a f717a;
            final /* synthetic */ C12115 f718b;

            C03081(C12115 c12115, C0269a c0269a) {
                this.f718b = c12115;
                this.f717a = c0269a;
            }

            public void run() {
                try {
                    if (this.f717a.m438c()) {
                        this.f718b.f4022a.f614s = false;
                        Object e = this.f717a.m442e("type");
                        if (TextUtils.isEmpty(e) || !e.equals("native")) {
                            this.f718b.f4023b.m711a(this.f718b.f4022a, C0287b.WEB);
                        } else {
                            this.f718b.f4023b.m711a(this.f718b.f4022a, C0287b.NATIVE);
                        }
                        this.f718b.f4023b.m709a(this.f718b.f4022a, this.f717a);
                        return;
                    }
                    this.f718b.f4023b.m710a(this.f718b.f4022a, CBImpressionError.INVALID_RESPONSE);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* renamed from: com.chartboost.sdk.e.5.2 */
        class C03092 implements Runnable {
            final /* synthetic */ az f719a;
            final /* synthetic */ CBError f720b;
            final /* synthetic */ C12115 f721c;

            C03092(C12115 c12115, az azVar, CBError cBError) {
                this.f721c = c12115;
                this.f719a = azVar;
                this.f720b = cBError;
            }

            public void run() {
                this.f721c.f4022a.f614s = false;
                String str = "network failure";
                String str2 = "request %s failed with error %s: %s";
                Object[] objArr = new Object[3];
                objArr[0] = this.f719a.m882g();
                objArr[1] = this.f720b.m554a().name();
                objArr[2] = this.f720b.m555b() != null ? this.f720b.m555b() : XMLConstants.NULL_NS_URI;
                CBLogging.m385d(str, String.format(str2, objArr));
                this.f721c.f4023b.m710a(this.f721c.f4022a, this.f720b.m556c());
            }
        }

        C12115(C0311e c0311e, C0291a c0291a) {
            this.f4023b = c0311e;
            this.f4022a = c0291a;
        }

        public void m4419a(C0269a c0269a, az azVar) {
            Chartboost.m327a(new C03081(this, c0269a));
        }

        public void m4420a(C0269a c0269a, az azVar, CBError cBError) {
            Chartboost.m327a(new C03092(this, azVar, cBError));
        }
    }

    /* renamed from: com.chartboost.sdk.e.4 */
    class C15174 extends C1234d {
        final /* synthetic */ C0291a f4833a;
        final /* synthetic */ C0311e f4834b;

        C15174(C0311e c0311e, C0291a c0291a) {
            this.f4834b = c0311e;
            this.f4833a = c0291a;
        }

        public void m5695a(C0269a c0269a, az azVar) {
            if (C0299c.m667j() && !this.f4834b.m720c(this.f4833a.f600e)) {
                this.f4834b.m715b(this.f4833a.f600e);
            }
        }
    }

    protected abstract C0291a m706a(String str, boolean z);

    protected abstract C0310a m718c();

    public abstract String m724e();

    protected abstract az m728f(C0291a c0291a);

    protected abstract az m736m(C0291a c0291a);

    static {
        f722a = CBUtility.m400e();
    }

    public C0311e() {
        this.f723b = C0287b.NATIVE;
        this.f727f = null;
        this.f725d = new HashMap();
        this.f724c = new HashMap();
        this.f726e = new HashMap();
    }

    public void m713a(String str) {
        C0291a a = m706a(str, false);
        C0315f h = Chartboost.m350h();
        if (h != null && h.m754d()) {
            m710a(a, CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (!m717b(a)) {
            f722a.post(new C03051(this, str, a));
        }
    }

    public void m715b(String str) {
        C0291a d;
        if (m720c(str)) {
            d = m722d(str);
            if (d != null) {
                m714b().m699d(d);
                return;
            }
            return;
        }
        d = m706a(str, true);
        if (!m717b(d)) {
            m719c(d);
        }
    }

    protected void m708a(C0291a c0291a) {
        m741r(c0291a);
        m714b().m699d(c0291a);
        c0291a.f598c = C0290e.CACHED;
    }

    protected final boolean m717b(C0291a c0291a) {
        if (m714b().m703h(c0291a) || CBUtility.m391a().getInt("cbPrefSessionCount", 0) != 1) {
            return false;
        }
        m710a(c0291a, CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
        return true;
    }

    protected void m719c(C0291a c0291a) {
        if (m730g(c0291a) && m714b().m702g(c0291a) && !m705s(c0291a)) {
            if (!c0291a.f602g && c0291a.f599d == C0286a.MORE_APPS && C0299c.m680w()) {
                c0291a.f605j = true;
                Chartboost.m326a(c0291a);
            }
            if (m726e(c0291a)) {
                m723d(c0291a);
            }
        }
    }

    protected void m723d(C0291a c0291a) {
        ax.m845a().execute(new C03062(this, c0291a));
    }

    protected boolean m726e(C0291a c0291a) {
        return true;
    }

    private final synchronized boolean m705s(C0291a c0291a) {
        boolean z = true;
        synchronized (this) {
            if (m738o(c0291a) != null) {
                CBLogging.m381b(getClass().getSimpleName(), String.format("%s %s", new Object[]{"Request already in process for impression with location", c0291a.f600e}));
            } else {
                m740q(c0291a);
                z = false;
            }
        }
        return z;
    }

    protected void m710a(C0291a c0291a, CBImpressionError cBImpressionError) {
        Chartboost.m327a(new C03073(this, c0291a, cBImpressionError));
    }

    protected final boolean m730g(C0291a c0291a) {
        if (C0299c.m673p()) {
            C0315f h = Chartboost.m350h();
            if (!c0291a.f602g && h != null && h.m754d()) {
                m710a(c0291a, CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
                return false;
            } else if (ay.m847a().m855c()) {
                return true;
            } else {
                m710a(c0291a, CBImpressionError.INTERNET_UNAVAILABLE);
                return false;
            }
        }
        m710a(c0291a, CBImpressionError.SESSION_NOT_STARTED);
        return false;
    }

    protected void m731h(C0291a c0291a) {
        boolean z = c0291a.f598c != C0290e.DISPLAYED;
        if (z) {
            if (C0299c.m647b() != null && C0299c.m647b().doesWrapperUseCustomShouldDisplayBehavior()) {
                this.f726e.put(c0291a.f600e == null ? XMLConstants.NULL_NS_URI : c0291a.f600e, c0291a);
            }
            if (!m714b().m701f(c0291a)) {
                return;
            }
        }
        m704a(c0291a, z);
    }

    protected void m716b(String str, boolean z) {
        if (str == null) {
            str = XMLConstants.NULL_NS_URI;
        }
        C0291a c0291a = (C0291a) this.f726e.get(str);
        if (c0291a != null) {
            this.f726e.remove(str);
            if (z) {
                m704a(c0291a, true);
            }
        }
    }

    private void m704a(C0291a c0291a, boolean z) {
        boolean z2 = c0291a.f598c == C0290e.CACHED;
        m733j(c0291a);
        C0315f h = Chartboost.m350h();
        if (h != null) {
            if (h.m752c()) {
                h.m748a(c0291a, false);
            } else if (!(!c0291a.f605j || z2 || c0291a.f598c == C0290e.DISPLAYED)) {
                return;
            }
        }
        if (z) {
            m732i(c0291a);
        } else {
            Chartboost.m326a(c0291a);
        }
    }

    protected void m732i(C0291a c0291a) {
        Chartboost.m326a(c0291a);
    }

    protected void m733j(C0291a c0291a) {
        m734k(c0291a);
    }

    public void m734k(C0291a c0291a) {
        if (!c0291a.f603h) {
            c0291a.f603h = true;
            c0291a.f602g = false;
            m735l(c0291a);
            if (m722d(c0291a.f600e) == c0291a) {
                m725e(c0291a.f600e);
            }
        }
    }

    protected void m735l(C0291a c0291a) {
        az m = m736m(c0291a);
        m.m871a(true);
        if (c0291a.f602g) {
            m.m869a("cached", SchemaSymbols.ATTVAL_TRUE_1);
        } else {
            m.m869a("cached", SchemaSymbols.ATTVAL_FALSE_0);
        }
        Object e = c0291a.m563A().m442e("ad_id");
        if (e != null) {
            m.m869a("ad_id", e);
        }
        m.m869a("location", c0291a.f600e);
        m.m864a(new C15174(this, c0291a));
        C1203a.m4359a(m724e(), c0291a.f600e, c0291a.m589t());
    }

    protected final boolean m737n(C0291a c0291a) {
        return TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - c0291a.f597b.getTime()) >= 86400;
    }

    protected void m709a(C0291a c0291a, C0269a c0269a) {
        if (c0269a.m444f(NotificationCompatApi21.CATEGORY_STATUS) == 404) {
            CBLogging.m381b(c0291a.f599d, "Invalid status code" + c0269a.m431a(NotificationCompatApi21.CATEGORY_STATUS));
            m710a(c0291a, CBImpressionError.NO_AD_FOUND);
        } else if (c0269a.m444f(NotificationCompatApi21.CATEGORY_STATUS) != 200) {
            CBLogging.m381b(c0291a.f599d, "Invalid status code" + c0269a.m431a(NotificationCompatApi21.CATEGORY_STATUS));
            m710a(c0291a, CBImpressionError.INVALID_RESPONSE);
        } else {
            c0291a.m566a(c0269a, C0304d.m686a().f706a);
        }
    }

    protected final void m712a(az azVar, C0291a c0291a) {
        c0291a.f614s = true;
        azVar.m864a(new C12115(this, c0291a));
    }

    protected synchronized C0291a m738o(C0291a c0291a) {
        C0291a c0291a2;
        if (c0291a != null) {
            c0291a2 = (C0291a) this.f724c.get(c0291a.f600e);
        } else {
            c0291a2 = null;
        }
        return c0291a2;
    }

    protected synchronized void m739p(C0291a c0291a) {
        if (c0291a != null) {
            this.f724c.remove(c0291a.f600e);
        }
    }

    protected synchronized void m740q(C0291a c0291a) {
        if (c0291a != null) {
            this.f724c.put(c0291a.f600e, c0291a);
        }
    }

    public boolean m720c(String str) {
        return m722d(str) != null;
    }

    protected C0291a m722d(String str) {
        C0291a c0291a = (C0291a) this.f725d.get(str);
        return (c0291a == null || m737n(c0291a)) ? null : c0291a;
    }

    protected void m725e(String str) {
        this.f725d.remove(str);
    }

    protected void m707a() {
        this.f725d.clear();
    }

    protected void m741r(C0291a c0291a) {
        this.f725d.put(c0291a.f600e, c0291a);
    }

    protected final C0310a m714b() {
        if (this.f727f == null) {
            this.f727f = m718c();
        }
        return this.f727f;
    }

    protected Context m721d() {
        try {
            Method declaredMethod = Chartboost.class.getDeclaredMethod("getValidContext", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Context) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable e) {
            CBLogging.m382b(this, "Error encountered getting valid context", e);
            CBUtility.throwProguardError(e);
            return C0299c.m682y();
        }
    }

    public C0287b m727f() {
        return this.f723b;
    }

    public void m711a(C0291a c0291a, C0287b c0287b) {
        if (c0291a != null) {
            c0291a.f596a = c0287b;
        }
        this.f723b = c0287b;
    }

    public String m729g() {
        if (this.f723b == C0287b.NATIVE) {
            return "native";
        }
        return "web";
    }
}
