package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView {
    private int f41a;
    private int f42b;

    public AppLovinVideoView(Context context) {
        this(context, null);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41a = 0;
        this.f42b = 0;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f41a <= 0 || this.f42b <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int ceil;
        int ceil2;
        float height = ((float) this.f42b) / ((float) getHeight());
        float width = ((float) this.f41a) / ((float) getWidth());
        if (height > width) {
            ceil = (int) Math.ceil((double) (((float) this.f42b) / height));
            ceil2 = (int) Math.ceil((double) (((float) this.f41a) / height));
        } else {
            ceil = (int) Math.ceil((double) (((float) this.f42b) / width));
            ceil2 = (int) Math.ceil((double) (((float) this.f41a) / width));
        }
        setMeasuredDimension(ceil2, ceil);
    }

    public void setVideoSize(int i, int i2) {
        this.f41a = i;
        this.f42b = i2;
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception e) {
        }
    }
}
