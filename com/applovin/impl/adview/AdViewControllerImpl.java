package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.RelativeLayout.LayoutParams;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.ClickTrackingOverlayView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.cb;
import com.applovin.impl.sdk.cd;
import com.applovin.impl.sdk.di;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {
    private Activity f3763a;
    private AppLovinSdk f3764b;
    private AppLovinAdService f3765c;
    private AppLovinLogger f3766d;
    private AppLovinAdSize f3767e;
    private String f3768f;
    private C0224r f3769g;
    private C1171l f3770h;
    private C0221o f3771i;
    private AppLovinAd f3772j;
    private Runnable f3773k;
    private Runnable f3774l;
    private Runnable f3775m;
    private volatile AppLovinAd f3776n;
    private ClickTrackingOverlayView f3777o;
    private WeakReference f3778p;
    private final AtomicReference f3779q;
    private volatile boolean f3780r;
    private volatile boolean f3781s;
    private volatile boolean f3782t;
    private volatile boolean f3783u;
    private volatile AppLovinAdLoadListener f3784v;
    private volatile AppLovinAdDisplayListener f3785w;
    private volatile AppLovinAdVideoPlaybackListener f3786x;
    private volatile AppLovinAdClickListener f3787y;
    private volatile boolean f3788z;

    public AdViewControllerImpl() {
        this.f3776n = null;
        this.f3777o = null;
        this.f3778p = null;
        this.f3779q = new AtomicReference();
        this.f3780r = false;
        this.f3781s = true;
        this.f3782t = false;
        this.f3783u = false;
    }

    private void m4063a(ViewGroup viewGroup, AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (context instanceof Activity) {
            this.f3764b = appLovinSdk;
            this.f3765c = appLovinSdk.getAdService();
            this.f3766d = appLovinSdk.getLogger();
            this.f3767e = appLovinAdSize;
            this.f3763a = (Activity) context;
            this.f3772j = di.m4281a();
            this.f3769g = new C0224r(this, appLovinSdk);
            this.f3775m = new C0213f();
            this.f3773k = new C0218k();
            this.f3774l = new C0216i();
            this.f3770h = new C1171l(this, appLovinSdk);
            if (m4066a(context)) {
                this.f3771i = m4067b();
                viewGroup.setBackgroundColor(0);
                viewGroup.addView(this.f3771i);
                m4069b(this.f3771i, appLovinAdSize);
                m4065a(this.f3775m);
                m4065a(new C0217j());
                this.f3780r = true;
                return;
            }
            this.f3766d.userError("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
        } else {
            throw new IllegalArgumentException("Specified context is not an activity");
        }
    }

    private void m4064a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri) {
        if (this.f3777o == null) {
            this.f3766d.m306d("AppLovinAdView", "Creating and rendering click overlay");
            this.f3777o = new ClickTrackingOverlayView(appLovinAdView.getContext(), this.f3764b);
            this.f3777o.setLayoutParams(new LayoutParams(-1, -1));
            appLovinAdView.addView(this.f3777o);
            appLovinAdView.bringChildToFront(this.f3777o);
            ((AppLovinAdServiceImpl) this.f3765c).trackForegroundClick(appLovinAd, this.f3768f, appLovinAdView, this, uri);
            return;
        }
        this.f3766d.m306d("AppLovinAdView", "Skipping click overlay rendering because it already exists");
    }

    private void m4065a(Runnable runnable) {
        this.f3763a.runOnUiThread(runnable);
    }

    private static boolean m4066a(Context context) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return true;
            }
            WebViewDatabase instance = WebViewDatabase.getInstance(context);
            Method declaredMethod = WebViewDatabase.class.getDeclaredMethod("getCacheTotalSize", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, new Object[0]);
            return true;
        } catch (Throwable e) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e);
            return true;
        } catch (Throwable e2) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e2);
            return true;
        } catch (Throwable e22) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e22);
            return true;
        } catch (Throwable e3) {
            Log.e("AppLovinAdView", "getCacheTotalSize() reported exception", e3);
            return false;
        } catch (Throwable e32) {
            Log.e("AppLovinAdView", "Unexpected error while checking DB state", e32);
            return false;
        }
    }

    private C0221o m4067b() {
        C0221o c0221o = new C0221o(this.f3769g, this.f3764b, this.f3763a);
        c0221o.setBackgroundColor(0);
        c0221o.setWillNotCacheDrawing(false);
        if (new cb(this.f3764b).m181F() && VERSION.SDK_INT >= 19) {
            c0221o.setLayerType(2, null);
        }
        return c0221o;
    }

    private static void m4069b(View view, AppLovinAdSize appLovinAdSize) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
        int applyDimension2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
        ViewGroup.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -2);
        }
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension2;
        if (layoutParams instanceof LayoutParams) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    void m4078a() {
        this.f3766d.m306d("AppLovinAdView", "Ad: " + this.f3776n + " with placement = \"" + this.f3768f + "\" closed.");
        m4065a(this.f3775m);
        m4065a(new C0215h(this, this.f3776n));
        this.f3776n = null;
        this.f3768f = null;
    }

    void m4079a(int i) {
        if (!this.f3782t) {
            this.f3765c.addAdUpdateListener(this.f3770h, this.f3767e);
            m4065a(this.f3775m);
        }
        m4065a(new C0212b(this, i));
    }

    void m4080a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            this.f3783u = true;
            if (this.f3782t) {
                this.f3779q.set(appLovinAd);
                this.f3766d.m306d("AppLovinAdView", "Ad view has paused when an ad was recieved, ad saved for later");
            } else {
                this.f3765c.addAdUpdateListener(this.f3770h, this.f3767e);
                renderAd(appLovinAd);
            }
            m4065a(new C0211a(this, appLovinAd));
            return;
        }
        this.f3766d.m307e("AppLovinAdView", "No provided when to the view controller");
        m4079a(-1);
    }

    void m4081a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdServiceImpl appLovinAdServiceImpl = (AppLovinAdServiceImpl) this.f3765c;
        if (!new cb(this.f3764b).m183H() || uri == null) {
            appLovinAdServiceImpl.trackClickOn(appLovinAd, this.f3768f, appLovinAdView, this, uri);
        } else {
            m4064a(appLovinAd, appLovinAdView, uri);
        }
        m4065a(new C0214g(this, appLovinAd));
    }

    public void destroy() {
        if (this.f3765c != null) {
            this.f3765c.removeAdUpdateListener(this.f3770h, getSize());
        }
        if (this.f3771i != null) {
            try {
                ViewParent parent = this.f3771i.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f3771i);
                }
                this.f3771i.removeAllViews();
                this.f3771i.destroy();
                this.f3771i = null;
            } catch (Throwable th) {
                this.f3766d.m311w("AppLovinAdView", "Unable to destroy ad view", th);
            }
        }
        this.f3782t = true;
    }

    public void dismissInterstitialIfRequired() {
        if (!new cb(this.f3764b).m187L()) {
            return;
        }
        if (this.f3763a != null && (this.f3763a instanceof AppLovinInterstitialActivity)) {
            ((AppLovinInterstitialActivity) this.f3763a).dismiss();
        } else if (this.f3778p != null) {
            C1172x c1172x = (C1172x) this.f3778p.get();
            if (c1172x != null) {
                c1172x.dismiss();
            }
        }
    }

    public AppLovinAdSize getSize() {
        return this.f3767e;
    }

    public void initializeAdView(ViewGroup viewGroup, Context context, AppLovinAdSize appLovinAdSize, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null) {
                appLovinAdSize = C0219m.m18a(attributeSet);
                if (appLovinAdSize == null) {
                    appLovinAdSize = AppLovinAdSize.BANNER;
                }
            }
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m4063a(viewGroup, appLovinSdk, appLovinAdSize, context);
                if (C0219m.m19b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f3764b.getAdService().hasPreloadedAd(this.f3767e);
    }

    public boolean isAutoDestroy() {
        return this.f3781s;
    }

    public boolean isForegroundClickInvalidated() {
        return this.f3788z;
    }

    public void loadNextAd() {
        if (this.f3764b == null || this.f3770h == null || this.f3763a == null || !this.f3780r) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f3765c.loadNextAd(this.f3767e, this.f3770h);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.f3776n != null) {
            webView.setVisibility(0);
            try {
                if (this.f3785w != null) {
                    this.f3785w.adDisplayed(this.f3776n);
                }
            } catch (Throwable th) {
                this.f3766d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (this.f3780r) {
            m4065a(new C0215h(this, this.f3776n));
            if (this.f3781s) {
                destroy();
            }
        }
    }

    public void onVisibilityChanged(int i) {
        if (!this.f3780r || !this.f3781s) {
            return;
        }
        if (i == 8 || i == 4) {
            pause();
        } else if (i == 0) {
            resume();
        }
    }

    public void pause() {
        if (this.f3780r) {
            this.f3765c.removeAdUpdateListener(this.f3770h, getSize());
            AppLovinAd appLovinAd = this.f3776n;
            renderAd(this.f3772j);
            if (appLovinAd != null) {
                this.f3779q.set(appLovinAd);
            }
            this.f3782t = true;
        }
    }

    public void removeClickTrackingOverlay() {
        if (this.f3777o != null) {
            ViewParent parent = this.f3777o.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f3777o);
                this.f3777o = null;
                return;
            }
            return;
        }
        this.f3766d.m306d("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, null);
    }

    public void renderAd(AppLovinAd appLovinAd, String str) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (!this.f3780r) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to render ad: AppLovinAdView is not initialized.");
        } else if (appLovinAd != this.f3776n) {
            this.f3766d.m306d("AppLovinAdView", "Rendering ad #" + appLovinAd.getAdIdNumber() + " (" + appLovinAd.getSize() + ") over placement: " + str);
            m4065a(new C0215h(this, this.f3776n));
            this.f3779q.set(null);
            this.f3776n = appLovinAd;
            this.f3768f = str;
            if (appLovinAd.getSize() == this.f3767e) {
                m4065a(this.f3773k);
            } else if (appLovinAd.getSize() == AppLovinAdSize.INTERSTITIAL) {
                m4065a(this.f3775m);
                m4065a(this.f3774l);
            }
            new cd(this.f3764b).m224a();
        } else {
            this.f3766d.m310w("AppLovinAdView", "Ad #" + appLovinAd.getAdIdNumber() + " is already showing, ignoring");
        }
    }

    public void resume() {
        if (this.f3780r) {
            if (this.f3783u) {
                this.f3765c.addAdUpdateListener(this.f3770h, this.f3767e);
            }
            AppLovinAd appLovinAd = (AppLovinAd) this.f3779q.getAndSet(null);
            if (appLovinAd != null) {
                renderAd(appLovinAd);
            }
            this.f3782t = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f3787y = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f3785w = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f3784v = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f3786x = appLovinAdVideoPlaybackListener;
    }

    public void setAutoDestroy(boolean z) {
        this.f3781s = z;
    }

    public void setIsForegroundClickInvalidated(boolean z) {
        this.f3788z = z;
    }

    public void setParentDialog(WeakReference weakReference) {
        this.f3778p = weakReference;
    }
}
