package com.inmobi.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.ads.AdUnit.AdState;
import com.inmobi.ads.AdUnit.C0629a;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.p000a.SdkContext;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class InMobiBanner extends RelativeLayout {
    private static final String TAG;
    private long mAdLoadCalledTimestamp;
    private AnimationType mAnimationType;
    private BannerAdUnit mBackgroundBannerAdUnit;
    private final C0629a mBannerAdListener;
    private BannerAdUnit mBannerAdUnit1;
    private BannerAdUnit mBannerAdUnit2;
    private int mBannerHeightInDp;
    private int mBannerWidthInDp;
    private C0635b mClientCallbackHandler;
    private BannerAdListener mClientListener;
    private BannerAdUnit mForegroundBannerAdUnit;
    private boolean mIsAutoRefreshEnabled;
    private boolean mIsInitialized;
    private BannerRefreshHandler mRefreshHandler;
    private int mRefreshInterval;

    /* renamed from: com.inmobi.ads.InMobiBanner.1 */
    class C06311 implements Runnable {
        final /* synthetic */ boolean f1406a;
        final /* synthetic */ InMobiBanner f1407b;

        C06311(InMobiBanner inMobiBanner, boolean z) {
            this.f1407b = inMobiBanner;
            this.f1406a = z;
        }

        public void run() {
            if (this.f1407b.hasValidSize()) {
                this.f1407b.cancelScheduledRefresh();
                if (this.f1407b.checkForRefreshRate()) {
                    this.f1407b.mBackgroundBannerAdUnit.m5819a(this.f1406a);
                    return;
                }
                return;
            }
            Logger.m1744a(InternalLogLevel.ERROR, InMobiBanner.TAG, "The height or width of the banner can not be determined");
            this.f1407b.mBannerAdListener.m1425a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
        }
    }

    /* renamed from: com.inmobi.ads.InMobiBanner.2 */
    class C06322 implements OnGlobalLayoutListener {
        final /* synthetic */ InMobiBanner f1408a;

        C06322(InMobiBanner inMobiBanner) {
            this.f1408a = inMobiBanner;
        }

        public void onGlobalLayout() {
            this.f1408a.mBannerWidthInDp = DisplayInfo.m1784a(this.f1408a.getMeasuredWidth());
            this.f1408a.mBannerHeightInDp = DisplayInfo.m1784a(this.f1408a.getMeasuredHeight());
            if (!this.f1408a.hasValidSize()) {
                return;
            }
            if (VERSION.SDK_INT >= 16) {
                this.f1408a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.f1408a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* renamed from: com.inmobi.ads.InMobiBanner.3 */
    class C06333 implements AnimationListener {
        final /* synthetic */ C0634a f1409a;
        final /* synthetic */ InMobiBanner f1410b;

        C06333(InMobiBanner inMobiBanner, C0634a c0634a) {
            this.f1410b = inMobiBanner;
            this.f1409a = c0634a;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f1410b.displayAd();
            this.f1409a.m1431a();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public enum AnimationType {
        ANIMATION_OFF,
        ROTATE_HORIZONTAL_AXIS,
        ANIMATION_ALPHA,
        ROTATE_VERTICAL_AXIS
    }

    public interface BannerAdListener {
        void onAdDismissed(InMobiBanner inMobiBanner);

        void onAdDisplayed(InMobiBanner inMobiBanner);

        void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map);

        void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiBanner inMobiBanner);

        void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map);

        void onUserLeftApplication(InMobiBanner inMobiBanner);
    }

    /* renamed from: com.inmobi.ads.InMobiBanner.a */
    private interface C0634a {
        void m1431a();
    }

    /* renamed from: com.inmobi.ads.InMobiBanner.b */
    private static final class C0635b extends Handler {
        private WeakReference<BannerAdListener> f1411a;
        private WeakReference<InMobiBanner> f1412b;

        public C0635b(InMobiBanner inMobiBanner, BannerAdListener bannerAdListener) {
            super(Looper.getMainLooper());
            this.f1412b = new WeakReference(inMobiBanner);
            this.f1411a = new WeakReference(bannerAdListener);
        }

        public void m1432a(BannerAdListener bannerAdListener) {
            this.f1411a = new WeakReference(bannerAdListener);
        }

        public void handleMessage(Message message) {
            Map map = null;
            InMobiBanner inMobiBanner = (InMobiBanner) this.f1412b.get();
            BannerAdListener bannerAdListener = (BannerAdListener) this.f1411a.get();
            if (inMobiBanner != null && bannerAdListener != null) {
                switch (message.what) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        bannerAdListener.onAdLoadSucceeded(inMobiBanner);
                    case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                        bannerAdListener.onAdLoadFailed(inMobiBanner, (InMobiAdRequestStatus) message.obj);
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        bannerAdListener.onAdDisplayed(inMobiBanner);
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        bannerAdListener.onAdDismissed(inMobiBanner);
                    case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                        if (message.obj != null) {
                            map = (Map) message.obj;
                        }
                        bannerAdListener.onAdInteraction(inMobiBanner, map);
                    case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                        bannerAdListener.onUserLeftApplication(inMobiBanner);
                    case ConnectionResult.NETWORK_ERROR /*7*/:
                        if (message.obj != null) {
                            map = (Map) message.obj;
                        }
                        bannerAdListener.onAdRewardActionCompleted(inMobiBanner, map);
                    default:
                        Logger.m1744a(InternalLogLevel.INTERNAL, InMobiBanner.TAG, "Unhandled ad lifecycle event! Ignoring ...");
                }
            }
        }
    }

    /* renamed from: com.inmobi.ads.InMobiBanner.4 */
    class C14094 implements C0629a {
        final /* synthetic */ InMobiBanner f4370a;

        /* renamed from: com.inmobi.ads.InMobiBanner.4.1 */
        class C14081 implements C0634a {
            final /* synthetic */ C14094 f4369a;

            C14081(C14094 c14094) {
                this.f4369a = c14094;
            }

            public void m4998a() {
                this.f4369a.f4370a.mClientCallbackHandler.sendEmptyMessage(1);
                this.f4369a.f4370a.scheduleRefresh();
            }
        }

        C14094(InMobiBanner inMobiBanner) {
            this.f4370a = inMobiBanner;
        }

        public void m4999a() {
            if (this.f4370a.mForegroundBannerAdUnit == null || !this.f4370a.mForegroundBannerAdUnit.m5830x()) {
                this.f4370a.swapAdUnitsAndDisplayAd(new C14081(this));
            }
        }

        public void m5000a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = inMobiAdRequestStatus;
            this.f4370a.mClientCallbackHandler.sendMessage(obtain);
            this.f4370a.scheduleRefresh();
        }

        public void m5002b() {
            this.f4370a.mClientCallbackHandler.sendEmptyMessage(3);
        }

        public void m5004c() {
            this.f4370a.scheduleRefresh();
            this.f4370a.mClientCallbackHandler.sendEmptyMessage(4);
        }

        public void m5001a(Map<Object, Object> map) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = map;
            this.f4370a.mClientCallbackHandler.sendMessage(obtain);
        }

        public void m5005d() {
            this.f4370a.mClientCallbackHandler.sendEmptyMessage(6);
        }

        public void m5003b(Map<Object, Object> map) {
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.obj = map;
            this.f4370a.mClientCallbackHandler.sendMessage(obtain);
        }
    }

    static {
        TAG = InMobiBanner.class.getSimpleName();
    }

    public InMobiBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsInitialized = false;
        this.mIsAutoRefreshEnabled = true;
        this.mBannerWidthInDp = 0;
        this.mBannerHeightInDp = 0;
        this.mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.mAdLoadCalledTimestamp = 0;
        this.mBannerAdListener = new C14094(this);
        if (SdkContext.m1561a()) {
            String str = "http://schemas.android.com/apk/lib/com.inmobi.ads";
            this.mClientCallbackHandler = new C0635b(this, this.mClientListener);
            str = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "refreshInterval");
            if (str != null) {
                try {
                    initializeAdUnit(context, Long.parseLong(str.trim()));
                } catch (Throwable e) {
                    Map hashMap = new HashMap();
                    hashMap.put("errorCode", "InvalidPlacement");
                    hashMap.put("type", "banner");
                    TelemetryComponent.m5070a().m5092a("ads", "AdLoadFailed", hashMap);
                    Logger.m1745a(InternalLogLevel.ERROR, TAG, "Placement id value supplied in XML layout is not valid. Banner creation failed.", e);
                }
            } else {
                Logger.m1744a(InternalLogLevel.ERROR, TAG, "Placement id value is not supplied in XML layout. Banner creation failed.");
            }
            if (attributeValue != null) {
                try {
                    setRefreshInterval(Integer.parseInt(attributeValue.trim()));
                    return;
                } catch (Throwable e2) {
                    Logger.m1745a(InternalLogLevel.ERROR, TAG, "Refresh interval value supplied in XML layout is not valid. Falling back to default value.", e2);
                    return;
                }
            }
            return;
        }
        Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
    }

    public InMobiBanner(Context context, long j) {
        super(context);
        this.mIsInitialized = false;
        this.mIsAutoRefreshEnabled = true;
        this.mBannerWidthInDp = 0;
        this.mBannerHeightInDp = 0;
        this.mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.mAdLoadCalledTimestamp = 0;
        this.mBannerAdListener = new C14094(this);
        if (context == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Context supplied as null, the ad unit can't be created.");
        } else if (SdkContext.m1561a()) {
            this.mClientCallbackHandler = new C0635b(this, this.mClientListener);
            initializeAdUnit(context, j);
        } else {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
        }
    }

    public void load() {
        load(false);
    }

    void load(boolean z) {
        if (!this.mIsInitialized) {
            return;
        }
        if (getLayoutParams() == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "The layout params of the banner must be set before calling load");
            this.mBannerAdListener.m1425a(new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
        } else if (getLayoutParams().width == -2 || getLayoutParams().height == -2) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "The height or width of a Banner ad can't be WRAP_CONTENT");
            this.mBannerAdListener.m1425a(new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
        } else if (this.mForegroundBannerAdUnit == null || !this.mForegroundBannerAdUnit.m5830x()) {
            if (!hasValidSize()) {
                setSizeFromLayoutParams();
            }
            if (hasValidSize()) {
                cancelScheduledRefresh();
                if (checkForRefreshRate()) {
                    this.mBackgroundBannerAdUnit.m5819a(z);
                    return;
                }
                return;
            }
            new Handler().postDelayed(new C06311(this, z), 200);
        } else {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = new InMobiAdRequestStatus(StatusCode.AD_ACTIVE);
            this.mClientCallbackHandler.sendMessage(obtain);
            this.mForegroundBannerAdUnit.m4974c("AdActive");
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
        }
    }

    private final boolean checkForRefreshRate() {
        if (this.mAdLoadCalledTimestamp != 0) {
            int f = this.mBackgroundBannerAdUnit.m4987k().m5031f();
            if (SystemClock.elapsedRealtime() - this.mAdLoadCalledTimestamp < ((long) (f * 1000))) {
                this.mBackgroundBannerAdUnit.m4959a(new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + f + " seconds"), false);
                Logger.m1744a(InternalLogLevel.ERROR, TAG, "Ad cannot be refreshed before " + f + " seconds");
                return false;
            }
        }
        this.mAdLoadCalledTimestamp = SystemClock.elapsedRealtime();
        return true;
    }

    public void setExtras(Map<String, String> map) {
        if (this.mIsInitialized) {
            this.mBannerAdUnit1.m4966a((Map) map);
            this.mBannerAdUnit2.m4966a((Map) map);
        }
    }

    public void setKeywords(String str) {
        if (this.mIsInitialized) {
            this.mBannerAdUnit1.m4965a(str);
            this.mBannerAdUnit2.m4965a(str);
        }
    }

    public void setListener(BannerAdListener bannerAdListener) {
        if (bannerAdListener == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Please pass a non-null listener to the banner.");
            return;
        }
        this.mClientListener = bannerAdListener;
        if (this.mClientCallbackHandler != null) {
            this.mClientCallbackHandler.m1432a(bannerAdListener);
        }
    }

    public void setEnableAutoRefresh(boolean z) {
        if (this.mIsInitialized && this.mIsAutoRefreshEnabled != z) {
            this.mIsAutoRefreshEnabled = z;
            if (this.mIsAutoRefreshEnabled) {
                scheduleRefresh();
            } else {
                cancelScheduledRefresh();
            }
        }
    }

    public void setRefreshInterval(int i) {
        if (this.mIsInitialized) {
            if (i < this.mBackgroundBannerAdUnit.m4987k().m5031f()) {
                i = this.mBackgroundBannerAdUnit.m4987k().m5031f();
            }
            this.mRefreshInterval = i;
        }
    }

    public void setAnimationType(AnimationType animationType) {
        if (this.mIsInitialized) {
            this.mAnimationType = animationType;
        }
    }

    public void disableHardwareAcceleration() {
        if (this.mIsInitialized) {
            this.mBannerAdUnit1.m5828v();
            this.mBannerAdUnit2.m5828v();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsInitialized) {
            setSizeFromLayoutParams();
            if (!hasValidSize()) {
                setupBannerSizeObserver();
            }
            scheduleRefresh();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsInitialized) {
            cancelScheduledRefresh();
        }
    }

    private void setSizeFromLayoutParams() {
        if (getLayoutParams() != null) {
            this.mBannerWidthInDp = DisplayInfo.m1784a(getLayoutParams().width);
            this.mBannerHeightInDp = DisplayInfo.m1784a(getLayoutParams().height);
        }
    }

    @TargetApi(16)
    void setupBannerSizeObserver() {
        getViewTreeObserver().addOnGlobalLayoutListener(new C06322(this));
    }

    boolean hasValidSize() {
        return this.mBannerWidthInDp > 0 && this.mBannerHeightInDp > 0;
    }

    String getFrameSizeString() {
        return this.mBannerWidthInDp + "x" + this.mBannerHeightInDp;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.mIsInitialized) {
            return;
        }
        if (i == 0) {
            scheduleRefresh();
        } else {
            cancelScheduledRefresh();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!this.mIsInitialized) {
            return;
        }
        if (z) {
            scheduleRefresh();
        } else {
            cancelScheduledRefresh();
        }
    }

    private void initializeAdUnit(Context context, long j) {
        this.mBannerAdUnit1 = new BannerAdUnit(this, context, j, this.mBannerAdListener);
        this.mBannerAdUnit2 = new BannerAdUnit(this, context, j, this.mBannerAdListener);
        this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
        this.mRefreshInterval = this.mBackgroundBannerAdUnit.m4987k().m5032g();
        this.mRefreshHandler = new BannerRefreshHandler(this);
        this.mIsInitialized = true;
    }

    private void scheduleRefresh() {
        if (isShown() && hasWindowFocus()) {
            this.mRefreshHandler.removeMessages(1);
            if (this.mBackgroundBannerAdUnit.m4982g() == AdState.STATE_LOADING || this.mBackgroundBannerAdUnit.m4982g() == AdState.STATE_AVAILABLE || (this.mForegroundBannerAdUnit != null && this.mForegroundBannerAdUnit.m4982g() == AdState.STATE_ACTIVE)) {
                Logger.m1744a(InternalLogLevel.INTERNAL, TAG, "Ignoring an attempt to schedule refresh when an ad is already loading or active.");
            } else if (this.mIsAutoRefreshEnabled) {
                this.mRefreshHandler.sendEmptyMessageDelayed(1, (long) (this.mRefreshInterval * 1000));
            }
        }
    }

    private void cancelScheduledRefresh() {
        this.mRefreshHandler.removeMessages(1);
    }

    private void displayAd() {
        if (this.mForegroundBannerAdUnit.m5829w()) {
            this.mForegroundBannerAdUnit.m4989m().m1987o();
        }
        ViewGroup viewGroup = (ViewGroup) this.mForegroundBannerAdUnit.m4989m().getParent();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (viewGroup == null) {
            addView(this.mForegroundBannerAdUnit.m4989m(), layoutParams);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(this.mForegroundBannerAdUnit.m4989m(), layoutParams);
        }
        this.mBackgroundBannerAdUnit.m4994r();
    }

    private void swapAdUnitsAndDisplayAd(C0634a c0634a) {
        if (this.mForegroundBannerAdUnit == null) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        } else if (this.mForegroundBannerAdUnit.equals(this.mBannerAdUnit1)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit2;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit1;
        } else if (this.mForegroundBannerAdUnit.equals(this.mBannerAdUnit2)) {
            this.mForegroundBannerAdUnit = this.mBannerAdUnit1;
            this.mBackgroundBannerAdUnit = this.mBannerAdUnit2;
        }
        Animation a = AnimationController.m1531a(this.mAnimationType, (float) getWidth(), (float) getHeight());
        if (a == null) {
            displayAd();
            c0634a.m1431a();
            return;
        }
        a.setAnimationListener(new C06333(this, c0634a));
        startAnimation(a);
    }
}
