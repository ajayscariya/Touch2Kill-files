package com.wTouch2KiLL.ads.behavior.loaderBehaviors;

import com.wTouch2KiLL.ads.AdsLoader;
import com.wTouch2KiLL.ads.behavior.BehaviorFactory.ClickBehavior;

public class LoaderClickBehavior extends LoaderBehavior {
    ClickBehavior _clickBehavior;

    public LoaderClickBehavior(ClickBehavior behavior) {
        this._clickBehavior = behavior;
    }

    public void visit(AdsLoader loader) {
        loader.changeClickBehavior(this._clickBehavior);
    }
}
