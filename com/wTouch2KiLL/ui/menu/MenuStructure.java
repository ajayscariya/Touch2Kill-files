package com.wTouch2KiLL.ui.menu;

import com.wTouch2KiLL.C0866R;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuStructure {
    public static final int INVALID_RESOURCE_ID = -1000500;
    static ArrayList<Item> menuItems;

    public static class Item {
        private int _iconResourceId;
        private int _itemId;

        public Item(int _itemId, int _iconResourceId) {
            setItemId(_itemId);
            setIconResourceId(_iconResourceId);
        }

        public int getItemId() {
            return this._itemId;
        }

        public void setItemId(int _itemId) {
            this._itemId = _itemId;
        }

        public int getIconResourceId() {
            return this._iconResourceId;
        }

        public void setIconResourceId(int _iconResourceId) {
            this._iconResourceId = _iconResourceId;
        }
    }

    static {
        menuItems = new ArrayList();
        menuItems.add(new Item(C0866R.id.webapp_refresh, C0866R.drawable.ic_refresh_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_share, C0866R.drawable.ic_share_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_about, C0866R.drawable.ic_info_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_rate, C0866R.drawable.ic_rate_review_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_exit, C0866R.drawable.ic_cancel_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_back, C0866R.drawable.ic_arrow_back_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_forward, C0866R.drawable.ic_arrow_forward_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_request_desktop, C0866R.drawable.ic_desktop_mac_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_pin_to_desktop, C0866R.drawable.ic_offline_pin_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_add_to_home, C0866R.drawable.ic_offline_pin_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_home, C0866R.drawable.ic_home_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_downloads_list, C0866R.drawable.ic_file_download_black_24dp));
        menuItems.add(new Item(C0866R.id.webapp_settings, C0866R.drawable.ic_settings_black_24dp));
    }

    public static int getIconResourceIdByItemId(int itemId) {
        Iterator i$ = menuItems.iterator();
        while (i$.hasNext()) {
            Item item = (Item) i$.next();
            if (item.getItemId() == itemId) {
                return item.getIconResourceId();
            }
        }
        return INVALID_RESOURCE_ID;
    }
}
