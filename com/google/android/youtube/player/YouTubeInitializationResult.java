package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.youtube.player.internal.C0611m;
import com.google.android.youtube.player.internal.C0627y;
import com.google.android.youtube.player.internal.C0628z;
import com.google.android.youtube.player.internal.ab;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public enum YouTubeInitializationResult {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    /* renamed from: com.google.android.youtube.player.YouTubeInitializationResult.1 */
    static /* synthetic */ class C05971 {
        static final /* synthetic */ int[] f1168a;

        static {
            f1168a = new int[YouTubeInitializationResult.values().length];
            try {
                f1168a[YouTubeInitializationResult.SERVICE_MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1168a[YouTubeInitializationResult.SERVICE_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1168a[YouTubeInitializationResult.SERVICE_VERSION_UPDATE_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubeInitializationResult.a */
    private static final class C0598a implements OnClickListener {
        private final Activity f1169a;
        private final Intent f1170b;
        private final int f1171c;

        public C0598a(Activity activity, Intent intent, int i) {
            this.f1169a = (Activity) ab.m1183a((Object) activity);
            this.f1170b = (Intent) ab.m1183a((Object) intent);
            this.f1171c = ((Integer) ab.m1183a(Integer.valueOf(i))).intValue();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f1169a.startActivityForResult(this.f1170b, this.f1171c);
                dialogInterface.dismiss();
            } catch (Throwable e) {
                C0627y.m1274a("Can't perform resolution for YouTubeInitalizationError", e);
            }
        }
    }

    public final Dialog getErrorDialog(Activity activity, int i) {
        return getErrorDialog(activity, i, null);
    }

    public final Dialog getErrorDialog(Activity activity, int i, OnCancelListener onCancelListener) {
        Intent b;
        Builder builder = new Builder(activity);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        switch (C05971.f1168a[ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                b = C0628z.m1282b(C0628z.m1278a((Context) activity));
                break;
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                b = C0628z.m1276a(C0628z.m1278a((Context) activity));
                break;
            default:
                b = null;
                break;
        }
        OnClickListener c0598a = new C0598a(activity, b, i);
        C0611m c0611m = new C0611m(activity);
        switch (C05971.f1168a[ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                return builder.setTitle(c0611m.f1181b).setMessage(c0611m.f1182c).setPositiveButton(c0611m.f1183d, c0598a).create();
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                return builder.setTitle(c0611m.f1184e).setMessage(c0611m.f1185f).setPositiveButton(c0611m.f1186g, c0598a).create();
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return builder.setTitle(c0611m.f1187h).setMessage(c0611m.f1188i).setPositiveButton(c0611m.f1189j, c0598a).create();
            default:
                String str = "Unexpected errorReason: ";
                String valueOf = String.valueOf(name());
                throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final boolean isUserRecoverableError() {
        switch (C05971.f1168a[ordinal()]) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return true;
            default:
                return false;
        }
    }
}
