package com.wTouch2KiLL.server;

import android.content.Context;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.configuration.WebWidgetConfiguration;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;

public class PushServerClient extends BaseServerClient implements OnRequestDoneListener {

    enum RequestType {
        REGISTER_ID,
        UNREGISTER_ID,
        GET_PUSH_ACCOUNT
    }

    public PushServerClient(MainNavigationActivity activity) {
        super(activity);
    }

    public PushServerClient(Context context, WebWidgetConfiguration config) {
        super(context, config);
    }

    public void sendRegisteredId(String regId) {
        sendRequestAsync(this._context.getResources().getString(C0866R.string.pushDomainUrl) + "add_register_id.php" + "?id=" + String.valueOf(this._config.getApplicationId()) + "&guid=" + this._config.getAppGuid() + "&regId=" + regId, Integer.valueOf(RequestType.REGISTER_ID.ordinal()), this);
    }

    public void sendUnregisteredId(String regId) {
        sendRequestAsync(this._context.getResources().getString(C0866R.string.pushDomainUrl) + "remove_register_id.php" + "?id=" + String.valueOf(this._config.getApplicationId()) + "&guid=" + this._config.getAppGuid() + "&regId=" + regId, Integer.valueOf(RequestType.UNREGISTER_ID.ordinal()), this);
    }

    public void onRequestDone(String requestUrl, int tag, String response) {
    }

    private void _savePushAccount(String response) {
    }

    public void loadPushAccount() {
        sendRequestAsync(this._context.getResources().getString(C0866R.string.pushDomainUrl) + "register.php" + "?id=" + String.valueOf(this._config.getApplicationId()) + "&guid=" + this._config.getAppGuid(), Integer.valueOf(RequestType.GET_PUSH_ACCOUNT.ordinal()), this);
    }
}
