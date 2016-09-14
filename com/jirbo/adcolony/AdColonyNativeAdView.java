package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.C0756n.C0730a;
import com.jirbo.adcolony.C0756n.ad;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.FileInputStream;
import mf.javax.xml.XMLConstants;

public class AdColonyNativeAdView extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    boolean f2280A;
    boolean f2281B;
    boolean f2282C;
    boolean f2283D;
    boolean f2284E;
    boolean f2285F;
    boolean f2286G;
    boolean f2287H;
    boolean f2288I;
    boolean f2289J;
    boolean f2290K;
    String f2291L;
    AdColonyInterstitialAd f2292M;
    AdColonyNativeAdListener f2293N;
    AdColonyNativeAdMutedListener f2294O;
    ADCImage f2295P;
    ADCImage f2296Q;
    ADCImage f2297R;
    ImageView f2298S;
    C0689b f2299T;
    View f2300U;
    Bitmap f2301V;
    ADCImage f2302W;
    TextView f2303a;
    ad aA;
    C0730a aB;
    float aC;
    float aD;
    float aE;
    boolean aF;
    boolean aG;
    boolean aH;
    LayoutParams aI;
    LayoutParams aJ;
    FileInputStream aK;
    ImageView aa;
    boolean ab;
    Button ac;
    String ad;
    String ae;
    String af;
    MediaPlayer ag;
    Surface ah;
    String ai;
    String aj;
    String ak;
    String al;
    String am;
    String an;
    String ao;
    String ap;
    String aq;
    AdColonyIAPEngagement ar;
    int as;
    int at;
    int au;
    int av;
    int aw;
    int ax;
    int ay;
    int az;
    TextView f2304b;
    TextView f2305c;
    Activity f2306d;
    String f2307e;
    String f2308f;
    ViewGroup f2309g;
    SurfaceTexture f2310h;
    int f2311i;
    int f2312j;
    int f2313k;
    int f2314l;
    boolean f2315m;
    boolean f2316n;
    boolean f2317o;
    boolean f2318p;
    boolean f2319q;
    boolean f2320r;
    boolean f2321s;
    boolean f2322t;
    boolean f2323u;
    boolean f2324v;
    boolean f2325w;
    boolean f2326x;
    boolean f2327y;
    boolean f2328z;

    /* renamed from: com.jirbo.adcolony.AdColonyNativeAdView.1 */
    class C06851 implements OnTouchListener {
        final /* synthetic */ AdColonyNativeAdView f2272a;

        C06851(AdColonyNativeAdView adColonyNativeAdView) {
            this.f2272a = adColonyNativeAdView;
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                float[] fArr = new float[3];
                Color.colorToHSV(this.f2272a.ax, fArr);
                fArr[2] = fArr[2] * 0.8f;
                this.f2272a.ac.setBackgroundColor(Color.HSVToColor(fArr));
            } else if (action == 3) {
                this.f2272a.ac.setBackgroundColor(this.f2272a.ax);
            } else if (action == 1) {
                if (this.f2272a.f2289J) {
                    this.f2272a.ar = AdColonyIAPEngagement.OVERLAY;
                    this.f2272a.f2323u = true;
                } else {
                    if (this.f2272a.af.equals("install") || this.f2272a.af.equals(DatabaseOpenHelper.HISTORY_ROW_URL)) {
                        C0694a.f2372l.f2515d.m5359b("native_overlay_click", this.f2272a.f2292M);
                        try {
                            C0694a.m2452b().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f2272a.ae)));
                        } catch (Exception e) {
                            Toast.makeText(C0694a.m2452b(), "Unable to open store.", 0).show();
                        }
                    }
                    this.f2272a.ac.setBackgroundColor(this.f2272a.ax);
                }
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyNativeAdView.2 */
    class C06862 implements OnClickListener {
        final /* synthetic */ AdColonyNativeAdView f2273a;

        C06862(AdColonyNativeAdView adColonyNativeAdView) {
            this.f2273a = adColonyNativeAdView;
        }

        public void onClick(View v) {
            if (this.f2273a.f2320r) {
                if (this.f2273a.f2294O != null) {
                    this.f2273a.f2294O.onAdColonyNativeAdMuted(this.f2273a, true);
                }
                this.f2273a.m2432a(true, true);
                this.f2273a.f2326x = true;
            } else if (this.f2273a.f2301V == this.f2273a.f2297R.f2171a) {
                if (this.f2273a.f2294O != null) {
                    this.f2273a.f2294O.onAdColonyNativeAdMuted(this.f2273a, false);
                }
                this.f2273a.f2326x = false;
                this.f2273a.m2432a(false, true);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyNativeAdView.a */
    class C0688a extends TextureView implements SurfaceTextureListener {
        boolean f2275a;
        boolean f2276b;
        final /* synthetic */ AdColonyNativeAdView f2277c;

        /* renamed from: com.jirbo.adcolony.AdColonyNativeAdView.a.1 */
        class C06871 implements Runnable {
            final /* synthetic */ C0688a f2274a;

            C06871(C0688a c0688a) {
                this.f2274a = c0688a;
            }

            public void run() {
                if (!this.f2274a.f2277c.f2328z && !this.f2274a.f2277c.f2280A) {
                    this.f2274a.f2276b = false;
                    this.f2274a.f2277c.f2323u = true;
                    this.f2274a.f2277c.f2298S.setVisibility(8);
                }
            }
        }

        C0688a(AdColonyNativeAdView adColonyNativeAdView, Context context) {
            this(adColonyNativeAdView, context, false);
        }

        C0688a(AdColonyNativeAdView adColonyNativeAdView, Context context, boolean z) {
            this.f2277c = adColonyNativeAdView;
            super(context);
            this.f2275a = false;
            this.f2276b = false;
            setSurfaceTextureListener(this);
            setWillNotDraw(false);
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f2275a = z;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture texture, int w, int h) {
            if (texture == null) {
                this.f2277c.f2323u = true;
                this.f2277c.f2298S.setVisibility(8);
                return;
            }
            this.f2277c.f2299T.setVisibility(0);
            this.f2277c.f2310h = texture;
            if (!this.f2277c.f2323u && !this.f2275a) {
                this.f2277c.ah = new Surface(texture);
                if (this.f2277c.ag != null) {
                    this.f2277c.ag.release();
                }
                this.f2277c.f2311i = w;
                this.f2277c.f2312j = h;
                this.f2277c.ag = new MediaPlayer();
                try {
                    this.f2277c.aK = new FileInputStream(this.f2277c.f2308f);
                    this.f2277c.ag.setDataSource(this.f2277c.aK.getFD());
                    this.f2277c.ag.setSurface(this.f2277c.ah);
                    this.f2277c.ag.setOnCompletionListener(this.f2277c);
                    this.f2277c.ag.setOnPreparedListener(this.f2277c);
                    this.f2277c.ag.setOnErrorListener(this.f2277c);
                    this.f2277c.ag.prepareAsync();
                    C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Prepare called.");
                    this.f2276b = true;
                    Handler handler = new Handler();
                    Runnable c06871 = new C06871(this);
                    if (!this.f2276b) {
                        handler.postDelayed(c06871, 1800);
                    }
                } catch (Exception e) {
                    this.f2277c.f2323u = true;
                    this.f2277c.f2298S.setVisibility(8);
                }
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture texture, int w, int h) {
            C0726l.f2612c.m2657b((Object) "[ADC] onSurfaceTextureSizeChanged");
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
            C0726l.f2612c.m2657b((Object) "[ADC] Native surface destroyed");
            this.f2277c.f2328z = false;
            this.f2277c.f2298S.setVisibility(4);
            this.f2277c.f2299T.setVisibility(0);
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture texture) {
        }

        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            float x = event.getX();
            float y = event.getY();
            if (action == 1 && C0694a.f2339E && C0760q.m2793c() && (x <= ((float) ((this.f2277c.au - this.f2277c.f2296Q.f2176f) + 8)) || y >= ((float) (this.f2277c.f2296Q.f2177g + 8)) || this.f2277c.f2323u || this.f2277c.ag == null || !this.f2277c.ag.isPlaying())) {
                C0694a.f2354T = this.f2277c.f2292M;
                C0694a.f2372l.f2512a.m2542a(this.f2277c.f2307e, this.f2277c.f2292M.j);
                ADCVideo.m5299a();
                if (this.f2277c.f2290K) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f2277c.f2291L));
                        if (C0694a.f2350P != null) {
                            C0694a.m2452b().startActivity(intent);
                        }
                    } catch (Exception e) {
                        if (C0694a.f2350P != null) {
                            Toast.makeText(C0694a.m2452b(), "Unable to open store.", 0).show();
                        }
                    }
                } else {
                    this.f2277c.f2292M.k = "native";
                    this.f2277c.f2292M.l = "fullscreen";
                    this.f2277c.f2292M.t = true;
                    this.f2277c.f2292M.u = this.f2277c.f2282C;
                    if ((this.f2277c.f2328z || this.f2277c.f2323u) && C0760q.m2793c()) {
                        if (this.f2277c.f2293N != null) {
                            this.f2277c.f2293N.onAdColonyNativeAdStarted(true, this.f2277c);
                        }
                        if (this.f2277c.ag == null || !this.f2277c.ag.isPlaying()) {
                            this.f2277c.f2292M.q = 0.0d;
                            ADCVideo.f4529c = 0;
                        } else {
                            ADCVideo.f4529c = this.f2277c.ag.getCurrentPosition();
                            this.f2277c.f2292M.q = this.f2277c.f2292M.p;
                            this.f2277c.ag.pause();
                        }
                        C0694a.f2339E = false;
                        C0694a.f2372l.f2515d.m5359b("video_expanded", this.f2277c.f2292M);
                        if (C0694a.f2373m) {
                            C0726l.f2610a.m2657b((Object) "Launching AdColonyOverlay");
                            C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyOverlay.class));
                        } else {
                            C0726l.f2610a.m2657b((Object) "Launching AdColonyFullscreen");
                            C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyFullscreen.class));
                        }
                        if (this.f2277c.f2323u) {
                            af afVar = this.f2277c.f2292M.i.f2692r;
                            afVar.f2461d++;
                        }
                        this.f2277c.f2323u = true;
                        this.f2277c.f2282C = true;
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyNativeAdView.b */
    class C0689b extends View {
        boolean f2278a;
        final /* synthetic */ AdColonyNativeAdView f2279b;

        public C0689b(AdColonyNativeAdView adColonyNativeAdView, Context context) {
            this.f2279b = adColonyNativeAdView;
            super(context);
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }

        public void onDraw(Canvas canvas) {
            this.f2279b.f2309g = (ViewGroup) getParent().getParent();
            Rect rect = new Rect();
            if (!(this.f2279b.ag == null || this.f2279b.ag.isPlaying() || !this.f2279b.f2316n)) {
                this.f2278a = false;
            }
            if (getLocalVisibleRect(rect) && VERSION.SDK_INT >= 14 && this.f2279b.f2328z) {
                if ((!this.f2279b.f2316n || (this.f2279b.f2316n && (rect.top == 0 || rect.bottom - rect.top > this.f2279b.getNativeAdHeight()))) && rect.bottom - rect.top > this.f2279b.getNativeAdHeight() / 2 && rect.right - rect.left > this.f2279b.getNativeAdWidth() / 2) {
                    if (this.f2278a || this.f2279b.f2323u || this.f2279b.ag == null || this.f2279b.ag.isPlaying() || this.f2279b.f2280A || this.f2279b.f2292M.m5305a(true) || !this.f2279b.f2322t) {
                    }
                    if (!this.f2279b.f2322t) {
                        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Starting");
                        this.f2279b.m2433b();
                        this.f2279b.f2322t = true;
                        this.f2279b.f2292M.k = "native";
                        this.f2279b.f2292M.l = "native";
                    } else if (!this.f2279b.f2324v && this.f2279b.ag != null && C0760q.m2793c() && !this.f2279b.ag.isPlaying() && !C0694a.f2336B) {
                        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Resuming");
                        C0694a.f2372l.f2515d.m5359b("video_resumed", this.f2279b.f2292M);
                        if (!this.f2279b.f2320r) {
                            this.f2279b.m2436c(true);
                        }
                        this.f2279b.setVolume(this.f2279b.aD);
                        this.f2279b.ag.seekTo(this.f2279b.f2292M.r);
                        this.f2279b.ag.start();
                    } else if (!(this.f2279b.f2323u || this.f2279b.f2322t || (C0694a.f2372l.m2560a(this.f2279b.f2292M.h, true, false) && this.f2279b.aH))) {
                        this.f2279b.f2323u = true;
                        setVisibility(0);
                        this.f2279b.f2298S.setVisibility(8);
                    }
                }
                this.f2278a = true;
            } else {
                this.f2278a = false;
            }
            if (!(this.f2279b.f2323u || C0760q.m2793c() || this.f2279b.ag == null || this.f2279b.ag.isPlaying())) {
                setVisibility(0);
                this.f2279b.f2298S.setVisibility(8);
                this.f2279b.f2323u = true;
            }
            if (!this.f2279b.f2323u && this.f2279b.ag != null && this.f2279b.ag.isPlaying()) {
                setVisibility(4);
                this.f2279b.f2298S.setVisibility(0);
            } else if (this.f2279b.f2323u || this.f2279b.f2324v) {
                canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
                this.f2279b.f2298S.setVisibility(8);
                this.f2279b.f2295P.m2405a(canvas, (this.f2279b.au - this.f2279b.f2295P.f2176f) / 2, (this.f2279b.av - this.f2279b.f2295P.f2177g) / 2);
            }
            if (!this.f2279b.f2280A && !this.f2279b.f2323u) {
                invalidate();
            }
        }
    }

    public AdColonyNativeAdView(Activity context, String zone_id, int width) {
        super(context);
        this.f2281B = true;
        this.f2283D = true;
        this.ab = false;
        this.ad = XMLConstants.NULL_NS_URI;
        this.ae = XMLConstants.NULL_NS_URI;
        this.af = XMLConstants.NULL_NS_URI;
        this.ap = XMLConstants.NULL_NS_URI;
        this.aq = XMLConstants.NULL_NS_URI;
        this.ar = AdColonyIAPEngagement.NONE;
        this.av = -1;
        this.ax = -3355444;
        this.ay = ViewCompat.MEASURED_STATE_MASK;
        this.aC = 0.25f;
        this.aD = 0.25f;
        m2429a(context, zone_id, width);
        m2427a();
    }

    public AdColonyNativeAdView(Activity context, String zone_id, int width, int height) {
        super(context);
        this.f2281B = true;
        this.f2283D = true;
        this.ab = false;
        this.ad = XMLConstants.NULL_NS_URI;
        this.ae = XMLConstants.NULL_NS_URI;
        this.af = XMLConstants.NULL_NS_URI;
        this.ap = XMLConstants.NULL_NS_URI;
        this.aq = XMLConstants.NULL_NS_URI;
        this.ar = AdColonyIAPEngagement.NONE;
        this.av = -1;
        this.ax = -3355444;
        this.ay = ViewCompat.MEASURED_STATE_MASK;
        this.aC = 0.25f;
        this.aD = 0.25f;
        m2430a(context, zone_id, width, height);
        m2431a(false);
    }

    AdColonyNativeAdView(Activity context, String zone_id, int width, boolean is_private) {
        super(context);
        this.f2281B = true;
        this.f2283D = true;
        this.ab = false;
        this.ad = XMLConstants.NULL_NS_URI;
        this.ae = XMLConstants.NULL_NS_URI;
        this.af = XMLConstants.NULL_NS_URI;
        this.ap = XMLConstants.NULL_NS_URI;
        this.aq = XMLConstants.NULL_NS_URI;
        this.ar = AdColonyIAPEngagement.NONE;
        this.av = -1;
        this.ax = -3355444;
        this.ay = ViewCompat.MEASURED_STATE_MASK;
        this.aC = 0.25f;
        this.aD = 0.25f;
        this.f2286G = is_private;
        m2429a(context, zone_id, width);
        m2427a();
    }

    void m2429a(Activity activity, String str, int i) {
        m2430a(activity, str, i, 0);
    }

    void m2430a(Activity activity, String str, int i, int i2) {
        int i3;
        int i4;
        C0694a.m2460e();
        C0694a.am = 0;
        this.f2306d = activity;
        this.f2307e = str;
        this.au = i;
        this.f2313k = i;
        if (i2 != 0) {
            this.f2314l = i2;
            this.av = i2;
            this.f2317o = true;
        }
        this.f2320r = true;
        this.aE = C0694a.m2452b().getResources().getDisplayMetrics().density;
        Display defaultDisplay = C0694a.m2452b().getWindowManager().getDefaultDisplay();
        if (VERSION.SDK_INT >= 14) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i3 = point.x;
            i4 = point.y;
        } else {
            i3 = defaultDisplay.getWidth();
            i4 = defaultDisplay.getHeight();
        }
        if (i3 >= i4) {
            i3 = i4;
        }
        this.az = i3;
        this.f2292M = new AdColonyInterstitialAd(str);
        this.f2292M.k = "native";
        this.f2292M.l = "native";
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (!this.f2281B) {
            return;
        }
        if (!this.f2292M.m2422b(true) || this.f2292M.j == null || this.f2292M.j.f2626A == null) {
            if (!this.f2286G) {
                C0726l.f2613d.m2657b((Object) "AdColonyNativeAdView created while no ads are available, returning blank view.");
                this.f2292M.g = 5;
                C0694a.f2372l.f2515d.m5354a(str, this.f2292M);
            }
            this.aH = true;
            return;
        }
        this.aA = this.f2292M.i;
        if (!this.f2286G) {
            if (!this.f2286G) {
                C0694a.aq.add(this);
            }
            this.f2292M.i.m2700c();
            if (!this.f2292M.m5305a(true)) {
                this.aH = true;
            }
            this.f2292M.j.f2626A.f2837i = true;
            C0694a.f2372l.f2515d.m5354a(str, this.f2292M);
        }
    }

    public boolean isEngagementEnabled() {
        return this.ab;
    }

    public String getEngagementLabel() {
        if (this.ad == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return this.ad;
    }

    public String getEngagementCommand() {
        if (this.ae == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return this.ae;
    }

    public String getEngagementType() {
        if (this.af == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return this.af;
    }

    void m2427a() {
        m2431a(true);
    }

    void m2431a(boolean z) {
        this.f2328z = false;
        this.f2319q = false;
        setWillNotDraw(false);
        this.f2292M.x = this;
        if (this.f2281B) {
            if (C0694a.f2372l == null || C0694a.f2372l.f2512a == null || this.f2292M == null || this.f2292M.h == null || (!C0694a.f2372l.m2560a(this.f2292M.h, true, false) && this.aH)) {
                this.f2323u = true;
            } else {
                C0694a.f2372l.f2512a.m2544b(this.f2307e);
            }
            this.f2308f = C0694a.m2469j("video_filepath");
            this.ai = C0694a.m2469j("advertiser_name");
            this.aj = C0694a.m2469j("description");
            this.ak = C0694a.m2469j(DatabaseOpenHelper.HISTORY_ROW_TITLE);
            this.al = C0694a.m2469j("poster_image");
            this.am = C0694a.m2469j("unmute");
            this.an = C0694a.m2469j("mute");
            this.ao = C0694a.m2469j("thumb_image");
            this.ab = C0694a.m2468i("native_engagement_enabled");
            this.ad = C0694a.m2469j("native_engagement_label");
            this.ae = C0694a.m2469j("native_engagement_command");
            this.af = C0694a.m2469j("native_engagement_type");
            this.f2289J = C0694a.m2468i("v4iap_enabled");
            this.f2290K = C0694a.m2468i("click_to_install");
            this.f2291L = C0694a.m2469j("store_url");
            this.aq = C0694a.ad;
            if (this.f2289J) {
                this.ar = AdColonyIAPEngagement.AUTOMATIC;
            }
            this.ap = C0694a.m2469j("product_id");
            if (this.f2292M.j == null || this.f2292M.j.f2626A == null) {
                this.f2327y = true;
            } else {
                this.f2327y = this.f2292M.j.f2626A.f2830b;
            }
            if (this.aA != null) {
                this.aA.m2711m();
            }
            if (this.f2292M.j == null || this.f2292M.j.f2626A == null || !this.f2292M.j.f2626A.f2829a || this.f2292M.i == null) {
                C0694a.am = 13;
                return;
            }
            this.f2321s = true;
            if (this.f2286G) {
                return;
            }
        } else if (VERSION.SDK_INT < 14) {
            return;
        }
        if (this.f2281B) {
            float f;
            this.as = this.f2292M.j.f2653z.f2661b;
            this.at = this.f2292M.j.f2653z.f2662c;
            C0694a.m2467h();
            if (this.av == -1) {
                this.av = (int) (((double) this.at) * (((double) this.au) / ((double) this.as)));
                this.f2314l = this.av;
            }
            if (!z && this.ab) {
                this.av -= this.av / 6;
            }
            float f2 = ((float) this.as) / ((float) this.at);
            if (((float) this.au) / ((float) this.as) > ((float) this.av) / ((float) this.at)) {
                this.aG = true;
                this.au = (int) (((float) this.av) * f2);
            } else {
                this.aF = true;
                this.av = (int) (((float) this.au) / f2);
            }
            this.aJ = new LayoutParams(this.au, this.av, 48);
            this.aI = new LayoutParams(this.f2313k, this.f2314l, 48);
            if (this.ab && !z && this.aF) {
                this.aJ.setMargins(0, ((this.f2314l - this.av) / 2) - (this.av / 10), 0, 0);
                this.aI.setMargins(0, ((this.f2314l - this.av) / 2) - (this.av / 10), 0, (((this.f2314l - this.av) / 2) - (this.av / 10)) * -1);
            } else if (!z && this.aF) {
                this.aJ.setMargins(0, (this.f2314l - this.av) / 2, 0, 0);
                this.aI.setMargins(0, (this.f2314l - this.av) / 2, 0, ((this.f2314l - this.av) / 2) * -1);
            } else if (this.ab && !z && this.aG) {
                this.aJ.setMargins((this.f2313k - this.au) / 2, 0, 0, 0);
                this.aI.setMargins((this.f2313k - this.au) / 2, 0, ((this.f2313k - this.au) / 2) * -1, 0);
            } else if (!z && this.aG) {
                this.aJ.setMargins((this.f2313k - this.au) / 2, 0, 0, 0);
                this.aI.setMargins((this.f2313k - this.au) / 2, 0, ((this.f2313k - this.au) / 2) * -1, 0);
            }
            this.f2295P = new ADCImage(this.al, true, false);
            if (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (((float) this.f2295P.f2176f) / ((float) this.au)) > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (((float) this.f2295P.f2177g) / ((float) this.av))) {
                f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (((float) this.f2295P.f2177g) / ((float) this.av));
            } else {
                f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / (((float) this.f2295P.f2176f) / ((float) this.au));
            }
            this.f2295P.m2402a((double) f, true);
            this.f2281B = false;
        }
        if (this.ab) {
            this.ac = new Button(C0694a.m2452b());
            this.ac.setText(this.ad);
            this.ac.setGravity(17);
            this.ac.setTextSize((float) ((int) (18.0d * (((double) this.au) / ((double) this.az)))));
            this.ac.setPadding(0, 0, 0, 0);
            this.ac.setBackgroundColor(this.ax);
            this.ac.setTextColor(this.ay);
            this.ac.setOnTouchListener(new C06851(this));
        }
        this.f2297R = new ADCImage(this.am, true, false);
        this.f2296Q = new ADCImage(this.an, true, false);
        this.f2302W = new ADCImage(this.ao, true, false);
        this.f2302W.m2402a((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / ((float) (((double) (((float) this.f2302W.f2176f) / ((float) this.au))) / ((((double) this.au) / 5.5d) / ((double) ((float) this.au)))))), true);
        this.f2296Q.m2402a((double) (this.aE / 2.0f), true);
        this.f2297R.m2402a((double) (this.aE / 2.0f), true);
        this.f2299T = new C0689b(this, C0694a.m2452b());
        this.aa = new ImageView(C0694a.m2452b());
        this.f2298S = new ImageView(C0694a.m2452b());
        this.aa.setImageBitmap(this.f2302W.f2171a);
        if (this.f2320r) {
            this.f2298S.setImageBitmap(this.f2296Q.f2171a);
        } else {
            this.f2298S.setImageBitmap(this.f2297R.f2171a);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(this.f2296Q.f2176f, this.f2296Q.f2177g, 48);
        layoutParams.setMargins(this.f2313k - this.f2296Q.f2176f, 0, 0, 0);
        this.f2298S.setOnClickListener(new C06862(this));
        this.f2301V = this.f2296Q.f2171a;
        if (this.f2323u) {
            this.f2298S.setVisibility(8);
        }
        if (this.f2324v) {
            this.f2298S.setVisibility(4);
        }
        if (VERSION.SDK_INT >= 14) {
            this.f2300U = new C0688a(this, C0694a.m2452b(), this.f2323u);
        }
        if (VERSION.SDK_INT >= 14) {
            addView(this.f2300U, this.aJ);
        }
        if (VERSION.SDK_INT < 14) {
            this.f2323u = true;
        }
        addView(this.f2299T, this.aI);
        if (this.f2327y && VERSION.SDK_INT >= 14 && this.f2283D) {
            addView(this.f2298S, layoutParams);
        }
        if (this.ab) {
            if (z) {
                layoutParams = new LayoutParams(this.f2313k, this.f2314l / 5, 80);
            } else {
                layoutParams = new LayoutParams(this.f2313k, this.av / 5, 80);
            }
            addView(this.ac, layoutParams);
        }
    }

    public boolean isReady() {
        if ((this.f2292M.m5305a(true) || !this.aH) && this.f2321s && !this.f2285F) {
            return true;
        }
        return false;
    }

    boolean m2434b(boolean z) {
        if ((this.f2292M.m5305a(true) || !this.aH) && AdColony.isZoneNative(this.f2307e)) {
            return true;
        }
        return false;
    }

    public int getNativeAdWidth() {
        return this.f2313k;
    }

    public int getNativeAdHeight() {
        return (this.f2317o || !this.ab) ? this.f2314l : this.f2314l + (this.f2314l / 5);
    }

    public void setOverlayButtonColor(int color) {
        if (this.ab) {
            this.ac.setBackgroundColor(color);
        }
        this.ax = color;
    }

    public void setOverlayButtonTextColor(int color) {
        if (this.ab) {
            this.ac.setTextColor(color);
        }
        this.ay = color;
    }

    public void setOverlayButtonTypeface(Typeface tf, int style) {
        if (this.ab) {
            this.ac.setTypeface(tf, style);
        }
    }

    void m2432a(boolean z, boolean z2) {
        if (z) {
            this.f2298S.setImageBitmap(this.f2297R.f2171a);
            this.f2320r = false;
            m2428a(0.0f, z2);
            this.f2301V = this.f2297R.f2171a;
        } else if (!this.f2326x && this.f2301V == this.f2297R.f2171a) {
            this.f2298S.setImageBitmap(this.f2296Q.f2171a);
            this.f2320r = true;
            if (this.ag != null) {
                if (((double) this.aD) != 0.0d) {
                    m2428a(this.aD, z2);
                } else {
                    m2428a(0.25f, z2);
                }
            }
            this.f2301V = this.f2296Q.f2171a;
        }
    }

    public void setMuted(boolean mute) {
        m2432a(mute, false);
    }

    public void destroy() {
        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Destroy called.");
        if (this.ah != null) {
            this.ah.release();
        }
        if (this.ag != null) {
            this.ag.release();
        }
        this.ag = null;
        this.f2292M.j.f2626A.f2837i = false;
        C0694a.aq.remove(this);
    }

    public ImageView getAdvertiserImage() {
        if (this.f2302W == null) {
            this.f2302W = new ADCImage(this.ao, true, false);
            this.f2302W.m2402a((double) (this.aE / 2.0f), true);
        }
        if (this.aa == null) {
            this.aa = new ImageView(C0694a.m2452b());
            this.aa.setImageBitmap(this.f2302W.f2171a);
        }
        return this.aa;
    }

    public String getTitle() {
        return this.ak;
    }

    public String getAdvertiserName() {
        return this.ai;
    }

    public String getDescription() {
        return this.aj;
    }

    public boolean canceled() {
        return this.f2288I;
    }

    public boolean iapEnabled() {
        return this.f2289J;
    }

    public String iapProductID() {
        return this.ap;
    }

    public AdColonyIAPEngagement iapEngagementType() {
        if (this.f2292M == null || this.f2292M.z != AdColonyIAPEngagement.END_CARD) {
            return this.ar;
        }
        return AdColonyIAPEngagement.END_CARD;
    }

    public AdColonyNativeAdView withListener(AdColonyNativeAdListener listener) {
        this.f2293N = listener;
        this.f2292M.f4580C = listener;
        return this;
    }

    public AdColonyNativeAdView withMutedListener(AdColonyNativeAdMutedListener mute_listener) {
        this.f2294O = mute_listener;
        return this;
    }

    public void pause() {
        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Pause called.");
        if (this.ag != null && !this.f2323u && this.ag.isPlaying() && VERSION.SDK_INT >= 14) {
            C0694a.f2372l.f2515d.m5359b("video_paused", this.f2292M);
            this.f2324v = true;
            this.ag.pause();
            this.f2299T.setVisibility(0);
            this.f2298S.setVisibility(4);
        }
    }

    public void resume() {
        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad Resume called.");
        if (this.ag != null && this.f2324v && !this.f2323u && VERSION.SDK_INT >= 14) {
            C0694a.f2372l.f2515d.m5359b("video_resumed", this.f2292M);
            this.f2324v = false;
            this.ag.seekTo(this.f2292M.r);
            this.ag.start();
            this.f2299T.setVisibility(4);
            this.f2298S.setVisibility(0);
        }
    }

    void m2436c(boolean z) {
        if (this.ag != null && this.f2298S != null) {
            if (z) {
                this.ag.setVolume(0.0f, 0.0f);
                this.f2298S.setImageBitmap(this.f2297R.f2171a);
                this.f2301V = this.f2297R.f2171a;
                return;
            }
            this.ag.setVolume(this.aD, this.aD);
            this.f2298S.setImageBitmap(this.f2296Q.f2171a);
            this.f2301V = this.f2296Q.f2171a;
        }
    }

    void m2428a(float f, boolean z) {
        if (VERSION.SDK_INT >= 14) {
            this.aD = f;
            if (this.ag != null && ((double) f) >= 0.0d && ((double) f) <= 1.0d) {
                if (!this.f2326x) {
                    this.ag.setVolume(f, f);
                }
                if (!this.f2328z) {
                    return;
                }
                C1423g c1423g;
                if (this.f2301V == this.f2297R.f2171a && ((double) f) > 0.0d && !this.f2326x) {
                    c1423g = new C1423g();
                    c1423g.m5278b("user_action", z);
                    this.f2298S.setImageBitmap(this.f2296Q.f2171a);
                    this.f2301V = this.f2296Q.f2171a;
                    C0694a.f2372l.f2515d.m5353a("sound_unmute", c1423g, this.f2292M);
                    this.f2320r = true;
                } else if (this.f2301V == this.f2296Q.f2171a && ((double) f) == 0.0d) {
                    c1423g = new C1423g();
                    c1423g.m5278b("user_action", z);
                    this.f2298S.setImageBitmap(this.f2297R.f2171a);
                    this.f2301V = this.f2297R.f2171a;
                    C0694a.f2372l.f2515d.m5353a("sound_mute", c1423g, this.f2292M);
                    this.f2320r = false;
                }
            } else if (((double) f) >= 0.0d && ((double) f) <= 1.0d) {
                this.aC = f;
            }
        }
    }

    public void setVolume(float v) {
        m2428a(v, false);
    }

    synchronized void m2433b() {
        if ((this.f2323u || this.ag == null || !this.ag.isPlaying()) && this.ag != null) {
            setVolume(this.aD);
            this.ag.start();
            C0694a.f2372l.m2550a(this.f2292M);
            this.f2292M.s = true;
            if (this.f2293N != null) {
                this.f2293N.onAdColonyNativeAdStarted(false, this);
            }
        }
    }

    void m2435c() {
        if (!this.f2323u && this.ag != null && this.ag.isPlaying() && !this.f2324v) {
            C0694a.f2372l.f2515d.m5359b("video_paused", this.f2292M);
            this.ag.pause();
        }
    }

    public void onPrepared(MediaPlayer player) {
        C0726l.f2612c.m2657b((Object) "[ADC] Native Ad onPrepared called.");
        this.f2328z = true;
        if (this.f2301V == null || this.f2296Q.f2171a == null) {
            this.f2299T.setVisibility(0);
            this.f2298S.setVisibility(8);
            this.f2323u = true;
            this.ag = null;
            this.f2292M.r = 0;
        } else if (this.f2320r || !this.f2301V.equals(this.f2296Q.f2171a)) {
            setVolume(this.aD);
        } else {
            m2436c(true);
        }
    }

    public void onCompletion(MediaPlayer player) {
        try {
            this.aK.close();
        } catch (Exception e) {
        }
        this.f2299T.setVisibility(0);
        this.f2298S.setVisibility(8);
        this.f2292M.k = "native";
        this.f2292M.l = "native";
        this.f2292M.s = true;
        this.f2323u = true;
        if (this.ag != null) {
            this.ag.release();
        }
        this.ag = null;
        this.f2292M.r = 0;
        C1423g c1423g = new C1423g();
        c1423g.m5276b("ad_slot", C0694a.f2372l.f2516e.f2970j);
        c1423g.m5278b("replay", false);
        C0694a.f2372l.f2515d.m5353a("native_complete", c1423g, this.f2292M);
        this.f2292M.j.f2645r = false;
        if (this.f2293N != null) {
            this.f2293N.onAdColonyNativeAdFinished(false, this);
        }
        this.f2282C = true;
    }

    public boolean onError(MediaPlayer player, int what, int extra) {
        this.f2299T.setVisibility(0);
        this.f2298S.setVisibility(8);
        this.f2323u = true;
        this.f2328z = true;
        this.ag = null;
        this.f2292M.r = 0;
        return true;
    }

    public void onDraw(Canvas canvas) {
        if (this.f2309g != null) {
            Rect rect = new Rect();
            if (!this.f2309g.hasFocus()) {
                this.f2309g.requestFocus();
            }
            if (!(this.f2323u || this.ag == null)) {
                this.aw = this.ag.getCurrentPosition();
            }
            if (this.aw != 0) {
                this.f2292M.r = this.aw;
            }
            getLocalVisibleRect(rect);
            boolean z = rect.bottom - rect.top > getNativeAdHeight() / 2 && rect.right - rect.left > getNativeAdWidth() / 2;
            if ((z || this.f2316n) && (!this.f2316n || (z && (rect.bottom - rect.top >= getNativeAdHeight() || rect.top == 0)))) {
                if (this.f2323u || this.ag == null || !this.ag.isPlaying()) {
                    if (!this.f2299T.f2278a) {
                        canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
                    }
                } else if (this.f2328z) {
                    this.f2292M.k = "native";
                    this.f2292M.l = "native";
                    C0694a.f2372l.m2548a(((double) this.ag.getCurrentPosition()) / ((double) this.ag.getDuration()), this.f2292M);
                    if (!this.f2287H) {
                        this.f2287H = true;
                        C0694a.f2372l.m2556a("native_start", "{\"ad_slot\":" + (C0694a.f2372l.f2516e.f2970j + 1) + ", \"replay\":false}", this.f2292M);
                        this.f2292M.j.f2645r = true;
                        this.f2292M.j.f2644q = true;
                        C0694a.m2467h();
                        this.f2292M.i.f2684j.m5235a(this.f2292M.j.f2628a);
                    }
                } else {
                    canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
                }
            } else if (!(this.f2323u || this.ag == null || !this.ag.isPlaying() || this.f2324v)) {
                C0726l.f2612c.m2657b((Object) "[ADC] Scroll Pause");
                C0694a.f2372l.f2515d.m5359b("video_paused", this.f2292M);
                this.ag.pause();
                this.f2299T.setVisibility(0);
            }
            if (!this.f2280A && !this.f2323u) {
                invalidate();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (VERSION.SDK_INT >= 14) {
            return false;
        }
        if (event.getAction() == 1 && C0694a.f2339E && C0760q.m2793c()) {
            if (this.f2290K) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f2291L));
                    if (C0694a.f2350P != null) {
                        C0694a.m2452b().startActivity(intent);
                    }
                } catch (Exception e) {
                    if (C0694a.f2350P != null) {
                        Toast.makeText(C0694a.m2452b(), "Unable to open store.", 0).show();
                    }
                }
            } else {
                C0694a.f2354T = this.f2292M;
                C0694a.f2372l.f2512a.m2542a(this.f2307e, this.f2292M.j);
                ADCVideo.m5299a();
                this.f2292M.u = this.f2282C;
                this.f2292M.t = true;
                this.f2292M.k = "native";
                this.f2292M.l = "fullscreen";
                C0694a.f2339E = false;
                C0694a.f2372l.f2515d.m5359b("video_expanded", this.f2292M);
                if (this.f2293N != null) {
                    this.f2293N.onAdColonyNativeAdStarted(true, this);
                }
                if (C0694a.f2373m) {
                    C0726l.f2610a.m2657b((Object) "Launching AdColonyOverlay");
                    C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyOverlay.class));
                } else {
                    C0726l.f2610a.m2657b((Object) "Launching AdColonyFullscreen");
                    C0694a.m2452b().startActivity(new Intent(C0694a.m2452b(), AdColonyFullscreen.class));
                }
                if (this.f2323u) {
                    this.f2292M.f = -1;
                    af afVar = this.f2292M.i.f2692r;
                    afVar.f2461d++;
                    this.f2292M.j.f2645r = true;
                }
                this.f2323u = true;
                this.f2282C = true;
            }
        }
        return true;
    }

    public void notifyAddedToListView() {
        if (this.f2315m) {
            ((C0688a) this.f2300U).onSurfaceTextureAvailable(this.f2310h, this.f2311i, this.f2312j);
        } else {
            this.f2315m = true;
        }
    }

    public void prepareForListView() {
        this.f2316n = true;
    }
}
