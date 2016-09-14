package com.applovin.impl.sdk;

import com.applovin.impl.adview.C0228v;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinAdImpl.Builder;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class cw extends bw implements dh {
    private final Collection f3936a;
    private final JSONObject f3937b;
    private final AppLovinAdLoadListener f3938c;
    private final C0246z f3939d;
    private boolean f3940i;
    private C0231c f3941j;

    cw(JSONObject jSONObject, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("RenderAd", appLovinSdkImpl);
        this.f3941j = new C0231c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
        this.f3937b = jSONObject;
        this.f3938c = appLovinAdLoadListener;
        this.f3936a = m4251d();
        this.f3939d = appLovinSdkImpl.getFileManager();
    }

    private float m4244a(String str, AppLovinAdType appLovinAdType, int i) {
        return appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? 0.5f : (appLovinAdType.equals(AppLovinAdType.REGULAR) && str != null && i == -1) ? 0.5f : 0.0f;
    }

    private C0228v m4245a(int i) {
        return i == 1 ? C0228v.WhiteXOnTransparentGrey : C0228v.WhiteXOnOpaqueBlack;
    }

    private C0228v m4246a(String str) {
        return str != null ? C0228v.WhiteXOnTransparentGrey : C0228v.WhiteXOnOpaqueBlack;
    }

    private String m4247a(String str, String str2) {
        File a = this.f3939d.m286a(str2.replace("/", "_"), this.f.getApplicationContext(), true);
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.g.m306d(this.e, "Loaded " + str2 + " from cache: file://" + a.getAbsolutePath());
            return "file://" + a.getAbsolutePath();
        }
        return this.f3939d.m294a(a, new StringBuilder().append(str).append(str2).toString()) ? "file://" + a.getAbsolutePath() : null;
    }

    private void m4248a(JSONObject jSONObject) {
        AppLovinAdSize fromString;
        String string = jSONObject.getString(Method.HTML);
        if (jSONObject.has("size")) {
            fromString = AppLovinAdSize.fromString(jSONObject.getString("size"));
        } else {
            fromString = AppLovinAdSize.BANNER;
        }
        String str = null;
        if (string == null || string.length() <= 0) {
            this.g.m307e(this.e, "No HTML received for requested ad");
            m4253c();
            return;
        }
        AdTarget valueOf;
        AppLovinAdType fromString2;
        String string2;
        int i;
        int i2;
        float f;
        C0228v a;
        String b = m4249b(string);
        if (jSONObject.has("ad_target")) {
            valueOf = AdTarget.valueOf(jSONObject.getString("ad_target").toUpperCase(Locale.ENGLISH));
        } else {
            valueOf = AdTarget.DEFAULT;
        }
        if (jSONObject.has("ad_type")) {
            fromString2 = AppLovinAdType.fromString(jSONObject.getString("ad_type").toUpperCase(Locale.ENGLISH));
        } else {
            fromString2 = AppLovinAdType.REGULAR;
        }
        this.f3941j = new C0231c(fromString, fromString2);
        if (jSONObject.has("video")) {
            string2 = jSONObject.getString("video");
            if (string2 == null || string2.isEmpty()) {
                string2 = null;
            } else {
                try {
                    str = this.f3939d.m287a(this.h, string2);
                    this.f3940i = true;
                    string2 = str;
                } catch (Exception e) {
                    string2 = str;
                }
            }
            if (string2 == null) {
                m4253c();
                return;
            }
            str = string2;
        }
        long j = -1;
        if (jSONObject.has("ad_id")) {
            j = jSONObject.getLong("ad_id");
        }
        if (jSONObject.has("countdown_length")) {
            try {
                i = jSONObject.getInt("countdown_length");
            } catch (JSONException e2) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (jSONObject.has("close_delay")) {
            try {
                i2 = jSONObject.getInt("close_delay");
            } catch (JSONException e3) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (jSONObject.has("close_delay_graphic")) {
            try {
                f = (float) jSONObject.getInt("close_delay_graphic");
            } catch (JSONException e4) {
                f = m4244a(str, fromString2, i2);
            }
        } else {
            f = m4244a(str, fromString2, i2);
        }
        if (jSONObject.has("close_style")) {
            try {
                a = m4245a(jSONObject.getInt("close_style"));
            } catch (JSONException e5) {
                a = m4246a(str);
            }
        } else {
            a = m4246a(str);
        }
        String str2 = XMLConstants.NULL_NS_URI;
        if (jSONObject.has("clcodes")) {
            try {
                string2 = ((JSONArray) jSONObject.get("clcodes")).getString(0);
            } catch (JSONException e6) {
                string2 = str2;
            }
        } else {
            string2 = str2;
        }
        str2 = XMLConstants.NULL_NS_URI;
        if (jSONObject.has("video_end_url")) {
            try {
                str2 = jSONObject.getString("video_end_url");
            } catch (Exception e7) {
            }
        }
        String str3 = XMLConstants.NULL_NS_URI;
        if (jSONObject.has("mute_image")) {
            try {
                str3 = this.f.getFileManager().m288a(this.h, jSONObject.getString("mute_image"), false);
            } catch (Exception e8) {
            }
        }
        String str4 = XMLConstants.NULL_NS_URI;
        if (jSONObject.has("unmute_image")) {
            try {
                str4 = this.f.getFileManager().m288a(this.h, jSONObject.getString("unmute_image"), false);
            } catch (Exception e9) {
            }
        }
        String str5 = XMLConstants.NULL_NS_URI;
        if (jSONObject.has("click_tracking_url")) {
            try {
                str5 = jSONObject.getString("click_tracking_url");
            } catch (Exception e10) {
            }
        }
        m4252a(new Builder().setHtml(b).setSize(fromString).setType(fromString2).setVideoFilename(str).setTarget(valueOf).setCloseStyle(a).setVideoCloseDelay((float) i2).setCloseDelay(f).setCountdownLength(i).setCurrentAdIdNumber(j).setClCode(string2).setCompletionUrl(str2).setSupplementalClickTrackingUrl(str5).setMuteImageFilename(str3).setUnmuteImageFilename(str4).build());
    }

    private String m4249b(String str) {
        return ((Boolean) this.f.m4161a(bx.f233B)).booleanValue() ? m4250c(str) : str;
    }

    private String m4250c(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (String str2 : ((String) this.f.m4161a(bx.f234C)).split(",")) {
            int i = 0;
            int i2 = 0;
            while (i2 < stringBuilder.length()) {
                i2 = stringBuilder.indexOf(str2, i);
                if (i2 == -1) {
                    break;
                }
                int length = stringBuilder.length();
                i = i2;
                while (!this.f3936a.contains(Character.valueOf(stringBuilder.charAt(i))) && i < length) {
                    i++;
                }
                if (i <= i2 || i == length) {
                    this.g.m306d(this.e, "Unable to cache resource; ad HTML is invalid.");
                } else {
                    String a = m4247a(str2, stringBuilder.substring(str2.length() + i2, i));
                    if (a != null) {
                        stringBuilder.replace(i2, i, a);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private Collection m4251d() {
        Collection hashSet = new HashSet();
        for (char valueOf : ((String) this.f.m4161a(bx.ac)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add(Character.valueOf('\"'));
        return hashSet;
    }

    void m4252a(AppLovinAd appLovinAd) {
        this.f.getLogger().m306d(m154a(), "Rendered new ad:" + appLovinAd);
        if (this.f3938c != null) {
            this.f3938c.adReceived(appLovinAd);
        }
    }

    void m4253c() {
        try {
            if (this.f3938c == null) {
                return;
            }
            if (this.f3938c instanceof C1181x) {
                ((C1181x) this.f3938c).m4307a(this.f3941j, -6);
            } else {
                this.f3938c.failedToReceiveAd(-6);
            }
        } catch (Throwable th) {
            this.g.m308e(this.e, "Unable process a failure to receive an ad", th);
        }
    }

    public String m4254e() {
        return "tRA";
    }

    public boolean m4255f() {
        return this.f3940i;
    }

    public void run() {
        this.g.m306d(this.e, "Rendering ad...");
        try {
            m4248a(this.f3937b);
        } catch (Throwable e) {
            this.g.m308e(this.e, "Unable to parse ad service response", e);
            m4253c();
        } catch (Throwable e2) {
            this.g.m308e(this.e, "Ad response is not valid", e2);
            m4253c();
        } catch (Throwable e22) {
            this.g.m308e(this.e, "Unable to render ad", e22);
            m4253c();
        }
    }
}
