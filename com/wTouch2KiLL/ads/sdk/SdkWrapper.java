package com.wTouch2KiLL.ads.sdk;

import android.app.Activity;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.ui.dialog.ProgressDialogManager;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class SdkWrapper {
    public static final String KEY_ADCOLONY = "ADCOLONY";
    public static final String KEY_CHARTBOOST = "CHARTBOOST";
    public static final String KEY_INMOBI = "INMOBI";
    public static final String KEY_SILVERMOB = "SILVERMOB";
    protected Activity _activity;
    private boolean _isActive;
    protected HashMap<String, String> parameters;

    public SdkWrapper() {
        this._activity = null;
        this._isActive = false;
    }

    public void addExtras(HashMap<String, String> extras) {
        if (this.parameters == null) {
            this.parameters = new HashMap();
        }
        for (Entry<String, String> item : extras.entrySet()) {
            this.parameters.put(item.getKey(), item.getValue());
        }
    }

    public void startSession(Activity activity) {
        if (isActive()) {
            stopSession();
        }
        this._activity = activity;
        this._isActive = true;
    }

    public void stopSession() {
        this._isActive = false;
        this._activity = null;
    }

    public boolean isActive() {
        return this._isActive;
    }

    public void showFsBanner() {
        if (this._isActive) {
            MainNavigationActivity activity = this._activity;
            ProgressDialogManager.getInstance(activity).dismissProgressDialog();
            activity.showContentView();
        }
    }

    public void setFSBannerCallbacksForSdk(String onAdReadyJSCallback, String onAdFailedJSCallback, String onAdClickedJSCallback, String onAdCLosedJSCallback) {
    }
}
