package com.startapp.android.publish.banner.banner3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.banner.banner3d.Banner3DSize.Size;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xml.serialize.LineSeparator;

/* renamed from: com.startapp.android.publish.banner.banner3d.a */
public class StartAppSDK extends RelativeLayout {
    private TextView f3102a;
    private TextView f3103b;
    private ImageView f3104c;
    private com.startapp.android.publish.p022h.StartAppSDK f3105d;
    private TextView f3106e;
    private Point f3107f;

    /* renamed from: com.startapp.android.publish.banner.banner3d.a.1 */
    class StartAppSDK extends ShapeDrawable {
        final /* synthetic */ StartAppSDK f3094a;

        StartAppSDK(StartAppSDK startAppSDK, Shape shape) {
            this.f3094a = startAppSDK;
            super(shape);
        }

        protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, shape.getHeight(), -4466580, -11363070, TileMode.REPEAT));
            paint.setMaskFilter(new EmbossMaskFilter(new float[]{DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT}, 0.4f, 5.0f, 3.0f));
            super.onDraw(shape, canvas, paint);
        }
    }

    /* renamed from: com.startapp.android.publish.banner.banner3d.a.2 */
    static /* synthetic */ class StartAppSDK {
        static final /* synthetic */ int[] f3095a;

        static {
            f3095a = new int[StartAppSDK.values().length];
            try {
                f3095a[StartAppSDK.XS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3095a[StartAppSDK.S.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3095a[StartAppSDK.M.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3095a[StartAppSDK.L.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3095a[StartAppSDK.XL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.startapp.android.publish.banner.banner3d.a.a */
    private enum StartAppSDK {
        XS,
        S,
        M,
        L,
        XL
    }

    public StartAppSDK(Context context, Point point) {
        super(context);
        this.f3107f = point;
        m2961a();
    }

    private void m2961a() {
        Context context = getContext();
        StartAppSDK templateBySize = getTemplateBySize();
        setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{MetaData.getInstance().getItemGradientTop(), MetaData.getInstance().getItemGradientBottom()}));
        setLayoutParams(new LayoutParams(-2, -2));
        int a = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 2);
        int a2 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 3);
        com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 4);
        int a3 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 5);
        int a4 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 6);
        int a5 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 8);
        com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 10);
        int a6 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 20);
        com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 84);
        int a7 = com.startapp.android.publish.p022h.StartAppSDK.m3270a(context, 90);
        setPadding(a3, 0, a3, 0);
        setTag(this);
        this.f3104c = new ImageView(context);
        this.f3104c.setId(1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a7, a7);
        layoutParams.addRule(15);
        this.f3104c.setLayoutParams(layoutParams);
        this.f3102a = new TextView(context);
        this.f3102a.setId(2);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, 1);
        layoutParams2.addRule(14);
        this.f3102a.setLayoutParams(layoutParams2);
        this.f3102a.setTextColor(MetaData.getInstance().getItemTitleTextColor().intValue());
        this.f3102a.setGravity(3);
        this.f3102a.setBackgroundColor(0);
        switch (StartAppSDK.f3095a[templateBySize.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                this.f3102a.setTextSize(17.0f);
                this.f3102a.setPadding(a2, 0, 0, a);
                layoutParams2.width = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((double) this.f3107f.x) * 0.55d));
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                this.f3102a.setTextSize(17.0f);
                this.f3102a.setPadding(a2, 0, 0, a);
                layoutParams2.width = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((double) this.f3107f.x) * 0.65d));
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                this.f3102a.setTextSize(22.0f);
                this.f3102a.setPadding(a2, 0, 0, a3);
                break;
        }
        this.f3102a.setSingleLine(true);
        this.f3102a.setEllipsize(TruncateAt.END);
        com.startapp.android.publish.p022h.StartAppSDK.m3276a(this.f3102a, MetaData.getInstance().getItemTitleTextDecoration());
        this.f3103b = new TextView(context);
        this.f3103b.setId(3);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(1, 1);
        layoutParams3.addRule(3, 2);
        layoutParams3.setMargins(0, 0, 0, a3);
        this.f3103b.setLayoutParams(layoutParams3);
        this.f3103b.setTextColor(MetaData.getInstance().getItemDescriptionTextColor().intValue());
        this.f3103b.setTextSize(18.0f);
        this.f3103b.setMaxLines(2);
        this.f3103b.setLines(2);
        this.f3103b.setSingleLine(false);
        this.f3103b.setEllipsize(TruncateAt.MARQUEE);
        this.f3103b.setHorizontallyScrolling(true);
        this.f3103b.setPadding(a2, 0, 0, 0);
        this.f3105d = new com.startapp.android.publish.p022h.StartAppSDK(getContext());
        this.f3105d.setId(5);
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        switch (StartAppSDK.f3095a[templateBySize.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                layoutParams4.addRule(1, 1);
                layoutParams4.addRule(8, 1);
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                layoutParams4.addRule(1, 2);
                layoutParams3.width = com.startapp.android.publish.p022h.StartAppSDK.m3270a(getContext(), (int) (((double) this.f3107f.x) * 0.6d));
                break;
        }
        layoutParams4.setMargins(a2, a5, a2, 0);
        this.f3105d.setLayoutParams(layoutParams4);
        this.f3106e = new TextView(context);
        LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        switch (StartAppSDK.f3095a[templateBySize.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                this.f3106e.setTextSize(13.0f);
                layoutParams5.addRule(1, 2);
                layoutParams5.addRule(15);
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                layoutParams5.addRule(1, 3);
                layoutParams5.addRule(15);
                layoutParams5.setMargins(a6, 0, 0, 0);
                this.f3106e.setTextSize(26.0f);
                break;
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                layoutParams5.addRule(1, 3);
                layoutParams5.addRule(15);
                layoutParams5.setMargins(a6 * 7, 0, 0, 0);
                this.f3106e.setTextSize(26.0f);
                break;
        }
        this.f3106e.setPadding(a4, a4, a4, a4);
        this.f3106e.setLayoutParams(layoutParams5);
        setButtonText(false);
        this.f3106e.setTextColor(-1);
        this.f3106e.setTypeface(null, 1);
        this.f3106e.setId(4);
        this.f3106e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.f3106e.setBackgroundDrawable(new StartAppSDK(this, new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, null, null)));
        addView(this.f3104c);
        addView(this.f3102a);
        switch (StartAppSDK.f3095a[templateBySize.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                addView(this.f3106e);
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                addView(this.f3106e);
                addView(this.f3103b);
                break;
        }
        addView(this.f3105d);
    }

    public void setText(String text) {
        this.f3102a.setText(text);
    }

    public void setImage(Bitmap img) {
        this.f3104c.setImageBitmap(img);
    }

    public void m2963a(int i, int i2, int i3) {
        this.f3104c.setImageResource(i);
        LayoutParams layoutParams = this.f3104c.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.f3104c.setLayoutParams(layoutParams);
    }

    public void setRating(float rating) {
        this.f3105d.setRating(rating);
    }

    public void m2964a(Bitmap bitmap, int i, int i2) {
        this.f3104c.setImageBitmap(bitmap);
        LayoutParams layoutParams = this.f3104c.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f3104c.setLayoutParams(layoutParams);
    }

    public void setDescription(String description) {
        if (description != null && description.compareTo(XMLConstants.NULL_NS_URI) != 0) {
            String[] a = m2962a(description);
            String str = a[0];
            String str2 = XMLConstants.NULL_NS_URI;
            if (a[1] != null) {
                str2 = m2962a(a[1])[0];
            }
            if (description.length() >= 110) {
                str2 = str2 + "...";
            }
            this.f3103b.setText(str + LineSeparator.Web + str2);
        }
    }

    private String[] m2962a(String str) {
        int i = 55;
        String[] strArr = new String[2];
        if (str.length() > 55) {
            char[] toCharArray = str.substring(0, 55).toCharArray();
            int length = toCharArray.length - 1;
            int i2 = length - 1;
            while (i2 > 0) {
                if (toCharArray[i2] == ' ') {
                    length = 1;
                    break;
                }
                i2--;
            }
            i2 = length;
            length = 0;
            if (length != 0) {
                i = i2;
            }
            strArr[0] = str.substring(0, i);
            strArr[1] = str.substring(i + 1, str.length());
        } else {
            strArr[0] = str;
            strArr[1] = null;
        }
        return strArr;
    }

    private StartAppSDK getTemplateBySize() {
        StartAppSDK startAppSDK = StartAppSDK.S;
        if (this.f3107f.x > Size.SMALL.getSize().m2949a() || this.f3107f.y > Size.SMALL.getSize().m2952b()) {
            startAppSDK = StartAppSDK.M;
        }
        if (this.f3107f.x > Size.MEDIUM.getSize().m2949a() || this.f3107f.y > Size.MEDIUM.getSize().m2952b()) {
            startAppSDK = StartAppSDK.L;
        }
        if (this.f3107f.x > Size.LARGE.getSize().m2949a() || this.f3107f.y > Size.LARGE.getSize().m2952b()) {
            return StartAppSDK.XL;
        }
        return startAppSDK;
    }

    public void setButtonText(boolean isCPE) {
        if (isCPE) {
            this.f3106e.setText("OPEN");
        } else {
            this.f3106e.setText("DOWNLOAD");
        }
    }
}
