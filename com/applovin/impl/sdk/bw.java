package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinLogger;

abstract class bw implements Runnable {
    final String f228e;
    protected final AppLovinSdkImpl f229f;
    final AppLovinLogger f230g;
    final Context f231h;

    bw(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f229f = appLovinSdkImpl;
        if (str == null) {
            str = getClass().getSimpleName();
        }
        this.f228e = str;
        this.f230g = appLovinSdkImpl.getLogger();
        this.f231h = appLovinSdkImpl.getApplicationContext();
    }

    String m154a() {
        return this.f228e;
    }

    void m155b() {
    }
}
