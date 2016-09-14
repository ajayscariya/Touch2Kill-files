package com.applovin.impl.sdk;

import android.app.AlertDialog.Builder;

class as implements Runnable {
    final /* synthetic */ ar f183a;

    as(ar arVar) {
        this.f183a = arVar;
    }

    public void run() {
        Builder builder = new Builder(this.f183a.f177c);
        builder.setTitle((CharSequence) this.f183a.f175a.m4161a(bx.f242K));
        builder.setMessage((CharSequence) this.f183a.f175a.m4161a(bx.f243L));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f183a.f175a.m4161a(bx.f244M), new at(this));
        builder.setNegativeButton((CharSequence) this.f183a.f175a.m4161a(bx.f245N), new aw(this));
        builder.show();
    }
}
