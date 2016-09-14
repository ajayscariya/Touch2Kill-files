package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.Timer;

class ar {
    private final AppLovinSdkImpl f175a;
    private final aa f176b;
    private Activity f177c;
    private AppLovinAdDisplayListener f178d;
    private AppLovinAdVideoPlaybackListener f179e;
    private AppLovinAdClickListener f180f;
    private AppLovinAdRewardListener f181g;
    private final Timer f182h;

    ar(AppLovinSdkImpl appLovinSdkImpl, aa aaVar) {
        this.f182h = new Timer("IncentivizedAdLauncher");
        this.f175a = appLovinSdkImpl;
        this.f176b = aaVar;
    }

    private void m86b() {
        this.f176b.m69a(this.f177c, this.f181g, this.f179e, this.f178d, this.f180f);
    }

    void m91a() {
        this.f177c.runOnUiThread(new as(this));
    }

    public void m92a(Activity activity) {
        this.f177c = activity;
    }

    public void m93a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f180f = appLovinAdClickListener;
    }

    public void m94a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f178d = appLovinAdDisplayListener;
    }

    public void m95a(AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f181g = appLovinAdRewardListener;
    }

    public void m96a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f179e = appLovinAdVideoPlaybackListener;
    }
}
