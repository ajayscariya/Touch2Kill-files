package com.startapp.android.publish.p027a;

import android.content.Context;
import com.startapp.android.publish.Ad.AdState;
import com.startapp.android.publish.AdDisplayListener.NotDisplayedReason;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;

/* renamed from: com.startapp.android.publish.a.j */
public class StartAppSDK extends StartAppSDK {
    private static final long serialVersionUID = 1;

    public StartAppSDK(Context context) {
        super(context, Placement.INAPP_RETURN);
    }

    protected void loadAds(AdPreferences adPreferences, AdEventListener callback) {
        new com.startapp.android.publish.p011e.StartAppSDK(this.context, this, adPreferences, callback).m3047c();
    }

    public boolean load(AdPreferences adPreferences, AdEventListener userCallback) {
        AdEventListener startAppSDK = new com.startapp.android.publish.StartAppSDK(userCallback);
        if (!isReady()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("ReturnAd", 3, "Loading return ad");
        } else if (hasCacheTTLPassed()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("ReturnAd", 3, "Reloading return ad - Cache TTL has passed");
        } else {
            startAppSDK.onReceiveAd(this);
            return true;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3300a(this.context, adPreferences);
        setState(AdState.UN_INITIALIZED);
        return super.load(adPreferences, startAppSDK, true);
    }

    public boolean show() {
        boolean z = false;
        setNotDisplayedReason(null);
        if (!isReady()) {
            setNotDisplayedReason(NotDisplayedReason.AD_NOT_READY);
        } else if (com.startapp.android.publish.p022h.StartAppSDK.m3322a(this.context)) {
            z = super.m5875a(null);
        } else {
            setNotDisplayedReason(NotDisplayedReason.NETWORK_PROBLEM);
        }
        if (!z) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("ReturnAd", 3, "Return Ad not shown - " + getNotDisplayedReason());
            if (!(getNotDisplayedReason() == null || getNotDisplayedReason() == NotDisplayedReason.NETWORK_PROBLEM)) {
                com.startapp.android.publish.p022h.StartAppSDK.m3309a(this.context, com.startapp.android.publish.p022h.StartAppSDK.m3327a((com.startapp.android.publish.StartAppSDK) this), null, getNotDisplayedReason().toString());
            }
        }
        return z;
    }
}
