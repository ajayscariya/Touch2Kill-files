package com.inmobi.signals.activityrecognition;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.signals.GoogleApiClientWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActivityRecognitionManager extends IntentService {
    private static final String f2069a;
    private static Object f2070b;
    private static Object f2071c;

    /* renamed from: com.inmobi.signals.activityrecognition.ActivityRecognitionManager.a */
    private static class C0669a implements InvocationHandler {
        private C0669a() {
        }

        public void m2176a(Bundle bundle) {
            PendingIntent service = PendingIntent.getService(SdkContext.m1562b(), 0, new Intent(SdkContext.m1562b(), ActivityRecognitionManager.class), 134217728);
            try {
                Field declaredField = Class.forName("com.google.android.gms.location.ActivityRecognition").getDeclaredField("ActivityRecognitionApi");
                Class cls = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
                Class.forName("com.google.android.gms.location.ActivityRecognitionApi").getMethod("requestActivityUpdates", new Class[]{cls, Long.TYPE, PendingIntent.class}).invoke(declaredField.get(null), new Object[]{ActivityRecognitionManager.f2071c, Integer.valueOf(1000), service});
            } catch (Throwable e) {
                Logger.m1745a(InternalLogLevel.INTERNAL, ActivityRecognitionManager.f2069a, "Unable to request activity updates from ActivityRecognition client", e);
            } catch (Throwable e2) {
                Logger.m1745a(InternalLogLevel.INTERNAL, ActivityRecognitionManager.f2069a, "Unable to request activity updates from ActivityRecognition client", e2);
            } catch (Throwable e22) {
                Logger.m1745a(InternalLogLevel.INTERNAL, ActivityRecognitionManager.f2069a, "Unable to request activity updates from ActivityRecognition client", e22);
            } catch (Throwable e222) {
                Logger.m1745a(InternalLogLevel.INTERNAL, ActivityRecognitionManager.f2069a, "Unable to request activity updates from ActivityRecognition client", e222);
            } catch (Throwable e2222) {
                Logger.m1745a(InternalLogLevel.INTERNAL, ActivityRecognitionManager.f2069a, "Unable to request activity updates from ActivityRecognition client", e2222);
            }
        }

        public void m2175a(int i) {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str = "onConnected";
            str = "onConnectionSuspended";
            if (objArr != null) {
                if (method.getName().equals("onConnected")) {
                    m2176a((Bundle) objArr[0]);
                    return null;
                } else if (method.getName().equals("onConnectionSuspended")) {
                    m2175a(((Integer) objArr[0]).intValue());
                    return null;
                }
            }
            return method.invoke(this, objArr);
        }
    }

    static {
        f2069a = ActivityRecognitionManager.class.getSimpleName();
        f2070b = null;
        f2071c = null;
    }

    public ActivityRecognitionManager() {
        super("Activity service");
    }

    static void m2177a() {
        if (GoogleApiClientWrapper.m2253a() && f2071c == null) {
            m2178a(SdkContext.m1562b());
        }
    }

    static void m2180b() {
        if (GoogleApiClientWrapper.m2253a() && f2071c != null) {
            m2184f();
        }
    }

    private static void m2178a(Context context) {
        Logger.m1744a(InternalLogLevel.INTERNAL, f2069a, "Connecting activity recognition manager.");
        f2071c = GoogleApiClientWrapper.m2251a(context, new C0669a(), new C0669a(), "com.google.android.gms.location.ActivityRecognition");
        GoogleApiClientWrapper.m2252a(f2071c);
    }

    private static void m2184f() {
        Logger.m1744a(InternalLogLevel.INTERNAL, f2069a, "Disconnecting activity recognition manager.");
        GoogleApiClientWrapper.m2254b(f2071c);
        f2070b = null;
        f2071c = null;
    }

    protected void onHandleIntent(Intent intent) {
        if (f2071c != null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2069a, "Got activity recognition intent.");
            m2179a(intent);
        }
    }

    private static void m2179a(Intent intent) {
        try {
            Class cls = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
            if (((Boolean) cls.getMethod("hasResult", new Class[]{Intent.class}).invoke(null, new Object[]{intent})).booleanValue()) {
                f2070b = cls.getMethod("getMostProbableActivity", (Class[]) null).invoke(cls.getMethod("extractResult", new Class[]{Intent.class}).invoke(null, new Object[]{intent}), (Object[]) null);
            }
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "HandleIntent: Google play services not included. Cannot get current activity.", e);
        } catch (Throwable e2) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "HandleIntent: Google play services not included. Cannot get current activity.", e2);
        } catch (Throwable e22) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "HandleIntent: Google play services not included. Cannot get current activity.", e22);
        } catch (Throwable e222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "HandleIntent: Google play services not included. Cannot get current activity.", e222);
        }
    }

    public static int m2181c() {
        int intValue;
        Throwable e;
        Throwable th;
        String str = "getType";
        if (f2070b == null) {
            return -1;
        }
        try {
            intValue = ((Integer) Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", (Class[]) null).invoke(f2070b, (Object[]) null)).intValue();
            try {
                f2070b = null;
                Logger.m1744a(InternalLogLevel.INTERNAL, f2069a, "Getting detected activity:" + intValue);
                return intValue;
            } catch (ClassNotFoundException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
                Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
                return intValue;
            } catch (InvocationTargetException e4) {
                e = e4;
                Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
                return intValue;
            } catch (IllegalAccessException e5) {
                e = e5;
                Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
                return intValue;
            }
        } catch (Throwable e6) {
            th = e6;
            intValue = -1;
            e = th;
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
            return intValue;
        } catch (Throwable e62) {
            th = e62;
            intValue = -1;
            e = th;
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
            return intValue;
        } catch (Throwable e622) {
            th = e622;
            intValue = -1;
            e = th;
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
            return intValue;
        } catch (Throwable e6222) {
            th = e6222;
            intValue = -1;
            e = th;
            Logger.m1745a(InternalLogLevel.INTERNAL, f2069a, "getDetectedActivity: Google play services not included. Returning null.", e);
            return intValue;
        }
    }
}
