package com.immersion.content;

import java.nio.ByteBuffer;

public abstract class HeaderUtils {
    public static int f1214b044A044A044A = 1;
    public static int f1215b044A044A044A = 2;
    public static int f1216b044A044A = 86;

    public static int m1289b044A044A044A044A() {
        return 34;
    }

    public abstract int calculateBlockRate();

    public abstract int calculateBlockSize();

    public abstract int calculateByteOffsetIntoHapticData(int i);

    public abstract void dispose();

    public abstract String getContentUUID();

    public abstract int getEncryption();

    public abstract int getMajorVersionNumber();

    public abstract int getMinorVersionNumber();

    public abstract int getNumChannels();

    public abstract void setEncryptedHSI(ByteBuffer byteBuffer, int i);
}
