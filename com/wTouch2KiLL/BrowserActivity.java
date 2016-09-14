package com.wTouch2KiLL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import com.wTouch2KiLL.server.StatController;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.HashMap;
import mf.org.w3c.dom.traversal.NodeFilter;

public class BrowserActivity extends Activity {
    public static final String BANNER_TYPE_FULLSCREEN = "banner_type_fullscreen";
    public static final String BANNER_TYPE_SMALL = "banner_type_small";
    private static final int HTML_SUBSTRING_LENGTH = 1000;
    public static final String KEY_BANNER_TYPE = "banner_type";
    public static final String KEY_BROWSER_URL = "browser_url";
    public static final String KEY_TIMER_DURATION = "timer_duration";
    private static final int MIN_HTML_ALLOWED_LENGTH = 40;
    private static final int REDIRECT_FINISH_TIMEOUT = 1000;
    private Handler _handler;
    private boolean _isFullScreenBanner;
    private long _timerDuration;
    private long _timerStep;
    boolean _toShowTimer;
    ImageButton mBackButton;
    ImageButton mCloseButton;
    ImageButton mForwardButton;
    private Runnable mHtmlCheckRunnable;
    ImageButton mRefreshButton;
    TextView mTimer;
    WebView mWebView;

    /* renamed from: com.wTouch2KiLL.BrowserActivity.1 */
    class C08371 extends WebViewClient {
        C08371() {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            _handleRedirect(url);
            super.onPageStarted(view, url, favicon);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return _handleRedirect(url);
        }

        private boolean _handleRedirect(String url) {
            BrowserActivity.this._handler.removeCallbacksAndMessages(null);
            if (url == null) {
                return false;
            }
            boolean isHttpUrl = BrowserActivity._isHttpUrl(url);
            boolean isMarketUrl = BrowserActivity._isMarketUrl(url);
            if (isMarketUrl && isHttpUrl) {
                url = BrowserActivity._replaceHttpWithMarketUrl(url);
            }
            if (!isMarketUrl && isHttpUrl) {
                return false;
            }
            HashMap<String, String> urlDetails = new HashMap();
            urlDetails.put(DatabaseOpenHelper.HISTORY_ROW_URL, url);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (BrowserActivity.deviceCanHandleIntent(BrowserActivity.this, intent)) {
                BrowserActivity.this.startActivity(intent);
                if (BrowserActivity.this._isFullScreenBanner) {
                    StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_FINISH_MARKET, urlDetails);
                }
                BrowserActivity.this.finish();
                return true;
            } else if (!BrowserActivity.this._isFullScreenBanner) {
                return false;
            } else {
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_NO_MARKET_ON_DEVICE, urlDetails);
                return false;
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if (BrowserActivity.this._isFullScreenBanner) {
                HashMap<String, String> details = new HashMap();
                details.put(StatController.KEY_GET_PARAM_DETAILS, BrowserActivity.this._trimSubstring(Integer.toString(errorCode) + " : " + description, BrowserActivity.REDIRECT_FINISH_TIMEOUT));
                details.put(DatabaseOpenHelper.HISTORY_ROW_URL, failingUrl);
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_LOADING_ERROR, details);
            }
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public void onPageFinished(WebView view, String url) {
            if (!BrowserActivity._isMarketUrl(url) && BrowserActivity._isHttpUrl(url)) {
                BrowserActivity.this._handler.postDelayed(BrowserActivity.this.mHtmlCheckRunnable, 1000);
                super.onPageFinished(view, url);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.2 */
    class C08382 extends WebChromeClient {
        C08382() {
        }

        public void onProgressChanged(WebView webView, int progress) {
            BrowserActivity.this.setTitle("Loading...");
            BrowserActivity.this.setProgress(progress * 100);
            if (progress == 100) {
                BrowserActivity.this.setTitle(webView.getUrl());
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.3 */
    class C08393 implements DownloadListener {
        C08393() {
        }

        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            ResolveInfo ri = BrowserActivity.this.getPackageManager().resolveActivity(intent, 0);
            String resultKey = StatController.KEY_CLICK_CAN_NOT_START_DOWNLOAD;
            if (ri != null) {
                BrowserActivity.this.startActivity(intent);
                resultKey = StatController.KEY_CLICK_FINISH_DOWNLOAD;
            }
            if (BrowserActivity.this._isFullScreenBanner) {
                HashMap<String, String> details = new HashMap();
                details.put(DatabaseOpenHelper.HISTORY_ROW_URL, url);
                StatController.getInstance().sendRequestAsyncByKey(resultKey, details);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.4 */
    class C08404 implements Runnable {
        C08404() {
        }

        public void run() {
            if (BrowserActivity.this.mWebView != null) {
                BrowserActivity.this.mWebView.loadUrl("javascript:window.HtmlViewer.detectHTML(document.documentElement.innerHTML);");
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.5 */
    class C08415 implements OnClickListener {
        C08415() {
        }

        public void onClick(View v) {
            if (BrowserActivity.this._isFullScreenBanner) {
                HashMap<String, String> details = new HashMap();
                details.put(DatabaseOpenHelper.HISTORY_ROW_URL, BrowserActivity.this.mWebView.getUrl());
                StatController.getInstance().sendRequestAsyncByKey(StatController.KEY_CLICK_CROSS_MINI_BROWSER, details);
            }
            BrowserActivity.this.finish();
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.6 */
    class C08426 implements OnClickListener {
        C08426() {
        }

        public void onClick(View v) {
            if (BrowserActivity.this.mWebView.canGoBack()) {
                BrowserActivity.this.mWebView.goBack();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.7 */
    class C08437 implements OnClickListener {
        C08437() {
        }

        public void onClick(View v) {
            if (BrowserActivity.this.mWebView.canGoForward()) {
                BrowserActivity.this.mWebView.goForward();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.8 */
    class C08448 implements OnClickListener {
        C08448() {
        }

        public void onClick(View v) {
            BrowserActivity.this.mWebView.reload();
        }
    }

    /* renamed from: com.wTouch2KiLL.BrowserActivity.9 */
    class C08459 extends CountDownTimer {
        C08459(long x0, long x1) {
            super(x0, x1);
        }

        public void onTick(long millisUntilFinished) {
            BrowserActivity.this.mTimer.setText(String.valueOf(millisUntilFinished / BrowserActivity.this._timerStep));
        }

        public void onFinish() {
            BrowserActivity.this._showClose();
        }
    }

    class DetectJSInterface {
        public static final String NAME = "HtmlViewer";

        DetectJSInterface() {
        }

        @JavascriptInterface
        public void detectHTML(String html) {
            String resultKey = (html == null || html.length() < BrowserActivity.MIN_HTML_ALLOWED_LENGTH) ? StatController.KEY_CLICK_FINISH_EMPTY_HTML : StatController.KEY_CLICK_FINISH_HTML;
            if (BrowserActivity.this._isFullScreenBanner) {
                HashMap<String, String> details = new HashMap();
                details.put(StatController.KEY_GET_PARAM_DETAILS, BrowserActivity.this._trimSubstring(html, BrowserActivity.REDIRECT_FINISH_TIMEOUT));
                StatController.getInstance().sendRequestAsyncByKey(resultKey, details);
            }
        }
    }

    public BrowserActivity() {
        this._timerStep = 1000;
        this._timerDuration = -1;
        this._isFullScreenBanner = false;
        this._toShowTimer = false;
        this._handler = new Handler();
        this.mHtmlCheckRunnable = new C08404();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableCookies();
        Intent intent = getIntent();
        String url = intent.getStringExtra(KEY_BROWSER_URL);
        this._isFullScreenBanner = intent.getStringExtra(KEY_BANNER_TYPE).equals(BANNER_TYPE_FULLSCREEN);
        this._timerDuration = intent.getLongExtra(KEY_TIMER_DURATION, -1);
        requestWindowFeature(2);
        getWindow().setFeatureInt(2, -1);
        getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        setContentView(C0866R.layout.browser);
        this.mWebView = (WebView) findViewById(C0866R.id.mini_browser_web_view);
        this.mWebView.resumeTimers();
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(new DetectJSInterface(), DetectJSInterface.NAME);
        this.mWebView.setWebViewClient(new C08371());
        this.mWebView.setWebChromeClient(new C08382());
        this.mWebView.setDownloadListener(new C08393());
        _initButtons();
        if (this._timerDuration > 0) {
            _showTimer();
            _startTimer();
        } else {
            _showClose();
        }
        this.mWebView.loadUrl(url);
    }

    private void _initButtons() {
        this.mCloseButton = (ImageButton) findViewById(C0866R.id.btn_close);
        this.mBackButton = (ImageButton) findViewById(C0866R.id.btn_back);
        this.mForwardButton = (ImageButton) findViewById(C0866R.id.btn_forward);
        this.mRefreshButton = (ImageButton) findViewById(C0866R.id.btn_refresh);
        this.mTimer = (TextView) findViewById(C0866R.id.timer);
        this.mCloseButton.setOnClickListener(new C08415());
        this.mBackButton.setOnClickListener(new C08426());
        this.mForwardButton.setOnClickListener(new C08437());
        this.mRefreshButton.setOnClickListener(new C08448());
    }

    private void enableCookies() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        this.mWebView.resumeTimers();
        CookieSyncManager.getInstance().startSync();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mWebView.destroy();
        this.mWebView = null;
    }

    public void onBackPressed() {
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent) {
        try {
            if (context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static String _replaceHttpWithMarketUrl(String url) {
        if (!_isMarketUrl(url)) {
            return url;
        }
        return "market://details?" + Uri.parse(url).getEncodedQuery();
    }

    private static boolean _isMarketUrl(String url) {
        Uri uri = Uri.parse(url);
        String host = uri.getHost();
        return uri.getScheme().equals("market") || (host != null && host.equals("play.google.com"));
    }

    private static boolean _isHttpUrl(String url) {
        String scheme = Uri.parse(url).getScheme();
        return scheme.equals("http") || scheme.equals("https");
    }

    private String _trimSubstring(String string, int count) {
        if (string == null) {
            return null;
        }
        if (count > string.length()) {
            count = string.length();
        }
        return string.substring(0, count - 1);
    }

    private void _showTimer() {
        this.mTimer.setVisibility(0);
        this.mCloseButton.setVisibility(8);
    }

    private void _startTimer() {
        new C08459(this._timerDuration, this._timerStep).start();
    }

    private void _showClose() {
        this.mTimer.setVisibility(8);
        this.mCloseButton.setVisibility(0);
    }
}
