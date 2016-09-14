package com.chartboost.sdk.impl;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.chartboost.sdk.impl.C0350b.C0349a;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.chartboost.sdk.impl.w */
public class C1252w implements C0350b {
    private final Map<String, C0429a> f4231a;
    private long f4232b;
    private final File f4233c;
    private final int f4234d;

    /* renamed from: com.chartboost.sdk.impl.w.a */
    static class C0429a {
        public long f1155a;
        public String f1156b;
        public String f1157c;
        public long f1158d;
        public long f1159e;
        public long f1160f;
        public Map<String, String> f1161g;

        private C0429a() {
        }

        public C0429a(String str, C0349a c0349a) {
            this.f1156b = str;
            this.f1155a = (long) c0349a.f891a.length;
            this.f1157c = c0349a.f892b;
            this.f1158d = c0349a.f893c;
            this.f1159e = c0349a.f894d;
            this.f1160f = c0349a.f895e;
            this.f1161g = c0349a.f896f;
        }

        public static C0429a m1150a(InputStream inputStream) throws IOException {
            C0429a c0429a = new C0429a();
            if (C1252w.m4712a(inputStream) != 538183203) {
                throw new IOException();
            }
            c0429a.f1156b = C1252w.m4721c(inputStream);
            c0429a.f1157c = C1252w.m4721c(inputStream);
            if (c0429a.f1157c.equals(XMLConstants.NULL_NS_URI)) {
                c0429a.f1157c = null;
            }
            c0429a.f1158d = C1252w.m4720b(inputStream);
            c0429a.f1159e = C1252w.m4720b(inputStream);
            c0429a.f1160f = C1252w.m4720b(inputStream);
            c0429a.f1161g = C1252w.m4723d(inputStream);
            return c0429a;
        }

        public C0349a m1151a(byte[] bArr) {
            C0349a c0349a = new C0349a();
            c0349a.f891a = bArr;
            c0349a.f892b = this.f1157c;
            c0349a.f893c = this.f1158d;
            c0349a.f894d = this.f1159e;
            c0349a.f895e = this.f1160f;
            c0349a.f896f = this.f1161g;
            return c0349a;
        }

        public boolean m1152a(OutputStream outputStream) {
            try {
                C1252w.m4714a(outputStream, 538183203);
                C1252w.m4716a(outputStream, this.f1156b);
                C1252w.m4716a(outputStream, this.f1157c == null ? XMLConstants.NULL_NS_URI : this.f1157c);
                C1252w.m4715a(outputStream, this.f1158d);
                C1252w.m4715a(outputStream, this.f1159e);
                C1252w.m4715a(outputStream, this.f1160f);
                C1252w.m4718a(this.f1161g, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                C0426t.m1143b("%s", e.toString());
                return false;
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.w.b */
    private static class C0430b extends FilterInputStream {
        private int f1162a;

        private C0430b(InputStream inputStream) {
            super(inputStream);
            this.f1162a = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f1162a++;
            }
            return read;
        }

        public int read(byte[] buffer, int offset, int count) throws IOException {
            int read = super.read(buffer, offset, count);
            if (read != -1) {
                this.f1162a += read;
            }
            return read;
        }
    }

    public C1252w(File file, int i) {
        this.f4231a = new LinkedHashMap(16, 0.75f, true);
        this.f4232b = 0;
        this.f4233c = file;
        this.f4234d = i;
    }

    public C1252w(File file) {
        this(file, 5242880);
    }

    public synchronized C0349a m4726a(String str) {
        C0349a c0349a;
        IOException e;
        Throwable th;
        C0429a c0429a = (C0429a) this.f4231a.get(str);
        if (c0429a == null) {
            c0349a = null;
        } else {
            File c = m4730c(str);
            C0430b c0430b;
            try {
                c0430b = new C0430b(null);
                try {
                    C0429a.m1150a((InputStream) c0430b);
                    c0349a = c0429a.m1151a(C1252w.m4719a((InputStream) c0430b, (int) (c.length() - ((long) c0430b.f1162a))));
                    if (c0430b != null) {
                        try {
                            c0430b.close();
                        } catch (IOException e2) {
                            c0349a = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C0426t.m1143b("%s: %s", c.getAbsolutePath(), e.toString());
                        m4729b(str);
                        if (c0430b != null) {
                            try {
                                c0430b.close();
                            } catch (IOException e4) {
                                c0349a = null;
                            }
                        }
                        c0349a = null;
                        return c0349a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0430b != null) {
                            try {
                                c0430b.close();
                            } catch (IOException e5) {
                                c0349a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c0430b = null;
                C0426t.m1143b("%s: %s", c.getAbsolutePath(), e.toString());
                m4729b(str);
                if (c0430b != null) {
                    c0430b.close();
                }
                c0349a = null;
                return c0349a;
            } catch (Throwable th3) {
                th = th3;
                c0430b = null;
                if (c0430b != null) {
                    c0430b.close();
                }
                throw th;
            }
        }
        return c0349a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4727a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f4233c;	 Catch:{ all -> 0x0067 }
        r1 = r1.exists();	 Catch:{ all -> 0x0067 }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f4233c;	 Catch:{ all -> 0x0067 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0067 }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0067 }
        r2 = 0;
        r3 = r9.f4233c;	 Catch:{ all -> 0x0067 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0067 }
        r1[r2] = r3;	 Catch:{ all -> 0x0067 }
        com.chartboost.sdk.impl.C0426t.m1144c(r0, r1);	 Catch:{ all -> 0x0067 }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f4233c;	 Catch:{ all -> 0x0067 }
        r3 = r1.listFiles();	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x0067 }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x0067 }
        r1 = 0;
        r0 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0051, all -> 0x0060 }
        r0.<init>(r5);	 Catch:{ IOException -> 0x0051, all -> 0x0060 }
        r1 = com.chartboost.sdk.impl.C1252w.C0429a.m1150a(r0);	 Catch:{ IOException -> 0x0073 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0073 }
        r1.f1155a = r6;	 Catch:{ IOException -> 0x0073 }
        r6 = r1.f1156b;	 Catch:{ IOException -> 0x0073 }
        r9.m4717a(r6, r1);	 Catch:{ IOException -> 0x0073 }
        if (r0 == 0) goto L_0x004d;
    L_0x004a:
        r0.close();	 Catch:{ IOException -> 0x006c }
    L_0x004d:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0051:
        r0 = move-exception;
        r0 = r1;
    L_0x0053:
        if (r5 == 0) goto L_0x0058;
    L_0x0055:
        r5.delete();	 Catch:{ all -> 0x006e }
    L_0x0058:
        if (r0 == 0) goto L_0x004d;
    L_0x005a:
        r0.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x004d;
    L_0x005e:
        r0 = move-exception;
        goto L_0x004d;
    L_0x0060:
        r0 = move-exception;
    L_0x0061:
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();	 Catch:{ IOException -> 0x006a }
    L_0x0066:
        throw r0;	 Catch:{ all -> 0x0067 }
    L_0x0067:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006a:
        r1 = move-exception;
        goto L_0x0066;
    L_0x006c:
        r0 = move-exception;
        goto L_0x004d;
    L_0x006e:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0061;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.w.a():void");
    }

    public synchronized void m4728a(String str, C0349a c0349a) {
        m4713a(c0349a.f891a.length);
        File c = m4730c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C0429a c0429a = new C0429a(str, c0349a);
            if (c0429a.m1152a(fileOutputStream)) {
                fileOutputStream.write(c0349a.f891a);
                fileOutputStream.close();
                m4717a(str, c0429a);
            } else {
                fileOutputStream.close();
                C0426t.m1143b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                C0426t.m1143b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m4729b(String str) {
        boolean delete = m4730c(str).delete();
        m4725e(str);
        if (!delete) {
            C0426t.m1143b("Could not delete cache entry for key=%s, filename=%s", str, m4722d(str));
        }
    }

    private String m4722d(String str) {
        int length = str.length() / 2;
        return new StringBuilder(String.valueOf(String.valueOf(str.substring(0, length).hashCode()))).append(String.valueOf(str.substring(length).hashCode())).toString();
    }

    public File m4730c(String str) {
        return new File(this.f4233c, m4722d(str));
    }

    private void m4713a(int i) {
        if (this.f4232b + ((long) i) >= ((long) this.f4234d)) {
            int i2;
            if (C0426t.f1149b) {
                C0426t.m1141a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f4232b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f4231a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C0429a c0429a = (C0429a) ((Entry) it.next()).getValue();
                if (m4730c(c0429a.f1156b).delete()) {
                    this.f4232b -= c0429a.f1155a;
                } else {
                    C0426t.m1143b("Could not delete cache entry for key=%s, filename=%s", c0429a.f1156b, m4722d(c0429a.f1156b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f4232b + ((long) i))) < ((float) this.f4234d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (C0426t.f1149b) {
                C0426t.m1141a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4232b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void m4717a(String str, C0429a c0429a) {
        if (this.f4231a.containsKey(str)) {
            C0429a c0429a2 = (C0429a) this.f4231a.get(str);
            this.f4232b = (c0429a.f1155a - c0429a2.f1155a) + this.f4232b;
        } else {
            this.f4232b += c0429a.f1155a;
        }
        this.f4231a.put(str, c0429a);
    }

    private void m4725e(String str) {
        C0429a c0429a = (C0429a) this.f4231a.get(str);
        if (c0429a != null) {
            this.f4232b -= c0429a.f1155a;
            this.f4231a.remove(str);
        }
    }

    private static byte[] m4719a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    private static int m4724e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void m4714a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    static int m4712a(InputStream inputStream) throws IOException {
        return (((0 | (C1252w.m4724e(inputStream) << 0)) | (C1252w.m4724e(inputStream) << 8)) | (C1252w.m4724e(inputStream) << 16)) | (C1252w.m4724e(inputStream) << 24);
    }

    static void m4715a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long m4720b(InputStream inputStream) throws IOException {
        return (((((((0 | ((((long) C1252w.m4724e(inputStream)) & 255) << null)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 8)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 16)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 24)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 32)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 40)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 48)) | ((((long) C1252w.m4724e(inputStream)) & 255) << 56);
    }

    static void m4716a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Defaults.Encoding);
        C1252w.m4715a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String m4721c(InputStream inputStream) throws IOException {
        return new String(C1252w.m4719a(inputStream, (int) C1252w.m4720b(inputStream)), Defaults.Encoding);
    }

    static void m4718a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            C1252w.m4714a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                C1252w.m4716a(outputStream, (String) entry.getKey());
                C1252w.m4716a(outputStream, (String) entry.getValue());
            }
            return;
        }
        C1252w.m4714a(outputStream, 0);
    }

    static Map<String, String> m4723d(InputStream inputStream) throws IOException {
        Map<String, String> emptyMap;
        int a = C1252w.m4712a(inputStream);
        if (a == 0) {
            emptyMap = Collections.emptyMap();
        } else {
            emptyMap = new HashMap(a);
        }
        for (int i = 0; i < a; i++) {
            emptyMap.put(C1252w.m4721c(inputStream).intern(), C1252w.m4721c(inputStream).intern());
        }
        return emptyMap;
    }
}
