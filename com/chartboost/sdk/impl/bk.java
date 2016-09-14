package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C1201j;

public class bk extends ImageView {
    protected TextView f993a;
    private C1201j f994b;

    public bk(Context context) {
        super(context);
        this.f994b = null;
        this.f993a = null;
    }

    public void m1011a(C1201j c1201j) {
        if (this.f994b != c1201j) {
            this.f994b = c1201j;
            setImageDrawable(new BitmapDrawable(c1201j.m4349f()));
        }
    }

    public void setImageBitmap(Bitmap adImage) {
        this.f994b = null;
        setImageDrawable(new BitmapDrawable(adImage));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m1010a(canvas);
    }

    protected void m1010a(Canvas canvas) {
        if (this.f993a != null) {
            this.f993a.layout(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f993a.setEnabled(isEnabled());
            this.f993a.setSelected(isSelected());
            if (isFocused()) {
                this.f993a.requestFocus();
            } else {
                this.f993a.clearFocus();
            }
            this.f993a.setPressed(isPressed());
            this.f993a.draw(canvas);
        }
    }
}
