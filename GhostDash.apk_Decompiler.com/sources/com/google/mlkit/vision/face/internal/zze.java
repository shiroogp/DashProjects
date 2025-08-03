package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_face.zzla;
import com.google.android.gms.internal.mlkit_vision_face.zzll;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zze extends LazyInstanceMap<FaceDetectorOptions, zzh> {
    private final MlKitContext zza;

    public zze(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzb zzb;
        FaceDetectorOptions faceDetectorOptions = (FaceDetectorOptions) obj;
        Context applicationContext = this.zza.getApplicationContext();
        zzla zzb2 = zzll.zzb(zzj.zzb());
        if (zza.zzc(applicationContext) || GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204500000) {
            zzb = new zza(applicationContext, faceDetectorOptions, zzb2);
        } else {
            zzb = new zzm(applicationContext, faceDetectorOptions, zzb2);
        }
        return new zzh(zzll.zzb(zzj.zzb()), faceDetectorOptions, zzb);
    }
}
