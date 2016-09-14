package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.google.android.youtube.player.internal.C0625w.C0624a;

public final class ac extends aa {
    public final C1381a m4789a(C1382b c1382b, YouTubeThumbnailView youTubeThumbnailView) {
        return new C1533p(c1382b, youTubeThumbnailView);
    }

    public final C1382b m4790a(Context context, String str, C0620a c0620a, C0621b c0621b) {
        return new C1531o(context, str, context.getPackageName(), C0628z.m1285d(context), c0620a, c0621b);
    }

    public final C0602d m4791a(Activity activity, C1382b c1382b, boolean z) throws C0624a {
        return C0625w.m1271a(activity, c1382b.m4792a(), z);
    }
}
