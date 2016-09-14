package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class PostbackServiceImpl implements AppLovinPostbackService {
    private final AppLovinSdkImpl f3887a;

    PostbackServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        this.f3887a = appLovinSdkImpl;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackAsync(str, null, appLovinPostbackListener);
    }

    public void dispatchPostbackAsync(String str, Map map, int i, int i2, int i3, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            bw clVar = new cl(this.f3887a, str, map, appLovinPostbackListener);
            clVar.m4215b(i2);
            clVar.m4214a(i);
            clVar.m4216c(i3);
            this.f3887a.m4160a().m233a(clVar, cs.POSTBACKS);
            return;
        }
        this.f3887a.getLogger().m307e("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(str, AppLovinErrorCodes.INVALID_URL);
        }
    }

    public void dispatchPostbackAsync(String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            this.f3887a.m4160a().m233a(new cl(this.f3887a, str, map, new bq(this, appLovinPostbackListener)), cs.POSTBACKS);
            return;
        }
        this.f3887a.getLogger().m306d("PostbackService", "Ignoring enqueued postback request to invalid URL");
    }
}
