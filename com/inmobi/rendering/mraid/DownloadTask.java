package com.inmobi.rendering.mraid;

import android.os.AsyncTask;
import android.os.Environment;
import android.webkit.URLUtil;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkUtils;
import com.inmobi.rendering.RenderView;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import mf.javax.xml.XMLConstants;
import mf.org.w3c.dom.traversal.NodeFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.rendering.mraid.c */
public final class DownloadTask extends AsyncTask<Void, Void, String> {
    private static final String f1960a;
    private int f1961b;
    private File f1962c;
    private String f1963d;
    private String f1964e;
    private String f1965f;
    private WeakReference<RenderView> f1966g;
    private DownloadTask f1967h;
    private ArrayList<String> f1968i;
    private long f1969j;
    private String f1970k;

    /* renamed from: com.inmobi.rendering.mraid.c.a */
    public interface DownloadTask {
        void m2071a();

        void m2072a(int i);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2074a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2075a((String) obj);
    }

    static {
        f1960a = DownloadTask.class.getSimpleName();
    }

    public DownloadTask(String str, File file, String str2, String str3, RenderView renderView) {
        this.f1970k = str;
        this.f1962c = file;
        this.f1963d = str2;
        this.f1964e = str3;
        this.f1968i = renderView.getRenderingConfig().m1485h();
        this.f1969j = renderView.getRenderingConfig().m1484g();
        this.f1966g = new WeakReference(renderView);
    }

    protected String m2074a(Void... voidArr) {
        if (!NetworkUtils.m1783a()) {
            this.f1961b = 8;
            return "fail";
        } else if (!this.f1964e.matches("[A-Za-z0-9]+") || this.f1964e.equals(XMLConstants.NULL_NS_URI)) {
            this.f1961b = 2;
            return "fail";
        } else if (this.f1963d.equals(XMLConstants.NULL_NS_URI) || !URLUtil.isValidUrl(this.f1963d)) {
            this.f1961b = 3;
            return "fail";
        } else if (Environment.getExternalStorageState().equals("mounted")) {
            String[] strArr = (String[]) this.f1968i.toArray(new String[this.f1968i.size()]);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1963d).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                int responseCode = httpURLConnection.getResponseCode();
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "Response code: " + responseCode);
                if (responseCode < 400) {
                    Object obj;
                    String contentType = httpURLConnection.getContentType();
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "Content Type: " + contentType);
                    for (String str : strArr) {
                        Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "Allowed Type: " + str);
                        if (str.toLowerCase(Locale.ENGLISH).equals(contentType.toLowerCase(Locale.ENGLISH))) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        this.f1961b = 6;
                        return "fail";
                    }
                }
                long contentLength = (long) httpURLConnection.getContentLength();
                if (contentLength >= 0) {
                    Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "ContentSize: " + contentLength + " max size: " + this.f1969j);
                    if (contentLength > this.f1969j) {
                        this.f1961b = 7;
                        return "fail";
                    }
                }
                httpURLConnection.connect();
                FileOutputStream fileOutputStream = new FileOutputStream(this.f1962c);
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        j += (long) read;
                        if (j > this.f1969j) {
                            this.f1961b = 7;
                            return "fail";
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        j = System.currentTimeMillis();
                        String str2 = "file://" + this.f1962c.getAbsolutePath();
                        Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "file path of video: " + str2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(DatabaseOpenHelper.HISTORY_ROW_URL, this.f1963d);
                        jSONObject.put("saved_url", str2);
                        jSONObject.put("size_in_bytes", this.f1962c.length());
                        jSONObject.put("download_started_at", currentTimeMillis);
                        jSONObject.put("download_ended_at", j);
                        this.f1965f = jSONObject.toString().replace("\"", "\\\"");
                        return "success";
                    }
                }
            } catch (SocketTimeoutException e) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "SocketTimeoutException");
                this.f1961b = 4;
                return "fail";
            } catch (FileNotFoundException e2) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "FileNotFoundException");
                this.f1961b = 4;
                return "fail";
            } catch (MalformedURLException e3) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "MalformedURLException");
                this.f1961b = 3;
                return "fail";
            } catch (ProtocolException e4) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "ProtocolException");
                this.f1961b = 8;
                return "fail";
            } catch (IOException e5) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "IOException");
                this.f1961b = 8;
                return "fail";
            } catch (JSONException e6) {
                Logger.m1744a(InternalLogLevel.INTERNAL, f1960a, "JSONException");
                this.f1961b = 0;
                return "fail";
            }
        } else {
            this.f1961b = 10;
            return "fail";
        }
    }

    protected void onCancelled() {
        super.onCancelled();
    }

    protected void m2075a(String str) {
        if (str.equals("success")) {
            if (this.f1966g.get() != null) {
                ((RenderView) this.f1966g.get()).m1946a(this.f1970k, "sendSaveContentResult(\"saveContent_" + this.f1964e + "\", 'success', \"" + this.f1965f + "\");");
            }
            if (this.f1967h != null) {
                this.f1967h.m2071a();
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DatabaseOpenHelper.HISTORY_ROW_URL, this.f1963d);
                jSONObject.put("reason", this.f1961b);
                String replace = jSONObject.toString().replace("\"", "\\\"");
                if (this.f1966g.get() != null) {
                    ((RenderView) this.f1966g.get()).m1946a(this.f1970k, "sendSaveContentResult(\"saveContent_" + this.f1964e + "\", 'failure', \"" + replace + "\");");
                }
                if (this.f1967h != null) {
                    this.f1967h.m2072a(this.f1961b);
                }
            } catch (JSONException e) {
                if (this.f1966g.get() != null) {
                    ((RenderView) this.f1966g.get()).m1946a(this.f1970k, "sendSaveContentResult(\"saveContent_" + this.f1964e + "\", 'failure', \"JSONException\");");
                }
            }
        }
        super.onPostExecute(str);
    }

    public String m2073a() {
        return this.f1964e;
    }
}
