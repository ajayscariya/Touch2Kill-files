package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.internal.C0601c.C1384a;
import com.google.android.youtube.player.internal.C0607i.C1396a;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.ArrayList;

/* renamed from: com.google.android.youtube.player.internal.r */
public abstract class C1404r<T extends IInterface> implements C0622t {
    final Handler f4285a;
    private final Context f4286b;
    private T f4287c;
    private ArrayList<C0620a> f4288d;
    private final ArrayList<C0620a> f4289e;
    private boolean f4290f;
    private ArrayList<C0621b> f4291g;
    private boolean f4292h;
    private final ArrayList<C0618b<?>> f4293i;
    private ServiceConnection f4294j;
    private boolean f4295k;

    /* renamed from: com.google.android.youtube.player.internal.r.1 */
    static /* synthetic */ class C06161 {
        static final /* synthetic */ int[] f1201a;

        static {
            f1201a = new int[YouTubeInitializationResult.values().length];
            try {
                f1201a[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.a */
    final class C0617a extends Handler {
        final /* synthetic */ C1404r f1202a;

        C0617a(C1404r c1404r) {
            this.f1202a = c1404r;
        }

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                this.f1202a.m4881a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (this.f1202a.f4288d) {
                    if (this.f1202a.f4295k && this.f1202a.m4888f() && this.f1202a.f4288d.contains(message.obj)) {
                        ((C0620a) message.obj).m1264a();
                    }
                }
            } else if (message.what == 2 && !this.f1202a.m4888f()) {
            } else {
                if (message.what == 2 || message.what == 1) {
                    ((C0618b) message.obj).m1261a();
                }
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.b */
    protected abstract class C0618b<TListener> {
        final /* synthetic */ C1404r f1203a;
        private TListener f1204b;

        public C0618b(C1404r c1404r, TListener tListener) {
            this.f1203a = c1404r;
            this.f1204b = tListener;
            synchronized (c1404r.f4293i) {
                c1404r.f4293i.add(this);
            }
        }

        public final void m1261a() {
            Object obj;
            synchronized (this) {
                obj = this.f1204b;
            }
            m1262a(obj);
        }

        protected abstract void m1262a(TListener tListener);

        public final void m1263b() {
            synchronized (this) {
                this.f1204b = null;
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.e */
    final class C0619e implements ServiceConnection {
        final /* synthetic */ C1404r f1205a;

        C0619e(C1404r c1404r) {
            this.f1205a = c1404r;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f1205a.m4884b(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f1205a.f4287c = null;
            this.f1205a.m4890h();
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.c */
    protected final class C1403c extends C0618b<Boolean> {
        public final YouTubeInitializationResult f4282b;
        public final IBinder f4283c;
        final /* synthetic */ C1404r f4284d;

        public C1403c(C1404r c1404r, String str, IBinder iBinder) {
            this.f4284d = c1404r;
            super(c1404r, Boolean.valueOf(true));
            this.f4282b = C1404r.m4875b(str);
            this.f4283c = iBinder;
        }

        protected final /* synthetic */ void m4870a(Object obj) {
            if (((Boolean) obj) != null) {
                switch (C06161.f1201a[this.f4282b.ordinal()]) {
                    case MainNavigationActivity.REQUEST_CODE /*1*/:
                        try {
                            if (this.f4284d.m4883b().equals(this.f4283c.getInterfaceDescriptor())) {
                                this.f4284d.f4287c = this.f4284d.m4880a(this.f4283c);
                                if (this.f4284d.f4287c != null) {
                                    this.f4284d.m4889g();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        this.f4284d.m4874a();
                        this.f4284d.m4881a(YouTubeInitializationResult.INTERNAL_ERROR);
                    default:
                        this.f4284d.m4881a(this.f4282b);
                }
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.internal.r.d */
    protected final class C1534d extends C1384a {
        final /* synthetic */ C1404r f4887a;

        protected C1534d(C1404r c1404r) {
            this.f4887a = c1404r;
        }

        public final void m5799a(String str, IBinder iBinder) {
            this.f4887a.f4285a.sendMessage(this.f4887a.f4285a.obtainMessage(1, new C1403c(this.f4887a, str, iBinder)));
        }
    }

    protected C1404r(Context context, C0620a c0620a, C0621b c0621b) {
        this.f4289e = new ArrayList();
        this.f4290f = false;
        this.f4292h = false;
        this.f4293i = new ArrayList();
        this.f4295k = false;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.f4286b = (Context) ab.m1183a((Object) context);
        this.f4288d = new ArrayList();
        this.f4288d.add(ab.m1183a((Object) c0620a));
        this.f4291g = new ArrayList();
        this.f4291g.add(ab.m1183a((Object) c0621b));
        this.f4285a = new C0617a(this);
    }

    private void m4874a() {
        if (this.f4294j != null) {
            try {
                this.f4286b.unbindService(this.f4294j);
            } catch (Throwable e) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e);
            }
        }
        this.f4287c = null;
        this.f4294j = null;
    }

    private static YouTubeInitializationResult m4875b(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException e) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException e2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    protected abstract T m4880a(IBinder iBinder);

    protected final void m4881a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f4285a.removeMessages(4);
        synchronized (this.f4291g) {
            this.f4292h = true;
            ArrayList arrayList = this.f4291g;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.f4295k) {
                    if (this.f4291g.contains(arrayList.get(i))) {
                        ((C0621b) arrayList.get(i)).m1266a(youTubeInitializationResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.f4292h = false;
        }
    }

    protected abstract void m4882a(C0607i c0607i, C1534d c1534d) throws RemoteException;

    protected abstract String m4883b();

    protected final void m4884b(IBinder iBinder) {
        try {
            m4882a(C1396a.m4856a(iBinder), new C1534d(this));
        } catch (RemoteException e) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract String m4885c();

    public void m4886d() {
        m4890h();
        this.f4295k = false;
        synchronized (this.f4293i) {
            int size = this.f4293i.size();
            for (int i = 0; i < size; i++) {
                ((C0618b) this.f4293i.get(i)).m1263b();
            }
            this.f4293i.clear();
        }
        m4874a();
    }

    public final void m4887e() {
        this.f4295k = true;
        YouTubeInitializationResult isYouTubeApiServiceAvailable = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.f4286b);
        if (isYouTubeApiServiceAvailable != YouTubeInitializationResult.SUCCESS) {
            this.f4285a.sendMessage(this.f4285a.obtainMessage(3, isYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(m4885c()).setPackage(C0628z.m1278a(this.f4286b));
        if (this.f4294j != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            m4874a();
        }
        this.f4294j = new C0619e(this);
        if (!this.f4286b.bindService(intent, this.f4294j, 129)) {
            this.f4285a.sendMessage(this.f4285a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
        }
    }

    public final boolean m4888f() {
        return this.f4287c != null;
    }

    protected final void m4889g() {
        boolean z = true;
        synchronized (this.f4288d) {
            ab.m1186a(!this.f4290f);
            this.f4285a.removeMessages(4);
            this.f4290f = true;
            if (this.f4289e.size() != 0) {
                z = false;
            }
            ab.m1186a(z);
            ArrayList arrayList = this.f4288d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f4295k && m4888f(); i++) {
                if (!this.f4289e.contains(arrayList.get(i))) {
                    ((C0620a) arrayList.get(i)).m1264a();
                }
            }
            this.f4289e.clear();
            this.f4290f = false;
        }
    }

    protected final void m4890h() {
        this.f4285a.removeMessages(4);
        synchronized (this.f4288d) {
            this.f4290f = true;
            ArrayList arrayList = this.f4288d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f4295k; i++) {
                if (this.f4288d.contains(arrayList.get(i))) {
                    ((C0620a) arrayList.get(i)).m1265b();
                }
            }
            this.f4290f = false;
        }
    }

    protected final void m4891i() {
        if (!m4888f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T m4892j() {
        m4891i();
        return this.f4287c;
    }
}
