package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.v */
public class C0428v {
    protected static final Comparator<byte[]> f1150a;
    private List<byte[]> f1151b;
    private List<byte[]> f1152c;
    private int f1153d;
    private final int f1154e;

    /* renamed from: com.chartboost.sdk.impl.v.1 */
    class C04271 implements Comparator<byte[]> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1146a((byte[]) obj, (byte[]) obj2);
        }

        C04271() {
        }

        public int m1146a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    static {
        f1150a = new C04271();
    }

    public C0428v(int i) {
        this.f1151b = new LinkedList();
        this.f1152c = new ArrayList(64);
        this.f1153d = 0;
        this.f1154e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] m1149a(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r4.f1152c;	 Catch:{ all -> 0x002b }
        r0 = r0.size();	 Catch:{ all -> 0x002b }
        if (r1 < r0) goto L_0x000f;
    L_0x000b:
        r0 = new byte[r5];	 Catch:{ all -> 0x002b }
    L_0x000d:
        monitor-exit(r4);
        return r0;
    L_0x000f:
        r0 = r4.f1152c;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002b }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x002b }
        r2 = r0.length;	 Catch:{ all -> 0x002b }
        if (r2 < r5) goto L_0x002e;
    L_0x001a:
        r2 = r4.f1153d;	 Catch:{ all -> 0x002b }
        r3 = r0.length;	 Catch:{ all -> 0x002b }
        r2 = r2 - r3;
        r4.f1153d = r2;	 Catch:{ all -> 0x002b }
        r2 = r4.f1152c;	 Catch:{ all -> 0x002b }
        r2.remove(r1);	 Catch:{ all -> 0x002b }
        r1 = r4.f1151b;	 Catch:{ all -> 0x002b }
        r1.remove(r0);	 Catch:{ all -> 0x002b }
        goto L_0x000d;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x002e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v.a(int):byte[]");
    }

    public synchronized void m1148a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f1154e) {
                this.f1151b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f1152c, bArr, f1150a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f1152c.add(binarySearch, bArr);
                this.f1153d += bArr.length;
                m1147a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m1147a() {
        /*
        r2 = this;
        monitor-enter(r2);
    L_0x0001:
        r0 = r2.f1153d;	 Catch:{ all -> 0x001f }
        r1 = r2.f1154e;	 Catch:{ all -> 0x001f }
        if (r0 > r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);
        return;
    L_0x0009:
        r0 = r2.f1151b;	 Catch:{ all -> 0x001f }
        r1 = 0;
        r0 = r0.remove(r1);	 Catch:{ all -> 0x001f }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x001f }
        r1 = r2.f1152c;	 Catch:{ all -> 0x001f }
        r1.remove(r0);	 Catch:{ all -> 0x001f }
        r1 = r2.f1153d;	 Catch:{ all -> 0x001f }
        r0 = r0.length;	 Catch:{ all -> 0x001f }
        r0 = r1 - r0;
        r2.f1153d = r0;	 Catch:{ all -> 0x001f }
        goto L_0x0001;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.v.a():void");
    }
}
