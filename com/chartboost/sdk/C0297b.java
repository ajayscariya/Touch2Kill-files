package com.chartboost.sdk;

import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0276g.C0275k;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C1203a;
import com.chartboost.sdk.impl.C0412i;
import com.chartboost.sdk.impl.C0415l;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.C0417m;
import com.chartboost.sdk.impl.C0420n;
import com.chartboost.sdk.impl.C0420n.C0418a;
import com.chartboost.sdk.impl.C0423s;
import com.chartboost.sdk.impl.C1244d;
import com.chartboost.sdk.impl.C1246h;
import com.chartboost.sdk.impl.C1249q;
import com.chartboost.sdk.impl.C1250r;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0347c;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bd;
import com.chartboost.sdk.impl.bd.C0364a;
import com.chartboost.sdk.impl.bv;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import mf.org.apache.xml.serialize.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.b */
public class C0297b {
    public static volatile ArrayList<C0291a> f648a;
    public static C0297b f649b;
    private static final String f650c;
    private static C0278h f651d;
    private static C0417m f652e;
    private static C0296b f653f;
    private static C0296b f654g;
    private static AtomicInteger f655h;
    private static AtomicInteger f656i;
    private static String f657j;
    private static boolean f658k;
    private static long f659l;
    private static long f660m;
    private static int f661n;
    private static int f662o;
    private static ConcurrentHashMap<String, C0295a> f663p;
    private static ConcurrentHashMap<String, JSONArray> f664q;
    private static ConcurrentHashMap<String, String> f665r;
    private static ConcurrentHashMap<String, Integer> f666s;
    private static C0269a f667t;
    private static C0269a f668u;
    private static C0347c f669v;

    /* renamed from: com.chartboost.sdk.b.2 */
    static class C02942 implements Runnable {
        final /* synthetic */ C0291a f637a;

        C02942(C0291a c0291a) {
            this.f637a = c0291a;
        }

        public void run() {
            this.f637a.m590u().m723d(this.f637a);
        }
    }

    /* renamed from: com.chartboost.sdk.b.a */
    private static class C0295a {
        public String f638a;
        public String f639b;
        public String f640c;
        public String f641d;
        public C0269a f642e;
        public ArrayList<String> f643f;
        public boolean f644g;

        public C0295a(String str, String str2, String str3, String str4, C0269a c0269a) {
            this.f638a = str;
            this.f639b = str2;
            this.f640c = str3;
            this.f641d = str4;
            this.f642e = c0269a;
            this.f643f = new ArrayList();
            this.f643f.add(this.f638a);
            this.f644g = false;
        }
    }

    /* renamed from: com.chartboost.sdk.b.b */
    public enum C0296b {
        kCBInitial,
        kCBInProgress
    }

    /* renamed from: com.chartboost.sdk.b.1 */
    static class C12041 implements C0347c {
        C12041() {
        }

        public void m4398a(C0269a c0269a, az azVar) {
            C0297b.f653f = C0296b.kCBInitial;
            try {
                if (c0269a.m438c()) {
                    C0269a a = c0269a.m431a("ad_units");
                    CBLogging.m379a(C0297b.f650c, "Got Asset list for Web Prefetch from server :)" + c0269a);
                    C0297b.m604a(a, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            C1203a.m4368b("complete-success");
        }

        public void m4399a(C0269a c0269a, az azVar, CBError cBError) {
            try {
                C0297b.f653f = C0296b.kCBInitial;
                C1203a.m4368b("complete-failure");
                C0297b.m604a(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.b.c */
    private static class C1205c extends C0415l<Object> {
        private String f4010a;
        private long f4011b;
        private String f4012c;
        private C0295a f4013d;

        public C1205c(int i, String str, C1206d c1206d, String str2, C0295a c0295a) {
            super(i, str, c1206d);
            this.f4010a = str2;
            this.f4012c = str;
            this.f4011b = System.currentTimeMillis();
            this.f4013d = c0295a;
        }

        protected void m4405b(Object obj) {
        }

        protected C0420n<Object> m4404a(C0412i c0412i) {
            if (c0412i != null) {
                File k;
                File s;
                C1203a.m4377d(this.f4010a, Long.valueOf((System.currentTimeMillis() - this.f4011b) / 1000).toString(), this.f4012c);
                CBLogging.m379a(C0297b.f650c, "Asset download Success. Storing asset in cache" + this.f4010a);
                if (this.f4013d.f640c.equalsIgnoreCase("css")) {
                    k = C0297b.f651d.m524k();
                } else if (this.f4013d.f640c.equalsIgnoreCase("js")) {
                    k = C0297b.f651d.m525l();
                } else if (this.f4013d.f640c.equalsIgnoreCase("media")) {
                    k = C0297b.f651d.m526m();
                } else if (this.f4013d.f640c.contains(Method.HTML)) {
                    CharSequence a = C0297b.m609b(new String(c0412i.f1101b, Charset.defaultCharset()));
                    k = C0297b.f651d.m530q();
                    if (TextUtils.isEmpty(a)) {
                        if (C0297b.f666s.containsKey(this.f4013d.f638a)) {
                            C0297b.f666s.remove(this.f4013d.f638a);
                        }
                        CBLogging.m381b(C0297b.f650c, "Error happened while injecting the html file, invalid injection params in the html or injection params missing in the prefetch");
                    } else {
                        C0297b.f665r.put(this.f4013d.f638a, a);
                    }
                } else {
                    k = null;
                }
                if (k != null) {
                    if (k != null) {
                        try {
                            bv.m1066a(new File(k, this.f4013d.f639b), c0412i.f1101b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        s = C0297b.f651d.m532s();
                        if (s != null) {
                            Iterator it = this.f4013d.f643f.iterator();
                            while (it.hasNext()) {
                                File file = new File(s, (String) it.next());
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                try {
                                    bv.m1066a(new File(file, this.f4013d.f639b.split("\\.(?=[^\\.]+$)")[0]), this.f4013d.f642e.toString().getBytes());
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (C0297b.f666s.containsKey(this.f4013d.f638a)) {
                    int intValue = ((Integer) C0297b.f666s.get(this.f4013d.f638a)).intValue() - 1;
                    if (intValue > 0) {
                        C0297b.f666s.put(this.f4013d.f638a, Integer.valueOf(intValue));
                    } else {
                        ArrayList d;
                        C0297b.f666s.remove(this.f4013d.f638a);
                        s = C0297b.f651d.m533t();
                        File u = C0297b.f651d.m534u();
                        if (C0278h.m503i()) {
                            d = C0278h.m497d(u);
                        } else {
                            d = C0278h.m497d(s);
                        }
                        if (!(d == null || d.isEmpty() || !d.contains(this.f4013d.f638a))) {
                            d.remove(this.f4013d.f638a);
                        }
                        if (C0278h.m503i()) {
                            CBLogging.m387e(C0297b.f650c, "##### Serializing blacklist ad id to " + u);
                            C0278h.m493a(d, u, false);
                        } else {
                            CBLogging.m387e(C0297b.f650c, "##### Serializing blacklist ad id to " + s);
                            C0278h.m493a(d, s, false);
                        }
                    }
                }
            }
            CBLogging.m379a(C0297b.f650c, "Current Download count:" + C0297b.f655h.get());
            if (C0297b.f655h.incrementAndGet() == C0297b.f656i.get()) {
                CBLogging.m387e(C0297b.f650c, "##### Success Response callback : Asset Prefetch Download Complete");
                C0297b.f655h.set(0);
                C0297b.f656i.set(0);
                C0297b.f654g = C0296b.kCBInitial;
                C0297b.m625o();
            }
            return C0420n.m1130a(null, null);
        }

        public C0414a m4406s() {
            return C0414a.LOW;
        }
    }

    /* renamed from: com.chartboost.sdk.b.d */
    private static class C1206d implements C0418a {
        private C1205c f4014a;

        private C1206d() {
        }

        public void m4408a(C0423s c0423s) {
            synchronized (C0297b.m602a()) {
                try {
                    if ((c0423s instanceof C1250r) || (c0423s instanceof C1249q) || (c0423s instanceof C1246h)) {
                        if (this.f4014a != null) {
                            C1203a.m4374c(this.f4014a.f4010a, Long.valueOf((System.currentTimeMillis() - this.f4014a.f4011b) / 1000).toString(), this.f4014a.f4012c, c0423s.getMessage());
                        }
                        CBLogging.m381b(C0297b.f650c, "Error downloading asset " + c0423s.getMessage() + this.f4014a.f4010a);
                    }
                    C0295a d = this.f4014a.f4013d;
                    if (C0297b.f666s.containsKey(d.f638a)) {
                        C0297b.f666s.remove(d.f638a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (C0297b.f655h.incrementAndGet() == C0297b.f656i.get()) {
                    CBLogging.m387e(C0297b.f650c, "##### Failure response callback : Asset Prefetch Download Complete");
                    C0297b.f655h.set(0);
                    C0297b.f656i.set(0);
                    C0297b.f654g = C0296b.kCBInitial;
                    C0297b.m625o();
                }
            }
        }
    }

    static {
        f650c = C0297b.class.getSimpleName();
        f655h = new AtomicInteger();
        f656i = new AtomicInteger();
        f657j = "blacklist";
        f658k = false;
        f661n = 7;
        f662o = 10;
        f669v = new C12041();
    }

    private C0297b() {
    }

    public static synchronized C0297b m602a() {
        C0297b c0297b;
        synchronized (C0297b.class) {
            if (f649b == null) {
                f649b = new C0297b();
                C0297b.m624n();
            }
            c0297b = f649b;
        }
        return c0297b;
    }

    private static synchronized void m624n() {
        synchronized (C0297b.class) {
            if (!f658k) {
                f658k = true;
                f651d = new C0278h(true);
                f653f = C0296b.kCBInitial;
                f654g = C0296b.kCBInitial;
                f652e = ba.m914a(C0299c.m682y()).m927a();
                f648a = new ArrayList();
                f659l = C0278h.m504w();
                f660m = C0278h.m505x();
                f661n = C0299c.m630D();
                f662o = C0299c.m631E();
                f666s = new ConcurrentHashMap();
                f665r = new ConcurrentHashMap();
            }
        }
    }

    public static synchronized void m610b() {
        synchronized (C0297b.class) {
            synchronized (f649b) {
                if (C0299c.m681x()) {
                    CBLogging.m379a(f650c, "Prefetching the asset list");
                    if (C0296b.kCBInProgress == f653f || C0296b.kCBInProgress == f654g) {
                    } else {
                        f653f = C0296b.kCBInProgress;
                        f656i.set(0);
                        f655h.set(0);
                        bd bdVar = new bd(C0299c.m629C());
                        C0297b.m607b(false);
                        bdVar.m4581a("ad_units", f668u, C0364a.AD);
                        C0275k[] c0275kArr = new C0275k[2];
                        c0275kArr[0] = C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a);
                        C0275k[] c0275kArr2 = new C0275k[2];
                        c0275kArr2[0] = C0276g.m482a("id", C0276g.m476a());
                        c0275kArr2[1] = C0276g.m482a("elements", C0276g.m484b(C0276g.m480a(C0276g.m482a("type", C0276g.m476a()), C0276g.m482a("name", C0276g.m476a()), C0276g.m482a("value", C0276g.m476a()))));
                        c0275kArr[1] = C0276g.m482a("ad_units", C0276g.m484b(C0276g.m480a(c0275kArr2)));
                        bdVar.m863a(C0276g.m480a(c0275kArr));
                        bdVar.m875b(true);
                        bdVar.m864a(f669v);
                        C1203a.m4375d();
                        C1203a.m4365a(C0278h.m506y().m443e());
                    }
                }
            }
        }
    }

    private static void m611b(C0269a c0269a) {
        int i;
        int o = c0269a.m458o();
        if (o > f662o) {
            i = f662o;
        } else {
            i = o;
        }
        for (int i2 = 0; i2 < i; i2++) {
            C0269a c = c0269a.m437c(i2);
            Object e = c.m442e("id");
            C0269a a = c.m431a("elements");
            JSONArray jSONArray = new JSONArray();
            if (!(TextUtils.isEmpty(e) || a == null || a.m458o() <= 0)) {
                for (int i3 = 0; i3 < a.m458o(); i3++) {
                    C0269a c2 = a.m437c(i3);
                    String e2 = c2.m442e("type");
                    Object e3 = c2.m442e("name");
                    Object e4 = c2.m442e("value");
                    if (!(TextUtils.isEmpty(e2) || TextUtils.isEmpty(e3) || TextUtils.isEmpty(e4))) {
                        C0295a c0295a;
                        if (f663p.containsKey(e3)) {
                            c0295a = (C0295a) f663p.get(e3);
                            c0295a.f643f.add(e);
                            f663p.put(e3, c0295a);
                        } else {
                            c0295a = new C0295a(e, e3, e2, e4, c2);
                            if (e2.equals("param")) {
                                File file = new File(f651d.m532s(), c0295a.f638a);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                try {
                                    bv.m1066a(new File(file, c0295a.f639b.split("\\.(?=[^\\.]+$)")[0]), c0295a.f642e.toString().getBytes());
                                } catch (IOException e5) {
                                    CBLogging.m381b(f650c, "Failed to add the injection values into the log");
                                    e5.printStackTrace();
                                }
                                jSONArray.put(c0295a);
                            } else {
                                f663p.put(e3, c0295a);
                            }
                        }
                    }
                }
                if (jSONArray.length() > 0 && !f664q.containsKey(e)) {
                    f664q.put(e, jSONArray);
                }
            }
        }
    }

    public static void m613c() {
        C0297b.m607b(true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m604a(com.chartboost.sdk.Libraries.C0271e.C0269a r12, boolean r13) {
        /*
        r4 = f649b;	 Catch:{ Exception -> 0x013e }
        monitor-enter(r4);	 Catch:{ Exception -> 0x013e }
        r0 = f665r;	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r0 = f665r;	 Catch:{ all -> 0x013b }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x013b }
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        r0 = f665r;	 Catch:{ all -> 0x013b }
        r0.clear();	 Catch:{ all -> 0x013b }
    L_0x0014:
        com.chartboost.sdk.Tracking.C1203a.m4378e();	 Catch:{ all -> 0x013b }
        r0 = new java.util.concurrent.ConcurrentHashMap;	 Catch:{ all -> 0x013b }
        r0.<init>();	 Catch:{ all -> 0x013b }
        f663p = r0;	 Catch:{ all -> 0x013b }
        r0 = new java.util.concurrent.ConcurrentHashMap;	 Catch:{ all -> 0x013b }
        r0.<init>();	 Catch:{ all -> 0x013b }
        f664q = r0;	 Catch:{ all -> 0x013b }
        r0 = f667t;	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x003e;
    L_0x0029:
        r0 = f667t;	 Catch:{ all -> 0x013b }
        r0 = r0.m438c();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x003e;
    L_0x0031:
        r0 = f667t;	 Catch:{ all -> 0x013b }
        r0 = r0.m458o();	 Catch:{ all -> 0x013b }
        if (r0 <= 0) goto L_0x003e;
    L_0x0039:
        r0 = f667t;	 Catch:{ all -> 0x013b }
        com.chartboost.sdk.C0297b.m611b(r0);	 Catch:{ all -> 0x013b }
    L_0x003e:
        if (r12 == 0) goto L_0x004f;
    L_0x0040:
        r0 = r12.m438c();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x004f;
    L_0x0046:
        r0 = r12.m458o();	 Catch:{ all -> 0x013b }
        if (r0 <= 0) goto L_0x004f;
    L_0x004c:
        com.chartboost.sdk.C0297b.m611b(r12);	 Catch:{ all -> 0x013b }
    L_0x004f:
        r5 = com.chartboost.sdk.Libraries.C0278h.m495b();	 Catch:{ all -> 0x013b }
        r0 = f651d;	 Catch:{ all -> 0x013b }
        r6 = r0.m533t();	 Catch:{ all -> 0x013b }
        r0 = f651d;	 Catch:{ all -> 0x013b }
        r7 = r0.m534u();	 Catch:{ all -> 0x013b }
        r0 = com.chartboost.sdk.Libraries.C0278h.m503i();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x0147;
    L_0x0065:
        r0 = com.chartboost.sdk.Libraries.C0278h.m497d(r7);	 Catch:{ all -> 0x013b }
        r3 = r0;
    L_0x006a:
        if (r5 == 0) goto L_0x0165;
    L_0x006c:
        r0 = r5.isEmpty();	 Catch:{ all -> 0x013b }
        if (r0 != 0) goto L_0x0165;
    L_0x0072:
        r0 = f663p;	 Catch:{ all -> 0x013b }
        r0 = r0.keySet();	 Catch:{ all -> 0x013b }
        r8 = r0.iterator();	 Catch:{ all -> 0x013b }
    L_0x007c:
        r0 = r8.hasNext();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x0165;
    L_0x0082:
        r0 = r8.next();	 Catch:{ all -> 0x013b }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x013b }
        r1 = r5.containsKey(r0);	 Catch:{ all -> 0x013b }
        if (r1 == 0) goto L_0x007c;
    L_0x008e:
        r1 = r5.get(r0);	 Catch:{ all -> 0x013b }
        r1 = (java.io.File) r1;	 Catch:{ all -> 0x013b }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x013b }
        r1.setLastModified(r10);	 Catch:{ all -> 0x013b }
        r1 = f663p;	 Catch:{ all -> 0x013b }
        r1 = r1.get(r0);	 Catch:{ all -> 0x013b }
        r1 = (com.chartboost.sdk.C0297b.C0295a) r1;	 Catch:{ all -> 0x013b }
        r2 = r1.f640c;	 Catch:{ all -> 0x013b }
        r9 = "html";
        r2 = r2.equals(r9);	 Catch:{ all -> 0x013b }
        if (r2 == 0) goto L_0x00dd;
    L_0x00ad:
        r2 = com.chartboost.sdk.Libraries.C0278h.C0277a.Html;	 Catch:{ all -> 0x013b }
        r2 = com.chartboost.sdk.Libraries.C0278h.m490a(r2, r0);	 Catch:{ all -> 0x013b }
        r9 = "";
        if (r2 == 0) goto L_0x0156;
    L_0x00b7:
        r9 = r2.exists();	 Catch:{ all -> 0x013b }
        if (r9 == 0) goto L_0x0156;
    L_0x00bd:
        r9 = new java.lang.String;	 Catch:{ all -> 0x013b }
        r10 = f651d;	 Catch:{ all -> 0x013b }
        r2 = r10.m515b(r2);	 Catch:{ all -> 0x013b }
        r10 = java.nio.charset.Charset.defaultCharset();	 Catch:{ all -> 0x013b }
        r9.<init>(r2, r10);	 Catch:{ all -> 0x013b }
        r2 = com.chartboost.sdk.C0297b.m609b(r9);	 Catch:{ all -> 0x013b }
        r9 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x013b }
        if (r9 != 0) goto L_0x014e;
    L_0x00d6:
        r9 = f665r;	 Catch:{ all -> 0x013b }
        r10 = r1.f638a;	 Catch:{ all -> 0x013b }
        r9.put(r10, r2);	 Catch:{ all -> 0x013b }
    L_0x00dd:
        if (r1 == 0) goto L_0x007c;
    L_0x00df:
        r2 = r1.f638a;	 Catch:{ all -> 0x013b }
        r2 = r3.contains(r2);	 Catch:{ all -> 0x013b }
        if (r2 != 0) goto L_0x007c;
    L_0x00e7:
        r2 = r1.f643f;	 Catch:{ Exception -> 0x0120 }
        r9 = r2.iterator();	 Catch:{ Exception -> 0x0120 }
    L_0x00ed:
        r2 = r9.hasNext();	 Catch:{ Exception -> 0x0120 }
        if (r2 == 0) goto L_0x015e;
    L_0x00f3:
        r2 = r9.next();	 Catch:{ Exception -> 0x0120 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0120 }
        r10 = new java.io.File;	 Catch:{ Exception -> 0x0120 }
        r11 = f651d;	 Catch:{ Exception -> 0x0120 }
        r11 = r11.m532s();	 Catch:{ Exception -> 0x0120 }
        r10.<init>(r11, r2);	 Catch:{ Exception -> 0x0120 }
        r2 = r10.exists();	 Catch:{ Exception -> 0x0120 }
        if (r2 != 0) goto L_0x010d;
    L_0x010a:
        r10.mkdir();	 Catch:{ Exception -> 0x0120 }
    L_0x010d:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0120 }
        r2.<init>(r10, r0);	 Catch:{ Exception -> 0x0120 }
        r10 = r1.f642e;	 Catch:{ Exception -> 0x0120 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0120 }
        r10 = r10.getBytes();	 Catch:{ Exception -> 0x0120 }
        com.chartboost.sdk.impl.bv.m1066a(r2, r10);	 Catch:{ Exception -> 0x0120 }
        goto L_0x00ed;
    L_0x0120:
        r1 = move-exception;
        r1 = f650c;	 Catch:{ all -> 0x013b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013b }
        r2.<init>();	 Catch:{ all -> 0x013b }
        r9 = "Error writing asset file log information for";
        r2 = r2.append(r9);	 Catch:{ all -> 0x013b }
        r0 = r2.append(r0);	 Catch:{ all -> 0x013b }
        r0 = r0.toString();	 Catch:{ all -> 0x013b }
        com.chartboost.sdk.Libraries.CBLogging.m381b(r1, r0);	 Catch:{ all -> 0x013b }
        goto L_0x007c;
    L_0x013b:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x013b }
        throw r0;	 Catch:{ Exception -> 0x013e }
    L_0x013e:
        r0 = move-exception;
        r0 = f650c;
        r1 = "Error while syncrhonizing assets";
        com.chartboost.sdk.Libraries.CBLogging.m381b(r0, r1);
    L_0x0146:
        return;
    L_0x0147:
        r0 = com.chartboost.sdk.Libraries.C0278h.m497d(r6);	 Catch:{ all -> 0x013b }
        r3 = r0;
        goto L_0x006a;
    L_0x014e:
        r2 = f650c;	 Catch:{ all -> 0x013b }
        r9 = "Error happened while injection on updating the html file in cache";
        com.chartboost.sdk.Libraries.CBLogging.m381b(r2, r9);	 Catch:{ all -> 0x013b }
        goto L_0x00dd;
    L_0x0156:
        r2 = f650c;	 Catch:{ all -> 0x013b }
        r9 = "Html file path doesn't exist";
        com.chartboost.sdk.Libraries.CBLogging.m381b(r2, r9);	 Catch:{ all -> 0x013b }
        goto L_0x00dd;
    L_0x015e:
        r1 = f663p;	 Catch:{ Exception -> 0x0120 }
        r1.remove(r0);	 Catch:{ Exception -> 0x0120 }
        goto L_0x007c;
    L_0x0165:
        r0 = com.chartboost.sdk.Libraries.C0278h.m503i();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x0170;
    L_0x016b:
        if (r13 == 0) goto L_0x0170;
    L_0x016d:
        com.chartboost.sdk.C0297b.m605a(r5);	 Catch:{ all -> 0x013b }
    L_0x0170:
        r0 = f663p;	 Catch:{ all -> 0x013b }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x013b }
        if (r0 != 0) goto L_0x0220;
    L_0x0178:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x013b }
        r2.<init>();	 Catch:{ all -> 0x013b }
        r0 = f663p;	 Catch:{ all -> 0x013b }
        r0 = r0.entrySet();	 Catch:{ all -> 0x013b }
        r3 = r0.iterator();	 Catch:{ all -> 0x013b }
    L_0x0187:
        r0 = r3.hasNext();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x01ea;
    L_0x018d:
        r0 = r3.next();	 Catch:{ all -> 0x013b }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x013b }
        r0 = r0.getValue();	 Catch:{ all -> 0x013b }
        r0 = (com.chartboost.sdk.C0297b.C0295a) r0;	 Catch:{ all -> 0x013b }
        r1 = f666s;	 Catch:{ all -> 0x013b }
        r5 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1 = r1.containsKey(r5);	 Catch:{ all -> 0x013b }
        if (r1 != 0) goto L_0x01ce;
    L_0x01a3:
        r1 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1 = r2.contains(r1);	 Catch:{ all -> 0x013b }
        if (r1 != 0) goto L_0x01b0;
    L_0x01ab:
        r1 = r0.f638a;	 Catch:{ all -> 0x013b }
        r2.add(r1);	 Catch:{ all -> 0x013b }
    L_0x01b0:
        r1 = f666s;	 Catch:{ all -> 0x013b }
        r5 = r0.f638a;	 Catch:{ all -> 0x013b }
        r8 = 1;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x013b }
        r1.put(r5, r8);	 Catch:{ all -> 0x013b }
        r1 = f665r;	 Catch:{ all -> 0x013b }
        r5 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1 = r1.containsKey(r5);	 Catch:{ all -> 0x013b }
        if (r1 == 0) goto L_0x0187;
    L_0x01c6:
        r1 = f665r;	 Catch:{ all -> 0x013b }
        r0 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1.remove(r0);	 Catch:{ all -> 0x013b }
        goto L_0x0187;
    L_0x01ce:
        r1 = f666s;	 Catch:{ all -> 0x013b }
        r5 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1 = r1.get(r5);	 Catch:{ all -> 0x013b }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x013b }
        r1 = r1.intValue();	 Catch:{ all -> 0x013b }
        r1 = r1 + 1;
        r5 = f666s;	 Catch:{ all -> 0x013b }
        r0 = r0.f638a;	 Catch:{ all -> 0x013b }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x013b }
        r5.put(r0, r1);	 Catch:{ all -> 0x013b }
        goto L_0x0187;
    L_0x01ea:
        r0 = com.chartboost.sdk.Libraries.C0278h.m503i();	 Catch:{ all -> 0x013b }
        if (r0 == 0) goto L_0x0223;
    L_0x01f0:
        r0 = f650c;	 Catch:{ all -> 0x013b }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013b }
        r1.<init>();	 Catch:{ all -> 0x013b }
        r3 = "##### Serializing blacklist ad id to ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x013b }
        r1 = r1.append(r7);	 Catch:{ all -> 0x013b }
        r1 = r1.toString();	 Catch:{ all -> 0x013b }
        com.chartboost.sdk.Libraries.CBLogging.m387e(r0, r1);	 Catch:{ all -> 0x013b }
        r0 = 1;
        com.chartboost.sdk.Libraries.C0278h.m493a(r2, r7, r0);	 Catch:{ all -> 0x013b }
    L_0x020c:
        r0 = com.chartboost.sdk.C0297b.C0296b.kCBInProgress;	 Catch:{ all -> 0x013b }
        f654g = r0;	 Catch:{ all -> 0x013b }
        r0 = f656i;	 Catch:{ all -> 0x013b }
        r1 = f663p;	 Catch:{ all -> 0x013b }
        r1 = r1.size();	 Catch:{ all -> 0x013b }
        r0.set(r1);	 Catch:{ all -> 0x013b }
        r0 = f663p;	 Catch:{ all -> 0x013b }
        com.chartboost.sdk.C0297b.m612b(r0);	 Catch:{ all -> 0x013b }
    L_0x0220:
        monitor-exit(r4);	 Catch:{ all -> 0x013b }
        goto L_0x0146;
    L_0x0223:
        r0 = f650c;	 Catch:{ all -> 0x013b }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013b }
        r1.<init>();	 Catch:{ all -> 0x013b }
        r3 = "##### Serializing blacklist ad id to ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x013b }
        r1 = r1.append(r6);	 Catch:{ all -> 0x013b }
        r1 = r1.toString();	 Catch:{ all -> 0x013b }
        com.chartboost.sdk.Libraries.CBLogging.m387e(r0, r1);	 Catch:{ all -> 0x013b }
        r0 = 1;
        com.chartboost.sdk.Libraries.C0278h.m493a(r2, r6, r0);	 Catch:{ all -> 0x013b }
        goto L_0x020c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.b.a(com.chartboost.sdk.Libraries.e$a, boolean):void");
    }

    private static long m599a(ConcurrentHashMap<String, C0295a> concurrentHashMap) {
        long j = 0;
        int i = 0;
        for (Entry entry : concurrentHashMap.entrySet()) {
            int i2;
            long j2;
            if (!((C0295a) entry.getValue()).f640c.equals("media")) {
                i2 = i;
                j2 = j + 15000;
            } else if (((C0295a) entry.getValue()).f639b.contains("mp4")) {
                i2 = 1255000 + i;
                j2 = j;
            } else {
                i2 = 125000 + i;
                j2 = j;
            }
            j = j2;
            i = i2;
        }
        return j;
    }

    private static synchronized void m612b(ConcurrentHashMap<String, C0295a> concurrentHashMap) {
        synchronized (C0297b.class) {
            for (C0295a c0295a : concurrentHashMap.values()) {
                C1206d c1206d = new C1206d();
                C0415l c1205c = new C1205c(0, c0295a.f641d, c1206d, c0295a.f639b, c0295a);
                c1206d.f4014a = c1205c;
                c1205c.m1089a((Object) Integer.valueOf(f649b.hashCode()));
                c1205c.m1088a(new C1244d(30000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                f652e.m1119a(c1205c);
                C1203a.m4358a(c0295a.f641d, c0295a.f639b);
                CBLogging.m379a(f650c, "Downloading Asset:" + c0295a.f641d);
            }
        }
    }

    private static String m609b(String str) {
        if (f664q.isEmpty() || str.isEmpty()) {
            return null;
        }
        for (Entry value : f664q.entrySet()) {
            JSONArray jSONArray = (JSONArray) value.getValue();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        C0295a c0295a = (C0295a) jSONArray.get(i);
                        String str2 = c0295a.f639b;
                        str = str.replaceAll(Pattern.quote(str2), c0295a.f641d);
                    } catch (Exception e) {
                        e.printStackTrace();
                        CBLogging.m381b(f650c, "Error while injecting values into the html");
                    }
                }
            }
        }
        if (!str.contains("{{") && !str.contains("}}")) {
            return str;
        }
        CBLogging.m381b(f650c, " Html data still contains mustache injection values, cannot load the web view ad");
        return null;
    }

    public static synchronized C0269a m600a(boolean z) {
        C0269a a;
        synchronized (C0297b.class) {
            Object jSONArray = new JSONArray();
            try {
                if (f665r.isEmpty() && z) {
                    C0297b.m613c();
                    C0297b.m604a(null, true);
                }
                if (!f665r.isEmpty()) {
                    for (String str : f665r.keySet()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", str);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            CBLogging.m381b(f650c, "getAvailableAdIdList(): Error while loading ad id into json array");
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a = C0269a.m426a(jSONArray);
        }
        return a;
    }

    public static ConcurrentHashMap<String, String> m614d() {
        return f665r;
    }

    public static C0269a m607b(boolean z) {
        Object jSONArray = new JSONArray();
        Object jSONArray2 = new JSONArray();
        File t = f651d.m533t();
        File u = f651d.m534u();
        File s = f651d.m532s();
        ArrayList d;
        if (C0278h.m503i()) {
            d = C0278h.m497d(u);
        } else {
            d = C0278h.m497d(t);
        }
        if (s != null) {
            File[] listFiles = s.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File t2 : listFiles) {
                    try {
                        if (t2.isDirectory()) {
                            C0269a a = C0269a.m425a();
                            C0269a a2 = C0269a.m425a();
                            JSONArray jSONArray3 = new JSONArray();
                            String name = t2.getName();
                            if (TextUtils.isEmpty(name) || r2.contains(name)) {
                                CBLogging.m381b(f650c, "Black list Ad id found: " + name);
                            } else {
                                a2.m432a("id", name);
                                jSONArray2.put(a2.m443e());
                                String[] list = t2.list();
                                if (list != null && list.length > 0) {
                                    File file = new File(s, name);
                                    for (String file2 : list) {
                                        byte[] b = f651d.m515b(new File(file, file2));
                                        if (b != null) {
                                            jSONArray3.put(C0269a.m427k(new String(b)).m443e());
                                        }
                                    }
                                    if (jSONArray3.length() > 0) {
                                        a.m432a("id", name);
                                        a.m432a("elements", jSONArray3);
                                        jSONArray.put(a.m443e());
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        CBLogging.m381b(f650c, e.getMessage());
                    }
                }
            }
        }
        f667t = C0269a.m426a(jSONArray);
        f668u = C0269a.m426a(jSONArray2);
        if (z) {
            return f667t;
        }
        return f668u;
    }

    public static synchronized void m615e() {
        synchronized (C0297b.class) {
            if (f649b != null) {
                f652e.m1122a(Integer.valueOf(f649b.hashCode()));
            }
        }
    }

    public static boolean m606a(C0269a c0269a) {
        if (c0269a == null || c0269a.m458o() == 0) {
            return false;
        }
        CharSequence e = c0269a.m442e("ad_unit_id");
        if (TextUtils.isEmpty(e)) {
            CBLogging.m381b(f650c, "Cannot find ad_unit_id. ad_unit_id is empty or null in the response");
            return false;
        } else if (!f665r.containsKey(e)) {
            return false;
        } else {
            CBLogging.m379a(f650c, "Found the ad id in the html mapping object.");
            return true;
        }
    }

    public static synchronized boolean m616f() {
        boolean z;
        synchronized (C0297b.class) {
            if (f653f == C0296b.kCBInProgress || f654g == C0296b.kCBInProgress) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private static void m625o() {
        C0297b.m607b(true);
        Iterator it;
        C0291a c0291a;
        if (f668u.m438c() && f668u.m458o() > 0 && f648a.size() > 0) {
            it = f648a.iterator();
            while (it.hasNext()) {
                c0291a = (C0291a) it.next();
                CBUtility.m400e().post(new C02942(c0291a));
                f648a.remove(c0291a);
            }
        } else if (f648a.size() > 0) {
            it = f648a.iterator();
            while (it.hasNext()) {
                c0291a = (C0291a) it.next();
                c0291a.m590u().m710a(c0291a, CBImpressionError.EMPTY_LOCAL_AD_LIST);
            }
            f648a.clear();
        }
    }

    private static synchronized void m605a(HashMap<String, File> hashMap) {
        synchronized (C0297b.class) {
            ArrayList arrayList = new ArrayList(hashMap.values());
            ArrayList arrayList2 = new ArrayList();
            if (!arrayList.isEmpty()) {
                long a = C0297b.m599a(f663p);
                f659l = C0278h.m504w();
                f660m = C0278h.m505x();
                CBLogging.m379a(f650c, "Total local file count:" + arrayList.size());
                CBLogging.m379a(f650c, "Total max cache size available :" + Long.toString(f659l));
                CBLogging.m379a(f650c, "Total space occupied:" + Long.toString(f660m));
                CBLogging.m379a(f650c, "Estimated Cache Size needed:" + Long.toString(a));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    if (C0278h.m494a(file, f661n) || f659l < a) {
                        a -= file.length();
                        CBLogging.m379a(f650c, "Deleting file at path:" + file.getPath());
                        file.delete();
                        File s = f651d.m532s();
                        if (s != null) {
                            File[] listFiles = s.listFiles();
                            if (listFiles != null && listFiles.length > 0) {
                                for (File s2 : listFiles) {
                                    arrayList2.add(s2.getName());
                                    if (f665r.containsKey(arrayList2)) {
                                        f665r.remove(arrayList2);
                                    }
                                    File[] listFiles2 = s2.listFiles();
                                    if (listFiles2 != null && listFiles2.length > 0) {
                                        for (File file2 : listFiles2) {
                                            if (file2.getName().equalsIgnoreCase(file.getName().split("\\.(?=[^\\.]+$)")[0])) {
                                                CBLogging.m379a(f650c, "Deleting log file info:" + file2);
                                                file2.delete();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    a = a;
                }
            }
            if (C0278h.m503i()) {
                C0278h.m493a(arrayList2, f651d.m534u(), true);
            } else {
                C0278h.m493a(arrayList2, f651d.m533t(), true);
            }
        }
    }
}
