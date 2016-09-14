package com.jirbo.adcolony;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

class ai {
    private static String f2465a = null;
    private static final String f2466b = "INSTALLATION";

    ai() {
    }

    static {
        f2465a = null;
    }

    public static synchronized String m2536a(Context context) {
        String str;
        synchronized (ai.class) {
            if (f2465a == null) {
                File file = new File(context.getFilesDir(), f2466b);
                try {
                    if (!file.exists()) {
                        m2538b(file);
                    }
                    f2465a = m2537a(file);
                } catch (Exception e) {
                    throw new AdColonyException(e.toString());
                }
            }
            str = f2465a;
        }
        return str;
    }

    private static String m2537a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[((int) randomAccessFile.length())];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void m2538b(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}
