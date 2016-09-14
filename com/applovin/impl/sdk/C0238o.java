package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.o */
class C0238o {
    private final AppLovinSdkImpl f333a;
    private final AppLovinLogger f334b;

    C0238o(AppLovinSdkImpl appLovinSdkImpl) {
        this.f333a = appLovinSdkImpl;
        this.f334b = appLovinSdkImpl.getLogger();
    }

    private int m253a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        } else {
            String message = th.getMessage();
            return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
        }
    }

    private HttpURLConnection m254a(String str, String str2, int i) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f333a.m4161a(bx.f272o)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f333a.m4161a(bx.f274q)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private static void m255a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    private void m256a(String str, int i, String str2, C0239p c0239p) {
        this.f334b.m306d("ConnectionManager", i + " received from from \"" + str2 + "\": " + str);
        if (i < 200 || i >= 300) {
            this.f334b.m307e("ConnectionManager", i + " error received from \"" + str2 + "\"");
            c0239p.m265a(i);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (!(i == AppLovinErrorCodes.NO_FILL || str == null || str.length() <= 2)) {
            jSONObject = new JSONObject(str);
        }
        c0239p.m266a(jSONObject, i);
    }

    private void m257a(String str, String str2, int i, long j) {
        this.f334b.m309i("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0240q.m268a(this.f333a) + " to \"" + str2 + "\"");
    }

    private void m258a(String str, String str2, int i, long j, Throwable th) {
        this.f334b.m308e("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0240q.m268a(this.f333a) + " to \"" + str2 + "\"", th);
    }

    private static void m259a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    void m260a(String str, int i, C0239p c0239p) {
        m263a(str, "GET", i, null, true, c0239p);
    }

    void m261a(String str, int i, JSONObject jSONObject, boolean z, C0239p c0239p) {
        m263a(str, "POST", i, jSONObject, z, c0239p);
    }

    void m262a(String str, int i, boolean z, C0239p c0239p) {
        m263a(str, "GET", i, null, z, c0239p);
    }

    void m263a(String str, String str2, int i, JSONObject jSONObject, boolean z, C0239p c0239p) {
        String str3;
        HttpURLConnection a;
        Throwable th;
        Throwable th2;
        InputStream inputStream;
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No method specified");
        } else if (c0239p == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (str.toLowerCase().startsWith("http")) {
            if (!((Boolean) this.f333a.m4161a(bx.aZ)).booleanValue() || str.contains("https://")) {
                str3 = str;
            } else {
                this.f333a.getLogger().m310w("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
                str3 = str.replace("http://", "https://");
            }
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream2 = null;
            int i2 = -1;
            try {
                this.f334b.m309i("ConnectionManager", "Sending " + str2 + " request to \"" + str3 + "\"...");
                a = m254a(str3, str2, i);
                if (jSONObject != null) {
                    try {
                        String jSONObject2 = jSONObject.toString();
                        this.f334b.m306d("ConnectionManager", "Request to \"" + str3 + "\" is " + jSONObject2);
                        a.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                        a.setDoOutput(true);
                        a.setFixedLengthStreamingMode(jSONObject2.getBytes(Charset.forName(Defaults.Encoding)).length);
                        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(a.getOutputStream(), "UTF8"));
                        printWriter.print(jSONObject2);
                        printWriter.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (i2 == 0) {
                            try {
                                i2 = m253a(th);
                            } catch (Throwable th4) {
                                th2 = th4;
                                C0238o.m255a(inputStream2);
                                C0238o.m259a(a);
                                throw th2;
                            }
                        }
                        m258a(str2, str3, i2, currentTimeMillis, th);
                        c0239p.m265a(i2);
                        C0238o.m255a(inputStream2);
                        C0238o.m259a(a);
                    }
                }
                try {
                    i2 = a.getResponseCode();
                    if (i2 > 0) {
                        m257a(str2, str3, i2, currentTimeMillis);
                        if (z) {
                            inputStream = a.getInputStream();
                            try {
                                m256a(C0240q.m269a(inputStream), a.getResponseCode(), str3, c0239p);
                            } catch (MalformedURLException e) {
                                if (z) {
                                    c0239p.m266a(new JSONObject(), -901);
                                    C0238o.m255a(inputStream);
                                    C0238o.m259a(a);
                                }
                                try {
                                    c0239p.m265a(-901);
                                    C0238o.m255a(inputStream);
                                    C0238o.m259a(a);
                                } catch (Throwable th5) {
                                    inputStream2 = inputStream;
                                    th2 = th5;
                                    C0238o.m255a(inputStream2);
                                    C0238o.m259a(a);
                                    throw th2;
                                }
                            }
                        }
                        c0239p.m266a(new JSONObject(), i2);
                        inputStream = null;
                    } else {
                        m258a(str2, str3, i2, currentTimeMillis, null);
                        c0239p.m265a(i2);
                        inputStream = null;
                    }
                } catch (MalformedURLException e2) {
                    inputStream = null;
                    if (z) {
                        c0239p.m266a(new JSONObject(), -901);
                        C0238o.m255a(inputStream);
                        C0238o.m259a(a);
                    }
                    c0239p.m265a(-901);
                    C0238o.m255a(inputStream);
                    C0238o.m259a(a);
                }
                C0238o.m255a(inputStream);
                C0238o.m259a(a);
            } catch (Throwable th52) {
                a = null;
                th2 = th52;
                C0238o.m255a(inputStream2);
                C0238o.m259a(a);
                throw th2;
            }
        } else {
            this.f334b.userError("ConnectionManager", "Requested postback submission to non HTTP endpoint " + str + "; skipping...");
            c0239p.m265a(AppLovinErrorCodes.INVALID_URL);
        }
    }

    void m264a(String str, JSONObject jSONObject, C0239p c0239p) {
        m263a(str, "POST", -1, jSONObject, true, c0239p);
    }
}
