package com.wTouch2KiLL.ads.behavior.activityBehaviors;

import android.app.Activity;
import com.wTouch2KiLL.ads.behavior.BehaviorAcceptor;
import com.wTouch2KiLL.ads.behavior.BehaviorVisitor;

public abstract class ActivityVisitor implements BehaviorVisitor {
    abstract void visit(Activity activity);

    public void visit(BehaviorAcceptor acceptor) {
        if (acceptor instanceof Activity) {
            visit((Activity) acceptor);
        }
    }
}
