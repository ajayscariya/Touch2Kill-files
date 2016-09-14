package com.wTouch2KiLL;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wTouch2KiLL.controllers.ITabContentController;
import com.wTouch2KiLL.controllers.ITabsController;
import com.wTouch2KiLL.controllers.TabsController;
import com.wTouch2KiLL.controllers.WebContentController;
import com.wTouch2KiLL.controllers.WidgetsController;
import com.wTouch2KiLL.model.WidgetEntity;
import com.wTouch2KiLL.storage.BookmarksManager;
import com.wTouch2KiLL.ui.navigationwidget.INavigationWidget;
import com.wTouch2KiLL.ui.views.TabContent.ContentType;
import java.util.HashMap;

public class Factory {
    private static Factory _instance;
    private MainNavigationActivity _activity;
    private BookmarksManager _homePageManager;
    private INavigationWidget _navigationWidget;
    private ITabsController _tabsController;
    private WidgetsController _widgetsController;
    private HashMap<String, BookmarksManager> bookmarkManagers;
    private ITabContentController tccRes;

    /* renamed from: com.wTouch2KiLL.Factory.1 */
    static /* synthetic */ class C08501 {
        static final /* synthetic */ int[] $SwitchMap$com$wTouch2KiLL$ui$views$TabContent$ContentType;

        static {
            $SwitchMap$com$wTouch2KiLL$ui$views$TabContent$ContentType = new int[ContentType.values().length];
            try {
                $SwitchMap$com$wTouch2KiLL$ui$views$TabContent$ContentType[ContentType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    static {
        _instance = null;
    }

    private Factory() {
        this._navigationWidget = null;
        this.tccRes = null;
        this.bookmarkManagers = new HashMap();
        this._widgetsController = new WidgetsController();
        this._tabsController = new TabsController();
    }

    public static Factory getInstance() {
        if (_instance == null) {
            _instance = new Factory();
        }
        return _instance;
    }

    public void destroy() {
        this._widgetsController = null;
        this._tabsController.destroy();
        this._tabsController = null;
        _instance = null;
    }

    public void Init(MainNavigationActivity activity) {
        this._activity = activity;
    }

    public void setNavigationWidget(INavigationWidget widget) {
        this._navigationWidget = widget;
    }

    public INavigationWidget getNavigationWidget() {
        return this._navigationWidget;
    }

    public MainNavigationActivity getMainNavigationActivity() {
        return this._activity;
    }

    public WidgetsController getWidgetsController() {
        return this._widgetsController;
    }

    public void setWidgetsController(WidgetsController widgetsController) {
        this._widgetsController = widgetsController;
    }

    public ITabsController getTabsController() {
        return this._tabsController;
    }

    public View getTabContent(ContentType type, LayoutInflater inflater, ViewGroup container) throws Exception {
        switch (C08501.$SwitchMap$com$wTouch2KiLL$ui$views$TabContent$ContentType[type.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                return inflater.inflate(C0866R.layout.web_content, container, false);
            default:
                throw new Exception("Unknown Content Type");
        }
    }

    public ITabContentController getTabContentController(WidgetEntity wdgtInfo) {
        this.tccRes = new WebContentController(wdgtInfo);
        this.tccRes.setMainNavigationActivity(this._activity);
        return this.tccRes;
    }

    public ITabContentController getWebContentController() {
        return this.tccRes;
    }

    public BookmarksManager getHomePageManager() {
        if (this._homePageManager == null) {
            this._homePageManager = new BookmarksManager("Homepage", this._activity);
        }
        return this._homePageManager;
    }

    public BookmarksManager getBookmarkManager(String BookmarkPage) {
        if (!this.bookmarkManagers.containsKey(BookmarkPage)) {
            this.bookmarkManagers.put(BookmarkPage, new BookmarksManager(BookmarkPage, this._activity));
        }
        return (BookmarksManager) this.bookmarkManagers.get(BookmarkPage);
    }
}
