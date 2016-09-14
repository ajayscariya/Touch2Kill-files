package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.d */
public class ExpandProperties {
    private static final String f1971c;
    public int f1972a;
    public int f1973b;
    private boolean f1974d;
    private boolean f1975e;
    private boolean f1976f;
    private String f1977g;

    static {
        f1971c = ExpandProperties.class.getSimpleName();
    }

    public ExpandProperties() {
        this.f1972a = DisplayInfo.m1785a().m1800b();
        this.f1973b = DisplayInfo.m1785a().m1799a();
        this.f1974d = false;
        this.f1976f = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", this.f1972a);
            jSONObject.put("height", this.f1973b);
            jSONObject.put("useCustomClose", this.f1974d);
            jSONObject.put("isModal", this.f1976f);
        } catch (JSONException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1971c, "Exception in composing ExpandProperties: " + e.getMessage());
        }
        this.f1977g = jSONObject.toString();
    }

    public boolean m2077a() {
        return this.f1974d;
    }

    public boolean m2078b() {
        return this.f1975e;
    }

    public static ExpandProperties m2076a(String str, ExpandProperties expandProperties, OrientationProperties orientationProperties) {
        ExpandProperties expandProperties2 = new ExpandProperties();
        expandProperties2.f1977g = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            expandProperties2.f1976f = true;
            if (jSONObject.has("useCustomClose")) {
                expandProperties2.f1975e = true;
            }
            expandProperties2.f1974d = jSONObject.optBoolean("useCustomClose", false);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1971c, "Invalid expand properties string passed.", e);
        }
        return expandProperties2;
    }

    public String m2079c() {
        return this.f1977g;
    }
}
