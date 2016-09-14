package com.inmobi.signals.p007b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.inmobi.commons.p000a.SdkContext;
import com.inmobi.signals.SignalsComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.signals.b.b */
public class WifiInfoUtil {
    public static WifiInfo m2204a() {
        if (!WifiInfoUtil.m2215e() || !SignalsComponent.m5202a().m5207e().m2376l()) {
            return null;
        }
        int j = SignalsComponent.m5202a().m5207e().m2374j();
        return WifiInfoUtil.m2206a(WifiInfoUtil.m2208a(j), WifiInfoUtil.m2212b(j));
    }

    public static Map<String, String> m2211b() {
        WifiInfo a = WifiInfoUtil.m2204a();
        Map hashMap = new HashMap();
        if (a != null) {
            hashMap.put("c-ap-bssid", String.valueOf(a.m2195a()));
        }
        return hashMap;
    }

    private static boolean m2208a(int i) {
        return !WifiInfoUtil.m2209a(i, 2);
    }

    private static boolean m2212b(int i) {
        return WifiInfoUtil.m2209a(i, 1);
    }

    private static boolean m2215e() {
        String str = "android.permission.ACCESS_WIFI_STATE";
        if (SdkContext.m1562b().checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
            return false;
        }
        return true;
    }

    private static WifiInfo m2206a(boolean z, boolean z2) {
        WifiInfo connectionInfo = ((WifiManager) SdkContext.m1562b().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        String bssid = connectionInfo.getBSSID();
        String ssid = connectionInfo.getSSID();
        if (bssid == null || WifiInfoUtil.m2210a(z, ssid)) {
            return null;
        }
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.m2197a(WifiInfoUtil.m2202a(bssid));
        if (ssid != null && ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        if (z2) {
            ssid = null;
        }
        wifiInfo.m2198a(ssid);
        wifiInfo.m2196a(connectionInfo.getRssi());
        wifiInfo.m2200b(connectionInfo.getIpAddress());
        return wifiInfo;
    }

    private static boolean m2210a(boolean z, String str) {
        return z && str != null && str.endsWith("_nomap");
    }

    private static long m2202a(String str) {
        String str2 = ":";
        str2 = "\\:";
        String[] split = str.split("\\:");
        byte[] bArr = new byte[6];
        for (int i = 0; i < 6; i++) {
            bArr[i] = (byte) Integer.parseInt(split[i], 16);
        }
        return WifiInfoUtil.m2203a(bArr);
    }

    private static long m2203a(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            return 0;
        }
        return ((((WifiInfoUtil.m2201a(bArr[5]) | (WifiInfoUtil.m2201a(bArr[4]) << 8)) | (WifiInfoUtil.m2201a(bArr[3]) << 16)) | (WifiInfoUtil.m2201a(bArr[2]) << 24)) | (WifiInfoUtil.m2201a(bArr[1]) << 32)) | (WifiInfoUtil.m2201a(bArr[0]) << 40);
    }

    private static long m2201a(byte b) {
        return ((long) b) & 255;
    }

    private static boolean m2209a(int i, int i2) {
        return (i & i2) == i2;
    }

    public static boolean m2213c() {
        Context b = SdkContext.m1562b();
        for (String checkCallingOrSelfPermission : new String[]{"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"}) {
            if (b.checkCallingOrSelfPermission(checkCallingOrSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<WifiInfo> m2207a(List<ScanResult> list) {
        int j = SignalsComponent.m5202a().m5207e().m2374j();
        boolean a = WifiInfoUtil.m2208a(j);
        boolean b = WifiInfoUtil.m2212b(j);
        List arrayList = new ArrayList();
        if (list != null) {
            for (ScanResult scanResult : list) {
                if (!WifiInfoUtil.m2210a(a, scanResult.SSID)) {
                    arrayList.add(WifiInfoUtil.m2205a(scanResult, b));
                }
            }
        }
        return arrayList;
    }

    private static WifiInfo m2205a(ScanResult scanResult, boolean z) {
        String str = null;
        if (scanResult == null) {
            return null;
        }
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.m2197a(WifiInfoUtil.m2202a(scanResult.BSSID));
        if (!z) {
            str = scanResult.SSID;
        }
        wifiInfo.m2198a(str);
        wifiInfo.m2196a(scanResult.level);
        return wifiInfo;
    }

    public static Map<String, String> m2214d() {
        ArrayList arrayList = (ArrayList) WifiScanner.m2218a();
        Map hashMap = new HashMap();
        if (arrayList != null && arrayList.size() > 0) {
            hashMap.put("v-ap-bssid", String.valueOf(((WifiInfo) arrayList.get(arrayList.size() - 1)).m2195a()));
        }
        return hashMap;
    }
}
