package com.jirbo.adcolony;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mf.org.w3c.dom.traversal.NodeFilter;

/* renamed from: com.jirbo.adcolony.w */
class C0764w extends InputStream {
    InputStream f2972a;
    byte[] f2973b;
    int f2974c;
    int f2975d;
    int f2976e;
    int f2977f;
    int f2978g;
    int f2979h;

    C0764w(String str) throws IOException {
        this.f2973b = new byte[NodeFilter.SHOW_DOCUMENT_FRAGMENT];
        if (C0694a.f2374n != 0) {
            this.f2979h = 23;
            this.f2978g = 23;
        }
        this.f2974c = (int) new File(str).length();
        this.f2972a = new FileInputStream(str);
    }

    public int available() throws IOException {
        return (this.f2976e - this.f2977f) + this.f2972a.available();
    }

    public void close() throws IOException {
        this.f2972a.close();
    }

    public void mark(int read_limit) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.f2975d == this.f2974c) {
            return -1;
        }
        if (this.f2977f >= this.f2976e) {
            m2814a();
        }
        this.f2975d++;
        byte[] bArr = this.f2973b;
        int i = this.f2977f;
        this.f2977f = i + 1;
        return bArr[i];
    }

    public int read(byte[] array) throws IOException {
        return read(array, 0, array.length);
    }

    public int read(byte[] array, int offset, int count) throws IOException {
        if (this.f2975d == this.f2974c) {
            return -1;
        }
        int count2 = this.f2974c - this.f2975d;
        if (count > count2) {
            count = count2;
        }
        int i = 0;
        while (count > 0) {
            if (this.f2977f == this.f2976e) {
                m2814a();
            }
            int i2 = count < this.f2976e ? count : this.f2976e;
            int i3 = 0;
            int offset2 = offset;
            while (i3 < i2) {
                offset = offset2 + 1;
                byte[] bArr = this.f2973b;
                int i4 = this.f2977f;
                this.f2977f = i4 + 1;
                array[offset2] = bArr[i4];
                i3++;
                offset2 = offset;
            }
            count -= i2;
            i += i2;
            this.f2975d = i2 + this.f2975d;
            offset = offset2;
        }
        return i;
    }

    public void reset() throws IOException {
        throw new IOException("ADCStreamReader does not support reset().");
    }

    public long skip(long n) throws IOException {
        throw new IOException("ADCStreamReader does not support skip().");
    }

    void m2814a() throws IOException {
        this.f2976e = 0;
        while (this.f2976e == 0) {
            this.f2976e = this.f2972a.read(this.f2973b, 0, NodeFilter.SHOW_DOCUMENT_FRAGMENT);
        }
        for (int i = 0; i < this.f2976e; i++) {
            this.f2973b[i] = (byte) (this.f2973b[i] ^ this.f2978g);
            this.f2978g += this.f2979h;
        }
        this.f2977f = 0;
    }
}
