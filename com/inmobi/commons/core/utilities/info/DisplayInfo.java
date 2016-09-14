package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import com.inmobi.commons.p000a.SdkContext;
import com.wTouch2KiLL.MainNavigationActivity;
import java.util.HashMap;
import java.util.Map;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class DisplayInfo {

    public enum ORIENTATION_VALUES {
        PORTRAIT(1),
        REVERSE_PORTRAIT(2),
        LANDSCAPE(3),
        REVERSE_LANDSCAPE(4);
        
        private int f1648a;

        private ORIENTATION_VALUES(int i) {
            this.f1648a = i;
        }

        public int getValue() {
            return this.f1648a;
        }
    }

    private static String m1788d() {
        DisplayProperties a = m1785a();
        return a.m1800b() + "X" + a.m1799a();
    }

    private static String m1789e() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) SdkContext.m1562b().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return i + "x" + displayMetrics.heightPixels;
    }

    public static DisplayProperties m1785a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) SdkContext.m1562b().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        return new DisplayProperties(Math.round(((float) displayMetrics.widthPixels) / f), Math.round(((float) displayMetrics.heightPixels) / f), f);
    }

    public static int m1784a(int i) {
        return Math.round(((float) i) / m1785a().m1801c());
    }

    public static int m1786b() {
        Context b = SdkContext.m1562b();
        int rotation = ((WindowManager) b.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (b.getResources().getConfiguration().orientation) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                if (VERSION.SDK_INT < 8) {
                    return ORIENTATION_VALUES.PORTRAIT.getValue();
                }
                if (rotation == 1 || rotation == 2) {
                    return ORIENTATION_VALUES.REVERSE_PORTRAIT.getValue();
                }
                return ORIENTATION_VALUES.PORTRAIT.getValue();
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                if (VERSION.SDK_INT < 8) {
                    return ORIENTATION_VALUES.LANDSCAPE.getValue();
                }
                if (rotation == 0 || rotation == 1) {
                    return ORIENTATION_VALUES.LANDSCAPE.getValue();
                }
                return ORIENTATION_VALUES.REVERSE_LANDSCAPE.getValue();
            default:
                return ORIENTATION_VALUES.PORTRAIT.getValue();
        }
    }

    private static float m1790f() {
        return new TextView(SdkContext.m1562b()).getTextSize();
    }

    public static Map<String, String> m1787c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("d-device-screen-density", String.valueOf(m1785a().m1801c()));
        hashMap.put("d-device-screen-size", m1788d());
        hashMap.put("d-density-dependent-screen-size", m1789e());
        hashMap.put("d-orientation", String.valueOf(m1786b()));
        hashMap.put("d-textsize", String.valueOf(m1790f()));
        return hashMap;
    }
}
