package com.google.mlkit.vision.face.internal;

import android.util.Pair;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.2.0 */
interface zzb {
    Pair<List<Face>, List<Face>> zza(InputImage inputImage) throws MlKitException;

    void zzb();

    boolean zzd() throws MlKitException;
}
