package com.applovin.adview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.applovin.adview.a */
class C0192a implements OnClickListener {
    final /* synthetic */ AppLovinConfirmationActivity f12a;

    C0192a(AppLovinConfirmationActivity appLovinConfirmationActivity) {
        this.f12a = appLovinConfirmationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f12a.finish();
    }
}
