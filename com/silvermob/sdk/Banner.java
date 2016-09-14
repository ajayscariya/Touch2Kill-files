package com.silvermob.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.silvermob.sdk.AdManager.BannerListener;

public class Banner extends FrameLayout {
    private AdManager adManager;
    private String placementId;

    /* renamed from: com.silvermob.sdk.Banner.1 */
    class C14531 implements BannerListener {
        final /* synthetic */ FrameLayout val$self;

        C14531(FrameLayout frameLayout) {
            this.val$self = frameLayout;
        }

        public void onAdLoaded(View adView) {
            this.val$self.removeAllViews();
            this.val$self.addView(adView);
        }

        public void onNoFill() {
        }

        public void onError() {
        }

        public void onAdClosed() {
        }

        public void onAdClicked() {
        }
    }

    public Banner(Context context) {
        super(context);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(Context context, String placementId) {
        this.placementId = placementId;
        this.adManager = new AdManager(context);
    }

    public void loadAd() {
        loadBannerAd();
    }

    private void loadBannerAd() {
        Integer width = Integer.valueOf(getWidth());
        Integer height = Integer.valueOf(getHeight());
        this.adManager.setBannerListener(new C14531(this));
        this.adManager.requestBanner(this.placementId, width, height);
    }
}
