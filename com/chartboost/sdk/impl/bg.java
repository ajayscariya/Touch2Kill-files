package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.bh.C0378a;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class bg extends TextureView implements SurfaceTextureListener, C0378a {
    OnVideoSizeChangedListener f4173a;
    OnPreparedListener f4174b;
    private String f4175c;
    private Uri f4176d;
    private Map<String, String> f4177e;
    private int f4178f;
    private int f4179g;
    private int f4180h;
    private Surface f4181i;
    private MediaPlayer f4182j;
    private int f4183k;
    private int f4184l;
    private OnCompletionListener f4185m;
    private OnPreparedListener f4186n;
    private int f4187o;
    private OnErrorListener f4188p;
    private int f4189q;
    private OnCompletionListener f4190r;
    private OnErrorListener f4191s;
    private OnBufferingUpdateListener f4192t;

    /* renamed from: com.chartboost.sdk.impl.bg.1 */
    class C03731 implements OnVideoSizeChangedListener {
        final /* synthetic */ bg f967a;

        C03731(bg bgVar) {
            this.f967a = bgVar;
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            this.f967a.f4183k = mp.getVideoWidth();
            this.f967a.f4184l = mp.getVideoHeight();
            if (this.f967a.f4183k != 0 && this.f967a.f4184l != 0) {
                this.f967a.m4652a(this.f967a.getWidth(), this.f967a.getHeight());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bg.2 */
    class C03742 implements OnPreparedListener {
        final /* synthetic */ bg f968a;

        C03742(bg bgVar) {
            this.f968a = bgVar;
        }

        public void onPrepared(MediaPlayer mp) {
            this.f968a.f4179g = 2;
            this.f968a.f4183k = mp.getVideoWidth();
            this.f968a.f4184l = mp.getVideoHeight();
            if (this.f968a.f4186n != null) {
                this.f968a.f4186n.onPrepared(this.f968a.f4182j);
            }
            int e = this.f968a.f4189q;
            if (e != 0) {
                this.f968a.m4651a(e);
            }
            if (this.f968a.f4180h == 3) {
                this.f968a.m4650a();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bg.3 */
    class C03753 implements OnCompletionListener {
        final /* synthetic */ bg f969a;

        C03753(bg bgVar) {
            this.f969a = bgVar;
        }

        public void onCompletion(MediaPlayer mp) {
            this.f969a.f4180h = 5;
            if (this.f969a.f4179g != 5) {
                this.f969a.f4179g = 5;
                if (this.f969a.f4185m != null) {
                    this.f969a.f4185m.onCompletion(this.f969a.f4182j);
                }
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bg.4 */
    class C03764 implements OnErrorListener {
        final /* synthetic */ bg f970a;

        C03764(bg bgVar) {
            this.f970a = bgVar;
        }

        public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            CBLogging.m379a(this.f970a.f4175c, "Error: " + framework_err + "," + impl_err);
            if (framework_err == 100) {
                this.f970a.m4644g();
            } else {
                this.f970a.f4179g = -1;
                this.f970a.f4180h = -1;
                if (this.f970a.f4188p != null && this.f970a.f4188p.onError(this.f970a.f4182j, framework_err, impl_err)) {
                }
            }
            return true;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bg.5 */
    class C03775 implements OnBufferingUpdateListener {
        final /* synthetic */ bg f971a;

        C03775(bg bgVar) {
            this.f971a = bgVar;
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            this.f971a.f4187o = percent;
        }
    }

    public bg(Context context) {
        super(context);
        this.f4175c = "VideoTextureView";
        this.f4179g = 0;
        this.f4180h = 0;
        this.f4181i = null;
        this.f4182j = null;
        this.f4173a = new C03731(this);
        this.f4174b = new C03742(this);
        this.f4190r = new C03753(this);
        this.f4191s = new C03764(this);
        this.f4192t = new C03775(this);
        m4642f();
    }

    private void m4642f() {
        this.f4183k = 0;
        this.f4184l = 0;
        setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f4179g = 0;
        this.f4180h = 0;
    }

    public void m4656a(Uri uri) {
        m4657a(uri, null);
    }

    public void m4652a(int i, int i2) {
        if (this.f4183k != 0 && this.f4184l != 0 && i != 0 && i2 != 0) {
            float min = Math.min(((float) i) / ((float) this.f4183k), ((float) i2) / ((float) this.f4184l));
            float f = ((float) this.f4183k) * min;
            min *= (float) this.f4184l;
            Matrix matrix = new Matrix();
            matrix.setScale(f / ((float) i), min / ((float) i2), ((float) i) / 2.0f, ((float) i2) / 2.0f);
            setTransform(matrix);
        }
    }

    public void m4657a(Uri uri, Map<String, String> map) {
        this.f4176d = uri;
        this.f4177e = map;
        this.f4189q = 0;
        m4644g();
        requestLayout();
        invalidate();
    }

    private void m4644g() {
        if (this.f4176d != null && this.f4181i != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
            m4632a(false);
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f4176d.toString());
                String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                this.f4184l = (int) Float.parseFloat(extractMetadata);
                this.f4183k = (int) Float.parseFloat(extractMetadata2);
            } catch (Throwable e) {
                CBLogging.m386d("play video", "read size error", e);
            }
            try {
                this.f4182j = new MediaPlayer();
                this.f4182j.setOnPreparedListener(this.f4174b);
                this.f4182j.setOnVideoSizeChangedListener(this.f4173a);
                this.f4178f = -1;
                this.f4182j.setOnCompletionListener(this.f4190r);
                this.f4182j.setOnErrorListener(this.f4191s);
                this.f4182j.setOnBufferingUpdateListener(this.f4192t);
                this.f4187o = 0;
                FileInputStream fileInputStream = new FileInputStream(new File(this.f4176d.toString()));
                this.f4182j.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
                this.f4182j.setSurface(this.f4181i);
                this.f4182j.setAudioStreamType(3);
                this.f4182j.setScreenOnWhilePlaying(true);
                this.f4182j.prepareAsync();
                this.f4179g = 1;
            } catch (Throwable e2) {
                CBLogging.m386d(this.f4175c, "Unable to open content: " + this.f4176d, e2);
                this.f4179g = -1;
                this.f4180h = -1;
                this.f4191s.onError(this.f4182j, 1, 0);
            } catch (Throwable e22) {
                CBLogging.m386d(this.f4175c, "Unable to open content: " + this.f4176d, e22);
                this.f4179g = -1;
                this.f4180h = -1;
                this.f4191s.onError(this.f4182j, 1, 0);
            }
        }
    }

    public void m4655a(OnPreparedListener onPreparedListener) {
        this.f4186n = onPreparedListener;
    }

    public void m4653a(OnCompletionListener onCompletionListener) {
        this.f4185m = onCompletionListener;
    }

    public void m4654a(OnErrorListener onErrorListener) {
        this.f4188p = onErrorListener;
    }

    private void m4632a(boolean z) {
        if (this.f4182j != null) {
            this.f4182j.reset();
            this.f4182j.release();
            this.f4182j = null;
            this.f4179g = 0;
            if (z) {
                this.f4180h = 0;
            }
        }
    }

    public void m4650a() {
        if (m4646h()) {
            this.f4182j.start();
            this.f4179g = 3;
        }
        this.f4180h = 3;
    }

    public void m4658b() {
        if (m4646h() && this.f4182j.isPlaying()) {
            this.f4182j.pause();
            this.f4179g = 4;
        }
        this.f4180h = 4;
    }

    public int m4659c() {
        if (!m4646h()) {
            this.f4178f = -1;
            return this.f4178f;
        } else if (this.f4178f > 0) {
            return this.f4178f;
        } else {
            this.f4178f = this.f4182j.getDuration();
            return this.f4178f;
        }
    }

    public int m4660d() {
        if (m4646h()) {
            return this.f4182j.getCurrentPosition();
        }
        return 0;
    }

    public void m4651a(int i) {
        if (m4646h()) {
            this.f4182j.seekTo(i);
            this.f4189q = 0;
            return;
        }
        this.f4189q = i;
    }

    public boolean m4661e() {
        return m4646h() && this.f4182j.isPlaying();
    }

    private boolean m4646h() {
        return (this.f4182j == null || this.f4179g == -1 || this.f4179g == 0 || this.f4179g == 1) ? false : true;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int w, int h) {
        this.f4181i = new Surface(surface);
        m4644g();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.f4181i = null;
        m4632a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int w, int h) {
        Object obj = this.f4180h == 3 ? 1 : null;
        if (this.f4182j != null && obj != null) {
            if (this.f4189q != 0) {
                m4651a(this.f4189q);
            }
            m4650a();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
}
