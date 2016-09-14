package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.C0600b;

public class YouTubeBaseActivity extends Activity {
    private C1375a f1164a;
    private YouTubePlayerView f1165b;
    private int f1166c;
    private Bundle f1167d;

    /* renamed from: com.google.android.youtube.player.YouTubeBaseActivity.a */
    private final class C1375a implements C0600b {
        final /* synthetic */ YouTubeBaseActivity f4236a;

        private C1375a(YouTubeBaseActivity youTubeBaseActivity) {
            this.f4236a = youTubeBaseActivity;
        }

        public final void m4737a(YouTubePlayerView youTubePlayerView) {
            if (!(this.f4236a.f1165b == null || this.f4236a.f1165b == youTubePlayerView)) {
                this.f4236a.f1165b.m4769c(true);
            }
            this.f4236a.f1165b = youTubePlayerView;
            if (this.f4236a.f1166c > 0) {
                youTubePlayerView.m4763a();
            }
            if (this.f4236a.f1166c >= 2) {
                youTubePlayerView.m4766b();
            }
        }

        public final void m4738a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            youTubePlayerView.m4764a(this.f4236a, youTubePlayerView, str, onInitializedListener, this.f4236a.f1167d);
            this.f4236a.f1167d = null;
        }
    }

    final C0600b m1164a() {
        return this.f1164a;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1164a = new C1375a();
        this.f1167d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    protected void onDestroy() {
        if (this.f1165b != null) {
            this.f1165b.m4767b(isFinishing());
        }
        super.onDestroy();
    }

    protected void onPause() {
        this.f1166c = 1;
        if (this.f1165b != null) {
            this.f1165b.m4768c();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f1166c = 2;
        if (this.f1165b != null) {
            this.f1165b.m4766b();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", this.f1165b != null ? this.f1165b.m4771e() : this.f1167d);
    }

    protected void onStart() {
        super.onStart();
        this.f1166c = 1;
        if (this.f1165b != null) {
            this.f1165b.m4763a();
        }
    }

    protected void onStop() {
        this.f1166c = 0;
        if (this.f1165b != null) {
            this.f1165b.m4770d();
        }
        super.onStop();
    }
}
