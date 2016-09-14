package com.startapp.android.publish.video.p026b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.VideoView;
import com.android.volley.DefaultRetryPolicy;

/* renamed from: com.startapp.android.publish.video.b.b */
public class StartAppSDK extends StartAppSDK implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private MediaPlayer f4954g;
    private VideoView f4955h;

    /* renamed from: com.startapp.android.publish.video.b.b.a */
    public enum StartAppSDK {
        MEDIA_ERROR_IO,
        MEDIA_ERROR_MALFORMED,
        MEDIA_ERROR_UNSUPPORTED,
        MEDIA_ERROR_TIMED_OUT;

        public static StartAppSDK m3912a(int i) {
            switch (i) {
                case -1010:
                    return MEDIA_ERROR_UNSUPPORTED;
                case -1007:
                    return MEDIA_ERROR_MALFORMED;
                case -1004:
                    return MEDIA_ERROR_IO;
                case -110:
                    return MEDIA_ERROR_TIMED_OUT;
                default:
                    return MEDIA_ERROR_IO;
            }
        }
    }

    /* renamed from: com.startapp.android.publish.video.b.b.b */
    public enum StartAppSDK {
        MEDIA_ERROR_UNKNOWN,
        MEDIA_ERROR_SERVER_DIED;

        public static StartAppSDK m3913a(int i) {
            if (i == 100) {
                return MEDIA_ERROR_SERVER_DIED;
            }
            return MEDIA_ERROR_UNKNOWN;
        }
    }

    public StartAppSDK(VideoView videoView) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "Ctor");
        this.f4955h = videoView;
        this.f4955h.setOnPreparedListener(this);
        this.f4955h.setOnCompletionListener(this);
        this.f4955h.setOnErrorListener(this);
    }

    public void m6047a() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "start");
        this.f4955h.start();
    }

    public void m6048a(int i) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "seekTo(" + i + ")");
        this.f4955h.seekTo(i);
    }

    public void m6051b() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "pause");
        this.f4955h.pause();
    }

    public void m6052c() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "stop");
        this.f4955h.stopPlayback();
    }

    public void m6050a(boolean z) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "setMute(" + z + ")");
        if (this.f4954g == null) {
            return;
        }
        if (z) {
            this.f4954g.setVolume(0.0f, 0.0f);
        } else {
            this.f4954g.setVolume(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
    }

    public void m6053d() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "replay");
        if (this.a != null && this.f4954g != null) {
            this.f4955h.setVideoPath(this.a);
        }
    }

    public int m6054e() {
        return this.f4955h.getCurrentPosition();
    }

    public int m6055f() {
        return this.f4955h.getDuration();
    }

    public boolean m6056g() {
        return this.f4954g != null;
    }

    public void m6049a(String str) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "setVideoLocation(" + str + ")");
        super.m5625a(str);
        this.f4955h.setVideoPath(this.a);
    }

    public void m6057h() {
        if (this.f4954g != null) {
            this.f4954g = null;
        }
    }

    public void onPrepared(MediaPlayer mp) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "onPrepared");
        this.f4954g = mp;
        if (this.b != null) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 3, "Dispatching onPrepared");
            this.b.m3916a();
        }
    }

    public void onCompletion(MediaPlayer mp) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 4, "onCompletion");
        if (this.d != null) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 3, "Dispatching onCompletion");
            this.d.m3914a();
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 6, "onError(" + what + ", " + extra + ")");
        if (this.c == null) {
            return false;
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("NativeVideoPlayer", 3, "Dispatching onError");
        return this.c.m3915a(m6046a(what, extra));
    }

    private StartAppSDK m6046a(int i, int i2) {
        return new StartAppSDK(StartAppSDK.m3913a(i) == StartAppSDK.MEDIA_ERROR_SERVER_DIED ? StartAppSDK.SERVER_DIED : StartAppSDK.UNKNOWN, StartAppSDK.m3912a(i2).toString());
    }
}
