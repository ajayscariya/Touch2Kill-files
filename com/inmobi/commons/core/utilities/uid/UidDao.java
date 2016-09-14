package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import com.inmobi.commons.core.p002b.KeyValueStore;

/* renamed from: com.inmobi.commons.core.utilities.uid.b */
class UidDao {
    private KeyValueStore f1690a;

    public UidDao() {
        this.f1690a = KeyValueStore.m1590b("uid_store");
    }

    public UidDao(Context context) {
        this.f1690a = KeyValueStore.m1588a(context, "uid_store");
    }

    public void m1844a(String str) {
        this.f1690a.m1592a("adv_id", str);
    }

    public String m1842a() {
        return this.f1690a.m1595b("adv_id", null);
    }

    public void m1845a(boolean z) {
        this.f1690a.m1593a("limit_ad_tracking", z);
    }

    public boolean m1847b() {
        return this.f1690a.m1596b("limit_ad_tracking", true);
    }

    public void m1846b(String str) {
        this.f1690a.m1592a("app_id", str);
    }

    public String m1848c() {
        return this.f1690a.m1595b("app_id", null);
    }

    public void m1849c(String str) {
        this.f1690a.m1592a("im_id", str);
    }

    public String m1850d() {
        return this.f1690a.m1595b("im_id", null);
    }

    public void m1843a(long j) {
        this.f1690a.m1591a("imid_timestamp", j);
    }

    public long m1852e() {
        return this.f1690a.m1594b("imid_timestamp", 0);
    }

    public void m1851d(String str) {
        this.f1690a.m1592a("appended_id", str);
    }

    public String m1853f() {
        return this.f1690a.m1595b("appended_id", null);
    }
}
