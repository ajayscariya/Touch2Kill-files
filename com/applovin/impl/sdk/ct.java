package com.applovin.impl.sdk;

import java.util.concurrent.ThreadFactory;

class ct implements ThreadFactory {
    final /* synthetic */ cr f310a;
    private final String f311b;

    public ct(cr crVar, String str) {
        this.f310a = crVar;
        this.f311b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f311b + ":" + di.m4282a(this.f310a.f301a.getSdkKey()));
        thread.setDaemon(true);
        thread.setPriority(10);
        thread.setUncaughtExceptionHandler(new cu(this));
        return thread;
    }
}
