package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.volley.DefaultRetryPolicy;
import com.chartboost.sdk.impl.C0415l.C0414a;
import com.chartboost.sdk.impl.C0420n.C0418a;
import com.chartboost.sdk.impl.C0420n.C0419b;

public class ab extends C0415l<Bitmap> {
    private static final Object f4029e;
    private final C0419b<Bitmap> f4030a;
    private final Config f4031b;
    private final int f4032c;
    private final int f4033d;

    protected /* synthetic */ void m4434b(Object obj) {
        m4433a((Bitmap) obj);
    }

    static {
        f4029e = new Object();
    }

    public ab(String str, C0419b<Bitmap> c0419b, int i, int i2, Config config, C0418a c0418a) {
        super(0, str, c0418a);
        m1088a(new C1244d(1000, 2, 2.0f));
        this.f4030a = c0419b;
        this.f4031b = config;
        this.f4032c = i;
        this.f4033d = i2;
    }

    public C0414a m4435s() {
        return C0414a.LOW;
    }

    private static int m4430b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) ((((double) i2) / ((double) i4)) * ((double) i3));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (((double) i) * d > ((double) i2)) {
            return (int) (((double) i2) / d);
        }
        return i;
    }

    protected C0420n<Bitmap> m4432a(C0412i c0412i) {
        C0420n<Bitmap> b;
        synchronized (f4029e) {
            try {
                b = m4431b(c0412i);
            } catch (Throwable e) {
                C0426t.m1144c("Caught OOM for %d byte image, url=%s", Integer.valueOf(c0412i.f1101b.length), m1098d());
                b = C0420n.m1129a(new C1247k(e));
            }
        }
        return b;
    }

    private C0420n<Bitmap> m4431b(C0412i c0412i) {
        Object decodeByteArray;
        byte[] bArr = c0412i.f1101b;
        Options options = new Options();
        if (this.f4032c == 0 && this.f4033d == 0) {
            options.inPreferredConfig = this.f4031b;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = m4430b(this.f4032c, this.f4033d, i, i2);
            int b2 = m4430b(this.f4033d, this.f4032c, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m4429a(i, i2, b, b2);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray2 == null || (decodeByteArray2.getWidth() <= b && decodeByteArray2.getHeight() <= b2)) {
                Bitmap bitmap = decodeByteArray2;
            } else {
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray2, b, b2, true);
                decodeByteArray2.recycle();
            }
        }
        if (decodeByteArray == null) {
            return C0420n.m1129a(new C1247k(c0412i));
        }
        return C0420n.m1130a(decodeByteArray, C0432y.m1155a(c0412i));
    }

    protected void m4433a(Bitmap bitmap) {
        this.f4030a.m1128a(bitmap);
    }

    static int m4429a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        while (((double) (f * 2.0f)) <= min) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
