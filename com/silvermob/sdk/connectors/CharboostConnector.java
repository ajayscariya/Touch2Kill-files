package com.silvermob.sdk.connectors;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.silvermob.sdk.connectors.Connector.Listener;
import java.util.Map;

public class CharboostConnector implements Connector {
    private Context context;
    private String mLocation;
    private Map<String, String> mPrefs;

    /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.1 */
    class C08071 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.1.1 */
        class C15401 extends ChartboostDelegate {

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.1.1.1 */
            class C08041 implements Runnable {
                C08041() {
                }

                public void run() {
                    C08071.this.val$listener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.1.1.2 */
            class C08052 implements Runnable {
                C08052() {
                }

                public void run() {
                    C08071.this.val$listener.onAdClicked(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.1.1.3 */
            class C08063 implements Runnable {
                C08063() {
                }

                public void run() {
                    C08071.this.val$listener.onAdShown();
                }
            }

            C15401() {
            }

            public void didCloseInterstitial(String location) {
                super.didCloseInterstitial(location);
                C08071.this.val$handler.post(new C08041());
            }

            public void didClickInterstitial(String location) {
                super.didClickInterstitial(location);
                C08071.this.val$handler.post(new C08052());
            }

            public void didDisplayInterstitial(String location) {
                super.didDisplayInterstitial(location);
                C08071.this.val$handler.post(new C08063());
            }
        }

        C08071(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Chartboost.showInterstitial(CharboostConnector.this.mLocation);
            Chartboost.setDelegate(new C15401());
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.2 */
    class C08102 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.2.1 */
        class C15411 extends ChartboostDelegate {

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.2.1.1 */
            class C08081 implements Runnable {
                C08081() {
                }

                public void run() {
                    C08102.this.val$listener.onError();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.2.1.2 */
            class C08092 implements Runnable {
                C08092() {
                }

                public void run() {
                    C08102.this.val$listener.onAdLoaded(null);
                }
            }

            C15411() {
            }

            public void didFailToLoadInterstitial(String location, CBImpressionError error) {
                super.didFailToLoadInterstitial(location, error);
                C08102.this.val$handler.post(new C08081());
            }

            public void didCacheInterstitial(String location) {
                super.didCacheInterstitial(location);
                CharboostConnector.this.mLocation = location;
                C08102.this.val$handler.post(new C08092());
            }
        }

        C08102(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Chartboost.setDelegate(new C15411());
            Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.3 */
    class C08133 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.3.1 */
        class C15421 extends ChartboostDelegate {

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.3.1.1 */
            class C08111 implements Runnable {
                C08111() {
                }

                public void run() {
                    C08133.this.val$listener.onError();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.CharboostConnector.3.1.2 */
            class C08122 implements Runnable {
                C08122() {
                }

                public void run() {
                    C08133.this.val$listener.onAdShown();
                }
            }

            C15421() {
            }

            public void didFailToLoadRewardedVideo(String location, CBImpressionError error) {
                super.didFailToLoadInterstitial(location, error);
                C08133.this.val$handler.post(new C08111());
            }

            public void didCacheRewardedVideo(String location) {
                super.didCacheInterstitial(location);
                Chartboost.showInterstitial(location);
                C08133.this.val$handler.post(new C08122());
            }
        }

        C08133(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            Chartboost.setDelegate(new C15421());
            Chartboost.cacheRewardedVideo(CBLocation.LOCATION_DEFAULT);
        }
    }

    public String getName() {
        return "chartboost";
    }

    public void showInterstitialAd(Listener listener) {
        Handler handler = new Handler();
        if (this.mLocation != null) {
            ((Activity) this.context).runOnUiThread(new C08071(handler, listener));
        } else {
            listener.onError();
        }
    }

    public void init(Context ctx, Map<String, String> prefs) {
        this.context = ctx;
        this.mPrefs = prefs;
        Chartboost.startWithAppId((Activity) this.context, (String) this.mPrefs.get("appId"), (String) this.mPrefs.get("signature"));
        Chartboost.setShouldRequestInterstitialsInFirstSession(true);
        Chartboost.setAutoCacheAds(false);
        Chartboost.setShouldDisplayLoadingViewForMoreApps(false);
        Chartboost.onCreate((Activity) this.context);
        Chartboost.onStart((Activity) this.context);
    }

    private void loadInterstitialAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08102(new Handler(), listener));
    }

    private void loadVideoAd(Map<String, String> map, Listener listener) {
        ((Activity) this.context).runOnUiThread(new C08133(new Handler(), listener));
    }

    private void loadBannerAd(Map<String, String> map, Listener listener) {
        listener.onError();
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
