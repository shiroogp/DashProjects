package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzaf extends zza implements IInterface {
    zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(3, zza());
    }

    public final zzq[] zze(IObjectWrapper iObjectWrapper, zzaj zzaj) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzaj);
        Parcel zzb = zzb(1, zza);
        zzq[] zzqArr = (zzq[]) zzb.createTypedArray(zzq.CREATOR);
        zzb.recycle();
        return zzqArr;
    }

    public final zzq[] zzf(IObjectWrapper iObjectWrapper, zzaj zzaj) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, iObjectWrapper);
        zzc.zza(zza, zzaj);
        Parcel zzb = zzb(2, zza);
        zzq[] zzqArr = (zzq[]) zzb.createTypedArray(zzq.CREATOR);
        zzb.recycle();
        return zzqArr;
    }
}
