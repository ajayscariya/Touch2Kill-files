package com.inmobi.signals.activityrecognition;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.signals.SignalsComponent;
import java.util.ArrayList;
import java.util.List;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.inmobi.signals.activityrecognition.b */
public class ActivityRecognitionSampler {
    private static final String f2075a;
    private static final Object f2076b;
    private static volatile ActivityRecognitionSampler f2077c;
    private static List<ActivityInfo> f2078d;
    private HandlerThread f2079e;
    private Handler f2080f;

    /* renamed from: com.inmobi.signals.activityrecognition.b.a */
    static class ActivityRecognitionSampler extends Handler {
        ActivityRecognitionSampler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case DurationDV.DURATION_TYPE /*0*/:
                    int c = ActivityRecognitionManager.m2181c();
                    Logger.m1744a(InternalLogLevel.INTERNAL, ActivityRecognitionSampler.f2075a, "Polling for ActivityRecognition. Detected activity:" + c);
                    if (c != -1) {
                        ActivityRecognitionSampler.f2078d.add(new ActivityInfo(c, System.currentTimeMillis()));
                    }
                    if (ActivityRecognitionSampler.f2078d.size() < SignalsComponent.m5202a().m5207e().m2383s()) {
                        sendEmptyMessageDelayed(0, (long) (SignalsComponent.m5202a().m5207e().m2382r() * 1000));
                    }
                default:
            }
        }
    }

    static {
        f2075a = ActivityRecognitionSampler.class.getSimpleName();
        f2076b = new Object();
    }

    public static ActivityRecognitionSampler m2186a() {
        ActivityRecognitionSampler activityRecognitionSampler = f2077c;
        if (activityRecognitionSampler == null) {
            synchronized (f2076b) {
                activityRecognitionSampler = f2077c;
                if (activityRecognitionSampler == null) {
                    activityRecognitionSampler = new ActivityRecognitionSampler();
                    f2077c = activityRecognitionSampler;
                }
            }
        }
        return activityRecognitionSampler;
    }

    private ActivityRecognitionSampler() {
        f2078d = new ArrayList();
        this.f2079e = new HandlerThread("ActivityRecognitionSampler");
        this.f2079e.start();
        this.f2080f = new ActivityRecognitionSampler(this.f2079e.getLooper());
    }

    public void m2191b() {
        if (ActivityRecognitionSampler.m2189h() && ActivityRecognitionSampler.m2190i() && !this.f2080f.hasMessages(0)) {
            ActivityRecognitionManager.m2177a();
            this.f2080f.sendEmptyMessage(0);
        }
    }

    public void m2192c() {
        if (ActivityRecognitionSampler.m2189h() && ActivityRecognitionSampler.m2190i() && this.f2080f.hasMessages(0)) {
            ActivityRecognitionManager.m2180b();
            this.f2080f.removeMessages(0);
        }
    }

    public List<ActivityInfo> m2193d() {
        return f2078d;
    }

    public void m2194e() {
        f2078d = new ArrayList();
    }

    private static boolean m2189h() {
        String str = "com.google.android.gms.permission.ACTIVITY_RECOGNITION";
        if (SdkContext.m1562b().checkCallingOrSelfPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION") == 0) {
            return true;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f2075a, "Activity recognition sampling did not work due to missing permission.");
        return false;
    }

    private static boolean m2190i() {
        if (SdkContext.m1562b().getPackageManager().queryIntentServices(new Intent(SdkContext.m1562b(), ActivityRecognitionManager.class), AccessibilityNodeInfoCompat.ACTION_CUT).size() > 0) {
            return true;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f2075a, "Activity recognition sampling did not work due to missing service in manifest.");
        return false;
    }
}
