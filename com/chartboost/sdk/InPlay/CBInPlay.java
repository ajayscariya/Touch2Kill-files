package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;

public final class CBInPlay {
    private static final String f442a;
    private static C0261a f443f;
    private String f444b;
    private Bitmap f445c;
    private String f446d;
    private C0269a f447e;

    static {
        f442a = CBInPlay.class.getSimpleName();
        f443f = null;
    }

    CBInPlay() {
    }

    public void show() {
        C0261a.m364a().m373a(this);
    }

    public void click() {
        C0261a.m364a().m375b(this);
    }

    public String getLocation() {
        return this.f444b;
    }

    protected void m362a(String str) {
        this.f444b = str;
    }

    public Bitmap getAppIcon() {
        return this.f445c;
    }

    protected void m360a(Bitmap bitmap) {
        this.f445c = bitmap;
    }

    public String getAppName() {
        return this.f446d;
    }

    protected void m363b(String str) {
        this.f446d = str;
    }

    protected C0269a m359a() {
        return this.f447e;
    }

    protected void m361a(C0269a c0269a) {
        this.f447e = c0269a;
    }

    public static void cacheInPlay(String location) {
        if (!C0299c.m674q()) {
            return;
        }
        if (TextUtils.isEmpty(location)) {
            CBLogging.m381b(f442a, "Inplay location cannot be empty");
            if (C0299c.m663g() != null) {
                C0299c.m663g().didFailToLoadInPlay(location, CBImpressionError.INVALID_LOCATION);
                return;
            }
            return;
        }
        if (f443f == null) {
            f443f = C0261a.m364a();
        }
        f443f.m374a(location);
    }

    public static boolean hasInPlay(String location) {
        if (!C0299c.m674q()) {
            return false;
        }
        if (TextUtils.isEmpty(location)) {
            CBLogging.m381b(f442a, "Inplay location cannot be empty");
            if (C0299c.m663g() == null) {
                return false;
            }
            C0299c.m663g().didFailToLoadInPlay(location, CBImpressionError.INVALID_LOCATION);
            return false;
        }
        if (f443f == null) {
            f443f = C0261a.m364a();
        }
        return f443f.m376b(location);
    }

    public static CBInPlay getInPlay(String location) {
        if (!C0299c.m674q()) {
            return null;
        }
        if (TextUtils.isEmpty(location)) {
            CBLogging.m381b(f442a, "Inplay location cannot be empty");
            if (C0299c.m663g() == null) {
                return null;
            }
            C0299c.m663g().didFailToLoadInPlay(location, CBImpressionError.INVALID_LOCATION);
            return null;
        }
        if (f443f == null) {
            f443f = C0261a.m364a();
        }
        return f443f.m377c(location);
    }
}
