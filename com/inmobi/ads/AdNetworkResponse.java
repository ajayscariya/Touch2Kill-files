package com.inmobi.ads;

import com.google.android.gms.common.ConnectionResult;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.network.NetworkResponse;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.inmobi.ads.f */
final class AdNetworkResponse {
    private NetworkResponse f1456a;
    private InMobiAdRequestStatus f1457b;
    private AdNetworkRequest f1458c;

    /* renamed from: com.inmobi.ads.f.1 */
    static /* synthetic */ class AdNetworkResponse {
        static final /* synthetic */ int[] f1455a;

        static {
            f1455a = new int[ErrorCode.values().length];
            try {
                f1455a[ErrorCode.NETWORK_UNAVAILABLE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1455a[ErrorCode.HTTP_BAD_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1455a[ErrorCode.HTTP_GATEWAY_TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1455a[ErrorCode.HTTP_INTERNAL_SERVER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1455a[ErrorCode.HTTP_NOT_IMPLEMENTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1455a[ErrorCode.HTTP_BAD_GATEWAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1455a[ErrorCode.HTTP_SERVER_NOT_AVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f1455a[ErrorCode.HTTP_VERSION_NOT_SUPPORTED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public AdNetworkResponse(AdNetworkRequest adNetworkRequest, NetworkResponse networkResponse) {
        this.f1458c = adNetworkRequest;
        this.f1456a = networkResponse;
        if (this.f1456a.m1739c() != null) {
            m1502e();
        }
    }

    private void m1502e() {
        switch (AdNetworkResponse.f1455a[this.f1456a.m1739c().m1699a().ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                this.f1457b = new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE);
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                this.f1457b = new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                this.f1457b = new InMobiAdRequestStatus(StatusCode.REQUEST_TIMED_OUT);
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
            case ConnectionResult.NETWORK_ERROR /*7*/:
            case ConnectionResult.INTERNAL_ERROR /*8*/:
                this.f1457b = new InMobiAdRequestStatus(StatusCode.SERVER_ERROR);
            default:
                this.f1457b = new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR);
        }
    }

    public InMobiAdRequestStatus m1503a() {
        return this.f1457b;
    }

    public AdNetworkRequest m1504b() {
        return this.f1458c;
    }

    public String m1505c() {
        return this.f1456a.m1738b();
    }

    public NetworkError m1506d() {
        return this.f1456a.m1739c();
    }
}
