package com.wTouch2KiLL.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.ui.navigationwidget.INavigationWidget;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

public class BrowserWebView extends WebView {
    private boolean _firstUrl;
    private INavigationWidget _navigationWidget;
    private GestureDetector gestureDetector;
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2, int i3, int i4);
    }

    public BrowserWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._firstUrl = true;
        this._navigationWidget = null;
    }

    private void init() {
        this._navigationWidget = Factory.getInstance().getNavigationWidget();
        this._firstUrl = false;
    }

    public void loadUrl(String url) {
        if (this._firstUrl) {
            init();
        }
        if (!(this._navigationWidget == null || !this._navigationWidget.isVisible() || URLUtil.isValidUrl(url))) {
            if (("http://" + url).matches("(news|(ht|f)tp(s?)\\://){1}[\\S\\.]+\\.[\\S\\.]+")) {
                url = "http://" + url;
            } else {
                try {
                    url = getResources().getString(C0866R.string.searchUrl) + URLEncoder.encode(url, Defaults.Encoding);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!url.contains("javascript:(function(){  })()")) {
            super.loadUrl(url);
        }
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.mOnScrollChangedCallback != null) {
            this.mOnScrollChangedCallback.onScroll(l, t, oldl, oldt);
        }
    }

    public OnScrollChangedCallback getOnScrollChangedCallback(OnScrollChangedCallback getOnScrollChangedCallback) {
        return this.mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }
}
