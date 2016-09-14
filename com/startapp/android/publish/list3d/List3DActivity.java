package com.startapp.android.publish.list3d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.model.MetaData;
import java.util.List;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;

/* compiled from: StartAppSDK */
public class List3DActivity extends Activity implements StartAppSDK {
    private StartAppSDK f4744a;
    private ProgressDialog f4745b;
    private WebView f4746c;
    private List<ListItem> f4747d;
    private int f4748e;
    private String f4749f;
    private com.startapp.android.publish.adinformation.StartAppSDK f4750g;
    private Long f4751h;
    private String f4752i;
    private String f4753j;
    private BroadcastReceiver f4754k;

    /* renamed from: com.startapp.android.publish.list3d.List3DActivity.1 */
    class StartAppSDK extends BroadcastReceiver {
        final /* synthetic */ List3DActivity f3399a;

        StartAppSDK(List3DActivity list3DActivity) {
            this.f3399a = list3DActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3399a.finish();
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.List3DActivity.2 */
    class StartAppSDK implements OnItemClickListener {
        final /* synthetic */ List3DActivity f3401a;

        /* renamed from: com.startapp.android.publish.list3d.List3DActivity.2.1 */
        class StartAppSDK implements Runnable {
            final /* synthetic */ StartAppSDK f3400a;

            StartAppSDK(StartAppSDK startAppSDK) {
                this.f3400a = startAppSDK;
            }

            public void run() {
                this.f3400a.f3401a.finish();
            }
        }

        StartAppSDK(List3DActivity list3DActivity) {
            this.f3401a = list3DActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String b = ((ListItem) this.f3401a.f4747d.get(position)).m3388b();
            String d = ((ListItem) this.f3401a.f4747d.get(position)).m3390d();
            String e = ((ListItem) this.f3401a.f4747d.get(position)).m3391e();
            boolean k = ((ListItem) this.f3401a.f4747d.get(position)).m3397k();
            boolean l = ((ListItem) this.f3401a.f4747d.get(position)).m3398l();
            Object o = ((ListItem) this.f3401a.f4747d.get(position)).m3401o();
            String n = ((ListItem) this.f3401a.f4747d.get(position)).m3400n();
            if (o != null && !TextUtils.isEmpty(o)) {
                m3384a(o, n, b, d);
            } else if (!TextUtils.isEmpty(b)) {
                if (k) {
                    com.startapp.android.publish.p022h.StartAppSDK.m3306a(this.f3401a, b, d, e, new com.startapp.android.publish.p022h.StartAppSDK(this.f3401a.f4749f), MetaData.getInstance().getSmartRedirectTimeout(), l, new StartAppSDK(this));
                    return;
                }
                com.startapp.android.publish.p022h.StartAppSDK.m3303a(this.f3401a, b, d, new com.startapp.android.publish.p022h.StartAppSDK(this.f3401a.f4749f), l);
                this.f3401a.finish();
            }
        }

        private void m3384a(String str, String str2, String str3, String str4) {
            com.startapp.android.publish.p022h.StartAppSDK.m3316a(str, str2, str3, this.f3401a, new com.startapp.android.publish.p022h.StartAppSDK(this.f3401a.f4749f));
            this.f3401a.finish();
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.List3DActivity.3 */
    class StartAppSDK implements OnClickListener {
        final /* synthetic */ List3DActivity f3402a;

        StartAppSDK(List3DActivity list3DActivity) {
            this.f3402a = list3DActivity;
        }

        public void onClick(View v) {
            this.f3402a.finish();
        }
    }

    /* renamed from: com.startapp.android.publish.list3d.List3DActivity.4 */
    class StartAppSDK implements Runnable {
        final /* synthetic */ List3DActivity f3403a;

        StartAppSDK(List3DActivity list3DActivity) {
            this.f3403a = list3DActivity;
        }

        public void run() {
            this.f3403a.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    public List3DActivity() {
        this.f4745b = null;
        this.f4746c = null;
        this.f4754k = new StartAppSDK(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("fullscreen", false)) {
            requestWindowFeature(1);
            getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        }
        if (savedInstanceState == null) {
            com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3224a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
            this.f4751h = (Long) getIntent().getSerializableExtra("lastLoadTime");
        } else if (savedInstanceState.containsKey("lastLoadTime")) {
            this.f4751h = (Long) savedInstanceState.getSerializable("lastLoadTime");
        }
        this.f4752i = getIntent().getStringExtra("position");
        this.f4753j = getIntent().getStringExtra("listModelUuid");
        com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3223a(this.f4754k, new IntentFilter("com.startapp.android.CloseAdActivity"));
        this.f4748e = getResources().getConfiguration().orientation;
        com.startapp.android.publish.p022h.StartAppSDK.m3298a((Activity) this, true);
        boolean booleanExtra = getIntent().getBooleanExtra("overlay", false);
        requestWindowFeature(1);
        this.f4749f = getIntent().getStringExtra("adTag");
        int backgroundGradientTop = MetaData.getInstance().getBackgroundGradientTop();
        int backgroundGradientBottom = MetaData.getInstance().getBackgroundGradientBottom();
        this.f4744a = new StartAppSDK(this, null, this.f4749f, this.f4753j);
        this.f4744a.setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{backgroundGradientTop, backgroundGradientBottom}));
        this.f4747d = StartAppSDK.m3487a().m3488a(this.f4753j).m3486b();
        if (this.f4747d == null) {
            finish();
            return;
        }
        View imageButton;
        String str = XMLConstants.NULL_NS_URI;
        if (booleanExtra) {
            com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3223a(this.f4744a.f3443a, new IntentFilter("com.startapp.android.Activity3DGetValues"));
        } else {
            this.f4744a.m3470a();
            this.f4744a.setHint(true);
            this.f4744a.setFade(true);
            str = "back";
        }
        Adapter startAppSDK = new StartAppSDK(this, this.f4747d, str, this.f4749f, this.f4753j);
        StartAppSDK.m3487a().m3488a(this.f4753j).m3483a(this, !booleanExtra);
        this.f4744a.setAdapter(startAppSDK);
        this.f4744a.setDynamics(new SimpleDynamics(0.9f, 0.6f));
        this.f4744a.setOnItemClickListener(new StartAppSDK(this));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setContentDescription("StartApp Ad");
        relativeLayout.setId(com.startapp.android.publish.StartAppSDK.STARTAPP_AD_MAIN_LAYOUT_ID);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        relativeLayout.addView(linearLayout, layoutParams2);
        View relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout2.setBackgroundColor(MetaData.getInstance().getTitleBackgroundColor().intValue());
        linearLayout.addView(relativeLayout2);
        TextView textView = new TextView(this);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        textView.setLayoutParams(layoutParams3);
        textView.setPadding(0, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 2), 0, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 5));
        textView.setTextColor(MetaData.getInstance().getTitleTextColor().intValue());
        textView.setTextSize((float) MetaData.getInstance().getTitleTextSize().intValue());
        textView.setSingleLine(true);
        textView.setEllipsize(TruncateAt.END);
        textView.setText(MetaData.getInstance().getTitleContent());
        textView.setShadowLayer(2.5f, -2.0f, 2.0f, -11513776);
        com.startapp.android.publish.p022h.StartAppSDK.m3276a(textView, MetaData.getInstance().getTitleTextDecoration());
        relativeLayout2.addView(textView);
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        Bitmap a = com.startapp.android.publish.p022h.StartAppSDK.m3198a(this, "close_button.png");
        if (a != null) {
            imageButton = new ImageButton(this, null, 16973839);
            ((ImageButton) imageButton).setImageBitmap(Bitmap.createScaledBitmap(a, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 36), com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 36), true));
        } else {
            imageButton = new TextView(this);
            ((TextView) imageButton).setText("   x   ");
            ((TextView) imageButton).setTextSize(20.0f);
        }
        imageButton.setLayoutParams(layoutParams4);
        imageButton.setOnClickListener(new StartAppSDK(this));
        imageButton.setContentDescription("x");
        imageButton.setId(com.startapp.android.publish.StartAppSDK.LIST_3D_CLOSE_BUTTON_ID);
        relativeLayout2.addView(imageButton);
        View view = new View(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 2)));
        view.setBackgroundColor(MetaData.getInstance().getTitleLineColor().intValue());
        linearLayout.addView(view);
        layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f4744a.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f4744a);
        view = new LinearLayout(this);
        layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 80;
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(MetaData.getInstance().getPoweredByBackgroundColor().intValue());
        view.setGravity(17);
        linearLayout.addView(view);
        imageButton = new TextView(this);
        imageButton.setTextColor(MetaData.getInstance().getPoweredByTextColor().intValue());
        imageButton.setPadding(0, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 2), 0, com.startapp.android.publish.p022h.StartAppSDK.m3270a((Context) this, 3));
        imageButton.setText("Powered By ");
        imageButton.setTextSize(16.0f);
        view.addView(imageButton);
        imageButton = new ImageView(this);
        imageButton.setImageBitmap(com.startapp.android.publish.p022h.StartAppSDK.m3198a(this, "logo.png"));
        view.addView(imageButton);
        this.f4750g = new com.startapp.android.publish.adinformation.StartAppSDK(this, com.startapp.android.publish.adinformation.StartAppSDK.StartAppSDK.LARGE, Placement.INAPP_OFFER_WALL, (com.startapp.android.publish.adinformation.StartAppSDK) getIntent().getSerializableExtra("adInfoOverride"));
        this.f4750g.m2852a(relativeLayout);
        setContentView(relativeLayout, layoutParams);
        new Handler().postDelayed(new StartAppSDK(this), 500);
    }

    protected void onResume() {
        super.onResume();
        if (m5474b()) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("List3DActivity", 3, "Cache TTL passed, finishing");
            finish();
            return;
        }
        com.startapp.android.publish.StartAppSDK.m3103a().m3117a(true);
    }

    protected void onDestroy() {
        if (this.f4745b != null) {
            synchronized (this.f4745b) {
                if (this.f4745b != null) {
                    this.f4745b.dismiss();
                    this.f4745b = null;
                }
            }
        }
        if (this.f4746c != null) {
            this.f4746c.stopLoading();
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3298a((Activity) this, false);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.f4750g != null && this.f4750g.m2853b()) {
            this.f4750g.m2854c();
        }
        overridePendingTransition(0, 0);
        if (this.f4752i != null && this.f4752i.equals("back")) {
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f4751h != null) {
            outState.putSerializable("lastLoadTime", this.f4751h);
        }
    }

    public void m5475a(int i) {
        View childAt = this.f4744a.getChildAt(i - this.f4744a.getFirstItemPosition());
        if (childAt != null) {
            StartAppSDK startAppSDK = (StartAppSDK) childAt.getTag();
            StartAppSDK a = StartAppSDK.m3487a().m3488a(this.f4753j);
            if (a != null && a.m3486b() != null && i < a.m3486b().size()) {
                ListItem listItem = (ListItem) a.m3486b().get(i);
                startAppSDK.m3476b().setImageBitmap(a.m3480a(i, listItem.m3387a(), listItem.m3394h()));
                startAppSDK.m3476b().requestLayout();
                startAppSDK.m3475a(listItem.m3402p());
            }
        }
    }

    public void finish() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("List3DActivity", 2, "Finishing activity.");
        com.startapp.android.publish.StartAppSDK.m3103a().m3117a(false);
        m5472a();
        synchronized (this) {
            if (this.f4754k != null) {
                com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3222a(this.f4754k);
                this.f4754k = null;
            }
        }
        if (!com.startapp.android.publish.StartAppSDK.OVERRIDE_NETWORK.booleanValue()) {
            StartAppSDK.m3487a().m3489b(this.f4753j);
        }
        super.finish();
    }

    private void m5472a() {
        if (this.f4748e == getResources().getConfiguration().orientation) {
            com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3224a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
        }
    }

    private boolean m5474b() {
        if (this.f4751h == null || System.currentTimeMillis() - this.f4751h.longValue() <= MetaData.getInstance().getACMConfig().getAdCacheTtl()) {
            return false;
        }
        return true;
    }
}
