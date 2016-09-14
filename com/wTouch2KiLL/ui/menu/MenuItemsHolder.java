package com.wTouch2KiLL.ui.menu;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity.ApplicationMode;
import com.wTouch2KiLL.configuration.UrlBarMenuButton;
import com.wTouch2KiLL.configuration.UrlBarMenuButton.UrlBarMenuButtonTypes;
import com.wTouch2KiLL.configuration.UrlBarMenuLinkButton;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarStates;
import com.wTouch2KiLL.ui.navigationdrawer.ListItem;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuItemsHolder {
    private Menu _menu;
    public boolean trigger;

    /* renamed from: com.wTouch2KiLL.ui.menu.MenuItemsHolder.1 */
    class C09501 implements OnMenuItemClickListener {
        final /* synthetic */ UrlBarMenuLinkButton val$button;

        C09501(UrlBarMenuLinkButton urlBarMenuLinkButton) {
            this.val$button = urlBarMenuLinkButton;
        }

        public boolean onMenuItemClick(MenuItem item) {
            Factory.getInstance().getTabsController().getSelectedTab().getWebView().loadUrl(this.val$button.getUrl());
            return false;
        }
    }

    public MenuItemsHolder(WebWidgetConfiguration config, Activity activity) {
        this.trigger = true;
        ApplicationMode mode = config.getApplicationMode();
        if (activity != null) {
            this._menu = MenuGenerator.newEmptyMenuInstance(activity);
            _init(config, mode, activity);
        }
    }

    public MenuItemsHolder(WebWidgetConfiguration config, ApplicationMode mode, Activity activity, Menu menu) {
        this.trigger = true;
        if (activity != null) {
            this._menu = menu;
            _init(config, mode, activity);
        }
    }

    private void _init(WebWidgetConfiguration config, ApplicationMode mode, Activity _activity) {
        _activity.getMenuInflater().inflate(C0866R.menu.webapp_menu, this._menu);
        _applyItemsVisibility(config, mode);
    }

    private void _applyItemsVisibility(WebWidgetConfiguration config, ApplicationMode mode) {
        if (!config.getUrlOverlayState().equals(UrlBarStates.DISABLED)) {
            Iterator i$ = config.getUrlBarMenuButtons().iterator();
            while (i$.hasNext()) {
                UrlBarMenuButton urlBarMenuButton = (UrlBarMenuButton) i$.next();
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.BACK)) {
                    this._menu.findItem(C0866R.id.webapp_back).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.FORWARD)) {
                    this._menu.findItem(C0866R.id.webapp_forward).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.REQUEST_DESKTOP)) {
                    this._menu.findItem(C0866R.id.webapp_request_desktop).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.PIN_TO_DESKTOP)) {
                    this._menu.findItem(C0866R.id.webapp_pin_to_desktop).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.ADD_TO_HOME)) {
                    this._menu.findItem(C0866R.id.webapp_add_to_home).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.HOME)) {
                    this._menu.findItem(C0866R.id.webapp_home).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.DOWNLOADS_LIST)) {
                    this._menu.findItem(C0866R.id.webapp_downloads_list).setVisible(true);
                }
                if (urlBarMenuButton.getType().equals(UrlBarMenuButtonTypes.LINK) && (urlBarMenuButton instanceof UrlBarMenuLinkButton)) {
                    UrlBarMenuLinkButton button = (UrlBarMenuLinkButton) urlBarMenuButton;
                    this._menu.add(0, button.getTitle().hashCode(), 0, button.getTitle()).setOnMenuItemClickListener(new C09501(button));
                }
            }
        }
        if (mode == ApplicationMode.CUSTOM) {
            this._menu.findItem(C0866R.id.webapp_share).setVisible(false);
        } else {
            this._menu.findItem(C0866R.id.webapp_share).setVisible(true);
        }
        if (!config.getIsAboutScreenEnabled()) {
            this._menu.findItem(C0866R.id.webapp_about).setVisible(false);
        }
        this._menu.findItem(C0866R.id.webapp_rate).setVisible(config.getRateItemVisibility());
        this._menu.findItem(C0866R.id.webapp_refresh).setVisible(config.getShowRefreshMenuItem());
        this._menu.findItem(C0866R.id.webapp_exit).setVisible(config.getShowExitMenuItem());
        this._menu.findItem(C0866R.id.webapp_share).setVisible(config.getShowShareMenuItem());
        this._menu.findItem(C0866R.id.webapp_about).setVisible(config.getShowAboutMenuItem());
        this._menu.findItem(C0866R.id.webapp_downloads_list).setVisible(config.getShowDownloadList());
        this._menu.findItem(C0866R.id.webapp_settings).setVisible(config.getShowSettings());
    }

    public void setItemVisible(int id, boolean visible) {
        MenuItem item = this._menu.findItem(id);
        if (item != null) {
            item.setVisible(visible);
        }
    }

    public ArrayList<ListItem> getAllItems() {
        ArrayList<ListItem> result = new ArrayList();
        for (int i = 0; i < this._menu.size(); i++) {
            MenuItem currentItem = this._menu.getItem(i);
            if (currentItem.getItemId() != C0866R.id.webapp_request_desktop && currentItem.isVisible()) {
                int id = currentItem.getItemId();
                result.add(new ListItem(currentItem.getTitle().toString(), MenuStructure.getIconResourceIdByItemId(id), id));
            }
        }
        return result;
    }

    public Menu getMenu() {
        return this._menu;
    }

    public void setMenu(Menu _menu) {
        this._menu = _menu;
    }
}
