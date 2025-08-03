package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzlz;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
public final class zzf extends LazyInstanceMap<BarcodeScannerOptions, zzi> {
    private final MlKitContext zza;

    public zzf(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzj zzj;
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        Context applicationContext = this.zza.getApplicationContext();
        zzlo zzb = zzlz.zzb(zzb.zzd());
        if (zzm.zzd(applicationContext) || GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204500000) {
            zzj = new zzm(applicationContext, barcodeScannerOptions, zzb);
        } else {
            zzj = new zzo(applicationContext, barcodeScannerOptions, zzb);
        }
        return new zzi(this.zza, barcodeScannerOptions, zzj, zzb);
    }
}
