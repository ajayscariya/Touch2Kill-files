package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.info.AppInfo;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.PublisherProvidedUserInfo;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.signals.LocationInfo;
import com.inmobi.signals.p006a.CellularInfoUtil;
import com.inmobi.signals.p007b.WifiInfoUtil;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.inmobi.ads.e */
public final class AdNetworkRequest extends NetworkRequest {
    private long f4389d;
    private String f4390e;
    private String f4391f;
    private int f4392g;
    private String f4393h;
    private String f4394i;
    private Map<String, String> f4395j;
    private Map<String, String> f4396k;

    public AdNetworkRequest(String str, long j, UidMap uidMap) {
        super(RequestType.POST, str, true, uidMap);
        this.f4390e = "json";
        this.f4392g = 1;
        this.f4389d = j;
        this.c.put("im-plid", String.valueOf(this.f4389d));
        this.c.putAll(PublisherProvidedUserInfo.m1806a());
        this.c.putAll(DisplayInfo.m1787c());
        this.c.put("u-appIS", AppInfo.m1791a().m1794b());
        this.c.putAll(LocationInfo.m2285a().m2298d());
        this.c.putAll(WifiInfoUtil.m2211b());
        this.c.putAll(WifiInfoUtil.m2214d());
        this.c.putAll(CellularInfoUtil.m2166c());
        this.c.putAll(CellularInfoUtil.m2167d());
    }

    public void m5042a() {
        super.m1703a();
        this.c.put("format", this.f4390e);
        this.c.put("mk-ads", String.valueOf(this.f4392g));
        this.c.put("adtype", this.f4393h);
        if (this.f4394i != null) {
            this.c.put("p-keywords", this.f4394i);
        }
        if (this.f4395j != null) {
            for (Entry entry : this.f4395j.entrySet()) {
                if (!this.c.containsKey(entry.getKey())) {
                    this.c.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.f4396k != null) {
            this.c.putAll(this.f4396k);
        }
    }

    public void m5044a(String str) {
        this.f4393h = str;
    }

    public String m5046b() {
        return this.f4393h;
    }

    public void m5047b(String str) {
        this.f4390e = str;
    }

    public String m5049c() {
        return this.f4391f;
    }

    public void m5050c(String str) {
        this.f4391f = str;
    }

    public void m5043a(int i) {
        this.f4392g = i;
    }

    public int m5051d() {
        return this.f4392g;
    }

    public long m5053e() {
        return this.f4389d;
    }

    public void m5052d(String str) {
        this.f4394i = str;
    }

    public void m5045a(Map<String, String> map) {
        this.f4395j = map;
    }

    public void m5048b(Map<String, String> map) {
        this.f4396k = map;
    }
}
