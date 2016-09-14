package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {
    private static final Object f3789a;
    private static WeakReference f3790b;
    private static WeakReference f3791c;

    static {
        f3789a = new Object();
        f3790b = new WeakReference(null);
        f3791c = new WeakReference(null);
    }

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Activity activity) {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(activity);
        }
        synchronized (f3789a) {
            appLovinInterstitialAdDialog = (ah) f3790b.get();
            if (appLovinInterstitialAdDialog != null && appLovinInterstitialAdDialog.isShowing() && f3791c.get() == activity) {
                appLovinSdk.getLogger().m310w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            } else {
                appLovinInterstitialAdDialog = new ah(appLovinSdk, activity);
                f3790b = new WeakReference(appLovinInterstitialAdDialog);
                f3791c = new WeakReference(activity);
            }
        }
        return appLovinInterstitialAdDialog;
    }
}
