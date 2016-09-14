package com.startapp.android.publish.video;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.startapp.android.publish.FullScreenActivity;
import com.startapp.android.publish.model.MetaData;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xerces.impl.io.UTF16Reader;

/* renamed from: com.startapp.android.publish.video.b */
public class StartAppSDK {

    /* renamed from: com.startapp.android.publish.video.b.a */
    public enum StartAppSDK {
        ELIGIBLE(XMLConstants.NULL_NS_URI),
        INELIGIBLE_NO_STORAGE("Not enough storage for video"),
        INELIGIBLE_MISSING_ACTIVITY("FullScreenActivity not declared in AndroidManifest.xml"),
        INELIGIBLE_ERRORS_THRESHOLD_REACHED("Video errors threshold reached.");
        
        private String desctiption;

        private StartAppSDK(String str) {
            this.desctiption = str;
        }

        public String m3911a() {
            return this.desctiption;
        }
    }

    public static String m3937a(Context context, URL url, String str) {
        InputStream openStream;
        Throwable e;
        FileOutputStream fileOutputStream;
        com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppWall.VideoUtil", 3, "Downloading video from " + url);
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            String a = StartAppSDK.m3936a(context, str);
            File file = new File(a);
            if (file.exists()) {
                try {
                    inputStream.close();
                    dataInputStream.close();
                    fileOutputStream2.close();
                    return a;
                } catch (Exception e2) {
                    return a;
                }
            }
            openStream = url.openStream();
            try {
                dataInputStream = new DataInputStream(openStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                dataInputStream = null;
                try {
                    Log.e("StartAppWall.VideoUtil", "Error downloading video from " + url, e);
                    new File(StartAppSDK.m3936a(context, str + ".temp")).delete();
                    try {
                        openStream.close();
                        dataInputStream.close();
                        fileOutputStream.close();
                        return null;
                    } catch (Exception e4) {
                        return null;
                    }
                } catch (Throwable th) {
                    e = th;
                    try {
                        openStream.close();
                        dataInputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e5) {
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                dataInputStream = null;
                openStream.close();
                dataInputStream.close();
                fileOutputStream.close();
                throw e;
            }
            try {
                byte[] bArr = new byte[UTF16Reader.DEFAULT_BUFFER_SIZE];
                fileOutputStream = context.openFileOutput(str + ".temp", 0);
                while (true) {
                    try {
                        int read = dataInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            new File(StartAppSDK.m3936a(context, str + ".temp")).renameTo(file);
                            try {
                                openStream.close();
                                dataInputStream.close();
                                fileOutputStream.close();
                                return a;
                            } catch (Exception e6) {
                                return a;
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
                Log.e("StartAppWall.VideoUtil", "Error downloading video from " + url, e);
                new File(StartAppSDK.m3936a(context, str + ".temp")).delete();
                openStream.close();
                dataInputStream.close();
                fileOutputStream.close();
                return null;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                openStream.close();
                dataInputStream.close();
                fileOutputStream.close();
                throw e;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
            dataInputStream = null;
            openStream = null;
            Log.e("StartAppWall.VideoUtil", "Error downloading video from " + url, e);
            new File(StartAppSDK.m3936a(context, str + ".temp")).delete();
            openStream.close();
            dataInputStream.close();
            fileOutputStream.close();
            return null;
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            dataInputStream = null;
            openStream = null;
            openStream.close();
            dataInputStream.close();
            fileOutputStream.close();
            throw e;
        }
    }

    public static StartAppSDK m3935a(Context context) {
        StartAppSDK startAppSDK = StartAppSDK.ELIGIBLE;
        if (StartAppSDK.m3940c(context)) {
            startAppSDK = StartAppSDK.INELIGIBLE_ERRORS_THRESHOLD_REACHED;
        }
        if (!com.startapp.android.publish.p022h.StartAppSDK.m3323a(context, FullScreenActivity.class)) {
            startAppSDK = StartAppSDK.INELIGIBLE_MISSING_ACTIVITY;
        }
        if (StartAppSDK.m3941d(context)) {
            return startAppSDK;
        }
        return StartAppSDK.INELIGIBLE_NO_STORAGE;
    }

    public static void m3939b(Context context) {
        com.startapp.android.publish.p022h.StartAppSDK.m3214b(context, "videoErrorsCount", Integer.valueOf(com.startapp.android.publish.p022h.StartAppSDK.m3209a(context, "videoErrorsCount", Integer.valueOf(0)).intValue() + 1));
    }

    public static void m3938a(Context context, com.startapp.android.publish.video.p025a.StartAppSDK startAppSDK) {
        if (startAppSDK != null) {
            for (String b : startAppSDK.m3896a()) {
                com.startapp.android.publish.p022h.StartAppSDK.m3332b(context, b);
            }
        }
    }

    private static String m3936a(Context context, String str) {
        return context.getFilesDir() + "/" + str;
    }

    private static boolean m3940c(Context context) {
        if (MetaData.getInstance().getVideoConfig().getVideoErrorsThreshold() >= 0 && com.startapp.android.publish.p022h.StartAppSDK.m3209a(context, "videoErrorsCount", Integer.valueOf(0)).intValue() >= MetaData.getInstance().getVideoConfig().getVideoErrorsThreshold()) {
            return true;
        }
        return false;
    }

    private static boolean m3941d(Context context) {
        try {
            if (com.startapp.android.publish.p022h.StartAppSDK.m3190d(context) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID > MetaData.getInstance().getVideoConfig().getMinAvailableStorageRequired() * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                return true;
            }
            return false;
        } catch (com.startapp.android.publish.p022h.StartAppSDK e) {
            com.startapp.android.publish.p022h.StartAppSDK.m3232a("StartAppWall.VideoUtil", 3, "Failed to calculate available storage: " + e.getMessage());
            return false;
        }
    }
}
