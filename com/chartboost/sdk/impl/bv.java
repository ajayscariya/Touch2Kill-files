package com.chartboost.sdk.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

public class bv {
    public static final BigInteger f1068a;
    public static final BigInteger f1069b;
    public static final BigInteger f1070c;
    public static final BigInteger f1071d;
    public static final BigInteger f1072e;
    public static final BigInteger f1073f;
    public static final BigInteger f1074g;
    public static final BigInteger f1075h;
    public static final File[] f1076i;
    private static final Charset f1077j;

    static {
        f1068a = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
        f1069b = f1068a.multiply(f1068a);
        f1070c = f1068a.multiply(f1069b);
        f1071d = f1068a.multiply(f1070c);
        f1072e = f1068a.multiply(f1071d);
        f1073f = f1068a.multiply(f1072e);
        f1074g = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));
        f1075h = f1068a.multiply(f1074g);
        f1076i = new File[0];
        f1077j = Charset.forName(Defaults.Encoding);
    }

    public static FileInputStream m1064a(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream m1065a(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static byte[] m1068b(File file) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = m1064a(file);
            byte[] a = bw.m1073a(inputStream, file.length());
            return a;
        } finally {
            bw.m1070a(inputStream);
        }
    }

    public static void m1066a(File file, byte[] bArr) throws IOException {
        m1067a(file, bArr, false);
    }

    public static void m1067a(File file, byte[] bArr, boolean z) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = m1065a(file, z);
            outputStream.write(bArr);
            outputStream.close();
        } finally {
            bw.m1071a(outputStream);
        }
    }
}
