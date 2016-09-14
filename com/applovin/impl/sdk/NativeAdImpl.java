package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

public class NativeAdImpl implements az, C1182y {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
    public static final AppLovinAdSize SIZE_NATIVE;
    public static final C0231c SPEC_NATIVE;
    public static final AppLovinAdType TYPE_NATIVE;
    private final AppLovinSdkImpl f4791a;
    private String f4792b;
    private String f4793c;
    private String f4794d;
    private String f4795e;
    private String f4796f;
    private String f4797g;
    private String f4798h;
    private String f4799i;
    private String f4800j;
    private String f4801k;
    private float f4802l;
    private String f4803m;
    private String f4804n;
    private String f4805o;
    private String f4806p;
    private String f4807q;
    private String f4808r;
    private long f4809s;

    static {
        SIZE_NATIVE = new AppLovinAdSize("NATIVE");
        TYPE_NATIVE = new AppLovinAdType("NATIVE");
        SPEC_NATIVE = new C0231c(SIZE_NATIVE, TYPE_NATIVE);
    }

    private NativeAdImpl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f, String str10, String str11, String str12, String str13, String str14, String str15, String str16, long j, AppLovinSdkImpl appLovinSdkImpl) {
        this.f4792b = str;
        this.f4793c = str2;
        this.f4794d = str3;
        this.f4795e = str4;
        this.f4796f = str5;
        this.f4797g = str6;
        this.f4798h = str7;
        this.f4800j = str8;
        this.f4801k = str9;
        this.f4802l = f;
        this.f4803m = str10;
        this.f4804n = str11;
        this.f4805o = str12;
        this.f4806p = str13;
        this.f4807q = str14;
        this.f4808r = str15;
        this.f4799i = str16;
        this.f4809s = j;
        this.f4791a = appLovinSdkImpl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        if (this.f4798h == null ? nativeAdImpl.f4798h != null : !this.f4798h.equals(nativeAdImpl.f4798h)) {
            return false;
        }
        if (this.f4808r == null ? nativeAdImpl.f4808r != null : !this.f4808r.equals(nativeAdImpl.f4808r)) {
            return false;
        }
        if (this.f4805o == null ? nativeAdImpl.f4805o != null : !this.f4805o.equals(nativeAdImpl.f4805o)) {
            return false;
        }
        if (this.f4799i == null ? nativeAdImpl.f4799i != null : !this.f4799i.equals(nativeAdImpl.f4799i)) {
            return false;
        }
        if (this.f4797g == null ? nativeAdImpl.f4797g != null : !this.f4797g.equals(nativeAdImpl.f4797g)) {
            return false;
        }
        if (this.f4804n == null ? nativeAdImpl.f4804n != null : !this.f4804n.equals(nativeAdImpl.f4804n)) {
            return false;
        }
        if (this.f4792b == null ? nativeAdImpl.f4792b != null : !this.f4792b.equals(nativeAdImpl.f4792b)) {
            return false;
        }
        if (this.f4793c == null ? nativeAdImpl.f4793c != null : !this.f4793c.equals(nativeAdImpl.f4793c)) {
            return false;
        }
        if (this.f4794d == null ? nativeAdImpl.f4794d != null : !this.f4794d.equals(nativeAdImpl.f4794d)) {
            return false;
        }
        if (this.f4795e == null ? nativeAdImpl.f4795e != null : !this.f4795e.equals(nativeAdImpl.f4795e)) {
            return false;
        }
        if (this.f4796f == null ? nativeAdImpl.f4796f != null : !this.f4796f.equals(nativeAdImpl.f4796f)) {
            return false;
        }
        if (this.f4807q == null ? nativeAdImpl.f4807q != null : !this.f4807q.equals(nativeAdImpl.f4807q)) {
            return false;
        }
        if (this.f4806p != null) {
            if (this.f4806p.equals(nativeAdImpl.f4806p)) {
                return true;
            }
        } else if (nativeAdImpl.f4806p == null) {
            return true;
        }
        return false;
    }

    public long getAdId() {
        return this.f4809s;
    }

    public String getCaptionText() {
        return this.f4798h;
    }

    public String getClCode() {
        return this.f4808r;
    }

    public String getClickUrl() {
        return this.f4805o;
    }

    public String getCtaText() {
        return this.f4799i;
    }

    public String getDescriptionText() {
        return this.f4797g;
    }

    public String getIconUrl() {
        return this.f4800j;
    }

    public String getImageUrl() {
        return this.f4801k;
    }

    public String getImpressionTrackingUrl() {
        return this.f4804n;
    }

    public String getSourceIconUrl() {
        return this.f4792b;
    }

    public String getSourceImageUrl() {
        return this.f4793c;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f4794d;
    }

    public String getSourceVideoUrl() {
        return this.f4795e;
    }

    public float getStarRating() {
        return this.f4802l;
    }

    public String getTitle() {
        return this.f4796f;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        if (this.f4807q == null) {
            return Uri.EMPTY.toString();
        }
        if (i < 0 || i > 100) {
            Log.e("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        return Uri.parse(this.f4807q).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString(z)).build().toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f4806p;
    }

    public String getVideoUrl() {
        return this.f4803m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f4807q != null ? this.f4807q.hashCode() : 0) + (((this.f4806p != null ? this.f4806p.hashCode() : 0) + (((this.f4805o != null ? this.f4805o.hashCode() : 0) + (((this.f4804n != null ? this.f4804n.hashCode() : 0) + (((this.f4799i != null ? this.f4799i.hashCode() : 0) + (((this.f4798h != null ? this.f4798h.hashCode() : 0) + (((this.f4797g != null ? this.f4797g.hashCode() : 0) + (((this.f4796f != null ? this.f4796f.hashCode() : 0) + (((this.f4795e != null ? this.f4795e.hashCode() : 0) + (((this.f4794d != null ? this.f4794d.hashCode() : 0) + (((this.f4793c != null ? this.f4793c.hashCode() : 0) + ((this.f4792b != null ? this.f4792b.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f4808r != null) {
            i = this.f4808r.hashCode();
        }
        return hashCode + i;
    }

    public boolean isImagePrecached() {
        boolean z = (this.f4800j == null || this.f4800j.equals(this.f4792b)) ? false : true;
        boolean z2 = (this.f4801k == null || this.f4801k.equals(this.f4793c)) ? false : true;
        return z && z2;
    }

    public boolean isVideoPrecached() {
        return (this.f4803m == null || this.f4803m.equals(this.f4795e)) ? false : true;
    }

    public void launchClickTarget(Context context) {
        this.f4791a.getPersistentPostbackManager().m139a(this.f4805o, null);
        AppLovinSdkUtils.openUrl(context, this.f4805o, this.f4791a);
    }

    public void setIconUrl(String str) {
        this.f4800j = str;
    }

    public void setImageUrl(String str) {
        this.f4801k = str;
    }

    public void setStarRating(float f) {
        this.f4802l = f;
    }

    public void setVideoUrl(String str) {
        this.f4803m = str;
    }

    public String toString() {
        return "WidgetSlot{clCode='" + this.f4808r + '\'' + ", sourceIconUrl='" + this.f4792b + '\'' + ", sourceImageUrl='" + this.f4793c + '\'' + ", sourceStarRatingImageUrl='" + this.f4794d + '\'' + ", sourceVideoUrl='" + this.f4795e + '\'' + ", title='" + this.f4796f + '\'' + ", descriptionText='" + this.f4797g + '\'' + ", captionText='" + this.f4798h + '\'' + ", ctaText='" + this.f4799i + '\'' + ", iconUrl='" + this.f4800j + '\'' + ", imageUrl='" + this.f4801k + '\'' + ", starRating='" + this.f4802l + '\'' + ", videoUrl='" + this.f4803m + '\'' + ", impressionTrackingUrl='" + this.f4804n + '\'' + ", clickUrl='" + this.f4805o + '\'' + ", videoStartTrackingUrl='" + this.f4806p + '\'' + ", videoEndTrackingUrl='" + this.f4807q + '\'' + '}';
    }
}
