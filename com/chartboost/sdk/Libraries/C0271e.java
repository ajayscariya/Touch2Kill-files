package com.chartboost.sdk.Libraries;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.e */
public class C0271e {
    private static Map<Integer, C0269a> f478a;
    private static Runnable f479b;

    /* renamed from: com.chartboost.sdk.Libraries.e.1 */
    static class C02681 implements Runnable {
        C02681() {
        }

        public void run() {
            C0271e.f478a.clear();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.e.a */
    public static class C0269a {
        public static C0269a f470a;
        private static JSONObject f471c;
        private static Map<String, Object> f472d;
        private static JSONArray f473e;
        private static List<?> f474f;
        private Object f475b;

        static {
            f470a = new C0269a(null);
            f471c = null;
            f472d = null;
            f473e = null;
            f474f = null;
        }

        private C0269a(Object obj) {
            this.f475b = obj;
        }

        public static C0269a m425a() {
            return C0269a.m426a(new JSONObject());
        }

        public C0269a m431a(String str) {
            if (this.f475b instanceof JSONObject) {
                return C0269a.m426a(((JSONObject) this.f475b).opt(str));
            }
            if (this.f475b instanceof Map) {
                return C0269a.m426a(((Map) this.f475b).get(str));
            }
            return f470a;
        }

        public boolean m435b() {
            return this.f475b == null || this.f475b == JSONObject.NULL;
        }

        public boolean m438c() {
            return !m435b();
        }

        public boolean m441d() {
            return !TextUtils.isEmpty(m449h());
        }

        public boolean m436b(String str) {
            return m431a(str).m435b();
        }

        public boolean m439c(String str) {
            return m431a(str).m438c();
        }

        public JSONObject m443e() {
            if (this.f475b instanceof JSONObject) {
                return (JSONObject) this.f475b;
            }
            if (!(this.f475b instanceof Map)) {
                return null;
            }
            if (f471c == null) {
                f471c = C0271e.m467a((Map) this.f475b);
            }
            return f471c;
        }

        public Map<String, Object> m445f() {
            if (this.f475b instanceof JSONObject) {
                if (f472d == null) {
                    f472d = C0271e.m465a((JSONObject) this.f475b);
                }
                return f472d;
            } else if (this.f475b instanceof Map) {
                return (Map) this.f475b;
            } else {
                return null;
            }
        }

        public JSONArray m447g() {
            if (this.f475b instanceof JSONArray) {
                return (JSONArray) this.f475b;
            }
            if (!(this.f475b instanceof List)) {
                return null;
            }
            if (f473e == null) {
                f473e = C0271e.m466a((List) this.f475b);
            }
            return f473e;
        }

        public String m449h() {
            if (m435b()) {
                return null;
            }
            return this.f475b instanceof String ? (String) this.f475b : this.f475b.toString();
        }

        public String m440d(String str) {
            return this.f475b instanceof String ? (String) this.f475b : str;
        }

        public double m450i() {
            return m428a(0.0d);
        }

        public double m428a(double d) {
            if (!(this.f475b instanceof String)) {
                return this.f475b instanceof Number ? ((Number) this.f475b).doubleValue() : d;
            } else {
                try {
                    return Double.parseDouble((String) this.f475b);
                } catch (NumberFormatException e) {
                    return d;
                }
            }
        }

        public float m452j() {
            return m429a(0.0f);
        }

        public float m429a(float f) {
            if (!(this.f475b instanceof String)) {
                return this.f475b instanceof Number ? ((Number) this.f475b).floatValue() : f;
            } else {
                try {
                    return Float.parseFloat((String) this.f475b);
                } catch (NumberFormatException e) {
                    return f;
                }
            }
        }

        public int m454k() {
            return m430a(0);
        }

        public int m430a(int i) {
            if (!(this.f475b instanceof String)) {
                return this.f475b instanceof Number ? ((Number) this.f475b).intValue() : i;
            } else {
                try {
                    return Integer.parseInt((String) this.f475b);
                } catch (NumberFormatException e) {
                    return i;
                }
            }
        }

        public long m455l() {
            return m434b(0);
        }

        public long m434b(int i) {
            if (!(this.f475b instanceof String)) {
                return this.f475b instanceof Number ? ((Number) this.f475b).longValue() : (long) i;
            } else {
                try {
                    return Long.parseLong((String) this.f475b);
                } catch (NumberFormatException e) {
                    return (long) i;
                }
            }
        }

        public boolean m456m() {
            return m433a(false);
        }

        public boolean m433a(boolean z) {
            return this.f475b instanceof Boolean ? ((Boolean) this.f475b).booleanValue() : z;
        }

        public boolean equals(Object other) {
            C0269a a = C0269a.m426a(other);
            if (m435b()) {
                return a.m435b();
            }
            if (m443e() != null && a.m443e() != null) {
                return C0279i.m540a(m443e(), a.m443e());
            }
            if (m447g() != null && a.m447g() != null) {
                return C0279i.m539a(m447g(), a.m447g());
            }
            if (this.f475b instanceof String) {
                return this.f475b.equals(a.m449h());
            }
            if (a.f475b instanceof String) {
                return a.f475b.equals(m449h());
            }
            return m457n().equals(a.m457n());
        }

        public Object m457n() {
            return this.f475b;
        }

        public static C0269a m426a(Object obj) {
            if (obj instanceof C0269a) {
                return (C0269a) obj;
            }
            if (obj == null || obj == JSONObject.NULL) {
                return f470a;
            }
            C0269a c0269a = (C0269a) C0271e.f478a.get(Integer.valueOf(obj.hashCode()));
            if (c0269a != null) {
                return c0269a;
            }
            CBUtility.m400e().removeCallbacks(C0271e.f479b);
            CBUtility.m400e().postDelayed(C0271e.f479b, 1000);
            c0269a = new C0269a(obj);
            C0271e.f478a.put(Integer.valueOf(obj.hashCode()), c0269a);
            return c0269a;
        }

        public int m458o() {
            if (this.f475b instanceof JSONArray) {
                return ((JSONArray) this.f475b).length();
            }
            if (this.f475b instanceof List) {
                return ((List) this.f475b).size();
            }
            return 1;
        }

        public C0269a m437c(int i) {
            if (this.f475b instanceof JSONArray) {
                return C0269a.m426a(((JSONArray) this.f475b).opt(i));
            }
            if (!(this.f475b instanceof List)) {
                return i != 0 ? f470a : this;
            } else {
                try {
                    return C0269a.m426a(((List) this.f475b).get(i));
                } catch (IndexOutOfBoundsException e) {
                    return f470a;
                }
            }
        }

        public String m442e(String str) {
            return m431a(str).m449h();
        }

        public int m444f(String str) {
            return m431a(str).m454k();
        }

        public float m446g(String str) {
            return m431a(str).m452j();
        }

        public double m448h(String str) {
            return m431a(str).m450i();
        }

        public long m451i(String str) {
            return m431a(str).m455l();
        }

        public boolean m453j(String str) {
            return m431a(str).m456m();
        }

        public void m432a(String str, Object obj) {
            f471c = null;
            f473e = null;
            f472d = null;
            f474f = null;
            if (obj instanceof C0269a) {
                obj = ((C0269a) obj).m457n();
            }
            if (this.f475b instanceof JSONObject) {
                try {
                    ((JSONObject) this.f475b).put(str, obj);
                } catch (Throwable e) {
                    CBLogging.m382b(this, "Error updating balances dictionary.", e);
                }
            } else if (this.f475b instanceof Map) {
                try {
                    ((Map) this.f475b).put(str, obj);
                } catch (Throwable e2) {
                    CBLogging.m382b(this, "Error updating balances dictionary.", e2);
                }
            }
        }

        public static C0269a m427k(String str) {
            if (str == null) {
                CBLogging.m385d("CBJSON", "null passed when creating new JSON object");
                return f470a;
            }
            if (str != null) {
                try {
                    if (str.trim().startsWith("[")) {
                        return C0269a.m426a(new JSONArray(str));
                    }
                } catch (Throwable e) {
                    CBLogging.m382b("CBJSON", "error creating new json object", e);
                    return f470a;
                }
            }
            return C0269a.m426a(new JSONObject(str));
        }

        public String toString() {
            if (m443e() != null) {
                return m443e().toString();
            }
            if (m447g() != null) {
                return m447g().toString();
            }
            if (this.f475b != null) {
                return this.f475b.toString();
            }
            return "null";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.e.b */
    public static class C0270b {
        private String f476a;
        private Object f477b;

        public C0270b(String str, Object obj) {
            this.f476a = str;
            if (obj instanceof C0269a) {
                this.f477b = ((C0269a) obj).m457n();
            } else {
                this.f477b = obj;
            }
        }
    }

    static {
        f478a = Collections.synchronizedMap(new HashMap());
        f479b = new C02681();
    }

    public static C0269a m461a(C0270b... c0270bArr) {
        C0269a a = C0269a.m425a();
        for (int i = 0; i < c0270bArr.length; i++) {
            a.m432a(c0270bArr[i].f476a, c0270bArr[i].f477b);
        }
        return a;
    }

    public static C0270b m462a(String str, Object obj) {
        return new C0270b(str, obj);
    }

    public static List<?> m463a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        List<?> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    obj = C0271e.m465a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = C0271e.m463a((JSONArray) obj);
                } else if (obj.equals(JSONObject.NULL)) {
                    obj = null;
                }
                arrayList.add(obj);
            } catch (Throwable e) {
                CBLogging.m382b("CBJSON", "error converting json", e);
            }
        }
        return arrayList;
    }

    public static Map<String, Object> m465a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                if (obj instanceof JSONObject) {
                    obj = C0271e.m465a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    obj = C0271e.m463a((JSONArray) obj);
                } else if (obj.equals(JSONObject.NULL)) {
                    obj = null;
                }
                hashMap.put(str, obj);
            } catch (Throwable e) {
                CBLogging.m382b("CBJSON", "error converting json", e);
            }
        }
        return hashMap;
    }

    public static JSONArray m466a(List<?> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                Object obj = list.get(i);
                if (obj instanceof Map) {
                    obj = C0271e.m467a((Map) obj);
                } else if (obj instanceof List) {
                    obj = C0271e.m466a((List) obj);
                } else if (obj == null) {
                    obj = JSONObject.NULL;
                }
                jSONArray.put(obj);
            } catch (Throwable e) {
                CBLogging.m382b("CBJSON", "error converting json", e);
            }
        }
        return jSONArray;
    }

    public static JSONObject m467a(Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            String obj = entry.getKey().toString();
            Object value = entry.getValue();
            try {
                if (value instanceof Map) {
                    value = C0271e.m467a((Map) value);
                } else if (value instanceof List) {
                    value = C0271e.m466a((List) value);
                } else if (value == null) {
                    value = JSONObject.NULL;
                }
                jSONObject.put(obj, value);
            } catch (Throwable e) {
                CBLogging.m382b("CBJSON", "error converting json", e);
            }
        }
        return jSONObject;
    }
}
