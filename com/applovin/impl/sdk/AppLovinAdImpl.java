package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.C0228v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import mf.javax.xml.XMLConstants;

public class AppLovinAdImpl implements az, AppLovinAd {
    private final AppLovinAdSize f3842a;
    private final AppLovinAdType f3843b;
    private final long f3844c;
    private final String f3845d;
    private final AdTarget f3846e;
    private final String f3847f;
    private final String f3848g;
    private final float f3849h;
    private final float f3850i;
    private final int f3851j;
    private final String f3852k;
    private final String f3853l;
    private final String f3854m;
    private final String f3855n;
    private final C0228v f3856o;

    public enum AdTarget {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class Builder {
        private String f113a;
        private AppLovinAdSize f114b;
        private AppLovinAdType f115c;
        private String f116d;
        private AdTarget f117e;
        private C0228v f118f;
        private float f119g;
        private float f120h;
        private int f121i;
        private long f122j;
        private String f123k;
        private String f124l;
        private String f125m;
        private String f126n;
        private String f127o;

        public AppLovinAdImpl build() {
            return new AppLovinAdImpl(this.f114b, this.f115c, this.f116d, this.f117e, this.f118f, this.f119g, this.f120h, this.f121i, this.f122j, this.f123k, this.f124l, this.f125m, this.f126n, this.f127o, null);
        }

        public Builder setClCode(String str) {
            this.f123k = str;
            return this;
        }

        public Builder setCloseDelay(float f) {
            this.f120h = f;
            return this;
        }

        public Builder setCloseStyle(C0228v c0228v) {
            this.f118f = c0228v;
            return this;
        }

        public Builder setCompletionUrl(String str) {
            this.f124l = str;
            return this;
        }

        public Builder setCountdownLength(int i) {
            this.f121i = i;
            return this;
        }

        public Builder setCurrentAdIdNumber(long j) {
            this.f122j = j;
            return this;
        }

        public Builder setHtml(String str) {
            this.f113a = str;
            return this;
        }

        public Builder setMuteImageFilename(String str) {
            this.f126n = str;
            return this;
        }

        public Builder setSize(AppLovinAdSize appLovinAdSize) {
            this.f114b = appLovinAdSize;
            return this;
        }

        public Builder setSupplementalClickTrackingUrl(String str) {
            this.f125m = str;
            return this;
        }

        public Builder setTarget(AdTarget adTarget) {
            this.f117e = adTarget;
            return this;
        }

        public Builder setType(AppLovinAdType appLovinAdType) {
            this.f115c = appLovinAdType;
            return this;
        }

        public Builder setUnmuteImageFilename(String str) {
            this.f127o = str;
            return this;
        }

        public Builder setVideoCloseDelay(float f) {
            this.f119g = f;
            return this;
        }

        public Builder setVideoFilename(String str) {
            this.f116d = str;
            return this;
        }
    }

    private AppLovinAdImpl(String str, AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str2, AdTarget adTarget, C0228v c0228v, float f, float f2, int i, long j, String str3, String str4, String str5, String str6, String str7) {
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No size specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No type specified");
        } else {
            this.f3842a = appLovinAdSize;
            this.f3843b = appLovinAdType;
            this.f3845d = str2;
            this.f3844c = j;
            this.f3848g = str;
            this.f3846e = adTarget;
            this.f3849h = f;
            this.f3851j = i;
            this.f3847f = str3;
            this.f3856o = c0228v;
            this.f3850i = f2;
            this.f3852k = str4;
            this.f3853l = str5;
            this.f3854m = str6;
            this.f3855n = str7;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) obj;
        if (this.f3844c != appLovinAdImpl.f3844c || Float.compare(appLovinAdImpl.f3849h, this.f3849h) != 0 || Float.compare(appLovinAdImpl.f3850i, this.f3850i) != 0 || this.f3851j != appLovinAdImpl.f3851j) {
            return false;
        }
        if (this.f3842a != null) {
            if (!this.f3842a.equals(appLovinAdImpl.f3842a)) {
                return false;
            }
        } else if (appLovinAdImpl.f3842a != null) {
            return false;
        }
        if (this.f3843b != null) {
            if (!this.f3843b.equals(appLovinAdImpl.f3843b)) {
                return false;
            }
        } else if (appLovinAdImpl.f3843b != null) {
            return false;
        }
        if (this.f3845d != null) {
            if (!this.f3845d.equals(appLovinAdImpl.f3845d)) {
                return false;
            }
        } else if (appLovinAdImpl.f3845d != null) {
            return false;
        }
        if (this.f3846e != appLovinAdImpl.f3846e) {
            return false;
        }
        if (this.f3847f != null) {
            if (!this.f3847f.equals(appLovinAdImpl.f3847f)) {
                return false;
            }
        } else if (appLovinAdImpl.f3847f != null) {
            return false;
        }
        if (this.f3848g != null) {
            if (!this.f3848g.equals(appLovinAdImpl.f3848g)) {
                return false;
            }
        } else if (appLovinAdImpl.f3848g != null) {
            return false;
        }
        if (this.f3852k != null) {
            if (!this.f3852k.equals(appLovinAdImpl.f3852k)) {
                return false;
            }
        } else if (appLovinAdImpl.f3852k != null) {
            return false;
        }
        if (this.f3853l != null) {
            if (!this.f3853l.equals(appLovinAdImpl.f3853l)) {
                return false;
            }
        } else if (appLovinAdImpl.f3853l != null) {
            return false;
        }
        if (this.f3854m != null) {
            if (!this.f3854m.equals(appLovinAdImpl.f3854m)) {
                return false;
            }
        } else if (appLovinAdImpl.f3854m != null) {
            return false;
        }
        if (this.f3855n != null) {
            if (!this.f3855n.equals(appLovinAdImpl.f3855n)) {
                return false;
            }
        } else if (appLovinAdImpl.f3855n != null) {
            return false;
        }
        if (this.f3856o != appLovinAdImpl.f3856o) {
            z = false;
        }
        return z;
    }

    public long getAdIdNumber() {
        return this.f3844c;
    }

    public String getClCode() {
        return this.f3847f;
    }

    public float getCloseDelay() {
        return this.f3850i;
    }

    public C0228v getCloseStyle() {
        return this.f3856o;
    }

    public String getCompletionUrl() {
        return this.f3852k;
    }

    public int getCountdownLength() {
        return this.f3851j;
    }

    public String getHtmlSource() {
        return this.f3848g;
    }

    public String getMuteImageFilename() {
        return this.f3854m;
    }

    public String getParametrizedCompletionUrl(int i, String str) {
        String completionUrl = getCompletionUrl();
        return AppLovinSdkUtils.isValidString(completionUrl) ? di.m4285a(str, Uri.parse(completionUrl.replace("{CLCODE}", getClCode())).buildUpon().appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).build().toString()) : XMLConstants.NULL_NS_URI;
    }

    public AppLovinAdSize getSize() {
        return this.f3842a;
    }

    public String getSupplementalClickTrackingUrl() {
        return getSupplementalClickTrackingUrl(null);
    }

    public String getSupplementalClickTrackingUrl(String str) {
        String str2 = this.f3853l;
        return AppLovinSdkUtils.isValidString(str2) ? di.m4285a(str, str2.replace("{CLCODE}", getClCode())) : XMLConstants.NULL_NS_URI;
    }

    public AdTarget getTarget() {
        return this.f3846e;
    }

    public AppLovinAdType getType() {
        return this.f3843b;
    }

    public String getUnmuteImageFilename() {
        return this.f3855n;
    }

    public float getVideoCloseDelay() {
        return this.f3849h;
    }

    public String getVideoFilename() {
        return this.f3845d;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3855n != null ? this.f3855n.hashCode() : 0) + (((this.f3854m != null ? this.f3854m.hashCode() : 0) + (((this.f3853l != null ? this.f3853l.hashCode() : 0) + (((this.f3852k != null ? this.f3852k.hashCode() : 0) + (((((this.f3850i != 0.0f ? Float.floatToIntBits(this.f3850i) : 0) + (((this.f3849h != 0.0f ? Float.floatToIntBits(this.f3849h) : 0) + (((this.f3848g != null ? this.f3848g.hashCode() : 0) + (((this.f3847f != null ? this.f3847f.hashCode() : 0) + (((this.f3846e != null ? this.f3846e.hashCode() : 0) + (((this.f3845d != null ? this.f3845d.hashCode() : 0) + (((((this.f3843b != null ? this.f3843b.hashCode() : 0) + ((this.f3842a != null ? this.f3842a.hashCode() : 0) * 31)) * 31) + ((int) (this.f3844c ^ (this.f3844c >>> 32)))) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.f3851j) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3856o != null) {
            i = this.f3856o.hashCode();
        }
        return hashCode + i;
    }

    public boolean isVideoAd() {
        return AppLovinSdkUtils.isValidString(this.f3845d);
    }

    public String toString() {
        return "AppLovinAdImpl{size=" + this.f3842a + ", type=" + this.f3843b + ", adIdNumber=" + this.f3844c + ", videoFilename='" + this.f3845d + '\'' + ", target=" + this.f3846e + ", clCode='" + this.f3847f + '\'' + ", htmlSource='" + this.f3848g + '\'' + ", videoCloseDelay=" + this.f3849h + ", closeDelay=" + this.f3850i + ", countdownLength=" + this.f3851j + ", completionUrl='" + this.f3852k + '\'' + ", supplementalClickTrackingUrl='" + this.f3853l + '\'' + ", muteImageFilename='" + this.f3854m + '\'' + ", unmuteImageFilename='" + this.f3855n + '\'' + ", closeStyle=" + this.f3856o + '}';
    }
}
