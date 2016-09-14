package com.chartboost.sdk.Tracking;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0263b;
import com.chartboost.sdk.Libraries.C0266c;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.ba;
import java.lang.reflect.Method;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Tracking.a */
public class C1203a implements C0262a {
    private static final String f3999b;
    private static C1203a f4000k;
    private static boolean f4001l;
    private String f4002c;
    private String f4003d;
    private JSONArray f4004e;
    private long f4005f;
    private long f4006g;
    private long f4007h;
    private C0278h f4008i;
    private C0278h f4009j;

    static {
        f3999b = C1203a.class.getSimpleName();
        f4001l = false;
    }

    private C1203a() {
        this.f4007h = System.currentTimeMillis();
        this.f4003d = m4396o();
        this.f4004e = new JSONArray();
        this.f4008i = new C0278h(false);
        this.f4009j = new C0278h(false);
    }

    public static C1203a m4355a() {
        if (f4000k == null) {
            synchronized (Chartboost.class) {
                if (f4000k == null) {
                    f4000k = new C1203a();
                }
            }
        }
        return f4000k;
    }

    public static void m4367b() {
        C1203a.m4357a("start");
        C1203a.m4357a("did-become-active");
    }

    public static void m4357a(String str) {
        f4000k.m4382a("session", str, null, null, null, null, "session");
    }

    public void m4385c() {
        m4384a(false);
    }

    public void m4384a(boolean z) {
        C0269a a = C0269a.m425a();
        a.m432a("complete", Boolean.valueOf(z));
        f4000k.m4383a("session", "end", null, null, null, null, a.m443e(), "session");
        C1203a.m4357a("did-become-active");
    }

    public static void m4363a(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        f4000k.m4383a("webview-track", str, str2, str3, null, null, jSONObject, str4);
    }

    public static void m4365a(JSONObject jSONObject) {
        f4000k.m4383a("folder", C0299c.m632F().booleanValue() ? "web" : "native", null, null, null, null, jSONObject, "system");
    }

    public static void m4364a(String str, String str2, String str3, boolean z) {
        f4000k.m4383a("ad-get", str, str2, TextUtils.isEmpty(str3) ? "empty-adid" : str3, C1203a.m4366b(z), "single", null, "system");
    }

    public static void m4359a(String str, String str2, String str3) {
        f4000k.m4382a("ad-show", str, str2, str3, null, null, "system");
    }

    public static void m4370b(String str, String str2, String str3) {
        f4000k.m4382a("ad-click", str, str2, str3, null, null, "system");
    }

    public static void m4373c(String str, String str2, String str3) {
        f4000k.m4382a("ad-close", str, str2, str3, null, null, "system");
    }

    public static void m4360a(String str, String str2, String str3, CBImpressionError cBImpressionError) {
        f4000k.m4382a("ad-error", str, str2, TextUtils.isEmpty(str3) ? "empty-adid" : str3, cBImpressionError != null ? cBImpressionError.toString() : XMLConstants.NULL_NS_URI, null, "system");
    }

    public static void m4361a(String str, String str2, String str3, String str4) {
        f4000k.m4382a("ad-error", str, str2, TextUtils.isEmpty(str3) ? "empty-adid" : str3, str4, null, "system");
    }

    public static void m4371b(String str, String str2, String str3, String str4) {
        f4000k.m4382a("ad-warning", str, str2, TextUtils.isEmpty(str3) ? "empty-adid" : str3, str4, null, "system");
    }

    public static void m4375d() {
        f4000k.m4382a("asset-prefetcher", "start", null, null, null, null, "system");
    }

    public static void m4368b(String str) {
        f4000k.m4383a("asset-prefetcher", C0299c.m632F().booleanValue() ? "web" : "native", str, null, null, null, null, "system");
    }

    public static void m4378e() {
        f4000k.m4383a("asset-prefetcher", C0299c.m632F().booleanValue() ? "web" : "native", null, null, null, null, null, "system");
    }

    public static void m4358a(String str, String str2) {
        f4000k.m4383a("asset-prefetcher", "start", C0299c.m632F().booleanValue() ? "web" : "native", str, str2, null, null, "system");
    }

    public static void m4374c(String str, String str2, String str3, String str4) {
        f4000k.m4383a("asset-prefetcher", "failure", C0299c.m632F().booleanValue() ? "web" : "native", str, str2, str4, null, "system");
    }

    public static void m4377d(String str, String str2, String str3) {
        f4000k.m4383a("asset-prefetcher", "success", C0299c.m632F().booleanValue() ? "web" : "native", str, str2, null, null, "system");
    }

    public static void m4369b(String str, String str2) {
        f4000k.m4382a("playback-complete", str, str2, null, null, null, "system");
    }

    public static void m4372c(String str, String str2) {
        f4000k.m4382a("replay", str, str2, null, null, null, "system");
    }

    public static void m4376d(String str, String str2) {
        f4000k.m4382a("playback-start", str, str2, null, null, null, "system");
    }

    public static void m4379e(String str, String str2) {
        f4000k.m4382a("playback-stop", str, str2, null, null, null, "system");
    }

    public static void m4362a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        f4000k.m4383a(str, str2, str3, str4, str5, str6, jSONObject, "system");
    }

    public void m4382a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f4000k.m4383a(str, str2, str3, str4, str5, str6, new JSONObject(), str7);
    }

    public void m4383a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, String str7) {
        JSONObject jSONObject2;
        try {
            Method declaredMethod = C0299c.class.getDeclaredMethod("k", new Class[0]);
            declaredMethod.setAccessible(true);
            jSONObject2 = (JSONObject) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable e) {
            CBLogging.m382b(this, "Error encountered getting tracking levels", e);
            CBUtility.throwProguardError(e);
            jSONObject2 = null;
        }
        C0269a a = C0269a.m425a();
        if (jSONObject2 != null && jSONObject2.optBoolean(str7)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.f4005f;
            currentTimeMillis -= this.f4007h;
            a.m432a(NotificationCompatApi21.CATEGORY_EVENT, C1203a.m4356a((Object) str));
            a.m432a("kingdom", C1203a.m4356a((Object) str2));
            a.m432a("phylum", C1203a.m4356a((Object) str3));
            a.m432a("class", C1203a.m4356a((Object) str4));
            a.m432a("family", C1203a.m4356a((Object) str5));
            a.m432a("genus", C1203a.m4356a((Object) str6));
            String str8 = "meta";
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a.m432a(str8, jSONObject);
            a.m432a("clientTimestamp", Long.valueOf(System.currentTimeMillis() / 1000));
            a.m432a("session_id", m4392k());
            a.m432a("totalSessionTime", Long.valueOf(j / 1000));
            a.m432a("currentSessionTime", Long.valueOf(currentTimeMillis / 1000));
            synchronized (this) {
                if (m4387f()) {
                    m4397p();
                    ba.m923e();
                }
                this.f4004e.put(a.m443e());
                Object a2 = C0269a.m425a();
                a2.m432a("events", this.f4004e);
                CBLogging.m379a(f3999b, "###Writing" + C1203a.m4356a((Object) str) + "to tracking cache dir");
                this.f4008i.m510a(this.f4008i.m529p(), this.f4003d, C0269a.m426a(a2));
                m4391j();
            }
        }
    }

    public boolean m4387f() {
        if (this.f4004e == null || this.f4004e.length() < 50) {
            return false;
        }
        return true;
    }

    public String m4388g() {
        C0269a a = C0269a.m425a();
        a.m432a("startTime", Long.valueOf(System.currentTimeMillis()));
        a.m432a("deviceID", C0266c.m417e());
        this.f4002c = C0263b.m407b(a.toString().getBytes());
        return this.f4002c;
    }

    public void m4389h() {
        C0269a a = this.f4009j.m508a(this.f4009j.m528o(), "cb_previous_session_info");
        if (a != null) {
            this.f4006g = a.m451i("timestamp");
            this.f4005f = a.m451i("start_timestamp");
            this.f4002c = a.m442e("session_id");
            if (System.currentTimeMillis() - this.f4006g > 180000) {
                m4384a(true);
            } else if (!TextUtils.isEmpty(this.f4002c)) {
                m4391j();
                f4001l = false;
                return;
            }
        }
        m4390i();
        f4001l = true;
    }

    public void m4390i() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f4005f = currentTimeMillis;
        this.f4006g = currentTimeMillis;
        this.f4002c = m4388g();
        m4381a(currentTimeMillis, currentTimeMillis);
        SharedPreferences a = CBUtility.m391a();
        int i = a.getInt("cbPrefSessionCount", 0) + 1;
        Editor edit = a.edit();
        edit.putInt("cbPrefSessionCount", i);
        edit.commit();
    }

    public void m4391j() {
        m4381a(this.f4005f, System.currentTimeMillis());
    }

    public void m4381a(long j, long j2) {
        C0269a a = C0269a.m425a();
        a.m432a("start_timestamp", Long.valueOf(j));
        a.m432a("timestamp", Long.valueOf(j2));
        a.m432a("session_id", this.f4002c);
        this.f4009j.m510a(this.f4009j.m528o(), "cb_previous_session_info", a);
    }

    public az m4380a(C0269a c0269a) {
        az azVar = new az("/api/track");
        azVar.m869a("track", (Object) c0269a);
        azVar.m863a(C0276g.m480a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a)));
        azVar.m866a(C0414a.LOW);
        return azVar;
    }

    public String toString() {
        return "Session [ startTime: " + m4395n() + " sessionEvents: " + m4394m() + " ]";
    }

    public String m4392k() {
        return this.f4002c;
    }

    public C0278h m4393l() {
        return this.f4008i;
    }

    public JSONArray m4394m() {
        return this.f4004e;
    }

    public long m4395n() {
        return this.f4005f;
    }

    public String m4396o() {
        return new Long(System.nanoTime()).toString();
    }

    public static String m4366b(boolean z) {
        return z ? SchemaSymbols.ATTVAL_TRUE_1 : SchemaSymbols.ATTVAL_FALSE_0;
    }

    private static Object m4356a(Object obj) {
        return obj != null ? obj : XMLConstants.NULL_NS_URI;
    }

    public boolean m4386c(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals("cb_previous_session_info");
    }

    public void m4397p() {
        this.f4004e = new JSONArray();
        this.f4003d = m4396o();
    }
}
