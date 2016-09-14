package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.C0282k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.ba;

public class CBImpressionActivity extends Activity {
    protected static final String f375a;
    private Activity f376b;
    private PhoneStateListener f377c;

    /* renamed from: com.chartboost.sdk.CBImpressionActivity.1 */
    class C02511 extends PhoneStateListener {
        final /* synthetic */ CBImpressionActivity f374a;

        C02511(CBImpressionActivity cBImpressionActivity) {
            this.f374a = cBImpressionActivity;
        }

        public void onCallStateChanged(int state, String incomingNumber) {
            if (state == 1) {
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Phone call State: Ringing");
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Pausing the impression");
                this.f374a.onPause();
            } else if (state == 0) {
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Phone call State: Idle");
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Resuming the impression");
                this.f374a.onResume();
            } else if (state == 2) {
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Phone call State: OffHook");
                CBLogging.m379a(CBImpressionActivity.f375a, "##### Pausing the impression");
                this.f374a.onPause();
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }

    public CBImpressionActivity() {
        this.f376b = null;
        this.f377c = new C02511(this);
    }

    static {
        f375a = CBImpressionActivity.class.getSimpleName();
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (this.f376b != null) {
            return this.f376b.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public void forwardTouchEvents(Activity host) {
        this.f376b = host;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
        requestWindowFeature(1);
        getWindow().setWindowAnimations(0);
        setContentView(new RelativeLayout(this));
        Chartboost.m323a(this);
        Chartboost.m336c((Activity) this);
        ba.m914a((Context) this).m931d();
        CBLogging.m379a(CBImpressionActivity.class.getName(), "Impression Activity onCreate() called");
    }

    protected void onStart() {
        super.onStart();
        Chartboost.m319a();
        Chartboost.m321a((Activity) this);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
            if (telephonyManager != null) {
                telephonyManager.listen(this.f377c, 32);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
        Chartboost.m324a(C0282k.m549a((Activity) this));
        CBUtility.m398c(this);
    }

    protected void onPause() {
        super.onPause();
        Chartboost.m333b(C0282k.m549a((Activity) this));
    }

    protected void onStop() {
        super.onStop();
        Chartboost.m337c(C0282k.m549a((Activity) this));
        try {
            ((TelephonyManager) getSystemService("phone")).listen(this.f377c, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Chartboost.m331b((Activity) this);
    }

    public void onBackPressed() {
        if (!Chartboost.m340d()) {
            super.onBackPressed();
        }
    }
}
