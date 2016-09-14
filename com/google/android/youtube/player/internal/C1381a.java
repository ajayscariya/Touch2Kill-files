package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason;
import com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener;
import com.google.android.youtube.player.YouTubeThumbnailView;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.youtube.player.internal.a */
public abstract class C1381a implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> f4268a;
    private OnThumbnailLoadedListener f4269b;
    private boolean f4270c;
    private boolean f4271d;

    public C1381a(YouTubeThumbnailView youTubeThumbnailView) {
        this.f4268a = new WeakReference(ab.m1183a((Object) youTubeThumbnailView));
    }

    private void m4776i() {
        if (!m4780a()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    public final void m4777a(Bitmap bitmap, String str) {
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) this.f4268a.get();
        if (m4780a() && youTubeThumbnailView != null) {
            youTubeThumbnailView.setImageBitmap(bitmap);
            if (this.f4269b != null) {
                this.f4269b.onThumbnailLoaded(youTubeThumbnailView, str);
            }
        }
    }

    public abstract void m4778a(String str);

    public abstract void m4779a(String str, int i);

    protected boolean m4780a() {
        return !this.f4271d;
    }

    public final void m4781b() {
        if (m4780a()) {
            C0627y.m1275a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            release();
        }
    }

    public final void m4782b(String str) {
        YouTubeThumbnailView youTubeThumbnailView = (YouTubeThumbnailView) this.f4268a.get();
        if (m4780a() && this.f4269b != null && youTubeThumbnailView != null) {
            ErrorReason valueOf;
            try {
                valueOf = ErrorReason.valueOf(str);
            } catch (IllegalArgumentException e) {
                valueOf = ErrorReason.UNKNOWN;
            } catch (NullPointerException e2) {
                valueOf = ErrorReason.UNKNOWN;
            }
            this.f4269b.onThumbnailError(youTubeThumbnailView, valueOf);
        }
    }

    public abstract void m4783c();

    public abstract void m4784d();

    public abstract void m4785e();

    public abstract boolean m4786f();

    public final void first() {
        m4776i();
        if (this.f4270c) {
            m4785e();
            return;
        }
        throw new IllegalStateException("Must call setPlaylist first");
    }

    public abstract boolean m4787g();

    public abstract void m4788h();

    public final boolean hasNext() {
        m4776i();
        return m4786f();
    }

    public final boolean hasPrevious() {
        m4776i();
        return m4787g();
    }

    public final void next() {
        m4776i();
        if (!this.f4270c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (m4786f()) {
            m4783c();
        } else {
            throw new NoSuchElementException("Called next at end of playlist");
        }
    }

    public final void previous() {
        m4776i();
        if (!this.f4270c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (m4787g()) {
            m4784d();
        } else {
            throw new NoSuchElementException("Called previous at start of playlist");
        }
    }

    public final void release() {
        if (m4780a()) {
            this.f4271d = true;
            this.f4269b = null;
            m4788h();
        }
    }

    public final void setOnThumbnailLoadedListener(OnThumbnailLoadedListener onThumbnailLoadedListener) {
        m4776i();
        this.f4269b = onThumbnailLoadedListener;
    }

    public final void setPlaylist(String str) {
        setPlaylist(str, 0);
    }

    public final void setPlaylist(String str, int i) {
        m4776i();
        this.f4270c = true;
        m4779a(str, i);
    }

    public final void setVideo(String str) {
        m4776i();
        this.f4270c = false;
        m4778a(str);
    }
}
