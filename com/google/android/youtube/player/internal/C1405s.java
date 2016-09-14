package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.PlaylistEventListener;
import com.google.android.youtube.player.internal.C0603e.C1388a;
import com.google.android.youtube.player.internal.C0604f.C1390a;
import com.google.android.youtube.player.internal.C0605g.C1392a;
import com.google.android.youtube.player.internal.C0606h.C1394a;
import java.util.List;

/* renamed from: com.google.android.youtube.player.internal.s */
public final class C1405s implements YouTubePlayer {
    private C1382b f4296a;
    private C0602d f4297b;

    /* renamed from: com.google.android.youtube.player.internal.s.1 */
    class C15351 extends C1388a {
        final /* synthetic */ OnFullscreenListener f4888a;
        final /* synthetic */ C1405s f4889b;

        C15351(C1405s c1405s, OnFullscreenListener onFullscreenListener) {
            this.f4889b = c1405s;
            this.f4888a = onFullscreenListener;
        }

        public final void m5800a(boolean z) {
            this.f4888a.onFullscreen(z);
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.2 */
    class C15362 extends C1394a {
        final /* synthetic */ PlaylistEventListener f4890a;
        final /* synthetic */ C1405s f4891b;

        C15362(C1405s c1405s, PlaylistEventListener playlistEventListener) {
            this.f4891b = c1405s;
            this.f4890a = playlistEventListener;
        }

        public final void m5801a() {
            this.f4890a.onPrevious();
        }

        public final void m5802b() {
            this.f4890a.onNext();
        }

        public final void m5803c() {
            this.f4890a.onPlaylistEnded();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.3 */
    class C15373 extends C1392a {
        final /* synthetic */ PlayerStateChangeListener f4892a;
        final /* synthetic */ C1405s f4893b;

        C15373(C1405s c1405s, PlayerStateChangeListener playerStateChangeListener) {
            this.f4893b = c1405s;
            this.f4892a = playerStateChangeListener;
        }

        public final void m5804a() {
            this.f4892a.onLoading();
        }

        public final void m5805a(String str) {
            this.f4892a.onLoaded(str);
        }

        public final void m5806b() {
            this.f4892a.onAdStarted();
        }

        public final void m5807b(String str) {
            ErrorReason valueOf;
            try {
                valueOf = ErrorReason.valueOf(str);
            } catch (IllegalArgumentException e) {
                valueOf = ErrorReason.UNKNOWN;
            } catch (NullPointerException e2) {
                valueOf = ErrorReason.UNKNOWN;
            }
            this.f4892a.onError(valueOf);
        }

        public final void m5808c() {
            this.f4892a.onVideoStarted();
        }

        public final void m5809d() {
            this.f4892a.onVideoEnded();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.s.4 */
    class C15384 extends C1390a {
        final /* synthetic */ PlaybackEventListener f4894a;
        final /* synthetic */ C1405s f4895b;

        C15384(C1405s c1405s, PlaybackEventListener playbackEventListener) {
            this.f4895b = c1405s;
            this.f4894a = playbackEventListener;
        }

        public final void m5810a() {
            this.f4894a.onPlaying();
        }

        public final void m5811a(int i) {
            this.f4894a.onSeekTo(i);
        }

        public final void m5812a(boolean z) {
            this.f4894a.onBuffering(z);
        }

        public final void m5813b() {
            this.f4894a.onPaused();
        }

        public final void m5814c() {
            this.f4894a.onStopped();
        }
    }

    public C1405s(C1382b c1382b, C0602d c0602d) {
        this.f4296a = (C1382b) ab.m1184a((Object) c1382b, (Object) "connectionClient cannot be null");
        this.f4297b = (C0602d) ab.m1184a((Object) c0602d, (Object) "embeddedPlayer cannot be null");
    }

    public final View m4893a() {
        try {
            return (View) C1539v.m5816a(this.f4297b.m1230s());
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4894a(Configuration configuration) {
        try {
            this.f4297b.m1190a(configuration);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4895a(boolean z) {
        try {
            this.f4297b.m1199a(z);
            this.f4296a.m4794a(z);
            this.f4296a.m1267d();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean m4896a(int i, KeyEvent keyEvent) {
        try {
            return this.f4297b.m1200a(i, keyEvent);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean m4897a(Bundle bundle) {
        try {
            return this.f4297b.m1201a(bundle);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void addFullscreenControlFlag(int i) {
        try {
            this.f4297b.m1212d(i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4898b() {
        try {
            this.f4297b.m1224m();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4899b(boolean z) {
        try {
            this.f4297b.m1215e(z);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean m4900b(int i, KeyEvent keyEvent) {
        try {
            return this.f4297b.m1208b(i, keyEvent);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4901c() {
        try {
            this.f4297b.m1225n();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void cuePlaylist(String str) {
        cuePlaylist(str, 0, 0);
    }

    public final void cuePlaylist(String str, int i, int i2) {
        try {
            this.f4297b.m1197a(str, i, i2);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void cueVideo(String str) {
        cueVideo(str, 0);
    }

    public final void cueVideo(String str, int i) {
        try {
            this.f4297b.m1196a(str, i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void cueVideos(List<String> list) {
        cueVideos(list, 0, 0);
    }

    public final void cueVideos(List<String> list, int i, int i2) {
        try {
            this.f4297b.m1198a((List) list, i, i2);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4902d() {
        try {
            this.f4297b.m1226o();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4903e() {
        try {
            this.f4297b.m1227p();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4904f() {
        try {
            this.f4297b.m1228q();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void m4905g() {
        try {
            this.f4297b.m1223l();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.f4297b.m1219h();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.f4297b.m1220i();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final int getFullscreenControlFlags() {
        try {
            return this.f4297b.m1221j();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final Bundle m4906h() {
        try {
            return this.f4297b.m1229r();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean hasNext() {
        try {
            return this.f4297b.m1214d();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.f4297b.m1216e();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final boolean isPlaying() {
        try {
            return this.f4297b.m1211c();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void loadPlaylist(String str) {
        loadPlaylist(str, 0, 0);
    }

    public final void loadPlaylist(String str, int i, int i2) {
        try {
            this.f4297b.m1205b(str, i, i2);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void loadVideo(String str) {
        loadVideo(str, 0);
    }

    public final void loadVideo(String str, int i) {
        try {
            this.f4297b.m1204b(str, i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void loadVideos(List<String> list) {
        loadVideos(list, 0, 0);
    }

    public final void loadVideos(List<String> list, int i, int i2) {
        try {
            this.f4297b.m1206b((List) list, i, i2);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void next() {
        try {
            this.f4297b.m1217f();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void pause() {
        try {
            this.f4297b.m1202b();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void play() {
        try {
            this.f4297b.m1188a();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void previous() {
        try {
            this.f4297b.m1218g();
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void release() {
        m4895a(true);
    }

    public final void seekRelativeMillis(int i) {
        try {
            this.f4297b.m1203b(i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void seekToMillis(int i) {
        try {
            this.f4297b.m1189a(i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setFullscreen(boolean z) {
        try {
            this.f4297b.m1207b(z);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setFullscreenControlFlags(int i) {
        try {
            this.f4297b.m1209c(i);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setManageAudioFocus(boolean z) {
        try {
            this.f4297b.m1213d(z);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setOnFullscreenListener(OnFullscreenListener onFullscreenListener) {
        try {
            this.f4297b.m1191a(new C15351(this, onFullscreenListener));
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setPlaybackEventListener(PlaybackEventListener playbackEventListener) {
        try {
            this.f4297b.m1192a(new C15384(this, playbackEventListener));
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setPlayerStateChangeListener(PlayerStateChangeListener playerStateChangeListener) {
        try {
            this.f4297b.m1193a(new C15373(this, playerStateChangeListener));
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setPlayerStyle(PlayerStyle playerStyle) {
        try {
            this.f4297b.m1195a(playerStyle.name());
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setPlaylistEventListener(PlaylistEventListener playlistEventListener) {
        try {
            this.f4297b.m1194a(new C15362(this, playlistEventListener));
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }

    public final void setShowFullscreenButton(boolean z) {
        try {
            this.f4297b.m1210c(z);
        } catch (RemoteException e) {
            throw new C0615q(e);
        }
    }
}
