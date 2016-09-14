package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.ads.AdNetworkClient.AdNetworkClient;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.g */
final class AdStore implements AdNetworkClient {
    private static final String f4397a;
    private AdStoreRequest f4398b;
    private AdStore f4399c;
    private AdDao f4400d;
    private boolean f4401e;
    private long f4402f;

    /* renamed from: com.inmobi.ads.g.a */
    public interface AdStore {
        void m1507a(InMobiAdRequestStatus inMobiAdRequestStatus);

        void m1508a(Ad ad);
    }

    static {
        f4397a = AdStore.class.getSimpleName();
    }

    public AdStore(AdStoreRequest adStoreRequest, AdStore adStore) {
        this.f4401e = false;
        this.f4402f = 0;
        this.f4398b = adStoreRequest;
        this.f4399c = adStore;
        this.f4400d = AdDao.m1495a();
    }

    public void m5057a() {
        this.f4401e = false;
        this.f4400d.m1497a(this.f4398b.m1527h(), this.f4398b.m1525f().m1448e());
        int a = this.f4400d.m1496a(this.f4398b.m1519c(), this.f4398b.m1530k());
        if (a == 0) {
            m5055a(this.f4398b);
        } else if (a <= this.f4398b.m1525f().m1447d()) {
            m5054a(this.f4398b.m1519c(), this.f4398b.m1530k());
            m5055a(this.f4398b);
        } else {
            m5054a(this.f4398b.m1519c(), this.f4398b.m1530k());
        }
    }

    private void m5054a(long j, String str) {
        this.f4401e = true;
        this.f4399c.m1508a(this.f4400d.m1499b(j, str));
    }

    private void m5055a(AdStoreRequest adStoreRequest) {
        AdNetworkRequest adNetworkRequest = new AdNetworkRequest(adStoreRequest.m1509a(), adStoreRequest.m1519c(), adStoreRequest.m1526g());
        adNetworkRequest.m5052d(adStoreRequest.m1521d());
        adNetworkRequest.m5045a(adStoreRequest.m1523e());
        adNetworkRequest.m5044a(adStoreRequest.m1527h());
        adNetworkRequest.m5047b(adStoreRequest.m1528i());
        adNetworkRequest.m5043a(adStoreRequest.m1525f().m1446c());
        adNetworkRequest.m5048b(adStoreRequest.m1529j());
        adNetworkRequest.m5047b(adStoreRequest.m1528i());
        adNetworkRequest.m5050c(adStoreRequest.m1530k());
        adNetworkRequest.m1706b(adStoreRequest.m1516b() * 1000);
        adNetworkRequest.m1708c(adStoreRequest.m1516b() * 1000);
        this.f4402f = SystemClock.elapsedRealtime();
        new AdNetworkClient(adNetworkRequest, this).m5039a();
    }

    public void m5058a(AdNetworkResponse adNetworkResponse) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        List c = m5056c(adNetworkResponse);
        if (c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4397a, "Could not parse ad response:" + adNetworkResponse.m1505c());
            if (!this.f4401e) {
                this.f4399c.m1507a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            }
        } else if (c.size() == 0) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4397a, "Ad response received but no ad available:" + adNetworkResponse.m1505c());
            Map hashMap = new HashMap();
            hashMap.put("type", this.f4398b.m1527h());
            hashMap.put("loadLatency", Long.valueOf(elapsedRealtime - this.f4402f));
            TelemetryComponent.m5070a().m5092a("ads", "ServerNoFill", hashMap);
            if (!this.f4401e) {
                this.f4399c.m1507a(new InMobiAdRequestStatus(StatusCode.NO_FILL));
            }
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("type", this.f4398b.m1527h());
            hashMap2.put("count", Integer.valueOf(c.size()));
            hashMap2.put("loadLatency", Long.valueOf(elapsedRealtime - this.f4402f));
            TelemetryComponent.m5070a().m5092a("ads", "ServerFill", hashMap2);
            if (!this.f4401e) {
                this.f4399c.m1508a((Ad) c.get(0));
                c.remove(0);
            }
            this.f4400d.m1498a(c, this.f4398b.m1525f().m1445b(), this.f4398b.m1527h());
        }
    }

    private List<Ad> m5056c(AdNetworkResponse adNetworkResponse) {
        List<Ad> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(adNetworkResponse.m1505c());
            String trim = jSONObject.getString("requestId").trim();
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            if (jSONArray == null) {
                return arrayList;
            }
            int min = Math.min(adNetworkResponse.m1504b().m5051d(), jSONArray.length());
            for (int i = 0; i < min; i++) {
                arrayList.add(new Ad(adNetworkResponse, jSONArray.getJSONObject(i).toString(), trim + "_" + i));
            }
            return arrayList;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4397a, "Error while parsing ad response.", e);
            Map hashMap = new HashMap();
            hashMap.put("type", this.f4398b.m1527h());
            hashMap.put("errorCode", "ParsingError");
            hashMap.put("reason", e.getLocalizedMessage());
            TelemetryComponent.m5070a().m5092a("ads", "ServerError", hashMap);
            return null;
        }
    }

    public void m5059b(AdNetworkResponse adNetworkResponse) {
        if (!this.f4401e) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map hashMap = new HashMap();
            hashMap.put("type", this.f4398b.m1527h());
            hashMap.put("errorCode", String.valueOf(adNetworkResponse.m1506d().m1699a().getValue()));
            hashMap.put("reason", adNetworkResponse.m1506d().m1700b());
            hashMap.put("loadLatency", Long.valueOf(elapsedRealtime - this.f4402f));
            TelemetryComponent.m5070a().m5092a("ads", "ServerError", hashMap);
            this.f4399c.m1507a(adNetworkResponse.m1503a());
        }
    }
}
