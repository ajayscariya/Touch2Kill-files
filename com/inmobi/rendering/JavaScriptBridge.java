package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.commons.core.network.AsyncNetworkTask.AsyncNetworkTask;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.NetworkResponse;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.commons.p000a.SdkInfo;
import com.inmobi.rendering.InMobiAdActivity.C0647b;
import com.inmobi.rendering.RenderView.RenderViewState;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.inmobi.rendering.a.AnonymousClass10;
import com.inmobi.rendering.a.AnonymousClass11;
import com.inmobi.rendering.a.AnonymousClass12;
import com.inmobi.rendering.a.AnonymousClass13;
import com.inmobi.rendering.a.AnonymousClass14;
import com.inmobi.rendering.a.AnonymousClass15;
import com.inmobi.rendering.a.AnonymousClass16;
import com.inmobi.rendering.a.AnonymousClass17;
import com.inmobi.rendering.a.AnonymousClass18;
import com.inmobi.rendering.a.AnonymousClass19;
import com.inmobi.rendering.a.AnonymousClass20;
import com.inmobi.rendering.a.AnonymousClass21;
import com.inmobi.rendering.a.AnonymousClass22;
import com.inmobi.rendering.a.AnonymousClass24;
import com.inmobi.rendering.a.AnonymousClass25;
import com.inmobi.rendering.a.AnonymousClass27;
import com.inmobi.rendering.a.AnonymousClass29;
import com.inmobi.rendering.a.AnonymousClass30;
import com.inmobi.rendering.mraid.Dimensions;
import com.inmobi.rendering.mraid.ExpandProperties;
import com.inmobi.rendering.mraid.ImageProcessing;
import com.inmobi.rendering.mraid.MediaPlayerProperties;
import com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType;
import com.inmobi.rendering.mraid.OrientationProperties;
import com.inmobi.rendering.mraid.ResizeProperties;
import com.inmobi.rendering.p005a.ClickManager;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.a */
public class JavaScriptBridge {
    static final String[] f1915a;
    private static final String f1916b;
    private RenderView f1917c;
    private RenderingProperties f1918d;
    private OrientationProperties f1919e;
    private DownloadManager f1920f;
    private BroadcastReceiver f1921g;
    private Context f1922h;

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String f1794a;
        final /* synthetic */ String f1795b;
        final /* synthetic */ JavaScriptBridge f1796c;

        AnonymousClass10(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1796c = javaScriptBridge;
            this.f1794a = str;
            this.f1795b = str2;
        }

        public void run() {
            this.f1796c.f1917c.m1978h(this.f1794a, this.f1795b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String f1797a;
        final /* synthetic */ String f1798b;
        final /* synthetic */ JavaScriptBridge f1799c;

        AnonymousClass11(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1799c = javaScriptBridge;
            this.f1797a = str;
            this.f1798b = str2;
        }

        public void run() {
            this.f1799c.f1917c.m1980i(this.f1797a, this.f1798b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ String f1800a;
        final /* synthetic */ String f1801b;
        final /* synthetic */ JavaScriptBridge f1802c;

        AnonymousClass12(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1802c = javaScriptBridge;
            this.f1800a = str;
            this.f1801b = str2;
        }

        public void run() {
            this.f1802c.f1917c.m1962c("openEmbedded", this.f1800a, this.f1801b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.13 */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String f1803a;
        final /* synthetic */ String f1804b;
        final /* synthetic */ JavaScriptBridge f1805c;

        AnonymousClass13(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1805c = javaScriptBridge;
            this.f1803a = str;
            this.f1804b = str2;
        }

        public void run() {
            this.f1805c.f1917c.m1960c(this.f1803a, this.f1804b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ String f1806a;
        final /* synthetic */ String f1807b;
        final /* synthetic */ JavaScriptBridge f1808c;

        AnonymousClass14(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1808c = javaScriptBridge;
            this.f1806a = str;
            this.f1807b = str2;
        }

        public void run() {
            this.f1808c.f1917c.m1965d(this.f1806a, this.f1807b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.15 */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ String f1809a;
        final /* synthetic */ String f1810b;
        final /* synthetic */ int f1811c;
        final /* synthetic */ JavaScriptBridge f1812d;

        AnonymousClass15(JavaScriptBridge javaScriptBridge, String str, String str2, int i) {
            this.f1812d = javaScriptBridge;
            this.f1809a = str;
            this.f1810b = str2;
            this.f1811c = i;
        }

        public void run() {
            this.f1812d.f1917c.m1955b(this.f1809a, this.f1810b, this.f1811c);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ String f1813a;
        final /* synthetic */ String f1814b;
        final /* synthetic */ String f1815c;
        final /* synthetic */ boolean f1816d;
        final /* synthetic */ boolean f1817e;
        final /* synthetic */ String f1818f;
        final /* synthetic */ String f1819g;
        final /* synthetic */ boolean f1820h;
        final /* synthetic */ JavaScriptBridge f1821i;

        AnonymousClass16(JavaScriptBridge javaScriptBridge, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, boolean z3) {
            this.f1821i = javaScriptBridge;
            this.f1813a = str;
            this.f1814b = str2;
            this.f1815c = str3;
            this.f1816d = z;
            this.f1817e = z2;
            this.f1818f = str4;
            this.f1819g = str5;
            this.f1820h = z3;
        }

        public void run() {
            if ((this.f1813a == null || this.f1813a.trim().length() == 0) && (this.f1814b == null || this.f1814b.trim().length() == 0 || !this.f1814b.startsWith("http"))) {
                this.f1821i.f1917c.m1949a(this.f1815c, "Null or empty or invalid media playback URL supplied", "playVideo");
                return;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Media player properties");
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "shouldAutoPlay: " + this.f1816d + "; shouldLoopPlayback: " + this.f1817e + "; startStyle: " + this.f1818f + "; stopStyle: " + this.f1819g);
            Dimensions dimensions = new Dimensions();
            dimensions.f1956a = 0;
            dimensions.f1957b = 0;
            dimensions.f1958c = 24;
            dimensions.f1959d = 24;
            MediaPlayerProperties mediaPlayerProperties = new MediaPlayerProperties();
            if (this.f1813a == null || this.f1813a.length() != 0) {
                mediaPlayerProperties.f1979a = this.f1813a;
            }
            if (!this.f1821i.f1917c.getMediaProcessor().m2048a()) {
                mediaPlayerProperties.f1982d = this.f1816d;
                mediaPlayerProperties.f1984f = this.f1817e;
                mediaPlayerProperties.f1980b = this.f1818f;
                mediaPlayerProperties.f1981c = this.f1819g;
                mediaPlayerProperties.f1983e = this.f1820h;
            }
            this.f1821i.f1917c.getMediaProcessor().m2041a(dimensions);
            this.f1821i.f1917c.getMediaProcessor().m2042a(mediaPlayerProperties);
            this.f1821i.f1917c.m1948a(this.f1815c, this.f1814b, MediaContentType.MEDIA_CONTENT_TYPE_AUDIO);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ String f1822a;
        final /* synthetic */ String f1823b;
        final /* synthetic */ int f1824c;
        final /* synthetic */ JavaScriptBridge f1825d;

        AnonymousClass17(JavaScriptBridge javaScriptBridge, String str, String str2, int i) {
            this.f1825d = javaScriptBridge;
            this.f1822a = str;
            this.f1823b = str2;
            this.f1824c = i;
        }

        public void run() {
            this.f1825d.f1917c.m1947a(this.f1822a, this.f1823b, this.f1824c);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.18 */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ String f1826a;
        final /* synthetic */ String f1827b;
        final /* synthetic */ JavaScriptBridge f1828c;

        AnonymousClass18(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1828c = javaScriptBridge;
            this.f1826a = str;
            this.f1827b = str2;
        }

        public void run() {
            this.f1828c.f1917c.m1954b(this.f1826a, this.f1827b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.19 */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ String f1829a;
        final /* synthetic */ String f1830b;
        final /* synthetic */ JavaScriptBridge f1831c;

        AnonymousClass19(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1831c = javaScriptBridge;
            this.f1829a = str;
            this.f1830b = str2;
        }

        public void run() {
            this.f1831c.f1917c.m1960c(this.f1829a, this.f1830b);
        }
    }

    /* renamed from: com.inmobi.rendering.a.1 */
    class JavaScriptBridge implements Runnable {
        final /* synthetic */ String f1832a;
        final /* synthetic */ String f1833b;
        final /* synthetic */ JavaScriptBridge f1834c;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1834c = javaScriptBridge;
            this.f1832a = str;
            this.f1833b = str2;
        }

        public void run() {
            this.f1834c.f1917c.m1962c("open", this.f1832a, this.f1833b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.20 */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ String f1835a;
        final /* synthetic */ String f1836b;
        final /* synthetic */ JavaScriptBridge f1837c;

        AnonymousClass20(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1837c = javaScriptBridge;
            this.f1835a = str;
            this.f1836b = str2;
        }

        public void run() {
            this.f1837c.f1917c.m1965d(this.f1835a, this.f1836b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.21 */
    class AnonymousClass21 implements Runnable {
        final /* synthetic */ String f1838a;
        final /* synthetic */ String f1839b;
        final /* synthetic */ int f1840c;
        final /* synthetic */ JavaScriptBridge f1841d;

        AnonymousClass21(JavaScriptBridge javaScriptBridge, String str, String str2, int i) {
            this.f1841d = javaScriptBridge;
            this.f1838a = str;
            this.f1839b = str2;
            this.f1840c = i;
        }

        public void run() {
            this.f1841d.f1917c.m1955b(this.f1838a, this.f1839b, this.f1840c);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.22 */
    class AnonymousClass22 implements Runnable {
        final /* synthetic */ boolean f1842a;
        final /* synthetic */ JavaScriptBridge f1843b;

        AnonymousClass22(JavaScriptBridge javaScriptBridge, boolean z) {
            this.f1843b = javaScriptBridge;
            this.f1842a = z;
        }

        public void run() {
            this.f1843b.f1917c.m1951a(this.f1842a);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.24 */
    class AnonymousClass24 implements Runnable {
        final /* synthetic */ String f1845a;
        final /* synthetic */ JavaScriptBridge f1846b;

        AnonymousClass24(JavaScriptBridge javaScriptBridge, String str) {
            this.f1846b = javaScriptBridge;
            this.f1845a = str;
        }

        public void run() {
            this.f1846b.f1917c.m1969e(this.f1845a);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.25 */
    class AnonymousClass25 implements Runnable {
        final /* synthetic */ String f1847a;
        final /* synthetic */ String f1848b;
        final /* synthetic */ int f1849c;
        final /* synthetic */ JavaScriptBridge f1850d;

        AnonymousClass25(JavaScriptBridge javaScriptBridge, String str, String str2, int i) {
            this.f1850d = javaScriptBridge;
            this.f1847a = str;
            this.f1848b = str2;
            this.f1849c = i;
        }

        public void run() {
            this.f1850d.f1917c.m1961c(this.f1847a, this.f1848b, this.f1849c);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.27 */
    class AnonymousClass27 implements Runnable {
        final /* synthetic */ String f1852a;
        final /* synthetic */ String f1853b;
        final /* synthetic */ JavaScriptBridge f1854c;

        AnonymousClass27(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1854c = javaScriptBridge;
            this.f1852a = str;
            this.f1853b = str2;
        }

        public void run() {
            this.f1854c.f1917c.m1982j(this.f1852a, this.f1853b);
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.29 */
    class AnonymousClass29 implements Runnable {
        final /* synthetic */ boolean f1856a;
        final /* synthetic */ JavaScriptBridge f1857b;

        AnonymousClass29(JavaScriptBridge javaScriptBridge, boolean z) {
            this.f1857b = javaScriptBridge;
            this.f1856a = z;
        }

        public void run() {
            this.f1857b.f1917c.m1957b(this.f1856a);
        }
    }

    /* renamed from: com.inmobi.rendering.a.2 */
    class JavaScriptBridge extends BroadcastReceiver {
        final /* synthetic */ String f1858a;
        final /* synthetic */ JavaScriptBridge f1859b;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str) {
            this.f1859b = javaScriptBridge;
            this.f1858a = str;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("extra_download_id", 0);
                Query query = new Query();
                query.setFilterById(new long[]{longExtra});
                Cursor query2 = this.f1859b.f1920f.query(query);
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex(NotificationCompatApi21.CATEGORY_STATUS);
                    if (16 == query2.getInt(columnIndex)) {
                        this.f1859b.f1917c.m1949a(this.f1858a, "File failed to download", "storePicture");
                    } else if (8 == query2.getInt(columnIndex)) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Download completed");
                    } else if (1 == query2.getInt(columnIndex)) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Download queued");
                    } else if (2 == query2.getInt(columnIndex)) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Download ongoing");
                    }
                }
            }
        }
    }

    /* compiled from: JavaScriptBridge */
    /* renamed from: com.inmobi.rendering.a.30 */
    class AnonymousClass30 implements Runnable {
        final /* synthetic */ String f1860a;
        final /* synthetic */ String f1861b;
        final /* synthetic */ JavaScriptBridge f1862c;

        AnonymousClass30(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1862c = javaScriptBridge;
            this.f1860a = str;
            this.f1861b = str2;
        }

        public void run() {
            this.f1862c.f1917c.m1948a(this.f1860a, this.f1861b, MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO);
        }
    }

    /* renamed from: com.inmobi.rendering.a.6 */
    class JavaScriptBridge implements Runnable {
        final /* synthetic */ String f1864a;
        final /* synthetic */ String f1865b;
        final /* synthetic */ String f1866c;
        final /* synthetic */ String f1867d;
        final /* synthetic */ String f1868e;
        final /* synthetic */ boolean f1869f;
        final /* synthetic */ boolean f1870g;
        final /* synthetic */ String f1871h;
        final /* synthetic */ String f1872i;
        final /* synthetic */ String f1873j;
        final /* synthetic */ String f1874k;
        final /* synthetic */ boolean f1875l;
        final /* synthetic */ boolean f1876m;
        final /* synthetic */ JavaScriptBridge f1877n;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, String str7, String str8, String str9, boolean z3, boolean z4) {
            this.f1877n = javaScriptBridge;
            this.f1864a = str;
            this.f1865b = str2;
            this.f1866c = str3;
            this.f1867d = str4;
            this.f1868e = str5;
            this.f1869f = z;
            this.f1870g = z2;
            this.f1871h = str6;
            this.f1872i = str7;
            this.f1873j = str8;
            this.f1874k = str9;
            this.f1875l = z3;
            this.f1876m = z4;
        }

        public void run() {
            int i = 0;
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "JavaScript called: playVideo (" + this.f1864a + ", " + this.f1865b + ")");
            if ((this.f1865b == null || this.f1865b.trim().length() == 0) && (this.f1864a == null || this.f1864a.trim().length() == 0 || !this.f1864a.startsWith("http"))) {
                this.f1877n.f1917c.m1949a(this.f1866c, "Null or empty or invalid media playback URL supplied", "playVideo");
                return;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Video dimensions: (" + this.f1867d + ", " + this.f1868e + ")");
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "Media player properties");
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "shouldAutoPlay: " + this.f1869f + "; shouldLoopPlayback: " + this.f1870g + "; startStyle: " + this.f1871h + "; stopStyle: " + this.f1872i);
            Dimensions dimensions = new Dimensions();
            MediaPlayerProperties mediaPlayerProperties = new MediaPlayerProperties();
            if (this.f1865b == null || this.f1865b.length() != 0) {
                mediaPlayerProperties.f1979a = this.f1865b;
            }
            int a = JavaScriptBridge.m2014b(this.f1867d);
            int a2 = JavaScriptBridge.m2014b(this.f1868e);
            int a3 = JavaScriptBridge.m2014b(this.f1873j);
            int a4 = JavaScriptBridge.m2014b(this.f1874k);
            if (!(-99999 == a && -99999 == a2) && a > 0 && a2 > 0) {
                float c = DisplayInfo.m1785a().m1801c();
                if (a3 == -99999) {
                    a3 = 0;
                }
                if (a4 != -99999) {
                    i = a4;
                }
                dimensions.f1956a = (int) ((((float) a3) * c) + 0.5f);
                dimensions.f1957b = (int) ((((float) i) * c) + 0.5f);
                dimensions.f1958c = (int) ((((float) a) * c) + 0.5f);
                dimensions.f1959d = (int) ((((float) a2) * c) + 0.5f);
                mediaPlayerProperties.f1980b = this.f1871h;
            } else {
                mediaPlayerProperties.f1980b = "fullscreen";
            }
            if (!this.f1877n.f1917c.getMediaProcessor().m2048a()) {
                mediaPlayerProperties.f1985g = this.f1875l;
                mediaPlayerProperties.f1982d = this.f1869f;
                mediaPlayerProperties.f1984f = this.f1870g;
                mediaPlayerProperties.f1981c = this.f1872i;
                mediaPlayerProperties.f1983e = this.f1876m;
            }
            this.f1877n.f1917c.getMediaProcessor().m2041a(dimensions);
            this.f1877n.f1917c.getMediaProcessor().m2042a(mediaPlayerProperties);
            this.f1877n.f1917c.m1948a(this.f1866c, this.f1864a, MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO);
        }
    }

    /* renamed from: com.inmobi.rendering.a.7 */
    class JavaScriptBridge implements Runnable {
        final /* synthetic */ String f1878a;
        final /* synthetic */ String f1879b;
        final /* synthetic */ int f1880c;
        final /* synthetic */ JavaScriptBridge f1881d;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str, String str2, int i) {
            this.f1881d = javaScriptBridge;
            this.f1878a = str;
            this.f1879b = str2;
            this.f1880c = i;
        }

        public void run() {
            this.f1881d.f1917c.m1947a(this.f1878a, this.f1879b, this.f1880c);
        }
    }

    /* renamed from: com.inmobi.rendering.a.8 */
    class JavaScriptBridge implements Runnable {
        final /* synthetic */ String f1882a;
        final /* synthetic */ String f1883b;
        final /* synthetic */ JavaScriptBridge f1884c;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1884c = javaScriptBridge;
            this.f1882a = str;
            this.f1883b = str2;
        }

        public void run() {
            this.f1884c.f1917c.m1954b(this.f1882a, this.f1883b);
        }
    }

    /* renamed from: com.inmobi.rendering.a.9 */
    class JavaScriptBridge implements Runnable {
        final /* synthetic */ String f1885a;
        final /* synthetic */ String f1886b;
        final /* synthetic */ JavaScriptBridge f1887c;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str, String str2) {
            this.f1887c = javaScriptBridge;
            this.f1885a = str;
            this.f1886b = str2;
        }

        public void run() {
            this.f1887c.f1917c.m1975g(this.f1885a, this.f1886b);
        }
    }

    @TargetApi(16)
    /* renamed from: com.inmobi.rendering.a.a */
    private static class JavaScriptBridge implements OnGlobalLayoutListener {
        private int f1888a;
        private int f1889b;
        private View f1890c;
        private final Boolean f1891d;

        JavaScriptBridge(View view) {
            this.f1891d = Boolean.valueOf(false);
            this.f1890c = view;
        }

        public void onGlobalLayout() {
            this.f1888a = DisplayInfo.m1784a(this.f1890c.getWidth());
            this.f1889b = DisplayInfo.m1784a(this.f1890c.getHeight());
            if (VERSION.SDK_INT >= 16) {
                this.f1890c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.f1890c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            synchronized (this.f1891d) {
                this.f1891d.notify();
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.3 */
    class JavaScriptBridge implements C0647b {
        final /* synthetic */ Uri f4454a;
        final /* synthetic */ String f4455b;
        final /* synthetic */ JavaScriptBridge f4456c;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, Uri uri, String str) {
            this.f4456c = javaScriptBridge;
            this.f4454a = uri;
            this.f4455b = str;
        }

        public void m5164a(int i, Intent intent) {
            if (i == -1) {
                String a;
                if (intent == null || intent.getData() == null) {
                    a = ImageProcessing.m2082a(this.f4454a, this.f4456c.f1922h);
                } else {
                    a = ImageProcessing.m2082a(intent.getData(), this.f4456c.f1922h);
                }
                Bitmap a2 = ImageProcessing.m2080a(a, this.f4456c.f1922h, this.f4456c.f1917c.getRenderingConfig().m1478a(), this.f4456c.f1917c.getRenderingConfig().m1479b());
                int width = a2.getWidth();
                this.f4456c.f1917c.m1946a(this.f4455b, "fireCameraPictureCatpturedEvent('" + ImageProcessing.m2081a(a2, this.f4456c.f1922h, this.f4456c.f1917c.getRenderingConfig().m1480c()) + "'" + "," + "'" + width + "','" + a2.getHeight() + "')");
                return;
            }
            this.f4456c.f1917c.m1949a(this.f4455b, "User did not take a picture", "takeCameraPicture");
        }
    }

    /* renamed from: com.inmobi.rendering.a.4 */
    class JavaScriptBridge implements C0647b {
        final /* synthetic */ String f4457a;
        final /* synthetic */ JavaScriptBridge f4458b;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge, String str) {
            this.f4458b = javaScriptBridge;
            this.f4457a = str;
        }

        public void m5165a(int i, Intent intent) {
            if (i == -1) {
                Bitmap a = ImageProcessing.m2080a(ImageProcessing.m2082a(intent.getData(), this.f4458b.f1922h), this.f4458b.f1922h, this.f4458b.f1917c.getRenderingConfig().m1478a(), this.f4458b.f1917c.getRenderingConfig().m1479b());
                int width = a.getWidth();
                this.f4458b.f1917c.m1946a(this.f4457a, "fireGalleryImageSelectedEvent('" + ImageProcessing.m2081a(a, this.f4458b.f1922h, this.f4458b.f1917c.getRenderingConfig().m1480c()) + "'" + "," + "'" + width + "','" + a.getHeight() + "')");
                return;
            }
            this.f4458b.f1917c.m1949a(this.f4457a, "User did not select an image from gallery", "getGalleryImage");
        }
    }

    /* renamed from: com.inmobi.rendering.a.5 */
    class JavaScriptBridge implements AsyncNetworkTask {
        final /* synthetic */ JavaScriptBridge f4459a;

        JavaScriptBridge(JavaScriptBridge javaScriptBridge) {
            this.f4459a = javaScriptBridge;
        }

        public void m5166a(NetworkResponse networkResponse) {
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "asyncPing Successful");
        }

        public void m5167b(NetworkResponse networkResponse) {
            Logger.m1744a(InternalLogLevel.INTERNAL, JavaScriptBridge.f1916b, "asyncPing Failed");
        }
    }

    static {
        f1916b = JavaScriptBridge.class.getSimpleName();
        f1915a = new String[]{"tel", "sms", "calendar", "storePicture", "inlineVideo"};
    }

    public JavaScriptBridge(RenderView renderView, RenderingProperties renderingProperties) {
        this.f1922h = renderView.getContext();
        this.f1917c = renderView;
        this.f1918d = renderingProperties;
    }

    @JavascriptInterface
    public void open(String str, String str2) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            new Handler(this.f1917c.getContext().getMainLooper()).post(new JavaScriptBridge(this, str, str2));
        }
    }

    @JavascriptInterface
    public void openEmbedded(String str, String str2) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            new Handler(this.f1917c.getContext().getMainLooper()).post(new AnonymousClass12(this, str, str2));
        }
    }

    @JavascriptInterface
    public void ping(String str, String str2, boolean z) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
            this.f1917c.m1949a(str, "Invalid URL:" + str2, "ping");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called ping() URL: >>> " + str2 + " <<<");
            ClickManager.m5176a().m5187a(str2, z);
        }
    }

    @JavascriptInterface
    public void pingInWebView(String str, String str2, boolean z) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
            this.f1917c.m1949a(str, "Invalid URL:" + str2, "pingInWebView");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called pingInWebView() URL: >>> " + str2 + " <<<");
            ClickManager.m5176a().m5189b(str2, z);
        }
    }

    @JavascriptInterface
    public void log(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Log called. Message:" + str2);
    }

    @JavascriptInterface
    public String getPlatformVersion(String str) {
        String num = Integer.toString(VERSION.SDK_INT);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getPlatformVersion. Version:" + num);
        return num;
    }

    @JavascriptInterface
    public String getPlatform(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getPlatform. Platform:" + SdkInfo.m1574d());
        return SdkInfo.m1574d();
    }

    @JavascriptInterface
    public void fireAdReady(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "fireAdReady called.");
        this.f1917c.getListener().m1899a(this.f1917c);
    }

    @JavascriptInterface
    public void fireAdFailed(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "fireAdFailed called.");
        this.f1917c.getListener().m1901b(this.f1917c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.webkit.JavascriptInterface
    public java.lang.String getDefaultPosition(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.f1917c;
        if (r0 != 0) goto L_0x0017;
    L_0x0004:
        r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
        r1 = f1916b;
        r2 = "Found a null instance of render view!";
        com.inmobi.commons.core.utilities.Logger.m1744a(r0, r1, r2);
        r0 = new org.json.JSONObject;
        r0.<init>();
        r0 = r0.toString();
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r3.f1917c;
        r1 = r0.getDefaultPositionMonitor();
        monitor-enter(r1);
        r0 = r3.f1917c;	 Catch:{ all -> 0x004a }
        r0.setDefaultPositionLock();	 Catch:{ all -> 0x004a }
        r0 = r3.f1917c;	 Catch:{ all -> 0x004a }
        r0 = r0.getContext();	 Catch:{ all -> 0x004a }
        r0 = (android.app.Activity) r0;	 Catch:{ all -> 0x004a }
        r2 = new com.inmobi.rendering.a$23;	 Catch:{ all -> 0x004a }
        r2.<init>(r3);	 Catch:{ all -> 0x004a }
        r0.runOnUiThread(r2);	 Catch:{ all -> 0x004a }
    L_0x0033:
        r0 = r3.f1917c;	 Catch:{ all -> 0x004a }
        r0 = r0.m1958b();	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x004d;
    L_0x003b:
        r0 = r3.f1917c;	 Catch:{ InterruptedException -> 0x0045 }
        r0 = r0.getDefaultPositionMonitor();	 Catch:{ InterruptedException -> 0x0045 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0045 }
        goto L_0x0033;
    L_0x0045:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x004a }
        goto L_0x0033;
    L_0x004a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004a }
        throw r0;
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004a }
        r0 = r3.f1917c;
        r0 = r0.getDefaultPosition();
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.rendering.a.getDefaultPosition(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.webkit.JavascriptInterface
    public java.lang.String getCurrentPosition(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.f1917c;
        if (r0 != 0) goto L_0x0010;
    L_0x0004:
        r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL;
        r1 = f1916b;
        r2 = "Found a null instance of render view!";
        com.inmobi.commons.core.utilities.Logger.m1744a(r0, r1, r2);
        r0 = "";
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r3.f1917c;
        r1 = r0.getCurrentPositionMonitor();
        monitor-enter(r1);
        r0 = r3.f1917c;	 Catch:{ all -> 0x0043 }
        r0.setCurrentPositionLock();	 Catch:{ all -> 0x0043 }
        r0 = r3.f1917c;	 Catch:{ all -> 0x0043 }
        r0 = r0.getContext();	 Catch:{ all -> 0x0043 }
        r0 = (android.app.Activity) r0;	 Catch:{ all -> 0x0043 }
        r2 = new com.inmobi.rendering.a$26;	 Catch:{ all -> 0x0043 }
        r2.<init>(r3);	 Catch:{ all -> 0x0043 }
        r0.runOnUiThread(r2);	 Catch:{ all -> 0x0043 }
    L_0x002c:
        r0 = r3.f1917c;	 Catch:{ all -> 0x0043 }
        r0 = r0.m1963c();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0046;
    L_0x0034:
        r0 = r3.f1917c;	 Catch:{ InterruptedException -> 0x003e }
        r0 = r0.getCurrentPositionMonitor();	 Catch:{ InterruptedException -> 0x003e }
        r0.wait();	 Catch:{ InterruptedException -> 0x003e }
        goto L_0x002c;
    L_0x003e:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0043 }
        goto L_0x002c;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        r0 = r3.f1917c;
        r0 = r0.getCurrentPosition();
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.rendering.a.getCurrentPosition(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public void setExpandProperties(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "setExpandProperties called. Params:" + str2);
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (this.f1917c.getState() == RenderViewState.EXPANDED) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "setExpandProperties can't be called on an already expanded ad.");
        } else {
            this.f1917c.setExpandProperties(ExpandProperties.m2076a(str2, this.f1917c.getExpandProperties(), this.f1917c.getOrientationProperties()));
        }
    }

    @JavascriptInterface
    public String getExpandProperties(String str) {
        if (this.f1917c != null) {
            return this.f1917c.getExpandProperties().m2079c();
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return XMLConstants.NULL_NS_URI;
    }

    @JavascriptInterface
    public void expand(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "expand called. Url:" + str2);
        if (this.f1918d.m1989a() == PlacementType.FULL_SCREEN) {
            return;
        }
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (!this.f1917c.m1952a()) {
            this.f1917c.m1949a(str, "Creative is not visible. Ignoring request.", "expand");
        } else if (str2 == null || str2.length() == 0 || str2.startsWith("http")) {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass27(this, str, str2));
        } else {
            this.f1917c.m1949a(str, "Invalid URL", "expand");
        }
    }

    @JavascriptInterface
    public String getVersion(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getVersion called. Version:" + SdkInfo.m1573c());
        return SdkInfo.m1573c();
    }

    @JavascriptInterface
    public void setResizeProperties(String str, String str2) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "setResizeProperties called. Properties:" + str2);
        ResizeProperties a = ResizeProperties.m2137a(str2, this.f1917c.getResizeProperties());
        if (a == null) {
            this.f1917c.m1949a(str, "setResizeProperties", "All mandatory fields are not present");
        }
        this.f1917c.setResizeProperties(a);
    }

    @JavascriptInterface
    public String getResizeProperties(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return XMLConstants.NULL_NS_URI;
        }
        ResizeProperties resizeProperties = this.f1917c.getResizeProperties();
        return resizeProperties == null ? XMLConstants.NULL_NS_URI : resizeProperties.m2138a();
    }

    @JavascriptInterface
    public void resize(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "resize called");
        if (this.f1918d.m1989a() == PlacementType.FULL_SCREEN) {
            return;
        }
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (this.f1917c.m1952a()) {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new Runnable() {
                final /* synthetic */ JavaScriptBridge f1855a;

                {
                    this.f1855a = r1;
                }

                public void run() {
                    this.f1855a.f1917c.m1979i();
                }
            });
        } else {
            this.f1917c.m1949a(str, "Creative is not visible. Ignoring request.", "resize");
        }
    }

    @JavascriptInterface
    public void setOrientationProperties(String str, String str2) {
        this.f1919e = OrientationProperties.m2136a(str2, this.f1917c.getOrientationProperties());
        this.f1917c.setOrientationProperties(this.f1919e);
    }

    @JavascriptInterface
    public String getOrientationProperties(String str) {
        String obj = this.f1919e.toString();
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getOrientationProperties called: " + obj);
        return obj;
    }

    @JavascriptInterface
    public void onOrientationChange(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, ">>> onOrientationChange() >>> This API is deprecated!");
    }

    @JavascriptInterface
    public boolean isViewable(String str) {
        if (this.f1917c != null) {
            return this.f1917c.m1952a();
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return false;
    }

    @JavascriptInterface
    public void useCustomClose(String str, boolean z) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "useCustomClose called:" + z);
        ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass29(this, z));
    }

    @JavascriptInterface
    public void playVideo(String str, String str2) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (str2 == null || str2.trim().length() == 0 || !str2.startsWith("http")) {
            this.f1917c.m1949a(str, "Null or empty or invalid media playback URL supplied", "playVideo");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: playVideo (" + str2 + ")");
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass30(this, str, str2));
        }
    }

    @JavascriptInterface
    public String getState(String str) {
        String toLowerCase = this.f1917c.getState().toString().toLowerCase(Locale.ENGLISH);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getState called:" + toLowerCase);
        return toLowerCase;
    }

    @JavascriptInterface
    public String getScreenSize(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", DisplayInfo.m1785a().m1800b());
            jSONObject.put("height", DisplayInfo.m1785a().m1799a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getScreenSize called:" + jSONObject2);
        return jSONObject2;
    }

    @JavascriptInterface
    public String getMaxSize(String str) {
        Activity activity;
        int i;
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getMaxSize called");
        if (this.f1917c.getFullScreenActivity() == null) {
            activity = (Activity) this.f1917c.getContext();
        } else {
            activity = this.f1917c.getFullScreenActivity();
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        int a = DisplayInfo.m1784a(frameLayout.getWidth());
        int a2 = DisplayInfo.m1784a(frameLayout.getHeight());
        if (this.f1917c.getFullScreenActivity() == null || !(a == 0 || a2 == 0)) {
            i = a2;
            a2 = a;
        } else {
            JavaScriptBridge javaScriptBridge = new JavaScriptBridge(frameLayout);
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(javaScriptBridge);
            synchronized (javaScriptBridge.f1891d) {
                try {
                    javaScriptBridge.f1891d.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a2 = javaScriptBridge.f1888a;
                i = javaScriptBridge.f1889b;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", a2);
            jSONObject.put("height", i);
        } catch (Throwable e2) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1916b, "Error while creating max size Json.", e2);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getMaxSize called:" + jSONObject.toString());
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void close(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "close called");
        ((Activity) this.f1917c.getContext()).runOnUiThread(new Runnable() {
            final /* synthetic */ JavaScriptBridge f1863a;

            {
                this.f1863a = r1;
            }

            public void run() {
                this.f1863a.f1917c.m1981j();
            }
        });
    }

    @JavascriptInterface
    public String getPlacementType(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getPlacementType called");
        if (this.f1918d.m1989a() == PlacementType.FULL_SCREEN) {
            return "interstitial";
        }
        return "inline";
    }

    @JavascriptInterface
    @SuppressLint({"NewApi"})
    public void storePicture(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "storePicture called with URL: " + str2);
        if (!this.f1917c.m1976g("storePicture")) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "storePicture called despite the fact that it is not supported");
        } else if (str2 == null || str2.length() == 0) {
            this.f1917c.m1949a(str, "Null or empty URL supplied", "storePicture");
        } else if (str2.startsWith("http") || str2.startsWith("HTTP")) {
            if (this.f1920f == null) {
                this.f1920f = (DownloadManager) SdkContext.m1562b().getSystemService("download");
            }
            try {
                Uri parse = Uri.parse(str2);
                Request request = new Request(parse);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, parse.getLastPathSegment());
                registerBroadcastListener(str);
                Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Download enqueued with ID: " + this.f1920f.enqueue(request));
            } catch (ParseException e) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Invalid URL provided to storePicture " + e.getMessage());
                this.f1917c.m1949a(str, "Invalid URL", "storePicture");
            }
        } else {
            this.f1917c.m1949a(str, "Invalid URL scheme - only HTTP(S) is supported", "storePicture");
        }
    }

    @JavascriptInterface
    public void createCalendarEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (str3 == null || str3.trim().length() == 0 || str4 == null || str4.trim().length() == 0) {
            this.f1917c.m1949a(str, "Mandatory parameter(s) start and/or end date not supplied", "createCalendarEvent");
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "createCalendarEvent called with parameters: \nevent ID: " + str2 + "; startDate: " + str3 + "; endDate: " + str4 + "; location: " + str5 + "; description: " + str6 + "; summary: " + str7 + "; status: " + str8 + "; transparency: " + str9 + "; recurrence: " + str10 + "; reminder: " + str11);
            this.f1917c.m1950a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
        }
    }

    @SuppressLint({"NewApi"})
    public void registerBroadcastListener(String str) {
        if (this.f1921g == null) {
            this.f1921g = new JavaScriptBridge(this, str);
            SdkContext.m1562b().registerReceiver(this.f1921g, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    @SuppressLint({"NewApi"})
    public void unRegisterBroadcastListener() {
        if (this.f1921g != null) {
            SdkContext.m1562b().unregisterReceiver(this.f1921g);
            this.f1921g = null;
        }
    }

    @JavascriptInterface
    public void makeCall(String str, String str2) {
        if (this.f1917c.m1976g("tel")) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "makeCall: " + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            } else if (!str2.startsWith("tel:")) {
                str2 = "tel:" + str2;
            }
            if (str2 != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.addFlags(268435456);
                this.f1922h.startActivity(intent);
                this.f1917c.getListener().m1907g(this.f1917c);
                return;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "makeCall Unsuccesful: invalid number provided");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "makeCall called even when it is not supported");
    }

    @JavascriptInterface
    public void sendMail(String str, String str2, String str3, String str4) {
        if (this.f1917c.m1976g("sendMail")) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "sendMail recipient: " + str2 + "subject: " + str3 + " message: " + str4);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str2});
            intent.putExtra("android.intent.extra.SUBJECT", str3);
            intent.putExtra("android.intent.extra.TEXT", str4);
            intent.addFlags(268435456);
            this.f1922h.startActivity(Intent.createChooser(intent, "Choose the Email Client."));
            this.f1917c.getListener().m1907g(this.f1917c);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "sendMail called even when it is not supported");
    }

    @JavascriptInterface
    public void sendSMS(String str, String str2, String str3) {
        if (this.f1917c.m1976g("sms")) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "sendSMS recipient: " + str2 + " message: " + str3);
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + Uri.encode(str2)));
            intent.putExtra("sms_body", str3);
            intent.addFlags(268435456);
            this.f1922h.startActivity(intent);
            this.f1917c.getListener().m1907g(this.f1917c);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "sendSMS called even when it is not supported");
    }

    @JavascriptInterface
    public void takeCameraPicture(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "takeCameraPicture called ");
        if (this.f1917c.m1976g("takeCameraPicture")) {
            Object insert = this.f1922h.getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, new ContentValues());
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", insert);
            int a = InMobiAdActivity.m1885a(intent, new JavaScriptBridge(this, insert, str));
            intent = new Intent(this.f1922h, InMobiAdActivity.class);
            intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkedTextViewStyle);
            intent.putExtra("id", a);
            this.f1922h.startActivity(intent);
            this.f1917c.getListener().m1907g(this.f1917c);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "takeCameraPicture called even when it is not supported");
    }

    @JavascriptInterface
    public void getGalleryImage(String str) {
        if (this.f1917c.m1976g("getGalleryImage")) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getGalleryImage called ");
            int a = InMobiAdActivity.m1885a(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), new JavaScriptBridge(this, str));
            Intent intent = new Intent(this.f1922h, InMobiAdActivity.class);
            intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkedTextViewStyle);
            intent.putExtra("id", a);
            this.f1922h.startActivity(intent);
            this.f1917c.getListener().m1907g(this.f1917c);
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getGalleryImage called even when it is not supported");
    }

    @JavascriptInterface
    public void postToSocial(String str, int i, String str2, String str3, String str4) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "postToSocial called with parameters: socialType: " + i + "; text: " + str2 + "; link: " + str3 + "; image URL: " + str4);
        this.f1917c.m1945a(str, i, str2, str3, str4);
    }

    @JavascriptInterface
    public String getSdkVersion(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getSdkVersion called. Version:" + SdkInfo.m1572b());
        return SdkInfo.m1572b();
    }

    @JavascriptInterface
    public String supports(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Checking support for: " + str2);
        if (Arrays.asList(f1915a).contains(str2) || this.f1917c.m1976g(str2)) {
            return String.valueOf(this.f1917c.m1976g(str2));
        }
        return SchemaSymbols.ATTVAL_FALSE;
    }

    @JavascriptInterface
    public void openExternal(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "openExternal called with url: " + str2);
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else if (!str2.startsWith("http") || URLUtil.isValidUrl(str2)) {
            this.f1917c.m1956b("openExternal", str, str2);
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "openExternal called with invalid url (" + str2 + ")");
            this.f1917c.m1949a(str, "Invalid URL", "openExternal");
        }
    }

    @JavascriptInterface
    public void asyncPing(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "asyncPing called: " + str2);
        if (URLUtil.isValidUrl(str2)) {
            NetworkRequest networkRequest = new NetworkRequest(RequestType.GET, str2, false, null);
            networkRequest.m1705a(false);
            new com.inmobi.commons.core.network.AsyncNetworkTask(networkRequest, new JavaScriptBridge(this)).m1726a();
            return;
        }
        this.f1917c.m1949a(str, "Invalid url", "asyncPing");
    }

    @JavascriptInterface
    public void showAlert(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "showAlert: " + str2);
    }

    @JavascriptInterface
    public void playVideo(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Activity activity = (Activity) this.f1917c.getContext();
        r16.runOnUiThread(new JavaScriptBridge(this, str2, str9, str, str5, str6, z2, z4, str7, str8, str4, str3, z, z3));
    }

    @JavascriptInterface
    public void seekVideo(String str, String str2, int i) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: seekVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new JavaScriptBridge(this, str, str2, i));
        }
    }

    @JavascriptInterface
    public void pauseVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: pauseVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new JavaScriptBridge(this, str, str2));
        }
    }

    @JavascriptInterface
    public void closeVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: closeVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new JavaScriptBridge(this, str, str2));
        }
    }

    @JavascriptInterface
    public void hideVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: hideVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass10(this, str, str2));
        }
    }

    @JavascriptInterface
    public void showVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: showVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass11(this, str, str2));
        }
    }

    @JavascriptInterface
    public void muteVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: muteVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass13(this, str, str2));
        }
    }

    @JavascriptInterface
    public void unMuteVideo(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: unMuteVideo (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass14(this, str, str2));
        }
    }

    @JavascriptInterface
    public boolean isVideoMuted(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: isVideoMuted (" + str2 + ")");
        if (this.f1917c != null) {
            return this.f1917c.m1973f(str, str2);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return false;
    }

    @JavascriptInterface
    public void setVideoVolume(String str, String str2, int i) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: setVideoVolume (" + str2 + ", " + i + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass15(this, str, str2, i));
        }
    }

    @JavascriptInterface
    public int getVideoVolume(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: getVideoVolume (" + str2 + ")");
        if (this.f1917c != null) {
            return this.f1917c.m1968e(str, str2);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return 0;
    }

    @JavascriptInterface
    public void playAudio(String str, String str2, boolean z, boolean z2, boolean z3, String str3, String str4, String str5) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: playAudio (" + str2 + ", " + str5 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass16(this, str5, str2, str, z, z3, str3, str4, z2));
    }

    @JavascriptInterface
    public void seekAudio(String str, String str2, int i) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: seekAudio (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass17(this, str, str2, i));
        }
    }

    @JavascriptInterface
    public void pauseAudio(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: pauseAudio (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass18(this, str, str2));
        }
    }

    @JavascriptInterface
    public void muteAudio(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: muteAudio (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass19(this, str, str2));
        }
    }

    @JavascriptInterface
    public void unMuteAudio(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: unMuteAudio (" + str2 + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass20(this, str, str2));
        }
    }

    @JavascriptInterface
    public boolean isAudioMuted(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: isAudioMuted (" + str2 + ")");
        if (this.f1917c != null) {
            return this.f1917c.m1973f(str, str2);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return false;
    }

    @JavascriptInterface
    public void setAudioVolume(String str, String str2, int i) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: setAudioVolume (" + str2 + ", " + i + ")");
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass21(this, str, str2, i));
        }
    }

    @JavascriptInterface
    public int getAudioVolume(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: getAudioVolume (" + str2 + ")");
        if (this.f1917c != null) {
            return this.f1917c.m1968e(str, str2);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return 0;
    }

    @JavascriptInterface
    public double getMicIntensity(String str) {
        if (this.f1917c != null) {
            return this.f1917c.m1985m();
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return Double.MIN_VALUE;
    }

    @JavascriptInterface
    public void disableCloseRegion(String str, boolean z) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass22(this, z));
        }
    }

    @JavascriptInterface
    public void onUserInteraction(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "onUserInteraction called. Params:" + str2);
        if (str2 == null) {
            this.f1917c.getListener().m1902b(this.f1917c, null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                hashMap.put(str3, jSONObject.get(str3));
            }
            this.f1917c.getListener().m1902b(this.f1917c, hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
            this.f1917c.getListener().m1902b(this.f1917c, null);
        }
    }

    @JavascriptInterface
    public void incentCompleted(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "incentCompleted called. IncentData:" + str2);
        if (str2 == null) {
            this.f1917c.getListener().m1900a(this.f1917c, null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                hashMap.put(str3, jSONObject.get(str3));
            }
            this.f1917c.getListener().m1900a(this.f1917c, hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
            this.f1917c.getListener().m1900a(this.f1917c, null);
        }
    }

    @JavascriptInterface
    public void vibrate(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Vibrate called");
        ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass24(this, str));
    }

    @JavascriptInterface
    public void vibrate(String str, String str2, int i) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Vibrate called with pattern " + str2);
        ((Activity) this.f1917c.getContext()).runOnUiThread(new AnonymousClass25(this, str, str2, i));
    }

    @JavascriptInterface
    public String getOrientation(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "getOrientation called");
        int b = DisplayInfo.m1786b();
        if (b == ORIENTATION_VALUES.PORTRAIT.getValue()) {
            return SchemaSymbols.ATTVAL_FALSE_0;
        }
        if (b == ORIENTATION_VALUES.LANDSCAPE.getValue()) {
            return "90";
        }
        if (b == ORIENTATION_VALUES.REVERSE_PORTRAIT.getValue()) {
            return "180";
        }
        if (b == ORIENTATION_VALUES.REVERSE_LANDSCAPE.getValue()) {
            return "270";
        }
        return "-1";
    }

    @JavascriptInterface
    public void saveContent(String str, String str2, String str3) {
        if (str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            String str4;
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "saveContent called with invalid parameters");
            JSONObject jSONObject = new JSONObject();
            try {
                str4 = DatabaseOpenHelper.HISTORY_ROW_URL;
                if (str3 == null) {
                    str3 = XMLConstants.NULL_NS_URI;
                }
                jSONObject.put(str4, str3);
                jSONObject.put("reason", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            str4 = jSONObject.toString().replace("\"", "\\\"");
            StringBuilder append = new StringBuilder().append("sendSaveContentResult(\"saveContent_");
            if (str2 == null) {
                str2 = XMLConstants.NULL_NS_URI;
            }
            this.f1917c.m1946a(str, append.append(str2).append("\", 'failure', \"").append(str4).append("\");").toString());
            return;
        }
        this.f1917c.m1966d(str, str2, str3);
    }

    @JavascriptInterface
    public void cancelSaveContent(String str, String str2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "cancelSaveContent called. mediaId:" + str2);
        this.f1917c.m1971f(str2);
    }

    @JavascriptInterface
    public void registerMicListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Register microphone intensity listener ...");
        this.f1917c.m1964d(str);
    }

    @JavascriptInterface
    public void unregisterMicListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Unregister microphone intensity listener ...");
        this.f1917c.m1986n();
    }

    @JavascriptInterface
    public String isDeviceMuted(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return SchemaSymbols.ATTVAL_FALSE;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: isDeviceMuted()");
        return String.valueOf(this.f1917c.getMediaProcessor().m2059e());
    }

    @JavascriptInterface
    public String isHeadphonePlugged(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return SchemaSymbols.ATTVAL_FALSE;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "JavaScript called: isHeadphonePlugged()");
        return String.valueOf(this.f1917c.getMediaProcessor().m2064h());
    }

    @JavascriptInterface
    public void registerDeviceMuteEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.getMediaProcessor().m2043a(str);
        }
    }

    @JavascriptInterface
    public void unregisterDeviceMuteEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Unregister device mute event listener ...");
        this.f1917c.getMediaProcessor().m2060f();
    }

    @JavascriptInterface
    public void registerDeviceVolumeChangeEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.getMediaProcessor().m2050b(str);
        }
    }

    @JavascriptInterface
    public void unregisterDeviceVolumeChangeEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Unregister device volume change listener ...");
        this.f1917c.getMediaProcessor().m2062g();
    }

    @JavascriptInterface
    public void registerHeadphonePluggedEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.getMediaProcessor().m2054c(str);
        }
    }

    @JavascriptInterface
    public void unregisterHeadphonePluggedEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Unregister headphone plugged event listener ...");
        this.f1917c.getMediaProcessor().m2065i();
    }

    @JavascriptInterface
    public void disableBackButton(String str, boolean z) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.setDisableBackButton(z);
        }
    }

    @JavascriptInterface
    public boolean isBackButtonDisabled(String str) {
        if (this.f1917c != null) {
            return this.f1917c.m1972f();
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        return false;
    }

    @JavascriptInterface
    public void registerBackButtonPressedEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.m1959c(str);
        }
    }

    @JavascriptInterface
    public void unregisterBackButtonPressedEventListener(String str) {
        if (this.f1917c == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1916b, "Found a null instance of render view!");
        } else {
            this.f1917c.m1974g();
        }
    }

    private static int m2014b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -99999;
        }
    }
}
