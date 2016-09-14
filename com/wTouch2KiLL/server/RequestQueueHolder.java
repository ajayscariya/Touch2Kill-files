package com.wTouch2KiLL.server;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

public class RequestQueueHolder {
    private static volatile boolean _ready;
    private static ArrayList<String> deferredUrls;
    private static RequestQueueHolder instance;
    private RequestQueue _queue;

    static {
        instance = null;
        _ready = false;
        deferredUrls = null;
    }

    public static RequestQueueHolder getInstance(Context context) {
        if (instance == null) {
            instance = new RequestQueueHolder(context);
        }
        return instance;
    }

    public static void addUrl(String url) {
        if (instance == null) {
            if (deferredUrls == null) {
                deferredUrls = new ArrayList();
            }
            deferredUrls.add(url);
            return;
        }
        instance.getQueue().add(new StringRequest(url, null, null));
    }

    public RequestQueue getQueue() {
        return this._queue;
    }

    private RequestQueueHolder(Context context) {
        this._queue = null;
        this._queue = Volley.newRequestQueue(context);
        _ready = true;
    }

    public static boolean ready() {
        return _ready;
    }
}
