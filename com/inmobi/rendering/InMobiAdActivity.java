package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.rendering.CustomView.SwitchIconType;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.wTouch2KiLL.C0866R;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import mf.org.w3c.dom.traversal.NodeFilter;

@SuppressLint({"ClickableViewAccessibility"})
public class InMobiAdActivity extends Activity {
    @SuppressLint({"UseSparseArrays"})
    public static Map<Integer, C0647b> f1716a;
    @SuppressLint({"UseSparseArrays"})
    public static Map<Integer, Intent> f1717b;
    public static Integer f1718c;
    private static final String f1719d;
    private static Stack<RenderView> f1720e;
    private static RenderView f1721f;
    private RenderView f1722g;
    private RenderView f1723h;
    private CustomView f1724i;
    private CustomView f1725j;
    private int f1726k;
    private boolean f1727l;

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.1 */
    class C06401 implements OnTouchListener {
        final /* synthetic */ InMobiAdActivity f1710a;

        C06401(InMobiAdActivity inMobiAdActivity) {
            this.f1710a = inMobiAdActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.setBackgroundColor(-7829368);
                this.f1710a.f1727l = true;
                this.f1710a.finish();
            } else if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.2 */
    class C06412 implements OnTouchListener {
        final /* synthetic */ InMobiAdActivity f1711a;

        C06412(InMobiAdActivity inMobiAdActivity) {
            this.f1711a = inMobiAdActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.setBackgroundColor(-7829368);
                this.f1711a.f1723h.reload();
            } else if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.3 */
    class C06423 implements OnTouchListener {
        final /* synthetic */ InMobiAdActivity f1712a;

        C06423(InMobiAdActivity inMobiAdActivity) {
            this.f1712a = inMobiAdActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.setBackgroundColor(-7829368);
                if (this.f1712a.f1723h.canGoBack()) {
                    this.f1712a.f1723h.goBack();
                } else {
                    this.f1712a.f1727l = true;
                    this.f1712a.finish();
                }
            } else if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.4 */
    class C06434 implements OnTouchListener {
        final /* synthetic */ InMobiAdActivity f1713a;

        C06434(InMobiAdActivity inMobiAdActivity) {
            this.f1713a = inMobiAdActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.setBackgroundColor(-7829368);
                if (this.f1713a.f1723h.canGoForward()) {
                    this.f1713a.f1723h.goForward();
                }
            } else if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.5 */
    class C06445 implements OnClickListener {
        final /* synthetic */ InMobiAdActivity f1714a;

        C06445(InMobiAdActivity inMobiAdActivity) {
            this.f1714a = inMobiAdActivity;
        }

        public void onClick(View view) {
            this.f1714a.f1727l = true;
            this.f1714a.f1722g.m1981j();
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.6 */
    class C06456 implements OnClickListener {
        final /* synthetic */ InMobiAdActivity f1715a;

        C06456(InMobiAdActivity inMobiAdActivity) {
            this.f1715a = inMobiAdActivity;
        }

        public void onClick(View view) {
            this.f1715a.f1727l = true;
            this.f1715a.f1722g.m1981j();
        }
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.a */
    public interface C0646a {
        void m1882a();

        void m1883b();
    }

    /* renamed from: com.inmobi.rendering.InMobiAdActivity.b */
    public interface C0647b {
        void m1884a(int i, Intent intent);
    }

    public InMobiAdActivity() {
        this.f1727l = false;
    }

    static {
        f1719d = InMobiAdActivity.class.getSimpleName();
        f1720e = new Stack();
        f1716a = new HashMap();
        f1717b = new HashMap();
        f1718c = Integer.valueOf(0);
    }

    public static int m1886a(RenderView renderView) {
        f1720e.push(renderView);
        return f1720e.indexOf(renderView);
    }

    public static RenderView m1887a() {
        return (RenderView) f1720e.peek();
    }

    public static void m1893b(RenderView renderView) {
        f1721f = renderView;
    }

    public static int m1885a(Intent intent, C0647b c0647b) {
        Integer num = f1718c;
        f1718c = Integer.valueOf(f1718c.intValue() + 1);
        f1716a.put(f1718c, c0647b);
        f1717b.put(f1718c, intent);
        return f1718c.intValue();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1726k = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkboxStyle);
        if (this.f1726k == 100) {
            String stringExtra = getIntent().getStringExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
            this.f1723h = new RenderView(this, new RenderingProperties(PlacementType.FULL_SCREEN));
            this.f1723h.m1943a(f1721f.getListener(), f1721f.getRenderingConfig(), f1721f.getMraidConfig());
            m1892b();
            this.f1723h.loadUrl(stringExtra);
            this.f1723h.getListener().m1905e(this.f1723h);
            this.f1723h.setFullScreenActivity(this);
        } else if (this.f1726k == C0866R.styleable.Theme_checkboxStyle) {
            int intExtra = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", -1);
            if (intExtra != -1) {
                if (getIntent().getBooleanExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false)) {
                    requestWindowFeature(1);
                    getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
                }
                this.f1722g = (RenderView) f1720e.get(intExtra);
                m1894c();
                this.f1722g.setFullScreenActivity(this);
                if (this.f1722g.getAdScreenEventsListener() != null) {
                    this.f1722g.getAdScreenEventsListener().m1882a();
                }
            }
        } else if (this.f1726k == C0866R.styleable.Theme_checkedTextViewStyle) {
            int intExtra2 = getIntent().getIntExtra("id", -1);
            if (intExtra2 == -1) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1719d, "Invalid Request Code Supplied");
            } else {
                startActivityForResult((Intent) f1717b.get(Integer.valueOf(intExtra2)), intExtra2);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1723h != null) {
            this.f1723h.m1983k();
        }
    }

    private void m1892b() {
        ViewGroup relativeLayout = new RelativeLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        layoutParams.addRule(2, 65533);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(this.f1723h, layoutParams);
        m1889a(relativeLayout);
        setContentView(relativeLayout);
    }

    private void m1889a(ViewGroup viewGroup) {
        float c = DisplayInfo.m1785a().m1801c();
        View linearLayout = new LinearLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (48.0f * c));
        linearLayout.setOrientation(0);
        linearLayout.setId(65533);
        linearLayout.setWeightSum(100.0f);
        linearLayout.setBackgroundResource(17301658);
        linearLayout.setBackgroundColor(-7829368);
        layoutParams.addRule(12);
        viewGroup.addView(linearLayout, layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 25.0f;
        View customView = new CustomView(this, c, SwitchIconType.CLOSE_ICON);
        customView.setOnTouchListener(new C06401(this));
        linearLayout.addView(customView, layoutParams);
        customView = new CustomView(this, c, SwitchIconType.REFRESH);
        customView.setOnTouchListener(new C06412(this));
        linearLayout.addView(customView, layoutParams);
        customView = new CustomView(this, c, SwitchIconType.BACK);
        customView.setOnTouchListener(new C06423(this));
        linearLayout.addView(customView, layoutParams);
        customView = new CustomView(this, c, SwitchIconType.FORWARD_INACTIVE);
        customView.setOnTouchListener(new C06434(this));
        linearLayout.addView(customView, layoutParams);
    }

    private void m1894c() {
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        View relativeLayout = new RelativeLayout(this);
        float c = DisplayInfo.m1785a().m1801c();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        if (this.f1722g.getParent() != null) {
            ((ViewGroup) this.f1722g.getParent()).removeView(this.f1722g);
        }
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (50.0f * c), (int) (50.0f * c));
        layoutParams2.addRule(11);
        this.f1724i = new CustomView(this, c, SwitchIconType.CLOSE_BUTTON);
        this.f1724i.setId(65532);
        this.f1724i.setOnClickListener(new C06445(this));
        this.f1725j = new CustomView(this, c, SwitchIconType.CLOSE_TRANSPARENT);
        this.f1725j.setId(65531);
        this.f1725j.setOnClickListener(new C06456(this));
        relativeLayout.setId(65534);
        relativeLayout.addView(this.f1722g, layoutParams);
        relativeLayout.addView(this.f1724i, layoutParams2);
        relativeLayout.addView(this.f1725j, layoutParams2);
        relativeLayout.setBackgroundColor(0);
        frameLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f1722g.m1951a(this.f1722g.m1970e());
        this.f1722g.m1957b(this.f1722g.m1967d());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.f1727l) {
            return;
        }
        if (this.f1726k == 100) {
            this.f1723h.getListener().m1906f(this.f1723h);
            this.f1723h.destroy();
        } else if (this.f1726k == C0866R.styleable.Theme_checkboxStyle) {
            if (this.f1722g.getAdScreenEventsListener() != null) {
                this.f1722g.getAdScreenEventsListener().m1883b();
            }
            f1720e.pop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0647b c0647b = (C0647b) f1716a.get(Integer.valueOf(i));
        f1716a.remove(Integer.valueOf(i));
        f1717b.remove(Integer.valueOf(i));
        c0647b.m1884a(i2, intent);
        this.f1727l = true;
        finish();
    }

    void m1895a(boolean z) {
        this.f1727l = z;
    }

    public void onBackPressed() {
        if (this.f1726k == C0866R.styleable.Theme_checkboxStyle) {
            this.f1722g.m1977h();
            if (!this.f1722g.m1972f()) {
                this.f1727l = true;
                this.f1722g.m1981j();
            }
        } else if (this.f1726k == 100) {
            this.f1727l = true;
            finish();
        }
    }
}
