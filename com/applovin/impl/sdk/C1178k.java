package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinLogger;
import mf.javax.xml.XMLConstants;

/* renamed from: com.applovin.impl.sdk.k */
class C1178k implements AppLovinLogger {
    private ca f3964a;
    private C0236l f3965b;

    C1178k() {
    }

    void m4294a(ca caVar) {
        this.f3964a = caVar;
    }

    void m4295a(C0236l c0236l) {
        this.f3965b = c0236l;
    }

    boolean m4296a() {
        return this.f3964a != null ? ((Boolean) this.f3964a.m169a(bx.f266i)).booleanValue() : false;
    }

    public void m4297d(String str, String str2) {
        if (m4296a()) {
            Log.d(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f3965b != null) {
            this.f3965b.m246a("DEBUG  [" + str + "] " + str2);
        }
    }

    public void m4298e(String str, String str2) {
        m4299e(str, str2, null);
    }

    public void m4299e(String str, String str2, Throwable th) {
        if (m4296a()) {
            Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f3965b != null) {
            this.f3965b.m246a("ERROR  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : XMLConstants.NULL_NS_URI));
        }
    }

    public void m4300i(String str, String str2) {
        if (m4296a()) {
            Log.i(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f3965b != null) {
            this.f3965b.m246a("INFO  [" + str + "] " + str2);
        }
    }

    public void userError(String str, String str2) {
        userError(str, str2, null);
    }

    public void userError(String str, String str2, Throwable th) {
        Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        if (this.f3965b != null) {
            this.f3965b.m246a("USER  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : XMLConstants.NULL_NS_URI));
        }
    }

    public void m4301w(String str, String str2) {
        m4302w(str, str2, null);
    }

    public void m4302w(String str, String str2, Throwable th) {
        if (m4296a()) {
            Log.w(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f3965b != null) {
            this.f3965b.m246a("WARN  [" + str + "] " + str2);
        }
    }
}
