package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0266c.C0265a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* renamed from: com.chartboost.sdk.Libraries.d */
public final class C0267d {
    private C0267d() {
    }

    protected static String m424a() {
        Info advertisingIdInfo;
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C0299c.m682y());
        } catch (IOException e) {
            advertisingIdInfo = null;
        } catch (GooglePlayServicesRepairableException e2) {
            advertisingIdInfo = null;
        } catch (GooglePlayServicesNotAvailableException e3) {
            advertisingIdInfo = null;
        } catch (Throwable e4) {
            CBLogging.m380a("CBIdentityAdv", "Security Exception when retrieving AD id", e4);
            advertisingIdInfo = null;
        } catch (Throwable e42) {
            CBLogging.m380a("CBIdentityAdv", "General Exception when retrieving AD id", e42);
            advertisingIdInfo = null;
        }
        if (advertisingIdInfo == null) {
            C0266c.m411a(C0265a.UNKNOWN);
            return null;
        }
        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
            C0266c.m411a(C0265a.TRACKING_DISABLED);
        } else {
            C0266c.m411a(C0265a.TRACKING_ENABLED);
        }
        try {
            UUID fromString = UUID.fromString(advertisingIdInfo.getId());
            ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            return C0263b.m407b(wrap.array());
        } catch (Throwable e5) {
            CBLogging.m382b("CBIdentityAdv", "Exception raised retrieveAdvertisingID", e5);
            return advertisingIdInfo.getId();
        }
    }
}
