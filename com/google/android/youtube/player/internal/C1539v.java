package com.google.android.youtube.player.internal;

import android.os.IBinder;
import com.google.android.youtube.player.internal.C0623u.C1407a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.youtube.player.internal.v */
public final class C1539v<T> extends C1407a {
    private final T f4896a;

    private C1539v(T t) {
        this.f4896a = t;
    }

    public static <T> C0623u m5815a(T t) {
        return new C1539v(t);
    }

    public static <T> T m5816a(C0623u c0623u) {
        if (c0623u instanceof C1539v) {
            return ((C1539v) c0623u).f4896a;
        }
        IBinder asBinder = c0623u.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
