package com.jirbo.adcolony;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;

class ADCDownload extends C0724j implements Runnable {
    C0711d f4513a;
    Listener f4514b;
    String f4515c;
    File f4516d;
    Object f4517e;
    String f4518f;
    String f4519g;
    boolean f4520h;
    boolean f4521i;
    boolean f4522j;
    Map<String, List<String>> f4523k;
    SSLContext f4524l;
    int f4525m;
    String f4526n;

    public interface Listener {
        void on_download_finished(ADCDownload aDCDownload);
    }

    ADCDownload(C0711d controller, String url, Listener listener) {
        this(controller, url, listener, null);
    }

    ADCDownload(C0711d controller, String url, Listener listener, String filepath) {
        super(controller, false);
        this.f4515c = XMLConstants.NULL_NS_URI;
        this.f4515c = url;
        if (url == null) {
            this.f4515c = XMLConstants.NULL_NS_URI;
        }
        this.f4514b = listener;
        if (filepath != null) {
            this.f4516d = new File(filepath);
        }
    }

    ADCDownload m5295a(Object obj) {
        this.f4517e = obj;
        return this;
    }

    ADCDownload m5296a(String str, String str2) {
        this.f4518f = str;
        this.f4519g = str2;
        return this;
    }

    public void m5298b() {
        C0766z.m2816a(this);
    }

    public void run() {
        int i = 1;
        while (i <= 3) {
            HttpsURLConnection httpsURLConnection = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4515c).openConnection();
                InputStream inputStream;
                int read;
                int i2;
                if (this.f4518f != null) {
                    HttpsURLConnection httpsURLConnection2;
                    C0726l.f2610a.m2657b((Object) "Performing POST");
                    if (!this.f4515c.startsWith("https://") || VERSION.SDK_INT < 10) {
                        httpsURLConnection2 = null;
                    } else {
                        httpsURLConnection = (HttpsURLConnection) new URL(this.f4515c).openConnection();
                        this.f4522j = true;
                        httpsURLConnection2 = httpsURLConnection;
                    }
                    if (this.f4522j) {
                        httpsURLConnection2.setRequestMethod("POST");
                    } else {
                        httpURLConnection.setRequestMethod("POST");
                    }
                    if (this.f4522j) {
                        httpsURLConnection2.setDoOutput(true);
                    } else {
                        httpURLConnection.setDoOutput(true);
                    }
                    (this.f4522j ? new PrintStream(httpsURLConnection2.getOutputStream()) : new PrintStream(httpURLConnection.getOutputStream())).println(this.f4519g);
                    C0726l.f2610a.m2653a("Post data: ").m2657b(this.f4519g);
                    if (this.f4522j) {
                        httpsURLConnection2.connect();
                    } else {
                        httpURLConnection.connect();
                    }
                    if ((this.f4522j && httpsURLConnection2.getResponseCode() == 200) || (!this.f4522j && httpURLConnection.getResponseCode() == 200)) {
                        inputStream = this.f4522j ? httpsURLConnection2.getInputStream() : httpURLConnection.getInputStream();
                        StringBuilder stringBuilder = new StringBuilder();
                        this.f4523k = this.f4522j ? httpsURLConnection2.getHeaderFields() : httpURLConnection.getHeaderFields();
                        byte[] bArr = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
                        for (read = inputStream.read(bArr, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT); read != -1; read = inputStream.read(bArr, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT)) {
                            i2 = -1;
                            while (true) {
                                i2++;
                                if (i2 >= read) {
                                    break;
                                }
                                stringBuilder.append((char) bArr[i2]);
                            }
                        }
                        inputStream.close();
                        try {
                            this.f4526n = stringBuilder.toString();
                            this.f4525m = this.f4526n.length();
                            if (this.f4515c.contains("androidads23")) {
                                C0694a.al = System.currentTimeMillis();
                            }
                            this.f4521i = true;
                            C0694a.m2445a((C0724j) this);
                            return;
                        } catch (OutOfMemoryError e) {
                            C0726l.f2613d.m2657b((Object) "Out of memory, disabling AdColony");
                            AdColony.disable();
                            return;
                        }
                    }
                    if (i == 3) {
                        break;
                    }
                    try {
                        Thread.sleep((long) (((i + 1) * 10) * 1000));
                    } catch (InterruptedException e2) {
                    }
                    C0726l.f2611b.m2653a("Trying again (").m2651a(i + 1).m2657b((Object) "/3)");
                    i++;
                } else {
                    httpURLConnection.setReadTimeout(30000);
                    if (this.f4520h) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                    }
                    if (this.f4516d != null) {
                        if (!(this.f4513a == null || this.f4513a.f2517f == null)) {
                            this.f4513a.f2517f.m2414b();
                        }
                        Object absolutePath = this.f4516d.getAbsolutePath();
                        OutputStream fileOutputStream = new FileOutputStream(absolutePath);
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        read = httpURLConnection.getContentLength();
                        this.f4525m = 0;
                        byte[] bArr2 = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
                        i2 = inputStream2.read(bArr2, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
                        while (i2 != -1) {
                            if (read > 0) {
                                if (i2 > read) {
                                    i2 = read;
                                }
                                read -= i2;
                            }
                            this.f4525m += i2;
                            fileOutputStream.write(bArr2, 0, i2);
                            i2 = inputStream2.read(bArr2, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
                            if (read == 0) {
                                break;
                            }
                        }
                        inputStream2.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        C0726l.f2611b.m2653a("Downloaded ").m2653a(this.f4515c).m2653a(" to ").m2657b(absolutePath);
                    } else {
                        if (this.f4520h) {
                            if (this.f4515c.startsWith("https://") && VERSION.SDK_INT >= 10) {
                                httpsURLConnection = (HttpsURLConnection) new URL(this.f4515c).openConnection();
                                this.f4522j = true;
                            }
                            int responseCode = this.f4522j ? httpsURLConnection.getResponseCode() : httpURLConnection.getResponseCode();
                            if (responseCode > 0) {
                                C0726l.f2610a.m2653a("Got HTTP response ").m2651a(responseCode).m2657b((Object) " - counting as completed submission for 3rd party tracking.");
                                C0726l.f2611b.m2653a("Downloaded ").m2657b(this.f4515c);
                                this.f4526n = XMLConstants.NULL_NS_URI;
                                this.f4525m = 0;
                                this.f4521i = true;
                                C0694a.m2445a((C0724j) this);
                                return;
                            }
                        }
                        if (!this.f4515c.startsWith("https://") || VERSION.SDK_INT < 10) {
                            this.f4522j = false;
                        } else {
                            httpsURLConnection = (HttpsURLConnection) new URL(this.f4515c).openConnection();
                            this.f4522j = true;
                            C0726l.f2610a.m2657b((Object) "ADCDownload - use ssl!");
                        }
                        C0726l.f2610a.m2657b((Object) "ADCDownload - before pause");
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e3) {
                        }
                        C0726l.f2610a.m2657b((Object) "ADCDownload - getInputStream");
                        if (this.f4522j) {
                            inputStream = httpsURLConnection.getInputStream();
                        } else {
                            inputStream = httpURLConnection.getInputStream();
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        byte[] bArr3 = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
                        for (read = inputStream.read(bArr3, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT); read != -1; read = inputStream.read(bArr3, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT)) {
                            i2 = -1;
                            while (true) {
                                i2++;
                                if (i2 >= read) {
                                    break;
                                }
                                try {
                                    stringBuilder2.append((char) bArr3[i2]);
                                } catch (OutOfMemoryError e4) {
                                    C0726l.f2613d.m2657b((Object) "Out of memory, disabling AdColony");
                                    AdColony.disable();
                                    return;
                                }
                            }
                        }
                        inputStream.close();
                        try {
                            this.f4526n = stringBuilder2.toString();
                            this.f4525m = this.f4526n.length();
                            C0726l.f2611b.m2653a("Downloaded ").m2657b(this.f4515c);
                        } catch (OutOfMemoryError e5) {
                            C0726l.f2613d.m2657b((Object) "Out of memory, disabling AdColony");
                            AdColony.disable();
                            return;
                        }
                    }
                    this.f4521i = true;
                    C0694a.m2445a((C0724j) this);
                    return;
                }
            } catch (IOException e6) {
                C0694a.m2456c("Download of " + this.f4515c + " failed:\n" + e6.toString());
            }
        }
        if (this.f4515c.contains("androidads23")) {
            C0694a.f2376p = false;
        }
        this.f4521i = false;
        C0694a.m2445a((C0724j) this);
    }

    void m5297a() {
        this.f4514b.on_download_finished(this);
    }
}
