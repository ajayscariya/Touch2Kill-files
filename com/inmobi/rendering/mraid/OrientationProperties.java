package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.l */
public class OrientationProperties {
    private static String f2038c;
    public boolean f2039a;
    public String f2040b;

    static {
        f2038c = OrientationProperties.class.getSimpleName();
    }

    public OrientationProperties() {
        this.f2039a = true;
        this.f2040b = XMLConstants.NULL_NS_URI;
    }

    public static OrientationProperties m2136a(String str, OrientationProperties orientationProperties) {
        OrientationProperties orientationProperties2 = new OrientationProperties();
        try {
            JSONObject jSONObject = new JSONObject(str);
            orientationProperties2.f2040b = jSONObject.optString("forceOrientation", orientationProperties.f2040b);
            orientationProperties2.f2039a = jSONObject.optBoolean("allowOrientationChange", orientationProperties.f2039a);
            return orientationProperties2;
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2038c, "Invalid orientation properties string passed.", e);
            return null;
        }
    }
}
