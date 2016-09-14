package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.youtube.player.internal.u */
public interface C0623u extends IInterface {

    /* renamed from: com.google.android.youtube.player.internal.u.a */
    public static abstract class C1407a extends Binder implements C0623u {

        /* renamed from: com.google.android.youtube.player.internal.u.a.a */
        private static class C1406a implements C0623u {
            private IBinder f4298a;

            C1406a(IBinder iBinder) {
                this.f4298a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f4298a;
            }
        }

        public C1407a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static C0623u m4907a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0623u)) ? new C1406a(iBinder) : (C0623u) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
