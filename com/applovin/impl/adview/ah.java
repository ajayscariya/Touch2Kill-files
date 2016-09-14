package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0237n;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ah implements AppLovinInterstitialAdDialog {
    public static volatile boolean f3794a;
    public static volatile boolean f3795b;
    private static final Map f3796c;
    private static volatile boolean f3797o;
    private final String f3798d;
    private final AppLovinSdkImpl f3799e;
    private final WeakReference f3800f;
    private volatile AppLovinAdLoadListener f3801g;
    private volatile AppLovinAdDisplayListener f3802h;
    private volatile AppLovinAdVideoPlaybackListener f3803i;
    private volatile AppLovinAdClickListener f3804j;
    private volatile AppLovinAdImpl f3805k;
    private volatile AdTarget f3806l;
    private volatile C0229w f3807m;
    private volatile String f3808n;

    static {
        f3796c = Collections.synchronizedMap(new HashMap());
        f3794a = false;
        f3795b = false;
    }

    ah(AppLovinSdk appLovinSdk, Activity activity) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f3799e = (AppLovinSdkImpl) appLovinSdk;
            this.f3798d = UUID.randomUUID().toString();
            f3794a = true;
            f3795b = false;
            this.f3800f = new WeakReference(activity);
        }
    }

    public static ah m4082a(String str) {
        return (ah) f3796c.get(str);
    }

    private void m4084a(int i) {
        Activity i2 = m4094i();
        if (i2 != null) {
            i2.runOnUiThread(new al(this, i));
        } else {
            this.f3799e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        }
    }

    private void m4085a(Activity activity) {
        Object c1172x = new C1172x(this.f3799e, activity);
        c1172x.m4138a(this);
        this.f3807m = c1172x;
        c1172x.m4139a(this.f3805k, this.f3808n);
    }

    private void m4089a(AppLovinAd appLovinAd) {
        if (this.f3802h != null) {
            this.f3802h.adHidden(appLovinAd);
        }
    }

    private void m4091b(Activity activity) {
        Intent intent = new Intent(activity, AppLovinInterstitialActivity.class);
        intent.putExtra(AppLovinInterstitialActivity.KEY_WRAPPER_ID, this.f3798d);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        activity.startActivity(intent);
        m4097a(true);
    }

    private void m4093b(AppLovinAd appLovinAd) {
        Activity i = m4094i();
        if (i != null) {
            i.runOnUiThread(new ak(this, appLovinAd));
        } else {
            this.f3799e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        }
    }

    private Activity m4094i() {
        return this.f3800f != null ? (Activity) this.f3800f.get() : null;
    }

    public AppLovinSdk m4095a() {
        return this.f3799e;
    }

    public void m4096a(C0229w c0229w) {
        this.f3807m = c0229w;
    }

    public void m4097a(boolean z) {
        f3797o = z;
    }

    public AppLovinAd m4098b() {
        return this.f3805k;
    }

    public AppLovinAdVideoPlaybackListener m4099c() {
        return this.f3803i;
    }

    public AppLovinAdDisplayListener m4100d() {
        return this.f3802h;
    }

    public void dismiss() {
        Activity i = m4094i();
        if (i == null) {
            this.f3799e.getLogger().userError("InterstitialAdDialogWrapper", "Failed to notify load listener: activity reference is stale");
        } else if (this.f3807m != null) {
            i.runOnUiThread(new am(this));
        }
    }

    public AppLovinAdClickListener m4101e() {
        return this.f3804j;
    }

    public AdTarget m4102f() {
        return this.f3806l;
    }

    public String m4103g() {
        return this.f3808n;
    }

    public void m4104h() {
        f3794a = false;
        f3795b = true;
        f3796c.remove(this.f3798d);
    }

    public boolean isAdReadyToDisplay() {
        return this.f3799e.getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing() {
        return f3797o;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f3804j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f3802h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f3801g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f3803i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        show(null);
    }

    public void show(String str) {
        this.f3799e.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new ai(this, str));
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        showAndRender(appLovinAd, null);
    }

    public void showAndRender(AppLovinAd appLovinAd, String str) {
        if (isShowing()) {
            this.f3799e.getLogger().userError("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
            return;
        }
        f3796c.put(this.f3798d, this);
        this.f3805k = (AppLovinAdImpl) appLovinAd;
        this.f3808n = str;
        this.f3806l = this.f3805k != null ? this.f3805k.getTarget() : AdTarget.DEFAULT;
        Context i = m4094i();
        if (i == null) {
            this.f3799e.getLogger().m307e("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            m4089a(appLovinAd);
        } else if (!AppLovinSdkUtils.isValidString(this.f3805k.getVideoFilename()) || this.f3799e.getFileManager().m295a(this.f3805k.getVideoFilename(), i)) {
            boolean a = C0237n.m249a(AppLovinInterstitialActivity.class, i);
            boolean z = this.f3806l == AdTarget.ACTIVITY_LANDSCAPE || this.f3806l == AdTarget.ACTIVITY_PORTRAIT;
            i.runOnUiThread(new aj(this, a, z, i));
        } else {
            m4089a(appLovinAd);
        }
    }
}
