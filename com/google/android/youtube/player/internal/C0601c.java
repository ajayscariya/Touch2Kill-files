package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.wTouch2KiLL.MainNavigationActivity;

/* renamed from: com.google.android.youtube.player.internal.c */
public interface C0601c extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.c.a */
    public static abstract class C1384a extends Binder implements C0601c {

        /* renamed from: com.google.android.youtube.player.internal.c.a.a */
        private static class C1383a implements C0601c {
            private IBinder f4272a;

            C1383a(IBinder iBinder) {
                this.f4272a = iBinder;
            }

            public final void m4795a(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    this.f4272a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4272a;
            }
        }

        public C1384a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    m1187a(parcel.readString(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m1187a(String str, IBinder iBinder) throws RemoteException;
}
