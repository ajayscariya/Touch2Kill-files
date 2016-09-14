package com.startapp.android.publish.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdDisplayListener;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.adrules.AdRulesResult;
import com.startapp.android.publish.splash.SplashConfig.MaxAdDisplayTime;
import com.startapp.android.publish.splash.SplashConfig.Orientation;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.startapp.android.publish.splash.b */
public class StartAppSDK {
    private Activity f3613a;
    private SplashConfig f3614b;
    private StartAppSDK f3615c;
    private com.startapp.android.publish.p008b.StartAppSDK f3616d;
    private Handler f3617e;
    private boolean f3618f;
    private StartAppSDK f3619g;
    private AdPreferences f3620h;
    private Runnable f3621i;
    private Runnable f3622j;
    private AdEventListener f3623k;

    /* renamed from: com.startapp.android.publish.splash.b.1 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3607a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3607a = startAppSDK;
        }

        public void run() {
            if (this.f3607a.m3873d()) {
                this.f3607a.m3876e();
                this.f3607a.m3878f();
            }
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3608a;

        /* renamed from: com.startapp.android.publish.splash.b.2.1 */
        class StartAppSDK implements AdDisplayListener {
            final /* synthetic */ StartAppSDK f4783a;

            StartAppSDK(StartAppSDK startAppSDK) {
                this.f4783a = startAppSDK;
            }

            public void adHidden(Ad ad) {
                this.f4783a.f3608a.f3615c.m3859b();
            }

            public void adDisplayed(Ad ad) {
                this.f4783a.f3608a.f3615c.m3861c();
            }

            public void adClicked(Ad ad) {
                this.f4783a.f3608a.f3615c.m3865g();
            }

            public void adNotDisplayed(Ad ad) {
            }
        }

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3608a = startAppSDK;
        }

        public void run() {
            if (!this.f3608a.f3618f && this.f3608a.f3619g != null) {
                com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Displaying Splash ad");
                this.f3608a.f3619g.showAd(new StartAppSDK(this));
                this.f3608a.m3879g();
                this.f3608a.f3613a.finish();
            }
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.4 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3609a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3609a = startAppSDK;
        }

        public void run() {
            if (this.f3609a.f3615c.m3860b(this.f3609a.f3622j, this.f3609a.f3616d)) {
                this.f3609a.f3619g = null;
                this.f3609a.f3616d = null;
            }
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.5 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3610a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3610a = startAppSDK;
        }

        public void run() {
            this.f3610a.f3615c.m3858a(this.f3610a.f3622j, this.f3610a.f3616d);
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.6 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3611a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3611a = startAppSDK;
        }

        public void run() {
            this.f3611a.f3615c.m3856a(this.f3611a.f3619g);
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.7 */
    static /* synthetic */ class StartAppSDK {
        static final /* synthetic */ int[] f3612a;

        static {
            f3612a = new int[Orientation.values().length];
            try {
                f3612a[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3612a[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.3 */
    class StartAppSDK implements AdEventListener {
        final /* synthetic */ StartAppSDK f4784a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f4784a = startAppSDK;
        }

        public void onReceiveAd(Ad ad) {
            this.f4784a.f3615c.m3857a(this.f4784a.f3622j);
        }

        public void onFailedToReceiveAd(Ad ad) {
            if (this.f4784a.f3619g != null) {
                this.f4784a.f3615c.m3855a();
            }
        }
    }

    /* renamed from: com.startapp.android.publish.splash.b.a */
    private static class StartAppSDK extends StartAppAd {
        private static final long serialVersionUID = 1;

        public StartAppSDK(Context context) {
            super(context);
            this.placement = Placement.INAPP_SPLASH;
        }

        protected AdRulesResult shouldDisplayAd(String adTag, Placement adPlacement) {
            return new AdRulesResult(true);
        }
    }

    public StartAppSDK(Activity activity, SplashConfig splashConfig, AdPreferences adPreferences) {
        this.f3617e = new Handler();
        this.f3618f = false;
        this.f3621i = new StartAppSDK(this);
        this.f3622j = new StartAppSDK(this);
        this.f3623k = new StartAppSDK(this);
        this.f3613a = activity;
        this.f3614b = splashConfig;
        splashConfig.initSplashLogo(activity);
        this.f3620h = adPreferences;
        this.f3615c = new StartAppSDK(activity);
    }

    public void m3885a(Bundle bundle) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "========= Splash Screen Feature =========");
        this.f3615c.m3866h();
        if (m3872c()) {
            this.f3617e.postDelayed(this.f3621i, 100);
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Splash screen orientation is being modified");
            return;
        }
        this.f3617e.post(this.f3621i);
    }

    public void m3884a() {
        this.f3617e.removeCallbacks(this.f3621i);
        this.f3615c.m3862d();
    }

    private boolean m3872c() {
        boolean z = true;
        int i = this.f3613a.getResources().getConfiguration().orientation;
        if (this.f3614b.getOrientation() == Orientation.AUTO) {
            if (i == 2) {
                this.f3614b.setOrientation(Orientation.LANDSCAPE);
            } else {
                this.f3614b.setOrientation(Orientation.PORTRAIT);
            }
        }
        switch (StartAppSDK.f3612a[this.f3614b.getOrientation().ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (i != 2) {
                    z = false;
                }
                com.startapp.android.publish.p022h.StartAppSDK.m3165a(this.f3613a);
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (i != 1) {
                    z = false;
                }
                com.startapp.android.publish.p022h.StartAppSDK.m3183b(this.f3613a);
                break;
            default:
                z = false;
                break;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Set Orientation: [" + this.f3614b.getOrientation().toString() + "]");
        return z;
    }

    private boolean m3873d() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Displaying Splash screen");
        if (this.f3614b.validate(this.f3613a)) {
            this.f3613a.setContentView(this.f3614b.getLayout(this.f3613a), new LayoutParams(-1, -1));
            return true;
        }
        throw new IllegalArgumentException(this.f3614b.getErrorMessage());
    }

    private void m3876e() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Loading Splash Ad");
        this.f3619g = new StartAppSDK(this.f3613a.getApplicationContext());
        this.f3616d = this.f3619g.loadSplash(this.f3620h, this.f3623k);
    }

    private void m3878f() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Started Splash Loading Timer");
        this.f3617e.postDelayed(new StartAppSDK(this), this.f3614b.getMaxLoadAdTimeout().longValue());
        this.f3617e.postDelayed(new StartAppSDK(this), this.f3614b.getMinSplashTime().getIndex());
    }

    private void m3879g() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Splash", 4, "Started Splash Display Timer");
        if (this.f3614b.getMaxAdDisplayTime() != MaxAdDisplayTime.FOR_EVER) {
            this.f3617e.postDelayed(new StartAppSDK(this), this.f3614b.getMaxAdDisplayTime().getIndex());
        }
    }

    public void m3886b() {
        this.f3618f = true;
        this.f3615c.m3864f();
    }
}
