package com.applovin.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.NativeAdImpl;
import com.applovin.impl.sdk.di;
import java.io.File;
import mf.javax.xml.XMLConstants;

public class AppLovinSdkUtils {
    public static final String TAG = "AppLovinSdkUtils";

    private static boolean m312a(Context context) {
        Bundle e = m316e(context);
        return e != null && e.getBoolean("applovin.sdk.verbose_logging", false);
    }

    private static long m313b(Context context) {
        Bundle e = m316e(context);
        return e != null ? (long) e.getInt("applovin.sdk.ad_refresh_seconds", -100) : -100;
    }

    private static String m314c(Context context) {
        Bundle e = m316e(context);
        if (e != null) {
            String string = e.getString("applovin.sdk.auto_preload_ad_sizes");
            if (string != null) {
                return string;
            }
        }
        return AppLovinAdSize.BANNER.getLabel() + "," + AppLovinAdSize.INTERSTITIAL.getLabel();
    }

    private static String m315d(Context context) {
        Bundle e = m316e(context);
        if (e != null) {
            String string = e.getString("applovin.sdk.auto_preload_ad_types");
            if (string != null) {
                return string;
            }
        }
        return AppLovinAdType.REGULAR.getLabel() + "," + AppLovinAdType.INCENTIVIZED.getLabel() + "," + NativeAdImpl.TYPE_NATIVE.getLabel();
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    private static Bundle m316e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT).metaData;
        } catch (Throwable e) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to retrieve application metadata", e);
            return null;
        }
    }

    public static boolean isValidString(String str) {
        return str != null && str.length() > 1;
    }

    public static void openUri(Context context, Uri uri, AppLovinSdk appLovinSdk) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Throwable th) {
            appLovinSdk.getLogger().m308e(TAG, "Unable to open \"" + uri + "\".", th);
        }
    }

    public static void openUrl(Context context, String str, AppLovinSdk appLovinSdk) {
        openUri(context, Uri.parse(str), appLovinSdk);
    }

    public static void recycleImageView(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                ((BitmapDrawable) drawable).getBitmap().recycle();
            }
        }
    }

    public static String retrieveSdkKey(Context context) {
        Bundle e = m316e(context);
        if (e == null) {
            return null;
        }
        String string = e.getString("applovin.sdk.key");
        return string != null ? string : XMLConstants.NULL_NS_URI;
    }

    public static AppLovinSdkSettings retrieveUserSettings(Context context) {
        AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings();
        appLovinSdkSettings.setVerboseLogging(m312a(context));
        appLovinSdkSettings.setBannerAdRefreshSeconds(m313b(context));
        appLovinSdkSettings.setAutoPreloadSizes(m314c(context));
        appLovinSdkSettings.setAutoPreloadTypes(m315d(context));
        return appLovinSdkSettings;
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int i, int i2) {
        recycleImageView(imageView);
        Bitmap a = di.m4279a(context, i, i2);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int i) {
        recycleImageView(imageView);
        Bitmap a = di.m4280a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }
}
