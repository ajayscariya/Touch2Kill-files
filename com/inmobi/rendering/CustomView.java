package com.inmobi.rendering;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class CustomView extends View {
    private float f1700a;
    private float f1701b;
    private float f1702c;
    private float f1703d;
    private float f1704e;
    private SwitchIconType f1705f;
    private int f1706g;
    private Paint f1707h;
    private Path f1708i;
    private RectF f1709j;

    /* renamed from: com.inmobi.rendering.CustomView.1 */
    static /* synthetic */ class C06391 {
        static final /* synthetic */ int[] f1699a;

        static {
            f1699a = new int[SwitchIconType.values().length];
            try {
                f1699a[SwitchIconType.CLOSE_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1699a[SwitchIconType.CLOSE_TRANSPARENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1699a[SwitchIconType.FORWARD_ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1699a[SwitchIconType.FORWARD_INACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1699a[SwitchIconType.BACK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1699a[SwitchIconType.REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1699a[SwitchIconType.CLOSE_ICON.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public enum SwitchIconType {
        CLOSE_BUTTON,
        CLOSE_TRANSPARENT,
        CLOSE_ICON,
        REFRESH,
        BACK,
        FORWARD_ACTIVE,
        FORWARD_INACTIVE
    }

    private CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, float f, SwitchIconType switchIconType) {
        this(context);
        this.f1705f = switchIconType;
        this.f1700a = f;
        this.f1706g = 15;
        this.f1701b = (50.0f * this.f1700a) / 2.0f;
        this.f1702c = (30.0f * this.f1700a) / 2.0f;
        this.f1703d = this.f1701b - (this.f1702c / 3.0f);
        this.f1704e = this.f1701b + (this.f1702c / 3.0f);
        this.f1707h = new Paint(1);
        this.f1709j = new RectF();
        this.f1708i = new Path();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1707h.reset();
        switch (C06391.f1699a[this.f1705f.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1707h.setStrokeWidth(3.0f);
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawCircle(this.f1701b, this.f1701b, this.f1702c, this.f1707h);
                this.f1707h.setColor(-1);
                this.f1707h.setStyle(Style.STROKE);
                canvas.drawLine(this.f1703d, this.f1703d, this.f1704e, this.f1704e, this.f1707h);
                canvas.drawLine(this.f1703d, this.f1704e, this.f1704e, this.f1703d, this.f1707h);
                canvas.drawCircle(this.f1701b, this.f1701b, this.f1702c, this.f1707h);
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(0);
                this.f1707h.setStrokeWidth(3.0f);
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawCircle(this.f1701b, this.f1701b, this.f1701b, this.f1707h);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                this.f1708i.reset();
                this.f1708i.setFillType(FillType.EVEN_ODD);
                this.f1708i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), (float) (getHeight() / 2));
                this.f1708i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.close();
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1707h.setStrokeWidth(3.0f);
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawPath(this.f1708i, this.f1707h);
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                this.f1708i.reset();
                this.f1708i.setFillType(FillType.EVEN_ODD);
                this.f1708i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), (float) (getHeight() / 2));
                this.f1708i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.close();
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(-12303292);
                this.f1707h.setStrokeWidth(3.0f);
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawPath(this.f1708i, this.f1707h);
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                this.f1708i.reset();
                this.f1708i.setFillType(FillType.EVEN_ODD);
                this.f1708i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), (float) (getHeight() / 2));
                this.f1708i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f));
                this.f1708i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), (float) (getHeight() / 2));
                this.f1708i.close();
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1707h.setStrokeWidth(3.0f);
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawPath(this.f1708i, this.f1707h);
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                this.f1708i.reset();
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1707h.setStrokeWidth(5.0f);
                this.f1707h.setStyle(Style.STROKE);
                this.f1709j.set(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f));
                canvas.drawArc(this.f1709j, 0.0f, 270.0f, false, this.f1707h);
                this.f1708i.setFillType(FillType.EVEN_ODD);
                this.f1708i.moveTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - (this.f1700a * 2.0f));
                this.f1708i.lineTo((((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f)) - (this.f1700a * 2.0f), (float) (getHeight() / 2));
                this.f1708i.lineTo((((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f)) + (this.f1700a * 2.0f), (float) (getHeight() / 2));
                this.f1708i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - (this.f1700a * 2.0f));
                this.f1708i.close();
                this.f1707h.setStyle(Style.FILL_AND_STROKE);
                canvas.drawPath(this.f1708i, this.f1707h);
            case ConnectionResult.NETWORK_ERROR /*7*/:
                this.f1707h.setAntiAlias(true);
                this.f1707h.setColor(ViewCompat.MEASURED_STATE_MASK);
                this.f1707h.setStrokeWidth(5.0f);
                this.f1707h.setStyle(Style.STROKE);
                Canvas canvas2 = canvas;
                canvas2.drawLine(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((((float) this.f1706g) * this.f1700a) / 2.0f) + ((float) (getWidth() / 2)), ((((float) this.f1706g) * this.f1700a) / 2.0f) + ((float) (getHeight() / 2)), this.f1707h);
                canvas2 = canvas;
                canvas2.drawLine(((float) (getWidth() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), ((((float) this.f1706g) * this.f1700a) / 2.0f) + ((float) (getHeight() / 2)), ((((float) this.f1706g) * this.f1700a) / 2.0f) + ((float) (getWidth() / 2)), ((float) (getHeight() / 2)) - ((((float) this.f1706g) * this.f1700a) / 2.0f), this.f1707h);
            default:
        }
    }

    public void setSwitchInt(SwitchIconType switchIconType) {
        this.f1705f = switchIconType;
    }
}
