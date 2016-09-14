package com.startapp.android.publish.p008b;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.startapp.android.publish.b.c */
public class StartAppSDK {
    private static final EnumSet<Placement> f3080a;
    private Context f3081b;
    private Placement f3082c;
    private AdPreferences f3083d;
    private com.startapp.android.publish.StartAppSDK f3084e;
    private Map<AdEventListener, List<StartAppAd>> f3085f;

    /* renamed from: com.startapp.android.publish.b.c.2 */
    static /* synthetic */ class StartAppSDK {
        static final /* synthetic */ int[] f3079a;

        static {
            f3079a = new int[Placement.values().length];
            try {
                f3079a[Placement.INAPP_FULL_SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3079a[Placement.INAPP_OVERLAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3079a[Placement.INAPP_OFFER_WALL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.startapp.android.publish.b.c.1 */
    class StartAppSDK implements AdEventListener {
        final /* synthetic */ AdEventListener f4658a;
        final /* synthetic */ StartAppSDK f4659b;

        StartAppSDK(StartAppSDK startAppSDK, AdEventListener adEventListener) {
            this.f4659b = startAppSDK;
            this.f4658a = adEventListener;
        }

        public void onReceiveAd(Ad ad) {
            this.f4658a.onReceiveAd(ad);
        }

        public void onFailedToReceiveAd(Ad ad) {
            this.f4658a.onFailedToReceiveAd(ad);
        }
    }

    /* renamed from: com.startapp.android.publish.b.c.a */
    private class StartAppSDK implements AdEventListener {
        final /* synthetic */ StartAppSDK f4660a;
        private boolean f4661b;
        private boolean f4662c;

        private StartAppSDK(StartAppSDK startAppSDK) {
            this.f4660a = startAppSDK;
            this.f4661b = false;
            this.f4662c = false;
        }

        public void onReceiveAd(Ad ad) {
            if (!this.f4661b) {
                this.f4661b = true;
                synchronized (this.f4660a.f3085f) {
                    for (AdEventListener adEventListener : this.f4660a.f3085f.keySet()) {
                        for (StartAppAd startAppAd : (List) this.f4660a.f3085f.get(adEventListener)) {
                            startAppAd.setErrorMessage(ad.getErrorMessage());
                            new com.startapp.android.publish.StartAppSDK(adEventListener).onReceiveAd(startAppAd);
                        }
                    }
                    this.f4660a.f3085f.clear();
                }
            }
        }

        public void onFailedToReceiveAd(Ad ad) {
            Map map;
            if (this.f4662c) {
                map = null;
            } else {
                ConcurrentHashMap concurrentHashMap;
                synchronized (this.f4660a.f3085f) {
                    concurrentHashMap = new ConcurrentHashMap(this.f4660a.f3085f);
                    this.f4660a.f3084e = null;
                    this.f4660a.f3085f.clear();
                }
                map = concurrentHashMap;
            }
            if (map != null) {
                for (AdEventListener adEventListener : map.keySet()) {
                    for (StartAppAd startAppAd : (List) map.get(adEventListener)) {
                        startAppAd.setErrorMessage(ad.getErrorMessage());
                        new com.startapp.android.publish.StartAppSDK(adEventListener).onFailedToReceiveAd(startAppAd);
                    }
                }
            }
            this.f4662c = true;
        }
    }

    static {
        f3080a = EnumSet.of(Placement.INAPP_SPLASH);
    }

    public StartAppSDK(Context context, Placement placement, AdPreferences adPreferences) {
        this.f3084e = null;
        this.f3085f = new ConcurrentHashMap();
        this.f3081b = context;
        this.f3082c = placement;
        this.f3083d = adPreferences;
    }

    protected void m2912a(AdPreferences adPreferences) {
        this.f3083d = adPreferences;
    }

    public void m2911a(StartAppAd startAppAd, AdEventListener adEventListener) {
        AdEventListener startAppSDK = new com.startapp.android.publish.StartAppSDK(adEventListener);
        if (m2913a()) {
            startAppSDK.onReceiveAd(startAppAd);
            return;
        }
        this.f3084e = m2917d();
        this.f3084e.load(this.f3083d, new StartAppSDK(this, startAppSDK));
    }

    public void m2915b(StartAppAd startAppAd, AdEventListener adEventListener) {
        synchronized (this.f3085f) {
            boolean f = m2908f();
            if (!m2913a() || f) {
                if (!(startAppAd == null || adEventListener == null)) {
                    List list = (List) this.f3085f.get(adEventListener);
                    if (list == null) {
                        list = new ArrayList();
                        this.f3085f.put(adEventListener, list);
                    }
                    list.add(startAppAd);
                }
                if (this.f3084e == null || f) {
                    if (f) {
                        com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 3, this.f3082c + " ad cache TTL passed");
                    }
                    m2909g();
                } else {
                    com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 3, this.f3082c + " ad is currently loading");
                    return;
                }
            }
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 3, this.f3082c + " ad already loaded");
            if (!(startAppAd == null || adEventListener == null)) {
                new com.startapp.android.publish.StartAppSDK(adEventListener).onReceiveAd(startAppAd);
            }
        }
    }

    private boolean m2908f() {
        return this.f3084e != null && this.f3084e.hasCacheTTLPassed();
    }

    public boolean m2913a() {
        return this.f3084e != null && this.f3084e.isReady();
    }

    public com.startapp.android.publish.StartAppSDK m2914b() {
        if (!m2913a()) {
            return null;
        }
        com.startapp.android.publish.StartAppSDK startAppSDK = this.f3084e;
        if (com.startapp.android.publish.StartAppSDK.OVERRIDE_NETWORK.booleanValue()) {
            return startAppSDK;
        }
        if (f3080a.contains(this.f3082c)) {
            this.f3084e = null;
            return startAppSDK;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 4, "Auto loading:" + this.f3082c);
        m2909g();
        return startAppSDK;
    }

    private void m2909g() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 3, "Loading new " + this.f3082c + " ad");
        this.f3084e = m2918e();
        this.f3084e.load(this.f3083d, new StartAppSDK());
    }

    public com.startapp.android.publish.StartAppSDK m2916c() {
        return this.f3084e;
    }

    public com.startapp.android.publish.StartAppSDK m2917d() {
        return new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
    }

    public com.startapp.android.publish.StartAppSDK m2918e() {
        com.startapp.android.publish.StartAppSDK startAppSDK;
        com.startapp.android.publish.p022h.StartAppSDK.m3300a(this.f3081b, this.f3083d);
        switch (StartAppSDK.f3079a[this.f3082c.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                startAppSDK = new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                startAppSDK = new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                startAppSDK = m2910h();
                break;
            default:
                startAppSDK = new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
                break;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("CachedAd", 4, "ad Type: [" + startAppSDK.getClass().toString() + "]");
        return startAppSDK;
    }

    private com.startapp.android.publish.StartAppSDK m2910h() {
        if ((new Random().nextInt(100) < MetaData.getInstance().getProbability3D() || com.startapp.android.publish.p022h.StartAppSDK.m3324a(this.f3083d, "forceOfferWall3D")) && !com.startapp.android.publish.p022h.StartAppSDK.m3324a(this.f3083d, "forceOfferWall2D")) {
            return new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
        }
        return new com.startapp.android.publish.p027a.StartAppSDK(this.f3081b);
    }
}
