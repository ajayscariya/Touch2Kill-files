package com.startapp.android.publish.list3d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: StartAppSDK */
class SimpleDynamics extends Dynamics implements Parcelable {
    public static final Creator<SimpleDynamics> CREATOR;
    private float f4755f;
    private float f4756g;

    /* renamed from: com.startapp.android.publish.list3d.SimpleDynamics.1 */
    static class StartAppSDK implements Creator<SimpleDynamics> {
        StartAppSDK() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3403a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3404a(x0);
        }

        public SimpleDynamics m3403a(Parcel parcel) {
            return new SimpleDynamics(parcel);
        }

        public SimpleDynamics[] m3404a(int i) {
            return new SimpleDynamics[i];
        }
    }

    public SimpleDynamics(float frictionFactor, float snapToFactor) {
        this.f4755f = frictionFactor;
        this.f4756g = snapToFactor;
    }

    protected void m5477a(int i) {
        this.b += m3383c() * this.f4756g;
        this.a += (this.b * ((float) i)) / 1000.0f;
        this.b *= this.f4755f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeFloat(this.f4755f);
        dest.writeFloat(this.f4756g);
    }

    public SimpleDynamics(Parcel in) {
        super(in);
        this.f4755f = in.readFloat();
        this.f4756g = in.readFloat();
    }

    static {
        CREATOR = new StartAppSDK();
    }

    public void m5476a(double d) {
        super.m3375a(d);
    }

    public String toString() {
        return super.toString() + ", Friction: [" + this.f4755f + "], Snap:[" + this.f4756g + "]";
    }
}
