package com.chartboost.sdk.impl;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class bw {
    public static final char f1078a;
    public static final String f1079b;

    static {
        f1078a = File.separatorChar;
        Writer bxVar = new bx(4);
        PrintWriter printWriter = new PrintWriter(bxVar);
        printWriter.println();
        f1079b = bxVar.toString();
        printWriter.close();
    }

    public static void m1070a(InputStream inputStream) {
        m1069a((Closeable) inputStream);
    }

    public static void m1071a(OutputStream outputStream) {
        m1069a((Closeable) outputStream);
    }

    public static void m1069a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m1073a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return m1072a(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    public static byte[] m1072a(InputStream inputStream, int i) throws IOException {
        int i2 = 0;
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        } else if (i == 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
        }
    }
}
