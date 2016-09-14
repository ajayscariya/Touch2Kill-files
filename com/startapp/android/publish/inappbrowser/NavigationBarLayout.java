package com.startapp.android.publish.inappbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.wTouch2KiLL.DownloadsListActivity;

/* compiled from: StartAppSDK */
public class NavigationBarLayout extends RelativeLayout {
    private static final int f3375m;
    private static final int f3376n;
    private RelativeLayout f3377a;
    private ImageView f3378b;
    private ImageView f3379c;
    private ImageView f3380d;
    private ImageView f3381e;
    private Bitmap f3382f;
    private Bitmap f3383g;
    private Bitmap f3384h;
    private Bitmap f3385i;
    private TextView f3386j;
    private TextView f3387k;
    private Boolean f3388l;

    /* compiled from: StartAppSDK */
    static class SavedState extends BaseSavedState {
        public static final ClassLoaderCreator<SavedState> f3373b;
        SparseArray f3374a;

        /* renamed from: com.startapp.android.publish.inappbrowser.NavigationBarLayout.SavedState.1 */
        static class StartAppSDK implements ClassLoaderCreator<SavedState> {
            StartAppSDK() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m3362a(x0);
            }

            public /* synthetic */ Object createFromParcel(Parcel x0, ClassLoader x1) {
                return m3363a(x0, x1);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m3364a(x0);
            }

            public SavedState m3363a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(classLoader, null);
            }

            public SavedState m3362a(Parcel parcel) {
                return m3362a(null);
            }

            public SavedState[] m3364a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in, ClassLoader classLoader) {
            super(in);
            this.f3374a = in.readSparseArray(classLoader);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeSparseArray(this.f3374a);
        }

        static {
            f3373b = new StartAppSDK();
        }
    }

    static {
        f3375m = Color.rgb(78, 86, DownloadsListActivity.DOWNLOAD_COMPLETE);
        f3376n = Color.rgb(148, 155, 166);
    }

    public NavigationBarLayout(Context context) {
        super(context);
        this.f3388l = Boolean.valueOf(false);
    }

    public void m3366a() {
        setDescendantFocusability(AccessibilityNodeInfoCompat.ACTION_EXPAND);
        setBackgroundColor(Color.parseColor("#e9e9e9"));
        setLayoutParams(new LayoutParams(-1, com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), 60)));
        setId(2101);
    }

    public void m3368b() {
        Typeface typeface = Typeface.DEFAULT;
        this.f3386j = com.startapp.android.publish.p022h.StartAppSDK.m3275a(getContext(), this.f3386j, typeface, 1, 16.46f, f3375m, 2102);
        this.f3387k = com.startapp.android.publish.p022h.StartAppSDK.m3275a(getContext(), this.f3386j, typeface, 1, 12.12f, f3376n, 2107);
        this.f3386j.setText("Loading...");
        this.f3377a = new RelativeLayout(getContext());
        this.f3377a.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f3377a.addView(this.f3386j, com.startapp.android.publish.p022h.StartAppSDK.m3273a(getContext(), new int[]{0, 0, 0, 0}, new int[0]));
        this.f3377a.addView(this.f3387k, com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{0, 0, 0, 0}, new int[0], 3, 2102));
        this.f3382f = com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 14, 22, "back_.png");
        this.f3384h = com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 14, 22, "back_dark.png");
        this.f3383g = com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 14, 22, "forward_.png");
        this.f3385i = com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 14, 22, "forward_dark.png");
        this.f3378b = com.startapp.android.publish.p022h.StartAppSDK.m3272a(getContext(), this.f3378b, com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 23, 23, "x_dark.png"), 2103);
        this.f3380d = com.startapp.android.publish.p022h.StartAppSDK.m3272a(getContext(), this.f3380d, com.startapp.android.publish.p022h.StartAppSDK.m3271a(getContext(), 28, 28, "browser_icon_dark.png"), 2104);
        this.f3381e = com.startapp.android.publish.p022h.StartAppSDK.m3272a(getContext(), this.f3381e, this.f3382f, 2105);
        this.f3379c = com.startapp.android.publish.p022h.StartAppSDK.m3272a(getContext(), this.f3379c, this.f3383g, 2106);
        int a = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), 10);
        this.f3379c.setPadding(a, a, a, a);
        this.f3381e.setPadding(a, a, a, a);
        addView(this.f3378b, com.startapp.android.publish.p022h.StartAppSDK.m3273a(getContext(), new int[]{0, 0, 16, 0}, new int[]{15, 11}));
        addView(this.f3380d, com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{0, 0, 17, 0}, new int[]{15}, 0, 2103));
        addView(this.f3377a, com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{16, 6, 16, 0}, new int[]{9}, 0, 2104));
    }

    public void m3367a(WebView webView) {
        if (this.f3388l.booleanValue()) {
            m3369b(webView);
        } else if (webView.canGoBack()) {
            m3365d();
            this.f3388l = Boolean.valueOf(true);
        }
    }

    void m3369b(WebView webView) {
        if (webView.canGoBack()) {
            this.f3381e.setImageBitmap(this.f3384h);
        } else {
            this.f3381e.setImageBitmap(this.f3382f);
        }
        if (webView.canGoForward()) {
            this.f3379c.setImageBitmap(this.f3385i);
        } else {
            this.f3379c.setImageBitmap(this.f3383g);
        }
        if (webView.getTitle() != null) {
            this.f3386j.setText(webView.getTitle());
        }
    }

    public TextView getUrlTxt() {
        return this.f3387k;
    }

    public TextView getTitleTxt() {
        return this.f3386j;
    }

    public void setButtonsListener(OnClickListener listener) {
        this.f3378b.setOnClickListener(listener);
        this.f3381e.setOnClickListener(listener);
        this.f3379c.setOnClickListener(listener);
        this.f3380d.setOnClickListener(listener);
    }

    private void m3365d() {
        this.f3381e.setImageBitmap(this.f3384h);
        addView(this.f3381e, com.startapp.android.publish.p022h.StartAppSDK.m3273a(getContext(), new int[]{6, 0, 0, 0}, new int[]{15, 9}));
        addView(this.f3379c, com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{9, 0, 0, 0}, new int[]{15}, 1, 2105));
        removeView(this.f3377a);
        this.f3377a.removeView(this.f3387k);
        this.f3377a.removeView(this.f3386j);
        this.f3377a.addView(this.f3386j, com.startapp.android.publish.p022h.StartAppSDK.m3273a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}));
        this.f3377a.addView(this.f3387k, com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{0, 0, 0, 0}, new int[]{14}, 3, 2102));
        ViewGroup.LayoutParams a = com.startapp.android.publish.p022h.StartAppSDK.m3274a(getContext(), new int[]{16, 0, 16, 0}, new int[]{15}, 1, 2106);
        a.addRule(0, 2104);
        addView(this.f3377a, a);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3374a = new SparseArray();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).saveHierarchyState(savedState.f3374a);
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).restoreHierarchyState(savedState.f3374a);
        }
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    public void m3370c() {
        if (VERSION.SDK_INT < 11) {
            ((BitmapDrawable) this.f3378b.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.f3380d.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.f3381e.getDrawable()).getBitmap().recycle();
            ((BitmapDrawable) this.f3379c.getDrawable()).getBitmap().recycle();
        }
        this.f3382f = null;
        this.f3384h = null;
        this.f3383g = null;
        this.f3385i = null;
    }
}
