package rrrrrr;

import com.immersion.hapticmediasdk.controllers.MediaController;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

public class rcrrrr implements Runnable {
    public static int f3705b0415041504150415 = 1;
    public static int f3706b041504150415 = 92;
    public static int f3707b041504150415 = 0;
    public static int f3708b041504150415 = 2;
    public final /* synthetic */ MediaController f3709b04170417041704170417;

    public rcrrrr(MediaController mediaController) {
        if (((f3706b041504150415 + f3705b0415041504150415) * f3706b041504150415) % f3708b041504150415 != f3707b041504150415) {
            f3706b041504150415 = 15;
            f3707b041504150415 = 7;
        }
        try {
            this.f3709b04170417041704170417 = mediaController;
            try {
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int m3979b0415041504150415() {
        return 6;
    }

    public void run() {
        if (this.f3709b04170417041704170417.isPlaying() && MediaController.m1384b043B043B(this.f3709b04170417041704170417) != null) {
            MediaController.m1384b043B043B(this.f3709b04170417041704170417).syncUpdate(this.f3709b04170417041704170417.getCurrentPosition(), this.f3709b04170417041704170417.getReferenceTimeForCurrentPosition());
            MediaController mediaController = this.f3709b04170417041704170417;
            int i = f3706b041504150415;
            switch ((i * (f3705b0415041504150415 + i)) % f3708b041504150415) {
                case DurationDV.DURATION_TYPE /*0*/:
                    break;
                default:
                    f3706b041504150415 = m3979b0415041504150415();
                    f3707b041504150415 = 99;
                    break;
            }
            MediaController.m1384b043B043B(mediaController).getHandler().removeCallbacks(this);
            MediaController.m1384b043B043B(this.f3709b04170417041704170417).getHandler().postDelayed(this, 1000);
        }
    }
}
