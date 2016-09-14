package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class bn {
    private final AppLovinSdkImpl f211a;
    private final AppLovinLogger f212b;
    private ArrayList f213c;
    private ArrayList f214d;
    private final Object f215e;
    private final SharedPreferences f216f;

    bn(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f211a = appLovinSdkImpl;
        this.f212b = appLovinSdkImpl.getLogger();
        this.f216f = appLovinSdkImpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
        this.f215e = new Object();
        this.f213c = m132c();
        this.f214d = new ArrayList();
    }

    private bp m126a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new bp(this, jSONObject.getString("targetUrl"), ay.m99a(jSONObject.getJSONObject("requestBody")), jSONObject.getInt("attemptNumber"));
        } catch (Throwable e) {
            this.f212b.m311w("PersistentPostbackManager", "Unable to inflate postback request from JSON.", e);
            return null;
        }
    }

    private void m129a(bp bpVar) {
        synchronized (this.f215e) {
            m131b(bpVar);
            m133c(bpVar);
        }
    }

    private void m131b(bp bpVar) {
        synchronized (this.f215e) {
            if (this.f213c.size() < ((Integer) this.f211a.m4161a(bx.ba)).intValue()) {
                this.f213c.add(bpVar);
                m134d();
                this.f212b.m306d("PersistentPostbackManager", "Enqueued postback: " + bpVar);
            } else {
                this.f212b.m310w("PersistentPostbackManager", "Persistent queue has reached maximum size; postback retried in memory only." + bpVar);
            }
        }
    }

    private ArrayList m132c() {
        if (C0237n.m251b()) {
            Set<String> stringSet = this.f216f.getStringSet("com.applovin.sdk.impl.postbackQueue.key", new LinkedHashSet(0));
            ArrayList arrayList = new ArrayList(Math.max(1, stringSet.size()));
            int intValue = ((Integer) this.f211a.m4161a(bx.bb)).intValue();
            this.f212b.m306d("PersistentPostbackManager", "Deserializing " + stringSet.size() + " postback(s).");
            for (String str : stringSet) {
                bp a = m126a(str);
                if (a == null) {
                    this.f212b.m307e("PersistentPostbackManager", "Unable to deserialize postback json: " + str);
                } else if (a.m141a() > intValue) {
                    arrayList.add(a);
                } else {
                    this.f212b.m306d("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + a);
                }
            }
            this.f212b.m306d("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            return arrayList;
        }
        this.f212b.m306d("PersistentPostbackManager", "Loading new postback queue due to old Android version...");
        return new ArrayList();
    }

    private void m133c(bp bpVar) {
        this.f212b.m306d("PersistentPostbackManager", "Preparing to submit postback..." + bpVar);
        synchronized (this.f215e) {
            bpVar.m142a(bpVar.m141a() + 1);
            m134d();
        }
        int intValue = ((Integer) this.f211a.m4161a(bx.bb)).intValue();
        if (bpVar.m141a() > intValue) {
            this.f212b.m310w("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + intValue + ". Dequeuing postback: " + bpVar);
            m135d(bpVar);
            return;
        }
        this.f211a.getPostbackService().dispatchPostbackAsync(bpVar.m143b(), bpVar.m144c(), new bo(this, bpVar));
    }

    private void m134d() {
        if (C0237n.m251b()) {
            Set linkedHashSet = new LinkedHashSet(this.f213c.size());
            Iterator it = this.f213c.iterator();
            while (it.hasNext()) {
                String f = m137f((bp) it.next());
                if (f != null) {
                    linkedHashSet.add(f);
                }
            }
            this.f216f.edit().putStringSet("com.applovin.sdk.impl.postbackQueue.key", linkedHashSet).commit();
            this.f212b.m306d("PersistentPostbackManager", "Wrote updated postback queue to disk.");
            return;
        }
        this.f212b.m306d("PersistentPostbackManager", "Skipping writing postback queue to disk due to old Android version...");
    }

    private void m135d(bp bpVar) {
        synchronized (this.f215e) {
            this.f213c.remove(bpVar);
            m134d();
        }
        this.f212b.m306d("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + bpVar);
    }

    private void m136e(bp bpVar) {
        synchronized (this.f215e) {
            this.f214d.add(bpVar);
        }
    }

    private String m137f(bp bpVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attemptNumber", bpVar.m141a()).put("targetUrl", bpVar.m143b());
            Map c = bpVar.m144c();
            if (c != null) {
                jSONObject.put("requestBody", new JSONObject(c));
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            this.f212b.m311w("PersistentPostbackManager", "Unable to serialize postback request to JSON.", e);
            return null;
        }
    }

    public void m138a() {
        synchronized (this.f215e) {
            Iterator it = this.f213c.iterator();
            while (it.hasNext()) {
                m133c((bp) it.next());
            }
        }
    }

    public void m139a(String str, Map map) {
        m129a(new bp(this, str, map));
    }

    public void m140b() {
        synchronized (this.f215e) {
            Iterator it = this.f214d.iterator();
            while (it.hasNext()) {
                m133c((bp) it.next());
            }
            this.f214d.clear();
        }
    }
}
