package com.wTouch2KiLL.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationChecker extends BroadcastReceiver {
    public static final String CHECKER_URL_KEY = "checker_url";
    public static boolean ENABLE_NOTIFICATION = false;
    public static final String INTERVAL_KEY = "interval";
    public static final int INTERVAL_ONE_HOUR = 3600000;
    private static final String NOTIFICATION_CHECKER_ENTRIES = "notification-checker-entries";

    static {
        ENABLE_NOTIFICATION = false;
    }

    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, NotificationService.class);
        serviceIntent.putExtra(CHECKER_URL_KEY, intent.getExtras().getString(CHECKER_URL_KEY));
        context.startService(serviceIntent);
    }

    private PendingIntent _createPendingIntentForChecker(String checkerUrl, Context context) {
        Intent intent = new Intent(context, NotificationChecker.class);
        intent.putExtra(CHECKER_URL_KEY, checkerUrl);
        return PendingIntent.getBroadcast(context, checkerUrl.hashCode(), intent, 0);
    }

    private void _setAlarmForChecker(String checkerUrl, JSONObject checker, Context context) {
        PendingIntent pendingIntent = _createPendingIntentForChecker(checkerUrl, context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
        int checkerInterval = checker.optInt(INTERVAL_KEY);
        if (checkerInterval == 0) {
            checkerInterval = INTERVAL_ONE_HOUR;
        }
        alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + ((long) checkerInterval), (long) checkerInterval, pendingIntent);
    }

    private void _removeAlarmForChecker(String checkerUrl, Context context) {
        ((AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM)).cancel(_createPendingIntentForChecker(checkerUrl, context));
    }

    public void rescheduleLaunch(Context context) {
        JSONObject checkers = _readCheckerEntries(context);
        Iterator<?> urls = checkers.keys();
        while (urls.hasNext()) {
            String url = (String) urls.next();
            JSONObject checker = checkers.optJSONObject(url);
            _removeAlarmForChecker(url, context);
            _setAlarmForChecker(url, checker, context);
        }
    }

    private JSONObject _readCheckerEntries(Context context) {
        try {
            return new JSONObject(context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).getString(NOTIFICATION_CHECKER_ENTRIES, "{}"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean _writeCheckerEntries(JSONObject entries, Context context) {
        return context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).edit().putString(NOTIFICATION_CHECKER_ENTRIES, entries.toString()).commit();
    }

    public void addChecker(String htmlUrl, int checkIntervalMillis, MainNavigationActivity activity) {
        try {
            ENABLE_NOTIFICATION = true;
            JSONObject checkerJson = new JSONObject();
            checkerJson.put(INTERVAL_KEY, checkIntervalMillis);
            JSONObject checkers = _readCheckerEntries(activity);
            checkers.put(htmlUrl, checkerJson);
            _writeCheckerEntries(checkers, activity);
            rescheduleLaunch(activity);
            if (!activity.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).getBoolean("never_show", false)) {
                activity.checkDrawOverlayPermission();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeChecker(String htmlUrl, Context context) {
        JSONObject checkers = _readCheckerEntries(context);
        checkers.remove(htmlUrl);
        _removeAlarmForChecker(htmlUrl, context);
        _writeCheckerEntries(checkers, context);
    }

    public void clearCheckers(Context context) {
        Iterator<?> urls = _readCheckerEntries(context).keys();
        while (urls.hasNext()) {
            _removeAlarmForChecker((String) urls.next(), context);
        }
        try {
            _writeCheckerEntries(new JSONObject("{}"), context);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
