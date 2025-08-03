package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public abstract class zznb extends zzb implements zznc {
    public static zznc zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        if (queryLocalInterface instanceof zznc) {
            return (zznc) queryLocalInterface;
        }
        return new zzna(iBinder);
    }
}
