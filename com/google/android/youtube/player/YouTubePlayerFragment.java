package com.google.android.youtube.player;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.C0600b;
import com.google.android.youtube.player.internal.ab;

public class YouTubePlayerFragment extends Fragment implements Provider {
    private final C1376a f4238a;
    private Bundle f4239b;
    private YouTubePlayerView f4240c;
    private String f4241d;
    private OnInitializedListener f4242e;
    private boolean f4243f;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerFragment.a */
    private final class C1376a implements C0600b {
        final /* synthetic */ YouTubePlayerFragment f4237a;

        private C1376a(YouTubePlayerFragment youTubePlayerFragment) {
            this.f4237a = youTubePlayerFragment;
        }

        public final void m4739a(YouTubePlayerView youTubePlayerView) {
        }

        public final void m4740a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            this.f4237a.initialize(str, this.f4237a.f4242e);
        }
    }

    public YouTubePlayerFragment() {
        this.f4238a = new C1376a();
    }

    private void m4742a() {
        if (this.f4240c != null && this.f4242e != null) {
            this.f4240c.m4765a(this.f4243f);
            this.f4240c.m4764a(getActivity(), this, this.f4241d, this.f4242e, this.f4239b);
            this.f4239b = null;
            this.f4242e = null;
        }
    }

    public static YouTubePlayerFragment newInstance() {
        return new YouTubePlayerFragment();
    }

    public void initialize(String str, OnInitializedListener onInitializedListener) {
        this.f4241d = ab.m1185a(str, (Object) "Developer key cannot be null or empty");
        this.f4242e = onInitializedListener;
        m4742a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4239b = bundle != null ? bundle.getBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4240c = new YouTubePlayerView(getActivity(), null, 0, this.f4238a);
        m4742a();
        return this.f4240c;
    }

    public void onDestroy() {
        if (this.f4240c != null) {
            Activity activity = getActivity();
            YouTubePlayerView youTubePlayerView = this.f4240c;
            boolean z = activity == null || activity.isFinishing();
            youTubePlayerView.m4767b(z);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f4240c.m4769c(getActivity().isFinishing());
        this.f4240c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.f4240c.m4768c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f4240c.m4766b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE", this.f4240c != null ? this.f4240c.m4771e() : this.f4239b);
    }

    public void onStart() {
        super.onStart();
        this.f4240c.m4763a();
    }

    public void onStop() {
        this.f4240c.m4770d();
        super.onStop();
    }
}
