package com.inmobi.ads;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.inmobi.ads.AdConfig.AdConfig;
import com.inmobi.ads.AdUnit.AdState;
import com.inmobi.ads.VisibilityTracker.VisibilityTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.ads.l */
class ImpressionTracker {
    private static final String f1487a;
    @NonNull
    private final VisibilityTracker f1488b;
    @NonNull
    private final Map<View, NativeAdUnit> f1489c;
    @NonNull
    private final Map<View, TimestampWrapper<NativeAdUnit>> f1490d;
    @NonNull
    private final Handler f1491e;
    @NonNull
    private final ImpressionTracker f1492f;
    @NonNull
    private final VisibilityTracker f1493g;
    @Nullable
    private VisibilityTracker f1494h;
    @NonNull
    private AdConfig f1495i;

    /* renamed from: com.inmobi.ads.l.a */
    class ImpressionTracker implements Runnable {
        final /* synthetic */ ImpressionTracker f1485a;
        @NonNull
        private final ArrayList<View> f1486b;

        ImpressionTracker(ImpressionTracker impressionTracker) {
            this.f1485a = impressionTracker;
            this.f1486b = new ArrayList();
        }

        public void run() {
            for (Entry entry : this.f1485a.f1490d.entrySet()) {
                View view = (View) entry.getKey();
                TimestampWrapper timestampWrapper = (TimestampWrapper) entry.getValue();
                if (this.f1485a.f1493g.m1542a(timestampWrapper.f1498b, this.f1485a.f1495i.m1492b())) {
                    ((NativeAdUnit) timestampWrapper.f1497a).m5866y();
                    this.f1486b.add(view);
                }
            }
            Iterator it = this.f1486b.iterator();
            while (it.hasNext()) {
                this.f1485a.m1538a((View) it.next());
            }
            this.f1486b.clear();
            if (!this.f1485a.f1490d.isEmpty()) {
                this.f1485a.m1541c();
            }
        }
    }

    /* renamed from: com.inmobi.ads.l.1 */
    class ImpressionTracker implements VisibilityTracker {
        final /* synthetic */ ImpressionTracker f4403a;

        ImpressionTracker(ImpressionTracker impressionTracker) {
            this.f4403a = impressionTracker;
        }

        public void m5060a(@NonNull List<View> list, @NonNull List<View> list2) {
            for (View view : list) {
                NativeAdUnit nativeAdUnit = (NativeAdUnit) this.f4403a.f1489c.get(view);
                if (nativeAdUnit == null) {
                    this.f4403a.m1538a(view);
                } else {
                    TimestampWrapper timestampWrapper = (TimestampWrapper) this.f4403a.f1490d.get(view);
                    if (timestampWrapper == null || !nativeAdUnit.equals(timestampWrapper.f1497a)) {
                        this.f4403a.f1490d.put(view, new TimestampWrapper(nativeAdUnit));
                    }
                }
            }
            for (View view2 : list2) {
                this.f4403a.f1490d.remove(view2);
            }
            this.f4403a.m1541c();
        }
    }

    static {
        f1487a = ImpressionTracker.class.getSimpleName();
    }

    ImpressionTracker(AdConfig adConfig) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker(), new VisibilityTracker(adConfig), new Handler(), adConfig);
    }

    ImpressionTracker(@NonNull Map<View, NativeAdUnit> map, @NonNull Map<View, TimestampWrapper<NativeAdUnit>> map2, @NonNull VisibilityTracker visibilityTracker, @NonNull VisibilityTracker visibilityTracker2, @NonNull Handler handler, @NonNull AdConfig adConfig) {
        this.f1489c = map;
        this.f1490d = map2;
        this.f1493g = visibilityTracker;
        this.f1488b = visibilityTracker2;
        this.f1495i = adConfig;
        this.f1494h = new ImpressionTracker(this);
        this.f1488b.m1553a(this.f1494h);
        this.f1491e = handler;
        this.f1492f = new ImpressionTracker(this);
    }

    void m1539a(View view, @NonNull NativeAdUnit nativeAdUnit) {
        if (this.f1489c.get(view) != nativeAdUnit) {
            m1538a(view);
            if (AdState.STATE_RENDERED != nativeAdUnit.m4982g()) {
                this.f1489c.put(view, nativeAdUnit);
                this.f1488b.m1552a(view, this.f1495i.m1491a());
            }
        }
    }

    void m1538a(View view) {
        this.f1489c.remove(view);
        m1534b(view);
        this.f1488b.m1551a(view);
    }

    void m1537a() {
        this.f1489c.clear();
        this.f1490d.clear();
        this.f1488b.m1550a();
        this.f1491e.removeMessages(0);
    }

    void m1540b() {
        m1537a();
        this.f1488b.m1554b();
        this.f1494h = null;
    }

    void m1541c() {
        if (!this.f1491e.hasMessages(0)) {
            this.f1491e.postDelayed(this.f1492f, (long) this.f1495i.m1494d());
        }
    }

    private void m1534b(View view) {
        this.f1490d.remove(view);
    }
}
