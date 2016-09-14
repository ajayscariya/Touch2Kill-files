package com.wTouch2KiLL.server;

import android.content.Context;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class BaseServerClient {
    protected static final int FORBIDDEN_RESPONSE = 403;
    protected static final int OK_RESPONSE = 200;
    protected MainNavigationActivity _activity;
    protected WebWidgetConfiguration _config;
    protected Context _context;

    public interface OnRequestDoneListener {
        void onRequestDone(String str, int i, String str2);
    }

    /* renamed from: com.wTouch2KiLL.server.BaseServerClient.1 */
    class C14781 implements Listener<String> {
        final /* synthetic */ OnRequestDoneListener val$onResponseListener;
        final /* synthetic */ String val$requestUrl;
        final /* synthetic */ Integer val$tag;

        C14781(OnRequestDoneListener onRequestDoneListener, String str, Integer num) {
            this.val$onResponseListener = onRequestDoneListener;
            this.val$requestUrl = str;
            this.val$tag = num;
        }

        public void onResponse(String response) {
            if (this.val$onResponseListener != null) {
                this.val$onResponseListener.onRequestDone(this.val$requestUrl, this.val$tag.intValue(), response);
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.server.BaseServerClient.2 */
    class C14792 implements ErrorListener {
        C14792() {
        }

        public void onErrorResponse(VolleyError arg0) {
            if (arg0 == null || arg0.getMessage() == null) {
                System.err.println(NotificationCompatApi21.CATEGORY_ERROR);
            } else {
                System.err.println(arg0.getMessage());
            }
        }
    }

    public BaseServerClient(MainNavigationActivity activity) {
        this._activity = activity;
        this._context = activity;
        this._config = activity.getConfig();
    }

    public BaseServerClient(Context context, WebWidgetConfiguration config) {
        this._activity = null;
        this._context = context;
        this._config = config;
    }

    public void sendRequestAsync(String requestUrl, Integer tag, OnRequestDoneListener onResponseListener) {
        StringRequest stringRequest = new StringRequest(requestUrl, new C14781(onResponseListener, requestUrl, tag), new C14792());
        stringRequest.setTag(tag);
        RequestQueueHolder.getInstance(this._context).getQueue().add(stringRequest);
    }

    public boolean getAvailabilityStatus(String url) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(url + "&test=1").openConnection();
            con.setRequestMethod("HEAD");
            if (con.getResponseCode() != OK_RESPONSE) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Map<String, List<String>> loadHeaders(String url) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(url + "&test=1").openConnection();
            con.setRequestMethod("HEAD");
            int iResp = con.getResponseCode();
            Map<String, List<String>> resp = con.getHeaderFields();
            if (iResp != OK_RESPONSE) {
                return null;
            }
            return resp;
        } catch (Exception e) {
            return null;
        }
    }
}
