package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.ConnectionResult;
import com.immersion.hapticmediasdk.HapticContentSDKFactory;
import com.jirbo.adcolony.aa.C0696b;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

class ad extends View implements OnCompletionListener, OnErrorListener {
    static float[] aB;
    boolean f2407A;
    boolean f2408B;
    boolean f2409C;
    boolean f2410D;
    boolean f2411E;
    boolean f2412F;
    boolean f2413G;
    boolean f2414H;
    boolean f2415I;
    boolean f2416J;
    boolean f2417K;
    boolean f2418L;
    boolean f2419M;
    boolean f2420N;
    boolean f2421O;
    boolean f2422P;
    boolean f2423Q;
    boolean f2424R;
    boolean f2425S;
    boolean f2426T;
    boolean f2427U;
    boolean f2428V;
    Canvas f2429W;
    WebView f2430a;
    String[] aA;
    float aC;
    float aD;
    float aE;
    float aF;
    float aG;
    float aH;
    float aI;
    Paint aJ;
    RectF aK;
    C0707b aL;
    Handler aM;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    String af;
    C0696b ag;
    Paint ah;
    Paint ai;
    Paint aj;
    Paint ak;
    Rect al;
    ADCImage am;
    ADCImage an;
    ADCImage ao;
    ADCImage ap;
    ADCImage aq;
    ADCImage ar;
    ADCImage as;
    ADCImage at;
    ADCImage au;
    ADCImage av;
    ADCImage aw;
    ADCImage[] ax;
    ADCImage[] ay;
    C0729m az;
    WebView f2431b;
    View f2432c;
    ADCVideo f2433d;
    double f2434e;
    double f2435f;
    int f2436g;
    int f2437h;
    int f2438i;
    int f2439j;
    int f2440k;
    int f2441l;
    int f2442m;
    int f2443n;
    int f2444o;
    int f2445p;
    int f2446q;
    int f2447r;
    int f2448s;
    int f2449t;
    int f2450u;
    long f2451v;
    long f2452w;
    float f2453x;
    boolean f2454y;
    boolean f2455z;

    /* renamed from: com.jirbo.adcolony.ad.1 */
    class C06971 implements Runnable {
        final /* synthetic */ ad f2391a;

        C06971(ad adVar) {
            this.f2391a = adVar;
        }

        public void run() {
            this.f2391a.f2409C = true;
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.2 */
    class C06982 extends Handler {
        final /* synthetic */ ad f2392a;

        C06982(ad adVar) {
            this.f2392a = adVar;
        }

        public void handleMessage(Message m) {
            if (!this.f2392a.f2433d.isFinishing() && this.f2392a.f2433d.f4542G != null) {
                this.f2392a.m2491a(m.what);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.3 */
    class C06993 extends WebChromeClient {
        final /* synthetic */ ad f2393a;

        C06993(ad adVar) {
            this.f2393a = adVar;
        }

        public boolean onConsoleMessage(ConsoleMessage cm) {
            String sourceId = cm.sourceId();
            if (sourceId == null) {
                sourceId = "Internal";
            } else {
                int lastIndexOf = sourceId.lastIndexOf(47);
                if (lastIndexOf != -1) {
                    sourceId = sourceId.substring(lastIndexOf + 1);
                }
            }
            C0726l.f2611b.m2653a(cm.message()).m2653a(" [").m2653a(sourceId).m2653a(" line ").m2651a(cm.lineNumber()).m2657b((Object) "]");
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            callback.invoke(origin, true, false);
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.4 */
    class C07004 extends WebViewClient {
        String f2394a;
        final /* synthetic */ ad f2395b;

        C07004(ad adVar) {
            this.f2395b = adVar;
            this.f2394a = C0694a.ad;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            C0726l.f2610a.m2653a("DEC request: ").m2657b((Object) url);
            if (url.contains("mraid:")) {
                this.f2395b.az.m2662a(url);
                return true;
            } else if (url.contains("youtube")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + url));
                intent.putExtra("VIDEO_ID", url);
                this.f2395b.f2433d.startActivity(intent);
                return true;
            } else if (url.contains("mraid.js")) {
                return true;
            } else {
                return false;
            }
        }

        public void onLoadResource(WebView view, String url) {
            C0726l.f2610a.m2653a("DEC onLoad: ").m2657b((Object) url);
            if (url.equals(this.f2394a)) {
                C0726l.f2610a.m2657b((Object) "DEC disabling mouse events");
                this.f2395b.m2492a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
            }
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (url.equals(this.f2394a)) {
                this.f2395b.f2433d.f4562k = true;
                this.f2395b.f2451v = System.currentTimeMillis();
            }
        }

        public void onPageFinished(WebView view, String url) {
            C0726l.f2610a.m2653a("onPageFinished - ").m2657b((Object) url);
            C0726l.f2610a.m2653a("END CARD URL = ").m2657b(this.f2394a);
            C0726l.f2610a.m2653a("equals? ").m2658b(url.equals(this.f2394a));
            if (url.equals(this.f2394a) || C0694a.ad.startsWith("<")) {
                C0726l.f2610a.m2657b((Object) "DEC FINISHED LOADING");
                this.f2395b.f2410D = false;
                this.f2395b.f2433d.f4563l = true;
                this.f2395b.f2452w = System.currentTimeMillis();
                this.f2395b.f2433d.f4567p = ((double) (this.f2395b.f2452w - this.f2395b.f2451v)) / 1000.0d;
            }
            this.f2395b.f2433d.f4551P.removeView(this.f2395b.f2432c);
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.5 */
    class C07015 implements Runnable {
        final /* synthetic */ ad f2396a;

        C07015(ad adVar) {
            this.f2396a = adVar;
        }

        public void run() {
            if (this.f2396a.f2410D && this.f2396a.f2433d != null && this.f2396a.f2423Q && this.f2396a.f2430a != null) {
                this.f2396a.f2433d.f4564m = true;
                this.f2396a.m2504g();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.6 */
    class C07026 implements Runnable {
        final /* synthetic */ View f2397a;
        final /* synthetic */ ad f2398b;

        C07026(ad adVar, View view) {
            this.f2398b = adVar;
            this.f2397a = view;
        }

        public void run() {
            this.f2398b.f2433d.f4551P.removeView(this.f2397a);
            this.f2398b.m2493a(true);
            this.f2398b.f2433d.f4569r = System.currentTimeMillis();
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.7 */
    class C07037 implements Runnable {
        final /* synthetic */ ad f2399a;

        C07037(ad adVar) {
            this.f2399a = adVar;
        }

        public void run() {
            if (this.f2399a.f2433d.f4542G != null) {
                this.f2399a.f2433d.f4542G.setVisibility(8);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.8 */
    class C07048 implements Runnable {
        final /* synthetic */ View f2400a;
        final /* synthetic */ ad f2401b;

        C07048(ad adVar, View view) {
            this.f2401b = adVar;
            this.f2400a = view;
        }

        public void run() {
            if (this.f2401b.f2423Q) {
                this.f2401b.f2433d.f4552Q.setVisibility(4);
            }
            this.f2401b.f2433d.f4551P.removeView(this.f2400a);
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.9 */
    class C07059 implements OnGlobalLayoutListener {
        final /* synthetic */ View f2402a;
        final /* synthetic */ ad f2403b;

        C07059(ad adVar, View view) {
            this.f2403b = adVar;
            this.f2402a = view;
        }

        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f2402a.getWindowVisibleDisplayFrame(rect);
            if (this.f2403b.f2430a != null) {
                this.f2403b.m2497b((this.f2402a.getRootView().getHeight() - (rect.bottom - rect.top)) - ((this.f2403b.f2433d.f4572u - this.f2403b.f2430a.getHeight()) / 2));
            }
            this.f2403b.m2508k();
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.a */
    class C0706a extends View {
        Rect f2404a;
        final /* synthetic */ ad f2405b;

        public C0706a(ad adVar, Activity activity) {
            this.f2405b = adVar;
            super(activity);
            this.f2404a = new Rect();
        }

        public void onDraw(Canvas canvas) {
            canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
            getDrawingRect(this.f2404a);
            this.f2405b.av.m2405a(canvas, (this.f2404a.width() - this.f2405b.av.f2176f) / 2, (this.f2404a.height() - this.f2405b.av.f2177g) / 2);
            invalidate();
        }
    }

    /* renamed from: com.jirbo.adcolony.ad.b */
    class C0707b extends Handler {
        final /* synthetic */ ad f2406a;

        C0707b(ad adVar) {
            this.f2406a = adVar;
            m2488a();
        }

        void m2488a() {
            sendMessageDelayed(obtainMessage(), 500);
        }

        public void handleMessage(Message m) {
            m2488a();
            if (!this.f2406a.f2433d.isFinishing() && this.f2406a.f2433d.f4542G != null) {
                synchronized (this) {
                    if (!(this.f2406a.ag == null || !this.f2406a.ag.m2474a() || this.f2406a.f2433d.f4542G.isPlaying())) {
                        this.f2406a.ag = null;
                        this.f2406a.f2449t = 0;
                        if (this.f2406a.f2433d.f4542G != null) {
                            this.f2406a.f2433d.f4542G.m2587a();
                        }
                        this.f2406a.f2433d.f4565n = true;
                        this.f2406a.m2504g();
                    }
                }
            }
        }
    }

    static {
        aB = new float[80];
    }

    ad(ADCVideo aDCVideo) {
        super(aDCVideo);
        this.f2434e = 1.0d;
        this.f2435f = 1.0d;
        this.f2436g = 99;
        this.f2437h = 0;
        this.f2454y = true;
        this.f2455z = true;
        this.f2407A = true;
        this.f2408B = true;
        this.f2409C = true;
        this.f2410D = true;
        this.aa = C0694a.f2372l.f2512a.f2486b;
        this.ah = new Paint();
        this.ai = new Paint(1);
        this.aj = new Paint(1);
        this.ak = new Paint(1);
        this.al = new Rect();
        this.ax = new ADCImage[4];
        this.ay = new ADCImage[4];
        this.aA = new String[4];
        this.aJ = new Paint(1);
        this.aK = new RectF();
        this.aL = new C0707b(this);
        this.aM = new C06982(this);
        this.f2433d = aDCVideo;
        this.f2419M = C0694a.f2372l.f2512a.f2503t;
        if (C0694a.f2354T != null) {
            this.f2419M |= C0694a.f2354T.f2214j.f2653z.f2671l.f2759a;
            C0694a.f2354T.f2220p = C0694a.f2354T.f2221q;
        }
        this.f2453x = aDCVideo.getResources().getDisplayMetrics().density;
        this.f2423Q = C0694a.f2359Y;
        if (!(C0694a.ad == null || C0694a.f2365e == null)) {
            int indexOf = C0694a.ad.indexOf("#");
            C0694a.ad = C0694a.f2365e + (indexOf >= 0 ? C0694a.ad.substring(indexOf) : XMLConstants.NULL_NS_URI);
        }
        aDCVideo.f4544I.f2219o = C0694a.ad;
        C0726l.f2610a.m2653a("DEC URL = ").m2657b(aDCVideo.f4544I.f2219o);
        if (C0694a.f2354T != null && C0694a.f2354T.f2214j.f2652y.f2778d) {
            boolean z;
            if (this.f2423Q) {
                z = false;
            } else {
                z = true;
            }
            this.f2420N = z;
        }
        if (this.f2420N) {
            this.am = new ADCImage(C0694a.m2469j("end_card_filepath"));
            this.f2443n = this.am.f2176f;
            this.f2444o = this.am.f2177g;
            if (this.f2443n == 0) {
                this.f2443n = 480;
            }
            if (this.f2444o == 0) {
                this.f2444o = 320;
            }
            this.ax[0] = new ADCImage(C0694a.m2469j("info_image_normal"));
            this.ax[1] = new ADCImage(C0694a.m2469j("download_image_normal"));
            this.ax[2] = new ADCImage(C0694a.m2469j("replay_image_normal"));
            this.ax[3] = new ADCImage(C0694a.m2469j("continue_image_normal"));
            this.ay[0] = new ADCImage(C0694a.m2469j("info_image_down"), true);
            this.ay[1] = new ADCImage(C0694a.m2469j("download_image_down"), true);
            this.ay[2] = new ADCImage(C0694a.m2469j("replay_image_down"), true);
            this.ay[3] = new ADCImage(C0694a.m2469j("continue_image_down"), true);
            this.aA[0] = "Info";
            this.aA[1] = "Download";
            this.aA[2] = "Replay";
            this.aA[3] = "Continue";
        } else if (this.f2423Q) {
            this.ar = new ADCImage(C0694a.m2469j("reload_image_normal"));
            this.ap = new ADCImage(C0694a.m2469j("close_image_normal"));
            this.aq = new ADCImage(C0694a.m2469j("close_image_down"));
            this.as = new ADCImage(C0694a.m2469j("reload_image_down"));
            this.av = new ADCImage(C0694a.m2469j("browser_icon"));
            this.f2432c = new C0706a(this, aDCVideo);
            m2496b();
        }
        if (this.f2419M) {
            this.an = new ADCImage(C0694a.m2469j("skip_video_image_normal"));
            this.ao = new ADCImage(C0694a.m2469j("skip_video_image_down"));
            this.f2445p = C0694a.m2466h("skip_delay") * 1000;
        }
        this.aJ.setStyle(Style.STROKE);
        float f = 2.0f * aDCVideo.getResources().getDisplayMetrics().density;
        if (f > 6.0f) {
            f = 6.0f;
        }
        if (f < 4.0f) {
            this.aJ.setStrokeWidth(2.0f * aDCVideo.getResources().getDisplayMetrics().density);
            this.aJ.setColor(-3355444);
            this.f2425S = false;
            this.f2418L = false;
            this.f2426T = false;
        } else {
            this.aJ.setStrokeWidth(2.0f * aDCVideo.getResources().getDisplayMetrics().density);
            this.aJ.setColor(-3355444);
            this.f2425S = false;
            this.f2418L = false;
            this.f2426T = false;
        }
        if (C0694a.f2354T != null) {
            this.f2418L = C0694a.f2354T.f2214j.f2653z.f2672m.f2759a;
            this.f2426T = C0694a.m2468i("image_overlay_enabled");
        }
        if (this.f2418L) {
            this.at = new ADCImage(C0694a.m2469j("engagement_image_normal"));
            this.au = new ADCImage(C0694a.m2469j("engagement_image_down"));
            this.ad = C0694a.f2354T.f2214j.f2653z.f2672m.f2768j;
            this.ab = C0694a.f2354T.f2214j.f2653z.f2672m.f2770l;
            this.ac = C0694a.f2354T.f2214j.f2653z.f2672m.f2773o;
            this.f2447r = C0694a.f2354T.f2214j.f2653z.f2672m.f2761c;
            this.f2446q = C0694a.m2466h("engagement_delay") * 1000;
            if (this.ab.equals(XMLConstants.NULL_NS_URI)) {
                this.ab = "Learn More";
            }
            if (!this.ac.equals(XMLConstants.NULL_NS_URI)) {
                this.f2413G = true;
            }
            if (this.f2413G) {
                this.f2431b = new WebView(aDCVideo);
                this.f2431b.setBackgroundColor(0);
            }
            if (this.at == null || this.au == null) {
                this.f2418L = false;
            }
        }
        if (this.f2426T) {
            double d;
            this.aw = new ADCImage(C0694a.m2469j("image_overlay_filepath"));
            if (AdColony.isTablet()) {
                d = (((double) this.f2447r) * (((double) this.f2453x) / 1.0d)) / ((double) this.aw.f2177g);
            } else {
                d = (((double) this.f2447r) * (((double) this.f2453x) / 0.75d)) / ((double) this.aw.f2177g);
            }
            this.aw.m2401a(d);
        }
        if (ADCVideo.f4530d) {
            m2503f();
        }
        this.ah.setColor(-1);
        this.aj.setTextSize(24.0f);
        this.aj.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ai.setColor(-3355444);
        this.ai.setTextSize(20.0f);
        this.ai.setTextAlign(Align.CENTER);
        this.ak.setTextSize(20.0f);
        this.ak.setColor(-1);
        try {
            getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
        } catch (Exception e) {
        }
    }

    public void onDraw(Canvas canvas) {
        if (!this.f2412F) {
            m2490a();
            this.f2429W = canvas;
            if (!this.f2421O && this.f2419M) {
                this.f2421O = this.f2433d.f4542G.getCurrentPosition() > this.f2445p;
            }
            if (!this.f2422P && this.f2418L) {
                this.f2422P = this.f2433d.f4542G.getCurrentPosition() > this.f2446q;
            }
            ADCVideo aDCVideo = this.f2433d;
            int c;
            int i;
            if (ADCVideo.f4530d && this.f2420N) {
                canvas.drawARGB((this.f2433d.f4577z >> 24) & MotionEventCompat.ACTION_MASK, 0, 0, 0);
                this.am.m2405a(canvas, (this.f2433d.f4571t - this.am.f2176f) / 2, (this.f2433d.f4572u - this.am.f2177g) / 2);
                c = this.am.m2408c() + ((int) (186.0d * this.f2434e));
                int d = this.am.m2410d() + ((int) (470.0d * this.f2434e));
                i = 0;
                while (i < this.ax.length) {
                    if (this.f2449t == i + 1 || !(this.f2450u != i + 1 || this.f2407A || this.f2450u == 0)) {
                        this.ay[i].m2401a(this.f2434e);
                        this.ay[i].m2405a(canvas, c, d);
                        c = (int) (((double) c) + (((double) 1125974016) * this.f2434e));
                    } else if (this.f2407A || i + 1 != this.f2450u) {
                        this.ax[i].m2401a(this.f2434e);
                        this.ax[i].m2405a(canvas, c, d);
                        c = (int) (((double) c) + (((double) 1125974016) * this.f2434e));
                    }
                    this.ai.setColor(-1);
                    this.ai.clearShadowLayer();
                    canvas.drawText(this.aA[i], ((float) this.ax[i].m2408c()) + ((float) (this.ax[i].f2176f / 2)), (float) (this.ax[i].m2410d() + this.ax[i].f2177g), this.ai);
                    i++;
                }
                return;
            }
            aDCVideo = this.f2433d;
            if (ADCVideo.f4530d && this.f2423Q) {
                this.ap.m2401a(this.f2435f);
                this.aq.m2401a(this.f2435f);
                this.ar.m2401a(this.f2435f);
                this.as.m2401a(this.f2435f);
                i = (C0694a.f2373m || this.f2438i == 0) ? this.f2433d.f4571t - this.ap.f2176f : this.f2438i;
                this.f2438i = i;
                this.f2439j = 0;
                this.f2440k = 0;
                this.f2441l = 0;
                if (this.f2414H) {
                    this.aq.m2405a(canvas, this.f2438i, this.f2439j);
                } else {
                    this.ap.m2405a(canvas, this.f2438i, this.f2439j);
                }
                if (this.f2415I) {
                    this.as.m2405a(canvas, this.f2440k, this.f2441l);
                } else {
                    this.ar.m2405a(canvas, this.f2440k, this.f2441l);
                }
                m2507j();
                return;
            }
            if (this.f2433d.f4542G != null) {
                int i2;
                C0694a.f2372l.m2548a(((double) this.f2433d.f4542G.getCurrentPosition()) / ((double) this.f2433d.f4542G.getDuration()), this.f2433d.f4544I);
                if (this.f2433d.f4547L) {
                    this.f2433d.f4545J.update((long) this.f2433d.f4542G.getCurrentPosition());
                }
                c = this.f2433d.f4542G.getCurrentPosition();
                i = ((this.f2448s - c) + 999) / 1000;
                if (this.f2425S && i == 1) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (i2 == 0) {
                    this.f2425S = true;
                }
                if (c >= 500) {
                    if (this.f2408B) {
                        this.aD = (float) (360.0d / (((double) this.f2448s) / 1000.0d));
                        this.f2408B = false;
                        Rect rect = new Rect();
                        this.ai.getTextBounds("0123456789", 0, 9, rect);
                        this.aG = (float) rect.height();
                    }
                    this.aE = (float) getWidth();
                    this.aF = (float) getHeight();
                    this.aH = this.aG;
                    this.aI = (((float) this.f2433d.f4572u) - this.aG) - ((float) this.f2442m);
                    this.aK.set(this.aH - (this.aG / 2.0f), this.aI - (2.0f * this.aG), this.aH + (2.0f * this.aG), this.aI + (this.aG / 2.0f));
                    this.aJ.setShadowLayer((float) ((int) (4.0d * this.f2434e)), 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
                    this.aC = (float) (((((double) this.f2448s) / 1000.0d) - (((double) c) / 1000.0d)) * ((double) this.aD));
                    canvas.drawArc(this.aK, 270.0f, this.aC, false, this.aJ);
                    aDCVideo = this.f2433d;
                    if (!ADCVideo.f4530d) {
                        this.ai.setColor(-3355444);
                        this.ai.setShadowLayer((float) ((int) (2.0d * this.f2434e)), 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
                        this.ai.setTextAlign(Align.CENTER);
                        this.ai.setLinearText(true);
                        canvas.drawText(XMLConstants.NULL_NS_URI + i2, this.aK.centerX(), (float) (((double) this.aK.centerY()) + (((double) this.ai.getFontMetrics().bottom) * 1.35d)), this.ai);
                    }
                    if (this.f2419M) {
                        aDCVideo = this.f2433d;
                        if (!ADCVideo.f4530d && this.f2421O) {
                            if (this.f2449t == 10) {
                                this.ao.m2405a(canvas, this.f2433d.f4571t - this.ao.f2176f, (int) (this.f2434e * 4.0d));
                            } else {
                                this.an.m2405a(canvas, this.f2433d.f4571t - this.an.f2176f, (int) (this.f2434e * 4.0d));
                            }
                        }
                    }
                    if (this.f2418L && this.f2422P) {
                        if (!this.f2413G && !this.f2426T) {
                            if (this.f2416J) {
                                this.au.m2409c((int) (((float) (this.f2433d.f4571t - this.au.f2176f)) - (this.aG / 2.0f)), ((this.f2433d.f4572u - this.au.f2177g) - this.f2442m) - ((int) (this.aG / 2.0f)));
                                this.au.m2404a(canvas);
                            } else {
                                this.at.m2409c((int) (((float) (this.f2433d.f4571t - this.at.f2176f)) - (this.aG / 2.0f)), ((this.f2433d.f4572u - this.at.f2177g) - this.f2442m) - ((int) (this.aG / 2.0f)));
                                this.at.m2404a(canvas);
                            }
                            this.aj.setTextAlign(Align.CENTER);
                            canvas.drawText(this.ab, (float) this.at.f2175e.centerX(), (float) (((double) this.at.f2175e.centerY()) + (((double) this.aj.getFontMetrics().bottom) * 1.35d)), this.aj);
                        } else if (!this.f2413G && this.f2426T) {
                            this.aw.m2409c((int) (((float) (this.f2433d.f4571t - this.aw.f2176f)) - (this.aG / 2.0f)), ((this.f2433d.f4572u - this.aw.f2177g) - this.f2442m) - ((int) (this.aG / 2.0f)));
                            this.aw.m2404a(canvas);
                        }
                    }
                }
                if (C1440v.f4637I != null) {
                    C1440v.f4637I.onDraw(canvas);
                }
            }
            aDCVideo = this.f2433d;
            if (ADCVideo.f4534h) {
                invalidate();
            }
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.f2442m = this.f2433d.f4572u - h;
        if (Build.MODEL.equals("Kindle Fire")) {
            this.f2442m = 20;
        }
        if (Build.MODEL.equals("SCH-I800")) {
            this.f2442m = 25;
        }
        if (Build.MODEL.equals("SHW-M380K") || Build.MODEL.equals("SHW-M380S") || Build.MODEL.equals("SHW-M380W")) {
            this.f2442m = 40;
        }
    }

    void m2491a(int i) {
        try {
            if (this.f2409C || i == 10) {
                this.f2409C = false;
                Object j;
                switch (i) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        this.f2449t = 0;
                        C0694a.m2450a("info", "{\"ad_slot\":" + C0694a.f2354T.f2213i.f2692r.f2460c + "}", this.f2433d.f4544I);
                        j = C0694a.m2469j("info_url");
                        C0726l.f2611b.m2653a("INFO ").m2657b(j);
                        if (!j.startsWith("market:") && !j.startsWith("amzn:")) {
                            AdColonyBrowser.url = j;
                            this.f2433d.startActivity(new Intent(this.f2433d, AdColonyBrowser.class));
                            break;
                        }
                        this.f2433d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(j)));
                        break;
                        break;
                    case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                        this.f2449t = 0;
                        C0694a.m2450a("download", "{\"ad_slot\":" + C0694a.f2354T.f2213i.f2692r.f2460c + "}", this.f2433d.f4544I);
                        j = C0694a.m2469j("download_url");
                        C0726l.f2611b.m2653a("DOWNLOAD ").m2657b(j);
                        if (!j.startsWith("market:") && !j.startsWith("amzn:")) {
                            AdColonyBrowser.url = j;
                            this.f2433d.startActivity(new Intent(this.f2433d, AdColonyBrowser.class));
                            break;
                        }
                        this.f2433d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(j)));
                        break;
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        this.f2449t = 0;
                        m2506i();
                        invalidate();
                        break;
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        this.f2449t = 0;
                        this.f2433d.f4542G.m2587a();
                        m2504g();
                        break;
                    case MetaData.DEFAULT_MAX_ADS /*10*/:
                        this.f2449t = 0;
                        m2505h();
                        break;
                    default:
                        this.f2449t = 0;
                        break;
                }
                new Handler().postDelayed(new C06971(this), 1500);
            }
        } catch (RuntimeException e) {
            this.f2409C = true;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (C1440v.f4637I != null) {
            C1440v.f4637I.onTouchEvent(event);
            return true;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        ADCVideo aDCVideo;
        if (action == 0) {
            aDCVideo = this.f2433d;
            if (!ADCVideo.f4530d || !this.f2423Q) {
                aDCVideo = this.f2433d;
                if (ADCVideo.f4530d && this.f2420N) {
                    x = (int) (((double) (event.getX() - ((float) this.am.m2408c()))) / (this.f2434e * 2.0d));
                    y = (int) (((double) (event.getY() - ((float) this.am.m2410d()))) / (this.f2434e * 2.0d));
                    if (this.f2449t == 0 && y >= 235 && y < 305) {
                        action = m2489a(x, y);
                        this.f2449t = action;
                        this.f2450u = action;
                        this.f2407A = false;
                        invalidate();
                    }
                }
                if (this.f2419M && this.f2421O && this.f2433d.f4542G != null && m2494a(this.an, r1, r0)) {
                    this.f2449t = 10;
                    this.f2450u = this.f2449t;
                    this.f2407A = false;
                    invalidate();
                    return true;
                } else if (this.f2418L && this.f2422P && (m2494a(this.at, r1, r0) || m2494a(this.aw, r1, r0))) {
                    this.f2416J = true;
                    invalidate();
                    return true;
                }
            } else if (m2494a(this.ap, x, y)) {
                this.f2414H = true;
                invalidate();
                return true;
            } else if (!m2494a(this.ar, x, y)) {
                return false;
            } else {
                this.f2415I = true;
                invalidate();
                return true;
            }
        } else if (action == 1) {
            aDCVideo = this.f2433d;
            if (ADCVideo.f4530d && this.f2423Q) {
                if (m2494a(this.ap, x, y) && this.f2414H) {
                    this.f2449t = 4;
                    if (this.f2430a != null) {
                        this.f2430a.clearCache(true);
                    }
                    this.aM.sendMessageDelayed(this.aM.obtainMessage(this.f2449t), 250);
                    return true;
                } else if (m2494a(this.ar, x, y) && this.f2415I) {
                    this.f2449t = 3;
                    if (this.f2430a != null) {
                        this.f2430a.clearCache(true);
                    }
                    this.aM.sendMessageDelayed(this.aM.obtainMessage(this.f2449t), 250);
                    return true;
                }
            }
            aDCVideo = this.f2433d;
            if (ADCVideo.f4530d && this.f2420N) {
                x = (int) (((double) (event.getX() - ((float) this.am.m2408c()))) / (this.f2434e * 2.0d));
                y = (int) (((double) (event.getY() - ((float) this.am.m2410d()))) / (this.f2434e * 2.0d));
                if (!this.f2407A && y >= 235 && y < 305) {
                    action = m2489a(x, y);
                    if (action > 0 && action == this.f2450u) {
                        this.aM.sendMessageDelayed(this.aM.obtainMessage(action), 250);
                    }
                }
            }
            if (this.f2419M && this.f2421O && this.f2433d.f4542G != null && m2494a(this.an, r1, r0)) {
                this.f2449t = 10;
                this.f2407A = true;
                this.f2450u = this.f2449t;
                this.aM.sendMessageDelayed(this.aM.obtainMessage(this.f2449t), 250);
                return true;
            } else if (this.f2418L && this.f2422P && (m2494a(this.at, r1, r0) || m2494a(this.aw, r1, r0))) {
                this.f2416J = false;
                if (this.ad.startsWith("market:") || this.ad.startsWith("amzn:")) {
                    this.f2433d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.ad)));
                } else if (this.f2433d.f4544I.f2214j.f2627B == null || !this.f2433d.f4544I.f2214j.f2627B.f2656c) {
                    AdColonyBrowser.url = this.ad;
                    this.f2433d.startActivity(new Intent(this.f2433d, AdColonyBrowser.class));
                } else {
                    this.ae = this.f2433d.f4544I.f2218n;
                    this.f2433d.f4544I.f2230z = AdColonyIAPEngagement.OVERLAY;
                    this.f2418L = false;
                    this.f2427U = true;
                    this.f2426T = false;
                    m2505h();
                }
                C0694a.m2450a("in_video_engagement", "{\"ad_slot\":" + C0694a.f2354T.f2213i.f2692r.f2460c + "}", this.f2433d.f4544I);
                return true;
            } else {
                this.f2414H = false;
                this.f2415I = false;
                this.f2416J = false;
                this.f2407A = true;
                this.f2449t = 0;
                invalidate();
                return true;
            }
        } else if (action == 3) {
            this.f2414H = false;
            this.f2415I = false;
            this.f2416J = false;
            this.f2407A = true;
            this.f2449t = 0;
            invalidate();
            return true;
        }
        return true;
    }

    int m2489a(int i, int i2) {
        if (i >= this.f2436g && i < this.f2436g + 62) {
            return 1;
        }
        if (i >= this.f2436g + 78 && i < (this.f2436g + 78) + 62) {
            return 2;
        }
        if (i >= (this.f2436g + 78) + 78 && i < ((this.f2436g + 78) + 78) + 62) {
            return 3;
        }
        if (i >= ((this.f2436g + 78) + 78) + 78 && i < (((this.f2436g + 78) + 78) + 78) + 62) {
            return 4;
        }
        if (this.f2433d.f4542G == null || !this.f2419M || i < this.f2433d.f4542G.getWidth() - this.an.f2176f || i2 > this.an.f2177g) {
            return 0;
        }
        return 10;
    }

    public boolean m2494a(ADCImage aDCImage, int i, int i2) {
        if (aDCImage != null && i < (aDCImage.m2408c() + aDCImage.f2176f) + 8 && i > aDCImage.m2408c() - 8 && i2 < (aDCImage.m2410d() + aDCImage.f2177g) + 8 && i2 > aDCImage.m2410d() - 8) {
            return true;
        }
        return false;
    }

    public void m2490a() {
        boolean b = this.f2433d.m5301b();
        this.f2454y |= b;
        if (this.f2433d.f4542G != null) {
            if (this.f2448s <= 0) {
                this.f2448s = this.f2433d.f4542G.getDuration();
            }
            if (b) {
                setLayoutParams(new LayoutParams(this.f2433d.f4571t, this.f2433d.f4572u, 17));
                this.f2433d.f4542G.setLayoutParams(new LayoutParams(this.f2433d.f4575x, this.f2433d.f4576y, 17));
                this.f2454y = true;
            }
        }
        if (this.f2454y) {
            double sqrt;
            this.f2454y = false;
            if (this.f2455z) {
                DisplayMetrics displayMetrics = AdColony.activity().getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
                float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
                sqrt = Math.sqrt((double) ((displayMetrics.heightPixels * displayMetrics.heightPixels) + (displayMetrics.widthPixels * displayMetrics.widthPixels))) / Math.sqrt((double) ((f * f) + (f2 * f2)));
                this.f2435f = sqrt / 280.0d < 0.7d ? 0.7d : sqrt / 280.0d;
                if (!AdColony.isTablet() && this.f2435f == 0.7d) {
                    this.f2435f = 1.0d;
                }
                float f3 = this.f2435f * 20.0d < 18.0d ? 18.0f : (float) (this.f2435f * 20.0d);
                if (this.f2435f * 20.0d < 18.0d) {
                    f = 18.0f;
                } else {
                    f = (float) (this.f2435f * 20.0d);
                }
                this.ai.setTextSize(f3);
                this.ak.setTextSize(f3);
                this.aj.setTextSize(f);
                if (!(!this.f2418L || this.at == null || this.au == null)) {
                    this.at.m2403a(m2495b(this.ab + (this.at.f2176f * 2)), this.at.f2177g);
                    this.au.m2403a(m2495b(this.ab + (this.au.f2176f * 2)), this.au.f2177g);
                }
                int i;
                if (this.f2433d.f4571t > this.f2433d.f4572u) {
                    i = this.f2433d.f4572u;
                } else {
                    i = this.f2433d.f4571t;
                }
                this.f2455z = false;
            }
            if (this.f2423Q) {
                if (b && this.f2430a != null) {
                    this.f2430a.setLayoutParams(new LayoutParams(this.f2433d.f4571t, this.f2433d.f4572u - this.f2442m, 17));
                }
                this.f2434e = ((double) this.f2433d.f4576y) / 640.0d < 0.9d ? 0.9d : ((double) this.f2433d.f4576y) / 640.0d;
                if (!AdColony.isTablet() && this.f2434e == 0.9d) {
                    this.f2434e = 1.2d;
                }
            }
            if (this.f2420N) {
                double d = (double) (this.f2443n / this.f2444o);
                sqrt = ((double) this.f2433d.f4571t) / d > ((double) this.f2433d.f4572u) / 1.0d ? ((double) this.f2433d.f4572u) / 1.0d : ((double) this.f2433d.f4571t) / d;
                this.f2433d.f4575x = (int) (d * sqrt);
                this.f2433d.f4576y = (int) (sqrt * 1.0d);
                this.f2434e = this.f2433d.f4571t > this.f2433d.f4572u ? ((double) this.f2433d.f4576y) / 640.0d : ((double) this.f2433d.f4576y) / 960.0d;
                if (((double) this.f2433d.f4571t) / ((double) this.f2443n) > ((double) this.f2433d.f4572u) / ((double) this.f2444o)) {
                    sqrt = ((double) this.f2433d.f4572u) / ((double) this.f2444o);
                } else {
                    sqrt = ((double) this.f2433d.f4571t) / ((double) this.f2443n);
                }
                this.am.m2401a(sqrt);
                this.am.m2411d(this.f2433d.f4571t, this.f2433d.f4572u);
            }
            if (!(!this.f2418L || this.at == null || this.au == null)) {
                if (this.at == null || this.au == null || this.at.f2172b == null || this.au.f2172b == null) {
                    this.f2418L = false;
                } else {
                    int height = (int) (((double) this.au.f2172b.getHeight()) * this.f2435f);
                    this.at.m2406b(this.at.f2176f, (int) (((double) this.at.f2172b.getHeight()) * this.f2435f));
                    this.au.m2406b(this.au.f2176f, height);
                }
            }
            if (this.f2419M) {
                this.an.m2401a(this.f2435f);
                this.ao.m2401a(this.f2435f);
            }
        }
    }

    void m2496b() {
        this.f2430a = new WebView(this.f2433d);
        this.f2430a.setFocusable(true);
        this.f2430a.setHorizontalScrollBarEnabled(false);
        this.f2430a.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.f2430a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(PluginState.ON_DEMAND);
        settings.setBuiltInZoomControls(true);
        settings.setGeolocationEnabled(true);
        this.f2430a.setWebChromeClient(new C06993(this));
        this.f2433d.f4552Q = new FrameLayout(this.f2433d);
        if (C0694a.m2468i("hardware_acceleration_disabled")) {
            try {
                this.f2433d.f4552Q.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this.f2430a, new Object[]{Integer.valueOf(1), null});
            } catch (Exception e) {
            }
        }
        this.az = new C0729m(this.f2433d, this.f2430a, this.f2433d);
        this.f2430a.setWebViewClient(new C07004(this));
    }

    public void m2499c() {
        if (this.f2430a != null) {
            if (this.f2433d.f4544I.f2219o.startsWith("<")) {
                this.f2430a.loadData(this.f2433d.f4544I.f2219o, "text/html", null);
            } else {
                this.f2430a.loadDataWithBaseURL(this.f2433d.f4544I.f2219o, this.af, "text/html", null, null);
            }
            new C0720f("htmltest").m2599a(this.af);
            m2492a("var is_tablet=" + (C0694a.f2373m ? SchemaSymbols.ATTVAL_TRUE : SchemaSymbols.ATTVAL_FALSE) + ";");
            String str = C0694a.f2373m ? "tablet" : "phone";
            m2492a("adc_bridge.adc_version='" + C0694a.ag + "'");
            m2492a("adc_bridge.os_version='" + C0694a.af + "'");
            m2492a("adc_bridge.os_name='android'");
            m2492a("adc_bridge.device_type='" + str + "'");
            m2492a("adc_bridge.fireChangeEvent({state:'default'});");
            m2492a("adc_bridge.fireReadyEvent()");
        }
    }

    public void onCompletion(MediaPlayer player) {
        m2501d();
    }

    public void m2501d() {
        C0711d c0711d = C0694a.f2372l;
        ADCVideo aDCVideo = this.f2433d;
        c0711d.m2558a(ADCVideo.f4531e, this.f2433d.f4544I);
        if (this.f2423Q && this.f2410D && C0694a.ab) {
            this.f2433d.f4551P.addView(this.f2432c);
            new Handler().postDelayed(new C07015(this), (long) (C0694a.ac * 1000));
        }
        if (C0694a.f2360Z) {
            m2504g();
        }
        C0694a.m2448a("card_shown", this.f2433d.f4544I);
        synchronized (this.aL) {
            this.ag = null;
            if (C0694a.f2354T.f2214j.f2652y.f2779e) {
                this.ag = new C0696b(C0694a.f2354T.f2214j.f2652y.f2781g);
            }
        }
        if (this.f2423Q) {
            Handler handler = new Handler();
            View view = new View(this.f2433d);
            Runnable c07026 = new C07026(this, view);
            view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f2433d.f4551P.addView(view);
            handler.postDelayed(c07026, 500);
            this.f2433d.f4552Q.setVisibility(0);
        }
        this.f2433d.f4569r = System.currentTimeMillis();
        m2503f();
    }

    void m2502e() {
        this.f2430a.loadUrl(C0694a.ad);
        C0726l.f2610a.m2653a("Loading - end card url = ").m2657b(C0694a.ad);
    }

    void m2492a(String str) {
        if (!this.f2420N && this.f2430a != null) {
            if (VERSION.SDK_INT >= 19) {
                this.f2430a.evaluateJavascript(str, null);
            } else {
                this.f2430a.loadUrl("javascript:" + str);
            }
        }
    }

    void m2493a(boolean z) {
        if (!this.f2420N) {
            if (z) {
                m2492a("adc_bridge.fireChangeEvent({viewable:true});");
            } else {
                m2492a("adc_bridge.fireChangeEvent({viewable:false});");
            }
        }
    }

    void m2498b(boolean z) {
        if (!this.f2420N) {
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        m2500c(true);
        return true;
    }

    void m2503f() {
        new Handler().postDelayed(new C07037(this), 300);
        if (this.f2433d.f4547L) {
            this.f2433d.f4545J.stop();
        }
        ADCVideo aDCVideo = this.f2433d;
        ADCVideo.f4530d = true;
        if (this.f2433d.f4542G != null) {
            this.f2433d.f4542G.m2587a();
        }
        C1440v.f4637I = null;
        invalidate();
        this.f2415I = false;
        invalidate();
    }

    void m2504g() {
        if (this.f2433d == null) {
            return;
        }
        if (!this.f2423Q || (this.f2430a != null && this.f2433d.f4552Q != null && this.f2433d.f4551P != null)) {
            C0694a.f2347M = true;
            this.f2433d.f4570s = System.currentTimeMillis();
            ADCVideo aDCVideo = this.f2433d;
            aDCVideo.f4568q += ((double) (this.f2433d.f4570s - this.f2433d.f4569r)) / 1000.0d;
            C0694a.ak = true;
            for (int i = 0; i < C0694a.aq.size(); i++) {
                if (C0694a.aq.get(i) != null) {
                    ((AdColonyNativeAdView) C0694a.aq.get(i)).m2427a();
                }
            }
            try {
                this.f2433d.f4557V.close();
            } catch (Exception e) {
            }
            this.f2433d.finish();
            this.ag = null;
            if (this.f2423Q) {
                this.f2433d.f4551P.removeView(this.f2433d.f4552Q);
                this.f2430a.destroy();
                this.f2430a = null;
            }
            C0694a.m2443a(this.f2433d.f4544I);
            AdColonyBrowser.f2242A = true;
            C0694a.f2339E = true;
        }
    }

    void m2505h() {
        m2500c(false);
    }

    void m2500c(boolean z) {
        C0694a.f2347M = true;
        if (!C0694a.f2354T.m2421b() || z) {
            for (int i = 0; i < C0694a.aq.size(); i++) {
                if (C0694a.aq.get(i) != null) {
                    ((AdColonyNativeAdView) C0694a.aq.get(i)).m2427a();
                }
            }
            this.f2433d.finish();
            C0694a.f2357W.m2438b(this.f2433d.f4544I);
            C0694a.ak = true;
            C0694a.f2339E = true;
            AdColonyBrowser.f2242A = true;
            return;
        }
        ADCVideo aDCVideo = this.f2433d;
        ADCVideo.f4527a = this.f2433d.f4542G.getCurrentPosition();
        C1440v.f4637I = new C1440v(this.f2433d, (AdColonyV4VCAd) C0694a.f2354T);
    }

    void m2506i() {
        C0694a.m2448a("replay", this.f2433d.f4544I);
        ADCVideo aDCVideo = this.f2433d;
        ADCVideo.f4531e = true;
        aDCVideo = this.f2433d;
        ADCVideo.f4530d = false;
        aDCVideo = this.f2433d;
        ADCVideo.f4527a = 0;
        this.f2433d.f4544I.f2225u = true;
        this.f2433d.f4544I.f2220p = 0.0d;
        this.f2425S = false;
        View view = new View(this.f2433d);
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2433d.f4551P.addView(view, new LayoutParams(this.f2433d.f4571t, this.f2433d.f4572u, 17));
        new Handler().postDelayed(new C07048(this, view), 900);
        this.f2433d.f4542G.start();
        if (this.f2433d.f4547L) {
            try {
                this.f2433d.f4545J = HapticContentSDKFactory.GetNewSDKInstance(0, this.f2433d);
                this.f2433d.f4545J.openHaptics(this.f2433d.f4546K);
            } catch (Exception e) {
                this.f2433d.f4547L = false;
            }
            if (this.f2433d.f4545J == null) {
                this.f2433d.f4547L = false;
            }
            if (this.f2433d.f4547L) {
                this.f2433d.f4545J.play();
            }
        }
        C0694a.f2372l.m2550a(this.f2433d.f4544I);
        this.f2433d.f4542G.requestFocus();
        this.f2433d.f4542G.setBackgroundColor(0);
        this.f2433d.f4542G.setVisibility(0);
        m2493a(false);
    }

    int m2495b(String str) {
        this.aj.getTextWidths(str, aB);
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            f += aB[i];
        }
        return (int) f;
    }

    void m2507j() {
        getViewTreeObserver().addOnGlobalLayoutListener(new C07059(this, this));
    }

    void m2508k() {
        if (this.f2437h >= 70 && !this.f2411E) {
            this.f2411E = true;
            m2498b(true);
        } else if (this.f2411E && this.f2437h == 0) {
            this.f2411E = false;
            m2498b(false);
        }
    }

    void m2497b(int i) {
        this.f2437h = i;
        if (i < 0) {
            this.f2437h = 0;
        }
    }
}
