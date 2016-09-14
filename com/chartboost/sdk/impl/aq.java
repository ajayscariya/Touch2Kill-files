package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBUtility;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import mf.javax.xml.XMLConstants;

public class aq extends ap {
    private ImageView f4083a;

    public aq(aw awVar, Context context) {
        super(context);
        this.f4083a = new ImageView(context);
        addView(this.f4083a, new LayoutParams(-1, -1));
    }

    public void m4507a(C0269a c0269a, int i) {
        C0269a a = c0269a.m431a("assets").m431a(CBUtility.m397c().m469a() ? "portrait" : "landscape");
        if (a.m438c()) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            String str = XMLConstants.NULL_NS_URI;
            if (!(a.m442e("checksum") == null || a.m442e("checksum").isEmpty())) {
                str = a.m442e("checksum");
            }
            bc.m956a().m962a(a.m442e(DatabaseOpenHelper.HISTORY_ROW_URL), str, null, this.f4083a, bundle);
        }
    }

    public int m4506a() {
        return CBUtility.m390a(110, getContext());
    }
}
