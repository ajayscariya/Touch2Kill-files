package com.inmobi.signals;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.signals.SignalsConfig.SignalsConfig;
import com.inmobi.signals.activityrecognition.ActivityRecognitionSampler;
import com.inmobi.signals.p006a.CellularInfoUtil;
import com.inmobi.signals.p007b.WifiInfo;
import com.inmobi.signals.p007b.WifiInfoUtil;
import com.inmobi.signals.p007b.WifiScanner.WifiScanner;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.ArrayList;
import java.util.List;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.inmobi.signals.i */
class IceCollector {
    private static final String f2112a;
    private HandlerThread f2113b;
    private IceCollector f2114c;

    /* renamed from: com.inmobi.signals.i.a */
    static class IceCollector extends Handler {
        private List<IceWifiSample> f2111a;

        /* renamed from: com.inmobi.signals.i.a.1 */
        class IceCollector implements WifiScanner {
            final /* synthetic */ IceWifiSample f4490a;
            final /* synthetic */ IceCollector f4491b;

            IceCollector(IceCollector iceCollector, IceWifiSample iceWifiSample) {
                this.f4491b = iceCollector;
                this.f4490a = iceWifiSample;
            }

            public void m5198a() {
                Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "Wifi scan timeout.");
                this.f4491b.m2257a(this.f4490a);
            }

            public void m5199a(List<WifiInfo> list) {
                Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "Wifi scan successful.");
                this.f4490a.m2280a((List) list);
                this.f4491b.m2257a(this.f4490a);
            }
        }

        IceCollector(Looper looper) {
            super(looper);
            this.f2111a = new ArrayList();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    m2259b();
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    m2260c();
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "Polling for samples.");
                    if (VERSION.SDK_INT >= 14 || IceCollector.m2258a()) {
                        if (SignalsComponent.m5202a().m5207e().m2381q()) {
                            ActivityRecognitionSampler.m2186a().m2191b();
                        } else {
                            ActivityRecognitionSampler.m2186a().m2192c();
                        }
                        m2261d();
                        sendEmptyMessageDelayed(3, (long) (SignalsComponent.m5202a().m5207e().m2366b() * 1000));
                        return;
                    }
                    sendEmptyMessage(2);
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    m2256a(m2262e());
                    m2263f();
                default:
            }
        }

        private void m2259b() {
            Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "User data collection started.");
            LocationInfo.m2285a().m2296b();
            sendEmptyMessage(3);
        }

        private void m2260c() {
            Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "Stopping user data collection.");
            ActivityRecognitionSampler.m2186a().m2192c();
            removeMessages(3);
            sendEmptyMessage(4);
        }

        private void m2261d() {
            IceWifiSample iceWifiSample = new IceWifiSample();
            iceWifiSample.m2279a(WifiInfoUtil.m2204a());
            if (!SignalsComponent.m5202a().m5207e().m2375k() || !WifiInfoUtil.m2213c()) {
                m2257a(iceWifiSample);
            } else if (!com.inmobi.signals.p007b.WifiScanner.m2221a(new IceCollector(this, iceWifiSample))) {
                m2257a(iceWifiSample);
            }
        }

        private void m2257a(IceWifiSample iceWifiSample) {
            if (this.f2111a != null && iceWifiSample.m2281a()) {
                this.f2111a.add(iceWifiSample);
                if (this.f2111a.size() > SignalsComponent.m5202a().m5207e().m2368d()) {
                    TelemetryComponent.m5070a().m5090a(new TelemetryEvent("signals", "SampleSizeExceeded"));
                    while (this.f2111a.size() > SignalsComponent.m5202a().m5207e().m2368d()) {
                        this.f2111a.remove(0);
                    }
                }
            }
        }

        private IceSample m2262e() {
            IceSample iceSample = new IceSample();
            iceSample.m2274a(CellularInfoUtil.m2161a());
            iceSample.m2276a(LocationInfo.m2285a().m2297c());
            iceSample.m2275a(this.f2111a);
            iceSample.m2273a(SessionManager.m2299a().m2302d());
            iceSample.m2277b(ActivityRecognitionSampler.m2186a().m2193d());
            return iceSample;
        }

        private void m2263f() {
            ActivityRecognitionSampler.m2186a().m2194e();
            this.f2111a = new ArrayList();
        }

        private void m2256a(IceSample iceSample) {
            SignalsConfig e = SignalsComponent.m5202a().m5207e();
            new IceNetworkClient(new IceNetworkRequest(e.m2369e(), e.m2370f(), e.m2371g(), SignalsComponent.m5202a().m5206d(), iceSample)).m2270a();
        }

        public static boolean m2258a() {
            ActivityManager activityManager = (ActivityManager) SdkContext.m1562b().getSystemService("activity");
            if (activityManager != null) {
                try {
                    if (((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getPackageName().equalsIgnoreCase(SdkContext.m1562b().getPackageName())) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "Is app in foreground check for below ICS: true");
                        return true;
                    }
                } catch (Throwable e) {
                    Logger.m1745a(InternalLogLevel.INTERNAL, IceCollector.f2112a, "NPE while determining if app is in foreground for below ICS devices.", e);
                }
            }
            return false;
        }
    }

    static {
        f2112a = IceCollector.class.getSimpleName();
    }

    public IceCollector() {
        this.f2113b = new HandlerThread("DataCollectionHandler");
        this.f2113b.start();
        this.f2114c = new IceCollector(this.f2113b.getLooper());
    }

    public synchronized void m2265a() {
        if (VERSION.SDK_INT < 14 && !m2266b()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2112a, "User data collection can not be started as the data collector is not properly initialized.");
        } else if (this.f2114c.hasMessages(3)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2112a, "User data collection already running.");
        } else {
            this.f2114c.removeMessages(2);
            this.f2114c.sendEmptyMessage(1);
        }
    }

    public boolean m2266b() {
        return SdkContext.m1562b().checkCallingOrSelfPermission("android.permission.GET_TASKS") == 0;
    }

    public void m2267c() {
        this.f2114c.sendEmptyMessageDelayed(2, (long) (SignalsComponent.m5202a().m5207e().m2367c() * 1000));
    }
}
