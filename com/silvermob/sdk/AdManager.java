package com.silvermob.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.silvermob.sdk.MediationRulesManager.Format;
import com.silvermob.sdk.MediationRulesManager.MediationRule;
import com.silvermob.sdk.connectors.Connector;
import com.silvermob.sdk.connectors.Connector.Listener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AdManager {
    private static final String TAG = "AdManager";
    private static AdManager instance;
    private static Map<Context, AdManager> mInstances;
    private final Handler handler;
    private BannerListener mBannerListener;
    private Connector mCurrentInterstitialLoaded;
    private String mCurrentInterstitialPlacementId;
    private InterstitialListener mInterstitialListener;
    private MediationRulesManager mManager;
    private Map<String, Connector> sdkConnectors;

    /* renamed from: com.silvermob.sdk.AdManager.1 */
    class C07711 implements Comparator<MediationRule> {
        C07711() {
        }

        public int compare(MediationRule lhs, MediationRule rhs) {
            if (lhs.getPriority().intValue() > rhs.getPriority().intValue()) {
                return -1;
            }
            if (lhs.getPriority().intValue() < rhs.getPriority().intValue()) {
                return 1;
            }
            if (Math.random() <= ((double) Float.valueOf(Float.valueOf((float) lhs.getWeight().intValue()).floatValue() / ((float) (lhs.getWeight().intValue() + rhs.getWeight().intValue()))).floatValue())) {
                return 1;
            }
            return -1;
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.6 */
    class C07786 implements Runnable {
        final /* synthetic */ Integer val$height;
        final /* synthetic */ String val$placementId;
        final /* synthetic */ Integer val$width;

        /* renamed from: com.silvermob.sdk.AdManager.6.2 */
        class C07772 implements Runnable {
            C07772() {
            }

            public void run() {
                AdManager.this.mBannerListener.onNoFill();
            }
        }

        /* renamed from: com.silvermob.sdk.AdManager.6.1 */
        class C14481 implements ConnectorQueueManagerListener {
            final /* synthetic */ Boolean[] val$processed;

            /* renamed from: com.silvermob.sdk.AdManager.6.1.1 */
            class C07721 implements Runnable {
                C07721() {
                }

                public void run() {
                    AdManager.this.mBannerListener.onError();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.6.1.2 */
            class C07732 implements Runnable {
                C07732() {
                }

                public void run() {
                    AdManager.this.mBannerListener.onNoFill();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.6.1.3 */
            class C07743 implements Runnable {
                final /* synthetic */ View val$adView;

                C07743(View view) {
                    this.val$adView = view;
                }

                public void run() {
                    AdManager.this.mBannerListener.onAdLoaded(this.val$adView);
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.6.1.4 */
            class C07754 implements Runnable {
                C07754() {
                }

                public void run() {
                    AdManager.this.mBannerListener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.6.1.5 */
            class C07765 implements Runnable {
                C07765() {
                }

                public void run() {
                    AdManager.this.mBannerListener.onAdClicked();
                }
            }

            C14481(Boolean[] boolArr) {
                this.val$processed = boolArr;
            }

            public void onShown(String network) {
                AdManager.this.handler.post(new C07721());
            }

            public void onNoFill() {
                if (!this.val$processed[0].booleanValue()) {
                    this.val$processed[0] = Boolean.valueOf(true);
                    AdManager.this.handler.post(new C07732());
                }
            }

            public void onAdLoaded(View adView, Connector connector) {
                if (!this.val$processed[0].booleanValue()) {
                    this.val$processed[0] = Boolean.valueOf(true);
                    AdManager.this.trackView(C07786.this.val$placementId, connector.getName());
                    AdManager.this.handler.post(new C07743(adView));
                }
            }

            public void onAdClosed() {
                AdManager.this.handler.post(new C07754());
            }

            public void onAdClicked() {
                AdManager.this.handler.post(new C07765());
            }
        }

        C07786(String str, Integer num, Integer num2) {
            this.val$placementId = str;
            this.val$width = num;
            this.val$height = num2;
        }

        public void run() {
            Looper.prepare();
            Log.d(AdManager.TAG, "Requesting banner ad");
            Queue<Pair<Connector, String>> connectorsOrdered = AdManager.this.getConnectorsOrder(Format.BANNER);
            Map<String, String> requestParams = AdManager.this.getRequestParams(this.val$placementId, this.val$width, this.val$height);
            Boolean[] processed = new Boolean[]{Boolean.valueOf(false)};
            if (connectorsOrdered.size() > 0) {
                ConnectorQueueManager connectorQueueManager = new ConnectorQueueManager(connectorsOrdered, requestParams, new C14481(processed));
            } else {
                AdManager.this.handler.post(new C07772());
            }
            Looper.loop();
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.7 */
    class C07857 implements Runnable {
        final /* synthetic */ String val$placementId;

        /* renamed from: com.silvermob.sdk.AdManager.7.2 */
        class C07842 implements Runnable {
            C07842() {
            }

            public void run() {
                AdManager.this.mInterstitialListener.onNoFill();
            }
        }

        /* renamed from: com.silvermob.sdk.AdManager.7.1 */
        class C14491 implements ConnectorQueueManagerListener {
            final /* synthetic */ Boolean[] val$processed;

            /* renamed from: com.silvermob.sdk.AdManager.7.1.1 */
            class C07791 implements Runnable {
                C07791() {
                }

                public void run() {
                    AdManager.this.mInterstitialListener.onShown();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.7.1.2 */
            class C07802 implements Runnable {
                C07802() {
                }

                public void run() {
                    AdManager.this.mInterstitialListener.onNoFill();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.7.1.3 */
            class C07813 implements Runnable {
                C07813() {
                }

                public void run() {
                    AdManager.this.mInterstitialListener.onAdLoaded(null);
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.7.1.4 */
            class C07824 implements Runnable {
                C07824() {
                }

                public void run() {
                    AdManager.this.mInterstitialListener.onAdClosed();
                }
            }

            /* renamed from: com.silvermob.sdk.AdManager.7.1.5 */
            class C07835 implements Runnable {
                C07835() {
                }

                public void run() {
                    AdManager.this.mInterstitialListener.onAdClicked();
                }
            }

            C14491(Boolean[] boolArr) {
                this.val$processed = boolArr;
            }

            public void onShown(String network) {
                if (!this.val$processed[0].booleanValue()) {
                    this.val$processed[0] = Boolean.valueOf(true);
                    AdManager.this.trackView(C07857.this.val$placementId, network);
                    AdManager.this.handler.post(new C07791());
                }
            }

            public void onNoFill() {
                if (!this.val$processed[0].booleanValue()) {
                    this.val$processed[0] = Boolean.valueOf(true);
                    AdManager.this.handler.post(new C07802());
                }
            }

            public void onAdLoaded(View adView, Connector connector) {
                if (!this.val$processed[0].booleanValue()) {
                    this.val$processed[0] = Boolean.valueOf(true);
                    AdManager.this.trackServed(C07857.this.val$placementId, connector.getName());
                    AdManager.this.mCurrentInterstitialLoaded = connector;
                    AdManager.this.mCurrentInterstitialPlacementId = C07857.this.val$placementId;
                    AdManager.this.handler.post(new C07813());
                }
            }

            public void onAdClosed() {
                AdManager.this.handler.post(new C07824());
            }

            public void onAdClicked() {
                AdManager.this.handler.post(new C07835());
            }
        }

        C07857(String str) {
            this.val$placementId = str;
        }

        public void run() {
            Log.d(AdManager.TAG, "Requesting interstitial ad");
            Looper.prepare();
            Queue<Pair<Connector, String>> connectorsOrdered = AdManager.this.getConnectorsOrder(Format.INTERSTITIAL);
            Map<String, String> requestParams = AdManager.this.getRequestParams(this.val$placementId, Integer.valueOf(0), Integer.valueOf(0));
            Boolean[] processed = new Boolean[]{Boolean.valueOf(false)};
            if (connectorsOrdered.size() > 0) {
                ConnectorQueueManager connectorQueueManager = new ConnectorQueueManager(connectorsOrdered, requestParams, new C14491(processed));
            } else {
                AdManager.this.handler.post(new C07842());
            }
            Looper.loop();
        }
    }

    public interface BannerListener {
        void onAdClicked();

        void onAdClosed();

        void onAdLoaded(View view);

        void onError();

        void onNoFill();
    }

    private class ConnectorQueueManager {
        private ConnectorQueueManagerListener mListener;
        private Map<String, String> mParams;
        private Queue<Pair<Connector, String>> mQueue;

        /* renamed from: com.silvermob.sdk.AdManager.ConnectorQueueManager.1 */
        class C07861 implements Runnable {
            final /* synthetic */ Connector val$conn;
            final /* synthetic */ String val$feature;
            final /* synthetic */ Boolean[] val$loaded;
            final /* synthetic */ Boolean[] val$timedout;

            C07861(Boolean[] boolArr, Boolean[] boolArr2, Connector connector, String str) {
                this.val$loaded = boolArr;
                this.val$timedout = boolArr2;
                this.val$conn = connector;
                this.val$feature = str;
            }

            public void run() {
                if (!this.val$loaded[0].booleanValue()) {
                    this.val$timedout[0] = Boolean.valueOf(true);
                    AdManager.this.trackTimeout(this.val$conn.toString());
                    Log.d(AdManager.TAG, "Timeout '" + this.val$feature + "' ad from " + this.val$conn.toString());
                    ConnectorQueueManager.this.requestNextConnector();
                }
            }
        }

        /* renamed from: com.silvermob.sdk.AdManager.ConnectorQueueManager.2 */
        class C14522 implements Listener {
            final /* synthetic */ Connector val$conn;
            final /* synthetic */ String val$feature;
            final /* synthetic */ Boolean[] val$loaded;
            final /* synthetic */ Boolean[] val$timedout;

            C14522(Boolean[] boolArr, Boolean[] boolArr2, String str, Connector connector) {
                this.val$timedout = boolArr;
                this.val$loaded = boolArr2;
                this.val$feature = str;
                this.val$conn = connector;
            }

            public void onAdLoaded(View adView) {
                if (!this.val$timedout[0].booleanValue()) {
                    this.val$loaded[0] = Boolean.valueOf(true);
                    Log.d(AdManager.TAG, "Got '" + this.val$feature + "' ad from " + this.val$conn.toString());
                    ConnectorQueueManager.this.mListener.onAdLoaded(adView, this.val$conn);
                }
            }

            public void onAdClicked(View adView) {
                ConnectorQueueManager.this.mListener.onAdClicked();
            }

            public void onAdClosed() {
                ConnectorQueueManager.this.mListener.onAdClosed();
            }

            public void onError() {
                if (!this.val$timedout[0].booleanValue()) {
                    this.val$loaded[0] = Boolean.valueOf(true);
                    Log.d(AdManager.TAG, "Got no fill '" + this.val$feature + "' ad from " + this.val$conn.toString());
                    ConnectorQueueManager.this.requestNextConnector();
                }
            }

            public void onAdShown() {
                Log.d(AdManager.TAG, "Shown '" + this.val$feature + "' ad from " + this.val$conn.toString());
                ConnectorQueueManager.this.mListener.onShown(this.val$conn.getName());
            }
        }

        public ConnectorQueueManager(Queue<Pair<Connector, String>> queue, Map<String, String> params, ConnectorQueueManagerListener listener) {
            this.mQueue = queue;
            this.mListener = listener;
            this.mParams = params;
            requestNextConnector();
        }

        private void requestNextConnector() {
            Pair<Connector, String> p = (Pair) this.mQueue.poll();
            if (p != null) {
                Connector conn = p.first;
                String feature = p.second;
                this.mParams.put("format", feature);
                if (conn != null) {
                    Log.d(AdManager.TAG, "Requesting '" + feature + "' ad from " + conn.toString());
                    Boolean[] loaded = new Boolean[]{Boolean.valueOf(false)};
                    Boolean[] timedout = new Boolean[]{Boolean.valueOf(false)};
                    Handler h = new Handler();
                    Runnable timeoutRequest = new C07861(loaded, timedout, conn, feature);
                    conn.loadAd(this.mParams, new C14522(timedout, loaded, feature, conn));
                    h.postDelayed(timeoutRequest, 20000);
                    return;
                }
                this.mListener.onNoFill();
                return;
            }
            this.mListener.onNoFill();
        }
    }

    private interface ConnectorQueueManagerListener {
        void onAdClicked();

        void onAdClosed();

        void onAdLoaded(View view, Connector connector);

        void onNoFill();

        void onShown(String str);
    }

    public interface InterstitialListener {
        void onAdClicked();

        void onAdClosed();

        void onAdLoaded(View view);

        void onError();

        void onNoFill();

        void onShown();
    }

    /* renamed from: com.silvermob.sdk.AdManager.2 */
    class C14442 implements Response.Listener<String> {
        C14442() {
        }

        public void onResponse(String response) {
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.3 */
    class C14453 implements ErrorListener {
        C14453() {
        }

        public void onErrorResponse(VolleyError error) {
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.4 */
    class C14464 implements Response.Listener<String> {
        C14464() {
        }

        public void onResponse(String response) {
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.5 */
    class C14475 implements ErrorListener {
        C14475() {
        }

        public void onErrorResponse(VolleyError error) {
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.8 */
    class C14508 implements Response.Listener<String> {
        C14508() {
        }

        public void onResponse(String response) {
        }
    }

    /* renamed from: com.silvermob.sdk.AdManager.9 */
    class C14519 implements ErrorListener {
        C14519() {
        }

        public void onErrorResponse(VolleyError error) {
        }
    }

    static {
        instance = null;
        mInstances = new HashMap();
    }

    public static AdManager getInstance(Context context) {
        AdManager am = (AdManager) mInstances.get(context);
        if (am != null) {
            return am;
        }
        am = new AdManager(context);
        mInstances.put(context, am);
        return am;
    }

    public void setInterstitialListener(InterstitialListener listener) {
        this.mInterstitialListener = listener;
    }

    public void setBannerListener(BannerListener listener) {
        this.mBannerListener = listener;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected AdManager(android.content.Context r13) {
        /*
        r12 = this;
        r9 = 0;
        r12.<init>();
        r8 = new java.util.HashMap;
        r8.<init>();
        r12.sdkConnectors = r8;
        r8 = com.silvermob.sdk.MediationRulesManager.getInstance(r13);
        r12.mManager = r8;
        r8 = new android.os.Handler;
        r8.<init>();
        r12.handler = r8;
        r8 = r12.mManager;
        r6 = r8.getRequiredSdks();
        r3 = java.lang.Integer.valueOf(r9);
    L_0x0022:
        r8 = r3.intValue();
        r10 = r6.size();
        if (r8 >= r10) goto L_0x00e9;
    L_0x002c:
        r8 = r3.intValue();
        r5 = r6.get(r8);
        r5 = (android.util.Pair) r5;
        r8 = r5.first;
        r8 = (java.lang.String) r8;
        r10 = -1;
        r11 = r8.hashCode();
        switch(r11) {
            case -1249910051: goto L_0x0051;
            case -1183962098: goto L_0x006f;
            case 1179703863: goto L_0x005b;
            case 1316799103: goto L_0x0079;
            case 1788315269: goto L_0x0065;
            default: goto L_0x0042;
        };
    L_0x0042:
        r8 = r10;
    L_0x0043:
        switch(r8) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0097;
            case 2: goto L_0x00ab;
            case 3: goto L_0x00bf;
            case 4: goto L_0x00d4;
            default: goto L_0x0046;
        };
    L_0x0046:
        r8 = r3.intValue();
        r8 = r8 + 1;
        r3 = java.lang.Integer.valueOf(r8);
        goto L_0x0022;
    L_0x0051:
        r11 = "adcolony";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x0042;
    L_0x0059:
        r8 = r9;
        goto L_0x0043;
    L_0x005b:
        r11 = "applovin";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x0042;
    L_0x0063:
        r8 = 1;
        goto L_0x0043;
    L_0x0065:
        r11 = "chartboost";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x0042;
    L_0x006d:
        r8 = 2;
        goto L_0x0043;
    L_0x006f:
        r11 = "inmobi";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x0042;
    L_0x0077:
        r8 = 3;
        goto L_0x0043;
    L_0x0079:
        r11 = "startapp";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x0042;
    L_0x0081:
        r8 = 4;
        goto L_0x0043;
    L_0x0083:
        r0 = new com.silvermob.sdk.connectors.AdcolonyConnector;
        r0.<init>();
        r8 = r5.second;
        r8 = (java.util.Map) r8;
        r0.init(r13, r8);
        r8 = r12.sdkConnectors;
        r10 = "adcolony";
        r8.put(r10, r0);
        goto L_0x0046;
    L_0x0097:
        r1 = new com.silvermob.sdk.connectors.ApplovinConnector;
        r1.<init>();
        r8 = r5.second;
        r8 = (java.util.Map) r8;
        r1.init(r13, r8);
        r8 = r12.sdkConnectors;
        r10 = "applovin";
        r8.put(r10, r1);
        goto L_0x0046;
    L_0x00ab:
        r2 = new com.silvermob.sdk.connectors.CharboostConnector;
        r2.<init>();
        r8 = r5.second;
        r8 = (java.util.Map) r8;
        r2.init(r13, r8);
        r8 = r12.sdkConnectors;
        r10 = "chartboost";
        r8.put(r10, r2);
        goto L_0x0046;
    L_0x00bf:
        r4 = new com.silvermob.sdk.connectors.InmobiConnector;
        r4.<init>();
        r8 = r5.second;
        r8 = (java.util.Map) r8;
        r4.init(r13, r8);
        r8 = r12.sdkConnectors;
        r10 = "inmobi";
        r8.put(r10, r4);
        goto L_0x0046;
    L_0x00d4:
        r7 = new com.silvermob.sdk.connectors.StartappConnector;
        r7.<init>();
        r8 = r5.second;
        r8 = (java.util.Map) r8;
        r7.init(r13, r8);
        r8 = r12.sdkConnectors;
        r10 = "startapp";
        r8.put(r10, r7);
        goto L_0x0046;
    L_0x00e9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.silvermob.sdk.AdManager.<init>(android.content.Context):void");
    }

    private Map<String, String> getRequestParams(String placementId, Integer width, Integer height) {
        Map<String, String> params = new HashMap();
        params.put("width", width.toString());
        params.put("height", height.toString());
        params.put("placementId", placementId);
        return params;
    }

    private Queue<Pair<Connector, String>> getConnectorsOrder(Format format) {
        Queue<Pair<Connector, String>> connectors = new LinkedList();
        ArrayList<MediationRule> rules = this.mManager.getMediationRules(format);
        Collections.sort(rules, new C07711());
        for (Integer i = Integer.valueOf(0); i.intValue() < rules.size(); i = Integer.valueOf(i.intValue() + 1)) {
            String sdk = ((MediationRule) rules.get(i.intValue())).getKey().split(":")[0];
            String feature = ((MediationRule) rules.get(i.intValue())).getKey().split(":")[1];
            Connector conn = (Connector) this.sdkConnectors.get(sdk);
            if (conn != null) {
                connectors.add(new Pair(conn, feature));
            }
        }
        return connectors;
    }

    private void trackRequest(String placementId) {
        Volley.newRequestQueue(this.mManager.getContext()).add(new StringRequest(0, "http://silvermob.com/marketplace/api/sdk/track/request?pid=" + placementId, new C14442(), new C14453()));
    }

    private void trackView(String placementId, String network) {
        Volley.newRequestQueue(this.mManager.getContext()).add(new StringRequest(0, "http://silvermob.com/marketplace/api/sdk/track/view/" + network + "?pid=" + placementId, new C14464(), new C14475()));
    }

    public void requestBanner(String placementId, Integer width, Integer height) {
        trackRequest(placementId);
        new Thread(new C07786(placementId, width, height)).start();
    }

    public void requestInterstitial(String placementId) {
        trackRequest(placementId);
        new Thread(new C07857(placementId)).start();
    }

    private void trackServed(String placementId, String network) {
        Volley.newRequestQueue(this.mManager.getContext()).add(new StringRequest(0, "http://silvermob.com/marketplace/api/sdk/track/served/" + network + "?pid=" + placementId, new C14508(), new C14519()));
    }

    private void trackTimeout(String network) {
        Volley.newRequestQueue(this.mManager.getContext()).add(new StringRequest(0, "http://silvermob.com/marketplace/api/sdk/track/timeout/" + network, new Response.Listener<String>() {
            public void onResponse(String response) {
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }));
    }

    public void showInterstitial() {
        new Thread(new Runnable() {

            /* renamed from: com.silvermob.sdk.AdManager.12.1 */
            class C14431 implements Listener {

                /* renamed from: com.silvermob.sdk.AdManager.12.1.1 */
                class C07671 implements Runnable {
                    C07671() {
                    }

                    public void run() {
                        AdManager.this.mInterstitialListener.onAdClicked();
                    }
                }

                /* renamed from: com.silvermob.sdk.AdManager.12.1.2 */
                class C07682 implements Runnable {
                    C07682() {
                    }

                    public void run() {
                        AdManager.this.mInterstitialListener.onAdClosed();
                    }
                }

                /* renamed from: com.silvermob.sdk.AdManager.12.1.3 */
                class C07693 implements Runnable {
                    C07693() {
                    }

                    public void run() {
                        AdManager.this.mInterstitialListener.onError();
                    }
                }

                /* renamed from: com.silvermob.sdk.AdManager.12.1.4 */
                class C07704 implements Runnable {
                    C07704() {
                    }

                    public void run() {
                        AdManager.this.mInterstitialListener.onShown();
                    }
                }

                C14431() {
                }

                public void onAdLoaded(View adView) {
                }

                public void onAdClicked(View adView) {
                    AdManager.this.handler.post(new C07671());
                }

                public void onAdClosed() {
                    AdManager.this.handler.post(new C07682());
                }

                public void onError() {
                    AdManager.this.handler.post(new C07693());
                }

                public void onAdShown() {
                    AdManager.this.trackView(AdManager.this.mCurrentInterstitialPlacementId, AdManager.this.mCurrentInterstitialLoaded.getName());
                    Log.d(AdManager.TAG, "posting onAdShown to main thread");
                    AdManager.this.handler.post(new C07704());
                    AdManager.this.mCurrentInterstitialLoaded = null;
                    AdManager.this.mCurrentInterstitialPlacementId = null;
                }
            }

            public void run() {
                Log.d(AdManager.TAG, "Showing interstitial ad");
                Looper.prepare();
                if (AdManager.this.mCurrentInterstitialLoaded != null) {
                    AdManager.this.mCurrentInterstitialLoaded.showInterstitialAd(new C14431());
                } else {
                    AdManager.this.mInterstitialListener.onError();
                }
                Looper.loop();
            }
        }).start();
    }
}
