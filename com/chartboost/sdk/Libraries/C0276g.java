package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Libraries.C0271e.C0269a;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.g */
public final class C0276g {
    private static final String f492a;
    private static C1516p f493b;
    private static C1197n f494c;
    private static C1195j f495d;
    private static C1189d f496e;
    private static C1196l f497f;

    /* renamed from: com.chartboost.sdk.Libraries.g.a */
    public static abstract class C0274a {
        private String f489a;

        public abstract String m471a();

        public abstract boolean m472a(Object obj);

        public C0274a() {
            this.f489a = null;
        }

        public boolean m473a(Object obj, StringBuilder stringBuilder) {
            if (obj instanceof C0269a) {
                obj = ((C0269a) obj).m457n();
            }
            boolean a = m472a(obj);
            if (!a) {
                stringBuilder.append(this.f489a != null ? this.f489a : m471a());
            }
            return a;
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.k */
    public static class C0275k {
        private String f490a;
        private C0274a f491b;

        public C0275k(String str, C0274a c0274a) {
            this.f490a = str;
            this.f491b = c0274a;
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.b */
    private static class C1188b extends C0274a {
        private C1188b() {
        }

        public boolean m4317a(Object obj) {
            return (obj instanceof List) || (obj instanceof JSONArray);
        }

        public String m4316a() {
            return "object must be an array.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.d */
    private static class C1189d extends C0274a {
        private C1189d() {
        }

        public boolean m4319a(Object obj) {
            return Boolean.class.isInstance(obj) || Boolean.TYPE.isInstance(obj);
        }

        public String m4318a() {
            return "object must be a boolean.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.e */
    public static abstract class C1190e extends C0274a {
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.f */
    private static class C1191f extends C0274a {
        protected C0275k[] f3981a;
        protected String f3982b;

        public C1191f(C0275k[] c0275kArr) {
            this.f3982b = null;
            this.f3981a = c0275kArr;
        }

        public boolean m4321a(Object obj) {
            int i;
            String a;
            C0274a b;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                for (Entry entry : map.entrySet()) {
                    if (!(entry.getKey() instanceof String)) {
                        this.f3982b = "key '" + entry.getKey().toString() + "' is not a string";
                        return false;
                    }
                }
                if (this.f3981a != null && this.f3981a.length >= 1) {
                    for (i = 0; i < this.f3981a.length; i++) {
                        a = this.f3981a[i].f490a;
                        b = this.f3981a[i].f491b;
                        if (map.containsKey(a)) {
                            if (!b.m472a(map.get(a))) {
                                this.f3982b = "key '" + a + "' fails to match: <" + b.m471a() + ">";
                                return false;
                            }
                        } else if (!b.m472a(null)) {
                            this.f3982b = "no key for required mapping '" + a + "' : <" + b.m471a() + ">";
                            return false;
                        }
                    }
                }
                return true;
            } else if (!(obj instanceof JSONObject)) {
                return false;
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                if (this.f3981a != null && this.f3981a.length >= 1) {
                    i = 0;
                    while (i < this.f3981a.length) {
                        a = this.f3981a[i].f490a;
                        b = this.f3981a[i].f491b;
                        try {
                            if (b.m472a(jSONObject.get(a))) {
                                i++;
                            } else {
                                this.f3982b = "key '" + a + "' fails to match: <" + b.m471a() + ">";
                                return false;
                            }
                        } catch (JSONException e) {
                            if (!b.m472a(null)) {
                                this.f3982b = "no key for required mapping '" + a + "' : <" + b.m471a() + ">";
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }

        public String m4320a() {
            if (this.f3982b != null) {
                return this.f3982b;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must contain the following key-value schema: {\n");
            for (int i = 0; i < this.f3981a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f3981a[i].f490a);
                stringBuilder.append(": [");
                stringBuilder.append(this.f3981a[i].f491b.m471a());
                stringBuilder.append("]>");
                if (i < this.f3981a.length - 1) {
                    stringBuilder.append(",\n");
                }
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.g */
    private static class C1192g extends C0274a {
        private Set<String> f3983a;
        private C1191f f3984b;
        private String f3985c;

        public C1192g(C1191f c1191f) {
            this.f3985c = null;
            this.f3984b = c1191f;
            this.f3983a = new HashSet();
            for (C0275k a : this.f3984b.f3981a) {
                this.f3983a.add(a.f490a);
            }
        }

        public boolean m4323a(Object obj) {
            if (!this.f3984b.m4321a(obj)) {
                this.f3985c = this.f3984b.f3982b;
                return false;
            } else if (obj instanceof Map) {
                for (Object next : ((Map) obj).keySet()) {
                    if (!this.f3983a.contains(next)) {
                        this.f3985c = "key '" + next + "' is not allowed in this dictionary";
                        return false;
                    }
                }
                return true;
            } else if (obj instanceof JSONObject) {
                Iterator keys = ((JSONObject) obj).keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (!this.f3983a.contains(str)) {
                        this.f3985c = "key '" + str + "' is not allowed in this dictionary";
                        return false;
                    }
                }
                return true;
            } else {
                this.f3985c = "object must be a dictionary";
                return false;
            }
        }

        public String m4322a() {
            if (this.f3985c != null) {
                return this.f3985c;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must EXACTLY MATCH the following key-value schema: {\n");
            for (int i = 0; i < this.f3984b.f3981a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f3984b.f3981a[i].f490a);
                stringBuilder.append(": [");
                stringBuilder.append(this.f3984b.f3981a[i].f491b.m471a());
                stringBuilder.append("]>");
                if (i < this.f3984b.f3981a.length - 1) {
                    stringBuilder.append(",\n");
                }
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.h */
    private static class C1193h extends C0274a {
        private Object[] f3986a;

        public C1193h(Object[] objArr) {
            this.f3986a = objArr;
        }

        public boolean m4325a(Object obj) {
            for (Object obj2 : this.f3986a) {
                if (obj == null) {
                    if (obj2 == null) {
                        return true;
                    }
                } else if (obj.equals(obj2)) {
                    return true;
                }
            }
            return false;
        }

        public String m4324a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must equal one of the following: ");
            for (int i = 0; i < this.f3986a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f3986a[i].toString());
                stringBuilder.append(">");
                if (i < this.f3986a.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.i */
    private static class C1194i extends C0274a {
        private Class<?> f3987a;

        public C1194i(Class<?> cls) {
            this.f3987a = cls;
        }

        public boolean m4327a(Object obj) {
            return this.f3987a.isInstance(obj);
        }

        public String m4326a() {
            return "object must be an instance of " + this.f3987a.getName() + ".";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.j */
    private static class C1195j extends C0274a {
        private C1195j() {
        }

        public boolean m4329a(Object obj) {
            return Integer.class.isInstance(obj) || Long.class.isInstance(obj) || Short.class.isInstance(obj) || Byte.class.isInstance(obj) || BigInteger.class.isInstance(obj) || Integer.TYPE.isInstance(obj) || Long.TYPE.isInstance(obj) || Short.TYPE.isInstance(obj) || Byte.TYPE.isInstance(obj);
        }

        public String m4328a() {
            return "object must be a number w/o decimals (int, long, short, or byte).";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.l */
    private static class C1196l extends C0274a {
        private C1196l() {
        }

        public boolean m4331a(Object obj) {
            return obj == null || obj == JSONObject.NULL;
        }

        public String m4330a() {
            return "object must be null.";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.n */
    private static class C1197n extends C0274a {
        private C1197n() {
        }

        public boolean m4333a(Object obj) {
            return (obj instanceof Number) || Integer.TYPE.isInstance(obj) || Long.TYPE.isInstance(obj) || Short.TYPE.isInstance(obj) || Float.TYPE.isInstance(obj) || Double.TYPE.isInstance(obj) || Byte.TYPE.isInstance(obj);
        }

        public String m4332a() {
            return "object must be a number (primitive type or derived from Number).";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.o */
    private static class C1198o extends C0274a {
        private C0274a[] f3988a;

        public C1198o(C0274a[] c0274aArr) {
            this.f3988a = c0274aArr;
        }

        public boolean m4335a(Object obj) {
            for (C0274a a : this.f3988a) {
                if (a.m472a(obj)) {
                    return true;
                }
            }
            return false;
        }

        public String m4334a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must match one of the following: ");
            for (int i = 0; i < this.f3988a.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f3988a[i].m471a());
                stringBuilder.append(">");
                if (i < this.f3988a.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.q */
    private static class C1199q extends C0274a {
        protected String f3989a;
        private C0274a[] f3990b;

        public C1199q(C0274a[] c0274aArr) {
            this.f3989a = null;
            this.f3990b = c0274aArr;
        }

        public boolean m4337a(Object obj) {
            int i = 0;
            while (i < this.f3990b.length) {
                if (this.f3990b[i].m472a(obj)) {
                    i++;
                } else {
                    this.f3989a = "object failed to match: <" + this.f3990b[i].m471a() + ">";
                    return false;
                }
            }
            return true;
        }

        public String m4336a() {
            if (this.f3989a != null) {
                return this.f3989a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("object must match ALL of the following: ");
            for (int i = 0; i < this.f3990b.length; i++) {
                stringBuilder.append("<");
                stringBuilder.append(this.f3990b[i].m471a());
                stringBuilder.append(">");
                if (i < this.f3990b.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.c */
    private static class C1514c extends C1188b {
        private C0274a f4831a;

        public C1514c(C0274a c0274a) {
            super();
            this.f4831a = c0274a;
        }

        public boolean m5692a(Object obj) {
            int i;
            if (obj instanceof List) {
                List list = (List) obj;
                for (i = 0; i < list.size(); i++) {
                    if (!this.f4831a.m472a(list.get(i))) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof JSONArray)) {
                return false;
            } else {
                JSONArray jSONArray = (JSONArray) obj;
                for (i = 0; i < jSONArray.length(); i++) {
                    if (!this.f4831a.m472a(jSONArray.opt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }

        public String m5691a() {
            return "object must be an array of objects matching: <" + this.f4831a.m471a() + ">";
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.m */
    private static class C1515m extends C1196l {
        private C0274a f4832a;

        public C1515m(C0274a c0274a) {
            super();
            this.f4832a = c0274a;
        }

        public boolean m5694a(Object obj) {
            if (super.m4331a(obj)) {
                return true;
            }
            return this.f4832a.m472a(obj);
        }

        public String m5693a() {
            return "object must be either null or " + this.f4832a.m471a();
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.g.p */
    private static class C1516p extends C1194i {
        public C1516p() {
            super(String.class);
        }
    }

    static {
        f492a = C0276g.class.getSimpleName();
        f493b = new C1516p();
        f494c = new C1197n();
        f495d = new C1195j();
        f496e = new C1189d();
        f497f = new C1196l();
    }

    private C0276g() {
    }

    public static C0274a m478a(Class<?> cls) {
        return new C1194i(cls);
    }

    public static C0274a m476a() {
        return f493b;
    }

    public static C0274a m483b() {
        return f494c;
    }

    public static C0274a m487c() {
        return f496e;
    }

    public static C0274a m477a(C0274a c0274a) {
        return new C1515m(c0274a);
    }

    public static C0274a m484b(C0274a c0274a) {
        return new C1514c(c0274a);
    }

    public static C0274a m479a(C0274a... c0274aArr) {
        return new C1198o(c0274aArr);
    }

    public static C0274a m485b(C0274a... c0274aArr) {
        return new C1199q(c0274aArr);
    }

    public static C0274a m481a(Object... objArr) {
        return new C1193h(objArr);
    }

    public static C0275k m482a(String str, C0274a c0274a) {
        return new C0275k(str, c0274a);
    }

    public static C0274a m480a(C0275k... c0275kArr) {
        return new C1191f(c0275kArr);
    }

    public static C0274a m486b(C0275k... c0275kArr) {
        return new C1192g(new C1191f(c0275kArr));
    }

    public static boolean m488c(C0274a c0274a) {
        return (c0274a instanceof C1191f) || (c0274a instanceof C1192g) || (c0274a instanceof C1198o);
    }
}
