package com.wTouch2KiLL.configuration;

import com.wTouch2KiLL.configuration.UrlBarMenuButton.UrlBarMenuButtonTypes;
import java.io.Serializable;

public class UrlBarIcon extends UrlBarMenuLinkButton implements Serializable {
    private String icon;

    public UrlBarIcon(String title, String url, String icon) {
        super(title, url);
        setType(UrlBarMenuButtonTypes.ICON);
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
