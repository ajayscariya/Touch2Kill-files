package com.jirbo.adcolony;

import com.jirbo.adcolony.C0756n.C0730a;
import com.jirbo.adcolony.C0756n.ad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

public abstract class AdColonyAd implements Serializable {
    static final int f2203a = 0;
    static final int f2204b = 1;
    static final int f2205c = 2;
    static final int f2206d = 3;
    static final int f2207e = 4;
    HashMap<String, String> f2208A;
    HashMap<String, ArrayList<String>> f2209B;
    int f2210f;
    int f2211g;
    String f2212h;
    ad f2213i;
    C0730a f2214j;
    String f2215k;
    String f2216l;
    String f2217m;
    String f2218n;
    String f2219o;
    double f2220p;
    double f2221q;
    int f2222r;
    boolean f2223s;
    boolean f2224t;
    boolean f2225u;
    boolean f2226v;
    boolean f2227w;
    AdColonyNativeAdView f2228x;
    AdColonyAdListener f2229y;
    AdColonyIAPEngagement f2230z;

    abstract void m2419a();

    abstract boolean m2420a(boolean z);

    abstract boolean m2421b();

    abstract boolean isReady();

    public AdColonyAd() {
        this.f2210f = f2203a;
        this.f2215k = XMLConstants.NULL_NS_URI;
        this.f2216l = XMLConstants.NULL_NS_URI;
        this.f2217m = XMLConstants.NULL_NS_URI;
        this.f2218n = XMLConstants.NULL_NS_URI;
        this.f2219o = XMLConstants.NULL_NS_URI;
        this.f2220p = 0.0d;
        this.f2221q = 0.0d;
        this.f2230z = AdColonyIAPEngagement.NONE;
        this.f2208A = new HashMap();
        this.f2209B = new HashMap();
    }

    public boolean shown() {
        return this.f2210f == f2207e;
    }

    public boolean notShown() {
        return this.f2210f != f2207e;
    }

    public boolean canceled() {
        return this.f2210f == f2204b;
    }

    public boolean noFill() {
        return this.f2210f == f2205c;
    }

    public boolean skipped() {
        return this.f2210f == f2206d;
    }

    public boolean iapEnabled() {
        return this.f2226v;
    }

    public AdColonyIAPEngagement iapEngagementType() {
        return this.f2230z;
    }

    public String iapProductID() {
        return this.f2218n;
    }

    public int getAvailableViews() {
        if (isReady() && m2423c()) {
            return this.f2213i.m2704f();
        }
        return f2203a;
    }

    boolean m2423c() {
        return m2422b(false);
    }

    boolean m2422b(boolean z) {
        if (this.f2210f == f2207e) {
            return true;
        }
        if (!isReady() && !z) {
            return false;
        }
        if (!m2420a(true) && z) {
            return false;
        }
        this.f2213i = C0694a.f2372l.m2576g(this.f2212h);
        this.f2214j = z ? this.f2213i.m2710l() : this.f2213i.m2709k();
        if (this.f2214j == null) {
            return false;
        }
        this.f2208A.put("replay", this.f2214j.f2651x.f2706a);
        this.f2208A.put("card_shown", this.f2214j.f2651x.f2707b);
        this.f2208A.put("html5_interaction", this.f2214j.f2651x.f2708c);
        this.f2208A.put("cancel", this.f2214j.f2651x.f2709d);
        this.f2208A.put("download", this.f2214j.f2651x.f2710e);
        this.f2208A.put(SchemaSymbols.ATTVAL_SKIP, this.f2214j.f2651x.f2711f);
        this.f2208A.put("info", this.f2214j.f2651x.f2712g);
        this.f2208A.put("custom_event", this.f2214j.f2651x.f2713h);
        this.f2208A.put("midpoint", this.f2214j.f2651x.f2714i);
        this.f2208A.put("card_dissolved", this.f2214j.f2651x.f2715j);
        this.f2208A.put("start", this.f2214j.f2651x.f2716k);
        this.f2208A.put("third_quartile", this.f2214j.f2651x.f2717l);
        this.f2208A.put("complete", this.f2214j.f2651x.f2718m);
        this.f2208A.put("continue", this.f2214j.f2651x.f2719n);
        this.f2208A.put("in_video_engagement", this.f2214j.f2651x.f2720o);
        this.f2208A.put("reward_v4vc", this.f2214j.f2651x.f2721p);
        this.f2208A.put("v4iap", this.f2214j.f2651x.f2722q);
        this.f2208A.put("first_quartile", this.f2214j.f2651x.f2723r);
        this.f2208A.put("video_expanded", this.f2214j.f2651x.f2724s);
        this.f2208A.put("sound_mute", this.f2214j.f2651x.f2725t);
        this.f2208A.put("sound_unmute", this.f2214j.f2651x.f2726u);
        this.f2208A.put("video_paused", this.f2214j.f2651x.f2727v);
        this.f2208A.put("video_resumed", this.f2214j.f2651x.f2728w);
        this.f2208A.put("native_start", this.f2214j.f2651x.f2729x);
        this.f2208A.put("native_first_quartile", this.f2214j.f2651x.f2730y);
        this.f2208A.put("native_midpoint", this.f2214j.f2651x.f2731z);
        this.f2208A.put("native_third_quartile", this.f2214j.f2651x.f2702A);
        this.f2208A.put("native_complete", this.f2214j.f2651x.f2703B);
        this.f2208A.put("native_overlay_click", this.f2214j.f2651x.f2704C);
        this.f2209B.put("replay", this.f2214j.f2648u.f2902a);
        this.f2209B.put("card_shown", this.f2214j.f2648u.f2903b);
        this.f2209B.put("html5_interaction", this.f2214j.f2648u.f2904c);
        this.f2209B.put("cancel", this.f2214j.f2648u.f2905d);
        this.f2209B.put("download", this.f2214j.f2648u.f2906e);
        this.f2209B.put(SchemaSymbols.ATTVAL_SKIP, this.f2214j.f2648u.f2907f);
        this.f2209B.put("midpoint", this.f2214j.f2648u.f2909h);
        this.f2209B.put("card_dissolved", this.f2214j.f2648u.f2910i);
        this.f2209B.put("start", this.f2214j.f2648u.f2911j);
        this.f2209B.put("third_quartile", this.f2214j.f2648u.f2912k);
        this.f2209B.put("complete", this.f2214j.f2648u.f2913l);
        this.f2209B.put("continue", this.f2214j.f2648u.f2914m);
        this.f2209B.put("in_video_engagement", this.f2214j.f2648u.f2915n);
        this.f2209B.put("reward_v4vc", this.f2214j.f2648u.f2916o);
        this.f2209B.put("v4iap", this.f2214j.f2648u.f2918q);
        this.f2209B.put("first_quartile", this.f2214j.f2648u.f2917p);
        this.f2209B.put("video_expanded", this.f2214j.f2648u.f2919r);
        this.f2209B.put("sound_mute", this.f2214j.f2648u.f2920s);
        this.f2209B.put("sound_unmute", this.f2214j.f2648u.f2921t);
        this.f2209B.put("video_paused", this.f2214j.f2648u.f2922u);
        this.f2209B.put("video_resumed", this.f2214j.f2648u.f2923v);
        this.f2209B.put("native_start", this.f2214j.f2648u.f2924w);
        this.f2209B.put("native_first_quartile", this.f2214j.f2648u.f2925x);
        this.f2209B.put("native_midpoint", this.f2214j.f2648u.f2926y);
        this.f2209B.put("native_third_quartile", this.f2214j.f2648u.f2927z);
        this.f2209B.put("native_complete", this.f2214j.f2648u.f2899A);
        this.f2209B.put("native_overlay_click", this.f2214j.f2648u.f2900B);
        return true;
    }

    public String getZoneID() {
        if (this.f2212h == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return this.f2212h;
    }
}
