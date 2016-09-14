package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONObject;

class cz implements C0239p {
    final /* synthetic */ AppLovinSdkImpl f3948a;
    final /* synthetic */ String f3949b;
    final /* synthetic */ cy f3950c;

    cz(cy cyVar, AppLovinSdkImpl appLovinSdkImpl, String str) {
        this.f3950c = cyVar;
        this.f3948a = appLovinSdkImpl;
        this.f3949b = str;
    }

    public void m4272a(int i) {
        Object obj = 1;
        Object obj2 = (i < 200 || i >= 500) ? 1 : null;
        if (i == AppLovinErrorCodes.NO_NETWORK) {
            obj = null;
        }
        if (obj2 == null || r0 == null || this.f3950c.f3944a <= 0) {
            this.f3950c.m4267a(i);
            return;
        }
        long longValue = this.f3950c.f3945b < 0 ? ((Long) this.f3948a.m4161a(bx.f269l)).longValue() : this.f3950c.f3945b;
        Log.w(this.f3949b, "Unable to send request due to server failure (code " + i + "). " + this.f3950c.f3944a + " attempts left, retrying in " + (((double) longValue) / 1000.0d) + " seconds...");
        this.f3950c.f3944a = this.f3950c.f3944a - 1;
        if (this.f3950c.f3944a == 0) {
            this.f3950c.m4265c();
        }
        this.f3948a.m4160a().m234a(this.f3950c, cs.BACKGROUND, longValue);
    }

    public void m4273a(JSONObject jSONObject, int i) {
        this.f3950c.f3944a = 0;
        this.f3950c.m4271a(jSONObject, i);
    }
}
