package com.inmobi.rendering.p005a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.ads.AdConfig.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent.ConfigComponent;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.network.WebViewNetworkTask;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkConnectivityChangeObserver.NetworkConnectivityChangeObserver;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.inmobi.rendering.a.c */
public final class ClickManager implements ConfigComponent {
    private static final String f4464a;
    private static ClickManager f4465b;
    private static final Object f4466c;
    private static ExecutorService f4467d;
    private static ClickManager f4468e;
    private static HandlerThread f4469f;
    private static List<Click> f4470g;
    private static ClickDao f4471h;
    private static AtomicBoolean f4472i;
    private static AdConfig f4473j;
    private static final Object f4474k;
    private final ClickManager f4475l;

    /* renamed from: com.inmobi.rendering.a.c.1 */
    class ClickManager implements Runnable {
        final /* synthetic */ Click f1901a;
        final /* synthetic */ ClickManager f1902b;

        ClickManager(ClickManager clickManager, Click click) {
            this.f1902b = clickManager;
            this.f1901a = click;
        }

        public void run() {
            if (this.f1901a.f1897f) {
                new ClickManager(this.f1902b.f4475l).m2007a(this.f1901a);
            } else {
                new ClickManager(this.f1902b.f4475l).m2008a(this.f1901a);
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.c.a */
    final class ClickManager extends Handler {
        final /* synthetic */ ClickManager f1903a;

        /* renamed from: com.inmobi.rendering.a.c.a.1 */
        class ClickManager implements ClickManager {
            final /* synthetic */ ClickManager f4462a;

            ClickManager(ClickManager clickManager) {
                this.f4462a = clickManager;
            }

            public void m5171a(Click click) {
                this.f4462a.m2004c(click);
            }

            public void m5172a(Click click, ErrorCode errorCode) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + click.f1892a + ") via HTTP failed ...");
                this.f4462a.f1903a.m5178a(click);
                this.f4462a.m2005d(click);
            }
        }

        /* renamed from: com.inmobi.rendering.a.c.a.2 */
        class ClickManager implements ClickManager {
            final /* synthetic */ ClickManager f4463a;

            ClickManager(ClickManager clickManager) {
                this.f4463a = clickManager;
            }

            public void m5173a(Click click) {
                this.f4463a.m2004c(click);
            }

            public void m5174a(Click click, ErrorCode errorCode) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + click.f1892a + ") via WebView failed ...");
                this.f4463a.f1903a.m5178a(click);
                this.f4463a.m2005d(click);
            }
        }

        public ClickManager(ClickManager clickManager, Looper looper) {
            this.f1903a = clickManager;
            super(looper);
        }

        public void handleMessage(Message message) {
            Click click;
            int a;
            switch (message.what) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    ClickManager.f4470g = ClickManager.f4471h.m1994a(ClickManager.f4473j.m1458e(), ClickManager.f4473j.m1455b());
                    if (!ClickManager.f4470g.isEmpty()) {
                        click = (Click) ClickManager.f4470g.get(0);
                        Message obtain = Message.obtain();
                        obtain.what = click.f1897f ? 3 : 2;
                        obtain.obj = click;
                        long currentTimeMillis = System.currentTimeMillis() - click.f1894c;
                        if (currentTimeMillis < ((long) (ClickManager.f4473j.m1455b() * 1000))) {
                            sendMessageDelayed(obtain, ((long) (ClickManager.f4473j.m1455b() * 1000)) - currentTimeMillis);
                            return;
                        } else {
                            sendMessage(obtain);
                            return;
                        }
                    } else if (ClickManager.f4471h.m1996a()) {
                        ClickManager.f4472i.set(false);
                        return;
                    } else {
                        Message obtain2 = Message.obtain();
                        obtain2.what = 1;
                        sendMessageDelayed(obtain2, (long) (ClickManager.f4473j.m1455b() * 1000));
                        return;
                    }
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    if (NetworkUtils.m1783a()) {
                        click = (Click) message.obj;
                        if (click.f1895d == 0) {
                            m2002b(click);
                            return;
                        }
                        a = (ClickManager.f4473j.m1454a() - click.f1895d) + 1;
                        if (a == 0) {
                            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + click.f1892a + ") over HTTP");
                        } else {
                            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Retry attempt #" + a + " for click (" + click.f1892a + ") over HTTP");
                        }
                        new ClickManager(new ClickManager(this)).m2008a(click);
                        return;
                    }
                    ClickManager.f4472i.set(false);
                    this.f1903a.m5190c();
                    return;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    if (NetworkUtils.m1783a()) {
                        click = (Click) message.obj;
                        if (click.f1895d == 0) {
                            m2002b(click);
                            return;
                        }
                        a = (ClickManager.f4473j.m1454a() - click.f1895d) + 1;
                        if (a == 0) {
                            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + click.f1892a + ") in WebView");
                        } else {
                            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Retry attempt #" + a + " for click (" + click.f1892a + ") using WebView");
                        }
                        new ClickManager(new ClickManager(this)).m2007a(click);
                        return;
                    }
                    ClickManager.f4472i.set(false);
                    this.f1903a.m5190c();
                    return;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    break;
                case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                    click = (Click) message.obj;
                    Map hashMap = new HashMap();
                    hashMap.put("pingUrl", click.f1893b);
                    hashMap.put("errorCode", "MaxRetryCountReached");
                    TelemetryComponent.m5070a().m5092a("ads", "PingDiscarded", hashMap);
                    break;
                default:
                    return;
            }
            click = (Click) message.obj;
            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Processing click (" + click.f1892a + ") completed");
            ClickManager.f4471h.m1998b(click);
            ClickManager.f4470g.remove(click);
            if (!ClickManager.f4470g.isEmpty()) {
                m2000a((Click) ClickManager.f4470g.get(0));
            } else if (ClickManager.f4471h.m1996a()) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Done processing all clicks!");
                ClickManager.f4472i.set(false);
            } else {
                obtain2 = Message.obtain();
                obtain2.what = 1;
                sendMessage(obtain2);
            }
        }

        private void m2000a(Click click) {
            Message obtain = Message.obtain();
            obtain.what = click.f1897f ? 3 : 2;
            obtain.obj = click;
            sendMessage(obtain);
        }

        private void m2002b(Click click) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = click;
            sendMessage(obtain);
        }

        private void m2004c(Click click) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = click;
            sendMessage(obtain);
        }

        private void m2005d(Click click) {
            int indexOf = ClickManager.f4470g.indexOf(click);
            Click click2 = (Click) ClickManager.f4470g.get(indexOf == ClickManager.f4470g.size() + -1 ? 0 : indexOf + 1);
            Message obtain = Message.obtain();
            obtain.what = click2.f1897f ? 3 : 2;
            obtain.obj = click2;
            if (System.currentTimeMillis() - click2.f1894c < ((long) (ClickManager.f4473j.m1455b() * 1000))) {
                sendMessageDelayed(obtain, (long) (ClickManager.f4473j.m1455b() * 1000));
            } else {
                sendMessage(obtain);
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.c.b */
    static final class ClickManager {
        private ClickManager f1913a;

        /* renamed from: com.inmobi.rendering.a.c.b.1 */
        class ClickManager implements Runnable {
            final /* synthetic */ Click f1910a;
            final /* synthetic */ Handler f1911b;
            final /* synthetic */ ClickManager f1912c;

            /* renamed from: com.inmobi.rendering.a.c.b.1.1 */
            class ClickManager extends WebViewClient {
                AtomicBoolean f1907a;
                boolean f1908b;
                final /* synthetic */ ClickManager f1909c;

                /* renamed from: com.inmobi.rendering.a.c.b.1.1.1 */
                class ClickManager implements Runnable {
                    final /* synthetic */ WebView f1905a;
                    final /* synthetic */ ClickManager f1906b;

                    /* renamed from: com.inmobi.rendering.a.c.b.1.1.1.1 */
                    class ClickManager implements Runnable {
                        final /* synthetic */ ClickManager f1904a;

                        ClickManager(ClickManager clickManager) {
                            this.f1904a = clickManager;
                        }

                        public void run() {
                            this.f1904a.f1905a.stopLoading();
                        }
                    }

                    ClickManager(ClickManager clickManager, WebView webView) {
                        this.f1906b = clickManager;
                        this.f1905a = webView;
                    }

                    public void run() {
                        try {
                            Thread.sleep((long) (ClickManager.f4473j.m1456c() * 1000));
                        } catch (InterruptedException e) {
                        }
                        if (!this.f1906b.f1907a.get()) {
                            Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + this.f1906b.f1909c.f1910a.f1892a + ") via WebView timed out!");
                            this.f1906b.f1909c.f1910a.f1896e.set(true);
                            this.f1906b.f1909c.f1911b.post(new ClickManager(this));
                            this.f1906b.f1909c.f1912c.f1913a.m2010a(this.f1906b.f1909c.f1910a, null);
                        }
                    }
                }

                ClickManager(ClickManager clickManager) {
                    this.f1909c = clickManager;
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    this.f1907a = new AtomicBoolean(false);
                    this.f1908b = false;
                    new Thread(new ClickManager(this, webView)).start();
                }

                public void onPageFinished(WebView webView, String str) {
                    this.f1907a.set(true);
                    if (!this.f1908b && !this.f1909c.f1910a.f1896e.get()) {
                        this.f1909c.f1912c.f1913a.m2009a(this.f1909c.f1910a);
                    }
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    this.f1908b = true;
                    this.f1909c.f1912c.f1913a.m2010a(this.f1909c.f1910a, null);
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (this.f1909c.f1910a.f1898g || str.equals(this.f1909c.f1910a.f1893b)) {
                        return false;
                    }
                    return true;
                }
            }

            ClickManager(ClickManager clickManager, Click click, Handler handler) {
                this.f1912c = clickManager;
                this.f1910a = click;
                this.f1911b = handler;
            }

            public void run() {
                new WebViewNetworkTask(new NetworkRequest(RequestType.GET, this.f1910a.f1893b, false, null), new ClickManager(this)).m1742a();
            }
        }

        public ClickManager(ClickManager clickManager) {
            this.f1913a = clickManager;
        }

        public void m2007a(Click click) {
            click.f1896e.set(false);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new ClickManager(this, click, handler));
        }
    }

    /* renamed from: com.inmobi.rendering.a.c.c */
    static final class ClickManager {
        private ClickManager f1914a;

        public ClickManager(ClickManager clickManager) {
            this.f1914a = clickManager;
        }

        public void m2008a(Click click) {
            NetworkRequest networkRequest = new NetworkRequest(RequestType.GET, click.f1893b, false, null);
            networkRequest.m1705a(false);
            networkRequest.m1707b(click.f1898g);
            networkRequest.m1706b(ClickManager.f4473j.m1456c() * 1000);
            networkRequest.m1708c(ClickManager.f4473j.m1456c() * 1000);
            NetworkResponse a = new SyncNetworkTask(networkRequest).m1740a();
            if (a.m1737a()) {
                ErrorCode a2 = a.m1739c().m1699a();
                if (click.f1898g || !(ErrorCode.HTTP_SEE_OTHER == a2 || ErrorCode.HTTP_MOVED_TEMP == a2)) {
                    this.f1914a.m2010a(click, a.m1739c().m1699a());
                    return;
                } else {
                    this.f1914a.m2009a(click);
                    return;
                }
            }
            this.f1914a.m2009a(click);
        }
    }

    /* renamed from: com.inmobi.rendering.a.c.d */
    interface ClickManager {
        void m2009a(Click click);

        void m2010a(Click click, ErrorCode errorCode);
    }

    /* renamed from: com.inmobi.rendering.a.c.2 */
    class ClickManager implements NetworkConnectivityChangeObserver {
        final /* synthetic */ ClickManager f4460a;

        ClickManager(ClickManager clickManager) {
            this.f4460a = clickManager;
        }

        public void m5168a(boolean z) {
            if (z) {
                this.f4460a.m5188b();
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.c.3 */
    class ClickManager implements ClickManager {
        final /* synthetic */ ClickManager f4461a;

        ClickManager(ClickManager clickManager) {
            this.f4461a = clickManager;
        }

        public void m5169a(Click click) {
            if (click != null) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Processing click (" + click.f1892a + ") completed");
                ClickManager.f4471h.m1998b(click);
            }
        }

        public void m5170a(Click click, ErrorCode errorCode) {
            if (click != null) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ClickManager.f4464a, "Pinging click (" + click.f1892a + ") failed! Updating retry counts and timestamps ...");
                this.f4461a.m5178a(click);
                this.f4461a.m5188b();
            }
        }
    }

    static {
        f4464a = ClickManager.class.getSimpleName();
        f4466c = new Object();
        f4470g = new ArrayList();
        f4472i = new AtomicBoolean(false);
        f4474k = new Object();
    }

    public static ClickManager m5176a() {
        ClickManager clickManager = f4465b;
        if (clickManager == null) {
            synchronized (f4466c) {
                clickManager = f4465b;
                if (clickManager == null) {
                    clickManager = new ClickManager();
                    f4465b = clickManager;
                }
            }
        }
        return clickManager;
    }

    public void m5186a(Config config) {
        f4473j = ((com.inmobi.ads.AdConfig) config).m5034i();
    }

    public void m5188b() {
        if (NetworkUtils.m1783a()) {
            synchronized (f4474k) {
                if (f4472i.compareAndSet(false, true)) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "Resume processing clicks ...");
                    if (f4469f == null) {
                        f4469f = new HandlerThread("pingHandlerThread");
                        f4469f.start();
                    }
                    if (f4468e == null) {
                        f4468e = new ClickManager(this, f4469f.getLooper());
                    }
                    if (f4471h.m1996a()) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "Done processing all clicks!");
                        f4472i.set(false);
                        m5190c();
                    } else {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        f4468e.sendMessage(obtain);
                    }
                }
            }
        }
    }

    public void m5187a(String str, boolean z) {
        Click click = new Click(str, z, false, f4473j.m1454a() + 1);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "Received click (" + click.f1892a + ") for pinging over HTTP");
        m5180b(click);
    }

    public void m5189b(String str, boolean z) {
        Click click = new Click(str, z, true, f4473j.m1454a() + 1);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "Received click (" + click.f1892a + ") for pinging in WebView");
        m5180b(click);
    }

    public void m5190c() {
        f4472i.set(false);
        synchronized (f4474k) {
            if (!f4472i.get()) {
                if (f4469f != null) {
                    f4469f.getLooper().quit();
                    f4469f.interrupt();
                    f4469f = null;
                    f4468e = null;
                }
                f4470g.clear();
            }
        }
    }

    private void m5178a(Click click) {
        if (click.f1895d > 0) {
            click.f1895d--;
            click.f1894c = System.currentTimeMillis();
            f4471h.m1995a(click);
        }
    }

    private void m5180b(Click click) {
        f4471h.m1997a(click, f4473j.m1457d());
        if (NetworkUtils.m1783a()) {
            f4467d.submit(new ClickManager(this, click));
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "No network available. Saving click for later processing ...");
        f4472i.set(false);
        m5190c();
    }

    private ClickManager() {
        this.f4475l = new ClickManager(this);
        Logger.m1744a(InternalLogLevel.INTERNAL, f4464a, "Creating a new instance ...");
        f4467d = Executors.newFixedThreadPool(5);
        f4469f = new HandlerThread("pingHandlerThread");
        f4469f.start();
        f4468e = new ClickManager(this, f4469f.getLooper());
        Config adConfig = new com.inmobi.ads.AdConfig();
        com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(adConfig, (ConfigComponent) this);
        f4473j = adConfig.m5034i();
        f4471h = new ClickDao();
        com.inmobi.commons.core.utilities.NetworkConnectivityChangeObserver.m1775a().m1779a(new ClickManager(this));
    }
}
