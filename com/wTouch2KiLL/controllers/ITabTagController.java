package com.wTouch2KiLL.controllers;

import android.view.View;

public interface ITabTagController {
    View createTabTag() throws Exception;

    void onTagSelected();
}
