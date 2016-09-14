package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.cb;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.x */
class C1172x extends Dialog implements C0229w {
    private final Activity f3827a;
    private final AppLovinSdk f3828b;
    private final AppLovinLogger f3829c;
    private RelativeLayout f3830d;
    private AppLovinAdView f3831e;
    private Runnable f3832f;
    private C0227u f3833g;
    private Handler f3834h;
    private ah f3835i;
    private volatile boolean f3836j;
    private volatile boolean f3837k;

    C1172x(AppLovinSdk appLovinSdk, Activity activity) {
        super(activity, 16973840);
        this.f3835i = null;
        this.f3836j = false;
        this.f3837k = false;
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f3828b = appLovinSdk;
            this.f3829c = appLovinSdk.getLogger();
            this.f3827a = activity;
            this.f3832f = new ag();
            this.f3834h = new Handler();
            this.f3831e = new AppLovinAdView(appLovinSdk, AppLovinAdSize.INTERSTITIAL, activity);
            this.f3831e.setAutoDestroy(false);
            ((AdViewControllerImpl) this.f3831e.getAdViewController()).setParentDialog(new WeakReference(this));
            requestWindowFeature(1);
            try {
                getWindow().setFlags(activity.getWindow().getAttributes().flags, activity.getWindow().getAttributes().flags);
            } catch (Throwable e) {
                this.f3829c.m308e("InterstitialAdDialog", "Set window flags failed.", e);
            }
        }
    }

    private int m4119a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f3827a, i);
    }

    private void m4121a() {
        this.f3827a.runOnUiThread(new af(this));
    }

    private void m4122a(long j) {
        this.f3834h.postDelayed(new ae(this), j);
    }

    private void m4123a(C0228v c0228v) {
        int i = 9;
        this.f3833g = C0227u.m50a(this.f3828b, getContext(), c0228v);
        this.f3833g.setVisibility(8);
        this.f3833g.setOnClickListener(new ac(this));
        this.f3833g.setClickable(false);
        cb cbVar = new cb(this.f3828b);
        int a = m4119a(cbVar.m200l());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(10);
        layoutParams.addRule(cbVar.m213y() ? 9 : 11);
        this.f3833g.m51a(a);
        int a2 = m4119a(cbVar.m202n());
        int a3 = m4119a(cbVar.m204p());
        layoutParams.setMargins(a3, a2, a3, a2);
        this.f3831e.addView(this.f3833g, layoutParams);
        this.f3833g.bringToFront();
        int a4 = m4119a(new cb(this.f3828b).m206r());
        View view = new View(this.f3827a);
        view.setBackgroundColor(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a + a4, a + a4);
        layoutParams2.addRule(10);
        if (!cbVar.m212x()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(0, a2 - m4119a(5), a3 - m4119a(5), 0);
        view.setOnClickListener(new ad(this));
        this.f3831e.addView(view, layoutParams2);
        view.bringToFront();
    }

    private void m4128b() {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f3831e.setLayoutParams(layoutParams);
        this.f3830d = new RelativeLayout(this.f3827a);
        this.f3830d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f3830d.setBackgroundColor(-1157627904);
        this.f3830d.addView(this.f3831e);
        setContentView(this.f3830d);
    }

    public void m4138a(ah ahVar) {
        this.f3831e.setAdDisplayListener(new C1173y(this, ahVar));
        this.f3831e.setAdClickListener(new C1174z(this, ahVar));
        this.f3831e.setAdVideoPlaybackListener(new aa(this, ahVar));
        this.f3835i = ahVar;
        ahVar.m4097a(true);
    }

    public void m4139a(AppLovinAd appLovinAd, String str) {
        this.f3827a.runOnUiThread(new ab(this, appLovinAd, str));
    }

    public void dismiss() {
        if (this.f3835i != null) {
            this.f3835i.m4104h();
        }
        if (this.f3831e != null) {
            this.f3831e.destroy();
        }
        this.f3835i = null;
        this.f3831e = null;
        super.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4128b();
    }
}
