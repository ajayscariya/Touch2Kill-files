package com.jirbo.adcolony;

import java.io.File;

/* renamed from: com.jirbo.adcolony.i */
class C0723i {
    C0723i() {
    }

    public static boolean m2627a(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    C0723i.m2627a(listFiles[i]);
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return file.delete();
    }
}
