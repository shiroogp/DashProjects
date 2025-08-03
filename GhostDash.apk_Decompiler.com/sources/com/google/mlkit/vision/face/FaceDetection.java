package com.google.mlkit.vision.face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.internal.zzd;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public class FaceDetection {
    private FaceDetection() {
    }

    public static FaceDetector getClient() {
        return ((zzd) MlKitContext.getInstance().get(zzd.class)).zza();
    }

    public static FaceDetector getClient(FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        return ((zzd) MlKitContext.getInstance().get(zzd.class)).zzb(faceDetectorOptions);
    }
}
