package com.inmobi.signals;

import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

/* renamed from: com.inmobi.signals.j */
public class IceNetworkClient {
    private static final String f2116a;
    private IceNetworkRequest f2117b;

    /* renamed from: com.inmobi.signals.j.1 */
    class IceNetworkClient implements Runnable {
        final /* synthetic */ IceNetworkClient f2115a;

        IceNetworkClient(IceNetworkClient iceNetworkClient) {
            this.f2115a = iceNetworkClient;
        }

        public void run() {
            int i = 0;
            while (i <= this.f2115a.f2117b.m5200b()) {
                Logger.m1744a(InternalLogLevel.INTERNAL, IceNetworkClient.f2116a, "Attempting to send samples to server.");
                if (new SyncNetworkTask(this.f2115a.f2117b).m1740a().m1737a()) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, IceNetworkClient.f2116a, "Sending samples to server failed.");
                    i++;
                    if (i > this.f2115a.f2117b.m5200b()) {
                        TelemetryComponent.m5070a().m5090a(new TelemetryEvent("signals", "RetryCountExceeded"));
                        return;
                    }
                    try {
                        Thread.sleep((long) (this.f2115a.f2117b.m5201c() * 1000));
                    } catch (Throwable e) {
                        Logger.m1745a(InternalLogLevel.INTERNAL, IceNetworkClient.f2116a, "User data network client interrupted while sleeping.", e);
                    }
                } else {
                    Logger.m1744a(InternalLogLevel.INTERNAL, IceNetworkClient.f2116a, "Sending samples to server succeeded.");
                    return;
                }
            }
        }
    }

    static {
        f2116a = IceNetworkClient.class.getSimpleName();
    }

    public IceNetworkClient(IceNetworkRequest iceNetworkRequest) {
        this.f2117b = iceNetworkRequest;
    }

    public void m2270a() {
        new Thread(new IceNetworkClient(this)).start();
    }
}
