package com.silvermob.sdk.connectors;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.silvermob.sdk.connectors.Connector.Listener;
import java.util.Map;

public class ApplovinConnector implements Connector {
    private AppLovinAdService adService;
    private Context context;
    private AppLovinAd mLoadedInterstitialAd;
    private Map<String, String> mPrefs;
    private AppLovinSdk sdk;

    /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1 */
    class C08001 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;
        final /* synthetic */ Activity val$parentActivity;

        /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1.1 */
        class C14571 implements AppLovinAdDisplayListener {

            /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1.1.1 */
            class C07971 implements Runnable {
                C07971() {
                }

                public void run() {
                    Log.d("AdManager", "Applovin posted onAdShown");
                    C08001.this.val$listener.onAdShown();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1.1.2 */
            class C07982 implements Runnable {
                C07982() {
                }

                public void run() {
                    C08001.this.val$listener.onAdClosed();
                }
            }

            C14571() {
            }

            public void adDisplayed(AppLovinAd appLovinAd) {
                Log.d("AdManager", "Applovin adDisplayed");
                C08001.this.val$handler.post(new C07971());
            }

            public void adHidden(AppLovinAd appLovinAd) {
                C08001.this.val$handler.post(new C07982());
            }
        }

        /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1.2 */
        class C14582 implements AppLovinAdClickListener {

            /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.1.2.1 */
            class C07991 implements Runnable {
                C07991() {
                }

                public void run() {
                    C08001.this.val$listener.onAdClicked(null);
                }
            }

            C14582() {
            }

            public void adClicked(AppLovinAd appLovinAd) {
                C08001.this.val$handler.post(new C07991());
            }
        }

        C08001(Activity activity, Handler handler, Listener listener) {
            this.val$parentActivity = activity;
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            AppLovinInterstitialAdDialog inter = AppLovinInterstitialAd.create(ApplovinConnector.this.sdk, this.val$parentActivity);
            inter.setAdDisplayListener(new C14571());
            inter.setAdClickListener(new C14582());
            inter.showAndRender(ApplovinConnector.this.mLoadedInterstitialAd);
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.2 */
    class C08032 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.2.1 */
        class C14591 implements AppLovinAdLoadListener {

            /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.2.1.1 */
            class C08011 implements Runnable {
                C08011() {
                }

                public void run() {
                    C08032.this.val$listener.onAdLoaded(null);
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.ApplovinConnector.2.1.2 */
            class C08022 implements Runnable {
                C08022() {
                }

                public void run() {
                    C08032.this.val$listener.onError();
                }
            }

            C14591() {
            }

            public void adReceived(AppLovinAd appLovinAd) {
                ApplovinConnector.this.mLoadedInterstitialAd = appLovinAd;
                C08032.this.val$handler.post(new C08011());
            }

            public void failedToReceiveAd(int i) {
                Log.d("AdManager", "Applovin response code: " + i);
                C08032.this.val$handler.post(new C08022());
            }
        }

        C08032(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            ApplovinConnector.this.adService.loadNextAd(AppLovinAdSize.INTERSTITIAL, new C14591());
        }
    }

    public void init(Context ctx, Map<String, String> prefs) {
        this.context = ctx;
        this.mPrefs = prefs;
        AppLovinSdk.initializeSdk(this.context);
        this.sdk = AppLovinSdk.getInstance(this.context);
        this.adService = this.sdk.getAdService();
    }

    public String getName() {
        return AppLovinSdk.URI_SCHEME;
    }

    public void showInterstitialAd(Listener listener) {
        Handler handler = new Handler();
        if (this.mLoadedInterstitialAd != null) {
            Activity parentActivity = this.context;
            parentActivity.runOnUiThread(new C08001(parentActivity, handler, listener));
            return;
        }
        listener.onError();
    }

    private void loadInterstitialAd(Map<String, String> map, Listener listener) {
        this.context.runOnUiThread(new C08032(new Handler(), listener));
    }

    public void loadAd(Map<String, String> params, Listener listener) {
        if (((String) params.get("format")).equals("interstitial")) {
            loadInterstitialAd(params, listener);
        } else {
            listener.onError();
        }
    }
}
