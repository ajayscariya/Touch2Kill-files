package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

class bq implements AppLovinPostbackListener {
    final /* synthetic */ AppLovinPostbackListener f3919a;
    final /* synthetic */ PostbackServiceImpl f3920b;

    bq(PostbackServiceImpl postbackServiceImpl, AppLovinPostbackListener appLovinPostbackListener) {
        this.f3920b = postbackServiceImpl;
        this.f3919a = appLovinPostbackListener;
    }

    public void onPostbackFailure(String str, int i) {
        this.f3920b.f3887a.getLogger().m307e("PostbackService", "Failed to dispatch postback to URL " + str + ": " + i);
        if (this.f3919a != null) {
            this.f3919a.onPostbackFailure(str, i);
        }
    }

    public void onPostbackSuccess(String str) {
        this.f3920b.f3887a.getLogger().m306d("PostbackService", "Successfully dispatched postback to URL " + str);
        if (this.f3919a != null) {
            this.f3919a.onPostbackSuccess(str);
        }
    }
}
