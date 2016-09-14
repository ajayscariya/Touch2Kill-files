package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;

public class ADCImage {
    static int f2169k;
    static int f2170l;
    Bitmap f2171a;
    Bitmap f2172b;
    Paint f2173c;
    Rect f2174d;
    Rect f2175e;
    int f2176f;
    int f2177g;
    boolean f2178h;
    int f2179i;
    int f2180j;
    boolean f2181m;
    ArrayList<Bitmap> f2182n;

    ADCImage(String filepath) {
        this(filepath, 1.0d);
    }

    ADCImage(String filepath, int width, int height) {
        this(filepath, 1.0d);
        m2406b(width, height);
    }

    ADCImage(String filepath, boolean is_native, boolean down_state) {
        this(filepath, 1.0d, down_state, is_native);
    }

    ADCImage(String filepath, boolean down_state) {
        this(filepath, 1.0d, down_state);
    }

    ADCImage(String filepath, double scale) {
        this(filepath, scale, false);
    }

    ADCImage(String filepath, double scale, boolean down_state) {
        this(filepath, scale, down_state, false);
    }

    ADCImage(String filepath, double scale, boolean down_state, boolean is_native) {
        this.f2173c = new Paint();
        this.f2174d = new Rect();
        this.f2175e = new Rect();
        this.f2182n = new ArrayList();
        try {
            InputStream fileInputStream = new FileInputStream(filepath);
            this.f2171a = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            this.f2172b = this.f2171a;
            this.f2176f = this.f2171a.getWidth();
            this.f2177g = this.f2171a.getHeight();
            this.f2179i = this.f2171a.getWidth();
            this.f2180j = this.f2171a.getHeight();
            f2169k = this.f2179i;
            f2170l = this.f2180j;
            m2401a(scale);
            this.f2178h = true;
            if (down_state) {
                this.f2171a = convertToMutable(this.f2171a);
                int[] iArr = new int[(this.f2171a.getWidth() * this.f2171a.getHeight())];
                this.f2171a.getPixels(iArr, 0, this.f2171a.getWidth(), 0, 0, this.f2171a.getWidth(), this.f2171a.getHeight());
                int i = 0;
                while (i < iArr.length) {
                    if (iArr[i] < 255 && iArr[i] != 0) {
                        iArr[i] = ((iArr[i] >> 1) & 8355711) | ViewCompat.MEASURED_STATE_MASK;
                    }
                    i++;
                }
                this.f2171a.setPixels(iArr, 0, this.f2171a.getWidth(), 0, 0, this.f2171a.getWidth(), this.f2171a.getHeight());
                this.f2172b = this.f2171a;
            }
            if (!is_native) {
                C0694a.an.add(this.f2171a);
                this.f2182n.add(this.f2171a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0694a.m2461e("Failed to load image " + filepath);
            this.f2181m = true;
        }
    }

    void m2403a(int i, int i2) {
        if (this.f2171a != null) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f2172b, 0, 0, this.f2179i / 3, this.f2180j);
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f2172b, (this.f2179i * 2) / 3, 0, this.f2179i / 3, this.f2180j);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(this.f2172b, this.f2179i / 3, 0, this.f2179i / 3, this.f2180j), i, this.f2180j, false);
            int[] iArr = new int[((this.f2179i / 3) * this.f2180j)];
            int[] iArr2 = new int[((this.f2179i / 3) * this.f2180j)];
            createBitmap.getPixels(iArr, 0, this.f2179i / 3, 0, 0, this.f2179i / 3, this.f2180j);
            createBitmap2.getPixels(iArr2, 0, this.f2179i / 3, 0, 0, this.f2179i / 3, this.f2180j);
            createScaledBitmap.getPixels(new int[(createScaledBitmap.getWidth() * createScaledBitmap.getHeight())], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i6 < createScaledBitmap.getHeight()) {
                if (i5 < this.f2179i / 3) {
                    if (i4 < iArr.length) {
                        createScaledBitmap.setPixel(i5, i6, iArr[i4]);
                    }
                    i4++;
                } else if (i5 >= createScaledBitmap.getWidth() - (this.f2179i / 3)) {
                    if (i3 < iArr2.length) {
                        createScaledBitmap.setPixel(i5, i6, iArr2[i3]);
                    }
                    i3++;
                }
                i5++;
                if (i5 == createScaledBitmap.getWidth()) {
                    i6++;
                    i5 = 0;
                }
            }
            this.f2171a = createScaledBitmap;
            this.f2172b = this.f2171a;
            this.f2176f = this.f2171a.getWidth();
            this.f2177g = this.f2171a.getHeight();
            this.f2179i = this.f2176f;
            this.f2180j = this.f2177g;
            this.f2174d.right = this.f2176f;
            this.f2174d.bottom = this.f2177g;
        }
    }

    void m2406b(int i, int i2) {
        if (this.f2171a != null && !this.f2171a.isRecycled()) {
            if (i != this.f2176f || i2 != this.f2177g) {
                this.f2171a = Bitmap.createScaledBitmap(this.f2172b, i, i2, true);
                this.f2176f = i;
                this.f2177g = i2;
                this.f2174d.right = i;
                this.f2174d.bottom = i2;
                C0694a.an.add(this.f2171a);
                this.f2182n.add(this.f2171a);
            }
        }
    }

    void m2401a(double d) {
        m2402a(d, false);
    }

    void m2402a(double d, boolean z) {
        if (this.f2171a != null && !this.f2171a.isRecycled()) {
            if (d != 1.0d) {
                int width = (int) (((double) this.f2172b.getWidth()) * d);
                int height = (int) (((double) this.f2172b.getHeight()) * d);
                if (!(width == this.f2176f && height == this.f2177g)) {
                    this.f2176f = width;
                    this.f2177g = height;
                    this.f2171a = Bitmap.createScaledBitmap(this.f2172b, this.f2176f, this.f2177g, true);
                    if (!z) {
                        C0694a.an.add(this.f2171a);
                        this.f2182n.add(this.f2171a);
                    }
                }
                if (z) {
                    this.f2172b.recycle();
                    this.f2172b = null;
                }
            }
            this.f2174d.right = this.f2176f;
            this.f2174d.bottom = this.f2177g;
        }
    }

    void m2400a() {
        Iterator it = this.f2182n.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        this.f2182n.clear();
    }

    void m2409c(int i, int i2) {
        this.f2175e.left = i;
        this.f2175e.top = i2;
        this.f2175e.right = this.f2176f + i;
        this.f2175e.bottom = this.f2177g + i2;
    }

    int[] m2407b() {
        return new int[]{this.f2175e.left, this.f2175e.top};
    }

    int m2408c() {
        return this.f2175e.left;
    }

    int m2410d() {
        return this.f2175e.top;
    }

    void m2411d(int i, int i2) {
        m2409c((i - this.f2176f) / 2, (i2 - this.f2177g) / 2);
    }

    void m2405a(Canvas canvas, int i, int i2) {
        m2409c(i, i2);
        m2404a(canvas);
    }

    void m2404a(Canvas canvas) {
        if (this.f2171a != null && !this.f2171a.isRecycled()) {
            canvas.drawBitmap(this.f2171a, this.f2174d, this.f2175e, this.f2173c);
        }
    }

    public static Bitmap convertToMutable(Bitmap img_in) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            int i = f2169k;
            int i2 = f2170l;
            Config config = img_in.getConfig();
            FileChannel channel = randomAccessFile.getChannel();
            Buffer map = channel.map(MapMode.READ_WRITE, 0, (long) (img_in.getRowBytes() * i2));
            img_in.copyPixelsToBuffer(map);
            img_in = Bitmap.createBitmap(i, i2, config);
            map.position(0);
            img_in.copyPixelsFromBuffer(map);
            channel.close();
            randomAccessFile.close();
            file.delete();
            return img_in;
        } catch (Exception e) {
            e.printStackTrace();
            return img_in;
        }
    }
}
