package com.chartboost.sdk.Libraries;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.i */
public final class C0279i {
    private static final String f547a;

    static {
        f547a = C0279i.class.getSimpleName();
    }

    private C0279i() {
    }

    public static boolean m539a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length() && !C0279i.m541b(jSONArray.toString(), jSONArray2.toString())) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object opt = jSONArray.opt(i);
            Object opt2 = jSONArray2.opt(i);
            if (!C0279i.m538a(opt.getClass(), opt2.getClass()) && (!Number.class.isInstance(opt) || !Number.class.isInstance(opt2))) {
                return false;
            }
            if (opt instanceof JSONObject) {
                if (!C0279i.m540a((JSONObject) opt, (JSONObject) opt2)) {
                    return false;
                }
            } else if (opt instanceof JSONArray) {
                if (!C0279i.m539a((JSONArray) opt, (JSONArray) opt2)) {
                    return false;
                }
            } else if (!C0279i.m541b(opt, opt2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m538a(Object obj, Object obj2) {
        return obj == obj2;
    }

    public static boolean m540a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject.length() != jSONObject2.length()) {
            try {
                if (!C0279i.m541b(jSONObject.toString(2), jSONObject2.toString(2))) {
                    return false;
                }
            } catch (JSONException e) {
                return false;
            }
        }
        JSONArray names = jSONObject.names();
        if (names == null && jSONObject2.names() == null) {
            return true;
        }
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i);
            Object opt = jSONObject.opt(optString);
            Object opt2 = jSONObject2.opt(optString);
            if (C0279i.m537a(opt) && !C0279i.m537a(opt2)) {
                return false;
            }
            if (!C0279i.m538a(opt.getClass(), opt2.getClass()) && (!Number.class.isInstance(opt) || !Number.class.isInstance(opt2))) {
                return false;
            }
            if (opt instanceof JSONObject) {
                if (!C0279i.m540a((JSONObject) opt, (JSONObject) opt2)) {
                    return false;
                }
            } else if (opt instanceof JSONArray) {
                if (!C0279i.m539a((JSONArray) opt, (JSONArray) opt2)) {
                    return false;
                }
            } else if (!C0279i.m541b(opt, opt2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m537a(Object obj) {
        return (obj == null || obj == JSONObject.NULL) ? false : true;
    }

    private static BigDecimal m536a(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger) number);
        }
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return new BigDecimal(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return new BigDecimal(number.doubleValue());
        }
        try {
            return new BigDecimal(number.toString());
        } catch (Throwable e) {
            CBLogging.m382b(f547a, "The given number (\"" + number + "\" of class " + number.getClass().getName() + ") does not have a parsable string representation", e);
            return null;
        }
    }

    public static boolean m541b(Object obj, Object obj2) {
        if (obj == null || obj == JSONObject.NULL) {
            boolean z = obj2 == null || obj2 == JSONObject.NULL;
            return z;
        }
        if (Number.class.isInstance(obj) && Number.class.isInstance(obj2)) {
            try {
                if (C0279i.m536a((Number) obj).compareTo(C0279i.m536a((Number) obj2)) != 0) {
                    return false;
                }
                return true;
            } catch (RuntimeException e) {
                CBLogging.m381b(f547a, "Error comparing big decimal values");
            }
        }
        return obj.equals(obj2);
    }
}
