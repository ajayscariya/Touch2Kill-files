package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

/* renamed from: com.inmobi.rendering.mraid.j */
public class MraidJsFetcher {
    private static final String f2028a;
    private String f2029b;
    private int f2030c;
    private int f2031d;
    private NetworkRequest f2032e;

    /* renamed from: com.inmobi.rendering.mraid.j.1 */
    class MraidJsFetcher implements Runnable {
        final /* synthetic */ MraidJsFetcher f2027a;

        MraidJsFetcher(MraidJsFetcher mraidJsFetcher) {
            this.f2027a = mraidJsFetcher;
        }

        public void run() {
            int i = 0;
            while (i <= this.f2027a.f2030c) {
                Logger.m1744a(InternalLogLevel.INTERNAL, MraidJsFetcher.f2028a, "Attempting to get MRAID Js.");
                NetworkResponse a = new SyncNetworkTask(this.f2027a.f2032e).m1740a();
                if (a.m1737a()) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, MraidJsFetcher.f2028a, "Getting MRAID Js from server failed.");
                    i++;
                    if (i <= this.f2027a.f2030c) {
                        try {
                            Thread.sleep((long) (this.f2027a.f2031d * 1000));
                        } catch (Throwable e) {
                            Logger.m1745a(InternalLogLevel.INTERNAL, MraidJsFetcher.f2028a, "MRAID Js client interrupted while sleeping.", e);
                        }
                    } else {
                        return;
                    }
                }
                Logger.m1744a(InternalLogLevel.INTERNAL, MraidJsFetcher.f2028a, "Getting MRAID Js from server succeeded. Response:" + a.m1738b());
                new MraidJsDao().m2119a(a.m1738b());
                return;
            }
        }
    }

    static {
        f2028a = MraidJsFetcher.class.getSimpleName();
    }

    public MraidJsFetcher(String str, int i, int i2) {
        this.f2029b = str;
        this.f2030c = i;
        this.f2031d = i2;
    }

    public void m2126a() {
        if (this.f2029b == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2028a, "MRAID Js Url provided is invalid.");
            return;
        }
        this.f2032e = new NetworkRequest(RequestType.GET, this.f2029b, false, null);
        new Thread(new MraidJsFetcher(this)).start();
    }
}
