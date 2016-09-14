package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.internal.C0612n;
import com.google.android.youtube.player.internal.C0622t.C0620a;
import com.google.android.youtube.player.internal.C0622t.C0621b;
import com.google.android.youtube.player.internal.C0627y;
import com.google.android.youtube.player.internal.C1382b;
import com.google.android.youtube.player.internal.C1405s;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {
    private final C0599a f4254a;
    private final Set<View> f4255b;
    private final C0600b f4256c;
    private C1382b f4257d;
    private C1405s f4258e;
    private View f4259f;
    private C0612n f4260g;
    private Provider f4261h;
    private Bundle f4262i;
    private OnInitializedListener f4263j;
    private boolean f4264k;
    private boolean f4265l;

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.a */
    private final class C0599a implements OnGlobalFocusChangeListener {
        final /* synthetic */ YouTubePlayerView f1175a;

        private C0599a(YouTubePlayerView youTubePlayerView) {
            this.f1175a = youTubePlayerView;
        }

        public final void onGlobalFocusChanged(View view, View view2) {
            if (this.f1175a.f4258e != null && this.f1175a.f4255b.contains(view2) && !this.f1175a.f4255b.contains(view)) {
                this.f1175a.f4258e.m4905g();
            }
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.b */
    interface C0600b {
        void m1171a(YouTubePlayerView youTubePlayerView);

        void m1172a(YouTubePlayerView youTubePlayerView, String str, OnInitializedListener onInitializedListener);
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.1 */
    class C13781 implements C0620a {
        final /* synthetic */ Activity f4251a;
        final /* synthetic */ YouTubePlayerView f4252b;

        C13781(YouTubePlayerView youTubePlayerView, Activity activity) {
            this.f4252b = youTubePlayerView;
            this.f4251a = activity;
        }

        public final void m4747a() {
            if (this.f4252b.f4257d != null) {
                YouTubePlayerView.m4753a(this.f4252b, this.f4251a);
            }
            this.f4252b.f4257d = null;
        }

        public final void m4748b() {
            if (!(this.f4252b.f4265l || this.f4252b.f4258e == null)) {
                this.f4252b.f4258e.m4904f();
            }
            this.f4252b.f4260g.m1258a();
            if (this.f4252b.indexOfChild(this.f4252b.f4260g) < 0) {
                this.f4252b.addView(this.f4252b.f4260g);
                this.f4252b.removeView(this.f4252b.f4259f);
            }
            this.f4252b.f4259f = null;
            this.f4252b.f4258e = null;
            this.f4252b.f4257d = null;
        }
    }

    /* renamed from: com.google.android.youtube.player.YouTubePlayerView.2 */
    class C13792 implements C0621b {
        final /* synthetic */ YouTubePlayerView f4253a;

        C13792(YouTubePlayerView youTubePlayerView) {
            this.f4253a = youTubePlayerView;
        }

        public final void m4749a(YouTubeInitializationResult youTubeInitializationResult) {
            this.f4253a.m4752a(youTubeInitializationResult);
            this.f4253a.f4257d = null;
        }
    }

    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        if (context instanceof YouTubeBaseActivity) {
            this(context, attributeSet, i, ((YouTubeBaseActivity) context).m1164a());
            return;
        }
        throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
    }

    YouTubePlayerView(Context context, AttributeSet attributeSet, int i, C0600b c0600b) {
        super((Context) ab.m1184a((Object) context, (Object) "context cannot be null"), attributeSet, i);
        this.f4256c = (C0600b) ab.m1184a((Object) c0600b, (Object) "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        setClipToPadding(false);
        this.f4260g = new C0612n(context);
        requestTransparentRegion(this.f4260g);
        addView(this.f4260g);
        this.f4255b = new HashSet();
        this.f4254a = new C0599a();
    }

    private void m4751a(View view) {
        Object obj = (view == this.f4260g || (this.f4258e != null && view == this.f4259f)) ? 1 : null;
        if (obj == null) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    private void m4752a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f4258e = null;
        this.f4260g.m1260c();
        if (this.f4263j != null) {
            this.f4263j.onInitializationFailure(this.f4261h, youTubeInitializationResult);
            this.f4263j = null;
        }
    }

    static /* synthetic */ void m4753a(YouTubePlayerView youTubePlayerView, Activity activity) {
        try {
            youTubePlayerView.f4258e = new C1405s(youTubePlayerView.f4257d, aa.m1178a().m1182a(activity, youTubePlayerView.f4257d, youTubePlayerView.f4264k));
            youTubePlayerView.f4259f = youTubePlayerView.f4258e.m4893a();
            youTubePlayerView.addView(youTubePlayerView.f4259f);
            youTubePlayerView.removeView(youTubePlayerView.f4260g);
            youTubePlayerView.f4256c.m1171a(youTubePlayerView);
            if (youTubePlayerView.f4263j != null) {
                boolean z = false;
                if (youTubePlayerView.f4262i != null) {
                    z = youTubePlayerView.f4258e.m4897a(youTubePlayerView.f4262i);
                    youTubePlayerView.f4262i = null;
                }
                youTubePlayerView.f4263j.onInitializationSuccess(youTubePlayerView.f4261h, youTubePlayerView.f4258e, z);
                youTubePlayerView.f4263j = null;
            }
        } catch (Throwable e) {
            C0627y.m1274a("Error creating YouTubePlayerView", e);
            youTubePlayerView.m4752a(YouTubeInitializationResult.INTERNAL_ERROR);
        }
    }

    final void m4763a() {
        if (this.f4258e != null) {
            this.f4258e.m4898b();
        }
    }

    final void m4764a(Activity activity, Provider provider, String str, OnInitializedListener onInitializedListener, Bundle bundle) {
        if (this.f4258e == null && this.f4263j == null) {
            ab.m1184a((Object) activity, (Object) "activity cannot be null");
            this.f4261h = (Provider) ab.m1184a((Object) provider, (Object) "provider cannot be null");
            this.f4263j = (OnInitializedListener) ab.m1184a((Object) onInitializedListener, (Object) "listener cannot be null");
            this.f4262i = bundle;
            this.f4260g.m1259b();
            this.f4257d = aa.m1178a().m1181a(getContext(), str, new C13781(this, activity), new C13792(this));
            this.f4257d.m1268e();
        }
    }

    final void m4765a(boolean z) {
        if (!z || VERSION.SDK_INT >= 14) {
            this.f4264k = z;
            return;
        }
        C0627y.m1275a("Could not enable TextureView because API level is lower than 14", new Object[0]);
        this.f4264k = false;
    }

    public final void addFocusables(ArrayList<View> arrayList, int i) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i);
        arrayList.addAll(arrayList2);
        this.f4255b.clear();
        this.f4255b.addAll(arrayList2);
    }

    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        arrayList.addAll(arrayList2);
        this.f4255b.clear();
        this.f4255b.addAll(arrayList2);
    }

    public final void addView(View view) {
        m4751a(view);
        super.addView(view);
    }

    public final void addView(View view, int i) {
        m4751a(view);
        super.addView(view, i);
    }

    public final void addView(View view, int i, int i2) {
        m4751a(view);
        super.addView(view, i, i2);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        m4751a(view);
        super.addView(view, i, layoutParams);
    }

    public final void addView(View view, LayoutParams layoutParams) {
        m4751a(view);
        super.addView(view, layoutParams);
    }

    final void m4766b() {
        if (this.f4258e != null) {
            this.f4258e.m4901c();
        }
    }

    final void m4767b(boolean z) {
        if (this.f4258e != null) {
            this.f4258e.m4899b(z);
            m4769c(z);
        }
    }

    final void m4768c() {
        if (this.f4258e != null) {
            this.f4258e.m4902d();
        }
    }

    final void m4769c(boolean z) {
        this.f4265l = true;
        if (this.f4258e != null) {
            this.f4258e.m4895a(z);
        }
    }

    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    final void m4770d() {
        if (this.f4258e != null) {
            this.f4258e.m4903e();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f4258e != null) {
            if (keyEvent.getAction() == 0) {
                return this.f4258e.m4896a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            } else {
                if (keyEvent.getAction() == 1) {
                    return this.f4258e.m4900b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    final Bundle m4771e() {
        return this.f4258e == null ? this.f4262i : this.f4258e.m4906h();
    }

    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.f4255b.add(view);
    }

    public final void initialize(String str, OnInitializedListener onInitializedListener) {
        ab.m1185a(str, (Object) "Developer key cannot be null or empty");
        this.f4256c.m1172a(this, str, onInitializedListener);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f4254a);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f4258e != null) {
            this.f4258e.m4894a(configuration);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f4254a);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i, i2);
            setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f4255b.add(view2);
    }

    public final void setClipToPadding(boolean z) {
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
    }
}
