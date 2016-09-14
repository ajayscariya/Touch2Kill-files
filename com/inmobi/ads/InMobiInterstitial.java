package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.lang.ref.WeakReference;
import java.util.Map;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class InMobiInterstitial {
    private static final String TAG;
    private C0636a mClientCallbackHandler;
    private final C0629a mInterstitialAdListener;
    private InterstitialAdUnit mInterstitialAdUnit;
    private InterstitialAdListener mlistener;

    public interface InterstitialAdListener {
        void onAdDismissed(InMobiInterstitial inMobiInterstitial);

        void onAdDisplayed(InMobiInterstitial inMobiInterstitial);

        void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map);

        void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial);

        void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map);

        void onUserLeftApplication(InMobiInterstitial inMobiInterstitial);
    }

    /* renamed from: com.inmobi.ads.InMobiInterstitial.a */
    private static final class C0636a extends Handler {
        private WeakReference<InterstitialAdListener> f1413a;
        private WeakReference<InMobiInterstitial> f1414b;

        public C0636a(InMobiInterstitial inMobiInterstitial, InterstitialAdListener interstitialAdListener) {
            super(Looper.getMainLooper());
            this.f1414b = new WeakReference(inMobiInterstitial);
            this.f1413a = new WeakReference(interstitialAdListener);
        }

        public void handleMessage(Message message) {
            Map map = null;
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f1414b.get();
            InterstitialAdListener interstitialAdListener = (InterstitialAdListener) this.f1413a.get();
            if (inMobiInterstitial != null && interstitialAdListener != null) {
                switch (message.what) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        interstitialAdListener.onAdLoadSucceeded(inMobiInterstitial);
                    case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                        interstitialAdListener.onAdLoadFailed(inMobiInterstitial, (InMobiAdRequestStatus) message.obj);
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        interstitialAdListener.onAdDisplayed(inMobiInterstitial);
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        interstitialAdListener.onAdDismissed(inMobiInterstitial);
                    case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                        if (message.obj != null) {
                            map = (Map) message.obj;
                        }
                        interstitialAdListener.onAdInteraction(inMobiInterstitial, map);
                    case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                        interstitialAdListener.onUserLeftApplication(inMobiInterstitial);
                    case ConnectionResult.NETWORK_ERROR /*7*/:
                        if (message.obj != null) {
                            map = (Map) message.obj;
                        }
                        interstitialAdListener.onAdRewardActionCompleted(inMobiInterstitial, map);
                    default:
                        Logger.m1744a(InternalLogLevel.INTERNAL, InMobiInterstitial.TAG, "Unhandled ad lifecycle event! Ignoring ...");
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.InMobiInterstitial.1 */
    class C14101 implements C0629a {
        final /* synthetic */ InMobiInterstitial f4371a;

        C14101(InMobiInterstitial inMobiInterstitial) {
            this.f4371a = inMobiInterstitial;
        }

        public void m5006a() {
            this.f4371a.mClientCallbackHandler.sendEmptyMessage(1);
        }

        public void m5007a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = inMobiAdRequestStatus;
            this.f4371a.mClientCallbackHandler.sendMessage(obtain);
        }

        public void m5009b() {
            this.f4371a.mClientCallbackHandler.sendEmptyMessage(3);
        }

        public void m5011c() {
            this.f4371a.mClientCallbackHandler.sendEmptyMessage(4);
        }

        public void m5008a(Map<Object, Object> map) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = map;
            this.f4371a.mClientCallbackHandler.sendMessage(obtain);
        }

        public void m5012d() {
            this.f4371a.mClientCallbackHandler.sendEmptyMessage(6);
        }

        public void m5010b(Map<Object, Object> map) {
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.obj = map;
            this.f4371a.mClientCallbackHandler.sendMessage(obtain);
        }
    }

    static {
        TAG = InMobiInterstitial.class.getSimpleName();
    }

    public InMobiInterstitial(Context context, long j, InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdListener = new C14101(this);
        if (!SdkContext.m1561a()) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
        } else if (interstitialAdListener == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
        } else if (context == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Unable to create ad unit with NULL context object.");
        } else {
            this.mInterstitialAdUnit = new InterstitialAdUnit(context, j, this.mInterstitialAdListener);
            this.mlistener = interstitialAdListener;
            this.mClientCallbackHandler = new C0636a(this, interstitialAdListener);
        }
    }

    public void setKeywords(String str) {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m4965a(str);
        }
    }

    public void load() {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m5841n();
        }
    }

    public void show() {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m5845v();
        }
    }

    public void show(int i, int i2) {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m5832a(i, i2);
        }
    }

    public boolean isReady() {
        if (this.mInterstitialAdUnit == null) {
            return false;
        }
        return this.mInterstitialAdUnit.m5847x();
    }

    public void setExtras(Map<String, String> map) {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m4966a((Map) map);
        }
    }

    public void disableHardwareAcceleration() {
        if (this.mInterstitialAdUnit != null) {
            this.mInterstitialAdUnit.m5848y();
        }
    }
}
