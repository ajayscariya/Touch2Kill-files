package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.google.android.youtube.player.internal.h */
public interface C0606h extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.h.a */
    public static abstract class C1394a extends Binder implements C0606h {

        /* renamed from: com.google.android.youtube.player.internal.h.a.a */
        private static class C1393a implements C0606h {
            private IBinder f4277a;

            C1393a(IBinder iBinder) {
                this.f4277a = iBinder;
            }

            public final void m4852a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f4277a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4277a;
            }

            public final void m4853b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f4277a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m4854c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f4277a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1394a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IPlaylistEventListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m1243a();
                    parcel2.writeNoException();
                    return true;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m1244b();
                    parcel2.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    m1245c();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m1243a() throws RemoteException;

    void m1244b() throws RemoteException;

    void m1245c() throws RemoteException;
}
