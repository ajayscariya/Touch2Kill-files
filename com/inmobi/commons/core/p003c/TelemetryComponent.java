package com.inmobi.commons.core.p003c;

import android.content.ContentValues;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent.ConfigComponent;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.p001a.CrashEvent;
import com.inmobi.commons.core.p003c.TelemetryComponentConfig.TelemetryComponentConfig;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkConnectivityChangeObserver.NetworkConnectivityChangeObserver;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.commons.p000a.SdkContext;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.c.a */
public class TelemetryComponent implements ConfigComponent {
    private static final String f4408a;
    private static final Object f4409b;
    private static volatile TelemetryComponent f4410c;
    private static final AtomicBoolean f4411d;
    private static final AtomicBoolean f4412e;
    private static Map<String, TelemetryComponentConfig> f4413f;
    private static TelemetryConfig f4414h;
    private static final Random f4415o;
    private List<TelemetryEvent> f4416g;
    private HandlerThread f4417i;
    private TelemetryComponent f4418j;
    private Map<String, Integer> f4419k;
    private final Object f4420l;
    private final Object f4421m;
    private final Object f4422n;

    /* renamed from: com.inmobi.commons.core.c.a.a */
    private final class TelemetryComponent extends Handler {
        final /* synthetic */ TelemetryComponent f1534a;
        private String f1535b;
        private String f1536c;
        private TelemetryDao f1537d;
        private int f1538e;
        private int f1539f;
        private int f1540g;
        private AtomicBoolean f1541h;
        private int f1542i;
        private int f1543j;
        private boolean f1544k;
        private List<TelemetryEvent> f1545l;

        public TelemetryComponent(TelemetryComponent telemetryComponent, Looper looper) {
            this.f1534a = telemetryComponent;
            super(looper);
            this.f1541h = new AtomicBoolean(false);
            this.f1542i = 0;
            this.f1545l = new ArrayList();
            this.f1536c = null;
            m1598a();
        }

        private void m1598a() {
            this.f1538e = TelemetryComponent.f4414h.m5113i();
            this.f1535b = TelemetryComponent.f4414h.m5110f();
            this.f1539f = TelemetryComponent.f4414h.m5115k() * 1000;
            this.f1540g = TelemetryComponent.f4414h.m5111g() * 1000;
            this.f1543j = TelemetryComponent.f4414h.m5114j();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    removeMessages(1);
                    if (!this.f1541h.compareAndSet(false, true)) {
                        return;
                    }
                    if (SdkContext.m1567e() && NetworkUtils.m1783a()) {
                        m1598a();
                        m1600b();
                        return;
                    }
                    Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "App not in foreground or No Network available ");
                    this.f1541h.set(false);
                    if (!SdkContext.m1567e()) {
                        sendEmptyMessage(4);
                    }
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    m1601c();
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    this.f1541h.set(false);
                    sendEmptyMessageDelayed(1, (long) this.f1539f);
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    TelemetryComponent.m5070a().m5087i();
                default:
            }
        }

        private void m1600b() {
            Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Begin reporting");
            this.f1537d = new TelemetryDao();
            List a = this.f1537d.m1619a();
            if (!a.isEmpty()) {
                this.f1544k = true;
                this.f1536c = m1599b(a);
            } else if (this.f1536c == null || this.f1536c.equals(XMLConstants.NULL_NS_URI)) {
                this.f1544k = false;
                if (this.f1545l.isEmpty()) {
                    this.f1545l = this.f1537d.m1620a(this.f1538e);
                }
                if (this.f1545l.isEmpty()) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "No events to report");
                    sendEmptyMessage(3);
                    return;
                }
                this.f1536c = m1597a(this.f1545l);
            }
            sendEmptyMessage(2);
        }

        private void m1601c() {
            NetworkRequest networkRequest = new NetworkRequest(RequestType.POST, this.f1535b, true, new UidMap(TelemetryComponent.f4414h.m1654n().m1648a()));
            Map hashMap = new HashMap();
            if (this.f1544k) {
                hashMap.put("metric", this.f1536c);
            } else {
                hashMap.put("telemetry", this.f1536c);
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Telemetry Payload: " + this.f1536c);
            networkRequest.m1709c(hashMap);
            NetworkResponse a = new SyncNetworkTask(networkRequest).m1740a();
            if (a.m1737a()) {
                this.f1542i++;
                if (this.f1542i > this.f1543j) {
                    this.f1542i = 0;
                    Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Unable to send telemetry events to server: " + a.m1738b() + " . And retry count exhausted. Will Discard Events");
                    this.f1545l.clear();
                    this.f1536c = null;
                    sendEmptyMessage(3);
                    return;
                }
                Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Unable to send telemetry events to server: " + a.m1738b() + ". Will retry");
                this.f1541h.set(false);
                sendEmptyMessageDelayed(1, (long) this.f1540g);
                return;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Successfully sent events to server: " + a.m1738b());
            this.f1536c = null;
            this.f1545l.clear();
            if (this.f1537d.m1625c() > this.f1538e) {
                this.f1541h.set(false);
                sendEmptyMessage(1);
                return;
            }
            sendEmptyMessage(3);
        }

        private String m1597a(List<TelemetryEvent> list) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("componentType", ((TelemetryEvent) list.get(i)).m1627a());
                    jSONObject.put("eventType", ((TelemetryEvent) list.get(i)).m1629b());
                    if (!((TelemetryEvent) list.get(i)).m1630c().trim().isEmpty()) {
                        jSONObject.put("payload", ((TelemetryEvent) list.get(i)).m1630c());
                    }
                    jSONObject.put("ts", ((TelemetryEvent) list.get(i)).m1631d());
                    jSONArray.put(jSONObject);
                    i++;
                } catch (JSONException e) {
                    return XMLConstants.NULL_NS_URI;
                }
            }
            return jSONArray.toString();
        }

        private String m1599b(List<ContentValues> list) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("componentType", ((ContentValues) list.get(i)).getAsString("componentType"));
                    jSONObject.put("eventType", ((ContentValues) list.get(i)).getAsString("eventType"));
                    jSONObject.put("payload", ((ContentValues) list.get(i)).getAsString("payload"));
                    jSONArray.put(jSONObject);
                    i++;
                } catch (JSONException e) {
                    return XMLConstants.NULL_NS_URI;
                }
            }
            return jSONArray.toString();
        }
    }

    /* renamed from: com.inmobi.commons.core.c.a.1 */
    class TelemetryComponent implements NetworkConnectivityChangeObserver {
        final /* synthetic */ TelemetryComponent f4407a;

        TelemetryComponent(TelemetryComponent telemetryComponent) {
            this.f4407a = telemetryComponent;
        }

        public void m5069a(boolean z) {
            Logger.m1744a(InternalLogLevel.INTERNAL, TelemetryComponent.f4408a, "Network status changed " + z);
            if (z && !TelemetryComponent.f4412e.get() && SdkContext.m1567e()) {
                TelemetryComponent.m5070a().m5072a(60);
            }
            TelemetryComponent.f4412e.set(z);
        }
    }

    static {
        f4408a = TelemetryComponent.class.getSimpleName();
        f4409b = new Object();
        f4411d = new AtomicBoolean(false);
        f4412e = new AtomicBoolean(false);
        f4415o = new Random(System.currentTimeMillis());
    }

    public static TelemetryComponent m5070a() {
        TelemetryComponent telemetryComponent = f4410c;
        if (telemetryComponent == null) {
            synchronized (f4409b) {
                telemetryComponent = f4410c;
                if (telemetryComponent == null) {
                    telemetryComponent = new TelemetryComponent();
                    f4410c = telemetryComponent;
                }
            }
        }
        return telemetryComponent;
    }

    private TelemetryComponent() {
        this.f4420l = new Object();
        this.f4421m = new Object();
        this.f4422n = new Object();
        this.f4416g = new ArrayList();
        f4413f = new HashMap();
        this.f4419k = new HashMap();
        f4414h = new TelemetryConfig();
        f4412e.set(NetworkUtils.m1783a());
        com.inmobi.commons.core.configs.ConfigComponent.m1656a().m1668a(f4414h, (ConfigComponent) this);
        m5075a(f4414h.m5104a(), f4414h.m5117m());
        com.inmobi.commons.core.utilities.NetworkConnectivityChangeObserver.m1775a().m1779a(new TelemetryComponent(this));
    }

    public void m5091a(Config config) {
        f4414h = (TelemetryConfig) config;
    }

    public final void m5093a(String str, JSONObject jSONObject) {
        m5075a(str, new TelemetryComponentConfig(str, jSONObject, f4414h.m5117m()));
    }

    private void m5075a(String str, TelemetryComponentConfig telemetryComponentConfig) {
        if (str == null || str.trim().equals(XMLConstants.NULL_NS_URI)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Component type provided while registering is null or empty!");
        } else if (telemetryComponentConfig != null) {
            f4413f.put(str, telemetryComponentConfig);
        } else {
            f4413f.put(str, new TelemetryComponentConfig(str, null, f4414h.m5117m()));
        }
    }

    TelemetryComponentConfig m5089a(String str) {
        if (str != null && !str.trim().equals(XMLConstants.NULL_NS_URI)) {
            return (TelemetryComponentConfig) f4413f.get(str);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Request null or empty Component type!");
        return null;
    }

    public void m5092a(String str, String str2, Map<String, Object> map) {
        TelemetryEvent telemetryEvent = new TelemetryEvent(str, str2);
        if (!(map == null || map.isEmpty())) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Entry entry : map.entrySet()) {
                    jSONObject.put(entry.getKey().toString(), entry.getValue());
                }
                telemetryEvent.m1628a(jSONObject.toString());
            } catch (JSONException e) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Error forming JSON payload for " + str2 + " Error: " + e);
            }
        }
        TelemetryComponent.m5070a().m5090a(telemetryEvent);
    }

    public void m5090a(TelemetryEvent telemetryEvent) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Event submitted to telemetry: " + telemetryEvent.m1629b() + " - " + telemetryEvent.m1627a());
        TelemetryComponentConfig f = m5082f(telemetryEvent);
        if (f != null && f.m1615b() && f4414h.m5109e()) {
            m5077c(telemetryEvent);
            m5079d(telemetryEvent);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Telemetry service is not enabled or registered for component: " + telemetryEvent.m1627a());
    }

    private void m5077c(TelemetryEvent telemetryEvent) {
        if (m5084g(telemetryEvent).m1607c()) {
            m5095b(telemetryEvent);
        }
    }

    private void m5079d(TelemetryEvent telemetryEvent) {
        int b = m5084g(telemetryEvent).m1606b();
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Event Sampling factor: " + b);
        if (b <= 0) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Sampling factor is <=0 for this event!");
        } else if (f4415o.nextInt(b) != 0) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Event " + telemetryEvent.m1629b() + " is not lucky enough to be processed further");
        } else {
            m5081e(telemetryEvent);
        }
    }

    private void m5081e(TelemetryEvent telemetryEvent) {
        if (telemetryEvent instanceof CrashEvent) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Got a crash event, will save it right away!");
            new TelemetryDao().m1621a(telemetryEvent);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Caching event " + telemetryEvent.m1629b() + " in memory");
        int h = f4414h.m5112h();
        synchronized (this.f4422n) {
            this.f4416g.add(telemetryEvent);
        }
        if (this.f4416g.size() >= h) {
            m5085g();
            h = new TelemetryDao().m1625c();
            int l = f4414h.m5116l();
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Current event count: " + h + " Upper cap: " + l);
            if (h > (l * 3) / 4) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Telemetry is more than 75% full. Begin reporting ");
                m5086h();
            }
        }
    }

    private void m5085g() {
        synchronized (this.f4422n) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Adding events " + this.f4416g.toString() + "to persistence");
            TelemetryDao telemetryDao = new TelemetryDao();
            int l = f4414h.m5116l();
            int c = telemetryDao.m1625c();
            if ((this.f4416g.size() + c) - l <= 0) {
                telemetryDao.m1623a(this.f4416g);
            } else {
                l -= c;
                if (l <= 0) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Persistence is full, won't add events");
                } else {
                    telemetryDao.m1623a(this.f4416g.subList(0, l));
                    Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Persistence will overflow, will add " + l + " events to persistence");
                }
            }
            this.f4416g.clear();
        }
    }

    private TelemetryComponentConfig m5082f(TelemetryEvent telemetryEvent) {
        return TelemetryComponent.m5070a().m5089a(telemetryEvent.m1627a());
    }

    private TelemetryComponentConfig m5084g(TelemetryEvent telemetryEvent) {
        return m5082f(telemetryEvent).m1609a(telemetryEvent.m1629b());
    }

    private void m5086h() {
        m5072a(0);
    }

    private void m5072a(int i) {
        if (SdkContext.m1567e() && NetworkUtils.m1783a()) {
            synchronized (this.f4421m) {
                if (f4411d.compareAndSet(false, true)) {
                    this.f4417i = new HandlerThread("telemetry");
                    this.f4417i.start();
                    this.f4418j = new TelemetryComponent(this, this.f4417i.getLooper());
                }
                if (i > 0) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Begin reporting after " + i + " seconds");
                    this.f4418j.sendEmptyMessageDelayed(1, (long) (i * 1000));
                } else {
                    this.f4418j.sendEmptyMessage(1);
                }
            }
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "App not in foreground or No Network available");
    }

    public synchronized void m5094b() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "start called");
        TelemetryComponent.m5070a().m5086h();
    }

    public synchronized void m5096c() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "stop called");
        TelemetryComponent.m5070a().m5088j();
        TelemetryComponent.m5070a().m5085g();
    }

    private void m5087i() {
        synchronized (this.f4421m) {
            if (this.f4417i != null) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Deiniting telemetry");
                this.f4417i.getLooper().quit();
                this.f4417i.interrupt();
                this.f4417i = null;
                this.f4418j = null;
                f4411d.set(false);
            }
        }
    }

    void m5095b(TelemetryEvent telemetryEvent) {
        String a = telemetryEvent.m1627a();
        String b = telemetryEvent.m1629b();
        Logger.m1744a(InternalLogLevel.INTERNAL, f4408a, "Metric collected: " + b + " - " + a);
        b = m5071a(a, b);
        synchronized (this.f4420l) {
            if (this.f4419k.containsKey(b)) {
                this.f4419k.put(b, Integer.valueOf(((Integer) this.f4419k.get(b)).intValue() + 1));
            } else {
                this.f4419k.put(b, Integer.valueOf(1));
            }
        }
    }

    private String m5071a(String str, String str2) {
        return str + "@$#$@" + str2;
    }

    private String[] m5076b(String str) {
        return str.split("\\@\\$\\#\\$\\@");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5088j() {
        /*
        r7 = this;
        r2 = r7.f4420l;
        monitor-enter(r2);
        r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;	 Catch:{ all -> 0x005b }
        r1 = f4408a;	 Catch:{ all -> 0x005b }
        r3 = "Saving metric to persistence";
        com.inmobi.commons.core.utilities.Logger.m1744a(r0, r1, r3);	 Catch:{ all -> 0x005b }
        r3 = new com.inmobi.commons.core.c.d;	 Catch:{ all -> 0x005b }
        r3.<init>();	 Catch:{ all -> 0x005b }
        r3.m1624b();	 Catch:{ all -> 0x005b }
        r0 = r7.f4419k;	 Catch:{ all -> 0x005b }
        r0 = r0.entrySet();	 Catch:{ all -> 0x005b }
        r4 = r0.iterator();	 Catch:{ all -> 0x005b }
    L_0x001e:
        r0 = r4.hasNext();	 Catch:{ all -> 0x005b }
        if (r0 == 0) goto L_0x005e;
    L_0x0024:
        r0 = r4.next();	 Catch:{ all -> 0x005b }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x005b }
        r1 = r0.getKey();	 Catch:{ all -> 0x005b }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x005b }
        r1 = r7.m5076b(r1);	 Catch:{ all -> 0x005b }
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0050 }
        r5.<init>();	 Catch:{ JSONException -> 0x0050 }
        r6 = "count";
        r0 = r0.getValue();	 Catch:{ JSONException -> 0x0050 }
        r5.put(r6, r0);	 Catch:{ JSONException -> 0x0050 }
        r0 = 0;
        r0 = r1[r0];	 Catch:{ JSONException -> 0x0050 }
        r6 = 1;
        r1 = r1[r6];	 Catch:{ JSONException -> 0x0050 }
        r5 = r5.toString();	 Catch:{ JSONException -> 0x0050 }
        r3.m1622a(r0, r1, r5);	 Catch:{ JSONException -> 0x0050 }
        goto L_0x001e;
    L_0x0050:
        r0 = move-exception;
        r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;	 Catch:{ all -> 0x005b }
        r1 = f4408a;	 Catch:{ all -> 0x005b }
        r5 = "Error forming metric payload";
        com.inmobi.commons.core.utilities.Logger.m1744a(r0, r1, r5);	 Catch:{ all -> 0x005b }
        goto L_0x001e;
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x005b }
        throw r0;
    L_0x005e:
        r0 = r7.f4419k;	 Catch:{ all -> 0x005b }
        r0.clear();	 Catch:{ all -> 0x005b }
        monitor-exit(r2);	 Catch:{ all -> 0x005b }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.commons.core.c.a.j():void");
    }
}
