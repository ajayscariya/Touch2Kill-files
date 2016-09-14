package com.applovin.impl.sdk;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class EventServiceImpl implements AppLovinEventService {
    private final AppLovinSdkImpl f3885a;
    private final List f3886b;

    public EventServiceImpl(AppLovinSdk appLovinSdk) {
        this.f3885a = (AppLovinSdkImpl) appLovinSdk;
        this.f3886b = Arrays.asList(((String) ((AppLovinSdkImpl) appLovinSdk).m4161a(bx.aX)).split(","));
    }

    private Uri m4171a(bt btVar, C0243t c0243t) {
        C0241r dataCollector = this.f3885a.getDataCollector();
        C0245v a = dataCollector.m279a();
        C0244u b = dataCollector.m281b();
        boolean contains = this.f3886b.contains(btVar.m151a());
        Builder appendQueryParameter = Uri.parse((String) this.f3885a.m4161a(bx.aW)).buildUpon().appendQueryParameter(NotificationCompatApi21.CATEGORY_EVENT, contains ? btVar.m151a() : "postinstall").appendQueryParameter("ts", Long.toString(btVar.m153c())).appendQueryParameter("platform", "Android").appendQueryParameter("model", a.f351a).appendQueryParameter("package_name", b.f349c).appendQueryParameter("sdk_key", this.f3885a.getSdkKey()).appendQueryParameter("idfa", c0243t.f346b).appendQueryParameter("dnt", Boolean.toString(c0243t.f345a)).appendQueryParameter("ia", Long.toString(b.f350d)).appendQueryParameter("api_did", (String) this.f3885a.m4161a(bx.f260c)).appendQueryParameter("brand", a.f353c).appendQueryParameter("model", a.f351a).appendQueryParameter("revision", a.f354d).appendQueryParameter("sdk_version", AppLovinSdk.VERSION).appendQueryParameter("os", a.f352b).appendQueryParameter("app_version", this.f3885a.getDataCollector().m281b().f348b);
        if (!contains) {
            appendQueryParameter = appendQueryParameter.appendQueryParameter("sub_event", btVar.m151a());
        }
        return appendQueryParameter.build();
    }

    private Map m4173a(Map map) {
        Map hashMap = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if ((key instanceof String) && (value instanceof String)) {
                    hashMap.put((String) key, (String) value);
                } else {
                    this.f3885a.getLogger().m310w("EventServiceImpl", "Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered " + key.getClass().getCanonicalName() + "/" + value.getClass().getCanonicalName() + "; will use toString() value instead, which may be unexpected...");
                    hashMap.put(key.toString(), value.toString());
                }
            }
        }
        return hashMap;
    }

    private void m4174a(bt btVar) {
        if (((Boolean) this.f3885a.m4161a(bx.aY)).booleanValue()) {
            this.f3885a.getLogger().m306d("EventServiceImpl", "Tracking event: " + btVar);
            m4175a(new C1180w(this, btVar));
        }
    }

    private void m4175a(ck ckVar) {
        this.f3885a.m4160a().m233a(new cj(this.f3885a, ckVar), cs.BACKGROUND);
    }

    public void trackCheckout(String str, Map map) {
        Map hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map map) {
        m4174a(new bt(str, m4173a(map), System.currentTimeMillis(), di.m4291b(UUID.randomUUID().toString())));
    }

    public void trackInAppPurchase(Intent intent, Map map) {
        Map hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable e) {
            this.f3885a.getLogger().userError("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", e);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, hashMap);
    }
}
