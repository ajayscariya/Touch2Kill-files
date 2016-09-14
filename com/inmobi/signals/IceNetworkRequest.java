package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.uid.UidMap;

/* renamed from: com.inmobi.signals.k */
public class IceNetworkRequest extends NetworkRequest {
    private static final String f4492d;
    private int f4493e;
    private int f4494f;
    private IceSample f4495g;

    static {
        f4492d = IceNetworkRequest.class.getSimpleName();
    }

    public IceNetworkRequest(String str, int i, int i2, UidMap uidMap, IceSample iceSample) {
        super(RequestType.POST, str, true, uidMap);
        this.f4493e = i;
        this.f4494f = i2;
        this.f4495g = iceSample;
        String jSONObject = this.f4495g.m2271a().toString();
        this.c.put("payload", jSONObject);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4492d, "Ice payload being sent:" + jSONObject);
    }

    public int m5200b() {
        return this.f4493e;
    }

    public int m5201c() {
        return this.f4494f;
    }
}
