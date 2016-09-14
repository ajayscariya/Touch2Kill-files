package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.youtube.player.internal.C0608j.C1398a.C1397a;
import com.google.android.youtube.player.internal.C0609k.C1400a;
import com.wTouch2KiLL.MainNavigationActivity;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;

/* renamed from: com.google.android.youtube.player.internal.l */
public interface C0610l extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.l.a */
    public static abstract class C1402a extends Binder implements C0610l {

        /* renamed from: com.google.android.youtube.player.internal.l.a.a */
        private static class C1401a implements C0610l {
            private IBinder f4281a;

            C1401a(IBinder iBinder) {
                this.f4281a = iBinder;
            }

            public final IBinder m4866a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.f4281a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final C0609k m4867a(C0608j c0608j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    obtain.writeStrongBinder(c0608j != null ? c0608j.asBinder() : null);
                    this.f4281a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0609k a = C1400a.m4865a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void m4868a(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f4281a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f4281a;
            }
        }

        public static C0610l m4869a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0610l)) ? new C1401a(iBinder) : (C0610l) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case MainNavigationActivity.REQUEST_CODE /*1*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder a = m1255a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                    C0608j c0608j;
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c0608j = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                        c0608j = (queryLocalInterface == null || !(queryLocalInterface instanceof C0608j)) ? new C1397a(readStrongBinder) : (C0608j) queryLocalInterface;
                    }
                    C0609k a2 = m1256a(c0608j);
                    parcel2.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    m1257a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m1255a() throws RemoteException;

    C0609k m1256a(C0608j c0608j) throws RemoteException;

    void m1257a(boolean z) throws RemoteException;
}
