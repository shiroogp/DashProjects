package com.google.mlkit.vision.face.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
public class FaceDetectorImpl extends MobileVisionBase<List<Face>> implements FaceDetector {
    static final FaceDetectorOptions zzb = new FaceDetectorOptions.Builder().build();

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ FaceDetectorImpl(com.google.mlkit.vision.face.internal.zzh r1, com.google.mlkit.common.sdkinternal.ExecutorSelector r2, com.google.mlkit.vision.face.FaceDetectorOptions r3, com.google.mlkit.vision.face.internal.zzc r4) {
        /*
            r0 = this;
            java.util.concurrent.Executor r4 = r3.zzf()
            java.util.concurrent.Executor r2 = r2.getExecutorToUse(r4)
            java.lang.String r4 = com.google.mlkit.vision.face.internal.zzj.zzb()
            com.google.android.gms.internal.mlkit_vision_face.zzla r4 = com.google.android.gms.internal.mlkit_vision_face.zzll.zzb(r4)
            r0.<init>(r1, r2)
            com.google.android.gms.internal.mlkit_vision_face.zziv r1 = new com.google.android.gms.internal.mlkit_vision_face.zziv
            r1.<init>()
            com.google.android.gms.internal.mlkit_vision_face.zzjh r2 = new com.google.android.gms.internal.mlkit_vision_face.zzjh
            r2.<init>()
            com.google.android.gms.internal.mlkit_vision_face.zzie r3 = com.google.mlkit.vision.face.internal.zzj.zza(r3)
            r2.zze(r3)
            com.google.android.gms.internal.mlkit_vision_face.zzji r2 = r2.zzi()
            r1.zzf(r2)
            r2 = 1
            com.google.android.gms.internal.mlkit_vision_face.zzld r1 = com.google.android.gms.internal.mlkit_vision_face.zzld.zze(r1, r2)
            com.google.android.gms.internal.mlkit_vision_face.zzit r2 = com.google.android.gms.internal.mlkit_vision_face.zzit.ON_DEVICE_FACE_CREATE
            r4.zzd(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.FaceDetectorImpl.<init>(com.google.mlkit.vision.face.internal.zzh, com.google.mlkit.common.sdkinternal.ExecutorSelector, com.google.mlkit.vision.face.FaceDetectorOptions, com.google.mlkit.vision.face.internal.zzc):void");
    }

    public final Task<List<Face>> process(MlImage mlImage) {
        return super.processBase(mlImage);
    }

    public final Task<List<Face>> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
