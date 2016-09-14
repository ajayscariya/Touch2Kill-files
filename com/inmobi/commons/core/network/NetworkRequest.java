package com.inmobi.commons.core.network;

import android.util.Base64;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.ConfigComponent;
import com.inmobi.commons.core.configs.PkConfig;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.inmobi.commons.core.utilities.info.AppInfo;
import com.inmobi.commons.core.utilities.info.DeviceInfo;
import com.inmobi.commons.core.utilities.info.IdentityInfo;
import com.inmobi.commons.core.utilities.p004a.RequestEncryptionUtils;
import com.inmobi.commons.core.utilities.uid.UidMap;
import com.inmobi.commons.p000a.SdkContext;
import java.util.HashMap;
import java.util.Map;
import mf.javax.xml.XMLConstants;

public class NetworkRequest {
    private static final String f1596d;
    protected Map<String, String> f1597a;
    protected Map<String, String> f1598b;
    protected Map<String, String> f1599c;
    private RequestType f1600e;
    private String f1601f;
    private UidMap f1602g;
    private int f1603h;
    private int f1604i;
    private boolean f1605j;
    private boolean f1606k;
    private byte[] f1607l;
    private byte[] f1608m;
    private boolean f1609n;
    private long f1610o;

    public enum RequestType {
        GET,
        POST
    }

    static {
        f1596d = NetworkRequest.class.getSimpleName();
    }

    public NetworkRequest(RequestType requestType, String str, boolean z, UidMap uidMap) {
        this.f1597a = new HashMap();
        this.f1598b = new HashMap();
        this.f1599c = new HashMap();
        this.f1603h = 60000;
        this.f1604i = 60000;
        this.f1605j = true;
        this.f1609n = true;
        this.f1610o = -1;
        this.f1600e = requestType;
        this.f1601f = str;
        this.f1606k = z;
        this.f1602g = uidMap;
        this.f1597a.put("User-Agent", SdkContext.m1566d());
    }

    public void m1704a(long j) {
        this.f1610o = j;
    }

    public long m1711f() {
        return this.f1610o;
    }

    public boolean m1712g() {
        return this.f1610o != -1;
    }

    public void m1705a(boolean z) {
        this.f1609n = z;
    }

    public String m1713h() {
        return this.f1601f;
    }

    public void m1709c(Map<String, String> map) {
        this.f1599c.putAll(map);
    }

    public Map<String, String> m1714i() {
        NetworkUtils.m1782a(this.f1597a);
        return this.f1597a;
    }

    public void m1703a() {
        if (!this.f1609n) {
            return;
        }
        if (this.f1600e == RequestType.GET) {
            m1702a(this.f1598b);
        } else if (this.f1600e == RequestType.POST) {
            m1702a(this.f1599c);
        }
    }

    public String m1715j() {
        NetworkUtils.m1782a(this.f1598b);
        String a = NetworkUtils.m1781a(this.f1598b, "&");
        Logger.m1744a(InternalLogLevel.INTERNAL, f1596d, "Get params: " + a);
        return a;
    }

    public String m1716k() {
        NetworkUtils.m1782a(this.f1599c);
        String a = NetworkUtils.m1781a(this.f1599c, "&");
        Logger.m1744a(InternalLogLevel.INTERNAL, f1596d, "Post body url: " + m1713h());
        Logger.m1744a(InternalLogLevel.INTERNAL, f1596d, "Post body: " + a);
        if (!m1721p()) {
            return a;
        }
        a = m1701a(a);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1596d, "Encrypted post body: " + a);
        return a;
    }

    public boolean m1717l() {
        return this.f1605j;
    }

    public void m1707b(boolean z) {
        this.f1605j = z;
    }

    public RequestType m1718m() {
        return this.f1600e;
    }

    public int m1719n() {
        return this.f1603h;
    }

    public void m1706b(int i) {
        this.f1603h = i;
    }

    public void m1708c(int i) {
        this.f1604i = i;
    }

    public int m1720o() {
        return this.f1604i;
    }

    public boolean m1721p() {
        return this.f1606k;
    }

    private void m1702a(Map<String, String> map) {
        map.putAll(AppInfo.m1791a().m1795c());
        map.putAll(DeviceInfo.m1796a());
        map.putAll(IdentityInfo.m1802a());
        if (this.f1602g == null) {
            return;
        }
        if (m1721p()) {
            map.putAll(this.f1602g.m1879a());
        } else {
            map.putAll(this.f1602g.m1881b());
        }
    }

    private String m1701a(String str) {
        byte[] a = RequestEncryptionUtils.m1755a(8);
        this.f1607l = RequestEncryptionUtils.m1755a(16);
        this.f1608m = RequestEncryptionUtils.m1754a();
        Map hashMap = new HashMap();
        Config pkConfig = new PkConfig();
        ConfigComponent.m1656a().m1668a(pkConfig, null);
        hashMap.put("sm", RequestEncryptionUtils.m1753a(str, this.f1608m, this.f1607l, a, pkConfig.m5137f(), pkConfig.m5136e()));
        hashMap.put("sn", pkConfig.m5138g());
        return NetworkUtils.m1781a(hashMap, "&");
    }

    protected String m1710e(String str) {
        if (str == null || str.trim().length() == 0) {
            return XMLConstants.NULL_NS_URI;
        }
        byte[] a = RequestEncryptionUtils.m1759a(Base64.decode(str.getBytes(), 0), this.f1608m, this.f1607l);
        if (a != null) {
            return new String(a);
        }
        return null;
    }
}
