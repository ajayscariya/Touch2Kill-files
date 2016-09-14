package com.inmobi.ads;

import com.inmobi.commons.core.network.AsyncNetworkTask.AsyncNetworkTask;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

/* renamed from: com.inmobi.ads.d */
final class AdNetworkClient implements AsyncNetworkTask {
    private static final String f4386a;
    private AdNetworkRequest f4387b;
    private AdNetworkClient f4388c;

    /* renamed from: com.inmobi.ads.d.a */
    public interface AdNetworkClient {
        void m1500a(AdNetworkResponse adNetworkResponse);

        void m1501b(AdNetworkResponse adNetworkResponse);
    }

    static {
        f4386a = AdNetworkClient.class.getSimpleName();
    }

    public AdNetworkClient(AdNetworkRequest adNetworkRequest, AdNetworkClient adNetworkClient) {
        this.f4387b = adNetworkRequest;
        this.f4388c = adNetworkClient;
    }

    public void m5039a() {
        new com.inmobi.commons.core.network.AsyncNetworkTask(this.f4387b, this).m1726a();
    }

    public void m5040a(NetworkResponse networkResponse) {
        AdNetworkResponse adNetworkResponse = new AdNetworkResponse(this.f4387b, networkResponse);
        this.f4388c.m1500a(adNetworkResponse);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4386a, "Ad fetch succeeded. Response:" + adNetworkResponse.m1505c());
    }

    public void m5041b(NetworkResponse networkResponse) {
        AdNetworkResponse adNetworkResponse = new AdNetworkResponse(this.f4387b, networkResponse);
        this.f4388c.m1501b(adNetworkResponse);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4386a, "Ad fetch failed:" + adNetworkResponse.m1506d().m1700b());
    }
}
