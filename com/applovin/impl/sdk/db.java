package com.applovin.impl.sdk;

import org.json.JSONObject;

class db implements C0239p {
    final /* synthetic */ da f3951a;

    db(da daVar) {
        this.f3951a = daVar;
    }

    public void m4274a(int i) {
        this.f3951a.g.m306d("TaskReportReward", "Failed to report reward for ad: " + this.f3951a.f4826a.getAdIdNumber() + " - error code: " + i);
    }

    public void m4275a(JSONObject jSONObject, int i) {
        this.f3951a.g.m306d("TaskReportReward", "Reported reward successfully for ad: " + this.f3951a.f4826a.getAdIdNumber());
    }
}
