package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;
import com.wTouch2KiLL.MainNavigationActivity;

/* renamed from: com.inmobi.ads.k */
final class BannerRefreshHandler extends Handler {
    private InMobiBanner f1484a;

    public BannerRefreshHandler(InMobiBanner inMobiBanner) {
        this.f1484a = inMobiBanner;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                this.f1484a.load(true);
            default:
        }
    }
}
