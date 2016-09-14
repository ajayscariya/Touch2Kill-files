package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.signals.p007b.WifiInfo;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.m */
public class IceWifiSample {
    private static final String f2125a;
    private long f2126b;
    private WifiInfo f2127c;
    private List<WifiInfo> f2128d;

    static {
        f2125a = IceWifiSample.class.getSimpleName();
    }

    public IceWifiSample() {
        m2278a(Calendar.getInstance().getTimeInMillis());
    }

    public void m2278a(long j) {
        this.f2126b = j;
    }

    public void m2279a(WifiInfo wifiInfo) {
        this.f2127c = wifiInfo;
    }

    public void m2280a(List<WifiInfo> list) {
        this.f2128d = list;
    }

    public boolean m2281a() {
        return (this.f2127c == null && this.f2128d == null) ? false : true;
    }

    public JSONObject m2282b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", this.f2126b);
            if (this.f2127c != null) {
                jSONObject.put("c-ap", this.f2127c.m2199b());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.f2128d != null) {
                for (int i = 0; i < this.f2128d.size(); i++) {
                    jSONArray.put(((WifiInfo) this.f2128d.get(i)).m2199b());
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("v-ap", jSONArray);
                }
            }
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2125a, "Error while converting IceWifiCellSample to string.", e);
        }
        return jSONObject;
    }
}
