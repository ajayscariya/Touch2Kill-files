package com.wTouch2KiLL.controllers;

import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public interface ITabsController {
    void destroy();

    LayoutParams getLayoutParams();

    WebContentController getSelectedTab();

    boolean getVisibilityTabs();

    void initWithTabs(WidgetsController widgetsController);

    boolean onBackKeyDown();

    void setLayoutParams(RelativeLayout.LayoutParams layoutParams);
}
