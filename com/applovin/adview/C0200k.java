package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* renamed from: com.applovin.adview.k */
class C0200k implements OnCompletionListener {
    final /* synthetic */ AppLovinInterstitialActivity f25a;

    C0200k(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f25a = appLovinInterstitialActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f25a.f3747m = true;
        this.f25a.m4048s();
    }
}
