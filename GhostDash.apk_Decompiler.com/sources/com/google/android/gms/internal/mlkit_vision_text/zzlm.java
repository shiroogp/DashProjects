package com.google.android.gms.internal.mlkit_vision_text;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.3.0 */
public final class zzlm extends zza implements IInterface {
    zzlm(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    public final zzlw zzd(IObjectWrapper iObjectWrapper, zzlk zzlk) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, iObjectWrapper);
        zzc.zzb(zza, zzlk);
        Parcel zzb = zzb(3, zza);
        zzlw zzlw = (zzlw) zzc.zza(zzb, zzlw.CREATOR);
        zzb.recycle();
        return zzlw;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
