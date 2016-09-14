package com.wTouch2KiLL.ads.behavior.bannerBehaviors;

import com.wTouch2KiLL.ads.BottomBannerLayout;
import com.wTouch2KiLL.ads.behavior.BehaviorAcceptor;
import com.wTouch2KiLL.ads.behavior.BehaviorVisitor;

public abstract class BannerLayoutBehavior implements BehaviorVisitor {
    abstract void visit(BottomBannerLayout bottomBannerLayout);

    public void visit(BehaviorAcceptor acceptor) {
        if (acceptor instanceof BottomBannerLayout) {
            visit((BottomBannerLayout) acceptor);
        }
    }
}
