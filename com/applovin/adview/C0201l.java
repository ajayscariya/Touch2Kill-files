package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* renamed from: com.applovin.adview.l */
class C0201l implements OnErrorListener {
    final /* synthetic */ AppLovinInterstitialActivity f26a;

    C0201l(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f26a = appLovinInterstitialActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f26a.f3755u.post(new C0202m(this, i, i2));
        return true;
    }
}
