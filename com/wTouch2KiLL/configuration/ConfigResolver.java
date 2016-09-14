package com.wTouch2KiLL.configuration;

import android.content.Context;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;

public class ConfigResolver {
    public static WebWidgetConfiguration resolveConfig(Context context) {
        MainNavigationActivity activity = Factory.getInstance().getMainNavigationActivity();
        if (activity != null) {
            return activity.getConfig();
        }
        WebWidgetConfiguration webWidgetConfiguration = null;
        try {
            return WebWidgetConfigurationManager.getInstance(context).loadConfiguration(context);
        } catch (Exception e) {
            e.printStackTrace();
            return webWidgetConfiguration;
        }
    }
}
