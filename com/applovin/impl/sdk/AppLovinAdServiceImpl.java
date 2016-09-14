package com.applovin.impl.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    public static String URI_NO_OP;
    public static String URI_TRACK_CLICK_IMMEDIATELY;
    private final AppLovinSdkImpl f3857a;
    private final AppLovinLogger f3858b;
    private Handler f3859c;
    private final Map f3860d;

    static {
        URI_NO_OP = "/adservice/no_op";
        URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    }

    AppLovinAdServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f3857a = appLovinSdkImpl;
        this.f3858b = appLovinSdkImpl.getLogger();
        this.f3859c = new Handler(Looper.getMainLooper());
        this.f3860d = new HashMap(2);
        for (AppLovinAdType put : AppLovinAdType.allTypes()) {
            this.f3860d.put(put, new HashMap());
        }
        ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.BANNER, new C0235i(null));
        ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.MREC, new C0235i(null));
        ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.INTERSTITIAL, new C0235i(null));
        ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.LEADER, new C0235i(null));
        ((Map) this.f3860d.get(AppLovinAdType.INCENTIVIZED)).put(AppLovinAdSize.INTERSTITIAL, new C0235i(null));
    }

    private void m4141a(Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        adViewControllerImpl.removeClickTrackingOverlay();
        expireAdLoadState(appLovinAdImpl);
        AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f3857a);
        adViewControllerImpl.dismissInterstitialIfRequired();
    }

    private void m4144a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        C0231c c0231c = new C0231c(appLovinAdSize, appLovinAdType);
        AppLovinAd appLovinAd = (AppLovinAd) this.f3857a.m4164c().m6073b(c0231c);
        if (appLovinAd != null) {
            this.f3858b.m306d("AppLovinAdService", "Using pre-loaded ad: " + appLovinAd + " for size " + appLovinAdSize + " and type " + appLovinAdType);
            appLovinAdLoadListener.adReceived(appLovinAd);
        } else {
            this.f3857a.m4160a().m233a(new cn(appLovinAdSize, appLovinAdType, appLovinAdLoadListener, this.f3857a), cs.MAIN);
        }
        this.f3857a.m4164c().m6078f(c0231c);
    }

    private boolean m4145a() {
        return ((PowerManager) this.f3857a.getApplicationContext().getSystemService("power")).isScreenOn();
    }

    private boolean m4147a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER ? ((Boolean) this.f3857a.m4161a(bx.f277t)).booleanValue() : appLovinAdSize == AppLovinAdSize.MREC ? ((Boolean) this.f3857a.m4161a(bx.f279v)).booleanValue() : appLovinAdSize == AppLovinAdSize.LEADER ? ((Boolean) this.f3857a.m4161a(bx.f281x)).booleanValue() : false;
    }

    private boolean m4148a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return !((Boolean) this.f3857a.m4161a(bx.f232A)).booleanValue() ? false : !m4152b(appLovinAdSize, appLovinAdType) ? false : appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f3857a.m4161a(bx.aq)).booleanValue() : appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL) ? ((Boolean) this.f3857a.m4161a(bx.ar)).booleanValue() : false;
    }

    private long m4150b(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER ? ((Long) this.f3857a.m4161a(bx.f278u)).longValue() : appLovinAdSize == AppLovinAdSize.MREC ? ((Long) this.f3857a.m4161a(bx.f280w)).longValue() : appLovinAdSize == AppLovinAdSize.LEADER ? ((Long) this.f3857a.m4161a(bx.f282y)).longValue() : 0;
    }

    private boolean m4152b(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        try {
            return appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? ((Boolean) this.f3857a.m4161a(bx.f236E)).booleanValue() : ((String) this.f3857a.m4161a(bx.f235D)).toUpperCase(Locale.ENGLISH).contains(appLovinAdSize.getLabel());
        } catch (Throwable e) {
            this.f3857a.getLogger().m308e("AppLovinAdService", "Unable to safely test preload merge capability", e);
            return false;
        }
    }

    private void m4155c(AppLovinAdSize appLovinAdSize) {
        long b = m4150b(appLovinAdSize);
        if (b > 0) {
            this.f3857a.m4160a().m234a(new C1177j(this, appLovinAdSize), cs.MAIN, (b + 2) * 1000);
        }
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
        addAdUpdateListener(appLovinAdUpdateListener, AppLovinAdSize.BANNER);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener == null) {
            throw new IllegalArgumentException("No ad listener specified");
        }
        Object obj;
        C0235i c0235i = (C0235i) ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
        synchronized (c0235i.f327b) {
            if (c0235i.f331f.contains(appLovinAdUpdateListener)) {
                obj = null;
            } else {
                c0235i.f331f.add(appLovinAdUpdateListener);
                obj = 1;
                this.f3858b.m306d("AppLovinAdService", "Added update listener: " + appLovinAdUpdateListener);
            }
        }
        if (obj != null) {
            this.f3857a.m4160a().m233a(new C1177j(this, appLovinAdSize), cs.MAIN);
        }
    }

    public void expireAdLoadState(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        C0235i c0235i = (C0235i) ((Map) this.f3860d.get(appLovinAdImpl.getType())).get(appLovinAdImpl.getSize());
        synchronized (c0235i.f327b) {
            c0235i.f328c = null;
            c0235i.f329d = 0;
        }
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f3857a.m4164c().m6077e(new C0231c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        loadNextAd(appLovinAdSize, AppLovinAdType.REGULAR, appLovinAdLoadListener);
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        Object obj = 1;
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No ad type specificed");
        } else {
            AppLovinAd appLovinAd;
            this.f3857a.getLogger().m306d("AppLovinAdService", "Loading next ad of size " + appLovinAdSize.getLabel() + " and type " + appLovinAdType.getLabel());
            if (appLovinAdSize.equals(AppLovinAdSize.BANNER) || appLovinAdSize.equals(AppLovinAdSize.MREC) || appLovinAdSize.equals(AppLovinAdSize.LEADER)) {
                this.f3857a.getLogger().userError("AppLovinAdService", "Banners, MRecs and Leaderboards are deprecated and will be removed in a future SDK version!");
            }
            C0235i c0235i = (C0235i) ((Map) this.f3860d.get(appLovinAdType)).get(appLovinAdSize);
            synchronized (c0235i.f327b) {
                if (System.currentTimeMillis() <= c0235i.f329d) {
                    obj = null;
                }
                if (c0235i.f328c == null || r2 != null) {
                    this.f3858b.m306d("AppLovinAdService", "Loading next ad...");
                    c0235i.f332g.add(appLovinAdLoadListener);
                    if (!c0235i.f330e) {
                        c0235i.f330e = true;
                        obj = new C1176h(this, (C0235i) ((Map) this.f3860d.get(appLovinAdType)).get(appLovinAdSize), null);
                        if (!m4148a(appLovinAdSize, appLovinAdType)) {
                            this.f3858b.m306d("AppLovinAdService", "Task merge not necessary.");
                            m4144a(appLovinAdSize, appLovinAdType, obj);
                        } else if (this.f3857a.m4164c().m6072a(new C0231c(appLovinAdSize, appLovinAdType), obj)) {
                            this.f3858b.m306d("AppLovinAdService", "Attaching load listener to initial preload task...");
                            appLovinAd = null;
                        } else {
                            this.f3858b.m306d("AppLovinAdService", "Skipped attach of initial preload callback.");
                            m4144a(appLovinAdSize, appLovinAdType, obj);
                            appLovinAd = null;
                        }
                    }
                    appLovinAd = null;
                } else {
                    appLovinAd = c0235i.f328c;
                }
            }
            if (appLovinAd != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            }
        }
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f3857a.m4164c().m6078f(new C0231c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener != null) {
            C0235i c0235i = (C0235i) ((Map) this.f3860d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
            synchronized (c0235i.f327b) {
                c0235i.f331f.remove(appLovinAdUpdateListener);
            }
            this.f3858b.m306d("AppLovinAdService", "Removed update listener: " + appLovinAdUpdateListener);
        }
    }

    public void trackClickOn(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        String supplementalClickTrackingUrl = appLovinAdImpl.getSupplementalClickTrackingUrl(str);
        if (AppLovinSdkUtils.isValidString(supplementalClickTrackingUrl)) {
            this.f3857a.getPersistentPostbackManager().m139a(supplementalClickTrackingUrl, null);
        }
        m4141a(uri, appLovinAdImpl, appLovinAdView, adViewControllerImpl);
    }

    public void trackForegroundClick(AppLovinAd appLovinAd, String str, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        this.f3858b.m306d("AppLovinAdService", "Tracking foreground click on an ad...");
        int intValue = ((Integer) this.f3857a.m4161a(bx.be)).intValue();
        int intValue2 = ((Integer) this.f3857a.m4161a(bx.bf)).intValue();
        int intValue3 = ((Integer) this.f3857a.m4161a(bx.bg)).intValue();
        this.f3857a.getPostbackService().dispatchPostbackAsync(((AppLovinAdImpl) appLovinAd).getSupplementalClickTrackingUrl(str), null, intValue, intValue2, intValue3, new C1175e(this, adViewControllerImpl, uri, appLovinAdImpl, appLovinAdView));
    }
}
