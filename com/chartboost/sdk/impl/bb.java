package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.C0304d.C0303b;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0290e;
import com.chartboost.sdk.Model.CBError.CBClickError;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class bb {
    private static bb f927c;
    private C0358a f928a;
    private C0291a f929b;

    /* renamed from: com.chartboost.sdk.impl.bb.1 */
    class C03571 implements Runnable {
        final /* synthetic */ String f923a;
        final /* synthetic */ Activity f924b;
        final /* synthetic */ C0303b f925c;
        final /* synthetic */ bb f926d;

        /* renamed from: com.chartboost.sdk.impl.bb.1.1 */
        class C03561 implements Runnable {
            final /* synthetic */ String f921a;
            final /* synthetic */ C03571 f922b;

            C03561(C03571 c03571, String str) {
                this.f922b = c03571;
                this.f921a = str;
            }

            public void run() {
                this.f922b.f926d.m940a(this.f921a, this.f922b.f924b, this.f922b.f925c);
            }
        }

        C03571(bb bbVar, String str, Activity activity, C0303b c0303b) {
            this.f926d = bbVar;
            this.f923a = str;
            this.f924b = activity;
            this.f925c = c0303b;
        }

        public void run() {
            String str;
            Throwable th;
            String str2 = this.f923a;
            if (ay.m847a().m855c()) {
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f923a).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        String headerField = httpURLConnection2.getHeaderField("Location");
                        if (headerField != null) {
                            str2 = headerField;
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            str = str2;
                            m936a(str);
                        }
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        try {
                            CBLogging.m382b("CBURLOpener", "Exception raised while opening a HTTP Conection", th);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                str = str2;
                                m936a(str);
                            }
                            str = str2;
                            m936a(str);
                        } catch (Throwable th3) {
                            th = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    th = e2;
                    CBLogging.m382b("CBURLOpener", "Exception raised while opening a HTTP Conection", th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        str = str2;
                        m936a(str);
                    }
                    str = str2;
                    m936a(str);
                }
            }
            str = str2;
            m936a(str);
        }

        public void m936a(String str) {
            Runnable c03561 = new C03561(this, str);
            if (this.f924b != null) {
                this.f924b.runOnUiThread(c03561);
            } else {
                CBUtility.m400e().post(c03561);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bb.a */
    public interface C0358a {
        void m937a(C0291a c0291a, boolean z, String str, CBClickError cBClickError, C0303b c0303b);
    }

    public static bb m938a(C0358a c0358a) {
        if (f927c == null) {
            f927c = new bb(c0358a);
        }
        return f927c;
    }

    private bb(C0358a c0358a) {
        this.f928a = c0358a;
    }

    public void m942a(C0291a c0291a, String str, Activity activity, C0303b c0303b) {
        this.f929b = c0291a;
        try {
            String scheme = new URI(str).getScheme();
            if (scheme == null) {
                if (this.f928a != null) {
                    this.f928a.m937a(c0291a, false, str, CBClickError.URI_INVALID, c0303b);
                }
            } else if (scheme.equals("http") || scheme.equals("https")) {
                ax.m845a().execute(new C03571(this, str, activity, c0303b));
            } else {
                m940a(str, activity, c0303b);
            }
        } catch (URISyntaxException e) {
            if (this.f928a != null) {
                this.f928a.m937a(c0291a, false, str, CBClickError.URI_INVALID, c0303b);
            }
        }
    }

    private void m940a(String str, Context context, C0303b c0303b) {
        String str2;
        if (this.f929b != null && this.f929b.m569a()) {
            this.f929b.f598c = C0290e.NONE;
        }
        if (context == null) {
            context = C0299c.m682y();
        }
        if (context != null) {
            Intent intent;
            try {
                intent = new Intent("android.intent.action.VIEW");
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(Uri.parse(str));
                context.startActivity(intent);
                str2 = str;
            } catch (Exception e) {
                if (str.startsWith("market://")) {
                    try {
                        str = "http://market.android.com/" + str.substring(9);
                        intent = new Intent("android.intent.action.VIEW");
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                        str2 = str;
                    } catch (Throwable e2) {
                        str2 = str;
                        CBLogging.m382b("CBURLOpener", "Exception raised openeing an inavld playstore URL", e2);
                        if (this.f928a != null) {
                            this.f928a.m937a(this.f929b, false, str2, CBClickError.URI_UNRECOGNIZED, c0303b);
                            return;
                        }
                        return;
                    }
                }
                if (this.f928a != null) {
                    this.f928a.m937a(this.f929b, false, str, CBClickError.URI_UNRECOGNIZED, c0303b);
                }
                str2 = str;
            }
            if (this.f928a != null) {
                this.f928a.m937a(this.f929b, true, str2, null, c0303b);
            }
        } else if (this.f928a != null) {
            this.f928a.m937a(this.f929b, false, str, CBClickError.NO_HOST_ACTIVITY, c0303b);
        }
    }

    public static boolean m941a(String str) {
        try {
            Context y = C0299c.m682y();
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(y instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            if (y.getPackageManager().queryIntentActivities(intent, AccessibilityNodeInfoCompat.ACTION_CUT).size() > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            CBLogging.m382b("CBURLOpener", "Cannot open URL", e);
            return false;
        }
    }
}
