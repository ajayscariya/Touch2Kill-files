package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.c */
public class CarbGetListNetworkResponse {
    private static final String f2095a;
    private NetworkResponse f2096b;
    private boolean f2097c;
    private List<CarbInfo> f2098d;
    private String f2099e;
    private int f2100f;

    static {
        f2095a = CarbGetListNetworkResponse.class.getSimpleName();
    }

    public CarbGetListNetworkResponse(NetworkResponse networkResponse) {
        this.f2097c = true;
        this.f2100f = 0;
        this.f2096b = networkResponse;
        this.f2098d = new ArrayList();
        m2229f();
        if (this.f2097c) {
            TelemetryComponent.m5070a().m5090a(new TelemetryEvent("signals", "InvalidCarbGetResponse"));
        }
    }

    private void m2229f() {
        if (this.f2096b.m1737a()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2095a, "Error response for Carb list received. Error code:" + this.f2096b.m1739c().m1699a());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f2096b.m1738b());
            if (jSONObject.getBoolean("success")) {
                jSONObject = jSONObject.getJSONObject("data");
                this.f2099e = jSONObject.getString("req_id");
                JSONArray jSONArray = jSONObject.getJSONArray("p_apps");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("bid", null);
                    String optString2 = jSONObject2.optString("inm_id", null);
                    if (!(optString == null || optString2 == null || optString2.trim().length() <= 0)) {
                        this.f2098d.add(new CarbInfo(optString, optString2));
                    }
                    this.f2100f = i + 1;
                }
            } else {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2095a, "Error response for Carb list received. Error code:" + jSONObject.optInt("errorCode"));
            }
            this.f2097c = false;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2095a, "Bad response for Carb list received.", e);
        }
    }

    public boolean m2230a() {
        return this.f2097c;
    }

    public List<CarbInfo> m2231b() {
        return this.f2098d;
    }

    public String m2232c() {
        return this.f2099e;
    }

    public int m2233d() {
        return this.f2100f;
    }

    public boolean m2234e() {
        return this.f2100f == 0;
    }
}
