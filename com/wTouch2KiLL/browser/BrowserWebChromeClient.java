package com.wTouch2KiLL.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.controllers.WebContentController;
import com.wTouch2KiLL.ui.dialog.SimpleDialogs;
import mf.javax.xml.XMLConstants;

public class BrowserWebChromeClient extends WebChromeClient {
    public static final String WEB_VIEW_LOG_PREFIX = "webConsoleMessage";
    private WebContentController _webController;

    /* renamed from: com.wTouch2KiLL.browser.BrowserWebChromeClient.1 */
    class C09021 implements OnClickListener {
        final /* synthetic */ JsResult val$result;

        C09021(JsResult jsResult) {
            this.val$result = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.val$result.confirm();
        }
    }

    /* renamed from: com.wTouch2KiLL.browser.BrowserWebChromeClient.2 */
    class C09032 implements OnClickListener {
        final /* synthetic */ JsResult val$result;

        C09032(JsResult jsResult) {
            this.val$result = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.val$result.cancel();
        }
    }

    public BrowserWebChromeClient(WebContentController webController) {
        this._webController = webController;
    }

    public void onProgressChanged(WebView view, int progress) {
        this._webController.setProgressBarState(progress);
    }

    public View getVideoLoadingProgressView() {
        return Factory.getInstance().getMainNavigationActivity().getVideoLoadingProgressView();
    }

    public void onShowCustomView(View view, CustomViewCallback callback) {
        super.onShowCustomView(view, callback);
        Factory.getInstance().getMainNavigationActivity().onShowCustomView(view, callback);
    }

    public void onHideCustomView() {
        super.onHideCustomView();
        Factory.getInstance().getMainNavigationActivity().onHideCustomView();
    }

    public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
        return Factory.getInstance().getMainNavigationActivity().openFileChooser(mWebView, filePathCallback, fileChooserParams);
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
        openFileChooser(uploadMsg, acceptType);
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
        Factory.getInstance().getMainNavigationActivity().openFileChooser(uploadMsg, acceptType);
    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg) {
        openFileChooser(uploadMsg, XMLConstants.NULL_NS_URI);
    }

    public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
        callback.invoke(origin, true, true);
    }

    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        SimpleDialogs.createConfirmDialog(Factory.getInstance().getMainNavigationActivity().getConfig().getWidgetName(), message, view.getContext(), new C09021(result), new C09032(result)).show();
        return true;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.d(WEB_VIEW_LOG_PREFIX, String.format("%s @ %d: %s", new Object[]{consoleMessage.message(), Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.sourceId()}));
        return true;
    }
}
