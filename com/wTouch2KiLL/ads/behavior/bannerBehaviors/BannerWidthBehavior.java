package com.wTouch2KiLL.ads.behavior.bannerBehaviors;

import com.wTouch2KiLL.ads.BottomBannerLayout;

public class BannerWidthBehavior extends BannerLayoutBehavior {
    private int _width;

    public BannerWidthBehavior(int w) {
        this._width = w;
    }

    public void visit(BottomBannerLayout layout) {
        layout.setWidth(this._width);
    }
}
