package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.media.TransportMediator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventParameters;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0263b;
import com.chartboost.sdk.Libraries.C0266c;
import com.chartboost.sdk.Libraries.C0266c.C0265a;
import com.chartboost.sdk.Libraries.C0271e;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0276g.C0274a;
import com.chartboost.sdk.Libraries.C0276g.C0275k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.google.android.gcm.GCMConstants;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mf.javax.xml.XMLConstants;
import mf.javax.xml.transform.OutputKeys;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.apache.xerces.xinclude.XIncludeHandler;

public class az {
    protected static C0348e f874b;
    private static C0269a f875h;
    protected C0269a f876a;
    private String f877c;
    private String f878d;
    private Map<String, Object> f879e;
    private Map<String, Object> f880f;
    private String f881g;
    private C0347c f882i;
    private boolean f883j;
    private boolean f884k;
    private C0274a f885l;
    private ba f886m;
    private int f887n;
    private boolean f888o;
    private boolean f889p;
    private C0414a f890q;

    /* renamed from: com.chartboost.sdk.impl.az.c */
    public interface C0347c {
        void m856a(C0269a c0269a, az azVar);

        void m857a(C0269a c0269a, az azVar, CBError cBError);
    }

    /* renamed from: com.chartboost.sdk.impl.az.e */
    class C0348e {
        public String f850a;
        public String f851b;
        public String f852c;
        public String f853d;
        public String f854e;
        public String f855f;
        public String f856g;
        public String f857h;
        public String f858i;
        public String f859j;
        public String f860k;
        public String f861l;
        public String f862m;
        public String f863n;
        public String f864o;
        public String f865p;
        public C0269a f866q;
        public String f867r;
        public String f868s;
        public String f869t;
        public boolean f870u;
        public String f871v;
        public Integer f872w;
        final /* synthetic */ az f873x;

        public C0348e(az azVar) {
            int width;
            int height;
            Throwable th;
            DisplayMetrics displayMetrics;
            int i;
            Object obj = null;
            int i2 = 0;
            this.f873x = azVar;
            this.f867r = XMLConstants.NULL_NS_URI;
            this.f868s = XMLConstants.NULL_NS_URI;
            this.f869t = XMLConstants.NULL_NS_URI;
            Context y = C0299c.m682y();
            this.f864o = C0299c.m659e();
            if ("sdk".equals(Build.PRODUCT)) {
                this.f850a = "Android Simulator";
            } else {
                this.f850a = Build.MODEL;
            }
            this.f865p = Build.MANUFACTURER + " " + Build.MODEL;
            this.f851b = "Android " + VERSION.RELEASE;
            this.f852c = Locale.getDefault().getCountry();
            this.f853d = Locale.getDefault().getLanguage();
            this.f856g = "6.0.2";
            this.f862m = String.valueOf(Long.valueOf(new Date().getTime() / 1000).intValue());
            this.f863n = XMLConstants.NULL_NS_URI + y.getResources().getDisplayMetrics().density;
            try {
                String packageName = y.getPackageName();
                this.f854e = y.getPackageManager().getPackageInfo(packageName, TransportMediator.FLAG_KEY_MEDIA_NEXT).versionName;
                this.f855f = packageName;
            } catch (Throwable e) {
                CBLogging.m382b("CBRequest", "Exception raised getting package mager object", e);
            }
            if (az.f875h == null) {
                TelephonyManager telephonyManager = (TelephonyManager) y.getSystemService("phone");
                if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                    az.f875h = C0269a.m425a();
                } else {
                    Object obj2;
                    String simOperator = telephonyManager.getSimOperator();
                    if (TextUtils.isEmpty(simOperator)) {
                        obj2 = null;
                    } else {
                        obj2 = simOperator.substring(0, 3);
                        obj = simOperator.substring(3);
                    }
                    az.f875h = C0271e.m461a(C0271e.m462a("carrier-name", telephonyManager.getNetworkOperatorName()), C0271e.m462a("mobile-country-code", obj2), C0271e.m462a("mobile-network-code", obj), C0271e.m462a("iso-country-code", telephonyManager.getNetworkCountryIso()), C0271e.m462a("phone-type", Integer.valueOf(telephonyManager.getPhoneType())));
                }
            }
            this.f866q = az.f875h;
            this.f867r = C0299c.m672o();
            if (C0299c.m647b() != null) {
                Object d = C0299c.m655d();
                if (!TextUtils.isEmpty(d)) {
                    this.f868s = d;
                }
                d = C0299c.m652c();
                if (!TextUtils.isEmpty(d)) {
                    this.f869t = d;
                }
            }
            this.f870u = CBUtility.m401f();
            this.f871v = CBUtility.m402g();
            this.f872w = ay.m848d();
            try {
                if (y instanceof Activity) {
                    Activity activity = (Activity) y;
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    width = rect.width();
                    try {
                        height = rect.height();
                        i2 = width;
                    } catch (Throwable e2) {
                        Throwable th2 = e2;
                        height = width;
                        th = th2;
                        CBLogging.m384c("CBRequest", "Exception getting activity size", th);
                        i2 = height;
                        height = 0;
                        displayMetrics = y.getResources().getDisplayMetrics();
                        width = displayMetrics.widthPixels;
                        i = displayMetrics.heightPixels;
                        this.f859j = XMLConstants.NULL_NS_URI + width;
                        this.f860k = XMLConstants.NULL_NS_URI + i;
                        this.f861l = XMLConstants.NULL_NS_URI + displayMetrics.densityDpi;
                        i2 = width;
                        height = i;
                        this.f857h = XMLConstants.NULL_NS_URI + i2;
                        this.f858i = XMLConstants.NULL_NS_URI + height;
                    }
                }
                height = 0;
            } catch (Throwable e22) {
                th = e22;
                height = 0;
                CBLogging.m384c("CBRequest", "Exception getting activity size", th);
                i2 = height;
                height = 0;
                displayMetrics = y.getResources().getDisplayMetrics();
                width = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
                this.f859j = XMLConstants.NULL_NS_URI + width;
                this.f860k = XMLConstants.NULL_NS_URI + i;
                this.f861l = XMLConstants.NULL_NS_URI + displayMetrics.densityDpi;
                i2 = width;
                height = i;
                this.f857h = XMLConstants.NULL_NS_URI + i2;
                this.f858i = XMLConstants.NULL_NS_URI + height;
            }
            displayMetrics = y.getResources().getDisplayMetrics();
            width = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            this.f859j = XMLConstants.NULL_NS_URI + width;
            this.f860k = XMLConstants.NULL_NS_URI + i;
            this.f861l = XMLConstants.NULL_NS_URI + displayMetrics.densityDpi;
            if (i2 <= 0 || i2 > width) {
                i2 = width;
            }
            if (height <= 0 || height > i) {
                height = i;
            }
            this.f857h = XMLConstants.NULL_NS_URI + i2;
            this.f858i = XMLConstants.NULL_NS_URI + height;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.az.a */
    private static class C1232a implements C0347c {
        private C1234d f4135a;
        private C1233b f4136b;

        public C1232a(C1234d c1234d, C1233b c1233b) {
            this.f4135a = c1234d;
            this.f4136b = c1233b;
        }

        public void m4565a(C0269a c0269a, az azVar) {
            if (this.f4135a != null) {
                this.f4135a.m856a(c0269a, azVar);
            }
        }

        public void m4566a(C0269a c0269a, az azVar, CBError cBError) {
            if (this.f4136b != null) {
                this.f4136b.m857a(c0269a, azVar, cBError);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.az.b */
    public static abstract class C1233b implements C0347c {
    }

    /* renamed from: com.chartboost.sdk.impl.az.d */
    public static abstract class C1234d implements C0347c {
        public void m4567a(C0269a c0269a, az azVar, CBError cBError) {
        }
    }

    static {
        f875h = null;
    }

    public az(String str) {
        this.f882i = null;
        this.f883j = false;
        this.f884k = false;
        this.f885l = null;
        this.f888o = false;
        this.f889p = true;
        this.f890q = C0414a.NORMAL;
        this.f877c = str;
        this.f881g = "POST";
        this.f886m = ba.m914a(C0299c.m682y());
        m862a(0);
        if (f874b == null) {
            f874b = new C0348e(this);
        }
    }

    protected void m861a() {
        if (this.f880f == null) {
            this.f880f = new HashMap();
        }
        this.f880f.put(XIncludeHandler.HTTP_ACCEPT, "application/json");
        this.f880f.put("X-Chartboost-Client", CBUtility.m399d());
        this.f880f.put("X-Chartboost-API", "6.0.2");
        this.f880f.put("X-Chartboost-Client", CBUtility.m399d());
    }

    protected String m873b() {
        return "application/json";
    }

    public void m869a(String str, Object obj) {
        if (this.f876a == null) {
            this.f876a = C0269a.m425a();
        }
        this.f876a.m432a(str, obj);
    }

    public void m870a(String str, String str2) {
        if (this.f880f == null) {
            this.f880f = new HashMap();
        }
        this.f880f.put(str, str2);
    }

    public void m868a(String str, C0269a c0269a) {
        if (c0269a != null && c0269a.m439c(str)) {
            m869a(str, c0269a.m442e(str));
        }
    }

    protected void m876c() {
        int i = 0;
        m869a(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, f874b.f864o);
        m869a("model", f874b.f850a);
        m869a("device_type", f874b.f865p);
        m869a("os", f874b.f851b);
        m869a("country", f874b.f852c);
        m869a(SchemaSymbols.ATTVAL_LANGUAGE, f874b.f853d);
        m869a("sdk", f874b.f856g);
        m869a("timestamp", f874b.f862m);
        m869a("session", Integer.valueOf(CBUtility.m391a().getInt("cbPrefSessionCount", 0)));
        m869a("reachability", Integer.valueOf(ay.m847a().m851b()));
        m869a("scale", f874b.f863n);
        String str = "is_portrait";
        if (CBUtility.m397c().m469a()) {
            i = 1;
        }
        m869a(str, Integer.valueOf(i));
        m869a("bundle", f874b.f854e);
        m869a("bundle_id", f874b.f855f);
        m869a("carrier", f874b.f866q);
        m869a("custom_id", f874b.f867r);
        if (C0299c.m647b() != null) {
            if (!TextUtils.isEmpty(f874b.f864o)) {
                m869a("framework_version", f874b.f868s);
            }
            if (!TextUtils.isEmpty(f874b.f864o)) {
                m869a("wrapper_version", f874b.f869t);
            }
        }
        m869a("rooted_device", Boolean.valueOf(f874b.f870u));
        m869a("timezone", f874b.f871v);
        m869a("mobile_network", f874b.f872w);
        m869a("dw", f874b.f859j);
        m869a("dh", f874b.f860k);
        m869a("dpi", f874b.f861l);
        m869a("w", f874b.f857h);
        m869a("h", f874b.f858i);
        m869a("identity", C0266c.m413b());
        C0265a c = C0266c.m415c();
        if (c.m409b()) {
            m869a("tracking", Integer.valueOf(c.m408a()));
        }
    }

    public void m878d() {
        String e = C0299c.m659e();
        String f = C0299c.m661f();
        f = C0263b.m407b(C0263b.m406a(String.format(Locale.US, "%s %s\n%s\n%s", new Object[]{this.f881g, m880e(), f, m881f()}).getBytes()));
        m870a("X-Chartboost-App", e);
        m870a("X-Chartboost-Signature", f);
    }

    public String m880e() {
        return m882g() + CBUtility.m392a(this.f879e);
    }

    public String m881f() {
        return this.f876a.toString();
    }

    public String m882g() {
        if (this.f877c == null) {
            return "/";
        }
        return (this.f877c.startsWith("/") ? XMLConstants.NULL_NS_URI : "/") + this.f877c;
    }

    public void m867a(String str) {
        this.f877c = str;
    }

    public boolean m883h() {
        return m882g().equals("/api/track");
    }

    public C0269a m884i() {
        return this.f876a;
    }

    public Map<String, Object> m885j() {
        return this.f880f;
    }

    public boolean m886k() {
        return this.f884k;
    }

    public void m871a(boolean z) {
        this.f884k = z;
    }

    public C0274a m887l() {
        return this.f885l;
    }

    public boolean m888m() {
        return this.f888o;
    }

    public void m875b(boolean z) {
        this.f888o = z;
    }

    public void m863a(C0274a c0274a) {
        if (!C0276g.m488c(c0274a)) {
            CBLogging.m381b("CBRequest", "Validation predicate must be a dictionary style -- either VDictionary, VDictionaryExact, VDictionaryWithValues, or just a list of KV pairs.");
        }
        this.f885l = c0274a;
    }

    public void m872a(C0275k... c0275kArr) {
        this.f885l = C0276g.m480a(c0275kArr);
    }

    public void m874b(String str) {
        this.f878d = str;
    }

    public void m866a(C0414a c0414a) {
        this.f890q = c0414a;
    }

    public C0414a m889n() {
        return this.f890q;
    }

    public int m890o() {
        return this.f887n;
    }

    public void m862a(int i) {
        this.f887n = i;
    }

    public boolean m891p() {
        return this.f889p;
    }

    public void m877c(boolean z) {
        this.f889p = z;
    }

    public boolean m892q() {
        return this.f883j;
    }

    public void m879d(boolean z) {
        this.f883j = z;
    }

    public C0347c m893r() {
        return this.f882i;
    }

    public void m894s() {
        m865a(null, null);
    }

    public void m864a(C0347c c0347c) {
        if (!C0299c.m669l()) {
            this.f884k = false;
            this.f888o = false;
        }
        this.f882i = c0347c;
        m879d(true);
        this.f886m.m928a(this, c0347c);
    }

    public void m865a(C1234d c1234d, C1233b c1233b) {
        if (!C0299c.m669l()) {
            this.f884k = false;
            this.f888o = false;
        }
        m879d(true);
        this.f882i = new C1232a(c1234d, c1233b);
        this.f886m.m928a(this, this.f882i);
    }

    public static az m858a(C0269a c0269a) {
        try {
            az azVar = new az(c0269a.m442e("path"));
            azVar.f881g = c0269a.m442e(OutputKeys.METHOD);
            azVar.f879e = c0269a.m431a(AppLovinEventParameters.SEARCH_QUERY).m445f();
            azVar.f876a = c0269a.m431a("body");
            azVar.f880f = c0269a.m431a("headers").m445f();
            azVar.f884k = c0269a.m453j("ensureDelivery");
            azVar.f878d = c0269a.m442e("eventType");
            azVar.f877c = c0269a.m442e("path");
            azVar.f887n = c0269a.m444f("retryCount");
            if (c0269a.m431a("callback") instanceof C0347c) {
                azVar.f882i = (C0347c) c0269a.m431a("callback");
            }
            return azVar;
        } catch (Throwable e) {
            CBLogging.m386d("CBRequest", "Unable to deserialize failed request", e);
            return null;
        }
    }

    public C0269a m895t() {
        return C0271e.m461a(C0271e.m462a("path", this.f877c), C0271e.m462a(OutputKeys.METHOD, this.f881g), C0271e.m462a(AppLovinEventParameters.SEARCH_QUERY, C0271e.m467a(this.f879e)), C0271e.m462a("body", this.f876a), C0271e.m462a("eventType", this.f878d), C0271e.m462a("headers", C0271e.m467a(this.f880f)), C0271e.m462a("ensureDelivery", Boolean.valueOf(this.f884k)), C0271e.m462a("retryCount", Integer.valueOf(this.f887n)), C0271e.m462a("callback", this.f882i));
    }
}
