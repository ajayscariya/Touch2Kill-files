package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class da extends bu {
    private final AppLovinAdImpl f4826a;

    public da(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd) {
        super("TaskReportReward", appLovinSdkImpl);
        this.f4826a = (AppLovinAdImpl) appLovinAd;
    }

    public void run() {
        String b = aa.m64b();
        String clCode = this.f4826a.getClCode();
        Map hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        bm a = bm.m121a();
        clCode = a.m125b(this.f4826a);
        if (clCode != null) {
            hashMap.put("result", clCode);
            Map a2 = a.m122a(this.f4826a);
            if (a2 != null) {
                hashMap.put("params", a2);
            }
            m4199a("cr", new JSONObject(hashMap), new db(this));
            return;
        }
        this.g.m306d("TaskReportReward", "No reward result was found for ad: " + this.f4826a);
    }
}
