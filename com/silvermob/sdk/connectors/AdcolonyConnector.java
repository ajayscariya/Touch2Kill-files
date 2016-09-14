package com.silvermob.sdk.connectors;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyVideoAd;
import com.silvermob.sdk.connectors.Connector.Listener;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AdcolonyConnector implements Connector {
    private Context context;
    private AdColonyVideoAd mAdColonyVideoAd;
    private Boolean mIsLoading;
    private Map<String, String> mPrefs;
    private Integer mTries;

    /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.1 */
    class C07921 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;

        /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.1.1 */
        class C14561 implements AdColonyAdListener {

            /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.1.1.1 */
            class C07901 implements Runnable {
                C07901() {
                }

                public void run() {
                    C07921.this.val$listener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.1.1.2 */
            class C07912 implements Runnable {
                C07912() {
                }

                public void run() {
                    C07921.this.val$listener.onAdShown();
                }
            }

            C14561() {
            }

            public void onAdColonyAdAttemptFinished(AdColonyAd adColonyAd) {
                C07921.this.val$handler.post(new C07901());
            }

            public void onAdColonyAdStarted(AdColonyAd adColonyAd) {
                C07921.this.val$handler.post(new C07912());
            }
        }

        C07921(Handler handler, Listener listener) {
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            AdcolonyConnector.this.mAdColonyVideoAd.withListener(new C14561());
            AdcolonyConnector.this.mAdColonyVideoAd.show();
        }
    }

    /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.2 */
    class C07962 implements Runnable {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Listener val$listener;
        final /* synthetic */ ScheduledThreadPoolExecutor val$mScheduledThreadPoolExecutor;

        /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.2.1 */
        class C07931 implements Runnable {
            C07931() {
            }

            public void run() {
                C07962.this.val$listener.onError();
            }
        }

        /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.2.2 */
        class C07942 implements Runnable {
            C07942() {
            }

            public void run() {
                C07962.this.val$listener.onAdLoaded(null);
            }
        }

        /* renamed from: com.silvermob.sdk.connectors.AdcolonyConnector.2.3 */
        class C07953 implements Runnable {
            C07953() {
            }

            public void run() {
                C07962.this.val$listener.onError();
            }
        }

        C07962(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Handler handler, Listener listener) {
            this.val$mScheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
            this.val$handler = handler;
            this.val$listener = listener;
        }

        public void run() {
            AdcolonyConnector.this.mTries;
            AdcolonyConnector.this.mTries = Integer.valueOf(AdcolonyConnector.this.mTries.intValue() + 1);
            if (AdcolonyConnector.this.mAdColonyVideoAd.noFill()) {
                AdcolonyConnector.this.mIsLoading = Boolean.valueOf(false);
                this.val$mScheduledThreadPoolExecutor.shutdownNow();
                this.val$handler.post(new C07931());
            } else if (AdcolonyConnector.this.mAdColonyVideoAd.isReady()) {
                AdcolonyConnector.this.mIsLoading = Boolean.valueOf(false);
                this.val$mScheduledThreadPoolExecutor.shutdownNow();
                this.val$handler.post(new C07942());
            } else if (AdcolonyConnector.this.mTries.intValue() > 3) {
                AdcolonyConnector.this.mIsLoading = Boolean.valueOf(false);
                this.val$mScheduledThreadPoolExecutor.shutdownNow();
                this.val$handler.post(new C07953());
            }
        }
    }

    public AdcolonyConnector() {
        this.mIsLoading = Boolean.valueOf(false);
    }

    public void init(Context ctx, Map<String, String> prefs) {
        this.mPrefs = prefs;
        this.context = ctx;
    }

    public String getName() {
        return "adcolony";
    }

    public void showInterstitialAd(Listener listener) {
        this.mAdColonyVideoAd.show();
        new C07921(new Handler(), listener).run();
    }

    private void loadInterstitialAd(Map<String, String> map, Listener listener) {
        AdColony.configure((Activity) this.context, "version:2.1,store:google", (String) this.mPrefs.get("appId"), (String) this.mPrefs.get("intPlacementId"));
        AdColony.resume((Activity) this.context);
        this.mAdColonyVideoAd = new AdColonyVideoAd((String) this.mPrefs.get("intPlacementId"));
        Handler handler = new Handler();
        ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = new C07962(mScheduledThreadPoolExecutor, handler, listener);
        if (!this.mIsLoading.booleanValue()) {
            mScheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
            this.mTries = Integer.valueOf(0);
            this.mIsLoading = Boolean.valueOf(true);
        }
    }

    private void loadVideoAd(Map<String, String> map, Listener listener) {
        listener.onError();
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
