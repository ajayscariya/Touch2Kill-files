package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.u */
public abstract class C0227u extends View {
    protected final AppLovinSdk f107a;
    protected final Context f108b;

    C0227u(AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f108b = context;
        this.f107a = appLovinSdk;
    }

    public static C0227u m50a(AppLovinSdk appLovinSdk, Context context, C0228v c0228v) {
        return c0228v.equals(C0228v.WhiteXOnTransparentGrey) ? new an(appLovinSdk, context) : new ao(appLovinSdk, context);
    }

    public abstract void m51a(int i);
}
