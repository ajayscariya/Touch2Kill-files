package com.inmobi.commons.core.configs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.commons.core.configs.ConfigNetworkClient.ConfigNetworkClient;
import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse;
import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse.ConfigResponseStatus;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.commons.p000a.SdkInfo;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import org.json.JSONException;

/* renamed from: com.inmobi.commons.core.configs.b */
public class ConfigComponent {
    private static final String f1573a;
    private static final Object f1574b;
    private static Map<Config, ArrayList<WeakReference<ConfigComponent>>> f1575c;
    private static RootConfig f1576d;
    private static volatile ConfigComponent f1577e;
    private static ConfigComponent f1578f;
    private HandlerThread f1579g;
    private ConfigComponent f1580h;
    private boolean f1581i;

    /* renamed from: com.inmobi.commons.core.configs.b.b */
    public interface ConfigComponent {
        void m1655a(Config config);
    }

    /* renamed from: com.inmobi.commons.core.configs.b.a */
    static final class ConfigComponent extends Handler implements ConfigNetworkClient {
        private List<Config> f4431a;
        private Map<String, Map<String, Config>> f4432b;
        private Map<String, Config> f4433c;
        private ExecutorService f4434d;

        ConfigComponent(Looper looper) {
            super(looper);
            this.f4431a = new ArrayList();
            this.f4432b = new HashMap();
            this.f4433c = new HashMap();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    Config config = (Config) message.obj;
                    Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Fetch requested for config:" + config.m1649a() + ". IsAlreadyScheduled:" + m5120a(config.m1649a()));
                    if (m5120a(config.m1649a())) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config fetching already in progress:" + config.m1649a());
                        return;
                    }
                    this.f4431a.add(config);
                    if (!hasMessages(2)) {
                        sendEmptyMessage(2);
                    }
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    sendEmptyMessageDelayed(3, (long) (ConfigComponent.f1576d.m5148g() * 1000));
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    m5119a(this.f4431a);
                    this.f4431a.clear();
                    if (this.f4434d == null || this.f4434d.isShutdown()) {
                        this.f4434d = Executors.newFixedThreadPool(1);
                        sendEmptyMessage(4);
                    }
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    Entry entry;
                    if (this.f4432b.isEmpty()) {
                        entry = null;
                    } else {
                        entry = (Entry) this.f4432b.entrySet().iterator().next();
                    }
                    if (entry != null) {
                        this.f4433c = (Map) entry.getValue();
                        this.f4432b.remove(entry.getKey());
                        m5118a((String) entry.getKey(), this.f4433c);
                        return;
                    }
                    Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config fetching stopping as no more configs left to fetch.");
                    sendEmptyMessage(5);
                case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                    m5121a();
                default:
            }
        }

        public void m5121a() {
            if (this.f4434d != null && !this.f4434d.isShutdown()) {
                this.f4433c = null;
                this.f4432b.clear();
                removeMessages(3);
                this.f4434d.shutdownNow();
            }
        }

        private boolean m5120a(String str) {
            boolean z;
            if (this.f4432b.get(ConfigComponent.f1576d.m5142b(str)) == null || !((Map) this.f4432b.get(ConfigComponent.f1576d.m5142b(str))).containsKey(str)) {
                z = false;
            } else {
                z = true;
            }
            if (this.f4433c == null || !this.f4433c.containsKey(str)) {
                return z;
            }
            return true;
        }

        private void m5118a(String str, Map<String, Config> map) {
            int f = ConfigComponent.f1576d.m5147f();
            Map<String, Config> map2 = map;
            this.f4434d.execute(new ConfigNetworkClient(this, new ConfigNetworkRequest(map2, new UidMap(ConfigComponent.f1576d.m1654n().m1648a()), str, ConfigComponent.f1576d.m5146e(), f)));
        }

        private void m5119a(List<Config> list) {
            for (int i = 0; i < list.size(); i++) {
                Config config = (Config) list.get(i);
                HashMap hashMap = (HashMap) this.f4432b.get(ConfigComponent.f1576d.m5142b(config.m1649a()));
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(config.m1649a(), config);
                this.f4432b.put(ConfigComponent.f1576d.m5142b(config.m1649a()), hashMap);
            }
        }

        public void m5122a(ConfigResponse configResponse) {
            ConfigDao configDao = new ConfigDao();
            if (configResponse.m1640d()) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config fetching failed:" + configResponse.m1636a().m1649a() + ", Error code:" + configResponse.m1639c().m1633a());
                return;
            }
            Config a = configResponse.m1636a();
            configDao.m1673a(a);
            if (configResponse.m1638b() == ConfigResponseStatus.NOT_MODIFIED) {
                Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config not modified status from server:" + configResponse.m1636a().m1649a());
                configDao.m1674a(configResponse.m1636a().m1649a(), System.currentTimeMillis());
                return;
            }
            try {
                Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config cached successfully:" + configResponse.m1636a().m1649a());
                Logger.m1744a(InternalLogLevel.INTERNAL, ConfigComponent.f1573a, "Config cached successfully:" + a.m1651b().toString());
                ConfigComponent.m1661b(a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void m5123b() {
            sendEmptyMessage(4);
        }
    }

    /* renamed from: com.inmobi.commons.core.configs.b.c */
    static class ConfigComponent implements ConfigComponent {
        ConfigComponent() {
        }

        public void m5124a(Config config) {
            ConfigComponent.f1576d = (RootConfig) config;
        }
    }

    static {
        f1573a = ConfigComponent.class.getSimpleName();
        f1574b = new Object();
    }

    public static ConfigComponent m1656a() {
        ConfigComponent configComponent = f1577e;
        if (configComponent == null) {
            synchronized (f1574b) {
                configComponent = f1577e;
                if (configComponent == null) {
                    configComponent = new ConfigComponent();
                    f1577e = configComponent;
                }
            }
        }
        return configComponent;
    }

    private ConfigComponent() {
        this.f1581i = false;
        f1575c = new HashMap();
        this.f1579g = new HandlerThread("ConfigBootstrapHandler");
        this.f1579g.start();
        this.f1580h = new ConfigComponent(this.f1579g.getLooper());
        f1576d = new RootConfig();
    }

    public synchronized void m1669b() {
        if (!this.f1581i) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Starting config component.");
            this.f1581i = true;
            TelemetryComponent.m5070a().m5093a("root", f1576d.m5150i());
            if (f1578f == null) {
                f1578f = new ConfigComponent();
            }
            m1668a(f1576d, f1578f);
            m1667g();
        }
    }

    public synchronized void m1670c() {
        if (this.f1581i) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Stopping config component.");
            this.f1581i = false;
            this.f1580h.sendEmptyMessage(5);
        }
    }

    private void m1662b(Config config, ConfigComponent configComponent) {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) f1575c.get(config);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        arrayList.add(configComponent == null ? null : new WeakReference(configComponent));
        f1575c.put(config, arrayList);
    }

    private void m1667g() {
        for (Entry key : f1575c.entrySet()) {
            Config config = (Config) key.getKey();
            m1663c(config);
            ConfigComponent.m1661b(config);
        }
    }

    private static void m1661b(Config config) {
        ArrayList arrayList = (ArrayList) f1575c.get(config);
        if (arrayList != null) {
            int i = 0;
            while (i < arrayList.size()) {
                if (!(arrayList.get(i) == null || ((WeakReference) arrayList.get(i)).get() == null)) {
                    ((ConfigComponent) ((WeakReference) arrayList.get(i)).get()).m1655a(config);
                }
                i++;
            }
        }
    }

    public final synchronized void m1668a(Config config, ConfigComponent configComponent) {
        if (this.f1581i) {
            m1662b(config, configComponent);
            m1663c(config);
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Config component not yet started, config can't be fetched. Requested type:" + config.m1649a());
        }
    }

    public final void m1671d() {
        String a = f1576d.m5149h().m1697a();
        String b = f1576d.m5149h().m1698b();
        if (a.trim().length() != 0 && ConfigComponent.m1660a(SdkInfo.m1572b(), a.trim())) {
            Logger.m1744a(InternalLogLevel.DEBUG, f1573a, "A newer version (version " + a + ") of the InMobi SDK is available! " + "You are currently on an older version (Version " + SdkInfo.m1572b() + "). Please download the latest InMobi SDK from " + b);
        }
    }

    private final synchronized void m1663c(Config config) {
        ConfigDao configDao = new ConfigDao();
        if (configDao.m1675a(f1576d.m5140a())) {
            configDao.m1677b(f1576d);
            if (m1659a(configDao.m1676b(f1576d.m5140a()), f1576d.m5139a(f1576d.m5140a()))) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "RootConfig expired. Fetching root.");
                m1664d(f1576d.m5145d());
            }
            if (configDao.m1675a(config.m1649a())) {
                configDao.m1677b(config);
                if (m1659a(configDao.m1676b(config.m1649a()), f1576d.m5139a(config.m1649a()))) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Requested config expired. Returning currently cached and fetching. Config type:" + config.m1649a());
                    m1664d(config.m1653d());
                } else {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Serving config from cache. Config:" + config.m1649a());
                }
            } else {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "Requested config not present. Returning default and fetching. Config type:" + config.m1649a());
                m1664d(config.m1653d());
            }
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1573a, "RootConfig not available. Fetching root and returning defaults for config type:" + config.m1649a());
            m1664d(f1576d.m5145d());
        }
    }

    private boolean m1659a(long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            return true;
        }
        return false;
    }

    private void m1664d(Config config) {
        Message obtainMessage = this.f1580h.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = config;
        this.f1580h.sendMessage(obtainMessage);
    }

    public static boolean m1660a(String str, String str2) {
        boolean z = true;
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length) {
            try {
                if (Integer.valueOf(split[i]).intValue() < 0) {
                    return false;
                }
                i++;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        for (String valueOf : split2) {
            if (Integer.valueOf(valueOf).intValue() < 0) {
                return false;
            }
        }
        i = split.length < split2.length ? split.length : split2.length;
        int i2 = 0;
        while (i2 < i) {
            if (split[i2].equals(split2[i2])) {
                i2++;
            } else {
                boolean z2;
                if (Integer.valueOf(split[i2]).intValue() < Integer.valueOf(split2[i2]).intValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return z2;
            }
        }
        if (split.length >= split2.length) {
            z = false;
        }
        return z;
    }
}
