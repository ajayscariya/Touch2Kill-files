package com.inmobi.commons.core.network;

/* renamed from: com.inmobi.commons.core.network.d */
public final class SyncNetworkTask {
    private NetworkRequest f1621a;

    public SyncNetworkTask(NetworkRequest networkRequest) {
        this.f1621a = networkRequest;
    }

    public NetworkResponse m1740a() {
        return new NetworkConnection(this.f1621a).m1733a();
    }
}
