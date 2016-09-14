package com.inmobi.commons.core.network;

/* renamed from: com.inmobi.commons.core.network.a */
public final class AsyncNetworkTask {
    private NetworkRequest f1612a;
    private AsyncNetworkTask f1613b;

    /* renamed from: com.inmobi.commons.core.network.a.1 */
    class AsyncNetworkTask implements Runnable {
        final /* synthetic */ AsyncNetworkTask f1611a;

        AsyncNetworkTask(AsyncNetworkTask asyncNetworkTask) {
            this.f1611a = asyncNetworkTask;
        }

        public void run() {
            NetworkResponse a = new NetworkConnection(this.f1611a.f1612a).m1733a();
            if (a.m1737a()) {
                this.f1611a.f1613b.m1723b(a);
            } else {
                this.f1611a.f1613b.m1722a(a);
            }
        }
    }

    /* renamed from: com.inmobi.commons.core.network.a.a */
    public interface AsyncNetworkTask {
        void m1722a(NetworkResponse networkResponse);

        void m1723b(NetworkResponse networkResponse);
    }

    public AsyncNetworkTask(NetworkRequest networkRequest, AsyncNetworkTask asyncNetworkTask) {
        this.f1612a = networkRequest;
        this.f1613b = asyncNetworkTask;
    }

    public void m1726a() {
        new Thread(new AsyncNetworkTask(this)).start();
    }
}
