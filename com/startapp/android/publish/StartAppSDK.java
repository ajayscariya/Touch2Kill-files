package com.startapp.android.publish;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.startapp.android.publish.b */
public class StartAppSDK implements AdEventListener {
    private AdEventListener f4668a;

    /* renamed from: com.startapp.android.publish.b.1 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ Ad f3059a;
        final /* synthetic */ StartAppSDK f3060b;

        StartAppSDK(StartAppSDK startAppSDK, Ad ad) {
            this.f3060b = startAppSDK;
            this.f3059a = ad;
        }

        public void run() {
            this.f3060b.f4668a.onReceiveAd(this.f3059a);
        }
    }

    /* renamed from: com.startapp.android.publish.b.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ Ad f3061a;
        final /* synthetic */ StartAppSDK f3062b;

        StartAppSDK(StartAppSDK startAppSDK, Ad ad) {
            this.f3062b = startAppSDK;
            this.f3061a = ad;
        }

        public void run() {
            this.f3062b.f4668a.onFailedToReceiveAd(this.f3061a);
        }
    }

    public StartAppSDK(AdEventListener adEventListener) {
        this.f4668a = adEventListener;
    }

    public void onReceiveAd(Ad ad) {
        if (this.f4668a != null) {
            Handler a = m5378a();
            if (a != null) {
                a.post(new StartAppSDK(this, ad));
            } else {
                this.f4668a.onReceiveAd(ad);
            }
        }
    }

    public void onFailedToReceiveAd(Ad ad) {
        if (this.f4668a != null) {
            Handler a = m5378a();
            if (a != null) {
                a.post(new StartAppSDK(this, ad));
            } else {
                this.f4668a.onFailedToReceiveAd(ad);
            }
        }
    }

    public Handler m5378a() {
        return new Handler(Looper.getMainLooper());
    }
}
