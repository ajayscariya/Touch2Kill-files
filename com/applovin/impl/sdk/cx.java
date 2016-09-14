package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

class cx extends bw {
    private final AppLovinNativeAdLoadListener f3942a;
    private final JSONObject f3943b;

    cx(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", appLovinSdkImpl);
        this.f3942a = appLovinNativeAdLoadListener;
        this.f3943b = jSONObject;
    }

    private String m4256a(Map map, String str) {
        String str2 = (String) map.get("simp_url");
        if (AppLovinSdkUtils.isValidString(str2)) {
            return str2.replace("{CLCODE}", str);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    private String m4257a(Map map, String str, String str2) {
        String str3 = (String) map.get("click_url");
        if (AppLovinSdkUtils.isValidString(str3)) {
            CharSequence charSequence;
            if (str2 == null) {
                charSequence = XMLConstants.NULL_NS_URI;
            }
            return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", charSequence);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    private void m4258a(JSONObject jSONObject) {
        List<Map> a = ay.m98a(jSONObject.getJSONArray("native_ads"));
        Map a2 = ay.m99a(jSONObject.getJSONObject("native_settings"));
        List arrayList = new ArrayList(a.size());
        for (Map map : a) {
            String str = (String) map.get("clcode");
            NativeAdImpl a3 = new bb().m109e((String) map.get(DatabaseOpenHelper.HISTORY_ROW_TITLE)).m110f((String) map.get("description")).m111g((String) map.get("caption")).m120p((String) map.get("cta")).m105a((String) map.get("icon_url")).m106b((String) map.get("image_url")).m108d((String) map.get("video_url")).m107c((String) map.get("star_rating_url")).m112h((String) map.get("icon_url")).m113i((String) map.get("image_url")).m114j((String) map.get("video_url")).m102a(Float.parseFloat((String) map.get("star_rating"))).m119o(str).m115k(m4256a(a2, str)).m116l(m4257a(a2, str, (String) map.get("event_id"))).m117m(m4259b(a2, str)).m118n(m4260c(a2, str)).m103a(Long.parseLong((String) map.get("ad_id"))).m104a(this.f).m101a();
            arrayList.add(a3);
            this.f.getLogger().m306d("TaskRenderNativeAd", "Prepared slot: " + a3.getAdId());
        }
        if (this.f3942a != null) {
            this.f3942a.onNativeAdsLoaded(arrayList);
        }
    }

    private String m4259b(Map map, String str) {
        String str2 = (String) map.get("video_start_url");
        return str2 != null ? str2.replace("{CLCODE}", str) : null;
    }

    private String m4260c(Map map, String str) {
        String str2 = (String) map.get("video_end_url");
        return str2 != null ? str2.replace("{CLCODE}", str) : null;
    }

    void m4261a(int i) {
        try {
            if (this.f3942a != null) {
                this.f3942a.onNativeAdsFailedToLoad(i);
            }
        } catch (Throwable e) {
            this.f.getLogger().m308e("TaskRenderNativeAd", "Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f3943b == null || this.f3943b.length() == 0) {
                m4261a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            } else {
                m4258a(this.f3943b);
            }
        } catch (Throwable e) {
            this.f.getLogger().m308e("TaskRenderNativeAd", "Unable to render widget.", e);
            m4261a((int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        }
    }
}
