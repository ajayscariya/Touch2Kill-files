package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0276g.C0275k;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.C0420n.C0418a;
import com.chartboost.sdk.impl.az.C0347c;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

public class be {
    public static be f948a;
    private static final String f949b;
    private static C0278h f950c;
    private static C0417m f951d;
    private static ConcurrentHashMap<Integer, C1240b> f952e;
    private static C0366a f953f;
    private static C0366a f954g;
    private static AtomicInteger f955h;
    private static AtomicInteger f956i;
    private static boolean f957j;
    private static boolean f958k;
    private static Observer f959l;
    private static C0347c f960m;

    /* renamed from: com.chartboost.sdk.impl.be.1 */
    static class C03651 implements Observer {
        C03651() {
        }

        public void update(Observable observable, Object data) {
            be.m984l();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.a */
    public enum C0366a {
        kCBIntial,
        kCBInProgress
    }

    /* renamed from: com.chartboost.sdk.impl.be.2 */
    static class C12392 implements C0347c {
        C12392() {
        }

        public void m4583a(C0269a c0269a, az azVar) {
            try {
                synchronized (be.class) {
                    be.f953f = C0366a.kCBIntial;
                    if (c0269a.m438c()) {
                        CBLogging.m379a(be.f949b, "Got Video list from server :)" + c0269a);
                        be.m967a(c0269a.m431a("videos"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void m4584a(C0269a c0269a, az azVar, CBError cBError) {
            be.f953f = C0366a.kCBIntial;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.b */
    private static class C1240b extends C0415l<Object> {
        private String f4146a;
        private long f4147b;
        private String f4148c;

        public C1240b(int i, String str, C1241c c1241c, String str2) {
            super(i, str, c1241c);
            this.f4146a = str2;
            this.f4148c = str;
            this.f4147b = System.currentTimeMillis();
        }

        protected void m4588b(Object obj) {
        }

        protected C0420n<Object> m4587a(C0412i c0412i) {
            if (c0412i != null) {
                Long.valueOf((System.currentTimeMillis() - this.f4147b) / 1000);
                CBLogging.m379a(be.f949b, "Video download Success. Storing video in cache" + this.f4146a);
                be.f950c.m512a(be.f950c.m523j(), this.f4146a, c0412i.f1101b);
            }
            synchronized (be.m965a()) {
                if (be.f955h.get() == be.f956i.get()) {
                    be.f955h.set(0);
                    be.f956i.set(0);
                    be.f954g = C0366a.kCBIntial;
                    be.f952e.clear();
                }
            }
            return C0420n.m1130a(null, null);
        }

        public C0414a m4589s() {
            return C0414a.LOW;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.be.c */
    private static class C1241c implements C0418a {
        private C1240b f4149a;

        private C1241c() {
        }

        public void m4591a(C0423s c0423s) {
            if ((c0423s instanceof C1250r) || (c0423s instanceof C1249q) || (c0423s instanceof C1246h)) {
                if (this.f4149a != null) {
                    Long.valueOf((System.currentTimeMillis() - this.f4149a.f4147b) / 1000);
                }
                be.f952e.put(Integer.valueOf(this.f4149a.hashCode()), this.f4149a);
                CBLogging.m381b(be.f949b, "Error downloading video " + c0423s.getMessage() + this.f4149a.f4146a);
            }
        }
    }

    static {
        f949b = be.class.getSimpleName();
        f955h = new AtomicInteger();
        f956i = new AtomicInteger();
        f957j = true;
        f958k = false;
        f959l = new C03651();
        f960m = new C12392();
    }

    private be() {
    }

    public static synchronized be m965a() {
        be beVar;
        synchronized (be.class) {
            if (f948a == null) {
                f948a = new be();
                m983k();
            }
            beVar = f948a;
        }
        return beVar;
    }

    private static synchronized void m983k() {
        synchronized (be.class) {
            if (!f958k) {
                f958k = true;
                f950c = new C0278h(true);
                f952e = new ConcurrentHashMap();
                f953f = C0366a.kCBIntial;
                f954g = C0366a.kCBIntial;
                f951d = ba.m914a(C0299c.m682y()).m927a();
                ay.m847a().addObserver(f959l);
            }
        }
    }

    public static synchronized void m972b() {
        synchronized (be.class) {
            if (!f958k) {
                m983k();
            }
            if (C0299c.m681x()) {
                CBLogging.m379a(f949b, "Prefetching the Video list");
                if (!(C0366a.kCBInProgress == f953f || C0366a.kCBInProgress == f954g)) {
                    if (!(f952e == null || f952e.isEmpty())) {
                        f952e.clear();
                        f951d.m1122a(Integer.valueOf(f959l.hashCode()));
                        f954g = C0366a.kCBIntial;
                        CBLogging.m379a(f949b, "prefetchVideo: Clearing all volley request for new start");
                    }
                    f953f = C0366a.kCBInProgress;
                    Object jSONArray = new JSONArray();
                    if (m975c() != null) {
                        for (Object put : m975c()) {
                            jSONArray.put(put);
                        }
                    }
                    f956i.set(0);
                    f955h.set(0);
                    az azVar = new az("/api/video-prefetch");
                    azVar.m869a("local-videos", jSONArray);
                    C0275k[] c0275kArr = new C0275k[2];
                    c0275kArr[0] = C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a);
                    c0275kArr[1] = C0276g.m482a("videos", C0276g.m484b(C0276g.m480a(C0276g.m482a("video", C0276g.m477a(C0276g.m476a())), C0276g.m482a("id", C0276g.m476a()))));
                    azVar.m863a(C0276g.m480a(c0275kArr));
                    azVar.m875b(true);
                    azVar.m864a(f960m);
                }
            }
        }
    }

    public static synchronized void m967a(C0269a c0269a) {
        synchronized (be.class) {
            if (C0299c.m681x()) {
                if (c0269a.m438c()) {
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    String[] c = m975c();
                    for (int i = 0; i < c0269a.m458o(); i++) {
                        C0269a c2 = c0269a.m437c(i);
                        if (!(c2.m436b("id") || c2.m436b("video"))) {
                            String e = c2.m442e("id");
                            CharSequence e2 = c2.m442e("video");
                            if (!(f950c.m514b(e) || TextUtils.isEmpty(e) || TextUtils.isEmpty(e2) || hashMap2.get(e) != null)) {
                                hashMap2.put(e, e2);
                                f956i.incrementAndGet();
                            }
                            hashMap.put(e, e2);
                        }
                    }
                    if (f957j) {
                        f957j = false;
                    }
                    CBLogging.m379a(f949b, "Synchronizing videos with the list got from the server");
                    m969a(hashMap, c);
                    if (!hashMap2.isEmpty()) {
                        m968a(hashMap2);
                        f954g = C0366a.kCBInProgress;
                    }
                }
            }
        }
    }

    private static synchronized void m969a(HashMap<String, String> hashMap, String[] strArr) {
        synchronized (be.class) {
            if (!(hashMap == null || strArr == null)) {
                for (String str : strArr) {
                    if (!hashMap.containsKey(str)) {
                        File c = f950c.m516c(f950c.m523j(), str);
                        if (!(c == null || str.equals(".nomedia"))) {
                            CBLogging.m387e(f949b, "Deleting video: " + c.getAbsolutePath());
                            f950c.m520e(c);
                        }
                    }
                }
            }
        }
    }

    private static synchronized void m968a(HashMap<String, String> hashMap) {
        synchronized (be.class) {
            for (String str : hashMap.keySet()) {
                C1241c c1241c = new C1241c();
                C0415l c1240b = new C1240b(0, (String) hashMap.get(str), c1241c, str);
                c1240b.m1088a(new C1244d(30000, 0, 0.0f));
                c1241c.f4149a = c1240b;
                c1240b.m1089a((Object) Integer.valueOf(f959l.hashCode()));
                f951d.m1119a(c1240b);
                CBLogging.m379a(f949b, "Downloading video:" + ((String) hashMap.get(str)));
            }
        }
    }

    public static String[] m975c() {
        if (f950c == null) {
            return null;
        }
        return f950c.m518c(f950c.m523j());
    }

    public static synchronized void m976d() {
        synchronized (be.class) {
            f951d.m1122a(Integer.valueOf(f959l.hashCode()));
        }
    }

    public static String m966a(String str) {
        if (f950c.m519d(str)) {
            return f950c.m516c(f950c.m523j(), str).getPath();
        }
        return null;
    }

    public static String m971b(C0269a c0269a) {
        if (c0269a == null) {
            return null;
        }
        C0269a a = c0269a.m431a("assets");
        if (a.m435b()) {
            return null;
        }
        C0269a a2 = a.m431a(CBUtility.m397c().m469a() ? "video-portrait" : "video-landscape");
        if (a2.m435b()) {
            return null;
        }
        String e = a2.m442e("id");
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        return m966a(e);
    }

    public static void m973b(String str) {
        if (f950c.m514b(str)) {
            f950c.m513b(f950c.m523j(), str);
        }
    }

    public static boolean m974c(C0269a c0269a) {
        return !TextUtils.isEmpty(m971b(c0269a));
    }

    private static synchronized void m984l() {
        synchronized (be.class) {
            CBLogging.m379a(f949b, "Process Request called");
            if (!(f953f == C0366a.kCBInProgress || f954g == C0366a.kCBInProgress)) {
                if ((f954g == C0366a.kCBIntial && f952e != null) || f952e.size() > 0) {
                    for (Integer num : f952e.keySet()) {
                        f954g = C0366a.kCBInProgress;
                        f951d.m1119a((C0415l) f952e.get(num));
                        f952e.remove(num);
                    }
                }
            }
        }
    }
}
