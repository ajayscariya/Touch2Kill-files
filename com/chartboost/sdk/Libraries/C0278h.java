package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.impl.bv;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import mf.org.apache.xml.serialize.Method;

/* renamed from: com.chartboost.sdk.Libraries.h */
public class C0278h {
    private static long f511A;
    private static String[] f512B;
    private static long f513C;
    private static String[] f514D;
    private static long f515E;
    private static String[] f516F;
    private static String[] f517G;
    private static long f518H;
    private static String[] f519I;
    private static File f520a;
    private static File f521b;
    private static File f522c;
    private static File f523d;
    private static File f524e;
    private static File f525f;
    private static File f526g;
    private static File f527h;
    private static File f528i;
    private static File f529j;
    private static File f530k;
    private static File f531l;
    private static File f532m;
    private static File f533n;
    private static File f534o;
    private static File f535p;
    private static File f536q;
    private static File f537r;
    private static File f538s;
    private static File f539t;
    private static File f540u;
    private static Context f541v;
    private static File f542w;
    private static File f543x;
    private static File f544y;
    private static File f545z;
    private boolean f546J;

    /* renamed from: com.chartboost.sdk.Libraries.h.a */
    public enum C0277a {
        Media("media"),
        AssetFileLog("asset_log"),
        Videos("videos"),
        Images("images"),
        StyleSheets("css"),
        Javascript("js"),
        Html(Method.HTML),
        VideoCompletion("videoCompletionEvents"),
        Session("session"),
        Track("track"),
        RequestManager("requests");
        
        private final String f510l;

        private C0277a(String str) {
            this.f510l = str;
        }

        public String toString() {
            return this.f510l;
        }
    }

    public C0278h(boolean z) {
        this.f546J = false;
        f541v = C0299c.m682y();
        if (f541v == null) {
            CBLogging.m381b("CBFileCache", "RunTime error: Cannot find context object");
            return;
        }
        this.f546J = z;
        m491a(z);
    }

    private File m491a(boolean z) {
        if (m535v() != null) {
            return f520a;
        }
        File file = new File(f541v.getCacheDir(), ".chartboost");
        f540u = file;
        f522c = file;
        file = new File(Environment.getExternalStorageDirectory(), ".chartboost");
        f539t = file;
        f521b = file;
        if (!f522c.exists()) {
            f522c.mkdirs();
        }
        if (!f521b.exists()) {
            f521b.mkdirs();
        }
        if (C0299c.m645a()) {
            f520a = f522c;
        } else {
            f520a = f521b;
        }
        if (!z) {
            f520a = f522c;
        }
        f532m = new File(f522c, C0277a.AssetFileLog.toString());
        f532m = new File(f532m, C0299c.m659e());
        if (!f532m.exists()) {
            f532m.mkdir();
        }
        f531l = new File(f521b, C0277a.AssetFileLog.toString());
        f531l = new File(f531l, C0299c.m659e());
        if (!f531l.exists()) {
            f531l.mkdir();
        }
        f524e = new File(f522c, C0277a.Videos.toString());
        if (!f524e.exists()) {
            f524e.mkdir();
        }
        f523d = new File(f521b, C0277a.Videos.toString());
        if (!f523d.exists()) {
            f523d.mkdir();
        }
        f528i = new File(f522c, C0277a.StyleSheets.toString());
        if (!f528i.exists()) {
            f528i.mkdir();
        }
        f527h = new File(f521b, C0277a.StyleSheets.toString());
        if (!f527h.exists()) {
            f527h.mkdir();
        }
        f526g = new File(f522c, C0277a.Media.toString());
        if (!f526g.exists()) {
            f526g.mkdir();
        }
        f525f = new File(f521b, C0277a.Media.toString());
        if (!f525f.exists()) {
            f525f.mkdir();
        }
        f530k = new File(f522c, C0277a.Javascript.toString());
        if (!f530k.exists()) {
            f530k.mkdir();
        }
        f529j = new File(f521b, C0277a.Javascript.toString());
        if (!f529j.exists()) {
            f529j.mkdir();
        }
        f534o = new File(f522c, C0277a.Html.toString());
        if (!f534o.exists()) {
            f534o.mkdir();
        }
        f533n = new File(f521b, C0277a.Html.toString());
        if (!f533n.exists()) {
            f533n.mkdir();
        }
        f538s = new File(f522c, C0277a.Images.toString());
        if (!f538s.exists()) {
            f538s.mkdir();
        }
        f537r = new File(f521b, C0277a.Images.toString());
        if (!f537r.exists()) {
            f537r.mkdir();
        }
        f535p = new File(f521b, ".adId");
        f536q = new File(f522c, ".adId");
        f542w = new File(f540u, C0277a.VideoCompletion.toString());
        f543x = new File(f540u, C0277a.RequestManager.toString());
        f545z = new File(f540u, C0277a.Track.toString());
        f544y = new File(f540u, C0277a.Session.toString());
        return f520a;
    }

    public static File m489a() {
        if (C0278h.m503i()) {
            return f539t;
        }
        return f540u;
    }

    public synchronized File m510a(File file, String str, C0269a c0269a) {
        File file2;
        file2 = null;
        if (file != null) {
            if (!TextUtils.isEmpty(str)) {
                file2 = new File(file.getPath(), str);
            }
            file2 = m509a(file, file2, c0269a);
        }
        return file2;
    }

    public synchronized File m509a(File file, File file2, C0269a c0269a) {
        File file3;
        if (file == null) {
            file3 = null;
        } else {
            if (file2 == null) {
                file3 = new File(file.getPath(), Long.toString(System.nanoTime()));
            } else {
                file3 = file2;
            }
            try {
                bv.m1066a(file3, c0269a.toString().getBytes());
            } catch (Throwable e) {
                CBLogging.m382b("CBFileCache", "IOException attempting to write cache to disk", e);
            }
        }
        return file3;
    }

    public synchronized void m512a(File file, String str, byte[] bArr) {
        if (file != null) {
            File file2 = null;
            if (!TextUtils.isEmpty(str)) {
                file2 = new File(file.getPath(), str);
            }
            m511a(file, file2, bArr);
        }
    }

    public synchronized void m511a(File file, File file2, byte[] bArr) {
        if (!(file == null || bArr == null)) {
            if (file2 == null) {
                file2 = new File(file.getPath(), Long.toString(System.nanoTime()));
            }
            try {
                bv.m1066a(file2, bArr);
            } catch (Throwable e) {
                CBLogging.m382b("CBFileCache", "IOException attempting to write cache to disk", e);
            }
        }
    }

    public synchronized C0269a m508a(File file, String str) {
        C0269a c0269a;
        if (m535v() == null || str == null) {
            c0269a = C0269a.f470a;
        } else {
            File file2 = new File(file, str);
            if (file2.exists()) {
                c0269a = m507a(file2);
            } else {
                c0269a = C0269a.f470a;
            }
        }
        return c0269a;
    }

    public synchronized C0269a m507a(File file) {
        C0269a c0269a;
        if (m535v() == null) {
            c0269a = C0269a.f470a;
        } else {
            String str;
            try {
                str = new String(bv.m1068b(file));
            } catch (Throwable e) {
                CBLogging.m382b("CBFileCache", "Error loading cache from disk", e);
                str = null;
            }
            c0269a = C0269a.m427k(str);
        }
        return c0269a;
    }

    public synchronized byte[] m515b(File file) {
        byte[] bArr = null;
        synchronized (this) {
            if (file != null) {
                try {
                    bArr = bv.m1068b(file);
                } catch (Throwable e) {
                    CBLogging.m382b("CBFileCache", "Error loading cache from disk", e);
                }
            }
        }
        return bArr;
    }

    public synchronized String[] m518c(File file) {
        String[] strArr;
        if (file == null) {
            strArr = null;
        } else {
            strArr = file.list();
        }
        return strArr;
    }

    public static synchronized HashMap<String, File> m495b() {
        HashMap<String, File> hashMap;
        int i = 0;
        synchronized (C0278h.class) {
            String[] g = C0278h.m502g();
            String[] f = C0278h.m500f();
            String[] e = C0278h.m499e();
            String[] c = C0278h.m496c();
            hashMap = new HashMap();
            if (f520a != null) {
                File file;
                if (g != null) {
                    if (g.length > 0) {
                        if (C0278h.m503i()) {
                            file = f525f;
                        } else {
                            file = f526g;
                        }
                        for (String str : g) {
                            if (!str.equals(".nomedia")) {
                                hashMap.put(str, new File(file, str));
                            }
                        }
                    }
                }
                if (f != null && f.length > 0) {
                    if (C0278h.m503i()) {
                        file = f529j;
                    } else {
                        file = f530k;
                    }
                    for (String str2 : f) {
                        if (!str2.equals(".nomedia")) {
                            hashMap.put(str2, new File(file, str2));
                        }
                    }
                }
                if (e != null && e.length > 0) {
                    if (C0278h.m503i()) {
                        file = f527h;
                    } else {
                        file = f528i;
                    }
                    for (String str3 : e) {
                        if (!str3.equals(".nomedia")) {
                            hashMap.put(str3, new File(file, str3));
                        }
                    }
                }
                if (c != null && c.length > 0) {
                    File file2;
                    if (C0278h.m503i()) {
                        file2 = f533n;
                    } else {
                        file2 = f534o;
                    }
                    int length = c.length;
                    while (i < length) {
                        String str4 = c[i];
                        if (!str4.equals(".nomedia")) {
                            hashMap.put(str4, new File(file2, str4));
                        }
                        i++;
                    }
                }
            }
        }
        return hashMap;
    }

    public static synchronized String[] m496c() {
        String[] strArr;
        synchronized (C0278h.class) {
            if (f520a == null) {
                strArr = null;
            } else {
                File file;
                if (C0278h.m503i()) {
                    file = f533n;
                } else {
                    file = f534o;
                }
                if (file.lastModified() > f518H) {
                    f519I = file.list();
                    f518H = file.lastModified();
                }
                strArr = f519I;
            }
        }
        return strArr;
    }

    public static synchronized String[] m498d() {
        String[] strArr = null;
        synchronized (C0278h.class) {
            if (f520a != null) {
                File file;
                if (C0278h.m503i()) {
                    file = f523d;
                } else {
                    file = f524e;
                }
                if (file != null) {
                    f517G = file.list();
                }
                if (!(f517G == null || f517G.length == 0)) {
                    strArr = f517G;
                }
            }
        }
        return strArr;
    }

    public static synchronized String[] m499e() {
        String[] strArr;
        synchronized (C0278h.class) {
            if (f520a == null) {
                strArr = null;
            } else {
                File file;
                if (C0278h.m503i()) {
                    file = f527h;
                } else {
                    file = f528i;
                }
                if (file.lastModified() > f515E) {
                    f516F = file.list();
                    f515E = file.lastModified();
                }
                strArr = f516F;
            }
        }
        return strArr;
    }

    public static String m492a(String str) {
        if (f520a == null) {
            return null;
        }
        File file;
        if (C0278h.m503i()) {
            file = f523d;
        } else {
            file = f524e;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            return file2.getPath();
        }
        return null;
    }

    public static synchronized String[] m500f() {
        String[] strArr;
        synchronized (C0278h.class) {
            if (f520a == null) {
                strArr = null;
            } else {
                File file;
                if (C0278h.m503i()) {
                    file = f529j;
                } else {
                    file = f530k;
                }
                if (file.lastModified() > f513C) {
                    f514D = file.list();
                    f513C = file.lastModified();
                }
                strArr = f514D;
            }
        }
        return strArr;
    }

    public static synchronized String[] m502g() {
        String[] strArr;
        synchronized (C0278h.class) {
            if (f520a == null) {
                strArr = null;
            } else {
                File file;
                if (C0278h.m503i()) {
                    file = f525f;
                } else {
                    file = f526g;
                }
                if (file.lastModified() > f511A) {
                    f512B = file.list();
                    f511A = file.lastModified();
                }
                strArr = f512B;
            }
        }
        return strArr;
    }

    public static synchronized void m493a(ArrayList<String> arrayList, File file, boolean z) {
        IOException e;
        FileOutputStream fileOutputStream = null;
        synchronized (C0278h.class) {
            if (!(file == null || arrayList == null)) {
                if (z) {
                    ArrayList<String> d = C0278h.m497d(file);
                    if (d.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (!d.contains(str)) {
                                d.add(str);
                            }
                        }
                        arrayList = d;
                    }
                }
                ObjectOutputStream objectOutputStream;
                try {
                    OutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                        try {
                            objectOutputStream.writeObject(arrayList);
                            objectOutputStream.close();
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    e.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            e.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        objectOutputStream = null;
                        OutputStream outputStream = fileOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        e.printStackTrace();
                    }
                } catch (IOException e5) {
                    e = e5;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.ArrayList<java.lang.String> m497d(java.io.File r7) {
        /*
        r3 = 0;
        r5 = com.chartboost.sdk.Libraries.C0278h.class;
        monitor-enter(r5);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x003b }
        r1.<init>();	 Catch:{ all -> 0x003b }
        if (r7 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r7.exists();	 Catch:{ all -> 0x003b }
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        monitor-exit(r5);
        return r0;
    L_0x0014:
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x004d, ClassNotFoundException -> 0x0043 }
        r4.<init>(r7);	 Catch:{ IOException -> 0x004d, ClassNotFoundException -> 0x0043 }
        r2 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0053, ClassNotFoundException -> 0x0043 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x0053, ClassNotFoundException -> 0x0043 }
        r0 = r2.readObject();	 Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x0043 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x0043 }
        r2.close();	 Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x004b }
        r4.close();	 Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x004b }
        goto L_0x0012;
    L_0x002b:
        r1 = move-exception;
        r3 = r4;
    L_0x002d:
        if (r2 == 0) goto L_0x0032;
    L_0x002f:
        r2.close();	 Catch:{ IOException -> 0x003e }
    L_0x0032:
        if (r3 == 0) goto L_0x0037;
    L_0x0034:
        r3.close();	 Catch:{ IOException -> 0x003e }
    L_0x0037:
        r1.printStackTrace();	 Catch:{ all -> 0x003b }
        goto L_0x0012;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x003e:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x003b }
        goto L_0x0037;
    L_0x0043:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x0047:
        r1.printStackTrace();	 Catch:{ all -> 0x003b }
        goto L_0x0012;
    L_0x004b:
        r1 = move-exception;
        goto L_0x0047;
    L_0x004d:
        r0 = move-exception;
        r2 = r3;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x002d;
    L_0x0053:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x002d;
    L_0x005a:
        r0 = move-exception;
        r3 = r4;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Libraries.h.d(java.io.File):java.util.ArrayList<java.lang.String>");
    }

    public synchronized void m520e(File file) {
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public synchronized void m513b(File file, String str) {
        if (file != null) {
            if (!TextUtils.isEmpty(str)) {
                m520e(m516c(file, str));
            }
        }
    }

    public synchronized void m522h() {
        int i = 0;
        synchronized (this) {
            if (f520a != null) {
                try {
                    if (f521b != null) {
                        File[] listFiles = f521b.listFiles();
                        if (listFiles != null) {
                            for (File delete : listFiles) {
                                delete.delete();
                            }
                        }
                    }
                    if (f522c != null) {
                        File[] listFiles2 = f522c.listFiles();
                        if (listFiles2 != null) {
                            int length = listFiles2.length;
                            while (i < length) {
                                listFiles2[i].delete();
                                i++;
                            }
                        }
                    }
                } catch (Exception e) {
                    CBLogging.m381b("CBFileCache", "Error while clearing the file cache");
                }
            }
        }
    }

    public synchronized void m521f(File file) {
        if (!(file == null || file == null)) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            } catch (Exception e) {
                CBLogging.m381b("CBFileCache", "Error while clearing the file cache");
            }
        }
    }

    public static boolean m503i() {
        if (Environment.getExternalStorageState().equals("mounted") && !C0299c.m645a()) {
            return true;
        }
        CBLogging.m387e("CBFileCache", "External Storage unavailable");
        return false;
    }

    public boolean m514b(String str) {
        if (m535v() == null || str == null) {
            return false;
        }
        return new File(f520a.getPath(), str).exists();
    }

    public boolean m517c(String str) {
        if (m531r() == null || str == null) {
            return false;
        }
        return new File(m531r(), str).exists();
    }

    public boolean m519d(String str) {
        if (m523j() == null || str == null) {
            return false;
        }
        return new File(m523j(), str).exists();
    }

    public File m516c(File file, String str) {
        if (file == null) {
            return null;
        }
        return new File(file.getPath(), str);
    }

    public static File m490a(C0277a c0277a, String str) {
        if (c0277a == null || TextUtils.isEmpty(str)) {
            CBLogging.m381b("CBFileCache", "Invalid directory or filename passed");
            return null;
        }
        Object obj;
        if (C0278h.m503i()) {
            obj = 1;
        } else {
            obj = null;
        }
        File file;
        if (c0277a == C0277a.StyleSheets) {
            if (obj != null) {
                file = f527h;
            } else {
                file = f528i;
            }
            return new File(file, str);
        } else if (c0277a == C0277a.Javascript) {
            if (obj != null) {
                file = f529j;
            } else {
                file = f530k;
            }
            return new File(file, str);
        } else if (c0277a == C0277a.Media) {
            if (obj != null) {
                file = f525f;
            } else {
                file = f526g;
            }
            return new File(file, str);
        } else if (c0277a == C0277a.Videos) {
            if (obj != null) {
                file = f523d;
            } else {
                file = f524e;
            }
            return new File(file, str);
        } else if (c0277a != C0277a.Html) {
            return null;
        } else {
            if (obj != null) {
                file = f533n;
            } else {
                file = f534o;
            }
            return new File(file, str);
        }
    }

    public File m523j() {
        System.out.println(this.f546J);
        System.out.println(!C0299c.m645a());
        System.out.println(f523d);
        System.out.println(f524e);
        if (!this.f546J || C0299c.m645a()) {
            return f524e;
        }
        return f523d;
    }

    public File m524k() {
        if (!this.f546J || C0299c.m645a()) {
            return f528i;
        }
        return f527h;
    }

    public File m525l() {
        if (!this.f546J || C0299c.m645a()) {
            return f530k;
        }
        return f529j;
    }

    public File m526m() {
        if (!this.f546J || C0299c.m645a()) {
            return f526g;
        }
        return f525f;
    }

    public File m527n() {
        return f543x;
    }

    public File m528o() {
        return f544y;
    }

    public File m529p() {
        return f545z;
    }

    public File m530q() {
        if (!this.f546J || C0299c.m645a()) {
            return f534o;
        }
        return f533n;
    }

    public File m531r() {
        if (!this.f546J || C0299c.m645a()) {
            return f538s;
        }
        return f537r;
    }

    public File m532s() {
        if (!this.f546J || C0299c.m645a()) {
            return f532m;
        }
        return f531l;
    }

    public File m533t() {
        return f536q;
    }

    public File m534u() {
        return f535p;
    }

    public File m535v() {
        if (f520a == null) {
            return null;
        }
        if (!this.f546J || C0299c.m645a()) {
            f520a = f522c;
        } else {
            f520a = f521b;
        }
        return f520a;
    }

    public static long m504w() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null || !C0278h.m503i()) {
            return 0;
        }
        return C0278h.m501g(externalStorageDirectory);
    }

    public static long m505x() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null || !C0278h.m503i()) {
            return 0;
        }
        StatFs statFs = new StatFs(externalStorageDirectory.getAbsolutePath());
        if (VERSION.SDK_INT >= 18) {
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        }
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private static long m501g(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        StatFs statFs = new StatFs(file.getAbsolutePath());
        if (VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        }
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static C0269a m506y() {
        Object obj;
        File file;
        C0269a a;
        File file2;
        C0269a a2 = C0269a.m425a();
        if (C0278h.m503i()) {
            obj = 1;
        } else {
            obj = null;
        }
        a2.m432a(".chartboost-total-external-space", Long.valueOf(f539t.getTotalSpace()));
        a2.m432a(".chartboost-total-internal-space", Long.valueOf(f540u.getTotalSpace()));
        a2.m432a("sdCard-total-space", Long.valueOf(Environment.getExternalStorageDirectory().getTotalSpace()));
        a2.m432a("sdCard-free-space", Long.valueOf(Environment.getExternalStorageDirectory().getFreeSpace()));
        if (obj != null) {
            file = f527h;
        } else {
            file = f528i;
        }
        if (file != null) {
            a = C0269a.m425a();
            a.m432a("size", Long.valueOf(file.getTotalSpace()));
            if (file.list() != null) {
                a.m432a("count", Integer.valueOf(file.list().length));
            }
            a2.m432a("css", a);
        }
        if (obj != null) {
            file = f529j;
        } else {
            file = f529j;
        }
        if (file != null) {
            a = C0269a.m425a();
            a.m432a("size", Long.valueOf(file.getTotalSpace()));
            if (file.list() != null) {
                a.m432a("count", Integer.valueOf(file.list().length));
            }
            a2.m432a("js", a);
        }
        if (obj != null) {
            file = f525f;
        } else {
            file = f526g;
        }
        if (file != null) {
            a = C0269a.m425a();
            a.m432a("size", Long.valueOf(file.getTotalSpace()));
            if (file.list() != null) {
                a.m432a("count", Integer.valueOf(file.list().length));
            }
            a2.m432a("media", a);
        }
        if (obj != null) {
            file2 = f533n;
        } else {
            file2 = f534o;
        }
        if (file2 != null) {
            C0269a a3 = C0269a.m425a();
            a3.m432a("size", Long.valueOf(file2.getTotalSpace()));
            if (file2.list() != null) {
                a3.m432a("count", Integer.valueOf(file2.list().length));
            }
            a2.m432a(Method.HTML, a3);
        }
        return a2;
    }

    public static boolean m494a(File file, int i) {
        if (file == null || !file.exists()) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(6, -i);
        if (!new Date(file.lastModified()).before(instance.getTime())) {
            return false;
        }
        CBLogging.m379a("CBFileCache", "File is expired and is past " + i + " days");
        return true;
    }
}
