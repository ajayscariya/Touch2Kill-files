package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.uid.UidMap;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.inmobi.signals.f */
public class CarbPostListNetworkRequest extends NetworkRequest {
    private int f4486d;
    private int f4487e;
    private CarbGetListNetworkResponse f4488f;
    private List<CarbInfo> f4489g;

    public CarbPostListNetworkRequest(String str, int i, int i2, UidMap uidMap, List<CarbInfo> list, CarbGetListNetworkResponse carbGetListNetworkResponse) {
        super(RequestType.POST, str, true, uidMap);
        this.f4486d = i;
        this.f4487e = i2;
        this.f4489g = list;
        this.f4488f = carbGetListNetworkResponse;
        this.c.put("req_id", this.f4488f.m2232c());
        this.c.put("i_till", Integer.toString(this.f4488f.m2233d()));
        this.c.put("p_a_apps", m5195d());
    }

    private String m5195d() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.f4489g.size(); i++) {
            jSONArray.put(((CarbInfo) this.f4489g.get(i)).m2236b());
        }
        return jSONArray.toString();
    }

    public int m5196b() {
        return this.f4486d;
    }

    public int m5197c() {
        return this.f4487e;
    }
}
