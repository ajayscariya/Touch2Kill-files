package com.chartboost.sdk.impl;

import com.chartboost.sdk.C0297b;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0311e;
import com.chartboost.sdk.C0311e.C0310a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0286a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0288c;
import com.chartboost.sdk.Model.C0292b;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.bd.C0364a;
import mf.javax.xml.transform.OutputKeys;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONArray;

public class ae extends C0311e {
    private static final String f4035c;
    private static ae f4036d;

    /* renamed from: com.chartboost.sdk.impl.ae.1 */
    class C03221 implements Runnable {
        final /* synthetic */ C0269a f762a;
        final /* synthetic */ ae f763b;

        C03221(ae aeVar, C0269a c0269a) {
            this.f763b = aeVar;
            this.f762a = c0269a;
        }

        public void run() {
            C0297b.m613c();
            if (this.f762a.m438c() && this.f762a.m431a("ad_units").m438c()) {
                C0297b.m604a(this.f762a.m431a("ad_units"), false);
            } else {
                C0297b.m604a(null, false);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ae.2 */
    class C12152 implements C0310a {
        final /* synthetic */ ae f4034a;

        C12152(ae aeVar) {
            this.f4034a = aeVar;
        }

        public void m4436a(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didClickInterstitial(c0291a.f600e);
            }
        }

        public void m4438b(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCloseInterstitial(c0291a.f600e);
            }
        }

        public void m4439c(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDismissInterstitial(c0291a.f600e);
            }
        }

        public void m4440d(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didCacheInterstitial(c0291a.f600e);
            }
        }

        public void m4437a(C0291a c0291a, CBImpressionError cBImpressionError) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToLoadInterstitial(c0291a.f600e, cBImpressionError);
            }
        }

        public void m4441e(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                C0299c.m663g().didDisplayInterstitial(c0291a.f600e);
            }
        }

        public boolean m4442f(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m663g().shouldDisplayInterstitial(c0291a.f600e);
            }
            return true;
        }

        public boolean m4443g(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m663g().shouldRequestInterstitial(c0291a.f600e);
            }
            return true;
        }

        public boolean m4444h(C0291a c0291a) {
            if (C0299c.m663g() != null) {
                return C0299c.m679v();
            }
            return true;
        }
    }

    static {
        f4035c = ae.class.getSimpleName();
    }

    protected ae() {
    }

    public static ae m4445h() {
        if (f4036d == null) {
            f4036d = new ae();
        }
        return f4036d;
    }

    protected boolean m4448b(C0291a c0291a, C0269a c0269a) {
        return c0269a.m431a(OutputKeys.MEDIA_TYPE) != null && c0269a.m431a(OutputKeys.MEDIA_TYPE).equals("video");
    }

    protected void m4452h(C0291a c0291a) {
        super.m731h(c0291a);
    }

    protected void m4447a(C0291a c0291a, C0269a c0269a) {
        if (c0291a.f596a == C0287b.NATIVE) {
            if (m4448b(c0291a, c0269a) && !be.m974c(c0269a)) {
                CBLogging.m381b(f4035c, "Video Media unavailable for the cached impression");
                m710a(c0291a, CBImpressionError.VIDEO_UNAVAILABLE);
                return;
            }
        } else if (C0297b.m606a(c0269a)) {
            ax.m845a().execute(new C03221(this, c0269a));
        } else {
            CBLogging.m381b(f4035c, "WebView ad id for the html unavailable");
            m710a(c0291a, CBImpressionError.ERROR_LOADING_WEB_VIEW);
            return;
        }
        super.m709a(c0291a, c0269a);
    }

    protected C0291a m4446a(String str, boolean z) {
        return new C0291a(C0286a.INTERSTITIAL, z, str, false, m727f());
    }

    protected az m4451f(C0291a c0291a) {
        az azVar;
        if (C0299c.m627A() == "/interstitial/get") {
            c0291a.f596a = C0287b.NATIVE;
        } else {
            c0291a.f596a = C0287b.WEB;
        }
        if (c0291a.f596a == C0287b.NATIVE) {
            azVar = new az(C0299c.m627A());
            azVar.m869a("local-videos", m4453i());
            azVar.m866a(C0414a.HIGH);
            azVar.m863a(C0292b.f626f);
            azVar.m869a("location", c0291a.f600e);
            if (c0291a.f602g) {
                azVar.m869a("cache", SchemaSymbols.ATTVAL_TRUE_1);
                azVar.m875b(true);
            }
        } else {
            C0269a a = C0297b.m600a(false);
            azVar = new bd(C0299c.m627A());
            azVar.m4581a("ad_units", a, C0364a.AD);
            azVar.m866a(C0414a.HIGH);
            azVar.m4581a("location", c0291a.f600e, C0364a.AD);
            if (c0291a.f602g) {
                azVar.m4581a("cache", Boolean.valueOf(true), C0364a.AD);
                azVar.m875b(true);
            } else {
                azVar.m4581a("cache", Boolean.valueOf(false), C0364a.AD);
            }
            azVar.m863a(C0292b.f626f);
        }
        return azVar;
    }

    protected void m4454j(C0291a c0291a) {
        if (c0291a.f601f != C0288c.INTERSTITIAL_VIDEO) {
            super.m733j(c0291a);
        }
    }

    protected C0310a m4449c() {
        return new C12152(this);
    }

    protected az m4455m(C0291a c0291a) {
        return new az("/interstitial/show");
    }

    public JSONArray m4453i() {
        JSONArray jSONArray = new JSONArray();
        String[] d = C0278h.m498d();
        if (d != null) {
            for (String str : d) {
                if (!str.contains("nomedia")) {
                    jSONArray.put(str);
                }
            }
        }
        return jSONArray;
    }

    public String m4450e() {
        return String.format("%s-%s", new Object[]{"interstitial", m729g()});
    }
}
