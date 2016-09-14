package com.startapp.android.publish.p012f.p013a.p017d;

import java.util.regex.Pattern;

/* renamed from: com.startapp.android.publish.f.a.d.d */
public class StartAppSDK implements StartAppSDK {
    private final Pattern f4717a;
    private final Pattern f4718b;
    private final Pattern f4719c;
    private final Pattern f4720d;
    private final Pattern f4721e;
    private final Pattern f4722f;

    public StartAppSDK() {
        this.f4717a = Pattern.compile("\\+");
        this.f4718b = Pattern.compile("/");
        this.f4719c = Pattern.compile("=");
        this.f4720d = Pattern.compile("_");
        this.f4721e = Pattern.compile("\\*");
        this.f4722f = Pattern.compile("#");
    }

    public String m5459a(String str) {
        return this.f4719c.matcher(this.f4718b.matcher(this.f4717a.matcher(str).replaceAll("_")).replaceAll("*")).replaceAll("#");
    }
}
