package com.wTouch2KiLL.ads.behavior.bannerBehaviors;

import com.wTouch2KiLL.ads.BottomBannerLayout;

public class BannerFullScreenBehavior extends BannerLayoutBehavior {
    private boolean _isFullScreen;

    public BannerFullScreenBehavior(boolean isFullScreen) {
        this._isFullScreen = isFullScreen;
    }

    public void visit(BottomBannerLayout layout) {
        layout.setFullscreenMode(this._isFullScreen);
    }
}
