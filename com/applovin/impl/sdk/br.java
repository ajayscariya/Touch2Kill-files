package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class br implements C1181x, AppLovinNativeAdLoadListener {
    protected final AppLovinSdkImpl f4810a;
    protected final AppLovinLogger f4811b;
    protected final Object f4812c;
    protected final Map f4813d;
    protected final Map f4814e;
    protected final Set f4815f;

    br(AppLovinSdkImpl appLovinSdkImpl) {
        this.f4810a = appLovinSdkImpl;
        this.f4811b = appLovinSdkImpl.getLogger();
        this.f4812c = new Object();
        this.f4813d = m5641a();
        this.f4814e = new HashMap();
        this.f4815f = new HashSet();
    }

    private bs m5638h(C0231c c0231c) {
        return (bs) this.f4813d.get(c0231c);
    }

    abstract bw m5639a(C0231c c0231c);

    abstract C0231c m5640a(az azVar);

    abstract Map m5641a();

    abstract void m5642a(Object obj, az azVar);

    abstract void m5643a(Object obj, C0231c c0231c, int i);

    public boolean m5644a(C0231c c0231c, Object obj) {
        boolean z;
        synchronized (this.f4812c) {
            if (m5654g(c0231c)) {
                z = false;
            } else {
                m5648b(c0231c, obj);
                z = true;
            }
        }
        return z;
    }

    public az m5645b(C0231c c0231c) {
        az e;
        synchronized (this.f4812c) {
            e = m5638h(c0231c).m150e();
        }
        return e;
    }

    void m5646b(az azVar) {
        m5653f(m5640a(azVar));
    }

    protected void m5647b(C0231c c0231c, int i) {
        this.f4811b.m306d("PreloadManager", "Failed to pre-load an ad of spec " + c0231c + ", error code " + i);
        synchronized (this.f4812c) {
            Object remove = this.f4814e.remove(c0231c);
            this.f4815f.add(c0231c);
        }
        if (remove != null) {
            try {
                m5643a(remove, c0231c, i);
            } catch (Throwable th) {
                this.f4810a.getLogger().userError("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    public void m5648b(C0231c c0231c, Object obj) {
        synchronized (this.f4812c) {
            if (this.f4814e.containsKey(c0231c)) {
                this.f4811b.m310w("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f4814e.put(c0231c, obj);
        }
    }

    protected void m5649c(az azVar) {
        synchronized (this.f4812c) {
            C0231c a = m5640a(azVar);
            Object obj = this.f4814e.get(a);
            this.f4814e.remove(a);
            this.f4815f.add(a);
            if (obj == null) {
                m5638h(a).m146a(azVar);
                this.f4811b.m306d("PreloadManager", "Ad enqueued: " + azVar);
            } else {
                this.f4811b.m306d("PreloadManager", "Additional callback found, skipping enqueue.");
            }
        }
        if (obj != null) {
            this.f4811b.m306d("PreloadManager", "Called additional callback regarding " + azVar);
            try {
                m5642a(obj, azVar);
            } catch (Throwable th) {
                this.f4810a.getLogger().userError("PreloadManager", "Encountered throwable while notifying user callback", th);
            }
            m5646b(azVar);
        }
        this.f4811b.m306d("PreloadManager", "Pulled ad from network and saved to preload cache: " + azVar);
    }

    public boolean m5650c(C0231c c0231c) {
        boolean c;
        synchronized (this.f4812c) {
            c = m5638h(c0231c).m148c();
        }
        return c;
    }

    public void m5651d(C0231c c0231c) {
        int i = 0;
        if (c0231c != null) {
            int b;
            synchronized (this.f4812c) {
                bs h = m5638h(c0231c);
                b = h != null ? h.m147b() - h.m145a() : 0;
            }
            if (b > 0) {
                while (i < b) {
                    m5653f(c0231c);
                    i++;
                }
            }
        }
    }

    public boolean m5652e(C0231c c0231c) {
        boolean z;
        synchronized (this.f4812c) {
            z = !m5638h(c0231c).m149d();
        }
        return z;
    }

    public void m5653f(C0231c c0231c) {
        if (((Boolean) this.f4810a.m4161a(bx.f232A)).booleanValue() && !m5650c(c0231c)) {
            this.f4811b.m306d("PreloadManager", "Preloading ad for spec " + c0231c + "...");
            this.f4810a.m4160a().m234a(m5639a(c0231c), cs.MAIN, 500);
        }
    }

    boolean m5654g(C0231c c0231c) {
        boolean contains;
        synchronized (this.f4812c) {
            contains = this.f4815f.contains(c0231c);
        }
        return contains;
    }
}
