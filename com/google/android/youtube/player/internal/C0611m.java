package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.youtube.player.internal.m */
public final class C0611m {
    public final String f1180a;
    public final String f1181b;
    public final String f1182c;
    public final String f1183d;
    public final String f1184e;
    public final String f1185f;
    public final String f1186g;
    public final String f1187h;
    public final String f1188i;
    public final String f1189j;

    public C0611m(Context context) {
        Resources resources = context.getResources();
        Locale locale = (resources == null || resources.getConfiguration() == null || resources.getConfiguration().locale == null) ? Locale.getDefault() : resources.getConfiguration().locale;
        Map a = C0626x.m1272a(locale);
        this.f1180a = (String) a.get("error_initializing_player");
        this.f1181b = (String) a.get("get_youtube_app_title");
        this.f1182c = (String) a.get("get_youtube_app_text");
        this.f1183d = (String) a.get("get_youtube_app_action");
        this.f1184e = (String) a.get("enable_youtube_app_title");
        this.f1185f = (String) a.get("enable_youtube_app_text");
        this.f1186g = (String) a.get("enable_youtube_app_action");
        this.f1187h = (String) a.get("update_youtube_app_title");
        this.f1188i = (String) a.get("update_youtube_app_text");
        this.f1189j = (String) a.get("update_youtube_app_action");
    }
}
