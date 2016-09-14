package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.m */
public class ResizeProperties {
    private static final String f2041g;
    String f2042a;
    int f2043b;
    int f2044c;
    int f2045d;
    int f2046e;
    boolean f2047f;

    static {
        f2041g = ResizeProperties.class.getSimpleName();
    }

    public ResizeProperties() {
        this.f2045d = 0;
        this.f2046e = 0;
        this.f2042a = "top-right";
        this.f2047f = true;
    }

    public static ResizeProperties m2137a(String str, ResizeProperties resizeProperties) {
        ResizeProperties resizeProperties2 = new ResizeProperties();
        try {
            JSONObject jSONObject = new JSONObject(str);
            resizeProperties2.f2043b = jSONObject.getInt("width");
            resizeProperties2.f2044c = jSONObject.getInt("height");
            resizeProperties2.f2045d = jSONObject.getInt("offsetX");
            resizeProperties2.f2046e = jSONObject.getInt("offsetY");
            if (resizeProperties == null) {
                return resizeProperties2;
            }
            resizeProperties2.f2042a = jSONObject.optString("customClosePosition", resizeProperties.f2042a);
            resizeProperties2.f2047f = jSONObject.optBoolean("allowOffscreen", resizeProperties.f2047f);
            return resizeProperties2;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2041g, "Invalid resize properties string passed.", e);
            return null;
        }
    }

    public String m2138a() {
        String str = XMLConstants.NULL_NS_URI;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.f2043b);
            jSONObject.put("height", this.f2044c);
            jSONObject.put("customClosePosition", this.f2042a);
            jSONObject.put("offsetX", this.f2045d);
            jSONObject.put("offsetY", this.f2046e);
            jSONObject.put("allowOffscreen", this.f2047f);
            str = jSONObject.toString();
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2041g, "Invalid resize properties string passed.", e);
        }
        return str;
    }
}
