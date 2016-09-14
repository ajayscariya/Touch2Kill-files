package com.chartboost.sdk.Model;

import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class CBError {
    private C0284a f572a;
    private String f573b;
    private boolean f574c;

    /* renamed from: com.chartboost.sdk.Model.CBError.1 */
    static /* synthetic */ class C02831 {
        static final /* synthetic */ int[] f561a;

        static {
            f561a = new int[C0284a.values().length];
            try {
                f561a[C0284a.MISCELLANEOUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f561a[C0284a.UNEXPECTED_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f561a[C0284a.PUBLIC_KEY_MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f561a[C0284a.INTERNET_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f561a[C0284a.HTTP_NOT_FOUND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f561a[C0284a.NETWORK_FAILURE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f561a[C0284a.INVALID_RESPONSE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public enum CBClickError {
        URI_INVALID,
        URI_UNRECOGNIZED,
        AGE_GATE_FAILURE,
        NO_HOST_ACTIVITY,
        INTERNAL
    }

    public enum CBImpressionError {
        INTERNAL,
        INTERNET_UNAVAILABLE,
        TOO_MANY_CONNECTIONS,
        WRONG_ORIENTATION,
        FIRST_SESSION_INTERSTITIALS_DISABLED,
        NETWORK_FAILURE,
        NO_AD_FOUND,
        SESSION_NOT_STARTED,
        IMPRESSION_ALREADY_VISIBLE,
        NO_HOST_ACTIVITY,
        USER_CANCELLATION,
        INVALID_LOCATION,
        VIDEO_UNAVAILABLE,
        VIDEO_ID_MISSING,
        ERROR_PLAYING_VIDEO,
        INVALID_RESPONSE,
        ASSETS_DOWNLOAD_FAILURE,
        ERROR_CREATING_VIEW,
        ERROR_DISPLAYING_VIEW,
        INCOMPATIBLE_API_VERSION,
        ERROR_LOADING_WEB_VIEW,
        ASSET_PREFETCH_IN_PROGRESS,
        EMPTY_LOCAL_AD_LIST,
        ACTIVITY_MISSING_IN_MANIFEST,
        EMPTY_LOCAL_VIDEO_LIST
    }

    /* renamed from: com.chartboost.sdk.Model.CBError.a */
    public enum C0284a {
        MISCELLANEOUS,
        INTERNET_UNAVAILABLE,
        INVALID_RESPONSE,
        UNEXPECTED_RESPONSE,
        NETWORK_FAILURE,
        PUBLIC_KEY_MISSING,
        HTTP_NOT_FOUND
    }

    public CBError(C0284a error, String errorDesc) {
        this.f572a = error;
        this.f573b = errorDesc;
        this.f574c = true;
    }

    public C0284a m554a() {
        return this.f572a;
    }

    public String m555b() {
        return this.f573b;
    }

    public CBImpressionError m556c() {
        switch (C02831.f561a[this.f572a.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return CBImpressionError.INTERNAL;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return CBImpressionError.INTERNET_UNAVAILABLE;
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                return CBImpressionError.NO_AD_FOUND;
            default:
                return CBImpressionError.NETWORK_FAILURE;
        }
    }
}
