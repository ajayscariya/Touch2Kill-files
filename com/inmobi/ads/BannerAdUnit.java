package com.inmobi.ads;

import android.content.Context;
import com.inmobi.ads.AdUnit.AdState;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.ads.j */
class BannerAdUnit extends AdUnit {
    private static final String f4897a;
    private InMobiBanner f4898b;
    private boolean f4899c;
    private boolean f4900d;
    private int f4901e;

    static {
        f4897a = BannerAdUnit.class.getSimpleName();
    }

    public BannerAdUnit(InMobiBanner inMobiBanner, Context context, long j, C0629a c0629a) {
        super(context, j, c0629a);
        this.f4899c = true;
        this.f4900d = false;
        this.f4901e = 0;
        this.f4898b = inMobiBanner;
    }

    void m5828v() {
        this.f4900d = true;
        if (m4989m() != null) {
            m4989m().m1987o();
        }
    }

    public void m5819a(boolean z) {
        this.f4899c = z;
        super.m4990n();
    }

    boolean m5829w() {
        return this.f4900d;
    }

    boolean m5830x() {
        return m4982g() == AdState.STATE_ACTIVE;
    }

    protected void m5827o() {
        super.m4991o();
        if (this.f4900d) {
            m4989m().m1987o();
        }
    }

    protected String m5817a() {
        return "banner";
    }

    protected String m5820c() {
        return this.f4898b.getFrameSizeString();
    }

    protected PlacementType m5822d() {
        return PlacementType.INLINE;
    }

    protected Map<String, String> m5824e() {
        Map hashMap = new HashMap();
        hashMap.put("u-rt", this.f4899c ? String.valueOf(1) : String.valueOf(0));
        hashMap.put("mk-ad-slot", this.f4898b.getFrameSizeString());
        return hashMap;
    }

    public void m5818a(Ad ad) {
        super.m4960a(ad);
        if (m4982g() == AdState.STATE_AVAILABLE) {
            m4970b(m4984h());
        }
    }

    public void m5821c(RenderView renderView) {
        super.m4973c(renderView);
        if (m4982g() == AdState.STATE_AVAILABLE) {
            m4995s();
            m4957a(AdState.STATE_LOADED);
            m4997u();
            m4988l().m1424a();
            m4992p();
        }
    }

    public void m5823d(RenderView renderView) {
        super.m4976d(renderView);
        if (m4982g() == AdState.STATE_LOADED) {
            m4957a(AdState.STATE_RENDERED);
            Map hashMap = new HashMap();
            hashMap.put("type", m5817a());
            hashMap.put("impId", m4985i());
            TelemetryComponent.m5070a().m5092a("ads", "AdRendered", hashMap);
        }
    }

    public synchronized void m5825e(RenderView renderView) {
        super.m4979e(renderView);
        if (m4982g() == AdState.STATE_RENDERED) {
            this.f4901e++;
            m4957a(AdState.STATE_ACTIVE);
            m4988l().m1427b();
        } else if (m4982g() == AdState.STATE_ACTIVE) {
            this.f4901e++;
        }
    }

    public synchronized void m5826f(RenderView renderView) {
        super.m4981f(renderView);
        if (m4982g() == AdState.STATE_ACTIVE) {
            this.f4901e--;
            if (this.f4901e == 0) {
                m4957a(AdState.STATE_RENDERED);
                m4988l().m1429c();
            }
        }
    }
}
