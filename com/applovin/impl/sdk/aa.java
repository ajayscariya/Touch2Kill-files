package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;

public class aa {
    private static String f130l;
    private final AppLovinSdkImpl f131a;
    private final AppLovinAdServiceImpl f132b;
    private AppLovinAdImpl f133c;
    private String f134d;
    private SoftReference f135e;
    private final Handler f136f;
    private final Object f137g;
    private volatile String f138h;
    private df f139i;
    private volatile boolean f140j;
    private SoftReference f141k;

    static {
        f130l = null;
    }

    public aa(AppLovinSdk appLovinSdk) {
        this.f137g = new Object();
        this.f140j = false;
        this.f131a = (AppLovinSdkImpl) appLovinSdk;
        this.f132b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f136f = new Handler(Looper.getMainLooper());
    }

    public static void m60a(String str) {
        f130l = str;
    }

    public static String m64b() {
        return f130l;
    }

    private void m67e() {
        if (this.f135e != null) {
            AppLovinAdLoadListener appLovinAdLoadListener = (AppLovinAdLoadListener) this.f135e.get();
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
            }
        }
    }

    private AppLovinAdRewardListener m68f() {
        return new ab(this);
    }

    void m69a(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (m75a()) {
            AppLovinAd appLovinAd = this.f133c;
            if (appLovinAd.getType().equals(AppLovinAdType.INCENTIVIZED)) {
                AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f131a, activity);
                AppLovinAdRewardListener afVar = new af(activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
                create.setAdDisplayListener(afVar);
                create.setAdVideoPlaybackListener(afVar);
                create.setAdClickListener(afVar);
                create.showAndRender(appLovinAd, this.f134d);
                this.f141k = new SoftReference(create);
                m71a(appLovinAd, afVar);
                return;
            }
            this.f131a.getLogger().m307e("IncentivizedAdController", "Attempted to render an ad of type " + this.f133c.getType() + " in an Incentivized Ad interstitial.");
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(this.f133c, 0.0d, false);
            return;
        }
        this.f131a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m67e();
    }

    public void m70a(Activity activity, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdRewardListener f = appLovinAdRewardListener == null ? m68f() : appLovinAdRewardListener;
        if (!m75a()) {
            this.f131a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            m67e();
        } else if (!AppLovinSdkUtils.isValidString(this.f133c.getVideoFilename()) || this.f131a.getFileManager().m295a(this.f133c.getVideoFilename(), (Context) activity)) {
            this.f134d = str;
            if (((Boolean) this.f131a.m4161a(bx.f252U)).booleanValue()) {
                ar arVar = new ar(this.f131a, this);
                arVar.m92a(activity);
                arVar.m94a(appLovinAdDisplayListener);
                arVar.m93a(appLovinAdClickListener);
                arVar.m96a(appLovinAdVideoPlaybackListener);
                arVar.m95a(f);
                arVar.m91a();
                return;
            }
            m69a(activity, f, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }
    }

    void m71a(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f139i = new df(this.f131a, appLovinAd, appLovinAdRewardListener);
        this.f131a.m4160a().m233a(this.f139i, cs.BACKGROUND);
    }

    public void m72a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f131a.getLogger().m306d("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f135e = new SoftReference(appLovinAdLoadListener);
        if (m75a()) {
            this.f131a.getLogger().userError("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f133c);
                return;
            }
            return;
        }
        this.f132b.loadNextAd(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, new ac(this, appLovinAdLoadListener));
    }

    void m73a(AppLovinAdRewardListener appLovinAdRewardListener) {
        appLovinAdRewardListener.userDeclinedToViewAd(this.f133c);
    }

    void m74a(String str, Activity activity) {
        if (str != null && ((Boolean) this.f131a.m4161a(bx.f253V)).booleanValue()) {
            new ap(this.f131a, activity, str).m81a();
        }
    }

    public boolean m75a() {
        return this.f133c != null;
    }

    void m76b(String str) {
        synchronized (this.f137g) {
            this.f138h = str;
        }
    }

    String m77c() {
        String str;
        synchronized (this.f137g) {
            str = this.f138h;
        }
        return str;
    }

    public void m78d() {
        if (this.f141k != null) {
            AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = (AppLovinInterstitialAdDialog) this.f141k.get();
            if (appLovinInterstitialAdDialog != null) {
                appLovinInterstitialAdDialog.dismiss();
            }
        }
    }
}
