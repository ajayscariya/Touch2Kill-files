package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class df extends bu {
    private final AppLovinAdImpl f4827a;
    private final AppLovinAdRewardListener f4828b;
    private final Object f4829c;
    private volatile boolean f4830d;

    public df(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        super("TaskValidateReward", appLovinSdkImpl);
        this.f4829c = new Object();
        this.f4830d = false;
        this.f4827a = (AppLovinAdImpl) appLovinAd;
        this.f4828b = appLovinAdRewardListener;
    }

    private void m5682a(int i) {
        if (!m5688c()) {
            String str = "network_timeout";
            if (i < 400 || i > 500) {
                this.f4828b.validationRequestFailed(this.f4827a, i);
            } else {
                this.f4828b.userRewardRejected(this.f4827a, new HashMap(0));
                str = "rejected";
            }
            bm.m121a().m123a(this.f4827a, str);
        }
    }

    private void m5685a(String str, Map map) {
        if (!m5688c()) {
            bm a = bm.m121a();
            a.m123a(this.f4827a, str);
            a.m124a(this.f4827a, map);
            if (str.equals("accepted")) {
                this.f4828b.userRewardVerified(this.f4827a, map);
            } else if (str.equals("quota_exceeded")) {
                this.f4828b.userOverQuota(this.f4827a, map);
            } else if (str.equals("rejected")) {
                this.f4828b.userRewardRejected(this.f4827a, map);
            } else {
                this.f4828b.validationRequestFailed(this.f4827a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5686a(org.json.JSONObject r5) {
        /*
        r4 = this;
        r0 = r4.m5688c();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r2 = com.applovin.impl.sdk.C0240q.m272a(r5);	 Catch:{ JSONException -> 0x0027 }
        r0 = r4.f;	 Catch:{ JSONException -> 0x0027 }
        com.applovin.impl.sdk.C0240q.m274a(r2, r0);	 Catch:{ JSONException -> 0x0027 }
        r0 = "params";
        r0 = r2.get(r0);	 Catch:{ Throwable -> 0x0032 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ Throwable -> 0x0032 }
        r0 = com.applovin.impl.sdk.ay.m99a(r0);	 Catch:{ Throwable -> 0x0032 }
        r1 = r0;
    L_0x001d:
        r0 = "result";
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x003b }
    L_0x0023:
        r4.m5685a(r0, r1);	 Catch:{ JSONException -> 0x0027 }
        goto L_0x0006;
    L_0x0027:
        r0 = move-exception;
        r1 = r4.g;
        r2 = r4.e;
        r3 = "Unable to parse API response";
        r1.m308e(r2, r3, r0);
        goto L_0x0006;
    L_0x0032:
        r0 = move-exception;
        r0 = new java.util.HashMap;	 Catch:{ JSONException -> 0x0027 }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0027 }
        r1 = r0;
        goto L_0x001d;
    L_0x003b:
        r0 = move-exception;
        r0 = "network_timeout";
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.df.a(org.json.JSONObject):void");
    }

    public void m5687a(boolean z) {
        synchronized (this.f4829c) {
            this.f4830d = z;
        }
    }

    boolean m5688c() {
        boolean z;
        synchronized (this.f4829c) {
            z = this.f4830d;
        }
        return z;
    }

    public void run() {
        String b = aa.m64b();
        String clCode = this.f4827a.getClCode();
        Map hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        m4199a("vr", new JSONObject(hashMap), new dg(this));
    }
}
