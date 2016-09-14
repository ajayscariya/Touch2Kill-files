package rrrrrr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.immersion.hapticmediasdk.HapticContentSDK.SDKStatus;
import com.immersion.hapticmediasdk.MediaTaskManager;
import com.immersion.hapticmediasdk.controllers.MediaController;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class crrrrr extends Handler {
    public static int f3692b0421042104210421 = 0;
    public static int f3693b0421042104210421 = 2;
    public static int f3694b042104210421 = 1;
    public static int f3695b042104210421 = 1;
    public final /* synthetic */ MediaController f3696b041704170417;

    public crrrrr(MediaController mediaController, Looper looper) {
        this.f3696b041704170417 = mediaController;
        super(looper);
    }

    public static int m3973b0421042104210421() {
        return 35;
    }

    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    if (MediaController.m1383b04110411041104110411(this.f3696b041704170417).get() == message.arg1 && MediaController.m1380b043B(this.f3696b041704170417).get() == message.arg2) {
                        try {
                            MediaTaskManager bл043Bлллл = MediaController.m1385b043B(this.f3696b041704170417);
                            int i = f3694b042104210421;
                            switch ((i * (f3695b042104210421 + i)) % f3693b0421042104210421) {
                                case DurationDV.DURATION_TYPE /*0*/:
                                    break;
                                default:
                                    f3694b042104210421 = 55;
                                    f3692b0421042104210421 = m3973b0421042104210421();
                                    break;
                            }
                            if (bл043Bлллл.getSDKStatus() == SDKStatus.PAUSED_DUE_TO_BUFFERING) {
                                MediaController.m1385b043B(this.f3696b041704170417).transitToState(SDKStatus.PLAYING);
                                return;
                            }
                            MediaController.m1378b043B043B(this.f3696b041704170417, MediaController.m1383b04110411041104110411(this.f3696b041704170417).get(), SystemClock.uptimeMillis());
                            this.f3696b041704170417.playbackStarted();
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                case ConnectionResult.NETWORK_ERROR /*7*/:
                    this.f3696b041704170417.m1374a(message.arg1);
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    MediaController.m1379b043B043B(this.f3696b041704170417, message);
                default:
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
