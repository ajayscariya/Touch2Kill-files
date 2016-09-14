package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* renamed from: com.jirbo.adcolony.v */
class C1440v extends C0722h {
    static boolean f4636H;
    static C1440v f4637I;
    boolean f4638J;
    boolean f4639K;
    ADCVideo f4640L;

    public C1440v(ADCVideo aDCVideo, AdColonyV4VCAd adColonyV4VCAd) {
        this.f4640L = aDCVideo;
        this.G = adColonyV4VCAd;
        aDCVideo.f4542G.pause();
        f4637I = this;
        if (!m2620a()) {
        }
    }

    public void onDraw(Canvas canvas) {
        int i = TransportMediator.FLAG_KEY_MEDIA_NEXT;
        if (this.f4640L.f4542G != null) {
            f4636H = true;
            m5363d();
            int currentTimeMillis = (((int) (System.currentTimeMillis() - this.w)) * MotionEventCompat.ACTION_MASK) / 1000;
            if (currentTimeMillis <= TransportMediator.FLAG_KEY_MEDIA_NEXT) {
                i = currentTimeMillis;
            }
            canvas.drawARGB(i, 0, 0, 0);
            this.a.m2405a(canvas, this.x, this.y);
            i = (m2622b() * 3) / 2;
            m2618a("Completion is required to receive", this.z, (int) (((double) this.A) - (((double) i) * 2.75d)), canvas);
            m2618a("your reward.", this.z, this.A - (i * 2), canvas);
            m2618a("Are you sure you want to skip?", this.z, (int) (((double) this.A) - (((double) i) * 1.25d)), canvas);
            this.b.m2405a(canvas, this.z - (this.b.f2176f / 2), this.A - (this.b.f2177g / 2));
            if (this.f4638J) {
                this.d.m2405a(canvas, this.B, this.D);
            } else {
                this.c.m2405a(canvas, this.B, this.D);
            }
            if (this.f4639K) {
                this.f.m2405a(canvas, this.C, this.D);
            } else {
                this.e.m2405a(canvas, this.C, this.D);
            }
            m2625c("Yes", this.B, this.D, canvas);
            m2625c("No", this.C, this.D, canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        ADCVideo aDCVideo = this.f4640L;
        if (ADCVideo.f4530d) {
            f4637I = null;
            return this.f4640L.f4543H.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 1) {
            if (m2621a(x, y, this.B, this.D) && this.f4638J) {
                f4637I = null;
                f4636H = false;
                C0694a.f2338D = false;
                C0694a.ak = true;
                C0694a.f2357W.m2438b(this.G);
                AdColonyBrowser.f2242A = true;
                this.f4640L.finish();
                C0694a.f2339E = true;
            } else if (m2621a(x, y, this.C, this.D) && this.f4639K) {
                f4637I = null;
                f4636H = false;
                this.f4640L.f4542G.start();
            }
            this.f4638J = false;
            this.f4639K = false;
            invalidate();
        }
        if (event.getAction() != 0) {
            return true;
        }
        if (m2621a(x, y, this.B, this.D)) {
            this.f4638J = true;
            invalidate();
            return true;
        } else if (!m2621a(x, y, this.C, this.D)) {
            return true;
        } else {
            this.f4639K = true;
            invalidate();
            return true;
        }
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (this.f4640L.f4542G != null && keycode == 4) {
            return super.onKeyDown(keycode, event);
        }
        return false;
    }

    public boolean onKeyUp(int keycode, KeyEvent event) {
        if (keycode != 4) {
            return false;
        }
        f4637I = null;
        this.f4640L.f4542G.start();
        return true;
    }

    void m5363d() {
        int i = this.f4640L.f4571t;
        int i2 = this.f4640L.f4572u;
        this.x = (i - this.a.f2176f) / 2;
        this.y = (i2 - this.a.f2177g) / 2;
        this.z = this.x + (this.a.f2176f / 2);
        this.A = this.y + (this.a.f2177g / 2);
        this.D = this.y + ((int) (((double) this.a.f2177g) - (((double) this.c.f2177g) + (p * 16.0d))));
        this.B = this.x + ((int) (p * 16.0d));
        this.C = this.x + ((int) (((double) this.a.f2176f) - (((double) this.c.f2176f) + (p * 16.0d))));
    }
}
