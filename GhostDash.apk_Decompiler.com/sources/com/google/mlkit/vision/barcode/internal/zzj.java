package com.google.mlkit.vision.barcode.internal;

import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.2.0 */
interface zzj {
    List<Barcode> zza(InputImage inputImage) throws MlKitException;

    void zzb();

    boolean zzc() throws MlKitException;
}
