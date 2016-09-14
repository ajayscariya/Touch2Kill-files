package com.chartboost.sdk.Tracking;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.chartboost.sdk.C0299c;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0271e;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0278h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.az.C0347c;
import com.chartboost.sdk.impl.ba;
import java.io.File;
import java.util.EnumMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CBAnalytics {

    public enum CBIAPPurchaseInfo {
        PRODUCT_ID,
        PRODUCT_TITLE,
        PRODUCT_DESCRIPTION,
        PRODUCT_PRICE,
        PRODUCT_CURRENCY_CODE,
        GOOGLE_PURCHASE_DATA,
        GOOGLE_PURCHASE_SIGNATURE,
        AMAZON_PURCHASE_TOKEN,
        AMAZON_USER_ID
    }

    public enum CBIAPType {
        GOOGLE_PLAY,
        AMAZON
    }

    public enum CBLevelType {
        HIGHEST_LEVEL_REACHED(1),
        CURRENT_AREA(2),
        CHARACTER_LEVEL(3),
        OTHER_SEQUENTIAL(4),
        OTHER_NONSEQUENTIAL(5);
        
        private int f636a;

        private CBLevelType(int value) {
            this.f636a = value;
        }

        public int getLevelType() {
            return this.f636a;
        }
    }

    /* renamed from: com.chartboost.sdk.Tracking.CBAnalytics.1 */
    static class C12021 implements C0347c {
        final /* synthetic */ String f3997a;
        final /* synthetic */ CBIAPType f3998b;

        C12021(String str, CBIAPType cBIAPType) {
            this.f3997a = str;
            this.f3998b = cBIAPType;
        }

        public void m4353a(C0269a c0269a, az azVar) {
        }

        public void m4354a(C0269a c0269a, az azVar, CBError cBError) {
            try {
                if (this.f3997a.equals(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE) && c0269a.m438c() && c0269a.m444f(NotificationCompatApi21.CATEGORY_STATUS) == 400 && this.f3998b == CBIAPType.GOOGLE_PLAY) {
                    CBLogging.m379a("CBPostInstallTracker", this.f3997a + " 400 response from server!!");
                    ba a = ba.m914a(C0299c.m682y());
                    C0278h i = a.m935i();
                    ConcurrentHashMap h = a.m934h();
                    if (i != null && h != null) {
                        i.m520e((File) h.get(azVar));
                        h.remove(azVar);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private CBAnalytics() {
    }

    public synchronized void trackInAppPurchaseEvent(EnumMap<CBIAPPurchaseInfo, String> map, CBIAPType iapType) {
        if (!(map == null || iapType == null)) {
            if (!(TextUtils.isEmpty((CharSequence) map.get(CBIAPPurchaseInfo.PRODUCT_ID)) || TextUtils.isEmpty((CharSequence) map.get(CBIAPPurchaseInfo.PRODUCT_TITLE)) || TextUtils.isEmpty((CharSequence) map.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION)) || TextUtils.isEmpty((CharSequence) map.get(CBIAPPurchaseInfo.PRODUCT_PRICE)) || TextUtils.isEmpty((CharSequence) map.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE)))) {
                m598a((String) map.get(CBIAPPurchaseInfo.PRODUCT_ID), (String) map.get(CBIAPPurchaseInfo.PRODUCT_TITLE), (String) map.get(CBIAPPurchaseInfo.PRODUCT_DESCRIPTION), (String) map.get(CBIAPPurchaseInfo.PRODUCT_PRICE), (String) map.get(CBIAPPurchaseInfo.PRODUCT_CURRENCY_CODE), (String) map.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_DATA), (String) map.get(CBIAPPurchaseInfo.GOOGLE_PURCHASE_SIGNATURE), (String) map.get(CBIAPPurchaseInfo.AMAZON_USER_ID), (String) map.get(CBIAPPurchaseInfo.AMAZON_PURCHASE_TOKEN), iapType);
            }
        }
        CBLogging.m381b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
    }

    private static synchronized void m598a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CBIAPType cBIAPType) {
        synchronized (CBAnalytics.class) {
            if (C0299c.m682y() == null) {
                CBLogging.m381b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
            } else if (!C0299c.m673p()) {
                CBLogging.m381b("CBPostInstallTracker", "You need call Chartboost.OnStart() before tracking in-app purchases");
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                CBLogging.m381b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
            } else {
                try {
                    Matcher matcher = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(str4);
                    matcher.find();
                    Object group = matcher.group();
                    if (TextUtils.isEmpty(group)) {
                        CBLogging.m381b("CBPostInstallTracker", "Invalid price object");
                    } else {
                        float parseFloat = Float.parseFloat(group);
                        C0269a c0269a = null;
                        if (cBIAPType == CBIAPType.GOOGLE_PLAY) {
                            if (TextUtils.isEmpty(str6) || TextUtils.isEmpty(str7)) {
                                CBLogging.m381b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
                            } else {
                                c0269a = C0271e.m461a(C0271e.m462a("purchaseData", str6), C0271e.m462a("purchaseSignature", str7), C0271e.m462a("type", Integer.valueOf(CBIAPType.GOOGLE_PLAY.ordinal())));
                            }
                        } else if (cBIAPType == CBIAPType.AMAZON) {
                            if (TextUtils.isEmpty(str8) || TextUtils.isEmpty(str9)) {
                                CBLogging.m381b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                            } else {
                                c0269a = C0271e.m461a(C0271e.m462a("userID", str8), C0271e.m462a("purchaseToken", str9), C0271e.m462a("type", Integer.valueOf(CBIAPType.AMAZON.ordinal())));
                            }
                        }
                        if (c0269a == null) {
                            CBLogging.m381b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
                        } else {
                            String encodeToString = Base64.encodeToString(c0269a.toString().getBytes(), 2);
                            m597a(C0271e.m461a(C0271e.m462a("localized-title", str2), C0271e.m462a("localized-description", str3), C0271e.m462a("price", Float.valueOf(parseFloat)), C0271e.m462a(AppLovinEventParameters.REVENUE_CURRENCY, str5), C0271e.m462a("productID", str), C0271e.m462a("receipt", encodeToString)), AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, cBIAPType);
                        }
                    }
                } catch (IllegalStateException e) {
                    CBLogging.m381b("CBPostInstallTracker", "Invalid price object");
                }
            }
        }
    }

    public static synchronized void trackInAppGooglePlayPurchaseEvent(String title, String description, String price, String currency, String productID, String purchaseData, String purchaseSignature) {
        synchronized (CBAnalytics.class) {
            m598a(productID, title, description, price, currency, purchaseData, purchaseSignature, null, null, CBIAPType.GOOGLE_PLAY);
        }
    }

    public static synchronized void trackInAppAmazonStorePurchaseEvent(String title, String description, String price, String currency, String productID, String userID, String purchaseToken) {
        synchronized (CBAnalytics.class) {
            m598a(productID, title, description, price, currency, null, null, userID, purchaseToken, CBIAPType.AMAZON);
        }
    }

    public static synchronized void trackLevelInfo(String eventLabel, CBLevelType type, int mainLevel, String description) {
        synchronized (CBAnalytics.class) {
            trackLevelInfo(eventLabel, type, mainLevel, 0, description);
        }
    }

    public static synchronized void trackLevelInfo(String eventLabel, CBLevelType type, int mainLevel, int subLevel, String description) {
        synchronized (CBAnalytics.class) {
            if (TextUtils.isEmpty(eventLabel)) {
                CBLogging.m381b("CBPostInstallTracker", "Invalid value: event label cannot be empty or null");
            } else {
                if (type != null) {
                    if (type instanceof CBLevelType) {
                        if (mainLevel < 0 || subLevel < 0) {
                            CBLogging.m381b("CBPostInstallTracker", "Invalid value: Level number should be > 0");
                        } else if (description.isEmpty()) {
                            CBLogging.m381b("CBPostInstallTracker", "Invalid value: description cannot be empty or null");
                        } else {
                            m596a(C0271e.m461a(C0271e.m462a("event_label", eventLabel), C0271e.m462a("event_field", Integer.valueOf(type.getLevelType())), C0271e.m462a("main_level", Integer.valueOf(mainLevel)), C0271e.m462a("sub_level", Integer.valueOf(subLevel)), C0271e.m462a("description", description), C0271e.m462a("timestamp", Long.valueOf(System.currentTimeMillis())), C0271e.m462a("data_type", "level_info")), "tracking");
                        }
                    }
                }
                CBLogging.m381b("CBPostInstallTracker", "Invalid value: level type cannot be empty or null, please choose from one of the CBLevelType enum values");
            }
        }
    }

    private static synchronized void m597a(C0269a c0269a, String str, CBIAPType cBIAPType) {
        synchronized (CBAnalytics.class) {
            az azVar = new az(String.format(Locale.US, "%s%s", new Object[]{"/post-install-event/", str}));
            azVar.m869a(str, (Object) c0269a);
            azVar.m863a(C0276g.m480a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a)));
            azVar.m874b(str);
            azVar.m871a(true);
            azVar.m864a(new C12021(str, cBIAPType));
        }
    }

    private static synchronized void m596a(C0269a c0269a, String str) {
        synchronized (CBAnalytics.class) {
            az azVar = new az("/post-install-event/".concat("tracking"));
            azVar.m869a("track_info", (Object) c0269a);
            azVar.m863a(C0276g.m480a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a)));
            azVar.m874b(str);
            azVar.m871a(true);
            azVar.m894s();
        }
    }
}
