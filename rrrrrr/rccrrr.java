package rrrrrr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.immersion.hapticmediasdk.controllers.FileReaderFactory;
import com.immersion.hapticmediasdk.controllers.HapticPlaybackThread;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class rccrrr extends Handler {
    public static int f3697b04270427042704270427 = 16;
    public static int f3698b04270427042704270427 = 1;
    public static int f3699b0427042704270427;
    public final /* synthetic */ HapticPlaybackThread f3700b0444044404440444;

    private rccrrr(HapticPlaybackThread hapticPlaybackThread) {
        int i = 0;
        while (true) {
            try {
                int[] iArr = new int[-1];
            } catch (Exception e) {
                while (true) {
                    try {
                        i /= 0;
                    } catch (Exception e2) {
                        try {
                            this.f3700b0444044404440444 = hapticPlaybackThread;
                            try {
                                return;
                            } catch (Exception e3) {
                                throw e3;
                            }
                        } catch (Exception e32) {
                            throw e32;
                        }
                    }
                }
            }
        }
    }

    public static int m3974b0446() {
        return 85;
    }

    public static int m3975b04270427042704270427() {
        return 2;
    }

    public void handleMessage(Message message) {
        int i = 0;
        String str = null;
        switch (message.what) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                HapticPlaybackThread.m1350b041104110411(this.f3700b0444044404440444).removeCallbacks(HapticPlaybackThread.m1341b041104110411(this.f3700b0444044404440444));
                HapticPlaybackThread.m1333b0411041104110411(this.f3700b0444044404440444, message.arg1);
                HapticPlaybackThread.m1354b041104110411(this.f3700b0444044404440444, message.arg2);
                HapticPlaybackThread.m1337b0411041104110411(this.f3700b0444044404440444, 0);
                HapticPlaybackThread.m1347b0411041104110411(this.f3700b0444044404440444);
            case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                Bundle data = message.getData();
                HapticPlaybackThread.m1330b04110411041104110411(this.f3700b0444044404440444, data.getInt("playback_timecode"), data.getLong("playback_uptime"));
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                if (HapticPlaybackThread.m1360b0411(this.f3700b0444044404440444) == null) {
                    HapticPlaybackThread.m1344b04110411(this.f3700b0444044404440444, FileReaderFactory.getHapticFileReaderInstance(this.f3700b0444044404440444.f1299f, HapticPlaybackThread.m1336b041104110411(this.f3700b0444044404440444)));
                }
                if (HapticPlaybackThread.m1360b0411(this.f3700b0444044404440444) != null && this.f3700b0444044404440444.f1298e == 0) {
                    HapticPlaybackThread.m1340b041104110411(this.f3700b0444044404440444, HapticPlaybackThread.m1360b0411(this.f3700b0444044404440444).getBlockSizeMS());
                }
                if (HapticPlaybackThread.m1360b0411(this.f3700b0444044404440444) != null) {
                    HapticPlaybackThread.m1360b0411(this.f3700b0444044404440444).setBytesAvailable(message.arg1);
                }
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                HapticPlaybackThread.m1349b041104110411(this.f3700b0444044404440444);
                while (true) {
                    try {
                        i /= 0;
                    } catch (Exception e) {
                        while (true) {
                            try {
                                str.length();
                            } catch (Exception e2) {
                                return;
                            }
                        }
                    }
                }
            case MetaData.DEFAULT_SMART_REDIRECT_TIMEOUT /*5*/:
                HapticPlaybackThread.m1332b0411041104110411(this.f3700b0444044404440444);
            case ConnectionResult.INTERNAL_ERROR /*8*/:
                HapticPlaybackThread.m1358b04110411(this.f3700b0444044404440444, message);
            case ConnectionResult.SERVICE_INVALID /*9*/:
                HapticPlaybackThread.m1342b041104110411(this.f3700b0444044404440444);
            default:
        }
    }
}
