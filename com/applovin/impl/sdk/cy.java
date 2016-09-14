package com.applovin.impl.sdk;

import org.json.JSONObject;

abstract class cy extends bw implements C0239p {
    private int f3944a;
    private long f3945b;
    private final C0239p f3946c;
    private bz f3947d;

    cy(String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
        this.f3945b = -1;
        this.f3947d = null;
        this.f3944a = i;
        this.f3946c = new cz(this, appLovinSdkImpl, str);
    }

    cy(String str, bz bzVar, AppLovinSdkImpl appLovinSdkImpl) {
        this(str, ((Integer) appLovinSdkImpl.m4161a(bzVar)).intValue(), appLovinSdkImpl);
    }

    private void m4265c() {
        if (this.f3947d != null) {
            ca settingsManager = this.f.getSettingsManager();
            settingsManager.m170a(this.f3947d, this.f3947d.m162c());
            settingsManager.m173b();
        }
    }

    public void m4267a(int i) {
    }

    public void m4268a(long j) {
        this.f3945b = j;
    }

    public void m4269a(bz bzVar) {
        this.f3947d = bzVar;
    }

    protected abstract void m4270a(C0238o c0238o, C0239p c0239p);

    public void m4271a(JSONObject jSONObject, int i) {
    }

    public void run() {
        m4270a(this.f.getConnectionManager(), this.f3946c);
    }
}
