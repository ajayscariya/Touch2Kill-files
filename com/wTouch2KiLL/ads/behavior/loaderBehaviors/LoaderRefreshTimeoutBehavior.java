package com.wTouch2KiLL.ads.behavior.loaderBehaviors;

import com.wTouch2KiLL.ads.AdsLoader;

public class LoaderRefreshTimeoutBehavior extends LoaderBehavior {
    float _timeOut;

    public LoaderRefreshTimeoutBehavior(float timeout) {
        this._timeOut = timeout;
    }

    public void visit(AdsLoader loader) {
        loader.setRefreshTimeout(this._timeOut);
    }
}
