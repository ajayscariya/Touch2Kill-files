package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

class ac extends C0722h {
    boolean f4590H;

    public ac(String str, AdColonyV4VCAd adColonyV4VCAd) {
        this.F = str;
        this.G = adColonyV4VCAd;
        if (m2620a()) {
            AdColony.activity().addContentView(this, new LayoutParams(-1, -1, 17));
        }
    }

    public void onDraw(Canvas canvas) {
        m5314d();
        int currentTimeMillis = (((int) (System.currentTimeMillis() - this.w)) * MotionEventCompat.ACTION_MASK) / 1000;
        if (currentTimeMillis > TransportMediator.FLAG_KEY_MEDIA_NEXT) {
            currentTimeMillis = TransportMediator.FLAG_KEY_MEDIA_NEXT;
        }
        canvas.drawARGB(currentTimeMillis, 0, 0, 0);
        this.a.m2405a(canvas, this.x, this.y);
        int b = (m2622b() * 3) / 2;
        int remainingViewsUntilReward = this.G.getRemainingViewsUntilReward();
        if (remainingViewsUntilReward == this.G.getViewsPerReward() || remainingViewsUntilReward == 0) {
            m2619a(this.F, "video. You earned");
            if (s) {
                m2618a("Thanks for watching the sponsored", this.z, (int) (((double) this.A) - (((double) b) * 2.5d)), canvas);
                m2618a("video. You earned " + q + ".", this.z, (int) (((double) this.A) - (((double) b) * 1.5d)), canvas);
            } else {
                m2618a("Thanks for watching the sponsored", this.z, (int) (((double) this.A) - (((double) b) * 2.8d)), canvas);
                m2618a("video. You earned " + q, this.z, (int) (((double) this.A) - (((double) b) * 2.05d)), canvas);
                m2618a(r + ".", this.z, (int) (((double) this.A) - (((double) b) * 1.3d)), canvas);
            }
        } else {
            m2619a(this.F, "to earn ");
            String str = remainingViewsUntilReward == 1 ? "video" : "videos";
            if (s) {
                m2618a("Thank you. Watch " + remainingViewsUntilReward + " more " + str, this.z, (int) (((double) this.A) - (((double) b) * 2.5d)), canvas);
                m2618a("to earn " + q + ".", this.z, (int) (((double) this.A) - (((double) b) * 1.5d)), canvas);
            } else {
                m2618a("Thank you. Watch " + remainingViewsUntilReward + " more " + str, this.z, (int) (((double) this.A) - (((double) b) * 2.8d)), canvas);
                m2618a("to earn " + q, this.z, (int) (((double) this.A) - (((double) b) * 2.05d)), canvas);
                m2618a(r + ".", this.z, (int) (((double) this.A) - (((double) b) * 1.3d)), canvas);
            }
        }
        this.b.m2405a(canvas, this.z - (this.b.f2176f / 2), this.A - (this.b.f2177g / 2));
        if (this.f4590H) {
            this.g.m2405a(canvas, this.B, this.D);
        } else {
            this.h.m2405a(canvas, this.B, this.D);
        }
        m2625c("Ok", this.B, this.D, canvas);
        if (currentTimeMillis != TransportMediator.FLAG_KEY_MEDIA_NEXT) {
            invalidate();
        }
    }

    void m5314d() {
        Display defaultDisplay = C0694a.m2452b().getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        double d = this.n ? 12.0d : 16.0d;
        this.x = (width - this.a.f2176f) / 2;
        this.y = ((height - this.a.f2177g) / 2) - 80;
        this.z = this.x + (this.a.f2176f / 2);
        this.A = this.y + (this.a.f2177g / 2);
        this.D = ((int) (((double) this.a.f2177g) - ((d * p) + ((double) this.h.f2177g)))) + this.y;
        this.B = this.z - (this.h.f2176f / 2);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 1) {
            if (m2621a(x, y, this.B, this.D) && this.f4590H) {
                C0694a.f2353S = null;
                ((ViewGroup) getParent()).removeView(this);
                for (int i = 0; i < C0694a.an.size(); i++) {
                    ((Bitmap) C0694a.an.get(i)).recycle();
                }
                C0694a.an.clear();
                C0694a.f2339E = true;
            }
            this.f4590H = false;
            invalidate();
        }
        if (event.getAction() == 0 && m2621a(x, y, this.B, this.D)) {
            this.f4590H = true;
            invalidate();
        }
        return true;
    }
}
