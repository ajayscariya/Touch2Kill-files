package com.silvermob.sdk.connectors;

import android.content.Context;
import android.view.View;
import java.util.Map;

public interface Connector {

    public interface Listener {
        void onAdClicked(View view);

        void onAdClosed();

        void onAdLoaded(View view);

        void onAdShown();

        void onError();
    }

    String getName();

    void init(Context context, Map<String, String> map);

    void loadAd(Map<String, String> map, Listener listener);

    void showInterstitialAd(Listener listener);
}
