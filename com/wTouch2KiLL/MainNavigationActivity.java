package com.wTouch2KiLL;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.android.gcm.GCMRegistrar;
import com.google.android.gms.common.ConnectionResult;
import com.jirbo.adcolony.AdColony;
import com.wTouch2KiLL.ads.AdsLoader;
import com.wTouch2KiLL.ads.AdsLoader.AdsLoadingFinishedListener;
import com.wTouch2KiLL.ads.AdsLoader.HeadersReceiver;
import com.wTouch2KiLL.ads.BottomBannerLayout;
import com.wTouch2KiLL.ads.FullscreenBanner.AdMobFSBannerController;
import com.wTouch2KiLL.ads.FullscreenBanner.FullScreenBannerController;
import com.wTouch2KiLL.ads.FullscreenBanner.IFullScreenBannerListener;
import com.wTouch2KiLL.ads.behavior.BehaviorAcceptor;
import com.wTouch2KiLL.ads.behavior.BehaviorFactory;
import com.wTouch2KiLL.ads.behavior.BehaviorVisitor;
import com.wTouch2KiLL.browser.DownloadsItem.Status;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.ApplicationThemes;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.TabsPositions;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.UrlBarStates;
import com.wTouch2KiLL.configuration.WebWidgetConfigurationManager;
import com.wTouch2KiLL.controllers.ITabsController;
import com.wTouch2KiLL.controllers.SplashScreenController;
import com.wTouch2KiLL.controllers.WebContentController;
import com.wTouch2KiLL.controllers.WidgetsController;
import com.wTouch2KiLL.deviceidparser.DeviceIdParameters;
import com.wTouch2KiLL.deviceidparser.DeviceIdParser;
import com.wTouch2KiLL.deviceidparser.IDeviceIdParserListener;
import com.wTouch2KiLL.media.camera.AlbumStorageController;
import com.wTouch2KiLL.model.WidgetEntity;
import com.wTouch2KiLL.model.WidgetEntity.DefaultWidgetType;
import com.wTouch2KiLL.notification.NotificationChecker;
import com.wTouch2KiLL.pull.PullServerController;
import com.wTouch2KiLL.server.AppsGeyserServerClient;
import com.wTouch2KiLL.server.PushServerClient;
import com.wTouch2KiLL.storage.BrowsingHistoryItem;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import com.wTouch2KiLL.ui.dialog.SimpleDialogs;
import com.wTouch2KiLL.ui.dialog.StartupConfirmationDialog;
import com.wTouch2KiLL.ui.menu.MenuItemsHolder;
import com.wTouch2KiLL.ui.navigationdrawer.NavigationDrawer;
import com.wTouch2KiLL.ui.navigationdrawer.NavigationDrawerHolder;
import com.wTouch2KiLL.ui.navigationwidget.INavigationWidget;
import com.wTouch2KiLL.ui.navigationwidget.NavigationWidget;
import com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget;
import com.wTouch2KiLL.ui.views.AboutDialog;
import com.wTouch2KiLL.ui.views.BrowserWebView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

public class MainNavigationActivity extends AppCompatActivity implements Callback, OnCompletionListener, OnErrorListener, AdsLoadingFinishedListener, HeadersReceiver, BehaviorAcceptor, IDeviceIdParserListener, IFullScreenBannerListener {
    private static final int ACTION_TAKE_PHOTO = 2;
    public static final String ADS_SLEEP_PARAM = "adsSleep";
    public static final String APPMODE_PARAM = "applicationMode";
    public static final String BANNER_JS_PARAM = "bannerJs";
    static final LayoutParams COVER_SCREEN_GRAVITY_CENTER;
    public static final int DOWNLOAD_START = 100;
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 35;
    public static final String PREFS_NAME = "AppsgeyserPrefs";
    public static final int REQUEST_CODE = 1;
    public static final int REQUEST_SELECT_FILE = 100;
    private static final int SEARCH_BAR_NOTIFICATION_ID = 120778953;
    private static boolean _active;
    private static volatile ApplicationState applicationState;
    MainNavigationActivity _activity;
    AdMobFSBannerController _adMobFSBannerController;
    WebWidgetConfiguration _config;
    Dialog _connectionErrorDialog;
    private ApplicationMode _currentMode;
    DeviceIdParameters _deviceIdParameters;
    FullScreenBannerController _fullScreenBannerController;
    private MenuItemsHolder _menuItemsHolder;
    private NavigationDrawer _navigationDrawer;
    PushServerClient _pushClient;
    AppsGeyserServerClient _serverClient;
    SplashScreenController _splashScreenController;
    ITabsController _tabsController;
    BroadcastReceiver activityReceiver;
    private boolean adsKeyboardShow;
    private AdsLoader adsLoader;
    private AlbumStorageController albumStorageController;
    StartupConfirmationDialog alertDialog;
    private BottomBannerLayout bannerLayout;
    private boolean isOptionDownloadsList;
    private Handler loadUrlFromIntentHandler;
    private Runnable loadUrlFromIntentRunnable;
    public AboutDialog mAboutDialog;
    private LinearLayout mContentView;
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private FrameLayout mFullScreenBannerView;
    private ViewGroup mSplashScreenView;
    private ValueCallback<Uri> mUploadMessage;
    private VideoView mVideo;
    private View mVideoProgressView;
    BroadcastReceiver onComplete;
    private boolean onCreateBeforeAds;
    BroadcastReceiver onNotificationClick;
    private ValueCallback<Integer> permissionCallback;
    public Long timeStart;
    public ValueCallback<Uri[]> uploadMessage;
    private String urlFromIntentToLoad;

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.10 */
    class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ HttpAuthHandler val$handler;
        final /* synthetic */ String val$host;
        final /* synthetic */ String val$realm;
        final /* synthetic */ View val$v;
        final /* synthetic */ WebView val$webView;

        AnonymousClass10(View view, WebView webView, String str, String str2, HttpAuthHandler httpAuthHandler) {
            this.val$v = view;
            this.val$webView = webView;
            this.val$host = str;
            this.val$realm = str2;
            this.val$handler = httpAuthHandler;
        }

        public void onClick(DialogInterface dialog, int whichButton) {
            String nm = ((EditText) this.val$v.findViewById(C0866R.id.username_edit)).getText().toString();
            String pw = ((EditText) this.val$v.findViewById(C0866R.id.password_edit)).getText().toString();
            MainNavigationActivity.this.setHttpAuthUsernamePassword(this.val$webView, this.val$host, this.val$realm, nm, pw);
            this.val$handler.proceed(nm, pw);
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ int val$id;
        final /* synthetic */ boolean val$visible;

        AnonymousClass12(int i, boolean z) {
            this.val$id = i;
            this.val$visible = z;
        }

        public void run() {
            MainNavigationActivity.this._menuItemsHolder.setItemVisible(this.val$id, this.val$visible);
            if (MainNavigationActivity.this._navigationDrawer != null) {
                MainNavigationActivity.this._navigationDrawer.setOptions(MainNavigationActivity.this._menuItemsHolder.getAllItems());
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ int val$viewVisililityCode;

        AnonymousClass14(int i) {
            this.val$viewVisililityCode = i;
        }

        public void run() {
            INavigationWidget navigationWIdget = Factory.getInstance().getNavigationWidget();
            if (navigationWIdget == null) {
                return;
            }
            if (this.val$viewVisililityCode == 0) {
                ((NavigationWidget) navigationWIdget).showAnimated();
            } else {
                ((NavigationWidget) navigationWIdget).hideAnimated();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.1 */
    class C08511 implements Runnable {
        C08511() {
        }

        public void run() {
            if (MainNavigationActivity.this.urlFromIntentToLoad != null && MainNavigationActivity.this.urlFromIntentToLoad.length() > 0) {
                WebContentController controller = MainNavigationActivity.this._tabsController.getSelectedTab();
                if (controller != null) {
                    WebView currentView = controller.getWebView();
                    currentView.stopLoading();
                    currentView.loadUrl(MainNavigationActivity.this.urlFromIntentToLoad);
                    return;
                }
                MainNavigationActivity.this.loadUrlFromIntentHandler.postDelayed(this, 500);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.2 */
    class C08522 implements OnClickListener {
        C08522() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainNavigationActivity.this._closeNavigationDrawer();
            MainNavigationActivity.applicationState = ApplicationState.EXITING;
            if (MainNavigationActivity.this._config.getOnExitFullscreenBannerEnabled()) {
                MainNavigationActivity.this._fullScreenBannerController.loadBanner();
            } else {
                MainNavigationActivity.this.finish();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.3 */
    class C08533 implements OnClickListener {
        C08533() {
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.4 */
    class C08574 implements Runnable {

        /* renamed from: com.wTouch2KiLL.MainNavigationActivity.4.1 */
        class C08541 implements OnClickListener {
            C08541() {
            }

            public void onClick(DialogInterface dialog, int which) {
                Editor editor = MainNavigationActivity.this.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).edit();
                editor.putBoolean("never_show", true);
                editor.apply();
                dialog.cancel();
            }
        }

        /* renamed from: com.wTouch2KiLL.MainNavigationActivity.4.2 */
        class C08552 implements OnClickListener {
            C08552() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        /* renamed from: com.wTouch2KiLL.MainNavigationActivity.4.3 */
        class C08563 implements OnClickListener {
            C08563() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MainNavigationActivity.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + MainNavigationActivity.this.getPackageName())), MainNavigationActivity.REQUEST_CODE);
            }
        }

        C08574() {
        }

        public void run() {
            try {
                SimpleDialogs.showNoticeDialog(MainNavigationActivity.this.getString(C0866R.string.permission), MainNavigationActivity.this.getString(C0866R.string.allow_show_permission), MainNavigationActivity.this, new C08541(), new C08552(), new C08563()).show();
            } catch (Exception e) {
                Log.e("Exception", XMLConstants.NULL_NS_URI + e);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.5 */
    class C08595 extends BroadcastReceiver {

        /* renamed from: com.wTouch2KiLL.MainNavigationActivity.5.1 */
        class C08581 implements View.OnClickListener {
            final /* synthetic */ Context val$context;

            C08581(Context context) {
                this.val$context = context;
            }

            public void onClick(View v) {
                MainNavigationActivity.this.startActivity(new Intent(this.val$context, DownloadsListActivity.class));
            }
        }

        C08595() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getIntExtra("type", 0) != MainNavigationActivity.REQUEST_SELECT_FILE) {
                    return;
                }
                if (MainNavigationActivity.this.isOptionDownloadsList) {
                    Snackbar.make(MainNavigationActivity.this.findViewById(C0866R.id.frame_layout), (int) C0866R.string.snackbar_downloads, 0).setAction((int) C0866R.string.view, new C08581(context)).show();
                } else {
                    Toast.makeText(context, C0866R.string.snackbar_downloads, 0).show();
                }
            } catch (Exception e) {
                Log.e("activityReceiver", XMLConstants.NULL_NS_URI + e);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.6 */
    class C08606 implements View.OnClickListener {
        C08606() {
        }

        public void onClick(View view) {
            MainNavigationActivity.this._tabsController = Factory.getInstance().getTabsController();
            MainNavigationActivity.this._tabsController.initWithTabs(Factory.getInstance().getWidgetsController());
            MainNavigationActivity.this._connectionErrorDialog.dismiss();
            MainNavigationActivity.this._connectionErrorDialog = null;
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.7 */
    class C08617 implements View.OnClickListener {
        C08617() {
        }

        public void onClick(View view) {
            MainNavigationActivity.this._connectionErrorDialog.dismiss();
            MainNavigationActivity.this._connectionErrorDialog = null;
            MainNavigationActivity.this._activity.finish();
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.8 */
    class C08628 implements OnCancelListener {
        final /* synthetic */ HttpAuthHandler val$handler;

        C08628(HttpAuthHandler httpAuthHandler) {
            this.val$handler = httpAuthHandler;
        }

        public void onCancel(DialogInterface dialog) {
            this.val$handler.cancel();
        }
    }

    /* renamed from: com.wTouch2KiLL.MainNavigationActivity.9 */
    class C08639 implements OnClickListener {
        final /* synthetic */ HttpAuthHandler val$handler;

        C08639(HttpAuthHandler httpAuthHandler) {
            this.val$handler = httpAuthHandler;
        }

        public void onClick(DialogInterface dialog, int whichButton) {
            this.val$handler.cancel();
        }
    }

    public enum ApplicationMode {
        UNKNOWN,
        COMMON,
        CUSTOM
    }

    public enum ApplicationState {
        STARTED,
        EXITING
    }

    public MainNavigationActivity() {
        this._config = null;
        this._deviceIdParameters = null;
        this._fullScreenBannerController = null;
        this._splashScreenController = null;
        this._pushClient = null;
        this.timeStart = null;
        this._currentMode = ApplicationMode.COMMON;
        this.isOptionDownloadsList = false;
        this.loadUrlFromIntentHandler = new Handler();
        this.loadUrlFromIntentRunnable = new C08511();
        this.activityReceiver = new C08595();
        this.onNotificationClick = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                MainNavigationActivity.this.startActivity(new Intent(context, DownloadsListActivity.class));
            }
        };
        this.onComplete = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                long reference = intent.getLongExtra("extra_download_id", -1);
                SQLiteDatabase db = new DatabaseOpenHelper(MainNavigationActivity.this).getWritableDatabase();
                ContentValues cv = new ContentValues();
                DownloadManager downloadManager = (DownloadManager) MainNavigationActivity.this.getSystemService("download");
                Query query = new Query();
                long[] jArr = new long[MainNavigationActivity.REQUEST_CODE];
                jArr[0] = reference;
                query.setFilterById(jArr);
                Cursor cursor = downloadManager.query(query);
                if (cursor.moveToFirst()) {
                    String savedFilePath;
                    int status = cursor.getInt(cursor.getColumnIndex(NotificationCompatApi21.CATEGORY_STATUS));
                    if (VERSION.SDK_INT > 10) {
                        savedFilePath = cursor.getString(cursor.getColumnIndex("local_filename"));
                    } else {
                        savedFilePath = cursor.getString(cursor.getColumnIndex("local_uri"));
                    }
                    int reason = cursor.getInt(cursor.getColumnIndex("reason"));
                    switch (status) {
                        case ConnectionResult.INTERNAL_ERROR /*8*/:
                            cv.put(NotificationCompatApi21.CATEGORY_STATUS, Status.Ok.toString());
                            cv.put("file_path", savedFilePath);
                            cv.put(SchemaSymbols.ATTVAL_DATE, Long.valueOf(System.currentTimeMillis()));
                            db.update("downloadsList", cv, "id_d = " + reference, null);
                            break;
                        case ConnectionResult.API_UNAVAILABLE /*16*/:
                            cv.put(NotificationCompatApi21.CATEGORY_STATUS, Status.Fail.toString());
                            cv.put("description", Integer.valueOf(reason));
                            cv.put(SchemaSymbols.ATTVAL_DATE, Long.valueOf(System.currentTimeMillis()));
                            db.update("downloadsList", cv, "id_d = " + reference, null);
                            break;
                    }
                }
                cursor.close();
                Intent msgIntent = new Intent();
                msgIntent.putExtra("type", DownloadsListActivity.DOWNLOAD_COMPLETE);
                msgIntent.setAction(DownloadsListActivity.DOWNLOAD_LIST_MSG);
                MainNavigationActivity.this.sendBroadcast(msgIntent);
                db.close();
            }
        };
    }

    public FullScreenBannerController getFullScreenBannerController() {
        return this._fullScreenBannerController;
    }

    public PushServerClient getPushClient() {
        if (this._pushClient == null) {
            this._pushClient = new PushServerClient(this);
        }
        return this._pushClient;
    }

    public AdMobFSBannerController getAdMobFSBannerController() {
        return this._adMobFSBannerController;
    }

    static {
        COVER_SCREEN_GRAVITY_CENTER = new LayoutParams(-1, -1, 17);
        _active = false;
    }

    public StartupConfirmationDialog getAlertDialog() {
        return this.alertDialog;
    }

    public static ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        applicationState = applicationState;
    }

    public void setPermissionCallback(ValueCallback<Integer> permissionCallback) {
        this.permissionCallback = permissionCallback;
    }

    public DeviceIdParameters getDeviceIdParameters() {
        return this._deviceIdParameters;
    }

    public void setDeviceIdParameters(DeviceIdParameters _deviceIdParameters) {
        this._deviceIdParameters = _deviceIdParameters;
    }

    public BottomBannerLayout getBannerLayout() {
        return this.bannerLayout;
    }

    public void setMStartupScreenViewContainer(FrameLayout mStartupScreenViewContainer) {
        this.mFullScreenBannerView = mStartupScreenViewContainer;
    }

    public void onCreate(Bundle savedInstanceState) {
        int tabsLayoutId;
        super.onCreate(null);
        this._activity = this;
        Factory.getInstance().Init(this._activity);
        applicationState = ApplicationState.STARTED;
        try {
            this._config = WebWidgetConfigurationManager.getInstance(this._activity).loadConfiguration(this._activity);
            this._serverClient = AppsGeyserServerClient.getInstance(this._activity);
            this._serverClient.SendAfterInstallInfo();
            this._serverClient.SendUsageInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadPreviousApplicationMode();
        _applyAppTheme(this._config);
        setContentView((int) C0866R.layout.main);
        _postApplyAppTheme(this._config);
        this._serverClient.GetApplicationMode();
        this.mContentView = (LinearLayout) findViewById(C0866R.id.contentFrame);
        if (this._config.getTabsPosition() == TabsPositions.BOTTOM) {
            tabsLayoutId = C0866R.layout.tabs_panel_bottom;
        } else {
            tabsLayoutId = C0866R.layout.tabs_panel;
        }
        getLayoutInflater().inflate(tabsLayoutId, this.mContentView, true);
        this.mContentView.setKeepScreenOn(this._config.getPreventFromSleep());
        this.mCustomViewContainer = (FrameLayout) findViewById(C0866R.id.customFrame);
        this.mFullScreenBannerView = (FrameLayout) findViewById(C0866R.id.fullScreenBannerContainer);
        this.mSplashScreenView = (ViewGroup) findViewById(C0866R.id.splashScreenView);
        this._splashScreenController = new SplashScreenController(this.mSplashScreenView, this);
        if (this._config.isSplashScreenEnabled()) {
            this._splashScreenController.showSplashScreen(this._config.getSplashScreenImage());
        } else {
            showContentView();
        }
        this._adMobFSBannerController = new AdMobFSBannerController(this);
        if (!StartupConfirmationDialog.isAlreadyShown(this) && this._config.isStartupConfirmationDialogEnabled()) {
            this.alertDialog = new StartupConfirmationDialog(this);
            this.alertDialog.show();
        }
        this.albumStorageController = new AlbumStorageController(this._config.getWidgetName());
        boolean quickSearch = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(SettingsActivity.KEY_QUICK_SEARCH, true);
        if (quickSearch && getConfig().getShowSearchNotice() && getConfig().getUrlOverlayState() == UrlBarStates.ENABLED) {
            createNotice();
        }
        if (quickSearch && getIntent().getBooleanExtra("focus", false)) {
            this.adsKeyboardShow = false;
            this.onCreateBeforeAds = true;
        }
        _initAppContent();
        DeviceIdParser.getInstance().rescan(this, this);
        new PullServerController().reScheduleNotification(this);
        new NotificationChecker().rescheduleLaunch(this);
        if (this.timeStart == null) {
            this.timeStart = Long.valueOf(System.currentTimeMillis());
        }
        registerReceiver(this.onComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        registerReceiver(this.activityReceiver, new IntentFilter(DownloadsListActivity.DOWNLOAD_LIST_MSG));
        registerReceiver(this.onNotificationClick, new IntentFilter("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED"));
    }

    public void createNotice() {
        Builder mBuilder = new Builder(this).setSmallIcon(C0866R.drawable.ic_search_white_24dp).setContent(new RemoteViews(getPackageName(), C0866R.layout.search_notice)).setOngoing(true);
        Intent resultIntent = new Intent(this, MainNavigationActivity.class);
        resultIntent.putExtra("focus", true);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainNavigationActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        mBuilder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), resultIntent, 0));
        ((NotificationManager) getSystemService("notification")).notify(SEARCH_BAR_NOTIFICATION_ID, mBuilder.build());
    }

    public void setAdsKeyboardShow(boolean adsKeyboardShow) {
        this.adsKeyboardShow = adsKeyboardShow;
    }

    public boolean getAdsKeyboardShow() {
        return this.adsKeyboardShow;
    }

    public void deleteNotice() {
        ((NotificationManager) getSystemService("notification")).cancel(SEARCH_BAR_NOTIFICATION_ID);
    }

    protected void onStart() {
        super.onStart();
    }

    private void _applyAppTheme(WebWidgetConfiguration config) {
        if (config.getApplicationTheme() == ApplicationThemes.ACTION_BAR) {
            try {
                setTheme(C0866R.style.AppThemeActionBar);
                ActionBar bar = getSupportActionBar();
                if (bar != null) {
                    bar.setElevation(0.0f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void _postApplyAppTheme(WebWidgetConfiguration config) {
        this._navigationDrawer = NavigationDrawerHolder.getNavigationDrawer(this);
        if (config.getApplicationTheme() == ApplicationThemes.SLIDER) {
            _showNavigationDrawer();
        } else {
            _removeNavigationDrawer();
        }
    }

    private void _initAppContent() {
        this._tabsController = Factory.getInstance().getTabsController();
        this._tabsController.initWithTabs(Factory.getInstance().getWidgetsController());
        CookieSyncManager.createInstance(this._activity);
        CookieSyncManager.getInstance().startSync();
        this.mAboutDialog = new AboutDialog(this._activity, C0866R.style.FullHeightDialog);
    }

    public void showCloseAppDialog() {
        SimpleDialogs.createConfirmDialog(null, getResources().getString(C0866R.string.appExitCaption), this, new C08522(), null).show();
    }

    public void showMessage(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this._activity);
        builder.setMessage(text);
        builder.setPositiveButton("ok", new C08533());
        builder.create().show();
    }

    public void showPausedContentInfo() {
        if (this._tabsController == null) {
            this._tabsController = Factory.getInstance().getTabsController();
        }
        WidgetsController widgetCtrlr = Factory.getInstance().getWidgetsController();
        widgetCtrlr.removeAll();
        widgetCtrlr.addWidget(WidgetEntity.createDefaultWidget(DefaultWidgetType.PAUSED));
        this._tabsController.initWithTabs(widgetCtrlr);
    }

    public void setApplicationMode(ApplicationMode mode) {
        if (!(mode == ApplicationMode.UNKNOWN || this._currentMode == mode)) {
            getSharedPreferences(PREFS_NAME, 0).edit().putInt(APPMODE_PARAM, this._currentMode.ordinal()).apply();
            this._currentMode = mode;
        }
        if (this.mAboutDialog != null) {
            this.mAboutDialog.setApplicationMode(this._currentMode);
        }
    }

    public void loadPreviousApplicationMode() {
        int mode = getSharedPreferences(PREFS_NAME, 0).getInt(APPMODE_PARAM, ApplicationMode.COMMON.ordinal());
        if (ApplicationMode.COMMON.ordinal() == mode) {
            this._currentMode = ApplicationMode.COMMON;
        } else if (ApplicationMode.CUSTOM.ordinal() == mode) {
            this._currentMode = ApplicationMode.CUSTOM;
        }
        if (this.mAboutDialog != null) {
            this.mAboutDialog.setApplicationMode(this._currentMode);
        }
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
        this.mUploadMessage = uploadMsg;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (acceptType.length() == 0) {
            acceptType = "*/*";
        }
        intent.setType(acceptType);
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), REQUEST_CODE);
    }

    public boolean openFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
        if (VERSION.SDK_INT < 21) {
            return false;
        }
        if (this.uploadMessage != null) {
            this.uploadMessage.onReceiveValue(null);
            this.uploadMessage = null;
        }
        this.uploadMessage = filePathCallback;
        try {
            startActivityForResult(fileChooserParams.createIntent(), REQUEST_SELECT_FILE);
            return true;
        } catch (ActivityNotFoundException e) {
            this.uploadMessage = null;
            Toast.makeText(getApplicationContext(), "Cannot Open File Chooser", REQUEST_CODE).show();
            return false;
        }
    }

    public void checkDrawOverlayPermission() {
        if (VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(getApplicationContext())) {
            new Handler().postDelayed(new C08574(), 10000 - (Long.valueOf(System.currentTimeMillis()).longValue() - this.timeStart.longValue()));
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (VERSION.SDK_INT >= 21 && requestCode == REQUEST_SELECT_FILE) {
            if (this.uploadMessage != null) {
                this.uploadMessage.onReceiveValue(FileChooserParams.parseResult(resultCode, intent));
                this.uploadMessage = null;
            } else {
                return;
            }
        }
        if (requestCode != REQUEST_CODE) {
            Toast.makeText(getApplicationContext(), C0866R.string.failed_upload_file, REQUEST_CODE).show();
        } else if (this.mUploadMessage != null) {
            Uri result = (intent == null || resultCode != -1) ? null : intent.getData();
            this.mUploadMessage.onReceiveValue(result);
            this.mUploadMessage = null;
        }
    }

    private void dispatchTakePictureIntent(int actionCode) {
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        switch (actionCode) {
            case ACTION_TAKE_PHOTO /*2*/:
                try {
                    File f = this.albumStorageController.setUpPhotoFile();
                    this.albumStorageController.setCurrentPhotoPath(f.getAbsolutePath());
                    takePictureIntent.putExtra("output", Uri.fromFile(f));
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                    this.albumStorageController.setCurrentPhotoPath(null);
                    break;
                }
        }
        startActivityForResult(takePictureIntent, actionCode);
    }

    public static boolean isIntentAvailable(Context context, String action) {
        return context.getPackageManager().queryIntentActivities(new Intent(action), AccessibilityNodeInfoCompat.ACTION_CUT).size() > 0;
    }

    protected void onPause() {
        super.onPause();
        AdColony.pause();
        _active = false;
        boolean showing = ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        if (((TelephonyManager) getSystemService("phone")).getCallState() == REQUEST_CODE) {
            pauseBrowser();
        }
        if (!showing) {
            pauseBrowser();
        }
    }

    public void pauseBrowser() {
        BrowserWebView bannerBrowser = (BrowserWebView) findViewById(C0866R.id.banner_webkit);
        if (bannerBrowser != null) {
            if (!this._adMobFSBannerController.isActive()) {
                bannerBrowser.pauseTimers();
            }
            this._adMobFSBannerController.setActive(false);
        }
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        AdColony.resume(this);
        _active = true;
        Intent intent = getIntent();
        if (intent != null) {
            Uri url = intent.getData();
            if (url != null) {
                this.urlFromIntentToLoad = url.toString();
                this.loadUrlFromIntentHandler.post(this.loadUrlFromIntentRunnable);
            }
        }
        if (!this._config.getPreventFromSleep()) {
            if (this._config.getPushAccount().length() != 0) {
                String regId = GCMRegistrar.getRegistrationId(this);
                if (regId == null || XMLConstants.NULL_NS_URI.equals(regId)) {
                    registerGCM(this._config.getPushAccount());
                } else {
                    if (this._pushClient == null) {
                        this._pushClient = new PushServerClient(this);
                    }
                    this._pushClient.sendRegisteredId(regId);
                }
            } else if (this._config.getAppGuid().length() > 0) {
                updatePushAccount();
            }
            BrowserWebView bannerBrowser = (BrowserWebView) findViewById(C0866R.id.banner_webkit);
            if (bannerBrowser != null) {
                bannerBrowser.resumeTimers();
            }
            CookieSyncManager.getInstance().startSync();
        }
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(SettingsActivity.KEY_QUICK_SEARCH, true) && Factory.getInstance().getNavigationWidget() != null && getIntent().getBooleanExtra("focus", false)) {
            Factory.getInstance().getTabsController().getSelectedTab().getNavigationWidget().getNawigationWidgetView().findViewById(C0866R.id.urlTextbox).requestFocus();
            getIntent().removeExtra("focus");
        }
    }

    public void updatePushAccount() {
        if (this._pushClient == null) {
            this._pushClient = new PushServerClient(this);
        }
        this._pushClient.loadPushAccount();
    }

    public void registerGCM(String pushAccount) {
        String[] strArr = new String[REQUEST_CODE];
        strArr[0] = pushAccount;
        GCMRegistrar.register(this, strArr);
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            setIntent(intent);
            Uri url = intent.getData();
            if (url != null) {
                this.urlFromIntentToLoad = url.toString();
                this.loadUrlFromIntentHandler.post(this.loadUrlFromIntentRunnable);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.onComplete);
        unregisterReceiver(this.activityReceiver);
        unregisterReceiver(this.onNotificationClick);
        System.exit(0);
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (this._navigationDrawer != null && this._navigationDrawer.isOpened()) {
            _closeNavigationDrawer();
            return true;
        } else if (this.mCustomView != null) {
            onHideCustomView();
            return true;
        } else {
            INavigationWidget navigationWIdget = Factory.getInstance().getNavigationWidget();
            if (navigationWIdget != null && (navigationWIdget instanceof TopNavigationWidget) && ((TopNavigationWidget) navigationWIdget).isSuggestionsVisible()) {
                ((TopNavigationWidget) navigationWIdget).hideSuggestionsView();
                return true;
            }
            if (!this._tabsController.onBackKeyDown()) {
                if (getFullScreenBannerController().isOnScreen()) {
                    if (!getFullScreenBannerController().isBackKeyLocked()) {
                        getFullScreenBannerController().closeBanner();
                    }
                } else if (!getApplicationState().equals(ApplicationState.EXITING)) {
                    showCloseAppDialog();
                }
            }
            return true;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this._menuItemsHolder == null) {
            this._menuItemsHolder = new MenuItemsHolder(this._config, this._currentMode, this, menu);
        }
        if (this._navigationDrawer != null) {
            this._navigationDrawer.setOptions(this._menuItemsHolder.getAllItems());
            this._navigationDrawer.show();
        }
        try {
            this.isOptionDownloadsList = this._config.getShowDownloadList();
        } catch (Exception e) {
            Log.e("isOptionDownloadsList", XMLConstants.NULL_NS_URI + e);
        }
        return super.onCreateOptionsMenu(this._menuItemsHolder.getMenu());
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (_isMenuItemId(item.getItemId())) {
            return onOptionsItemSelected(item.getItemId(), item);
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean _isMenuItemId(int itemId) {
        return itemId == C0866R.id.webapp_exit || itemId == C0866R.id.webapp_refresh || itemId == C0866R.id.webapp_about || itemId == C0866R.id.webapp_rate || itemId == C0866R.id.webapp_share || itemId == C0866R.id.webapp_back || itemId == C0866R.id.webapp_forward || itemId == C0866R.id.webapp_request_desktop || itemId == C0866R.id.webapp_pin_to_desktop || itemId == C0866R.id.webapp_add_to_home || itemId == C0866R.id.webapp_home || itemId == C0866R.id.webapp_downloads_list || itemId == C0866R.id.webapp_settings;
    }

    public boolean onOptionsItemSelected(int itemId, MenuItem item) {
        boolean z = false;
        NavigationWidget navigationWidget = (NavigationWidget) Factory.getInstance().getNavigationWidget();
        switch (itemId) {
            case C0866R.id.webapp_back /*2131427544*/:
                if (navigationWidget == null) {
                    return true;
                }
                navigationWidget.onClickBackButton();
                return true;
            case C0866R.id.webapp_forward /*2131427545*/:
                if (navigationWidget == null) {
                    return true;
                }
                navigationWidget.onClickForwardButton();
                return true;
            case C0866R.id.webapp_request_desktop /*2131427546*/:
                if (navigationWidget == null || item == null) {
                    return true;
                }
                boolean z2;
                if (item.isChecked()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                navigationWidget.reloadWithChangedUserAgent(z2);
                if (!item.isChecked()) {
                    z = true;
                }
                item.setChecked(z);
                return true;
            case C0866R.id.webapp_pin_to_desktop /*2131427547*/:
                if (navigationWidget == null) {
                    return true;
                }
                navigationWidget.onPinToHomeScreenButtonClick();
                return true;
            case C0866R.id.webapp_add_to_home /*2131427548*/:
                if (navigationWidget == null) {
                    return true;
                }
                navigationWidget.onAddToStartPageClick();
                return true;
            case C0866R.id.webapp_home /*2131427549*/:
                if (navigationWidget == null) {
                    return true;
                }
                navigationWidget.onHomeButtonClick();
                return true;
            case C0866R.id.webapp_downloads_list /*2131427550*/:
                startActivity(new Intent(this, DownloadsListActivity.class));
                return true;
            case C0866R.id.webapp_settings /*2131427551*/:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case C0866R.id.webapp_refresh /*2131427552*/:
                this._tabsController.getSelectedTab().getWebView().reload();
                return true;
            case C0866R.id.webapp_share /*2131427553*/:
                String bodyText;
                String subjectText;
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                if (this._config.getShareExtraLink() != null && !this._config.getShareExtraLink().equals(XMLConstants.NULL_NS_URI)) {
                    bodyText = this._config.getShareExtraLink();
                    subjectText = getResources().getString(C0866R.string.shareContentSubject);
                } else if (this._config.getUrlOverlayState() == UrlBarStates.ENABLED) {
                    bodyText = Factory.getInstance().getTabsController().getSelectedTab().getWebView().getUrl();
                    subjectText = getResources().getString(C0866R.string.shareSiteSubject);
                } else {
                    bodyText = getResources().getString(C0866R.string.getWidgetUrl) + this._config.getApplicationId() + "?" + this._config.getAffiliateString();
                    subjectText = getResources().getString(C0866R.string.shareContentSubject);
                }
                sharingIntent.putExtra("android.intent.extra.TEXT", bodyText);
                sharingIntent.putExtra("android.intent.extra.SUBJECT", subjectText);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return true;
            case C0866R.id.webapp_about /*2131427554*/:
                this.mAboutDialog.showDialog();
                return true;
            case C0866R.id.webapp_rate /*2131427555*/:
                this._activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this._activity.getPackageName())));
                return true;
            case C0866R.id.webapp_exit /*2131427556*/:
                showCloseAppDialog();
                return true;
            default:
                return false;
        }
    }

    public void showConnectionErrorDialog() {
        if (this._connectionErrorDialog == null) {
            this._connectionErrorDialog = new Dialog(this, C0866R.style.FullHeightDialog);
            this._connectionErrorDialog.setContentView(C0866R.layout.connection_error_dialog);
            ((TextView) this._connectionErrorDialog.findViewById(C0866R.id.text)).setText(getResources().getString(C0866R.string.noInternetConnectionMessage));
            Button btn = (Button) this._connectionErrorDialog.findViewById(C0866R.id.ok);
            btn.setText("Try Again");
            btn.setOnClickListener(new C08606());
            btn = (Button) this._connectionErrorDialog.findViewById(C0866R.id.cancel);
            btn.setText("Exit");
            btn.setOnClickListener(new C08617());
            this._connectionErrorDialog.setCancelable(true);
            this._connectionErrorDialog.show();
        }
    }

    public void invoke(String origin, boolean allow, boolean remember) {
    }

    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            this.mVideoProgressView = LayoutInflater.from(this).inflate(C0866R.layout.video_loading_progress, null);
        }
        return this.mVideoProgressView;
    }

    public void onShowCustomView(View view, CustomViewCallback callback) {
        if (this.mCustomView != null) {
            callback.onCustomViewHidden();
            return;
        }
        if (view instanceof FrameLayout) {
            FrameLayout frame = (FrameLayout) view;
            if (frame.getFocusedChild() instanceof VideoView) {
                this.mVideo = (VideoView) frame.getFocusedChild();
                this.mVideo.setOnCompletionListener(this);
                this.mVideo.setOnErrorListener(this);
            }
        }
        this.mCustomViewContainer.addView(view, COVER_SCREEN_GRAVITY_CENTER);
        this.mCustomView = view;
        this.mCustomViewCallback = callback;
        this.mContentView.setVisibility(8);
        _hideNavigationDrawer();
        this.mCustomViewContainer.setVisibility(0);
        this.mCustomViewContainer.bringToFront();
    }

    public void onHideCustomView() {
        if (this.mCustomView != null) {
            if (this.mVideo != null) {
                this.mVideo.stopPlayback();
            }
            this.mCustomView.setVisibility(8);
            this.mCustomViewContainer.removeView(this.mCustomView);
            this.mCustomView = null;
            this.mCustomViewContainer.setVisibility(8);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mContentView.setVisibility(0);
            _showNavigationDrawer();
        }
    }

    public void showContentView() {
        this.mFullScreenBannerView.setVisibility(8);
        this.mContentView.setVisibility(0);
        this.mSplashScreenView.setVisibility(8);
        this.mContentView.bringToFront();
        _showNavigationDrawer();
    }

    public void showFullscreenBannerView() {
        this.mContentView.setVisibility(8);
        this.mFullScreenBannerView.setVisibility(0);
        this.mSplashScreenView.setVisibility(8);
        this.mFullScreenBannerView.bringToFront();
        _hideNavigationDrawer();
    }

    public void showSplashScreen() {
        this.mContentView.setVisibility(8);
        this.mFullScreenBannerView.setVisibility(8);
        this.mSplashScreenView.setVisibility(0);
        this.mSplashScreenView.bringToFront();
        _hideNavigationDrawer();
    }

    public void showVideoView() {
        this.mContentView.setVisibility(8);
        this.mFullScreenBannerView.setVisibility(8);
        this.mSplashScreenView.setVisibility(8);
        _hideNavigationDrawer();
    }

    public void onCompletion(MediaPlayer mp) {
        mp.stop();
        onHideCustomView();
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (getIntent() != null) {
            Uri uri = getIntent().getData();
            if (uri != null) {
                intent.setData(uri);
                startActivity(intent);
            }
        }
        return false;
    }

    public WebWidgetConfiguration getConfig() {
        return this._config;
    }

    public void showHttpAuthentication(WebView webView, HttpAuthHandler handler, String host, String realm, String title, String name, String password, int focusId) {
        if (getResources().getBoolean(C0866R.bool.autoHttpAuthorization)) {
            String login = this._config.getHttpAccessLogin();
            String pass = this._config.getHttpAccessPassword();
            setHttpAuthUsernamePassword(webView, host, realm, login, pass);
            handler.proceed(login, pass);
            return;
        }
        View v = LayoutInflater.from(this).inflate(C0866R.layout.http_authentication, null);
        if (name != null) {
            ((EditText) v.findViewById(C0866R.id.username_edit)).setText(name);
        }
        if (password != null) {
            ((EditText) v.findViewById(C0866R.id.password_edit)).setText(password);
        }
        String titleText = title;
        if (titleText == null) {
            titleText = getText(C0866R.string.sign_in_to).toString().replace("%s1", host).replace("%s2", realm);
        }
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle(titleText).setView(v).setPositiveButton("Sign in", new AnonymousClass10(v, webView, host, realm, handler)).setNegativeButton("Cancel", new C08639(handler)).setOnCancelListener(new C08628(handler)).create();
        dialog.getWindow().setSoftInputMode(4);
        dialog.show();
        if (focusId != 0) {
            dialog.findViewById(focusId).requestFocus();
        } else {
            v.findViewById(C0866R.id.username_edit).requestFocus();
        }
    }

    public void setHttpAuthUsernamePassword(WebView webView, String host, String realm, String username, String password) {
        if (webView != null) {
            webView.setHttpAuthUsernamePassword(host, realm, username, password);
        }
    }

    public boolean onAdHeadersReceived(Map<String, List<String>> headers) {
        _applyBehaviors(new BehaviorFactory().createPreloadBehaviors(headers));
        if (new Date().compareTo(new Date(getSharedPreferences(PREFS_NAME, 0).getLong(ADS_SLEEP_PARAM, 0))) >= 0) {
            return true;
        }
        return false;
    }

    public void onAdLoadFinished() {
        _applyBehaviors(new BehaviorFactory().createPostloadBehaviors(this.adsLoader.getLastResponseHeaders()));
        if (this.onCreateBeforeAds) {
            this.adsKeyboardShow = true;
            this.onCreateBeforeAds = false;
            runOnUiThread(new Runnable() {
                public void run() {
                    ((InputMethodManager) MainNavigationActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(MainNavigationActivity.this.mCustomViewContainer.getWindowToken(), 0);
                }
            });
        }
    }

    private void _applyBehaviors(List<BehaviorVisitor> behaviors) {
        for (BehaviorVisitor visitor : behaviors) {
            acceptBehavior(visitor);
            this.adsLoader.acceptBehavior(visitor);
            this.bannerLayout.acceptBehavior(visitor);
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (this._config.getApplicationTheme() == ApplicationThemes.SLIDER) {
            if (this._menuItemsHolder == null) {
                this._menuItemsHolder = new MenuItemsHolder(this._config, this);
            }
            if (this._navigationDrawer != null) {
                this._navigationDrawer.setOptions(this._menuItemsHolder.getAllItems());
                this._navigationDrawer.show();
            }
        }
    }

    public void acceptBehavior(BehaviorVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isCurrentStartupAdView() {
        return this.mFullScreenBannerView.getVisibility() == 0;
    }

    public void setMenuItemVisible(int id, boolean visible) {
        if (this._menuItemsHolder != null) {
            runOnUiThread(new AnonymousClass12(id, visible));
        }
    }

    public void onDeviceIdParametersObtained(DeviceIdParameters result) {
        this._deviceIdParameters = result;
        this._fullScreenBannerController = new FullScreenBannerController(this.mFullScreenBannerView, this);
        this._fullScreenBannerController.setFullScreenBannerListener(this);
        applicationState = ApplicationState.STARTED;
        this._fullScreenBannerController.loadBanner();
        this.adsLoader = new AdsLoader();
        this.bannerLayout = new BottomBannerLayout();
        this.bannerLayout.init(this, this.adsLoader);
        this.bannerLayout.setPosition(this._config.getBannerPosition());
        this.adsLoader.init(this._serverClient.GetBannerUrl(), this);
        this.adsLoader.setAdsLoadingFinishedListener(this);
        this.adsLoader.setHeaderReceiver(this);
        this.adsLoader.setBottomBannerLayout(this.bannerLayout);
        this.adsLoader.reload();
    }

    private void _showNavigationDrawer() {
        if (this._navigationDrawer != null) {
            this._navigationDrawer.show();
        }
    }

    private void _hideNavigationDrawer() {
        if (this._navigationDrawer != null) {
            this._navigationDrawer.hide();
        }
    }

    private void _removeNavigationDrawer() {
        if (this._navigationDrawer != null) {
            this._navigationDrawer.remove();
        }
    }

    private void _closeNavigationDrawer() {
        if (this._navigationDrawer != null) {
            this._navigationDrawer.close();
        }
    }

    public static boolean isActive() {
        return _active;
    }

    public void onLoadStarted() {
    }

    public void onLoadFinished() {
    }

    public void onAdFailedToLoad() {
    }

    public void onAdClosed() {
        if (this.adsKeyboardShow) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Factory.getInstance().getTabsController().getSelectedTab().getNavigationWidget().getNawigationWidgetView().findViewById(C0866R.id.urlTextbox).requestFocus();
                }
            });
            this.adsKeyboardShow = false;
        }
        if (getApplicationState().equals(ApplicationState.EXITING)) {
            finish();
        }
    }

    public void setUrlBarVisibility(int viewVisililityCode) {
        runOnUiThread(new AnonymousClass14(viewVisililityCode));
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE /*35*/:
                if (this.permissionCallback != null) {
                    this.permissionCallback.onReceiveValue(Integer.valueOf(grantResults[0]));
                    this.permissionCallback = null;
                }
            default:
        }
    }

    public ArrayList<BrowsingHistoryItem> getWeeklyHistory() {
        ArrayList<BrowsingHistoryItem> historyItems = new ArrayList();
        INavigationWidget navigationWIdget = Factory.getInstance().getNavigationWidget();
        if (navigationWIdget == null || !(navigationWIdget instanceof NavigationWidget)) {
            return historyItems;
        }
        return ((NavigationWidget) navigationWIdget).getWeeklyHistory();
    }

    public int removeHistoryItem(long id) {
        INavigationWidget navigationWIdget = Factory.getInstance().getNavigationWidget();
        if (navigationWIdget == null || !(navigationWIdget instanceof NavigationWidget)) {
            return -1;
        }
        return ((NavigationWidget) navigationWIdget).removeHistoryItem(id);
    }

    public int removeHistoryAllItem() {
        INavigationWidget navigationWIdget = Factory.getInstance().getNavigationWidget();
        if (navigationWIdget == null || !(navigationWIdget instanceof NavigationWidget)) {
            return -1;
        }
        return ((NavigationWidget) navigationWIdget).removeHistoryAllItem();
    }
}
