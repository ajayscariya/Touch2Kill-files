package com.inmobi.signals;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.inmobi.commons.core.p003c.TelemetryComponent;
import com.inmobi.commons.core.p003c.TelemetryEvent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.PublisherProvidedUserInfo;
import com.inmobi.commons.p000a.SdkContext;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.inmobi.signals.n */
public class LocationInfo {
    private static final String f2129a;
    private static LocationInfo f2130b;
    private static Object f2131c;
    private static boolean f2132d;
    private static LocationManager f2133e;
    private static Object f2134f;
    private static boolean f2135g;

    /* renamed from: com.inmobi.signals.n.a */
    private static class LocationInfo implements InvocationHandler {
        private LocationInfo() {
        }

        public void m2284a(Bundle bundle) {
            Logger.m1744a(InternalLogLevel.INTERNAL, LocationInfo.f2129a, "Successfully connected to Google API client.");
            LocationInfo.f2135g = true;
        }

        public void m2283a(int i) {
            LocationInfo.f2135g = false;
            Logger.m1744a(InternalLogLevel.INTERNAL, LocationInfo.f2129a, "Google API client connection suspended");
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str = "onConnected";
            str = "onConnectionSuspended";
            if (objArr != null) {
                if (method.getName().equals("onConnected")) {
                    m2284a((Bundle) objArr[0]);
                    return null;
                } else if (method.getName().equals("onConnectionSuspended")) {
                    m2283a(((Integer) objArr[0]).intValue());
                    return null;
                }
            }
            return method.invoke(this, objArr);
        }
    }

    static {
        f2129a = LocationInfo.class.getSimpleName();
        f2131c = new Object();
        f2132d = false;
        f2134f = null;
        f2135g = false;
    }

    public static LocationInfo m2285a() {
        LocationInfo locationInfo = f2130b;
        if (locationInfo == null) {
            synchronized (f2131c) {
                locationInfo = f2130b;
                if (locationInfo == null) {
                    f2130b = new LocationInfo();
                    locationInfo = f2130b;
                }
            }
        }
        return locationInfo;
    }

    private LocationInfo() {
        f2133e = (LocationManager) SdkContext.m1562b().getSystemService("location");
    }

    void m2296b() {
        if (f2132d && GoogleApiClientWrapper.m2253a()) {
            m2288a(SdkContext.m1562b());
        }
    }

    private void m2288a(Context context) {
        if (f2134f == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2129a, "Connecting Google API client for location.");
            f2134f = GoogleApiClientWrapper.m2251a(context, new LocationInfo(), new LocationInfo(), "com.google.android.gms.location.LocationServices");
            GoogleApiClientWrapper.m2252a(f2134f);
        }
    }

    public synchronized HashMap<String, Object> m2297c() {
        return m2287a(m2292g(), true);
    }

    public synchronized HashMap<String, String> m2298d() {
        HashMap<String, String> hashMap;
        hashMap = new HashMap();
        Location g = m2292g();
        HashMap a;
        if (g != null) {
            a = m2287a(g, true);
        } else {
            a = m2287a(PublisherProvidedUserInfo.m1816d(), false);
        }
        for (Entry entry : r0.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    public void m2295a(boolean z) {
        f2132d = z;
    }

    private boolean m2291f() {
        Context b = SdkContext.m1562b();
        if (f2133e == null) {
            return false;
        }
        boolean z;
        boolean isProviderEnabled;
        if (b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            isProviderEnabled = f2133e.isProviderEnabled("gps");
            z = false;
        } else if (b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z = f2133e.isProviderEnabled("network");
            isProviderEnabled = false;
        } else {
            isProviderEnabled = false;
            z = false;
        }
        if (z || r1) {
            return true;
        }
        return false;
    }

    private Location m2292g() {
        boolean z = true;
        Context b = SdkContext.m1562b();
        Location location = null;
        if (f2132d && m2291f()) {
            if (f2135g) {
                Location h = m2293h();
                Logger.m1744a(InternalLogLevel.INTERNAL, f2129a, "Location info provided by Google Api client:" + (h != null));
                location = h;
            }
            if (location == null && f2133e != null) {
                Criteria criteria = new Criteria();
                if (b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                    criteria.setAccuracy(1);
                } else if (b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    criteria.setAccuracy(2);
                }
                criteria.setCostAllowed(false);
                String bestProvider = f2133e.getBestProvider(criteria, true);
                if (bestProvider != null) {
                    location = f2133e.getLastKnownLocation(bestProvider);
                    if (location == null) {
                        location = m2294i();
                    }
                }
                InternalLogLevel internalLogLevel = InternalLogLevel.INTERNAL;
                String str = f2129a;
                StringBuilder append = new StringBuilder().append("Location info provided by Location manager:");
                if (location == null) {
                    z = false;
                }
                Logger.m1744a(internalLogLevel, str, append.append(z).toString());
            }
        }
        if (location == null) {
            TelemetryComponent.m5070a().m5090a(new TelemetryEvent("signals", "LocationFixFailed"));
        }
        return location;
    }

    private Location m2293h() {
        try {
            Field declaredField = Class.forName("com.google.android.gms.location.LocationServices").getDeclaredField("FusedLocationApi");
            Class cls = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
            return (Location) Class.forName("com.google.android.gms.location.FusedLocationProviderApi").getMethod("getLastLocation", new Class[]{cls}).invoke(declaredField.get(null), new Object[]{f2134f});
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2129a, "Unable to request activity updates from ActivityRecognition client", e);
            return null;
        } catch (Throwable e2) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2129a, "Unable to request activity updates from ActivityRecognition client", e2);
            return null;
        } catch (Throwable e22) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2129a, "Unable to request activity updates from ActivityRecognition client", e22);
            return null;
        } catch (Throwable e222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2129a, "Unable to request activity updates from ActivityRecognition client", e222);
            return null;
        } catch (Throwable e2222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2129a, "Unable to request activity updates from ActivityRecognition client", e2222);
            return null;
        }
    }

    private Location m2294i() {
        if (f2133e == null) {
            return null;
        }
        List providers = f2133e.getProviders(true);
        int size = providers.size() - 1;
        Location location = null;
        while (size >= 0) {
            Location lastKnownLocation;
            String str = (String) providers.get(size);
            if (f2133e.isProviderEnabled(str)) {
                lastKnownLocation = f2133e.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    return lastKnownLocation;
                }
            } else {
                lastKnownLocation = location;
            }
            size--;
            location = lastKnownLocation;
        }
        return location;
    }

    private HashMap<String, Object> m2287a(Location location, boolean z) {
        int i = 1;
        HashMap<String, Object> hashMap = new HashMap();
        if (location != null) {
            if (location.getTime() > 0) {
                hashMap.put("u-ll-ts", Long.valueOf(location.getTime()));
            }
            hashMap.put("u-latlong-accu", m2286a(location));
            hashMap.put("sdk-collected", Integer.valueOf(z ? 1 : 0));
        }
        if (f2132d) {
            String str = "loc-allowed";
            if (!m2291f()) {
                i = 0;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    private String m2286a(Location location) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(location.getLatitude());
        stringBuilder.append(",");
        stringBuilder.append(location.getLongitude());
        stringBuilder.append(",");
        stringBuilder.append((int) location.getAccuracy());
        return stringBuilder.toString();
    }
}
