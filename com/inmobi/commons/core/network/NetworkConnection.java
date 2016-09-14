package com.inmobi.commons.core.network;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.NetworkUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import mf.org.apache.xml.serialize.LineSeparator;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.inmobi.commons.core.network.b */
class NetworkConnection {
    private static final String f1614a;
    private NetworkRequest f1615b;
    private HttpURLConnection f1616c;

    static {
        f1614a = NetworkConnection.class.getName();
    }

    public NetworkConnection(NetworkRequest networkRequest) {
        this.f1615b = networkRequest;
    }

    public NetworkResponse m1733a() {
        this.f1615b.m1703a();
        NetworkResponse networkResponse;
        if (NetworkUtils.m1783a()) {
            try {
                String b = m1730b();
                Logger.m1744a(InternalLogLevel.INTERNAL, f1614a, "Url: " + b);
                this.f1616c = m1727a(b);
                if (!this.f1615b.m1717l()) {
                    this.f1616c.setInstanceFollowRedirects(false);
                }
                if (this.f1615b.m1718m() == RequestType.POST) {
                    m1731b(this.f1615b.m1716k());
                }
                return m1732c();
            } catch (IOException e) {
                IOException iOException = e;
                networkResponse = new NetworkResponse(this.f1615b);
                networkResponse.m1734a(new NetworkError(ErrorCode.NETWORK_IO_ERROR, iOException.getLocalizedMessage()));
                iOException.printStackTrace();
                return networkResponse;
            } catch (IllegalArgumentException e2) {
                IllegalArgumentException illegalArgumentException = e2;
                networkResponse = new NetworkResponse(this.f1615b);
                networkResponse.m1734a(new NetworkError(ErrorCode.HTTP_BAD_REQUEST, "The URL is malformed:" + ErrorCode.HTTP_BAD_REQUEST.toString()));
                illegalArgumentException.printStackTrace();
                return networkResponse;
            }
        }
        networkResponse = new NetworkResponse(this.f1615b);
        networkResponse.m1734a(new NetworkError(ErrorCode.NETWORK_UNAVAILABLE_ERROR, "Network unavailable."));
        return networkResponse;
    }

    private String m1730b() {
        String h = this.f1615b.m1713h();
        if (!h.contains("?")) {
            h = h + "?";
        }
        return h + this.f1615b.m1715j();
    }

    private HttpURLConnection m1727a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m1729a(httpURLConnection);
        return httpURLConnection;
    }

    private void m1729a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(this.f1615b.m1719n());
        httpURLConnection.setReadTimeout(this.f1615b.m1720o());
        httpURLConnection.setUseCaches(false);
        if (this.f1615b.m1714i() != null) {
            for (String str : this.f1615b.m1714i().keySet()) {
                httpURLConnection.setRequestProperty(str, (String) this.f1615b.m1714i().get(str));
            }
        }
        RequestType m = this.f1615b.m1718m();
        httpURLConnection.setRequestMethod(m.toString());
        if (m != RequestType.GET) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
    }

    private void m1731b(String str) throws IOException {
        Closeable bufferedWriter;
        Throwable th;
        this.f1616c.setRequestProperty("Content-Length", Integer.toString(str.length()));
        this.f1616c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f1616c.getOutputStream()));
            try {
                bufferedWriter.write(str);
                m1728a(bufferedWriter);
            } catch (Throwable th2) {
                th = th2;
                m1728a(bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            m1728a(bufferedWriter);
            throw th;
        }
    }

    private NetworkResponse m1732c() {
        Throwable th;
        NetworkResponse networkResponse = new NetworkResponse(this.f1615b);
        Closeable closeable = null;
        try {
            int responseCode = this.f1616c.getResponseCode();
            Logger.m1744a(InternalLogLevel.INTERNAL, f1614a, this.f1615b.m1713h() + "Response code: " + responseCode);
            if (responseCode == 200) {
                try {
                    if (!this.f1615b.m1712g() || ((long) this.f1616c.getContentLength()) <= this.f1615b.m1711f()) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f1616c.getInputStream(), Defaults.Encoding));
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuilder.append(readLine).append(LineSeparator.Web);
                            }
                            networkResponse.m1735a(stringBuilder.toString());
                            networkResponse.m1736a(this.f1616c.getHeaderFields());
                            Object obj = bufferedReader;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = bufferedReader;
                            this.f1616c.disconnect();
                            m1728a(closeable);
                            throw th;
                        }
                    }
                    networkResponse.m1734a(new NetworkError(ErrorCode.RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT, "Response size greater than specified max response size"));
                } catch (Throwable th3) {
                    th = th3;
                    this.f1616c.disconnect();
                    m1728a(closeable);
                    throw th;
                }
            }
            ErrorCode fromValue = ErrorCode.fromValue(responseCode);
            if (fromValue == null) {
                fromValue = ErrorCode.UNKNOWN_ERROR;
            }
            networkResponse.m1734a(new NetworkError(fromValue, "HTTP:" + responseCode));
            networkResponse.m1736a(this.f1616c.getHeaderFields());
            this.f1616c.disconnect();
            m1728a(closeable);
        } catch (SocketTimeoutException e) {
            networkResponse.m1734a(new NetworkError(ErrorCode.HTTP_GATEWAY_TIMEOUT, ErrorCode.HTTP_GATEWAY_TIMEOUT.toString()));
            e.printStackTrace();
        } catch (IOException e2) {
            networkResponse.m1734a(new NetworkError(ErrorCode.NETWORK_IO_ERROR, ErrorCode.NETWORK_IO_ERROR.toString()));
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            networkResponse.m1734a(new NetworkError(ErrorCode.OUT_OF_MEMORY_ERROR, ErrorCode.OUT_OF_MEMORY_ERROR.toString()));
            e3.printStackTrace();
        }
        try {
            if (this.f1615b.m1721p()) {
                String e4 = this.f1615b.m1710e(networkResponse.m1738b());
                if (e4 == null) {
                    networkResponse.m1734a(new NetworkError(ErrorCode.INVALID_ENCRYPTED_RESPONSE_RECEIVED, "Unable to decrypt the server response."));
                } else {
                    networkResponse.m1735a(e4);
                }
            }
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            networkResponse.m1734a(new NetworkError(ErrorCode.INVALID_ENCRYPTED_RESPONSE_RECEIVED, "Unable to decrypt the server response."));
        }
        return networkResponse;
    }

    private void m1728a(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }
}
