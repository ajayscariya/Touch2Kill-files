package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;

public class bh extends FrameLayout {
    private View f972a;
    private boolean f973b;

    /* renamed from: com.chartboost.sdk.impl.bh.a */
    public interface C0378a {
        void m985a();

        void m986a(int i);

        void m987a(int i, int i2);

        void m988a(OnCompletionListener onCompletionListener);

        void m989a(OnErrorListener onErrorListener);

        void m990a(OnPreparedListener onPreparedListener);

        void m991a(Uri uri);

        void m992b();

        int m993c();

        int m994d();

        boolean m995e();
    }

    public bh(Context context) {
        super(context);
        m998c();
    }

    private void m998c() {
        this.f973b = m997b();
        if (!Chartboost.getImpressionsUseActivities() && (getContext() instanceof Activity)) {
            this.f973b = m996a((Activity) getContext());
        }
        CBLogging.m387e("VideoInit", "Choosing " + (this.f973b ? "texture" : "surface") + " solution for video playback");
        if (this.f973b) {
            this.f972a = new bg(getContext());
        } else {
            this.f972a = new bf(getContext());
        }
        addView(this.f972a, new LayoutParams(-1, -1));
        if (!this.f973b) {
            ((SurfaceView) this.f972a).setZOrderMediaOverlay(true);
        }
    }

    public C0378a m999a() {
        return (C0378a) this.f972a;
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        m999a().m987a(w, h);
    }

    public static boolean m996a(Activity activity) {
        if (m997b()) {
            if (Chartboost.getImpressionsUseActivities()) {
                return true;
            }
            try {
                return activity.getWindow().getDecorView().isHardwareAccelerated();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static boolean m997b() {
        return VERSION.SDK_INT >= 14;
    }
}
