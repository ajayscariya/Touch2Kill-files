package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Map;

class af implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
    final /* synthetic */ aa f3891a;
    private final Activity f3892b;
    private final AppLovinAdDisplayListener f3893c;
    private final AppLovinAdClickListener f3894d;
    private final AppLovinAdVideoPlaybackListener f3895e;
    private final AppLovinAdRewardListener f3896f;

    private af(aa aaVar, Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f3891a = aaVar;
        this.f3893c = appLovinAdDisplayListener;
        this.f3894d = appLovinAdClickListener;
        this.f3895e = appLovinAdVideoPlaybackListener;
        this.f3896f = appLovinAdRewardListener;
        this.f3892b = activity;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f3894d != null) {
            this.f3891a.f136f.post(new ai(this, appLovinAd));
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        if (this.f3893c != null) {
            this.f3893c.adDisplayed(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        String c = this.f3891a.m77c();
        if (c == null || !this.f3891a.f140j) {
            String str;
            int i;
            this.f3891a.f139i.m5687a(true);
            if (this.f3891a.f140j) {
                str = "network_timeout";
                i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
            } else {
                str = "user_closed_video";
                i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
            }
            bm.m121a().m123a(appLovinAd, str);
            if (this.f3891a.f140j) {
                this.f3891a.m74a(c, this.f3892b);
            }
            this.f3891a.f136f.post(new ag(this, appLovinAd, i));
        } else {
            this.f3891a.m74a(c, this.f3892b);
        }
        if (this.f3893c != null) {
            this.f3891a.f136f.post(new ah(this, appLovinAd));
        }
        this.f3891a.f131a.m4160a().m233a(new da(this.f3891a.f131a, appLovinAd), cs.BACKGROUND);
        this.f3891a.f133c = null;
        this.f3891a.f134d = null;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f3891a.m76b("quota_exceeded");
        if (this.f3896f != null) {
            this.f3891a.f136f.post(new am(this, appLovinAd, map));
        }
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f3891a.m76b("rejected");
        if (this.f3896f != null) {
            this.f3891a.f136f.post(new an(this, appLovinAd, map));
        }
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f3891a.m76b("accepted");
        if (this.f3896f != null) {
            this.f3891a.f136f.post(new al(this, appLovinAd, map));
        }
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f3891a.m76b("network_timeout");
        if (this.f3896f != null) {
            this.f3891a.f136f.post(new ao(this, appLovinAd, i));
        }
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f3895e != null) {
            this.f3891a.f136f.post(new aj(this, appLovinAd));
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f3895e != null) {
            this.f3891a.f136f.post(new ak(this, appLovinAd, d, z));
        }
        this.f3891a.f140j = z;
    }
}
