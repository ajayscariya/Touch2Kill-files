package com.wTouch2KiLL.ui.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.wTouch2KiLL.C0866R;

public class SimpleDialogs {

    /* renamed from: com.wTouch2KiLL.ui.dialog.SimpleDialogs.1 */
    static class C09421 implements OnClickListener {
        final /* synthetic */ OnClickListener val$onYesListener;

        C09421(OnClickListener onClickListener) {
            this.val$onYesListener = onClickListener;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            if (this.val$onYesListener != null) {
                this.val$onYesListener.onClick(dialog, which);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.dialog.SimpleDialogs.2 */
    static class C09432 implements OnClickListener {
        final /* synthetic */ OnClickListener val$onNoListener;

        C09432(OnClickListener onClickListener) {
            this.val$onNoListener = onClickListener;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            if (this.val$onNoListener != null) {
                this.val$onNoListener.onClick(dialog, which);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.dialog.SimpleDialogs.3 */
    static class C09443 implements OnCancelListener {
        final /* synthetic */ OnClickListener val$onNoListener;

        C09443(OnClickListener onClickListener) {
            this.val$onNoListener = onClickListener;
        }

        public void onCancel(DialogInterface dialog) {
            dialog.dismiss();
            if (this.val$onNoListener != null) {
                this.val$onNoListener.onClick(dialog, 0);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.dialog.SimpleDialogs.4 */
    static class C09454 implements OnClickListener {
        C09454() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    public static AlertDialog createConfirmDialog(String title, String message, Context context, OnClickListener onYesListener, OnClickListener onNoListener) {
        Builder builder = new Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(context.getString(C0866R.string.yes), new C09421(onYesListener));
        builder.setNegativeButton(context.getString(C0866R.string.no), new C09432(onNoListener));
        builder.setOnCancelListener(new C09443(onNoListener));
        return builder.create();
    }

    public static void showOpenOrSaveDialog(Context context, OnClickListener open, OnClickListener save) {
        AlertDialog dialog = new Builder(context).create();
        dialog.setTitle(context.getString(C0866R.string.dialog_select_action));
        dialog.setButton(-1, context.getString(C0866R.string.open_file), open);
        dialog.setButton(-3, context.getString(C0866R.string.save_file), save);
        dialog.setButton(-2, context.getString(C0866R.string.cancel), new C09454());
        dialog.setCancelable(true);
        dialog.show();
    }

    public static AlertDialog showNoticeDialog(String title, String msg, Context context, OnClickListener never_show, OnClickListener no, OnClickListener yes) {
        AlertDialog dialog = new Builder(context).create();
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setButton(-2, context.getString(C0866R.string.deny), no);
        dialog.setButton(-1, context.getString(C0866R.string.allow), yes);
        dialog.setButton(-3, context.getString(C0866R.string.never), never_show);
        return dialog;
    }
}
