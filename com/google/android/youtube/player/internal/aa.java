package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.google.android.youtube.player.internal.C0625w.C0624a;

public abstract class aa {
    private static final aa f1179a;

    static {
        f1179a = m1179b();
    }

    public static aa m1178a() {
        return f1179a;
    }

    private static aa m1179b() {
        try {
            return (aa) Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(aa.class).newInstance();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        } catch (ClassNotFoundException e3) {
            return new ac();
        }
    }

    public abstract C1381a m1180a(C1382b c1382b, YouTubeThumbnailView youTubeThumbnailView);

    public abstract C1382b m1181a(Context context, String str, C0620a c0620a, C0621b c0621b);

    public abstract C0602d m1182a(Activity activity, C1382b c1382b, boolean z) throws C0624a;
}
