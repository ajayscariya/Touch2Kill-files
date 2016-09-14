package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.C0320g;
import com.chartboost.sdk.C0320g.C0319b;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.bc.C0361b;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.File;
import mf.javax.xml.XMLConstants;

/* renamed from: com.chartboost.sdk.Libraries.j */
public final class C1201j implements C0319b {
    private C0281a f3992a;
    private C0320g f3993b;
    private String f3994c;
    private float f3995d;
    private C0361b f3996e;

    /* renamed from: com.chartboost.sdk.Libraries.j.2 */
    class C02802 implements Runnable {
        final /* synthetic */ C0269a f548a;
        final /* synthetic */ String f549b;
        final /* synthetic */ Bundle f550c;
        final /* synthetic */ C1201j f551d;

        C02802(C1201j c1201j, C0269a c0269a, String str, Bundle bundle) {
            this.f551d = c1201j;
            this.f548a = c0269a;
            this.f549b = str;
            this.f550c = bundle;
        }

        public void run() {
            String str = XMLConstants.NULL_NS_URI;
            if (!(this.f548a.m442e("checksum") == null || this.f548a.m442e("checksum").isEmpty())) {
                str = this.f548a.m442e("checksum");
            }
            bc.m956a().m962a(this.f549b, str, this.f551d.f3996e, null, this.f550c == null ? new Bundle() : this.f550c);
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.j.a */
    public static class C0281a {
        private int f552a;
        private String f553b;
        private File f554c;
        private Bitmap f555d;
        private C0278h f556e;
        private int f557f;
        private int f558g;

        public C0281a(String str, File file, C0278h c0278h) {
            this.f557f = -1;
            this.f558g = -1;
            this.f554c = file;
            this.f553b = str;
            this.f555d = null;
            this.f552a = 1;
            this.f556e = c0278h;
        }

        public Bitmap m544a() {
            if (this.f555d == null) {
                m545b();
            }
            return this.f555d;
        }

        public void m545b() {
            if (this.f555d == null) {
                CBLogging.m379a("MemoryBitmap", "Loading image '" + this.f553b + "' from cache");
                byte[] b = this.f556e.m515b(this.f554c);
                if (b == null) {
                    CBLogging.m381b("MemoryBitmap", "decode() - bitmap not found");
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(b, 0, b.length, options);
                Options options2 = new Options();
                options2.inJustDecodeBounds = false;
                options2.inDither = false;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                options2.inTempStorage = new byte[AccessibilityNodeInfoCompat.ACTION_PASTE];
                options2.inSampleSize = 1;
                while (options2.inSampleSize < 32) {
                    try {
                        this.f555d = BitmapFactory.decodeByteArray(b, 0, b.length, options2);
                        break;
                    } catch (Throwable e) {
                        CBLogging.m382b("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", e);
                        options2.inSampleSize *= 2;
                    } catch (Throwable e2) {
                        CBLogging.m382b("MemoryBitmap", "Exception raised decoding bitmap", e2);
                    }
                }
                this.f552a = options2.inSampleSize;
            }
        }

        public void m546c() {
            try {
                if (!(this.f555d == null || this.f555d.isRecycled())) {
                    this.f555d.recycle();
                }
            } catch (Exception e) {
            }
            this.f555d = null;
        }

        public int m547d() {
            if (this.f555d != null) {
                return this.f555d.getWidth();
            }
            if (this.f557f >= 0) {
                return this.f557f;
            }
            m543f();
            return this.f557f;
        }

        public int m548e() {
            if (this.f555d != null) {
                return this.f555d.getHeight();
            }
            if (this.f558g >= 0) {
                return this.f558g;
            }
            m543f();
            return this.f558g;
        }

        private void m543f() {
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f554c.getAbsolutePath(), options);
                this.f557f = options.outWidth;
                this.f558g = options.outHeight;
            } catch (Throwable e) {
                CBLogging.m382b("MemoryBitmap", "Error decoding file size", e);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Libraries.j.1 */
    class C12001 implements C0361b {
        final /* synthetic */ C1201j f3991a;

        C12001(C1201j c1201j) {
            this.f3991a = c1201j;
        }

        public void m4338a(C0281a c0281a, Bundle bundle) {
            this.f3991a.f3992a = c0281a;
            this.f3991a.f3993b.m773a(this.f3991a);
        }
    }

    public C1201j(C0320g c0320g) {
        this.f3995d = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f3996e = new C12001(this);
        this.f3993b = c0320g;
    }

    public int m4345b() {
        return this.f3992a.m547d() * this.f3992a.f552a;
    }

    public int m4346c() {
        return this.f3992a.m548e() * this.f3992a.f552a;
    }

    public void m4343a(String str) {
        m4342a(this.f3993b.m785g(), str, new Bundle());
    }

    public void m4342a(C0269a c0269a, String str, Bundle bundle) {
        C0269a a = c0269a.m431a(str);
        this.f3994c = str;
        if (!a.m435b()) {
            Object e = a.m442e(DatabaseOpenHelper.HISTORY_ROW_URL);
            this.f3995d = a.m431a("scale").m429a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            if (!TextUtils.isEmpty(e)) {
                this.f3993b.m779b((C0319b) this);
                CBUtility.m400e().post(new C02802(this, a, e, bundle));
            }
        }
    }

    public boolean m4344a() {
        return m4348e();
    }

    public void m4347d() {
        if (this.f3992a != null) {
            this.f3992a.m546c();
        }
    }

    public boolean m4348e() {
        return this.f3992a != null;
    }

    public Bitmap m4349f() {
        return this.f3992a != null ? this.f3992a.m544a() : null;
    }

    public float m4350g() {
        return this.f3995d;
    }

    public int m4351h() {
        return Math.round(((float) m4345b()) / this.f3995d);
    }

    public int m4352i() {
        return Math.round(((float) m4346c()) / this.f3995d);
    }
}
