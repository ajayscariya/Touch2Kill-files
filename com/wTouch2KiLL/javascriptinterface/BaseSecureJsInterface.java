package com.wTouch2KiLL.javascriptinterface;

import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.utils.Hasher;

public abstract class BaseSecureJsInterface {
    protected boolean _checkSecurityCode(String hashCode) {
        WebWidgetConfiguration config = Factory.getInstance().getMainNavigationActivity().getConfig();
        int appId = config.getApplicationId();
        return hashCode.equalsIgnoreCase(Hasher.md5(config.getAppGuid() + String.valueOf(appId)));
    }
}
