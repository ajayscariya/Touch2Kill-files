package com.wTouch2KiLL.ui.navigationdrawer;

import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;

public class ListItem implements IOptionsMenuItemSelectedListener {
    int _iconId;
    int _id;
    String _title;

    /* renamed from: com.wTouch2KiLL.ui.navigationdrawer.ListItem.1 */
    class C09511 implements Runnable {
        final /* synthetic */ MainNavigationActivity val$activity;

        C09511(MainNavigationActivity mainNavigationActivity) {
            this.val$activity = mainNavigationActivity;
        }

        public void run() {
            this.val$activity.onOptionsItemSelected(ListItem.this._id, null);
        }
    }

    public int getIconId() {
        return this._iconId;
    }

    public void setIconId(int _icon) {
        this._iconId = _icon;
    }

    public String getTitle() {
        return this._title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getId() {
        return this._id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public ListItem(String _title, int _iconId, int _id) {
        this._iconId = _iconId;
        this._title = _title;
        this._id = _id;
    }

    public void select() {
        MainNavigationActivity activity = Factory.getInstance().getMainNavigationActivity();
        if (activity != null) {
            activity.runOnUiThread(new C09511(activity));
        }
    }
}
