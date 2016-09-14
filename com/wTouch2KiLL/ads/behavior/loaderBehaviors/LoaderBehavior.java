package com.wTouch2KiLL.ads.behavior.loaderBehaviors;

import com.wTouch2KiLL.ads.AdsLoader;
import com.wTouch2KiLL.ads.behavior.BehaviorAcceptor;
import com.wTouch2KiLL.ads.behavior.BehaviorVisitor;

public abstract class LoaderBehavior implements BehaviorVisitor {
    abstract void visit(AdsLoader adsLoader);

    public void visit(BehaviorAcceptor loader) {
        if (loader instanceof AdsLoader) {
            visit((AdsLoader) loader);
        }
    }
}
