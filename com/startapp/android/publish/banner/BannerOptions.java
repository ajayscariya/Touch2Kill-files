package com.startapp.android.publish.banner;

import com.android.volley.DefaultRetryPolicy;
import java.io.Serializable;

/* compiled from: StartAppSDK */
public class BannerOptions implements Serializable {
    private static final long serialVersionUID = 1;
    private int adsNumber;
    private int delayFaceTime;
    private Effect effect;
    private int height;
    private float heightRatio;
    private int htmlAdsNumber;
    private float minScale;
    private int probability3D;
    private int refreshRate;
    private int refreshRate3D;
    private boolean rotateThroughOnStart;
    private int rotateThroughSpeedMult;
    private int scalePower;
    private int stepSize;
    private int timeBetweenFrames;
    private int width;
    private float widthRatio;

    /* compiled from: StartAppSDK */
    public enum Effect {
        ROTATE_3D(1),
        EXCHANGE(2),
        FLY_IN(3);
        
        private int index;

        private Effect(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }

        public int getRotationMultiplier() {
            return (int) Math.pow(2.0d, (double) (this.index - 1));
        }

        public static Effect getByIndex(int index) {
            Effect effect = ROTATE_3D;
            Effect[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getIndex() == index) {
                    effect = values[i];
                }
            }
            return effect;
        }

        public static Effect getByName(String name) {
            Effect effect = ROTATE_3D;
            Effect[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].name().toLowerCase().compareTo(name.toLowerCase()) == 0) {
                    effect = values[i];
                }
            }
            return effect;
        }
    }

    public BannerOptions() {
        this.width = 300;
        this.height = 50;
        this.probability3D = 90;
        this.timeBetweenFrames = 25;
        this.stepSize = 5;
        this.delayFaceTime = 5000;
        this.adsNumber = 4;
        this.htmlAdsNumber = 10;
        this.refreshRate3D = 60000;
        this.widthRatio = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.heightRatio = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.minScale = 0.88f;
        this.scalePower = 4;
        this.effect = Effect.ROTATE_3D;
        this.rotateThroughOnStart = true;
        this.rotateThroughSpeedMult = 2;
        this.refreshRate = 60000;
    }

    public BannerOptions(BannerOptions other) {
        this.width = 300;
        this.height = 50;
        this.probability3D = 90;
        this.timeBetweenFrames = 25;
        this.stepSize = 5;
        this.delayFaceTime = 5000;
        this.adsNumber = 4;
        this.htmlAdsNumber = 10;
        this.refreshRate3D = 60000;
        this.widthRatio = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.heightRatio = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.minScale = 0.88f;
        this.scalePower = 4;
        this.effect = Effect.ROTATE_3D;
        this.rotateThroughOnStart = true;
        this.rotateThroughSpeedMult = 2;
        this.refreshRate = 60000;
        this.width = other.width;
        this.height = other.height;
        this.probability3D = other.probability3D;
        this.timeBetweenFrames = other.timeBetweenFrames;
        this.stepSize = other.stepSize;
        this.delayFaceTime = other.delayFaceTime;
        this.adsNumber = other.adsNumber;
        this.htmlAdsNumber = other.htmlAdsNumber;
        this.refreshRate3D = other.refreshRate3D;
        this.widthRatio = other.widthRatio;
        this.heightRatio = other.heightRatio;
        this.minScale = other.minScale;
        this.scalePower = other.scalePower;
        this.effect = other.effect;
        this.rotateThroughOnStart = other.rotateThroughOnStart;
        this.rotateThroughSpeedMult = other.rotateThroughSpeedMult;
        this.refreshRate = other.refreshRate;
    }

    public void m2932a(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public int m2931a() {
        return this.timeBetweenFrames;
    }

    public int m2933b() {
        return this.stepSize;
    }

    public int m2934c() {
        return this.delayFaceTime;
    }

    public int m2935d() {
        return this.width;
    }

    public int m2936e() {
        return this.height;
    }

    public int m2937f() {
        return this.adsNumber;
    }

    public int m2938g() {
        return this.htmlAdsNumber;
    }

    public int m2939h() {
        return this.refreshRate3D;
    }

    public int m2940i() {
        return this.refreshRate;
    }

    public int m2941j() {
        return this.probability3D;
    }

    public float m2942k() {
        return this.widthRatio;
    }

    public float m2943l() {
        return this.heightRatio;
    }

    public float m2944m() {
        return this.minScale;
    }

    public int m2945n() {
        return this.scalePower;
    }

    public Effect m2946o() {
        return this.effect;
    }

    public boolean m2947p() {
        return this.rotateThroughOnStart;
    }

    public int m2948q() {
        return this.rotateThroughSpeedMult;
    }

    public boolean equals(Object option) {
        BannerOptions bannerOptions = (BannerOptions) option;
        if (bannerOptions.m2937f() == m2937f() && bannerOptions.m2938g() == m2938g() && bannerOptions.m2939h() == m2939h() && bannerOptions.m2934c() == m2934c() && bannerOptions.m2936e() == m2936e() && bannerOptions.m2933b() == m2933b() && bannerOptions.m2931a() == m2931a() && bannerOptions.m2935d() == m2935d() && bannerOptions.m2940i() == m2940i() && bannerOptions.m2941j() == m2941j()) {
            return true;
        }
        return false;
    }
}
