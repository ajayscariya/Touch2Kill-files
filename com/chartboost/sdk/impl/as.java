package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.C0271e.C0269a;
import com.chartboost.sdk.Libraries.CBLogging;

public class as extends ar {
    private aw f4873a;
    private Button f4874b;
    private bh f4875c;
    private C0269a f4876d;

    /* renamed from: com.chartboost.sdk.impl.as.1 */
    class C03371 implements OnClickListener {
        final /* synthetic */ as f821a;

        C03371(as asVar) {
            this.f821a = asVar;
        }

        public void onClick(View v) {
            this.f821a.m5774c();
        }
    }

    /* renamed from: com.chartboost.sdk.impl.as.2 */
    class C03382 implements OnCompletionListener {
        final /* synthetic */ as f822a;

        C03382(as asVar) {
            this.f822a = asVar;
        }

        public void onCompletion(MediaPlayer arg0) {
            bi.m1004a(false, this.f822a.f4875c);
        }
    }

    public as(aw awVar, Context context) {
        super(awVar, context);
        this.f4873a = awVar;
        this.f4874b = new Button(context);
        this.f4874b.setTextColor(-14571545);
        this.f4874b.setText("Preview");
        this.f4874b.setOnClickListener(new C03371(this));
        addView(this.f4874b, 2);
    }

    public void m5775a(C0269a c0269a, int i) {
        super.m4514a(c0269a, i);
        this.f4876d = c0269a;
    }

    private void m5774c() {
        CBLogging.m383c(this, "play the video");
        if (this.f4875c == null) {
            this.f4875c = new bh(getContext());
            this.f4873a.m783e().addView(this.f4875c, new LayoutParams(-1, -1));
            this.f4875c.setVisibility(8);
        }
        this.f4875c.m999a().m988a(new C03382(this));
        bi.m1004a(true, this.f4875c);
        this.f4875c.m999a().m985a();
    }
}
