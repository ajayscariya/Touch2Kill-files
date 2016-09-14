package com.inmobi.rendering.mraid;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.plus.PlusShare.Builder;
import com.inmobi.ads.AdConfig.AdConfig;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.InMobiAdActivity.C0647b;
import com.inmobi.rendering.RenderView;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.notification.NotificationChecker;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Calendar;
import mf.javax.xml.XMLConstants;
import mf.javax.xml.transform.OutputKeys;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.n */
public class SystemTasksProcessor {
    private static final String f2050a;
    private RenderView f2051b;
    private SystemTasksProcessor f2052c;

    /* renamed from: com.inmobi.rendering.mraid.n.a */
    static final class SystemTasksProcessor extends Handler {
        private static final String f2048a;
        private WeakReference<RenderView> f2049b;

        static {
            f2048a = SystemTasksProcessor.class.getSimpleName();
        }

        public SystemTasksProcessor(Looper looper, RenderView renderView) {
            super(looper);
            this.f2049b = new WeakReference(renderView);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    String str = (String) message.obj;
                    String str2 = "broadcastEvent('vibrateComplete');";
                    RenderView renderView = (RenderView) this.f2049b.get();
                    if (renderView != null) {
                        renderView.m1946a(str, "broadcastEvent('vibrateComplete');");
                    }
                default:
                    Logger.m1744a(InternalLogLevel.INTERNAL, f2048a, "Unknown message type. Ignoring ...");
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.n.1 */
    class SystemTasksProcessor implements C0647b {
        final /* synthetic */ Context f4477a;
        final /* synthetic */ int f4478b;
        final /* synthetic */ String f4479c;
        final /* synthetic */ String f4480d;
        final /* synthetic */ String f4481e;
        final /* synthetic */ String f4482f;
        final /* synthetic */ SystemTasksProcessor f4483g;

        SystemTasksProcessor(SystemTasksProcessor systemTasksProcessor, Context context, int i, String str, String str2, String str3, String str4) {
            this.f4483g = systemTasksProcessor;
            this.f4477a = context;
            this.f4478b = i;
            this.f4479c = str;
            this.f4480d = str2;
            this.f4481e = str3;
            this.f4482f = str4;
        }

        public void m5193a(int i, Intent intent) {
            Logger.m1744a(InternalLogLevel.INTERNAL, SystemTasksProcessor.f2050a, "Result code: " + i);
            if (this.f4478b == CalendarUtil.m2066a(this.f4477a)) {
                Logger.m1744a(InternalLogLevel.INTERNAL, SystemTasksProcessor.f2050a, "User cancelled the create calendar event");
                return;
            }
            ContentValues contentValues = new ContentValues();
            String str = this.f4479c;
            int i2 = -1;
            switch (str.hashCode()) {
                case -1320822226:
                    if (str.equals("tentative")) {
                        i2 = 0;
                        break;
                    }
                    break;
                case -804109473:
                    if (str.equals("confirmed")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 476588369:
                    if (str.equals("cancelled")) {
                        i2 = 2;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case DurationDV.DURATION_TYPE /*0*/:
                    contentValues.put("eventStatus", Integer.valueOf(0));
                    break;
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    contentValues.put("eventStatus", Integer.valueOf(1));
                    break;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    contentValues.put("eventStatus", Integer.valueOf(2));
                    break;
            }
            ContentResolver contentResolver = this.f4477a.getContentResolver();
            contentResolver.update(ContentUris.withAppendedId(Events.CONTENT_URI, (long) CalendarUtil.m2066a(this.f4477a)), contentValues, null, null);
            if (this.f4480d != null && !XMLConstants.NULL_NS_URI.equals(this.f4480d)) {
                try {
                    if (this.f4480d.startsWith("+")) {
                        i2 = Integer.parseInt(this.f4480d.substring(1)) / 60000;
                    } else {
                        i2 = Integer.parseInt(this.f4480d) / 60000;
                    }
                } catch (NumberFormatException e) {
                    Calendar b = CalendarUtil.m2070b(this.f4480d);
                    if (b == null) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, SystemTasksProcessor.f2050a, "Invalid reminder date provided. date string: " + this.f4480d);
                        return;
                    }
                    i2 = ((int) (b.getTimeInMillis() - CalendarUtil.m2070b(this.f4481e).getTimeInMillis())) / 60000;
                    if (i2 > 0) {
                        this.f4483g.f2051b.m1949a(this.f4482f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
                        return;
                    }
                }
                i2 = -i2;
                contentResolver.delete(Reminders.CONTENT_URI, "event_id=?", new String[]{CalendarUtil.m2066a(this.f4477a) + XMLConstants.NULL_NS_URI});
                if (i2 < 0) {
                    this.f4483g.f2051b.m1949a(this.f4482f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
                    return;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Integer.valueOf(CalendarUtil.m2066a(this.f4477a)));
                contentValues2.put(OutputKeys.METHOD, Integer.valueOf(1));
                contentValues2.put("minutes", Integer.valueOf(i2));
                contentResolver.insert(Reminders.CONTENT_URI, contentValues2);
            }
        }
    }

    static {
        f2050a = SystemTasksProcessor.class.getSimpleName();
    }

    public SystemTasksProcessor(RenderView renderView) {
        this.f2051b = renderView;
        HandlerThread handlerThread = new HandlerThread("SystemTasksHandlerThread");
        handlerThread.start();
        this.f2052c = new SystemTasksProcessor(handlerThread.getLooper(), renderView);
    }

    @TargetApi(14)
    public void m2148a(String str, Context context, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        int a = CalendarUtil.m2066a(context);
        Calendar b = CalendarUtil.m2070b(str3);
        if (b == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Invalid event start date provided. date string: " + str3);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Event start: " + b.get(1) + "-" + b.get(2) + "-" + b.get(5));
        Calendar b2 = CalendarUtil.m2070b(str4);
        if (b2 == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Invalid event end date provided. date string: " + str4);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Event end: " + b2.get(1) + "-" + b2.get(2) + "-" + b2.get(5));
        Intent putExtra = new Intent("android.intent.action.INSERT").setData(Events.CONTENT_URI).putExtra("calendar_id", str2).putExtra("beginTime", b.getTimeInMillis()).putExtra("endTime", b2.getTimeInMillis()).putExtra("allDay", false).putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, str6).putExtra("eventLocation", str5).putExtra("description", str7);
        if (str9.equals("transparent")) {
            putExtra.putExtra("availability", 1);
        } else {
            if (str9.equals("opaque")) {
                putExtra.putExtra("availability", 0);
            }
        }
        String a2 = m2141a(str10);
        if (a2.length() != 0) {
            putExtra.putExtra("rrule", a2);
        }
        int a3 = InMobiAdActivity.m1885a(putExtra, new SystemTasksProcessor(this, context, a, str8, str11, str3, str));
        Intent intent = new Intent(context, InMobiAdActivity.class);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkedTextViewStyle);
        intent.putExtra("id", a3);
        context.startActivity(intent);
    }

    public void m2146a(String str, Context context, int i, String str2, String str3, String str4) {
        if (str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0 || !str3.startsWith("http") || str4 == null || str4.length() == 0 || !str4.startsWith("http") || !str4.endsWith(".jpg")) {
            this.f2051b.m1949a(str, "Attempting to share with null/empty/invalid parameters", "postToSocial");
            return;
        }
        Intent intent = null;
        String str5;
        switch (i) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                str5 = XMLConstants.NULL_NS_URI;
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (m2143b()) {
                    intent = new Builder(context).setType("text/plain").setText(str2 + " " + str3 + " " + str4).setContentUrl(Uri.parse(str4)).getIntent();
                    break;
                }
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                str5 = str2 + " " + str3 + " " + str4;
                intent = new Intent();
                intent.setType("text/plain");
                intent.setPackage("com.twitter.android");
                intent.putExtra("android.intent.extra.TEXT", str5);
                break;
            default:
                this.f2051b.m1949a(str, "Unsupported type of social network", "postToSocial");
                return;
        }
        if (intent != null) {
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                m2142a(context, i, str2, str3, str4);
                return;
            }
        }
        m2142a(context, i, str2, str3, str4);
    }

    private boolean m2143b() {
        try {
            return GooglePlayServicesUtil.isGooglePlayServicesAvailable(SdkContext.m1562b()) == 0;
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
            return false;
        }
    }

    private void m2142a(Context context, int i, String str, String str2, String str3) {
        String str4 = str + " " + str2 + " " + str3;
        String str5 = null;
        switch (i) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                try {
                    str5 = "https://www.facebook.com/dialog/feed?app_id=181821551957328&link=" + URLEncoder.encode(str2, Defaults.Encoding) + "&picture=" + URLEncoder.encode(str3, Defaults.Encoding) + "&name=&description=" + URLEncoder.encode(str, Defaults.Encoding) + "&redirect_uri=" + URLEncoder.encode(str2, Defaults.Encoding);
                    break;
                } catch (UnsupportedEncodingException e) {
                    return;
                }
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                str5 = "https://m.google.com/app/plus/x/?v=compose&content=" + URLEncoder.encode(str4, Defaults.Encoding);
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                str5 = "http://twitter.com/home?status=" + URLEncoder.encode(str4, Defaults.Encoding);
                break;
        }
        if (str5 != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str5));
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e2) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, e2.getMessage());
                return;
            }
        }
        Intent intent2 = new Intent();
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.TEXT", str4);
        try {
            context.startActivity(intent2);
        } catch (ActivityNotFoundException e22) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, e22.getMessage());
        }
    }

    public void m2145a(String str, Context context) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(2000);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = str;
        this.f2052c.sendMessageDelayed(obtain, 2000);
    }

    public void m2147a(String str, Context context, String str2, int i) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        String replaceAll = str2.replaceAll("\\[", XMLConstants.NULL_NS_URI).replaceAll("\\]", XMLConstants.NULL_NS_URI);
        if (replaceAll == null || XMLConstants.NULL_NS_URI.equals(replaceAll.trim())) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Vibration canceled");
            m2144a(context);
            return;
        }
        String[] split = replaceAll.split(",");
        int length = split.length;
        AdConfig renderingConfig = this.f2051b.getRenderingConfig();
        if (length > renderingConfig.m1483f()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "vibration pattern exceeds max length. Will be truncated to max " + renderingConfig.m1483f());
            length = renderingConfig.m1483f();
        }
        long[] jArr = new long[length];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            try {
                jArr[i3] = Long.parseLong(split[i3]);
                if (jArr[i3] > ((long) (renderingConfig.m1482e() * 1000))) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "vibration duration exceeds max. Will only vibrate for max " + renderingConfig.m1482e() + "ms");
                    jArr[i3] = (long) renderingConfig.m1482e();
                }
                if (jArr[i3] < 0) {
                    this.f2051b.m1949a(str, "Negative duration not allowed in vibration .", "vibrate");
                }
                i2 = (int) (((long) i2) + jArr[i3]);
                i3++;
            } catch (NumberFormatException e) {
                this.f2051b.m1949a(str, "Invalid values of pattern in vibration .", "vibrate");
                return;
            }
        }
        if (jArr.length != 0) {
            m2144a(context);
            vibrator.vibrate(jArr, i);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.f2052c.sendMessageDelayed(obtain, (long) i2);
        }
    }

    public void m2144a(Context context) {
        if (this.f2052c != null && this.f2052c.hasMessages(1)) {
            this.f2052c.removeMessages(1);
            ((Vibrator) context.getSystemService("vibrator")).cancel();
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Canceling any pending/ongoing vibrate requests");
        }
    }

    private String m2141a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str.length() == 0) {
            return XMLConstants.NULL_NS_URI;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("frequency");
            if (optString == null || XMLConstants.NULL_NS_URI.equals(optString)) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Error Parsing recurrence string. Frequency supplied is null");
                return XMLConstants.NULL_NS_URI;
            } else if ("daily".equals(optString) || "weekly".equals(optString) || "monthly".equals(optString) || "yearly".equals(optString)) {
                stringBuilder.append("freq=").append(optString).append(";");
                String optString2 = jSONObject.optString(NotificationChecker.INTERVAL_KEY);
                if (!(optString2 == null || XMLConstants.NULL_NS_URI.equals(optString2))) {
                    stringBuilder.append("interval=").append(Integer.parseInt(optString2)).append(";");
                }
                optString2 = CalendarUtil.m2067a(jSONObject.optString("expires"));
                if (optString2 != null) {
                    stringBuilder.append("until=").append(optString2.replace("+", "Z+").replace("-", "Z-")).append(";");
                }
                if (optString.equals("weekly")) {
                    optString2 = CalendarUtil.m2068a(jSONObject.optJSONArray("daysInWeek"));
                    if (optString2 != null) {
                        stringBuilder.append("byday=").append(optString2).append(";");
                    }
                }
                if (optString.equals("monthly")) {
                    optString2 = CalendarUtil.m2069a(jSONObject.optJSONArray("daysInMonth"), -31, 31);
                    if (optString2 != null) {
                        stringBuilder.append("bymonthday=").append(optString2).append(";");
                    }
                }
                if (optString.equals("yearly")) {
                    optString2 = CalendarUtil.m2069a(jSONObject.optJSONArray("daysInYear"), -366, 366);
                    if (optString2 != null) {
                        stringBuilder.append("byyearday=").append(optString2).append(";");
                    }
                }
                if (optString.equals("monthly")) {
                    optString2 = CalendarUtil.m2069a(jSONObject.optJSONArray("weeksInMonth"), -4, 4);
                    if (optString2 != null) {
                        stringBuilder.append("byweekno=").append(optString2).append(";");
                    }
                }
                if (optString.equals("yearly")) {
                    String a = CalendarUtil.m2069a(jSONObject.optJSONArray("monthsInYear"), 1, 12);
                    if (a != null) {
                        stringBuilder.append("bymonth=").append(a).append(";");
                    }
                }
                return stringBuilder.toString();
            } else {
                Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Error Parsing recurrence string. Invalid Frequency supplied");
                return XMLConstants.NULL_NS_URI;
            }
        } catch (JSONException e) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2050a, "Error Parsing recurrence string" + e.toString());
            return XMLConstants.NULL_NS_URI;
        }
    }
}
