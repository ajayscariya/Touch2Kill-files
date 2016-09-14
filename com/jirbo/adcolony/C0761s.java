package com.jirbo.adcolony;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.jirbo.adcolony.s */
class C0761s {
    char[] f2946a;
    int f2947b;
    int f2948c;

    C0761s(String str) {
        this.f2948c = str.length();
        StringBuilder stringBuilder = new StringBuilder(this.f2948c);
        int i = 0;
        while (i < this.f2948c) {
            char charAt = str.charAt(i);
            if ((charAt >= ' ' && charAt <= '~') || charAt == '\n') {
                stringBuilder.append(charAt);
            } else if ((charAt & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
                stringBuilder.append(' ');
            } else if ((charAt & 224) == 192 && i + 1 < this.f2948c) {
                stringBuilder.append((char) (((charAt & 31) << 6) | (str.charAt(i + 1) & 63)));
                i++;
            } else if (i + 2 < this.f2948c) {
                stringBuilder.append((char) ((((charAt & 15) << 12) | ((str.charAt(i + 1) & 63) << 6)) | (str.charAt(i + 2) & 63)));
                i += 2;
            } else {
                stringBuilder.append('?');
            }
            i++;
        }
        this.f2948c = stringBuilder.length();
        this.f2946a = new char[this.f2948c];
        stringBuilder.getChars(0, this.f2948c, this.f2946a, 0);
    }

    C0761s(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(inputStream.available());
        int read = inputStream.read();
        while (read != -1) {
            if ((read >= 32 && read <= TransportMediator.KEYCODE_MEDIA_PLAY) || read == 10) {
                stringBuilder.append((char) read);
            } else if ((read & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
                stringBuilder.append(' ');
            } else if ((read & 224) == 192) {
                stringBuilder.append((char) (((read & 31) << 6) | (inputStream.read() & 63)));
            } else {
                stringBuilder.append((char) ((((read & 15) << 12) | ((inputStream.read() & 63) << 6)) | (inputStream.read() & 63)));
            }
            read = inputStream.read();
        }
        inputStream.close();
        this.f2948c = stringBuilder.length();
        this.f2946a = new char[this.f2948c];
        stringBuilder.getChars(0, this.f2948c, this.f2946a, 0);
    }

    boolean m2797a() {
        return this.f2947b < this.f2948c;
    }

    char m2800b() {
        if (this.f2947b == this.f2948c) {
            return '\u0000';
        }
        return this.f2946a[this.f2947b];
    }

    char m2803c() {
        char[] cArr = this.f2946a;
        int i = this.f2947b;
        this.f2947b = i + 1;
        return cArr[i];
    }

    boolean m2798a(char c) {
        if (this.f2947b == this.f2948c || this.f2946a[this.f2947b] != c) {
            return false;
        }
        this.f2947b++;
        return true;
    }

    void m2801b(char c) {
        if (!m2798a(c)) {
            throw new AdColonyException("'" + c + "' expected.");
        }
    }

    boolean m2799a(String str) {
        int length = str.length();
        if (this.f2947b + length > this.f2948c) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.f2946a[this.f2947b + i]) {
                return false;
            }
        }
        this.f2947b += length;
        return true;
    }

    void m2802b(String str) {
        if (!m2799a(str)) {
            throw new AdColonyException("\"" + str + "\" expected.");
        }
    }

    void m2804d() {
        while (this.f2947b != this.f2948c) {
            char c = this.f2946a[this.f2947b];
            if (c == ' ' || c == '\n') {
                this.f2947b++;
            } else {
                return;
            }
        }
    }

    public static void m2796a(String[] strArr) {
    }
}
