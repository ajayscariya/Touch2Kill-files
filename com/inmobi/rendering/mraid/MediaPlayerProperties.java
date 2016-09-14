package com.inmobi.rendering.mraid;

import java.util.Locale;

/* renamed from: com.inmobi.rendering.mraid.f */
public class MediaPlayerProperties {
    public String f1979a;
    public String f1980b;
    public String f1981c;
    public boolean f1982d;
    public boolean f1983e;
    public boolean f1984f;
    public boolean f1985g;

    public MediaPlayerProperties() {
        this.f1979a = "anonymous";
        this.f1980b = "fullscreen";
        this.f1981c = "exit";
        this.f1982d = true;
        this.f1983e = true;
        this.f1984f = false;
        this.f1985g = false;
    }

    public boolean m2083a() {
        return "fullscreen".equals(this.f1980b.toLowerCase(Locale.ENGLISH));
    }

    public boolean m2084b() {
        return "exit".equals(this.f1981c.toLowerCase(Locale.ENGLISH));
    }
}
