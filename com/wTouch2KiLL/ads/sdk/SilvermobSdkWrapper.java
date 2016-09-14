package com.wTouch2KiLL.ads.sdk;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import com.silvermob.sdk.AdManager;
import com.silvermob.sdk.AdManager.InterstitialListener;
import com.wTouch2KiLL.server.StatController;

public class SilvermobSdkWrapper extends SdkWrapper {
    private static final String KEY_PLACEMENT_ID = "placement_id";
    AdManager mgr;

    /* renamed from: com.wTouch2KiLL.ads.sdk.SilvermobSdkWrapper.1 */
    class C08971 implements Runnable {
        final /* synthetic */ Activity val$activity;

        /* renamed from: com.wTouch2KiLL.ads.sdk.SilvermobSdkWrapper.1.1 */
        class C14701 implements InterstitialListener {
            C14701() {
            }

            public void onAdLoaded(View adView) {
                Log.d("silvermob", "Interstitial onAdLoaded");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_LOADED_URL);
                SilvermobSdkWrapper.this.mgr.showInterstitial();
            }

            public void onShown() {
                Log.d("silvermob", "Interstitial onShown");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_IMPRESSION_URL);
            }

            public void onNoFill() {
                Log.d("silvermob", "Interstitial onNoFill");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_NO_FILL_URL);
            }

            public void onError() {
                Log.d("silvermob", "Interstitial onError");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_ERROR_URL);
            }

            public void onAdClosed() {
                Log.d("silvermob", "Interstitial onAdClosed");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_CLOSE_URL);
            }

            public void onAdClicked() {
                Log.d("silvermob", "Interstitial onAdClicked");
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_CLICK_URL);
            }
        }

        C08971(Activity activity) {
            this.val$activity = activity;
        }

        public void run() {
            super.startSession(this.val$activity);
            SilvermobSdkWrapper.this.mgr = AdManager.getInstance(this.val$activity);
            String TAG = "silvermob";
            SilvermobSdkWrapper.this.mgr.setInterstitialListener(new C14701());
        }
    }

    /* renamed from: com.wTouch2KiLL.ads.sdk.SilvermobSdkWrapper.2 */
    class C08982 implements Runnable {
        C08982() {
        }

        public void run() {
            super.showFsBanner();
            SilvermobSdkWrapper.this.mgr.requestInterstitial((String) SilvermobSdkWrapper.this.parameters.get(SilvermobSdkWrapper.KEY_PLACEMENT_ID));
            StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_SILVERMOB_INTERSTITIAL_REQUEST_URL);
        }
    }

    public void startSession(Activity activity) {
        activity.runOnUiThread(new C08971(activity));
    }

    public void showFsBanner() {
        this._activity.runOnUiThread(new C08982());
    }
}
