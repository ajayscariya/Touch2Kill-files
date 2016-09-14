package com.startapp.android.publish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.startapp.android.publish.model.AdPreferences.Placement;
import com.startapp.android.publish.p009c.StartAppSDK;
import mf.org.w3c.dom.traversal.NodeFilter;

/* compiled from: StartAppSDK */
public class OverlayActivity extends Activity {
    private StartAppSDK f2987a;
    private boolean f2988b;
    private int f2989c;
    private boolean f2990d;
    private Bundle f2991e;
    private boolean f2992f;
    private int f2993g;

    public OverlayActivity() {
        this.f2992f = false;
        this.f2993g = -1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        boolean z = true;
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra("videoAd", false);
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra("fullscreen", false) || booleanExtra) {
            getWindow().setFlags(NodeFilter.SHOW_DOCUMENT_FRAGMENT, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        }
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onCreate");
        this.f2990d = getIntent().getBooleanExtra("activityShouldLockOrientation", true);
        if (savedInstanceState == null && !booleanExtra) {
            com.startapp.android.publish.p022h.StartAppSDK.m3219a((Context) this).m3224a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
        }
        if (savedInstanceState != null) {
            this.f2993g = savedInstanceState.getInt("activityLockedOrientation", -1);
            this.f2990d = savedInstanceState.getBoolean("activityShouldLockOrientation", true);
        }
        this.f2989c = getIntent().getIntExtra("orientation", getResources().getConfiguration().orientation);
        if (getResources().getConfiguration().orientation == this.f2989c) {
            z = false;
        }
        this.f2988b = z;
        if (this.f2988b) {
            this.f2991e = savedInstanceState;
            return;
        }
        m2819a();
        this.f2987a.m2977a(savedInstanceState);
    }

    private void m2819a() {
        this.f2987a = StartAppSDK.m2965a(this, getIntent(), Placement.getByIndex(getIntent().getIntExtra("placement", 0)));
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.f2988b) {
            m2819a();
            this.f2987a.m2977a(this.f2991e);
            this.f2987a.m3003s();
            this.f2988b = false;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.f2987a == null || this.f2987a.m2983a(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onPause() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onPause");
        super.onPause();
        if (!this.f2988b) {
            this.f2987a.m3001q();
            com.startapp.android.publish.p022h.StartAppSDK.m3338c();
        }
        overridePendingTransition(0, 0);
    }

    protected void onSaveInstanceState(Bundle outState) {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onSaveInstanceState");
        super.onSaveInstanceState(outState);
        if (!this.f2988b) {
            this.f2987a.m2985b(outState);
            outState.putInt("activityLockedOrientation", this.f2993g);
            outState.putBoolean("activityShouldLockOrientation", this.f2990d);
        }
    }

    protected void onResume() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onResume");
        super.onResume();
        if (this.f2992f) {
            this.f2987a.m2986c();
        }
        if (this.f2993g == -1) {
            this.f2993g = com.startapp.android.publish.p022h.StartAppSDK.m3288a((Activity) this, this.f2989c, this.f2990d);
        } else {
            setRequestedOrientation(this.f2993g);
        }
        if (!this.f2988b) {
            this.f2987a.m3003s();
        }
    }

    protected void onStop() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onStop");
        super.onStop();
        if (!this.f2988b) {
            this.f2987a.m3002r();
        }
    }

    protected void onDestroy() {
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("AppWallActivity", 2, "AppWallActivity::onDestroy");
        if (!this.f2988b) {
            this.f2987a.m3004t();
            this.f2987a = null;
            com.startapp.android.publish.p022h.StartAppSDK.m3298a((Activity) this, false);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.f2987a.m3000p()) {
            super.onBackPressed();
        }
    }

    public void finish() {
        if (this.f2987a != null) {
            this.f2987a.m2999o();
        }
        super.finish();
    }
}
