package com.startapp.android.publish;

import android.content.Context;
import android.webkit.WebView;
import com.startapp.android.publish.AdDisplayListener.NotDisplayedReason;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import com.startapp.android.publish.model.adrules.SessionManager;
import java.io.Serializable;
import mf.javax.xml.XMLConstants;

/* compiled from: StartAppSDK */
public abstract class Ad implements Serializable {
    private static boolean init = false;
    private static final long serialVersionUID = 1;
    com.startapp.android.publish.adinformation.StartAppSDK adInfoOverride;
    protected transient Context context;
    protected String errorMessage;
    protected Serializable extraData;
    private Long lastLoadTime;
    private NotDisplayedReason notDisplayedReason;
    protected Placement placement;
    private AdState state;
    private AdType type;

    /* compiled from: StartAppSDK */
    public enum AdState {
        UN_INITIALIZED,
        PROCESSING,
        READY
    }

    /* compiled from: StartAppSDK */
    public enum AdType {
        INTERSTITIAL,
        RICH_TEXT,
        VIDEO,
        REWARDED_VIDEO,
        NON_VIDEO
    }

    /* renamed from: com.startapp.android.publish.Ad.1 */
    class StartAppSDK implements AdEventListener {
        final /* synthetic */ AdEventListener f4649a;
        final /* synthetic */ Ad f4650b;

        StartAppSDK(Ad ad, AdEventListener adEventListener) {
            this.f4650b = ad;
            this.f4649a = adEventListener;
        }

        public void onReceiveAd(Ad ad) {
            this.f4650b.setLastLoadTime(Long.valueOf(System.currentTimeMillis()));
            this.f4649a.onReceiveAd(ad);
        }

        public void onFailedToReceiveAd(Ad ad) {
            this.f4649a.onFailedToReceiveAd(ad);
        }
    }

    /* renamed from: com.startapp.android.publish.Ad.2 */
    class StartAppSDK implements com.startapp.android.publish.p011e.StartAppSDK {
        final /* synthetic */ AdPreferences f4651a;
        final /* synthetic */ AdEventListener f4652b;
        final /* synthetic */ Ad f4653c;

        StartAppSDK(Ad ad, AdPreferences adPreferences, AdEventListener adEventListener) {
            this.f4653c = ad;
            this.f4651a = adPreferences;
            this.f4652b = adEventListener;
        }

        public void onFinishLoadingMeta() {
            this.f4653c.loadAds(this.f4651a, this.f4652b);
        }

        public void onFailedLoadingMeta() {
            this.f4653c.loadAds(this.f4651a, this.f4652b);
        }
    }

    protected abstract void loadAds(AdPreferences adPreferences, AdEventListener adEventListener);

    static {
        init = false;
    }

    public Ad(Context context, Placement placement) {
        this.extraData = null;
        this.adInfoOverride = com.startapp.android.publish.adinformation.StartAppSDK.m2855a();
        this.errorMessage = null;
        this.state = AdState.UN_INITIALIZED;
        this.context = context;
        this.placement = placement;
    }

    public Serializable getExtraData() {
        return this.extraData;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setExtraData(Serializable extraData) {
        this.extraData = extraData;
    }

    public AdState getState() {
        return this.state;
    }

    public void setState(AdState state) {
        this.state = state;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public com.startapp.android.publish.adinformation.StartAppSDK getAdInfoOverride() {
        return this.adInfoOverride;
    }

    public void setAdInfoOverride(com.startapp.android.publish.adinformation.StartAppSDK adInfoOverride) {
        this.adInfoOverride = adInfoOverride;
    }

    protected Placement getPlacement() {
        return this.placement;
    }

    protected void setPlacement(Placement mode) {
        this.placement = mode;
    }

    @Deprecated
    public boolean load() {
        return load(new AdPreferences(), null);
    }

    @Deprecated
    public boolean load(AdEventListener callback) {
        return load(new AdPreferences(), callback);
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences) {
        return load(adPreferences, null);
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener callback) {
        return load(adPreferences, callback, true);
    }

    protected boolean load(AdPreferences adPreferences, AdEventListener callback, boolean waitForMetadata) {
        boolean z;
        AdEventListener startAppSDK = new StartAppSDK(this, new StartAppSDK(callback));
        com.startapp.android.publish.p022h.StartAppSDK.m3216b(this.context, "User-Agent", new WebView(this.context).getSettings().getUserAgentString());
        if (!init) {
            com.startapp.android.publish.p022h.StartAppSDK.m3344d(this.context);
            com.startapp.android.publish.p022h.StartAppSDK.m3238c(this.context);
            init = true;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3300a(this.context, adPreferences);
        String str = XMLConstants.NULL_NS_URI;
        if (adPreferences.getProductId() == null || XMLConstants.NULL_NS_URI.equals(adPreferences.getProductId())) {
            str = "app ID was not set.";
            z = true;
        } else {
            z = false;
        }
        if (this.state != AdState.UN_INITIALIZED) {
            str = "load() was already called.";
            z = true;
        }
        if (!com.startapp.android.publish.p022h.StartAppSDK.m3322a(this.context)) {
            str = "network not available.";
            z = true;
        }
        if (z) {
            setErrorMessage("Ad wasn't loaded: " + str);
            startAppSDK.onFailedToReceiveAd(this);
            return false;
        }
        setState(AdState.PROCESSING);
        com.startapp.android.publish.p011e.StartAppSDK startAppSDK2 = new StartAppSDK(this, adPreferences, startAppSDK);
        if (adPreferences.getType() != null) {
            setType(adPreferences.getType());
        }
        MetaData.getInstance().loadFromServer(this.context, adPreferences, SessionManager.getInstance().getSessionRequestReason(), waitForMetadata, startAppSDK2);
        return true;
    }

    public boolean isReady() {
        return this.state == AdState.READY;
    }

    @Deprecated
    public boolean show() {
        return false;
    }

    public NotDisplayedReason getNotDisplayedReason() {
        return this.notDisplayedReason;
    }

    protected void setNotDisplayedReason(NotDisplayedReason reason) {
        this.notDisplayedReason = reason;
    }

    protected boolean hasCacheTTLPassed() {
        return getLastLoadTime() != null && System.currentTimeMillis() - getLastLoadTime().longValue() > getAdCacheTTL();
    }

    protected long getAdCacheTTL() {
        return MetaData.getInstance().getACMConfig().getAdCacheTtl();
    }

    protected Long getLastLoadTime() {
        return this.lastLoadTime;
    }

    private void setLastLoadTime(Long lastLoadTime) {
        this.lastLoadTime = lastLoadTime;
    }

    private void setType(AdType type) {
        this.type = type;
    }

    public AdType getType() {
        return this.type;
    }
}
