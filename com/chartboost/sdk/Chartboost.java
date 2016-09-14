package com.chartboost.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import com.chartboost.sdk.C0299c.C0298a;
import com.chartboost.sdk.InPlay.C0261a;
import com.chartboost.sdk.Libraries.C0262a;
import com.chartboost.sdk.Libraries.C0266c;
import com.chartboost.sdk.Libraries.C0276g;
import com.chartboost.sdk.Libraries.C0282k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C0291a;
import com.chartboost.sdk.Model.C0291a.C0287b;
import com.chartboost.sdk.Model.C0291a.C0290e;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.C1203a;
import com.chartboost.sdk.impl.C0417m;
import com.chartboost.sdk.impl.ae;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.av;
import com.chartboost.sdk.impl.ax;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.az;
import com.chartboost.sdk.impl.ba;
import com.chartboost.sdk.impl.bc;
import com.chartboost.sdk.impl.be;
import mf.org.apache.xerces.impl.XMLEntityManager;
import mf.org.w3c.dom.traversal.NodeFilter;

public final class Chartboost {
    protected static volatile Handler f424a;
    protected static C0282k f425b;
    private static volatile Chartboost f426c;
    private static CBImpressionActivity f427d;
    private static C0291a f428e;
    private static ay f429f;
    private static ba f430g;
    private static C0417m f431h;
    private static C1203a f432i;
    public static boolean isFirstHardBootup;
    private static boolean f433j;
    private static SparseBooleanArray f434k;
    private static C0315f f435l;
    private static C0304d f436m;
    private static boolean f437n;
    private static Runnable f438o;
    private static boolean f439p;
    private static boolean f440q;
    private static Runnable f441r;

    /* renamed from: com.chartboost.sdk.Chartboost.11 */
    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ String f378a;

        AnonymousClass11(String str) {
            this.f378a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f378a)) {
                CBLogging.m381b("Chartboost", "cacheMoreApps location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadMoreApps(this.f378a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            av.m4531h().m715b(this.f378a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.12 */
    static class AnonymousClass12 implements Runnable {
        final /* synthetic */ Activity f379a;
        final /* synthetic */ String f380b;
        final /* synthetic */ String f381c;

        AnonymousClass12(Activity activity, String str, String str2) {
            this.f379a = activity;
            this.f380b = str;
            this.f381c = str2;
        }

        public void run() {
            Chartboost.f426c = new Chartboost(this.f380b, this.f381c, null);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.13 */
    static class AnonymousClass13 implements Runnable {
        final /* synthetic */ String f382a;

        AnonymousClass13(String str) {
            this.f382a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f382a)) {
                CBLogging.m381b("Chartboost", "showMoreApps location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadMoreApps(this.f382a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            av.m4531h().m4535a(this.f382a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.14 */
    static class AnonymousClass14 implements Runnable {
        final /* synthetic */ CBMediation f383a;
        final /* synthetic */ String f384b;

        AnonymousClass14(CBMediation cBMediation, String str) {
            this.f383a = cBMediation;
            this.f384b = str;
        }

        public void run() {
            C0299c.m638a(this.f383a, this.f384b);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.15 */
    static class AnonymousClass15 implements Runnable {
        final /* synthetic */ CBFramework f385a;

        AnonymousClass15(CBFramework cBFramework) {
            this.f385a = cBFramework;
        }

        public void run() {
            C0299c.m636a(this.f385a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.16 */
    static class AnonymousClass16 implements Runnable {
        final /* synthetic */ CBFramework f386a;
        final /* synthetic */ String f387b;

        AnonymousClass16(CBFramework cBFramework, String str) {
            this.f386a = cBFramework;
            this.f387b = str;
        }

        public void run() {
            C0299c.m637a(this.f386a, this.f387b);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.17 */
    static class AnonymousClass17 implements Runnable {
        final /* synthetic */ String f388a;

        AnonymousClass17(String str) {
            this.f388a = str;
        }

        public void run() {
            C0299c.m643a(this.f388a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.18 */
    static class AnonymousClass18 implements Runnable {
        final /* synthetic */ String f389a;

        AnonymousClass18(String str) {
            this.f389a = str;
        }

        public void run() {
            C0299c.m656d(this.f389a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.19 */
    static class AnonymousClass19 implements Runnable {
        final /* synthetic */ Level f390a;

        AnonymousClass19(Level level) {
            this.f390a = level;
        }

        public void run() {
            C0299c.m639a(this.f390a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.20 */
    static class AnonymousClass20 implements Runnable {
        final /* synthetic */ ChartboostDelegate f391a;

        AnonymousClass20(ChartboostDelegate chartboostDelegate) {
            this.f391a = chartboostDelegate;
        }

        public void run() {
            C0299c.m641a(this.f391a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.21 */
    static class AnonymousClass21 implements Runnable {
        final /* synthetic */ boolean f392a;

        AnonymousClass21(boolean z) {
            this.f392a = z;
        }

        public void run() {
            C0299c.m644a(this.f392a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.22 */
    static class AnonymousClass22 implements Runnable {
        final /* synthetic */ boolean f393a;

        AnonymousClass22(boolean z) {
            this.f393a = z;
        }

        public void run() {
            C0299c.m660e(this.f393a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.23 */
    static class AnonymousClass23 implements Runnable {
        final /* synthetic */ Activity f394a;

        AnonymousClass23(Activity activity) {
            this.f394a = activity;
        }

        public void run() {
            Chartboost.m342e(this.f394a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.24 */
    static class AnonymousClass24 implements Runnable {
        final /* synthetic */ boolean f395a;

        AnonymousClass24(boolean z) {
            this.f395a = z;
        }

        public void run() {
            C0299c.m662f(this.f395a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.25 */
    static class AnonymousClass25 implements Runnable {
        final /* synthetic */ boolean f396a;

        AnonymousClass25(boolean z) {
            this.f396a = z;
        }

        public void run() {
            C0299c.m664g(this.f396a);
            String C = C0299c.m629C();
            if (this.f396a) {
                if (C.equals("/webview/v1/prefetch")) {
                    C0297b.m610b();
                } else {
                    be.m972b();
                }
            } else if (C.equals("/webview/v1/prefetch")) {
                C0297b.m615e();
            } else {
                be.m976d();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.26 */
    static class AnonymousClass26 implements Runnable {
        final /* synthetic */ Activity f397a;

        AnonymousClass26(Activity activity) {
            this.f397a = activity;
        }

        public void run() {
            CBLogging.m387e("VideoInit", "preparing activity for video surface");
            this.f397a.addContentView(new SurfaceView(this.f397a), new LayoutParams(0, 0));
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.27 */
    static class AnonymousClass27 implements Runnable {
        final /* synthetic */ String f398a;
        final /* synthetic */ boolean f399b;

        AnonymousClass27(String str, boolean z) {
            this.f398a = str;
            this.f399b = z;
        }

        public void run() {
            ae.m4445h().m716b(this.f398a, this.f399b);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.28 */
    static class AnonymousClass28 implements Runnable {
        final /* synthetic */ String f400a;
        final /* synthetic */ boolean f401b;

        AnonymousClass28(String str, boolean z) {
            this.f400a = str;
            this.f401b = z;
        }

        public void run() {
            av.m4531h().m716b(this.f400a, this.f401b);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.29 */
    static class AnonymousClass29 implements Runnable {
        final /* synthetic */ String f402a;
        final /* synthetic */ boolean f403b;

        AnonymousClass29(String str, boolean z) {
            this.f402a = str;
            this.f403b = z;
        }

        public void run() {
            af.m5701j().m716b(this.f402a, this.f403b);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.2 */
    static class C02522 implements Runnable {
        final /* synthetic */ Activity f404a;

        C02522(Activity activity) {
            this.f404a = activity;
        }

        public void run() {
            C0282k a = C0282k.m549a(this.f404a);
            if (Chartboost.m341d(a)) {
                Chartboost.m346f(a);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.30 */
    static class AnonymousClass30 implements Runnable {
        final /* synthetic */ boolean f405a;

        AnonymousClass30(boolean z) {
            this.f405a = z;
        }

        public void run() {
            if (Chartboost.f427d == null) {
                return;
            }
            if (this.f405a) {
                Chartboost.f427d.forwardTouchEvents(Chartboost.getHostActivity());
            } else {
                Chartboost.f427d.forwardTouchEvents(null);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.31 */
    static class AnonymousClass31 implements Runnable {
        final /* synthetic */ Activity f406a;

        AnonymousClass31(Activity activity) {
            this.f406a = activity;
        }

        public void run() {
            Chartboost.f424a.removeCallbacks(Chartboost.f438o);
            if (!(Chartboost.f425b == null || Chartboost.f425b.m553b(this.f406a) || !Chartboost.m358p())) {
                Chartboost.m346f(Chartboost.f425b);
                Chartboost.m338c(Chartboost.f425b, false);
            }
            Chartboost.m332b(this.f406a, true);
            Chartboost.f425b = C0282k.m549a(this.f406a);
            Chartboost.m319a();
            Chartboost.m321a(this.f406a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.35 */
    static class AnonymousClass35 implements Runnable {
        final /* synthetic */ Activity f407a;

        AnonymousClass35(Activity activity) {
            this.f407a = activity;
        }

        public void run() {
            C0282k a = C0282k.m549a(this.f407a);
            if (Chartboost.m341d(a)) {
                Chartboost.m324a(a);
            } else if (C0299c.m647b() != null && C0299c.m647b().ordinal() == CBFramework.CBFrameworkUnity.ordinal()) {
                Chartboost.m319a();
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.36 */
    static class AnonymousClass36 implements Runnable {
        final /* synthetic */ Activity f408a;

        AnonymousClass36(Activity activity) {
            this.f408a = activity;
        }

        public void run() {
            C0282k a = C0282k.m549a(this.f408a);
            if (Chartboost.m341d(a)) {
                Chartboost.m333b(a);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.3 */
    static class C02533 implements Runnable {
        final /* synthetic */ C0304d f409a;

        C02533(C0304d c0304d) {
            this.f409a = c0304d;
        }

        public void run() {
            this.f409a.m692b();
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.4 */
    static class C02544 implements Runnable {
        final /* synthetic */ C0315f f410a;
        final /* synthetic */ C0304d f411b;

        C02544(C0315f c0315f, C0304d c0304d) {
            this.f410a = c0315f;
            this.f411b = c0304d;
        }

        public void run() {
            this.f410a.m748a(this.f411b.m693c(), true);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.5 */
    static class C02555 implements Runnable {
        final /* synthetic */ Activity f412a;

        C02555(Activity activity) {
            this.f412a = activity;
        }

        public void run() {
            if (Chartboost.f425b == null || Chartboost.f425b.m553b(this.f412a)) {
                Chartboost.f438o = new C0260a();
                Chartboost.f438o.run();
            }
            Chartboost.m331b(this.f412a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.6 */
    static class C02566 implements Runnable {
        final /* synthetic */ String f413a;

        C02566(String str) {
            this.f413a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f413a)) {
                CBLogging.m381b("Chartboost", "cacheRewardedVideo location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadRewardedVideo(this.f413a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            af.m5701j().m715b(this.f413a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.7 */
    static class C02577 implements Runnable {
        final /* synthetic */ String f414a;

        C02577(String str) {
            this.f414a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f414a)) {
                CBLogging.m381b("Chartboost", "showRewardedVideo location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadRewardedVideo(this.f414a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            af.m5701j().m713a(this.f414a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.8 */
    static class C02588 implements Runnable {
        final /* synthetic */ String f415a;

        C02588(String str) {
            this.f415a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f415a)) {
                CBLogging.m381b("Chartboost", "cacheInterstitial location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadInterstitial(this.f415a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            ae.m4445h().m715b(this.f415a);
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.9 */
    static class C02599 implements Runnable {
        final /* synthetic */ String f416a;

        C02599(String str) {
            this.f416a = str;
        }

        public void run() {
            if (!C0299c.m674q()) {
                return;
            }
            if (TextUtils.isEmpty(this.f416a)) {
                CBLogging.m381b("Chartboost", "showInterstitial location cannot be empty");
                if (C0299c.m663g() != null) {
                    C0299c.m663g().didFailToLoadInterstitial(this.f416a, CBImpressionError.INVALID_LOCATION);
                    return;
                }
                return;
            }
            ae.m4445h().m713a(this.f416a);
        }
    }

    public enum CBFramework {
        CBFrameworkUnity("Unity"),
        CBFrameworkCorona("Corona"),
        CBFrameworkAir("AIR"),
        CBFrameworkGameSalad("GameSalad"),
        CBFrameworkCordova("Cordova"),
        CBFrameworkCocoonJS("CocoonJS"),
        CBFrameworkCocos2dx("Cocos2dx"),
        CBFrameworkPrime31Unreal("Prime31Unreal"),
        CBFrameworkWeeby("Weeby"),
        CBFrameworkOther("Other");
        
        private final String f418a;

        private CBFramework(String s) {
            this.f418a = s;
        }

        public String toString() {
            return this.f418a;
        }

        public boolean doesWrapperUseCustomShouldDisplayBehavior() {
            return this == CBFrameworkAir || this == CBFrameworkCocos2dx;
        }

        public boolean doesWrapperUseCustomBackgroundingBehavior() {
            return this == CBFrameworkAir;
        }
    }

    public enum CBMediation {
        CBMediationAdMarvel("AdMarvel"),
        CBMediationFuse("Fuse"),
        CBMediationFyber("Fyber"),
        CBMediationHeyZap("HeyZap"),
        CBMediationMoPub("MoPub"),
        CBMediationSupersonic("Supersonic"),
        CBMediationOther("Other");
        
        private final String f420a;

        private CBMediation(String s) {
            this.f420a = s;
        }

        public String toString() {
            return this.f420a;
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.a */
    private static class C0260a implements Runnable {
        private int f421a;
        private int f422b;
        private int f423c;

        private C0293a m317a() {
            return C0299c.m663g();
        }

        private C0260a() {
            int i = -1;
            C0293a a = m317a();
            this.f421a = Chartboost.f427d == null ? -1 : Chartboost.f427d.hashCode();
            this.f422b = Chartboost.f425b == null ? -1 : Chartboost.f425b.hashCode();
            if (a != null) {
                i = a.hashCode();
            }
            this.f423c = i;
        }

        public void run() {
            C0293a a = m317a();
            if (Chartboost.f425b != null && Chartboost.f425b.hashCode() == this.f422b) {
                Chartboost.f425b = null;
            }
            if (a != null && a.hashCode() == this.f423c) {
                C0299c.m641a(null);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.Chartboost.1 */
    class C11831 implements C0298a {
        final /* synthetic */ Chartboost f3969a;

        C11831(Chartboost chartboost) {
            this.f3969a = chartboost;
        }

        public void m4308a() {
            az azVar = new az("api/install");
            azVar.m871a(true);
            azVar.m872a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a));
            azVar.m894s();
            Chartboost.m357o();
            Chartboost.isFirstHardBootup = false;
        }
    }

    static {
        f426c = null;
        f427d = null;
        f428e = null;
        f429f = null;
        f430g = null;
        f431h = null;
        f432i = null;
        f433j = false;
        f434k = new SparseBooleanArray();
        f435l = null;
        f436m = null;
        isFirstHardBootup = true;
        f437n = false;
        f424a = new Handler(Looper.getMainLooper());
        f425b = null;
        f439p = false;
        f440q = false;
        f441r = new Runnable() {
            public void run() {
                if (!Chartboost.f440q) {
                    Chartboost.m335c();
                }
                Chartboost.f440q = false;
            }
        };
    }

    private Chartboost(Activity app, String appId, String appSignature) {
        f426c = this;
        CBUtility.m394a(f424a);
        C0299c.m634a(app.getApplication());
        C0299c.m635a(app.getApplicationContext());
        C0299c.m648b(appId);
        C0299c.m653c(appSignature);
        f429f = ay.m847a();
        f435l = C0315f.m744a();
        f430g = ba.m914a(C0299c.m682y());
        f431h = f430g.m927a();
        f436m = C0304d.m686a();
        f432i = C1203a.m4355a();
        f429f.m849a(C0299c.m682y());
        C0297b.m602a();
        be.m965a();
        f438o = new C0260a();
        C0266c.m410a();
        synchronized (f426c) {
            C0299c.m642a(new C11831(this));
        }
    }

    public static void startWithAppId(Activity activity, String appId, String appSignature) {
        if (f426c == null) {
            synchronized (Chartboost.class) {
                if (f426c == null) {
                    if (activity == null && !(activity instanceof Activity)) {
                        CBLogging.m381b("Chartboost", "Activity object is null. Please pass a valid activity object");
                        return;
                    } else if (!C0299c.m650b(activity)) {
                        CBLogging.m381b("Chartboost", "Permissions not set correctly");
                        return;
                    } else if (!C0299c.m651b((Context) activity)) {
                        CBLogging.m381b("Chartboost", "CBImpression Activity not added in your manifest.xml");
                        return;
                    } else if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(appSignature)) {
                        CBLogging.m381b("Chartboost", "AppId or AppSignature is null. Please pass a valid id's");
                        return;
                    } else {
                        m327a(new AnonymousClass12(activity, appId, appSignature));
                    }
                }
            }
        }
    }

    public static void onCreate(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new AnonymousClass23(activity));
        }
    }

    private static void m342e(Activity activity) {
        if (!(f425b == null || f425b.m553b(activity) || !m358p())) {
            m346f(f425b);
            m338c(f425b, false);
        }
        f424a.removeCallbacks(f438o);
        f425b = C0282k.m549a(activity);
        if (C0299c.m632F().booleanValue()) {
            m336c(activity);
        }
        ba.m914a((Context) activity).m931d();
    }

    public static void onStart(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new AnonymousClass31(activity));
        }
    }

    protected static void m321a(Activity activity) {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            C0299c.m650b(activity);
        }
        f429f.m852b(C0299c.m682y());
        if (!(activity instanceof CBImpressionActivity)) {
            f431h.m1120a();
            f430g.m932f();
        }
        C0299c.m635a(activity.getApplicationContext());
        if (activity instanceof CBImpressionActivity) {
            m323a((CBImpressionActivity) activity);
        } else {
            f425b = C0282k.m549a(activity);
            m338c(f425b, true);
        }
        f424a.removeCallbacks(f438o);
        if (C0299c.m647b() == null || !C0299c.m647b().doesWrapperUseCustomBackgroundingBehavior()) {
            z = false;
        } else {
            z = true;
        }
        if (activity == null) {
            return;
        }
        if (z || m347f(activity)) {
            m334b(C0282k.m549a(activity), true);
            if (activity instanceof CBImpressionActivity) {
                f437n = false;
            }
            if (f436m.m690a(activity, f428e)) {
                f428e = null;
            }
            C0291a c = f436m.m693c();
            if (c != null) {
                c.m594y();
            }
        }
    }

    protected static void m319a() {
        if (C0299c.m682y() == null) {
            CBLogging.m381b("Chartboost", "The context must be set through the Chartboost method onCreate() before calling startSession().");
        } else if (!C0299c.m665h() || !C0299c.m673p()) {
            m356n();
        } else if (f439p) {
            f440q = true;
        } else {
            f440q = false;
            m356n();
        }
    }

    protected static void m330b() {
        if (C0299c.m665h()) {
            f424a.postDelayed(f441r, 500);
        } else {
            m335c();
        }
    }

    private static void m356n() {
        f439p = true;
        C0299c.m649b(true);
        if (f432i == null) {
            f432i = C1203a.m4355a();
        }
        f432i.m4389h();
        C1203a.m4367b();
        synchronized (f426c) {
            if (!isFirstHardBootup) {
                C0299c.m642a(new C0298a() {
                    public void m4309a() {
                        az azVar = new az("api/install");
                        azVar.m871a(true);
                        azVar.m872a(C0276g.m482a(NotificationCompatApi21.CATEGORY_STATUS, C0262a.f458a));
                        azVar.m894s();
                        Chartboost.m357o();
                    }
                });
            }
        }
    }

    private static void m357o() {
        ax.m845a().execute(new Runnable() {
            public void run() {
                try {
                    if (C0299c.m629C().equals("/webview/v1/prefetch")) {
                        C0297b.m610b();
                    } else {
                        be.m972b();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected static void m335c() {
        f439p = false;
        if (f432i == null) {
            f432i = C1203a.m4355a();
        }
        f432i.m4385c();
    }

    public static void onResume(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new AnonymousClass35(activity));
        }
    }

    protected static void m324a(C0282k c0282k) {
        C0291a c = C0304d.m686a().m693c();
        if (C0299c.m647b() != null && C0299c.m647b().ordinal() == CBFramework.CBFrameworkUnity.ordinal()) {
            m319a();
        }
        if (c != null) {
            c.m593x();
        }
    }

    public static void onPause(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new AnonymousClass36(activity));
        }
    }

    protected static void m333b(C0282k c0282k) {
        C0291a c = C0304d.m686a().m693c();
        if (c != null) {
            c.m595z();
        }
    }

    public static void onStop(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new C02522(activity));
        }
    }

    private static void m346f(C0282k c0282k) {
        if (!C0299c.m665h()) {
            m337c(c0282k);
        }
        if (!(c0282k.get() instanceof CBImpressionActivity)) {
            m338c(c0282k, false);
        }
        m330b();
    }

    protected static void m337c(C0282k c0282k) {
        C0291a c = C0304d.m686a().m693c();
        if (c != null && c.f596a == C0287b.NATIVE) {
            C0315f h = m350h();
            if (m349g(c0282k) && h != null) {
                if (c != null) {
                    h.m751c(c);
                    f428e = c;
                }
                m334b(c0282k, false);
                if (c0282k.get() instanceof CBImpressionActivity) {
                    m348g();
                }
            }
            if (!(c0282k.get() instanceof CBImpressionActivity)) {
                m338c(c0282k, false);
            }
        }
        f429f.m854c(C0299c.m682y());
        if (!(c0282k.get() instanceof CBImpressionActivity)) {
            f431h.m1124b();
            f430g.m933g();
        }
    }

    public static boolean onBackPressed() {
        if (!C0299c.m677t()) {
            return false;
        }
        if (f425b == null) {
            CBLogging.m381b("Chartboost", "The Chartboost methods onCreate(), onStart(), onStop(), and onDestroy() must be called in the corresponding methods of your activity in order for Chartboost to function properly.");
            return false;
        } else if (!C0299c.m665h()) {
            return m340d();
        } else {
            if (!f437n) {
                return false;
            }
            f437n = false;
            m340d();
            return true;
        }
    }

    protected static boolean m340d() {
        return m344e();
    }

    protected static boolean m344e() {
        C0304d a = C0304d.m686a();
        C0291a c = a.m693c();
        if (c == null || c.f598c != C0290e.DISPLAYED) {
            C0315f h = m350h();
            if (h == null || !h.m752c()) {
                return false;
            }
            m327a(new C02544(h, a));
            return true;
        } else if (c.m592w()) {
            return true;
        } else {
            m327a(new C02533(a));
            return true;
        }
    }

    public static void onDestroy(Activity activity) {
        if (C0299c.m677t() && C0299c.m646a(activity)) {
            m327a(new C02555(activity));
        }
    }

    protected static void m331b(Activity activity) {
        m334b(C0282k.m549a(activity), false);
        f428e = null;
    }

    public static void didPassAgeGate(boolean pass) {
        C0299c.m654c(pass);
    }

    public static void setShouldPauseClickForConfirmation(boolean shouldPause) {
        C0299c.m657d(shouldPause);
    }

    public static void clearCache() {
        if (C0299c.m674q()) {
            bc.m956a().m963b();
            af.m5701j().m707a();
            ae.m4445h().m707a();
            av.m4531h().m4533a();
            C0261a.m369b();
        }
    }

    public static boolean hasRewardedVideo(String location) {
        if (C0299c.m674q()) {
            return af.m5701j().m720c(location);
        }
        return false;
    }

    public static void cacheRewardedVideo(String location) {
        m327a(new C02566(location));
    }

    public static void showRewardedVideo(String location) {
        m327a(new C02577(location));
    }

    public static boolean hasInterstitial(String location) {
        if (C0299c.m674q()) {
            return ae.m4445h().m720c(location);
        }
        return false;
    }

    public static void cacheInterstitial(String location) {
        m327a(new C02588(location));
    }

    public static void showInterstitial(String location) {
        m327a(new C02599(location));
    }

    public static void closeImpression() {
        m327a(new Runnable() {
            public void run() {
                if (C0299c.m674q()) {
                    Chartboost.m344e();
                }
            }
        });
    }

    public static boolean hasMoreApps(String location) {
        if (C0299c.m674q()) {
            return av.m4531h().m720c(location);
        }
        return false;
    }

    public static void cacheMoreApps(String location) {
        m327a(new AnonymousClass11(location));
    }

    public static void showMoreApps(String location) {
        m327a(new AnonymousClass13(location));
    }

    public static boolean isAnyViewVisible() {
        C0315f h = m350h();
        if (h == null) {
            return false;
        }
        return h.m754d();
    }

    public static void setMediation(CBMediation mediation, String libraryVersion) {
        m327a(new AnonymousClass14(mediation, libraryVersion));
    }

    public static void setFramework(CBFramework framework) {
        m327a(new AnonymousClass15(framework));
    }

    public static void setFramework(CBFramework framework, String version) {
        m327a(new AnonymousClass16(framework, version));
    }

    public static void setFrameworkVersion(String version) {
        m327a(new AnonymousClass17(version));
    }

    public static String getCustomId() {
        return C0299c.m672o();
    }

    public static void setCustomId(String customID) {
        m327a(new AnonymousClass18(customID));
    }

    public static void setLoggingLevel(Level lvl) {
        m327a(new AnonymousClass19(lvl));
    }

    public static Level getLoggingLevel() {
        return C0299c.m671n();
    }

    public static C0293a getDelegate() {
        return C0299c.m663g();
    }

    public static void setDelegate(ChartboostDelegate delegate) {
        m327a(new AnonymousClass20(delegate));
    }

    public static boolean getAutoCacheAds() {
        return C0299c.m667j();
    }

    public static void setAutoCacheAds(boolean autoCacheAds) {
        m327a(new AnonymousClass21(autoCacheAds));
    }

    public static void setShouldRequestInterstitialsInFirstSession(boolean shouldRequest) {
        m327a(new AnonymousClass22(shouldRequest));
    }

    public static void setShouldDisplayLoadingViewForMoreApps(boolean shouldDisplay) {
        m327a(new AnonymousClass24(shouldDisplay));
    }

    public static void setShouldPrefetchVideoContent(boolean shouldPrefetch) {
        m327a(new AnonymousClass25(shouldPrefetch));
    }

    protected static Activity m345f() {
        if (C0299c.m665h()) {
            return f427d;
        }
        return getHostActivity();
    }

    private static boolean m347f(Activity activity) {
        if (C0299c.m665h()) {
            if (f427d == activity) {
                return true;
            }
            return false;
        } else if (f425b != null) {
            return f425b.m553b(activity);
        } else {
            if (activity != null) {
                return false;
            }
            return true;
        }
    }

    private static boolean m349g(C0282k c0282k) {
        if (C0299c.m665h()) {
            if (c0282k != null) {
                return c0282k.m553b(f427d);
            }
            if (f427d == null) {
                return true;
            }
            return false;
        } else if (f425b != null) {
            return f425b.m551a(c0282k);
        } else {
            if (c0282k != null) {
                return false;
            }
            return true;
        }
    }

    protected static void m323a(CBImpressionActivity cBImpressionActivity) {
        if (!f433j) {
            C0299c.m635a(cBImpressionActivity.getApplicationContext());
            f427d = cBImpressionActivity;
            f433j = true;
        }
        f424a.removeCallbacks(f438o);
    }

    protected static void m348g() {
        if (f433j) {
            f427d = null;
            f433j = false;
        }
    }

    protected static void m326a(C0291a c0291a) {
        boolean z = true;
        C0315f h = m350h();
        if (h != null && h.m754d() && h.m755e().m1046h() != c0291a) {
            c0291a.m567a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (!C0299c.m665h()) {
            h = m350h();
            if (h == null || !m358p()) {
                c0291a.m567a(CBImpressionError.NO_HOST_ACTIVITY);
            } else {
                h.m747a(c0291a);
            }
        } else if (f433j) {
            if (m345f() == null || h == null) {
                if (m345f() == null) {
                    CBLogging.m381b("Chartboost", "Activity not found. Cannot display the view");
                    c0291a.m567a(CBImpressionError.NO_HOST_ACTIVITY);
                    return;
                }
                CBLogging.m381b("Chartboost", "Missing view controller to manage the impression activity");
                c0291a.m567a(CBImpressionError.ERROR_DISPLAYING_VIEW);
            } else if (c0291a.f596a == C0287b.WEB) {
                C0320g B = c0291a.m564B();
                if (B != null) {
                    B.m781c();
                }
            } else {
                h.m747a(c0291a);
            }
        } else if (m358p()) {
            Context hostActivity = getHostActivity();
            if (hostActivity == null) {
                CBLogging.m381b("Chartboost", "Failed to display impression as the host activity reference has been lost!");
                c0291a.m567a(CBImpressionError.NO_HOST_ACTIVITY);
            } else if (f428e == null || f428e == c0291a) {
                f428e = c0291a;
                Intent intent = new Intent(hostActivity, CBImpressionActivity.class);
                boolean z2 = (hostActivity.getWindow().getAttributes().flags & NodeFilter.SHOW_DOCUMENT_FRAGMENT) != 0;
                boolean z3;
                if ((hostActivity.getWindow().getAttributes().flags & XMLEntityManager.DEFAULT_BUFFER_SIZE) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String str = "paramFullscreen";
                if (!z2 || r3) {
                    z = false;
                }
                intent.putExtra(str, z);
                try {
                    hostActivity.startActivity(intent);
                    f437n = true;
                } catch (ActivityNotFoundException e) {
                    CBLogging.m381b("Chartboost", "Chartboost impression activity not declared in manifest. Please add the following inside your manifest's <application> tag: \n<activity android:name=\"com.chartboost.sdk.CBImpressionActivity\" android:theme=\"@android:style/Theme.Translucent.NoTitleBar\" android:excludeFromRecents=\"true\" />");
                }
            } else {
                c0291a.m567a(CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
            }
        } else {
            c0291a.m567a(CBImpressionError.NO_HOST_ACTIVITY);
        }
    }

    protected static Activity getHostActivity() {
        return f425b != null ? (Activity) f425b.get() : null;
    }

    protected static void m327a(Runnable runnable) {
        if (CBUtility.m396b()) {
            runnable.run();
        } else {
            f424a.post(runnable);
        }
    }

    protected static Context getValidContext() {
        return f425b != null ? f425b.m552b() : C0299c.m682y();
    }

    private static void m334b(C0282k c0282k, boolean z) {
    }

    private static boolean m358p() {
        return m341d(f425b);
    }

    protected static boolean m341d(C0282k c0282k) {
        if (c0282k == null) {
            return false;
        }
        Boolean valueOf = Boolean.valueOf(f434k.get(c0282k.m550a()));
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    private static void m332b(Activity activity, boolean z) {
        if (activity != null) {
            m320a(activity.hashCode(), z);
        }
    }

    private static void m338c(C0282k c0282k, boolean z) {
        if (c0282k != null) {
            m320a(c0282k.m550a(), z);
        }
    }

    private static void m320a(int i, boolean z) {
        f434k.put(i, z);
    }

    protected static C0315f m350h() {
        if (m345f() == null) {
            return null;
        }
        return f435l;
    }

    public static boolean getImpressionsUseActivities() {
        return C0299c.m665h();
    }

    @Deprecated
    public static void setImpressionsUseActivities(boolean impressionsUseActivities) {
    }

    protected static void m336c(Activity activity) {
        if (VERSION.SDK_INT < 14) {
            f424a.post(new AnonymousClass26(activity));
        }
    }

    private static void showInterstitialAIR(String location, boolean show) {
        m327a(new AnonymousClass27(location, show));
    }

    private static void showMoreAppsAIR(String location, boolean show) {
        m327a(new AnonymousClass28(location, show));
    }

    private static void showRewardedVideoAIR(String location, boolean show) {
        m327a(new AnonymousClass29(location, show));
    }

    private static void forwardTouchEventsAIR(boolean forward) {
        m327a(new AnonymousClass30(forward));
    }
}
