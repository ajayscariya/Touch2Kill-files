package com.wTouch2KiLL.browser;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.DownloadsListActivity;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.browser.DownloadsItem.Status;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration.DownloadActions;
import com.wTouch2KiLL.controllers.WebContentController;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import com.wTouch2KiLL.ui.dialog.SimpleDialogs;
import com.wTouch2KiLL.utils.FileManager;

public class BrowserDownloadListener implements DownloadListener {
    private WebContentController _webController;

    /* renamed from: com.wTouch2KiLL.browser.BrowserDownloadListener.1 */
    class C08991 implements OnClickListener {
        final /* synthetic */ String val$finalMimeType;
        final /* synthetic */ MainNavigationActivity val$mainActivity;
        final /* synthetic */ String val$url;

        C08991(String str, String str2, MainNavigationActivity mainNavigationActivity) {
            this.val$url = str;
            this.val$finalMimeType = str2;
            this.val$mainActivity = mainNavigationActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
            FileManager.fireOpenFileIntent(this.val$url, this.val$finalMimeType, this.val$mainActivity);
        }
    }

    /* renamed from: com.wTouch2KiLL.browser.BrowserDownloadListener.2 */
    class C09002 implements OnClickListener {
        final /* synthetic */ String val$contentDisposition;
        final /* synthetic */ String val$finalMimeType;
        final /* synthetic */ MainNavigationActivity val$mainActivity;
        final /* synthetic */ String val$url;

        C09002(String str, String str2, String str3, MainNavigationActivity mainNavigationActivity) {
            this.val$url = str;
            this.val$contentDisposition = str2;
            this.val$finalMimeType = str3;
            this.val$mainActivity = mainNavigationActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
            BrowserDownloadListener.this.download(this.val$url, this.val$contentDisposition, this.val$finalMimeType, this.val$mainActivity);
        }
    }

    /* renamed from: com.wTouch2KiLL.browser.BrowserDownloadListener.3 */
    class C09013 implements ValueCallback<Integer> {
        final /* synthetic */ String val$contentDisposition;
        final /* synthetic */ String val$finalMimeType;
        final /* synthetic */ MainNavigationActivity val$mainActivity;
        final /* synthetic */ String val$url;

        C09013(String str, String str2, String str3, MainNavigationActivity mainNavigationActivity) {
            this.val$url = str;
            this.val$finalMimeType = str2;
            this.val$contentDisposition = str3;
            this.val$mainActivity = mainNavigationActivity;
        }

        public void onReceiveValue(Integer value) {
            if (value.intValue() == 0) {
                long id = FileManager.downloadFile(this.val$url, this.val$finalMimeType, this.val$contentDisposition, this.val$mainActivity);
                String filename = URLUtil.guessFileName(this.val$url, this.val$contentDisposition, this.val$finalMimeType);
                BrowserDownloadListener.this.addIntoDataBase(this.val$mainActivity, this.val$url, id, filename);
                BrowserDownloadListener.this.sendMessageToActivity(this.val$mainActivity, id, filename, this.val$url);
                return;
            }
            Toast.makeText(this.val$mainActivity, C0866R.string.download_permission_denied, 1).show();
        }
    }

    public BrowserDownloadListener(WebContentController webController) {
        this._webController = webController;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        try {
            MainNavigationActivity mainActivity = Factory.getInstance().getMainNavigationActivity();
            String guessedMimeType = null;
            String extension = MimeTypeMap.getFileExtensionFromUrl(url);
            if (extension != null) {
                guessedMimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            }
            if (guessedMimeType == null) {
                guessedMimeType = mimetype;
            }
            String finalMimeType = guessedMimeType;
            DownloadActions action = mainActivity.getConfig().getDownloadAction();
            if (VERSION.SDK_INT < 9) {
                action = DownloadActions.OPEN;
            }
            if (action == DownloadActions.OPEN) {
                FileManager.fireOpenFileIntent(url, finalMimeType, mainActivity);
            } else if (action == DownloadActions.SAVE) {
                try {
                    download(url, null, finalMimeType, mainActivity);
                } catch (Exception e) {
                    FileManager.fireOpenFileIntent(url, finalMimeType, mainActivity);
                }
            } else if (action == DownloadActions.DIALOG) {
                try {
                    SimpleDialogs.showOpenOrSaveDialog(mainActivity, new C08991(url, finalMimeType, mainActivity), new C09002(url, contentDisposition, finalMimeType, mainActivity));
                } catch (Exception e2) {
                    FileManager.fireOpenFileIntent(url, mimetype, mainActivity);
                }
            }
        } catch (ActivityNotFoundException e3) {
            Log.e("ANFE", "onDownloadStart :" + e3.getMessage());
        }
    }

    private void download(String url, String contentDisposition, String finalMimeType, MainNavigationActivity mainActivity) {
        if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            long id = FileManager.downloadFile(url, finalMimeType, contentDisposition, mainActivity);
            String filename = URLUtil.guessFileName(url, contentDisposition, finalMimeType);
            addIntoDataBase(mainActivity, url, id, filename);
            sendMessageToActivity(mainActivity, id, filename, url);
            return;
        }
        ActivityCompat.requestPermissions(mainActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 35);
        mainActivity.setPermissionCallback(new C09013(url, finalMimeType, contentDisposition, mainActivity));
    }

    private void sendMessageToActivity(MainNavigationActivity mainActivity, long id, String name, String url) {
        Intent intent = new Intent();
        intent.putExtra("type", 100);
        intent.putExtra("item", new DownloadsItem(id, name, url));
        intent.setAction(DownloadsListActivity.DOWNLOAD_LIST_MSG);
        mainActivity.sendBroadcast(intent);
    }

    private void addIntoDataBase(MainNavigationActivity mainActivity, String url, long id, String filename) {
        SQLiteDatabase db = new DatabaseOpenHelper(mainActivity).getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            cv.put("id_d", Long.valueOf(id));
            cv.put("name", filename);
            cv.put(NotificationCompatApi21.CATEGORY_STATUS, Status.InProgress.toString());
            cv.put("link_d", url);
            cv.put("description", url);
            db.insert("downloadsList", null, cv);
        } catch (Exception e) {
            Log.e("Error", "  Error while add string into table downloadsList " + e);
        } finally {
            db.close();
        }
    }
}
