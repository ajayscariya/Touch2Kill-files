package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.j */
class C1177j extends bw {
    final /* synthetic */ AppLovinAdServiceImpl f3962a;
    private final AppLovinAdSize f3963b;

    public C1177j(AppLovinAdServiceImpl appLovinAdServiceImpl, AppLovinAdSize appLovinAdSize) {
        this.f3962a = appLovinAdServiceImpl;
        super("UpdateAdTask", appLovinAdServiceImpl.f3857a);
        this.f3963b = appLovinAdSize;
    }

    public void run() {
        Object obj = 1;
        C0235i c0235i = (C0235i) ((Map) this.f3962a.f3860d.get(AppLovinAdType.REGULAR)).get(this.f3963b);
        synchronized (c0235i.f327b) {
            boolean a = this.f3962a.m4147a(this.f3963b);
            boolean e = this.f3962a.m4145a();
            Object obj2 = !c0235i.f331f.isEmpty() ? 1 : null;
            if (System.currentTimeMillis() <= c0235i.f329d) {
                obj = null;
            }
            if (!(!a || obj2 == null || r1 == null || !e || c0235i.f330e)) {
                c0235i.f330e = true;
                this.f3962a.m4144a(this.f3963b, AppLovinAdType.REGULAR, new C1176h(this.f3962a, c0235i, null));
            }
        }
    }
}
