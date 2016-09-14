package com.inmobi.commons.core.utilities.uid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class ImIdShareBroadCastReceiver extends BroadcastReceiver {
    private static final String f1687a;

    static {
        f1687a = ImIdShareBroadCastReceiver.class.getSimpleName();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.inmobi.share.id")) {
            UidDao uidDao = new UidDao(context);
            CharSequence string = intent.getExtras().getString("appid");
            String d = uidDao.m1850d();
            String string2 = intent.getExtras().getString("imid");
            String f = uidDao.m1853f();
            String string3 = intent.getExtras().getString("appendedid");
            long e = uidDao.m1852e();
            long j = intent.getExtras().getLong("imidts");
            Logger.m1744a(InternalLogLevel.INTERNAL, f1687a, "Received broadcast for IDs. Received ID:" + string2 + " AppID:" + string + " AID:" + string3);
            if (f != null && string != null) {
                if (!f.contains(string)) {
                    if (j < e) {
                        uidDao.m1849c(string2);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("com.inmobi.share.id");
                    intent2.putExtra("imid", d);
                    intent2.putExtra("appendedid", f);
                    intent2.putExtra("imidts", e);
                    intent2.putExtra("appid", UidHelper.m1854a().m1865c());
                    context.sendBroadcast(intent2);
                }
                uidDao.m1851d(m1837a(string3, f));
            }
        }
    }

    public static String m1837a(String str, String str2) {
        if (str == null && str2 == null) {
            return null;
        }
        if (str != null && str2 != null) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                if (!str2.contains(split[i])) {
                    str2 = str2 + "," + split[i];
                }
            }
            return str2;
        } else if (str != null) {
            return str;
        } else {
            return str2;
        }
    }
}
