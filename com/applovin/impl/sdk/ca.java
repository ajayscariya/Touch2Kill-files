package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import mf.javax.xml.XMLConstants;
import org.json.JSONObject;

class ca {
    private final AppLovinSdkImpl f290a;
    private final AppLovinLogger f291b;
    private final Context f292c;
    private final Object[] f293d;

    ca(AppLovinSdkImpl appLovinSdkImpl) {
        this.f293d = new Object[bx.m158b()];
        this.f290a = appLovinSdkImpl;
        this.f291b = appLovinSdkImpl.getLogger();
        this.f292c = appLovinSdkImpl.getApplicationContext();
    }

    private static bz m165a(String str) {
        for (bz bzVar : bx.m157a()) {
            if (bzVar.m161b().equals(str)) {
                return bzVar;
            }
        }
        return null;
    }

    private static Object m166a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    private String m167e() {
        return "com.applovin.sdk." + di.m4282a(this.f290a.getSdkKey()) + ".";
    }

    public SharedPreferences m168a() {
        if (this.f292c != null) {
            return this.f292c.getSharedPreferences("com.applovin.sdk.1", 0);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public Object m169a(bz bzVar) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        Object obj;
        synchronized (this.f293d) {
            try {
                obj = this.f293d[bzVar.m159a()];
                if (obj != null) {
                    obj = bzVar.m160a(obj);
                } else {
                    obj = bzVar.m162c();
                }
            } catch (Throwable th) {
                this.f290a.getLogger().m307e("SettingsManager", "Unable to retrieve value for setting " + bzVar.m161b() + "; using default...");
                obj = bzVar.m162c();
            }
        }
        return obj;
    }

    public void m170a(bz bzVar, Object obj) {
        if (bzVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        } else {
            synchronized (this.f293d) {
                this.f293d[bzVar.m159a()] = obj;
            }
            this.f291b.m306d("SettingsManager", "Setting update: " + bzVar.m161b() + " set to \"" + obj + "\"");
        }
    }

    void m171a(AppLovinSdkSettings appLovinSdkSettings) {
        long j = 0;
        boolean z = false;
        this.f291b.m309i("SettingsManager", "Loading user-defined settings...");
        if (appLovinSdkSettings != null) {
            synchronized (this.f293d) {
                boolean z2;
                boolean z3;
                this.f293d[bx.f266i.m159a()] = Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled());
                long bannerAdRefreshSeconds = appLovinSdkSettings.getBannerAdRefreshSeconds();
                if (bannerAdRefreshSeconds >= 0) {
                    if (bannerAdRefreshSeconds > 0) {
                        j = Math.max(30, bannerAdRefreshSeconds);
                    }
                    this.f293d[bx.f278u.m159a()] = Long.valueOf(j);
                    this.f293d[bx.f277t.m159a()] = Boolean.valueOf(true);
                } else if (bannerAdRefreshSeconds == -1) {
                    this.f293d[bx.f277t.m159a()] = Boolean.valueOf(false);
                }
                String autoPreloadSizes = appLovinSdkSettings.getAutoPreloadSizes();
                if (autoPreloadSizes == null) {
                    autoPreloadSizes = "NONE";
                }
                Object[] objArr = this.f293d;
                int a = bx.f235D.m159a();
                if (autoPreloadSizes.equals("NONE")) {
                    autoPreloadSizes = XMLConstants.NULL_NS_URI;
                }
                objArr[a] = autoPreloadSizes;
                autoPreloadSizes = appLovinSdkSettings.getAutoPreloadTypes();
                if (autoPreloadSizes == null) {
                    autoPreloadSizes = "NONE";
                }
                if (autoPreloadSizes.equals("NONE")) {
                    z2 = false;
                    z3 = false;
                } else {
                    z2 = false;
                    z3 = false;
                    for (String str : autoPreloadSizes.split(",")) {
                        if (str.equals(AppLovinAdType.REGULAR.getLabel())) {
                            z3 = true;
                        } else if (str.equals(AppLovinAdType.INCENTIVIZED.getLabel()) || str.contains("INCENT") || str.contains("REWARD")) {
                            z2 = true;
                        } else if (str.equals(NativeAdImpl.TYPE_NATIVE.getLabel())) {
                            z = true;
                        }
                    }
                }
                if (!z3) {
                    this.f293d[bx.f235D.m159a()] = XMLConstants.NULL_NS_URI;
                }
                this.f293d[bx.f236E.m159a()] = Boolean.valueOf(z2);
                this.f293d[bx.az.m159a()] = Boolean.valueOf(z);
                if (appLovinSdkSettings instanceof ax) {
                    for (Entry entry : ((ax) appLovinSdkSettings).m4183b().entrySet()) {
                        this.f293d[((bz) entry.getKey()).m159a()] = entry.getValue();
                    }
                }
            }
        }
    }

    void m172a(JSONObject jSONObject) {
        this.f291b.m306d("SettingsManager", "Loading settings from JSON array...");
        synchronized (this.f293d) {
            String str = XMLConstants.NULL_NS_URI;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str != null && str.length() > 0) {
                    try {
                        bz a = m165a(str);
                        if (a != null) {
                            Object a2 = m166a(str, jSONObject, a.m162c());
                            this.f293d[a.m159a()] = a2;
                            this.f291b.m306d("SettingsManager", "Setting update: " + a.m161b() + " set to \"" + a2 + "\"");
                        } else {
                            this.f291b.m310w("SettingsManager", "Unknown setting recieved: " + str);
                        }
                    } catch (Throwable e) {
                        this.f291b.m308e("SettingsManager", "Unable to parse JSON settings array", e);
                    } catch (Throwable e2) {
                        this.f291b.m308e("SettingsManager", "Unable to convert setting object ", e2);
                    }
                }
            }
        }
    }

    void m173b() {
        if (this.f292c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f291b.m309i("SettingsManager", "Saving settings with the application...");
        String e = m167e();
        Editor edit = m168a().edit();
        synchronized (this.f293d) {
            for (bz bzVar : bx.m157a()) {
                Object obj = this.f293d[bzVar.m159a()];
                if (obj != null) {
                    String str = e + bzVar.m161b();
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else {
                        throw new RuntimeException("SDK Error: unknown value: " + obj.getClass());
                    }
                }
            }
        }
        edit.commit();
        this.f291b.m306d("SettingsManager", "Settings saved with the application.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m174c() {
        /*
        r10 = this;
        r0 = r10.f292c;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "No context specified";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r10.f291b;
        r1 = "SettingsManager";
        r2 = "Loading settings saved with the application...";
        r0.m309i(r1, r2);
        r2 = r10.m167e();
        r3 = r10.m168a();
        r4 = r10.f293d;
        monitor-enter(r4);
        r0 = com.applovin.impl.sdk.bx.m157a();	 Catch:{ all -> 0x008e }
        r5 = r0.iterator();	 Catch:{ all -> 0x008e }
    L_0x0028:
        r0 = r5.hasNext();	 Catch:{ all -> 0x008e }
        if (r0 == 0) goto L_0x00f2;
    L_0x002e:
        r0 = r5.next();	 Catch:{ all -> 0x008e }
        r0 = (com.applovin.impl.sdk.bz) r0;	 Catch:{ all -> 0x008e }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0068 }
        r1.<init>();	 Catch:{ Exception -> 0x0068 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0068 }
        r6 = r0.m161b();	 Catch:{ Exception -> 0x0068 }
        r1 = r1.append(r6);	 Catch:{ Exception -> 0x0068 }
        r6 = r1.toString();	 Catch:{ Exception -> 0x0068 }
        r1 = r0.m162c();	 Catch:{ Exception -> 0x0068 }
        r7 = r1 instanceof java.lang.Boolean;	 Catch:{ Exception -> 0x0068 }
        if (r7 == 0) goto L_0x0091;
    L_0x0051:
        r1 = (java.lang.Boolean) r1;	 Catch:{ Exception -> 0x0068 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0068 }
        r1 = r3.getBoolean(r6, r1);	 Catch:{ Exception -> 0x0068 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0068 }
    L_0x005f:
        r6 = r10.f293d;	 Catch:{ Exception -> 0x0068 }
        r7 = r0.m159a();	 Catch:{ Exception -> 0x0068 }
        r6[r7] = r1;	 Catch:{ Exception -> 0x0068 }
        goto L_0x0028;
    L_0x0068:
        r1 = move-exception;
        r6 = r10.f291b;	 Catch:{ all -> 0x008e }
        r7 = "SettingsManager";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r8.<init>();	 Catch:{ all -> 0x008e }
        r9 = "Unable to load \"";
        r8 = r8.append(r9);	 Catch:{ all -> 0x008e }
        r0 = r0.m161b();	 Catch:{ all -> 0x008e }
        r0 = r8.append(r0);	 Catch:{ all -> 0x008e }
        r8 = "\"";
        r0 = r0.append(r8);	 Catch:{ all -> 0x008e }
        r0 = r0.toString();	 Catch:{ all -> 0x008e }
        r6.m308e(r7, r0, r1);	 Catch:{ all -> 0x008e }
        goto L_0x0028;
    L_0x008e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x008e }
        throw r0;
    L_0x0091:
        r7 = r1 instanceof java.lang.Float;	 Catch:{ Exception -> 0x0068 }
        if (r7 == 0) goto L_0x00a4;
    L_0x0095:
        r1 = (java.lang.Float) r1;	 Catch:{ Exception -> 0x0068 }
        r1 = r1.floatValue();	 Catch:{ Exception -> 0x0068 }
        r1 = r3.getFloat(r6, r1);	 Catch:{ Exception -> 0x0068 }
        r1 = java.lang.Float.valueOf(r1);	 Catch:{ Exception -> 0x0068 }
        goto L_0x005f;
    L_0x00a4:
        r7 = r1 instanceof java.lang.Integer;	 Catch:{ Exception -> 0x0068 }
        if (r7 == 0) goto L_0x00b7;
    L_0x00a8:
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x0068 }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0068 }
        r1 = r3.getInt(r6, r1);	 Catch:{ Exception -> 0x0068 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0068 }
        goto L_0x005f;
    L_0x00b7:
        r7 = r1 instanceof java.lang.Long;	 Catch:{ Exception -> 0x0068 }
        if (r7 == 0) goto L_0x00ca;
    L_0x00bb:
        r1 = (java.lang.Long) r1;	 Catch:{ Exception -> 0x0068 }
        r8 = r1.longValue();	 Catch:{ Exception -> 0x0068 }
        r6 = r3.getLong(r6, r8);	 Catch:{ Exception -> 0x0068 }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0068 }
        goto L_0x005f;
    L_0x00ca:
        r7 = r1 instanceof java.lang.String;	 Catch:{ Exception -> 0x0068 }
        if (r7 == 0) goto L_0x00d5;
    L_0x00ce:
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0068 }
        r1 = r3.getString(r6, r1);	 Catch:{ Exception -> 0x0068 }
        goto L_0x005f;
    L_0x00d5:
        r6 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x0068 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0068 }
        r7.<init>();	 Catch:{ Exception -> 0x0068 }
        r8 = "SDK Error: unknown value: ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0068 }
        r1 = r1.getClass();	 Catch:{ Exception -> 0x0068 }
        r1 = r7.append(r1);	 Catch:{ Exception -> 0x0068 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0068 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0068 }
        throw r6;	 Catch:{ Exception -> 0x0068 }
    L_0x00f2:
        monitor-exit(r4);	 Catch:{ all -> 0x008e }
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.ca.c():void");
    }

    void m175d() {
        synchronized (this.f293d) {
            Arrays.fill(this.f293d, null);
        }
        Editor edit = m168a().edit();
        edit.clear();
        edit.commit();
    }
}
