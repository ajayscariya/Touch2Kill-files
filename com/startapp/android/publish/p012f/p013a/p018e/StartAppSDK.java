package com.startapp.android.publish.p012f.p013a.p018e;

import java.io.DataInput;

/* renamed from: com.startapp.android.publish.f.a.e.e */
public class StartAppSDK extends StartAppSDK {
    protected DataInput m5463a(byte[] bArr) {
        DataInput a = super.m3093a(bArr);
        m5461b(a);
        return a;
    }

    protected com.startapp.android.publish.p012f.p013a.p014a.StartAppSDK m5462a(DataInput dataInput) {
        long readInt = (long) dataInput.readInt();
        com.startapp.android.publish.p012f.p013a.p014a.StartAppSDK startAppSDK = new com.startapp.android.publish.p012f.p013a.p014a.StartAppSDK(readInt << 6);
        m3094a(dataInput, startAppSDK, readInt);
        return startAppSDK;
    }

    private void m5461b(DataInput dataInput) {
        try {
            dataInput.readInt();
        } catch (Throwable e) {
            throw new RuntimeException("problem incrementInputStreamForBackwordCompatability", e);
        }
    }
}
