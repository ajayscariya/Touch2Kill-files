package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.bh.C0378a;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class bf extends SurfaceView implements C0378a {
    OnVideoSizeChangedListener f4150a;
    OnPreparedListener f4151b;
    Callback f4152c;
    private String f4153d;
    private Uri f4154e;
    private Map<String, String> f4155f;
    private int f4156g;
    private int f4157h;
    private int f4158i;
    private SurfaceHolder f4159j;
    private MediaPlayer f4160k;
    private int f4161l;
    private int f4162m;
    private int f4163n;
    private int f4164o;
    private OnCompletionListener f4165p;
    private OnPreparedListener f4166q;
    private int f4167r;
    private OnErrorListener f4168s;
    private int f4169t;
    private OnCompletionListener f4170u;
    private OnErrorListener f4171v;
    private OnBufferingUpdateListener f4172w;

    /* renamed from: com.chartboost.sdk.impl.bf.1 */
    class C03671 implements OnVideoSizeChangedListener {
        final /* synthetic */ bf f961a;

        C03671(bf bfVar) {
            this.f961a = bfVar;
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            this.f961a.f4161l = mp.getVideoWidth();
            this.f961a.f4162m = mp.getVideoHeight();
            if (this.f961a.f4161l != 0 && this.f961a.f4162m != 0) {
                this.f961a.getHolder().setFixedSize(this.f961a.f4161l, this.f961a.f4162m);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.2 */
    class C03682 implements OnPreparedListener {
        final /* synthetic */ bf f962a;

        C03682(bf bfVar) {
            this.f962a = bfVar;
        }

        public void onPrepared(MediaPlayer mp) {
            this.f962a.f4157h = 2;
            this.f962a.f4161l = mp.getVideoWidth();
            this.f962a.f4162m = mp.getVideoHeight();
            if (this.f962a.f4166q != null) {
                this.f962a.f4166q.onPrepared(this.f962a.f4160k);
            }
            int e = this.f962a.f4169t;
            if (e != 0) {
                this.f962a.m4619a(e);
            }
            if (this.f962a.f4161l != 0 && this.f962a.f4162m != 0) {
                this.f962a.getHolder().setFixedSize(this.f962a.f4161l, this.f962a.f4162m);
                if (this.f962a.f4163n == this.f962a.f4161l && this.f962a.f4164o == this.f962a.f4162m && this.f962a.f4158i == 3) {
                    this.f962a.m4618a();
                }
            } else if (this.f962a.f4158i == 3) {
                this.f962a.m4618a();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.3 */
    class C03693 implements OnCompletionListener {
        final /* synthetic */ bf f963a;

        C03693(bf bfVar) {
            this.f963a = bfVar;
        }

        public void onCompletion(MediaPlayer mp) {
            this.f963a.f4158i = 5;
            if (this.f963a.f4157h != 5) {
                this.f963a.f4157h = 5;
                if (this.f963a.f4165p != null) {
                    this.f963a.f4165p.onCompletion(this.f963a.f4160k);
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.4 */
    class C03704 implements OnErrorListener {
        final /* synthetic */ bf f964a;

        C03704(bf bfVar) {
            this.f964a = bfVar;
        }

        public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            CBLogging.m379a(this.f964a.f4153d, "Error: " + framework_err + "," + impl_err);
            this.f964a.f4157h = -1;
            this.f964a.f4158i = -1;
            return (this.f964a.f4168s == null || this.f964a.f4168s.onError(this.f964a.f4160k, framework_err, impl_err)) ? true : true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.5 */
    class C03715 implements OnBufferingUpdateListener {
        final /* synthetic */ bf f965a;

        C03715(bf bfVar) {
            this.f965a = bfVar;
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            this.f965a.f4167r = percent;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bf.6 */
    class C03726 implements Callback {
        final /* synthetic */ bf f966a;

        C03726(bf bfVar) {
            this.f966a = bfVar;
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            Object obj = 1;
            this.f966a.f4163n = w;
            this.f966a.f4164o = h;
            Object obj2 = this.f966a.f4158i == 3 ? 1 : null;
            if (!(this.f966a.f4161l == w && this.f966a.f4162m == h)) {
                obj = null;
            }
            if (this.f966a.f4160k != null && obj2 != null && r1 != null) {
                if (this.f966a.f4169t != 0) {
                    this.f966a.m4619a(this.f966a.f4169t);
                }
                this.f966a.m4618a();
            }
        }

        public void surfaceCreated(SurfaceHolder holder) {
            this.f966a.f4159j = holder;
            this.f966a.m4610g();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            this.f966a.f4159j = null;
            this.f966a.m4596a(true);
        }
    }

    public bf(Context context) {
        super(context);
        this.f4153d = "VideoSurfaceView";
        this.f4157h = 0;
        this.f4158i = 0;
        this.f4159j = null;
        this.f4160k = null;
        this.f4150a = new C03671(this);
        this.f4151b = new C03682(this);
        this.f4170u = new C03693(this);
        this.f4171v = new C03704(this);
        this.f4172w = new C03715(this);
        this.f4152c = new C03726(this);
        m4607f();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int defaultSize = getDefaultSize(0, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(0, heightMeasureSpec);
        if (this.f4161l <= 0 || this.f4162m <= 0) {
            i = defaultSize2;
            defaultSize2 = defaultSize;
        } else {
            i = Math.min(defaultSize2, Math.round((((float) this.f4162m) / ((float) this.f4161l)) * ((float) defaultSize)));
            defaultSize2 = Math.min(defaultSize, Math.round(((float) defaultSize2) * (((float) this.f4161l) / ((float) this.f4162m))));
        }
        setMeasuredDimension(defaultSize2, i);
    }

    private void m4607f() {
        this.f4161l = 0;
        this.f4162m = 0;
        getHolder().addCallback(this.f4152c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4157h = 0;
        this.f4158i = 0;
    }

    public void m4624a(Uri uri) {
        m4625a(uri, null);
    }

    public void m4625a(Uri uri, Map<String, String> map) {
        this.f4154e = uri;
        this.f4155f = map;
        this.f4169t = 0;
        m4610g();
        requestLayout();
        invalidate();
    }

    private void m4610g() {
        if (this.f4154e != null && this.f4159j != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m4596a(false);
            try {
                this.f4160k = new MediaPlayer();
                this.f4160k.setOnPreparedListener(this.f4151b);
                this.f4160k.setOnVideoSizeChangedListener(this.f4150a);
                this.f4156g = -1;
                this.f4160k.setOnCompletionListener(this.f4170u);
                this.f4160k.setOnErrorListener(this.f4171v);
                this.f4160k.setOnBufferingUpdateListener(this.f4172w);
                this.f4167r = 0;
                this.f4160k.setDisplay(this.f4159j);
                this.f4160k.setAudioStreamType(3);
                this.f4160k.setScreenOnWhilePlaying(true);
                FileInputStream fileInputStream = new FileInputStream(new File(this.f4154e.toString()));
                this.f4160k.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f4160k.prepareAsync();
                this.f4157h = 1;
            } catch (Throwable e) {
                CBLogging.m386d(this.f4153d, "Unable to open content: " + this.f4154e, e);
                this.f4157h = -1;
                this.f4158i = -1;
                this.f4171v.onError(this.f4160k, 1, 0);
            } catch (Throwable e2) {
                CBLogging.m386d(this.f4153d, "Unable to open content: " + this.f4154e, e2);
                this.f4157h = -1;
                this.f4158i = -1;
                this.f4171v.onError(this.f4160k, 1, 0);
            }
        }
    }

    public void m4623a(OnPreparedListener onPreparedListener) {
        this.f4166q = onPreparedListener;
    }

    public void m4621a(OnCompletionListener onCompletionListener) {
        this.f4165p = onCompletionListener;
    }

    public void m4622a(OnErrorListener onErrorListener) {
        this.f4168s = onErrorListener;
    }

    private void m4596a(boolean z) {
        if (this.f4160k != null) {
            this.f4160k.reset();
            this.f4160k.release();
            this.f4160k = null;
            this.f4157h = 0;
            if (z) {
                this.f4158i = 0;
            }
        }
    }

    public void m4618a() {
        if (m4612h()) {
            this.f4160k.start();
            this.f4157h = 3;
        }
        this.f4158i = 3;
    }

    public void m4626b() {
        if (m4612h() && this.f4160k.isPlaying()) {
            this.f4160k.pause();
            this.f4157h = 4;
        }
        this.f4158i = 4;
    }

    public int m4627c() {
        if (!m4612h()) {
            this.f4156g = -1;
            return this.f4156g;
        } else if (this.f4156g > 0) {
            return this.f4156g;
        } else {
            this.f4156g = this.f4160k.getDuration();
            return this.f4156g;
        }
    }

    public int m4628d() {
        if (m4612h()) {
            return this.f4160k.getCurrentPosition();
        }
        return 0;
    }

    public void m4619a(int i) {
        if (m4612h()) {
            this.f4160k.seekTo(i);
            this.f4169t = 0;
            return;
        }
        this.f4169t = i;
    }

    public boolean m4629e() {
        return m4612h() && this.f4160k.isPlaying();
    }

    private boolean m4612h() {
        return (this.f4160k == null || this.f4157h == -1 || this.f4157h == 0 || this.f4157h == 1) ? false : true;
    }

    public void m4620a(int i, int i2) {
    }
}
