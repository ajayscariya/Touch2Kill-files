package com.chartboost.sdk.impl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

public class bm {
    private static final String[] f1011a;
    private C0390b f1012b;

    /* renamed from: com.chartboost.sdk.impl.bm.1 */
    class C03871 implements OnShowListener {
        final /* synthetic */ AlertDialog f1004a;
        final /* synthetic */ int f1005b;
        final /* synthetic */ ArrayList f1006c;
        final /* synthetic */ int f1007d;
        final /* synthetic */ bm f1008e;

        /* renamed from: com.chartboost.sdk.impl.bm.1.1 */
        class C03861 implements OnClickListener {
            final /* synthetic */ int f1002a;
            final /* synthetic */ C03871 f1003b;

            C03861(C03871 c03871, int i) {
                this.f1003b = c03871;
                this.f1002a = i;
            }

            public void onClick(View v) {
                if (this.f1003b.f1008e.f1012b != null) {
                    this.f1003b.f1008e.f1012b.m1030a(this.f1003b.f1008e, this.f1002a);
                }
                this.f1003b.f1004a.dismiss();
            }
        }

        C03871(bm bmVar, AlertDialog alertDialog, int i, ArrayList arrayList, int i2) {
            this.f1008e = bmVar;
            this.f1004a = alertDialog;
            this.f1005b = i;
            this.f1006c = arrayList;
            this.f1007d = i2;
        }

        public void onShow(DialogInterface d) {
            Button[] a = bm.m1033b(this.f1004a);
            for (int i = 0; i < this.f1005b; i++) {
                CharSequence charSequence = (CharSequence) this.f1006c.get(i);
                Button button = a[i];
                if (this.f1007d == i) {
                    button.setTypeface(null, 1);
                }
                button.setText(charSequence);
                button.setOnClickListener(new C03861(this, i));
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bm.2 */
    class C03882 implements OnCancelListener {
        final /* synthetic */ bm f1009a;

        C03882(bm bmVar) {
            this.f1009a = bmVar;
        }

        public void onCancel(DialogInterface arg0) {
            this.f1009a.f1012b.m1029a(this.f1009a);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bm.a */
    public static class C0389a {
        private final Bundle f1010a;

        public C0389a() {
            this.f1010a = new Bundle();
        }

        public C0389a m1024a(String str) {
            this.f1010a.putString("arg:title", str);
            return this;
        }

        public C0389a m1026b(String str) {
            this.f1010a.putString("arg:message", str);
            return this;
        }

        public C0389a m1027c(String str) {
            this.f1010a.putString("arg:left", str);
            return this;
        }

        public C0389a m1028d(String str) {
            this.f1010a.putString("arg:right", str);
            return this;
        }

        public bm m1025a(Context context, C0390b c0390b) {
            return new bm(context, this.f1010a, c0390b);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.bm.b */
    public static abstract class C0390b {
        public abstract void m1030a(bm bmVar, int i);

        public void m1029a(bm bmVar) {
        }
    }

    static {
        f1011a = new String[]{"arg:left", "arg:center", "arg:right"};
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bm(android.content.Context r10, android.os.Bundle r11, com.chartboost.sdk.impl.bm.C0390b r12) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 0;
        r9.<init>();
        r9.f1012b = r12;
        r0 = "arg:title";
        r2 = r11.getString(r0);
        r0 = "arg:message";
        r3 = r11.getString(r0);
        r0 = "arg:default";
        r4 = -1;
        r5 = r11.getInt(r0, r4);
        r4 = new java.util.ArrayList;
        r4.<init>();
        r0 = r1;
    L_0x0020:
        r6 = 3;
        if (r0 >= r6) goto L_0x0037;
    L_0x0023:
        r6 = f1011a;
        r6 = r6[r0];
        r6 = r11.getString(r6);
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 != 0) goto L_0x0034;
    L_0x0031:
        r4.add(r6);
    L_0x0034:
        r0 = r0 + 1;
        goto L_0x0020;
    L_0x0037:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r10);
        r0 = r0.setTitle(r2);
        r2 = r0.setMessage(r3);
        r3 = r4.size();
        switch(r3) {
            case 1: goto L_0x0078;
            case 2: goto L_0x006e;
            case 3: goto L_0x0064;
            default: goto L_0x004b;
        };
    L_0x004b:
        r2 = r2.create();
        r0 = new com.chartboost.sdk.impl.bm$1;
        r1 = r9;
        r0.<init>(r1, r2, r3, r4, r5);
        r2.setOnShowListener(r0);
        r0 = new com.chartboost.sdk.impl.bm$2;
        r0.<init>(r9);
        r2.setOnCancelListener(r0);
        r2.show();
        return;
    L_0x0064:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r2.setNegativeButton(r0, r8);
    L_0x006e:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r2.setNeutralButton(r0, r8);
    L_0x0078:
        r0 = r4.get(r1);
        r0 = (java.lang.CharSequence) r0;
        r2.setPositiveButton(r0, r8);
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.bm.<init>(android.content.Context, android.os.Bundle, com.chartboost.sdk.impl.bm$b):void");
    }

    private static final Button[] m1033b(AlertDialog alertDialog) {
        ViewGroup viewGroup = (ViewGroup) alertDialog.getButton(-1).getParent();
        int childCount = viewGroup.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && (childAt instanceof Button)) {
                arrayList.add((Button) childAt);
            }
        }
        Button[] buttonArr = new Button[arrayList.size()];
        arrayList.toArray(buttonArr);
        return buttonArr;
    }
}
