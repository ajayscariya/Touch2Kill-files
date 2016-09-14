package com.inmobi.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.ConnectionResult;
import com.inmobi.commons.core.configs.ConfigComponent;
import com.inmobi.commons.core.configs.ConfigDao;
import com.inmobi.commons.core.p001a.InMobiCrashHandler;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.utilities.ApplicationFocusChangeObserver.ApplicationFocusChangeObserver;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.PublisherProvidedUserInfo;
import com.inmobi.commons.core.utilities.p004a.EncryptionDao;
import com.inmobi.commons.core.utilities.uid.UidHelper;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.commons.p000a.SdkInfo;
import com.inmobi.rendering.mraid.MraidJsDao;
import com.inmobi.rendering.p005a.ClickManager;
import com.inmobi.signals.CarbDao;
import com.inmobi.signals.SignalsComponent;
import com.wTouch2KiLL.MainNavigationActivity;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public final class InMobiSdk {
    private static final String TAG;

    /* renamed from: com.inmobi.sdk.InMobiSdk.2 */
    static /* synthetic */ class C06672 {
        static final /* synthetic */ int[] f2053a;

        static {
            f2053a = new int[LogLevel.values().length];
            try {
                f2053a[LogLevel.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2053a[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2053a[LogLevel.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum AgeGroup {
        BELOW_18("below18"),
        BETWEEN_18_AND_20("between18and20"),
        BETWEEN_21_AND_24("between21and24"),
        BETWEEN_25_AND_34("between25and34"),
        BETWEEN_35_AND_54("between35and54"),
        ABOVE_55("above55");
        
        private String f2054a;

        private AgeGroup(String str) {
            this.f2054a = str;
        }

        public String toString() {
            return this.f2054a;
        }
    }

    public enum Education {
        HIGH_SCHOOL_OR_LESS("highschoolorless"),
        COLLEGE_OR_GRADUATE("collegeorgraduate"),
        POST_GRADUATE_OR_ABOVE("postgraduateorabove");
        
        private String f2055a;

        private Education(String str) {
            this.f2055a = str;
        }

        public String toString() {
            return this.f2055a;
        }
    }

    public enum Ethnicity {
        AFRICAN_AMERICAN("africanamerican"),
        ASIAN("asian"),
        CAUCASIAN("caucasian"),
        HISPANIC("hispanic"),
        OTHER("other");
        
        private String f2056a;

        private Ethnicity(String str) {
            this.f2056a = str;
        }

        public String toString() {
            return this.f2056a;
        }
    }

    public enum Gender {
        FEMALE("f"),
        MALE("m");
        
        private String f2057a;

        private Gender(String str) {
            this.f2057a = str;
        }

        public String toString() {
            return this.f2057a;
        }
    }

    public enum HouseHoldIncome {
        BELOW_USD_5K("belowusd5k"),
        BETWEEN_USD_5K_AND_10K("betweenusd5kand10k"),
        BETWEEN_USD_10K_AND_15K("betweenusd10kand15k"),
        BETWEEN_USD_15K_AND_20K("betweenusd15kand20k"),
        BETWEEN_USD_20K_AND_25K("betweenusd20kand25k"),
        BETWEEN_USD_25K_AND_50K("betweenusd25kand50k"),
        BETWEEN_USD_50K_AND_75K("betweenusd50kand75k"),
        BETWEEN_USD_75K_AND_100K("betweenusd75kand100k"),
        BETWEEN_USD_100K_AND_150K("betweenusd100kand150k"),
        ABOVE_USD_150K("aboveusd150k");
        
        private String f2058a;

        private HouseHoldIncome(String str) {
            this.f2058a = str;
        }

        public String toString() {
            return this.f2058a;
        }
    }

    public enum ImIdType {
        LOGIN,
        SESSION
    }

    public enum LogLevel {
        NONE,
        ERROR,
        DEBUG
    }

    /* renamed from: com.inmobi.sdk.InMobiSdk.1 */
    static class C14161 implements ApplicationFocusChangeObserver {
        C14161() {
        }

        public void m5194a(boolean z) {
            SdkContext.m1560a(z);
            if (z) {
                InMobiSdk.initComponents();
            } else {
                InMobiSdk.deInitComponents();
            }
        }
    }

    static {
        TAG = InMobiSdk.class.getSimpleName();
    }

    public static void init(Context context, String str) {
        if (context == null) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Context supplied as null, SDK could not be initialized.");
        } else if (str == null || str.trim().length() == 0) {
            Logger.m1744a(InternalLogLevel.ERROR, TAG, "Account ID cannot be null or empty. Please provide a valid Account ID.");
        } else {
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.inmobi.rendering.InMobiAdActivity");
            if (context.getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT) == null) {
                Logger.m1744a(InternalLogLevel.ERROR, TAG, "The activity com.inmobi.rendering.InMobiAdActivity not present in AndroidManifest. SDK could not be initialized.");
                return;
            }
            String trim = str.trim();
            if (!(trim.length() == 32 || trim.length() == 36)) {
                Logger.m1744a(InternalLogLevel.DEBUG, TAG, "Invalid account id passed to init. Please provide a valid account id");
            }
            if (SdkContext.m1561a()) {
                Logger.m1744a(InternalLogLevel.INTERNAL, TAG, "SDK already initialized");
                return;
            }
            if (hasSdkVersionChanged(context)) {
                clearCachedData(context);
                SdkInfo.m1571a(context, SdkInfo.m1572b());
            }
            SdkContext.m1558a(context, trim);
            initComponents();
            ConfigComponent.m1656a().m1671d();
            com.inmobi.commons.core.utilities.ApplicationFocusChangeObserver a = com.inmobi.commons.core.utilities.ApplicationFocusChangeObserver.m1766a();
            if (a != null) {
                a.m1772a(new C14161());
            }
        }
    }

    @SuppressLint({"SdCardPath"})
    private static void clearCachedData(Context context) {
        int i;
        File file;
        List asList = Arrays.asList(new String[]{"carbpreference", "IMAdMLtvpRuleCache", "inmobiAppAnalyticsSession", "aeskeygenerate", "impref", "IMAdTrackerStatusUpload", "IMAdMMediationCache", "inmobiAppAnalyticsAppId", "inmobiAppAnalyticsSession", "inmobisdkaid", "IMAdTrackerStatusUpload", "testAppPref"});
        List asList2 = Arrays.asList(new String[]{CarbDao.m2172a(), ConfigDao.m1672a(), EncryptionDao.m1749a(), MraidJsDao.m2118a()});
        for (i = 0; i < asList.size(); i++) {
            File file2 = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + ((String) asList.get(i)) + ".xml");
            if (file2.exists()) {
                file2.delete();
            }
        }
        for (i = 0; i < asList2.size(); i++) {
            File file3 = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + ((String) asList2.get(i)) + ".xml");
            if (file3.exists()) {
                file3.delete();
            }
        }
        asList = Arrays.asList(new String[]{"inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp"});
        for (i = 0; i < asList.size(); i++) {
            if (context.getCacheDir() != null) {
                file = new File(context.getCacheDir(), (String) asList.get(i));
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        asList = Arrays.asList(new String[]{"eventlog", "imai_click_events"});
        for (i = 0; i < asList.size(); i++) {
            if (context.getDir("data", 0) != null) {
                file = new File(context.getDir("data", 0), (String) asList.get(i));
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        context.deleteDatabase("adcache.db");
        context.deleteDatabase("appengage.db");
        context.deleteDatabase("im.db");
        context.deleteDatabase("ltvp.db");
        context.deleteDatabase("analytics.db");
        context.deleteDatabase("com.im.db");
    }

    private static boolean hasSdkVersionChanged(Context context) {
        if (SdkInfo.m1570a(context) == null || !SdkInfo.m1570a(context).equals(SdkInfo.m1572b())) {
            return true;
        }
        return false;
    }

    private static void initComponents() {
        UidHelper.m1854a().m1864b();
        UidHelper.m1854a().m1866d();
        ConfigComponent.m1656a().m1669b();
        ClickManager.m5176a().m5188b();
        InMobiCrashHandler.m1577a();
        TelemetryComponent.m5070a().m5094b();
        SignalsComponent.m5202a().m5204b();
    }

    private static void deInitComponents() {
        ConfigComponent.m1656a().m1670c();
        TelemetryComponent.m5070a().m5096c();
        SignalsComponent.m5202a().m5205c();
    }

    public static String getVersion() {
        return SdkInfo.m1572b();
    }

    public static void setLogLevel(LogLevel logLevel) {
        switch (C06672.f2053a[logLevel.ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                Logger.m1743a(InternalLogLevel.NONE);
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                Logger.m1743a(InternalLogLevel.ERROR);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                Logger.m1743a(InternalLogLevel.DEBUG);
            default:
        }
    }

    public static final void addIdType(ImIdType imIdType, String str) {
        if (imIdType == ImIdType.LOGIN) {
            PublisherProvidedUserInfo.m1827n(str);
        } else if (imIdType == ImIdType.SESSION) {
            PublisherProvidedUserInfo.m1828o(str);
        }
    }

    public static final void removeIdType(ImIdType imIdType) {
        if (imIdType == ImIdType.LOGIN) {
            PublisherProvidedUserInfo.m1827n(null);
        } else if (imIdType == ImIdType.SESSION) {
            PublisherProvidedUserInfo.m1828o(null);
        }
    }

    public static final void setAge(int i) {
        PublisherProvidedUserInfo.m1807a(i);
    }

    public static final void setAgeGroup(AgeGroup ageGroup) {
        PublisherProvidedUserInfo.m1809a(ageGroup.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setAreaCode(String str) {
        PublisherProvidedUserInfo.m1812b(str);
    }

    public static final void setPostalCode(String str) {
        PublisherProvidedUserInfo.m1815c(str);
    }

    public static final void setLocationWithCityStateCountry(String str, String str2, String str3) {
        PublisherProvidedUserInfo.m1817d(str);
        PublisherProvidedUserInfo.m1818e(str2);
        PublisherProvidedUserInfo.m1819f(str3);
    }

    public static final void setYearOfBirth(int i) {
        PublisherProvidedUserInfo.m1811b(i);
    }

    public static final void setGender(Gender gender) {
        PublisherProvidedUserInfo.m1820g(gender.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setEthnicity(Ethnicity ethnicity) {
        PublisherProvidedUserInfo.m1821h(ethnicity.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setEducation(Education education) {
        PublisherProvidedUserInfo.m1822i(education.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setLanguage(String str) {
        PublisherProvidedUserInfo.m1823j(str);
    }

    public static final void setIncome(int i) {
        PublisherProvidedUserInfo.m1814c(i);
    }

    public static final void setHouseHoldIncome(HouseHoldIncome houseHoldIncome) {
        PublisherProvidedUserInfo.m1824k(houseHoldIncome.toString().toLowerCase(Locale.ENGLISH));
    }

    public static final void setInterests(String str) {
        PublisherProvidedUserInfo.m1825l(str);
    }

    public static final void setNationality(String str) {
        PublisherProvidedUserInfo.m1826m(str);
    }

    public static final void setLocation(Location location) {
        PublisherProvidedUserInfo.m1808a(location);
    }
}
