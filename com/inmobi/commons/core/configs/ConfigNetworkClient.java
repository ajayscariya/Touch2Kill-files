package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse;
import com.inmobi.commons.core.network.SyncNetworkTask;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.inmobi.commons.core.configs.d */
class ConfigNetworkClient implements Runnable {
    private static final String f1583a;
    private ConfigNetworkRequest f1584b;
    private int f1585c;
    private ConfigNetworkClient f1586d;

    /* renamed from: com.inmobi.commons.core.configs.d.a */
    public interface ConfigNetworkClient {
        void m1678a(ConfigResponse configResponse);

        void m1679b();
    }

    static {
        f1583a = ConfigNetworkClient.class.getName();
    }

    public ConfigNetworkClient(ConfigNetworkClient configNetworkClient, ConfigNetworkRequest configNetworkRequest) {
        this.f1586d = configNetworkClient;
        this.f1584b = configNetworkRequest;
        this.f1585c = 0;
    }

    private void m1680a() throws InterruptedException {
        while (this.f1585c <= this.f1584b.m5129c()) {
            Map a = new ConfigNetworkResponse(this.f1584b.m5128b(), new SyncNetworkTask(this.f1584b).m1740a()).m1645a();
            for (Entry entry : a.entrySet()) {
                ConfigResponse configResponse = (ConfigResponse) entry.getValue();
                String str = (String) entry.getKey();
                if (!configResponse.m1640d()) {
                    this.f1586d.m1678a(configResponse);
                    this.f1584b.m5127a(str);
                }
            }
            if (this.f1584b.m5128b().isEmpty()) {
                break;
            }
            this.f1585c++;
            if (this.f1585c > this.f1584b.m5129c()) {
                for (Entry entry2 : this.f1584b.m5128b().entrySet()) {
                    str = (String) entry2.getKey();
                    if (a.containsKey(str)) {
                        this.f1586d.m1678a((ConfigResponse) a.get(str));
                    }
                }
            } else {
                Thread.sleep((long) (this.f1584b.m5130d() * 1000));
            }
        }
        this.f1586d.m1679b();
    }

    public void run() {
        try {
            m1680a();
        } catch (InterruptedException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1583a, "Fetching config interrupted by the component de-initialization.");
        }
    }
}
