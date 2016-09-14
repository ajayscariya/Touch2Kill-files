package com.startapp.android.publish.p009c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.gcm.GCMConstants;
import com.startapp.android.publish.Ad.AdType;
import com.startapp.android.publish.AdDisplayListener.NotDisplayedReason;
import com.startapp.android.publish.JsInterface;
import com.startapp.android.publish.VideoJsInterface;
import com.startapp.android.publish.c.h.AnonymousClass16;
import com.startapp.android.publish.c.h.AnonymousClass17;
import com.startapp.android.publish.model.MetaData;
import com.startapp.android.publish.model.VideoConfig.BackMode;
import com.startapp.android.publish.p009c.StartAppSDK.StartAppSDK;
import com.startapp.android.publish.video.VideoAdDetails;
import com.startapp.android.publish.video.VideoAdDetails.PostRollType;
import com.startapp.android.publish.video.tracking.VideoTrackingLink;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mf.javax.xml.XMLConstants;

/* renamed from: com.startapp.android.publish.c.h */
public class StartAppSDK extends StartAppSDK {
    private Handler f4919A;
    private Handler f4920B;
    private Handler f4921C;
    private Handler f4922D;
    private Map<Integer, List<com.startapp.android.publish.video.tracking.StartAppSDK>> f4923E;
    private Map<Integer, List<com.startapp.android.publish.video.tracking.StartAppSDK>> f4924F;
    private long f4925G;
    private com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK f4926H;
    private com.startapp.android.publish.video.p026b.StartAppSDK f4927e;
    private VideoView f4928f;
    private RelativeLayout f4929g;
    private RelativeLayout f4930h;
    private ProgressBar f4931i;
    private boolean f4932j;
    private int f4933k;
    private int f4934l;
    private int f4935m;
    private int f4936n;
    private boolean f4937o;
    private boolean f4938p;
    private boolean f4939q;
    private boolean f4940r;
    private boolean f4941s;
    private boolean f4942t;
    private boolean f4943u;
    private HashMap<Integer, Boolean> f4944v;
    private HashMap<Integer, Boolean> f4945w;
    private int f4946x;
    private boolean f4947y;
    private boolean f4948z;

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.android.publish.c.h.17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ Handler f3145a;
        final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f3146b;

        AnonymousClass17(com.startapp.android.publish.p009c.StartAppSDK startAppSDK, Handler handler) {
            this.f3146b = startAppSDK;
            this.f3145a = handler;
        }

        public void run() {
            if (this.f3146b.f4928f == null) {
                return;
            }
            if (this.f3146b.f4927e.m3931e() > 0) {
                this.f3146b.m5947e(0);
                this.f3146b.m5951f(0);
                if (this.f3146b.f4933k == 0) {
                    this.f3146b.al();
                    com.startapp.android.publish.p022h.StartAppSDK.m3219a(this.f3146b.m2984b()).m3224a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
                }
            } else if (!this.f3146b.f4941s) {
                this.f3145a.postDelayed(this, 100);
            }
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.2 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3147a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3147a = startAppSDK;
        }

        public void run() {
            int l = this.f3147a.m5901M();
            if (l >= 1000) {
                this.f3147a.f4920B.postDelayed(this, this.f3147a.m5915a(l));
            }
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.3 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3148a;
        private boolean f3149b;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3148a = startAppSDK;
        }

        public void run() {
            int d = this.f3148a.m5929b(this.f3148a.f4927e.m3931e() + 50);
            if (d >= 0 && !this.f3149b) {
                if (d == 0 || this.f3148a.f4934l >= this.f3148a.aa().getSkippableAfter() * 1000) {
                    this.f3149b = true;
                    this.f3148a.m5406a("videoApi.setSkipTimer", Integer.valueOf(0));
                } else {
                    this.f3148a.m5406a("videoApi.setSkipTimer", Integer.valueOf(d));
                }
            }
            this.f3148a.m5406a("videoApi.setVideoCurrentPosition", Integer.valueOf((this.f3148a.f4927e.m3931e() + 50) / 1000));
            if ((this.f3148a.f4927e.m3931e() + 50) / 1000 < this.f3148a.f4927e.m3932f() / 1000) {
                this.f3148a.f4920B.postDelayed(this, this.f3148a.m5905Q());
            }
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.4 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3151a;
        final /* synthetic */ StartAppSDK f3152b;

        /* renamed from: com.startapp.android.publish.c.h.4.1 */
        class StartAppSDK implements Runnable {
            final /* synthetic */ StartAppSDK f3150a;

            StartAppSDK(StartAppSDK startAppSDK) {
                this.f3150a = startAppSDK;
            }

            public void run() {
                if (!this.f3150a.f3152b.f4942t) {
                    this.f3150a.f3152b.f4928f.setVisibility(4);
                }
            }
        }

        StartAppSDK(StartAppSDK startAppSDK, StartAppSDK startAppSDK2) {
            this.f3152b = startAppSDK;
            this.f3151a = startAppSDK2;
        }

        public void run() {
            if (this.f3151a == StartAppSDK.SKIPPED || this.f3151a == StartAppSDK.CLICKED) {
                this.f3152b.f4919A.removeCallbacksAndMessages(null);
                this.f3152b.f4921C.removeCallbacksAndMessages(null);
                this.f3152b.f4935m = this.f3152b.f4927e.m3931e();
                this.f3152b.f4927e.m3928b();
            } else {
                this.f3152b.f4935m = this.f3152b.f4936n;
                this.f3152b.m5913Y();
            }
            this.f3152b.f4920B.removeCallbacksAndMessages(null);
            this.f3152b.f4944v.clear();
            this.f3152b.f4945w.clear();
            if (this.f3151a == StartAppSDK.CLICKED) {
                this.f3152b.m5906R();
                return;
            }
            if (this.f3152b.aa().getPostRollType() != PostRollType.NONE) {
                this.f3152b.m5896H();
                this.f3152b.a.m2851a().setVisibility(0);
            }
            if (this.f3152b.aa().getPostRollType() == PostRollType.IMAGE) {
                new Handler().postDelayed(new StartAppSDK(this), 1000);
            } else if (this.f3152b.aa().getPostRollType() == PostRollType.NONE) {
                this.f3152b.m5410n();
            }
            this.f3152b.m5906R();
            if (this.f3152b.aa().getPostRollType() != PostRollType.NONE) {
                this.f3152b.am();
            }
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.5 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ int f3153a;
        final /* synthetic */ StartAppSDK f3154b;

        StartAppSDK(StartAppSDK startAppSDK, int i) {
            this.f3154b = startAppSDK;
            this.f3153a = i;
        }

        public void run() {
            this.f3154b.m5947e(this.f3153a);
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.6 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ int f3155a;
        final /* synthetic */ StartAppSDK f3156b;

        StartAppSDK(StartAppSDK startAppSDK, int i) {
            this.f3156b = startAppSDK;
            this.f3155a = i;
        }

        public void run() {
            this.f3156b.m5951f(this.f3155a);
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.7 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3157a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3157a = startAppSDK;
        }

        public void run() {
            this.f3157a.m5913Y();
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.8 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3158a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3158a = startAppSDK;
        }

        public void run() {
            this.f3158a.f4932j = !this.f3158a.f4932j;
            this.f3158a.af();
            this.f3158a.m5933b(this.f3158a.f4932j);
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.9 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ StartAppSDK f3159a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3159a = startAppSDK;
        }

        public void run() {
            this.f3159a.ad();
        }
    }

    /* renamed from: com.startapp.android.publish.c.h.a */
    private enum StartAppSDK {
        PLAYER,
        POST_ROLL
    }

    /* renamed from: com.startapp.android.publish.c.h.b */
    private enum StartAppSDK {
        ON,
        OFF
    }

    /* renamed from: com.startapp.android.publish.c.h.c */
    private enum StartAppSDK {
        COMPLETE,
        SKIPPED,
        CLICKED
    }

    /* renamed from: com.startapp.android.publish.c.h.1 */
    class StartAppSDK implements com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK {
        final /* synthetic */ StartAppSDK f4694a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f4694a = startAppSDK;
        }

        public void m5427a() {
            if (this.f4694a.f4938p && this.f4694a.f4939q) {
                this.f4694a.m5885B();
            }
            if (this.f4694a.f4938p) {
                this.f4694a.m5890D();
            }
        }
    }

    public StartAppSDK() {
        this.f4932j = false;
        this.f4933k = 0;
        this.f4934l = 0;
        this.f4935m = 0;
        this.f4936n = 0;
        this.f4938p = false;
        this.f4939q = false;
        this.f4940r = false;
        this.f4941s = false;
        this.f4942t = false;
        this.f4943u = false;
        this.f4944v = new HashMap();
        this.f4945w = new HashMap();
        this.f4946x = 1;
        this.f4947y = false;
        this.f4948z = false;
        this.f4919A = new Handler();
        this.f4920B = new Handler();
        this.f4921C = new Handler();
        this.f4922D = new Handler();
        this.f4923E = new HashMap();
        this.f4924F = new HashMap();
    }

    public void m5973a(Bundle bundle) {
        super.m5404a(bundle);
        this.f4925G = System.currentTimeMillis();
        m5893F();
        ak();
        if (bundle != null && bundle.containsKey("currentPosition")) {
            this.f4934l = bundle.getInt("currentPosition");
            this.f4935m = bundle.getInt("latestPosition");
            this.f4944v = (HashMap) bundle.getSerializable("fractionProgressImpressionsSent");
            this.f4945w = (HashMap) bundle.getSerializable("absoluteProgressImpressionsSent");
            this.f4932j = bundle.getBoolean("isMuted");
            this.f4937o = bundle.getBoolean("shouldSetBg");
            this.f4933k = bundle.getInt("replayNum");
            this.f4943u = bundle.getBoolean("videoCompletedBroadcastSent", false);
            this.f4946x = bundle.getInt("pauseNum");
        }
    }

    public void m5974a(WebView webView) {
        super.m5405a(webView);
        webView.setBackgroundColor(33554431);
        com.startapp.android.publish.p022h.StartAppSDK.m3176a(webView, null);
    }

    protected void m5983x() {
        super.m5415x();
        this.f4938p = true;
        if (this.f4939q && ag()) {
            m5885B();
        } else if (m5908T()) {
            m5918a(this.c);
        }
        if (ag()) {
            m5890D();
        }
        if (m5908T()) {
            m5896H();
        }
    }

    private void m5885B() {
        if (this.f4940r) {
            m5918a(this.f4928f);
            if (!m5908T()) {
                m5897I();
            }
        }
    }

    public void m5980s() {
        super.m5412s();
        if (!m2984b().isFinishing()) {
            m5887C();
        }
    }

    private void m5887C() {
        if (this.f4928f == null) {
            m5916a(m2984b().getApplicationContext());
        }
        if (this.f4927e == null) {
            this.f4927e = new com.startapp.android.publish.video.p026b.StartAppSDK(this.f4928f);
        }
        this.f4939q = false;
        this.f4929g.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4927e.m3926a(aa().getLocalVideoPath());
        if (m5908T()) {
            this.a.m2851a().setVisibility(0);
            this.f4928f.setVisibility(4);
        } else if (this.f4934l != 0) {
            this.f4927e.m3920a(this.f4934l);
            m5932b(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK.EXTERNAL);
        }
        this.f4927e.m3925a(new StartAppSDK(this));
        this.f4927e.m3923a(new com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f4689a;

            {
                this.f4689a = r1;
            }

            public void m5424a() {
                if (!this.f4689a.m5908T()) {
                    this.f4689a.m5919a(StartAppSDK.COMPLETE);
                }
                this.f4689a.f4927e.m3929c();
            }
        });
        this.f4927e.m3924a(new com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f4690a;

            {
                this.f4690a = r1;
            }

            public boolean m5425a(com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK startAppSDK) {
                return this.f4690a.m5928a(startAppSDK);
            }
        });
        this.f4927e.m3922a(new com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f4691a;

            {
                this.f4691a = r1;
            }
        });
        this.f4927e.m3921a(new com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f4692a;

            {
                this.f4692a = r1;
            }
        });
        com.startapp.android.publish.p022h.StartAppSDK.m3172a(this.f4928f, new com.startapp.android.publish.p022h.StartAppSDK.StartAppSDK() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f4693a;

            {
                this.f4693a = r1;
            }

            public void m5426a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f4693a.f4939q = true;
                if (this.f4693a.f4938p && this.f4693a.ag()) {
                    this.f4693a.m5885B();
                }
            }
        });
    }

    private void m5890D() {
        m5898J();
        if (m5908T()) {
            this.f4927e.m3928b();
            return;
        }
        new Handler().postDelayed(new Runnable() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f3144a;

            /* renamed from: com.startapp.android.publish.c.h.16.1 */
            class StartAppSDK implements Runnable {
                final /* synthetic */ AnonymousClass16 f3143a;

                StartAppSDK(AnonymousClass16 anonymousClass16) {
                    this.f3143a = anonymousClass16;
                }

                public void run() {
                    this.f3143a.f3144a.m5885B();
                }
            }

            {
                this.f3144a = r1;
            }

            public void run() {
                this.f3144a.f4927e.m3919a();
                this.f3144a.f4940r = true;
                new Handler().post(new com.startapp.android.publish.p009c.StartAppSDK.16.StartAppSDK(this));
            }
        }, m5895G());
        if (this.f4934l == 0) {
            Handler handler = new Handler();
            handler.postDelayed(new AnonymousClass17(this, handler), 100);
        }
        m5909U();
        m5912X();
        m5900L();
        m5902N();
        this.a.m2851a().setVisibility(4);
        af();
    }

    private void m5891E() {
        this.f4922D.removeCallbacksAndMessages(null);
        if (this.f4931i.isShown()) {
            this.f4931i.setVisibility(8);
        }
    }

    private void m5893F() {
        if (!m2991g().equals("back")) {
            return;
        }
        if (MetaData.getInstance().getVideoConfig().getBackMode().equals(BackMode.BOTH)) {
            this.f4947y = true;
            this.f4948z = true;
        } else if (MetaData.getInstance().getVideoConfig().getBackMode().equals(BackMode.SKIP)) {
            this.f4947y = true;
            this.f4948z = false;
        } else if (MetaData.getInstance().getVideoConfig().getBackMode().equals(BackMode.CLOSE)) {
            this.f4947y = false;
            this.f4948z = true;
        } else if (MetaData.getInstance().getVideoConfig().getBackMode().equals(BackMode.DISABLED)) {
            this.f4947y = false;
            this.f4948z = false;
        } else {
            this.f4947y = false;
            this.f4948z = false;
        }
    }

    private long m5895G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f4925G;
        if (this.f4934l == 0 && this.f4933k == 0 && currentTimeMillis < 500) {
            return Math.max(200, 500 - currentTimeMillis);
        }
        return 0;
    }

    private void m5896H() {
        m5406a("videoApi.setReplayEnabled", Boolean.valueOf(ag()));
        m5406a("videoApi.setMode", StartAppSDK.POST_ROLL + "_" + aa().getPostRollType());
        m5406a("videoApi.setCloseable", Boolean.valueOf(true));
    }

    private void m5897I() {
        m5406a("videoApi.setClickableVideo", Boolean.valueOf(aa().isClickable()));
        m5406a("videoApi.setMode", StartAppSDK.PLAYER.toString());
        String str = "videoApi.setCloseable";
        Object[] objArr = new Object[1];
        boolean z = aa().isCloseable() || this.f4948z;
        objArr[0] = Boolean.valueOf(z);
        m5406a(str, objArr);
        m5406a("videoApi.setSkippable", Boolean.valueOf(ai()));
    }

    private void m5898J() {
        m5406a("videoApi.setVideoDuration", Integer.valueOf(this.f4927e.m3932f() / 1000));
        m5901M();
        m5903O();
        m5406a("videoApi.setVideoCurrentPosition", Integer.valueOf(this.f4934l / 1000));
    }

    private void m5899K() {
        m5406a("videoApi.setVideoCurrentPosition", Integer.valueOf(0));
        m5406a("videoApi.setSkipTimer", Integer.valueOf(0));
    }

    private void m5918a(View view) {
        m5406a("videoApi.setVideoFrame", Integer.valueOf(com.startapp.android.publish.p022h.StartAppSDK.m3277b(m2984b(), view.getLeft())), Integer.valueOf(com.startapp.android.publish.p022h.StartAppSDK.m3277b(m2984b(), view.getTop())), Integer.valueOf(com.startapp.android.publish.p022h.StartAppSDK.m3277b(m2984b(), view.getWidth())), Integer.valueOf(com.startapp.android.publish.p022h.StartAppSDK.m3277b(m2984b(), view.getHeight())));
    }

    private void m5900L() {
        this.f4920B.post(new StartAppSDK(this));
    }

    private int m5901M() {
        int P = m5904P();
        int i = P / 1000;
        if (i > 0 && P % 1000 < 100) {
            i--;
        }
        m5406a("videoApi.setVideoRemainingTimer", Integer.valueOf(i));
        return P;
    }

    private void m5902N() {
        m5903O();
        this.f4920B.post(new StartAppSDK(this));
    }

    private void m5903O() {
        m5406a("videoApi.setSkipTimer", Integer.valueOf(m5929b(this.f4934l + 50)));
    }

    private int m5904P() {
        if (this.f4927e.m3931e() != this.f4927e.m3932f() || m5908T()) {
            return this.f4927e.m3932f() - this.f4927e.m3931e();
        }
        return this.f4927e.m3932f();
    }

    private long m5915a(int i) {
        int i2 = i % 1000;
        if (i2 == 0) {
            i2 = 1000;
        }
        return (long) (i2 + 50);
    }

    private long m5905Q() {
        return (long) (1000 - (this.f4927e.m3931e() % 1000));
    }

    private int m5929b(int i) {
        if (this.f4947y || this.f4933k > 0) {
            return 0;
        }
        int skippableAfter = (aa().getSkippableAfter() * 1000) - i;
        if (skippableAfter > 0) {
            return (skippableAfter / 1000) + 1;
        }
        return 0;
    }

    private void m5919a(StartAppSDK startAppSDK) {
        new Handler().postDelayed(new StartAppSDK(this, startAppSDK), 0);
    }

    private void m5906R() {
        this.f4934l = -1;
    }

    private void m5907S() {
        this.f4934l = 0;
    }

    private boolean m5908T() {
        return this.f4934l == -1;
    }

    private void m5909U() {
        this.f4936n = this.f4927e.m3932f();
        m5910V();
        m5911W();
    }

    private void m5910V() {
        for (Integer intValue : this.f4923E.keySet()) {
            int intValue2 = intValue.intValue();
            m5917a(m5936c(intValue2), this.f4919A, new StartAppSDK(this, intValue2));
        }
    }

    private void m5911W() {
        for (Integer intValue : this.f4924F.keySet()) {
            int intValue2 = intValue.intValue();
            m5917a(intValue2, this.f4919A, new StartAppSDK(this, intValue2));
        }
    }

    private void m5912X() {
        m5917a(m5936c(MetaData.getInstance().getVideoConfig().getRewardGrantPercentage()), this.f4921C, new StartAppSDK(this));
    }

    private void m5917a(int i, Handler handler, Runnable runnable) {
        if (this.f4934l < i) {
            handler.postDelayed(runnable, (long) (i - this.f4934l));
        }
    }

    private int m5936c(int i) {
        return (this.f4936n * i) / 100;
    }

    private void m5913Y() {
        if (m5914Z() && !this.f4943u && this.f4933k == 0) {
            this.f4943u = true;
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending rewarded video completion broadcast.");
            if (com.startapp.android.publish.p022h.StartAppSDK.m3219a(m2984b()).m3224a(new Intent("com.startapp.android.OnVideoCompleted"))) {
                com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Rewarded video completion broadcast sent successfully.");
            }
            an();
        }
    }

    private boolean m5914Z() {
        return m3005u().getType() == AdType.REWARDED_VIDEO;
    }

    public void m5975b(Bundle bundle) {
        super.m5407b(bundle);
        bundle.putInt("currentPosition", this.f4934l);
        bundle.putInt("latestPosition", this.f4935m);
        bundle.putSerializable("fractionProgressImpressionsSent", this.f4944v);
        bundle.putSerializable("absoluteProgressImpressionsSent", this.f4945w);
        bundle.putBoolean("isMuted", this.f4932j);
        bundle.putBoolean("shouldSetBg", this.f4937o);
        bundle.putInt("replayNum", this.f4933k);
        bundle.putInt("pauseNum", this.f4946x);
        bundle.putBoolean("videoCompletedBroadcastSent", this.f4943u);
    }

    private VideoAdDetails aa() {
        return ((com.startapp.android.publish.p027a.StartAppSDK) m3005u()).getVideoAdDetails();
    }

    public void m5979q() {
        if (!(m5908T() || m2984b().isFinishing() || this.f4948z || this.f4947y)) {
            m5923a(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK.EXTERNAL);
        }
        ah();
        this.f4919A.removeCallbacksAndMessages(null);
        this.f4920B.removeCallbacksAndMessages(null);
        this.f4921C.removeCallbacksAndMessages(null);
        m5891E();
        this.f4937o = true;
        super.m5411q();
    }

    protected void m5982w() {
    }

    protected JsInterface m5981v() {
        return new VideoJsInterface(m2984b(), this.d, this.d, ae(), ac(), ab(), new com.startapp.android.publish.p022h.StartAppSDK(m2997m()));
    }

    private Runnable ab() {
        return new StartAppSDK(this);
    }

    private Runnable ac() {
        return new StartAppSDK(this);
    }

    private void ad() {
        m5919a(StartAppSDK.SKIPPED);
        ao();
    }

    private Runnable ae() {
        return new Runnable() {
            final /* synthetic */ com.startapp.android.publish.p009c.StartAppSDK f3142a;

            {
                this.f3142a = r1;
            }

            public void run() {
                this.f3142a.f4933k = this.f3142a.f4933k + 1;
                this.f3142a.f4928f.setVisibility(0);
                this.f3142a.f4937o = false;
                this.f3142a.m5907S();
                this.f3142a.m5899K();
                this.f3142a.f4927e.m3930d();
            }
        };
    }

    private RelativeLayout m5916a(Context context) {
        this.f4930h = (RelativeLayout) m2984b().findViewById(com.startapp.android.publish.StartAppSDK.STARTAPP_AD_MAIN_LAYOUT_ID);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f4928f = new VideoView(context);
        this.f4928f.setId(100);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        this.f4931i = new ProgressBar(context, null, 16843399);
        this.f4931i.setVisibility(4);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(15);
        this.f4929g = new RelativeLayout(context);
        this.f4929g.setId(1475346436);
        m2984b().setContentView(this.f4929g);
        this.f4929g.addView(this.f4928f, layoutParams2);
        this.f4929g.addView(this.f4930h, layoutParams);
        this.f4929g.addView(this.f4931i, layoutParams3);
        if (com.startapp.android.publish.StartAppSDK.m3038b().booleanValue()) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            this.f4929g.addView(m5930b(context), layoutParams);
        }
        this.a.m2851a().setVisibility(4);
        return this.f4929g;
    }

    private View m5930b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url=" + aa().getVideoUrl());
        View textView = new TextView(context);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.startapp.android.publish.p022h.StartAppSDK.m3169a(textView, 0.5f);
        textView.setTextColor(-7829368);
        textView.setSingleLine(false);
        textView.setText(stringBuilder.toString());
        return textView;
    }

    private void af() {
        if (this.f4927e != null) {
            try {
                if (this.f4932j) {
                    this.f4927e.m3927a(true);
                } else {
                    this.f4927e.m3927a(false);
                }
            } catch (IllegalStateException e) {
            }
        }
        String str = "videoApi.setSound";
        Object[] objArr = new Object[1];
        objArr[0] = this.f4932j ? StartAppSDK.OFF.toString() : StartAppSDK.ON.toString();
        m5406a(str, objArr);
    }

    private void m5923a(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK startAppSDK) {
        if (this.f4927e != null) {
            int e = this.f4927e.m3931e();
            this.f4934l = e;
            this.f4935m = e;
            this.f4927e.m3928b();
        }
        m5939c(startAppSDK);
    }

    private void m5932b(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK startAppSDK) {
        m5945d(startAppSDK);
        this.f4946x++;
    }

    private boolean m5928a(com.startapp.android.publish.video.p026b.StartAppSDK.StartAppSDK startAppSDK) {
        boolean z = false;
        com.startapp.android.publish.p010d.StartAppSDK.m3033a(m2984b(), com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.VIDEO_MEDIA_PLAYER_ERROR, startAppSDK.m3917a().toString(), startAppSDK.m3918b(), com.startapp.android.publish.p022h.StartAppSDK.m3295a(aj(), null));
        ar();
        boolean z2 = this.f4934l > 0;
        if (aa().getPostRollType() == PostRollType.NONE) {
            z = true;
        }
        boolean Z = m5914Z();
        if (!z2) {
            com.startapp.android.publish.video.StartAppSDK.m3939b(m2984b());
        }
        if ((!Z || this.f4943u) && !r2) {
            m5919a(StartAppSDK.SKIPPED);
        } else {
            com.startapp.android.publish.p022h.StartAppSDK.m3308a(m2984b(), m2992h(), m2997m(), this.f4933k, NotDisplayedReason.VIDEO_ERROR.toString());
            Intent intent = new Intent("com.startapp.android.ShowFailedDisplayBroadcastListener");
            intent.putExtra("showFailedReason", NotDisplayedReason.VIDEO_ERROR);
            com.startapp.android.publish.p022h.StartAppSDK.m3219a(m2984b()).m3224a(intent);
            this.f4941s = true;
            m5410n();
        }
        return true;
    }

    private boolean ag() {
        return this.f4927e != null && this.f4927e.m3933g();
    }

    private void ah() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Releasing video player");
        if (this.f4927e != null) {
            this.f4927e.m3934h();
            this.f4927e = null;
        }
    }

    public boolean m5978p() {
        if (m5908T()) {
            return false;
        }
        int b = m5929b(this.f4927e.m3931e() + 50);
        if (ai() && b == 0) {
            ad();
            return true;
        } else if (aa().isCloseable() || this.f4948z) {
            return false;
        } else {
            return true;
        }
    }

    private boolean ai() {
        return this.f4933k > 0 || aa().isSkippable() || this.f4947y;
    }

    private int m5941d(int i) {
        if (this.f4936n > 0) {
            return (i * 100) / this.f4936n;
        }
        return 0;
    }

    private String aj() {
        String[] h = m2992h();
        if (h != null && h.length > 0) {
            return h[0];
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 5, "dParam is not available.");
        return XMLConstants.NULL_NS_URI;
    }

    public void m5977o() {
        if (!this.f4941s) {
            super.m2999o();
        }
    }

    protected boolean m5976b(String str) {
        this.f4926H = m5908T() ? com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK.POSTROLL : com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK.VIDEO;
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Video clicked from: " + this.f4926H);
        if (this.f4926H == com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK.VIDEO) {
            m5919a(StartAppSDK.CLICKED);
        }
        m5922a(this.f4926H);
        return super.m5409b(str);
    }

    protected void m5984y() {
        if (this.f4941s) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Not sending close events due to media player error");
        } else if (m5908T() || this.f4928f == null) {
            ap();
        } else {
            aq();
        }
        super.m5416y();
    }

    protected com.startapp.android.publish.p022h.StartAppSDK m5972A() {
        return new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k, this.f4926H).m5630b(true).m5628a(true);
    }

    private void ak() {
        List list;
        int i = 0;
        com.startapp.android.publish.video.tracking.StartAppSDK[] a = aa().getVideoTrackingDetails().m3947a();
        if (a != null) {
            for (com.startapp.android.publish.video.tracking.StartAppSDK startAppSDK : a) {
                list = (List) this.f4923E.get(Integer.valueOf(startAppSDK.m5627a()));
                if (list == null) {
                    list = new ArrayList();
                    this.f4923E.put(Integer.valueOf(startAppSDK.m5627a()), list);
                }
                list.add(startAppSDK);
            }
        }
        com.startapp.android.publish.video.tracking.StartAppSDK[] b = aa().getVideoTrackingDetails().m3948b();
        if (b != null) {
            int length = b.length;
            while (i < length) {
                com.startapp.android.publish.video.tracking.StartAppSDK startAppSDK2 = b[i];
                list = (List) this.f4924F.get(Integer.valueOf(startAppSDK2.m5626a()));
                if (list == null) {
                    list = new ArrayList();
                    this.f4924F.put(Integer.valueOf(startAppSDK2.m5626a()), list);
                }
                list.add(startAppSDK2);
                i++;
            }
        }
    }

    private void al() {
        com.startapp.android.publish.p022h.StartAppSDK.m3307a(m2984b(), m2992h(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), 0, this.f4933k));
        m5924a(aa().getVideoTrackingDetails().m3949c(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), 0, this.f4933k), 0, "impression");
        m5924a(aa().getVideoTrackingDetails().m3951e(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), 0, this.f4933k), 0, "creativeView");
    }

    private void m5947e(int i) {
        if (this.f4944v.get(Integer.valueOf(i)) == null) {
            if (this.f4923E.containsKey(Integer.valueOf(i))) {
                List list = (List) this.f4923E.get(Integer.valueOf(i));
                com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending fraction progress event with fraction: " + i + ", total: " + list.size());
                m5924a((VideoTrackingLink[]) list.toArray(new com.startapp.android.publish.video.tracking.StartAppSDK[list.size()]), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), i, this.f4933k), this.f4927e.m3931e(), "fraction");
            }
            this.f4944v.put(Integer.valueOf(i), Boolean.valueOf(true));
            return;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Fraction progress event already sent for fraction: " + i);
    }

    private void m5951f(int i) {
        if (this.f4945w.get(Integer.valueOf(i)) == null) {
            if (this.f4924F.containsKey(Integer.valueOf(i))) {
                List list = (List) this.f4924F.get(Integer.valueOf(i));
                com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending absolute progress event with video progress: " + i + ", total: " + list.size());
                m5924a((VideoTrackingLink[]) list.toArray(new com.startapp.android.publish.video.tracking.StartAppSDK[list.size()]), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), i, this.f4933k), i, "absolute");
            }
            this.f4945w.put(Integer.valueOf(i), Boolean.valueOf(true));
            return;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Absolute progress event already sent for video progress: " + i);
    }

    private void am() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending postroll impression event");
        m5924a(aa().getVideoTrackingDetails().m3957k(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k), this.f4935m, "postrollImression");
    }

    private void an() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending rewarded event");
        m5924a(aa().getVideoTrackingDetails().m3959m(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), MetaData.getInstance().getVideoConfig().getRewardGrantPercentage(), this.f4933k), this.f4927e.m3931e(), "rewarded");
    }

    private void m5933b(boolean z) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending sound " + (z ? "muted " : "unmuted ") + NotificationCompatApi21.CATEGORY_EVENT);
        m5924a(z ? aa().getVideoTrackingDetails().m3952f() : aa().getVideoTrackingDetails().m3950d(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4927e.m3931e()), this.f4933k), this.f4927e.m3931e(), "sound");
    }

    private void ao() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending skip event");
        m5924a(aa().getVideoTrackingDetails().m3955i(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4927e.m3931e()), this.f4933k), this.f4927e.m3931e(), "skipped");
    }

    private void m5939c(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK startAppSDK) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending pause event with origin: " + startAppSDK);
        m5924a(aa().getVideoTrackingDetails().m3953g(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k, this.f4946x, startAppSDK), this.f4935m, "paused");
    }

    private void m5945d(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK startAppSDK) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending resume event with pause origin: " + startAppSDK);
        m5924a(aa().getVideoTrackingDetails().m3954h(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k, this.f4946x, startAppSDK), this.f4935m, "resumed");
    }

    private void ap() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending postroll closed event");
        m5924a(aa().getVideoTrackingDetails().m3958l(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k), this.f4935m, "postrollClosed");
    }

    private void aq() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending video closed event");
        m5924a(aa().getVideoTrackingDetails().m3956j(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4927e.m3931e()), this.f4933k), this.f4927e.m3931e(), "closed");
    }

    private void m5922a(com.startapp.android.publish.video.tracking.StartAppSDK.StartAppSDK startAppSDK) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending video clicked event with origin: " + startAppSDK.toString());
        m5924a(aa().getVideoTrackingDetails().m3960n(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4927e.m3931e()), this.f4933k, startAppSDK), this.f4927e.m3931e(), "clicked");
    }

    private void m5924a(VideoTrackingLink[] videoTrackingLinkArr, com.startapp.android.publish.video.tracking.StartAppSDK startAppSDK, int i, String str) {
        com.startapp.android.publish.video.StartAppSDK.m3938a(m2984b(), new com.startapp.android.publish.video.p025a.StartAppSDK(videoTrackingLinkArr, startAppSDK, aa().getVideoUrl(), i).m3905a(str).m3903a());
    }

    private void ar() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("VideoMode", 3, "Sending internal video event");
        com.startapp.android.publish.video.StartAppSDK.m3938a(m2984b(), new com.startapp.android.publish.video.p025a.StartAppSDK(aa().getVideoTrackingDetails().m3961o(), new com.startapp.android.publish.video.tracking.StartAppSDK(m2997m(), m5941d(this.f4935m), this.f4933k), aa().getVideoUrl(), this.f4935m).m3904a(com.startapp.android.publish.video.p025a.StartAppSDK.StartAppSDK.GENERAL).m3905a(GCMConstants.EXTRA_ERROR).m3903a());
    }
}
