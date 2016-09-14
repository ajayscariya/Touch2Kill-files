package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.adview.b */
class C0193b implements OnPreparedListener {
    final /* synthetic */ AppLovinInterstitialActivity f13a;

    C0193b(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f13a = appLovinInterstitialActivity;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f13a.f3734E = new WeakReference(mediaPlayer);
        int i = this.f13a.m4015c() ? 0 : 1;
        mediaPlayer.setVolume((float) i, (float) i);
        i = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f13a.f3754t = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
        this.f13a.f3757w.setVideoSize(i, videoHeight);
        mediaPlayer.setDisplay(this.f13a.f3757w.getHolder());
        mediaPlayer.setOnErrorListener(new C0194c(this));
        this.f13a.m4037m();
        this.f13a.m4026h();
        this.f13a.m4041o();
        this.f13a.m4022f();
    }
}
