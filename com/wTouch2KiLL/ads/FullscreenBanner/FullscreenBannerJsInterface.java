package com.wTouch2KiLL.ads.FullscreenBanner;

import android.webkit.JavascriptInterface;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.ads.sdk.JavascriptSdkController;
import com.wTouch2KiLL.server.StatController;
import com.wTouch2KiLL.utils.WebViewScreenShooter;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.nexage.sourcekit.vast.VASTPlayer;
import org.nexage.sourcekit.vast.VASTPlayer.VASTPlayerListener;

public class FullscreenBannerJsInterface extends JavascriptSdkController {
    public static String JS_INTERFACE_NAME = null;
    private static final int LOADING_SCREEN_DEFAULT_TIMEOUT = 5000;
    private VASTPlayer _vastPlayer;

    /* renamed from: com.wTouch2KiLL.ads.FullscreenBanner.FullscreenBannerJsInterface.1 */
    class C14661 implements VASTPlayerListener {
        C14661() {
        }

        public void vastReady() {
            FullscreenBannerJsInterface.this._vastPlayer.play();
        }

        public void vastError(int error) {
        }

        public void vastDismiss() {
        }

        public void vastComplete() {
        }

        public void vastClick() {
        }
    }

    static {
        JS_INTERFACE_NAME = "AppsgeyserBanner";
    }

    public FullscreenBannerJsInterface(FullScreenBannerController controller) {
        this._startupController = controller;
    }

    @JavascriptInterface
    public void stayAlive() {
        this._startupController.stayAlive();
    }

    @JavascriptInterface
    public void showAdMobFullScreenBanner(String adUnitID, String keywords, String genderString, String birthday, String latitude, String longtitude) {
        this._startupController.showAdMobFSBanner(adUnitID, keywords, genderString, birthday, latitude, longtitude);
    }

    @JavascriptInterface
    public void close() {
        this._startupController.closeBanner();
    }

    @JavascriptInterface
    public void setClickUrl(String clickUrl, String hashCode) {
        if (_checkSecurityCode(hashCode)) {
            this._startupController.setClickUrl(clickUrl);
        }
    }

    @JavascriptInterface
    public String takeScreenShot() {
        return WebViewScreenShooter.takeScreenShotInBase64(this._startupController.getFullscreenBannerWebView());
    }

    @JavascriptInterface
    public void showVideoAd(String hash, String vastXml) {
        if (_checkSecurityCode(hash)) {
            this._vastPlayer = new VASTPlayer(Factory.getInstance().getMainNavigationActivity(), new C14661());
            this._vastPlayer.loadVideoWithData(vastXml);
        }
    }

    @JavascriptInterface
    public void setStatUrls(String jsonParameters) {
        try {
            JSONObject json = new JSONObject(jsonParameters);
            HashMap<String, String> result = new HashMap();
            Iterator<?> iterator = json.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                result.put(key, json.get(key).toString());
            }
            StatController.getInstance().init(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void forceOpenInNativeBrowser(boolean openInNativeBrowser) {
        this._startupController.forceOpenInNativeBrowser(openInNativeBrowser);
    }

    @JavascriptInterface
    public void setBackKeyLocked(boolean locked) {
        this._startupController.setBackKeyLocked(locked);
    }

    @JavascriptInterface
    public void trackCrossClick() {
        StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_CROSS_BANNER);
    }

    @JavascriptInterface
    public void trackBannerClick() {
        StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_HTML_TAP_START);
    }

    @JavascriptInterface
    public void trackTimerClick() {
        StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_TIMER_BANNER);
    }

    @JavascriptInterface
    public void showTimer(int seconds) {
        this._startupController.setShowTimer((long) (seconds * 1000));
    }
}
