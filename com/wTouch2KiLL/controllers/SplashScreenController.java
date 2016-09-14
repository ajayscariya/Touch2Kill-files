package com.wTouch2KiLL.controllers;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.utils.ImageReader;
import java.io.IOException;

public class SplashScreenController {
    private final int SPLASH_SCREEN_TIMEOUT;
    private MainNavigationActivity _activity;
    private Handler _handler;
    private ViewGroup _splashScreenView;
    private Runnable hideSplashScreenViewRunnable;
    private Runnable showSplashScreenViewRunnable;

    /* renamed from: com.wTouch2KiLL.controllers.SplashScreenController.1 */
    class C09061 implements Runnable {
        C09061() {
        }

        public void run() {
            SplashScreenController.this._activity.showSplashScreen();
        }
    }

    /* renamed from: com.wTouch2KiLL.controllers.SplashScreenController.2 */
    class C09072 implements Runnable {
        C09072() {
        }

        public void run() {
            if (SplashScreenController.this._activity.getFullScreenBannerController().isOnScreen()) {
                SplashScreenController.this._splashScreenView.setVisibility(8);
            } else {
                SplashScreenController.this._activity.showContentView();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.controllers.SplashScreenController.3 */
    class C09083 implements Runnable {
        C09083() {
        }

        public void run() {
            SplashScreenController.this._activity.runOnUiThread(SplashScreenController.this.hideSplashScreenViewRunnable);
        }
    }

    public SplashScreenController(ViewGroup splashScreenView, MainNavigationActivity activity) {
        this.SPLASH_SCREEN_TIMEOUT = 2000;
        this._handler = new Handler();
        this.showSplashScreenViewRunnable = new C09061();
        this.hideSplashScreenViewRunnable = new C09072();
        this._splashScreenView = splashScreenView;
        this._activity = activity;
    }

    public void showSplashScreen(String imagePath) {
        try {
            ((ImageView) this._splashScreenView.findViewById(C0866R.id.splashScreenImage)).setImageBitmap(ImageReader.decodeFile(this._activity.getAssets().open(imagePath), this._activity.getWindowManager().getDefaultDisplay().getWidth()));
            this._activity.runOnUiThread(this.showSplashScreenViewRunnable);
            this._handler.postDelayed(new C09083(), 2000);
        } catch (IOException e) {
            e.printStackTrace();
            this._activity.showContentView();
        }
    }
}
