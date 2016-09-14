package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.android.volley.DefaultRetryPolicy;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;

public class AdColonyBrowser extends Activity {
    static boolean f2242A;
    static boolean f2243B;
    static boolean f2244C;
    static boolean f2245a;
    public static String url;
    static boolean f2246v;
    static boolean f2247w;
    static boolean f2248x;
    static boolean f2249y;
    static boolean f2250z;
    WebView f2251b;
    ADCImage f2252c;
    ADCImage f2253d;
    ADCImage f2254e;
    ADCImage f2255f;
    ADCImage f2256g;
    ADCImage f2257h;
    ADCImage f2258i;
    ADCImage f2259j;
    ADCImage f2260k;
    RelativeLayout f2261l;
    RelativeLayout f2262m;
    boolean f2263n;
    boolean f2264o;
    boolean f2265p;
    boolean f2266q;
    ProgressBar f2267r;
    DisplayMetrics f2268s;
    C0682a f2269t;
    C0684c f2270u;

    /* renamed from: com.jirbo.adcolony.AdColonyBrowser.1 */
    class C06801 extends WebChromeClient {
        final /* synthetic */ AdColonyBrowser f2231a;

        C06801(AdColonyBrowser adColonyBrowser) {
            this.f2231a = adColonyBrowser;
        }

        public void onProgressChanged(WebView view, int progress) {
            this.f2231a.setProgress(progress * 1000);
        }

        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            callback.invoke(origin, true, false);
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyBrowser.2 */
    class C06812 extends WebViewClient {
        final /* synthetic */ AdColonyBrowser f2232a;

        C06812(AdColonyBrowser adColonyBrowser) {
            this.f2232a = adColonyBrowser;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!url.startsWith("market://") && !url.startsWith("amzn://")) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (C0694a.f2355U != null) {
                C0694a.f2355U.startActivity(intent);
            }
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (!AdColonyBrowser.f2244C) {
                AdColonyBrowser.f2248x = true;
                AdColonyBrowser.f2249y = false;
                this.f2232a.f2267r.setVisibility(0);
            }
            this.f2232a.f2269t.invalidate();
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failing_url) {
            C0726l.f2613d.m2653a("Error viewing URL: ").m2657b((Object) description);
            this.f2232a.finish();
        }

        public void onPageFinished(WebView view, String url) {
            if (!AdColonyBrowser.f2244C) {
                AdColonyBrowser.f2249y = true;
                AdColonyBrowser.f2248x = false;
                this.f2232a.f2267r.setVisibility(4);
                AdColonyBrowser.f2246v = this.f2232a.f2251b.canGoBack();
                AdColonyBrowser.f2247w = this.f2232a.f2251b.canGoForward();
            }
            this.f2232a.f2269t.invalidate();
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyBrowser.a */
    class C0682a extends View {
        Rect f2233a;
        Paint f2234b;
        final /* synthetic */ AdColonyBrowser f2235c;

        public C0682a(AdColonyBrowser adColonyBrowser, Activity activity) {
            this.f2235c = adColonyBrowser;
            super(activity);
            this.f2233a = new Rect();
            this.f2234b = new Paint();
        }

        public void onDraw(Canvas canvas) {
            getDrawingRect(this.f2233a);
            int height = (this.f2235c.f2261l.getHeight() - this.f2235c.f2252c.f2177g) / 2;
            if (AdColonyBrowser.f2246v) {
                this.f2235c.f2259j.m2405a(canvas, this.f2235c.f2252c.f2176f, height);
            } else {
                this.f2235c.f2252c.m2405a(canvas, this.f2235c.f2252c.f2176f, height);
            }
            if (AdColonyBrowser.f2247w) {
                this.f2235c.f2260k.m2405a(canvas, (this.f2235c.f2252c.m2408c() + (this.f2235c.f2261l.getWidth() / 10)) + this.f2235c.f2252c.f2176f, height);
            } else {
                this.f2235c.f2255f.m2405a(canvas, (this.f2235c.f2252c.m2408c() + (this.f2235c.f2261l.getWidth() / 10)) + this.f2235c.f2252c.f2176f, height);
            }
            if (AdColonyBrowser.f2248x) {
                this.f2235c.f2253d.m2405a(canvas, (this.f2235c.f2255f.m2408c() + this.f2235c.f2255f.f2176f) + (this.f2235c.f2261l.getWidth() / 10), height);
            } else {
                this.f2235c.f2254e.m2405a(canvas, (this.f2235c.f2255f.m2408c() + this.f2235c.f2255f.f2176f) + (this.f2235c.f2261l.getWidth() / 10), height);
            }
            this.f2235c.f2256g.m2405a(canvas, this.f2235c.f2261l.getWidth() - (this.f2235c.f2256g.f2176f * 2), height);
            if (this.f2235c.f2263n) {
                this.f2235c.f2257h.m2409c((this.f2235c.f2252c.m2408c() - (this.f2235c.f2257h.f2176f / 2)) + (this.f2235c.f2252c.f2176f / 2), (this.f2235c.f2252c.m2410d() - (this.f2235c.f2257h.f2177g / 2)) + (this.f2235c.f2252c.f2177g / 2));
                this.f2235c.f2257h.m2404a(canvas);
            }
            if (this.f2235c.f2264o) {
                this.f2235c.f2257h.m2409c((this.f2235c.f2255f.m2408c() - (this.f2235c.f2257h.f2176f / 2)) + (this.f2235c.f2255f.f2176f / 2), (this.f2235c.f2255f.m2410d() - (this.f2235c.f2257h.f2177g / 2)) + (this.f2235c.f2255f.f2177g / 2));
                this.f2235c.f2257h.m2404a(canvas);
            }
            if (this.f2235c.f2265p) {
                this.f2235c.f2257h.m2409c((this.f2235c.f2254e.m2408c() - (this.f2235c.f2257h.f2176f / 2)) + (this.f2235c.f2254e.f2176f / 2), (this.f2235c.f2254e.m2410d() - (this.f2235c.f2257h.f2177g / 2)) + (this.f2235c.f2254e.f2177g / 2));
                this.f2235c.f2257h.m2404a(canvas);
            }
            if (this.f2235c.f2266q) {
                this.f2235c.f2257h.m2409c((this.f2235c.f2256g.m2408c() - (this.f2235c.f2257h.f2176f / 2)) + (this.f2235c.f2256g.f2176f / 2), (this.f2235c.f2256g.m2410d() - (this.f2235c.f2257h.f2177g / 2)) + (this.f2235c.f2256g.f2177g / 2));
                this.f2235c.f2257h.m2404a(canvas);
            }
            m2424a();
        }

        public void m2424a() {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f2235c.f2267r.getWidth(), this.f2235c.f2267r.getHeight());
            layoutParams.topMargin = (this.f2235c.f2261l.getHeight() - this.f2235c.f2253d.f2177g) / 2;
            layoutParams.leftMargin = ((this.f2235c.f2261l.getWidth() / 10) + this.f2235c.f2253d.m2408c()) + this.f2235c.f2253d.f2176f;
            if (AdColonyBrowser.f2250z && this.f2235c.f2253d.m2408c() != 0) {
                this.f2235c.f2262m.removeView(this.f2235c.f2267r);
                this.f2235c.f2262m.addView(this.f2235c.f2267r, layoutParams);
                AdColonyBrowser.f2250z = false;
            }
            if (this.f2235c.f2267r.getLayoutParams() != null) {
                this.f2235c.f2267r.getLayoutParams().height = this.f2235c.f2253d.f2177g;
                this.f2235c.f2267r.getLayoutParams().width = this.f2235c.f2253d.f2176f;
            }
        }

        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0) {
                if (m2425a(this.f2235c.f2252c, x, y) && AdColonyBrowser.f2246v) {
                    this.f2235c.f2263n = true;
                    invalidate();
                    return true;
                } else if (m2425a(this.f2235c.f2255f, x, y) && AdColonyBrowser.f2247w) {
                    this.f2235c.f2264o = true;
                    invalidate();
                    return true;
                } else if (m2425a(this.f2235c.f2254e, x, y)) {
                    this.f2235c.f2265p = true;
                    invalidate();
                    return true;
                } else if (m2425a(this.f2235c.f2256g, x, y)) {
                    this.f2235c.f2266q = true;
                    invalidate();
                    return true;
                }
            }
            if (action == 1) {
                if (m2425a(this.f2235c.f2252c, x, y) && AdColonyBrowser.f2246v) {
                    this.f2235c.f2251b.goBack();
                    m2426b();
                    return true;
                } else if (m2425a(this.f2235c.f2255f, x, y) && AdColonyBrowser.f2247w) {
                    this.f2235c.f2251b.goForward();
                    m2426b();
                    return true;
                } else if (m2425a(this.f2235c.f2254e, x, y) && AdColonyBrowser.f2248x) {
                    this.f2235c.f2251b.stopLoading();
                    m2426b();
                    return true;
                } else if (m2425a(this.f2235c.f2254e, x, y) && !AdColonyBrowser.f2248x) {
                    this.f2235c.f2251b.reload();
                    m2426b();
                    return true;
                } else if (m2425a(this.f2235c.f2256g, x, y)) {
                    AdColonyBrowser.f2244C = true;
                    this.f2235c.f2251b.loadData(XMLConstants.NULL_NS_URI, "text/html", "utf-8");
                    AdColonyBrowser.f2247w = false;
                    AdColonyBrowser.f2246v = false;
                    AdColonyBrowser.f2248x = false;
                    m2426b();
                    this.f2235c.finish();
                    return true;
                } else {
                    m2426b();
                }
            }
            return false;
        }

        public void m2426b() {
            this.f2235c.f2263n = false;
            this.f2235c.f2264o = false;
            this.f2235c.f2265p = false;
            this.f2235c.f2266q = false;
            invalidate();
        }

        public boolean m2425a(ADCImage aDCImage, int i, int i2) {
            return i < (aDCImage.m2408c() + aDCImage.f2176f) + 16 && i > aDCImage.m2408c() - 16 && i2 < (aDCImage.m2410d() + aDCImage.f2177g) + 16 && i2 > aDCImage.m2410d() - 16;
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyBrowser.b */
    class C0683b extends View {
        Rect f2236a;
        final /* synthetic */ AdColonyBrowser f2237b;

        public C0683b(AdColonyBrowser adColonyBrowser, Activity activity) {
            this.f2237b = adColonyBrowser;
            super(activity);
            this.f2236a = new Rect();
        }

        public void onDraw(Canvas canvas) {
            if (!AdColonyBrowser.f2249y) {
                canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
                getDrawingRect(this.f2236a);
                this.f2237b.f2258i.m2405a(canvas, (this.f2236a.width() - this.f2237b.f2258i.f2176f) / 2, (this.f2236a.height() - this.f2237b.f2258i.f2177g) / 2);
                invalidate();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColonyBrowser.c */
    class C0684c extends View {
        Paint f2238a;
        ADCImage f2239b;
        ADCImage f2240c;
        final /* synthetic */ AdColonyBrowser f2241d;

        public C0684c(AdColonyBrowser adColonyBrowser, Activity activity) {
            this.f2241d = adColonyBrowser;
            super(activity);
            this.f2238a = new Paint();
            this.f2239b = new ADCImage(C0694a.m2469j("close_image_normal"));
            this.f2240c = new ADCImage(C0694a.m2469j("close_image_down"));
            try {
                getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
            } catch (Exception e) {
            }
            this.f2238a.setColor(-3355444);
            this.f2238a.setStrokeWidth(10.0f);
            this.f2238a.setStyle(Style.STROKE);
            this.f2238a.setShadowLayer(3.0f, 0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, ViewCompat.MEASURED_STATE_MASK);
        }

        public void onDraw(Canvas canvas) {
            canvas.drawRect(0.0f, 0.0f, (float) this.f2241d.f2261l.getWidth(), 10.0f, this.f2238a);
        }
    }

    public AdColonyBrowser() {
        this.f2263n = false;
        this.f2264o = false;
        this.f2265p = false;
        this.f2266q = false;
    }

    static {
        f2245a = true;
        f2246v = false;
        f2247w = false;
        f2248x = false;
        f2249y = false;
        f2250z = true;
        f2242A = false;
        f2243B = false;
        f2244C = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        f2243B = true;
        this.f2252c = new ADCImage(C0694a.m2469j("browser_back_image_normal"));
        this.f2253d = new ADCImage(C0694a.m2469j("browser_stop_image_normal"));
        this.f2254e = new ADCImage(C0694a.m2469j("browser_reload_image_normal"));
        this.f2255f = new ADCImage(C0694a.m2469j("browser_forward_image_normal"));
        this.f2256g = new ADCImage(C0694a.m2469j("browser_close_image_normal"));
        this.f2257h = new ADCImage(C0694a.m2469j("browser_glow_button"));
        this.f2258i = new ADCImage(C0694a.m2469j("browser_icon"));
        this.f2259j = new ADCImage(C0694a.m2469j("browser_back_image_normal"), true);
        this.f2260k = new ADCImage(C0694a.m2469j("browser_forward_image_normal"), true);
        this.f2268s = AdColony.activity().getResources().getDisplayMetrics();
        float f = ((float) this.f2268s.widthPixels) / this.f2268s.xdpi;
        float f2 = ((float) this.f2268s.heightPixels) / this.f2268s.ydpi;
        double sqrt = (Math.sqrt((double) ((this.f2268s.widthPixels * this.f2268s.widthPixels) + (this.f2268s.heightPixels * this.f2268s.heightPixels))) / Math.sqrt((double) ((f * f) + (f2 * f2)))) / 220.0d;
        if (sqrt > 1.8d) {
            sqrt = 1.8d;
        }
        f2250z = true;
        f2246v = false;
        f2247w = false;
        f2244C = false;
        this.f2252c.m2401a(sqrt);
        this.f2253d.m2401a(sqrt);
        this.f2254e.m2401a(sqrt);
        this.f2255f.m2401a(sqrt);
        this.f2256g.m2401a(sqrt);
        this.f2257h.m2401a(sqrt);
        this.f2259j.m2401a(sqrt);
        this.f2260k.m2401a(sqrt);
        this.f2267r = new ProgressBar(this);
        this.f2267r.setVisibility(4);
        this.f2262m = new RelativeLayout(this);
        this.f2261l = new RelativeLayout(this);
        this.f2261l.setBackgroundColor(-3355444);
        if (C0694a.f2373m) {
            this.f2261l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (((double) this.f2252c.f2177g) * 1.5d)));
        } else {
            this.f2261l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (((double) this.f2252c.f2177g) * 1.5d)));
        }
        requestWindowFeature(1);
        getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        getWindow().requestFeature(2);
        setVolumeControlStream(3);
        this.f2251b = new WebView(this);
        this.f2251b.getSettings().setJavaScriptEnabled(true);
        this.f2251b.getSettings().setBuiltInZoomControls(true);
        this.f2251b.getSettings().setUseWideViewPort(true);
        this.f2251b.getSettings().setLoadWithOverviewMode(true);
        this.f2251b.getSettings().setGeolocationEnabled(true);
        if (f2245a) {
            if (C0694a.f2373m) {
                setRequestedOrientation(C0694a.f2340F);
            } else if (VERSION.SDK_INT >= 10) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(0);
            }
        }
        f2245a = true;
        this.f2251b.setWebChromeClient(new C06801(this));
        this.f2251b.setWebViewClient(new C06812(this));
        this.f2269t = new C0682a(this, this);
        this.f2270u = new C0684c(this, this);
        this.f2262m.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        this.f2262m.addView(this.f2261l);
        this.f2261l.setId(12345);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f2268s.heightPixels - ((int) (((double) this.f2256g.f2177g) * 1.5d)));
        layoutParams.addRule(3, this.f2261l.getId());
        this.f2262m.addView(this.f2251b, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-2, 20);
        layoutParams.addRule(3, this.f2261l.getId());
        layoutParams.setMargins(0, -10, 0, 0);
        this.f2262m.addView(this.f2270u, layoutParams);
        int i = this.f2268s.widthPixels > this.f2268s.heightPixels ? this.f2268s.widthPixels : this.f2268s.heightPixels;
        this.f2262m.addView(this.f2269t, new RelativeLayout.LayoutParams(i * 2, i * 2));
        layoutParams = new RelativeLayout.LayoutParams(-2, this.f2268s.heightPixels - ((int) (((double) this.f2256g.f2177g) * 1.5d)));
        layoutParams.addRule(3, this.f2261l.getId());
        this.f2262m.addView(new C0683b(this, this), layoutParams);
        setContentView(this.f2262m);
        this.f2251b.loadUrl(url);
        C0726l.f2612c.m2653a("Viewing ").m2657b(url);
    }

    public void onWindowFocusChanged(boolean has_focus) {
        super.onWindowFocusChanged(has_focus);
    }

    public void onPause() {
        super.onPause();
        this.f2269t.m2426b();
    }

    public void onResume() {
        super.onResume();
        f2250z = true;
        this.f2269t.invalidate();
    }

    public void onConfigurationChanged(Configuration new_config) {
        super.onConfigurationChanged(new_config);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f2268s.heightPixels - ((int) (1.5d * ((double) this.f2256g.f2177g))));
        layoutParams.addRule(3, this.f2261l.getId());
        this.f2251b.setLayoutParams(layoutParams);
        f2250z = true;
        this.f2269t.invalidate();
    }

    public void onDestroy() {
        if (!C0694a.f2338D && f2242A) {
            for (int i = 0; i < C0694a.an.size(); i++) {
                ((Bitmap) C0694a.an.get(i)).recycle();
            }
            C0694a.an.clear();
        }
        f2242A = false;
        f2243B = false;
        super.onDestroy();
    }
}
