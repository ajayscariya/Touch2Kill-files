package com.inmobi.signals.activityrecognition;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.activityrecognition.a */
public class ActivityInfo {
    private static final String f2072a;
    private int f2073b;
    private long f2074c;

    static {
        f2072a = ActivityInfo.class.getSimpleName();
    }

    public ActivityInfo(int i, long j) {
        this.f2073b = i;
        this.f2074c = j;
    }

    public JSONObject m2185a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f2073b);
            jSONObject.put("ts", this.f2074c);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2072a, "Error while converting WifiInfo to string.", e);
        }
        return jSONObject;
    }
}
