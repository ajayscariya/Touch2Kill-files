package com.applovin.impl.sdk;

import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

class aq implements Runnable {
    final /* synthetic */ ap f174a;

    aq(ap apVar) {
        this.f174a = apVar;
    }

    public void run() {
        String str = (String) this.f174a.f171a.m4161a(bx.f246O);
        String b = this.f174a.m83b();
        String str2 = (String) this.f174a.f171a.m4161a(bx.f251T);
        if (C0237n.m249a(AppLovinConfirmationActivity.class, this.f174a.f173c)) {
            try {
                Intent intent = new Intent(this.f174a.f173c, AppLovinConfirmationActivity.class);
                intent.putExtra("dialog_title", str);
                intent.putExtra("dialog_body", b);
                intent.putExtra("dialog_button_text", str2);
                this.f174a.f173c.startActivity(intent);
                return;
            } catch (Throwable th) {
                this.f174a.m82a(b, th);
                return;
            }
        }
        this.f174a.m82a(b, null);
    }
}
