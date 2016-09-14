package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.os.EnvironmentCompat;
import android.view.ViewGroup;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.jirbo.adcolony.ADCData.C0670i;
import com.jirbo.adcolony.ADCData.C1423g;
import com.jirbo.adcolony.C0756n.ad;
import java.util.HashMap;
import mf.javax.xml.XMLConstants;

public class AdColony {
    static boolean f2200b;
    static boolean f2201c;
    boolean f2202a;

    /* renamed from: com.jirbo.adcolony.AdColony.1 */
    static class C06761 implements Runnable {
        C06761() {
        }

        public void run() {
            C0694a.f2342H = false;
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColony.2 */
    static class C06782 implements Runnable {
        final /* synthetic */ Activity f2196a;

        /* renamed from: com.jirbo.adcolony.AdColony.2.1 */
        class C06771 implements Runnable {
            final /* synthetic */ C06782 f2195a;

            C06771(C06782 c06782) {
                this.f2195a = c06782;
            }

            public void run() {
                for (int i = 0; i < C0694a.aq.size(); i++) {
                    AdColonyNativeAdView adColonyNativeAdView = (AdColonyNativeAdView) C0694a.aq.get(i);
                    if (!(adColonyNativeAdView == null || C0694a.m2452b() != adColonyNativeAdView.f2306d || adColonyNativeAdView.f2323u)) {
                        adColonyNativeAdView.f2280A = false;
                        adColonyNativeAdView.invalidate();
                        if (adColonyNativeAdView.f2299T != null) {
                            adColonyNativeAdView.f2299T.f2278a = false;
                            adColonyNativeAdView.f2299T.invalidate();
                        }
                    }
                }
            }
        }

        C06782(Activity activity) {
            this.f2196a = activity;
        }

        public void run() {
            this.f2196a.runOnUiThread(new C06771(this));
        }
    }

    /* renamed from: com.jirbo.adcolony.AdColony.a */
    private static class C0679a extends AsyncTask<Void, Void, Void> {
        Activity f2197a;
        String f2198b;
        boolean f2199c;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2417a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2418a((Void) obj);
        }

        C0679a(Activity activity) {
            this.f2198b = XMLConstants.NULL_NS_URI;
            this.f2197a = activity;
        }

        protected Void m2417a(Void... voidArr) {
            try {
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f2197a);
                this.f2198b = advertisingIdInfo.getId();
                this.f2199c = advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (NoClassDefFoundError e) {
                C0726l.f2613d.m2657b((Object) "Google Play Services SDK not installed! Collecting Android Id instead of Advertising Id.");
            } catch (NoSuchMethodError e2) {
                C0726l.f2613d.m2657b((Object) "Google Play Services SDK is out of date! Collecting Android Id instead of Advertising Id.");
            } catch (Exception e3) {
                if (!Build.MANUFACTURER.equals("Amazon")) {
                    C0726l.f2613d.m2657b((Object) "Advertising Id not available! Collecting Android Id instead of Advertising Id.");
                    e3.printStackTrace();
                }
            }
            return null;
        }

        protected void m2418a(Void voidR) {
            C0721g.f2573a = this.f2198b;
            C0721g.f2574b = this.f2199c;
            AdColony.f2201c = true;
        }
    }

    public AdColony() {
        this.f2202a = false;
    }

    static {
        f2200b = true;
    }

    public static void disable() {
        C0694a.f2385y = true;
    }

    public static void configure(Activity activity, String client_options, String app_id, String... zone_ids) {
        f2201c = false;
        if (f2200b) {
            f2200b = false;
            if (VERSION.SDK_INT >= 11) {
                new C0679a(activity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new C0679a(activity).execute(new Void[0]);
            }
            C0694a.aq.clear();
            Handler handler = new Handler();
            Runnable c06761 = new C06761();
            if (!C0694a.f2342H || C0694a.f2343I) {
                if (!C0694a.f2385y) {
                    if (app_id == null) {
                        C0694a.m2447a("Null App ID - disabling AdColony.");
                        return;
                    } else if (zone_ids == null) {
                        C0694a.m2447a("Null Zone IDs array - disabling AdColony.");
                        return;
                    } else if (zone_ids.length == 0) {
                        C0694a.m2447a("No Zone IDs provided - disabling AdColony.");
                        return;
                    } else {
                        C0694a.m2453b(activity);
                        C0694a.f2372l.m2557a(client_options, app_id, zone_ids);
                        C0694a.f2383w = true;
                        C0694a.f2342H = true;
                        handler.postDelayed(c06761, 120000);
                    }
                } else {
                    return;
                }
            }
            if (C0694a.f2355U == null) {
                C0694a.f2339E = true;
            }
            C0694a.ao.clear();
            C0694a.ap.clear();
            C0694a.ar = new HashMap();
            for (Object put : zone_ids) {
                C0694a.ar.put(put, Boolean.valueOf(false));
            }
            return;
        }
        C0694a.ao.clear();
        C0694a.ap.clear();
    }

    public static void setCustomID(String new_custom_id) {
        if (!new_custom_id.equals(C0694a.f2372l.f2512a.f2508y) && C0694a.f2372l != null && C0694a.f2372l.f2513b != null) {
            C0694a.f2372l.f2512a.f2508y = new_custom_id;
            if (C0694a.f2384x) {
                C0694a.f2372l.f2513b.m5329h();
            }
        }
    }

    public static String getCustomID() {
        return C0694a.f2372l.f2512a.f2508y;
    }

    public static boolean isConfigured() {
        return !f2200b;
    }

    public static void setDeviceID(String new_device_id) {
        if (!new_device_id.equals(C0694a.f2372l.f2512a.f2509z)) {
            C0694a.f2372l.f2512a.f2509z = new_device_id;
            C0694a.f2342H = false;
            C0694a.f2372l.f2513b.f4594d = true;
            C0694a.f2372l.f2513b.f4592b = false;
            C0694a.f2372l.f2513b.f4593c = true;
        }
    }

    public static String getDeviceID() {
        return C0694a.f2372l.f2512a.f2509z;
    }

    public static boolean isTablet() {
        return C0721g.m2610i();
    }

    public static void resume(Activity activity) {
        C0726l.f2612c.m2657b((Object) "[ADC] AdColony resume called.");
        C0694a.f2336B = false;
        C0694a.f2378r = false;
        C0694a.m2442a(activity);
        C0694a.f2335A = false;
        C0694a.m2467h();
        if (activity == null) {
            C0726l.f2613d.m2657b((Object) "Activity reference is null. Disabling AdColony.");
            disable();
            return;
        }
        if (C0694a.f2382v != null) {
            C0694a.f2357W.m2437a(C0694a.f2382v);
            C0694a.f2382v = null;
        }
        new Thread(new C06782(activity)).start();
        C0694a.f2347M = false;
    }

    public static void pause() {
        C0726l.f2612c.m2657b((Object) "[ADC] AdColony pause called.");
        C0694a.f2378r = true;
        C0694a.f2336B = true;
        for (int i = 0; i < C0694a.aq.size(); i++) {
            if (C0694a.aq.get(i) != null) {
                AdColonyNativeAdView adColonyNativeAdView = (AdColonyNativeAdView) C0694a.aq.get(i);
                adColonyNativeAdView.f2280A = true;
                if (!(adColonyNativeAdView.ag == null || adColonyNativeAdView.f2323u || !adColonyNativeAdView.ag.isPlaying())) {
                    if (C0694a.f2339E) {
                        adColonyNativeAdView.f2299T.setVisibility(0);
                    }
                    adColonyNativeAdView.m2435c();
                }
            }
        }
    }

    public static void onBackPressed() {
        int i = 0;
        if (C0694a.f2353S == null) {
            return;
        }
        if ((C0694a.f2353S instanceof ab) || (C0694a.f2353S instanceof ac)) {
            ((ViewGroup) C0694a.f2353S.getParent()).removeView(C0694a.f2353S);
            C0694a.f2339E = true;
            C0694a.f2353S.f2587G.m5313c(false);
            while (i < C0694a.an.size()) {
                ((Bitmap) C0694a.an.get(i)).recycle();
                i++;
            }
            C0694a.an.clear();
            C0694a.f2353S = null;
        }
    }

    public static Activity activity() {
        return C0694a.m2452b();
    }

    public static boolean isZoneV4VC(String zone_id) {
        if (C0694a.f2372l == null || C0694a.f2372l.f2513b == null || C0694a.f2372l.f2513b.f4599i == null || C0694a.f2372l.f2513b.f4599i.f2749n == null) {
            return false;
        }
        return C0694a.f2372l.f2513b.m5319a(zone_id, false);
    }

    public static boolean isZoneNative(String zone_id) {
        if (C0694a.f2372l == null || C0694a.f2372l.f2513b == null || C0694a.f2372l.f2513b.f4599i == null || C0694a.f2372l.f2513b.f4599i.f2749n == null || C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id) == null || C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id).f2687m == null || C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id).f2687m.f2735a == null) {
            return false;
        }
        for (int i = 0; i < C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id).f2687m.f2735a.size(); i++) {
            if (C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id).f2687m.m2725a(i).f2626A.f2829a) {
                return true;
            }
        }
        return false;
    }

    public static void addV4VCListener(AdColonyV4VCListener listener) {
        if (!C0694a.ao.contains(listener)) {
            C0694a.ao.add(listener);
        }
    }

    public static void removeV4VCListener(AdColonyV4VCListener listener) {
        C0694a.ao.remove(listener);
    }

    public static void addAdAvailabilityListener(AdColonyAdAvailabilityListener listener) {
        if (!C0694a.ap.contains(listener)) {
            C0694a.ap.add(listener);
        }
    }

    public static void removeAdAvailabilityListener(AdColonyAdAvailabilityListener listener) {
        C0694a.ap.remove(listener);
    }

    public static void notifyIAPComplete(String product_id, String trans_id) {
        notifyIAPComplete(product_id, trans_id, null, 0.0d);
    }

    public static void notifyIAPComplete(String product_id, String trans_id, String currency_code, double price) {
        C0726l.f2612c.m2657b((Object) "notifyIAPComplete() called.");
        C0670i c1423g = new C1423g();
        c1423g.m5277b("product_id", product_id);
        if (price != 0.0d) {
            c1423g.m5275b("price", price);
        }
        c1423g.m5277b("trans_id", trans_id);
        c1423g.m5276b("quantity", 1);
        if (currency_code != null) {
            c1423g.m5277b("price_currency_code", currency_code);
        }
        if (C0694a.f2349O) {
            C0694a.f2372l.f2515d.m5352a("in_app_purchase", (C1423g) c1423g);
        } else {
            C0694a.aj.m5234a(c1423g);
        }
    }

    public static void cancelVideo() {
        if (C0694a.f2355U != null) {
            C0694a.f2355U.finish();
            C0694a.ak = true;
            C0694a.f2357W.m2438b(null);
        }
    }

    public static String statusForZone(String zone_id) {
        if (C0694a.f2372l == null || C0694a.f2372l.f2513b == null || C0694a.f2372l.f2513b.f4599i == null || C0694a.f2372l.f2513b.f4599i.f2749n == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (C0694a.f2385y) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        ad a = C0694a.f2372l.f2513b.f4599i.f2749n.m2716a(zone_id);
        if (a != null) {
            if (!a.f2681g) {
                return "off";
            }
            if (a.f2682h && C0694a.f2372l.f2513b.m5324c(zone_id, true)) {
                return "active";
            }
            return "loading";
        } else if (C0694a.f2384x) {
            return "invalid";
        } else {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static void get_images(String zone_id) {
        C0694a.f2372l.f2512a.m2544b(zone_id);
    }

    public static void disableDECOverride() {
        C0694a.f2365e = null;
    }

    public static void forceMobileCache() {
        if (!C0694a.f2348N) {
            C0694a.f2348N = true;
            C0694a.f2342H = false;
            C0694a.f2372l.f2513b.f4594d = true;
            C0694a.f2372l.f2513b.f4592b = false;
            C0694a.f2372l.f2513b.f4593c = true;
        }
    }
}
