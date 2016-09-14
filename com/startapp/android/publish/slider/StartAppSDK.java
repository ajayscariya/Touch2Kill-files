package com.startapp.android.publish.slider;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.model.AdDetails;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import com.startapp.android.publish.slider.sliding.DrawerLayout;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.startapp.android.publish.slider.b */
public class StartAppSDK {
    private static boolean f3509i;
    private Activity f3510a;
    private WebView f3511b;
    private DrawerLayout f3512c;
    private Handler f3513d;
    private com.startapp.android.publish.p027a.StartAppSDK f3514e;
    private int f3515f;
    private Handler f3516g;
    private com.startapp.android.publish.adinformation.StartAppSDK f3517h;

    /* renamed from: com.startapp.android.publish.slider.b.2 */
    class StartAppSDK extends WebView {
        final /* synthetic */ StartAppSDK f3490a;

        StartAppSDK(StartAppSDK startAppSDK, Context context) {
            this.f3490a = startAppSDK;
            super(context);
        }

        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (event.getAction() == 0) {
                switch (keyCode) {
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        if (this.f3490a.f3511b != null && this.f3490a.f3511b.canGoBack()) {
                            this.f3490a.f3511b.goBack();
                        } else if (this.f3490a.f3512c != null) {
                            this.f3490a.f3512c.m3531b();
                        }
                        return true;
                }
            }
            return super.onKeyDown(keyCode, event);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.3 */
    class StartAppSDK implements OnTouchListener {
        final /* synthetic */ StartAppSDK f3491a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f3491a = startAppSDK;
        }

        public boolean onTouch(View view, MotionEvent event) {
            this.f3491a.f3512c.requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.4 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ ImageButton f3492a;
        final /* synthetic */ TranslateAnimation f3493b;
        final /* synthetic */ StartAppSDK f3494c;

        StartAppSDK(StartAppSDK startAppSDK, ImageButton imageButton, TranslateAnimation translateAnimation) {
            this.f3494c = startAppSDK;
            this.f3492a = imageButton;
            this.f3493b = translateAnimation;
        }

        public void run() {
            this.f3492a.startAnimation(this.f3493b);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.5 */
    class StartAppSDK implements AnimationListener {
        final /* synthetic */ ImageButton f3495a;
        final /* synthetic */ TranslateAnimation f3496b;
        final /* synthetic */ StartAppSDK f3497c;

        StartAppSDK(StartAppSDK startAppSDK, ImageButton imageButton, TranslateAnimation translateAnimation) {
            this.f3497c = startAppSDK;
            this.f3495a = imageButton;
            this.f3496b = translateAnimation;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f3495a.startAnimation(this.f3496b);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.6 */
    class StartAppSDK implements AnimationListener {
        final /* synthetic */ ImageButton f3498a;
        final /* synthetic */ TranslateAnimation f3499b;
        final /* synthetic */ StartAppSDK f3500c;

        StartAppSDK(StartAppSDK startAppSDK, ImageButton imageButton, TranslateAnimation translateAnimation) {
            this.f3500c = startAppSDK;
            this.f3498a = imageButton;
            this.f3499b = translateAnimation;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f3500c.f3515f = this.f3500c.f3515f + 1;
            if (this.f3500c.f3515f > 12) {
                this.f3500c.f3515f = 0;
            } else {
                this.f3498a.startAnimation(this.f3499b);
            }
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.7 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ ImageButton f3501a;
        final /* synthetic */ TranslateAnimation f3502b;
        final /* synthetic */ StartAppSDK f3503c;

        StartAppSDK(StartAppSDK startAppSDK, ImageButton imageButton, TranslateAnimation translateAnimation) {
            this.f3503c = startAppSDK;
            this.f3501a = imageButton;
            this.f3502b = translateAnimation;
        }

        public void run() {
            this.f3501a.startAnimation(this.f3502b);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.8 */
    class StartAppSDK implements OnClickListener {
        final /* synthetic */ RelativeLayout f3504a;
        final /* synthetic */ StartAppSDK f3505b;

        StartAppSDK(StartAppSDK startAppSDK, RelativeLayout relativeLayout) {
            this.f3505b = startAppSDK;
            this.f3504a = relativeLayout;
        }

        public void onClick(View v) {
            this.f3505b.f3512c.m3540h(this.f3504a);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.a */
    private class StartAppSDK extends WebViewClient {
        final /* synthetic */ StartAppSDK f3508a;

        /* renamed from: com.startapp.android.publish.slider.b.a.1 */
        class StartAppSDK implements Runnable {
            final /* synthetic */ String f3506a;
            final /* synthetic */ StartAppSDK f3507b;

            StartAppSDK(StartAppSDK startAppSDK, String str) {
                this.f3507b = startAppSDK;
                this.f3506a = str;
            }

            public void run() {
                this.f3507b.f3508a.f3511b.loadUrl(this.f3506a);
            }
        }

        private StartAppSDK(StartAppSDK startAppSDK) {
            this.f3508a = startAppSDK;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 2, "MyWebViewClient::onPageStarted - [" + url + "]");
            super.onPageStarted(view, url, favicon);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 2, "MyWebViewClient::shouldOverrideUrlLoading - [" + url + "]");
            String toLowerCase = url.toLowerCase();
            CharSequence charSequence = "searchmobileonline";
            try {
                charSequence = new URL(((AdDetails) this.f3508a.f3514e.m5880b().get(0)).getClickUrl()).getHost();
            } catch (MalformedURLException e) {
            }
            if (toLowerCase.contains(charSequence)) {
                return false;
            }
            if (toLowerCase.contains(MetaData.getInstance().getAdClickUrl().toLowerCase())) {
                com.startapp.android.publish.p022h.StartAppSDK.m3305a(this.f3508a.m3510a(), url + (MetaData.getInstance().isDisableTwoClicks() ? XMLConstants.NULL_NS_URI : com.startapp.android.publish.p022h.StartAppSDK.m3193a(com.startapp.android.publish.p022h.StartAppSDK.m3331b(url))), null, null, new com.startapp.android.publish.p022h.StartAppSDK(), MetaData.getInstance().getSmartRedirectTimeout(), ((AdDetails) this.f3508a.f3514e.m5880b().get(0)).isStartappBrowserEnabled());
                return true;
            }
            com.startapp.android.publish.p022h.StartAppSDK.m3334b(this.f3508a.m3510a(), url, com.startapp.android.publish.p022h.StartAppSDK.m3331b(url));
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 2, "MyWebViewClient::onPageFinished - [" + url + "]");
            super.onPageFinished(view, url);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 2, "MyWebViewClient::onReceivedError - [" + description + "], [" + failingUrl + "]");
            this.f3508a.f3513d.postDelayed(new StartAppSDK(this, failingUrl), 5000);
            super.onReceivedError(view, errorCode, description, failingUrl);
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.1 */
    class StartAppSDK implements AdEventListener {
        final /* synthetic */ StartAppSDK f4765a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f4765a = startAppSDK;
        }

        public void onReceiveAd(Ad ad) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 3, "Slider loaded");
            this.f4765a.m3498b();
            this.f4765a.m3503d();
        }

        public void onFailedToReceiveAd(Ad ad) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 6, "Error loading Slider");
        }
    }

    /* renamed from: com.startapp.android.publish.slider.b.9 */
    class StartAppSDK implements com.startapp.android.publish.slider.sliding.DrawerLayout.StartAppSDK {
        final /* synthetic */ StartAppSDK f4766a;

        StartAppSDK(StartAppSDK startAppSDK) {
            this.f4766a = startAppSDK;
        }

        public void m5486a(int i) {
        }

        public void m5488a(View view, float f) {
        }

        public void m5487a(View view) {
            this.f4766a.m3505e();
        }

        public void m5489b(View view) {
            ((InputMethodManager) this.f4766a.m3510a().getSystemService("input_method")).hideSoftInputFromWindow(this.f4766a.f3511b.getWindowToken(), 0);
        }
    }

    static {
        f3509i = false;
    }

    public StartAppSDK(Activity activity) {
        this(activity, new AdPreferences());
    }

    public StartAppSDK(Activity activity, AdPreferences adPreferences) {
        this.f3513d = new Handler();
        this.f3515f = 0;
        this.f3516g = new Handler();
        this.f3517h = com.startapp.android.publish.adinformation.StartAppSDK.m2855a();
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("Slider", 3, "new Slider Created");
        this.f3510a = activity;
        this.f3514e = new com.startapp.android.publish.p027a.StartAppSDK(activity);
        this.f3514e.m5878a(adPreferences, new StartAppSDK(this));
    }

    public Activity m3510a() {
        return this.f3510a;
    }

    private void m3498b() {
        this.f3511b = new StartAppSDK(this, m3510a());
        this.f3511b.setOnTouchListener(new StartAppSDK(this));
        WebViewJSInterface webViewJSInterface = new WebViewJSInterface(this.f3510a);
        this.f3511b.setLayoutParams(new LayoutParams(-1, -1));
        this.f3511b.getSettings().setJavaScriptEnabled(true);
        this.f3511b.addJavascriptInterface(webViewJSInterface, "HTMLOUT");
        this.f3511b.setWebChromeClient(new WebChromeClient());
        this.f3511b.setHorizontalScrollBarEnabled(false);
        this.f3511b.setVerticalScrollBarEnabled(true);
        if (VERSION.SDK_INT > 10) {
            this.f3511b.setLayerType(1, null);
        }
        this.f3511b.setWebViewClient(new StartAppSDK());
        String str = ((AdDetails) this.f3514e.m5880b().get(0)).getClickUrl() + m3501c() + "&ver=" + com.startapp.android.publish.StartAppSDK.f3202g;
        com.startapp.android.publish.p022h.StartAppSDK.m3230a(3, "Slider URL: " + str);
        this.f3511b.loadUrl(str);
    }

    private String m3501c() {
        String e = com.startapp.android.publish.p022h.StartAppSDK.m3347e(m3510a());
        if (e == null || XMLConstants.NULL_NS_URI.equals(e)) {
            return XMLConstants.NULL_NS_URI;
        }
        try {
            return "&token=" + URLEncoder.encode(e, Defaults.Encoding);
        } catch (UnsupportedEncodingException e2) {
            return XMLConstants.NULL_NS_URI;
        }
    }

    private void m3503d() {
        if (com.startapp.android.publish.p022h.StartAppSDK.m3322a(m3510a())) {
            ViewGroup viewGroup = (ViewGroup) this.f3510a.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeView(childAt);
            this.f3512c = new DrawerLayout(m3510a());
            View relativeLayout = new RelativeLayout(this.f3510a);
            relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
            relativeLayout.addView(childAt);
            View imageButton = new ImageButton(this.f3510a);
            if (VERSION.SDK_INT >= 16) {
                imageButton.setBackground(null);
            } else {
                imageButton.setBackgroundDrawable(null);
            }
            imageButton.setPadding(0, 0, com.startapp.android.publish.p022h.StartAppSDK.m3289a(this.f3510a, 10), 0);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(15);
            imageButton.setLayoutParams(layoutParams);
            imageButton.setImageBitmap(com.startapp.android.publish.p022h.StartAppSDK.m3198a(this.f3510a, "tab_side.png"));
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.07f, 1, 0.07f);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.07f, 1, -0.07f);
            translateAnimation.setDuration(40);
            translateAnimation2.setDuration(40);
            StartAppSDK startAppSDK = new StartAppSDK(this, imageButton, translateAnimation);
            translateAnimation.setAnimationListener(new StartAppSDK(this, imageButton, translateAnimation2));
            translateAnimation2.setAnimationListener(new StartAppSDK(this, imageButton, translateAnimation));
            relativeLayout.addView(imageButton);
            if (!f3509i) {
                f3509i = true;
                this.f3516g.postDelayed(new StartAppSDK(this, imageButton, translateAnimation), 15000);
            }
            this.f3512c.setLayoutParams(new com.startapp.android.publish.slider.sliding.DrawerLayout.StartAppSDK(-1, -1));
            this.f3512c.addView(relativeLayout);
            RelativeLayout relativeLayout2 = new RelativeLayout(m3510a());
            ViewGroup.LayoutParams startAppSDK2 = new com.startapp.android.publish.slider.sliding.DrawerLayout.StartAppSDK(com.startapp.android.publish.p022h.StartAppSDK.m3289a(this.f3510a, 290), -1);
            startAppSDK2.f3521a = 3;
            relativeLayout2.setLayoutParams(startAppSDK2);
            relativeLayout2.addView(this.f3511b);
            this.f3512c.addView(relativeLayout2);
            viewGroup.addView(this.f3512c);
            new com.startapp.android.publish.adinformation.StartAppSDK(this.f3510a, com.startapp.android.publish.adinformation.StartAppSDK.StartAppSDK.LARGE, Placement.DEVICE_SIDEBAR, this.f3517h).m2852a(relativeLayout2);
            imageButton.setOnClickListener(new StartAppSDK(this, relativeLayout2));
            this.f3512c.setDrawerListener(new StartAppSDK(this));
        }
    }

    private void m3505e() {
        com.startapp.android.publish.p027a.StartAppSDK startAppSDK = this.f3514e;
        if (com.startapp.android.publish.p022h.StartAppSDK.m3211a(m3510a(), "trackingUrl", null) == null) {
            try {
                this.f3511b.loadUrl("javascript:window.HTMLOUT.processHTML(document.getElementById('SearchResults').innerHTML);");
            } catch (Throwable th) {
                com.startapp.android.publish.p022h.StartAppSDK.m3233a("Slider", 6, "Error reading SearchResults div ", th);
            }
        }
        new StartAppSDK(this.f3510a).m3495a(((AdDetails) startAppSDK.m5880b().get(0)).getTrackingUrl());
    }
}
