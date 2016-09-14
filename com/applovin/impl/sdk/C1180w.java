package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.w */
class C1180w implements ck {
    final /* synthetic */ bt f3967a;
    final /* synthetic */ EventServiceImpl f3968b;

    C1180w(EventServiceImpl eventServiceImpl, bt btVar) {
        this.f3968b = eventServiceImpl;
        this.f3967a = btVar;
    }

    public void m4306a(C0243t c0243t) {
        try {
            this.f3968b.f3885a.getPersistentPostbackManager().m139a(this.f3968b.m4171a(this.f3967a, c0243t).toString(), this.f3967a.m152b());
        } catch (Throwable e) {
            this.f3968b.f3885a.getLogger().m308e("EventServiceImpl", "Unable to track event due to failure to convert event parameters into JSONObject for event: " + this.f3967a, e);
        }
    }
}
