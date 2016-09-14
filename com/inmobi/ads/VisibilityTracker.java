package com.inmobi.ads;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.inmobi.ads.AdConfig.AdConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.ads.q */
class VisibilityTracker {
    private static final String f1505a;
    @NonNull
    private final ArrayList<View> f1506b;
    private long f1507c;
    @NonNull
    private final Map<View, VisibilityTracker> f1508d;
    @NonNull
    private final VisibilityTracker f1509e;
    @Nullable
    private VisibilityTracker f1510f;
    @NonNull
    private final VisibilityTracker f1511g;
    @NonNull
    private final Handler f1512h;
    private boolean f1513i;
    @NonNull
    private AdConfig f1514j;

    /* renamed from: com.inmobi.ads.q.a */
    static class VisibilityTracker {
        int f1499a;
        long f1500b;

        VisibilityTracker() {
        }
    }

    /* renamed from: com.inmobi.ads.q.b */
    static class VisibilityTracker {
        private final Rect f1501a;

        VisibilityTracker() {
            this.f1501a = new Rect();
        }

        boolean m1542a(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        boolean m1543a(@Nullable View view, int i) {
            if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.getGlobalVisibleRect(this.f1501a)) {
                return false;
            }
            long height = ((long) this.f1501a.height()) * ((long) this.f1501a.width());
            long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height2 <= 0 || height * 100 < height2 * ((long) i)) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.inmobi.ads.q.c */
    class VisibilityTracker implements Runnable {
        final /* synthetic */ VisibilityTracker f1502a;
        @NonNull
        private final ArrayList<View> f1503b;
        @NonNull
        private final ArrayList<View> f1504c;

        VisibilityTracker(VisibilityTracker visibilityTracker) {
            this.f1502a = visibilityTracker;
            this.f1504c = new ArrayList();
            this.f1503b = new ArrayList();
        }

        public void run() {
            this.f1502a.f1513i = false;
            for (Entry entry : this.f1502a.f1508d.entrySet()) {
                View view = (View) entry.getKey();
                if (this.f1502a.f1509e.m1543a(view, ((VisibilityTracker) entry.getValue()).f1499a)) {
                    this.f1503b.add(view);
                } else {
                    this.f1504c.add(view);
                }
            }
            if (this.f1502a.f1510f != null) {
                this.f1502a.f1510f.m1544a(this.f1503b, this.f1504c);
            }
            this.f1503b.clear();
            this.f1504c.clear();
            this.f1502a.m1555c();
        }
    }

    /* renamed from: com.inmobi.ads.q.d */
    interface VisibilityTracker {
        void m1544a(List<View> list, List<View> list2);
    }

    static {
        f1505a = VisibilityTracker.class.getSimpleName();
    }

    public VisibilityTracker(AdConfig adConfig) {
        this(new WeakHashMap(10), new VisibilityTracker(), new Handler(), adConfig);
    }

    VisibilityTracker(@NonNull Map<View, VisibilityTracker> map, @NonNull VisibilityTracker visibilityTracker, @NonNull Handler handler, @NonNull AdConfig adConfig) {
        this.f1507c = 0;
        this.f1508d = map;
        this.f1509e = visibilityTracker;
        this.f1512h = handler;
        this.f1511g = new VisibilityTracker(this);
        this.f1514j = adConfig;
        this.f1506b = new ArrayList(50);
    }

    void m1553a(@Nullable VisibilityTracker visibilityTracker) {
        this.f1510f = visibilityTracker;
    }

    void m1552a(@NonNull View view, int i) {
        VisibilityTracker visibilityTracker = (VisibilityTracker) this.f1508d.get(view);
        if (visibilityTracker == null) {
            visibilityTracker = new VisibilityTracker();
            this.f1508d.put(view, visibilityTracker);
            m1555c();
        }
        visibilityTracker.f1499a = i;
        visibilityTracker.f1500b = this.f1507c;
        this.f1507c++;
        if (this.f1507c % 50 == 0) {
            m1546a(this.f1507c - 50);
        }
    }

    private void m1546a(long j) {
        for (Entry entry : this.f1508d.entrySet()) {
            if (((VisibilityTracker) entry.getValue()).f1500b < j) {
                this.f1506b.add(entry.getKey());
            }
        }
        Iterator it = this.f1506b.iterator();
        while (it.hasNext()) {
            m1551a((View) it.next());
        }
        this.f1506b.clear();
    }

    void m1551a(@NonNull View view) {
        this.f1508d.remove(view);
    }

    void m1550a() {
        this.f1508d.clear();
        this.f1512h.removeMessages(0);
        this.f1513i = false;
    }

    void m1554b() {
        m1550a();
        this.f1510f = null;
    }

    void m1555c() {
        if (!this.f1513i) {
            this.f1513i = true;
            this.f1512h.postDelayed(this.f1511g, (long) this.f1514j.m1493c());
        }
    }
}
