package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0266c;
import com.chartboost.sdk.Libraries.C0266c.C0265a;
import com.chartboost.sdk.Libraries.C0271e;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0271e.C0270b;
import com.chartboost.sdk.Libraries.C0276g.C0274a;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.C0284a;
import com.chartboost.sdk.Tracking.C1203a;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.az.C0347c;
import com.google.android.gcm.GCMConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mf.javax.xml.XMLConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ba implements Observer {
    private static ba f912b;
    private static ConcurrentHashMap<az, File> f913e;
    private static ConcurrentHashMap<az, File> f914f;
    private static List<Runnable> f915h;
    private ay f916a;
    private C0417m f917c;
    private C0278h f918d;
    private ConcurrentHashMap<String, C0353b> f919g;
    private CountDownTimer f920i;

    /* renamed from: com.chartboost.sdk.impl.ba.1 */
    class C03511 extends CountDownTimer {
        final /* synthetic */ ba f897a;

        C03511(ba baVar, long j, long j2) {
            this.f897a = baVar;
            super(j, j2);
        }

        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
            this.f897a.m930c();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.a */
    public enum C0352a {
        ARRAY_OF_DICTIONARY
    }

    /* renamed from: com.chartboost.sdk.impl.ba.b */
    private class C0353b {
        final /* synthetic */ ba f900a;
        private String f901b;
        private int f902c;
        private String f903d;
        private C0352a f904e;
        private boolean f905f;
        private JSONArray f906g;
        private az f907h;

        public C0353b(ba baVar) {
            this.f900a = baVar;
            this.f901b = null;
            this.f902c = 50;
            this.f905f = false;
            this.f906g = null;
            this.f903d = Long.toString(System.nanoTime());
            this.f904e = C0352a.ARRAY_OF_DICTIONARY;
            this.f906g = new JSONArray();
        }

        public String m903a() {
            return this.f903d;
        }

        public void m904a(String str) {
            this.f901b = str;
        }

        public String m906b() {
            return this.f901b;
        }

        public boolean m908c() {
            return this.f905f;
        }

        public void m905a(boolean z) {
            this.f905f = z;
        }

        public void m909d() {
            this.f906g = new JSONArray();
        }

        public synchronized az m902a(az azVar) {
            C0269a i = azVar.m884i();
            if (i.m438c()) {
                i = i.m431a(this.f901b);
                if (!i.m435b()) {
                    if (this.f904e == C0352a.ARRAY_OF_DICTIONARY) {
                        if (this.f900a.f916a.m855c() || (this.f907h != null && this.f907h.m892q())) {
                            this.f903d = Long.toString(System.nanoTime());
                            azVar.m869a(this.f901b, new JSONArray().put(i.m443e()));
                        } else {
                            if (this.f906g.length() == this.f902c) {
                                this.f903d = Long.toString(System.nanoTime());
                                this.f906g = new JSONArray();
                            }
                            this.f906g.put(i.m443e());
                            if (this.f907h != null) {
                                ba.f913e.remove(this.f907h);
                            }
                            azVar.m869a(this.f901b, this.f906g);
                            this.f907h = azVar;
                            azVar = this.f907h;
                        }
                    }
                }
            }
            return azVar;
        }

        public void m907b(az azVar) {
            this.f907h = azVar;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.d */
    public static class C0354d {
        private C0269a f908a;
        private C0412i f909b;

        public C0354d(C0269a c0269a, C0412i c0412i) {
            this.f908a = c0269a;
            this.f909b = c0412i;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.e */
    private class C0355e implements Runnable {
        final /* synthetic */ ba f910a;
        private az f911b;

        /* renamed from: com.chartboost.sdk.impl.ba.e.a */
        private class C1236a extends C0415l<C0354d> {
            final /* synthetic */ C0355e f4138a;
            private az f4139b;

            protected /* synthetic */ void m4572b(Object obj) {
                m4570a((C0354d) obj);
            }

            public C1236a(C0355e c0355e, int i, String str, az azVar) {
                this.f4138a = c0355e;
                super(i, str, null);
                this.f4139b = azVar;
            }

            public String m4574p() {
                String b = this.f4139b.m873b();
                if (b == null) {
                    return "application/json; charset=utf-8";
                }
                return b;
            }

            public byte[] m4575q() {
                return (this.f4139b.m884i() == null ? XMLConstants.NULL_NS_URI : this.f4139b.m884i().toString()).getBytes();
            }

            public C0414a m4576s() {
                return this.f4139b.m889n();
            }

            public Map<String, String> m4573i() throws C1214a {
                Map<String, String> hashMap = new HashMap();
                for (Entry entry : this.f4139b.m885j().entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue() != null ? entry.getValue().toString() : null);
                }
                return hashMap;
            }

            protected C0420n<C0354d> m4569a(C0412i c0412i) {
                CBError cBError;
                Exception exception;
                Object obj = C0269a.f470a;
                int i = c0412i.f1100a;
                if (i <= 300 || i >= 200) {
                    try {
                        String str;
                        byte[] bArr = c0412i.f1101b;
                        if (bArr != null) {
                            str = new String(bArr);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            C0269a a = C0269a.m426a(new JSONObject(new JSONTokener(str)));
                            try {
                                CBError cBError2;
                                C0274a l = this.f4139b.m887l();
                                CBLogging.m383c("CBRequestManager", "Request " + this.f4139b.m882g() + " succeeded. Response code: " + i + ", body: " + str);
                                if (a.m444f(NotificationCompatApi21.CATEGORY_STATUS) == 404) {
                                    cBError2 = new CBError(C0284a.HTTP_NOT_FOUND, "404 error from server");
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    if (l == null || l.m473a(a, stringBuilder)) {
                                        cBError2 = null;
                                    } else {
                                        cBError2 = new CBError(C0284a.UNEXPECTED_RESPONSE, "Json response failed validation");
                                        CBLogging.m381b("CBRequestManager", "Json response failed validation: " + stringBuilder.toString());
                                    }
                                }
                                C0269a c0269a = a;
                                cBError = cBError2;
                                C0269a c0269a2 = c0269a;
                            } catch (Exception e) {
                                exception = e;
                                obj = a;
                                cBError = new CBError(C0284a.MISCELLANEOUS, exception.getLocalizedMessage());
                                if (obj.m438c()) {
                                }
                                return C0420n.m1129a(new C1235c(cBError));
                            }
                        }
                        cBError = new CBError(C0284a.INVALID_RESPONSE, "Response is not a valid json object");
                    } catch (Exception e2) {
                        exception = e2;
                        cBError = new CBError(C0284a.MISCELLANEOUS, exception.getLocalizedMessage());
                        if (obj.m438c()) {
                        }
                        return C0420n.m1129a(new C1235c(cBError));
                    }
                }
                CBLogging.m385d("CBRequestManager", "Request " + this.f4139b.m882g() + " failed. Response code: " + i);
                cBError = new CBError(C0284a.NETWORK_FAILURE, "Request failed. Response code: " + i + " is not valid ");
                if (obj.m438c() || cBError != null) {
                    return C0420n.m1129a(new C1235c(cBError));
                }
                return C0420n.m1130a(new C0354d(C0269a.m426a(obj), c0412i), null);
            }

            protected void m4570a(C0354d c0354d) {
                if (!(this.f4138a.f911b.m893r() == null || c0354d == null)) {
                    this.f4138a.f911b.m893r().m856a(c0354d.f908a, this.f4138a.f911b);
                }
                if (this.f4138a.f911b.m883h()) {
                    C1203a.m4355a().m4393l().m520e((File) ba.f914f.get(this.f4138a.f911b));
                    C1203a.m4355a().m4397p();
                    CBLogging.m379a("CBRequestManager", "### Removing track events sent to server...");
                    ba.f914f.remove(this.f4138a.f911b);
                    return;
                }
                this.f4138a.f910a.f918d.m520e((File) ba.f913e.get(this.f4138a.f911b));
                ba.f913e.remove(this.f4138a.f911b);
                C0353b c0353b = (C0353b) this.f4138a.f910a.f919g.get(this.f4138a.f911b.m882g());
                if (c0353b != null && !TextUtils.isEmpty(c0353b.m906b()) && c0353b.m908c() && c0353b.f907h == this.f4138a.f911b) {
                    c0353b.m909d();
                    c0353b.m907b(null);
                }
                this.f4138a.f911b.m879d(false);
                this.f4138a.f910a.m917a(this.f4138a.f911b, c0354d.f909b, null, true);
            }

            public void m4571b(C0423s c0423s) {
                if (!(this.f4138a.f911b == null || C0299c.m669l())) {
                    if (!this.f4138a.f911b.m883h() && ba.f913e.containsKey(this.f4138a.f911b)) {
                        this.f4138a.f910a.f918d.m520e((File) ba.f913e.get(this.f4138a.f911b));
                        ba.f913e.remove(this.f4138a.f911b);
                    } else if (!ba.f914f.isEmpty() && ba.f914f.containsKey(this.f4138a.f911b)) {
                        C1203a.m4355a().m4393l().m520e((File) ba.f914f.get(this.f4138a.f911b));
                        ba.f914f.remove(this.f4138a.f911b);
                    }
                }
                if (c0423s != null) {
                    CBError a;
                    if (c0423s instanceof C1235c) {
                        a = ((C1235c) c0423s).f4137b;
                    } else {
                        a = new CBError(C0284a.NETWORK_FAILURE, c0423s.getMessage());
                    }
                    C0269a c0269a = C0269a.f470a;
                    if (c0423s != null) {
                        try {
                            if (!(c0423s.f1141a == null || c0423s.f1141a.f1101b == null || c0423s.f1141a.f1101b.length <= 0)) {
                                c0269a = C0269a.m427k(new String(c0423s.f1141a.f1101b));
                            }
                        } catch (Throwable e) {
                            CBLogging.m386d("CBRequestManager", "unable to read error json", e);
                        }
                    }
                    if (c0423s.f1141a == null || c0423s.f1141a.f1100a != 200) {
                        if (this.f4138a.f911b.m893r() != null) {
                            this.f4138a.f911b.m893r().m857a(c0269a, this.f4138a.f911b, a);
                        }
                        if (this.f4138a.f911b.m883h()) {
                            ba.f914f.remove(this.f4138a.f911b);
                            return;
                        }
                        this.f4138a.f911b.m879d(false);
                        this.f4138a.f910a.m917a(this.f4138a.f911b, c0423s.f1141a, a, false);
                        return;
                    }
                    m4570a(new C0354d(c0269a, c0423s.f1141a));
                }
            }
        }

        public C0355e(ba baVar, az azVar) {
            this.f910a = baVar;
            this.f911b = azVar;
        }

        public void run() {
            this.f911b.m876c();
            this.f911b.m878d();
            String format = String.format("%s%s", new Object[]{"https://live.chartboost.com", this.f911b.m880e()});
            this.f911b.m861a();
            C0415l c1236a = new C1236a(this, 1, format, this.f911b);
            c1236a.m1088a(new C1244d(30000, 0, 0.0f));
            this.f910a.f917c.m1119a(c1236a);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.ba.c */
    public static class C1235c extends C0423s {
        private CBError f4137b;

        public C1235c(CBError cBError) {
            this.f4137b = cBError;
        }
    }

    static {
        f915h = new ArrayList();
    }

    public static ba m914a(Context context) {
        if (f912b == null) {
            synchronized (ba.class) {
                if (f912b == null) {
                    f912b = new ba(context);
                }
            }
        }
        return f912b;
    }

    private ba(Context context) {
        this.f916a = null;
        this.f917c = ad.m795a(context.getApplicationContext());
        this.f916a = ay.m847a();
        this.f918d = new C0278h(false);
        f913e = new ConcurrentHashMap();
        f914f = new ConcurrentHashMap();
        this.f919g = new ConcurrentHashMap();
        m926l();
        this.f916a.addObserver(this);
    }

    public C0417m m927a() {
        return this.f917c;
    }

    private void m917a(az azVar, C0412i c0412i, CBError cBError, boolean z) {
        if (azVar != null) {
            String str;
            C0270b[] c0270bArr = new C0270b[5];
            c0270bArr[0] = C0271e.m462a("endpoint", azVar.m882g());
            c0270bArr[1] = C0271e.m462a("statuscode", c0412i == null ? "None" : Integer.valueOf(c0412i.f1100a));
            c0270bArr[2] = C0271e.m462a(GCMConstants.EXTRA_ERROR, cBError == null ? "None" : cBError.m554a());
            c0270bArr[3] = C0271e.m462a("errorDescription", cBError == null ? "None" : cBError.m555b());
            c0270bArr[4] = C0271e.m462a("retryCount", Integer.valueOf(azVar.m890o()));
            C0269a a = C0271e.m461a(c0270bArr);
            String str2 = "request_manager";
            String str3 = "request";
            if (z) {
                str = "success";
            } else {
                str = "failure";
            }
            C1203a.m4362a(str2, str3, str, null, null, null, a.m443e());
        }
    }

    protected void m928a(az azVar, C0347c c0347c) {
        if (azVar != null) {
            if (this.f916a.m855c()) {
                if (!azVar.m883h() && azVar.m891p()) {
                    azVar.m877c(false);
                    m916a(azVar);
                }
                m929a(new C0355e(this, azVar));
                return;
            }
            CBError cBError = new CBError(C0284a.INTERNET_UNAVAILABLE, "Internet Unavailable");
            azVar.m879d(false);
            if (!azVar.m883h()) {
                if (azVar.m891p()) {
                    azVar.m877c(false);
                    m916a(azVar);
                }
                m917a(azVar, null, cBError, false);
                if (c0347c != null) {
                    CBLogging.m381b("Network failure", String.format("request %s failed with error : %s", new Object[]{azVar.m882g(), cBError.m555b()}));
                    c0347c.m857a(C0269a.f470a, azVar, cBError);
                }
            }
        }
    }

    public void m929a(Runnable runnable) {
        Object obj = null;
        synchronized (C0266c.class) {
            C0265a c = C0266c.m415c();
            if (c == C0265a.PRELOAD || c == C0265a.LOADING) {
                f915h.add(runnable);
            } else {
                obj = 1;
            }
        }
        if (obj != null) {
            ax.m845a().execute(runnable);
        }
    }

    public static void m920b() {
        List<Runnable> arrayList = new ArrayList();
        synchronized (C0266c.class) {
            arrayList.addAll(f915h);
            f915h.clear();
        }
        for (Runnable execute : arrayList) {
            ax.m845a().execute(execute);
        }
    }

    public synchronized void m930c() {
        synchronized (this) {
            if (f913e != null && !f913e.isEmpty()) {
                for (az azVar : f913e.keySet()) {
                    if (!(azVar == null || azVar.m892q())) {
                        azVar.m862a(azVar.m890o() + 1);
                        azVar.m864a(azVar.m893r());
                    }
                }
                m932f();
            } else if (this.f918d.m527n() != null) {
                String[] list = this.f918d.m527n().list();
                if (list != null) {
                    for (String str : list) {
                        az a = m913a(str);
                        if (a != null) {
                            f913e.put(a, this.f918d.m516c(this.f918d.m527n(), str));
                            a.m877c(false);
                            a.m862a(a.m890o() + 1);
                            a.m864a(a.m893r());
                        }
                    }
                }
                m932f();
            }
        }
    }

    public synchronized void m931d() {
        try {
            String[] c;
            if (this.f918d != null) {
                c = this.f918d.m518c(this.f918d.m527n());
            } else {
                c = null;
            }
            if (c != null && c.length > 0) {
                for (String str : c) {
                    C0269a a = this.f918d.m508a(this.f918d.m527n(), str);
                    if (a.m438c()) {
                        this.f918d.m513b(this.f918d.m527n(), str);
                        az a2 = az.m858a(a);
                        if (a2 != null) {
                            a2.m871a(true);
                            a2.m894s();
                        } else {
                            CBLogging.m381b("CBRequestManager", "Error processing video completion event");
                        }
                    }
                }
            }
        } catch (Throwable e) {
            CBLogging.m382b("CBRequestManager", "Error executing saved requests", e);
        }
    }

    public static void m923e() {
        C1203a a = C1203a.m4355a();
        if (!C0299c.m670m()) {
            if (!(f914f == null || f914f.isEmpty())) {
                f914f.clear();
            }
            C0278h l = a.m4393l();
            l.m521f(l.m529p());
        } else if (f914f.isEmpty()) {
            try {
                String[] c;
                C0278h l2 = a.m4393l();
                if (l2 != null) {
                    c = l2.m518c(l2.m529p());
                } else {
                    c = null;
                }
                if (c != null) {
                    for (String str : c) {
                        if (!a.m4386c(str)) {
                            C0269a a2 = l2.m508a(l2.m529p(), str);
                            if (a2.m438c()) {
                                CBLogging.m379a("CBRequestManager", "### Flushing out " + str + "track events from cache to server...");
                                az a3 = a.m4380a(a2);
                                f914f.put(a3, l2.m516c(l2.m529p(), str));
                                a3.m894s();
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                CBLogging.m382b("CBRequestManager", "Error executing saved requests", e);
            }
        } else {
            for (az azVar : f914f.keySet()) {
                if (!(azVar == null || azVar.m892q())) {
                    azVar.m862a(azVar.m890o() + 1);
                    azVar.m864a(azVar.m893r());
                }
            }
        }
    }

    private void m916a(az azVar) {
        if (azVar != null) {
            Object a;
            if (azVar.m886k()) {
                C0353b c0353b = (C0353b) this.f919g.get(azVar.m882g());
                if (c0353b == null || TextUtils.isEmpty(c0353b.m906b()) || !c0353b.m908c()) {
                    a = this.f918d.m509a(this.f918d.m527n(), null, azVar.m895t());
                } else {
                    azVar = c0353b.m902a(azVar);
                    a = this.f918d.m510a(this.f918d.m527n(), c0353b.m903a(), azVar.m895t());
                }
            } else {
                a = null;
            }
            if ((azVar.m886k() || azVar.m888m()) && a != null) {
                f913e.put(azVar, a);
            }
        }
    }

    private az m913a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0269a a = this.f918d.m508a(this.f918d.m527n(), str);
        if (a.m438c()) {
            return az.m858a(a);
        }
        return null;
    }

    public void m932f() {
        if (this.f920i == null) {
            this.f920i = new C03511(this, 240000, 1000).start();
        }
    }

    public void m933g() {
        CBLogging.m379a("CBRequestManager", "Timer stopped:");
        if (this.f920i != null) {
            this.f920i.cancel();
            this.f920i = null;
        }
    }

    public void update(Observable observable, Object data) {
        if (this.f920i != null) {
            m933g();
        }
        m930c();
    }

    public ConcurrentHashMap<az, File> m934h() {
        return f913e;
    }

    public C0278h m935i() {
        return this.f918d;
    }

    private void m926l() {
        C0353b c0353b = new C0353b(this);
        c0353b.m904a("track_info");
        c0353b.m905a(true);
        this.f919g.put("/post-install-event/".concat("tracking"), c0353b);
    }
}
