package com.startapp.android.publish.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.startapp.android.publish.model.AdDetails;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* compiled from: StartAppSDK */
public class NativeAdDetails implements Parcelable, com.startapp.android.publish.p022h.StartAppSDK.StartAppSDK, NativeAdInterface {
    public static final Creator<NativeAdDetails> CREATOR;
    private AdDetails f4757a;
    private int f4758b;
    private Bitmap f4759c;
    private boolean f4760d;
    private StartAppSDK f4761e;
    private String f4762f;

    /* renamed from: com.startapp.android.publish.nativead.NativeAdDetails.1 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ NativeAdDetails f3482a;

        StartAppSDK(NativeAdDetails nativeAdDetails) {
            this.f3482a = nativeAdDetails;
        }

        public void run() {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppNativeAd", 3, "SingleAd [" + this.f3482a.f4758b + "] Loaded");
            if (this.f3482a.f4761e != null) {
                this.f3482a.f4761e.onNativeAdDetailsLoaded(this.f3482a.f4758b);
            }
        }
    }

    /* renamed from: com.startapp.android.publish.nativead.NativeAdDetails.2 */
    static class StartAppSDK implements Creator<NativeAdDetails> {
        StartAppSDK() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3491a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3492a(x0);
        }

        public NativeAdDetails m3491a(Parcel parcel) {
            return new NativeAdDetails(parcel);
        }

        public NativeAdDetails[] m3492a(int i) {
            return new NativeAdDetails[i];
        }
    }

    /* renamed from: com.startapp.android.publish.nativead.NativeAdDetails.3 */
    static /* synthetic */ class StartAppSDK {
        static final /* synthetic */ int[] f3483a;

        static {
            f3483a = new int[com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK.values().length];
            try {
                f3483a[com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK.OPEN_MARKET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3483a[com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK.LAUNCH_APP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.startapp.android.publish.nativead.NativeAdDetails.a */
    protected interface StartAppSDK {
        void onNativeAdDetailsLoaded(int i);
    }

    public NativeAdDetails(AdDetails adDetails, NativeAdPreferences config, int identifier, StartAppSDK singleAdLoadedListener) {
        this.f4760d = false;
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppNativeAd", 3, "Initializiang SingleAd [" + identifier + "]");
        this.f4757a = adDetails;
        this.f4758b = identifier;
        this.f4761e = singleAdLoadedListener;
        if (config.isAutoBitmapDownload()) {
            new com.startapp.android.publish.p022h.StartAppSDK(getImageUrl(), this, identifier).m3204a();
        } else {
            m5481b();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("         Title: [" + getTitle() + "]\n");
        stringBuffer.append("         Description: [" + getDescription().substring(0, 30) + "]...\n");
        stringBuffer.append("         Rating: [" + getRating() + "]\n");
        stringBuffer.append("         Installs: [" + getInstalls() + "]\n");
        stringBuffer.append("         Category: [" + getCategory() + "]\n");
        stringBuffer.append("         PackageName: [" + getPackacgeName() + "]\n");
        stringBuffer.append("         CampaginAction: [" + getCampaignAction() + "]\n");
        return stringBuffer.toString();
    }

    private void m5479a(Bitmap bitmap) {
        this.f4759c = bitmap;
    }

    public void m5483a(Bitmap bitmap, int i) {
        m5479a(bitmap);
        m5481b();
    }

    private void m5481b() {
        new Handler().post(new StartAppSDK(this));
    }

    protected void m5484a(String str) {
        this.f4762f = str;
    }

    public String getTitle() {
        String str = XMLConstants.NULL_NS_URI;
        if (this.f4757a != null) {
            return this.f4757a.getTitle();
        }
        return str;
    }

    public String getDescription() {
        String str = XMLConstants.NULL_NS_URI;
        if (this.f4757a != null) {
            return this.f4757a.getDescription();
        }
        return str;
    }

    public float getRating() {
        if (this.f4757a != null) {
            return this.f4757a.getRating();
        }
        return 5.0f;
    }

    public String getImageUrl() {
        String str = "http://www.dummy.com";
        if (this.f4757a != null) {
            return this.f4757a.getImageUrl();
        }
        return str;
    }

    public Bitmap getImageBitmap() {
        return this.f4759c;
    }

    public String getInstalls() {
        String str = XMLConstants.NULL_NS_URI;
        if (this.f4757a != null) {
            return this.f4757a.getInstalls();
        }
        return str;
    }

    public String getCategory() {
        String str = XMLConstants.NULL_NS_URI;
        if (this.f4757a != null) {
            return this.f4757a.getCategory();
        }
        return str;
    }

    public String getPackacgeName() {
        String str = XMLConstants.NULL_NS_URI;
        if (this.f4757a != null) {
            return this.f4757a.getPackageName();
        }
        return str;
    }

    public com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK getCampaignAction() {
        com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK startAppSDK = com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK.OPEN_MARKET;
        if (this.f4757a == null || !this.f4757a.isCPE()) {
            return startAppSDK;
        }
        return com.startapp.android.publish.nativead.StartAppNativeAd.StartAppSDK.LAUNCH_APP;
    }

    protected AdDetails m5482a() {
        return this.f4757a;
    }

    public void sendClick(Context context) {
        if (this.f4757a != null) {
            switch (StartAppSDK.f3483a[getCampaignAction().ordinal()]) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    if (this.f4757a.isSmartRedirect()) {
                        com.startapp.android.publish.p022h.StartAppSDK.m3305a(context, this.f4757a.getClickUrl(), this.f4757a.getTrackingClickUrl(), this.f4757a.getPackageName(), new com.startapp.android.publish.p022h.StartAppSDK(this.f4762f), MetaData.getInstance().getSmartRedirectTimeout(), this.f4757a.isStartappBrowserEnabled());
                        return;
                    }
                    com.startapp.android.publish.p022h.StartAppSDK.m3303a(context, this.f4757a.getClickUrl(), this.f4757a.getTrackingClickUrl(), new com.startapp.android.publish.p022h.StartAppSDK(this.f4762f), this.f4757a.isStartappBrowserEnabled());
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    com.startapp.android.publish.p022h.StartAppSDK.m3316a(getPackacgeName(), this.f4757a.getIntentDetails(), this.f4757a.getClickUrl(), context, new com.startapp.android.publish.p022h.StartAppSDK(this.f4762f));
                default:
            }
        }
    }

    public void sendImpression(Context context) {
        if (this.f4760d) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppNativeAd", 3, "Already sent impression for [" + this.f4758b + "]");
            return;
        }
        this.f4760d = true;
        if (this.f4757a != null) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppNativeAd", 3, "Sending Impression for [" + this.f4758b + "]");
            com.startapp.android.publish.p022h.StartAppSDK.m3301a(context, this.f4757a.getTrackingUrl(), new com.startapp.android.publish.p022h.StartAppSDK(this.f4762f));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2;
        int i3 = 0;
        if (this.f4757a != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (getImageBitmap() != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.f4760d) {
            i3 = 1;
        }
        dest.writeInt(i);
        if (i == 1) {
            dest.writeParcelable(this.f4757a, flags);
        }
        dest.writeInt(i2);
        if (i2 == 1) {
            dest.writeParcelable(getImageBitmap(), flags);
        }
        dest.writeInt(i3);
        dest.writeInt(this.f4758b);
        dest.writeString(this.f4762f);
    }

    public NativeAdDetails(Parcel in) {
        this.f4760d = false;
        if (in.readInt() == 1) {
            this.f4757a = (AdDetails) in.readParcelable(AdDetails.class.getClassLoader());
        }
        if (in.readInt() == 1) {
            m5479a((Bitmap) in.readParcelable(Bitmap.class.getClassLoader()));
        }
        int readInt = in.readInt();
        this.f4760d = false;
        if (readInt == 1) {
            this.f4760d = true;
        }
        this.f4758b = in.readInt();
        this.f4762f = in.readString();
    }

    static {
        CREATOR = new StartAppSDK();
    }
}
