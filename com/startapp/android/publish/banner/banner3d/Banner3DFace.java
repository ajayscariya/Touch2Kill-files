package com.startapp.android.publish.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.startapp.android.publish.banner.BannerOptions;
import com.startapp.android.publish.model.AdDetails;
import com.startapp.android.publish.model.MetaData;

/* compiled from: StartAppSDK */
public class Banner3DFace implements Parcelable, com.startapp.android.publish.p022h.StartAppSDK.StartAppSDK {
    public static final Creator<Banner3DFace> CREATOR;
    private AdDetails f4669a;
    private Point f4670b;
    private Bitmap f4671c;
    private Bitmap f4672d;
    private Boolean f4673e;
    private com.startapp.android.publish.p022h.StartAppSDK f4674f;
    private StartAppSDK f4675g;

    /* renamed from: com.startapp.android.publish.banner.banner3d.Banner3DFace.1 */
    static class StartAppSDK implements Creator<Banner3DFace> {
        StartAppSDK() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m2954a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m2955a(x0);
        }

        public Banner3DFace m2954a(Parcel parcel) {
            return new Banner3DFace(parcel);
        }

        public Banner3DFace[] m2955a(int i) {
            return new Banner3DFace[i];
        }
    }

    public Banner3DFace(Context context, ViewGroup parent, AdDetails adDetails, BannerOptions options, com.startapp.android.publish.p022h.StartAppSDK params) {
        this.f4671c = null;
        this.f4672d = null;
        this.f4673e = Boolean.valueOf(false);
        this.f4675g = null;
        this.f4669a = adDetails;
        this.f4674f = params;
        m5383a(context, options, parent);
    }

    public AdDetails m5381a() {
        return this.f4669a;
    }

    public Bitmap m5385b() {
        return this.f4672d;
    }

    public void m5383a(Context context, BannerOptions bannerOptions, ViewGroup viewGroup) {
        int a = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, bannerOptions.m2936e() - 5);
        this.f4670b = new Point((int) (((float) com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, bannerOptions.m2935d())) * bannerOptions.m2942k()), (int) (((float) com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, bannerOptions.m2936e())) * bannerOptions.m2943l()));
        this.f4675g = new StartAppSDK(context, new Point(bannerOptions.m2935d(), bannerOptions.m2936e()));
        this.f4675g.setText(m5381a().getTitle());
        this.f4675g.setRating(m5381a().getRating());
        this.f4675g.setDescription(m5381a().getDescription());
        this.f4675g.setButtonText(this.f4669a.isCPE());
        if (this.f4671c != null) {
            this.f4675g.m2964a(this.f4671c, a, a);
        } else {
            this.f4675g.m2963a(17301651, a, a);
            new com.startapp.android.publish.p022h.StartAppSDK(m5381a().getImageUrl(), this, 0).m3204a();
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Banner3DFace", 3, " Banner Face Image Async Request: [" + m5381a().getTitle() + "]");
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4670b.x, this.f4670b.y);
        layoutParams.addRule(13);
        viewGroup.addView(this.f4675g, layoutParams);
        this.f4675g.setVisibility(8);
        m5380c();
    }

    private void m5380c() {
        this.f4672d = m5379a(this.f4675g);
        if (this.f4670b.x > 0 && this.f4670b.y > 0) {
            this.f4672d = Bitmap.createScaledBitmap(this.f4672d, this.f4670b.x, this.f4670b.y, false);
        }
    }

    private Bitmap m5379a(View view) {
        view.measure(view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return createBitmap;
    }

    public void m5384a(Bitmap bitmap, int i) {
        if (bitmap != null && this.f4675g != null) {
            this.f4671c = bitmap;
            this.f4675g.setImage(bitmap);
            m5380c();
        }
    }

    public void m5382a(Context context) {
        if (!this.f4673e.booleanValue()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("Banner3DFace", 3, "Sending Impression: [" + m5381a().getTitle() + "]");
            com.startapp.android.publish.p022h.StartAppSDK.m3301a(context, m5381a().getTrackingUrl(), this.f4674f);
            this.f4673e = Boolean.valueOf(true);
        }
    }

    public void m5386b(Context context) {
        String intentPackageName = m5381a().getIntentPackageName();
        if (intentPackageName != null && !"null".equals(intentPackageName) && !TextUtils.isEmpty(intentPackageName)) {
            com.startapp.android.publish.p022h.StartAppSDK.m3316a(intentPackageName, m5381a().getIntentDetails(), m5381a().getClickUrl(), context, this.f4674f);
        } else if (m5381a().isSmartRedirect()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3305a(context, m5381a().getClickUrl(), m5381a().getTrackingClickUrl(), m5381a().getPackageName(), this.f4674f, MetaData.getInstance().getSmartRedirectTimeout(), m5381a().isStartappBrowserEnabled());
        } else {
            com.startapp.android.publish.p022h.StartAppSDK.m3303a(context, m5381a().getClickUrl(), m5381a().getTrackingClickUrl(), this.f4674f, m5381a().isStartappBrowserEnabled());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(m5381a(), flags);
        dest.writeInt(this.f4670b.x);
        dest.writeInt(this.f4670b.y);
        dest.writeParcelable(this.f4671c, flags);
        dest.writeBooleanArray(new boolean[]{this.f4673e.booleanValue()});
        dest.writeSerializable(this.f4674f);
    }

    public Banner3DFace(Parcel in) {
        this.f4671c = null;
        this.f4672d = null;
        this.f4673e = Boolean.valueOf(false);
        this.f4675g = null;
        this.f4669a = (AdDetails) in.readParcelable(AdDetails.class.getClassLoader());
        this.f4670b = new Point(1, 1);
        this.f4670b.x = in.readInt();
        this.f4670b.y = in.readInt();
        this.f4671c = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
        boolean[] zArr = new boolean[1];
        in.readBooleanArray(zArr);
        this.f4673e = Boolean.valueOf(zArr[0]);
        this.f4674f = (com.startapp.android.publish.p022h.StartAppSDK) in.readSerializable();
    }

    static {
        CREATOR = new StartAppSDK();
    }
}
