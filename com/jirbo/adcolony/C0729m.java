package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import com.applovin.sdk.AppLovinEventTypes;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.Method;

/* renamed from: com.jirbo.adcolony.m */
class C0729m {
    WebView f2619a;
    Activity f2620b;
    ADCVideo f2621c;
    Handler f2622d;
    Runnable f2623e;
    AdColonyAd f2624f;
    String f2625g;

    /* renamed from: com.jirbo.adcolony.m.1 */
    class C07271 implements Runnable {
        final /* synthetic */ C0729m f2617a;

        C07271(C0729m c0729m) {
            this.f2617a = c0729m;
        }

        public void run() {
            C0694a.f2344J = false;
        }
    }

    /* renamed from: com.jirbo.adcolony.m.2 */
    class C07282 implements OnScanCompletedListener {
        final /* synthetic */ C0729m f2618a;

        C07282(C0729m c0729m) {
            this.f2618a = c0729m;
        }

        public void onScanCompleted(String path, Uri uri) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            Toast.makeText(this.f2618a.f2620b, "Screenshot saved to Gallery!", 0).show();
        }
    }

    public C0729m(ADCVideo aDCVideo, WebView webView, Activity activity) {
        this.f2619a = webView;
        this.f2620b = activity;
        this.f2621c = aDCVideo;
        this.f2622d = new Handler();
        this.f2623e = new C07271(this);
    }

    void m2662a(String str) {
        String str2;
        String[] strArr;
        String replace = str.replace("mraid://", XMLConstants.NULL_NS_URI);
        if (replace.contains("?")) {
            String[] split = replace.split("\\?");
            str2 = split[0];
            strArr = split;
        } else {
            str2 = replace;
            strArr = null;
        }
        if (strArr != null) {
            strArr = strArr[1].split("&");
        } else {
            strArr = new String[0];
        }
        HashMap hashMap = new HashMap();
        for (String str3 : r0) {
            hashMap.put(str3.split("=")[0], str3.split("=")[1]);
        }
        this.f2624f = C0694a.f2354T;
        this.f2625g = "{\"ad_slot\":" + C0694a.f2372l.f2516e.f2970j + "}";
        if (str2.equals("send_adc_event")) {
            m2665b((String) hashMap.get("type"));
        } else if (str2.equals("close")) {
            m2664b();
        } else if (str2.equals("open_store") && !C0694a.f2344J) {
            m2667c((String) hashMap.get("item"));
        } else if (str2.equals("open") && !C0694a.f2344J) {
            m2669d((String) hashMap.get(DatabaseOpenHelper.HISTORY_ROW_URL));
        } else if (str2.equals("expand")) {
            m2671e((String) hashMap.get(DatabaseOpenHelper.HISTORY_ROW_URL));
        } else if (str2.equals("create_calendar_event") && !C0694a.f2344J) {
            m2668c(hashMap);
        } else if (str2.equals("mail") && !C0694a.f2344J) {
            m2670d(hashMap);
        } else if (str2.equals("sms") && !C0694a.f2344J) {
            m2672e(hashMap);
        } else if (str2.equals("tel") && !C0694a.f2344J) {
            m2674f(hashMap);
        } else if (str2.equals("custom_event")) {
            m2676g(hashMap);
        } else if (str2.equals("launch_app") && !C0694a.f2344J) {
            m2677h(hashMap);
        } else if (str2.equals("check_app_presence")) {
            m2678i(hashMap);
        } else if (str2.equals("auto_play")) {
            m2679j(hashMap);
        } else if (str2.equals("save_screenshot")) {
            m2661a();
        } else if (str2.equals("social_post") && !C0694a.f2344J) {
            m2666b(hashMap);
        } else if (str2.equals("make_in_app_purchase") && !C0694a.f2344J) {
            m2663a(hashMap);
        }
        m2673f("adc_bridge.nativeCallComplete()");
    }

    void m2663a(HashMap hashMap) {
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        String g = m2675g((String) hashMap.get(AppLovinEventTypes.USER_VIEWED_PRODUCT));
        Integer.parseInt(m2675g((String) hashMap.get("quantity")));
        this.f2620b.finish();
        this.f2621c.f4544I.f2218n = g;
        this.f2621c.f4544I.f2230z = AdColonyIAPEngagement.END_CARD;
        C0694a.f2357W.m2437a(this.f2621c.f4544I);
    }

    void m2666b(HashMap hashMap) {
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g((String) hashMap.get(Method.TEXT));
        String g2 = m2675g((String) hashMap.get(DatabaseOpenHelper.HISTORY_ROW_URL));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", g + " " + g2);
        this.f2620b.startActivity(Intent.createChooser(intent, "Share this post using..."));
    }

    void m2661a() {
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        String str = Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots/" + "AdColony_Screenshot_" + System.currentTimeMillis() + ".jpg";
        View rootView = this.f2619a.getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures");
        File file2 = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots");
        try {
            file.mkdir();
            file2.mkdir();
        } catch (Exception e) {
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(new File(str));
            createBitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            MediaScannerConnection.scanFile(this.f2620b, new String[]{str}, null, new C07282(this));
        } catch (FileNotFoundException e2) {
            Toast.makeText(this.f2620b, "Error saving screenshot.", 0).show();
            C0726l.f2610a.m2653a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
        } catch (IOException e3) {
            Toast.makeText(this.f2620b, "Error saving screenshot.", 0).show();
            C0726l.f2610a.m2653a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
        }
    }

    void m2665b(String str) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandSendADCEvent called with type: ").m2657b((Object) str);
        C0694a.m2448a(str, this.f2621c.f4544I);
    }

    void m2664b() {
        C0726l.f2610a.m2657b((Object) "ADC [info] MRAIDCommandClose called");
        this.f2620b.finish();
        C0694a.f2357W.m2437a(this.f2621c.f4544I);
    }

    void m2667c(String str) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandOpenStore called with item: ").m2657b((Object) str);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        try {
            this.f2620b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(m2675g(str))));
        } catch (Exception e) {
            Toast.makeText(this.f2620b, "Unable to open store.", 0).show();
        }
    }

    void m2669d(String str) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandOpen called with url: ").m2657b((Object) str);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g(str);
        if (g.startsWith("adcvideo")) {
            this.f2621c.m5300a(g.replace("adcvideo", "http"));
        } else if (str.contains("youtube")) {
            try {
                this.f2620b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + g.substring(g.indexOf(118) + 2))));
            } catch (Exception e) {
                g = m2675g(str);
                if (g.contains("safari")) {
                    g = g.replace("safari", "http");
                }
                this.f2620b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(g)));
            }
        } else if (g.startsWith("browser")) {
            C0694a.m2448a("html5_interaction", this.f2621c.f4544I);
            this.f2620b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(g.replace("browser", "http"))));
        } else {
            C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
            AdColonyBrowser.url = g;
            this.f2620b.startActivity(new Intent(this.f2620b, AdColonyBrowser.class));
        }
    }

    void m2671e(String str) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandExpand called with url: ").m2657b((Object) str);
        m2673f("adc_bridge.fireChangeEvent({state:'expanded'});");
    }

    void m2668c(HashMap hashMap) {
        Date parse;
        Date parse2;
        Date date;
        long time;
        long time2;
        long j;
        Intent putExtra;
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandCreateCalendarEvent called with parameters: ").m2657b((Object) hashMap);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ");
        DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        DateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        String g = m2675g((String) hashMap.get("description"));
        m2675g((String) hashMap.get("location"));
        String g2 = m2675g((String) hashMap.get("start"));
        String g3 = m2675g((String) hashMap.get("end"));
        String g4 = m2675g((String) hashMap.get("summary"));
        String g5 = m2675g((String) hashMap.get("recurrence"));
        String str = XMLConstants.NULL_NS_URI;
        String str2 = XMLConstants.NULL_NS_URI;
        HashMap hashMap2 = new HashMap();
        String str3 = XMLConstants.NULL_NS_URI;
        str3 = XMLConstants.NULL_NS_URI;
        String str4 = "}";
        str3 = XMLConstants.NULL_NS_URI;
        String replace = g5.replace("\"", r21).replace("{", r21).replace(replace, r21);
        if (!replace.equals(XMLConstants.NULL_NS_URI)) {
            for (String str5 : replace.split(",")) {
                hashMap2.put(str5.substring(0, str5.indexOf(":")), str5.substring(str5.indexOf(":") + 1, str5.length()));
            }
            str = m2675g((String) hashMap2.get("expires"));
            str2 = m2675g((String) hashMap2.get("frequency")).toUpperCase();
            C0726l.f2610a.m2653a("Calendar Recurrence - ").m2657b((Object) replace);
            C0726l.f2610a.m2653a("Calendar Recurrence - frequency = ").m2657b((Object) str2);
            C0726l.f2610a.m2653a("Calendar Recurrence - expires =  ").m2657b((Object) str);
        }
        g5 = str;
        str = str2;
        if (g4.equals(XMLConstants.NULL_NS_URI)) {
            g4 = m2675g((String) hashMap.get("description"));
        }
        try {
            parse = simpleDateFormat.parse(g2);
            try {
                parse2 = simpleDateFormat.parse(g3);
            } catch (Exception e) {
                parse2 = null;
                if (parse == null) {
                    date = parse;
                } else {
                    try {
                        parse = simpleDateFormat2.parse(g2);
                        parse2 = simpleDateFormat2.parse(g3);
                        date = parse;
                    } catch (Exception e2) {
                        date = parse;
                    }
                }
                parse = simpleDateFormat.parse(g5);
                if (parse == null) {
                    try {
                        parse = simpleDateFormat3.parse(g5);
                    } catch (Exception e3) {
                    }
                }
                if (date == null) {
                    time = date.getTime();
                    time2 = parse2.getTime();
                    j = 0;
                    if (parse != null) {
                        j = (parse.getTime() - date.getTime()) / 1000;
                    }
                    if (!str.equals("DAILY")) {
                        j = (j / 86400) + 1;
                    } else if (!str.equals("WEEKLY")) {
                        j = (j / 604800) + 1;
                    } else if (!str.equals("MONTHLY")) {
                        j = (j / 2629800) + 1;
                    } else if (str.equals("YEARLY")) {
                        j = 0;
                    } else {
                        j = (j / 31557600) + 1;
                    }
                    if (replace.equals(XMLConstants.NULL_NS_URI)) {
                        putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2).putExtra("rrule", "FREQ=" + str + ";" + "COUNT=" + j);
                        C0726l.f2610a.m2653a("Calendar Recurrence - count = ").m2655b((double) j);
                    } else {
                        putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2);
                    }
                    try {
                        this.f2620b.startActivity(putExtra);
                    } catch (Exception e4) {
                        Toast.makeText(this.f2620b, "Unable to create Calendar Event.", 0).show();
                        return;
                    }
                }
                Toast.makeText(this.f2620b, "Unable to create Calendar Event.", 0).show();
                return;
            }
        } catch (Exception e5) {
            parse = null;
            parse2 = null;
            if (parse == null) {
                parse = simpleDateFormat2.parse(g2);
                parse2 = simpleDateFormat2.parse(g3);
                date = parse;
            } else {
                date = parse;
            }
            parse = simpleDateFormat.parse(g5);
            if (parse == null) {
                parse = simpleDateFormat3.parse(g5);
            }
            if (date == null) {
                Toast.makeText(this.f2620b, "Unable to create Calendar Event.", 0).show();
                return;
            }
            time = date.getTime();
            time2 = parse2.getTime();
            j = 0;
            if (parse != null) {
                j = (parse.getTime() - date.getTime()) / 1000;
            }
            if (!str.equals("DAILY")) {
                j = (j / 86400) + 1;
            } else if (!str.equals("WEEKLY")) {
                j = (j / 604800) + 1;
            } else if (!str.equals("MONTHLY")) {
                j = (j / 2629800) + 1;
            } else if (str.equals("YEARLY")) {
                j = (j / 31557600) + 1;
            } else {
                j = 0;
            }
            if (replace.equals(XMLConstants.NULL_NS_URI)) {
                putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2).putExtra("rrule", "FREQ=" + str + ";" + "COUNT=" + j);
                C0726l.f2610a.m2653a("Calendar Recurrence - count = ").m2655b((double) j);
            } else {
                putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2);
            }
            this.f2620b.startActivity(putExtra);
        }
        if (parse == null) {
            parse = simpleDateFormat2.parse(g2);
            parse2 = simpleDateFormat2.parse(g3);
            date = parse;
        } else {
            date = parse;
        }
        try {
            parse = simpleDateFormat.parse(g5);
        } catch (Exception e6) {
            parse = null;
        }
        if (parse == null) {
            parse = simpleDateFormat3.parse(g5);
        }
        if (date == null) {
            Toast.makeText(this.f2620b, "Unable to create Calendar Event.", 0).show();
            return;
        }
        time = date.getTime();
        time2 = parse2.getTime();
        j = 0;
        if (parse != null) {
            j = (parse.getTime() - date.getTime()) / 1000;
        }
        if (!str.equals("DAILY")) {
            j = (j / 86400) + 1;
        } else if (!str.equals("WEEKLY")) {
            j = (j / 604800) + 1;
        } else if (!str.equals("MONTHLY")) {
            j = (j / 2629800) + 1;
        } else if (str.equals("YEARLY")) {
            j = (j / 31557600) + 1;
        } else {
            j = 0;
        }
        if (replace.equals(XMLConstants.NULL_NS_URI)) {
            putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2).putExtra("rrule", "FREQ=" + str + ";" + "COUNT=" + j);
            C0726l.f2610a.m2653a("Calendar Recurrence - count = ").m2655b((double) j);
        } else {
            putExtra = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra(DatabaseOpenHelper.HISTORY_ROW_TITLE, g4).putExtra("description", g).putExtra("beginTime", time).putExtra("endTime", time2);
        }
        this.f2620b.startActivity(putExtra);
    }

    void m2670d(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandMail called with parameters: ").m2657b((Object) hashMap);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g((String) hashMap.get("subject"));
        String g2 = m2675g((String) hashMap.get("body"));
        String g3 = m2675g((String) hashMap.get("to"));
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", g).putExtra("android.intent.extra.TEXT", g2).putExtra("android.intent.extra.EMAIL", new String[]{g3});
            this.f2620b.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.f2620b, "Unable to launch email client.", 0).show();
        }
    }

    void m2672e(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandSMS called with parameters: ").m2657b((Object) hashMap);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g((String) hashMap.get("to"));
        String g2 = m2675g((String) hashMap.get("body"));
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        try {
            this.f2620b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("sms:" + g)).putExtra("sms_body", g2));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.f2620b, "Failed to create sms.", 0).show();
        }
    }

    void m2674f(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandTel called with parameters: ").m2657b((Object) hashMap);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g((String) hashMap.get("number"));
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        try {
            this.f2620b.startActivity(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + g)));
        } catch (Exception e) {
            Toast.makeText(this.f2620b, "Failed to dial number.", 0).show();
        }
    }

    void m2676g(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").m2657b((Object) hashMap);
        String str = "custom_event";
        C0694a.m2450a(str, "{\"event_type\":\"" + m2675g((String) hashMap.get("event_type")) + "\",\"ad_slot\":" + C0694a.f2372l.f2516e.f2970j + "}", this.f2621c.f4544I);
    }

    void m2677h(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").m2657b((Object) hashMap);
        C0694a.f2344J = true;
        this.f2622d.postDelayed(this.f2623e, 1000);
        String g = m2675g((String) hashMap.get("handle"));
        C0694a.m2450a("html5_interaction", this.f2625g, this.f2621c.f4544I);
        try {
            this.f2620b.startActivity(this.f2620b.getPackageManager().getLaunchIntentForPackage(g));
        } catch (Exception e) {
            Toast.makeText(this.f2620b, "Failed to launch external application.", 0).show();
        }
    }

    void m2678i(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").m2657b((Object) hashMap);
        String g = m2675g((String) hashMap.get("handle"));
        m2673f("adc_bridge.fireAppPresenceEvent('" + g + "'," + aa.m2480a(g) + ")");
    }

    void m2679j(HashMap hashMap) {
        C0726l.f2610a.m2653a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").m2657b((Object) hashMap);
    }

    void m2673f(String str) {
        this.f2619a.loadUrl("javascript:" + str);
    }

    String m2675g(String str) {
        if (str == null) {
            return XMLConstants.NULL_NS_URI;
        }
        return URLDecoder.decode(str);
    }
}
