package com.wTouch2KiLL.javascriptinterface;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.wTouch2KiLL.inline.StringEscapeUtils;
import com.wTouch2KiLL.server.BaseServerClient;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;
import com.wTouch2KiLL.utils.FileManager;
import com.wTouch2KiLL.utils.ImageReader;
import com.wTouch2KiLL.utils.UrlConverter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.LineSeparator;

public class BaseBrowserJavascriptInterface {
    public static final String JS_PREFERENCE_NAME = "JS-PREFERENCE";
    public static final String JS_PREFERENCE_PREFIX = "JS-Preference-";
    private Context _context;
    private WebView _view;
    private Handler _webViewThreadHandler;

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BaseBrowserJavascriptInterface.1 */
    class C14711 implements OnRequestDoneListener {
        final /* synthetic */ String val$resultCallback;

        /* renamed from: com.wTouch2KiLL.javascriptinterface.BaseBrowserJavascriptInterface.1.1 */
        class C09161 implements Runnable {
            final /* synthetic */ String val$callback;

            C09161(String str) {
                this.val$callback = str;
            }

            public void run() {
                BaseBrowserJavascriptInterface.this._view.loadUrl(this.val$callback);
            }
        }

        C14711(String str) {
            this.val$resultCallback = str;
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
            BaseBrowserJavascriptInterface.this._webViewThreadHandler.post(new C09161("javascript:window." + this.val$resultCallback + "('" + StringEscapeUtils.escapeJavaScript(stringResponse) + "');"));
        }
    }

    /* renamed from: com.wTouch2KiLL.javascriptinterface.BaseBrowserJavascriptInterface.2 */
    class C14722 implements OnRequestDoneListener {
        final /* synthetic */ String val$resultCallback;

        /* renamed from: com.wTouch2KiLL.javascriptinterface.BaseBrowserJavascriptInterface.2.1 */
        class C09171 implements Runnable {
            final /* synthetic */ String val$result;

            C09171(String str) {
                this.val$result = str;
            }

            public void run() {
                BaseBrowserJavascriptInterface.this._view.loadUrl("javascript:" + C14722.this.val$resultCallback + "('" + this.val$result + "');");
            }
        }

        C14722(String str) {
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
            BaseBrowserJavascriptInterface.this._webViewThreadHandler.post(new C09171(stringResponse.replace(LineSeparator.Web, XMLConstants.NULL_NS_URI).replace("\\", "\\\\").replace("'", "\\'")));
        }
    }

    public BaseBrowserJavascriptInterface(Context context, WebView webView, Handler webViewThreadHandler) {
        this._context = context;
        this._view = webView;
        this._webViewThreadHandler = webViewThreadHandler;
    }

    @JavascriptInterface
    public void sendXMLHTTPRequest(String url, String resultCallback) {
        new BaseServerClient(this._context, null).sendRequestAsync(url, Integer.valueOf(0), new C14711(resultCallback));
    }

    @JavascriptInterface
    public void showInfo(String message) {
        if (this._context != null) {
            Toast.makeText(this._context, message, 0).show();
        }
    }

    @JavascriptInterface
    public void downloadFile(String url) {
        FileManager.downloadFile(new UrlConverter(this._view).toAbsolute(url), XMLConstants.NULL_NS_URI, this._context);
    }

    @JavascriptInterface
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

    @JavascriptInterface
    public String getFileContents(String fileName) {
        String strRes = XMLConstants.NULL_NS_URI;
        return FileManager.getStringFromAssetsFileWithFileName(fileName, this._context);
    }

    @JavascriptInterface
    public String getItem(String key) {
        return this._context.getSharedPreferences(JS_PREFERENCE_NAME, 0).getString(JS_PREFERENCE_PREFIX + key, null);
    }

    @JavascriptInterface
    public void setItem(String key, String value) {
        this._context.getSharedPreferences(JS_PREFERENCE_NAME, 0).edit().putString(JS_PREFERENCE_PREFIX + key, value).commit();
    }

    @JavascriptInterface
    public void getBase64FromImageUrl(String url, String resultCallback) {
        new BaseServerClient(this._context, null).sendRequestAsync(url, Integer.valueOf(0), new C14722(resultCallback));
    }
}
