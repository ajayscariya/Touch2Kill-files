package com.startapp.android.publish.p010d;

import com.startapp.android.publish.model.BaseRequest;
import com.startapp.android.publish.model.NameValueObject;
import com.wTouch2KiLL.server.StatController;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.startapp.android.publish.d.c */
public class StartAppSDK extends BaseRequest {
    private StartAppSDK f4949a;

    public StartAppSDK(StartAppSDK startAppSDK) {
        this.f4949a = startAppSDK;
    }

    public List<NameValueObject> getNameValueMap() {
        List nameValueMap = super.getNameValueMap();
        if (nameValueMap == null) {
            nameValueMap = new ArrayList();
        }
        Object a = com.startapp.android.publish.p022h.StartAppSDK.m3192a();
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, com.startapp.android.publish.p022h.StartAppSDK.f3309b, a, true);
        com.startapp.android.publish.p022h.StartAppSDK.m3318a(nameValueMap, com.startapp.android.publish.p022h.StartAppSDK.f3310c, com.startapp.android.publish.p022h.StartAppSDK.m3194b(a), true, false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "category", this.f4949a.m3020a().m3019a(), true);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "value", this.f4949a.m3022b(), true);
        com.startapp.android.publish.p022h.StartAppSDK.m3318a(nameValueMap, "d", this.f4949a.m3026d(), false, false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "orientation", this.f4949a.m3028e(), false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "usedRam", this.f4949a.m3029f(), false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "freeRam", this.f4949a.m3030g(), false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "sessionTime", this.f4949a.m3031h(), false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, "appActivity", this.f4949a.m3032i(), false);
        com.startapp.android.publish.p022h.StartAppSDK.m3317a(nameValueMap, StatController.KEY_GET_PARAM_DETAILS, this.f4949a.m3024c(), false);
        return nameValueMap;
    }
}
