package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.android.volley.DefaultRetryPolicy;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C0225s;
import com.applovin.impl.adview.C0227u;
import com.applovin.impl.adview.C0229w;
import com.applovin.impl.adview.ah;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.cb;
import com.applovin.impl.sdk.di;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import mf.org.w3c.dom.traversal.NodeFilter;

public class AppLovinInterstitialActivity extends Activity implements C0229w {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile ah lastKnownWrapper;
    private View f3730A;
    private C0225s f3731B;
    private volatile UUID f3732C;
    private ImageView f3733D;
    private WeakReference f3734E;
    private AppLovinAdView f3735a;
    private ah f3736b;
    private volatile boolean f3737c;
    private AppLovinLogger f3738d;
    private cb f3739e;
    private AppLovinSdkImpl f3740f;
    private volatile AppLovinAdImpl f3741g;
    private volatile boolean f3742h;
    private volatile boolean f3743i;
    private volatile boolean f3744j;
    private volatile boolean f3745k;
    private volatile boolean f3746l;
    private volatile boolean f3747m;
    private volatile boolean f3748n;
    private volatile boolean f3749o;
    private volatile boolean f3750p;
    private boolean f3751q;
    private volatile boolean f3752r;
    private boolean f3753s;
    private int f3754t;
    private Handler f3755u;
    private FrameLayout f3756v;
    private AppLovinVideoView f3757w;
    private C0227u f3758x;
    private View f3759y;
    private C0227u f3760z;

    static {
        lastKnownWrapper = null;
    }

    public AppLovinInterstitialActivity() {
        this.f3737c = false;
        this.f3741g = di.m4281a();
        this.f3742h = false;
        this.f3743i = false;
        this.f3744j = false;
        this.f3745k = false;
        this.f3746l = false;
        this.f3747m = false;
        this.f3748n = false;
        this.f3749o = false;
        this.f3750p = false;
        this.f3751q = false;
        this.f3752r = false;
        this.f3753s = false;
        this.f3754t = 0;
        this.f3734E = new WeakReference(null);
    }

    private static int m3990a(Display display) {
        return display.getWidth() == display.getHeight() ? 3 : display.getWidth() < display.getHeight() ? 1 : 2;
    }

    private void m3994a(int i) {
        m4008b((int) (((float) i) - di.m4278a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)));
    }

    private void m3995a(int i, UUID uuid) {
        if (this.f3731B != null && uuid.equals(this.f3732C)) {
            if (i <= 0) {
                this.f3731B.setVisibility(8);
                this.f3753s = true;
            } else if (!this.f3753s) {
                int i2 = i - 1;
                this.f3731B.m30a(i2);
                this.f3755u.postDelayed(new C0199h(this, i2, uuid), 1000);
            }
        }
    }

    private void m3996a(long j, C0227u c0227u) {
        this.f3755u.postDelayed(new C0198g(this, c0227u), j);
    }

    private void m3999a(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener d = this.f3736b.m4100d();
        if (d != null) {
            d.adDisplayed(appLovinAd);
        }
        this.f3743i = true;
    }

    private void m4000a(AppLovinAd appLovinAd, double d, boolean z) {
        this.f3746l = true;
        AppLovinAdVideoPlaybackListener c = this.f3736b.m4099c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }

    private void m4001a(File file) {
        Uri fromFile = Uri.fromFile(file);
        this.f3757w = new AppLovinVideoView(this);
        this.f3757w.setOnPreparedListener(new C0193b(this));
        this.f3757w.setOnCompletionListener(new C0200k(this));
        this.f3757w.setOnErrorListener(new C0201l(this));
        this.f3757w.setVideoURI(fromFile);
        this.f3757w.setLayoutParams(new LayoutParams(-1, -1, 17));
        this.f3757w.setOnTouchListener(new AppLovinTouchToClickListener(this, new C0203n(this)));
        this.f3756v.addView(this.f3757w);
        setContentView(this.f3756v);
        m4035l();
    }

    private void m4002a(boolean z) {
        this.f3752r = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f3734E.get();
        if (mediaPlayer != null) {
            int i = z ? 0 : 1;
            mediaPlayer.setVolume((float) i, (float) i);
        }
    }

    private boolean m4003a() {
        return (this.f3736b == null || this.f3739e == null || this.f3739e.m189a()) ? true : (this.f3739e.m191c() && this.f3748n) ? true : this.f3739e.m190b() && this.f3750p;
    }

    private void m4007b() {
        Editor edit = m4056w().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.putInt("com.applovin.interstitial.last_video_position", 0);
        edit.commit();
    }

    private void m4008b(int i) {
        m3995a(i, this.f3732C);
    }

    private void m4010b(AppLovinAd appLovinAd) {
        m4014c(appLovinAd);
        dismiss();
    }

    private int m4012c(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    private void m4014c(AppLovinAd appLovinAd) {
        if (!this.f3744j) {
            this.f3744j = true;
            if (this.f3736b != null) {
                AppLovinAdDisplayListener d = this.f3736b.m4100d();
                if (d != null) {
                    d.adHidden(appLovinAd);
                }
            }
        }
    }

    private boolean m4015c() {
        return this.f3739e.m182G();
    }

    private void m4017d() {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f3756v = new FrameLayout(this);
        this.f3756v.setLayoutParams(layoutParams);
        this.f3756v.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3755u = new Handler();
    }

    private void m4019d(AppLovinAd appLovinAd) {
        if (!this.f3745k) {
            this.f3745k = true;
            AppLovinAdVideoPlaybackListener c = this.f3736b.m4099c();
            if (c != null) {
                c.videoPlaybackBegan(appLovinAd);
            }
        }
    }

    private void m4021e() {
        if (this.f3739e.m199k()) {
            finish();
        } else {
            m4028i();
        }
    }

    private void m4022f() {
        m4019d(this.f3741g);
        this.f3757w.start();
        m4008b(m4038n());
    }

    private void m4024g() {
        int i = 3;
        this.f3758x = C0227u.m50a(this.f3740f, this, this.f3741g.getCloseStyle());
        this.f3758x.setVisibility(8);
        this.f3758x.setOnClickListener(new C0205p(this));
        int c = m4012c(this.f3739e.m201m());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(c, c, (this.f3739e.m212x() ? 3 : 5) | 48);
        this.f3758x.m51a(c);
        int c2 = m4012c(this.f3739e.m203o());
        int c3 = m4012c(this.f3739e.m205q());
        layoutParams.setMargins(c3, c2, c3, c2);
        this.f3756v.addView(this.f3758x, layoutParams);
        this.f3760z = C0227u.m50a(this.f3740f, this, this.f3741g.getCloseStyle());
        this.f3760z.setVisibility(8);
        this.f3760z.setOnClickListener(new C0206q(this));
        layoutParams = new LayoutParams(c, c, (this.f3739e.m211w() ? 3 : 5) | 48);
        layoutParams.setMargins(c3, c2, c3, c2);
        this.f3760z.m51a(c);
        this.f3756v.addView(this.f3760z, layoutParams);
        this.f3760z.bringToFront();
        if (m4031j()) {
            int c4 = m4012c(new cb(this.f3740f).m206r());
            this.f3759y = new View(this);
            this.f3759y.setBackgroundColor(0);
            this.f3759y.setVisibility(8);
            this.f3730A = new View(this);
            this.f3730A.setBackgroundColor(0);
            this.f3730A.setVisibility(8);
            c += c4;
            int c5 = c2 - m4012c(5);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(c, c, (this.f3739e.m212x() ? 3 : 5) | 48);
            layoutParams2.setMargins(c5, c5, c5, c5);
            if (!this.f3739e.m211w()) {
                i = 5;
            }
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(c, c, i | 48);
            layoutParams3.setMargins(c5, c5, c5, c5);
            this.f3759y.setOnClickListener(new C0207r(this));
            this.f3730A.setOnClickListener(new C0208s(this));
            this.f3756v.addView(this.f3759y, layoutParams2);
            this.f3759y.bringToFront();
            this.f3756v.addView(this.f3730A, layoutParams3);
            this.f3730A.bringToFront();
        }
    }

    private void m4026h() {
        try {
            this.f3733D = new ImageView(this);
            if (!this.f3739e.m176A()) {
                return;
            }
            if (m4015c() || this.f3739e.m177B()) {
                int c = m4012c(this.f3739e.m178C());
                ViewGroup.LayoutParams layoutParams = new LayoutParams(c, c, this.f3739e.m179D());
                this.f3733D.setScaleType(ScaleType.FIT_CENTER);
                int c2 = m4012c(this.f3739e.m180E());
                layoutParams.setMargins(c2, c2, c2, c2);
                this.f3752r = m4015c();
                String muteImageFilename = m4015c() ? this.f3741g.getMuteImageFilename() : this.f3741g.getUnmuteImageFilename();
                File a = this.f3740f.getFileManager().m286a(muteImageFilename, (Context) this, true);
                if (a != null) {
                    this.f3740f.getLogger().m306d("AppLovinInterstitialActivity", "Added mute button with params: " + layoutParams);
                    AppLovinSdkUtils.safePopulateImageView(this.f3733D, Uri.fromFile(a), c);
                    this.f3733D.setClickable(true);
                    this.f3733D.setOnClickListener(new C0209t(this));
                    this.f3756v.addView(this.f3733D, layoutParams);
                    this.f3733D.bringToFront();
                    return;
                }
                this.f3740f.getLogger().m307e("AppLovinInterstitialActivity", "Attempting to add mute button but could not find cached file with intialFilename = " + muteImageFilename);
            }
        } catch (Throwable e) {
            this.f3740f.getLogger().m311w("AppLovinInterstitialActivity", "Failed to attach mute button", e);
        }
    }

    private void m4028i() {
        runOnUiThread(new C0196e(this));
    }

    private boolean m4031j() {
        return this.f3739e.m206r() > 0;
    }

    private void m4033k() {
        runOnUiThread(new C0197f(this));
    }

    private void m4035l() {
        if (this.f3741g.getVideoCloseDelay() >= 0.0f) {
            C0227u c0227u = (!this.f3751q || this.f3760z == null) ? this.f3758x : this.f3760z;
            m3996a(di.m4292c(this.f3741g.getVideoCloseDelay()), c0227u);
        }
    }

    private void m4037m() {
        if (this.f3731B == null) {
            this.f3731B = new C0225s(this);
            int p = m4042p();
            this.f3731B.m35c(p);
            this.f3731B.m32b((float) this.f3739e.m196h());
            this.f3731B.m37d(p);
            this.f3731B.m29a((float) this.f3739e.m195g());
            this.f3731B.m33b(m4038n());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(m4012c(this.f3739e.m194f()), m4012c(this.f3739e.m194f()), this.f3739e.m210v());
            int c = m4012c(this.f3739e.m209u());
            layoutParams.setMargins(c, c, c, c);
            this.f3756v.addView(this.f3731B, layoutParams);
            this.f3731B.bringToFront();
            C0225s c0225s = this.f3731B;
            p = (!this.f3739e.m197i() || m4038n() <= 0) ? 4 : 0;
            c0225s.setVisibility(p);
        }
    }

    private int m4038n() {
        int countdownLength = this.f3741g.getCountdownLength();
        return (countdownLength <= 0 && this.f3739e.m208t()) ? this.f3754t + 1 : countdownLength;
    }

    private void m4041o() {
        this.f3732C = UUID.randomUUID();
    }

    private int m4042p() {
        return Color.parseColor(this.f3739e.m192d());
    }

    private void m4044q() {
        m4048s();
    }

    private void m4046r() {
        if (!this.f3737c) {
            if (this.f3735a != null) {
                this.f3735a.setAdDisplayListener(new C1166i(this));
                this.f3735a.setAdClickListener(new C1167j(this));
                this.f3741g = (AppLovinAdImpl) this.f3736b.m4098b();
                m4017d();
                m4024g();
                File a = this.f3740f.getFileManager().m286a(this.f3741g.getVideoFilename(), (Context) this, false);
                if (a != null) {
                    m4001a(a);
                } else {
                    this.f3742h = true;
                    this.f3740f.getLogger().m307e("AppLovinInterstitialActivity", "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                    m4048s();
                }
                this.f3758x.bringToFront();
                if (m4031j() && this.f3759y != null) {
                    this.f3759y.bringToFront();
                }
                if (this.f3760z != null) {
                    this.f3760z.bringToFront();
                }
                this.f3735a.renderAd(this.f3741g, this.f3736b.m4103g());
                this.f3736b.m4097a(true);
                return;
            }
            exitWithError("AdView was null");
        }
    }

    private void m4048s() {
        m4055v();
        if (this.f3757w != null) {
            this.f3757w.stopPlayback();
        }
        View frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.addView(this.f3735a);
        if (!(this.f3756v == null || this.f3760z == null)) {
            this.f3756v.removeView(this.f3760z);
            if (this.f3730A != null) {
                this.f3756v.removeView(this.f3730A);
            }
        }
        if (m4031j() && this.f3759y != null) {
            if (this.f3756v != null) {
                this.f3756v.removeView(this.f3759y);
            }
            frameLayout.addView(this.f3759y);
            this.f3759y.bringToFront();
        }
        if (this.f3756v != null) {
            this.f3756v.removeView(this.f3758x);
        }
        frameLayout.addView(this.f3758x);
        setContentView(frameLayout);
        this.f3758x.bringToFront();
        if (this.f3741g.getCloseDelay() > 0.0f) {
            m3996a(di.m4292c(this.f3741g.getCloseDelay()), this.f3758x);
        } else {
            this.f3758x.setVisibility(0);
        }
        this.f3750p = true;
    }

    private void m4051t() {
        boolean z = !m4052u();
        m4002a(z);
        String muteImageFilename = z ? this.f3741g.getMuteImageFilename() : this.f3741g.getUnmuteImageFilename();
        int c = m4012c(this.f3739e.m178C());
        File a = this.f3740f.getFileManager().m286a(muteImageFilename, (Context) this, true);
        if (a != null) {
            AppLovinSdkUtils.safePopulateImageView(this.f3733D, Uri.fromFile(a), c);
        } else {
            this.f3740f.getLogger().m310w("AppLovinInterstitialActivity", "Attempt to toggle mute but no cached mute image file found.");
        }
    }

    private boolean m4052u() {
        return this.f3752r;
    }

    private void m4055v() {
        double d = 100.0d;
        if (!this.f3746l) {
            if (!this.f3747m) {
                if (this.f3757w != null) {
                    d = 100.0d * (((double) this.f3757w.getCurrentPosition()) / ((double) this.f3757w.getDuration()));
                } else {
                    this.f3738d.m307e("AppLovinInterstitialActivity", "No video view detected on video end");
                    d = 0.0d;
                }
            }
            String parametrizedCompletionUrl = this.f3741g.getParametrizedCompletionUrl((int) d, this.f3736b != null ? this.f3736b.m4103g() : null);
            if (AppLovinSdkUtils.isValidString(parametrizedCompletionUrl)) {
                this.f3740f.getPostbackService().dispatchPostbackAsync(parametrizedCompletionUrl, null);
            } else {
                this.f3738d.m307e("AppLovinInterstitialActivity", "Received invalid placement aware parameterized video completion url. No postback dispatched.");
            }
            m4000a(this.f3741g, d, d > 95.0d);
        }
    }

    private SharedPreferences m4056w() {
        return getSharedPreferences("com.applovin.interstitial.sharedpreferences", 0);
    }

    public void dismiss() {
        ((AdViewControllerImpl) this.f3735a.getAdViewController()).setIsForegroundClickInvalidated(true);
        m4007b();
        m4055v();
        if (this.f3736b != null) {
            if (this.f3741g != null) {
                m4014c(this.f3741g);
            }
            this.f3736b.m4097a(false);
            this.f3736b.m4104h();
        }
        finish();
    }

    public void exitWithError(String str) {
        try {
            Log.e("AppLovinInterstitialActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + ah.f3794a + "; CleanedUp = " + ah.f3795b));
            m4014c(di.m4281a());
        } catch (Throwable e) {
            Log.e("AppLovinInterstitialActivity", "Failed to show a video ad due to error:", e);
        }
        finish();
    }

    public void onBackPressed() {
        if (m4003a()) {
            this.f3738d.m306d("AppLovinInterstitialActivity", "Back button was pressed; forwarding to Android for handling...");
            super.onBackPressed();
            return;
        }
        try {
            if (this.f3751q && this.f3760z != null && this.f3760z.getVisibility() == 0 && this.f3760z.getAlpha() > 0.0f && !this.f3748n) {
                this.f3738d.m306d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to skip button.");
                this.f3760z.performClick();
            } else if (this.f3758x == null || this.f3758x.getVisibility() != 0 || this.f3758x.getAlpha() <= 0.0f) {
                this.f3738d.m306d("AppLovinInterstitialActivity", "Back button was pressed, but was not eligible for dismissal.");
            } else {
                this.f3738d.m306d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to close button.");
                this.f3758x.performClick();
            }
        } catch (Exception e) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        try {
            getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        } catch (Throwable th) {
        }
        requestWindowFeature(1);
        String stringExtra = getIntent().getStringExtra(KEY_WRAPPER_ID);
        if (stringExtra == null || stringExtra.isEmpty()) {
            exitWithError("Wrapper ID is null");
        } else {
            this.f3736b = ah.m4082a(stringExtra);
            if (this.f3736b == null && lastKnownWrapper != null) {
                this.f3736b = lastKnownWrapper;
            }
            if (this.f3736b != null) {
                AppLovinAd b = this.f3736b.m4098b();
                this.f3740f = (AppLovinSdkImpl) this.f3736b.m4095a();
                this.f3738d = this.f3736b.m4095a().getLogger();
                this.f3739e = new cb(this.f3736b.m4095a());
                if (b != null) {
                    Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                    int a = m3990a(defaultDisplay);
                    int rotation = defaultDisplay.getRotation();
                    boolean z = (a == 2 && rotation == 0) || ((a == 2 && rotation == 2) || ((a == 1 && rotation == 1) || (a == 1 && rotation == 3)));
                    if (this.f3736b.m4102f() == AdTarget.ACTIVITY_PORTRAIT) {
                        if (z) {
                            if (!(rotation == 1 || rotation == 3)) {
                                this.f3737c = true;
                                setRequestedOrientation(1);
                            }
                        } else if (!(rotation == 0 || rotation == 2)) {
                            this.f3737c = true;
                            setRequestedOrientation(1);
                        }
                    } else if (z) {
                        if (!(rotation == 0 || rotation == 2)) {
                            this.f3737c = true;
                            setRequestedOrientation(0);
                        }
                    } else if (!(rotation == 1 || rotation == 3)) {
                        this.f3737c = true;
                        setRequestedOrientation(0);
                    }
                    this.f3735a = new AppLovinAdView(this.f3740f, AppLovinAdSize.INTERSTITIAL, (Activity) this);
                    this.f3735a.setAutoDestroy(false);
                    this.f3736b.m4096a((C0229w) this);
                    this.f3751q = this.f3739e.m207s();
                } else {
                    exitWithError("No current ad found.");
                }
            } else {
                exitWithError("Wrapper is null; initialized state: " + Boolean.toString(ah.f3794a));
            }
        }
        Editor edit = m4056w().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.commit();
        m4007b();
        m4046r();
    }

    protected void onDestroy() {
        try {
            if (this.f3735a != null) {
                ViewParent parent = this.f3735a.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f3735a);
                }
                this.f3735a.destroy();
                this.f3735a = null;
            }
            if (this.f3757w != null) {
                this.f3757w.pause();
                this.f3757w.stopPlayback();
            }
        } catch (Throwable th) {
            this.f3738d.m311w("AppLovinInterstitialActivity", "Unable to destroy video view", th);
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (!(this.f3737c || this.f3742h)) {
            Editor edit = m4056w().edit();
            edit.putInt("com.applovin.interstitial.last_video_position", this.f3757w.getCurrentPosition());
            edit.putBoolean("com.applovin.interstitial.should_resume_video", true);
            edit.commit();
            this.f3757w.pause();
        }
        this.f3736b.m4097a(false);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f3736b.m4097a(true);
        SharedPreferences w = m4056w();
        if (w.getBoolean("com.applovin.interstitial.should_resume_video", false)) {
            if (this.f3757w != null) {
                int duration = this.f3757w.getDuration();
                int i = w.getInt("com.applovin.interstitial.last_video_position", duration);
                duration -= i;
                m4041o();
                this.f3757w.seekTo(i);
                this.f3757w.start();
                m3994a(duration);
            }
            if (this.f3758x == null || !this.f3739e.m198j()) {
                dismiss();
                return;
            }
            this.f3738d.m306d("AppLovinInterstitialActivity", "Fading in close button due to app resume.");
            C0227u c0227u = (!this.f3751q || this.f3760z == null) ? this.f3758x : this.f3760z;
            m3996a(0, c0227u);
        }
    }
}
