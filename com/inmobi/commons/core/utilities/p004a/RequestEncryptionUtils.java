package com.inmobi.commons.core.utilities.p004a;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mf.org.apache.xml.serialize.OutputFormat.Defaults;

/* renamed from: com.inmobi.commons.core.utilities.a.b */
public class RequestEncryptionUtils {
    private static final String f1631a;
    private static String f1632b;
    private static String f1633c;
    private static byte[] f1634d;

    static {
        f1631a = RequestEncryptionUtils.class.getSimpleName();
        f1632b = "AES";
        f1633c = "AES/CBC/PKCS7Padding";
    }

    public static String m1753a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, String str2, String str3) {
        try {
            byte[] b = RequestEncryptionUtils.m1762b(str.getBytes(Defaults.Encoding), bArr, bArr2);
            byte[] a = RequestEncryptionUtils.m1758a(b, bArr3);
            b = RequestEncryptionUtils.m1756a(b);
            a = RequestEncryptionUtils.m1756a(a);
            return new String(Base64.encode(RequestEncryptionUtils.m1761b(RequestEncryptionUtils.m1756a(RequestEncryptionUtils.m1757a(RequestEncryptionUtils.m1761b(RequestEncryptionUtils.m1761b(RequestEncryptionUtils.m1756a(bArr), RequestEncryptionUtils.m1756a(bArr3)), RequestEncryptionUtils.m1756a(bArr2)), str3, str2)), RequestEncryptionUtils.m1761b(b, a)), 8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static byte[] m1762b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = null;
        Key secretKeySpec = new SecretKeySpec(bArr2, f1632b);
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher instance = Cipher.getInstance(f1633c);
            instance.init(1, secretKeySpec, ivParameterSpec);
            instance.init(1, secretKeySpec, ivParameterSpec);
            instance.init(1, secretKeySpec, ivParameterSpec);
            bArr4 = instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
        }
        return bArr4;
    }

    private static byte[] m1760b() {
        String str = "SHA1PRNG";
        str = "Crypto";
        byte[] bArr = new byte[16];
        try {
            SecureRandom.getInstance("SHA1PRNG", "Crypto").nextBytes(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e2) {
            e2.printStackTrace();
        }
        return bArr;
    }

    private static byte[] m1758a(byte[] bArr, byte[] bArr2) {
        String str = "HmacSHA1";
        byte[] bArr3 = null;
        Key secretKeySpec = new SecretKeySpec(bArr2, 0, bArr2.length, "HmacSHA1");
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            bArr3 = instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
        }
        return bArr3;
    }

    private static byte[] m1756a(byte[] bArr) {
        long length = (long) bArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(length);
        Object array = allocate.array();
        Object obj = new byte[(array.length + bArr.length)];
        System.arraycopy(array, 0, obj, 0, array.length);
        System.arraycopy(bArr, 0, obj, array.length, bArr.length);
        return obj;
    }

    public static byte[] m1757a(byte[] bArr, String str, String str2) {
        String str3 = "RSA";
        str3 = "RSA/ECB/nopadding";
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(str2, 16), new BigInteger(str, 16)));
            Cipher instance = Cipher.getInstance("RSA/ECB/nopadding");
            instance.init(1, rSAPublicKey);
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static byte[] m1761b(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }

    public static synchronized byte[] m1754a() {
        byte[] bArr;
        synchronized (RequestEncryptionUtils.class) {
            EncryptionDao encryptionDao = new EncryptionDao();
            if ((System.currentTimeMillis() / 1000) - encryptionDao.m1752c() > 86400) {
                f1634d = RequestEncryptionUtils.m1760b();
                encryptionDao.m1750a(Base64.encodeToString(f1634d, 0));
            } else if (f1634d == null) {
                try {
                    f1634d = Base64.decode(encryptionDao.m1751b(), 0);
                } catch (Throwable e) {
                    Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "getAesPublicKey failed to decode the cached key.", e);
                    f1634d = RequestEncryptionUtils.m1760b();
                    encryptionDao.m1750a(Base64.encodeToString(f1634d, 0));
                }
            }
            bArr = f1634d;
        }
        return bArr;
    }

    public static byte[] m1759a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = null;
        Key secretKeySpec = new SecretKeySpec(bArr2, f1632b);
        try {
            Cipher instance = Cipher.getInstance(f1633c);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            bArr4 = instance.doFinal(bArr);
        } catch (Throwable e) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e);
        } catch (Throwable e2) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e2);
        } catch (Throwable e22) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e22);
        } catch (Throwable e222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e222);
        } catch (Throwable e2222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e2222);
        } catch (Throwable e22222) {
            Logger.m1745a(InternalLogLevel.INTERNAL, f1631a, "Error while decrypting response.", e22222);
        }
        return bArr4;
    }

    public static byte[] m1755a(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
