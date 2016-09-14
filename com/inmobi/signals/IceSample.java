package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.SessionInfo;
import com.inmobi.signals.activityrecognition.ActivityInfo;
import com.inmobi.signals.p006a.CellOperatorInfo;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.l */
public class IceSample {
    private static final String f2118a;
    private long f2119b;
    private CellOperatorInfo f2120c;
    private Map<String, Object> f2121d;
    private SessionInfo f2122e;
    private List<IceWifiSample> f2123f;
    private List<ActivityInfo> f2124g;

    static {
        f2118a = IceSample.class.getSimpleName();
    }

    public IceSample() {
        m2272a(Calendar.getInstance().getTimeInMillis());
    }

    public void m2272a(long j) {
        this.f2119b = j;
    }

    public void m2274a(CellOperatorInfo cellOperatorInfo) {
        this.f2120c = cellOperatorInfo;
    }

    public void m2276a(Map<String, Object> map) {
        this.f2121d = map;
    }

    public void m2273a(SessionInfo sessionInfo) {
        this.f2122e = sessionInfo;
    }

    public void m2275a(List<IceWifiSample> list) {
        this.f2123f = list;
    }

    public void m2277b(List<ActivityInfo> list) {
        this.f2124g = list;
    }

    public JSONObject m2271a() {
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", this.f2119b);
            if (this.f2120c != null) {
                if (this.f2120c.m2149a() != null) {
                    jSONObject.put("s-co", this.f2120c.m2149a());
                }
                if (this.f2120c.m2151b() != null) {
                    jSONObject.put("s-ho", this.f2120c.m2151b());
                }
            }
            if (!(this.f2121d == null || this.f2121d.isEmpty())) {
                jSONObject.put("l", new JSONObject(this.f2121d));
            }
            if (this.f2122e != null) {
                jSONObject.put("s", this.f2122e.m1834b());
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f2123f.size(); i2++) {
                jSONArray.put(((IceWifiSample) this.f2123f.get(i2)).m2282b());
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("w", jSONArray);
            }
            if (this.f2124g != null) {
                JSONArray jSONArray2 = new JSONArray();
                while (i < this.f2124g.size()) {
                    jSONArray2.put(((ActivityInfo) this.f2124g.get(i)).m2185a());
                    i++;
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("ar", jSONArray2);
                }
            }
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2118a, "Error while converting IceSample to string.", e);
        }
        return jSONObject;
    }
}
