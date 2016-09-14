package com.wTouch2KiLL;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.TabsEnabledHide;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarHide;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarStates;
import com.wTouch2KiLL.controllers.ITabContentController;
import com.wTouch2KiLL.controllers.ITabsController;
import com.wTouch2KiLL.notification.NotificationChecker;
import com.wTouch2KiLL.ui.views.AboutDialog;
import com.wTouch2KiLL.utils.AppCompatPreferenceActivity;

public class SettingsActivity extends AppCompatPreferenceActivity {
    public static final String KEY_HIDE_TAB_BAR = "hide_tab_bar";
    public static final String KEY_HIDE_URL_BAR = "hide_url_bar";
    public static final String KEY_QUICK_SEARCH = "show_quick_access_bar";
    public static final String TIME_FROM = "time_from";
    public static final String TIME_TO = "time_to";
    private OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    private SharedPreferences settings;
    private ITabsController tabsController;

    /* renamed from: com.wTouch2KiLL.SettingsActivity.1 */
    class C08671 implements OnSharedPreferenceChangeListener {
        C08671() {
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals(SettingsActivity.KEY_HIDE_URL_BAR) || key.equals(SettingsActivity.KEY_HIDE_TAB_BAR)) {
                ITabContentController webContentController = Factory.getInstance().getWebContentController();
                if (webContentController != null) {
                    webContentController.showNavigationBars();
                }
            }
            if (!key.equals(SettingsActivity.KEY_QUICK_SEARCH)) {
                return;
            }
            if (SettingsActivity.this.settings.getBoolean(key, true)) {
                Factory.getInstance().getMainNavigationActivity().createNotice();
            } else {
                Factory.getInstance().getMainNavigationActivity().deleteNotice();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.SettingsActivity.2 */
    class C08682 implements OnPreferenceChangeListener {
        final /* synthetic */ Preference val$timeFrom;

        C08682(Preference preference) {
            this.val$timeFrom = preference;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            this.val$timeFrom.setSummary(newValue.toString());
            return false;
        }
    }

    /* renamed from: com.wTouch2KiLL.SettingsActivity.3 */
    class C08693 implements OnPreferenceChangeListener {
        final /* synthetic */ Preference val$timeTo;

        C08693(Preference preference) {
            this.val$timeTo = preference;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            this.val$timeTo.setSummary(newValue.toString());
            return false;
        }
    }

    /* renamed from: com.wTouch2KiLL.SettingsActivity.4 */
    class C08704 implements OnPreferenceClickListener {
        final /* synthetic */ AboutDialog val$aboutDialog;

        C08704(AboutDialog aboutDialog) {
            this.val$aboutDialog = aboutDialog;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.val$aboutDialog.show();
            return false;
        }
    }

    public SettingsActivity() {
        this.tabsController = Factory.getInstance().getTabsController();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(C0866R.xml.preferences);
        this.settings = PreferenceManager.getDefaultSharedPreferences(this);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        WebWidgetConfiguration config = Factory.getInstance().getMainNavigationActivity().getConfig();
        Preference timeFrom = findPreference(TIME_FROM);
        Preference timeTo = findPreference(TIME_TO);
        Preference notificationsCategory = findPreference("notifications_category");
        Preference hideUrlBar = findPreference(KEY_HIDE_URL_BAR);
        Preference hideTabBar = findPreference(KEY_HIDE_TAB_BAR);
        Preference quickSearchBar = findPreference(KEY_QUICK_SEARCH);
        PreferenceCategory generalCategory = (PreferenceCategory) findPreference("general_category");
        preferenceScreen.removePreference(hideUrlBar);
        preferenceScreen.removePreference(hideTabBar);
        preferenceScreen.removePreference(notificationsCategory);
        getLayoutInflater().inflate(C0866R.layout.settings_toolbar, (ViewGroup) findViewById(16908290));
        setSupportActionBar((Toolbar) findViewById(C0866R.id.toolbar_preference));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setElevation(0.0f);
        }
        int horizontalMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        getListView().setPadding(horizontalMargin, (int) TypedValue.applyDimension(1, (float) (((int) getResources().getDimension(C0866R.dimen.activity_vertical_margin)) + 30), getResources().getDisplayMetrics()), horizontalMargin, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.onSharedPreferenceChangeListener = new C08671();
        this.settings.registerOnSharedPreferenceChangeListener(this.onSharedPreferenceChangeListener);
        timeFrom.setOnPreferenceChangeListener(new C08682(timeFrom));
        timeTo.setOnPreferenceChangeListener(new C08693(timeTo));
        findPreference("about_preference").setOnPreferenceClickListener(new C08704(new AboutDialog(this, Factory.getInstance().getMainNavigationActivity(), C0866R.style.FullHeightDialog)));
        findPreference("build_version_preference").setSummary(getString(C0866R.string.app_version, new Object[]{aboutDialog.getAppVersion(), Factory.getInstance().getMainNavigationActivity().getResources().getString(C0866R.string.platformVersion)}));
        if (!NotificationChecker.ENABLE_NOTIFICATION) {
            preferenceScreen.removePreference(notificationsCategory);
        } else if (!notificationsCategory.isEnabled()) {
            preferenceScreen.addPreference(notificationsCategory);
        }
        if (this.tabsController.getVisibilityTabs()) {
            if (!hideTabBar.isEnabled()) {
                generalCategory.addPreference(hideTabBar);
            }
            hideTabBar.setDefaultValue(Boolean.valueOf(config.getTabsEnabledHide() == TabsEnabledHide.ENABLED));
        } else {
            generalCategory.removePreference(hideTabBar);
            if (generalCategory.getPreferenceCount() == 0) {
                preferenceScreen.removePreference(generalCategory);
            }
        }
        if (config.getUrlOverlayState() == UrlBarStates.ENABLED) {
            if (!hideUrlBar.isEnabled()) {
                generalCategory.addPreference(hideUrlBar);
            }
            hideUrlBar.setDefaultValue(Boolean.valueOf(config.getUrlBarHide() == UrlBarHide.ENABLED));
        } else {
            generalCategory.removePreference(hideUrlBar);
            if (generalCategory.getPreferenceCount() == 0) {
                preferenceScreen.removePreference(generalCategory);
            }
        }
        if (Factory.getInstance().getNavigationWidget() != null) {
            boolean quickSearch = this.settings.getBoolean(KEY_QUICK_SEARCH, true);
            if (!quickSearchBar.isEnabled() && quickSearch) {
                generalCategory.addPreference(quickSearchBar);
            }
            if (!Factory.getInstance().getMainNavigationActivity().getConfig().getShowSearchNotice()) {
                quickSearchBar.setDefaultValue(Boolean.valueOf(false));
            }
        } else if (!Factory.getInstance().getMainNavigationActivity().getConfig().getShowSearchNotice() || Factory.getInstance().getMainNavigationActivity().getConfig().getUrlOverlayState() != UrlBarStates.ENABLED) {
            generalCategory.removePreference(quickSearchBar);
            if (generalCategory.getPreferenceCount() == 0) {
                preferenceScreen.removePreference(generalCategory);
            }
        }
    }

    protected void onResume() {
        super.onResume();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return false;
        }
    }
}
