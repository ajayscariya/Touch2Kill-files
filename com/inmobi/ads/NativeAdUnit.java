package com.inmobi.ads;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.AdUnit.AdState;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.inmobi.rendering.p005a.ClickManager;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.n */
class NativeAdUnit extends AdUnit {
    private static final String f4907a;
    private Map<NativeAdUnit, WeakReference<View>> f4908b;
    private WeakHashMap<View, NativeAdUnit> f4909c;
    private String f4910d;
    private String f4911e;
    private ImpressionTracker f4912f;
    private URL f4913g;
    private String f4914h;
    private int f4915i;
    private long f4916j;

    static {
        f4907a = NativeAdUnit.class.getSimpleName();
    }

    public NativeAdUnit(long j, C0629a c0629a) {
        super(SdkContext.m1562b(), j, c0629a);
        this.f4908b = new HashMap();
        this.f4909c = new WeakHashMap();
        this.f4915i = 0;
        this.f4916j = 0;
    }

    public void m5861n() {
        if (this.f4916j != 0) {
            int f = m4987k().m5031f();
            if (SystemClock.elapsedRealtime() - this.f4916j < ((long) (f * 1000))) {
                m4959a(new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + f + " seconds"), false);
                Logger.m1744a(InternalLogLevel.ERROR, f4907a, "Ad cannot be refreshed before " + f + " seconds");
                return;
            }
        }
        this.f4916j = SystemClock.elapsedRealtime();
        super.m4990n();
        this.f4912f = new ImpressionTracker(m4987k().m5037l());
    }

    public void m5863v() {
        if (AdState.STATE_ATTACHED == m4982g()) {
            WeakReference weakReference = (WeakReference) this.f4908b.get(this);
            if (weakReference != null) {
                View view = (View) weakReference.get();
                if (this.f4912f != null && view != null) {
                    this.f4912f.m1539a(view, this);
                }
            }
        }
    }

    public void m5864w() {
        if (AdState.STATE_ATTACHED == m4982g()) {
            WeakReference weakReference = (WeakReference) this.f4908b.get(this);
            if (weakReference != null) {
                View view = (View) weakReference.get();
                if (this.f4912f != null && view != null) {
                    this.f4912f.m1538a(view);
                }
            }
        }
    }

    public boolean m5855b(Ad ad) {
        if (!super.m4971b(ad)) {
            return false;
        }
        String str = "contextCode";
        str = "namespace";
        try {
            JSONObject jSONObject = new JSONObject(ad.m1434b());
            this.f4910d = jSONObject.getString("contextCode");
            this.f4911e = jSONObject.getString("namespace");
            if (this.f4910d == null || this.f4910d.trim().length() == 0 || this.f4911e == null || this.f4911e.trim().length() == 0) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4907a, "Exception while parsing ad.", e);
            return false;
        }
    }

    public void m5853a(Ad ad) {
        super.m4960a(ad);
        if (AdState.STATE_AVAILABLE == m4982g()) {
            m4970b(this.f4910d);
        }
    }

    public Object m5865x() {
        return m4984h();
    }

    public void m5852a(View view, URL url, String str) {
        View view2;
        boolean z = true;
        Map hashMap = new HashMap();
        hashMap.put("customScript", Boolean.valueOf(str != null));
        String str2 = "customUrl";
        if (url == null) {
            z = false;
        }
        hashMap.put(str2, Boolean.valueOf(z));
        TelemetryComponent.m5070a().m5092a("ads", "TrackImpression", hashMap);
        WeakReference weakReference = (WeakReference) this.f4908b.get(this);
        if (weakReference != null) {
            view2 = (View) weakReference.get();
        } else {
            view2 = null;
        }
        if (!view.equals(view2)) {
            if (AdState.STATE_LOADED == m4982g() || AdState.STATE_ATTACHED == m4982g()) {
                m5851a(view2);
                m5851a(view);
                this.f4908b.put(this, new WeakReference(view));
                this.f4909c.put(view, this);
                this.f4913g = url;
                this.f4914h = str;
                this.f4912f.m1539a(view, this);
                m4957a(AdState.STATE_ATTACHED);
            } else if (m4982g() != AdState.STATE_RENDERED && m4982g() != AdState.STATE_ACTIVE) {
                Logger.m1744a(InternalLogLevel.ERROR, f4907a, "Please wait for the ad to finish loading before making a call to bind.");
            }
        }
    }

    public void m5851a(View view) {
        if (view != null && AdState.STATE_ATTACHED == m4982g()) {
            m4957a(AdState.STATE_LOADED);
            InMobiNative.sMappedAdUnits.remove(view);
            this.f4912f.m1538a(view);
            this.f4908b.remove(this);
            NativeAdUnit nativeAdUnit = (NativeAdUnit) this.f4909c.remove(view);
            if (nativeAdUnit != null) {
                nativeAdUnit.m4957a(AdState.STATE_LOADED);
                this.f4908b.remove(nativeAdUnit);
            }
        }
    }

    void m5866y() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4907a, "Impression record requested for Ad unit (" + hashCode() + ")");
        if (AdState.STATE_ATTACHED == m4982g()) {
            m4957a(AdState.STATE_RENDERED);
            m4989m().m1953b(this.f4911e + "recordEvent(18)");
            if (this.f4914h != null) {
                m4989m().m1953b(this.f4914h);
            }
            if (this.f4913g != null) {
                ClickManager.m5176a().m5187a(this.f4913g.toExternalForm(), true);
            }
        }
    }

    void m5854a(Map<String, String> map, URL url, String str) {
        boolean z = false;
        Logger.m1744a(InternalLogLevel.INTERNAL, f4907a, "Click record requested");
        Map hashMap = new HashMap();
        hashMap.put("customScript", Boolean.valueOf(str != null));
        String str2 = "customUrl";
        if (url != null) {
            z = true;
        }
        hashMap.put(str2, Boolean.valueOf(z));
        TelemetryComponent.m5070a().m5092a("ads", "ReportClick", hashMap);
        if (AdState.STATE_ATTACHED == m4982g() || AdState.STATE_RENDERED == m4982g()) {
            m4989m().m1953b(m5849b((Map) map));
            if (str != null) {
                m4989m().m1953b(str);
            }
            if (url != null) {
                ClickManager.m5176a().m5187a(url.toExternalForm(), true);
                return;
            }
            return;
        }
        TelemetryComponent.m5070a().m5090a(new TelemetryEvent("ads", "InvalidClickReport"));
        Logger.m1744a(InternalLogLevel.ERROR, f4907a, "reportAdClick call made in wrong state");
    }

    private String m5849b(Map<String, String> map) {
        NetworkUtils.m1782a((Map) map);
        if (map == null || map.isEmpty()) {
            return this.f4911e + "recordEvent(8)";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f4911e + "recordEvent(8, ");
        stringBuilder.append(new JSONObject(map).toString());
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    void m5867z() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4907a, "Open landing page requested");
        TelemetryComponent.m5070a().m5090a(new TelemetryEvent("ads", "OpenLandingPage"));
        if (AdState.STATE_RENDERED == m4982g() || AdState.STATE_ATTACHED == m4982g()) {
            m4989m().m1953b(this.f4911e + "openLandingPage()");
        }
    }

    protected void m5862r() {
        m4986j();
        this.f4908b.clear();
        this.f4909c.clear();
        if (this.f4912f != null) {
            this.f4912f.m1540b();
        }
        this.f4914h = null;
        this.f4913g = null;
        if (!(m4989m() == null || m4989m().getParent() == null)) {
            ((ViewGroup) m4989m().getParent()).removeView(m4989m());
        }
        super.m4994r();
    }

    protected String m5850a() {
        return "native";
    }

    protected String m5856c() {
        return null;
    }

    protected PlacementType m5858d() {
        return PlacementType.INLINE;
    }

    public void m5857c(RenderView renderView) {
        super.m4973c(renderView);
        if (AdState.STATE_AVAILABLE == m4982g()) {
            m4995s();
            m4957a(AdState.STATE_LOADED);
            m4997u();
            m4988l().m1424a();
            m4992p();
        }
    }

    public void m5859e(RenderView renderView) {
        super.m4979e(renderView);
        if (AdState.STATE_RENDERED == m4982g() || AdState.STATE_ATTACHED == m4982g()) {
            this.f4915i++;
            m4957a(AdState.STATE_ACTIVE);
            m4988l().m1427b();
        } else if (m4982g() == AdState.STATE_ACTIVE) {
            this.f4915i++;
        }
    }

    public void m5860f(RenderView renderView) {
        super.m4981f(renderView);
        if (AdState.STATE_ACTIVE == m4982g()) {
            this.f4915i--;
            if (this.f4915i == 0) {
                m4957a(AdState.STATE_RENDERED);
                Map hashMap = new HashMap();
                hashMap.put("type", m5850a());
                hashMap.put("impId", m4985i());
                TelemetryComponent.m5070a().m5092a("ads", "AdRendered", hashMap);
                m4988l().m1429c();
            }
        }
    }
}
