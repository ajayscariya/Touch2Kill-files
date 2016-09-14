package com.jirbo.adcolony;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import mf.javax.xml.XMLConstants;

/* renamed from: com.jirbo.adcolony.h */
class C0722h extends View {
    static double f2575p;
    static String f2576q;
    static String f2577r;
    static boolean f2578s;
    static Paint f2579t;
    static float[] f2580u;
    int f2581A;
    int f2582B;
    int f2583C;
    int f2584D;
    int f2585E;
    String f2586F;
    AdColonyV4VCAd f2587G;
    ADCImage f2588a;
    ADCImage f2589b;
    ADCImage f2590c;
    ADCImage f2591d;
    ADCImage f2592e;
    ADCImage f2593f;
    ADCImage f2594g;
    ADCImage f2595h;
    double f2596i;
    double f2597j;
    double f2598k;
    double f2599l;
    double f2600m;
    boolean f2601n;
    ArrayList<ADCImage> f2602o;
    AdColonyInterstitialAd f2603v;
    long f2604w;
    int f2605x;
    int f2606y;
    int f2607z;

    C0722h() {
        super(C0694a.m2452b());
        this.f2596i = 2.8d;
        this.f2597j = 2.05d;
        this.f2598k = 1.3d;
        this.f2599l = 2.5d;
        this.f2600m = 1.5d;
        this.f2602o = new ArrayList();
        this.f2604w = System.currentTimeMillis();
    }

    static {
        f2576q = XMLConstants.NULL_NS_URI;
        f2577r = XMLConstants.NULL_NS_URI;
        f2578s = true;
        f2579t = new Paint(1);
        f2580u = new float[80];
    }

    public boolean m2620a() {
        double d = 2.5d;
        double d2 = 0.8d;
        if (this.f2588a == null) {
            this.f2588a = new ADCImage(C0694a.m2469j("pre_popup_bg"));
            this.f2589b = new ADCImage(C0694a.m2469j("v4vc_logo"));
            this.f2590c = new ADCImage(C0694a.m2469j("yes_button_normal"));
            this.f2591d = new ADCImage(C0694a.m2469j("yes_button_down"));
            this.f2592e = new ADCImage(C0694a.m2469j("no_button_normal"));
            this.f2593f = new ADCImage(C0694a.m2469j("no_button_down"));
            this.f2595h = new ADCImage(C0694a.m2469j("done_button_normal"));
            this.f2594g = new ADCImage(C0694a.m2469j("done_button_down"));
            this.f2602o.add(this.f2588a);
            this.f2602o.add(this.f2589b);
            this.f2602o.add(this.f2590c);
            this.f2602o.add(this.f2591d);
            this.f2602o.add(this.f2592e);
            this.f2602o.add(this.f2593f);
            this.f2602o.add(this.f2595h);
            this.f2602o.add(this.f2594g);
            Display defaultDisplay = C0694a.m2452b().getWindowManager().getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            double d3 = height > width ? ((double) (height - width)) / 360.0d : ((double) (width - height)) / 360.0d;
            if (d3 < 0.8d && !C0694a.f2373m) {
                this.f2601n = true;
            }
            if (d3 <= 2.5d) {
                d = d3;
            }
            if (d >= 0.8d) {
                d2 = d;
            } else if (!C0694a.f2373m) {
                d2 = 1.7d;
            }
            f2575p = d2;
            if (this.f2601n) {
                this.f2596i = 2.6d;
                this.f2597j = 1.8d;
                this.f2598k = 1.0d;
                this.f2599l = 2.2d;
                this.f2600m = 1.2d;
            }
            this.f2588a.m2401a(d2 / 1.8d);
            this.f2589b.m2401a(d2 / 1.8d);
            this.f2591d.m2401a(d2 / 1.8d);
            this.f2593f.m2401a(d2 / 1.8d);
            this.f2590c.m2401a(d2 / 1.8d);
            this.f2592e.m2401a(d2 / 1.8d);
            this.f2594g.m2401a(d2 / 1.8d);
            this.f2595h.m2401a(d2 / 1.8d);
            f2579t.setTextSize((float) (18.0d * d2));
            if (this.f2601n) {
                f2579t.setTextSize((float) (d2 * 9.0d));
            }
            f2579t.setFakeBoldText(true);
        }
        return true;
    }

    public C0722h(String str, int i, AdColonyInterstitialAd adColonyInterstitialAd) {
        super(AdColony.activity());
        this.f2596i = 2.8d;
        this.f2597j = 2.05d;
        this.f2598k = 1.3d;
        this.f2599l = 2.5d;
        this.f2600m = 1.5d;
        this.f2602o = new ArrayList();
        this.f2604w = System.currentTimeMillis();
        this.f2586F = str;
        this.f2585E = i;
        this.f2603v = adColonyInterstitialAd;
        if (m2620a()) {
            AdColony.activity().addContentView(this, new LayoutParams(-1, -1, 17));
        }
    }

    int m2617a(String str) {
        f2579t.getTextWidths(str, f2580u);
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            f += f2580u[i];
        }
        return (int) f;
    }

    int m2622b() {
        return (int) f2579t.getTextSize();
    }

    ViewGroup m2624c() {
        return (ViewGroup) getParent();
    }

    void m2618a(String str, int i, int i2, Canvas canvas) {
        int a = i - (m2617a(str) / 2);
        f2579t.setColor(-986896);
        canvas.drawText(str, (float) (a + 1), (float) (i2 + 1), f2579t);
        f2579t.setColor(-8355712);
        canvas.drawText(str, (float) a, (float) i2, f2579t);
    }

    void m2623b(String str, int i, int i2, Canvas canvas) {
        int a = i - (m2617a(str) / 2);
        f2579t.setColor(-8355712);
        canvas.drawText(str, (float) (a + 2), (float) (i2 + 2), f2579t);
        f2579t.setColor(-1);
        canvas.drawText(str, (float) a, (float) i2, f2579t);
    }

    void m2625c(String str, int i, int i2, Canvas canvas) {
        m2623b(str, (this.f2590c.f2176f / 2) + i, ((this.f2590c.f2177g / 2) + i2) + ((m2622b() * 4) / 10), canvas);
    }

    boolean m2621a(int i, int i2, int i3, int i4) {
        if (i >= i3 && i2 >= i4 && i < this.f2590c.f2176f + i3 && i2 < this.f2590c.f2177g + i4) {
            return true;
        }
        return false;
    }

    void m2619a(String str, String str2) {
        int a = m2617a(str);
        f2576q = XMLConstants.NULL_NS_URI;
        f2577r = XMLConstants.NULL_NS_URI;
        String str3 = XMLConstants.NULL_NS_URI;
        if (a > (this.f2588a.f2176f - m2617a("WW")) - m2617a(str2)) {
            f2578s = false;
            a = 0;
            String str4 = str3;
            int i = 0;
            while (i < (this.f2588a.f2176f - m2617a("WW")) - m2617a(str2)) {
                str4 = str4 + str.charAt(a);
                a++;
                i = m2617a(str4);
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < a) {
                if (str4.charAt(i2) != ' ' || i2 < 5) {
                    f2576q = i3 < 5 ? str.substring(0, a) : f2576q;
                    i = i3;
                } else {
                    f2576q = str.substring(0, i2);
                    i = i2;
                }
                i2++;
                i3 = i;
            }
            f2577r = i3 < 5 ? str.substring(a) : str.substring(i3);
            return;
        }
        f2578s = true;
        f2576q = str;
        f2577r = XMLConstants.NULL_NS_URI;
    }

    void m2626d() {
        double d = this.f2601n ? 12.0d : 16.0d;
        Display defaultDisplay = C0694a.m2452b().getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        this.f2605x = (width - this.f2588a.f2176f) / 2;
        this.f2606y = ((height - this.f2588a.f2177g) / 2) - 80;
        this.f2607z = this.f2605x + (this.f2588a.f2176f / 2);
        this.f2581A = this.f2606y + (this.f2588a.f2177g / 2);
        this.f2584D = this.f2606y + ((int) (((double) this.f2588a.f2177g) - (((double) this.f2590c.f2177g) + (f2575p * d))));
        this.f2582B = this.f2605x + ((int) (f2575p * d));
        this.f2583C = ((int) (((double) this.f2588a.f2176f) - ((d * f2575p) + ((double) this.f2590c.f2176f)))) + this.f2605x;
    }
}
