package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class cl extends bw {
    private final String f3926a;
    private final Map f3927b;
    private final AppLovinPostbackListener f3928c;
    private int f3929d;
    private int f3930i;
    private int f3931j;

    public cl(AppLovinSdkImpl appLovinSdkImpl, String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", appLovinSdkImpl);
        this.f3931j = -1;
        this.f3926a = str;
        this.f3928c = appLovinPostbackListener;
        this.f3927b = map;
    }

    public void m4214a(int i) {
        this.f3929d = i;
    }

    public void m4215b(int i) {
        this.f3930i = i;
    }

    public void m4216c(int i) {
        this.f3931j = i;
    }

    public void run() {
        if (AppLovinSdkUtils.isValidString(this.f3926a)) {
            cy cmVar = new cm(this, "RepeatTaskDispatchPostback", this.f3929d < 0 ? ((Integer) this.f.m4161a(bx.at)).intValue() : this.f3929d, this.f);
            cmVar.m4268a((long) this.f3930i);
            cmVar.run();
            return;
        }
        this.f.getLogger().m309i("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
        this.f3928c.onPostbackFailure(this.f3926a, AppLovinErrorCodes.INVALID_URL);
    }
}
