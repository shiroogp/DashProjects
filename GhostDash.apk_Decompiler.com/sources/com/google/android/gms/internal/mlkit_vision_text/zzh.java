package com.google.android.gms.internal.mlkit_vision_text;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzh extends zza implements IInterface {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final void zzd() throws RemoteException {
        zzc(2, zza());
    }

    public final zzl[] zze(IObjectWrapper iObjectWrapper, zzd zzd) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, iObjectWrapper);
        zzc.zzb(zza, zzd);
        Parcel zzb = zzb(1, zza);
        zzl[] zzlArr = (zzl[]) zzb.createTypedArray(zzl.CREATOR);
        zzb.recycle();
        return zzlArr;
    }
}
