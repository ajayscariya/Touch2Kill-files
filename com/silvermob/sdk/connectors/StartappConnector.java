package com.silvermob.sdk.connectors;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.silvermob.sdk.connectors.Connector.Listener;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdDisplayListener;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;
import com.startapp.android.publish.banner.Banner;
import com.startapp.android.publish.banner.BannerListener;
import java.util.Map;

public class StartappConnector implements Connector {
    private Context context;
    private Map<String, String> mPrefs;
    private StartAppAd mStartAppAd;

    /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1 */
    class C08291 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1.1 */
        class C14621 implements AdDisplayListener {

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1.1.1 */
            class C08251 implements Runnable {
                C08251() {
                }

                public void run() {
                    C08291.this.val$listener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1.1.2 */
            class C08262 implements Runnable {
                C08262() {
                }

                public void run() {
                    C08291.this.val$listener.onAdShown();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1.1.3 */
            class C08273 implements Runnable {
                C08273() {
                }

                public void run() {
                    C08291.this.val$listener.onAdClicked(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.1.1.4 */
            class C08284 implements Runnable {
                C08284() {
                }

                public void run() {
                    C08291.this.val$listener.onError();
                }
            }

            C14621() {
            }

            public void adHidden(Ad ad) {
                C08291.this.val$handler.post(new C08251());
            }

            public void adDisplayed(Ad ad) {
                C08291.this.val$handler.post(new C08262());
            }

            public void adClicked(Ad ad) {
                C08291.this.val$handler.post(new C08273());
            }

            public void adNotDisplayed(Ad ad) {
                Log.d("StarappConnector", "Ad received but not displayed: " + ad.getNotDisplayedReason());
                C08291.this.val$handler.post(new C08284());
            }
        }

        C08291(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            StartappConnector.this.mStartAppAd.showAd(new C14621());
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.StartappConnector.2 */
    class C08322 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.StartappConnector.2.1 */
        class C14631 implements AdEventListener {

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.2.1.1 */
            class C08301 implements Runnable {
                C08301() {
                }

                public void run() {
                    C08322.this.val$listener.onAdLoaded(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.2.1.2 */
            class C08312 implements Runnable {
                C08312() {
                }

                public void run() {
                    C08322.this.val$listener.onError();
                }
            }

            C14631() {
            }

            public void onReceiveAd(Ad ad) {
                C08322.this.val$handler.post(new C08301());
            }

            public void onFailedToReceiveAd(Ad ad) {
                C08322.this.val$handler.post(new C08312());
            }
        }

        C08322(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            StartappConnector.this.mStartAppAd = new StartAppAd(StartappConnector.this.context);
            StartappConnector.this.mStartAppAd.loadAd(new C14631());
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.StartappConnector.3 */
    class C08363 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.StartappConnector.3.1 */
        class C14641 implements BannerListener {

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.3.1.1 */
            class C08331 implements Runnable {
                final /* synthetic */ View val$view;

                C08331(View view) {
                    this.val$view = view;
                }

                public void run() {
                    C08363.this.val$listener.onAdLoaded(this.val$view);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.3.1.2 */
            class C08342 implements Runnable {
                C08342() {
                }

                public void run() {
                    C08363.this.val$listener.onError();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.StartappConnector.3.1.3 */
            class C08353 implements Runnable {
                final /* synthetic */ View val$view;

                C08353(View view) {
                    this.val$view = view;
                }

                public void run() {
                    C08363.this.val$listener.onAdClicked(this.val$view);
                }
            }

            C14641() {
            }

            public void onReceiveAd(View view) {
                C08363.this.val$handler.post(new C08331(view));
            }

            public void onFailedToReceiveAd(View view) {
                C08363.this.val$handler.post(new C08342());
            }

            public void onClick(View view) {
                C08363.this.val$handler.post(new C08353(view));
            }
        }

        C08363(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Banner startAppBanner = new Banner(StartappConnector.this.context, new C14641());
            Resources r = StartappConnector.this.context.getResources();
            startAppBanner.setLayoutParams(new LayoutParams(Integer.valueOf((int) TypedValue.applyDimension(1, 320.0f, r.getDisplayMetrics())).intValue(), Integer.valueOf((int) TypedValue.applyDimension(1, 50.0f, r.getDisplayMetrics())).intValue()));
        }
    }

    public String getName() {
        return "startapp";
    }

    public void showInterstitialAd(Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08291(new Handler(), listener));
    }

    public void init(Context ctx, Map<String, String> prefs) {
        this.mPrefs = prefs;
        this.context = ctx;
        StartAppSDK.init((Activity) this.context, (String) this.mPrefs.get("appId"), true);
    }

    private void loadInterstitialAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08322(new Handler(), listener));
    }

    private void loadVideoAd(Map<String, String> map, Listener listener) {
        listener.onError();
    }

    private void loadBannerAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08363(new Handler(), listener));
    }

    public void loadAd(Map<String, String> params, Listener listener) {
        String format = (String) params.get("format");
        if (format.equals("interstitial")) {
            loadInterstitialAd(params, listener);
        } else if (format.equals("video")) {
            loadVideoAd(params, listener);
        } else if (format.equals("banner")) {
            loadBannerAd(params, listener);
        } else {
            listener.onError();
        }
    }
}
