package com.jirbo.adcolony;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.jirbo.adcolony.q */
class C0760q {
    public static final int f2942a = 30;
    public static String f2943b;
    public static String f2944c;
    public static String f2945d;

    C0760q() {
    }

    static {
        f2943b = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  x          xxxxxxx                          xxxx x                          xxxxx";
        f2944c = "0123456789ABCDEF";
        f2945d = "0123456789abcdef";
    }

    static boolean m2788a() {
        return C0760q.m2789a(null);
    }

    static boolean m2789a(Activity activity) {
        if (activity == null) {
            activity = C0694a.f2350P;
        }
        if (activity == null) {
            C0726l.f2610a.m2657b((Object) "Null Activity");
            return false;
        } else if (C0694a.f2348N) {
            return true;
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        }
    }

    static boolean m2791b() {
        return C0760q.m2792b(null);
    }

    static boolean m2792b(Activity activity) {
        if (activity == null) {
            activity = C0694a.f2350P;
        }
        if (activity == null || C0694a.f2348N) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        int type = activeNetworkInfo.getType();
        boolean z = type == 0 || type >= 2;
        return z;
    }

    static boolean m2793c() {
        return C0760q.m2794c(null);
    }

    static boolean m2794c(Activity activity) {
        return C0760q.m2789a(activity) || C0760q.m2792b(activity);
    }

    public static String m2795d() {
        if (C0760q.m2788a()) {
            return "wifi";
        }
        if (C0760q.m2791b()) {
            return "cell";
        }
        return "offline";
    }

    public static String m2787a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= '\u0080' || f2943b.charAt(charAt) != ' ') {
                stringBuilder.append('%');
                int i2 = (charAt >> 4) & 15;
                int i3 = charAt & 15;
                if (i2 < 10) {
                    stringBuilder.append((char) (i2 + 48));
                } else {
                    stringBuilder.append((char) ((i2 + 65) - 10));
                }
                if (i3 < 10) {
                    stringBuilder.append((char) (i3 + 48));
                } else {
                    stringBuilder.append((char) ((i3 + 65) - 10));
                }
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public static int m2786a(char c) {
        int indexOf = f2944c.indexOf(c);
        if (indexOf >= 0) {
            return indexOf;
        }
        indexOf = f2945d.indexOf(c);
        return indexOf < 0 ? 0 : indexOf;
    }

    public static String m2790b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = str.charAt(i);
            if (charAt == '%') {
                char charAt2;
                if (i + 1 < length) {
                    charAt2 = str.charAt(i + 1);
                } else {
                    charAt2 = '0';
                }
                if (i + 2 < length) {
                    charAt = str.charAt(i + 2);
                } else {
                    charAt = '0';
                }
                i += 2;
                stringBuilder.append((char) (C0760q.m2786a(charAt) | (C0760q.m2786a(charAt2) << 8)));
                i2 = i;
            } else {
                stringBuilder.append(charAt);
                i2 = i;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }
}
