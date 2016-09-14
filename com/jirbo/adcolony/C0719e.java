package com.jirbo.adcolony;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.FileDescriptor;

/* renamed from: com.jirbo.adcolony.e */
class C0719e extends SurfaceView implements MediaPlayerControl {
    static final int f2532e = -1;
    static final int f2533f = 0;
    static final int f2534g = 1;
    static final int f2535h = 2;
    static final int f2536i = 3;
    static final int f2537j = 4;
    static final int f2538k = 5;
    static final int f2539l = 6;
    static final int f2540m = 7;
    static final int f2541n = 8;
    OnErrorListener f2542A;
    int f2543B;
    boolean f2544C;
    boolean f2545D;
    boolean f2546E;
    boolean f2547F;
    int f2548G;
    OnVideoSizeChangedListener f2549H;
    OnPreparedListener f2550I;
    Callback f2551J;
    private OnCompletionListener f2552K;
    private OnErrorListener f2553L;
    private OnBufferingUpdateListener f2554M;
    String f2555a;
    Uri f2556b;
    FileDescriptor f2557c;
    int f2558d;
    int f2559o;
    int f2560p;
    SurfaceHolder f2561q;
    MediaPlayer f2562r;
    int f2563s;
    int f2564t;
    int f2565u;
    int f2566v;
    MediaController f2567w;
    OnCompletionListener f2568x;
    OnPreparedListener f2569y;
    int f2570z;

    /* renamed from: com.jirbo.adcolony.e.1 */
    class C07121 implements OnVideoSizeChangedListener {
        final /* synthetic */ C0719e f2525a;

        C07121(C0719e c0719e) {
            this.f2525a = c0719e;
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            this.f2525a.f2563s = mp.getVideoWidth();
            this.f2525a.f2564t = mp.getVideoHeight();
            if (this.f2525a.f2563s != 0 && this.f2525a.f2564t != 0) {
                this.f2525a.getHolder().setFixedSize(this.f2525a.f2563s, this.f2525a.f2564t);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.e.2 */
    class C07132 implements OnPreparedListener {
        final /* synthetic */ C0719e f2526a;

        C07132(C0719e c0719e) {
            this.f2526a = c0719e;
        }

        public void onPrepared(MediaPlayer mp) {
            this.f2526a.f2559o = C0719e.f2535h;
            C0719e c0719e = this.f2526a;
            C0719e c0719e2 = this.f2526a;
            this.f2526a.f2546E = true;
            c0719e2.f2545D = true;
            c0719e.f2544C = true;
            if (this.f2526a.f2569y != null) {
                this.f2526a.f2569y.onPrepared(this.f2526a.f2562r);
            }
            if (this.f2526a.f2567w != null) {
                this.f2526a.f2567w.setEnabled(true);
            }
            this.f2526a.f2563s = mp.getVideoWidth();
            this.f2526a.f2564t = mp.getVideoHeight();
            int i = this.f2526a.f2543B;
            if (i != 0) {
                this.f2526a.seekTo(i);
            }
            if (this.f2526a.f2563s != 0 && this.f2526a.f2564t != 0) {
                this.f2526a.getHolder().setFixedSize(this.f2526a.f2563s, this.f2526a.f2564t);
                if (this.f2526a.f2565u != this.f2526a.f2563s || this.f2526a.f2566v != this.f2526a.f2564t) {
                    return;
                }
                if (this.f2526a.f2560p == C0719e.f2536i) {
                    this.f2526a.start();
                    if (this.f2526a.f2567w != null) {
                        this.f2526a.f2567w.show();
                    }
                } else if (!this.f2526a.isPlaying()) {
                    if ((i != 0 || this.f2526a.getCurrentPosition() > 0) && this.f2526a.f2567w != null) {
                        this.f2526a.f2567w.show(C0719e.f2533f);
                    }
                }
            } else if (this.f2526a.f2560p == C0719e.f2536i) {
                this.f2526a.start();
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.e.3 */
    class C07143 implements OnCompletionListener {
        final /* synthetic */ C0719e f2527a;

        C07143(C0719e c0719e) {
            this.f2527a = c0719e;
        }

        public void onCompletion(MediaPlayer mp) {
            this.f2527a.f2559o = C0719e.f2538k;
            this.f2527a.f2560p = C0719e.f2538k;
            if (this.f2527a.f2567w != null) {
                this.f2527a.f2567w.hide();
            }
            if (this.f2527a.f2568x != null) {
                this.f2527a.f2568x.onCompletion(this.f2527a.f2562r);
            }
        }
    }

    /* renamed from: com.jirbo.adcolony.e.4 */
    class C07164 implements OnErrorListener {
        final /* synthetic */ C0719e f2529a;

        /* renamed from: com.jirbo.adcolony.e.4.1 */
        class C07151 implements OnClickListener {
            final /* synthetic */ C07164 f2528a;

            C07151(C07164 c07164) {
                this.f2528a = c07164;
            }

            public void onClick(DialogInterface dialog, int whichButton) {
                if (this.f2528a.f2529a.f2568x != null) {
                    this.f2528a.f2529a.f2568x.onCompletion(this.f2528a.f2529a.f2562r);
                }
            }
        }

        C07164(C0719e c0719e) {
            this.f2529a = c0719e;
        }

        public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            Log.d(this.f2529a.f2555a, "Error: " + framework_err + "," + impl_err);
            this.f2529a.f2559o = C0719e.f2532e;
            this.f2529a.f2560p = C0719e.f2532e;
            if (this.f2529a.f2567w != null) {
                this.f2529a.f2567w.hide();
            }
            if ((this.f2529a.f2542A == null || !this.f2529a.f2542A.onError(this.f2529a.f2562r, framework_err, impl_err)) && this.f2529a.getWindowToken() != null) {
                CharSequence charSequence;
                this.f2529a.m2595b().getResources();
                if (framework_err == 200) {
                    charSequence = "Invalid progressive playback";
                } else {
                    charSequence = "Unknown error";
                }
                new Builder(this.f2529a.m2595b()).setTitle("ERROR").setMessage(charSequence).setPositiveButton("OKAY", new C07151(this)).setCancelable(false).show();
            }
            return true;
        }
    }

    /* renamed from: com.jirbo.adcolony.e.5 */
    class C07175 implements OnBufferingUpdateListener {
        final /* synthetic */ C0719e f2530a;

        C07175(C0719e c0719e) {
            this.f2530a = c0719e;
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            this.f2530a.f2570z = percent;
        }
    }

    /* renamed from: com.jirbo.adcolony.e.6 */
    class C07186 implements Callback {
        final /* synthetic */ C0719e f2531a;

        C07186(C0719e c0719e) {
            this.f2531a = c0719e;
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            Object obj = C0719e.f2534g;
            this.f2531a.f2565u = w;
            this.f2531a.f2566v = h;
            Object obj2 = this.f2531a.f2560p == C0719e.f2536i ? C0719e.f2534g : C0719e.f2533f;
            if (!(this.f2531a.f2563s == w && this.f2531a.f2564t == h)) {
                obj = C0719e.f2533f;
            }
            if (this.f2531a.f2562r != null && obj2 != null && r1 != null) {
                if (this.f2531a.f2543B != 0) {
                    this.f2531a.seekTo(this.f2531a.f2543B);
                }
                this.f2531a.start();
                if (this.f2531a.f2567w != null) {
                    this.f2531a.f2567w.show();
                }
            }
        }

        public void surfaceCreated(SurfaceHolder holder) {
            this.f2531a.f2561q = holder;
            if (this.f2531a.f2562r != null && this.f2531a.f2559o == C0719e.f2539l && this.f2531a.f2560p == C0719e.f2540m) {
                this.f2531a.f2562r.setDisplay(this.f2531a.f2561q);
                this.f2531a.m2597d();
                return;
            }
            this.f2531a.m2582f();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            this.f2531a.f2561q = null;
            if (this.f2531a.f2567w != null) {
                this.f2531a.f2567w.hide();
            }
            if (this.f2531a.f2559o != C0719e.f2539l) {
                this.f2531a.m2580a(true);
            }
        }
    }

    C0719e(Context context) {
        super(context);
        this.f2555a = "ADCCustomVideoView";
        this.f2559o = f2533f;
        this.f2560p = f2533f;
        this.f2561q = null;
        this.f2562r = null;
        this.f2549H = new C07121(this);
        this.f2550I = new C07132(this);
        this.f2552K = new C07143(this);
        this.f2553L = new C07164(this);
        this.f2554M = new C07175(this);
        this.f2551J = new C07186(this);
        m2581e();
    }

    C0719e(Context context, boolean z) {
        super(context);
        this.f2555a = "ADCCustomVideoView";
        this.f2559o = f2533f;
        this.f2560p = f2533f;
        this.f2561q = null;
        this.f2562r = null;
        this.f2549H = new C07121(this);
        this.f2550I = new C07132(this);
        this.f2552K = new C07143(this);
        this.f2553L = new C07164(this);
        this.f2554M = new C07175(this);
        this.f2551J = new C07186(this);
        this.f2547F = z;
        m2581e();
    }

    public C0719e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, f2533f);
        m2581e();
    }

    public C0719e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2555a = "ADCCustomVideoView";
        this.f2559o = f2533f;
        this.f2560p = f2533f;
        this.f2561q = null;
        this.f2562r = null;
        this.f2549H = new C07121(this);
        this.f2550I = new C07132(this);
        this.f2552K = new C07143(this);
        this.f2553L = new C07164(this);
        this.f2554M = new C07175(this);
        this.f2551J = new C07186(this);
        m2581e();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = C0719e.getDefaultSize(this.f2563s, widthMeasureSpec);
        int defaultSize2 = C0719e.getDefaultSize(this.f2564t, heightMeasureSpec);
        if (this.f2563s > 0 && this.f2564t > 0) {
            if (this.f2563s * defaultSize2 > this.f2564t * defaultSize) {
                defaultSize2 = (this.f2564t * defaultSize) / this.f2563s;
            } else if (this.f2563s * defaultSize2 < this.f2564t * defaultSize) {
                defaultSize = (this.f2563s * defaultSize2) / this.f2564t;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public int m2586a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID /*-2147483648*/:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private void m2581e() {
        this.f2563s = f2533f;
        this.f2564t = f2533f;
        getHolder().addCallback(this.f2551J);
        getHolder().setType(f2536i);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (this.f2547F) {
            requestFocus();
        }
        this.f2559o = f2533f;
        this.f2560p = f2533f;
    }

    public int getAudioSessionId() {
        return f2533f;
    }

    public void m2594a(String str) {
        m2591a(Uri.parse(str));
    }

    public void m2593a(FileDescriptor fileDescriptor) {
        this.f2557c = fileDescriptor;
        this.f2543B = f2533f;
        m2582f();
        requestLayout();
        invalidate();
    }

    public void m2591a(Uri uri) {
        this.f2556b = uri;
        this.f2543B = f2533f;
        m2582f();
        requestLayout();
        invalidate();
    }

    public void m2587a() {
        if (this.f2562r != null) {
            this.f2562r.stop();
            this.f2562r.release();
            this.f2562r = null;
            this.f2559o = f2533f;
            this.f2560p = f2533f;
        }
    }

    Activity m2595b() {
        return AdColony.activity();
    }

    private void m2582f() {
        if ((this.f2556b != null || this.f2557c != null) && this.f2561q != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            m2595b().sendBroadcast(intent);
            m2580a(false);
            try {
                this.f2562r = new MediaPlayer();
                this.f2562r.setOnPreparedListener(this.f2550I);
                this.f2562r.setOnVideoSizeChangedListener(this.f2549H);
                this.f2558d = f2532e;
                this.f2562r.setOnCompletionListener(this.f2552K);
                this.f2562r.setOnErrorListener(this.f2553L);
                this.f2562r.setOnBufferingUpdateListener(this.f2554M);
                this.f2570z = f2533f;
                if (this.f2556b != null) {
                    this.f2562r.setDataSource(m2595b(), this.f2556b);
                } else {
                    this.f2562r.setDataSource(this.f2557c);
                }
                this.f2562r.setDisplay(this.f2561q);
                this.f2562r.setAudioStreamType(f2536i);
                this.f2562r.setScreenOnWhilePlaying(true);
                this.f2562r.prepare();
                this.f2559o = f2534g;
                m2583g();
            } catch (Throwable e) {
                if (this.f2556b != null) {
                    Log.w(this.f2555a, "Unable to open content: " + this.f2556b, e);
                } else {
                    Log.w(this.f2555a, "Unable to open content");
                }
                this.f2559o = f2532e;
                this.f2560p = f2532e;
                this.f2553L.onError(this.f2562r, f2534g, f2533f);
                e.printStackTrace();
            } catch (Throwable e2) {
                if (this.f2556b != null) {
                    Log.w(this.f2555a, "Unable to open content: " + this.f2556b, e2);
                } else {
                    Log.w(this.f2555a, "Unable to open content");
                }
                this.f2559o = f2532e;
                this.f2560p = f2532e;
                this.f2553L.onError(this.f2562r, f2534g, f2533f);
                e2.printStackTrace();
            }
        }
    }

    public void m2592a(MediaController mediaController) {
        if (this.f2567w != null) {
            this.f2567w.hide();
        }
        this.f2567w = mediaController;
        m2583g();
    }

    private void m2583g() {
        if (this.f2562r != null && this.f2567w != null) {
            View view;
            this.f2567w.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.f2567w.setAnchorView(view);
            this.f2567w.setEnabled(m2585i());
        }
    }

    public void m2590a(OnPreparedListener onPreparedListener) {
        this.f2569y = onPreparedListener;
    }

    public void m2588a(OnCompletionListener onCompletionListener) {
        this.f2568x = onCompletionListener;
    }

    public void m2589a(OnErrorListener onErrorListener) {
        this.f2542A = onErrorListener;
    }

    private void m2580a(boolean z) {
        if (this.f2562r != null) {
            this.f2562r.reset();
            this.f2562r.release();
            this.f2562r = null;
            this.f2559o = f2533f;
            if (z) {
                this.f2560p = f2533f;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (m2585i() && this.f2567w != null) {
            m2584h();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent ev) {
        if (m2585i() && this.f2567w != null) {
            m2584h();
        }
        return false;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean z = (keyCode == f2537j || keyCode == 24 || keyCode == 25 || keyCode == 82 || keyCode == f2538k || keyCode == f2539l) ? false : true;
        if (m2585i() && z && this.f2567w != null) {
            if (keyCode == 79 || keyCode == 85) {
                if (this.f2562r.isPlaying()) {
                    pause();
                    this.f2567w.show();
                    return true;
                }
                start();
                this.f2567w.hide();
                return true;
            } else if (keyCode == 86 && this.f2562r.isPlaying()) {
                pause();
                this.f2567w.show();
            } else {
                m2584h();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void m2584h() {
        if (this.f2567w.isShowing()) {
            this.f2567w.hide();
        } else {
            this.f2567w.show();
        }
    }

    public void start() {
        if (m2585i()) {
            this.f2562r.start();
            this.f2559o = f2536i;
        }
        this.f2560p = f2536i;
    }

    public void pause() {
        if (m2585i() && this.f2562r.isPlaying()) {
            this.f2562r.pause();
            this.f2559o = f2537j;
        }
        this.f2560p = f2537j;
    }

    public void m2596c() {
        if (m2585i()) {
            this.f2562r.stop();
            this.f2548G = this.f2559o;
            this.f2559o = f2539l;
            this.f2560p = f2539l;
        }
    }

    public void m2597d() {
        if (this.f2561q == null && this.f2559o == f2539l) {
            this.f2560p = f2540m;
        } else if (this.f2562r != null && this.f2559o == f2539l) {
            this.f2562r.start();
            this.f2559o = this.f2548G;
            this.f2560p = this.f2548G;
        } else if (this.f2559o == f2541n) {
            m2582f();
        }
    }

    public int getDuration() {
        if (!m2585i()) {
            this.f2558d = f2532e;
            return this.f2558d;
        } else if (this.f2558d > 0) {
            return this.f2558d;
        } else {
            this.f2558d = this.f2562r.getDuration();
            return this.f2558d;
        }
    }

    public int getCurrentPosition() {
        if (m2585i()) {
            return this.f2562r.getCurrentPosition();
        }
        return f2533f;
    }

    public void seekTo(int msec) {
        if (m2585i()) {
            this.f2562r.seekTo(msec);
            this.f2543B = f2533f;
            return;
        }
        this.f2543B = msec;
    }

    public boolean isPlaying() {
        return m2585i() && this.f2562r.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f2562r != null) {
            return this.f2570z;
        }
        return f2533f;
    }

    private boolean m2585i() {
        return (this.f2562r == null || this.f2559o == f2532e || this.f2559o == 0 || this.f2559o == f2534g) ? false : true;
    }

    public boolean canPause() {
        return this.f2544C;
    }

    public boolean canSeekBackward() {
        return this.f2545D;
    }

    public boolean canSeekForward() {
        return this.f2546E;
    }
}
