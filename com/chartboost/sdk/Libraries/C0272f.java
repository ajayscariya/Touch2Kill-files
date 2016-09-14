package com.chartboost.sdk.Libraries;

/* renamed from: com.chartboost.sdk.Libraries.f */
public enum C0272f {
    PORTRAIT,
    LANDSCAPE,
    PORTRAIT_REVERSE,
    LANDSCAPE_REVERSE;
    
    public static final C0272f f484e;
    public static final C0272f f485f;
    public static final C0272f f486g;
    public static final C0272f f487h;

    static {
        f484e = PORTRAIT_REVERSE;
        f485f = PORTRAIT;
        f486g = LANDSCAPE;
        f487h = LANDSCAPE_REVERSE;
    }

    public boolean m469a() {
        return this == PORTRAIT || this == PORTRAIT_REVERSE;
    }

    public boolean m470b() {
        return this == LANDSCAPE || this == LANDSCAPE_REVERSE;
    }
}
