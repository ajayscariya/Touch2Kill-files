package com.startapp.android.publish.nativead;

import android.content.Context;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.model.AdDetails;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import com.startapp.android.publish.model.adrules.AdDisplayEvent;
import com.startapp.android.publish.model.adrules.AdRulesResult;
import com.startapp.android.publish.model.adrules.SessionManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StartAppSDK */
public class StartAppNativeAd extends Ad implements com.startapp.android.publish.nativead.NativeAdDetails.StartAppSDK {
    private static final String TAG = "StartAppNativeAd";
    private static final long serialVersionUID = 1;
    private StartAppSDK adEventDelegate;
    private boolean isLoading;
    private List<NativeAdDetails> listNativeAds;
    private com.startapp.android.publish.p027a.StartAppSDK nativeAd;
    private NativeAdPreferences preferences;
    private int totalObjectsLoaded;

    /* renamed from: com.startapp.android.publish.nativead.StartAppNativeAd.b */
    public enum StartAppSDK {
        LAUNCH_APP,
        OPEN_MARKET
    }

    /* renamed from: com.startapp.android.publish.nativead.StartAppNativeAd.a */
    private class StartAppSDK implements AdEventListener {
        final /* synthetic */ StartAppNativeAd f4763a;
        private AdEventListener f4764b;

        public StartAppSDK(StartAppNativeAd startAppNativeAd, AdEventListener adEventListener) {
            this.f4763a = startAppNativeAd;
            this.f4764b = null;
            this.f4764b = new com.startapp.android.publish.StartAppSDK(adEventListener);
        }

        public void onReceiveAd(Ad ad) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a(StartAppNativeAd.TAG, 3, "NativeAd Received");
            this.f4763a.initNativeAdList();
        }

        public void onFailedToReceiveAd(Ad ad) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a(StartAppNativeAd.TAG, 3, "NativeAd Failed to load");
            this.f4763a.setErrorMessage(ad.getErrorMessage());
            if (this.f4764b != null) {
                this.f4764b.onFailedToReceiveAd(this.f4763a);
                this.f4764b = null;
            }
            this.f4763a.isLoading = false;
            this.f4763a.initNativeAdList();
        }

        public AdEventListener m5485a() {
            return this.f4764b;
        }
    }

    public StartAppNativeAd(Context context) {
        super(context, Placement.INAPP_NATIVE);
        this.totalObjectsLoaded = 0;
        this.listNativeAds = new ArrayList();
        this.isLoading = false;
    }

    private NativeAdPreferences getPreferences() {
        return this.preferences;
    }

    private void setPreferences(NativeAdPreferences preferences) {
        this.preferences = preferences;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n===== StartAppNativeAd =====\n");
        for (int i = 0; i < getNumberOfAds(); i++) {
            stringBuffer.append(this.listNativeAds.get(i));
        }
        stringBuffer.append("===== End StartAppNativeAd =====");
        return stringBuffer.toString();
    }

    private void initNativeAdList() {
        this.totalObjectsLoaded = 0;
        if (this.listNativeAds == null) {
            this.listNativeAds = new ArrayList();
        }
        this.listNativeAds.clear();
        if (this.nativeAd != null && this.nativeAd.m5373b() != null) {
            for (int i = 0; i < this.nativeAd.m5373b().size(); i++) {
                this.listNativeAds.add(new NativeAdDetails((AdDetails) this.nativeAd.m5373b().get(i), getPreferences(), i, this));
            }
        }
    }

    public void onNativeAdDetailsLoaded(int identifier) {
        this.totalObjectsLoaded++;
        if (this.nativeAd.m5373b() != null && this.totalObjectsLoaded == this.nativeAd.m5373b().size()) {
            onNativeAdLoaded();
        }
    }

    private void onNativeAdLoaded() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a(TAG, 3, "Ad Loaded successfully");
        this.isLoading = false;
        setErrorMessage(null);
        if (this.adEventDelegate != null) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a(TAG, 3, "Calling original RecienedAd callback");
            AdEventListener a = this.adEventDelegate.m5485a();
            if (a != null) {
                a.onReceiveAd(this);
            }
        }
    }

    public int getNumberOfAds() {
        if (this.listNativeAds != null) {
            return this.listNativeAds.size();
        }
        return 0;
    }

    public boolean loadAd() {
        return loadAd(new NativeAdPreferences(), null);
    }

    public boolean loadAd(AdEventListener listener) {
        return loadAd(new NativeAdPreferences(), listener);
    }

    public boolean loadAd(NativeAdPreferences nativeAdPreferences) {
        return loadAd(nativeAdPreferences, null);
    }

    public boolean loadAd(NativeAdPreferences adPrefrences, AdEventListener listener) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a(TAG, 3, "Start loading StartAppNativeAd");
        this.adEventDelegate = new StartAppSDK(this, listener);
        com.startapp.android.publish.p022h.StartAppSDK.m3232a(TAG, 3, "Configurtaion: " + adPrefrences);
        setPreferences(adPrefrences);
        if (this.isLoading) {
            setErrorMessage("Ad is currently being loaded");
            return false;
        }
        this.isLoading = true;
        this.nativeAd = new com.startapp.android.publish.p027a.StartAppSDK(this.context, getPreferences());
        return this.nativeAd.load(adPrefrences, this.adEventDelegate);
    }

    protected void loadAds(AdPreferences adPreferences, AdEventListener callback) {
    }

    public ArrayList<NativeAdDetails> getNativeAds() {
        return getNativeAds(null);
    }

    public ArrayList<NativeAdDetails> getNativeAds(String adTag) {
        ArrayList<NativeAdDetails> arrayList = new ArrayList();
        AdRulesResult shouldDisplayAd = MetaData.getInstance().getAdRules().shouldDisplayAd(Placement.INAPP_NATIVE, adTag);
        if (!shouldDisplayAd.shouldDisplayAd()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3309a(this.context, com.startapp.android.publish.p022h.StartAppSDK.m3328a(getAdDetailsList()), adTag, shouldDisplayAd.getSimpleReason());
            if (com.startapp.android.publish.StartAppSDK.m3036a().booleanValue()) {
                com.startapp.android.publish.p022h.StartAppSDK.m3258a().m3259a(this.context, shouldDisplayAd.getReason());
            }
        } else if (this.listNativeAds != null) {
            for (NativeAdDetails nativeAdDetails : this.listNativeAds) {
                nativeAdDetails.m5484a(adTag);
                arrayList.add(nativeAdDetails);
            }
            SessionManager.getInstance().addAdDisplayEvent(new AdDisplayEvent(Placement.INAPP_NATIVE, adTag));
        }
        return arrayList;
    }

    private List<AdDetails> getAdDetailsList() {
        List<AdDetails> arrayList = new ArrayList();
        if (this.listNativeAds != null) {
            for (NativeAdDetails a : this.listNativeAds) {
                arrayList.add(a.m5482a());
            }
        }
        return arrayList;
    }
}
