package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class InMobiNative {
    private static final String TAG;
    protected static WeakHashMap<View, NativeAdUnit> sMappedAdUnits;
    private C0637a mClientCallbackHandler;
    private final C0629a mListener;
    private NativeAdListener mNativeAdListener;
    protected NativeAdUnit mNativeAdUnit;

    public interface NativeAdListener {
        void onAdDismissed(InMobiNative inMobiNative);

        void onAdDisplayed(InMobiNative inMobiNative);

        void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiNative inMobiNative);

        void onUserLeftApplication(InMobiNative inMobiNative);
    }

    /* renamed from: com.inmobi.ads.InMobiNative.a */
    private static final class C0637a extends Handler {
        private WeakReference<NativeAdListener> f1415a;
        private WeakReference<InMobiNative> f1416b;

        public C0637a(InMobiNative inMobiNative, NativeAdListener nativeAdListener) {
            super(Looper.getMainLooper());
            this.f1416b = new WeakReference(inMobiNative);
            this.f1415a = new WeakReference(nativeAdListener);
        }

        public void handleMessage(Message message) {
            InMobiNative inMobiNative = (InMobiNative) this.f1416b.get();
            NativeAdListener nativeAdListener = (NativeAdListener) this.f1415a.get();
            if (inMobiNative != null && nativeAdListener != null) {
                switch (message.what) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        nativeAdListener.onAdLoadSucceeded(inMobiNative);
                    case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                        nativeAdListener.onAdLoadFailed(inMobiNative, (InMobiAdRequestStatus) message.obj);
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        nativeAdListener.onAdDisplayed(inMobiNative);
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        nativeAdListener.onAdDismissed(inMobiNative);
                    case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                        nativeAdListener.onUserLeftApplication(inMobiNative);
                    default:
                        Logger.m1744a(InternalLogLevel.INTERNAL, InMobiNative.TAG, "Unhandled ad lifecycle event! Ignoring ...");
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.InMobiNative.1 */
    class C14111 implements C0629a {
        final /* synthetic */ InMobiNative f4372a;

        C14111(InMobiNative inMobiNative) {
            this.f4372a = inMobiNative;
        }

        public void m5013a() {
            this.f4372a.mClientCallbackHandler.sendEmptyMessage(1);
        }

        public void m5014a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = inMobiAdRequestStatus;
            this.f4372a.mClientCallbackHandler.sendMessage(obtain);
        }

        public void m5016b() {
            this.f4372a.mClientCallbackHandler.sendEmptyMessage(3);
        }

        public void m5018c() {
            this.f4372a.mClientCallbackHandler.sendEmptyMessage(4);
        }

        public void m5015a(Map<Object, Object> map) {
        }

        public void m5019d() {
            this.f4372a.mClientCallbackHandler.sendEmptyMessage(5);
        }

        public void m5017b(Map<Object, Object> map) {
        }
    }

    static {
        TAG = InMobiNative.class.getSimpleName();
        sMappedAdUnits = new WeakHashMap();
    }

    public InMobiNative(long j, NativeAdListener nativeAdListener) {
        this.mListener = new C14111(this);
        if (!SdkContext.m1561a()) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
        } else if (nativeAdListener == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
        } else {
            this.mNativeAdListener = nativeAdListener;
            this.mNativeAdUnit = new NativeAdUnit(j, this.mListener);
            this.mClientCallbackHandler = new C0637a(this, nativeAdListener);
        }
    }

    public final void load() {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m5861n();
        }
    }

    public final void resume() {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m5863v();
        }
    }

    public final void pause() {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m5864w();
        }
    }

    public final Object getAdContent() {
        if (this.mNativeAdUnit == null) {
            return null;
        }
        return this.mNativeAdUnit.m5865x();
    }

    public static void bind(View view, InMobiNative inMobiNative) {
        if (view == null || inMobiNative == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
            return;
        }
        if (((NativeAdUnit) sMappedAdUnits.get(view)) != null) {
            unbind(view);
        }
        NativeAdUnit nativeAdUnit = inMobiNative.mNativeAdUnit;
        if (nativeAdUnit != null) {
            sMappedAdUnits.remove(view);
            sMappedAdUnits.put(view, nativeAdUnit);
            nativeAdUnit.m5852a(view, null, null);
        }
    }

    public static void unbind(View view) {
        if (view == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please pass a non-null view object to bind.");
            return;
        }
        NativeAdUnit nativeAdUnit = (NativeAdUnit) sMappedAdUnits.remove(view);
        if (nativeAdUnit != null) {
            nativeAdUnit.m5851a(view);
        }
    }

    public final void reportAdClickAndOpenLandingPage(Map<String, String> map) {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m5854a((Map) map, null, null);
            this.mNativeAdUnit.m5867z();
        }
    }

    public final void reportAdClick(Map<String, String> map) {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m5854a((Map) map, null, null);
        }
    }

    public final void setExtras(Map<String, String> map) {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m4966a((Map) map);
        }
    }

    public final void setKeywords(String str) {
        if (this.mNativeAdUnit != null) {
            this.mNativeAdUnit.m4965a(str);
        }
    }
}
