package com.chartboost.sdk.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0263b;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.C1201j.C0281a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.C0420n.C0418a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mf.javax.xml.XMLConstants;

public final class bc {
    private static volatile bc f939c;
    private C0278h f940a;
    private Map<String, C0281a> f941b;

    /* renamed from: com.chartboost.sdk.impl.bc.a */
    private class C0360a implements Runnable {
        final /* synthetic */ bc f932a;
        private String f933b;
        private final WeakReference<ImageView> f934c;
        private C0361b f935d;
        private String f936e;
        private Bundle f937f;

        /* renamed from: com.chartboost.sdk.impl.bc.a.3 */
        class C03593 implements Runnable {
            final /* synthetic */ C0281a f930a;
            final /* synthetic */ C0360a f931b;

            C03593(C0360a c0360a, C0281a c0281a) {
                this.f931b = c0360a;
                this.f930a = c0281a;
            }

            public void run() {
                if (this.f931b.f934c != null) {
                    ImageView imageView = (ImageView) this.f931b.f934c.get();
                    C0360a a = bc.m959b(imageView);
                    if (this.f930a != null && this.f931b == a) {
                        imageView.setImageBitmap(this.f930a.m544a());
                    }
                }
                if (this.f931b.f935d != null) {
                    this.f931b.f935d.m951a(this.f930a, this.f931b.f937f);
                }
            }
        }

        /* renamed from: com.chartboost.sdk.impl.bc.a.1 */
        class C12371 implements C0418a {
            final /* synthetic */ C0360a f4140a;

            C12371(C0360a c0360a) {
                this.f4140a = c0360a;
            }

            public void m4577a(C0423s c0423s) {
                CBLogging.m381b("CBWebImageCache", "Error downloading the bitmap image from the server");
                if (!(c0423s == null || TextUtils.isEmpty(c0423s.getMessage()))) {
                    CBLogging.m381b("CBWebImageCache", c0423s.getMessage());
                }
                if (c0423s != null && c0423s.f1141a != null) {
                    CBLogging.m381b("CBWebImageCache", "Error status Code: " + c0423s.f1141a.f1100a);
                }
            }
        }

        /* renamed from: com.chartboost.sdk.impl.bc.a.2 */
        class C12382 extends C0415l<String> {
            final /* synthetic */ C0360a f4141a;

            C12382(C0360a c0360a, int i, String str, C0418a c0418a) {
                this.f4141a = c0360a;
                super(i, str, c0418a);
            }

            protected /* synthetic */ void m4579b(Object obj) {
                m4580c((String) obj);
            }

            protected C0420n<String> m4578a(C0412i c0412i) {
                try {
                    byte[] bArr = c0412i.f1101b;
                    String b = C0263b.m407b(C0263b.m406a(bArr));
                    if (TextUtils.isEmpty(b)) {
                        b = XMLConstants.NULL_NS_URI;
                    }
                    if (!b.equals(this.f4141a.f936e)) {
                        this.f4141a.f936e = b;
                        CBLogging.m381b("CBWebImageCache:ImageDownloader", "Error: checksum did not match while downloading from " + this.f4141a.f933b);
                    }
                    this.f4141a.f932a.f940a.m512a(this.f4141a.f932a.f940a.m531r(), String.format("%s%s", new Object[]{this.f4141a.f936e, ".png"}), bArr);
                    this.f4141a.f932a.m954a(this.f4141a.f936e);
                    return C0420n.m1130a(null, null);
                } catch (Exception e) {
                    return C0420n.m1129a(new C0423s("Bitmap response data is empty, unable to download the bitmap"));
                }
            }

            protected void m4580c(String str) {
                this.f4141a.m950a();
            }
        }

        public C0360a(bc bcVar, ImageView imageView, C0361b c0361b, String str, Bundle bundle, String str2) {
            this.f932a = bcVar;
            this.f934c = new WeakReference(imageView);
            Drawable c0362c = new C0362c(this);
            if (imageView != null) {
                imageView.setImageDrawable(c0362c);
            }
            this.f936e = str;
            this.f935d = c0361b;
            this.f937f = bundle;
            this.f933b = str2;
        }

        public void run() {
            if (this.f932a.m961b(this.f936e)) {
                m950a();
                return;
            }
            C0418a c12371 = new C12371(this);
            CBLogging.m379a("CBWebImageCache", "downloading image to cache... " + this.f933b);
            ba.m914a(C0299c.m682y()).m927a().m1119a(new C12382(this, 0, this.f933b, c12371));
        }

        public void m950a() {
            C0281a b = m945b();
            if (!(b == null || this.f934c == null || this.f934c.get() == null || this != bc.m959b((ImageView) this.f934c.get()))) {
                b.m545b();
            }
            CBUtility.m400e().post(new C03593(this, b));
        }

        private C0281a m945b() {
            return (C0281a) this.f932a.f941b.get(this.f936e);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bc.b */
    public interface C0361b {
        void m951a(C0281a c0281a, Bundle bundle);
    }

    /* renamed from: com.chartboost.sdk.impl.bc.c */
    static class C0362c extends BitmapDrawable {
        private final WeakReference<C0360a> f938a;

        public C0362c(C0360a c0360a) {
            this.f938a = new WeakReference(c0360a);
        }

        public C0360a m952a() {
            return (C0360a) this.f938a.get();
        }
    }

    static {
        f939c = null;
    }

    public static bc m956a() {
        if (f939c == null) {
            synchronized (bc.class) {
                if (f939c == null) {
                    f939c = new bc();
                }
            }
        }
        return f939c;
    }

    private bc() {
        this.f940a = new C0278h(true);
        this.f941b = new HashMap();
    }

    public void m963b() {
        this.f940a.m522h();
        this.f941b.clear();
    }

    public void m962a(String str, String str2, C0361b c0361b, ImageView imageView, Bundle bundle) {
        C0281a a = m954a(str2);
        if (a != null) {
            if (imageView != null) {
                imageView.setImageBitmap(a.m544a());
            }
            if (c0361b != null) {
                c0361b.m951a(a, bundle);
                return;
            }
            return;
        }
        if (str == null && c0361b != null) {
            c0361b.m951a(null, bundle);
        }
        ax.m845a().execute(new C0360a(this, imageView, c0361b, str2, bundle, str));
    }

    private C0281a m954a(String str) {
        if (!m961b(str)) {
            if (this.f941b.containsKey(str)) {
                this.f941b.remove(str);
            }
            return null;
        } else if (this.f941b.containsKey(str)) {
            return (C0281a) this.f941b.get(str);
        } else {
            C0281a c0281a = new C0281a(str, this.f940a.m516c(this.f940a.m531r(), String.format("%s%s", new Object[]{str, ".png"})), this.f940a);
            this.f941b.put(str, c0281a);
            return c0281a;
        }
    }

    private static C0360a m959b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof C0362c) {
                return ((C0362c) drawable).m952a();
            }
        }
        return null;
    }

    private boolean m961b(String str) {
        return this.f940a.m517c(String.format("%s%s", new Object[]{str, ".png"}));
    }
}
