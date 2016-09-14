package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.mraid.MediaRenderView.MediaRenderView;
import com.wTouch2KiLL.MainNavigationActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mf.org.apache.xerces.impl.XMLEntityManager;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

@SuppressLint({"ClickableViewAccessibility"})
public final class MraidMediaProcessor {
    private static final String f1943a;
    private RenderView f1944b;
    private MediaRenderView f1945c;
    private C0665a f1946d;
    private RingerModeChangeReceiver f1947e;
    private C0666b f1948f;
    private HeadphonesPluggedChangeReceiver f1949g;
    private MediaPlayerProperties f1950h;
    private Dimensions f1951i;
    private boolean f1952j;
    private Hashtable<String, MediaRenderView> f1953k;

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.1 */
    class C06601 implements OnTouchListener {
        final /* synthetic */ MraidMediaProcessor f1923a;

        C06601(MraidMediaProcessor mraidMediaProcessor) {
            this.f1923a = mraidMediaProcessor;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.2 */
    class C06612 implements OnKeyListener {
        final /* synthetic */ MraidMediaProcessor f1924a;

        C06612(MraidMediaProcessor mraidMediaProcessor) {
            this.f1924a = mraidMediaProcessor;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (4 != i || keyEvent.getAction() != 0) {
                return false;
            }
            this.f1924a.f1945c.m2104a(true);
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.4 */
    static /* synthetic */ class C06624 {
        static final /* synthetic */ int[] f1925a;

        static {
            f1925a = new int[MediaRenderView.values().length];
            try {
                f1925a[MediaRenderView.PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1925a[MediaRenderView.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1925a[MediaRenderView.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1925a[MediaRenderView.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final class HeadphonesPluggedChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ MraidMediaProcessor f1926a;
        private String f1927b;

        public HeadphonesPluggedChangeReceiver(MraidMediaProcessor mraidMediaProcessor, String str) {
            this.f1926a = mraidMediaProcessor;
            this.f1927b = str;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            if (intent != null && "android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("state", 0);
                Logger.m1744a(InternalLogLevel.INTERNAL, MraidMediaProcessor.f1943a, "Headphone plugged state changed: " + intExtra);
                MraidMediaProcessor mraidMediaProcessor = this.f1926a;
                String str = this.f1927b;
                if (1 != intExtra) {
                    z = false;
                }
                mraidMediaProcessor.m2035b(str, z);
            }
        }
    }

    public enum MediaContentType {
        MEDIA_CONTENT_TYPE_AUDIO,
        MEDIA_CONTENT_TYPE_AUDIO_VIDEO
    }

    public final class RingerModeChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ MraidMediaProcessor f1928a;
        private String f1929b;

        public RingerModeChangeReceiver(MraidMediaProcessor mraidMediaProcessor, String str) {
            this.f1928a = mraidMediaProcessor;
            this.f1929b = str;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
                Logger.m1744a(InternalLogLevel.INTERNAL, MraidMediaProcessor.f1943a, "Ringer mode action changed: " + intExtra);
                this.f1928a.m2031a(this.f1929b, 2 != intExtra);
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.a */
    public static final class C0665a {
        private static final String f1931a;
        private static final int[] f1932b;
        private static double f1933f;
        private HandlerThread f1934c;
        private C0664b f1935d;
        private AudioRecord f1936e;
        private List<C0663a> f1937g;
        private boolean f1938h;

        /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.a.a */
        public interface C0663a {
            void m2017a(double d);
        }

        /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.a.b */
        static final class C0664b extends Handler {
            private WeakReference<C0665a> f1930a;

            public C0664b(Looper looper, C0665a c0665a) {
                super(looper);
                this.f1930a = new WeakReference(c0665a);
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        C0665a c0665a = (C0665a) this.f1930a.get();
                        if (c0665a != null) {
                            c0665a.m2023e();
                        }
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        sendMessageDelayed(obtain, 1000);
                    default:
                        super.handleMessage(message);
                }
            }
        }

        public C0665a() {
            this.f1937g = new ArrayList();
        }

        static {
            f1931a = C0665a.class.getSimpleName();
            f1932b = new int[]{8000, 11025, 22050, 44100};
            f1933f = Double.MIN_VALUE;
        }

        public static double m2018a() {
            return f1933f;
        }

        public void m2024a(C0663a c0663a) {
            this.f1937g.add(c0663a);
            if (1 == this.f1937g.size()) {
                m2020b();
            }
        }

        public void m2025b(C0663a c0663a) {
            this.f1937g.remove(c0663a);
            if (this.f1937g.size() == 0) {
                m2021c();
            }
        }

        private void m2020b() {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1931a, "Start sampling audio levels ...");
            this.f1934c = new HandlerThread("audioSampler");
            this.f1934c.start();
            this.f1935d = new C0664b(this.f1934c.getLooper(), this);
            this.f1936e = m2022d();
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f1935d.sendMessage(obtain);
        }

        private void m2021c() {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1931a, "Stop sampling audio levels ...");
            if (this.f1936e != null) {
                if (this.f1938h) {
                    this.f1938h = false;
                }
                this.f1935d.removeMessages(1);
                try {
                    this.f1936e.stop();
                    this.f1936e.release();
                } catch (IllegalStateException e) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1931a, "Invalid recorder state: " + e.getMessage());
                }
                this.f1934c.getLooper().quit();
                this.f1934c.interrupt();
                this.f1934c = null;
            }
        }

        private AudioRecord m2022d() {
            for (int i : f1932b) {
                for (short s : new short[]{(short) 3, (short) 2}) {
                    for (short s2 : new short[]{(short) 16, (short) 12}) {
                        int minBufferSize = AudioRecord.getMinBufferSize(i, s2, s);
                        if (minBufferSize != -2) {
                            AudioRecord audioRecord = new AudioRecord(0, i, s2, s, minBufferSize);
                            if (audioRecord.getState() == 1) {
                                return audioRecord;
                            }
                        }
                    }
                }
            }
            return null;
        }

        private void m2023e() {
            if (this.f1936e != null && 1 == this.f1936e.getState()) {
                short[] sArr = new short[XMLEntityManager.DEFAULT_INTERNAL_BUFFER_SIZE];
                float[] fArr = new float[3];
                this.f1938h = true;
                this.f1936e.startRecording();
                int read = this.f1936e.read(sArr, 0, sArr.length);
                float f = 0.0f;
                for (int i = 0; i < read; i += 2) {
                    short s = (short) (sArr[i] | sArr[i + 1]);
                    if (s != (short) 0) {
                        f += (float) (Math.abs(s) / read);
                    }
                }
                fArr[0] = f;
                float f2 = 0.0f;
                for (int i2 = 0; i2 < 3; i2++) {
                    f2 += fArr[i2];
                }
                f1933f = (double) ((f2 / ((float) read)) / 32.0f);
                for (C0663a c0663a : this.f1937g) {
                    if (c0663a != null) {
                        c0663a.m2017a(f1933f);
                    }
                }
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.b */
    public final class C0666b extends ContentObserver {
        final /* synthetic */ MraidMediaProcessor f1939a;
        private Context f1940b;
        private int f1941c;
        private String f1942d;

        public C0666b(MraidMediaProcessor mraidMediaProcessor, String str, Context context, Handler handler) {
            this.f1939a = mraidMediaProcessor;
            super(handler);
            this.f1942d = str;
            this.f1940b = context;
            this.f1941c = -1;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            if (this.f1940b != null) {
                int streamVolume = ((AudioManager) this.f1940b.getSystemService("audio")).getStreamVolume(3);
                if (streamVolume != this.f1941c) {
                    this.f1941c = streamVolume;
                    this.f1939a.m2030a(this.f1942d, streamVolume);
                }
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.MraidMediaProcessor.3 */
    class C14153 implements MediaRenderView {
        final /* synthetic */ MraidMediaProcessor f4476a;

        C14153(MraidMediaProcessor mraidMediaProcessor) {
            this.f4476a = mraidMediaProcessor;
        }

        public void m5191a(MediaRenderView mediaRenderView) {
            Logger.m1744a(InternalLogLevel.INTERNAL, MraidMediaProcessor.f1943a, ">>> onPlayerCompleted");
            this.f4476a.f1944b.setAdActiveFlag(false);
            View f = mediaRenderView.m2112f();
            if (f != null) {
                ((ViewGroup) f.getParent()).removeView(f);
            }
            mediaRenderView.m2100a(null);
            synchronized (this) {
                if (this.f4476a.f1945c != null && mediaRenderView.f2005f.equalsIgnoreCase(this.f4476a.f1945c.f2005f)) {
                    this.f4476a.f1953k.remove(this.f4476a.f1945c.f2005f);
                    this.f4476a.f1945c = null;
                }
            }
        }

        public void m5192b(MediaRenderView mediaRenderView) {
            Logger.m1744a(InternalLogLevel.INTERNAL, MraidMediaProcessor.f1943a, ">>> onPlayerPrepared");
        }
    }

    static {
        f1943a = MraidMediaProcessor.class.getSimpleName();
    }

    public MraidMediaProcessor(RenderView renderView) {
        this.f1953k = new Hashtable();
        this.f1944b = renderView;
        this.f1946d = new C0665a();
        this.f1950h = new MediaPlayerProperties();
        this.f1951i = new Dimensions();
        this.f1952j = false;
    }

    public boolean m2048a() {
        return this.f1952j;
    }

    public void m2042a(MediaPlayerProperties mediaPlayerProperties) {
        this.f1950h = mediaPlayerProperties;
        this.f1952j = true;
    }

    public void m2041a(Dimensions dimensions) {
        this.f1951i = dimensions;
    }

    public void m2046a(String str, String str2, MediaContentType mediaContentType, Activity activity) {
        if (m2036b(str, str2, mediaContentType, activity)) {
            MediaPlayerProperties mediaPlayerProperties = this.f1950h;
            Dimensions dimensions = this.f1951i;
            this.f1944b.setAdActiveFlag(true);
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + this.f1945c.f2002c);
            if (str2.length() != 0) {
                this.f1945c.m2103a(str, str2, mediaPlayerProperties, dimensions);
            } else {
                this.f1945c.m2103a(str, this.f1945c.f2006g, mediaPlayerProperties, dimensions);
            }
            if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediaContentType && str2.startsWith("http") && !str2.endsWith("mp4") && !str2.endsWith("avi") && !str2.endsWith("m4v")) {
                this.f1945c.m2109c(3);
            } else if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO == mediaContentType && str2.startsWith("http") && !str2.endsWith("mp3")) {
                this.f1945c.m2109c(3);
            } else {
                this.f1953k.put(this.f1950h.f1979a, this.f1945c);
                if (MediaRenderView.HIDDEN == this.f1945c.f2002c) {
                    this.f1945c.m2106b();
                    return;
                }
                ViewGroup viewGroup;
                LayoutParams layoutParams;
                if (mediaPlayerProperties.m2083a()) {
                    viewGroup = (ViewGroup) activity.findViewById(16908290);
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    this.f1945c.setLayoutParams(layoutParams);
                    ViewGroup relativeLayout = new RelativeLayout(activity);
                    relativeLayout.setOnTouchListener(new C06601(this));
                    relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    relativeLayout.addView(this.f1945c);
                    viewGroup.addView(relativeLayout, new LayoutParams(-1, -1));
                    this.f1945c.m2100a(relativeLayout);
                    this.f1945c.requestFocus();
                    this.f1945c.setOnKeyListener(new C06612(this));
                } else {
                    viewGroup = (ViewGroup) activity.findViewById(16908290);
                    ViewGroup relativeLayout2 = new RelativeLayout(activity);
                    LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensions.f1958c, dimensions.f1959d);
                    layoutParams2.leftMargin = dimensions.f1956a;
                    layoutParams2.topMargin = dimensions.f1957b;
                    layoutParams2.width = dimensions.f1958c;
                    layoutParams2.height = dimensions.f1959d;
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(10);
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    layoutParams.addRule(11);
                    this.f1945c.setLayoutParams(layoutParams);
                    this.f1945c.m2100a(relativeLayout2);
                    relativeLayout2.addView(this.f1945c);
                    viewGroup.addView(relativeLayout2, layoutParams2);
                    this.f1945c.clearFocus();
                }
                this.f1945c.m2101a(new C14153(this));
                this.f1945c.m2097a();
            }
        }
    }

    public void m2044a(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "pauseMedia");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (d.f2002c == MediaRenderView.PLAYING || !(MediaRenderView.INITIALIZED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c)) {
            d.pause();
        } else if (d.f2007h) {
            this.f1944b.m1949a(str, "Invalid player state", "pauseMedia");
        } else {
            this.f1950h.f1982d = false;
            d.f2004e = this.f1950h;
        }
    }

    public void m2045a(String str, String str2, int i) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "seekMedia");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c || MediaRenderView.INITIALIZED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "seekMedia");
        } else {
            d.m2098a(i * 1000);
        }
    }

    public void m2051b(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "muteMedia");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c || MediaRenderView.INITIALIZED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "muteMedia");
        } else {
            d.m2110d();
        }
    }

    public void m2055c(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "unMuteMedia");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c || MediaRenderView.INITIALIZED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "unMuteMedia");
        } else {
            d.m2111e();
        }
    }

    public boolean m2057d(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "isMediaMuted");
            return false;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED != d.f2002c && MediaRenderView.INITIALIZED != d.f2002c && MediaRenderView.HIDDEN != d.f2002c) {
            return d.f2001b;
        }
        this.f1944b.m1949a(str, "Invalid player state", "isMediaMuted");
        return false;
    }

    public void m2052b(String str, String str2, int i) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "setMediaVolume");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "setMediaVolume");
        } else {
            d.m2107b(i);
        }
    }

    public int m2058e(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "getMediaVolume");
            return 0;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "getMediaVolume");
            return 0;
        } else if (d.f2001b) {
            return 0;
        } else {
            return d.f2000a;
        }
    }

    public void m2047a(String str, String str2, boolean z) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "closeMedia");
            return;
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player state: " + d.f2002c);
        if (MediaRenderView.RELEASED == d.f2002c || MediaRenderView.HIDDEN == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "closeMedia");
        } else {
            d.m2104a(z);
        }
    }

    public void m2061f(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "hideMedia");
        } else if (MediaRenderView.RELEASED == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "hideMedia");
        } else if (MediaRenderView.HIDDEN == d.f2002c) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player is already hidden");
        } else {
            d.m2108c();
        }
    }

    public void m2063g(String str, String str2) {
        MediaRenderView d = m2038d(str2);
        if (d == null) {
            this.f1944b.m1949a(str, "Invalid property ID", "showMedia");
        } else if (MediaRenderView.RELEASED == d.f2002c) {
            this.f1944b.m1949a(str, "Invalid player state", "showMedia");
        } else if (!this.f1950h.f1979a.equalsIgnoreCase(str2)) {
            this.f1944b.m1949a(str, "Show failed. There is already a video playing", "showMedia");
        } else if (MediaRenderView.SHOWING == d.f2002c) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Media player is already showing");
        } else {
            this.f1953k.remove(str2);
            this.f1945c = d;
            d.m2106b();
        }
    }

    public void m2049b() {
        if (this.f1945c != null) {
            this.f1953k.put(this.f1945c.f2005f, this.f1945c);
        }
        for (MediaRenderView a : this.f1953k.values()) {
            a.m2104a(true);
        }
        this.f1953k.clear();
        this.f1945c = null;
    }

    public void m2053c() {
        if (this.f1945c != null && MediaRenderView.RELEASED != this.f1945c.f2002c) {
            this.f1953k.put(this.f1945c.f2005f, this.f1945c);
            this.f1945c.m2108c();
        }
    }

    public C0665a m2056d() {
        return this.f1946d;
    }

    public boolean m2059e() {
        return 2 != ((AudioManager) SdkContext.m1562b().getSystemService("audio")).getRingerMode();
    }

    public void m2043a(String str) {
        if (this.f1947e == null) {
            this.f1947e = new RingerModeChangeReceiver(this, str);
            SdkContext.m1562b().registerReceiver(this.f1947e, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        }
    }

    public void m2060f() {
        if (this.f1947e != null) {
            SdkContext.m1562b().unregisterReceiver(this.f1947e);
            this.f1947e = null;
        }
    }

    public void m2050b(String str) {
        if (this.f1948f == null) {
            Context b = SdkContext.m1562b();
            this.f1948f = new C0666b(this, str, b, new Handler());
            b.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f1948f);
        }
    }

    public void m2062g() {
        if (this.f1948f != null) {
            SdkContext.m1562b().getContentResolver().unregisterContentObserver(this.f1948f);
            this.f1948f = null;
        }
    }

    public boolean m2064h() {
        return ((AudioManager) SdkContext.m1562b().getSystemService("audio")).isWiredHeadsetOn();
    }

    public void m2054c(String str) {
        if (this.f1949g == null) {
            this.f1949g = new HeadphonesPluggedChangeReceiver(this, str);
            SdkContext.m1562b().registerReceiver(this.f1949g, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        }
    }

    public void m2065i() {
        if (this.f1949g != null) {
            SdkContext.m1562b().unregisterReceiver(this.f1949g);
            this.f1949g = null;
        }
    }

    private boolean m2036b(String str, String str2, MediaContentType mediaContentType, Activity activity) {
        if (this.f1945c == null || !this.f1945c.f2005f.equalsIgnoreCase(this.f1950h.f1979a)) {
            return m2032a(str, str2, this.f1950h.f1979a, mediaContentType, activity);
        }
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Reusing media player (" + this.f1945c.f2005f + ") from the pool");
        if (!this.f1945c.f2005f.equalsIgnoreCase(this.f1950h.f1979a)) {
            return false;
        }
        if (str2.length() == 0 || this.f1945c.f2006g.equalsIgnoreCase(str2)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Player state: " + this.f1945c.f2002c);
            switch (C06624.f1925a[this.f1945c.f2002c.ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    this.f1945c.start();
                    m2040k();
                    return false;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    if (this.f1945c.f2007h) {
                        this.f1945c.start();
                    } else {
                        this.f1950h.f1982d = true;
                        this.f1945c.f2004e = this.f1950h;
                    }
                    m2040k();
                    return false;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    if (!this.f1950h.f1984f) {
                        return false;
                    }
                    this.f1945c.start();
                    m2040k();
                    return false;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    m2040k();
                    return false;
                default:
                    return false;
            }
        }
        this.f1945c.m2103a(str, str2, this.f1950h, this.f1951i);
        this.f1945c.m2113g();
        return false;
    }

    private void m2040k() {
        if (!this.f1950h.m2083a()) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f1945c.m2112f();
            if (relativeLayout != null) {
                relativeLayout.setOnTouchListener(null);
                relativeLayout.setBackgroundColor(0);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f1951i.f1958c, this.f1951i.f1959d);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                if (-99999 == this.f1951i.f1956a || -99999 == this.f1951i.f1957b) {
                    layoutParams.leftMargin = layoutParams2.leftMargin;
                    layoutParams.topMargin = layoutParams2.topMargin;
                } else {
                    layoutParams.leftMargin = this.f1951i.f1956a;
                    layoutParams.topMargin = this.f1951i.f1957b;
                }
                relativeLayout.setLayoutParams(layoutParams);
            }
        }
    }

    private boolean m2032a(String str, String str2, String str3, MediaContentType mediaContentType, Activity activity) {
        if ((str2.length() != 0 && !URLUtil.isValidUrl(str2)) || (str2.length() == 0 && !this.f1953k.containsKey(str3))) {
            String str4;
            RenderView renderView = this.f1944b;
            String str5 = "Invalid ID (" + str3 + "); no playback URL for this ID";
            if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediaContentType) {
                str4 = "playVideo";
            } else {
                str4 = "playAudio";
            }
            renderView.m1949a(str, str5, str4);
            return false;
        } else if (this.f1953k.size() == 5) {
            this.f1944b.m1949a(str, "Cannot create media player - limit on number of media players reached", MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == mediaContentType ? "playVideo" : "playAudio");
            return false;
        } else {
            MediaRenderView mediaRenderView = (MediaRenderView) this.f1953k.remove(str3);
            if (mediaRenderView == null) {
                if (this.f1945c != null && this.f1950h.m2083a()) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Only a single instance of full-screen media playback is allowed. Releasing the current active player ...");
                    this.f1953k.remove(this.f1945c.f2005f);
                    this.f1945c.m2104a(false);
                }
                Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Creating a new media player instance!");
                this.f1945c = new MediaRenderView(activity, this.f1944b);
            } else {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Reusing media player (" + str3 + ") from the pool");
                this.f1945c = mediaRenderView;
            }
            if (str2.length() == 0 && mediaRenderView != null) {
                this.f1945c.m2103a(str, mediaRenderView.f2006g, mediaRenderView.f2004e, mediaRenderView.f2003d);
                this.f1945c.f2003d = mediaRenderView.f2003d;
            }
            return true;
        }
    }

    private MediaRenderView m2038d(String str) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Checking for media player with ID: " + str);
        if (this.f1945c == null || !(str == null || str.length() == 0)) {
            MediaRenderView mediaRenderView = (MediaRenderView) this.f1953k.get(str);
            if (mediaRenderView != null) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Returning media render view with ID: " + str + " (state: " + mediaRenderView.f2002c + ")");
                return mediaRenderView;
            }
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "No media render view found!");
            return mediaRenderView;
        } else if ("anonymous".equalsIgnoreCase(this.f1950h.f1979a)) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Returning media render view with ID: " + this.f1950h.f1979a + " (state: " + this.f1945c.f2002c + ")");
            return this.f1945c;
        } else {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1943a, "Cannot find ID to look up the media render view");
            return null;
        }
    }

    private void m2031a(String str, boolean z) {
        if (this.f1944b != null) {
            this.f1944b.m1946a(str, "fireDeviceMuteChangeEvent(" + z + ");");
        }
    }

    private void m2030a(String str, int i) {
        if (this.f1944b != null) {
            this.f1944b.m1946a(str, "fireDeviceVolumeChangeEvent(" + i + ");");
        }
    }

    private void m2035b(String str, boolean z) {
        if (this.f1944b != null) {
            this.f1944b.m1946a(str, "fireHeadphonePluggedEvent(" + z + ");");
        }
    }
}
