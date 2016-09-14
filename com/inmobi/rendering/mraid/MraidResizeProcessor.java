package com.inmobi.rendering.mraid;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.rendering.CustomView;
import com.inmobi.rendering.CustomView.SwitchIconType;
import com.inmobi.rendering.RenderView;

/* renamed from: com.inmobi.rendering.mraid.k */
public final class MraidResizeProcessor {
    private static final String f2034a;
    private RenderView f2035b;
    private ViewGroup f2036c;
    private int f2037d;

    /* renamed from: com.inmobi.rendering.mraid.k.1 */
    class MraidResizeProcessor implements OnClickListener {
        final /* synthetic */ MraidResizeProcessor f2033a;

        MraidResizeProcessor(MraidResizeProcessor mraidResizeProcessor) {
            this.f2033a = mraidResizeProcessor;
        }

        public void onClick(View view) {
            this.f2033a.f2035b.m1981j();
        }
    }

    static {
        f2034a = MraidResizeProcessor.class.getSimpleName();
    }

    public MraidResizeProcessor(RenderView renderView) {
        this.f2035b = renderView;
    }

    public void m2134a() {
        if (this.f2036c == null) {
            this.f2036c = (ViewGroup) this.f2035b.getParent();
            this.f2037d = this.f2036c.indexOfChild(this.f2035b);
        }
        ResizeProperties resizeProperties = this.f2035b.getResizeProperties();
        m2133c();
        m2132a(resizeProperties);
    }

    private void m2133c() {
        View frameLayout = new FrameLayout(this.f2035b.getContext());
        LayoutParams layoutParams = new LayoutParams(this.f2035b.getWidth(), this.f2035b.getHeight());
        frameLayout.setId(SupportMenu.USER_MASK);
        this.f2036c.addView(frameLayout, this.f2037d, layoutParams);
        this.f2036c.removeView(this.f2035b);
    }

    private void m2132a(ResizeProperties resizeProperties) {
        float c = DisplayInfo.m1785a().m1801c();
        int i = (int) ((((float) resizeProperties.f2043b) * c) + 0.5f);
        int i2 = (int) ((c * ((float) resizeProperties.f2044c)) + 0.5f);
        FrameLayout frameLayout = (FrameLayout) this.f2036c.getRootView().findViewById(16908290);
        View frameLayout2 = new FrameLayout(this.f2035b.getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ViewGroup relativeLayout = new RelativeLayout(this.f2035b.getContext());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
        LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i2);
        frameLayout2.setId(65534);
        if (this.f2035b.getParent() != null) {
            ((ViewGroup) this.f2035b.getParent()).removeAllViews();
        }
        relativeLayout.addView(this.f2035b, layoutParams3);
        m2130a(relativeLayout, resizeProperties.f2042a);
        frameLayout2.addView(relativeLayout, layoutParams2);
        frameLayout.addView(frameLayout2, layoutParams);
        m2131a(frameLayout, frameLayout2, resizeProperties);
        frameLayout2.setBackgroundColor(0);
    }

    private void m2130a(ViewGroup viewGroup, String str) {
        float c = DisplayInfo.m1785a().m1801c();
        View customView = new CustomView(this.f2035b.getContext(), c, SwitchIconType.CLOSE_TRANSPARENT);
        customView.setId(65531);
        customView.setOnClickListener(new MraidResizeProcessor(this));
        viewGroup.addView(customView, m2127a(str, c));
    }

    private RelativeLayout.LayoutParams m2127a(String str, float f) {
        String a = m2129a(str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (50.0f * f), (int) (50.0f * f));
        if (a.equals("top-right") || a.equals("bottom-right")) {
            layoutParams.addRule(11);
        }
        if (a.equals("bottom-right") || a.equals("bottom-left") || a.equals("bottom-center")) {
            layoutParams.addRule(12);
            layoutParams.addRule(4);
        }
        if (a.equals("bottom-center") || a.equals("top-center") || a.equals("center")) {
            layoutParams.addRule(13);
        }
        if (a.equals("top-center")) {
            layoutParams.addRule(10);
        }
        return layoutParams;
    }

    private String m2129a(String str) {
        if (str == null || str.length() == 0) {
            return "top-right";
        }
        if (str.equals("top-left") || str.equals("top-right") || str.equals("bottom-left") || str.equals("bottom-right") || str.equals("top-center") || str.equals("bottom-center") || str.equals("center")) {
            return str;
        }
        return "top-right";
    }

    private void m2131a(FrameLayout frameLayout, FrameLayout frameLayout2, ResizeProperties resizeProperties) {
        float c = DisplayInfo.m1785a().m1801c();
        int i = (int) ((((float) resizeProperties.f2043b) * c) + 0.5f);
        int i2 = (int) ((((float) resizeProperties.f2044c) * c) + 0.5f);
        int i3 = (int) ((((float) resizeProperties.f2045d) * c) + 0.5f);
        int i4 = (int) ((c * ((float) resizeProperties.f2046e)) + 0.5f);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.f2036c.getLocationOnScreen(iArr);
        frameLayout.getLocationOnScreen(iArr2);
        iArr[1] = iArr[1] - iArr2[1];
        iArr[0] = iArr[0] - iArr2[0];
        iArr[0] = i3 + iArr[0];
        iArr[1] = i4 + iArr[1];
        if (!resizeProperties.f2047f) {
            if (i > frameLayout.getWidth() - iArr[0]) {
                iArr[0] = frameLayout.getWidth() - i;
            }
            if (i2 > frameLayout.getHeight() - iArr[1]) {
                iArr[1] = frameLayout.getHeight() - i2;
            }
            if (iArr[0] < 0) {
                iArr[0] = 0;
            }
            if (iArr[1] < 0) {
                iArr[1] = 0;
            }
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.gravity = GravityCompat.START;
        frameLayout2.setLayoutParams(layoutParams);
    }

    public void m2135b() {
        ViewGroup viewGroup = (ViewGroup) this.f2035b.getParent();
        View findViewById = viewGroup.getRootView().findViewById(65534);
        View findViewById2 = this.f2036c.getRootView().findViewById(SupportMenu.USER_MASK);
        ((ViewGroup) findViewById.getParent()).removeView(findViewById);
        ((ViewGroup) findViewById2.getParent()).removeView(findViewById2);
        viewGroup.removeView(this.f2035b);
        this.f2036c.addView(this.f2035b, this.f2037d, new RelativeLayout.LayoutParams(this.f2036c.getWidth(), this.f2036c.getHeight()));
        this.f2035b.m1984l();
    }
}
