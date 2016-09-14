package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.C0600b;
import com.google.android.youtube.player.internal.ab;

public class YouTubePlayerSupportFragment extends Fragment implements Provider {
    private final C1377a f4245a;
    private Bundle f4246b;
    private YouTubePlayerView f4247c;
    private String f4248d;
    private OnInitializedListener f4249e;
    private boolean f4250f;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerSupportFragment.a */
    private final class C1377a implements C0600b {
        final /* synthetic */ YouTubePlayerSupportFragment f4244a;

        private C1377a(YouTubePlayerSupportFragment youTubePlayerSupportFragment) {
            this.f4244a = youTubePlayerSupportFragment;
        }

        public final void m4743a(YouTubePlayerView youTubePlayerView) {
        }

        public final void m4744a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener) {
            this.f4244a.initialize(str, this.f4244a.f4249e);
        }
    }

    public YouTubePlayerSupportFragment() {
        this.f4245a = new C1377a();
    }

    private void m4746a() {
        if (this.f4247c != null && this.f4249e != null) {
            this.f4247c.m4765a(this.f4250f);
            this.f4247c.m4764a(getActivity(), this, this.f4248d, this.f4249e, this.f4246b);
            this.f4246b = null;
            this.f4249e = null;
        }
    }

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    public void initialize(String str, OnInitializedListener onInitializedListener) {
        this.f4248d = ab.m1185a(str, (Object) "Developer key cannot be null or empty");
        this.f4249e = onInitializedListener;
        m4746a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4246b = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4247c = new YouTubePlayerView(getActivity(), null, 0, this.f4245a);
        m4746a();
        return this.f4247c;
    }

    public void onDestroy() {
        if (this.f4247c != null) {
            Activity activity = getActivity();
            YouTubePlayerView youTubePlayerView = this.f4247c;
            boolean z = activity == null || activity.isFinishing();
            youTubePlayerView.m4767b(z);
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f4247c.m4769c(getActivity().isFinishing());
        this.f4247c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.f4247c.m4768c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f4247c.m4766b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", this.f4247c != null ? this.f4247c.m4771e() : this.f4246b);
    }

    public void onStart() {
        super.onStart();
        this.f4247c.m4763a();
    }

    public void onStop() {
        this.f4247c.m4770d();
        super.onStop();
    }
}
