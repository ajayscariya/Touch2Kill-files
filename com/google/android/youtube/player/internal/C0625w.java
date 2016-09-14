package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.youtube.player.internal.C0602d.C1386a;

/* renamed from: com.google.android.youtube.player.internal.w */
public final class C0625w {

    /* renamed from: com.google.android.youtube.player.internal.w.a */
    public static final class C0624a extends Exception {
        public C0624a(String str) {
            super(str);
        }

        public C0624a(String str, Throwable th) {
            super(str, th);
        }
    }

    private static IBinder m1269a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws C0624a {
        Throwable th;
        String str;
        String valueOf;
        try {
            return (IBinder) cls.getConstructor(new Class[]{IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE}).newInstance(new Object[]{iBinder, iBinder2, iBinder3, Boolean.valueOf(z)});
        } catch (Throwable e) {
            th = e;
            str = "Could not find the right constructor for ";
            valueOf = String.valueOf(cls.getName());
            throw new C0624a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        } catch (Throwable e2) {
            th = e2;
            str = "Exception thrown by invoked constructor in ";
            valueOf = String.valueOf(cls.getName());
            throw new C0624a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        } catch (Throwable e22) {
            th = e22;
            str = "Unable to instantiate the dynamic class ";
            valueOf = String.valueOf(cls.getName());
            throw new C0624a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        } catch (Throwable e222) {
            th = e222;
            str = "Unable to call the default constructor of ";
            valueOf = String.valueOf(cls.getName());
            throw new C0624a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
    }

    private static IBinder m1270a(ClassLoader classLoader, String str, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws C0624a {
        try {
            return C0625w.m1269a(classLoader.loadClass(str), iBinder, iBinder2, iBinder3, z);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Unable to find dynamic class ";
            String valueOf = String.valueOf(str);
            throw new C0624a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    public static C0602d m1271a(Activity activity, IBinder iBinder, boolean z) throws C0624a {
        ab.m1183a((Object) activity);
        ab.m1183a((Object) iBinder);
        Object b = C0628z.m1281b((Context) activity);
        if (b != null) {
            return C1386a.m4839a(C0625w.m1270a(b.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", C1539v.m5815a(b).asBinder(), C1539v.m5815a((Object) activity).asBinder(), iBinder, z));
        }
        throw new C0624a("Could not create remote context");
    }
}
