package com.startapp.android.publish.p022h;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.android.publish.Ad.AdType;
import com.startapp.android.publish.OverlayActivity;
import com.startapp.android.publish.model.AdDetails;
import com.startapp.android.publish.model.AdPreferences;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import com.startapp.android.publish.model.NameValueObject;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.XMLEntityManager;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import mf.org.w3c.dom.traversal.NodeFilter;
import org.json.JSONObject;

/* renamed from: com.startapp.android.publish.h.v */
public class StartAppSDK {
    public static final byte[] f3368a;
    private static Map<Activity, Integer> f3369b;
    private static ThreadPoolExecutor f3370c;
    private static ProgressDialog f3371d;
    private static boolean f3372e;

    /* renamed from: com.startapp.android.publish.h.v.1 */
    static class StartAppSDK implements Runnable {
        final /* synthetic */ Context f3348a;
        final /* synthetic */ String f3349b;
        final /* synthetic */ StartAppSDK f3350c;

        StartAppSDK(Context context, String str, StartAppSDK startAppSDK) {
            this.f3348a = context;
            this.f3349b = str;
            this.f3350c = startAppSDK;
        }

        public void run() {
            try {
                com.startapp.android.publish.p021g.StartAppSDK.m3146a(this.f3348a, this.f3349b + this.f3350c.m3269c() + StartAppSDK.m3193a(StartAppSDK.m3331b(this.f3349b)), null);
            } catch (Throwable e) {
                StartAppSDK.m3231a(6, "Error sending tracking message", e);
            }
        }
    }

    /* renamed from: com.startapp.android.publish.h.v.2 */
    static class StartAppSDK implements Runnable {
        final /* synthetic */ Context f3351a;
        final /* synthetic */ String f3352b;

        StartAppSDK(Context context, String str) {
            this.f3351a = context;
            this.f3352b = str;
        }

        public void run() {
            try {
                com.startapp.android.publish.p021g.StartAppSDK.m3146a(this.f3351a, this.f3352b, null);
            } catch (Throwable e) {
                StartAppSDK.m3231a(6, "Error sending tracking message", e);
            }
        }
    }

    /* renamed from: com.startapp.android.publish.h.v.3 */
    static class StartAppSDK implements OnCancelListener {
        final /* synthetic */ WebView f3353a;

        StartAppSDK(WebView webView) {
            this.f3353a = webView;
        }

        public void onCancel(DialogInterface dialog) {
            this.f3353a.stopLoading();
        }
    }

    /* renamed from: com.startapp.android.publish.h.v.a */
    private static class StartAppSDK extends WebViewClient {
        private String f3355a;
        private String f3356b;
        private boolean f3357c;
        private boolean f3358d;
        private long f3359e;
        private boolean f3360f;
        private String f3361g;
        private ProgressDialog f3362h;
        private Runnable f3363i;
        private boolean f3364j;
        private boolean f3365k;
        private List<String> f3366l;
        private Context f3367m;

        /* renamed from: com.startapp.android.publish.h.v.a.1 */
        class StartAppSDK implements Runnable {
            final /* synthetic */ StartAppSDK f3354a;

            StartAppSDK(StartAppSDK startAppSDK) {
                this.f3354a = startAppSDK;
            }

            public void run() {
                try {
                    Thread.sleep(this.f3354a.f3359e);
                } catch (InterruptedException e) {
                }
                if (!this.f3354a.f3357c) {
                    if (this.f3354a.f3365k) {
                        com.startapp.android.publish.p010d.StartAppSDK.m3033a(this.f3354a.f3367m, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.FAILED_SMART_REDIRECT, "Timeout - Page Finished", this.f3354a.f3355a, this.f3354a.f3356b);
                    } else {
                        com.startapp.android.publish.p010d.StartAppSDK.m3033a(this.f3354a.f3367m, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.FAILED_SMART_REDIRECT, "Timeout", this.f3354a.f3355a, this.f3354a.f3356b);
                    }
                    this.f3354a.f3364j = true;
                    StartAppSDK.m3339c(this.f3354a.f3367m);
                    if (this.f3354a.f3360f && MetaData.getInstance().isInAppBrowser()) {
                        StartAppSDK.m3334b(this.f3354a.f3367m, this.f3354a.f3355a, this.f3354a.f3356b);
                    } else {
                        StartAppSDK.m3302a(this.f3354a.f3367m, this.f3354a.f3355a, this.f3354a.f3356b);
                    }
                    if (this.f3354a.f3363i != null) {
                        this.f3354a.f3363i.run();
                    }
                }
            }
        }

        public StartAppSDK(Context context, long j, boolean z, ProgressDialog progressDialog, String str, String str2, String str3, Runnable runnable) {
            this.f3355a = XMLConstants.NULL_NS_URI;
            this.f3357c = false;
            this.f3358d = false;
            this.f3360f = true;
            this.f3364j = false;
            this.f3365k = false;
            this.f3366l = new ArrayList();
            this.f3367m = context;
            this.f3359e = j;
            this.f3360f = z;
            this.f3362h = progressDialog;
            this.f3355a = str;
            this.f3361g = str2;
            this.f3356b = str3;
            this.f3363i = runnable;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            StartAppSDK.m3230a(2, "MyWebViewClientSmartRedirect::onPageStarted - [" + url + "]");
            super.onPageStarted(view, url, favicon);
            if (!this.f3358d) {
                m3279a();
                this.f3358d = true;
            }
            this.f3365k = false;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            StartAppSDK.m3230a(2, "MyWebViewClientSmartRedirect::shouldOverrideUrlLoading - [" + url + "]");
            try {
                this.f3355a = url;
                this.f3366l.add(this.f3355a);
                if (!StartAppSDK.m3354g(url.toLowerCase())) {
                    return false;
                }
                if (this.f3364j) {
                    return true;
                }
                this.f3357c = true;
                StartAppSDK.m3339c(this.f3367m);
                StartAppSDK.m3340c(this.f3367m, url);
                if (this.f3361g != null && !this.f3361g.equals(XMLConstants.NULL_NS_URI) && !this.f3355a.toLowerCase().contains(this.f3361g.toLowerCase())) {
                    com.startapp.android.publish.p010d.StartAppSDK.m3033a(this.f3367m, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.WRONG_PACKAGE_REACHED, "Wrong package name reached", "Expected: " + this.f3361g + " Link: " + this.f3355a, this.f3356b);
                } else if (Math.random() * 100.0d < ((double) MetaData.getInstance().getAnalyticsConfig().m3018e())) {
                    com.startapp.android.publish.p010d.StartAppSDK.m3033a(this.f3367m, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.SUCCEEDED_SMART_REDIRECT, "Smart redirect succeeded", this.f3366l.toString(), this.f3356b);
                }
                if (this.f3363i == null) {
                    return true;
                }
                this.f3363i.run();
                return true;
            } catch (Exception e) {
                StartAppSDK.m3230a(6, "StartAppWall.UtilExcpetion - view to attached to window - Load Progress");
                return true;
            }
        }

        public void onPageFinished(WebView view, String url) {
            StartAppSDK.m3230a(2, "MyWebViewClientSmartRedirect::onPageFinished - [" + url + "]");
            if (!(this.f3357c || this.f3364j || !this.f3355a.equals(url) || url == null || StartAppSDK.m3354g(url) || (!url.startsWith("http://") && !url.startsWith("https://")))) {
                this.f3365k = true;
            }
            super.onPageFinished(view, url);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            StartAppSDK.m3230a(2, "MyWebViewClientSmartRedirect::onReceivedError - [" + description + "], [" + failingUrl + "]");
            if (!(failingUrl == null || StartAppSDK.m3354g(failingUrl) || (!failingUrl.startsWith("http://") && !failingUrl.startsWith("https://")))) {
                com.startapp.android.publish.p010d.StartAppSDK.m3033a(this.f3367m, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.FAILED_SMART_REDIRECT, Integer.toString(errorCode), failingUrl, this.f3356b);
            }
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        private void m3279a() {
            new Thread(new StartAppSDK(this)).start();
        }
    }

    static {
        f3368a = new byte[]{(byte) 12, (byte) 31, (byte) 86, (byte) 96, (byte) 103, (byte) 10, (byte) 28, (byte) 15, (byte) 17, (byte) 28, (byte) 36, (byte) 84, (byte) 64, (byte) 82, (byte) 84, (byte) 64, (byte) 80, (byte) 80, (byte) 69, (byte) 78, (byte) 67, (byte) 82, (byte) 89, (byte) 80, (byte) 84, (byte) 73, (byte) 79, (byte) 78, (byte) 75, (byte) 69, (byte) 89, (byte) 4, (byte) 32, (byte) 18, (byte) 16, (byte) 18, (byte) 11, (byte) 53, (byte) 45, (byte) 34};
        f3369b = new WeakHashMap();
        f3370c = new ThreadPoolExecutor(1, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        f3372e = false;
    }

    public static String m3293a() {
        String str = "3.2.2";
        if (str.equals("${project.version}")) {
            str = SchemaSymbols.ATTVAL_FALSE_0;
        }
        str = str + StartAppSDK.m3349f();
        StartAppSDK.m3230a(3, "SDK version: [" + str + "]");
        return str;
    }

    private static String m3349f() {
        if (StartAppSDK.m3335b()) {
            return "_Unity";
        }
        if (StartAppSDK.m3358i()) {
            return "_Cordova";
        }
        if (StartAppSDK.m3353g()) {
            return "_AdMob";
        }
        if (StartAppSDK.m3355h()) {
            return "_MoPub";
        }
        if (StartAppSDK.m3360j()) {
            return "_B4A";
        }
        return XMLConstants.NULL_NS_URI;
    }

    private static boolean m3353g() {
        return StartAppSDK.m3348e("com.startapp.android.mediation.admob.StartAppCustomEvent");
    }

    private static boolean m3355h() {
        return StartAppSDK.m3348e("com.mopub.mobileads.StartAppCustomEventInterstitial");
    }

    public static boolean m3335b() {
        return com.startapp.android.publish.StartAppSDK.m3103a().m3130h() != null;
    }

    private static boolean m3358i() {
        return StartAppSDK.m3348e("org.apache.cordova.CordovaPlugin");
    }

    private static boolean m3360j() {
        return StartAppSDK.m3348e("anywheresoftware.b4a.BA");
    }

    private static boolean m3348e(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean m3321a(Activity activity) {
        boolean z = activity.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        if ((activity.getWindow().getAttributes().flags & NodeFilter.SHOW_DOCUMENT_FRAGMENT) != 0) {
            return true;
        }
        return z;
    }

    public static String m3294a(Context context, String str) {
        try {
            return context.getResources().getString(context.getApplicationInfo().labelRes);
        } catch (NotFoundException e) {
            CharSequence applicationLabel;
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            } catch (NameNotFoundException e2) {
            }
            if (applicationInfo != null) {
                applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            } else {
                Object obj = str;
            }
            return (String) applicationLabel;
        }
    }

    public static boolean m3322a(Context context) {
        if (com.startapp.android.publish.StartAppSDK.OVERRIDE_HOST != null || com.startapp.android.publish.StartAppSDK.OVERRIDE_NETWORK.booleanValue()) {
            return true;
        }
        if (StartAppSDK.m3181a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static void m3310a(Editor editor) {
        StartAppSDK.m3168a(editor);
    }

    public static String m3296a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(str3, str2.length() + indexOf);
        if (indexOf2 != -1) {
            return str.substring(str2.length() + indexOf, indexOf2);
        }
        return null;
    }

    public static void m3317a(List<NameValueObject> list, String str, Object obj, boolean z) {
        StartAppSDK.m3318a((List) list, str, obj, z, true);
    }

    public static void m3318a(List<NameValueObject> list, String str, Object obj, boolean z, boolean z2) {
        if (z && obj == null) {
            throw new StartAppSDK("Required key: [" + str + "] is missing", null);
        } else if (obj != null && !obj.toString().equals(XMLConstants.NULL_NS_URI)) {
            try {
                NameValueObject nameValueObject = new NameValueObject();
                nameValueObject.setName(str);
                String obj2 = obj.toString();
                if (z2) {
                    obj2 = URLEncoder.encode(obj2, Defaults.Encoding);
                }
                nameValueObject.setValue(obj2);
                list.add(nameValueObject);
            } catch (Throwable e) {
                if (z) {
                    throw new StartAppSDK("failed encoding value: [" + obj + "]", e);
                }
            }
        }
    }

    public static void m3319a(List<NameValueObject> list, String str, Set<String> set, boolean z) {
        if (z && set == null) {
            throw new StartAppSDK("Required key: [" + str + "] is missing", null);
        } else if (set != null) {
            NameValueObject nameValueObject = new NameValueObject();
            nameValueObject.setName(str);
            Set hashSet = new HashSet();
            for (String encode : set) {
                try {
                    hashSet.add(URLEncoder.encode(encode, Defaults.Encoding));
                } catch (UnsupportedEncodingException e) {
                }
            }
            if (z && hashSet.size() == 0) {
                throw new StartAppSDK("failed encoding value: [" + set + "]", null);
            }
            nameValueObject.setValueSet(hashSet);
            list.add(nameValueObject);
        }
    }

    public static String m3329b(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return "landscape";
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            return "portrait";
        }
        return "undefined";
    }

    public static int m3288a(Activity activity, int i, boolean z) {
        if (z) {
            if (!f3369b.containsKey(activity)) {
                f3369b.put(activity, Integer.valueOf(activity.getRequestedOrientation()));
            }
            if (i == activity.getResources().getConfiguration().orientation) {
                return StartAppSDK.m3161a(activity, i, false);
            }
            return StartAppSDK.m3161a(activity, i, true);
        } else if (!f3369b.containsKey(activity)) {
            return -1;
        } else {
            int intValue = ((Integer) f3369b.get(activity)).intValue();
            activity.setRequestedOrientation(intValue);
            f3369b.remove(activity);
            return intValue;
        }
    }

    public static void m3298a(Activity activity, boolean z) {
        StartAppSDK.m3288a(activity, activity.getResources().getConfiguration().orientation, z);
    }

    public static int m3290a(String str) {
        String[] split = str.split("&");
        return Integer.parseInt(split[split.length - 1].split("=")[1]);
    }

    public static void m3320a(List<com.startapp.android.publish.StartAppSDK> list, List<String> list2) {
        StartAppSDK.m3230a(3, "in getAppPresenceDParameter()");
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (com.startapp.android.publish.StartAppSDK startAppSDK : list) {
            if (!startAppSDK.m3011c()) {
                String f = StartAppSDK.m3351f(startAppSDK.m3006a());
                if (startAppSDK.m3012d()) {
                    arrayList.add("d=" + f);
                } else {
                    arrayList2.add("d=" + f);
                }
            }
        }
        StartAppSDK.m3230a(3, "appPresence tracking size = " + arrayList.size() + " normal size = " + arrayList2.size());
        if (!arrayList.isEmpty()) {
            list2.addAll(StartAppSDK.m3297a(arrayList, SchemaSymbols.ATTVAL_FALSE, SchemaSymbols.ATTVAL_TRUE));
        }
        if (!arrayList2.isEmpty()) {
            list2.addAll(StartAppSDK.m3297a(arrayList2, SchemaSymbols.ATTVAL_FALSE, SchemaSymbols.ATTVAL_FALSE));
        }
    }

    private static String m3351f(String str) {
        return str.split("tracking/adImpression[?]d=")[1];
    }

    private static List<String> m3297a(List<String> list, String str, String str2) {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i += 5) {
            arrayList.add(com.startapp.android.publish.StartAppSDK.f3201f + "?" + TextUtils.join("&", list.subList(i, Math.min(i + 5, list.size()))) + "&isShown=" + str + (str2 != null ? "&appPresence=" + str2 : XMLConstants.NULL_NS_URI));
        }
        StartAppSDK.m3230a(3, "newUrlList size = " + arrayList.size());
        return arrayList;
    }

    public static void m3309a(Context context, String[] strArr, String str, String str2) {
        StartAppSDK.m3308a(context, strArr, str, 0, str2);
    }

    public static void m3308a(Context context, String[] strArr, String str, int i, String str2) {
        StartAppSDK.m3307a(context, strArr, new StartAppSDK(str).m3266a(i).m3267a(str2));
    }

    public static void m3301a(Context context, String str, StartAppSDK startAppSDK) {
        if (str != null && !str.equalsIgnoreCase(XMLConstants.NULL_NS_URI)) {
            StartAppSDK.m3230a(3, "Sending Impression: [" + str + "]");
            StartAppSDK.m3341c(context, str, startAppSDK);
        }
    }

    public static void m3307a(Context context, String[] strArr, StartAppSDK startAppSDK) {
        if (strArr != null) {
            for (String a : strArr) {
                StartAppSDK.m3301a(context, a, startAppSDK);
            }
        }
    }

    public static final void m3303a(Context context, String str, String str2, StartAppSDK startAppSDK, boolean z) {
        if (!(str2 == null || str2.equals(XMLConstants.NULL_NS_URI))) {
            StartAppSDK.m3333b(context, str2, startAppSDK);
        }
        com.startapp.android.publish.StartAppSDK.m3103a().m3119b();
        String a = StartAppSDK.m3295a(str, str2);
        String str3 = "InAppBrowser";
        try {
            if (MetaData.getInstance().isInAppBrowser() && z) {
                StartAppSDK.m3334b(context, str, a);
                return;
            }
            str3 = "externalBrowser";
            StartAppSDK.m3340c(context, str);
        } catch (Exception e) {
            com.startapp.android.publish.p010d.StartAppSDK.m3033a(context, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.EXCEPTION, "Util.clickWithoutSmartRedirect(): Couldn't start activity for " + str3, e.getMessage(), a);
            StartAppSDK.m3230a(6, "Cannot start activity to handle url: [" + str + "]");
        }
    }

    public static final void m3305a(Context context, String str, String str2, String str3, StartAppSDK startAppSDK, long j, boolean z) {
        StartAppSDK.m3306a(context, str, str2, str3, startAppSDK, j, z, null);
    }

    public static final void m3306a(Context context, String str, String str2, String str3, StartAppSDK startAppSDK, long j, boolean z, Runnable runnable) {
        com.startapp.android.publish.StartAppSDK.m3103a().m3119b();
        String a = StartAppSDK.m3295a(str, str2);
        if (!(str2 == null || str2.equals(XMLConstants.NULL_NS_URI))) {
            StartAppSDK.m3333b(context, str2, startAppSDK);
        }
        StartAppSDK.m3304a(context, str + (MetaData.getInstance().isDisableTwoClicks() ? StartAppSDK.m3193a(a) : XMLConstants.NULL_NS_URI), str3, a, j, z, runnable);
    }

    public static void m3333b(Context context, String str, StartAppSDK startAppSDK) {
        StartAppSDK.m3341c(context, str, startAppSDK);
    }

    private static void m3341c(Context context, String str, StartAppSDK startAppSDK) {
        if (!str.equals(XMLConstants.NULL_NS_URI)) {
            f3370c.execute(new StartAppSDK(context, str, startAppSDK));
        }
    }

    public static void m3332b(Context context, String str) {
        f3370c.execute(new StartAppSDK(context, str));
    }

    private static final void m3304a(Context context, String str, String str2, String str3, long j, boolean z, Runnable runnable) {
        StartAppSDK.m3219a(context).m3224a(new Intent("com.startapp.android.OnClickCallback"));
        if (StartAppSDK.m3354g(str)) {
            if (!(str2 == null || str2.equals(XMLConstants.NULL_NS_URI) || str.toLowerCase().contains(str2.toLowerCase()))) {
                com.startapp.android.publish.p010d.StartAppSDK.m3033a(context, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.WRONG_PACKAGE_REACHED, "Wrong package name reached", "Expected: " + str2 + " Link: " + str, str3);
            }
            StartAppSDK.m3302a(context, str, str3);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            StartAppSDK.m3298a((Activity) context, true);
        }
        WebView webView = new WebView(context);
        if (f3371d == null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            f3371d = ProgressDialog.show(context, null, "Loading....", false, false, new StartAppSDK(webView));
            f3371d.setCancelable(false);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new StartAppSDK(context, j, z, f3371d, str, str2, str3, runnable));
        webView.loadUrl(str);
    }

    private static boolean m3354g(String str) {
        return str.startsWith("market") || str.startsWith("http://play.google.com") || str.startsWith("https://play.google.com");
    }

    public static final void m3339c(Context context) {
        if (context != null && (context instanceof Activity)) {
            StartAppSDK.m3298a((Activity) context, false);
        }
        StartAppSDK.m3338c();
    }

    public static final void m3338c() {
        StartAppSDK.m3361k();
    }

    private static void m3361k() {
        if (f3371d != null) {
            synchronized (f3371d) {
                if (f3371d != null && f3371d.isShowing()) {
                    try {
                        f3371d.cancel();
                    } catch (Throwable e) {
                        StartAppSDK.m3231a(6, "Error while cancelling progress", e);
                    }
                    f3371d = null;
                }
            }
        }
    }

    public static void m3340c(Context context, String str) {
        StartAppSDK.m3302a(context, str, null);
    }

    public static void m3302a(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(76021760);
        if (MetaData.getInstance().isDisableInAppStore() || !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        StartAppSDK.m3299a(context, intent);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            com.startapp.android.publish.p010d.StartAppSDK.m3033a(context, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.EXCEPTION, "Util.openUrlExternally(): Couldn't start activity", e.getMessage(), str2);
            StartAppSDK.m3230a(6, "Cannot find activity to handle url: [" + str + "]");
        }
    }

    public static void m3334b(Context context, String str, String str2) {
        if (StartAppSDK.m3354g(str)) {
            StartAppSDK.m3302a(context, str, str2);
        }
        Intent intent = new Intent(context, OverlayActivity.class);
        intent.addFlags(AccessibilityNodeInfoCompat.ACTION_COLLAPSE);
        intent.setData(Uri.parse(str));
        intent.putExtra("placement", Placement.INAPP_BROWSER);
        intent.putExtra("activityShouldLockOrientation", false);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            com.startapp.android.publish.p010d.StartAppSDK.m3033a(context, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.EXCEPTION, "Util.OpenAsInAppBrowser(): Couldn't start activity", e.getMessage(), str2);
            StartAppSDK.m3230a(6, "Cannot find activity to handle url: [" + str + "]");
        }
    }

    public static void m3300a(Context context, AdPreferences adPreferences) {
        String a = StartAppSDK.m3211a(context, "shared_prefs_devId", null);
        String a2 = StartAppSDK.m3211a(context, "shared_prefs_appId", null);
        if (adPreferences.getPublisherId() == null) {
            adPreferences.setPublisherId(a);
        }
        if (adPreferences.getProductId() == null) {
            if (a2 == null) {
                adPreferences.setProductId(a2);
            } else {
                adPreferences.setProductId(a2);
            }
        }
        if (adPreferences.getProductId() == null && !f3372e) {
            f3372e = true;
            Log.e("StartApp", "Integration Error - App ID is missing");
        }
    }

    public static void m3342c(Context context, String str, String str2) {
        if (str != null) {
            StartAppSDK.m3216b(context, "shared_prefs_devId", str.trim());
        } else {
            StartAppSDK.m3216b(context, "shared_prefs_devId", null);
        }
        StartAppSDK.m3216b(context, "shared_prefs_appId", str2.trim());
    }

    public static String m3343d() {
        return "&position=" + StartAppSDK.m3346e();
    }

    public static String m3346e() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i = 0;
        while (i < 8) {
            if (stackTrace[i].getMethodName().compareTo("doHome") == 0) {
                return "home";
            }
            if (stackTrace[i].getMethodName().compareTo("onBackPressed") != 0) {
                i++;
            } else if (!com.startapp.android.publish.StartAppSDK.m3103a().m3127e() && !StartAppSDK.m3335b()) {
                return "interstitial";
            } else {
                com.startapp.android.publish.StartAppSDK.m3103a().m3129g();
                return "back";
            }
        }
        return "interstitial";
    }

    public static void m3311a(WebView webView, String str) {
        try {
            webView.loadDataWithBaseURL("http://www.startappexchange.com", str, "text/html", "utf-8", null);
        } catch (Exception e) {
            StartAppSDK.m3230a(6, "StartAppWall.UtilError while encoding html");
        }
    }

    public static void m3344d(Context context) {
        StartAppSDK.m3216b(context, "shared_prefs_simple_token", StartAppSDK.m3253a(context));
    }

    public static String m3347e(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        if (MetaData.getInstance().getAdInformationConfig().m2831e().m2889a(context)) {
            stringBuffer.append(StartAppSDK.m3211a(context, "shared_prefs_simple_token", XMLConstants.NULL_NS_URI));
        }
        return stringBuffer.toString();
    }

    public static void m3316a(String str, String str2, String str3, Context context, StartAppSDK startAppSDK) {
        StartAppSDK.m3341c(context, str3, startAppSDK);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    launchIntentForPackage.putExtra(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (Throwable e) {
                StartAppSDK.m3231a(6, "Couldn't parse intent details json!", e);
            }
        }
        try {
            context.startActivity(launchIntentForPackage);
        } catch (Exception e2) {
            com.startapp.android.publish.p010d.StartAppSDK.m3033a(context, com.startapp.android.publish.p010d.StartAppSDK.StartAppSDK.EXCEPTION, "Util.handleCPEClick(): Couldn't start activity", e2.getMessage(), StartAppSDK.m3295a(str3, null));
            StartAppSDK.m3230a(6, "Cannot find activity to handle url: [" + str3 + "]");
        }
    }

    public static int m3289a(Context context, int i) {
        return (int) ((context.getResources().getDisplayMetrics().density * ((float) i)) + 0.5f);
    }

    public static String m3350f(Context context) {
        String str = XMLConstants.NULL_NS_URI;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            return str;
        }
        str = resolveActivity.activityInfo.packageName;
        if (str != null) {
            return str.toLowerCase();
        }
        return str;
    }

    public static void m3299a(Context context, Intent intent) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equalsIgnoreCase(com.startapp.android.publish.StartAppSDK.f3203h)) {
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            }
        }
    }

    public static boolean m3324a(AdPreferences adPreferences, String str) {
        return ((Boolean) StartAppSDK.m3292a(adPreferences.getClass(), str, (Object) adPreferences)).booleanValue();
    }

    public static String m3330b(AdPreferences adPreferences, String str) {
        return (String) StartAppSDK.m3292a(adPreferences.getClass(), str, (Object) adPreferences);
    }

    public static AdType m3336c(AdPreferences adPreferences, String str) {
        return (AdType) StartAppSDK.m3292a(adPreferences.getClass(), str, (Object) adPreferences);
    }

    public static void m3314a(AdPreferences adPreferences, String str, boolean z) {
        StartAppSDK.m3315a(adPreferences.getClass(), str, (Object) adPreferences, Boolean.valueOf(z));
    }

    public static void m3313a(AdPreferences adPreferences, String str, AdType adType) {
        StartAppSDK.m3315a(adPreferences.getClass(), str, (Object) adPreferences, (Object) adType);
    }

    private static Object m3292a(Class cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static void m3315a(Class cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public static String m3331b(String str) {
        return StartAppSDK.m3295a(str, null);
    }

    public static String m3295a(String str, String str2) {
        String str3;
        if (str2 == null || str2.equals(XMLConstants.NULL_NS_URI)) {
            str3 = str.split("[?&]d=")[1];
        } else {
            str3 = str2.split("[?&]d=")[1];
        }
        return str3.split("[?&]")[0];
    }

    public static String[] m3327a(com.startapp.android.publish.StartAppSDK startAppSDK) {
        if (startAppSDK instanceof com.startapp.android.publish.p027a.StartAppSDK) {
            return ((com.startapp.android.publish.p027a.StartAppSDK) startAppSDK).getTrackingUrls();
        }
        if (startAppSDK instanceof com.startapp.android.publish.p027a.StartAppSDK) {
            return StartAppSDK.m3328a(((com.startapp.android.publish.p027a.StartAppSDK) startAppSDK).m5373b());
        }
        return new String[0];
    }

    public static String[] m3328a(List<AdDetails> list) {
        List arrayList = new ArrayList();
        if (list != null) {
            for (AdDetails trackingUrl : list) {
                arrayList.add(trackingUrl.getTrackingUrl());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String m3352g(Context context) {
        return context.getPackageManager().getInstallerPackageName(context.getPackageName());
    }

    public static void m3312a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("(");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] instanceof String) {
                        stringBuilder.append("\"").append(objArr[i]).append("\"");
                    } else {
                        stringBuilder.append(objArr[i]);
                    }
                    if (i < objArr.length - 1) {
                        stringBuilder.append(",");
                    }
                }
            }
            stringBuilder.append(")");
            StartAppSDK.m3232a("StartAppWall.Util", 3, "runJavascript: " + stringBuilder.toString());
            webView.loadUrl("javascript:" + stringBuilder.toString());
        }
    }

    public static Class<?> m3291a(Context context, Class<? extends Activity> cls, Class<? extends Activity> cls2) {
        if (StartAppSDK.m3323a(context, (Class) cls) || !StartAppSDK.m3323a(context, (Class) cls2)) {
            return cls;
        }
        Log.w("StartAppWall.Util", "Expected activity " + cls.getName() + " is missing from AndroidManifest.xml");
        return cls2;
    }

    public static boolean m3323a(Context context, Class<? extends Activity> cls) {
        try {
            for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                if (activityInfo.name.equals(cls.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean m3356h(Context context) {
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            int i = 0;
            boolean z = false;
            while (!z) {
                try {
                    if (i >= activityInfoArr.length) {
                        return z;
                    }
                    int i2 = i + 1;
                    ActivityInfo activityInfo = activityInfoArr[i];
                    if (activityInfo.name.equals("com.startapp.android.publish.AppWallActivity") || activityInfo.name.equals("com.startapp.android.publish.OverlayActivity") || activityInfo.name.equals("com.startapp.android.publish.FullScreenActivity")) {
                        if ((activityInfo.flags & XMLEntityManager.DEFAULT_INTERNAL_BUFFER_SIZE) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    i = i2;
                } catch (NameNotFoundException e) {
                    return z;
                }
            }
            return z;
        } catch (NameNotFoundException e2) {
            return false;
        }
    }

    public static String m3357i(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return str;
        }
    }

    public static int m3359j(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    public static String m3337c(String str) {
        int hashCode = f3368a.hashCode();
        long hashCode2 = (long) str.getBytes().hashCode();
        if (((long) hashCode) > hashCode2) {
            hashCode2 = ((hashCode2 * 29509871405L) + 11) & 16777215;
            int i = (int) (hashCode2 >>> 17);
            if (hashCode >= 1000) {
                hashCode = i % hashCode;
            } else if (((long) ((-hashCode) & hashCode)) == hashCode2) {
                hashCode = (int) ((((long) i) * ((long) hashCode)) >> 31);
            } else {
                hashCode = (int) (((((long) i) * ((long) hashCode)) * 2) >> 32);
            }
        }
        try {
            str = StartAppSDK.m3195a(StartAppSDK.m3326a(StartAppSDK.m3326a(str.getBytes(), new String(f3368a).substring(f3368a[5], f3368a[33]).getBytes()), new String(f3368a).substring(f3368a[35], f3368a[1]).getBytes()), 0);
        } catch (Exception e) {
        }
        return str;
    }

    public static byte[] m3326a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    public static byte[] m3325a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[Math.min(bArr.length, i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 % i;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i2]);
        }
        return bArr2;
    }
}
