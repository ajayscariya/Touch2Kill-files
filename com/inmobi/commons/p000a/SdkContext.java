package com.inmobi.commons.p000a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.core.utilities.FileUtils;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.commons.a.a */
public final class SdkContext {
    private static final String f1516a;
    private static Context f1517b;
    private static String f1518c;
    private static String f1519d;
    private static AtomicBoolean f1520e;

    /* renamed from: com.inmobi.commons.a.a.1 */
    static class SdkContext implements Runnable {
        final /* synthetic */ Context f1515a;

        SdkContext(Context context) {
            this.f1515a = context;
        }

        public void run() {
            SdkContext.f1518c = new WebView(this.f1515a).getSettings().getUserAgentString();
        }
    }

    static {
        f1516a = SdkContext.class.getSimpleName();
        f1518c = XMLConstants.NULL_NS_URI;
        f1519d = XMLConstants.NULL_NS_URI;
        f1520e = new AtomicBoolean();
    }

    public static void m1558a(Context context, String str) {
        if (!SdkContext.m1561a()) {
            f1517b = context.getApplicationContext();
            f1519d = str;
            f1520e.set(true);
            SdkContext.m1563b(context);
            SdkContext.m1565c(context);
        }
    }

    public static boolean m1561a() {
        return f1517b != null;
    }

    public static Context m1562b() {
        return f1517b;
    }

    public static String m1564c() {
        return f1519d;
    }

    public static String m1566d() {
        return f1518c;
    }

    public static boolean m1567e() {
        return f1520e.get();
    }

    public static void m1560a(boolean z) {
        f1520e.set(z);
    }

    public static File m1556a(Context context) {
        return new File(context.getCacheDir(), "im_cached_content");
    }

    public static void m1559a(File file, String str) {
        if (str == null || str.trim().length() == 0) {
            FileUtils.m1773a(file);
        } else {
            FileUtils.m1773a(new File(file, str));
        }
    }

    private static void m1563b(Context context) {
        if (VERSION.SDK_INT >= 17) {
            f1518c = SdkContext.m1568f();
        } else {
            new Handler(context.getMainLooper()).post(new SdkContext(context));
        }
    }

    private static void m1565c(Context context) {
        File a = SdkContext.m1556a(context);
        SdkContext.m1559a(a, null);
        if (!a.mkdir() && !a.isDirectory()) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1516a, "Cannot create media cache directory");
        }
    }

    @TargetApi(17)
    private static String m1568f() {
        return WebSettings.getDefaultUserAgent(SdkContext.m1562b());
    }
}
