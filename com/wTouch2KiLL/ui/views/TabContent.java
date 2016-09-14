package com.wTouch2KiLL.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.wTouch2KiLL.controllers.ITabContentController;

public class TabContent extends RelativeLayout {

    public enum ContentType {
        WEB
    }

    protected TabContent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected TabContent(Context context) {
        super(context);
    }

    protected void init(ITabContentController tabContentController) {
    }
}
