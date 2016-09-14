package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0608j.C1398a;

/* renamed from: com.google.android.youtube.player.internal.p */
public final class C1533p extends C1381a {
    private final Handler f4882a;
    private C1382b f4883b;
    private C0609k f4884c;
    private boolean f4885d;
    private boolean f4886e;

    /* renamed from: com.google.android.youtube.player.internal.p.a */
    private final class C1532a extends C1398a {
        final /* synthetic */ C1533p f4881a;

        /* renamed from: com.google.android.youtube.player.internal.p.a.1 */
        class C06131 implements Runnable {
            final /* synthetic */ boolean f1192a;
            final /* synthetic */ boolean f1193b;
            final /* synthetic */ Bitmap f1194c;
            final /* synthetic */ String f1195d;
            final /* synthetic */ C1532a f1196e;

            C06131(C1532a c1532a, boolean z, boolean z2, Bitmap bitmap, String str) {
                this.f1196e = c1532a;
                this.f1192a = z;
                this.f1193b = z2;
                this.f1194c = bitmap;
                this.f1195d = str;
            }

            public final void run() {
                this.f1196e.f4881a.f4885d = this.f1192a;
                this.f1196e.f4881a.f4886e = this.f1193b;
                this.f1196e.f4881a.m4777a(this.f1194c, this.f1195d);
            }
        }

        /* renamed from: com.google.android.youtube.player.internal.p.a.2 */
        class C06142 implements Runnable {
            final /* synthetic */ boolean f1197a;
            final /* synthetic */ boolean f1198b;
            final /* synthetic */ String f1199c;
            final /* synthetic */ C1532a f1200d;

            C06142(C1532a c1532a, boolean z, boolean z2, String str) {
                this.f1200d = c1532a;
                this.f1197a = z;
                this.f1198b = z2;
                this.f1199c = str;
            }

            public final void run() {
                this.f1200d.f4881a.f4885d = this.f1197a;
                this.f1200d.f4881a.f4886e = this.f1198b;
                this.f1200d.f4881a.m4782b(this.f1199c);
            }
        }

        private C1532a(C1533p c1533p) {
            this.f4881a = c1533p;
        }

        public final void m5785a(Bitmap bitmap, String str, boolean z, boolean z2) {
            this.f4881a.f4882a.post(new C06131(this, z, z2, bitmap, str));
        }

        public final void m5786a(String str, boolean z, boolean z2) {
            this.f4881a.f4882a.post(new C06142(this, z, z2, str));
        }
    }

    public C1533p(C1382b c1382b, YouTubeThumbnailView youTubeThumbnailView) {
        super(youTubeThumbnailView);
        this.f4883b = (C1382b) ab.m1184a((Object) c1382b, (Object) "connectionClient cannot be null");
        this.f4884c = c1382b.m4793a(new C1532a());
        this.f4882a = new Handler(Looper.getMainLooper());
    }

    public final void m5790a(String str) {
        try {
            this.f4884c.m1250a(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m5791a(String str, int i) {
        try {
            this.f4884c.m1251a(str, i);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final boolean m5792a() {
        return super.m4780a() && this.f4884c != null;
    }

    public final void m5793c() {
        try {
            this.f4884c.m1249a();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m5794d() {
        try {
            this.f4884c.m1252b();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m5795e() {
        try {
            this.f4884c.m1253c();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean m5796f() {
        return this.f4886e;
    }

    public final boolean m5797g() {
        return this.f4885d;
    }

    public final void m5798h() {
        try {
            this.f4884c.m1254d();
        } catch (RemoteException e) {
        }
        this.f4883b.m1267d();
        this.f4884c = null;
        this.f4883b = null;
    }
}
