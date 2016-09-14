package com.applovin.sdk;

public interface AppLovinLogger {
    public static final String SDK_TAG = "AppLovinSdk";

    void m306d(String str, String str2);

    void m307e(String str, String str2);

    void m308e(String str, String str2, Throwable th);

    void m309i(String str, String str2);

    void userError(String str, String str2);

    void userError(String str, String str2, Throwable th);

    void m310w(String str, String str2);

    void m311w(String str, String str2, Throwable th);
}
