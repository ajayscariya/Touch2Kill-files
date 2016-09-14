package com.applovin.impl.sdk;

import android.graphics.Point;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mf.org.apache.xerces.impl.Constants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONObject;

class cn extends bw implements dh {
    private final AppLovinAdSize f3932a;
    private final AppLovinAdType f3933b;
    private final AppLovinAdLoadListener f3934c;
    private boolean f3935d;

    cn(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("FetchNextAd", appLovinSdkImpl);
        this.f3935d = false;
        this.f3932a = appLovinAdSize;
        this.f3933b = appLovinAdType;
        this.f3934c = appLovinAdLoadListener;
    }

    private List m4217a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(list.size());
        for (C0244u c0244u : list) {
            arrayList.add(c0244u.f349c);
        }
        return arrayList;
    }

    private void m4218a(cc ccVar) {
        if (System.currentTimeMillis() - ccVar.m218b("ad_session_start") > ((long) ((Integer) this.f.m4161a(bx.f275r)).intValue()) * 60000) {
            ccVar.m220b("ad_session_start", System.currentTimeMillis());
            ccVar.m222c("ad_imp_session");
        }
    }

    private void m4221a(StringBuffer stringBuffer) {
        if (((Boolean) this.f.m4161a(bx.aS)).booleanValue()) {
            try {
                stringBuffer.append("&vx=").append(m4229h());
            } catch (Throwable e) {
                this.g.m308e(this.e, "Unable to populate vx field", e);
            }
        }
    }

    private void m4222b(int i) {
        this.g.m307e(this.e, "Unable to fetch " + this.f3932a + " ad: server returned " + i);
        try {
            m4234a(i);
        } catch (Throwable th) {
            this.g.userError(this.e, "Unable process a failure to recieve an ad", th);
        }
        C0240q.m277b(i, this.f);
    }

    private void m4223b(JSONObject jSONObject) {
        C0240q.m274a(jSONObject, this.f);
        this.f.m4160a().m233a(m4233a(jSONObject), cs.MAIN);
    }

    private void m4224d(Map map) {
        map.put("api_did", this.f.m4161a(bx.f260c));
        map.put("sdk_key", this.f.getSdkKey());
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("app_version", this.f.getDataCollector().m281b().f348b);
        if (!AppLovinSdk.CIS_BUILD_TAG.equals(AppLovinSdk.CIS_BUILD_TAG)) {
            map.put("build_tag", AppLovinSdk.CIS_BUILD_TAG);
        }
        String str = (String) this.f.m4161a(bx.f283z);
        if (str != null && str.length() > 0) {
            map.put("plugin_version", str);
        }
        map.put("accept", m4227g());
        map.put("v1", Boolean.toString(C0237n.m250a("android.permission.WRITE_EXTERNAL_STORAGE", this.h)));
        map.put("v2", Boolean.toString(C0237n.m249a(AppLovinInterstitialActivity.class, this.h)));
        map.put("preloading", String.valueOf(this.f3935d));
        map.put("size", this.f3932a.getLabel());
        map.put("format", "json");
        map.put("ia", Long.toString(this.f.getDataCollector().m281b().f350d));
    }

    private void m4225e(Map map) {
        if (((Boolean) this.f.m4161a(bx.f237F)).booleanValue()) {
            cc b = this.f.m4163b();
            map.put("li", String.valueOf(b.m218b("ad_imp")));
            map.put("si", String.valueOf(b.m218b("ad_imp_session")));
        }
    }

    private void m4226f(Map map) {
        if (((Boolean) this.f.m4161a(bx.f237F)).booleanValue()) {
            Map a = ((C1179m) this.f.getTargetingData()).m4305a();
            if (a != null && !a.isEmpty()) {
                map.putAll(a);
            }
        }
    }

    private String m4227g() {
        String str = "custom_size,launch_app";
        return (C0237n.m251b() && C0237n.m249a(AppLovinInterstitialActivity.class, this.h)) ? str + ",video" : str;
    }

    private void m4228g(Map map) {
        Map a = C0230a.m52a(this.f);
        if (a.isEmpty()) {
            try {
                m4230h(a);
                C0230a.m54a(a, this.f);
            } catch (Throwable e) {
                this.g.m308e(this.e, "Unable to populate device information", e);
            }
        }
        map.putAll(a);
        map.put("network", C0240q.m268a(this.f));
        m4232j(map);
        map.put("vz", di.m4283a(this.f.getApplicationContext().getPackageName(), this.f));
    }

    private String m4229h() {
        return di.m4286a(m4217a(this.f.getDataCollector().m283d()), ",", ((Integer) this.f.m4161a(bx.aR)).intValue());
    }

    private void m4230h(Map map) {
        C0245v a = this.f.getDataCollector().m279a();
        map.put("brand", di.m4293c(a.f353c));
        map.put("carrier", di.m4293c(a.f357g));
        map.put(Constants.LOCALE_PROPERTY, a.f358h.toString());
        map.put("model", di.m4293c(a.f351a));
        map.put("os", di.m4293c(a.f352b));
        map.put("platform", "android");
        map.put("revision", di.m4293c(a.f354d));
        map.put("wvvc", String.valueOf(a.f359i));
        m4231i(map);
    }

    private void m4231i(Map map) {
        Point a = C0237n.m247a(this.f.getApplicationContext());
        map.put("dx", Integer.toString(a.x));
        map.put("dy", Integer.toString(a.y));
    }

    private void m4232j(Map map) {
        C0243t c = this.f.getDataCollector().m282c();
        String str = c.f346b;
        boolean z = c.f345a;
        if ((!z || ((Boolean) this.f.getSettingsManager().m169a(bx.aT)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(z));
    }

    protected bw m4233a(JSONObject jSONObject) {
        return new cw(jSONObject, this.f3934c, this.f);
    }

    protected void m4234a(int i) {
        if (this.f3934c == null) {
            return;
        }
        if (this.f3934c instanceof C1181x) {
            ((C1181x) this.f3934c).m4307a(new C0231c(this.f3932a, this.f3933b), i);
        } else {
            this.f3934c.failedToReceiveAd(i);
        }
    }

    protected void m4235a(Map map) {
        m4226f(map);
        m4228g(map);
        m4225e(map);
        m4224d(map);
        m4238b(map);
        m4240c(map);
    }

    public void m4236a(boolean z) {
        this.f3935d = z;
    }

    void m4237b() {
        super.m155b();
        m4222b(-410);
    }

    protected void m4238b(Map map) {
        if (this.f3933b != null) {
            map.put("require", this.f3933b.getLabel());
        }
    }

    String m4239c() {
        Map hashMap = new HashMap();
        m4235a(hashMap);
        String d = m4241d();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d);
        stringBuffer.append("?");
        stringBuffer.append(di.m4287a(hashMap));
        m4221a(stringBuffer);
        return stringBuffer.toString();
    }

    protected void m4240c(Map map) {
        de a = dc.m236a().m237a("tFNA");
        if (a != null) {
            map.put("etf", Long.toString(a.m240b()));
            map.put("ntf", a.m239a());
        }
        a = dc.m236a().m237a("tRA");
        if (a != null) {
            map.put("etr", Long.toString(a.m240b()));
            map.put("ntr", a.m239a());
            map.put("fvr", a.m241c() ? SchemaSymbols.ATTVAL_TRUE_1 : SchemaSymbols.ATTVAL_FALSE_0);
        }
    }

    protected String m4241d() {
        return C0240q.m276b("2.0/ad", this.f);
    }

    public String m4242e() {
        return "tFNA";
    }

    public boolean m4243f() {
        return false;
    }

    public void run() {
        if (this.f3935d) {
            this.g.m306d(this.e, "Preloading next ad...");
        } else {
            this.g.m306d(this.e, "Fetching next ad...");
        }
        cc b = this.f.m4163b();
        b.m216a("ad_req");
        m4218a(b);
        try {
            cy coVar = new co(this, "RepeatFetchNextAd", bx.f265h, this.f);
            coVar.m4269a(bx.f268k);
            coVar.run();
        } catch (Throwable th) {
            this.g.m308e(this.e, "Unable to fetch " + this.f3932a + " ad", th);
            m4222b(0);
        }
    }
}
