package com.wTouch2KiLL.ads.sdk;

import android.app.Activity;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiInterstitial.InterstitialAdListener;
import com.inmobi.sdk.InMobiSdk;
import com.wTouch2KiLL.server.StatController;
import java.util.Map;

public class InmobiSdkWrapper extends SdkWrapper {
    private static final String KEY_ACCOUNT_ID = "account_id";
    private static final String KEY_PLACEMENT_ID = "placement_id";

    /* renamed from: com.wTouch2KiLL.ads.sdk.InmobiSdkWrapper.1 */
    class C08951 implements Runnable {
        final /* synthetic */ Activity val$activity;

        C08951(Activity activity) {
            this.val$activity = activity;
        }

        public void run() {
            super.startSession(this.val$activity);
            InMobiSdk.init(this.val$activity, (String) InmobiSdkWrapper.this.parameters.get(InmobiSdkWrapper.KEY_ACCOUNT_ID));
        }
    }

    /* renamed from: com.wTouch2KiLL.ads.sdk.InmobiSdkWrapper.2 */
    class C08962 implements Runnable {

        /* renamed from: com.wTouch2KiLL.ads.sdk.InmobiSdkWrapper.2.1 */
        class C14691 implements InterstitialAdListener {
            C14691() {
            }

            public void onUserLeftApplication(InMobiInterstitial arg0) {
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_INMOBI_INTERSTITIAL_CLICK_URL);
            }

            public void onAdRewardActionCompleted(InMobiInterstitial arg0, Map<Object, Object> map) {
            }

            public void onAdLoadSucceeded(InMobiInterstitial ad) {
                if (ad.isReady()) {
                    ad.show();
                    StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_INMOBI_INTERSTITIAL_IMPRESSION_URL);
                }
            }

            public void onAdLoadFailed(InMobiInterstitial arg0, InMobiAdRequestStatus arg1) {
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_INMOBI_INTERSTITIAL_NO_FILL_URL);
            }

            public void onAdInteraction(InMobiInterstitial arg0, Map<Object, Object> map) {
            }

            public void onAdDisplayed(InMobiInterstitial arg0) {
            }

            public void onAdDismissed(InMobiInterstitial arg0) {
            }
        }

        C08962() {
        }

        public void run() {
            super.showFsBanner();
            new InMobiInterstitial(InmobiSdkWrapper.this._activity, Long.parseLong((String) InmobiSdkWrapper.this.parameters.get(InmobiSdkWrapper.KEY_PLACEMENT_ID)), new C14691()).load();
            StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_INMOBI_INTERSTITIAL_REQUEST_URL);
        }
    }

    public void startSession(Activity activity) {
        activity.runOnUiThread(new C08951(activity));
    }

    public void showFsBanner() {
        this._activity.runOnUiThread(new C08962());
    }
}
