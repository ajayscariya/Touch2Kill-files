package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

@zzhb
class zzjh {
    private final Object zzNm;
    private final List<Runnable> zzNn;
    private final List<Runnable> zzNo;
    private boolean zzNp;

    public zzjh() {
        this.zzNm = new Object();
        this.zzNn = new ArrayList();
        this.zzNo = new ArrayList();
        this.zzNp = false;
    }

    private void zzd(Runnable runnable) {
        zziq.zza(runnable);
    }

    private void zze(Runnable runnable) {
        zza.zzMS.post(runnable);
    }

    public void zzb(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zzd(runnable);
            } else {
                this.zzNn.add(runnable);
            }
        }
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zze(runnable);
            } else {
                this.zzNo.add(runnable);
            }
        }
    }

    public void zzhK() {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                return;
            }
            for (Runnable zzd : this.zzNn) {
                zzd(zzd);
            }
            for (Runnable zzd2 : this.zzNo) {
                zze(zzd2);
            }
            this.zzNn.clear();
            this.zzNo.clear();
            this.zzNp = true;
        }
    }
}
