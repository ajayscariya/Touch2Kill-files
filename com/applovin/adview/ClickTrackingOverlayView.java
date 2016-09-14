package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.cb;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class ClickTrackingOverlayView extends RelativeLayout {
    public ClickTrackingOverlayView(Context context, AppLovinSdk appLovinSdk) {
        super(context, null, new cb(appLovinSdk).m186K());
        m17a(context, appLovinSdk);
    }

    private void m17a(Context context, AppLovinSdk appLovinSdk) {
        LayoutParams layoutParams;
        cb cbVar = new cb(appLovinSdk);
        View progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int J = cbVar.m185J();
        if (J == -2 || J == -1) {
            layoutParams = new RelativeLayout.LayoutParams(J, J);
        } else {
            J = AppLovinSdkUtils.dpToPx(context, J);
            layoutParams = new RelativeLayout.LayoutParams(J, J);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        setBackgroundColor(Color.parseColor(cbVar.m184I()));
        addView(progressBar);
    }
}
