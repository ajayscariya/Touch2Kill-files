package com.wTouch2KiLL.pull;

import android.content.Context;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.configuration.WebWidgetConfigurationManager;
import com.wTouch2KiLL.server.RequestQueueHolder;
import java.net.URLEncoder;

public class StatServerClient {
    private WebWidgetConfiguration _config;
    private Context _context;

    /* renamed from: com.wTouch2KiLL.pull.StatServerClient.1 */
    class C09381 extends Thread {
        final /* synthetic */ String val$requestUrl;

        C09381(String str) {
            this.val$requestUrl = str;
        }

        public void run() {
            RequestQueueHolder.addUrl(this.val$requestUrl);
        }
    }

    public StatServerClient(Context context) {
        this._context = null;
        this._context = context;
        try {
            this._config = WebWidgetConfigurationManager.getInstance(this._context).loadConfiguration(this._context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageAcceptedAsync(String messageUrl) {
        try {
            _sendRequestAsync(_createStatUrl("request", messageUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPushReceivedAsync(String messageUrl) {
        try {
            _sendRequestAsync(_createStatPushUrl("request", messageUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void senMessageClickedAsync(String messageUrl) {
        try {
            _sendRequestAsync(_createStatUrl("click", messageUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String _createStatUrl(String action, String messageUrl) {
        return this._context.getResources().getString(C0866R.string.statDomainUrl) + "pull.php?" + "a=" + action + "&url=" + URLEncoder.encode(messageUrl) + "&app=" + this._config.getApplicationId() + "&v=" + URLEncoder.encode(this._context.getString(C0866R.string.platformVersion)) + "&guid=" + URLEncoder.encode(this._config.getAppGuid());
    }

    private String _createStatPushUrl(String action, String messageUrl) {
        return this._context.getResources().getString(C0866R.string.statDomainUrl) + "push.php?" + "a=" + action + "&url=" + URLEncoder.encode(messageUrl) + "&app=" + this._config.getApplicationId() + "&v=" + URLEncoder.encode(this._context.getString(C0866R.string.platformVersion)) + "&guid=" + URLEncoder.encode(this._config.getAppGuid());
    }

    private void _sendRequestAsync(String requestUrl) {
        new C09381(requestUrl).start();
    }
}
