package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import mf.javax.xml.XMLConstants;

public class AppLovinSdkImpl extends AppLovinSdk {
    private String f3861a;
    private AppLovinSdkSettings f3862b;
    private Context f3863c;
    private AppLovinLogger f3864d;
    private cr f3865e;
    private ca f3866f;
    private C0238o f3867g;
    private cc f3868h;
    private C0246z f3869i;
    private C1548b f3870j;
    private bc f3871k;
    private C0241r f3872l;
    private C1179m f3873m;
    private AppLovinAdServiceImpl f3874n;
    private be f3875o;
    private PostbackServiceImpl f3876p;
    private EventServiceImpl f3877q;
    private bn f3878r;
    private boolean f3879s;
    private boolean f3880t;
    private boolean f3881u;
    private boolean f3882v;
    private boolean f3883w;
    private boolean f3884x;

    public AppLovinSdkImpl() {
        this.f3879s = true;
        this.f3880t = false;
        this.f3881u = false;
        this.f3882v = false;
        this.f3883w = false;
        this.f3884x = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4158a(android.content.Context r7) {
        /*
        r6 = this;
        r5 = 624; // 0x270 float:8.74E-43 double:3.083E-321;
        r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r7);
        r0 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r2 = 0;
        r0 = r1.getInt(r0, r2);	 Catch:{ Exception -> 0x003a }
        if (r0 >= r5) goto L_0x0032;
    L_0x000f:
        r0 = "AppLovinSdkImpl";
        r2 = "SDK has been updated since last run. Continuing...";
        android.util.Log.i(r0, r2);	 Catch:{ Exception -> 0x003a }
        r0 = r6.getSettingsManager();	 Catch:{ Exception -> 0x003a }
        r0.m175d();	 Catch:{ Exception -> 0x003a }
        r0 = r6.getSettingsManager();	 Catch:{ Exception -> 0x003a }
        r0.m173b();	 Catch:{ Exception -> 0x003a }
    L_0x0024:
        r0 = r1.edit();
        r1 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r0 = r0.putInt(r1, r5);
        r0.apply();
    L_0x0031:
        return;
    L_0x0032:
        r0 = "AppLovinSdkImpl";
        r2 = "SDK has not been updated since last run. Continuing...";
        android.util.Log.d(r0, r2);	 Catch:{ Exception -> 0x003a }
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = r6.getLogger();	 Catch:{ all -> 0x0054 }
        r3 = "AppLovinSdkImpl";
        r4 = "Unable to check for SDK update";
        r2.m308e(r3, r4, r0);	 Catch:{ all -> 0x0054 }
        r0 = r1.edit();
        r1 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r0 = r0.putInt(r1, r5);
        r0.apply();
        goto L_0x0031;
    L_0x0054:
        r0 = move-exception;
        r1 = r1.edit();
        r2 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r1 = r1.putInt(r2, r5);
        r1.apply();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinSdkImpl.a(android.content.Context):void");
    }

    private static boolean m4159i() {
        return (VERSION.RELEASE.startsWith("1.") || VERSION.RELEASE.startsWith("2.0") || VERSION.RELEASE.startsWith("2.1")) ? false : true;
    }

    cr m4160a() {
        return this.f3865e;
    }

    Object m4161a(bz bzVar) {
        return this.f3866f.m169a(bzVar);
    }

    void m4162a(boolean z) {
        this.f3879s = false;
        this.f3880t = z;
        this.f3881u = true;
    }

    cc m4163b() {
        return this.f3868h;
    }

    C1548b m4164c() {
        return this.f3870j;
    }

    public boolean checkCorrectInitialization(Context context) {
        try {
            getLogger().m306d(AppLovinLogger.SDK_TAG, "Checking if sdk is initialized in main activity...");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            String stackTraceString = Log.getStackTraceString(new Throwable());
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                getLogger().m306d(AppLovinLogger.SDK_TAG, "Found " + queryIntentActivities.size() + " main activities for this application");
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (stackTraceString.contains(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            }
            getLogger().m310w(AppLovinLogger.SDK_TAG, "AppLovin SDK was initialized too late in session; SDK should always be initialized within main activity and/or any relevant entry points");
            getLogger().m310w(AppLovinLogger.SDK_TAG, "Initialization instead happened from: " + stackTraceString);
        } catch (Throwable th) {
            getLogger().m308e(AppLovinLogger.SDK_TAG, "Error checking if sdk is initialized in main activity...", th);
        }
        return false;
    }

    bc m4165d() {
        return this.f3871k;
    }

    boolean m4166e() {
        return this.f3879s;
    }

    boolean m4167f() {
        return this.f3881u;
    }

    void m4168g() {
        this.f3879s = true;
        this.f3865e.m235a(new cq(this), 0);
    }

    public AppLovinAdService getAdService() {
        return this.f3874n;
    }

    public Context getApplicationContext() {
        return this.f3863c;
    }

    public C0238o getConnectionManager() {
        return this.f3867g;
    }

    public C0241r getDataCollector() {
        return this.f3872l;
    }

    public AppLovinEventService getEventService() {
        return this.f3877q;
    }

    public C0246z getFileManager() {
        return this.f3869i;
    }

    public AppLovinLogger getLogger() {
        return this.f3864d;
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.f3875o;
    }

    public bn getPersistentPostbackManager() {
        return this.f3878r;
    }

    public PostbackServiceImpl getPostbackService() {
        return this.f3876p;
    }

    public String getSdkKey() {
        return this.f3861a;
    }

    public AppLovinSdkSettings getSettings() {
        return this.f3862b;
    }

    public ca getSettingsManager() {
        return this.f3866f;
    }

    public AppLovinTargetingData getTargetingData() {
        return this.f3873m;
    }

    void m4169h() {
        this.f3866f.m175d();
        this.f3866f.m173b();
        this.f3868h.m215a();
    }

    public boolean hasCriticalErrors() {
        return this.f3882v || this.f3883w;
    }

    public void initialize(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.f3861a = str;
        this.f3862b = appLovinSdkSettings;
        this.f3863c = context;
        try {
            C1178k c1178k = new C1178k();
            this.f3864d = c1178k;
            this.f3866f = new ca(this);
            this.f3865e = new cr(this);
            this.f3867g = new C0238o(this);
            this.f3868h = new cc(this);
            this.f3869i = new C0246z(this);
            this.f3872l = new C0241r(this);
            this.f3874n = new AppLovinAdServiceImpl(this);
            this.f3875o = new be(this);
            this.f3876p = new PostbackServiceImpl(this);
            this.f3877q = new EventServiceImpl(this);
            this.f3878r = new bn(this);
            this.f3870j = new C1548b(this);
            this.f3871k = new bc(this);
            this.f3873m = new C1179m(this);
            if (!m4159i()) {
                this.f3882v = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
            }
            if (str == null || str.length() < 1) {
                this.f3883w = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                Writer stringWriter = new StringWriter();
                new Throwable(XMLConstants.NULL_NS_URI).printStackTrace(new PrintWriter(stringWriter));
                Log.e(AppLovinLogger.SDK_TAG, "Called with an invalid SDK key from: " + stringWriter.toString());
            }
            if (hasCriticalErrors()) {
                m4162a(false);
                return;
            }
            c1178k.m4294a(this.f3866f);
            if (appLovinSdkSettings instanceof ax) {
                c1178k.m4295a(((ax) appLovinSdkSettings).m4182a());
            }
            m4158a(context);
            this.f3866f.m174c();
            if (((Boolean) this.f3866f.m169a(bx.f259b)).booleanValue()) {
                this.f3866f.m171a(appLovinSdkSettings);
                this.f3866f.m173b();
            }
            m4168g();
        } catch (Throwable th) {
            Log.e(AppLovinLogger.SDK_TAG, "Failed to load AppLovin SDK, ad serving will be disabled", th);
            m4162a(false);
        }
    }

    public void initializeSdk() {
    }

    public boolean isEnabled() {
        return this.f3880t;
    }

    public boolean isInitializedInMainActivity() {
        return this.f3884x;
    }

    public void setInitializedInMainActivity(boolean z) {
        this.f3884x = z;
    }

    public void setPluginVersion(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No version specified");
        }
        this.f3866f.m170a(bx.f283z, str);
        this.f3866f.m173b();
    }
}
