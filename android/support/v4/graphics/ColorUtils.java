package android.support.v4.graphics;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;

    private ColorUtils() {
    }

    public static int compositeColors(@ColorInt int foreground, @ColorInt int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a = compositeAlpha(fgAlpha, bgAlpha);
        return Color.argb(a, compositeComponent(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a), compositeComponent(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a), compositeComponent(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a));
    }

    private static int compositeAlpha(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / MotionEventCompat.ACTION_MASK);
    }

    private static int compositeComponent(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return (((fgC * MotionEventCompat.ACTION_MASK) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a * MotionEventCompat.ACTION_MASK);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int color) {
        double red = ((double) Color.red(color)) / 255.0d;
        double green = ((double) Color.green(color)) / 255.0d;
        double blue = ((double) Color.blue(color)) / 255.0d;
        return ((0.2126d * (red < 0.03928d ? red / 12.92d : Math.pow((0.055d + red) / 1.055d, 2.4d))) + (0.7152d * (green < 0.03928d ? green / 12.92d : Math.pow((0.055d + green) / 1.055d, 2.4d)))) + (0.0722d * (blue < 0.03928d ? blue / 12.92d : Math.pow((0.055d + blue) / 1.055d, 2.4d)));
    }

    public static double calculateContrast(@ColorInt int foreground, @ColorInt int background) {
        if (Color.alpha(background) != MotionEventCompat.ACTION_MASK) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        if (Color.alpha(foreground) < MotionEventCompat.ACTION_MASK) {
            foreground = compositeColors(foreground, background);
        }
        double luminance1 = calculateLuminance(foreground) + 0.05d;
        double luminance2 = calculateLuminance(background) + 0.05d;
        return Math.max(luminance1, luminance2) / Math.min(luminance1, luminance2);
    }

    public static int calculateMinimumAlpha(@ColorInt int foreground, @ColorInt int background, float minContrastRatio) {
        if (Color.alpha(background) != MotionEventCompat.ACTION_MASK) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        } else if (calculateContrast(setAlphaComponent(foreground, MotionEventCompat.ACTION_MASK), background) < ((double) minContrastRatio)) {
            return -1;
        } else {
            int minAlpha = 0;
            int maxAlpha = MotionEventCompat.ACTION_MASK;
            for (int numIterations = 0; numIterations <= MIN_ALPHA_SEARCH_MAX_ITERATIONS && maxAlpha - minAlpha > MIN_ALPHA_SEARCH_PRECISION; numIterations += MIN_ALPHA_SEARCH_PRECISION) {
                int testAlpha = (minAlpha + maxAlpha) / 2;
                if (calculateContrast(setAlphaComponent(foreground, testAlpha), background) < ((double) minContrastRatio)) {
                    minAlpha = testAlpha;
                } else {
                    maxAlpha = testAlpha;
                }
            }
            return maxAlpha;
        }
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int r, @IntRange(from = 0, to = 255) int g, @IntRange(from = 0, to = 255) int b, @NonNull float[] hsl) {
        float s;
        float h;
        float rf = ((float) r) / 255.0f;
        float gf = ((float) g) / 255.0f;
        float bf = ((float) b) / 255.0f;
        float max = Math.max(rf, Math.max(gf, bf));
        float min = Math.min(rf, Math.min(gf, bf));
        float deltaMaxMin = max - min;
        float l = (max + min) / 2.0f;
        if (max == min) {
            s = 0.0f;
            h = 0.0f;
        } else {
            if (max == rf) {
                h = ((gf - bf) / deltaMaxMin) % 6.0f;
            } else if (max == gf) {
                h = ((bf - rf) / deltaMaxMin) + 2.0f;
            } else {
                h = ((rf - gf) / deltaMaxMin) + 4.0f;
            }
            s = deltaMaxMin / (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - Math.abs((2.0f * l) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        }
        h = (60.0f * h) % 360.0f;
        if (h < 0.0f) {
            h += 360.0f;
        }
        hsl[0] = constrain(h, 0.0f, 360.0f);
        hsl[MIN_ALPHA_SEARCH_PRECISION] = constrain(s, 0.0f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        hsl[2] = constrain(l, 0.0f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public static void colorToHSL(@ColorInt int color, @NonNull float[] hsl) {
        RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), hsl);
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] hsl) {
        float h = hsl[0];
        float s = hsl[MIN_ALPHA_SEARCH_PRECISION];
        float l = hsl[2];
        float c = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - Math.abs((2.0f * l) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) * s;
        float m = l - (0.5f * c);
        float x = c * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - Math.abs(((h / 60.0f) % 2.0f) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        int r = 0;
        int g = 0;
        int b = 0;
        switch (((int) h) / 60) {
            case DurationDV.DURATION_TYPE /*0*/:
                r = Math.round(255.0f * (c + m));
                g = Math.round(255.0f * (x + m));
                b = Math.round(255.0f * m);
                break;
            case MIN_ALPHA_SEARCH_PRECISION /*1*/:
                r = Math.round(255.0f * (x + m));
                g = Math.round(255.0f * (c + m));
                b = Math.round(255.0f * m);
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                r = Math.round(255.0f * m);
                g = Math.round(255.0f * (c + m));
                b = Math.round(255.0f * (x + m));
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                r = Math.round(255.0f * m);
                g = Math.round(255.0f * (x + m));
                b = Math.round(255.0f * (c + m));
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                r = Math.round(255.0f * (x + m));
                g = Math.round(255.0f * m);
                b = Math.round(255.0f * (c + m));
                break;
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                r = Math.round(255.0f * (c + m));
                g = Math.round(255.0f * m);
                b = Math.round(255.0f * (x + m));
                break;
        }
        return Color.rgb(constrain(r, 0, (int) MotionEventCompat.ACTION_MASK), constrain(g, 0, (int) MotionEventCompat.ACTION_MASK), constrain(b, 0, (int) MotionEventCompat.ACTION_MASK));
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        if (alpha >= 0 && alpha <= MotionEventCompat.ACTION_MASK) {
            return (ViewCompat.MEASURED_SIZE_MASK & color) | (alpha << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static float constrain(float amount, float low, float high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }

    private static int constrain(int amount, int low, int high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }
}
