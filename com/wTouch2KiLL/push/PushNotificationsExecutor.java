package com.wTouch2KiLL.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.wTouch2KiLL.notification.AppNotificationManager;
import com.wTouch2KiLL.pull.StatServerClient;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;

public class PushNotificationsExecutor {

    /* renamed from: com.wTouch2KiLL.push.PushNotificationsExecutor.1 */
    static class C09391 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Bundle val$extras;

        C09391(Bundle bundle, Context context) {
            this.val$extras = bundle;
            this.val$context = context;
        }

        public void run() {
            String url = this.val$extras.getString(DatabaseOpenHelper.HISTORY_ROW_URL);
            String message = this.val$extras.getString("message");
            String title = this.val$extras.getString(DatabaseOpenHelper.HISTORY_ROW_TITLE);
            if (message != null || title != null) {
                AppNotificationManager.generateNotification(this.val$context, message, title, AppNotificationManager.getLaunchIntent(this.val$context, title, url, this.val$extras.getString("launchMain")));
                String TAG = PushNotificationsExecutor.class.getSimpleName();
                Log.i(TAG, "Got incoming push message, url is " + url);
                Log.i(TAG, "Sending feedback to Appsgeyser...");
                new StatServerClient(this.val$context).sendPushReceivedAsync(url);
            }
        }
    }

    public static void executeNotification(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            new Thread(new C09391(extras, context)).start();
        }
    }
}
