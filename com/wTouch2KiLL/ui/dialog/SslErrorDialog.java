package com.wTouch2KiLL.ui.dialog;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.wTouch2KiLL.C0866R;

public class SslErrorDialog {
    private Context _activity;

    /* renamed from: com.wTouch2KiLL.ui.dialog.SslErrorDialog.1 */
    class C09461 implements OnClickListener {
        final /* synthetic */ SslErrorHandler val$handler;

        C09461(SslErrorHandler sslErrorHandler) {
            this.val$handler = sslErrorHandler;
        }

        public void onClick(DialogInterface dialog, int id) {
            this.val$handler.cancel();
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.dialog.SslErrorDialog.2 */
    class C09472 implements OnClickListener {
        final /* synthetic */ SslErrorHandler val$handler;

        C09472(SslErrorHandler sslErrorHandler) {
            this.val$handler = sslErrorHandler;
        }

        public void onClick(DialogInterface dialog, int id) {
            this.val$handler.proceed();
        }
    }

    public SslErrorDialog(Context activity) {
        this._activity = activity;
    }

    public void execute(WebView view, SslErrorHandler handler, SslError error) {
        if (VERSION.SDK_INT < 14 || error.getUrl().equals(view.getUrl())) {
            Builder builder = new Builder(this._activity);
            builder.setMessage(C0866R.string.ssl_error_message).setTitle(C0866R.string.ssl_error_title).setPositiveButton(C0866R.string.ssl_error_positive, new C09472(handler)).setNegativeButton(C0866R.string.ssl_error_negative, new C09461(handler));
            builder.create().show();
            return;
        }
        handler.proceed();
    }
}
