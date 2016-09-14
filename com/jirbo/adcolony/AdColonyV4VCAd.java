package com.jirbo.adcolony;

import android.graphics.Bitmap;
import mf.javax.xml.XMLConstants;

public final class AdColonyV4VCAd extends AdColonyAd {
    boolean f4584C;
    boolean f4585D;
    boolean f4586E;

    /* renamed from: com.jirbo.adcolony.AdColonyV4VCAd.1 */
    class C14271 extends C0724j {
        final /* synthetic */ AdColonyV4VCAd f4582a;

        C14271(AdColonyV4VCAd adColonyV4VCAd, C0711d c0711d) {
            this.f4582a = adColonyV4VCAd;
            super(c0711d);
        }

        void m5307a() {
            if (this.f4582a.h != null) {
                this.o.f2515d.m5354a(this.f4582a.h, this.f4582a);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyV4VCAd.2 */
    class C14282 extends C0724j {
        final /* synthetic */ AdColonyV4VCAd f4583a;

        C14282(AdColonyV4VCAd adColonyV4VCAd, C0711d c0711d) {
            this.f4583a = adColonyV4VCAd;
            super(c0711d);
        }

        void m5308a() {
            this.o.f2515d.m5354a(this.f4583a.h, this.f4583a);
        }
    }

    public AdColonyV4VCAd() {
        this.f4584C = false;
        this.f4585D = false;
        C0694a.f2338D = false;
        C0694a.m2460e();
        this.k = "v4vc";
        this.f4586E = false;
        this.l = "fullscreen";
        this.m = aa.m2481b();
    }

    public AdColonyV4VCAd(String zone_id) {
        this.f4584C = false;
        this.f4585D = false;
        C0694a.m2460e();
        this.h = zone_id;
        this.k = "v4vc";
        this.f4586E = false;
        this.l = "fullscreen";
        this.m = aa.m2481b();
    }

    public AdColonyV4VCAd withListener(AdColonyAdListener listener) {
        this.y = listener;
        return this;
    }

    public AdColonyV4VCAd withConfirmationDialog(boolean setting) {
        this.f4584C = setting;
        return this;
    }

    public AdColonyV4VCAd withResultsDialog(boolean setting) {
        this.f4585D = setting;
        C0694a.f2338D = this.f4585D;
        return this;
    }

    public AdColonyV4VCAd withConfirmationDialog() {
        return withConfirmationDialog(true);
    }

    public AdColonyV4VCAd withResultsDialog() {
        return withResultsDialog(true);
    }

    boolean m5312b() {
        return true;
    }

    boolean m5311a(boolean z) {
        return false;
    }

    public boolean isReady() {
        if (this.h == null) {
            this.h = C0694a.f2372l.m2574f();
            if (this.h == null) {
                return false;
            }
        }
        return C0694a.f2372l.m2575f(this.h);
    }

    public String getRewardName() {
        if (m2423c()) {
            return this.i.f2688n.f2698d;
        }
        return XMLConstants.NULL_NS_URI;
    }

    public int getRewardAmount() {
        if (m2423c()) {
            return this.i.f2688n.f2697c;
        }
        return 0;
    }

    public int getViewsPerReward() {
        if (m2423c()) {
            return this.i.f2688n.f2700f;
        }
        return 0;
    }

    public int getRemainingViewsUntilReward() {
        if (m2423c()) {
            return this.i.f2688n.f2700f - this.i.f2693s;
        }
        return 0;
    }

    public void show() {
        if (this.f4586E) {
            C0726l.f2613d.m2657b((Object) "Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
            return;
        }
        C0694a.am = 0;
        if (isReady()) {
            this.g = C0694a.am;
            if (C0694a.f2339E) {
                C14282 c14282 = new C14282(this, C0694a.f2372l);
                C0694a.f2339E = false;
                m2423c();
                C0694a.f2354T = this;
                C0694a.f2372l.m2552a(this);
                if (this.f4584C) {
                    m5310a("Confirmation");
                    return;
                }
                this.f4586E = true;
                m5313c(true);
                return;
            }
            return;
        }
        this.g = C0694a.am;
        C14271 c14271 = new C14271(this, C0694a.f2372l);
        this.f = 2;
        if (this.y != null) {
            this.y.onAdColonyAdAttemptFinished(this);
        }
        this.f4586E = true;
    }

    void m5313c(boolean z) {
        if (!z) {
            this.f = 1;
        } else if (C0694a.f2372l.m2565b(this)) {
            C0694a.f2375o = false;
            if (this.y != null) {
                this.y.onAdColonyAdStarted(this);
            }
            this.f = 4;
        } else {
            this.f = 3;
        }
        if (this.f != 4) {
            C0694a.f2339E = true;
            if (this.y != null) {
                this.y.onAdColonyAdAttemptFinished(this);
            }
        }
    }

    void m5309a() {
        if (this.f == 4 && this.f4585D) {
            m5310a("Result");
        }
        if (!(this.y == null || this.w)) {
            this.y.onAdColonyAdAttemptFinished(this);
        }
        if (!(C0694a.f2338D || AdColonyBrowser.f2243B)) {
            for (int i = 0; i < C0694a.an.size(); i++) {
                ((Bitmap) C0694a.an.get(i)).recycle();
            }
            C0694a.an.clear();
        }
        C0694a.f2355U = null;
        this.w = true;
        if (!this.f4585D) {
            C0694a.f2339E = true;
        }
        System.gc();
    }

    void m5310a(String str) {
        String rewardName = getRewardName();
        String str2 = XMLConstants.NULL_NS_URI;
        rewardName = (XMLConstants.NULL_NS_URI + getRewardAmount()) + " " + rewardName;
        if (str.equals("Confirmation")) {
            C0694a.f2353S = new ab(rewardName, this);
        } else {
            C0694a.f2353S = new ac(rewardName, this);
        }
    }
}
