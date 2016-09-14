package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.immersion.hapticmediasdk.utils.FileManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;

/* renamed from: com.applovin.impl.sdk.z */
public class C0246z {
    private final AppLovinLogger f360a;
    private final AppLovinSdkImpl f361b;
    private final String f362c;
    private final Object f363d;

    C0246z(AppLovinSdk appLovinSdk) {
        this.f362c = FileManager.TAG;
        this.f361b = (AppLovinSdkImpl) appLovinSdk;
        this.f360a = appLovinSdk.getLogger();
        this.f363d = new Object();
    }

    long m285a(long j) {
        return j / 1048576;
    }

    public File m286a(String str, Context context, boolean z) {
        if (AppLovinSdkUtils.isValidString(str)) {
            this.f360a.m306d(FileManager.TAG, "Looking up cached resource: " + str);
            if (!m291a(context) && !z) {
                return null;
            }
            File file;
            if (str.contains("icon")) {
                str = str.replace("/", "_").replace(".", "_");
            }
            synchronized (this.f363d) {
                File b = m297b(context);
                file = new File(b, str);
                try {
                    b.mkdirs();
                } catch (Exception e) {
                    return null;
                }
            }
            return file;
        }
        this.f361b.getLogger().m306d(FileManager.TAG, "Nothing to look up, skipping...");
        return null;
    }

    String m287a(Context context, String str) {
        return m288a(context, str, false);
    }

    String m288a(Context context, String str, boolean z) {
        if (str == null || str.equals(XMLConstants.NULL_NS_URI)) {
            this.f361b.getLogger().m306d(FileManager.TAG, "Nothing to cache, skipping...");
            return null;
        } else if (di.m4289a(this.f361b, str)) {
            this.f361b.getLogger().m306d(FileManager.TAG, "Starting caching of resource " + str);
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            File a = m286a(lastPathSegment, context, false);
            return (a == null || !a.exists()) ? m294a(a, str) ? z ? Uri.fromFile(a).toString() : lastPathSegment : null : z ? Uri.fromFile(a).toString() : lastPathSegment;
        } else {
            this.f361b.getLogger().m306d(FileManager.TAG, "Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        }
    }

    void m289a(long j, Context context) {
        long c = (long) m299c();
        if (c == -1) {
            this.f360a.m306d(FileManager.TAG, "Cache has no maximum size set; skipping drop...");
        } else if (m285a(j) > c) {
            this.f360a.m306d(FileManager.TAG, "Cache has exceeded maximum size; dropping...");
            m304g(context);
            this.f361b.m4163b().m216a("cache_drop_count");
        } else {
            this.f360a.m306d(FileManager.TAG, "Cache is present but under size limit; not dropping...");
        }
    }

    boolean m290a() {
        return ((Boolean) this.f361b.m4161a(bx.an)).booleanValue();
    }

    protected boolean m291a(Context context) {
        if (C0237n.m250a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        if (C0237n.m252c() && !((Boolean) this.f361b.m4161a(bx.bk)).booleanValue()) {
            return true;
        }
        this.f361b.getLogger().m310w(FileManager.TAG, "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    boolean m292a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        FileOutputStream fileOutputStream;
        boolean z;
        Throwable e;
        this.f360a.m306d(FileManager.TAG, "Writing resource to filesystem: " + file.getName());
        synchronized (this.f363d) {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    z = true;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        this.f360a.m308e(FileManager.TAG, "Unable to write data to file", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                z = false;
                            }
                        }
                        z = false;
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
                this.f360a.m308e(FileManager.TAG, "Unable to write data to file", e);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                z = false;
                return z;
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
        return z;
    }

    boolean m293a(File file) {
        boolean delete;
        this.f360a.m306d(FileManager.TAG, "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f363d) {
            try {
                delete = file.delete();
            } catch (Throwable e) {
                this.f360a.m308e(FileManager.TAG, "Failed to remove file " + file.getName() + " from filesystem!", e);
                delete = false;
            }
        }
        return delete;
    }

    boolean m294a(File file, String str) {
        Throwable e;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream = null;
        this.f360a.m306d(FileManager.TAG, "Starting caching of " + str + " into " + file.getAbsoluteFile());
        if (((Boolean) this.f361b.m4161a(bx.aZ)).booleanValue() && !str.contains("https://")) {
            this.f361b.getLogger().m310w(FileManager.TAG, "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            str = str.replace("http://", "https://");
        }
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            HttpURLConnection httpURLConnection2;
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    this.f360a.m308e(FileManager.TAG, "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e8) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                httpURLConnection = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
            try {
                httpURLConnection2.setConnectTimeout(((Integer) this.f361b.m4161a(bx.f272o)).intValue());
                httpURLConnection2.setReadTimeout(((Integer) this.f361b.m4161a(bx.f274q)).intValue());
                httpURLConnection2.setDefaultUseCaches(true);
                httpURLConnection2.setUseCaches(true);
                httpURLConnection2.setAllowUserInteraction(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    if (null != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e11) {
                        }
                    }
                    return false;
                }
                inputStream = httpURLConnection2.getInputStream();
                byte[] bArr = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read < 0) {
                        break;
                    }
                    try {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } catch (Exception e12) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e13) {
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e14) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e15) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e16) {
                            }
                        }
                        return false;
                    }
                }
                if (m292a(byteArrayOutputStream2, file)) {
                    this.f360a.m306d(FileManager.TAG, "Caching completed for " + file);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e18) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e19) {
                        }
                    }
                    return true;
                }
                this.f360a.m307e(FileManager.TAG, "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e20) {
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e21) {
                    }
                }
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e22) {
                    }
                }
                return false;
            } catch (Throwable e23) {
                byteArrayOutputStream = byteArrayOutputStream2;
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                e = e23;
                httpURLConnection = httpURLConnection3;
                this.f360a.m308e(FileManager.TAG, "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable e232) {
                Throwable th3 = e232;
                httpURLConnection = httpURLConnection2;
                e = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
        } catch (IOException e24) {
            e = e24;
            httpURLConnection = null;
            byteArrayOutputStream = null;
            this.f360a.m308e(FileManager.TAG, "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        } catch (Throwable th4) {
            e = th4;
            httpURLConnection = null;
            byteArrayOutputStream2 = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
    }

    public boolean m295a(String str, Context context) {
        boolean b;
        synchronized (this.f363d) {
            b = m298b(str, context, false);
        }
        return b;
    }

    long m296b() {
        long longValue = ((Long) this.f361b.m4161a(bx.ao)).longValue();
        return (longValue < 0 || !m290a()) ? -1 : longValue;
    }

    File m297b(Context context) {
        return m291a(context) ? new File(context.getExternalFilesDir(null), "al") : new File(context.getCacheDir(), "al");
    }

    public boolean m298b(String str, Context context, boolean z) {
        boolean z2;
        synchronized (this.f363d) {
            File a = m286a(str, context, z);
            z2 = (a == null || !a.exists() || a.isDirectory()) ? false : true;
        }
        return z2;
    }

    int m299c() {
        int intValue = ((Integer) this.f361b.m4161a(bx.ap)).intValue();
        return (intValue < 0 || !m290a()) ? -1 : intValue;
    }

    public List m300c(Context context) {
        File b = m297b(context);
        if (!b.isDirectory()) {
            return new ArrayList(0);
        }
        List asList;
        synchronized (this.f363d) {
            asList = Arrays.asList(b.listFiles());
        }
        return asList;
    }

    public boolean m301d(Context context) {
        if (((Boolean) this.f361b.m4161a(bx.bl)).booleanValue()) {
            try {
                m286a(".nomedia", context, false);
                File file = new File(m297b(context), ".nomedia");
                if (file != null) {
                    if (file.exists()) {
                        return true;
                    }
                    this.f361b.getLogger().m306d(FileManager.TAG, "Dropping .nomedia file at " + file.getAbsolutePath());
                    return file.createNewFile();
                }
            } catch (Throwable e) {
                this.f361b.getLogger().m311w(FileManager.TAG, "Failed to create nomedia file", e);
            }
        }
        return false;
    }

    void m302e(Context context) {
        try {
            if (!m290a()) {
                return;
            }
            if (this.f361b.isEnabled()) {
                this.f360a.m307e(FileManager.TAG, "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!");
                return;
            }
            this.f360a.m306d(FileManager.TAG, "Compacting cache...");
            synchronized (this.f363d) {
                m289a(m303f(context), context);
            }
        } catch (Throwable e) {
            this.f360a.m308e(FileManager.TAG, "Caught exception while compacting cache!", e);
            this.f361b.getSettingsManager().m170a(bx.an, Boolean.valueOf(false));
            this.f361b.getSettingsManager().m173b();
        }
    }

    long m303f(Context context) {
        long j = 0;
        long b = m296b();
        Object obj = b != -1 ? 1 : null;
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f363d) {
            for (File file : m300c(context)) {
                Object obj2 = null;
                if (obj != null && toSeconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > b) {
                    this.f360a.m306d(FileManager.TAG, "File " + file.getName() + " has expired, removing...");
                    m293a(file);
                    obj2 = 1;
                }
                if (obj2 != null) {
                    this.f361b.m4163b().m216a("cached_files_expired");
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    void m304g(Context context) {
        synchronized (this.f363d) {
            for (File a : m300c(context)) {
                m293a(a);
            }
        }
    }
}
