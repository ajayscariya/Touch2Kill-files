package com.wTouch2KiLL.ads.FullscreenBanner;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.MainNavigationActivity.ApplicationState;
import com.wTouch2KiLL.ads.AdMobUtils.AdMobParameters;
import com.wTouch2KiLL.ads.AdMobUtils.ParameterizedRequest;
import com.wTouch2KiLL.pull.StatServerClient;
import com.wTouch2KiLL.ui.dialog.ProgressDialogManager;
import com.wTouch2KiLL.ui.dialog.StartupConfirmationDialog;
import com.wTouch2KiLL.ui.dialog.StartupConfirmationDialogActionListener;
import mf.javax.xml.XMLConstants;

public class AdMobFSBannerController extends AdListener {
    private static final String TAG;
    private boolean _active;
    private Runnable _dismissAdMobFSRunnable;
    private Handler _handler;
    private InterstitialAd _interstitial;
    private MainNavigationActivity _mainActivity;
    StatServerClient _statClient;
    private boolean _timeoutExpired;
    public Runnable showInterstitialRunnable;

    /* renamed from: com.wTouch2KiLL.ads.FullscreenBanner.AdMobFSBannerController.1 */
    class C08811 implements Runnable {
        C08811() {
        }

        public void run() {
            if (AdMobFSBannerController.this._mainActivity != null) {
                ProgressDialogManager.getInstance(AdMobFSBannerController.this._mainActivity).dismissProgressDialog();
                AdMobFSBannerController.this.setTimeoutExpired(true);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ads.FullscreenBanner.AdMobFSBannerController.2 */
    class C08822 implements Runnable {
        C08822() {
        }

        public void run() {
            ProgressDialogManager.getInstance(AdMobFSBannerController.this._mainActivity).dismissProgressDialog();
            AdMobFSBannerController.this._interstitial.show();
        }
    }

    /* renamed from: com.wTouch2KiLL.ads.FullscreenBanner.AdMobFSBannerController.3 */
    class C14653 implements StartupConfirmationDialogActionListener {
        C14653() {
        }

        public void onPositiveButtonClick() {
            ProgressDialogManager.getInstance(AdMobFSBannerController.this._mainActivity).showProgressDialog();
            AdMobFSBannerController.this._handler.postDelayed(AdMobFSBannerController.this.showInterstitialRunnable, 2000);
        }

        public void onNegativeButtonClick() {
        }
    }

    static {
        TAG = AdMobFSBannerController.class.getSimpleName();
    }

    public boolean isTimeoutExpired() {
        return this._timeoutExpired;
    }

    public void setTimeoutExpired(boolean timeoutExpired) {
        this._timeoutExpired = timeoutExpired;
    }

    public AdMobFSBannerController(MainNavigationActivity mainActivity) {
        this._interstitial = null;
        this._active = false;
        this._handler = new Handler();
        this._timeoutExpired = false;
        this._statClient = null;
        this._dismissAdMobFSRunnable = new C08811();
        this.showInterstitialRunnable = new C08822();
        this._mainActivity = mainActivity;
        this._statClient = new StatServerClient(this._mainActivity);
    }

    public void onAdClosed() {
        System.out.println("admob__onAdClosed");
        if (MainNavigationActivity.getApplicationState().equals(ApplicationState.EXITING) && this._mainActivity != null) {
            this._mainActivity.finish();
        }
    }

    public void onAdFailedToLoad(int errorCode) {
        System.out.println("admob__onAdFailedToLoad_err_" + errorCode);
        ProgressDialogManager.getInstance(this._mainActivity).dismissProgressDialog();
        Log.e(TAG, "Failed to receive ad, error code " + errorCode);
        if (MainNavigationActivity.getApplicationState().equals(ApplicationState.EXITING) && this._mainActivity != null) {
            this._mainActivity.finish();
        }
    }

    public void onAdLeftApplication() {
        System.out.println("admob__onAdLeftApplication");
    }

    public void onAdOpened() {
        System.out.println("admob__onAdOpened");
    }

    public void onAdLoaded() {
        Log.d(TAG, "Received ad");
        System.out.println("admob__onAdLoaded");
        if (!StartupConfirmationDialog.isOnScreen()) {
            ProgressDialogManager.getInstance(this._mainActivity).showProgressDialog();
        }
        if (this._interstitial.isLoaded()) {
            setActive(true);
            if (isTimeoutExpired() && !StartupConfirmationDialog.isOnScreen()) {
                Log.i(TAG, "Received ad, but timeout expired");
                if (MainNavigationActivity.getApplicationState().equals(ApplicationState.EXITING) && this._mainActivity != null) {
                    this._mainActivity.finish();
                }
            } else if (StartupConfirmationDialog.isOnScreen()) {
                StartupConfirmationDialog dialog = this._mainActivity.getAlertDialog();
                if (dialog != null) {
                    dialog.addActionListener("AdMobInterstitialShow", new C14653());
                }
            } else {
                ProgressDialogManager.getInstance(this._mainActivity).showProgressDialog();
                this._handler.postDelayed(this.showInterstitialRunnable, 2000);
            }
        }
    }

    public void loadAdMobFSBanner(String adUnitID, String keywords, String genderString, String birthday, String latitude, String longtitude) {
        setTimeoutExpired(false);
        if (adUnitID == null) {
            adUnitID = XMLConstants.NULL_NS_URI;
        }
        System.out.println("admob__adUnitID_" + adUnitID);
        this._interstitial = new InterstitialAd(this._mainActivity);
        this._interstitial.setAdUnitId(adUnitID);
        this._interstitial.setAdListener(this);
        this._interstitial.loadAd(new ParameterizedRequest(new AdMobParameters(adUnitID, keywords, genderString, birthday, latitude, longtitude)).getRequest());
    }

    public boolean isActive() {
        return this._active;
    }

    public void setActive(boolean active) {
        this._active = active;
    }

    public void dismissAdMobFSOnTimeout(long timeout) {
        if (!StartupConfirmationDialog.isOnScreen()) {
            this._handler.postDelayed(this._dismissAdMobFSRunnable, timeout);
        }
    }
}
