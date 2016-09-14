package com.applovin.impl.sdk;

public class bz implements Comparable {
    private static int f284a;
    private final int f285b;
    private final String f286c;
    private final Object f287d;

    static {
        f284a = 0;
    }

    private bz(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        } else {
            this.f286c = str;
            this.f287d = obj;
            this.f285b = f284a;
            f284a++;
        }
    }

    public int m159a() {
        return this.f285b;
    }

    Object m160a(Object obj) {
        return this.f287d.getClass().cast(obj);
    }

    public String m161b() {
        return this.f286c;
    }

    public Object m162c() {
        return this.f287d;
    }

    public int compareTo(Object obj) {
        return (obj == null || !(obj instanceof bz)) ? 0 : this.f286c.compareTo(((bz) obj).m161b());
    }
}
