package com.inmobi.signals.p006a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.dom3.as.ASContentModel;
import org.json.JSONObject;

/* renamed from: com.inmobi.signals.a.b */
public class CellTowerInfo {
    private static final String f2063a;
    private String f2064b;
    private int f2065c;
    private int f2066d;

    static {
        f2063a = CellTowerInfo.class.getSimpleName();
    }

    @TargetApi(18)
    public CellTowerInfo(CellInfo cellInfo, String str, String str2, int i) {
        if (cellInfo instanceof CellInfoGsm) {
            this.f2066d = i;
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            this.f2065c = cellInfoGsm.getCellSignalStrength().getDbm();
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            this.f2064b = m2156a(str, str2, cellIdentity.getLac(), cellIdentity.getCid(), -1, ASContentModel.AS_UNBOUNDED);
        } else if (cellInfo instanceof CellInfoCdma) {
            this.f2066d = i;
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            this.f2065c = cellInfoCdma.getCellSignalStrength().getDbm();
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            this.f2064b = m2155a(str, cellIdentity2.getSystemId(), cellIdentity2.getNetworkId(), cellIdentity2.getBasestationId());
        } else if (VERSION.SDK_INT >= 18) {
            if (cellInfo instanceof CellInfoWcdma) {
                this.f2066d = i;
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                this.f2065c = cellInfoWcdma.getCellSignalStrength().getDbm();
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                this.f2064b = m2156a(str, str2, cellIdentity3.getLac(), cellIdentity3.getCid(), cellIdentity3.getPsc(), ASContentModel.AS_UNBOUNDED);
            }
        } else if (cellInfo instanceof CellInfoLte) {
            this.f2066d = i;
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
            this.f2065c = cellInfoLte.getCellSignalStrength().getDbm();
            CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
            this.f2064b = m2156a(str, str2, cellIdentity4.getTac(), cellIdentity4.getCi(), -1, cellIdentity4.getPci());
        }
    }

    public String m2155a(String str, int i, int i2, int i3) {
        return str + "#" + i + "#" + i2 + "#" + i3;
    }

    public String m2156a(String str, String str2, int i, int i2, int i3, int i4) {
        return str + "#" + str2 + "#" + i + "#" + i2 + "#" + (i3 == -1 ? XMLConstants.NULL_NS_URI : Integer.valueOf(i3)) + "#" + (i4 == ASContentModel.AS_UNBOUNDED ? XMLConstants.NULL_NS_URI : Integer.valueOf(i4));
    }

    public void m2158a(int i) {
        this.f2066d = i;
    }

    public void m2159a(String str) {
        this.f2064b = str;
    }

    public void m2160b(int i) {
        this.f2065c = i;
    }

    public JSONObject m2157a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f2064b);
            if (this.f2065c != ASContentModel.AS_UNBOUNDED) {
                jSONObject.put("ss", this.f2065c);
            }
            jSONObject.put("nt", this.f2066d);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f2063a, "Error while converting CellTowerInfo to string.", e);
        }
        return jSONObject;
    }
}
