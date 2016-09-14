package com.immersion.hapticmediasdk.controllers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.immersion.hapticmediasdk.models.HttpUnsuccessfulException;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;

public class HapticDownloadThread extends Thread {
    private static final String f1266a = "HapticDownloadThread";
    private static final int f1267b = 4096;
    public static int f1268b04150415041504150415 = 1;
    public static int f1269b0415041504150415 = 39;
    public static int f1270b0415041504150415 = 0;
    public static int f1271b0415041504150415 = 2;
    private String f1272c;
    private Handler f1273d;
    private boolean f1274e;
    private Thread f1275f;
    private FileManager f1276g;
    private volatile boolean f1277h;
    private volatile boolean f1278i;
    private volatile boolean f1279j;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HapticDownloadThread(java.lang.String r4, android.os.Handler r5, boolean r6, com.immersion.hapticmediasdk.utils.FileManager r7) {
        /*
        r3 = this;
        r2 = 1;
        r1 = 0;
        r0 = "HapticDownloadThread";
        r3.<init>(r0);
        r3.f1277h = r1;
        r3.f1278i = r1;
        r3.f1279j = r1;
        r3.f1272c = r4;
    L_0x000f:
        switch(r2) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0016;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r2) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0016;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x0012;
    L_0x0016:
        r3.f1273d = r5;
        r3.f1274e = r6;
        r3.f1276g = r7;
        r0 = r3.f1273d;
        r0 = r0.getLooper();
        r1 = f1269b0415041504150415;
        r2 = f1268b04150415041504150415;
        r1 = r1 + r2;
        r2 = f1269b0415041504150415;
        r1 = r1 * r2;
        r2 = f1271b0415041504150415;
        r1 = r1 % r2;
        r2 = f1270b0415041504150415;
        if (r1 == r2) goto L_0x003b;
    L_0x0031:
        r1 = 70;
        f1269b0415041504150415 = r1;
        r1 = m1323b04150415041504150415();
        f1270b0415041504150415 = r1;
    L_0x003b:
        r0 = r0.getThread();
        r3.f1275f = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticDownloadThread.<init>(java.lang.String, android.os.Handler, boolean, com.immersion.hapticmediasdk.utils.FileManager):void");
    }

    public static int m1323b04150415041504150415() {
        return 19;
    }

    public static int m1324b0427() {
        return 1;
    }

    public static int m1325b04150415041504150415() {
        return 0;
    }

    public synchronized boolean isFirstPacketReady() {
        boolean z;
        try {
            z = this.f1277h || this.f1278i;
        } catch (Exception e) {
            throw e;
        }
        return z;
    }

    public void run() {
        if (this.f1274e) {
            Process.setThreadPriority(10);
            try {
                HttpResponse executeGet = ImmersionHttpClient.getHttpClient().executeGet(this.f1272c, null, 60000);
                int statusCode = executeGet.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    writeToFile(executeGet.getEntity().getContent(), Integer.parseInt(executeGet.getFirstHeader("Content-Length").getValue()));
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder("HTTP STATUS CODE: ");
                stringBuilder.append(statusCode);
                switch (statusCode) {
                    case 400:
                        stringBuilder.append(" Bad Request");
                        break;
                    case 403:
                        stringBuilder.append(" Forbidden");
                        break;
                    case 404:
                        stringBuilder.append(" Not Found");
                        break;
                    case 500:
                        stringBuilder.append(" Internal Server Error");
                        break;
                    case 502:
                        stringBuilder.append(" Bad Gateway");
                        break;
                    case 503:
                        stringBuilder.append(" Service Unavailable");
                        break;
                    default:
                        break;
                }
                throw new HttpUnsuccessfulException(statusCode, stringBuilder.toString());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } catch (Object e2) {
                Message obtainMessage = this.f1273d.obtainMessage(8);
                Bundle bundle = new Bundle();
                bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, e2);
                obtainMessage.setData(bundle);
                if (this.f1275f.isAlive() && !this.f1279j) {
                    Handler handler = this.f1273d;
                    if (((f1269b0415041504150415 + f1268b04150415041504150415) * f1269b0415041504150415) % f1271b0415041504150415 != f1270b0415041504150415) {
                        f1269b0415041504150415 = m1323b04150415041504150415();
                        f1270b0415041504150415 = m1323b04150415041504150415();
                    }
                    handler.sendMessage(obtainMessage);
                }
                Log.m1418e(f1266a, e2.getMessage());
                return;
            }
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(this.f1272c);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                writeToFile(fileInputStream, fileInputStream.available());
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void terminate() {
        /*
        r3 = this;
        r2 = 1;
        r0 = f1269b0415041504150415;
        r1 = f1268b04150415041504150415;
        r0 = r0 + r1;
        r1 = f1269b0415041504150415;
        r0 = r0 * r1;
        r1 = f1271b0415041504150415;
        r0 = r0 % r1;
        r1 = m1325b04150415041504150415();
        if (r0 == r1) goto L_0x001c;
    L_0x0012:
        r0 = 53;
        f1269b0415041504150415 = r0;
        r0 = m1323b04150415041504150415();
        f1270b0415041504150415 = r0;
    L_0x001c:
        r0 = 0;
        switch(r0) {
            case 0: goto L_0x0024;
            case 1: goto L_0x001c;
            default: goto L_0x0020;
        };
    L_0x0020:
        switch(r2) {
            case 0: goto L_0x001c;
            case 1: goto L_0x0024;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0020;
    L_0x0024:
        r3.f1279j = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.immersion.hapticmediasdk.controllers.HapticDownloadThread.terminate():void");
    }

    public boolean writeToFile(InputStream inputStream, int i) throws IOException {
        Bundle bundle;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        String str;
        Message obtainMessage;
        int i2 = 0;
        try {
            byte[] bArr = new byte[f1267b];
            if (inputStream == null || i <= 0) {
                if (!this.f1277h) {
                    String str2 = "downloaded an empty file";
                    Message obtainMessage2 = this.f1273d.obtainMessage(8);
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str2));
                    obtainMessage2.setData(bundle2);
                    if (this.f1275f.isAlive() && !this.f1279j) {
                        this.f1273d.sendMessage(obtainMessage2);
                    }
                    Log.m1418e(f1266a, str2);
                }
                this.f1276g.closeCloseable(null);
                this.f1276g.closeCloseable(null);
                this.f1278i = true;
                return false;
            }
            try {
                Closeable bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    BufferedOutputStream makeOutputStreamForStreaming = this.f1274e ? this.f1276g.makeOutputStreamForStreaming(this.f1272c) : this.f1276g.makeOutputStream(this.f1272c);
                    Message obtainMessage3;
                    if (makeOutputStreamForStreaming == null) {
                        if (!this.f1277h) {
                            String str3 = "downloaded an empty file";
                            obtainMessage3 = this.f1273d.obtainMessage(8);
                            bundle = new Bundle();
                            bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str3));
                            try {
                                obtainMessage3.setData(bundle);
                                if (this.f1275f.isAlive() && !this.f1279j) {
                                    this.f1273d.sendMessage(obtainMessage3);
                                }
                                Log.m1418e(f1266a, str3);
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        this.f1276g.closeCloseable(bufferedInputStream);
                        this.f1276g.closeCloseable(makeOutputStreamForStreaming);
                        this.f1278i = true;
                        return false;
                    }
                    try {
                        String str4;
                        if (this.f1274e) {
                            while (!isInterrupted() && !this.f1279j) {
                                int read = bufferedInputStream.read(bArr, 0, f1267b);
                                if (read < 0) {
                                    break;
                                }
                                makeOutputStreamForStreaming.write(bArr, 0, read);
                                i2 += read;
                                if (this.f1275f.isAlive()) {
                                    if (!this.f1277h) {
                                        this.f1277h = true;
                                    }
                                    makeOutputStreamForStreaming.flush();
                                    this.f1273d.sendMessage(this.f1273d.obtainMessage(3, i2, 0));
                                }
                            }
                        } else {
                            this.f1277h = true;
                            if (this.f1279j) {
                                if (!this.f1277h) {
                                    str4 = "downloaded an empty file";
                                    obtainMessage3 = this.f1273d.obtainMessage(8);
                                    bundle = new Bundle();
                                    bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str4));
                                    obtainMessage3.setData(bundle);
                                    if (this.f1275f.isAlive() && !this.f1279j) {
                                        this.f1273d.sendMessage(obtainMessage3);
                                    }
                                    Log.m1418e(f1266a, str4);
                                }
                                this.f1276g.closeCloseable(bufferedInputStream);
                                this.f1276g.closeCloseable(makeOutputStreamForStreaming);
                                this.f1278i = true;
                                return true;
                            }
                            this.f1273d.sendMessage(this.f1273d.obtainMessage(3, i, 0));
                        }
                        Log.m1419i(f1266a, "file download completed");
                        if (!this.f1277h) {
                            str4 = "downloaded an empty file";
                            obtainMessage3 = this.f1273d.obtainMessage(8);
                            bundle = new Bundle();
                            if (((f1269b0415041504150415 + f1268b04150415041504150415) * f1269b0415041504150415) % f1271b0415041504150415 != f1270b0415041504150415) {
                                f1269b0415041504150415 = 2;
                                f1270b0415041504150415 = 54;
                            }
                            bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str4));
                            obtainMessage3.setData(bundle);
                            if (this.f1275f.isAlive() && !this.f1279j) {
                                this.f1273d.sendMessage(obtainMessage3);
                            }
                            Log.m1418e(f1266a, str4);
                        }
                        this.f1276g.closeCloseable(bufferedInputStream);
                        if (((f1269b0415041504150415 + m1324b0427()) * f1269b0415041504150415) % f1271b0415041504150415 != f1270b0415041504150415) {
                            f1269b0415041504150415 = 47;
                            f1270b0415041504150415 = 86;
                        }
                        this.f1276g.closeCloseable(makeOutputStreamForStreaming);
                        this.f1278i = true;
                        return true;
                    } catch (Throwable th2) {
                        closeable = bufferedInputStream;
                        BufferedOutputStream bufferedOutputStream = makeOutputStreamForStreaming;
                        th = th2;
                        Object obj = bufferedOutputStream;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable2 = null;
                    closeable = bufferedInputStream;
                    if (!this.f1277h) {
                        str = "downloaded an empty file";
                        obtainMessage = this.f1273d.obtainMessage(8);
                        bundle = new Bundle();
                        bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str));
                        obtainMessage.setData(bundle);
                        if (this.f1275f.isAlive() && !this.f1279j) {
                            this.f1273d.sendMessage(obtainMessage);
                        }
                        Log.m1418e(f1266a, str);
                    }
                    this.f1276g.closeCloseable(closeable);
                    this.f1276g.closeCloseable(closeable2);
                    this.f1278i = true;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable2 = null;
                closeable = null;
                if (this.f1277h) {
                    str = "downloaded an empty file";
                    obtainMessage = this.f1273d.obtainMessage(8);
                    bundle = new Bundle();
                    bundle.putSerializable(HapticPlaybackThread.HAPTIC_DOWNLOAD_EXCEPTION_KEY, new FileNotFoundException(str));
                    obtainMessage.setData(bundle);
                    this.f1273d.sendMessage(obtainMessage);
                    Log.m1418e(f1266a, str);
                }
                this.f1276g.closeCloseable(closeable);
                this.f1276g.closeCloseable(closeable2);
                this.f1278i = true;
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
