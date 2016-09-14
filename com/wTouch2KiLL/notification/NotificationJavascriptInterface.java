package com.wTouch2KiLL.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.SettingsActivity;
import com.wTouch2KiLL.javascriptinterface.BaseBrowserJavascriptInterface;
import com.wTouch2KiLL.utils.UrlConverter;
import java.util.GregorianCalendar;
import mf.javax.xml.XMLConstants;

public class NotificationJavascriptInterface extends BaseBrowserJavascriptInterface {
    public static final String JS_INTERFACE_NAME = "NotificationInterface";
    private Context _context;
    private NotificationService _service;
    private SharedPreferences settings;

    /* renamed from: com.wTouch2KiLL.notification.NotificationJavascriptInterface.1 */
    class C09351 implements Runnable {
        final /* synthetic */ String val$iconUrl;
        final /* synthetic */ String val$imageUrl;
        final /* synthetic */ Handler val$jsThreadHandler;
        final /* synthetic */ String val$launchMain;
        final /* synthetic */ String val$text;
        final /* synthetic */ String val$title;
        final /* synthetic */ String val$url;

        /* renamed from: com.wTouch2KiLL.notification.NotificationJavascriptInterface.1.1 */
        class C09341 implements Runnable {
            final /* synthetic */ String val$absoluteIconUrl;
            final /* synthetic */ String val$absoluteImageUrl;
            final /* synthetic */ String val$absoluteUrl;

            C09341(String str, String str2, String str3) {
                this.val$absoluteUrl = str;
                this.val$absoluteIconUrl = str2;
                this.val$absoluteImageUrl = str3;
            }

            public void run() {
                AppNotificationManager.generateNotification(NotificationJavascriptInterface.this._context, C09351.this.val$text, C09351.this.val$title, AppNotificationManager.getLaunchIntent(NotificationJavascriptInterface.this._context, C09351.this.val$title, this.val$absoluteUrl, C09351.this.val$launchMain), this.val$absoluteIconUrl, this.val$absoluteImageUrl);
            }
        }

        C09351(String str, String str2, String str3, Handler handler, String str4, String str5, String str6) {
            this.val$url = str;
            this.val$iconUrl = str2;
            this.val$imageUrl = str3;
            this.val$jsThreadHandler = handler;
            this.val$title = str4;
            this.val$launchMain = str5;
            this.val$text = str6;
        }

        public void run() {
            UrlConverter converter = new UrlConverter(NotificationJavascriptInterface.this._service.getWebView());
            this.val$jsThreadHandler.post(new C09341(NotificationJavascriptInterface.this._toAbsoluteUrlPreserveEmpty(this.val$url, converter), NotificationJavascriptInterface.this._toAbsoluteUrlPreserveEmpty(this.val$iconUrl, converter), NotificationJavascriptInterface.this._toAbsoluteUrlPreserveEmpty(this.val$imageUrl, converter)));
        }
    }

    public NotificationJavascriptInterface(Context context, NotificationService service) {
        super(context, service.getWebView(), service.getWebViewThreadHandler());
        this._context = context;
        this._service = service;
    }

    private String _toAbsoluteUrlPreserveEmpty(String url, UrlConverter converter) {
        if (url == null || url.length() == 0) {
            return XMLConstants.NULL_NS_URI;
        }
        return converter.toAbsolute(url);
    }

    @JavascriptInterface
    public void showNotification(String title, String text, String url, String launchMain, String iconUrl, String imageUrl) {
        Handler jsThreadHandler = new Handler();
        this.settings = PreferenceManager.getDefaultSharedPreferences(Factory.getInstance().getMainNavigationActivity().getBaseContext());
        if (this.settings.getBoolean("enable_notification", true) && checkValidateTimeForNotification()) {
            this._service.getWebViewThreadHandler().post(new C09351(url, iconUrl, imageUrl, jsThreadHandler, title, launchMain, text));
        }
    }

    private boolean checkValidateTimeForNotification() {
        String[] fromTime = this.settings.getString(SettingsActivity.TIME_FROM, "07:00").split(":", 2);
        String[] toTime = this.settings.getString(SettingsActivity.TIME_TO, "22:00").split(":", 2);
        int hour = new GregorianCalendar(this._context.getResources().getConfiguration().locale).get(11);
        int minute = new GregorianCalendar().get(12);
        try {
            if (hour > Integer.parseInt(fromTime[0]) || (hour == Integer.parseInt(fromTime[0]) && minute >= Integer.parseInt(fromTime[1]))) {
                if (hour < Integer.parseInt(toTime[0])) {
                    return true;
                }
                if (hour == Integer.parseInt(toTime[0]) && minute < Integer.parseInt(toTime[1])) {
                    return true;
                }
            }
        } catch (NumberFormatException p) {
            Log.e("checkValidateTime", XMLConstants.NULL_NS_URI + p);
        }
        return false;
    }

    @JavascriptInterface
    public void keepAlive() {
        this._service.keepAlive();
    }

    @JavascriptInterface
    public void close() {
        this._service.removeWebViewAndStop();
    }

    @JavascriptInterface
    public boolean isAppRunning() {
        return MainNavigationActivity.isActive();
    }
}
