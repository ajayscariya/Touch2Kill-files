package com.inmobi.commons.core.configs;

import com.applovin.sdk.AppLovinEventTypes;
import com.inmobi.commons.core.configs.ConfigError.ErrorCode;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

final class ConfigNetworkResponse {
    private static final String f1566a;
    private Map<String, Config> f1567b;
    private Map<String, ConfigResponse> f1568c;
    private NetworkResponse f1569d;
    private ConfigError f1570e;

    public static class ConfigResponse {
        private ConfigResponseStatus f1563a;
        private Config f1564b;
        private ConfigError f1565c;

        public enum ConfigResponseStatus {
            SUCCESS(200),
            NOT_MODIFIED(304),
            PRODUCT_NOT_FOUND(404),
            INTERNAL_ERROR(500),
            UNKNOWN(-1);
            
            private int f1562a;

            private ConfigResponseStatus(int i) {
                this.f1562a = i;
            }

            public int getValue() {
                return this.f1562a;
            }

            public static ConfigResponseStatus fromValue(int i) {
                for (ConfigResponseStatus configResponseStatus : values()) {
                    if (configResponseStatus.f1562a == i) {
                        return configResponseStatus;
                    }
                }
                return UNKNOWN;
            }
        }

        public ConfigResponse(JSONObject jSONObject, Config config) {
            this.f1564b = config;
            if (jSONObject != null) {
                m1635a(jSONObject);
            }
        }

        private void m1635a(JSONObject jSONObject) {
            try {
                this.f1563a = ConfigResponseStatus.fromValue(jSONObject.getInt(NotificationCompatApi21.CATEGORY_STATUS));
                if (this.f1563a == ConfigResponseStatus.SUCCESS) {
                    this.f1564b.m1650a(jSONObject.getJSONObject(AppLovinEventTypes.USER_VIEWED_CONTENT));
                    if (!this.f1564b.m1652c()) {
                        m1637a(new ConfigError(ErrorCode.PARSING_ERROR, "The received config has failed validation."));
                        Logger.m1744a(InternalLogLevel.INTERNAL, ConfigNetworkResponse.f1566a, "Config type:" + this.f1564b.m1649a() + " Error code:" + m1639c().m1633a() + " Error message:" + m1639c().m1634b());
                    }
                } else if (this.f1563a == ConfigResponseStatus.NOT_MODIFIED) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, ConfigNetworkResponse.f1566a, "Config type:" + this.f1564b.m1649a() + " Config not modified");
                } else {
                    m1637a(new ConfigError(ErrorCode.CONFIG_SERVER_INTERNAL_ERROR, this.f1563a.toString()));
                    Logger.m1744a(InternalLogLevel.INTERNAL, ConfigNetworkResponse.f1566a, "Config type:" + this.f1564b.m1649a() + " Error code:" + m1639c().m1633a() + " Error message:" + m1639c().m1634b());
                }
            } catch (Throwable e) {
                m1637a(new ConfigError(ErrorCode.PARSING_ERROR, e.getLocalizedMessage()));
                Logger.m1745a(InternalLogLevel.INTERNAL, ConfigNetworkResponse.f1566a, "Config type:" + this.f1564b.m1649a() + " Error code:" + m1639c().m1633a() + " Error message:" + m1639c().m1634b(), e);
                Map hashMap = new HashMap();
                hashMap.put("name", this.f1564b.m1649a());
                hashMap.put("errorCode", "ParsingError");
                hashMap.put("reason", e.getLocalizedMessage());
                TelemetryComponent.m5070a().m5092a("root", "InvalidConfig", hashMap);
            }
        }

        public Config m1636a() {
            return this.f1564b;
        }

        public ConfigResponseStatus m1638b() {
            return this.f1563a;
        }

        public ConfigError m1639c() {
            return this.f1565c;
        }

        public void m1637a(ConfigError configError) {
            this.f1565c = configError;
        }

        public boolean m1640d() {
            return this.f1565c != null;
        }
    }

    static {
        f1566a = ConfigNetworkResponse.class.getName();
    }

    ConfigNetworkResponse(Map<String, Config> map, NetworkResponse networkResponse) {
        this.f1567b = map;
        this.f1569d = networkResponse;
        this.f1568c = new HashMap();
        m1644d();
    }

    private void m1644d() {
        if (this.f1569d.m1737a()) {
            for (Entry entry : this.f1567b.entrySet()) {
                ConfigResponse configResponse = new ConfigResponse(null, (Config) entry.getValue());
                configResponse.m1637a(new ConfigError(ErrorCode.NETWORK_ERROR, "Network error in fetching config."));
                this.f1568c.put(entry.getKey(), configResponse);
            }
            m1642a(new ConfigError(ErrorCode.NETWORK_ERROR, this.f1569d.m1739c().m1700b()));
            Logger.m1744a(InternalLogLevel.INTERNAL, f1566a, "Error code:" + m1646b().m1633a() + " Error message:" + m1646b().m1634b());
            Map hashMap = new HashMap();
            hashMap.put("name", m1641a(this.f1567b));
            hashMap.put("errorCode", String.valueOf(this.f1569d.m1739c().m1699a().getValue()));
            hashMap.put("reason", this.f1569d.m1739c().m1700b());
            TelemetryComponent.m5070a().m5092a("root", "InvalidConfig", hashMap);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f1569d.m1738b());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (this.f1567b.get(str) != null) {
                    this.f1568c.put(str, new ConfigResponse(jSONObject2, (Config) this.f1567b.get(str)));
                }
            }
        } catch (Throwable e) {
            m1642a(new ConfigError(ErrorCode.PARSING_ERROR, e.getLocalizedMessage()));
            Logger.m1745a(InternalLogLevel.INTERNAL, f1566a, "Error code:" + m1646b().m1633a() + " Error message:" + m1646b().m1634b(), e);
            Map hashMap2 = new HashMap();
            hashMap2.put("name", m1641a(this.f1567b));
            hashMap2.put("errorCode", "ParsingError");
            hashMap2.put("reason", e.getLocalizedMessage());
            TelemetryComponent.m5070a().m5092a("root", "InvalidConfig", hashMap2);
        }
    }

    public Map<String, ConfigResponse> m1645a() {
        return this.f1568c;
    }

    public ConfigError m1646b() {
        return this.f1570e;
    }

    private void m1642a(ConfigError configError) {
        this.f1570e = configError;
    }

    private static String m1641a(Map<String, Config> map) {
        String str = XMLConstants.NULL_NS_URI;
        String str2 = str;
        for (String str3 : map.keySet()) {
            str2 = str2 + str3 + ",";
        }
        return str2.substring(0, str2.length() - 1);
    }
}
