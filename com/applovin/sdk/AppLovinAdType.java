package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED;
    public static final AppLovinAdType REGULAR;
    private final String f367a;

    static {
        REGULAR = new AppLovinAdType("REGULAR");
        INCENTIVIZED = new AppLovinAdType("VIDEOA");
    }

    public AppLovinAdType(String str) {
        this.f367a = str;
    }

    public static Set allTypes() {
        Set hashSet = new HashSet(2);
        hashSet.add(REGULAR);
        hashSet.add(INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String str) {
        return str.toUpperCase(Locale.ENGLISH).equals(INCENTIVIZED.getLabel()) ? INCENTIVIZED : REGULAR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdType appLovinAdType = (AppLovinAdType) obj;
        if (this.f367a != null) {
            if (this.f367a.equals(appLovinAdType.f367a)) {
                return true;
            }
        } else if (appLovinAdType.f367a == null) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this.f367a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode() {
        return this.f367a != null ? this.f367a.hashCode() : 0;
    }

    public String toString() {
        return getLabel();
    }
}
