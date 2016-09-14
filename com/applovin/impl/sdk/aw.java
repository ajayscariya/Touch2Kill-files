package com.applovin.impl.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aw implements OnClickListener {
    final /* synthetic */ as f187a;

    aw(as asVar) {
        this.f187a = asVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f187a.f183a.f176b.m73a(this.f187a.f183a.f181g);
    }
}
