package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.commons.p000a.SdkContext;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.e */
final class ConfigNetworkRequest extends NetworkRequest {
    private static final String f4435d;
    private static String f4436h;
    private int f4437e;
    private int f4438f;
    private Map<String, Config> f4439g;

    static {
        f4435d = ConfigNetworkRequest.class.getSimpleName();
        f4436h = "http://config.inmobi.com/config-server/v1/config/secure.cfg";
    }

    public ConfigNetworkRequest(Map<String, Config> map, UidMap uidMap, String str, int i, int i2) {
        RequestType requestType = RequestType.POST;
        if (str == null || str.trim().length() == 0) {
            str = f4436h;
        }
        super(requestType, str, true, uidMap);
        this.f4439g = map;
        this.f4437e = i;
        this.f4438f = i2;
    }

    public void m5126a() {
        super.m1703a();
        this.c.put("p", m5125e());
        this.c.put("im-accid", SdkContext.m1564c());
    }

    private String m5125e() {
        ConfigDao configDao = new ConfigDao();
        String str = XMLConstants.NULL_NS_URI;
        try {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f4439g.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("n", entry.getKey());
                jSONObject.put("t", configDao.m1676b((String) entry.getKey()));
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f4435d, "Problem while creating config network request's payload.", e);
            return str;
        }
    }

    public Map<String, Config> m5128b() {
        return this.f4439g;
    }

    public int m5129c() {
        return this.f4437e;
    }

    public int m5130d() {
        return this.f4438f;
    }

    public void m5127a(String str) {
        this.f4439g.remove(str);
    }
}
