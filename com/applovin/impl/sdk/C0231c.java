package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

/* renamed from: com.applovin.impl.sdk.c */
public class C0231c {
    private AppLovinAdSize f288a;
    private AppLovinAdType f289b;

    public C0231c(AppLovinAd appLovinAd) {
        this.f288a = appLovinAd.getSize();
        this.f289b = appLovinAd.getType();
    }

    public C0231c(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        this.f288a = appLovinAdSize;
        this.f289b = appLovinAdType;
    }

    public AppLovinAdSize m163a() {
        return this.f288a;
    }

    public AppLovinAdType m164b() {
        return this.f289b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0231c c0231c = (C0231c) obj;
        if (this.f288a == null ? c0231c.f288a != null : !this.f288a.equals(c0231c.f288a)) {
            if (this.f289b != null) {
                if (this.f289b.equals(c0231c.f289b)) {
                    return true;
                }
            } else if (c0231c.f289b == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f288a != null ? this.f288a.hashCode() : 0) * 31;
        if (this.f289b != null) {
            i = this.f289b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AdSpec{size=" + this.f288a + ", type=" + this.f289b + '}';
    }
}
