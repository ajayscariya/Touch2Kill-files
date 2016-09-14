package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.google.android.youtube.player.internal.C1381a;
import com.google.android.youtube.player.internal.C1382b;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;

public final class YouTubeThumbnailView extends ImageView {
    private C1382b f1177a;
    private C1381a f1178b;

    public interface OnInitializedListener {
        void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult);

        void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader);
    }

    /* renamed from: com.google.android.youtube.player.YouTubeThumbnailView.a */
    private static final class C1380a implements C0620a, C0621b {
        private YouTubeThumbnailView f4266a;
        private OnInitializedListener f4267b;

        public C1380a(YouTubeThumbnailView youTubeThumbnailView, OnInitializedListener onInitializedListener) {
            this.f4266a = (YouTubeThumbnailView) ab.m1184a((Object) youTubeThumbnailView, (Object) "thumbnailView cannot be null");
            this.f4267b = (OnInitializedListener) ab.m1184a((Object) onInitializedListener, (Object) "onInitializedlistener cannot be null");
        }

        private void m4772c() {
            if (this.f4266a != null) {
                this.f4266a.f1177a = null;
                this.f4266a = null;
                this.f4267b = null;
            }
        }

        public final void m4773a() {
            if (this.f4266a != null && this.f4266a.f1177a != null) {
                this.f4266a.f1178b = aa.m1178a().m1180a(this.f4266a.f1177a, this.f4266a);
                this.f4267b.onInitializationSuccess(this.f4266a, this.f4266a.f1178b);
                m4772c();
            }
        }

        public final void m4774a(YouTubeInitializationResult youTubeInitializationResult) {
            this.f4267b.onInitializationFailure(this.f4266a, youTubeInitializationResult);
            m4772c();
        }

        public final void m4775b() {
            m4772c();
        }
    }

    public YouTubeThumbnailView(Context context) {
        this(context, null);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void finalize() throws Throwable {
        if (this.f1178b != null) {
            this.f1178b.m4781b();
            this.f1178b = null;
        }
        super.finalize();
    }

    public final void initialize(String str, OnInitializedListener onInitializedListener) {
        Object c1380a = new C1380a(this, onInitializedListener);
        this.f1177a = aa.m1178a().m1181a(getContext(), str, c1380a, c1380a);
        this.f1177a.m1268e();
    }
}
