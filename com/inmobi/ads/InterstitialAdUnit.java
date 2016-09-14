package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.inmobi.ads.AdUnit.AdState;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.wTouch2KiLL.C0866R;
import java.util.HashMap;
import java.util.Map;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

/* renamed from: com.inmobi.ads.m */
class InterstitialAdUnit extends AdUnit {
    private static final String f4902a;
    private int f4903b;
    private boolean f4904c;
    private int f4905d;
    private long f4906e;

    static {
        f4902a = InterstitialAdUnit.class.getSimpleName();
    }

    public InterstitialAdUnit(Context context, long j, C0629a c0629a) {
        super(context, j, c0629a);
        this.f4903b = 0;
        this.f4904c = false;
        this.f4905d = -1;
        this.f4906e = 0;
    }

    protected void m5842o() {
        super.m4991o();
        if (this.f4904c) {
            m4989m().m1987o();
        }
    }

    public void m5841n() {
        if (this.f4906e != 0) {
            int f = m4987k().m5031f();
            if (SystemClock.elapsedRealtime() - this.f4906e < ((long) (f * 1000))) {
                m4959a(new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + f + " seconds"), false);
                Logger.m1744a(InternalLogLevel.ERROR, f4902a, "Ad cannot be refreshed before " + f + " seconds");
                return;
            }
        }
        if (m4982g() == AdState.STATE_RENDERED) {
            m4959a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
            Logger.m1744a(InternalLogLevel.ERROR, f4902a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
            return;
        }
        this.f4906e = SystemClock.elapsedRealtime();
        super.m4990n();
    }

    protected void m5843r() {
        super.m4994r();
        this.f4905d = -1;
    }

    public void m5845v() {
        Map hashMap = new HashMap();
        String i = m4985i();
        if (i != null) {
            hashMap.put("impId", i);
        }
        TelemetryComponent.m5070a().m5092a("ads", "ShowInt", hashMap);
        if (m5847x()) {
            hashMap.put("type", m5831a());
            TelemetryComponent.m5070a().m5092a("ads", "AdRendered", hashMap);
            m4957a(AdState.STATE_RENDERED);
            m5846w();
            return;
        }
        Logger.m1744a(InternalLogLevel.ERROR, f4902a, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
        m4977d("ShowIntBeforeReady");
    }

    public void m5832a(int i, int i2) {
        try {
            m4980f().getResources().getAnimation(i);
            m4980f().getResources().getAnimation(i2);
            this.f4905d = i;
            m4989m().setFullScreenExitAnimation(i2);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.ERROR, f4902a, "The supplied resource id with show for animations is invalid", e);
        }
        m5845v();
    }

    void m5846w() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4902a, ">>> Starting " + InMobiAdActivity.class.getSimpleName() + " to display interstitial ad ...");
        int a = InMobiAdActivity.m1886a(m4989m());
        Intent intent = new Intent(m4980f(), InMobiAdActivity.class);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", a);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkboxStyle);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
        m4980f().startActivity(intent);
        if ((m4980f() instanceof Activity) && this.f4905d != -1) {
            ((Activity) m4980f()).overridePendingTransition(this.f4905d, 0);
        }
    }

    public boolean m5847x() {
        return m4982g() == AdState.STATE_READY;
    }

    void m5848y() {
        this.f4904c = true;
        if (m4989m() != null) {
            m4989m().m1987o();
        }
    }

    protected String m5831a() {
        return SchemaSymbols.ATTVAL_INT;
    }

    protected String m5836c() {
        return null;
    }

    protected PlacementType m5838d() {
        return PlacementType.FULL_SCREEN;
    }

    public void m5833a(Ad ad) {
        super.m4960a(ad);
        if (m4982g() == AdState.STATE_AVAILABLE) {
            m4970b(m4984h());
        }
    }

    public void m5834a(RenderView renderView) {
        super.m4963a(renderView);
        if (m4982g() == AdState.STATE_LOADED) {
            m4995s();
            m4957a(AdState.STATE_READY);
            m4997u();
            m4988l().m1424a();
            m4992p();
        }
    }

    public void m5837c(RenderView renderView) {
        super.m4973c(renderView);
        if (m4982g() == AdState.STATE_AVAILABLE) {
            m4957a(AdState.STATE_LOADED);
        }
    }

    public void m5835b(RenderView renderView) {
        super.m4968b(renderView);
        if (m4982g() == AdState.STATE_LOADED) {
            m4995s();
            m4957a(AdState.STATE_FAILED);
            m4988l().m1425a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    public synchronized void m5839e(RenderView renderView) {
        super.m4979e(renderView);
        if (m4982g() == AdState.STATE_RENDERED) {
            this.f4903b++;
            if (this.f4903b == 1) {
                m4988l().m1427b();
            } else {
                m4957a(AdState.STATE_ACTIVE);
            }
        } else if (m4982g() == AdState.STATE_ACTIVE) {
            this.f4903b++;
        }
    }

    public synchronized void m5840f(RenderView renderView) {
        super.m4981f(renderView);
        if (m4982g() == AdState.STATE_ACTIVE) {
            this.f4903b--;
            if (this.f4903b == 1) {
                m4957a(AdState.STATE_RENDERED);
            }
        } else if (m4982g() == AdState.STATE_RENDERED) {
            this.f4903b--;
            m4957a(AdState.STATE_CREATED);
            Map hashMap = new HashMap();
            hashMap.put("impId", m4985i());
            TelemetryComponent.m5070a().m5092a("ads", "IntClosed", hashMap);
            m4988l().m1429c();
            m5843r();
        }
    }

    protected void m5844t() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4902a, "Renderview timed out.");
        m4974c("RenderTimeOut");
        if (m4982g() == AdState.STATE_LOADED) {
            m4957a(AdState.STATE_FAILED);
            m4988l().m1425a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }
}
