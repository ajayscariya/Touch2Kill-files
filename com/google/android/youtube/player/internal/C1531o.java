package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.C0610l.C1402a;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.google.android.youtube.player.internal.C1404r.C1534d;

/* renamed from: com.google.android.youtube.player.internal.o */
public final class C1531o extends C1404r<C0610l> implements C1382b {
    private final String f4877b;
    private final String f4878c;
    private final String f4879d;
    private boolean f4880e;

    public C1531o(Context context, String str, String str2, String str3, C0620a c0620a, C0621b c0621b) {
        super(context, c0620a, c0621b);
        this.f4877b = (String) ab.m1183a((Object) str);
        this.f4878c = ab.m1185a(str2, (Object) "callingPackage cannot be null or empty");
        this.f4879d = ab.m1185a(str3, (Object) "callingAppVersion cannot be null or empty");
    }

    private final void m5776k() {
        m4891i();
        if (this.f4880e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    public final IBinder m5777a() {
        m5776k();
        try {
            return ((C0610l) m4892j()).m1255a();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final /* synthetic */ IInterface m5778a(IBinder iBinder) {
        return C1402a.m4869a(iBinder);
    }

    public final C0609k m5779a(C0608j c0608j) {
        m5776k();
        try {
            return ((C0610l) m4892j()).m1256a(c0608j);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final void m5780a(C0607i c0607i, C1534d c1534d) throws RemoteException {
        c0607i.m1246a(c1534d, 1202, this.f4878c, this.f4879d, this.f4877b, null);
    }

    public final void m5781a(boolean z) {
        if (m4888f()) {
            try {
                ((C0610l) m4892j()).m1257a(z);
            } catch (RemoteException e) {
            }
            this.f4880e = true;
        }
    }

    protected final String m5782b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    protected final String m5783c() {
        return "com.google.android.youtube.api.service.START";
    }

    public final void m5784d() {
        if (!this.f4880e) {
            m5781a(true);
        }
        super.m4886d();
    }
}
