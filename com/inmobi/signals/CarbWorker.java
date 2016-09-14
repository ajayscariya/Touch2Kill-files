package com.inmobi.signals;

import android.content.pm.PackageManager.NameNotFoundException;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.signals.SignalsConfig.SignalsConfig;
import java.util.ArrayList;
import java.util.List;
import mf.org.w3c.dom.traversal.NodeFilter;

/* renamed from: com.inmobi.signals.g */
public class CarbWorker {
    private static final String f2105a;
    private SignalsConfig f2106b;
    private boolean f2107c;
    private CarbDao f2108d;
    private CarbNetworkClient f2109e;

    /* renamed from: com.inmobi.signals.g.1 */
    class CarbWorker implements Runnable {
        final /* synthetic */ CarbWorker f2104a;

        CarbWorker(CarbWorker carbWorker) {
            this.f2104a = carbWorker;
        }

        public void run() {
            CarbGetListNetworkResponse a = this.f2104a.m2249c();
            if (!a.m2230a()) {
                this.f2104a.f2108d.m2173a(System.currentTimeMillis());
                if (!a.m2234e()) {
                    this.f2104a.m2242a(a, this.f2104a.m2241a(a.m2231b()));
                }
            }
            this.f2104a.f2107c = false;
        }
    }

    static {
        f2105a = CarbWorker.class.getSimpleName();
    }

    public CarbWorker() {
        this.f2107c = false;
        this.f2108d = new CarbDao();
        this.f2109e = new CarbNetworkClient();
    }

    public synchronized void m2250a(SignalsConfig signalsConfig) {
        this.f2106b = signalsConfig;
        if (this.f2107c || !m2244a()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2105a, "Carb worker did not admit Carb start request.");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2105a, "Starting Carb worker");
            this.f2107c = true;
            m2248b();
        }
    }

    private boolean m2244a() {
        long b = this.f2108d.m2174b();
        if (b != 0 && System.currentTimeMillis() - b < ((long) (this.f2106b.m2322d() * 1000))) {
            return false;
        }
        return true;
    }

    private void m2248b() {
        new Thread(new CarbWorker(this)).start();
    }

    private CarbGetListNetworkResponse m2249c() {
        CarbGetListNetworkRequest carbGetListNetworkRequest = new CarbGetListNetworkRequest(this.f2106b.m2320b(), this.f2106b.m2323e(), this.f2106b.m2324f(), SignalsComponent.m5202a().m5206d());
        carbGetListNetworkRequest.m1704a(this.f2106b.m2326h());
        carbGetListNetworkRequest.m1706b(this.f2106b.m2325g() * 1000);
        carbGetListNetworkRequest.m1708c(this.f2106b.m2325g() * 1000);
        return this.f2109e.m2237a(carbGetListNetworkRequest);
    }

    private List<CarbInfo> m2241a(List<CarbInfo> list) {
        List<CarbInfo> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!m2246a(((CarbInfo) list.get(i)).m2235a())) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    private boolean m2246a(String str) {
        try {
            SdkContext.m1562b().getPackageManager().getPackageInfo(str, NodeFilter.SHOW_DOCUMENT);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void m2242a(CarbGetListNetworkResponse carbGetListNetworkResponse, List<CarbInfo> list) {
        CarbPostListNetworkRequest carbPostListNetworkRequest = new CarbPostListNetworkRequest(this.f2106b.m2321c(), this.f2106b.m2323e(), this.f2106b.m2324f(), SignalsComponent.m5202a().m5206d(), list, carbGetListNetworkResponse);
        carbPostListNetworkRequest.m1706b(this.f2106b.m2325g() * 1000);
        carbPostListNetworkRequest.m1708c(this.f2106b.m2325g() * 1000);
        this.f2109e.m2238a(carbPostListNetworkRequest);
    }
}
