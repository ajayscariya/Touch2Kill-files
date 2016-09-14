package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import mf.javax.xml.XMLConstants;

class ab extends C0722h {
    boolean f4587H;
    boolean f4588I;
    boolean f4589J;

    public ab(String str, AdColonyV4VCAd adColonyV4VCAd) {
        this.f4589J = true;
        this.F = str;
        this.G = adColonyV4VCAd;
        if (m2620a()) {
            AdColony.activity().addContentView(this, new LayoutParams(-1, -1, 17));
            if (this.n) {
                this.D += 20;
            }
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f4589J) {
            C0694a.f2353S = null;
            this.f4589J = false;
            this.G.m5313c(false);
            C0694a.f2339E = true;
            for (int i = 0; i < C0694a.an.size(); i++) {
                ((Bitmap) C0694a.an.get(i)).recycle();
            }
            C0694a.an.clear();
        }
    }

    public void onDraw(Canvas canvas) {
        m2626d();
        int currentTimeMillis = (((int) (System.currentTimeMillis() - this.w)) * MotionEventCompat.ACTION_MASK) / 1000;
        if (currentTimeMillis > TransportMediator.FLAG_KEY_MEDIA_NEXT) {
            currentTimeMillis = TransportMediator.FLAG_KEY_MEDIA_NEXT;
        }
        canvas.drawARGB(currentTimeMillis, 0, 0, 0);
        this.a.m2405a(canvas, this.x, this.y);
        int b = (m2622b() * 3) / 2;
        int remainingViewsUntilReward = this.G.getRemainingViewsUntilReward();
        if (this.G.getViewsPerReward() == 1 || this.G.getViewsPerReward() == 0) {
            m2619a(this.F, XMLConstants.NULL_NS_URI);
            if (s) {
                m2618a("Watch a video to earn", this.z, (int) (((double) this.A) - (((double) b) * this.l)), canvas);
                m2618a(q + ".", this.z, (int) (((double) this.A) - (((double) b) * this.m)), canvas);
            } else {
                m2618a("Watch a video to earn", this.z, (int) (((double) this.A) - (((double) b) * this.i)), canvas);
                m2618a(q, this.z, (int) (((double) this.A) - (((double) b) * this.j)), canvas);
                m2618a(r + ".", this.z, (int) (((double) this.A) - (((double) b) * this.k)), canvas);
            }
        } else {
            String str = remainingViewsUntilReward == 1 ? "video" : "videos";
            m2619a(this.F, XMLConstants.NULL_NS_URI + remainingViewsUntilReward + " more " + str + " to earn )?");
            if (s) {
                m2618a("Watch a sponsored video now (Only", this.z, (int) (((double) this.A) - (((double) b) * this.l)), canvas);
                m2618a(XMLConstants.NULL_NS_URI + remainingViewsUntilReward + " more " + str + " to earn " + q + ")?", this.z, (int) (((double) this.A) - (((double) b) * this.m)), canvas);
            } else {
                m2618a("Watch a sponsored video now (Only", this.z, (int) (((double) this.A) - (((double) b) * this.i)), canvas);
                m2618a(XMLConstants.NULL_NS_URI + remainingViewsUntilReward + " more " + str + " to earn " + q, this.z, (int) (((double) this.A) - (((double) b) * this.j)), canvas);
                m2618a(r + ")?", this.z, (int) (((double) this.A) - (((double) b) * this.k)), canvas);
            }
        }
        this.b.m2405a(canvas, this.z - (this.b.f2176f / 2), this.A - (this.b.f2177g / 2));
        if (this.f4588I) {
            this.d.m2405a(canvas, this.B, this.D);
        } else {
            this.c.m2405a(canvas, this.B, this.D);
        }
        if (this.f4587H) {
            this.f.m2405a(canvas, this.C, this.D);
        } else {
            this.e.m2405a(canvas, this.C, this.D);
        }
        m2625c("Yes", this.B, this.D, canvas);
        m2625c("No", this.C, this.D, canvas);
        if (currentTimeMillis != TransportMediator.FLAG_KEY_MEDIA_NEXT) {
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 1) {
            if (m2621a(x, y, this.B, this.D) && this.f4588I) {
                C0694a.f2353S = null;
                this.f4589J = false;
                ((ViewGroup) getParent()).removeView(this);
                this.G.m5313c(true);
            } else if (m2621a(x, y, this.C, this.D) && this.f4587H) {
                C0694a.f2353S = null;
                this.f4589J = false;
                ((ViewGroup) getParent()).removeView(this);
                this.G.m5313c(false);
                C0694a.f2339E = true;
                for (int i = 0; i < C0694a.an.size(); i++) {
                    ((Bitmap) C0694a.an.get(i)).recycle();
                }
                C0694a.an.clear();
            }
            this.f4587H = false;
            this.f4588I = false;
            invalidate();
        }
        if (event.getAction() == 0) {
            if (m2621a(x, y, this.B, this.D)) {
                this.f4588I = true;
                invalidate();
            } else if (m2621a(x, y, this.C, this.D)) {
                this.f4587H = true;
                invalidate();
            }
        }
        return true;
    }
}
