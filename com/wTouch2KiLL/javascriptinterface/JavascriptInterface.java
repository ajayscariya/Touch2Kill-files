package com.wTouch2KiLL.javascriptinterface;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.Base64;
import android.widget.Toast;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyV4VCAd;
import com.jirbo.adcolony.AdColonyV4VCListener;
import com.jirbo.adcolony.AdColonyV4VCReward;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.ads.BottomBannerLayout;
import com.wTouch2KiLL.ads.sdk.JavascriptSdkController;
import com.wTouch2KiLL.controllers.WebContentController;
import com.wTouch2KiLL.inline.StringEscapeUtils;
import com.wTouch2KiLL.model.WidgetEntity;
import com.wTouch2KiLL.notification.NotificationChecker;
import com.wTouch2KiLL.server.AppsGeyserServerClient;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;
import com.wTouch2KiLL.storage.BrowsingHistoryItem;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import com.wTouch2KiLL.ui.navigationwidget.NavigationWidgetCustomIcon;
import com.wTouch2KiLL.utils.FileManager;
import com.wTouch2KiLL.utils.ImageReader;
import com.wTouch2KiLL.utils.UrlConverter;
import com.wTouch2KiLL.utils.WebViewScreenShooter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.apache.xml.serialize.LineSeparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JavascriptInterface extends JavascriptSdkController {
    public static final String JS_INTERFACE_NAME = "AppsgeyserJSInterface";
    public static final String JS_PREFERENCE_NAME = "JS-PREFERENCE";
    public static final String JS_PREFERENCE_PREFIX = "JS-Preference-";
    private ProgressDialog _currentProgressDialog;
    private MainNavigationActivity _mainActivity;
    private WebContentController _webController;
    private int mFinalHeight;
    private int mFinalWidth;

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass11(String str) {
            this.val$url = str;
        }

        public void run() {
            Factory.getInstance().getTabsController().getSelectedTab().getWebView().loadUrl(this.val$url);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ MainNavigationActivity val$activity;

        AnonymousClass12(MainNavigationActivity mainNavigationActivity) {
            this.val$activity = mainNavigationActivity;
        }

        public void run() {
            this.val$activity.showFullscreenBannerView();
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ int val$intervalMillis;
        final /* synthetic */ String val$url;

        AnonymousClass14(String str, int i) {
            this.val$url = str;
            this.val$intervalMillis = i;
        }

        public void run() {
            new NotificationChecker().addChecker(new UrlConverter(JavascriptInterface.this._webController.getWebView()).toAbsolute(this.val$url), this.val$intervalMillis, JavascriptInterface.this._mainActivity);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.15 */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass15(String str) {
            this.val$url = str;
        }

        public void run() {
            new NotificationChecker().removeChecker(new UrlConverter(JavascriptInterface.this._webController.getWebView()).toAbsolute(this.val$url), JavascriptInterface.this._mainActivity);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ String val$resultCallback;

        AnonymousClass16(String str) {
            this.val$resultCallback = str;
        }

        public void run() {
            ArrayList<BrowsingHistoryItem> history = JavascriptInterface.this._mainActivity.getWeeklyHistory();
            JSONObject jResult = new JSONObject();
            JSONArray jArray = new JSONArray();
            try {
                Iterator i$ = history.iterator();
                while (i$.hasNext()) {
                    BrowsingHistoryItem browsingHistoryItem = (BrowsingHistoryItem) i$.next();
                    JSONObject jGroup = new JSONObject();
                    jGroup.put("_id", browsingHistoryItem.getId());
                    jGroup.put(SchemaSymbols.ATTVAL_DATE, browsingHistoryItem.getDate());
                    jGroup.put(DatabaseOpenHelper.HISTORY_ROW_TITLE, browsingHistoryItem.getTitle());
                    jGroup.put(DatabaseOpenHelper.HISTORY_ROW_URL, browsingHistoryItem.getUrl());
                    jArray.put(jGroup);
                }
            } catch (Exception e) {
                jArray = new JSONArray();
            }
            try {
                jResult.put(DatabaseOpenHelper.HISTORY_TABLE_NAME, jArray);
            } catch (JSONException e2) {
            }
            JavascriptInterface.this._webController.getWebView().loadUrl("javascript:" + this.val$resultCallback + "('" + jResult.toString() + "')");
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ long val$id;

        AnonymousClass17(long j) {
            this.val$id = j;
        }

        public void run() {
            JavascriptInterface.this._mainActivity.removeHistoryItem(this.val$id);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.19 */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ HashMap val$mapParameters;
        final /* synthetic */ String val$resultCallback;

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.19.1 */
        class C14741 implements AdColonyAdAvailabilityListener {
            C14741() {
            }

            public void onAdColonyAdAvailabilityChange(boolean available, String zoneId) {
                HashMap<String, String> result = new HashMap();
                result.put("action", "adAvailabilityChange");
                result.put("zoneId", zoneId);
                result.put("available", String.valueOf(available));
                JavascriptInterface.this.XmlHttpRequestDone(JavascriptInterface.this.buildJsonResponse(result), AnonymousClass19.this.val$resultCallback);
            }
        }

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.19.2 */
        class C14752 implements AdColonyV4VCListener {
            C14752() {
            }

            public void onAdColonyV4VCReward(AdColonyV4VCReward reward) {
                HashMap<String, String> result = new HashMap();
                result.put("action", "reward");
                result.put("success", String.valueOf(reward.success()));
                if (reward.success()) {
                    result.put("name", reward.name());
                    result.put(AppLovinEventParameters.REVENUE_AMOUNT, String.valueOf(reward.amount()));
                }
                JavascriptInterface.this.XmlHttpRequestDone(JavascriptInterface.this.buildJsonResponse(result), AnonymousClass19.this.val$resultCallback);
            }
        }

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.19.3 */
        class C14763 implements AdColonyAdListener {
            C14763() {
            }

            public void onAdColonyAdStarted(AdColonyAd ad) {
                HashMap<String, String> result = new HashMap();
                result.put("action", "start");
                result.put("shown", String.valueOf(ad.shown()));
                result.put("notShown", String.valueOf(ad.notShown()));
                result.put("canceled", String.valueOf(ad.canceled()));
                result.put("noFill", String.valueOf(ad.noFill()));
                result.put("skipped", String.valueOf(ad.skipped()));
                JavascriptInterface.this.XmlHttpRequestDone(JavascriptInterface.this.buildJsonResponse(result), AnonymousClass19.this.val$resultCallback);
            }

            public void onAdColonyAdAttemptFinished(AdColonyAd ad) {
                HashMap<String, String> result = new HashMap();
                result.put("action", "finish");
                result.put("shown", String.valueOf(ad.shown()));
                result.put("notShown", String.valueOf(ad.notShown()));
                result.put("canceled", String.valueOf(ad.canceled()));
                result.put("noFill", String.valueOf(ad.noFill()));
                result.put("skipped", String.valueOf(ad.skipped()));
                JavascriptInterface.this.XmlHttpRequestDone(JavascriptInterface.this.buildJsonResponse(result), AnonymousClass19.this.val$resultCallback);
            }
        }

        AnonymousClass19(HashMap hashMap, String str) {
            this.val$mapParameters = hashMap;
            this.val$resultCallback = str;
        }

        public void run() {
            AdColony.configure(JavascriptInterface.this._mainActivity, (String) this.val$mapParameters.get("client_options"), (String) this.val$mapParameters.get("app_id"), (String) this.val$mapParameters.get("zone_id"));
            AdColony.addAdAvailabilityListener(new C14741());
            AdColony.addV4VCListener(new C14752());
            new AdColonyV4VCAd().withConfirmationDialog(true).withResultsDialog(true).withListener(new C14763()).show();
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.1 */
    class C09201 implements Runnable {
        final /* synthetic */ String val$resultCallback;
        final /* synthetic */ String val$url;

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.1.1 */
        class C09181 extends Thread {
            final /* synthetic */ String val$absoluteUrl;

            C09181(String str) {
                this.val$absoluteUrl = str;
            }

            public void run() {
                String strRes = XMLConstants.NULL_NS_URI;
                try {
                    strRes = FileManager.getStringFromAssetsFileWithFileName(this.val$absoluteUrl.replace("file:///android_asset/", XMLConstants.NULL_NS_URI).replaceFirst("#.*", XMLConstants.NULL_NS_URI), JavascriptInterface.this._mainActivity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JavascriptInterface.this.XmlHttpRequestDone(strRes, C09201.this.val$resultCallback);
            }
        }

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.1.2 */
        class C14732 implements OnRequestDoneListener {
            C14732() {
            }

            public void onRequestDone(String requestUrl, int tag, String response) {
                String stringResponse;
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(response.getBytes())));
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuilder.append(line);
                        stringBuilder.append('\n');
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    stringResponse = stringBuilder.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    stringResponse = XMLConstants.NULL_NS_URI;
                }
                JavascriptInterface.this.XmlHttpRequestDone(stringResponse, C09201.this.val$resultCallback);
            }
        }

        C09201(String str, String str2) {
            this.val$url = str;
            this.val$resultCallback = str2;
        }

        public void run() {
            String absoluteUrl = new UrlConverter(JavascriptInterface.this._webController.getWebView()).toAbsolute(this.val$url);
            if (absoluteUrl.startsWith("file:///")) {
                new C09181(absoluteUrl).start();
            } else {
                AppsGeyserServerClient.getInstance(JavascriptInterface.this._mainActivity).sendRequestAsync(absoluteUrl, Integer.valueOf(0), new C14732());
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.2 */
    class C09212 implements Runnable {
        final /* synthetic */ String val$callback;

        C09212(String str) {
            this.val$callback = str;
        }

        public void run() {
            JavascriptInterface.this._webController.getWebView().loadUrl(this.val$callback);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.3 */
    class C09223 implements Runnable {
        final /* synthetic */ String val$buttonBadge;
        final /* synthetic */ String val$buttonName;
        final /* synthetic */ HashMap val$icons;

        C09223(HashMap hashMap, String str, String str2) {
            this.val$icons = hashMap;
            this.val$buttonName = str;
            this.val$buttonBadge = str2;
        }

        public void run() {
            ((NavigationWidgetCustomIcon) this.val$icons.get(this.val$buttonName)).updateBadge(this.val$buttonBadge);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.4 */
    class C09234 implements Runnable {
        final /* synthetic */ String val$buttonName;
        final /* synthetic */ String val$iconPath;
        final /* synthetic */ HashMap val$icons;

        C09234(HashMap hashMap, String str, String str2) {
            this.val$icons = hashMap;
            this.val$buttonName = str;
            this.val$iconPath = str2;
        }

        public void run() {
            ((NavigationWidgetCustomIcon) this.val$icons.get(this.val$buttonName)).updateIcon(this.val$iconPath);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.5 */
    class C09245 implements Runnable {
        C09245() {
        }

        public void run() {
            JavascriptInterface.this._webController.setScaleForPageWithSize(JavascriptInterface.this.mFinalHeight, JavascriptInterface.this.mFinalWidth);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.6 */
    class C09256 implements Runnable {
        C09256() {
        }

        public void run() {
            JavascriptInterface.this._webController.zoomIn();
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.7 */
    class C09267 implements Runnable {
        final /* synthetic */ String val$text;

        C09267(String str) {
            this.val$text = str;
        }

        public void run() {
            JavascriptInterface.this._currentProgressDialog = ProgressDialog.show(JavascriptInterface.this._mainActivity, XMLConstants.NULL_NS_URI, this.val$text, true);
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.8 */
    class C09278 implements Runnable {
        C09278() {
        }

        public void run() {
            if (JavascriptInterface.this._currentProgressDialog != null) {
                JavascriptInterface.this._currentProgressDialog.hide();
                JavascriptInterface.this._currentProgressDialog = null;
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.9 */
    class C09289 implements Runnable {
        C09289() {
        }

        public void run() {
            JavascriptInterface.this._mainActivity.findViewById(C0866R.id.frame).setVisibility(8);
            BottomBannerLayout bannerLayout = JavascriptInterface.this._mainActivity.getBannerLayout();
            if (bannerLayout != null) {
                bannerLayout.setDefaultTagsPanelVisibility(8);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.13 */
    class AnonymousClass13 implements OnRequestDoneListener {
        final /* synthetic */ String val$resultCallback;

        /* renamed from: com.wTouch2KiLL.javascriptinterface.JavascriptInterface.13.1 */
        class C09191 implements Runnable {
            final /* synthetic */ String val$result;

            C09191(String str) {
                this.val$result = str;
            }

            public void run() {
                JavascriptInterface.this._webController.getWebView().loadUrl("javascript:" + AnonymousClass13.this.val$resultCallback + "('" + this.val$result + "');");
            }
        }

        AnonymousClass13(String str) {
            this.val$resultCallback = str;
        }

        public void onRequestDone(String requestUrl, int tag, String response) {
            String stringResponse;
            try {
                InputStream is = new ByteArrayInputStream(response.getBytes());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while (true) {
                    int c = is.read();
                    if (c == -1) {
                        break;
                    }
                    out.write(c);
                }
                out.flush();
                byte[] imageRaw = out.toByteArray();
                is.close();
                out.close();
                stringResponse = "data:image/png;base64," + Base64.encodeToString(imageRaw, 0);
            } catch (IOException e) {
                e.printStackTrace();
                stringResponse = XMLConstants.NULL_NS_URI;
            }
            JavascriptInterface.this._mainActivity.runOnUiThread(new C09191(stringResponse.replace(LineSeparator.Web, XMLConstants.NULL_NS_URI).replace("\\", "\\\\").replace("'", "\\'")));
        }
    }

    public JavascriptInterface(WebContentController webController) {
        if (webController != null) {
            this._mainActivity = webController.getMainNavigationActivity();
            this._webController = webController;
        }
    }

    @android.webkit.JavascriptInterface
    public void sendXMLHTTPRequest(String url, String resultCallback) {
        this._mainActivity.runOnUiThread(new C09201(url, resultCallback));
    }

    private void XmlHttpRequestDone(String response, String callbackName) {
        this._mainActivity.runOnUiThread(new C09212("javascript:window." + callbackName + "('" + StringEscapeUtils.escapeJavaScript(response) + "');"));
    }

    @android.webkit.JavascriptInterface
    public String getAppId() {
        return Integer.toString(this._mainActivity.getConfig().getApplicationId());
    }

    @android.webkit.JavascriptInterface
    public String getInstallationGuid() {
        return this._mainActivity.getConfig().getAppGuid();
    }

    @android.webkit.JavascriptInterface
    public void updateIconBadge(String buttonName, String buttonBadge) {
        HashMap<String, NavigationWidgetCustomIcon> icons = Factory.getInstance().getNavigationWidget().getCustomIcons();
        if (icons.containsKey(buttonName)) {
            this._mainActivity.runOnUiThread(new C09223(icons, buttonName, buttonBadge));
        }
    }

    @android.webkit.JavascriptInterface
    public void updateIcon(String buttonName, String iconPath) {
        HashMap<String, NavigationWidgetCustomIcon> icons = Factory.getInstance().getNavigationWidget().getCustomIcons();
        if (icons.containsKey(buttonName)) {
            this._mainActivity.runOnUiThread(new C09234(icons, buttonName, iconPath));
        }
    }

    @android.webkit.JavascriptInterface
    public void showInfo(String message) {
        if (this._mainActivity != null) {
            Toast.makeText(this._mainActivity, message, 0).show();
        }
    }

    @android.webkit.JavascriptInterface
    public void setScaleForPageWithSize(int iHeight, int iWidth) {
        this.mFinalHeight = iHeight;
        this.mFinalWidth = iWidth;
        if (this._mainActivity != null) {
            this._mainActivity.runOnUiThread(new C09245());
        }
    }

    @android.webkit.JavascriptInterface
    public void downloadFile(String url) {
        FileManager.downloadFile(new UrlConverter(this._webController.getWebView()).toAbsolute(url), XMLConstants.NULL_NS_URI, this._mainActivity);
    }

    @android.webkit.JavascriptInterface
    public String saveImageFromBase64(String base64, String prefix) {
        if (prefix == null) {
            prefix = "IMG";
        }
        Bitmap image = ImageReader.createBitmapFromBase64(base64);
        if (image != null) {
            File imageFile = FileManager.saveBitmapToGallery(prefix, image);
            if (imageFile != null) {
                showInfo("Image saved to gallery...");
                return imageFile.toString();
            }
        }
        return null;
    }

    @android.webkit.JavascriptInterface
    public void setWallpaper(String url) {
        InputStream wallpaperStream = new UrlConverter(this._webController.getWebView()).toStream(url);
        if (wallpaperStream != null) {
            Bitmap wallpaperBitmap = BitmapFactory.decodeStream(wallpaperStream);
            try {
                _scaleBitmapAndSetWallpaper(wallpaperBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wallpaperBitmap.recycle();
        }
    }

    @android.webkit.JavascriptInterface
    private void _scaleBitmapAndSetWallpaper(Bitmap wallpaperBitmap) throws IOException {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this._mainActivity);
        new Options().inScaled = false;
        wallpaperManager.setBitmap(wallpaperBitmap);
    }

    @android.webkit.JavascriptInterface
    public void zoomIn() {
        if (this._mainActivity != null) {
            this._mainActivity.runOnUiThread(new C09256());
        }
    }

    @android.webkit.JavascriptInterface
    public String getFileContents(String fileName) {
        String strRes = XMLConstants.NULL_NS_URI;
        return FileManager.getStringFromAssetsFileWithFileName(fileName, this._mainActivity);
    }

    @android.webkit.JavascriptInterface
    public void showLoadingDialog(String text) {
        this._mainActivity.runOnUiThread(new C09267(text));
    }

    @android.webkit.JavascriptInterface
    public void hideLoadingDialog() {
        this._mainActivity.runOnUiThread(new C09278());
    }

    @android.webkit.JavascriptInterface
    public String getTabUrl(String tabId) {
        WidgetEntity widget = Factory.getInstance().getWidgetsController().getWidgetByTabId(tabId);
        if (widget != null) {
            return widget.getLink();
        }
        return XMLConstants.NULL_NS_URI;
    }

    @android.webkit.JavascriptInterface
    public void hideTabs() {
        this._mainActivity.runOnUiThread(new C09289());
    }

    @android.webkit.JavascriptInterface
    public void showTabs() {
        this._mainActivity.runOnUiThread(new Runnable() {
            public void run() {
                JavascriptInterface.this._mainActivity.findViewById(C0866R.id.frame).setVisibility(0);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void setMenuItemVisible(String nameItem, boolean visibility) {
        if (nameItem != null && !nameItem.equals("undefined") && !nameItem.isEmpty()) {
            this._mainActivity.setMenuItemVisible(nameItem.hashCode(), visibility);
        }
    }

    @android.webkit.JavascriptInterface
    public String getItem(String key) {
        return this._mainActivity.getSharedPreferences(JS_PREFERENCE_NAME, 0).getString(JS_PREFERENCE_PREFIX + key, null);
    }

    @android.webkit.JavascriptInterface
    public void setItem(String key, String value) {
        this._mainActivity.getSharedPreferences(JS_PREFERENCE_NAME, 0).edit().putString(JS_PREFERENCE_PREFIX + key, value).commit();
    }

    @android.webkit.JavascriptInterface
    public void addToHomePage(String name, String url) {
        Factory.getInstance().getHomePageManager().addBookmark(name, url);
    }

    @android.webkit.JavascriptInterface
    public void addBookmark(String name, String url, String pageName) {
        Factory.getInstance().getBookmarkManager(pageName).addBookmark(name, url);
    }

    @android.webkit.JavascriptInterface
    public void removeFromHomepage(String index) {
        Factory.getInstance().getHomePageManager().removeBookmark(Integer.valueOf(Integer.parseInt(index)));
    }

    @android.webkit.JavascriptInterface
    public void removeBookmark(String index, String pageName) {
        Factory.getInstance().getBookmarkManager(pageName).removeBookmark(Integer.valueOf(Integer.parseInt(index)));
    }

    private String getBookmarksFromCursor(Cursor c) {
        JSONArray bookmarksArray = new JSONArray();
        if (c != null) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                JSONObject bookmark = new JSONObject();
                int i = 0;
                while (i < c.getColumnCount()) {
                    try {
                        Long longRes = Long.valueOf(c.getLong(i));
                        String sRes = c.getString(i);
                        if (sRes == null || sRes.length() == 0) {
                            bookmark.put(c.getColumnName(i), longRes);
                            i++;
                        } else {
                            bookmark.put(c.getColumnName(i), sRes);
                            i++;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bookmarksArray.put(bookmark);
                c.moveToNext();
            }
        }
        return bookmarksArray.toString();
    }

    @android.webkit.JavascriptInterface
    public String getHomePageItems() {
        return getBookmarksFromCursor(Factory.getInstance().getHomePageManager().getBookmarks());
    }

    @android.webkit.JavascriptInterface
    public String getBookmarks(String pageName) {
        return getBookmarksFromCursor(Factory.getInstance().getBookmarkManager(pageName).getBookmarks());
    }

    @android.webkit.JavascriptInterface
    public String getHomePageItems(String offset, String limit) {
        return getBookmarksFromCursor(Factory.getInstance().getHomePageManager().getBookmarks(Integer.valueOf(Integer.parseInt(offset)), Integer.valueOf(Integer.parseInt(limit))));
    }

    @android.webkit.JavascriptInterface
    public String getBookmarks(String offset, String limit, String pageName) {
        return getBookmarksFromCursor(Factory.getInstance().getBookmarkManager(pageName).getBookmarks(Integer.valueOf(Integer.parseInt(offset)), Integer.valueOf(Integer.parseInt(limit))));
    }

    @android.webkit.JavascriptInterface
    public String getAppName() {
        try {
            return Factory.getInstance().getMainNavigationActivity().getConfig().getWidgetName();
        } catch (Exception e) {
            return null;
        }
    }

    @android.webkit.JavascriptInterface
    public String getAppPackageName() {
        try {
            return this._mainActivity.getApplicationContext().getPackageName();
        } catch (Exception e) {
            return null;
        }
    }

    @android.webkit.JavascriptInterface
    public void redirect(String url) {
        try {
            if (this._mainActivity != null) {
                this._mainActivity.runOnUiThread(new AnonymousClass11(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @android.webkit.JavascriptInterface
    public void showPopup(String url) {
        MainNavigationActivity activity = Factory.getInstance().getMainNavigationActivity();
        activity.runOnUiThread(new AnonymousClass12(activity));
        activity.getFullScreenBannerController().showUrlInPopup(url);
    }

    @android.webkit.JavascriptInterface
    public void shareText(String subject, String body) {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.TEXT", body);
        sharingIntent.putExtra("android.intent.extra.SUBJECT", subject);
        Factory.getInstance().getMainNavigationActivity().startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    @android.webkit.JavascriptInterface
    public String takeScreenShot() {
        return WebViewScreenShooter.takeScreenShotInBase64(Factory.getInstance().getTabsController().getSelectedTab().getWebView());
    }

    @android.webkit.JavascriptInterface
    public void getBase64FromImageUrl(String url, String resultCallback) {
        AppsGeyserServerClient.getInstance(this._mainActivity).sendRequestAsync(url, Integer.valueOf(0), new AnonymousClass13(resultCallback));
    }

    @android.webkit.JavascriptInterface
    public void sharePicture(String fileName, String text) {
        Intent sendIntent = new Intent();
        sendIntent.setAction("android.intent.action.SEND");
        sendIntent.setType("image/png");
        File file = new File(fileName);
        if (file.exists()) {
            sendIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            this._mainActivity.startActivity(Intent.createChooser(sendIntent, text));
            return;
        }
        showInfo("Error! Can't find " + fileName + "!");
    }

    @android.webkit.JavascriptInterface
    public void registerUpdateChecker(String url, int intervalMillis) {
        this._mainActivity.runOnUiThread(new AnonymousClass14(url, intervalMillis));
    }

    @android.webkit.JavascriptInterface
    public void removeUpdateChecker(String url) {
        this._mainActivity.runOnUiThread(new AnonymousClass15(url));
    }

    @android.webkit.JavascriptInterface
    public void clearUpdateCheckers() {
        new NotificationChecker().clearCheckers(this._mainActivity);
    }

    @android.webkit.JavascriptInterface
    public void setUrlBarVisibility(boolean isVisible) {
        this._mainActivity.setUrlBarVisibility(isVisible ? 0 : 8);
    }

    @android.webkit.JavascriptInterface
    public boolean playYouTubeVideo(String videoId, String apiKey, int startMillis, boolean autoPlay, boolean lightBox) {
        try {
            this._mainActivity.startActivity(YouTubeStandalonePlayer.createVideoIntent(this._mainActivity, apiKey, videoId, startMillis, autoPlay, lightBox));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @android.webkit.JavascriptInterface
    public void overrideRefreshAction(String js) {
        this._webController.setPageRefreshJsCode(js);
    }

    @android.webkit.JavascriptInterface
    public void getWeeklyHistory(String resultCallback) {
        this._mainActivity.runOnUiThread(new AnonymousClass16(resultCallback));
    }

    @android.webkit.JavascriptInterface
    public void removeHistoryItem(long id) {
        this._mainActivity.runOnUiThread(new AnonymousClass17(id));
    }

    @android.webkit.JavascriptInterface
    public void removeHistoryAllItem() {
        this._mainActivity.runOnUiThread(new Runnable() {
            public void run() {
                JavascriptInterface.this._mainActivity.removeHistoryAllItem();
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void showAdColonyVideoAd(String parameters, String resultCallback) {
        this._mainActivity.runOnUiThread(new AnonymousClass19(jsonStringToMap(parameters), resultCallback));
    }

    private String buildJsonResponse(Map<String, String> map) {
        JSONObject json = new JSONObject();
        for (Entry<String, String> item : map.entrySet()) {
            try {
                json.putOpt((String) item.getKey(), (String) item.getValue());
            } catch (JSONException e) {
                System.err.println("Error building json!");
            }
        }
        return json.toString();
    }

    private HashMap<String, String> jsonStringToMap(String json) {
        HashMap<String, String> map = new HashMap();
        try {
            JSONObject jObject = new JSONObject(json);
            Iterator<?> keys = jObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                map.put(key, jObject.getString(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return map;
    }
}
