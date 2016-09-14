package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

class ab implements AppLovinAdRewardListener {
    final /* synthetic */ aa f3888a;

    ab(aa aaVar) {
        this.f3888a = aaVar;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        this.f3888a.f131a.getLogger().m306d("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f3888a.f131a.getLogger().m306d("IncentivizedAdController", "User over quota: " + map);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f3888a.f131a.getLogger().m306d("IncentivizedAdController", "Reward rejected: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f3888a.f131a.getLogger().m306d("IncentivizedAdController", "Reward validated: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f3888a.f131a.getLogger().m306d("IncentivizedAdController", "Reward validation failed: " + i);
    }
}
