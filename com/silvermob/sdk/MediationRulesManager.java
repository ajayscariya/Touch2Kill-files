package com.silvermob.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mf.javax.xml.XMLConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class MediationRulesManager {
    private static final String TAG = "MediationRulesManager";
    private static MediationRulesManager mInstance;
    private ArrayList<MediationRule> mBannerRules;
    private Context mContext;
    private ArrayList<MediationRule> mInterstitialRules;
    private SharedPreferences mSharedPreferences;

    /* renamed from: com.silvermob.sdk.MediationRulesManager.1 */
    class C07871 implements Runnable {
        final /* synthetic */ ArrayList val$bannerRules;
        final /* synthetic */ ArrayList val$interstitialRules;

        C07871(ArrayList arrayList, ArrayList arrayList2) {
            this.val$bannerRules = arrayList;
            this.val$interstitialRules = arrayList2;
        }

        public void run() {
            MediationRulesManager.this.onRulesUpdated(this.val$bannerRules, this.val$interstitialRules);
        }
    }

    /* renamed from: com.silvermob.sdk.MediationRulesManager.2 */
    class C07892 implements Runnable {
        final /* synthetic */ Handler val$handler;

        /* renamed from: com.silvermob.sdk.MediationRulesManager.2.1 */
        class C14541 implements Listener<JSONObject> {

            /* renamed from: com.silvermob.sdk.MediationRulesManager.2.1.1 */
            class C07881 implements Runnable {
                final /* synthetic */ JSONObject val$response;

                C07881(JSONObject jSONObject) {
                    this.val$response = jSONObject;
                }

                public void run() {
                    Editor editor = MediationRulesManager.this.mSharedPreferences.edit();
                    editor.putString("rules_cache", this.val$response.toString());
                    editor.putLong("rules_cache_ts", Long.valueOf(System.currentTimeMillis() / 1000).longValue());
                    editor.apply();
                }
            }

            C14541() {
            }

            public void onResponse(JSONObject response) {
                try {
                    MediationRulesManager.this.updateFromJSONObjects(response.getJSONObject("banner"), response.getJSONObject("interstitial"), response.getJSONObject("prefs"), C07892.this.val$handler);
                    C07892.this.val$handler.post(new C07881(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: com.silvermob.sdk.MediationRulesManager.2.2 */
        class C14552 implements ErrorListener {
            C14552() {
            }

            public void onErrorResponse(VolleyError error) {
            }
        }

        C07892(Handler handler) {
            this.val$handler = handler;
        }

        public void run() {
            String packageName = MediationRulesManager.this.mContext.getPackageName();
            PackageManager pm = MediationRulesManager.this.mContext.getPackageManager();
            String store = XMLConstants.NULL_NS_URI;
            String installerPackageName = pm.getInstallerPackageName(packageName);
            if (installerPackageName != null && installerPackageName.equals(zze.GOOGLE_PLAY_STORE_PACKAGE)) {
                store = "play";
            } else if (installerPackageName != null && installerPackageName.equals("com.amazon.venezia")) {
                store = "amazon";
            }
            Volley.newRequestQueue(MediationRulesManager.this.mContext).add(new JsonObjectRequest(0, "http://silvermob.com/marketplace/api/sdk/checkin?pn=" + packageName + "&store=" + store, new C14541(), new C14552()));
        }
    }

    public enum Format {
        BANNER,
        INTERSTITIAL
    }

    public class MediationRule {
        private String mKey;
        private Map<String, String> mPrefs;
        private Integer mPriority;
        private Integer mWeight;

        public MediationRule(String key, Integer priority, Integer weight, Map<String, String> prefs) {
            this.mKey = key;
            this.mWeight = weight;
            this.mPriority = priority;
            this.mPrefs = prefs;
        }

        public String getKey() {
            return this.mKey;
        }

        public Integer getWeight() {
            return this.mWeight;
        }

        public Integer getPriority() {
            return this.mPriority;
        }

        public Map<String, String> getPrefs() {
            return this.mPrefs;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    private MediationRulesManager(Context context) {
        this.mBannerRules = new ArrayList();
        this.mInterstitialRules = new ArrayList();
        this.mContext = context;
        this.mSharedPreferences = this.mContext.getSharedPreferences("silvermob_sdk", 0);
        String cachedRules = this.mSharedPreferences.getString("rules_cache", XMLConstants.NULL_NS_URI);
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(this.mSharedPreferences.getLong("rules_cache_ts", 0)).longValue() > 21600) {
            Log.d(TAG, "Existing rules are outdated. Updating");
            updateRules();
        }
        if (cachedRules.equals(XMLConstants.NULL_NS_URI)) {
            Log.d(TAG, "The cache is empty.. loading rules");
            updateRules();
            return;
        }
        try {
            Log.d(TAG, "Loading rules from cache");
            JSONObject obj = new JSONObject(cachedRules);
            updateFromJSONObjects(obj.getJSONObject("banner"), obj.getJSONObject("interstitial"), obj.getJSONObject("prefs"), null);
        } catch (JSONException e) {
            Log.d(TAG, "There is something incorrect in cache. Reloading rules");
            Log.e(TAG, e.getMessage());
            updateRules();
        }
    }

    public static MediationRulesManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MediationRulesManager(context);
        }
        return mInstance;
    }

    private void onRulesUpdated(ArrayList<MediationRule> banners, ArrayList<MediationRule> interstitials) {
        this.mBannerRules = banners;
        this.mInterstitialRules = interstitials;
    }

    private void updateFromJSONObjects(JSONObject banners, JSONObject interstitials, JSONObject allPrefsObj, Handler handler) {
        JSONObject prefObj;
        Map<String, String> prefs;
        ArrayList<MediationRule> bannerRules = new ArrayList();
        ArrayList<MediationRule> interstitialRules = new ArrayList();
        Iterator<String> iter = banners.keys();
        while (iter.hasNext()) {
            Iterator<String> iterPref;
            String key = (String) iter.next();
            String sdk = key.split(":")[0];
            try {
                JSONObject banner = banners.getJSONObject(key);
                prefObj = allPrefsObj.getJSONObject(sdk);
                prefs = new HashMap();
                iterPref = prefObj.keys();
                while (iterPref.hasNext()) {
                    String prefName = (String) iterPref.next();
                    prefs.put(prefName, prefObj.getString(prefName));
                }
                bannerRules.add(new MediationRule(key, Integer.valueOf(banner.getInt("priority")), Integer.valueOf(banner.getInt("weight")), prefs));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage());
            }
        }
        iter = interstitials.keys();
        while (iter.hasNext()) {
            key = (String) iter.next();
            sdk = key.split(":")[0];
            try {
                JSONObject interstitial = interstitials.getJSONObject(key);
                prefObj = allPrefsObj.getJSONObject(sdk);
                prefs = new HashMap();
                iterPref = prefObj.keys();
                while (iterPref.hasNext()) {
                    prefName = (String) iterPref.next();
                    prefs.put(prefName, prefObj.getString(prefName));
                }
                interstitialRules.add(new MediationRule(key, Integer.valueOf(interstitial.getInt("priority")), Integer.valueOf(interstitial.getInt("weight")), prefs));
            } catch (Exception ex2) {
                Log.e(TAG, ex2.getMessage());
            }
        }
        if (handler != null) {
            handler.post(new C07871(bannerRules, interstitialRules));
            return;
        }
        onRulesUpdated(bannerRules, interstitialRules);
    }

    private void updateRules() {
        new Thread(new C07892(new Handler())).start();
    }

    public ArrayList<Pair<String, Map<String, String>>> getRequiredSdks() {
        Integer i;
        String sdkName;
        ArrayList<Pair<String, Map<String, String>>> sdks = new ArrayList();
        ArrayList<String> foundSdks = new ArrayList();
        for (i = Integer.valueOf(0); i.intValue() < this.mInterstitialRules.size(); i = Integer.valueOf(i.intValue() + 1)) {
            MediationRule rule = (MediationRule) this.mInterstitialRules.get(i.intValue());
            String[] parts = rule.getKey().split(":");
            if (parts.length == 2) {
                sdkName = parts[0];
                if (foundSdks.indexOf(sdkName) == -1) {
                    sdks.add(new Pair(sdkName, rule.getPrefs()));
                    foundSdks.add(sdkName);
                }
            }
        }
        for (i = Integer.valueOf(0); i.intValue() < this.mBannerRules.size(); i = Integer.valueOf(i.intValue() + 1)) {
            rule = (MediationRule) this.mBannerRules.get(i.intValue());
            parts = rule.getKey().split(":");
            if (parts.length == 2) {
                sdkName = parts[0];
                if (foundSdks.indexOf(sdkName) == -1) {
                    sdks.add(new Pair(sdkName, rule.getPrefs()));
                    foundSdks.add(sdkName);
                }
            }
        }
        return sdks;
    }

    public ArrayList<MediationRule> getMediationRules(Format format) {
        if (format == Format.INTERSTITIAL) {
            return this.mInterstitialRules;
        }
        return this.mBannerRules;
    }
}
