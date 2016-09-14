package com.silvermob.sdk.connectors;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.TypedValue;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiBanner.AnimationType;
import com.inmobi.ads.InMobiBanner.BannerAdListener;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiInterstitial.InterstitialAdListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import com.silvermob.sdk.connectors.Connector.Listener;
import java.util.Map;

public class InmobiConnector implements Connector {
    private Context context;
    private InMobiInterstitial mInMobiInterstitial;
    private Map<String, String> mPrefs;

    /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.1 */
    class C08141 implements Runnable {
        C08141() {
        }

        public void run() {
            InmobiConnector.this.mInMobiInterstitial.show();
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2 */
    class C08202 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1 */
        class C14601 implements InterstitialAdListener {

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1.1 */
            class C08151 implements Runnable {
                C08151() {
                }

                public void run() {
                    C08202.this.val$listener.onAdShown();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1.2 */
            class C08162 implements Runnable {
                C08162() {
                }

                public void run() {
                    C08202.this.val$listener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1.3 */
            class C08173 implements Runnable {
                C08173() {
                }

                public void run() {
                    C08202.this.val$listener.onAdClicked(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1.4 */
            class C08184 implements Runnable {
                C08184() {
                }

                public void run() {
                    C08202.this.val$listener.onAdLoaded(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.2.1.5 */
            class C08195 implements Runnable {
                C08195() {
                }

                public void run() {
                    C08202.this.val$listener.onError();
                }
            }

            C14601() {
            }

            public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
            }

            public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
                C08202.this.val$handler.post(new C08151());
            }

            public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
                C08202.this.val$handler.post(new C08162());
            }

            public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                C08202.this.val$handler.post(new C08173());
            }

            public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
                InmobiConnector.this.mInMobiInterstitial = inMobiInterstitial;
                C08202.this.val$handler.post(new C08184());
            }

            public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
                C08202.this.val$handler.post(new C08195());
            }

            public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
            }
        }

        C08202(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Resources r = InmobiConnector.this.context.getResources();
            new InMobiInterstitial(InmobiConnector.this.context, Long.valueOf(Long.parseLong((String) InmobiConnector.this.mPrefs.get("intPlacementId"))).longValue(), new C14601()).load();
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.3 */
    class C08243 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.3.1 */
        class C14611 implements BannerAdListener {
            final /* synthetic */ InMobiBanner val$banner;

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.3.1.1 */
            class C08211 implements Runnable {
                C08211() {
                }

                public void run() {
                    C08243.this.val$listener.onAdLoaded(C14611.this.val$banner);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.3.1.2 */
            class C08222 implements Runnable {
                C08222() {
                }

                public void run() {
                    C08243.this.val$listener.onError();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.InmobiConnector.3.1.3 */
            class C08233 implements Runnable {
                C08233() {
                }

                public void run() {
                    C08243.this.val$listener.onAdClicked(C14611.this.val$banner);
                }
            }

            C14611(InMobiBanner inMobiBanner) {
                this.val$banner = inMobiBanner;
            }

            public void onAdLoadSucceeded(InMobiBanner ad) {
                C08243.this.val$handler.post(new C08211());
            }

            public void onAdLoadFailed(InMobiBanner ad, InMobiAdRequestStatus statusCode) {
                C08243.this.val$handler.post(new C08222());
            }

            public void onAdDisplayed(InMobiBanner ad) {
            }

            public void onAdDismissed(InMobiBanner ad) {
            }

            public void onAdInteraction(InMobiBanner ad, Map<Object, Object> map) {
                C08243.this.val$handler.post(new C08233());
            }

            public void onUserLeftApplication(InMobiBanner ad) {
            }

            public void onAdRewardActionCompleted(InMobiBanner ad, Map<Object, Object> map) {
            }
        }

        C08243(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Resources r = InmobiConnector.this.context.getResources();
            Integer w = Integer.valueOf((int) TypedValue.applyDimension(1, 320.0f, r.getDisplayMetrics()));
            Integer h = Integer.valueOf((int) TypedValue.applyDimension(1, 50.0f, r.getDisplayMetrics()));
            InMobiBanner banner = new InMobiBanner(InmobiConnector.this.context, Long.valueOf(Long.parseLong((String) InmobiConnector.this.mPrefs.get("bannerPlacementId"))).longValue());
            banner.setAnimationType(AnimationType.ANIMATION_OFF);
            banner.setLayoutParams(new LayoutParams(w.intValue(), h.intValue()));
            banner.setListener(new C14611(banner));
            banner.load();
        }
    }

    public String getName() {
        return "inmobi";
    }

    public void showInterstitialAd(Listener listener) {
        Handler handler = new Handler();
        if (this.mInMobiInterstitial != null) {
            ((Activity) this.context).runOnUiThread(new C08141());
        } else {
            listener.onError();
        }
    }

    public void init(Context ctx, Map<String, String> prefs) {
        this.context = ctx;
        this.mPrefs = prefs;
        InMobiSdk.init(this.context, (String) this.mPrefs.get("accountId"));
        InMobiSdk.setLogLevel(LogLevel.DEBUG);
    }

    private void loadInterstitialAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08202(new Handler(), listener));
    }

    private void loadBannerAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08243(new Handler(), listener));
    }

    public void loadAd(Map<String, String> params, Listener listener) {
        String format = (String) params.get("format");
        if (format.equals("interstitial")) {
            loadInterstitialAd(params, listener);
        } else if (format.equals("banner")) {
            loadBannerAd(params, listener);
        } else {
            listener.onError();
        }
    }
}
