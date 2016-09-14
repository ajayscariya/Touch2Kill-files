package com.wTouch2KiLL.javascriptinterface;

import android.webkit.JavascriptInterface;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.ads.AdMobUtils.AdMobParameters;
import com.wTouch2KiLL.ads.AdsLoader;
import com.wTouch2KiLL.ads.BottomBannerLayout;
import com.wTouch2KiLL.controllers.TabsController;
import com.wTouch2KiLL.deviceidparser.DeviceIdParser;
import com.wTouch2KiLL.utils.WebViewScreenShooter;
import mf.javax.xml.XMLConstants;

public class BannerJavascriptInterface extends BaseSecureJsInterface {
    public static String JS_INTERFACE_NAME;
    private AdsLoader _adsLoader;
    private String _androidId;
    private BottomBannerLayout _layout;

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.1 */
    class C09101 implements Runnable {
        C09101() {
        }

        public void run() {
            BannerJavascriptInterface.this._androidId = DeviceIdParser.getInstance().getAndroidId(Factory.getInstance().getMainNavigationActivity());
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.2 */
    class C09112 implements Runnable {
        C09112() {
        }

        public void run() {
            BannerJavascriptInterface.this._layout.hideBanner();
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.3 */
    class C09123 implements Runnable {
        final /* synthetic */ String val$birthday;
        final /* synthetic */ String val$genderString;
        final /* synthetic */ String val$keywords;
        final /* synthetic */ String val$latitude;
        final /* synthetic */ String val$longtitude;
        final /* synthetic */ String val$publisherId;

        C09123(String str, String str2, String str3, String str4, String str5, String str6) {
            this.val$publisherId = str;
            this.val$keywords = str2;
            this.val$genderString = str3;
            this.val$birthday = str4;
            this.val$latitude = str5;
            this.val$longtitude = str6;
        }

        public void run() {
            BannerJavascriptInterface.this._layout.switchToAdMobAd(new AdMobParameters(this.val$publisherId, this.val$keywords, this.val$genderString, this.val$birthday, this.val$latitude, this.val$longtitude));
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.4 */
    class C09134 implements Runnable {
        final /* synthetic */ String val$hash;
        final /* synthetic */ String val$jsCode;

        C09134(String str, String str2) {
            this.val$hash = str;
            this.val$jsCode = str2;
        }

        public void run() {
            if (BannerJavascriptInterface.this._checkSecurityCode(this.val$hash)) {
                TabsController controller = (TabsController) Factory.getInstance().getTabsController();
                if (controller != null) {
                    controller.setBannerInjectionJs(this.val$jsCode);
                }
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.5 */
    class C09145 implements Runnable {
        final /* synthetic */ String val$hash;
        final /* synthetic */ String val$url;

        C09145(String str, String str2) {
            this.val$hash = str;
            this.val$url = str2;
        }

        public void run() {
            if (BannerJavascriptInterface.this._checkSecurityCode(this.val$hash)) {
                BannerJavascriptInterface.this._adsLoader.setClickUrl(this.val$url);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BannerJavascriptInterface.6 */
    class C09156 implements Runnable {
        final /* synthetic */ String val$hash;

        C09156(String str) {
            this.val$hash = str;
        }

        public void run() {
            if (BannerJavascriptInterface.this._checkSecurityCode(this.val$hash)) {
                BannerJavascriptInterface.this._adsLoader.reload();
            }
        }
    }

    static {
        JS_INTERFACE_NAME = "AppsgeyserBanner";
    }

    public BannerJavascriptInterface(BottomBannerLayout layout, AdsLoader loader) {
        this._layout = layout;
        this._adsLoader = loader;
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09101());
    }

    @JavascriptInterface
    public void close() {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09112());
    }

    @JavascriptInterface
    public void showAdMobAd(String publisherId, String keywords, String genderString, String birthday, String latitude, String longtitude) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09123(publisherId, keywords, genderString, birthday, latitude, longtitude));
    }

    @JavascriptInterface
    public void addJs(String jsCode, String hash) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09134(hash, jsCode));
    }

    @JavascriptInterface
    public void setClickUrl(String url, String hash) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09145(hash, url));
    }

    @JavascriptInterface
    public String getAndroidId(String hash) {
        if (_checkSecurityCode(hash)) {
            return this._androidId;
        }
        return XMLConstants.NULL_NS_URI;
    }

    @JavascriptInterface
    public void reload(String hash) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09156(hash));
    }

    @JavascriptInterface
    public String takeScreenShot() {
        return WebViewScreenShooter.takeScreenShotInBase64(this._layout.getBannerWebView());
    }

    @JavascriptInterface
    public void forceOpenInNativeBrowser(boolean openInNativeBrowser) {
        this._adsLoader.forceOpenInNativeBrowser(openInNativeBrowser);
    }
}
