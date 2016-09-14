package com.startapp.android.publish.list3d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.startapp.android.publish.model.AdDetails;
import mf.javax.xml.XMLConstants;

/* compiled from: StartAppSDK */
public class ListItem implements Parcelable {
    public static final Creator<ListItem> CREATOR;
    private String f3404a;
    private String f3405b;
    private String f3406c;
    private String f3407d;
    private String f3408e;
    private String f3409f;
    private String f3410g;
    private String f3411h;
    private float f3412i;
    private boolean f3413j;
    private boolean f3414k;
    private Drawable f3415l;
    private String f3416m;
    private String f3417n;
    private String f3418o;

    /* renamed from: com.startapp.android.publish.list3d.ListItem.1 */
    static class StartAppSDK implements Creator<ListItem> {
        StartAppSDK() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3385a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3386a(x0);
        }

        public ListItem m3385a(Parcel parcel) {
            return new ListItem(parcel);
        }

        public ListItem[] m3386a(int i) {
            return new ListItem[i];
        }
    }

    public ListItem(AdDetails adDetails) {
        this.f3404a = XMLConstants.NULL_NS_URI;
        this.f3405b = XMLConstants.NULL_NS_URI;
        this.f3406c = XMLConstants.NULL_NS_URI;
        this.f3407d = XMLConstants.NULL_NS_URI;
        this.f3408e = XMLConstants.NULL_NS_URI;
        this.f3409f = XMLConstants.NULL_NS_URI;
        this.f3410g = XMLConstants.NULL_NS_URI;
        this.f3411h = XMLConstants.NULL_NS_URI;
        this.f3412i = 0.0f;
        this.f3413j = false;
        this.f3414k = true;
        this.f3415l = null;
        this.f3418o = XMLConstants.NULL_NS_URI;
        this.f3404a = adDetails.getAdId();
        this.f3405b = adDetails.getClickUrl();
        this.f3406c = adDetails.getTrackingUrl();
        this.f3407d = adDetails.getTrackingClickUrl();
        this.f3408e = adDetails.getPackageName();
        this.f3409f = adDetails.getTitle();
        this.f3410g = adDetails.getDescription();
        this.f3411h = adDetails.getImageUrl();
        this.f3412i = adDetails.getRating();
        this.f3413j = adDetails.isSmartRedirect();
        this.f3414k = adDetails.isStartappBrowserEnabled();
        this.f3415l = null;
        this.f3418o = adDetails.getTemplate();
        this.f3416m = adDetails.getIntentDetails();
        this.f3417n = adDetails.getIntentPackageName();
    }

    public ListItem(Parcel in) {
        this.f3404a = XMLConstants.NULL_NS_URI;
        this.f3405b = XMLConstants.NULL_NS_URI;
        this.f3406c = XMLConstants.NULL_NS_URI;
        this.f3407d = XMLConstants.NULL_NS_URI;
        this.f3408e = XMLConstants.NULL_NS_URI;
        this.f3409f = XMLConstants.NULL_NS_URI;
        this.f3410g = XMLConstants.NULL_NS_URI;
        this.f3411h = XMLConstants.NULL_NS_URI;
        this.f3412i = 0.0f;
        this.f3413j = false;
        this.f3414k = true;
        this.f3415l = null;
        this.f3418o = XMLConstants.NULL_NS_URI;
        if (in.readInt() == 1) {
            this.f3415l = new BitmapDrawable((Bitmap) Bitmap.CREATOR.createFromParcel(in));
        } else {
            this.f3415l = null;
        }
        this.f3404a = in.readString();
        this.f3405b = in.readString();
        this.f3406c = in.readString();
        this.f3407d = in.readString();
        this.f3408e = in.readString();
        this.f3409f = in.readString();
        this.f3410g = in.readString();
        this.f3411h = in.readString();
        this.f3412i = in.readFloat();
        if (in.readInt() == 1) {
            this.f3413j = true;
        } else {
            this.f3413j = false;
        }
        if (in.readInt() == 0) {
            this.f3414k = false;
        } else {
            this.f3414k = true;
        }
        this.f3418o = in.readString();
        this.f3417n = in.readString();
        this.f3416m = in.readString();
    }

    public String m3387a() {
        return this.f3404a;
    }

    public String m3388b() {
        return this.f3405b;
    }

    public String m3389c() {
        return this.f3406c;
    }

    public String m3390d() {
        return this.f3407d;
    }

    public String m3391e() {
        return this.f3408e;
    }

    public String m3392f() {
        return this.f3409f;
    }

    public String m3393g() {
        return this.f3410g;
    }

    public String m3394h() {
        return this.f3411h;
    }

    public Drawable m3395i() {
        return this.f3415l;
    }

    public float m3396j() {
        return this.f3412i;
    }

    public boolean m3397k() {
        return this.f3413j;
    }

    public boolean m3398l() {
        return this.f3414k;
    }

    public String m3399m() {
        return this.f3418o;
    }

    public String m3400n() {
        return this.f3416m;
    }

    public String m3401o() {
        return this.f3417n;
    }

    public boolean m3402p() {
        return this.f3417n != null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 0;
        if (m3395i() != null) {
            dest.writeParcelable(((BitmapDrawable) m3395i()).getBitmap(), flags);
            dest.writeInt(1);
        } else {
            dest.writeInt(0);
        }
        dest.writeString(this.f3404a);
        dest.writeString(this.f3405b);
        dest.writeString(this.f3406c);
        dest.writeString(this.f3407d);
        dest.writeString(this.f3408e);
        dest.writeString(this.f3409f);
        dest.writeString(this.f3410g);
        dest.writeString(this.f3411h);
        dest.writeFloat(this.f3412i);
        if (this.f3413j) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (this.f3414k) {
            i2 = 1;
        }
        dest.writeInt(i2);
        dest.writeString(this.f3418o);
        dest.writeString(this.f3417n);
        dest.writeString(this.f3416m);
    }

    static {
        CREATOR = new StartAppSDK();
    }
}
