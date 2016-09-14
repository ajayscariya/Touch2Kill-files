package com.startapp.android.publish.p012f.p013a.p019f;

/* renamed from: com.startapp.android.publish.f.a.f.a */
public class StartAppSDK {
    private final com.startapp.android.publish.p012f.p013a.p018e.StartAppSDK f3268a;
    private final com.startapp.android.publish.p012f.p013a.p017d.StartAppSDK f3269b;
    private final String f3270c;

    public StartAppSDK(com.startapp.android.publish.p012f.p013a.p018e.StartAppSDK startAppSDK, com.startapp.android.publish.p012f.p013a.p017d.StartAppSDK startAppSDK2, String str) {
        this.f3268a = startAppSDK;
        this.f3269b = startAppSDK2;
        this.f3270c = str;
    }

    public String m3095a(com.startapp.android.publish.p012f.p013a.p014a.StartAppSDK startAppSDK, long j) {
        try {
            return j + "-" + this.f3270c + "-" + this.f3269b.m3086a(this.f3268a.m3087a(startAppSDK));
        } catch (Throwable th) {
            return null;
        }
    }
}
