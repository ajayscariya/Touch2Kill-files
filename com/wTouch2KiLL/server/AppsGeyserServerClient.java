package com.wTouch2KiLL.server;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.MainNavigationActivity.ApplicationMode;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;
import com.wTouch2KiLL.utils.Geolocation;
import mf.javax.xml.XMLConstants;

public class AppsGeyserServerClient extends BaseServerClient implements OnRequestDoneListener {
    private static final String FIRST_START_KEY = "isFirstStart";
    private static final int FORBIDDEN_RESPONSE = 403;
    private static final int OK_RESPONSE = 200;
    private static AppsGeyserServerClient instance;
    private String _appGuid;
    private Handler handler;
    private ApplicationMode mAppMode;

    /* renamed from: com.wTouch2KiLL.server.AppsGeyserServerClient.1 */
    class C09401 extends Handler {
        C09401() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == RequestType.AFTERINSTALL.ordinal() && AppsGeyserServerClient.this._config.getPushAccount().length() == 0) {
                AppsGeyserServerClient.this._activity.updatePushAccount();
            }
            super.handleMessage(msg);
        }
    }

    enum RequestType {
        AFTERINSTALL,
        USAGE,
        CLICK,
        APPMODE
    }

    public static AppsGeyserServerClient getInstance(MainNavigationActivity activity) {
        if (instance == null) {
            instance = new AppsGeyserServerClient(activity);
        }
        return instance;
    }

    public void destroy() {
        instance = null;
    }

    private AppsGeyserServerClient(MainNavigationActivity activity) {
        super(activity);
        this._appGuid = XMLConstants.NULL_NS_URI;
        this.mAppMode = ApplicationMode.UNKNOWN;
        this.handler = new C09401();
        this._appGuid = this._config.getAppGuid();
        if (this._appGuid.length() == 0) {
            this._appGuid = this._config.loadGuid(activity);
        }
    }

    public void onRequestDone(String requestUrl, int tag, String response) {
    }

    public void SendAfterInstallInfo() {
        if (_isFirstStart()) {
            sendRequestAsync(this._config.getRegisteredUrl() + "?action=install&name=" + String.valueOf(this._config.getApplicationId()) + "&id=" + this._appGuid + "&v=" + this._context.getString(C0866R.string.platformVersion) + "&p=android" + "&market=" + _getInstallerMarket(), Integer.valueOf(RequestType.AFTERINSTALL.ordinal()), this);
        }
    }

    public void SendUsageInfo() {
        sendRequestAsync(this._config.getAddUsageUrl() + "?action=usage&name=" + String.valueOf(this._config.getApplicationId()) + "&id=" + this._appGuid + "&v=" + this._context.getString(C0866R.string.platformVersion) + "&p=android", Integer.valueOf(RequestType.USAGE.ordinal()), this);
    }

    public void GetApplicationMode() {
        sendRequestAsync(this._context.getResources().getString(C0866R.string.getAppModeUrl) + "?wid=" + String.valueOf(this._config.getApplicationId()), Integer.valueOf(RequestType.APPMODE.ordinal()), this);
    }

    public String GetBannerUrl() {
        return Factory.getInstance().getMainNavigationActivity().getResources().getString(C0866R.string.adsDomainUrl) + _getBaseBannerQueryString();
    }

    public String getOnExitFullScreenBannerUrl() {
        return Factory.getInstance().getMainNavigationActivity().getResources().getString(C0866R.string.fullScreenBannerUrl) + _getOnExitBannerQueryString();
    }

    public String getOnStartFullScreenBannerUrl() {
        return Factory.getInstance().getMainNavigationActivity().getResources().getString(C0866R.string.fullScreenBannerUrl) + _getOnStartBannerQueryString();
    }

    private String _getOnStartBannerQueryString() {
        return _getBaseBannerQueryString() + "&action=onstart";
    }

    private String _getOnExitBannerQueryString() {
        return _getBaseBannerQueryString() + "&action=onexit";
    }

    private String _getBaseBannerQueryString() {
        MainNavigationActivity activity = Factory.getInstance().getMainNavigationActivity();
        String version = activity.getResources().getString(C0866R.string.platformVersion);
        String strUrl = XMLConstants.NULL_NS_URI;
        String deviceIdSection = XMLConstants.NULL_NS_URI;
        String advId = activity.getDeviceIdParameters().getAdvid();
        String limitAdTrackingEnabled = activity.getDeviceIdParameters().getLimitAdTrackingEnabled().toString().toLowerCase();
        String aid = activity.getDeviceIdParameters().getAid();
        if (advId == null || advId.equals(XMLConstants.NULL_NS_URI)) {
            deviceIdSection = "&aid=" + aid;
        } else {
            deviceIdSection = "&advid=" + advId + "&limit_ad_tracking_enabled=" + limitAdTrackingEnabled;
        }
        double[] coords = Geolocation.getCoords(activity);
        return "?widgetid=" + this._config.getApplicationId() + "&guid=" + this._appGuid + "&v=" + version + deviceIdSection + "&tlat=" + coords[0] + "&tlon=" + coords[1] + "&p=android";
    }

    public void SendClickInfo(String reportUrl) {
        sendRequestAsync(reportUrl, Integer.valueOf(RequestType.CLICK.ordinal()), this);
    }

    private boolean _isFirstStart() {
        SharedPreferences preferences = this._activity.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0);
        boolean firstStart = preferences.getBoolean(FIRST_START_KEY, true);
        if (firstStart) {
            preferences.edit().putBoolean(FIRST_START_KEY, false).commit();
        }
        return firstStart;
    }

    private String _getInstallerMarket() {
        String installerMarket = XMLConstants.NULL_NS_URI;
        try {
            installerMarket = this._activity.getApplicationContext().getPackageManager().getInstallerPackageName(this._activity.getApplicationContext().getPackageName());
            if (installerMarket == null) {
                return XMLConstants.NULL_NS_URI;
            }
            return installerMarket;
        } catch (Exception e) {
            installerMarket = "ERROR";
            if (e == null || e.getMessage() == null || e.getMessage().length() <= 0) {
                return installerMarket;
            }
            return installerMarket + ":" + e.getMessage();
        }
    }
}
