package com.wTouch2KiLL.ui.navigationdrawer;

import com.wTouch2KiLL.MainNavigationActivity;

public class NavigationDrawerHolder {
    private static NavigationDrawer instance;

    static {
        instance = null;
    }

    public static NavigationDrawer getNavigationDrawer(MainNavigationActivity _activity) {
        if (instance == null) {
            instance = new NavigationDrawer(_activity);
        }
        return instance;
    }
}
