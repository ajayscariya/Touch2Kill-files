package com.inmobi.commons.core.p001a;

import android.util.Log;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.a.b */
public class CrashEvent extends TelemetryEvent {
    private static final String f4406a;

    static {
        f4406a = CrashEvent.class.getSimpleName();
    }

    public CrashEvent(Thread thread, Throwable th) {
        super("crashReporting", "CrashEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", th.getClass().getSimpleName());
            jSONObject.put("message", th.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(th));
            jSONObject.put("thread", thread.getName());
            m1628a(jSONObject.toString());
        } catch (JSONException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4406a, "JSONException: " + e);
        }
    }
}
