package com.inmobi.rendering.mraid;

import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import com.wTouch2KiLL.C0866R;

/* renamed from: com.inmobi.rendering.mraid.h */
public final class MraidExpandProcessor {
    private static final String f2021a;
    private RenderView f2022b;
    private boolean f2023c;
    private ViewGroup f2024d;
    private int f2025e;

    static {
        f2021a = MraidExpandProcessor.class.getSimpleName();
    }

    public MraidExpandProcessor(RenderView renderView) {
        this.f2022b = renderView;
        this.f2023c = false;
    }

    public void m2117a(String str, String str2) {
        if (this.f2024d == null) {
            this.f2024d = (ViewGroup) this.f2022b.getParent();
            this.f2025e = this.f2024d.indexOfChild(this.f2022b);
        }
        if (this.f2022b == null) {
            Logger.m1744a(InternalLogLevel.INTERNAL, f2021a, "Please check if the MRAID processor was initialized correctly.");
            return;
        }
        int a;
        ExpandProperties expandProperties = this.f2022b.getExpandProperties();
        this.f2023c = URLUtil.isValidUrl(str2);
        if (this.f2023c) {
            RenderView renderView = new RenderView(this.f2022b.getContext(), new RenderingProperties(PlacementType.INLINE));
            renderView.m1943a(this.f2022b.getListener(), this.f2022b.getRenderingConfig(), this.f2022b.getMraidConfig());
            renderView.setOriginalRenderView(this.f2022b);
            renderView.loadUrl(str2);
            a = InMobiAdActivity.m1886a(renderView);
        } else {
            m2115b();
            a = InMobiAdActivity.m1886a(this.f2022b);
        }
        Intent intent = new Intent(this.f2022b.getContext(), InMobiAdActivity.class);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", C0866R.styleable.Theme_checkboxStyle);
        intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", a);
        this.f2022b.getContext().startActivity(intent);
        if (expandProperties != null) {
            InMobiAdActivity.m1887a().setUseCustomClose(this.f2022b.m1967d());
        }
    }

    private void m2115b() {
        View frameLayout = new FrameLayout(this.f2022b.getContext());
        LayoutParams layoutParams = new LayoutParams(this.f2022b.getWidth(), this.f2022b.getHeight());
        frameLayout.setId(SupportMenu.USER_MASK);
        this.f2024d.addView(frameLayout, this.f2025e, layoutParams);
        this.f2024d.removeView(this.f2022b);
    }

    public void m2116a() {
        if (this.f2022b.getOriginalRenderView() == null) {
            View findViewById = this.f2024d.getRootView().findViewById(SupportMenu.USER_MASK);
            ((ViewGroup) this.f2022b.getParent()).removeView(this.f2022b);
            ((ViewGroup) findViewById.getParent()).removeView(findViewById);
            this.f2024d.addView(this.f2022b, this.f2025e, new RelativeLayout.LayoutParams(this.f2024d.getWidth(), this.f2024d.getHeight()));
            this.f2022b.m1984l();
        }
    }
}
