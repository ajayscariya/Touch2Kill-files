package com.wTouch2KiLL.pull;

import android.content.Context;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfigurationManager;
import com.wTouch2KiLL.server.BaseServerClient;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.net.URLEncoder;
import mf.javax.xml.XMLConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class PullServerClient {
    private final String DOMAIN_URL_KEY;
    private final String LAST_REQUEST_TIME_KEY;
    private final int OK_RESPONSE;
    private Context _context;
    private onMessageReceivedListener _listener;

    /* renamed from: com.wTouch2KiLL.pull.PullServerClient.1 */
    class C09371 extends Thread {
        final /* synthetic */ onMessageReceivedListener val$onResponseListener;
        final /* synthetic */ String val$requestUrl;

        /* renamed from: com.wTouch2KiLL.pull.PullServerClient.1.1 */
        class C14771 implements OnRequestDoneListener {
            C14771() {
            }

            public void onRequestDone(String requestUrl, int tag, String response) {
                String string;
                try {
                    JSONObject json = new JSONObject(response);
                    JSONArray jsonViewUrls = json.getJSONArray("data");
                    if (jsonViewUrls.length() > 0) {
                        Response[] responses = new Response[jsonViewUrls.length()];
                        for (int i = 0; i < jsonViewUrls.length(); i++) {
                            JSONObject row = jsonViewUrls.getJSONObject(i);
                            responses[i] = new Response();
                            responses[i].url = row.getString("data");
                            responses[i].message = row.getString("message");
                            responses[i].title = row.getString(DatabaseOpenHelper.HISTORY_ROW_TITLE);
                            Response response2 = responses[i];
                            if (row.has("launchMain")) {
                                string = row.getString("launchMain");
                            } else {
                                string = null;
                            }
                            response2.launchMain = string;
                        }
                        C09371.this.val$onResponseListener.onMessage(responses);
                    }
                    PullServerClient.this._setLastRequestTime(PullServerClient.this._context, json.getLong("timestamp"));
                } catch (Exception e) {
                    e.printStackTrace();
                    string = XMLConstants.NULL_NS_URI;
                }
            }
        }

        C09371(String str, onMessageReceivedListener com_wTouch2KiLL_pull_PullServerClient_onMessageReceivedListener) {
            this.val$requestUrl = str;
            this.val$onResponseListener = com_wTouch2KiLL_pull_PullServerClient_onMessageReceivedListener;
        }

        public void run() {
            try {
                new BaseServerClient(PullServerClient.this._context, null).sendRequestAsync(this.val$requestUrl, Integer.valueOf(0), new C14771());
            } catch (Exception e) {
            }
        }
    }

    public class Response {
        String launchMain;
        String message;
        String title;
        String url;

        public Response() {
            this.url = XMLConstants.NULL_NS_URI;
            this.title = XMLConstants.NULL_NS_URI;
            this.message = XMLConstants.NULL_NS_URI;
            this.launchMain = XMLConstants.NULL_NS_URI;
        }
    }

    public interface onMessageReceivedListener {
        void onMessage(Response[] responseArr);
    }

    public PullServerClient(Context context, onMessageReceivedListener listener) {
        this.OK_RESPONSE = 200;
        this.LAST_REQUEST_TIME_KEY = "last_pull_request_time";
        this.DOMAIN_URL_KEY = "domain_url";
        this._context = null;
        this._context = context;
        this._listener = listener;
    }

    public void tryLoadMessageAsync() {
        try {
            WebWidgetConfiguration config = WebWidgetConfigurationManager.getInstance(this._context).loadConfiguration(this._context);
            String pullServerUrl = _getDomainUrl(this._context);
            String version = this._context.getString(C0866R.string.platformVersion);
            _sendRequestAsync(pullServerUrl + "get_message.php?app_id=" + config.getApplicationId() + "&name=" + URLEncoder.encode(config.getWidgetName(), "utf-8") + "&last_request_timestamp=" + _getLastRequestTime(this._context) + "&guid=" + URLEncoder.encode(config.getAppGuid()) + "&v=" + URLEncoder.encode(version), this._listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private long _getLastRequestTime(Context context) {
        return context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).getLong("last_pull_request_time", System.currentTimeMillis() / 1000);
    }

    private void _setLastRequestTime(Context context, long newTime) {
        context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).edit().putLong("last_pull_request_time", newTime).commit();
    }

    private void _rotateDomainUrls(Context context) {
        String currentUrl = _getDomainUrl(context);
        String url1 = this._context.getResources().getString(C0866R.string.pullDomainUrl1);
        String url2 = this._context.getResources().getString(C0866R.string.pullDomainUrl2);
        String url3 = this._context.getResources().getString(C0866R.string.pullDomainUrl3);
        if (currentUrl.equalsIgnoreCase(url1)) {
            _setDomainUrl(context, url2);
        } else if (currentUrl.equalsIgnoreCase(url2)) {
            _setDomainUrl(context, url3);
        } else if (currentUrl.equalsIgnoreCase(url3)) {
            _setDomainUrl(context, url1);
        } else {
            _setDomainUrl(context, url1);
        }
    }

    private String _getDomainUrl(Context context) {
        return context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).getString("domain_url", this._context.getResources().getString(C0866R.string.pullDomainUrl1));
    }

    private void _setDomainUrl(Context context, String newUrl) {
        context.getSharedPreferences(MainNavigationActivity.PREFS_NAME, 0).edit().putString("domain_url", newUrl).commit();
    }

    private void _sendRequestAsync(String requestUrl, onMessageReceivedListener onResponseListener) {
        new C09371(requestUrl, onResponseListener).start();
    }
}
