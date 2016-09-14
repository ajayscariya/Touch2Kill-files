package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzhb
public abstract class zzby {
    @zzhb
    public static final zzby zzxs;
    @zzhb
    public static final zzby zzxt;
    @zzhb
    public static final zzby zzxu;

    /* renamed from: com.google.android.gms.internal.zzby.1 */
    static class C13121 extends zzby {
        C13121() {
        }

        public String zzb(@Nullable String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzby.2 */
    static class C13132 extends zzby {
        C13132() {
        }

        public String zzb(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzby.3 */
    static class C13143 extends zzby {
        C13143() {
        }

        @Nullable
        private String zzM(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzb(@Nullable String str, String str2) {
            String zzM = zzM(str);
            String zzM2 = zzM(str2);
            return TextUtils.isEmpty(zzM) ? zzM2 : TextUtils.isEmpty(zzM2) ? zzM : zzM + "," + zzM2;
        }
    }

    static {
        zzxs = new C13121();
        zzxt = new C13132();
        zzxu = new C13143();
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzb((String) map.get(str), str2));
    }

    public abstract String zzb(@Nullable String str, String str2);
}
