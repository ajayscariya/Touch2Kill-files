package com.chartboost.sdk.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.bu.C0405b;
import com.google.android.gcm.GCMConstants;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;
import org.json.JSONException;
import org.json.JSONObject;

public class bs extends WebChromeClient {
    private static final String f1047a;
    private View f1048b;
    private ViewGroup f1049c;
    private View f1050d;
    private bt f1051e;
    private boolean f1052f;
    private FrameLayout f1053g;
    private CustomViewCallback f1054h;
    private C0401a f1055i;
    private bu f1056j;
    private Handler f1057k;

    /* renamed from: com.chartboost.sdk.impl.bs.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ JSONObject f1029a;
        final /* synthetic */ bs f1030b;

        AnonymousClass10(bs bsVar, JSONObject jSONObject) {
            this.f1030b = bsVar;
            this.f1029a = jSONObject;
        }

        public void run() {
            try {
                this.f1030b.f1056j.m4678a(((float) this.f1029a.getDouble(SchemaSymbols.ATTVAL_DURATION)) * 1000.0f);
            } catch (Exception e) {
                this.f1030b.f1056j.m4685c("Parsing exception unknown field for current player duration");
                CBLogging.m381b(bs.f1047a, "Cannot find duration parameter for the video");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ JSONObject f1031a;
        final /* synthetic */ bs f1032b;

        AnonymousClass11(bs bsVar, JSONObject jSONObject) {
            this.f1032b = bsVar;
            this.f1031a = jSONObject;
        }

        public void run() {
            try {
                this.f1032b.f1056j.m4683b(((float) this.f1031a.getDouble(SchemaSymbols.ATTVAL_DURATION)) * 1000.0f);
            } catch (Exception e) {
                this.f1032b.f1056j.m4685c("Parsing exception unknown field for total player duration");
                CBLogging.m381b(bs.f1047a, "Cannot find duration parameter for the video");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.1 */
    class C03921 implements Runnable {
        final /* synthetic */ bs f1033a;

        C03921(bs bsVar) {
            this.f1033a = bsVar;
        }

        public void run() {
            if (this.f1033a != null) {
                this.f1033a.onHideCustomView();
            }
            this.f1033a.f1056j.m4679a(C0405b.IDLE);
            this.f1033a.f1056j.m4694o();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.2 */
    class C03932 implements Runnable {
        final /* synthetic */ bs f1034a;

        C03932(bs bsVar) {
            this.f1034a = bsVar;
        }

        public void run() {
            this.f1034a.f1056j.m777a(null, null);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.3 */
    class C03943 implements Runnable {
        final /* synthetic */ bs f1035a;

        C03943(bs bsVar) {
            this.f1035a = bsVar;
        }

        public void run() {
            this.f1035a.f1056j.m4688h();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.4 */
    class C03954 implements Runnable {
        final /* synthetic */ JSONObject f1036a;
        final /* synthetic */ bs f1037b;

        C03954(bs bsVar, JSONObject jSONObject) {
            this.f1037b = bsVar;
            this.f1036a = jSONObject;
        }

        public void run() {
            try {
                this.f1037b.f1056j.m4684b(this.f1036a.getString("message"));
            } catch (Exception e) {
                CBLogging.m381b(bs.f1047a, "Error message is empty");
                this.f1037b.f1056j.m4684b(XMLConstants.NULL_NS_URI);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.5 */
    class C03965 implements Runnable {
        final /* synthetic */ JSONObject f1038a;
        final /* synthetic */ bs f1039b;

        C03965(bs bsVar, JSONObject jSONObject) {
            this.f1039b = bsVar;
            this.f1038a = jSONObject;
        }

        public void run() {
            try {
                this.f1039b.f1056j.m4685c(this.f1038a.getString("message"));
            } catch (Exception e) {
                CBLogging.m381b(bs.f1047a, "Warning message is empty");
                this.f1039b.f1056j.m4685c(XMLConstants.NULL_NS_URI);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.6 */
    class C03976 implements Runnable {
        final /* synthetic */ bs f1040a;

        C03976(bs bsVar) {
            this.f1040a = bsVar;
        }

        public void run() {
            this.f1040a.f1056j.m4697r();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.7 */
    class C03987 implements Runnable {
        final /* synthetic */ JSONObject f1041a;
        final /* synthetic */ bs f1042b;

        C03987(bs bsVar, JSONObject jSONObject) {
            this.f1042b = bsVar;
            this.f1041a = jSONObject;
        }

        public void run() {
            try {
                Object string = this.f1041a.getString("name");
                if (!TextUtils.isEmpty(string)) {
                    this.f1042b.f1056j.f4209k = string;
                }
                this.f1042b.f1056j.m4695p();
            } catch (Exception e) {
                CBLogging.m381b(bs.f1047a, "Cannot find video file name");
                this.f1042b.f1056j.m4685c("Parsing exception unknown field for video replay");
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.8 */
    class C03998 implements Runnable {
        final /* synthetic */ JSONObject f1043a;
        final /* synthetic */ bs f1044b;

        C03998(bs bsVar, JSONObject jSONObject) {
            this.f1044b = bsVar;
            this.f1043a = jSONObject;
        }

        public void run() {
            try {
                Object string = this.f1043a.getString("name");
                if (!TextUtils.isEmpty(string)) {
                    this.f1044b.f1056j.f4209k = string;
                }
            } catch (Exception e) {
                CBLogging.m381b(bs.f1047a, "Cannot find video file name");
                this.f1044b.f1056j.m4685c("Parsing exception unknown field for video pause");
            }
            this.f1044b.f1056j.m4679a(C0405b.PAUSED);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.9 */
    class C04009 implements Runnable {
        final /* synthetic */ JSONObject f1045a;
        final /* synthetic */ bs f1046b;

        C04009(bs bsVar, JSONObject jSONObject) {
            this.f1046b = bsVar;
            this.f1045a = jSONObject;
        }

        public void run() {
            try {
                Object string = this.f1045a.getString("name");
                if (!TextUtils.isEmpty(string)) {
                    this.f1046b.f1056j.f4209k = string;
                }
            } catch (Exception e) {
                CBLogging.m381b(bs.f1047a, "Cannot find video file name");
                this.f1046b.f1056j.m4685c("Parsing exception unknown field for video play");
            }
            this.f1046b.f1056j.m4679a(C0405b.PLAYING);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bs.a */
    public interface C0401a {
        void m1047a(boolean z);
    }

    static {
        f1047a = bs.class.getSimpleName();
    }

    public bs() {
        this.f1057k = CBUtility.m400e();
    }

    public bs(View view, ViewGroup viewGroup, View view2, bt btVar, bu buVar) {
        this.f1057k = CBUtility.m400e();
        this.f1048b = view;
        this.f1049c = viewGroup;
        this.f1050d = view2;
        this.f1051e = btVar;
        this.f1052f = false;
        this.f1056j = buVar;
    }

    public boolean onConsoleMessage(ConsoleMessage cm) {
        Log.d(bs.class.getSimpleName(), "Chartboost Webview:" + cm.message() + " -- From line " + cm.lineNumber() + " of " + cm.sourceId());
        return true;
    }

    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        try {
            JSONObject jSONObject = new JSONObject(message);
            result.confirm(m1050a(jSONObject.getJSONObject("eventArgs"), jSONObject.getString("eventType")));
        } catch (JSONException e) {
            CBLogging.m381b(f1047a, "Exception caught parsing the function name from js to native");
        }
        return true;
    }

    public String m1050a(JSONObject jSONObject, String str) {
        if (str.equals("click")) {
            m1061k(jSONObject);
        } else if (str.equals("close")) {
            Log.d(f1047a, "JavaScript to native close callback triggered");
            m1062l(jSONObject);
        } else if (str.equals("videoCompleted")) {
            Log.d(f1047a, "JavaScript to native video complete callback triggered");
            m1052b(jSONObject);
        } else if (str.equals("videoPlaying")) {
            Log.d(f1047a, "JavaScript to native video playing callback triggered");
            m1058h(jSONObject);
        } else if (str.equals("videoPaused")) {
            Log.d(f1047a, "JavaScript to native video pause callback triggered");
            m1057g(jSONObject);
        } else if (str.equals("videoReplay")) {
            Log.d(f1047a, "JavaScript to native video replay callback triggered");
            m1056f(jSONObject);
        } else if (str.equals("currentDuration")) {
            m1059i(jSONObject);
        } else if (str.equals("totalDuration")) {
            Log.d(f1047a, "JavaScript to native total duration callback triggered");
            m1060j(jSONObject);
        } else if (str.equals("show")) {
            Log.d(f1047a, "JavaScript to native show callback triggered");
            m1055e(jSONObject);
        } else if (str.equals(GCMConstants.EXTRA_ERROR)) {
            Log.d(f1047a, "JavaScript to native error callback triggered");
            m1053c(jSONObject);
        } else if (str.equals("warning")) {
            Log.d(f1047a, "JavaScript to native warning callback triggered");
            m1054d(jSONObject);
        } else if (!str.equals("webview")) {
            return "Function name not recognized.";
        } else {
            Log.d(f1047a, "JavaScript to native webview track event callback triggered");
            m1051a(jSONObject);
        }
        return "Native function successfully called.";
    }

    public void m1051a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta");
            String string = jSONObject.getString("trackingLevel");
            if (!string.isEmpty()) {
                this.f1056j.m4680a(jSONObject2, string);
            }
        } catch (Exception e) {
            CBLogging.m381b(f1047a, "Parsing exception for tracking webiew events");
            this.f1056j.m4685c("Parsing exception unknown field for webview track");
        }
    }

    public void m1052b(JSONObject jSONObject) {
        Log.d(bt.class.getName(), "Video is Completed");
        this.f1057k.post(new C03921(this));
    }

    public void m1053c(JSONObject jSONObject) {
        Log.d(bt.class.getName(), "Javascript Error occured");
        this.f1057k.post(new C03954(this, jSONObject));
    }

    public void m1054d(JSONObject jSONObject) {
        Log.d(bt.class.getName(), "Javascript warning occurred");
        this.f1057k.post(new C03965(this, jSONObject));
    }

    public void m1055e(JSONObject jSONObject) {
        this.f1057k.post(new C03976(this));
    }

    public void m1056f(JSONObject jSONObject) {
        this.f1057k.post(new C03987(this, jSONObject));
    }

    public void m1057g(JSONObject jSONObject) {
        this.f1057k.post(new C03998(this, jSONObject));
    }

    public void m1058h(JSONObject jSONObject) {
        this.f1057k.post(new C04009(this, jSONObject));
    }

    public void m1059i(JSONObject jSONObject) {
        this.f1057k.post(new AnonymousClass10(this, jSONObject));
    }

    public void m1060j(JSONObject jSONObject) {
        this.f1057k.post(new AnonymousClass11(this, jSONObject));
    }

    public void m1061k(JSONObject jSONObject) {
        this.f1057k.post(new C03932(this));
    }

    public void m1062l(JSONObject jSONObject) {
        this.f1057k.post(new C03943(this));
    }

    public void onShowCustomView(View view, CustomViewCallback callback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            frameLayout.getFocusedChild();
            this.f1052f = true;
            this.f1053g = frameLayout;
            this.f1054h = callback;
            this.f1048b.setVisibility(4);
            this.f1049c.addView(this.f1053g, new LayoutParams(-1, -1));
            this.f1049c.setVisibility(0);
            if (this.f1055i != null) {
                this.f1055i.m1047a(true);
            }
        }
    }

    public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
        onShowCustomView(view, callback);
    }

    public void onHideCustomView() {
        if (this.f1052f) {
            this.f1049c.setVisibility(4);
            this.f1049c.removeView(this.f1053g);
            this.f1048b.setVisibility(0);
            if (!(this.f1054h == null || this.f1054h.getClass().getName().contains(".chromium."))) {
                this.f1054h.onCustomViewHidden();
            }
            this.f1052f = false;
            this.f1053g = null;
            this.f1054h = null;
            if (this.f1055i != null) {
                this.f1055i.m1047a(false);
            }
        }
    }
}
