package com.jirbo.adcolony;

import android.graphics.Bitmap;

public class AdColonyInterstitialAd extends AdColonyAd {
    AdColonyNativeAdListener f4580C;
    boolean f4581D;

    /* renamed from: com.jirbo.adcolony.AdColonyInterstitialAd.1 */
    class C14251 extends C0724j {
        final /* synthetic */ AdColonyInterstitialAd f4578a;

        C14251(AdColonyInterstitialAd adColonyInterstitialAd, C0711d c0711d) {
            this.f4578a = adColonyInterstitialAd;
            super(c0711d);
        }

        void m5302a() {
            if (this.f4578a.h != null) {
                this.o.f2515d.m5354a(this.f4578a.h, this.f4578a);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyInterstitialAd.2 */
    class C14262 extends C0724j {
        final /* synthetic */ AdColonyInterstitialAd f4579a;

        C14262(AdColonyInterstitialAd adColonyInterstitialAd, C0711d c0711d) {
            this.f4579a = adColonyInterstitialAd;
            super(c0711d);
        }

        void m5303a() {
            this.o.f2515d.m5354a(this.f4579a.h, this.f4579a);
        }
    }

    public AdColonyInterstitialAd() {
        C0694a.f2338D = false;
        C0694a.m2460e();
        this.k = "interstitial";
        this.l = "fullscreen";
        this.f4581D = false;
        this.m = aa.m2481b();
    }

    public AdColonyInterstitialAd(String zone_id) {
        this.k = "interstitial";
        this.l = "fullscreen";
        C0694a.m2460e();
        this.h = zone_id;
        this.f4581D = false;
        this.m = aa.m2481b();
    }

    boolean m5306b() {
        return false;
    }

    public AdColonyInterstitialAd withListener(AdColonyAdListener listener) {
        this.y = listener;
        return this;
    }

    boolean m5305a(boolean z) {
        boolean z2 = false;
        if (this.h == null) {
            this.h = C0694a.f2372l.m2572e();
            if (this.h == null) {
                return false;
            }
        }
        C0711d c0711d = C0694a.f2372l;
        String str = this.h;
        if (!z) {
            z2 = true;
        }
        return c0711d.m2560a(str, z, z2);
    }

    public boolean isReady() {
        if (this.h == null) {
            this.h = C0694a.f2372l.m2572e();
            if (this.h == null) {
                return false;
            }
        }
        if (!AdColony.isZoneNative(this.h)) {
            return C0694a.f2372l.m2573e(this.h);
        }
        C0694a.am = 12;
        return false;
    }

    public void show() {
        if (this.f4581D) {
            C0726l.f2613d.m2657b((Object) "Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
            return;
        }
        C0694a.am = 0;
        this.k = "interstitial";
        this.l = "fullscreen";
        if (isReady()) {
            this.g = C0694a.am;
            this.f4581D = true;
            if (C0694a.f2339E) {
                C14262 c14262 = new C14262(this, C0694a.f2372l);
                C0694a.f2339E = false;
                m2423c();
                C0694a.f2354T = this;
                if (!C0694a.f2372l.m2564b(this)) {
                    if (this.y != null) {
                        this.y.onAdColonyAdAttemptFinished(this);
                    }
                    C0694a.f2339E = true;
                    return;
                } else if (this.y != null) {
                    this.y.onAdColonyAdStarted(this);
                }
            }
            this.f = 4;
            return;
        }
        this.g = C0694a.am;
        C14251 c14251 = new C14251(this, C0694a.f2372l);
        this.f = 2;
        if (this.y != null) {
            this.y.onAdColonyAdAttemptFinished(this);
        }
        this.f4581D = true;
    }

    void m5304a() {
        this.k = "interstitial";
        this.l = "fullscreen";
        if (this.y != null && !this.w) {
            this.y.onAdColonyAdAttemptFinished(this);
        } else if (this.f4580C != null) {
            if (canceled()) {
                this.x.f2288I = true;
            } else {
                this.x.f2288I = false;
            }
            this.f4580C.onAdColonyNativeAdFinished(true, this.x);
        }
        System.gc();
        if (!(C0694a.f2338D || AdColonyBrowser.f2243B)) {
            for (int i = 0; i < C0694a.an.size(); i++) {
                ((Bitmap) C0694a.an.get(i)).recycle();
            }
            C0694a.an.clear();
        }
        this.w = true;
        C0694a.f2355U = null;
        C0694a.f2339E = true;
    }
}
