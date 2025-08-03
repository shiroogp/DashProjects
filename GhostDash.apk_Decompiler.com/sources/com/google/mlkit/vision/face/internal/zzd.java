package com.google.mlkit.vision.face.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public final class zzd {
    private final zze zza;
    private final ExecutorSelector zzb;

    zzd(zze zze, ExecutorSelector executorSelector) {
        this.zza = zze;
        this.zzb = executorSelector;
    }

    public final FaceDetectorImpl zza() {
        return zzb(FaceDetectorImpl.zzb);
    }

    public final FaceDetectorImpl zzb(FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        return new FaceDetectorImpl((zzh) this.zza.get(faceDetectorOptions), this.zzb, faceDetectorOptions, (zzc) null);
    }
}
