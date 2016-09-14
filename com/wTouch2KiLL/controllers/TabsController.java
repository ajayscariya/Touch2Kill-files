package com.wTouch2KiLL.controllers;

import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.astuetz.PagerSlidingTabStrip;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.TabsPositions;
import com.wTouch2KiLL.ui.views.TabFragment;

public class TabsController implements ITabsController {
    private final int OFFSCREEN_TABS_LIMIT;
    private int _selectedPosition;
    private TabsAdapter _tabsAdapter;
    FrameLayout frameLayout;
    public SimpleOnPageChangeListener onPageChangeListener;
    PagerSlidingTabStrip tagPanel;
    ViewPager viewPager;

    /* renamed from: com.wTouch2KiLL.controllers.TabsController.1 */
    class C15441 extends SimpleOnPageChangeListener {
        C15441() {
        }

        public void onPageSelected(int position) {
            TabsController.this._selectedPosition = position;
        }
    }

    public TabsController() {
        this._selectedPosition = 0;
        this.OFFSCREEN_TABS_LIMIT = 10;
        this.onPageChangeListener = new C15441();
    }

    public void initWithTabs(WidgetsController widgetsController) {
        try {
            Activity activity = Factory.getInstance().getMainNavigationActivity();
            this.viewPager = (ViewPager) activity.findViewById(C0866R.id.tabcontents_panel);
            this.viewPager.setOffscreenPageLimit(10);
            this.tagPanel = (PagerSlidingTabStrip) activity.findViewById(C0866R.id.tabtags_panel);
            this.frameLayout = (FrameLayout) activity.findViewById(C0866R.id.frame);
            this.viewPager.addOnPageChangeListener(this.onPageChangeListener);
            this._tabsAdapter = new TabsAdapter();
            this.viewPager.setAdapter(this._tabsAdapter);
            this._selectedPosition = this.viewPager.getCurrentItem();
            this.tagPanel.setViewPager(this.viewPager);
            ViewCompat.setElevation(this.tagPanel, 16.0f);
            int count = widgetsController.tabsCount();
            if (count == 1) {
                this.tagPanel.setVisibility(8);
                this.frameLayout.setVisibility(8);
            } else if (count == 0) {
                this.tagPanel.setVisibility(8);
                this.frameLayout.setVisibility(8);
            }
        } catch (Exception e) {
            Log.e("initWithTabs Error", e.getMessage());
            System.out.println("initWithTabs Error" + e.getMessage());
        }
    }

    public void setBannerInjectionJs(String jsCode) {
        this._tabsAdapter.setInjectionJs(jsCode);
    }

    public WebContentController getSelectedTab() {
        TabFragment fragment = this._tabsAdapter.getFragmentByPosition(this._selectedPosition);
        if (fragment == null) {
            return null;
        }
        return (WebContentController) fragment.getContentController();
    }

    public void setLayoutParams(LayoutParams params) {
        if (Factory.getInstance().getMainNavigationActivity().getConfig().getTabsPosition() == TabsPositions.BOTTOM) {
            params.addRule(12);
        }
        this.frameLayout.setLayoutParams(params);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.frameLayout.getLayoutParams();
    }

    public boolean onBackKeyDown() {
        WebContentController controller = getSelectedTab();
        if (controller != null) {
            return controller.onBackKeyDown();
        }
        return false;
    }

    public void destroy() {
        for (int i = 0; i < this._tabsAdapter.getCount(); i++) {
            TabFragment fragment = this._tabsAdapter.getFragmentByPosition(i);
            if (!(fragment == null || fragment.getContentController() == null)) {
                fragment.getContentController().destroy();
            }
        }
    }

    public boolean getVisibilityTabs() {
        return this.tagPanel.getVisibility() == 0;
    }
}
