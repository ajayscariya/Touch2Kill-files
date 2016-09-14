package com.inmobi.ads;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.inmobi.ads.AdStore.AdStore;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent.ConfigComponent;
import com.inmobi.commons.core.configs.PkConfig;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.inmobi.commons.core.utilities.uid.UidHelper;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderView.C0659b;
import com.inmobi.rendering.RenderingProperties;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.inmobi.signals.SignalsComponent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

abstract class AdUnit implements AdStore, ConfigComponent, C0659b {
    private static final String f4355a;
    private AdState f4356b;
    private Context f4357c;
    private long f4358d;
    private String f4359e;
    private Map<String, String> f4360f;
    private AdConfig f4361g;
    private String f4362h;
    private String f4363i;
    private C0629a f4364j;
    private RenderView f4365k;
    private RenderTimeoutHandler f4366l;
    private long f4367m;
    private long f4368n;

    public enum AdState {
        STATE_CREATED,
        STATE_LOADING,
        STATE_AVAILABLE,
        STATE_FAILED,
        STATE_LOADED,
        STATE_READY,
        STATE_ATTACHED,
        STATE_RENDERED,
        STATE_ACTIVE
    }

    /* renamed from: com.inmobi.ads.AdUnit.a */
    interface C0629a {
        void m1424a();

        void m1425a(InMobiAdRequestStatus inMobiAdRequestStatus);

        void m1426a(Map<Object, Object> map);

        void m1427b();

        void m1428b(Map<Object, Object> map);

        void m1429c();

        void m1430d();
    }

    protected abstract String m4956a();

    protected abstract String m4972c();

    protected abstract PlacementType m4975d();

    static {
        f4355a = AdUnit.class.getSimpleName();
    }

    public void m4962a(Config config) {
        this.f4361g = (AdConfig) config;
        TelemetryComponent.m5070a().m5093a(this.f4361g.m5025a(), this.f4361g.m5038m());
    }

    public AdUnit(Context context, long j, C0629a c0629a) {
        this.f4368n = 0;
        this.f4357c = context;
        this.f4358d = j;
        this.f4364j = c0629a;
        m4953v();
        m4957a(AdState.STATE_CREATED);
    }

    protected String m4967b() {
        return "json";
    }

    protected Map<String, String> m4978e() {
        return null;
    }

    protected Context m4980f() {
        return this.f4357c;
    }

    public AdState m4982g() {
        return this.f4356b;
    }

    protected String m4984h() {
        return this.f4362h;
    }

    protected String m4985i() {
        return this.f4363i;
    }

    protected void m4986j() {
        this.f4362h = null;
    }

    protected void m4957a(AdState adState) {
        this.f4356b = adState;
    }

    protected final AdConfig m4987k() {
        return this.f4361g;
    }

    protected final C0629a m4988l() {
        return this.f4364j;
    }

    protected final RenderView m4989m() {
        return this.f4365k;
    }

    public boolean m4971b(Ad ad) {
        String str = "pubContent";
        try {
            JSONObject jSONObject = new JSONObject(ad.m1434b());
            this.f4363i = ad.m1435c();
            this.f4362h = new String(Base64.decode(jSONObject.getString("pubContent"), 0)).trim();
            if (this.f4362h == null || this.f4362h.trim().length() == 0) {
                return false;
            }
            this.f4362h = this.f4362h.replace("@__imm_aft@", String.valueOf(System.currentTimeMillis() - this.f4367m));
            return true;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4355a, "Exception while parsing received ad.", e);
            return false;
        } catch (Throwable e2) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4355a, "Invalid Base64 encoding in received ad.", e2);
            return false;
        }
    }

    public void m4960a(Ad ad) {
        if (m4982g() != AdState.STATE_LOADING) {
            return;
        }
        if (m4971b(ad)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad fetch successful");
            m4957a(AdState.STATE_AVAILABLE);
            return;
        }
        m4974c("ParsingFailed");
        m4959a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
    }

    public void m4958a(InMobiAdRequestStatus inMobiAdRequestStatus) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad fetch failed. Status:" + inMobiAdRequestStatus.getStatusCode());
        m4959a(inMobiAdRequestStatus, true);
        if (inMobiAdRequestStatus.getStatusCode() == StatusCode.INTERNAL_ERROR) {
            m4974c("InternalError");
        }
    }

    protected void m4959a(InMobiAdRequestStatus inMobiAdRequestStatus, boolean z) {
        if (m4982g() == AdState.STATE_LOADING && z) {
            m4957a(AdState.STATE_FAILED);
        }
        m4988l().m1425a(inMobiAdRequestStatus);
        if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NO_FILL) {
            m4974c("NoFill");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.SERVER_ERROR) {
            m4974c("ServerError");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NETWORK_UNREACHABLE) {
            m4974c("NetworkUnreachable");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.AD_ACTIVE) {
            m4974c("AdActive");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_PENDING) {
            m4974c("RequestPending");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_INVALID) {
            m4974c("RequestInvalid");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.REQUEST_TIMED_OUT) {
            m4974c("RequestTimedOut");
        } else if (inMobiAdRequestStatus.getStatusCode() == StatusCode.EARLY_REFRESH_REQUEST) {
            m4974c("EarlyRefreshRequest");
        }
    }

    public void m4965a(String str) {
        this.f4359e = str;
    }

    public void m4966a(Map<String, String> map) {
        this.f4360f = map;
    }

    public void m4990n() {
        Map hashMap = new HashMap();
        hashMap.put("type", m4956a());
        TelemetryComponent.m5070a().m5092a("ads", "AdLoadRequested", hashMap);
        if (!NetworkUtils.m1783a()) {
            m4959a(new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE), true);
        } else if (this.f4356b == AdState.STATE_LOADING || this.f4356b == AdState.STATE_AVAILABLE) {
            m4959a(new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING), false);
            Logger.m1744a(InternalLogLevel.ERROR, f4355a, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
        } else if (m4982g() == AdState.STATE_ACTIVE) {
            m4959a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
            Logger.m1744a(InternalLogLevel.ERROR, f4355a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad");
        } else {
            m4994r();
            this.f4356b = AdState.STATE_LOADING;
            SignalsComponent.m5202a().m5211i();
            m4991o();
            m4993q();
            m4961a(m4954w());
        }
    }

    protected void m4991o() {
        this.f4365k = new RenderView(m4980f(), new RenderingProperties(m4975d()));
        this.f4365k.m1943a((C0659b) this, m4987k().m5035j(), m4987k().m5036k());
    }

    protected void m4970b(String str) {
        this.f4368n = SystemClock.elapsedRealtime();
        m4989m().m1944a(str);
        m4955x();
    }

    protected void m4992p() {
        this.f4365k.m1953b("inmobi.recordEvent(120,null);");
    }

    private void m4953v() {
        this.f4361g = new AdConfig();
        com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(new PkConfig(), null);
        com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(this.f4361g, (ConfigComponent) this);
        this.f4366l = new RenderTimeoutHandler(this);
        TelemetryComponent.m5070a().m5093a(this.f4361g.m5025a(), this.f4361g.m5038m());
    }

    void m4993q() {
        UidHelper.m1854a().m1867e();
    }

    private AdStoreRequest m4954w() {
        AdStoreRequest adStoreRequest = new AdStoreRequest();
        adStoreRequest.m1517b(this.f4359e);
        adStoreRequest.m1515a(this.f4360f);
        adStoreRequest.m1511a(this.f4358d);
        adStoreRequest.m1520c(m4956a());
        adStoreRequest.m1512a(m4987k().m5024a(m4956a()));
        adStoreRequest.m1518b(m4978e());
        adStoreRequest.m1522d(m4967b());
        adStoreRequest.m1514a(this.f4361g.m5030e());
        adStoreRequest.m1510a(this.f4361g.m5033h());
        adStoreRequest.m1524e(m4972c());
        adStoreRequest.m1513a(new UidMap(this.f4361g.m1654n().m1648a()));
        return adStoreRequest;
    }

    void m4961a(AdStoreRequest adStoreRequest) {
        this.f4367m = System.currentTimeMillis();
        new AdStore(adStoreRequest, this).m5057a();
    }

    protected void m4994r() {
        this.f4363i = null;
        View m = m4989m();
        if (m != null) {
            ViewParent parent = m.getParent();
            m.removeAllViews();
            if (parent != null) {
                ((ViewGroup) parent).removeView(m);
            }
            m.destroy();
        }
    }

    public void m4963a(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Render view signaled ad ready");
    }

    public void m4968b(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Render view signaled ad failed");
        m4974c("RenderFailed");
    }

    public void m4973c(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "RenderView completed loading ad content");
    }

    public void m4976d(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Renderview visible");
    }

    public void m4979e(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad displayed");
    }

    public void m4981f(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad dismissed");
    }

    public void m4964a(RenderView renderView, HashMap<Object, Object> hashMap) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad reward action completed. Params:" + (hashMap == null ? null : hashMap.toString()));
        m4988l().m1428b(hashMap);
    }

    public void m4969b(RenderView renderView, HashMap<Object, Object> hashMap) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Ad interaction. Params:" + (hashMap == null ? null : hashMap.toString()));
        m4988l().m1426a((Map) hashMap);
    }

    public void m4983g(RenderView renderView) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "User left application");
        m4988l().m1430d();
    }

    private void m4955x() {
        m4995s();
        this.f4366l.sendEmptyMessageDelayed(0, (long) (m4987k().m5035j().m1486i() * 1000));
    }

    protected void m4995s() {
        this.f4366l.removeMessages(0);
    }

    protected void m4996t() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4355a, "Renderview timed out.");
        m4974c("RenderTimeOut");
        if (m4982g() == AdState.STATE_AVAILABLE) {
            m4957a(AdState.STATE_FAILED);
            m4988l().m1425a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    protected void m4997u() {
        Map hashMap = new HashMap();
        hashMap.put("type", m4956a());
        hashMap.put("renderLatency", Long.valueOf(SystemClock.elapsedRealtime() - this.f4368n));
        TelemetryComponent.m5070a().m5092a("ads", "AdLoadSuccessful", hashMap);
    }

    protected void m4974c(String str) {
        Map hashMap = new HashMap();
        hashMap.put("impId", m4985i());
        hashMap.put("errorCode", str);
        hashMap.put("type", m4956a());
        if (str != null && (str.trim().equalsIgnoreCase("RenderFailed") || str.trim().equalsIgnoreCase("RenderTimeOut"))) {
            hashMap.put("renderLatency", Long.valueOf(SystemClock.elapsedRealtime() - this.f4368n));
        }
        TelemetryComponent.m5070a().m5092a("ads", "AdLoadFailed", hashMap);
    }

    protected void m4977d(String str) {
        Map hashMap = new HashMap();
        hashMap.put("impId", m4985i());
        hashMap.put("errorCode", str);
        hashMap.put("type", m4956a());
        TelemetryComponent.m5070a().m5092a("ads", "AdShowFailed", hashMap);
    }
}
