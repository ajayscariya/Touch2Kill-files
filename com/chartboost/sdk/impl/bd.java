package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.chartboost.sdk.Libraries.C0266c;
import com.chartboost.sdk.Libraries.C0266c.C0265a;
import com.chartboost.sdk.Libraries.C0271e;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBUtility;
import com.google.android.gcm.GCMConstants;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

public final class bd extends az {
    private C0269a f4142c;
    private C0269a f4143d;
    private C0269a f4144e;
    private C0269a f4145f;

    /* renamed from: com.chartboost.sdk.impl.bd.1 */
    static /* synthetic */ class C03631 {
        static final /* synthetic */ int[] f942a;

        static {
            f942a = new int[C0364a.values().length];
            try {
                f942a[C0364a.AD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bd.a */
    public enum C0364a {
        AD
    }

    public bd(String str) {
        super(str);
        this.f4142c = C0269a.m425a();
        this.f4143d = C0269a.m425a();
        this.f4144e = C0269a.m425a();
        this.f4145f = C0269a.m425a();
    }

    protected void m4582c() {
        int i = 1;
        this.f4143d.m432a(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, b.f864o);
        this.f4143d.m432a("bundle", b.f854e);
        this.f4143d.m432a("bundle_id", b.f855f);
        if (TextUtils.isEmpty(b.f867r)) {
            b.f867r = XMLConstants.NULL_NS_URI;
        }
        this.f4143d.m432a("custom_id", b.f867r);
        this.f4143d.m432a("session_id", XMLConstants.NULL_NS_URI);
        this.f4143d.m432a("ui", Integer.valueOf(-1));
        this.f4143d.m432a("test_mode", Boolean.valueOf(false));
        this.a.m432a(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, this.f4143d);
        this.f4144e.m432a("carrier", C0271e.m461a(C0271e.m462a("carrier_name", b.f866q.m442e("carrier-name")), C0271e.m462a("mobile_country_code", b.f866q.m442e("mobile-country-code")), C0271e.m462a("mobile_network_code", b.f866q.m442e("mobile-network-code")), C0271e.m462a("iso_country_code", b.f866q.m442e("iso-country-code")), C0271e.m462a("phone_type", Integer.valueOf(b.f866q.m444f("phone-type")))));
        this.f4144e.m432a("model", b.f850a);
        this.f4144e.m432a("device_type", b.f865p);
        this.f4144e.m432a("os", b.f851b);
        this.f4144e.m432a("country", b.f852c);
        this.f4144e.m432a(SchemaSymbols.ATTVAL_LANGUAGE, b.f853d);
        this.f4144e.m432a("timestamp", b.f862m);
        this.f4144e.m432a("reachability", Integer.valueOf(ay.m847a().m851b()));
        this.f4144e.m432a("scale", b.f863n);
        C0269a c0269a = this.f4144e;
        String str = "is_portrait";
        if (!CBUtility.m397c().m469a()) {
            i = 0;
        }
        c0269a.m432a(str, Integer.valueOf(i));
        this.f4144e.m432a("rooted_device", Boolean.valueOf(b.f870u));
        this.f4144e.m432a("timezone", b.f871v);
        this.f4144e.m432a("mobile_network", b.f872w);
        this.f4144e.m432a("dw", b.f859j);
        this.f4144e.m432a("dh", b.f860k);
        this.f4144e.m432a("dpi", b.f861l);
        this.f4144e.m432a("w", b.f857h);
        this.f4144e.m432a("h", b.f858i);
        this.f4144e.m432a("device_family", XMLConstants.NULL_NS_URI);
        this.f4144e.m432a("retina", Boolean.valueOf(false));
        this.f4144e.m432a("identity", C0266c.m413b());
        C0265a c = C0266c.m415c();
        if (c.m409b()) {
            this.f4144e.m432a("tracking", Integer.valueOf(c.m408a()));
        }
        this.a.m432a("device", this.f4144e);
        this.f4142c.m432a("framework", XMLConstants.NULL_NS_URI);
        this.f4142c.m432a("sdk", b.f856g);
        this.f4142c.m432a("framework_version", b.f868s);
        this.f4142c.m432a("wrapper_version", b.f869t);
        this.a.m432a("sdk", this.f4142c);
        this.f4145f.m432a("session", Integer.valueOf(CBUtility.m391a().getInt("cbPrefSessionCount", 0)));
        if (this.f4145f.m431a("cache").m435b()) {
            this.f4145f.m432a("cache", Boolean.valueOf(false));
        }
        if (this.f4145f.m431a(AppLovinEventParameters.REVENUE_AMOUNT).m435b()) {
            this.f4145f.m432a(AppLovinEventParameters.REVENUE_AMOUNT, Integer.valueOf(0));
        }
        if (this.f4145f.m431a("retry_count").m435b()) {
            this.f4145f.m432a("retry_count", Integer.valueOf(0));
        }
        if (this.f4145f.m431a("location").m435b()) {
            this.f4145f.m432a("location", XMLConstants.NULL_NS_URI);
        }
        this.a.m432a("ad", this.f4145f);
    }

    public void m4581a(String str, Object obj, C0364a c0364a) {
        if (this.a == null) {
            this.a = C0269a.m425a();
        }
        switch (C03631.f942a[c0364a.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                this.f4145f.m432a(str, obj);
                this.a.m432a("ad", this.f4145f);
            default:
        }
    }
}
