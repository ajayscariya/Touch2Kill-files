package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* renamed from: com.applovin.adview.c */
class C0194c implements OnErrorListener {
    final /* synthetic */ C0193b f14a;

    C0194c(C0193b c0193b) {
        this.f14a = c0193b;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f14a.f13a.f3755u.post(new C0195d(this, i, i2));
        return true;
    }
}
