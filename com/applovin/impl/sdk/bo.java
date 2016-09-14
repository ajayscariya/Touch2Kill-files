package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

class bo implements AppLovinPostbackListener {
    final /* synthetic */ bp f3917a;
    final /* synthetic */ bn f3918b;

    bo(bn bnVar, bp bpVar) {
        this.f3918b = bnVar;
        this.f3917a = bpVar;
    }

    public void onPostbackFailure(String str, int i) {
        this.f3918b.f212b.m309i("PersistentPostbackManager", "Failed to submit postback with errorCode " + i + ". Will retry later...  Postback: " + this.f3917a);
        this.f3918b.m136e(this.f3917a);
    }

    public void onPostbackSuccess(String str) {
        this.f3918b.m135d(this.f3917a);
        this.f3918b.f212b.m306d("PersistentPostbackManager", "Successfully submitted postback: " + this.f3917a);
        this.f3918b.m140b();
    }
}
