package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.telephony.PhoneStateListener;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.immersion.hapticmediasdk.HapticContentSDK;
import com.immersion.hapticmediasdk.HapticContentSDKFactory;
import com.jirbo.adcolony.ADCDownload.Listener;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.w3c.dom.traversal.NodeFilter;

public abstract class ADCVideo extends Activity implements OnPreparedListener, Listener {
    static int f4527a;
    static int f4528b;
    static int f4529c;
    static boolean f4530d;
    static boolean f4531e;
    static boolean f4532f;
    static boolean f4533g;
    static boolean f4534h;
    static boolean f4535i;
    double f4536A;
    String f4537B;
    String f4538C;
    boolean f4539D;
    boolean f4540E;
    boolean f4541F;
    C0719e f4542G;
    ad f4543H;
    AdColonyAd f4544I;
    HapticContentSDK f4545J;
    String f4546K;
    boolean f4547L;
    boolean f4548M;
    String f4549N;
    VideoView f4550O;
    FrameLayout f4551P;
    FrameLayout f4552Q;
    FrameLayout f4553R;
    Rect f4554S;
    ADCImage f4555T;
    C0675a f4556U;
    FileInputStream f4557V;
    PhoneStateListener f4558W;
    boolean f4559X;
    boolean f4560Y;
    boolean f4561j;
    boolean f4562k;
    boolean f4563l;
    boolean f4564m;
    boolean f4565n;
    boolean f4566o;
    double f4567p;
    double f4568q;
    long f4569r;
    long f4570s;
    int f4571t;
    int f4572u;
    int f4573v;
    int f4574w;
    int f4575x;
    int f4576y;
    int f4577z;

    /* renamed from: com.jirbo.adcolony.ADCVideo.1 */
    class C06711 implements Runnable {
        final /* synthetic */ ADCVideo f2189a;

        C06711(ADCVideo aDCVideo) {
            this.f2189a = aDCVideo;
        }

        public void run() {
            this.f2189a.f4542G.setBackgroundColor(0);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCVideo.2 */
    class C06722 implements Runnable {
        final /* synthetic */ ADCVideo f2190a;

        C06722(ADCVideo aDCVideo) {
            this.f2190a = aDCVideo;
        }

        public void run() {
            this.f2190a.f4543H.m2499c();
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCVideo.3 */
    class C06733 implements OnCompletionListener {
        final /* synthetic */ ADCVideo f2191a;

        C06733(ADCVideo aDCVideo) {
            this.f2191a = aDCVideo;
        }

        public void onCompletion(MediaPlayer media_player) {
            this.f2191a.setContentView(this.f2191a.f4551P);
            this.f2191a.f4553R.removeAllViews();
            ADCVideo.f4533g = false;
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCVideo.4 */
    class C06744 implements OnPreparedListener {
        final /* synthetic */ ADCVideo f2192a;

        C06744(ADCVideo aDCVideo) {
            this.f2192a = aDCVideo;
        }

        public void onPrepared(MediaPlayer media_player) {
            this.f2192a.f4553R.removeViewAt(1);
        }
    }

    /* renamed from: com.jirbo.adcolony.ADCVideo.a */
    class C0675a extends View {
        Rect f2193a;
        final /* synthetic */ ADCVideo f2194b;

        public C0675a(ADCVideo aDCVideo, Activity activity) {
            this.f2194b = aDCVideo;
            super(activity);
            this.f2193a = new Rect();
        }

        public void onDraw(Canvas canvas) {
            canvas.drawARGB(MotionEventCompat.ACTION_MASK, 0, 0, 0);
            getDrawingRect(this.f2193a);
            this.f2194b.f4555T.m2405a(canvas, (this.f2193a.width() - this.f2194b.f4555T.f2176f) / 2, (this.f2193a.height() - this.f2194b.f4555T.f2177g) / 2);
            invalidate();
        }
    }

    public ADCVideo() {
        this.f4561j = true;
        this.f4537B = XMLConstants.NULL_NS_URI;
        this.f4538C = XMLConstants.NULL_NS_URI;
        this.f4539D = true;
        this.f4540E = true;
        this.f4548M = true;
        this.f4549N = "Your purchase will begin shortly!";
        this.f4554S = new Rect();
        this.f4559X = false;
        this.f4560Y = false;
    }

    static void m5299a() {
        f4527a = 0;
        f4530d = false;
        f4531e = false;
        f4533g = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        int i = 1;
        C0694a.ak = false;
        super.onCreate(savedInstanceState);
        this.f4544I = C0694a.f2354T;
        if (this.f4544I == null) {
            finish();
            return;
        }
        String j;
        boolean z;
        int i2;
        this.f4547L = C0694a.m2468i("haptics_enabled");
        this.f4546K = C0694a.m2469j("haptics_filepath");
        this.f4549N = C0694a.m2469j("in_progress");
        if (this.f4544I.f2228x == null) {
            j = C0694a.m2469j("video_filepath");
        } else {
            j = this.f4544I.f2228x.f2308f;
        }
        this.f4538C = j;
        this.f4536A = (double) C0694a.m2466h("video_duration");
        if (this.f4547L) {
            try {
                this.f4545J = HapticContentSDKFactory.GetNewSDKInstance(0, this);
                this.f4545J.openHaptics(this.f4546K);
            } catch (Exception e) {
                e.printStackTrace();
                this.f4547L = false;
            }
            if (this.f4545J == null) {
                this.f4547L = false;
            }
        }
        if (C0694a.m2468i("video_enabled")) {
            z = false;
        } else {
            z = true;
        }
        C0694a.aa = z;
        if (C0694a.m2468i("end_card_enabled")) {
            z = false;
        } else {
            z = true;
        }
        C0694a.f2360Z = z;
        C0694a.ab = C0694a.m2468i("load_timeout_enabled");
        C0694a.ac = C0694a.m2466h("load_timeout");
        for (i2 = 0; i2 < C0694a.aq.size(); i2++) {
            if (C0694a.aq.get(i2) != null) {
                AdColonyNativeAdView adColonyNativeAdView = (AdColonyNativeAdView) C0694a.aq.get(i2);
                if (adColonyNativeAdView.ag != null) {
                    adColonyNativeAdView.f2300U.setVisibility(4);
                }
                if (adColonyNativeAdView.f2298S != null) {
                    adColonyNativeAdView.f2298S.setVisibility(4);
                }
            }
        }
        if (C0694a.m2468i("v4iap_enabled")) {
            this.f4544I.f2230z = AdColonyIAPEngagement.AUTOMATIC;
            this.f4544I.f2226v = true;
            this.f4544I.f2218n = C0694a.m2469j("product_id");
        }
        f4531e = this.f4544I.f2225u;
        requestWindowFeature(1);
        getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        if (C0694a.f2373m) {
            i2 = getResources().getConfiguration().orientation;
            int i3 = (i2 == 0 || i2 == 6 || i2 == 2) ? 6 : 7;
            C0694a.f2340F = i3;
            if (VERSION.SDK_INT < 10 || Build.MODEL.equals("Kindle Fire")) {
                if (Build.MODEL.equals("Kindle Fire")) {
                    getRequestedOrientation();
                    switch (((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation()) {
                        case DurationDV.DURATION_TYPE /*0*/:
                            break;
                        case MainNavigationActivity.REQUEST_CODE /*1*/:
                            i = 0;
                            break;
                        case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                            i = 9;
                            break;
                        default:
                            i = 8;
                            break;
                    }
                }
                i = i2;
                C0694a.f2340F = i;
                setRequestedOrientation(i);
            } else {
                setRequestedOrientation(C0694a.f2340F);
            }
        } else if (VERSION.SDK_INT >= 10) {
            setRequestedOrientation(6);
        } else {
            setRequestedOrientation(0);
        }
        setVolumeControlStream(3);
        this.f4542G = new C0719e(this);
        this.f4542G.m2590a((OnPreparedListener) this);
        this.f4551P = new FrameLayout(this);
        this.f4543H = new ad(this);
        this.f4553R = new FrameLayout(this);
        this.f4556U = new C0675a(this, this);
        this.f4555T = new ADCImage(C0694a.m2469j("browser_icon"));
        AdColonyBrowser.f2242A = false;
        C0694a.f2355U = this;
        C0694a.f2356V = this;
    }

    public void onPrepared(MediaPlayer mp) {
        if (this.f4561j) {
            int duration = this.f4542G.getDuration() / 1000;
            C0726l.f2610a.m2653a("duration, actual_duration = ").m2650a(this.f4536A).m2653a(", ").m2656b(duration);
            boolean z = this.f4536A / ((double) duration) > 0.9d && this.f4536A / ((double) duration) < 1.1d;
            if (z) {
                C0694a.f2372l.m2550a(this.f4544I);
                this.f4561j = false;
                return;
            }
            finish();
        }
    }

    public void onResume() {
        f4534h = true;
        super.onResume();
        AdColony.resume(this);
        if (C0694a.m2451a()) {
            finish();
        }
        m5301b();
        if (this.f4539D) {
            this.f4539D = false;
            if (!f4530d) {
                if (this.f4543H.f2423Q) {
                    this.f4552Q.addView(this.f4543H.f2430a);
                }
                if (this.f4543H.f2423Q) {
                    this.f4552Q.setVisibility(4);
                }
                if (Build.MODEL.equals("Kindle Fire")) {
                    this.f4543H.f2442m = 20;
                }
                if (Build.MODEL.equals("SCH-I800")) {
                    this.f4543H.f2442m = 25;
                }
                this.f4551P.addView(this.f4542G, new LayoutParams(this.f4575x, this.f4576y, 17));
                if (this.f4543H.f2423Q) {
                    this.f4551P.addView(this.f4552Q, new LayoutParams(this.f4571t, this.f4572u - this.f4543H.f2442m, 17));
                }
                this.f4551P.addView(this.f4543H, new LayoutParams(this.f4571t, this.f4572u, 17));
            }
        }
        if (f4533g) {
            this.f4553R.removeView(this.f4556U);
            this.f4553R.addView(this.f4556U);
            setContentView(this.f4553R);
        } else {
            setContentView(this.f4551P);
            if (f4530d) {
                this.f4569r = System.currentTimeMillis();
            }
        }
        this.f4542G.m2588a(this.f4543H);
        this.f4542G.m2589a(this.f4543H);
        try {
            this.f4557V = new FileInputStream(this.f4538C);
            this.f4542G.m2593a(this.f4557V.getFD());
            if (!f4535i) {
                onWindowFocusChanged(true);
            }
            if (C0694a.aa) {
                this.f4543H.m2490a();
                this.f4543H.m2501d();
            }
        } catch (IOException e) {
            C0694a.m2461e("Unable to play video: " + C0694a.m2469j("video_filepath"));
            this.f4543H.m2500c(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (C0694a.ak) {
            C1440v.f4636H = false;
            C1440v.f4637I = null;
        } else {
            C1440v.f4636H = false;
            C1440v.f4637I = null;
        }
        if (this.f4544I != null && this.f4544I.f2229y != null && !this.f4544I.f2227w) {
            this.f4544I.f2210f = 1;
            this.f4544I.m2419a();
        }
    }

    boolean m5301b() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4571t = displayMetrics.widthPixels;
        this.f4572u = displayMetrics.heightPixels;
        this.f4571t = displayMetrics.widthPixels;
        this.f4572u = displayMetrics.heightPixels;
        this.f4577z = ViewCompat.MEASURED_STATE_MASK;
        getWindow().setBackgroundDrawable(new ColorDrawable(this.f4577z));
        int i = this.f4571t;
        int i2 = this.f4572u;
        this.f4575x = i;
        this.f4576y = i2;
        if (!C0694a.f2373m && this.f4575x < this.f4576y) {
            this.f4571t = i2;
            this.f4572u = i;
            this.f4575x = i2;
            this.f4576y = i;
        }
        if (!C0694a.f2345K) {
            return false;
        }
        C0694a.f2345K = false;
        return true;
    }

    public void onWindowFocusChanged(boolean has_focus) {
        if (has_focus) {
            f4535i = false;
            if (f4530d || !f4534h) {
                if (f4533g) {
                    if (this.f4550O != null) {
                        this.f4550O.seekTo(f4528b);
                        this.f4550O.start();
                        return;
                    }
                    if (this.f4553R != null) {
                        this.f4553R.removeAllViews();
                    }
                    setContentView(this.f4551P);
                    return;
                } else if (f4530d) {
                    this.f4543H.invalidate();
                    return;
                } else {
                    return;
                }
            } else if (this.f4542G != null) {
                if (f4529c != 0) {
                    f4527a = f4529c;
                }
                f4529c = 0;
                this.f4542G.seekTo(f4527a);
                if (C0694a.f2373m) {
                    Handler handler = new Handler();
                    Runnable c06711 = new C06711(this);
                    this.f4542G.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    handler.postDelayed(c06711, 900);
                } else {
                    this.f4542G.setBackgroundColor(0);
                }
                if (!(C1440v.f4636H || this.f4560Y)) {
                    this.f4543H.f2425S = false;
                    this.f4542G.start();
                    this.f4541F = true;
                    if (this.f4548M) {
                        if (this.f4547L) {
                            this.f4545J.play();
                        }
                        new ADCDownload(C0694a.f2372l, this.f4544I.f2228x == null ? this.f4544I.f2219o : this.f4544I.f2228x.aq, this).m5298b();
                        this.f4548M = false;
                    } else if (this.f4547L) {
                        this.f4545J.resume();
                    }
                }
                this.f4543H.requestFocus();
                this.f4543H.invalidate();
                return;
            } else {
                return;
            }
        }
        if (f4534h && !this.f4560Y) {
            if (this.f4547L) {
                this.f4545J.pause();
            }
            f4527a = this.f4542G.getCurrentPosition();
            this.f4542G.pause();
            this.f4541F = false;
        }
        f4535i = true;
    }

    public void on_download_finished(ADCDownload download) {
        try {
            if (this.f4543H.f2423Q) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<script type=\"text/javascript\">");
                stringBuilder.append(aa.m2478a(C0694a.ae, XMLConstants.NULL_NS_URI));
                stringBuilder.append("</script>");
                if (download.f4526n == null) {
                    this.f4543H.af = XMLConstants.NULL_NS_URI;
                    return;
                }
                String replaceAll = download.f4526n.replaceAll("<script (type=\"text/javascript\")?((\\s)*src=\"mraid.js\"){1}></script>", stringBuilder.toString());
                if (this.f4543H != null) {
                    this.f4543H.af = replaceAll;
                    runOnUiThread(new C06722(this));
                }
            }
        } catch (OutOfMemoryError e) {
            C0726l.f2613d.m2657b((Object) "OutOfMemoryError - disabling AdColony.");
            this.f4543H.m2500c(true);
            AdColony.disable();
        }
    }

    public void onPause() {
        f4534h = false;
        if (!f4533g) {
            f4528b = 0;
        } else if (this.f4550O != null) {
            f4528b = this.f4550O.getCurrentPosition();
            this.f4550O.stopPlayback();
        }
        if (f4530d) {
            View view = new View(this);
            view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            setContentView(view);
            this.f4570s = System.currentTimeMillis();
            if (!isFinishing()) {
                this.f4568q += ((double) (this.f4570s - this.f4569r)) / 1000.0d;
            }
        }
        if (this.f4542G == null || this.f4560Y) {
            f4527a = 0;
        } else {
            if (this.f4542G.getCurrentPosition() != 0) {
                f4527a = this.f4542G.getCurrentPosition();
            }
            this.f4542G.m2587a();
            this.f4541F = false;
            this.f4542G.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (this.f4547L) {
                this.f4545J.pause();
            }
        }
        this.f4543H.f2407A = true;
        this.f4543H.f2415I = false;
        this.f4543H.f2414H = false;
        this.f4543H.f2416J = false;
        this.f4543H.f2450u = 0;
        this.f4543H.f2449t = 0;
        this.f4543H.invalidate();
        super.onPause();
        AdColony.pause();
    }

    public boolean onKeyUp(int keycode, KeyEvent event) {
        if (C1440v.f4637I != null && C1440v.f4637I.onKeyDown(keycode, event)) {
            return true;
        }
        if (keycode == 4) {
            if (f4530d) {
                if (f4533g) {
                    this.f4550O.stopPlayback();
                    f4533g = false;
                    this.f4553R.removeAllViews();
                    setContentView(this.f4551P);
                } else if (this.f4543H != null && this.f4543H.f2449t == 0) {
                    C0694a.ak = true;
                    this.f4543H.m2504g();
                }
            } else if (this.f4543H != null && C1440v.f4637I != null) {
                Iterator it = C1440v.f4637I.o.iterator();
                while (it.hasNext()) {
                    ((ADCImage) it.next()).m2400a();
                }
                C1440v.f4637I = null;
                C1440v.f4636H = false;
                this.f4542G.start();
                this.f4541F = true;
            } else if (this.f4543H != null && this.f4543H.f2419M && this.f4543H.f2421O) {
                C0694a.ak = true;
                this.f4543H.m2505h();
            }
            return true;
        } else if (keycode == 82) {
            return true;
        } else {
            return super.onKeyUp(keycode, event);
        }
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == 4) {
            return true;
        }
        return super.onKeyDown(keycode, event);
    }

    void m5300a(String str) {
        this.f4537B = str;
        f4533g = true;
        this.f4550O = new VideoView(this);
        this.f4550O.setVideoURI(Uri.parse(str));
        new MediaController(this).setMediaPlayer(this.f4550O);
        this.f4550O.setLayoutParams(new LayoutParams(this.f4571t, this.f4572u, 17));
        this.f4553R.addView(this.f4550O);
        this.f4553R.addView(this.f4556U);
        setContentView(this.f4553R);
        this.f4550O.setOnCompletionListener(new C06733(this));
        this.f4550O.setOnPreparedListener(new C06744(this));
        this.f4550O.start();
    }
}
