package com.startapp.android.publish.list3d;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.widget.AutoScrollHelper;
import android.view.animation.AnimationUtils;

/* compiled from: StartAppSDK */
public abstract class Dynamics implements Parcelable {
    protected float f3394a;
    protected float f3395b;
    protected float f3396c;
    protected float f3397d;
    protected long f3398e;

    protected abstract void m3378a(int i);

    public Dynamics() {
        this.f3396c = AutoScrollHelper.NO_MAX;
        this.f3397d = -3.4028235E38f;
        this.f3398e = 0;
    }

    public Dynamics(Parcel in) {
        this.f3396c = AutoScrollHelper.NO_MAX;
        this.f3397d = -3.4028235E38f;
        this.f3398e = 0;
        this.f3394a = in.readFloat();
        this.f3395b = in.readFloat();
        this.f3396c = in.readFloat();
        this.f3397d = in.readFloat();
        this.f3398e = AnimationUtils.currentAnimationTimeMillis();
    }

    public void m3377a(float f, float f2, long j) {
        this.f3395b = f2;
        this.f3394a = f;
        this.f3398e = j;
    }

    public float m3374a() {
        return this.f3394a;
    }

    public float m3381b() {
        return this.f3395b;
    }

    public boolean m3380a(float f, float f2) {
        boolean z;
        if (Math.abs(this.f3395b) < f) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (this.f3394a - f2 >= this.f3396c || this.f3394a + f2 <= this.f3397d) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    public void m3376a(float f) {
        this.f3396c = f;
    }

    public void m3382b(float f) {
        this.f3397d = f;
    }

    public void m3379a(long j) {
        int i = 50;
        if (this.f3398e != 0) {
            int i2 = (int) (j - this.f3398e);
            if (i2 <= 50) {
                i = i2;
            }
            m3378a(i);
        }
        this.f3398e = j;
    }

    protected float m3383c() {
        if (this.f3394a > this.f3396c) {
            return this.f3396c - this.f3394a;
        }
        if (this.f3394a < this.f3397d) {
            return this.f3397d - this.f3394a;
        }
        return 0.0f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.f3394a);
        dest.writeFloat(this.f3395b);
        dest.writeFloat(this.f3396c);
        dest.writeFloat(this.f3397d);
    }

    public void m3375a(double d) {
        this.f3394a = (float) (((double) this.f3394a) * d);
    }

    public String toString() {
        return "Position: [" + this.f3394a + "], Velocity:[" + this.f3395b + "], MaxPos: [" + this.f3396c + "], mMinPos: [" + this.f3397d + "] LastTime:[" + this.f3398e + "]";
    }
}
