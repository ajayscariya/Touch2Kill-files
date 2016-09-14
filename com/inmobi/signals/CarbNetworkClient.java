package com.inmobi.signals;

import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

/* renamed from: com.inmobi.signals.e */
public class CarbNetworkClient {
    private static final String f2103a;

    static {
        f2103a = CarbNetworkClient.class.getSimpleName();
    }

    public CarbGetListNetworkResponse m2237a(CarbGetListNetworkRequest carbGetListNetworkRequest) {
        CarbGetListNetworkResponse carbGetListNetworkResponse = new CarbGetListNetworkResponse(new SyncNetworkTask(carbGetListNetworkRequest).m1740a());
        if (carbGetListNetworkResponse.m2230a()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2103a, "Getting Carb list from server failed.");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2103a, "Getting Carb list from server succeeded.");
        }
        return carbGetListNetworkResponse;
    }

    public boolean m2238a(CarbPostListNetworkRequest carbPostListNetworkRequest) {
        boolean z = false;
        int i = 0;
        while (i <= carbPostListNetworkRequest.m5196b()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2103a, "Attempting to send pruned Carb list to server.");
            if (!new SyncNetworkTask(carbPostListNetworkRequest).m1740a().m1737a()) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2103a, "Sending pruned Carb list to server succeeded.");
                z = true;
                break;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, f2103a, "Sending pruned Carb list to server failed.");
            i++;
            if (i > carbPostListNetworkRequest.m5196b()) {
                break;
            }
            try {
                Thread.sleep((long) (carbPostListNetworkRequest.m5197c() * 1000));
            } catch (Throwable e) {
                Logger.m1745a(InternalLogLevel.INTERNAL, f2103a, "User data network client interrupted while sleeping.", e);
            }
        }
        if (!z) {
            TelemetryComponent.m5070a().m5090a(new TelemetryEvent("signals", "CarbUploadDiscarded"));
        }
        return z;
    }
}
