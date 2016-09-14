package com.applovin.impl.sdk;

import java.lang.Thread.UncaughtExceptionHandler;

class cu implements UncaughtExceptionHandler {
    final /* synthetic */ ct f312a;

    cu(ct ctVar) {
        this.f312a = ctVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f312a.f310a.f302b.m308e("TaskManager", "Caught unhandled exception", th);
    }
}
