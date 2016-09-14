package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.wTouch2KiLL.MainNavigationActivity;

/* renamed from: com.google.android.youtube.player.internal.e */
public interface C0603e extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.e.a */
    public static abstract class C1388a extends Binder implements C0603e {

        /* renamed from: com.google.android.youtube.player.internal.e.a.a */
        private static class C1387a implements C0603e {
            private IBinder f4274a;

            C1387a(IBinder iBinder) {
                this.f4274a = iBinder;
            }

            public final void m4840a(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f4274a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4274a;
            }
        }

        public C1388a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    m1231a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m1231a(boolean z) throws RemoteException;
}
