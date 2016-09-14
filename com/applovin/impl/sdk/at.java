package com.applovin.impl.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class at implements OnClickListener {
    final /* synthetic */ as f184a;

    at(as asVar) {
        this.f184a = asVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f184a.f183a.f182h.schedule(new au(this), 200);
    }
}
