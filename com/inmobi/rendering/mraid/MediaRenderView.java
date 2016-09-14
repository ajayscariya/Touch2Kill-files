package com.inmobi.rendering.mraid;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.android.volley.DefaultRetryPolicy;
import com.applovin.sdk.AppLovinTargetingData;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.rendering.RenderView;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import mf.javax.xml.XMLConstants;

/* renamed from: com.inmobi.rendering.mraid.g */
final class MediaRenderView extends VideoView implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final String f1999k;
    int f2000a;
    boolean f2001b;
    MediaRenderView f2002c;
    Dimensions f2003d;
    MediaPlayerProperties f2004e;
    String f2005f;
    String f2006g;
    boolean f2007h;
    int f2008i;
    int f2009j;
    private MediaPlayer f2010l;
    private MediaRenderView f2011m;
    private RenderView f2012n;
    private Bitmap f2013o;
    private ViewGroup f2014p;
    private MediaRenderView f2015q;
    private MediaRenderView f2016r;
    private MediaRenderView f2017s;
    private String f2018t;
    private boolean f2019u;
    private boolean f2020v;

    /* renamed from: com.inmobi.rendering.mraid.g.1 */
    class MediaRenderView implements OnVideoSizeChangedListener {
        final /* synthetic */ MediaRenderView f1986a;

        MediaRenderView(MediaRenderView mediaRenderView) {
            this.f1986a = mediaRenderView;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            Logger.m1744a(InternalLogLevel.INTERNAL, MediaRenderView.f1999k, ">>> onVideoSizeChanged");
            if (this.f1986a.f2011m == null && this.f1986a.f2004e.f1983e) {
                this.f1986a.f2011m = new MediaRenderView(this.f1986a.getContext());
                this.f1986a.f2011m.setAnchorView(this.f1986a);
                this.f1986a.setMediaController(this.f1986a.f2011m);
                this.f1986a.requestLayout();
                this.f1986a.requestFocus();
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.g.a */
    static class MediaRenderView extends MediaController {
        Context f1987a;

        public MediaRenderView(Context context) {
            super(context);
            this.f1987a = context;
        }

        public void show(int i) {
            super.show(i);
            if (VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = MediaController.class.getDeclaredField("mAnchor");
                    declaredField.setAccessible(true);
                    View view = (View) declaredField.get(this);
                    Field declaredField2 = MediaController.class.getDeclaredField("mDecor");
                    declaredField2.setAccessible(true);
                    View view2 = (View) declaredField2.get(this);
                    Field declaredField3 = MediaController.class.getDeclaredField("mDecorLayoutParams");
                    declaredField3.setAccessible(true);
                    LayoutParams layoutParams = (LayoutParams) declaredField3.get(this);
                    Field declaredField4 = MediaController.class.getDeclaredField("mWindowManager");
                    declaredField4.setAccessible(true);
                    WindowManager windowManager = (WindowManager) declaredField4.get(this);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    view2.measure(MeasureSpec.makeMeasureSpec(view.getWidth(), ExploreByTouchHelper.INVALID_ID), MeasureSpec.makeMeasureSpec(view.getHeight(), ExploreByTouchHelper.INVALID_ID));
                    view2.setPadding(0, 0, 0, 0);
                    layoutParams.verticalMargin = 0.0f;
                    layoutParams.horizontalMargin = 0.0f;
                    layoutParams.width = view.getWidth();
                    layoutParams.gravity = 8388659;
                    layoutParams.x = iArr[0];
                    layoutParams.y = (view.getHeight() + iArr[1]) - view2.getMeasuredHeight();
                    windowManager.updateViewLayout(view2, layoutParams);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.g.b */
    static final class MediaRenderView extends Handler {
        private final WeakReference<MediaRenderView> f1988a;

        public MediaRenderView(MediaRenderView mediaRenderView) {
            this.f1988a = new WeakReference(mediaRenderView);
        }

        public void handleMessage(Message message) {
            MediaRenderView mediaRenderView = (MediaRenderView) this.f1988a.get();
            if (mediaRenderView != null) {
                switch (message.what) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        if (MediaRenderView.PLAYING == mediaRenderView.f2002c) {
                            int round = Math.round(((float) mediaRenderView.getCurrentPosition()) / 1000.0f);
                            int round2 = Math.round(((float) mediaRenderView.getDuration()) / 1000.0f);
                            if (mediaRenderView.f2008i != round) {
                                mediaRenderView.m2099a(round, round2);
                                mediaRenderView.f2008i = round;
                                mediaRenderView.f2009j = round;
                            }
                            sendEmptyMessageDelayed(1, 1000);
                            break;
                        }
                        return;
                }
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.inmobi.rendering.mraid.g.c */
    interface MediaRenderView {
        void m2085a(MediaRenderView mediaRenderView);

        void m2086b(MediaRenderView mediaRenderView);
    }

    /* renamed from: com.inmobi.rendering.mraid.g.d */
    enum MediaRenderView {
        INITIALIZED,
        PLAYING,
        PAUSED,
        HIDDEN,
        SHOWING,
        COMPLETED,
        RELEASED
    }

    /* renamed from: com.inmobi.rendering.mraid.g.e */
    final class MediaRenderView extends BroadcastReceiver {
        final /* synthetic */ MediaRenderView f1997a;
        private final String f1998b;

        MediaRenderView(MediaRenderView mediaRenderView) {
            this.f1997a = mediaRenderView;
            this.f1998b = MediaRenderView.class.getSimpleName();
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                Logger.m1744a(InternalLogLevel.INTERNAL, this.f1998b, "Screen OFF");
                if (MediaRenderView.PLAYING == this.f1997a.f2002c) {
                    this.f1997a.f2020v = true;
                    this.f1997a.pause();
                }
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                Logger.m1744a(InternalLogLevel.INTERNAL, this.f1998b, "Screen ON");
                if (this.f1997a.f2020v && MediaRenderView.PAUSED == this.f1997a.f2002c) {
                    this.f1997a.f2020v = false;
                    this.f1997a.m2097a();
                }
            }
        }
    }

    static {
        f1999k = MediaRenderView.class.getSimpleName();
    }

    public MediaRenderView(Context context, RenderView renderView) {
        super(context);
        this.f2012n = renderView;
        setZOrderOnTop(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDrawingCacheEnabled(true);
        this.f2000a = 100;
        this.f2008i = -1;
        this.f2009j = 0;
        this.f2002c = MediaRenderView.INITIALIZED;
        this.f2019u = false;
        this.f2001b = false;
        this.f2020v = false;
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, ">>> onWindowVisibilityChanged (" + i + ")");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHolder().setSizeFromLayout();
    }

    @TargetApi(16)
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, ">>> onVisibilityChanged (" + i + ")");
        if (i != 0) {
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            setBackground(new BitmapDrawable(SdkContext.m1562b().getResources(), this.f2013o));
        } else {
            setBackgroundDrawable(new BitmapDrawable(this.f2013o));
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, ">>> onCompletion");
        this.f2002c = MediaRenderView.COMPLETED;
        this.f2019u = true;
        m2102a("ended");
        this.f2016r.removeMessages(1);
        if (this.f2004e.f1984f) {
            synchronized (this) {
                if (!m2096k()) {
                    this.f2009j = 0;
                    start();
                }
            }
        } else if (this.f2004e.m2084b()) {
            m2104a(false);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, ">>> onError (" + i + ", " + i2 + ")");
        m2104a(false);
        int i3 = -1;
        if (100 == i) {
            i3 = 2;
        }
        m2109c(i3);
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, ">>> onPrepared");
        mediaPlayer.setOnVideoSizeChangedListener(new MediaRenderView(this));
        this.f2010l = mediaPlayer;
        m2098a(this.f2009j * 1000);
        this.f2007h = true;
        this.f2015q.m2086b(this);
        m2113g();
    }

    public void m2103a(String str, String str2, MediaPlayerProperties mediaPlayerProperties, Dimensions dimensions) {
        this.f2018t = str;
        this.f2016r = new MediaRenderView(this);
        this.f2006g = m2092b(str2.trim());
        this.f2004e = mediaPlayerProperties;
        this.f2005f = mediaPlayerProperties.f1979a;
        this.f2003d = dimensions;
        if (this.f2013o == null) {
            this.f2013o = Bitmap.createBitmap(24, 24, Config.ARGB_8888);
            this.f2013o = m2093c(this.f2006g);
        }
    }

    public void start() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Media render view state: " + this.f2002c);
        if (MediaRenderView.PLAYING != this.f2002c) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Start media playback");
            m2098a(this.f2009j * 1000);
            this.f2002c = MediaRenderView.PLAYING;
            super.start();
            if (this.f2007h) {
                m2102a("play");
            }
            this.f2016r.sendEmptyMessage(1);
        }
    }

    public void pause() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Media render view state: " + this.f2002c);
        if (MediaRenderView.PAUSED != this.f2002c) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Pause media playback");
            this.f2016r.removeMessages(1);
            super.pause();
            this.f2002c = MediaRenderView.PAUSED;
            m2102a("pause");
        }
    }

    public void m2097a() {
        setVideoPath(this.f2006g);
        setOnCompletionListener(this);
        setOnPreparedListener(this);
        setOnErrorListener(this);
        if (this.f2011m == null && this.f2004e.f1983e && VERSION.SDK_INT >= 19) {
            this.f2011m = new MediaRenderView(getContext());
            this.f2011m.setAnchorView(this);
            setMediaController(this.f2011m);
        }
        if (this.f2017s == null) {
            this.f2017s = new MediaRenderView(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            SdkContext.m1562b().registerReceiver(this.f2017s, intentFilter);
        }
    }

    public void m2098a(int i) {
        if (i < getDuration()) {
            this.f2009j = i;
            seekTo(i);
        }
    }

    public void m2106b() {
        if (MediaRenderView.SHOWING != this.f2002c) {
            this.f2014p.setVisibility(0);
            setVisibility(0);
            requestFocus();
            this.f2002c = MediaRenderView.SHOWING;
            m2102a("showing");
        }
    }

    public void m2108c() {
        if (MediaRenderView.HIDDEN != this.f2002c) {
            setVisibility(4);
            this.f2014p.setVisibility(4);
            this.f2002c = MediaRenderView.HIDDEN;
            m2102a("hidden");
        }
    }

    public void m2110d() {
        if (this.f2010l != null && !this.f2001b) {
            this.f2001b = true;
            this.f2010l.setVolume(0.0f, 0.0f);
            m2114h();
        }
    }

    public void m2111e() {
        if (this.f2010l != null && this.f2001b) {
            m2107b(this.f2000a);
        }
    }

    public void m2107b(int i) {
        boolean z = false;
        if (this.f2010l == null) {
            return;
        }
        if (!this.f2001b && i == this.f2000a) {
            return;
        }
        if (this.f2001b && i == 0) {
            this.f2000a = 0;
            return;
        }
        if (i == 0) {
            z = true;
        }
        this.f2001b = z;
        this.f2000a = i;
        float log = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((float) (Math.log((double) (101 - i)) / Math.log(101.0d)));
        this.f2010l.setVolume(log, log);
        m2114h();
    }

    public void m2104a(boolean z) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Media render view state: " + this.f2002c);
        Logger.m1744a(InternalLogLevel.INTERNAL, f1999k, "Release the media render view");
        if (this.f2017s != null) {
            SdkContext.m1562b().unregisterReceiver(this.f2017s);
            this.f2017s = null;
        }
        this.f2002c = MediaRenderView.RELEASED;
        m2105a(z, this.f2008i != -1 ? this.f2008i : Math.round((float) (getCurrentPosition() / 1000)));
        stopPlayback();
        this.f2016r.removeMessages(1);
        m2095j();
        super.setMediaController(null);
        this.f2011m = null;
        if (this.f2015q != null) {
            this.f2015q.m2085a(this);
        }
    }

    public ViewGroup m2112f() {
        return this.f2014p;
    }

    public void m2100a(ViewGroup viewGroup) {
        this.f2014p = viewGroup;
    }

    public void m2101a(MediaRenderView mediaRenderView) {
        this.f2015q = mediaRenderView;
    }

    void m2113g() {
        if (MediaRenderView.SHOWING == this.f2002c) {
            this.f2002c = this.f2019u ? MediaRenderView.COMPLETED : MediaRenderView.PAUSED;
            if (!this.f2007h) {
                return;
            }
            if (VERSION.SDK_INT < 21) {
                super.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                super.pause();
                return;
            }
            super.start();
            super.pause();
        } else if (MediaRenderView.INITIALIZED == this.f2002c) {
            if (this.f2004e.f1985g) {
                m2110d();
            }
            if (this.f2004e.f1982d) {
                start();
            } else if (!this.f2007h) {
            } else {
                if (VERSION.SDK_INT < 21) {
                    super.start();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                    }
                    super.pause();
                    return;
                }
                super.start();
                super.pause();
            }
        }
    }

    private void m2095j() {
        if (this.f2014p != null) {
            ViewGroup viewGroup = (ViewGroup) this.f2014p.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2014p);
            }
            viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
            setBackgroundColor(0);
            this.f2014p = null;
        }
    }

    private boolean m2096k() {
        return MediaRenderView.PAUSED == this.f2002c || MediaRenderView.HIDDEN == this.f2002c;
    }

    void m2105a(boolean z, int i) {
        if (this.f2012n != null) {
            this.f2012n.m1946a(this.f2018t, "fireMediaCloseEvent('" + this.f2004e.f1979a + "'," + z + "," + i + ");");
        }
    }

    void m2102a(String str) {
        if (this.f2012n != null) {
            this.f2012n.m1946a(this.f2018t, "fireMediaTrackingEvent('" + str + "','" + this.f2004e.f1979a + "');");
        }
    }

    void m2114h() {
        int i = this.f2001b ? 0 : this.f2000a;
        if (this.f2012n != null) {
            this.f2012n.m1946a(this.f2018t, "fireMediaVolumeChangeEvent('" + this.f2004e.f1979a + "'," + i + "," + this.f2001b + ");");
        }
    }

    void m2109c(int i) {
        if (this.f2012n != null) {
            this.f2012n.m1946a(this.f2018t, "fireMediaErrorEvent('" + this.f2004e.f1979a + "'," + i + ");");
        }
    }

    void m2099a(int i, int i2) {
        if (this.f2012n != null) {
            this.f2012n.m1946a(this.f2018t, "fireMediaTimeUpdateEvent('" + this.f2004e.f1979a + "'," + i + "," + i2 + ");");
        }
    }

    private String m2092b(String str) {
        String str2 = XMLConstants.NULL_NS_URI;
        byte[] bytes = str.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            if ((b & TransportMediator.FLAG_KEY_MEDIA_NEXT) > 0) {
                stringBuilder.append("%").append(m2088a(b));
            } else {
                stringBuilder.append((char) b);
            }
        }
        try {
            return new String(stringBuilder.toString().getBytes(), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    private Bitmap m2093c(String str) {
        try {
            return (Bitmap) Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{str, Integer.valueOf(1)});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private String m2088a(byte b) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', AppLovinTargetingData.GENDER_FEMALE};
        return new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }
}
